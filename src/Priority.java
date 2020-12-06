public class Priority {
    double priority;
    public double countPriority(int queue, int size, int numberOfFiles) {
        priority = 1.0 / (10 * queue) + 10.0 / size + 1.0 / numberOfFiles; //zmiana 2*queue na 10*queue
        return priority;
    }
}
