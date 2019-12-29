import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C562C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] dir = sc.readLine().split(" ");
		int n = Integer.parseInt(dir[0]);
		int mod = Integer.parseInt(dir[1]);
		
		int allzero = 0;
		int zeroride = 0;
		int maxride = 0;
		
		int maxnumber = 0;
		int zeroridenumber = 0;
		
		int prev = 0;
		
		int d = 0;
		int val = 0;
		
		String[] t = sc.readLine().split(" ");
		int[] list = new int[n];
		for(int x=0; x<n; x++){
			list[x] = Integer.parseInt(t[x]);
		}
		
		maxnumber = list[0];
		allzero = dist(list[0], 0, mod);
		
		for(int i = 1; i<n; i++) {
			
			val = list[i];
			
			d = dist(val, 0, mod);
			if(d > allzero) {
				allzero = d;
			}
			
			if(val >= maxnumber) {
				maxnumber = val;
				
			}
			d = dist(val, maxnumber, mod);
			if(d > maxride) {
				maxride = d;
			}
			
			zeroridenumber = 
			
			prev = val;
		}
	}
	
	public static int dist(int start, int finish, int mod) {
		if(start <= finish) {
			return finish - start;
		}
		else {
			return finish + mod - start;
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
