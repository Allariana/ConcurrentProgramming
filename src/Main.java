import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Main {

    public static void main(String[] args) throws Exception {

        Frame f = new Frame();

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                f.refresh();
            }
        };
        Timer timer = new Timer(100 ,taskPerformer);
        timer.setRepeats(true);
        timer.start();

        Thread.sleep(100);
        f.startServer();
    }
}
