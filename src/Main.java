import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Main {

    static int NUMBER_OF_CLIENTS = 5;

    public static void main(String[] args) throws Exception {

        int i, j;
        ArrayList<Client> clients = new ArrayList<>();
//        Priority priority = new Priority();
//        LoadBalancer loadBalancer = new LoadBalancer();
        Server server = new Server();

        for (i = 0; i < NUMBER_OF_CLIENTS; i++) {

            clients.add(new Client());
            clients.get(i).randFunc(clients.get(i).numberOfFiles);
            //System.out.print("Client " + i + ": " + clients[i].filesList.size() + " files (");

//            for (j = 0; j < clients[i].filesList.size(); j++) {
//
//                //System.out.printf(clients[i].filesList.get(j) + " MB - p " + df5.format(priority.countPriority(i+1,clients[i].filesList.get(j),clients[i].numberOfFiles)));
////                if (j != clients[i].numberOfFiles - 1) System.out.print(", ");
////                else System.out.println(")\n");
//
//            }
        }
        Frame f = new Frame(NUMBER_OF_CLIENTS, clients);

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                f.refresh();
            }
        };
        Timer timer = new Timer(100 ,taskPerformer);
        timer.setRepeats(true);
        timer.start();

        Thread.sleep(100);

        server.startThreads(NUMBER_OF_CLIENTS,clients);
    }
}
//        try {
//            EventQueue.invokeLater(new Runnable() {
////            try{
//            //SwingUtilities.invokeLater(new Runnable(){
//            //SwingUtilities.invokeAndWait(new Runnable(){
//                @Override
//                public void run() {
//                    try {
//                        Frame f = new Frame(NUMBER_OF_CLIENTS, clients);
//                        new Thread(() ->
//                        {
//                            while (true) {
//                                f.refresh();
//                                try {
//                                    sleep(130);
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }).start();
//
//                    } catch (Exception e) {
//
//                    }
//                }
//            });
////            } catch (Exception e) {
////
////            }
//        }catch (Exception e) {
//
//        }
        //sleep(1000);



