import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CE84B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
	
		int t = sc.nextInt();
		for(int x=0; x<t; x++) {
			int n = sc.nextInt();
			int c = 0;
			
			boolean[] princess = new boolean[n];
			boolean[] prince = new boolean[n];
			for(int y=0; y<n; y++) {
				int len = sc.nextInt();
				//int[] list = new int[len];
				for(int j=0; j<len; j++) {
					int kingdom = sc.nextInt()-1;
					if(!princess[y] && !prince[kingdom]) {
						prince[kingdom] = true;
						princess[y] = true;
						c++;
					}
					//list[j] = sc.nextInt();
				}
				
				
			}
			
			if (c >= n) {
				System.out.println("OPTIMAL");
			} else {
				System.out.println("IMPROVE");
				int p1 = 0,p2=0;
				for(int z=0; z<n; z++) {
					if(!princess[z]) {
						p1 = z+1;
						break;
					}
				}
				for(int z=0; z<n; z++) {
					if(!prince[z]) {
						p2 = z+1;
						break;
					}
				}
//				System.out.println(Arrays.toString(princess));
//				System.out.println(Arrays.toString(prince));
				System.out.println(p1+" "+p2);
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
