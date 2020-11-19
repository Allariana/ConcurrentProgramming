public class Server {
    ServerMainThread[] serverMainThreads = new ServerMainThread[5];
    Thread[] threads = new Thread[5];

    public void startThreads() {
        for(int i=0; i<5; i++) {
            serverMainThreads[i] = new ServerMainThread(i);
        }
        for(int i=0; i<5; i++) {
            threads[i] = new Thread(serverMainThreads[i]);
        }
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }
    }
}

