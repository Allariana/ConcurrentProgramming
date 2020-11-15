public class LoadBalancer {
    double priority;

    public double countPriority(int queue, int size, int numberOfFiles) {
        priority = 1.0 / (2 * queue) + 10.0 / size + 1.0 / numberOfFiles;
        return priority;
    }
}
