class DataPacket {
    private String message;

    private boolean isMessageReady = false;

    public synchronized void send(String packet) {

        while(isMessageReady) {
            try {
                wait();
            } catch( InterruptedException i) {
                System.out.println(i);
            }
        }

        this.message = packet;
        this.isMessageReady = true;
        System.out.println("Sender Produced: "+packet);
        notify();
    }

    public synchronized String receive() {

        while(!isMessageReady) {
            try {
                wait();
            } catch (InterruptedException i) {
                System.out.println(i);
            }
        }

        this.isMessageReady = false;
        System.out.println("Receiver received: "+message);
        notify();

        return message;
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        
        DataPacket system = new DataPacket();

        new Thread( () -> {
            String[] message = {"Hello", "i", "am", "a", "Programmer"};
            for(String s: message) {
                system.send(s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException i) {
                    System.out.println(i);
                }
            }
            
            system.send("Over");
        }).start();

        new Thread( () -> {
            String data = "";
            while(!data.equals("Over")) {
                data = system.receive();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException i) {
                    System.out.println(i);
                }
            }
        }).start();
    }
}
