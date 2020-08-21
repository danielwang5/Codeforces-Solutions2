import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CG10D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			
			char[] ch = sc.next().toCharArray();
			
			char mode = ch[0];
			int cnt = 0;
			ArrayList<Integer> groups = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				if (ch[i] == mode) {
					cnt++;
				} else {
					mode = ch[i];
					groups.add(cnt);
					cnt = 1;
				}
			}
			if(cnt > 0) {
				groups.add(cnt);
			}
			
			if(groups.size() == 1) {
				out.println((n+2)/3);
				continue;
			}
			
			if(groups.size() % 2 == 1) {
				groups.set(0, groups.get(0) + groups.get(groups.size()-1));
				groups.remove(groups.size()-1);
			}
			
			int ans = 0;
			for(int g: groups) {
				ans += g/3;
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
