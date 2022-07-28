package CodingQuestions;

import java.util.List;

public class AlgoExpertKnapsack {

    public static void main(String[] args) {

        int[][] a = new int[][]{{1,2},{4,3},{5,6},{6,7}};
        //knapsackProblem1(a,10);
    }

    public static void knapsackProblem1(int[][] a, int capacity, int n) {
        int rows = a.length;
        int[] op = new int[capacity + 1];

        for (int i = 0; i < rows; i++) {

            for (int j = i ; j >= 0; j--) {
                int capacityWithJ = i - a[j][0];
                if (capacityWithJ >= 0 && op[i] < op[capacityWithJ] + a[j][1])
                    op[i] = op[capacityWithJ] + a[j][1];
            }

        }
        System.out.println(op);
    }

}
