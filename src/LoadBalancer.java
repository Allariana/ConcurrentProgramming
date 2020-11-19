public class LoadBalancer {
    Priority priority = new Priority();
    double max_priority = 0, min_priority = 1000, p;
    int client_number_max, file_index_max, client_number_min, file_index_min;
    int i, j;

    public void getMaxMinPriority(int number_of_client, Client[] clients) {

        for (i = 0; i < number_of_client; i++) {

            for (j = 0; j < clients[i].filesList.size(); j++) {

                p = priority.countPriority(i + 1, clients[i].filesList.get(j), clients[i].numberOfFiles);

                if (p > max_priority) {
                    max_priority = p;
                    client_number_max = i;
                    file_index_max = j;
                }
                if (p < min_priority) {
                    min_priority = p;
                    client_number_min = i;
                    file_index_min = j;
                }
            }
        }
        System.out.println("Max priority: client - " + client_number_max + " file - " + file_index_max);
        System.out.println("Min priority: client - " + client_number_min + " file - " + file_index_min);
    }
    public void removeFile(int NUMBER_OF_CLIENTS,Client[] clients) {

        for (i = 0; i < NUMBER_OF_CLIENTS; i++) {

            for (j = 0; j < clients[i].filesList.size(); j++) {

                p = priority.countPriority(i + 1, clients[i].filesList.get(j), clients[i].numberOfFiles);

                if (p > max_priority) {
                    max_priority = p;
                    client_number_max = i;
                    file_index_max = j;
                }
            }
        }

        clients[client_number_max].filesList.remove(file_index_max);
        for (i = 0; i < NUMBER_OF_CLIENTS; i++) {

            System.out.print("Client " + i + ": " + clients[i].filesList.size() + " files (");

            for (j = 0; j < clients[i].filesList.size(); j++) {

                System.out.printf(clients[i].filesList.get(j) + " MB" );
                if (j != clients[i].filesList.size() - 1) System.out.print(", ");
                else System.out.println(")\n");

            }
        }
    }

}
