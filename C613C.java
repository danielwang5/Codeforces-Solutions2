import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner; 
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class C613C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		
		HashMap<Long, Long> map = new HashMap<>();
		ArrayList<Long> factors = new ArrayList<Long>();
	
		long n = sc.nextLong();
		
		// Print the number of 2s that divide n 
        while (n%2==0) 
        { 
            if (map.containsKey(2l)) {
            	map.put(2l, map.get(2l)*2);
            } else {
            	factors.add(2l);
            	map.put(2l, 2l);
            }
            n /= 2; 
        } 
  
        // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
        for (long i = 3; i <= Math.sqrt(n); i+= 2) 
        { 
            // While i divides n, print i and divide n 
            while (n%i == 0) 
            { 
            	n /= i;
            	if (map.containsKey(i)) {
                	map.put(i, map.get(i)*i);
                } else {
                	factors.add(i);
                	map.put(i, i);
                }
            } 
        }
        

  
        // This condition is to handle the case whien 
        // n is a prime number greater than 2 
        if (n > 2) 
        	factors.add(n);
    		map.put(n, n);
    		
    	Arrays.toString(map.entrySet().toArray());
        
        long ans = 999999999999999l;
        long best1 = 0l;
        long best2 = 0l;
        
        for (long i=0; i<Math.pow(2, factors.size()); i++) {
        	long n1 = 1;
        	long n2 = 1;
        	long bit = 1;
        	for (int x=0; x<factors.size(); x++) {
        		if((i & bit) > 0) {
        			n1 *= map.get(factors.get(x));
        		} else {
        			n2 *= map.get(factors.get(x));
        		}
        		bit *= 2;
        	}
        	if (Math.max(n1, n2) < ans) {
        		ans = Math.max(n1, n2);
        		best1 = n1;
        		best2 = n2;
        	}
        }
        
        System.out.print(best1 + " " + best2);
		
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
