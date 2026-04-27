import java.util.Scanner;

public class Prims{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        System.out.println("Enter cost matrix:");
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        boolean[] visited = new boolean[n];
        visited[0] = true;

        int edges = 0, minCost = 0;

        System.out.println("Edges in MST:");

        while (edges < n - 1) {
            int min = 999, x = 0, y = 0;

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!visited[j] && cost[i][j] != 0) {
                            if (cost[i][j] < min) {
                                min = cost[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " = " + min);
            minCost += min;
            visited[y] = true;
            edges++;
        }

        System.out.println("Minimum cost = " + minCost);
        sc.close();
