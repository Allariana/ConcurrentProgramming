public class Server {
    private int number_of_threads=1;
    ServerMainThread[] serverMainThreads = new ServerMainThread[number_of_threads];
    Thread[] threads = new Thread[number_of_threads];

    public void startThreads(int NUMBER_OF_CLIENTS,Client[] clients) {
        for(int i=0; i<number_of_threads; i++) {
            serverMainThreads[i] = new ServerMainThread(i, NUMBER_OF_CLIENTS,clients);
        }
        for(int i=0; i<number_of_threads; i++) {
            threads[i] = new Thread(serverMainThreads[i]);
        }
        for (int i = 0; i < number_of_threads; i++) {
            threads[i].start();
        }
    }
}

