import java.io.*;
import java.lang.*;
import java.util.*;
public class leakey_bucket
{

   public int no_of_packets;
   public int bucket_size;
   public int o_rate;
   public int packet_size_remaining;
   public int op;
   public int packet_size[];

   
   leakey_bucket(int size)
   {
       no_of_packets=size;
       bucket_size=0;
       o_rate=0;
       packet_size_remaining=0;
       op=0;
       packet_size=new int[size];
   }
   public void input()
   {
      Scanner sc=new Scanner(System.in);
      
    
      
      System.out.println("Enter the bucket size");
      bucket_size=sc.nextInt();
      
      
      System.out.println("Enter the Output Rate");
      o_rate=sc.nextInt();
      
      System.out.println("Enter the size of the each of the packets");
      
      for(int i=0;i<no_of_packets;i++)
      {
         packet_size[i]=sc.nextInt();
      }
      
   }
   public void calc()
   {
   
      for(int i=0;i<no_of_packets;i++)
      {
      
         if(packet_size[i] + packet_size_remaining > bucket_size)
         {
            if(packet_size[i]>bucket_size)
            {
               System.out.println("INCOMING PACKET SIZE " + packet_size[i] + " GREATER THAN BUCKET CAPACITY " + bucket_size);
               System.out.println();
            }
            
            else
            {
               System.out.println("BUCKET CAPACITY EXCEEDED PACKET_REJECTED");
            }
            
          }
          else
          {
             packet_size_remaining+=packet_size[i];
             System.out.println("INCOMING PACKET SIZE " + packet_size[i]); 
             System.out.println("BYTE REMAINING TO BE TRANSMITTED " + packet_size_remaining);
             System.out.println();
             while(packet_size_remaining>0)
             {
                if(packet_size_remaining>0)
                {
                   if(packet_size_remaining<=o_rate)
                   {
                     op=packet_size_remaining;
                     packet_size_remaining=0;
                   }
                   else
                   {
                     op=o_rate;
                     packet_size_remaining-=o_rate;
                   }
                   System.out.println("PACKET SIZE TRANSMITTED " + op);
                   System.out.println("BYTES REMAINING "  + packet_size_remaining);
                   System.out.println();
                 }
                 else
                 {
                    System.out.println("NO PACKETS TO TRANSMIT " );
                 }  
               }
                 
            }
            
         }
     } 
}
             
      
      
      
      
      
      
      
      
   
   