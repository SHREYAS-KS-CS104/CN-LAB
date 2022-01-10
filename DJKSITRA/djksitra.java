import java.io.*;
import java.lang.*;
import java.util.*;
public class djksitra
{
   public int graph[][];
   int src;
   int n;
   public djksitra(int n,int src)
   {
      this.n=n;
      graph=new int[n][n];
      this.src=src;
   }
   
   public void input()
   {
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter the Distance matrix");
     for(int i=0;i<n;i++)
     {
        for(int j=0;j<n;j++)
        {
           graph[i][j]=sc.nextInt();
        }
     }
     
   }
   
   public int mindistance(int dist[],Boolean val[])
   {
      int min=Integer.MAX_VALUE;
      int min_index=-1;
      
      for(int i=0;i<dist.length;i++)
      {
       if(dist[i]<min && val[i]==false)
       {
         min=dist[i];
         min_index=i;
       }
       
      }
      return min_index;
   }    
     
   
   public int[] dj()
   {
      int dist[]=new int[n];
      Boolean val[]=new Boolean[n];
      
      Arrays.fill(dist,Integer.MAX_VALUE);
      Arrays.fill(val,false);
      
      dist[src]=0;
      
      for(int i=0;i<n-1;i++)
      {
         int u=mindistance(dist,val);
         
         val[u]=true;
         
         for(int j=0;j<n;j++)
         {
           if(val[j]==false && graph[u][j]!=0 && dist[u] + graph[u][j]<dist[j])
           {
              dist[j]=dist[u] + graph[u][j];
           }
        }   
      }
      return dist;
   }
}