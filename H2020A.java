import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class H2020A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String[] first = new String[n];
		String[] second = new String[m];
		
		for(int y=0; y<n; y++){
			first[y] = sc.next();
		}
		for(int y=0; y<m; y++){
			second[y] = sc.next();
		}
		int t = sc.nextInt();
		for(int y=0; y<t; y++){
			int year = sc.nextInt();
			year--;
			System.out.println(first[year%n]+second[year%m]);
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
