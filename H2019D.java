import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class H2019D {
	
	static long cons = 1000000007;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] dir = sc.readLine().split(" ");
		long n = Long.parseLong(dir[0]);
		long k = Long.parseLong(dir[1]);
		
		long finalans = 1;
		
		
		ArrayList<Long> factors = primeFactors(n);
		
		Map<Long, Long> map = new HashMap<Long, Long>();
		
		for(long f:factors) {
			if(map.get(f) == null) {
				map.put(f,1l);
			}
			else {
				map.put(f, map.get(f) + 1);
			}
		}
		
		long i = 0;
		Iterator<Entry<Long, Long>> it = map.entrySet().iterator();
		while (it.hasNext()) {
		    Entry<Long, Long> pair = it.next();
		    long factor = pair.getKey();
		    long count = pair.getValue();
		    
		    long ans = expected(factor, count, k);
		    finalans *= ans;
		    finalans %= cons;
		}
		
		System.out.print(finalans);
	}
	
	public static long expected(long factor, long count, long k) {
		long[] odds = new long[(int) count+1];
		long[] vals = new long[(int) count+1];
		long mult = 1;
		odds[odds.length - 1] = 1l;
		vals[0] = 1l;
		long sum = 1;
		for(int i=1; i<=count; i++) {
			mult *= (factor)%cons;
			//sum += mult;sum%=cons;
			mult %= cons;
			vals[i] = mult;
			
			//odds[i] = (sum * inv(i+1))%cons;
		}
		
		//System.out.println(Arrays.toString(vals));
		
		for(int j=0; j<k; j++) {
			//System.out.println(Arrays.toString(odds));
			
			long[] newodds = new long[(int) count+1];
			long sumtot = 0;
			for(int oldindex = (int) count; oldindex >= 0; oldindex--) {
				newodds[oldindex] = (odds[oldindex]*inv(oldindex+1))%cons;
				newodds[oldindex] %= cons;
				sumtot += newodds[oldindex];
				sumtot %= cons;
				
				newodds[oldindex] = sumtot;
			}
			for(int index = 0; index<=count; index++) {
				odds[index] = newodds[index];
			}
		}
		
		long ans = 0;
		
		for(int i=0; i<=count; i++) {
			odds[i] *= vals[i];
			odds[i] %= cons;
			
			ans += odds[i];
			ans %= cons;
		}
		
		
		return ans;
	}
	
	public static ArrayList<Long> primeFactors(long n) {
		ArrayList<Long> list = new ArrayList<Long>();
        while (n%2==0) 
        { 
            list.add(2l);
            n /= 2; 
        } 
        for (int i = 3; i <= Math.sqrt(n); i+= 2) 
        { 
            while (n%i == 0) 
            { 
            	list.add((long)i);
                n /= i; 
            } 
        } 
        if (n > 2) 
        	list.add(n);
        
        return list;
    } 
	
	public static long inv(long n) {
		return BigInteger.valueOf(n).modInverse(BigInteger.valueOf(1000000007)).longValue();
	}
}



/* 
BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(sc.readLine());
String[] t = sc.readLine().split(" ");
int[] list = new int[n];
for(int x=0; x<n; x++){
	list[x] = Integer.parseInt(t[x]);
}
		
String[] dir = sc.readLine().split(" ");
int a = Integer.parseInt(dir[0]);
int b = Integer.parseInt(dir[1]);
int c = Integer.parseInt(dir[2]);
int d = Integer.parseInt(dir[3]);
int e = Integer.parseInt(dir[4]);
int n = Integer.parseInt(sc.readLine());
*/
