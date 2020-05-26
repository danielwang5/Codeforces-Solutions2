import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class C613B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		for(int p=0; p<t; p++) {
			int n = sc.nextInt();
			long sum = 0;
			long min = 9999999999999999l;
			int mindex = 0;
			long max = -9999999999999999l;
			for(int x=0; x<n; x++) {
				long num = sc.nextLong();
				if (sum <= min) {
					min = sum;
					mindex = x;
				}
				sum += num;
				if (sum - min > max) {
					if (!(mindex == 0 && x == n-1))
						max = sum - min;
				}
			}
			//System.out.println(sum + " " + max);
			if(sum > max) {
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
