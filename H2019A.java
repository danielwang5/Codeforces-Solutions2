import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class H2019A{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] s = sc.readLine().split("");
		String[] t = sc.readLine().split(" ");
		
		boolean b = false;
		
		for(String tt:t) {
			if(tt.substring(0, 1).equals(s[0]) || tt.substring(1).equals(s[1])) {
				b = true;
			}
		}
		
		if(b) {
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
