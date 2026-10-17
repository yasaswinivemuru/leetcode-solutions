class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        Integer[] sorted=new Integer[n];
        for(int i=0;i<n;i++)
        sorted[i]=nums[i];
        Arrays.sort(sorted,(a,b)->{
            int suma=digitsum(a);
            int sumb=digitsum(b);
            if(suma!=sumb)
            return Integer.compare(suma,sumb);
            return Integer.compare(a,b);
        });
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        map.put(sorted[i],i);
        boolean[] visited=new boolean[n];
        int swaps=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i])
            continue;
            int j=i;
            int count=0;
            while(!visited[j])
            {
                visited[j]=true;
                j=map.get(nums[j]);
                count++;
            }
            if(count>1)
            swaps+=count-1;
        }
        return swaps;
    }
    public int digitsum(int a)
    {
        int sum=0;
        while(a>0)
        {
            sum+=a%10;
            a/=10;
        }
        return sum;
    }
}