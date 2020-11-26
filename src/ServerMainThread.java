public class ServerMainThread implements Runnable {
    private int id, time;
    private static int NUMBER_OF_CLIENTS;
    Client[] clients;
    LoadBalancer loadBalancer = new LoadBalancer();

    public ServerMainThread(int id, int NUMBER_OF_CLIENTS, Client[] clients) {
        this.id = id;
        this.clients = clients;
        this.NUMBER_OF_CLIENTS = NUMBER_OF_CLIENTS;
    }

    @Override
    public void run() {
        while(true) {
//            if (id != 2) {
//                time = loadBalancer.removeFileMax(NUMBER_OF_CLIENTS, clients);
//            } else {
//                time=18000;
//                //time = loadBalancer.removeFileMin(NUMBER_OF_CLIENTS, clients);
//                loadBalancer.printClients(NUMBER_OF_CLIENTS, clients);
//                loadBalancer.getMaxMinPriority(NUMBER_OF_CLIENTS, clients);
//            }
            time = loadBalancer.removeFileMax(NUMBER_OF_CLIENTS, clients);
            loadBalancer.printClients(NUMBER_OF_CLIENTS, clients);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


