import java.text.DecimalFormat;

public class Main {

    static int NUMBER_OF_CLIENTS = 5;
    public static DecimalFormat df5 = new DecimalFormat("#.#####");

    public static void main(String[] args) {

        int i, j;

        Client[] clients = new Client[NUMBER_OF_CLIENTS];
        LoadBalancer loadBalancer = new LoadBalancer();

        for (i = 0; i < NUMBER_OF_CLIENTS; i++) {

            clients[i] = new Client();
            clients[i].randFunc(clients[i].numberOfFiles);
            System.out.print("Client " + i + ": " + clients[i].numberOfFiles + " files (");

            for (j = 0; j < clients[i].numberOfFiles; j++) {

                System.out.printf(clients[i].filesList.get(j) + " MB - p " + df5.format(loadBalancer.countPriority(i+1,clients[i].filesList.get(j),clients[i].numberOfFiles)));
                if (j != clients[i].numberOfFiles - 1) System.out.print(", ");
                else System.out.println(")\n");

            }
        }
    }
}
