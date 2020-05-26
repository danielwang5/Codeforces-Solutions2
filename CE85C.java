import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CE85C {
	public static void main(String[] args) throws NumberFormatException, IOException{
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		int n = 0;
		long sum = 0;
		long hp0 = 0;
		long lastdeath = 0;
		long min = 2_000_000_000_000l;
		long a = 0;
		long b = 0;
		
		for(int x=0; x<t; x++) {
			n = sc.nextInt();
			hp0 = sc.nextLong();
			sum = hp0;
			lastdeath = sc.nextLong();
			min = 1_000_000_000_000l;
			
			if(n == 1) {
				out.println(hp0);
				continue;
			} else if(n == 2) {
				a = sc.nextLong();
				b = sc.nextLong();
				
				out.println(hp0 + a - Math.max(Math.min(lastdeath, a), Math.min(b,hp0)));
				continue;
			}
			
			for(int y=1; y<n; y++) {
				a = sc.nextLong();
				b = sc.nextLong();
				
				sum += a;
				if(a < lastdeath) {
					lastdeath = a;
				}
				sum -= lastdeath;
				if(lastdeath < min) {
					min = lastdeath;
				}
				
				lastdeath = b;
			}
			
			if (hp0 < lastdeath) {
				lastdeath = hp0;
			}
			sum -= lastdeath;
			if(lastdeath < min) {
				min = lastdeath;
			}

			sum += min;
			out.println(sum);
			
		}
		
		out.flush();
		
	}
	
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in), 32768);}
	String next() throws IOException{while(st==null||!st.hasMoreElements())
	st=new StringTokenizer(br.readLine());return st.nextToken();}
	int nextInt() throws NumberFormatException, IOException{return Integer.parseInt(next());}
	long nextLong() throws NumberFormatException, IOException{return Long.parseLong(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}
}

/* 
int n = sc.nextInt();

for(int y=0; y<n; y++){
	int x = sc.nextInt();
}

int a = sc.nextInt();
int b = sc.nextInt();
int c = sc.nextInt();
int d = sc.nextInt();
int e = sc.nextInt();
*/
