import java.util.ArrayList;

public class ServerMainThread implements Runnable {
    private int id, time;
    int tab[][];

    ArrayList<Client> clients;
    LoadBalancer loadBalancer = new LoadBalancer();

    public ServerMainThread(int id, ArrayList<Client> clients, int tab[][]) {
        this.id = id;
        this.clients = clients;
        this.tab = tab;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(id * 80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            time = loadBalancer.choseFileToLoad(clients, tab, id);
            try {
                Thread.sleep(time);
                if (tab[id][0] != -1) {
                    clients.get(tab[id][0]).filesList.set(tab[id][1], 0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


