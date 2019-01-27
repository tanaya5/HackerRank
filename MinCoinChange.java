 static long getMinCoins(long n, long[] c) {
       Set<Long> coin = new HashSet<Long>();
        for(int i = 0; i< c.length ; i++)
        {
            coin.add(c[i]);
        }
        long[] arr = new long[(int)n+1];
        for(int i = 1 ; i< arr.length ;i++)
        {
            if(coin.contains((long)i))
            {
                arr[i] = 1;
            }
                
            else
            {
                int j = i -1;
                long min = n+1;
                while(j > 0)
                {
                    if(min > arr[j] + arr[i-j] && arr[j] != 0 && arr[i-j]!=0)
                        min = arr[j] + arr[i-j];
                    j--;
                }
                arr[i] = min;
            }
            System.out.println(" ," + arr[i]);
        }
        return (long)arr[(int)n];
        }
