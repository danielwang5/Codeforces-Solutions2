import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CE66F {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(sc.readLine());
		
		ArrayList<Integer> coords = new ArrayList<Integer>();
		ArrayList<Integer> newcoords = new ArrayList<Integer>();
		
		int ans = 0;
		
		String[] t = sc.readLine().split(" ");
		int[] list = new int[n];
		for(int x=0; x<n; x++){
			list[x] = Integer.parseInt(t[x]);
			if(list[x] == 1) {
				coords.add(x);
				ans ++;
			}
		}
		
		int curval = 2;
		
		while(coords.size() > 0) {
			
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
