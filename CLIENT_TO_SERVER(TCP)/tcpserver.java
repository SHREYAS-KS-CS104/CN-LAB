import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
public class tcpserver
{
  public static void main(String[] args)
  {
     try
     { 
        ServerSocket s=new ServerSocket(12000);
        System.out.println("SERVER WAITING FOR CONNECTION ..... ");
        
        Socket s1=s.accept();
        
        
        
        DataOutputStream dos=new DataOutputStream(s1.getOutputStream());
        
        DataInputStream dis=new DataInputStream(s1.getInputStream());
        
        System.out.println("STATUS: " + dis.readUTF());
        
        String path=dis.readUTF();
        
        System.out.println("REQUEST HAS BEEN RECEIVED ");
        
        try
        {
           File mf=new File(path);
           Scanner sc=new Scanner(mf);
           String st=sc.nextLine();
           while(sc.hasNextLine())
           {
             st=st+"\n" + sc.nextLine();
           }
           dos.writeUTF(st);
           dos.close();
           s1.close();
           s.close();
           sc.close();
         }
         catch(FileNotFoundException e)
         {
           dos.writeUTF("FILE NOT FOUND ");
         }
       }
       catch(IOException e)
       {
          System.out.println(e);
       }
    }
}    
