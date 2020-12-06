import java.text.DecimalFormat;

public class LoadBalancer {
    public static DecimalFormat df5 = new DecimalFormat("#.#####");
    Priority priority = new Priority();
    double max_priority = 0, min_priority = 1000, p;
    int client_number_max, file_index_max, client_number_min, file_index_min;
    int i, j;

    public void getMaxMinPriority(int number_of_client, Client[] clients) {

        for (i = 0; i < number_of_client; i++) {

            for (j = 0; j < clients[i].filesList.size(); j++) {

                p = priority.countPriority(i + 1, clients[i].filesList.get(j), clients[i].filesList.size());

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
    public int removeFileMin(int NUMBER_OF_CLIENTS,Client[] clients) {
        int client_number_min = -1, file_index_min = -1;
        min_priority = 1000;
        int time=0;

        for (i = 0; i < NUMBER_OF_CLIENTS; i++) {

            for (j = 0; j < clients[i].filesList.size(); j++) {

                p = priority.countPriority(i + 1, clients[i].filesList.get(j), clients[i].numberOfFiles);

                if (p < min_priority) {
                    time = clients[i].filesList.get(j) * 90;
                    min_priority = p;
                    client_number_min = i;
                    file_index_min = j;
                }
            }
        }

        if(client_number_min!=-1)clients[client_number_min].filesList.remove(file_index_min);

    return time;
    }
    public int removeFileMax(int NUMBER_OF_CLIENTS,Client[] clients) {
        int client_number_max = -1, file_index_max = -1, client_number_min = -1, file_index_min = -1;
        max_priority=0;
        int time=0;

            for (i = 0; i < NUMBER_OF_CLIENTS; i++) {

                for (j = 0; j < clients[i].filesList.size(); j++) {

                    p = priority.countPriority(i + 1, clients[i].filesList.get(j), clients[i].filesList.size());

                    if (p > max_priority) {
                        time = clients[i].filesList.get(j) * 90;
                        max_priority = p;
                        client_number_max = i;
                        file_index_max = j;
                    }
                }
            }
            if(client_number_max!=-1)clients[client_number_max].filesList.remove(file_index_max);

        return time;
    }
    public void printClients(int NUMBER_OF_CLIENTS,Client[] clients){
        System.out.println();
        for (i = 0; i < NUMBER_OF_CLIENTS; i++) {

            if(clients[i].filesList.size()!=0)System.out.print("Client " + i + ": " + clients[i].filesList.size() + " files (");
            else System.out.print("Client " + i + ": " + clients[i].filesList.size() + " files \n");

            for (j = 0; j < clients[i].filesList.size(); j++) {

                System.out.printf(clients[i].filesList.get(j) + " MB - p " + df5.format(priority.countPriority(i+1,clients[i].filesList.get(j),clients[i].filesList.size())));
                if (j != clients[i].filesList.size() - 1) System.out.print(", ");
                else System.out.println(")");

            }
        }
    }

}
