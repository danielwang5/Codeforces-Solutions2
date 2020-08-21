import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CE89D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t = sc.nextInt();
		int[] ans = new int[t];
		int[] ans2 = new int[t];
		
		for(int tt=0; tt<t; tt++) {
			int a = sc.nextInt();
			//out.print(a);out.flush();
			int d = smallestDivisor(a);
			if(d == a || d == -1) {
				ans[tt] = -1;
				ans2[tt] = -1;
				continue;
			}
			
			int d2 = a;
			while(d2 % d == 0) {
				d2 /= d;
			}
			
			if(d == -1 || d2 == 1) {
				ans[tt] = -1;
				ans2[tt] = -1;
			} else {
				ans[tt] = d;
				ans2[tt] = d2;
			}
		}
		
		for(int i=0; i<t; i++) {
			out.print(ans[i]+ " ");
		}
		out.println();
		for(int i=0; i<t; i++) {
			out.print(ans2[i]+ " ");
		}
		
		out.flush();
		
		
	}
	
	static int smallestDivisor(int n)  
	{  
	    // if divisible by 2  
	    if (n % 2 == 0)  
	        return 2;
	    
	    if (n % 3 == 0)  
	        return 3; 
	  
	    // iterate from 3 to sqrt(n)  
	    for (int i = 5; i * i <= n; i += 4) {  
	        if (n % i == 0)  
	            return i;
	        i += 2;
	        if (n % i == 0)  
	            return i;
	    }  
	  
	    return -1;  
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
