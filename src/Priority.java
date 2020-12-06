public class Priority {
    double priority;
    public double countPriority(int queue, int size, int numberOfFiles) {
        priority = 1.0 / (10.0 * queue) + 10.0 / size + 1.0 / 2.0 * numberOfFiles; //zmiana 2*queue na 10*queue, numberOfFiles * 2.0
        return priority;
    }
}
