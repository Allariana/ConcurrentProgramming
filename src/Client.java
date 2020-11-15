import java.util.Random;

public class Client {
    static final int MAX_RAND_NUMBER = 12;
    static final int MAX_RAND_SIZE = 100;
    static final int MIN_RAND = 1;

    Random rand = new Random();

    int numberOfFiles = rand.nextInt(MAX_RAND_NUMBER - MIN_RAND) + MIN_RAND; //wylosowanie liczby plikow
    int[] tab = new int[numberOfFiles]; //tablica z rozmiarami plikow
    int i;

    public void randFunc(int numberOfFiles) {
        for (i = 0; i < numberOfFiles; i++) {
            tab[i] = rand.nextInt(MAX_RAND_SIZE - MIN_RAND) + MIN_RAND;
        }
    }
}
