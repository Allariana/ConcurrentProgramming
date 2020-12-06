import java.awt.Dimension;
import javax.swing.*;

public class Frame extends JFrame
{
    private JList<String> fileList1, fileList2;
    private DefaultListModel<String> filesListData1, filesListData2;
    private static int NUMBER_OF_CLIENTS;
    Client[] clients;
    int i,j;
    public Frame(int NUMBER_OF_CLIENTS,Client[] clients) {
        super("Clients");
        this.clients = clients;
        this.NUMBER_OF_CLIENTS = NUMBER_OF_CLIENTS;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(new Dimension(500, 500));

        filesListData1 = new DefaultListModel<>();
        fileList1 = new JList(filesListData1);
        fileList1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        fileList1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        fileList1.setVisibleRowCount(-1);
        fileList1.setBounds(10, 0, 50, 440);

        filesListData2 = new DefaultListModel<>();
        fileList2 = new JList(filesListData2);
        fileList2.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        fileList2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        fileList2.setVisibleRowCount(-1);
        fileList2.setBounds(90, 0, 50, 440);

//        refresh();
    }


    public void refresh(){
        filesListData1.clear();
        filesListData1.addElement("Client 0");
        for (j = 0; j < clients[0].filesList.size(); j++) {
            filesListData1.addElement(clients[0].filesList.get(j).toString() + " MB");
        }
        setLayout(null);
        add(fileList1);
        setVisible(true);

        filesListData2.clear();
        filesListData2.addElement("Client 1");
        for (j = 0; j < clients[1].filesList.size(); j++) {
            filesListData2.addElement(clients[1].filesList.get(j).toString() + " MB");
        }
        setLayout(null);
        add(fileList2);
        setVisible(true);
    }

}
