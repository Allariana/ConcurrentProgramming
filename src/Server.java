public class Server {
    private int NUMBER_OF_THREADS = 6;
    ServerMainThread[] serverMainThreads = new ServerMainThread[NUMBER_OF_THREADS];
    Thread[] threads = new Thread[NUMBER_OF_THREADS];

    public void startThreads(int NUMBER_OF_CLIENTS, Client[] clients) {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            serverMainThreads[i] = new ServerMainThread(i, NUMBER_OF_CLIENTS, clients);
        }
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new Thread(serverMainThreads[i]);
        }
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i].start();
        }
    }
}

