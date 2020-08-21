import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE90E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			// little endian
			
			int[] d = new int[18];
			
			
			int start = 1;
			int cons = ((k)*(k+1))/2;
			while(cons < n) {
				start++;
				cons += k;
			}
			
			if(cons == n) {
				// make min with start
			}else {
				cons -= 9;
				
			}
			
		}
		
		out.flush();
	}
	
	static int csum(int[] d, int k) {
		int sum = 0;
		int[] dd = d.clone();
		for(int x=0; x<=k; x++) {
			sum += digitsum(dd);
			
			for(int p=0; p<18; p++) {
				dd[p] = (dd[p]+1)%10;
				if(dd[p] != 0) {
					break;
				}
			}
		}
		
		return sum;
	}
	
	static int digitsum(int[] d) {
		int sum = 0;
		for(int dd:d) {
			sum += dd;
		}
		return sum;
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
