import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CE66B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int l = Integer.parseInt(sc.readLine());
		
		ArrayList<Long> prodlist = new ArrayList<Long>();
		
		long limit = 4294967296l;
		
		long prod = 1;
		
		long x = 0;
		
		boolean overflow = false;
		
		for(int i=0; i<l; i++) {
			String[] dir = sc.readLine().split(" ");
			String c = dir[0];
			if(c.equals("for")) {
				long n = Long.parseLong(dir[1]);
				prodlist.add(n);
			}
			else if(c.equals("add")) {
				prod = 1;
				for(long num: prodlist) {
					prod *= num;
					if(prod >= limit) {
						overflow = true;
						break;
					}
				}
				x += prod;
				if(x >= limit) {
					overflow = true;
				}
			}
			else { // end
				prodlist.remove(prodlist.size()-1);
			}
			
			if(overflow) {
				break;
			}
		}
		
		if(overflow) {
			System.out.print("OVERFLOW!!!");
		}
		else {
			System.out.print(x);
		}
		
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
