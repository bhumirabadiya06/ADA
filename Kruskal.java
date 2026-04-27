import java.util.*;

public class Kruskal{

    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        int edges[][] = new int[e][3];

        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt(); // u
            edges[i][1] = sc.nextInt(); // v
            edges[i][2] = sc.nextInt(); // weight
        }

        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        int parent[] = new int[n];

        // Initialize parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 0;
        int totalCost = 0;

        System.out.println("Edge  Weight");

        for (int i = 0; i < e && count < n - 1; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            int pu = find(parent, u);
            int pv = find(parent, v);

            // If no cycle
            if (pu != pv) {
                System.out.println(u + " - " + v + "   " + w);
                parent[pu] = pv;  // union
                totalCost += w;
                count++;
            }
        }

        System.out.println("Minimum cost = " + totalCost);
        sc.close();
    }
}
