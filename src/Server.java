import java.util.ArrayList;

public class Server {
    private int NUMBER_OF_THREADS = 5;
    ServerMainThread[] serverMainThreads = new ServerMainThread[NUMBER_OF_THREADS];
    Thread[] threads = new Thread[NUMBER_OF_THREADS];

    public void startThreads(ArrayList<Client> clients) {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            serverMainThreads[i] = new ServerMainThread(i, clients);
        }
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i] = new Thread(serverMainThreads[i]);
        }
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads[i].start();
        }
    }
}

