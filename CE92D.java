import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE92D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			
			long l1 = sc.nextLong();
			long r1 = sc.nextLong();
			long l2 = sc.nextLong();
			long r2 = sc.nextLong();
			
			
			long len1 = r1-l1;
			long len2 = r2-l2;
			if(l1 > l2) {
				long l1t = l1;
				long r1t = r1;
				long l2t = l2;
				long r2t = r2;
				l2 = l1t; r2 = r1t; l1 = l2t; r1 = r2t;
			}
			
			long moves = 0;
			
			// case 1
			if(l2 > r1) {
				if(k <= r2 - l1) {
					out.println(l2-r1+k);
					continue;
				} 
				
				else if(k >= n*(r2 - l1)) {
					k -= n*(r2 - l1);
					moves = n*(2*(r2 - l1) - (len1 + len2));
					long choicea = moves + k*2;
					
					k += n*(r2 - l1);
					k -= (r2 - l1);
					moves = 2*(r2 - l1) - (len1 + len2);
					long choiceb = moves + k*2;
					
					out.println(Math.min(choicea, choiceb));
					
					continue;
				} 
				
				else {
					k -= (r2-l1);
					moves = 2*(r2 - l1) - (len1 + len2);
					long choicea = moves + k*2;
					moves = 0;
					k += (r2-l1);
					
					long quot = k/(r2-l1);
					long rem = k%(r2-l1);
					moves = quot*(2*(r2 - l1) - (len1 + len2)) + (l2-r1+rem);
					long choiceb = moves;
					
					long choicec = quot*(2*(r2 - l1) - (len1 + len2)) + 2*rem;
					
					out.println(Math.min(Math.min(choicea, choiceb),choicec));
					continue;
				}
			}
			
			// case 2
			else {
				long inter = Math.min(r1, r2) - l2;
				long wide = Math.max(r1, r2) - l1;
				
				if(k <= n*inter) {
					out.println(0);
					continue;
				}
				
				else if(k <= n*wide) {
					out.println(k - n*inter);
					continue;
				}
				
				else {
					moves = n*(wide-inter);
					k -= n*wide;
					out.println(moves + 2*k);
					continue;
				}
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
