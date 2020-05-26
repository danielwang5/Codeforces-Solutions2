import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE86C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int q = sc.nextInt();
			
			long cnt = 0;
			boolean[] p = new boolean[a*b];
			for(int v=0; v<a*b; v++) {
				if((v%a)%b != (v%b)%a) {
					p[v] = true;
					cnt++;
				}
			}
			
			//out.println(cnt);
			
			
			
			for(int x=0; x<q; x++) {
				long ans = 0;
				long l = sc.nextLong();
				long r = sc.nextLong();
				
				if(r-l < a*b+2) {
					for(long v=l; v<=r; v++) {
						if (p[(int) (v%(a*b))]) {
							ans++;
						}
					}
				} else {
					
					int ll = (int) (l%(a*b));
					int rr = (int) (r%(a*b));
					
					int rtimes = 0;
					int ltimes = 0;
				
					while(ll > 0 && ll < a*b) {
						//out.println(ll);
						if (p[ll]) {
							ans++;
						}
						ll++;
						ltimes++;
					}
					while(rr >= 0) {
						//out.println(rr);
						if (p[rr]) {
							ans++;
						}
						rr--;
						rtimes++;
					}
					
					//out.println(ltimes + " gg " + rtimes);
					
					long times = (r-rtimes-ltimes+1-l)/(a*b);
					ans += times*cnt;
				}
				
				out.print(ans + " ");
			}
			out.println();
		}
		
		out.flush();
	}
	
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in));}
	String next(){while(st==null||!st.hasMoreElements())
	{try{st=new StringTokenizer(br.readLine());}
	catch(IOException e){e.printStackTrace();}}return st.nextToken();}
	int nextInt(){return Integer.parseInt(next());}
	long nextLong(){return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}
}
