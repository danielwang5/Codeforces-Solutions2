import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C649B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			
			int sum = 0;
			int len = 0;
			// none = 0; up = 1; down = 2;
			int dir = 0;
			
			int[] arr = new int[n];
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[0] = a; arr[1] = b;
			
			if(n == 2) {
				out.println(2);
				out.println(a + " " + b);
				continue;
			}
			
			boolean[] use = new boolean[n];
			
			if(a==b) {
				use[1] = true;
				len = 1;
			} else {
				use[0] = true;
				len = 1;
				sum += Math.abs(a-b);
				if(a < b) {
					dir = 1;
				} else if (a > b) {
					dir = 2;
				}
			}
			
			int last = b;
			
			for(int i=2; i<n; i++) {
				int next = sc.nextInt();
				arr[i] = next;
				if(last == next) {
					
				} else {
					sum += Math.abs(last - next);
					if(last < next) {
						if (dir == 2) {
							dir = 1;
							len++;
							use[i-1] = true;
						} else if (dir == 0) {
							dir = 1;
						}
					} else {
						if (dir == 1) {
							dir = 2;
							len++;
							use[i-1] = true;
						} else if (dir == 0) {
							dir = 1;
						}
					}
					if(i == n-1) {
						len++;
						use[i] = true;
					}
				}
				if(i == n-1 && !use[i] && len == 1) {
					len++;
					use[i] = true;
				}
				last = next;
				
			}
			
			out.println(len);
			for(int i=0; i<n; i++) {
				if(use[i]) {
					out.print(arr[i]+" ");
				}
			}
			out.println();
			
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
