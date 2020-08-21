import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CE93C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			
			char[] ch = sc.next().toCharArray();
			int[] a = new int[n];
			
			for(int i=0; i<n; i++) {
				a[i] = ch[i] - '0';
			}
			
			HashMap<Integer,Integer> map = new HashMap<>();
			
			map.put(n, 1);
			
			int cum = 0;
			long ans = 0;
			
			for(int i=0; i<n; i++) {
				cum += a[i];
				int ind = cum+(n-1-i);
				if(map.containsKey(ind)) {
					ans += map.get(ind);
					map.put(ind, map.get(ind)+1);
				} else {
					map.put(ind, 1);
				}
			}
			
			out.println(ans);
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
