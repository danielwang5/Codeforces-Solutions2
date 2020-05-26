import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C633E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			
			long p = sc.nextLong();
			long n = (p-1)/3;
			long m = (p-1)%3;
			
			long nn = n;
			long pow = 1;
			while(true) {
				if(nn < pow) {
					break;
				} else {
					nn -= pow;
				}
				pow *= 4;
			}
			
			long first = nn + pow;
			//out.println("first "+ first);
			
			if(m == 0) {
				out.println(first);
			} else {
				ArrayList<Long> digits = new ArrayList<Long>();
				long f = first;
				
				while(f > 0) {
					long mod = f % 4;
					f -= mod;
					digits.add(mod);
					f /= 4;
					
				}
				
				//out.println(digits);
				
				for(int x=0; x<digits.size(); x++) {
					long dig = digits.get(x);
					if(dig == 1) {
						digits.set(x, 2l);
					} else if(dig == 2) {
						digits.set(x, 3l);
					} else if (dig == 3) {
						digits.set(x, 1l);
					}
				}
				
				//out.println(digits);
				
				long second = 0;
				long mult = 1;
				for(int x=0; x<digits.size()-1; x++) {
					second += (mult * digits.get(x));
					mult *= 4;
				}
				
				second += 2*pow;
				
				if(m == 1) {
					out.println(second);
				} else {
					out.println(first^second);
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
