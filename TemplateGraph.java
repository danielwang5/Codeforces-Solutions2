import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TemplateGraph {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Graph<Integer> g = new Graph<Integer>();
		
		g.addVertex(0, 3);
		g.addVertex(1, 4);
		g.addVertex(2, 5);
		g.addVertex(3, 6);
		g.addVertex(4, 7);
		
		g.addEdge(0, 1); 
        g.addEdge(1, 2); 
        g.addEdge(0, 3); 
        g.addEdge(3, 4);
        
        BFS(g, 0, 5);
	}
	
	// for normal graphs
	static void BFS(Graph<Integer> g, int root, int num_nodes) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] seen = new boolean[num_nodes];
		
		q.add(root);
		seen[root] = true;
		while (!q.isEmpty()) {
			int next = q.poll();
			List<Integer> adj = g.getAdjacent(next);
			for(int a: adj) {
				if (!seen[a]) {
					seen[a] = true;
					System.out.println(a);
					q.add(a);
				}
			}
		}
	}
	
	// for them trees
	static void DFS(Graph<Integer> g, int root, int num_nodes) {
		Stack<Integer> st = new Stack<>();
		boolean[] seen = new boolean[num_nodes];
		
		st.add(root);
		seen[root] = true;
		
		while (!st.isEmpty()) {
			int next = st.pop();
			System.out.println(next);
			
			List<Integer> adj = g.getAdjacent(next);
			for(int a: adj) {
				if (!seen[a]) {
					seen[a] = true;
					st.add(a);
				}
			}
		}
	}
}

class Graph<T> { 
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
