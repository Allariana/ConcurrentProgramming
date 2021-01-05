import java.util.ArrayList;

public class LoadBalancer {
    int speed = 70; //90
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
                                time = clients.get(i).filesList.get(j) * speed;
                                min_priority = p;
                                client_index = i;
                                file_index = j;
                            }
                        } else if (p > max_priority) {

                            time = clients.get(i).filesList.get(j) * speed;
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

//    public int removeFileMin(ArrayList<Client> clients, int tab[][], int id) {
//        int client_number_min = -1, file_index_min = -1;
//        min_priority = 1000;
//        int time = 0;
//
//        for (i = 0; i < clients.size(); i++) {
//            actualSize = 0;
//            for (j = 0; j < clients.get(i).filesList.size(); j++) {
//                if(clients.get(i).filesList.get(j)!=0)actualSize +=1;
//            }
//            for (j = 0; j < clients.get(i).filesList.size(); j++) {
//                if (clients.get(i).filesBusy.get(j) == 0) {
//                    p = priority.countPriority(i + 1, clients.get(i).filesList.get(j), actualSize);
//
//                    if (p < min_priority) {
//                        time = clients.get(i).filesList.get(j) * 90;
//                        min_priority = p;
//                        client_number_min = i;
//                        file_index_min = j;
//                    }
//                }
//            }
//        }
//        if (client_number_min != -1) {
//            clients.get(client_number_min).filesBusy.set(file_index_min, 1);
//            tab[id][0] = client_number_min;
//            tab[id][1] = file_index_min;
//            tab[id][2] = clients.get(client_number_min).filesList.get(file_index_min);
//
//        }
//
//        return time;
//    }
//
//    public int removeFileMax(ArrayList<Client> clients, int tab[][], int id) {
//        int client_number_max = -1, file_index_max = -1;
//        max_priority = 0;
//        int time = 0;
//
//        for (i = 0; i < clients.size(); i++) {
//            actualSize = 0;
//            for (j = 0; j < clients.get(i).filesList.size(); j++) {
//                if(clients.get(i).filesList.get(j)!=0)actualSize +=1;
//            }
//            for (j = 0; j < clients.get(i).filesList.size(); j++) {
//                if (clients.get(i).filesBusy.get(j) == 0) {
//                    p = priority.countPriority(i + 1, clients.get(i).filesList.get(j), actualSize);
//
//                    if (p > max_priority) {
//                        time = clients.get(i).filesList.get(j) * 90;
//                        max_priority = p;
//                        client_number_max = i;
//                        file_index_max = j;
//                    }
//                }
//            }
//        }
//        if (client_number_max != -1) {
//            clients.get(client_number_max).filesBusy.set(file_index_max, 1);
//            tab[id][0] = client_number_max;
//            tab[id][1] = file_index_max;
//            tab[id][2] = clients.get(client_number_max).filesList.get(file_index_max);
//        }
//
//        return time;
//    }
//
//}
