public class LoadBalancer {
    Priority priority = new Priority();
    double max_priority = 0, min_priority = 1000, p;
    int client_number_max, file_index_max, client_number_min, file_index_min;
    int i, j;

    public void getMaxMinPriority(int number_of_client, Client[] clients) {

        for (i = 0; i < number_of_client; i++) {

            for (j = 0; j < clients[i].numberOfFiles; j++) {

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

}
