public class ServerMainThread extends Server implements Runnable {
    private int id;
    private static int NUMBER_OF_CLIENTS;
    Client[] clients;
    LoadBalancer loadBalancer = new LoadBalancer();

    public ServerMainThread(int id, int NUMBER_OF_CLIENTS,Client[] clients) {
        this.id = id;
        this.clients = clients;
        this.NUMBER_OF_CLIENTS = NUMBER_OF_CLIENTS;
    }
    @Override
    public void run() {
//        if(id!=4){
            System.out.println("Watek "+id);
            loadBalancer.removeFile(NUMBER_OF_CLIENTS,clients);
            //todo remove file, sleep
//        }
//        else {
//            System.out.println("Watek "+id);
//            //todo remove file, sleep
//        }
    }
    public void f(Client[] clients){

    }
}
