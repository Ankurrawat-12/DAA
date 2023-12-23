import java.util.*;

public class KnapsackDynamic{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of items");
        int n = scanner.nextInt();
        int[] profit = new int[n+1];
        int[] weight = new int[n+1];
        profit[0] = 0;
        weight[0] = 0;
        System.out.println("Enter the Profit and Weight Of The Items: -");
        for (int i = 1; i <= n; i++) {
            System.out.println("Profit Of Item " + i);
            int item_profit = scanner.nextInt();
            System.out.println("Weight Of Item " + i);
            int item_weight = scanner.nextInt();
            weight[i] = item_weight;
            profit[i] = item_profit;
        }
        System.out.println("Enter the capacity of the knapsack");
        int capacity = scanner.nextInt();
        scanner.close();
        int[][] dp = new int[n+1][capacity+1];

        for(int i = 0; i <= n; i++){
            for(int w = 0; w <= capacity; w++){
                if(w==0 || i == 0)
                    dp[i][w] = 0;
                else if(weight[i] <= w)
                    dp[i][w] = Math.max(profit[i] + dp[i-1][w - weight[i]], dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }
        System.out.println("The Maximum Profit is: " + dp[n][capacity]);
    }

}