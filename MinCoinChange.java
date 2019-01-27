 static long getMinCoins(long n, long[] c) {
        Set<Long> coin = new HashSet<Long>();
        for(int i = 0; i< c.length ; i++)
        {
            coin.add(c[i]);
        }
        long[] arr = new long[(int)n];
        for(int i = 0 ; i< arr.length ;i++)
        {
            if(coin.contains((long)i+1))
            {
                arr[i] = 1;
            }
                
            else
            {
                int j = i -1;
                long min = Integer.MAX_VALUE;
                while(j >= 0)
                {
                    if(min > arr[j] + arr[i-j] && arr[j] != 0 && arr[i-j]!=0)
                        min = arr[j] + arr[i-j];
                    j--;
                }
                arr[i] = min;
            }
        }
        return (long)arr[(int)n-1];
        }
