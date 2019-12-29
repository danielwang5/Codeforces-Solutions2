import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CE66A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int t = Integer.parseInt(sc.readLine());
		
		for(int i=0; i<t; i++) {
			String[] dir = sc.readLine().split(" ");
			long n = Long.parseLong(dir[0]);
			long k = Long.parseLong(dir[1]);
			
			long steps = 0;
			
			while(n > 0) {
				//System.out.println(steps + " " + n);
				
				if(n < k) {
					steps += n;
					n = 0;
				}
				else {
					long remain = n%k;
					n = n/k;
					steps += remain + 1;
				}
				
				
			}
			
			System.out.println(steps);
;		}
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
