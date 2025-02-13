import java.util.*;

class Job {
    int weight, length;

    public Job(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }
}

public class TaskSchedulerBruteForce {
    static List<List<Job>> allPermutations = new ArrayList<>();

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
            new Job(3, 5), new Job(1, 2), new Job(4, 6), new Job(2, 3),
            new Job(5, 7), new Job(6, 8), new Job(7, 4), new Job(8, 9)
        );

        long startTime = System.nanoTime();
        permute(jobs, 0);

        long minCompletionTime = Long.MAX_VALUE;

        for (List<Job> permutation : allPermutations) {
            long time = computeCompletionTime(permutation);
            if (time < minCompletionTime) {
                minCompletionTime = time;
            }
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Convert to milliseconds

        System.out.println("Minimum Completion Time (Brute Force): " + minCompletionTime);
        System.out.println("Execution Time (Brute Force): " + duration + " ms");
    }

    private static void permute(List<Job> jobs, int start) {
        if (start == jobs.size() - 1) {
            allPermutations.add(new ArrayList<>(jobs));
            return;
        }

        for (int i = start; i < jobs.size(); i++) {
            Collections.swap(jobs, start, i);
            permute(jobs, start + 1);
            Collections.swap(jobs, start, i);
        }
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
