import java.text.DecimalFormat;
import java.util.ArrayList;

public class LoadBalancer {

    public static DecimalFormat df5 = new DecimalFormat("#.#####");
    Priority priority = new Priority();
    double max_priority = 0, min_priority = 1000, p;
    int client_number_max, file_index_max, client_number_min, file_index_min;
    int i, j;

    public int removeFileMin(ArrayList<Client> clients, int tab[][], int id) {
        int client_number_min = -1, file_index_min = -1;
        min_priority = 1000;
        int time = 0;

        for (i = 0; i < clients.size(); i++) {

            for (j = 0; j < clients.get(i).filesList.size(); j++) {
                if (clients.get(i).filesBusy.get(j) == 0) {
                    p = priority.countPriority(i + 1, clients.get(i).filesList.get(j), clients.get(i).numberOfFiles);

                    if (p < min_priority) {
                        time = clients.get(i).filesList.get(j) * 100;
                        min_priority = p;
                        client_number_min = i;
                        file_index_min = j;
                    }
                }
            }
        }
        if (client_number_min != -1) {
            clients.get(client_number_min).filesBusy.set(file_index_min, 1);
            tab[id][0] = client_number_min;
            tab[id][1] = file_index_min;
            tab[id][2] = clients.get(client_number_min).filesList.get(file_index_min);

        }
        //if(tab[id][0]!=-1)clients.get(tab[id][0]).filesList.remove(tab[id][1]);
        //if(client_number_min!=-1)clients.get(client_number_min).filesList.remove(file_index_min);

        return time;
    }

    public int removeFileMax(ArrayList<Client> clients, int tab[][], int id) {
        int client_number_max = -1, file_index_max = -1;
        max_priority = 0;
        int time = 0;

        for (i = 0; i < clients.size(); i++) {

            for (j = 0; j < clients.get(i).filesList.size(); j++) {
                if (clients.get(i).filesBusy.get(j) == 0) {
                    p = priority.countPriority(i + 1, clients.get(i).filesList.get(j), clients.get(i).filesList.size());

                    if (p > max_priority) {
                        time = clients.get(i).filesList.get(j) * 100;
                        max_priority = p;
                        client_number_max = i;
                        file_index_max = j;
                    }
                }
            }
        }
        if (client_number_max != -1) {
            tab[id][0] = client_number_max;
            tab[id][1] = file_index_max;
            tab[id][2] = clients.get(client_number_max).filesList.get(file_index_max);
            clients.get(client_number_max).filesBusy.set(file_index_max, 1);
        }
//        if(tab[id][0]!=-1)clients.get(tab[id][0]).filesList.remove(tab[id][1]);
        //if(client_number_max!=-1)clients.get(client_number_max).filesList.remove(file_index_max);

        return time;
    }

    public void printClients(ArrayList<Client> clients) {
        System.out.println();
        for (i = 0; i < clients.size(); i++) {

            if (clients.get(i).filesList.size() != 0)
                System.out.print("Client " + i + ": " + clients.get(i).filesList.size() + " files (");
            else System.out.print("Client " + i + ": " + clients.get(i).filesList.size() + " files \n");

            for (j = 0; j < clients.get(i).filesList.size(); j++) {

                System.out.printf(clients.get(i).filesList.get(j) + " MB - p " + df5.format(priority.countPriority(i + 1, clients.get(i).filesList.get(j), clients.get(i).filesList.size())));
                if (j != clients.get(i).filesList.size() - 1) System.out.print(", ");
                else System.out.println(")");

            }
        }
    }

}
