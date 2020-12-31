import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    static final int MAX_RAND_NUMBER = 20;
    static final int MAX_RAND_SIZE = 300;
    static final int MIN_RAND = 10;

    Random rand = new Random();
    List<Integer> filesList = new ArrayList<>(); //lista zawierajca rozmiary plikow
    List<Integer> filesBusy = new ArrayList<>();

    int tab[] = new int[2];
    int numberOfFiles = rand.nextInt(MAX_RAND_NUMBER - MIN_RAND) + MIN_RAND; //wylosowanie liczby plikow
    int i;

    public void randFunc(int numberOfFiles) {
        for (i = 0; i < numberOfFiles; i++) {
            filesList.add(rand.nextInt(MAX_RAND_SIZE - MIN_RAND) + MIN_RAND);
        }
        for (i = 0; i < numberOfFiles; i++) {
            filesBusy.add(0);
        }
    }
}
