import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C645D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		long x = sc.nextLong();
		
		long[] d = new long[n];
		
		//out.println(seqsum(1000000,456));
		
		long m1 = 1;
		long d1 = 1;
		long m2 = 1;
		long cnt = 0;
		long sum = 0;
		long ans = 0;
		
		long starti = 0;
		
		for(int y=0; y<n; y++) {
			d[y] = sc.nextLong();
		}
		
		// start config
		
		while(cnt < x) {
			long l = d[(int) (m2-1)];
			sum += seqsum(1,l);
			cnt += l;
			m2 += 1;
		}
		m2 -= 1;
		starti = m2;
		
		long extra = cnt - x;
		//out.println(extra);
		
		while(extra > 0) {
			long l = d[(int) (m1-1)];
			if(extra >= l) {
				sum -= seqsum(1,l);
				extra -= l;
				m1++;

			} else {
				d1 = extra + 1;
				sum -= seqsum(1,d1-1);
				extra = 0;
			}
		}
		
		//out.println(m1+" " +d1+" "+m2+" "+sum);
		
		ans = sum;
		
		m2++;
		if(m2 > n) {
			m2 = 1;
		}
		
		while(starti != m2) {
			long l = d[(int) (m2-1)];
			sum += seqsum(1,l);
			
			extra = l;
			while(extra > 0) {
				long ll = d[(int) (m1-1)];
				if (ll - d1 + 1 <= extra) {
					sum -= seqsum(d1,ll);
					//out.println(sum);
					extra -= ll - d1 + 1;
					m1++;
					if(m1 > n) {
						m1 = 1;
					}
					d1 = 1;
				} else {
					sum -= seqsum(d1, d1+extra-1);
					//out.println(sum);
					d1 += extra;
					extra = 0;
				}
			}
			
			//out.println(m1+" " +d1+" "+m2+" "+sum);
			if (sum > ans) {
				ans = sum;
			}
			
			m2++;
			if(m2 > n) {
				m2 = 1;
			}
			
		}
		
		out.print(ans);
		
		
		out.flush();
	}
	
	public static long seqsum(long start, long end) {
		return (start+end)*(end-start+1)/2l;
		
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
