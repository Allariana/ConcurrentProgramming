import java.util.ArrayList;

public class ServerMainThread implements Runnable {
    private int id, time;

    ArrayList<Client> clients = new ArrayList<>();
    LoadBalancer loadBalancer = new LoadBalancer();

    public ServerMainThread(int id,ArrayList<Client> clients) {
        this.id = id;
        this.clients = clients;
    }

    @Override
    public void run() {
        while(true) {
            if (id != 4 && id !=3) { //2 watki odwrotnie zamiast 1
                time = loadBalancer.removeFileMax(clients);
            } else {
                time = loadBalancer.removeFileMin(clients);
            }

            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


