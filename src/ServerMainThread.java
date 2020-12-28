import java.util.ArrayList;

public class ServerMainThread implements Runnable {
    private int id, time;
    int tab[][] = new int[5][3];

    ArrayList<Client> clients = new ArrayList<>();
    LoadBalancer loadBalancer = new LoadBalancer();

    public ServerMainThread(int id,ArrayList<Client> clients, int tab[][]) {
        this.id = id;
        this.clients = clients;
        this.tab = tab;
    }

    @Override
    public void run() {
        while(true) {
            if (id != 4 && id !=3 && clients.size()>0) { //2 watki odwrotnie zamiast 1
                time = loadBalancer.removeFileMax(clients, tab, id);
            } else if (clients.size()>0) { //id == 4 &&
                time = loadBalancer.removeFileMin(clients, tab, id);
                //loadBalancer.printClients(clients);
            }
            //}else if (clients.size()>0)time = loadBalancer.removeFileMin(clients, tab, id);

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


