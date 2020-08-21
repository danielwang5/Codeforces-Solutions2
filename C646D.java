import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C646D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int[] sets = new int[n];
			Arrays.fill(sets, -1);
			
			for(int i=0; i<k; i++) {
				int c = sc.nextInt();
				for(int x=0; x<c; x++) {
					int num = sc.nextInt();
					sets[num-1] = i;
				}
			}
			
			out.print("? ");
			out.print(n);
			for(int i=1; i<=n; i++) {
				out.print(" ");
				out.print(i);
			}
			out.println();
			out.flush();
			int max = sc.nextInt();
			
			
			int left = 1;
			int right = n;
			
			while (left != right) {
				int middle = (left+right)/2;
				out.print("? ");
				out.print(middle - left + 1);
				for(int i=left; i<=middle; i++) {
					out.print(" ");
					out.print(i);
				}
				out.println();
				out.flush();
				int mx = sc.nextInt();
				
				if(mx == max) {
					right = middle;
				} else {
					left = middle + 1;
				}
					
			}
			
			int ind = left;
			int set = sets[ind-1];
			
			if(set == -1) {
				out.print("!");
				for(int x=0; x<k; x++) {
					out.print(" ");
					out.print(max);
				}
				
				out.println();
				out.flush();
			} else {
				
				int cnt = 0;
				for(int i=0; i<n; i++) {
					if(sets[i] != set) {
						cnt++;
					}
				}
				out.print("? ");
				out.print(cnt);
				
				for(int i=0; i<n; i++) {
					if(sets[i] != set) {
						out.print(" ");
						out.print(i+1);
					}
				}
				out.println();
				out.flush();
				
				int other = sc.nextInt();
				
				out.print("!");
				for(int x=0; x<k; x++) {
					out.print(" ");
					if(x == set) {
						out.print(other);
					} else {
						out.print(max);
					}
				}
				
				out.println();
				out.flush();
			}
			String res = sc.next();
			if(res.equals("Incorrect")) {
				return;
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
