import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CE66D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] dir = sc.readLine().split(" ");
		int n = Integer.parseInt(dir[0]);
		long k = Long.parseLong(dir[1]);
		
		String[] t = sc.readLine().split(" ");
		long[] list = new long[n];
		for(int x=0; x<n; x++){
			list[x] = Long.parseLong(t[x]);
		}
		
		long[] cumsum = new long[n];
		
		cumsum[n-1] = list[n-1];
		
		for(int x = n-2; x>=0; x--) {
			cumsum[x] = cumsum[x+1] + list[x];
		}
		
		Arrays.sort(cumsum,1,n);
		
		//System.out.println(Arrays.toString(cumsum));
		
		long ans = cumsum[0];
		
		for(int x = n-1; x>n-k; x--) {
			ans += cumsum[x];
		}
		
		System.out.print(ans);
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
