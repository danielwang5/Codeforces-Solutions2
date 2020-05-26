import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CE85A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		for(int x=0; x<t; x++) {
			int n = sc.nextInt();
			int aa = 0;
			int bb = 0;
			boolean ans = true;
			
			for(int y=0; y<n; y++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				int aaa = a - aa;
				int bbb = b - bb;
				
				if(aaa < 0) {
					ans = false;
				}
				if(bbb < 0) {
					ans = false;
				}
				if(aaa < bbb) {
					ans = false;
				}
				
				aa = a;
				bb = b;
			}
			
			if(ans) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
	
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in));}
	String next(){while(st==null||!st.hasMoreElements())
	{try{st=new StringTokenizer(br.readLine());}
	catch(IOException e){e.printStackTrace();}}return st.nextToken();}
	int nextInt(){return Integer.parseInt(next());}
	long nextLong(){return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
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
