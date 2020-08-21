import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C648C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();

		HashMap<Integer, Integer> p1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> p2 = new HashMap<Integer, Integer>();
		
		for(int i=0; i<n; i++) {
			p1.put(sc.nextInt(), i);
		}
		
		for(int i=0; i<n; i++) {
			p2.put(sc.nextInt(), i);
		}
		
		int max = 0;
		HashMap<Integer, Integer> shift = new HashMap<Integer, Integer>();
		
		for(int i=1; i<=n; i++) {
			int x1 = p1.get(i);
			int x2 = p2.get(i);
			int s = x2 - x1;
			if(s < 0) {
				s+=n;
			}
			if(!shift.containsKey(s)) {
				shift.put(s, 0);
			}
			int nxt = shift.get(s)+1;
			if(max < nxt) {
				max = nxt;
			}
			shift.put(s, nxt);
		}
		
		out.print(max);
		
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
