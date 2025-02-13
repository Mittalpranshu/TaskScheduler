import java.util.*;

class Job {
    int weight, length;
    double ratio;

    public Job(int weight, int length) {
        this.weight = weight;
        this.length = length;
        this.ratio = (double) weight / length;
    }
}

public class TaskSchedulerGreedy {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(3, 5),
            new Job(1, 2),
            new Job(4, 6),
            new Job(2, 3),
            new Job(5, 7)
        );

        jobs.sort((a, b) -> Double.compare(b.ratio, a.ratio));

        long completionTime = computeCompletionTime(jobs);
        System.out.println("Minimum Completion Time (Greedy Algorithm): " + completionTime);
    }

    private static long computeCompletionTime(List<Job> jobs) {
        long finishTime = 0, weightedSum = 0;

        for (Job job : jobs) {
            finishTime += job.length;
            weightedSum += (long) finishTime * job.weight;
        }
        return weightedSum;
    }
}
