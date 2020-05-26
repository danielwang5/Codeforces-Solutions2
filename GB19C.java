import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GB19C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(sc.readLine());
		for(int x=0; x<n; x++) {
			int l = Integer.parseInt(sc.readLine());
			
			String[] t = sc.readLine().split(" ");
			long sum = 0;
			long xor = 0;
			for(int y=0; y<l; y++) {
				long num = Long.parseLong(t[y]);
				sum += num;
				xor ^= num;
			}
			
			if(sum == 2*xor) {
				System.out.println(0);
				System.out.println();
				continue;
			}
			
			//int[] ans = new int[60];
			//int ansind = 0;
			
			long ans = 0;
			
			if(sum%2 == 1) {
				ans += 1;
				sum += 1;
				xor ^= 1;
			}
			
			int limit = 50;
			
			long bit = 1;
			while (bit*2 <= sum && limit > 0) {
				limit--;
				
				int xorbit = ((xor&(bit)) > 0) ? 1 : 0;
				int sumbit = ((sum&(bit*2)) > 0) ? 1 : 0;
				if (xorbit == sumbit) {
					
				} else {
					ans += bit*2;
					sum += bit*2;
					xor ^= bit*2;
				}
				
				//System.out.println(bit + " " + sum + " " + xor + " " + sumbit + " " + xorbit);
				
				
				bit *= 2;
			}
			
			System.out.println(1);
			System.out.println(ans);
		}
	}
	
	static int[] toBinary(int number) {
		int base = 2;
	    final int[] ret = new int[base];
	    for (int i = 0; i < base; i++) {
	        ret[base - 1 - i] = (1 << i & number);
	    }
	    return ret;
	}
}

/* 
BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(sc.readLine());

String[] t = sc.readLine().split(" ");
int[] list = new int[n];
for(int x=0; x<n; x++) {
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
