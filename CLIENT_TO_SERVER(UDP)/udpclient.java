import java.util.*;
import java.io.*;
import java.lang.*;
import java.net.*;
public class udpclient
{
   public static void main(String[] args)
   {
      try
      {
      InetAddress address=InetAddress.getByName("127.0.0.1");
      int port=2000;
      DatagramSocket socket=new DatagramSocket();
      
      Scanner sc=new Scanner(System.in);
      String name;
      System.out.println("Enter the name of the file");
      name=sc.nextLine();
      
      byte[] buffer=name.getBytes();
      DatagramPacket request=new DatagramPacket(buffer,buffer.length,address,port);
      socket.send(request);
      
      
      
      byte[] respo=new byte[512];
      DatagramPacket response=new DatagramPacket(respo,respo.length);
      socket.receive(response);
      String cont=new String(respo,0,response.getLength());
      System.out.println(cont);
      }
      catch(Exception e)
      {
         System.out.println(e);
      }
      
   }
   
}   
      
