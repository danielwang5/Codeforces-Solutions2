import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class C665D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			Graph<Long> g = new Graph<Long>();
			int n = sc.nextInt();
			
			for(int i=1; i<=n; i++) {
				g.addVertex(i-1,1l);
			}
			
			for(int i=1; i<n; i++) {
				g.addEdge(sc.nextInt()-1, sc.nextInt()-1);
			}
			
			Queue<Integer> q = new LinkedList<>();
			boolean[] seen = new boolean[n];
			
			Queue<Integer> leaves = new LinkedList<>();
			int[] children = new int[n];
			
			q.add(0);
			seen[0] = true;
			while (!q.isEmpty()) {
				int next = q.poll();
				List<Integer> adj = g.getAdjacent(next);
				boolean leaf = true;
				for(int a: adj) {
					if (!seen[a]) {
						children[next]++;
						seen[a] = true;
						leaf = false;
						q.add(a);
					}
				}
				if(leaf) {
					leaves.add(next);
				}
			}
			
			//out.println("leaf " + leaves);
			//out.flush();
			
			ArrayList<Long> counts = new ArrayList<>();
			
			seen = new boolean[n];
			for(int l: leaves) {
				seen[l] = true;
			}
			
			while(!leaves.isEmpty()) {
				int next = leaves.poll();
				List<Integer> adj = g.getAdjacent(next);
				long sum = 1;
				for(int a: adj) {
					
					if (!seen[a]) {
						children[a]--;
						if(children[a] == 0) {
							seen[a] = true;
							leaves.add(a);
						}
					} else {
						//out.println(next + " " + a);out.flush();
						sum += g.getVal(a);
					}
				}
				g.setVal(next, sum);
				counts.add(sum);
			}
			
			
			counts.remove(counts.size()-1);
			
			for(int i=0; i<n-1; i++) {
				long v = counts.get(i);
				counts.set(i, v*(n-v));
			}
			
			//out.println(counts);
			Collections.sort(counts,Collections.reverseOrder());
			
			
			ArrayList<Long> primes = new ArrayList<>();
			int p = sc.nextInt();
			for(int i=0; i<p; i++) {
				primes.add(sc.nextLong());
			}
			//out.println("primes: " + primes);
			Collections.sort(primes, Collections.reverseOrder());
			
			int extra = primes.size() - counts.size() + 1;
			
			long mod = 1_000_000_007;
			long ans = 0;
			
			//out.println(extra+"e");
			
			if(extra <= 0) {
				for(int i=0; i<primes.size(); i++) {
					ans += primes.get(i)*counts.get(i);
					ans %= mod;
				}
				for(int i=primes.size(); i<counts.size(); i++) {
					ans += counts.get(i);
					ans %= mod;
				}
			} else {
				long pp = 1;
				for(int i=0; i<extra; i++) {
					pp *= primes.get(i);
					pp %= mod;
				}
				ans += pp*counts.get(0);
				ans %= mod;
				for(int i=1; i<counts.size(); i++) {
					ans += primes.get(i-1+extra)*counts.get(i);
					ans %= mod;
				}
			}
			
			out.println(ans);
		}
		
		
		
		out.flush();
	}
	
	static class Graph<T> { 
	    public Map<Integer, List<Integer>> map = new HashMap<>(); 
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
	    
	    public void setVal(int s, T val) {
	    	vals.put(s, val);
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
