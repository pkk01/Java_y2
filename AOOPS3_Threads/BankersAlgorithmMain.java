import java.util.Arrays;

public class BankersAlgorithmMain {
    private int[][] max;
    private int[][] allot;
    private int[] avail;

    private int numProcesses;
    private int numResources;

    public BankersAlgorithmMain(int numProcesses, int numResources, int[][] max, int[][] allot, int[] avail) {
        this.allot = allot;
        this.avail = avail;
        this.numProcesses = numProcesses;
        this.numResources = numResources;
    }

    public boolean isSafe() {
        int[] work = Arrays.copyOf(avail, avail.length);
        boolean[] finish = new boolean[numProcesses];
        int count = 0;

        while (count < numProcesses) {
            boolean found = false;

            for (int p = 0; p < numProcesses; p++) {
                if (!finish[p] && canAllocate(p, work)) {
                    for (int j = 0; j < numResources; j++) {
                        work[j] += allot[p][j];
                    }

                    finish[p] = true;
                    found = true;
                    count++;
                }
            }
        }
    }
}
