import java.util.ArrayList;

public class ServerMainThread implements Runnable {
    private int id, time;
    int tab[][];

    ArrayList<Client> clients;
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
            } else if (clients.size()>0 ) { //id == 4 &&
                time = loadBalancer.removeFileMin(clients, tab, id);
                //loadBalancer.printClients(clients);
            }
//            else if (clients.size()>0)time = loadBalancer.removeFileMin(clients, tab, id);

            try {
//                if(tab[id][2]==-1)tab[id][2]=0;
//                Thread.sleep(tab[id][2]);
                Thread.sleep(time);
                if(tab[id][0]!=-1) {
                    clients.get(tab[id][0]).filesList.set(tab[id][1],0);
//                    clients.get(tab[id][0]).filesList.remove(tab[id][1]);
//                    clients.get(tab[id][0]).filesBusy.remove(tab[id][1]);
                }
//                if(tab[id][0]!=-1)clients.get(tab[id][0]).filesList.remove(tab[id][1]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


