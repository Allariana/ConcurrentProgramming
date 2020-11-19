public class ServerMainThread implements Runnable {
    private int id;

    public ServerMainThread(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        if(id==4)System.out.println("WatekOdwrotny "+id);
        else System.out.println("Watek "+id);
    }
}
