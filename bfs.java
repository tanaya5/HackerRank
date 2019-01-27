import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
        // n : number of nodes
        // m : number of edges
        // s : starting node

        // creating adjacency matrix for edges
        int[][] adjE = new int[n+1][n+1];
        for(int i = 0; i< edges.length ; i++)
        {
            adjE[edges[i][0]][edges[i][1]] = 1;
        }

        // creating a queue
        Queue<Integer> que = new LinkedList<>();

        // array for checking processed
        int[] arr = new int[n+1];

        // creating a returning array
        int[] result = new int[n];
        
        // adding stating vertex to queue
        que.add(s);
        arr[s] = 1;
        result[s-1]=1;
        while(!que.isEmpty())
        {
            int num = que.poll();
            for(int i = 1; i < n+1 ;i++)
            {
                if((adjE[num][i] == 1 || adjE[i][num] == 1) && arr[i]!= 1)
                {
                    que.add(i);
                    arr[i] =1;
                    result[i-1] = result[num-1]+1;
                }
            }

        }
        int[] res = new int[n-1];
        int j=0;
        for(int i = 0 ; i< result.length  ; i++)
        {
            if(i+1 ==s)
            {}
            else
            {
                if(result[i] == 0)
                {
                    res[j] = -1;
                }
                else
                {
                    res[j] = (result[i]-1)*6;
                }
                j++;
            }
        }
        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
