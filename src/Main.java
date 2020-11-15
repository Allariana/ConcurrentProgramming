public class Main {

    static int NUMBER_OF_CLIENTS = 5;

    public static void main(String[] args) {

        int i, j;
        Client[] clients = new Client[NUMBER_OF_CLIENTS];

        for (i = 0; i < NUMBER_OF_CLIENTS; i++) {

            clients[i] = new Client();
            clients[i].randFunc(clients[i].numberOfFiles);
            System.out.print("Client " + i + ": " + clients[i].numberOfFiles + " files (");

            for (j = 0; j < clients[i].numberOfFiles; j++) {

                System.out.print(clients[i].tab[j]);
                if (j != clients[i].numberOfFiles - 1) System.out.print(", ");
                else System.out.println(")");

            }
        }
    }
}
