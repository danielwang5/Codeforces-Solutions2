import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE92C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		
		for(int tt=0; tt<t; tt++) {
			char[] c = sc.next().toCharArray();
			
			int ans = 0;
			
			for(char d='0'; d<='9'; d++) {
				int count = 0;
				for(int i=0; i<c.length; i++) {
					if(c[i] == d) {
						count++;
					}
				}
				if(count > ans) {
					ans = count;
				}
			}
			
			for(char d1='0'; d1<='9'; d1++) {
				for(char d2='0'; d2<='9'; d2++) {
					if(d1 == d2) {
						continue;
					}
					
					int count = 0;
					for(int i=0; i<c.length; i++) {
						if(count%2 == 0 && c[i] == d1) {
							count++;
						} else if(count%2 == 1 && c[i] == d2) {
							count ++;
						}
					}
					if(count%2==1) {
						count--;
					}
					if(count > ans) {
						ans = count;
					}
				}
			}
			
			out.println(c.length - ans);
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
