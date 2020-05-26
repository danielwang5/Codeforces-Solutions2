import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CE66C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(sc.readLine());
		
		for(int x=0; x<T; x++){
			String[] dir = sc.readLine().split(" ");
			int n = Integer.parseInt(dir[0]);
			int k = Integer.parseInt(dir[1]);
			
			String[] t = sc.readLine().split(" ");
			int[] list = new int[n];
			for(int y=0; y<n; y++){
				list[y] = Integer.parseInt(t[y]);
			}
			
			int first = 0;
			
			int mindist = 2000000000;
			int minfirst = 0;
			int minsecond = 0;
			
			for(int second=k; second<n; second++) {
				int dist = list[second] - list[first];
				if(dist <= mindist) {
					mindist = dist;
					minfirst = list[first];
					minsecond = list[second];
				}
				
				first ++;
			}
			
			System.out.println((minfirst + minsecond)/2);
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
