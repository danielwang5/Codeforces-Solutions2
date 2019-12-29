import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C562A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] dir = sc.readLine().split(" ");
		int n = Integer.parseInt(dir[0]);
		int a = Integer.parseInt(dir[1]);
		int x = Integer.parseInt(dir[2]);
		int b = Integer.parseInt(dir[3]);
		int y = Integer.parseInt(dir[4]);
		
		
		int first = a;
		int second = b;
		
		boolean ans = false;
		
		for(int i=0; i<200; i++) {
			
			//System.out.println(first + " .. " + second);
			
			if(first == second) {
				ans = true;
			}
			if(first != x) {
				first ++;
				if(first == n+1) {
					first = 1;
				}
			}
			if(second != y) {
				second--;
				if(second == 0) {
					second = n;
				}
				
			}
			
			if(first == x || second == y) {
				if(first == second) {
					ans = true;
				}
				break;
			}
		}
		
		if(ans) {
			System.out.print("YES");
		}
		else {
			System.out.print("NO");
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
