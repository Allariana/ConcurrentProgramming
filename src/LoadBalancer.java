import java.util.ArrayList;

public class LoadBalancer {
    int slow = 70;
    Priority priority = new Priority();
    double max_priority = 0, min_priority = 1000, p;
    int i, j;
    int actualSize = 0;

    public int choseFileToLoad(ArrayList<Client> clients, int tab[][], int id) {
        int client_index = -1, file_index = -1;
        min_priority = 100000;
        max_priority = 0;
        int time = 0;
        try {
            for (i = 0; i < clients.size(); i++) {
                actualSize = 0;
                for (j = 0; j < clients.get(i).filesList.size(); j++) {
                    if (clients.get(i).filesList.get(j) != 0) actualSize += 1;
                }
                for (j = 0; j < clients.get(i).filesList.size(); j++) {
                    if (clients.get(i).filesBusy.get(j) == 0) {
                        p = priority.countPriority(i + 1, clients.get(i).filesList.get(j), actualSize);
                        if (id == 4 || id == 3) {
                            if (p < min_priority) {
                                time = clients.get(i).filesList.get(j) * slow;
                                min_priority = p;
                                client_index = i;
                                file_index = j;
                            }
                        } else if (p > max_priority) {

                            time = clients.get(i).filesList.get(j) * slow;
                            max_priority = p;
                            client_index = i;
                            file_index = j;

                        }
                    }
                }
            }
            if (client_index != -1) {
                clients.get(client_index).filesBusy.set(file_index, 1);
                tab[id][0] = client_index;
                tab[id][1] = file_index;
                tab[id][2] = clients.get(client_index).filesList.get(file_index);

            }

            if (id == 4 || id == 3) {
                if (min_priority == 100000) tab[id][0] = -1;
            } else if (max_priority == 0) tab[id][0] = -1;
        } catch (IndexOutOfBoundsException iO) {

        }
        return time;

    }
}

