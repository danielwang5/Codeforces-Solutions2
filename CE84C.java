import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CE84C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		System.out.println((n-1)+(m-1)+(n*m-1));
		
		for(int x=0; x<n-1; x++) {
			System.out.print("D");
		}
		for(int y=0; y<m-1; y++) {
			System.out.print("L");
		}
		
		for(int y=0; y<=m-1; y++) {
			if(y%2==0) {
				for(int x=0; x<n-1; x++) {
					System.out.print("U");
				}
			} else {
				for(int x=0; x<n-1; x++) {
					System.out.print("D");
				}
			}
			if(y!=m-1) {
				System.out.print("R");
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
