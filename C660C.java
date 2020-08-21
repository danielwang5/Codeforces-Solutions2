import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class C660C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		testloop:
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			Graph<Integer> g = new Graph<Integer>();
			
			long[] cit = new long[n];
			long[] hap = new long[n];
			int[] children = new int[n];
			
			for(int i=0; i<n; i++) {
				cit[i] = sc.nextLong();
			}
			for(int i=0; i<n; i++) {
				hap[i] = sc.nextLong();
			}
			
			for(int i=0; i<n-1; i++) {
				int pa = sc.nextInt();
				int pb = sc.nextInt();
				
				g.addEdge(pa-1, pb-1);
			}
			
			int[] parent = new int[n];
			
			//BFS
			Queue<Integer> q = new LinkedList<>();
			boolean[] seen = new boolean[n];
			
			Queue<Integer> qq = new LinkedList<>();
			
			if(n > 1) {
				q.add(0);
				seen[0] = true;
				while (!q.isEmpty()) {
					int next = q.poll();
					boolean leaf = true;
					List<Integer> adj = g.getAdjacent(next);
					for(int a: adj) {
						if (!seen[a]) {
							seen[a] = true;
							leaf = false;
							parent[a] = next;
							children[next]++;
							q.add(a);
						}
					}
					if(leaf) {
						qq.add(next);
					}
				}
			}
			
			else {
				qq.add(0);
			}
			
			//out.println(Arrays.toString(parent));
			long[] numhappy = new long[n];
			
			
			while(!qq.isEmpty()) {
				//out.println(qq);
				//out.flush();
				int i = qq.poll();
				if(cit[i] % 2 != Math.abs(hap[i] % 2)) {
					out.println("NO");
					continue testloop;
				}
				if(cit[i] < Math.abs(hap[i])) {
					out.println("NO");
					continue testloop;
				}
				
				long thishap = hap[i] + (cit[i]-hap[i])/2;
				//long thissad = cit[i] - thishap;
				
				if(numhappy[i] > thishap) {
					out.println("NO");
					continue testloop;
				}
				
				if(i != 0) {
					int next = parent[i];
					numhappy[next] += thishap;
					cit[next] += cit[i];
					children[next]--;
					
					if(children[next] <= 0) {
						qq.add(next);
					}
				}
				
			}
			
			out.println("YES");
		}
		
		out.flush();
	}
	
	static class Graph<T> { 
	    public Map<Integer, List<Integer> > map = new HashMap<>(); 
	    public Map<Integer, T> vals = new HashMap<>(); 
	  
	    public void addVertex(int s) { 
	        map.put(s, new LinkedList<Integer>()); 
	    }
	    
	    public void addVertex(int s, T val) { 
	        map.put(s, new LinkedList<Integer>()); 
	        vals.put(s, val);
	    }
	    
	    public T getVal(int s) {
	    	return vals.get(s);
	    }
	    
	    public void addEdge(int source, int destination) {
	    	addEdge(source, destination, true);
	    }
	  
	    public void addEdge(int source, int destination, boolean bidirectional) {
	        if (!map.containsKey(source)) 
	            addVertex(source); 
	  
	        if (!map.containsKey(destination)) 
	            addVertex(destination); 
	  
	        map.get(source).add(destination); 
	        if (bidirectional == true) { 
	            map.get(destination).add(source); 
	        } 
	    } 
	  
	    // This function gives the count of vertices 
	    public void getVertexCount() 
	    { 
	        System.out.println("The graph has "
	                           + map.keySet().size() 
	                           + " vertex"); 
	    } 
	  
	    // This function gives the count of edges 
	    public int getEdgesCount(boolean bidirection) 
	    { 
	        int count = 0; 
	        for (int v : map.keySet()) { 
	            count += map.get(v).size(); 
	        } 
	        if (bidirection == true) { 
	            count = count / 2; 
	        } 
	        return count;
	    } 
	  
	    // This function gives whether 
	    // a vertex is present or not. 
	    public boolean hasVertex(T s) 
	    { 
	        return map.containsKey(s);
	    } 
	  
	    // This function gives whether an edge is present or not. 
	    public boolean hasEdge(T s, T d) 
	    { 
	        return map.get(s).contains(d);
	    } 
	    
	    public List<Integer> getAdjacent(int s){
	    	return map.get(s);
	    }
	  
	    // Prints the adjacency list of each vertex. 
	    @Override
	    public String toString() 
	    { 
	        StringBuilder builder = new StringBuilder(); 
	  
	        for (int v : map.keySet()) { 
	            builder.append(v + ": "); 
	            for (int w : map.get(v)) { 
	                builder.append(w + " "); 
	            } 
	            builder.append("\n"); 
	        } 
	  
	        return (builder.toString()); 
	    } 
	} 
	
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in), 32768);}
	String next(){while(st==null||!st.hasMoreElements())
	{try{st=new StringTokenizer(br.readLine());}
	catch(IOException e){e.printStackTrace();}}return st.nextToken();}
	int nextInt(){return Integer.parseInt(next());}
	long nextLong(){return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}
}
