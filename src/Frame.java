import java.awt.Dimension;
import javax.swing.*;

public class Frame extends JFrame
{
    JLabel jLabel1 = new JLabel("Server 1");
    JLabel jLabel2 = new JLabel("Server 2");
    JLabel jLabel3 = new JLabel("Server 3");
    JLabel jLabel4 = new JLabel("Server 4");
    JLabel jLabel5 = new JLabel("Server 5");
//    ArrayList<JList<String>> jl = new ArrayList<>();
//    ArrayList<DefaultListModel<String>> dfm = new ArrayList<>();
    private JList<String> fileList1, fileList2, fileList3, fileList4, fileList5;
    private DefaultListModel<String> filesListData1, filesListData2, filesListData3, filesListData4, filesListData5;
    private static int NUMBER_OF_CLIENTS;
    Client[] clients;
    int i,j;
    public Frame(int NUMBER_OF_CLIENTS,Client[] clients) {
        super("Clients");
        this.clients = clients;
        this.NUMBER_OF_CLIENTS = NUMBER_OF_CLIENTS;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(new Dimension(410, 550));
        filesListData1 = new DefaultListModel<>();
        fileList1 = new JList(filesListData1);
        fileList1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        fileList1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        fileList1.setVisibleRowCount(-1);
        fileList1.setBounds(10, 50, 50, 500);
//        for(i=0;i<NUMBER_OF_CLIENTS;i++){
//            fileList1.setBounds(10, 0, 50, 440);
//            dfm.add(filesListData1);
//            jl.add(fileList1);
//            //jl[i].setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
//        }

        filesListData2 = new DefaultListModel<>();
        fileList2 = new JList(filesListData2);
        fileList2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        fileList2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        fileList2.setVisibleRowCount(-1);
        fileList2.setBounds(90, 50, 50, 500);

        filesListData3 = new DefaultListModel<>();
        fileList3 = new JList(filesListData3);
        fileList3.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        fileList3.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        fileList3.setVisibleRowCount(-1);
        fileList3.setBounds(170, 50, 50, 500);

        filesListData4 = new DefaultListModel<>();
        fileList4 = new JList(filesListData4);
        fileList4.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        fileList4.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        fileList4.setVisibleRowCount(-1);
        fileList4.setBounds(250, 50, 50, 500);

        filesListData5 = new DefaultListModel<>();
        fileList5 = new JList(filesListData5);
        fileList5.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        fileList5.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        fileList5.setVisibleRowCount(-1);
        fileList5.setBounds(330, 50, 50, 500);

        jLabel1.setBounds(10,0,50,50);
        add(jLabel1);
        jLabel2.setBounds(90,0,50,50);
        add(jLabel2);
        jLabel3.setBounds(170,0,50,50);
        add(jLabel3);
        jLabel4.setBounds(250,0,50,50);
        add(jLabel4);
        jLabel5.setBounds(330,0,50,50);
        add(jLabel5);

    }


    public void refresh(){
        try{
        filesListData1.clear();
        filesListData1.addElement("Client 0");
        for (j = 0; j < clients[0].filesList.size(); j++) {
            filesListData1.addElement(clients[0].filesList.get(j).toString() + " MB");
        }
        add(fileList1);

        filesListData2.clear();
        filesListData2.addElement("Client 1");
        for (j = 0; j < clients[1].filesList.size(); j++) {
            filesListData2.addElement(clients[1].filesList.get(j).toString() + " MB");
        }
        add(fileList2);

        filesListData3.clear();
        filesListData3.addElement("Client 2");
        for (j = 0; j < clients[2].filesList.size(); j++) {
            filesListData3.addElement(clients[2].filesList.get(j).toString() + " MB");
        }
        add(fileList3);

        filesListData4.clear();
        filesListData4.addElement("Client 3");
        for (j = 0; j < clients[3].filesList.size(); j++) {
            filesListData4.addElement(clients[3].filesList.get(j).toString() + " MB");
        }
        add(fileList4);

        filesListData5.clear();
        filesListData5.addElement("Client 4");
        for (j = 0; j < clients[4].filesList.size(); j++) {
            filesListData5.addElement(clients[4].filesList.get(j).toString() + " MB");
        }
        add(fileList5);

        setLayout(null);
        setVisible(true);
        }catch (Exception e) {

        }
    }

}
