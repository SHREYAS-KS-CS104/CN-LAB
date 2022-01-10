import java.io.*;
import java.lang.*;
import java.util.*;
class Main
{
   public static String string_val(String sts,int poly_length)
   {
       for(int i=1;i<poly_length;i++)
       {
           sts=sts+"0";
       }
       return sts;
       
   }
    
   public static String generate(char[] divisior,char[] dividend,int len,String org)
   {
      for(int i=0;i<len;i++)
      {
        if(dividend[i]=='1')
        {
           for(int j=0;j<divisior.length;j++)
           {
              if(dividend[i+j]==divisior[j])
              {
                 dividend[i+j]='0';
              }
              else
              {
                dividend[i+j]='1';
              }
            }
          }
       }
       String st=String.valueOf(dividend);
       
       String fin=org+st.substring(len);
       
       return fin;
       
   }
   public static void main(String[] args)
   {
   
      String str,rec;
      String d="10001000000100001";
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the string");
      str=sc.next();
      
      String org=str;
      
    //   System.out.println("ORIGINAL STRING IS " + org);
      
      int len=str.length();
      
      str=string_val(str,d.length());
      
      char[] divisior=d.toCharArray();
      char[] dividend=str.toCharArray();
      
      
      String fin=generate(divisior,dividend,len,org);
      
      System.out.println("DIVISIOR= " + String.valueOf(divisior));
      System.out.println("DIVIDEND= " + String.valueOf(dividend));
      

       System.out.println("TRANSMITTED MESSAGE IS  " + fin);
       
       System.out.println("Enter the received message");
       rec=sc.next();
       org=rec;
       
       len=rec.length();
       
       rec=string_val(rec,d.length());
       
       dividend=rec.toCharArray();
       
       String rin=generate(divisior,dividend,len,org);
       
       
       System.out.println("MESSAGE DUE TO ERRORS IS");
       System.out.println(rin);
       if(fin.equals(rin))
       {
           System.out.println("NO ERRORS");
       }
       else
       {
           System.out.println("ERRORS REPORTED");
       }
       
    //   System.out.println
   }
}
           
   
      
      