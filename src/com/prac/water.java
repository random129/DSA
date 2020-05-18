package com.prac;

import java.util.Scanner;

public class water
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int height[]=new int[n];
            for(int i=0;i<n;i++)
                height[i]=sc.nextInt();
            System.out.println(maxWater(height, n));
        }
    }

    static int maxWater(int height[], int n)
    {
        int i = 0 ;
        int j = n-1;
        int compare = 0;
        while(i<j){
            if(height[i]<height[j]){
                compare = Math.max(compare,(j-i-1)*height[i]);
                i++;
            }
            else if(height[i]>height[j]){

                compare = Math.max(compare,(j-i-1)*height[j]);
                j--;
            }
            else{
                compare = Math.max(compare,(j-i-1)*height[i]);
                i++;
                j--;
            }
        }
        return compare;
    }
}
