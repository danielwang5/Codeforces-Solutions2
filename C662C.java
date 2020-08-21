import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C662C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			HashMap<Integer,Integer> cnt = new HashMap<>();
			long max = 0;
			int c=0;
			for(int x=0; x<n; x++) {
				int v = sc.nextInt();
				if(cnt.containsKey(v)) {
					cnt.put(v,cnt.get(v)+1);
				} else {
					cnt.put(v, 1);
				}
				
				if(cnt.get(v) > max) {
					max = cnt.get(v);
					c = 1;
				} else if(cnt.get(v) == max){
					c++;
				}
			}
			//out.println(cnt);
			long dist = n-1;
			while(dist >= 0) {
				if(c+dist*(max-1) <= n) {
					out.println(dist-1);
					break;
				}
				dist--;
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
