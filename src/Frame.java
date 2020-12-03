import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.Objects;
import javax.swing.*;

public class Frame extends JFrame
{
    private JList<String> fileList1;
    private DefaultListModel<String> filesListData1;
    public static DecimalFormat df5 = new DecimalFormat("#.#####");
    JLabel lclient;
    private static int NUMBER_OF_CLIENTS;
    Client[] clients;
    int i,j;
    public Frame(int NUMBER_OF_CLIENTS,Client[] clients) throws IOException
    {
        super("Clients");
        this.clients = clients;
        this.NUMBER_OF_CLIENTS = NUMBER_OF_CLIENTS;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(new Dimension(1000, 600));
//        setLayout(null);
//        setVisible(true);
        filesListData1 = new DefaultListModel<>();
        fileList1 = new JList(filesListData1); //data has type Object[]
        fileList1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        fileList1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        fileList1.setVisibleRowCount(-1);
        fileList1.setBounds(10, 0, 190, 440);
        fileList1.setBackground(Color.orange);
        listFiles(NUMBER_OF_CLIENTS,clients,filesListData1);
//        lclient = new JLabel("Client");
//        lclient.setBounds(50,30,100,20);
//        add(lclient);
        setLayout(null);
        add(fileList1);
        setVisible(true);


    }


    public void refresh() throws IOException
    {

    }

    private void listFiles(int NUMBER_OF_CLIENTS,Client[] clients, DefaultListModel<String> list) throws IOException
    {
        list.clear();
        for (j = 0; j < clients[i].filesList.size(); j++) {
            list.addElement(clients[0].filesList.get(j).toString());
        }


    }
}
