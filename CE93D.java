import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CE93D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int rr = sc.nextInt();
		int gg = sc.nextInt();
		int bb = sc.nextInt();
		
		
		ArrayList<Integer> r = new ArrayList<Integer>();
		ArrayList<Integer> g = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		
		for(int i=0; i<rr; i++) {
			r.add(sc.nextInt());
		}
		for(int i=0; i<gg; i++) {
			g.add(sc.nextInt());
		}
		for(int i=0; i<bb; i++) {
			b.add(sc.nextInt());
		}
		
		Collections.sort(r, Collections.reverseOrder());
		Collections.sort(g, Collections.reverseOrder());
		Collections.sort(b, Collections.reverseOrder());
		
		long ans = 0;
		
		long dp[][][] = new long[rr+1][gg+1][bb+1];
		dp[0][0][0] = 0;
		
		for(int sum=2; sum <= rr+gg+bb; sum+=2) {
			for(int rq=0; rq<=Math.min(rr, sum); rq++) {
				for(int gq=0; gq<=Math.min(gg, sum-rq); gq++) {
					//out.print("Hi");out.flush();
					int bq = sum-rq-gq;
					if(bq > bb || bq < 0) {
						continue;
					}
					if(rq>0 && gq>0) {
						long next = dp[rq-1][gq-1][bq] + (r.get(rq-1)*g.get(gq-1));
						if(next > dp[rq][gq][bq]) {
							dp[rq][gq][bq] = next;
							if(next > ans) {
								ans = next;
							}
						}
					}
					if(rq>0 && bq>0) {
						long next = dp[rq-1][gq][bq-1] + (r.get(rq-1)*b.get(bq-1));
						if(next > dp[rq][gq][bq]) {
							dp[rq][gq][bq] = next;
							if(next > ans) {
								ans = next;
							}
						}
					}
					if(bq>0 && gq>0) {
						long next = dp[rq][gq-1][bq-1] + (b.get(bq-1)*g.get(gq-1));
						if(next > dp[rq][gq][bq]) {
							dp[rq][gq][bq] = next;
							if(next > ans) {
								ans = next;
							}
						}
					}
				}
			}
		}
		
		//out.println(Arrays.deepToString(dp));
		out.println(ans);
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
