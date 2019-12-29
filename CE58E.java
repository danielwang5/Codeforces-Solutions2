import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CE58E {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(sc.readLine());
		
		int maxA = 0;
		int maxB = 0;
		
		int x=0;
		int y=0;
		int temp = 0;
		String s;
		
		
		for(int i=0; i<n; i++){
			StringTokenizer token = new StringTokenizer(sc.readLine());
			
			s = token.nextToken();
			x = Integer.parseInt(token.nextToken());
			y = Integer.parseInt(token.nextToken());	
			
			if(x < y) {
				temp = x;
				x = y;
				y = temp;
			}
			
			if(s.equals("+")) {
				
				if(x>maxA){
					maxA = x;
				}
				
				if(y> maxB) {
					maxB = y;
				}
			}
			
			else {
				
				if(x >= maxA && y >= maxB) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
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
