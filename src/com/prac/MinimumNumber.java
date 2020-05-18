package com.prac;
import java.io.*;
import java.lang.*;

class MinimumNumber
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            long n = Long.parseLong(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int arr[] = new int[(int)n];
            for(long i = 0; i < n; i++)
                arr[(int)i] = Integer.parseInt(st[(int)i]);
            System.out.println(new MinimumNumber1().minNumber(arr,0,n-1));
        }
    }
}// } Driver Code Ends
class MinimumNumber1 {
    static long minNumber(int arr[], long low, long high) {
        while(low<=high){
            if(low == high){
                return arr[(int)low];
            }
            long mid =   (high+low)/2;
            // Is Mid greater than first element
            // is Mid less than last element
            if(arr[(int) mid]>=arr[(int)low] && arr[(int)mid]<=arr[(int)high]){
                high = mid-1;
                // setting last element index value to element before mid
            }
            // is mid less than first element
            // if mid is greater than last element
            else if(arr[(int) mid]<=arr[(int)low] && arr[(int) mid]>=arr[(int)high]){
                low = mid + 1;
            }

            // if mid is less than first element & mid is less than last element
            else if(arr[(int) mid]<=arr[(int)low] && arr[(int) mid]<=arr[(int)high]){
                low++;
                high--;
            }
            else if(arr[(int)mid]>=arr[(int)low] && arr[(int)mid]>=arr[(int)high]){
                low = mid+1;
            }
            else{
                return arr[(int)mid];
            }
        }
        return -1;
    }
}
