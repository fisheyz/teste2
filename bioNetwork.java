import java.util.*;
import java.io.*;

class Graph{
  int n;
  Node nodes[];
  int d, r;

  Graph(int n){
    this.n = n;
    this.d = 0;
    this.r = 1500;
    nodes = new Node[n+1];
    for (int i=1; i<=n; i++)
      nodes[i]=new Node();
  }
  public void addLink(int a, int b){
    nodes[a].adj.add(b);
    nodes[b].adj.add(a);
  }
  public void bfs(int v){
    LinkedList<Integer> q = new LinkedList<Integer>();
    q.add(v);
    nodes[v].visited=true;
    nodes[v].distance=0;
    int u = 0;
    while ( q.size() > 0){
        u=q.removeFirst();
        for (int w : nodes[u].adj)
          if (!nodes[w].visited){
            q.add(w);
            nodes[w].visited = true;
            nodes[w].distance = nodes[u].distance +1;
          }
        }
      int val = nodes[u].distance;
      if (val>d)
        d=val;
      if (val<r)
        r=val;
      nodes[v].exc = val;
      }
}

class Node{
  public LinkedList<Integer> adj;
  public boolean visited;
  public int distance, exc;

  Node(){
    adj=new LinkedList<Integer>();
    visited= false;
    distance = -1;
    exc = 0;
  }


}
public class bioNetwork{
  static int edges, n, d, k, h, r;
  public static void main(String args[]){
      Scanner in = new Scanner(System.in);
      n = in.nextInt();
      Graph g = new Graph(n);
      edges = in.nextInt();
      d=0;
      r=n;
      for (int i=0; i<edges ; i++)
        g.addLink(in.nextInt(), in.nextInt());

      for (int i=1; i <= n; i++){
          g.bfs(i);
          for(int j=1; j <=n; j++)
            g.nodes[j].visited = false;
      }
      System.out.println(g.d);
      System.out.println(g.r);
      for(int i=1; i<=n; i++)
        if (g.nodes[i].exc == g.r){
          if (h==1)
            System.out.print(" ");
          h=1;
          System.out.print(i);
        }
        System.out.println();
        for (int j=1; j<=n; j++)
          if (g.nodes[j].exc == g.d){
            if (k==1)
              System.out.print(" ");
            k=1;
            System.out.print(j);
          }
          System.out.println();
  }
}
