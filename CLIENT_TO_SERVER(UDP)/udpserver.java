import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;
public class udpserver
{

    public static void main(String[] args)
    {
       try{
       
       byte[] buffer=new byte[512];
 
      
       DatagramSocket socket=new DatagramSocket(2000);
       
       DatagramPacket request = new DatagramPacket(buffer, buffer.length);
       socket.receive(request);
       
       String path = new String(buffer, 0, request.getLength());
       
       System.out.println("REQUEST RECEIVED");
       
       try
       {
         File mf=new File(path);
         Scanner sc=new Scanner(mf);
         String nt=sc.nextLine();
         while(sc.hasNextLine())
         {
            nt=nt+"\n" + sc.nextLine();
         }
         //System.out.println(nt);
         InetAddress clientAddress=request.getAddress();
         int clientPort=request.getPort();
         
         byte[] ans=nt.getBytes();
         DatagramPacket response = new DatagramPacket(ans, ans.length, clientAddress,clientPort);
         socket.send(response);
       }
       catch(FileNotFoundException e)
       {
          String resp="FILE NOT FOUND";
         InetAddress clientAddress=request.getAddress();
         int clientPort=request.getPort();
         
         byte[] ans=resp.getBytes();
         DatagramPacket response = new DatagramPacket(ans, ans.length, clientAddress,clientPort);
         socket.send(response);
       }
    }catch(Exception e)
    {
       System.out.println(e);
    }
    
  }
  
}     
