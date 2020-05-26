import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GB19D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		String[] dir = sc.readLine().split(" ");
		int n = Integer.parseInt(dir[0]);
		int k = Integer.parseInt(dir[1]);
		
		int ind1=-1;
		int ind2=-1;
		int val1=0;
		int val2=0;
		int cnt1=0;
		int cnt2=0;
		
		for (int i=1; i<=k+1; i++) {
			System.out.print("? ");
			for(int j=1; j<=k+1; j++) {
				if(i!=j) {
					System.out.print(j+" ");
				}
			}
			System.out.flush();
			dir = sc.readLine().split(" ");
			int ind = Integer.parseInt(dir[0]);
			int val = Integer.parseInt(dir[1]);
			
			if(ind1==-1) {
				ind1 = ind;
				val1 = val;
				cnt1++;
			} else if(ind==ind1) {
				ind1 = ind;
				val1 = val;
				cnt1++;
			} else {
				if(ind2==-1) {
					ind2 = ind;
					val2 = val;
				}
				cnt2++;
			}
		}
		
		if(val1 < val2) {
			System.out.print("! "+cnt2);
		} else {
			System.out.print("! "+cnt1);
		}
		System.out.flush();
		sc.close();
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
