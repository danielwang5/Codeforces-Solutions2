import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class C649D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		Graphh<Integer> g = new Graphh<Integer>();
		
		for(int i=0; i<m; i++) {
			g.addEdge(sc.nextInt(), sc.nextInt());
		}
		
		Stack<Integer> st = new Stack<Integer>();
		boolean seen[] = new boolean[n+1];
		boolean curr[] = new boolean[n+1];
		
		int[] it = new int[n+1];
		
		st.push(1);
		seen[1] = true;
		curr[1] = true;
		
		while(st.size() > 0) {
			int top = st.peek();
			List<Integer> adj = g.getAdjacent(top);
			if(it[top] < adj.size()) {
				int next = adj.get(it[top]);
				if(curr[next] && (st.size() > 2 && next != st.get(st.size() - 2))) { // cycle
					ArrayList<Integer> cycle = new ArrayList<Integer>();
					cycle.add(next);
					while(st.peek() != next) {
						cycle.add(st.pop());
					}
//					out.print(cycle);
//					out.flush();
//					return;
					
					if(cycle.size() <= k) {
						out.println(2);
						for(int c: cycle) {
							out.print(c + " ");
						}
						out.flush();
						return;
					} else {
						int cnt = (k+1)/2;
						out.println(1);
						for(int i=0; i<2*cnt; i+=2) {
							out.print(cycle.get(i) + " ");
						}
						out.flush();
						return;
					}
				}
				st.push(next);
				seen[next] = true;
				curr[next] = true;
				it[top]++;
			}
		}
		
		
		out.flush();
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

class Graphh<T> { 
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
