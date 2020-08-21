import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class C662B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		
		int[] pl = new int[100005];
		int two = 0;
		int four = 0;
		int six = 0;
		int eight = 0;
		
		for(int tt=0; tt<n; tt++) {
			int v = sc.nextInt();
			pl[v]++;
			
			if(pl[v] == 2) {
				two++;
			} else if(pl[v] == 4) {
				two--;
				four++;
			} else if(pl[v] == 6) {
				four--;
				six++;
			} else if(pl[v] == 8) {
				six--;
				eight++;
			}
		}
		
		
		int q = sc.nextInt();
		
		for(int x=0; x<q; x++) {
			String sign = sc.next();
			int v = sc.nextInt();
			if(sign.equals("+")) {
				pl[v]++;
				if(pl[v] == 2) {
					two++;
				} else if(pl[v] == 4) {
					two--;
					four++;
				} else if(pl[v] == 6) {
					four--;
					six++;
				} else if(pl[v] == 8) {
					six--;
					eight++;
				}
				
				
			} else {
				pl[v]--;
				if(pl[v] == 7) {
					eight--;
					six++;
				}
				else if(pl[v] == 5) {
					six--;
					four++;
				} else if(pl[v] == 3) {
					four--;
					two++;
				} else if(pl[v] == 1) {
					two--;
				}
			}
			
			if((four+six+eight)>=1 && (2*two+4*four+6*six+8*eight)>=8) {
				out.println("YES");
			} else {
				out.println("NO");
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
