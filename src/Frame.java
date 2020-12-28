import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

public class Frame extends JFrame {
    LoadBalancer loadBalancer = new LoadBalancer();
    Server server = new Server();
    int tab[][] = new int[5][3];
    JLabel jLabel1 = new JLabel("Server 1");
    JLabel jLabel2 = new JLabel("Server 2");
    JLabel jLabel3 = new JLabel("Server 3");
    JLabel jLabel4 = new JLabel("Server 4");
    JLabel jLabel5 = new JLabel("Server 5");
    JButton button = new JButton("Add client");

    ArrayList<DefaultListModel<String>> dfm = new ArrayList<>();
    ArrayList<DefaultListModel<String>> dfmS = new ArrayList<>();
    private JList<String> fileList, fileListS;

    ArrayList<Client> clients = new ArrayList<>();
    int i, j;

    public Frame() {
        super("Clients");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(new Dimension(1000, 700));
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 3; j++) {
                tab[i][j] = -1;
            }
        }
//        jLabel1.setBounds(10, 0, 50, 50);
//        add(jLabel1);
//        jLabel2.setBounds(90, 0, 50, 50);
//        add(jLabel2);
//        jLabel3.setBounds(170, 0, 50, 50);
//        add(jLabel3);
//        jLabel4.setBounds(250, 0, 50, 50);
//        add(jLabel4);
//        jLabel5.setBounds(330, 0, 50, 50);
//        add(jLabel5);
        button.setBounds(850, 600, 100, 40);
        add(button);
        setLayout(null);
        setVisible(true);
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clients.add(new Client());
                clients.get(clients.size() - 1).randFunc(clients.get(clients.size() - 1).numberOfFiles);
            }
        });
    }

    public void startServer() {

        server.startThreads(clients, tab);

    }

    public void refresh() {
        //loadBalancer.printClients(clients);
        for (i = 0; i < 5; i++) {
            dfmS.add(new DefaultListModel<>());
            dfmS.get(i).clear();
            dfmS.get(i).addElement("Server " + (i + 1));
//            if (tab[i][0] != -1) {
                dfmS.get(i).addElement("Client " + tab[i][0]);
                dfmS.get(i).addElement("File " + tab[i][1]);
            dfmS.get(i).addElement("Size " + tab[i][2]);
//            }

            fileListS = new JList(dfmS.get(i));

            fileListS.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            fileListS.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            fileListS.setVisibleRowCount(-1);
            fileListS.setBounds(10 + 80 * i, 20, 50, 70);
            add(fileListS);
        }

        for (i = 0; i < clients.size(); i++) {
            dfm.add(new DefaultListModel<>());
            dfm.get(i).clear();
            dfm.get(i).addElement("Client " + (i + 1));
            for (j = 0; j < clients.get(i).filesList.size(); j++) {
                dfm.get(i).addElement(clients.get(i).filesList.get(j).toString() + " MB");
            }
            fileList = new JList(dfm.get(i));

            fileList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            fileList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            fileList.setVisibleRowCount(-1);
            fileList.setBounds(10 + 80 * i, 100, 50, 500);
            add(fileList);
        }


        setLayout(null);
        setVisible(true);
    }

}
