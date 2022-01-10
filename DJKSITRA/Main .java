import java.io.*;
import java.util.*;
class Main
{
  public static void main(String[] args)
  {
     int n;
     int src;
     Scanner sc=new Scanner(System.in);
     
     System.out.println("Enter the Number of nodes");
     n=sc.nextInt();
     
     System.out.println("Enter the source");
     src=sc.nextInt();
     
     djksitra ob=new djksitra(n,src);
     
     ob.input();
     
     int[] ans=ob.dj();
     
     System.out.println("SHORTEST DISTANCE FROM THE SOURCE " + src);
     for(int i=0;i<ans.length;i++)
     {
        System.out.println(src +  " -----> " + i  + " " +  ans[i]);
     }
  }
}  
     
     
     