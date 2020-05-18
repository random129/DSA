package com.prac;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Searching
{
    public static void main (String[] args)throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);

            long x = Long.parseLong(a[(int)1]);
            String st[] = read.readLine().trim().split("\\s+");
            long arr[] = new long[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st[i]); }
            System.out.println(new FloorSearch().findFloor(arr, 0, n-1, x));
        }
    }
}// } Driver Code Ends
class FloorSearch{
    // arr[] - 1,3,5
    // left is 0
    // right is total no of elements -1 = 2
    // x is 0
    static int findFloor(long arr[], int left, int right, long x) {
        int mid = left + (right - left)/2;
        while(left<=right){
            // array of middle position greater than 1
            // array of middle position less than 1 is less than 1
            // middle position less than 1 is not equal to 1
          //  if(arr[mid]>x && (arr[mid-1]<=x || mid-1 !=0)){
            if(mid>0 && arr[mid]>x && (arr[mid-1]<=x )){
                return mid-1;
            }
            // array of middle position greater than 1
            // array of middle position -1 greater than 1
            //   middle position -1 not equal to 1
            else if(mid>0 && arr[mid]>x && (arr[mid-1]>x )){
                return findFloor(arr,left,mid-1,x);
            }
            // array of middle position is equal to 1, returns MID
            else if(arr[mid]==x){
                return mid;
            }
            // Mid not equal to right -1
            // array of mid +1 greater than 1
            else if(mid != right-1 && arr[mid+1]>=x){
                return mid;
            }
            // mid not equal to right -1
            // array of mid+1 less than 1
            else if(mid != right-1 && arr[mid+1]<x){
                return findFloor(arr,mid+1,right,x);
            }
        }
        return -1;
    }
}
