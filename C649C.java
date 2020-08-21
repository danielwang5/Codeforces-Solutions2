import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C649C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		int last = 0;
		
		for(int i=0; i<n; i++) {
			if(a[i] > i+1 || last > a[i]) {
				out.print(-1);
				out.flush();
				return;
			}
			last = a[i];
		}
		
//		int[] next = new int[n];
//		int[] nextind = new int[n];
		
		boolean[] used = new boolean[200000];
		ArrayList<Integer> imp = new ArrayList<Integer>();
		ArrayList<Integer> impi = new ArrayList<Integer>();
		
		
		int min = -1;
		
		for(int i=0; i<n; i++) {
			if(min < a[i]) {
				min = a[i];
				imp.add(a[i]);
				impi.add(i);
				used[a[i]] = true;
			}
			
//			next[i] = val;
//			nextind[i] = ni;
			
		}
		
		int gap = 0;
		int impind = 0;
		
		for(int i=0; i<n; i++) {
			if(impind < imp.size() && a[i] != imp.get(impind)) {
				used[imp.get(impind)] = true;
				out.print(imp.get(impind) + " ");
				impind++;
			} else {
				while(used[gap]) {
					gap++;
				}
				out.print(gap+" ");
				gap++;
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
