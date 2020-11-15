import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    static final int MAX_RAND_NUMBER = 12;
    static final int MAX_RAND_SIZE = 100;
    static final int MIN_RAND = 1;

    Random rand = new Random();
    List<Integer> filesList = new ArrayList<>(); //lista zawierajca rozmiary plikow
    int numberOfFiles = rand.nextInt(MAX_RAND_NUMBER - MIN_RAND) + MIN_RAND; //wylosowanie liczby plikow
    int i;

    public void randFunc(int numberOfFiles) {
        for (i = 0; i < numberOfFiles; i++) {
            filesList.add(rand.nextInt(MAX_RAND_SIZE - MIN_RAND) + MIN_RAND);
        }
    }
}
