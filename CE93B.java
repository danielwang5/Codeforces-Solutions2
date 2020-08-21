import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CE93B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			char[] ch = sc.next().toCharArray();
			int len = ch.length;
			
			ArrayList<Integer> a = new ArrayList<>();
			int cum = 0;
			
			for(int x=0; x<len; x++) {
				if(ch[x] == '1') {
					cum++;
				} else {
					if(cum > 0) {
						a.add(cum);
						cum = 0;
					}
				}
			}
			if(cum > 0) {
				a.add(cum);
			}
			
			Collections.sort(a, Collections.reverseOrder());
			
			int ans = 0;
			for(int i=0; i<a.size(); i+=2) {
				ans += a.get(i);
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
