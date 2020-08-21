import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C654E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		int[] a = new int[n];
		
		for(int x=0; x<n; x++) {
			a[x] = sc.nextInt();
		}
		
		Arrays.sort(a);
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
	
		for(int x=a[0]; x<=2000; x++) {
			//out.println(x);out.flush();
			int i = 0;
			int add = 0;
			boolean res = true;
			while(true) {
				while(i < n && a[i] <= x+add) {
					i++;
				}
				if ((i-add)%p == 0 || (i-add)>p) {
					res = false;
					break;
				}
				add++;
				if(add >= n) {
					break;
				}
			}
			if(res) {
				ans.add(x);
			}
		}
		
		out.println(ans.size());
		for(int i:ans) {
			out.print(i);
			out.print(" ");
		}
		out.println();
		
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
