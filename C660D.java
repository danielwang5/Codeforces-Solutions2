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
import java.util.PriorityQueue;

public class C660D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		
		long[] a = new long[n];
		int[] b = new int[n];
		
		int[] child = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			b[i] = sc.nextInt() - 1;
			
			if(b[i] != -2) {
				child[b[i]]++;
			}
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int x=0; x<n; x++) {
			if(child[x] == 0) {
				q.add(x);
			}
		}
		
		long sum = 0;
		
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> last = new ArrayList<>();
		
		while(q.size() > 0) {
			int i = q.poll();
			sum = sum + a[i];
			if(b[i] > -2) {
				child[b[i]]--;
				if(a[i] > 0) {
					a[b[i]] += a[i];
					first.add(i);
				} else {
					last.add(i);
				}
				if(child[b[i]] <= 0) {
					q.add(b[i]);
				}
				
			} else {
				first.add(i);
			}
		}
		
		out.println(sum);
		
		for(int i: first) {
			out.print((i+1)+" ");
		}
		Collections.reverse(last);
		for(int i: last) {
			out.print((i+1)+" ");
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
