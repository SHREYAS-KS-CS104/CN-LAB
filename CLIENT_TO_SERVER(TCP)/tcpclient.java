import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
public class tcpclient
{
  public static void main(String[] args)
  {
     try
     { 
        Scanner sc=new Scanner(System.in); 
       
        Socket s=new Socket("127.0.0.1",12000);
        
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        
        DataInputStream dis=new DataInputStream(s.getInputStream());
        
        dos.writeUTF("CONNECTED TO 127.0.0.1\n");
        
        System.out.println("Enter the path of the file");
        
        String path=sc.nextLine();
        dos.writeUTF(path);
        
        System.out.println(new String(dis.readUTF()));
        
        dis.close();
        dos.close();
        sc.close();
        s.close();
     }
     catch(Exception e)
     {
       System.out.println(e);
     }
  
  }
  
}
