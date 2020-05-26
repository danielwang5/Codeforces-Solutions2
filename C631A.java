import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class C631A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		
		int t = sc.nextInt();
		
		for(int z=0; z<t; z++) {
	
			int n = sc.nextInt();
			int x = sc.nextInt();
			
			boolean[] b = new boolean[300];
			
			for(int i=0; i<n; i++) {
				int con = sc.nextInt();
				b[con] = true;
			}
			
			int c = 1;
			
			while(true) {
				if (!b[c]) {
					if(x > 0) {
						x--;
					} else {
						break;
					}
				}
				
				c++;
			}
			
			System.out.println(c-1);
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
