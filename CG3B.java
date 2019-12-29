import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CG3B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] dir = sc.readLine().split(" ");
		int n = Integer.parseInt(dir[0]);
		int m = Integer.parseInt(dir[1]);
		int ta = Integer.parseInt(dir[2]);
		int tb = Integer.parseInt(dir[3]);
		int k = Integer.parseInt(dir[4]);
		
		String[] t = sc.readLine().split(" ");
		int[] firstlist = new int[n];
		for(int x=0; x<n; x++){
			firstlist[x] = Integer.parseInt(t[x]);
		}
		
		t = sc.readLine().split(" ");
		int[] secondlist = new int[n];
		for(int x=0; x<n; x++){
			secondlist[x] = Integer.parseInt(t[x]);
		}
		
		if(k >= n || k >= m) {
			System.out.print(-1);
		}
		else {
			
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
