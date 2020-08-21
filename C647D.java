import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class C647D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
		for(int x=0; x<n; x++) {
			HashSet<Integer> set = new HashSet<Integer>();
			list.add(set);
		}
		for(int x=0; x<m; x++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list.get(a-1).add(b-1);
			list.get(b-1).add(a-1);
		}
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		
		int max = 0;
		int[] assn = new int[n];
		
		for(int x=0; x<n; x++) {
			int top = sc.nextInt();
			if(top > max) {
				max = top;
			}
			if(!map.containsKey(top-1)) {
				map.put(top-1, new ArrayList<Integer>());
			}
			map.get(top-1).add(x);
			
			assn[x] = top-1;
		}
		
		int[] ans = new int[n];
		for(int x=0; x<n; x++) {
			ans[x] = -1;
		}
		int ind = 0;
		
		//out.println(map);
		
		outerloop:
		for(int top = 0; top<max; top++) {
			if(!map.containsKey(top)){
				out.print(-1);
				out.flush();
				return;
			}
			for(int node : map.get(top)) {
				
				boolean[] seen = new boolean[top];
				
				int seencount = 0;
				if(list.get(node).size() < top) {
					//out.println("aaa "+top);
					
					out.print(-1);
					out.flush();
					return;
				}
				
				if(list.get(node).size() == 0) {
					
					ans[ind] = node+1;
					ind++;
					continue;
				}
				
				for(int next : list.get(node)) {
					//out.println(node+" "+next);
					
					int topnxt = assn[next];
					
					if(topnxt == top) {
						out.print(-1);
						out.flush();
						return;
					}
					
					if (topnxt < top) {
						if(!seen[topnxt]) {
							seen[topnxt] = true;
							seencount++;
						}
					}
					
					
				}
				
				if(seencount < top) {
					//out.println(map);
					//out.println("bbb "+seencount + " " + top);
					//out.println(list);
					out.print(-1);
					out.flush();
					return;
				}
				
				ans[ind] = node+1;
				ind++;
			}
		}
		
		for(int x=0; x<n; x++) {
			out.print(ans[x]);
			out.print(" ");
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
