import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int[] res =  new int[n];
        if(n == 1)
            return 1;
            long cand =0;
        if(arr[0] > arr[1])
        {
            res[0] = 2; 
            res[1] = 1;
        }
        else
        {
            res[0] = 1;
            res[1] = 2;
        }
        for(int i = 1 ; i< n-1 ;i++)
        {
            if(arr[i] < arr[i+1])
            {
                res[i+1] = res[i]+1;
            }
            else
            {
                res[i+1] =1;
                int j =i+1;
                while(res[j] == res[j-1] && j >=0 && arr[j] !=arr[j-1])
                {
                    res[j-1]++;
                    j --;
                }
            }
        }
        for(int  i =0; i< n ;i ++)
        {
            cand = cand + res[i];
            System.out.print(" " + res[i]);
        }
            
        return cand;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
