package studentRecordsBackupTree.factory;

import java.util.ArrayList;
import java.util.List;

import studentRecordsBackupTree.util.FileProcessorInterface;

public class OptimalBST {

    List<Integer> frequency;
    int[] freq;

    public OptimalBST(FileProcessorInterface fileProcessor) {
        frequency = new ArrayList<Integer>();
        frequency = fileProcessor.givenFrequency();
        freq = frequency.stream().mapToInt(i -> i).toArray();
        int val = optimalSearchTree(freq, freq.length);
        System.out.println("\n \n The total cost of the optimal BST based on frequencies is: " + val);
    }

    public int optCost(int freq[], int i, int j) {
        if (j < i)
            return 0;
        if (j == i)
            return freq[i];

        int fsum = sum(freq, i, j);

        // Initialize minimum value
        int min = Integer.MAX_VALUE;

        for (int r = i; r <= j; ++r) {
            int cost = optCost(freq, i, r - 1) + optCost(freq, r + 1, j);
            if (cost < min)
                min = cost;
        }

        // Return minimum value
        return min + fsum;
    }

    public int optimalSearchTree(int keys[], int n) {
        return optCost(freq, 0, n - 1);
    }

    public int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++)
            s += freq[k];
        return s;
    }

}
