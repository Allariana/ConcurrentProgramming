import java.text.DecimalFormat;

public class Main {

    static int NUMBER_OF_CLIENTS = 5;
    public static DecimalFormat df5 = new DecimalFormat("#.#####");

    public static void main(String[] args) throws InterruptedException {

        int i, j;

        Client[] clients = new Client[NUMBER_OF_CLIENTS];
        Priority priority = new Priority();
        LoadBalancer loadBalancer = new LoadBalancer();
        Server server = new Server();

        for (i = 0; i < NUMBER_OF_CLIENTS; i++) {

            clients[i] = new Client();
            clients[i].randFunc(clients[i].numberOfFiles);
            System.out.print("Client " + i + ": " + clients[i].filesList.size() + " files (");

            for (j = 0; j < clients[i].filesList.size(); j++) {

                System.out.printf(clients[i].filesList.get(j) + " MB - p " + df5.format(priority.countPriority(i+1,clients[i].filesList.get(j),clients[i].numberOfFiles)));
                if (j != clients[i].numberOfFiles - 1) System.out.print(", ");
                else System.out.println(")\n");

            }
        }

        loadBalancer.getMaxMinPriority(NUMBER_OF_CLIENTS, clients);
        server.startThreads(NUMBER_OF_CLIENTS,clients);

    }
}
