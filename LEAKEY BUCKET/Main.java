import java.io.*;
import java.util.*;
public class Main
{
   public static void main(String [] args)
   {
     Scanner sc=new Scanner(System.in);
     int n;
     System.out.println("Enter the number of packets");
     n=sc.nextInt();
     
     leakey_bucket ob=new leakey_bucket(n);
     
     ob.input();
     ob.calc();
   }
}    
  