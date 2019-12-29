import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CE58C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		
		
		
		
		
		
		int T = Integer.parseInt(sc.readLine());
		
		for(int x=0; x<T; x++){
			ArrayList<int[]> items = new ArrayList<int[]>();
			
			int A = 0;
			int B = 0;
			
			int n = Integer.parseInt(sc.readLine());
			String[] sorted = new String[n];
			
//			if(n == 2) {
//				sc.readLine();
//				sc.readLine();
//				System.out.println("1 2");
//				continue;
//			}

			for(int y=0; y<n; y++){
				String[] dir = sc.readLine().split(" ");
				int l = Integer.parseInt(dir[0]);
				int r = Integer.parseInt(dir[1]);
				
				int[] item = {l,r,y};
				items.add(item);
			}
			
			Collections.sort(items, new Comparator<int[]>() {
			    @Override
			    public int compare(int[] o1, int[] o2) {
			        return o1[0] > o2[0] ? +1 : o1[0] < o2[0] ? -1 : 0;
			    }
			});
			
			int twocount = 0;
			
			boolean imp = false;
			
			for(int y=0; y<n; y++) {
				int l = items.get(y)[0];
				int r = items.get(y)[1];
				int i = items.get(y)[2];
				
				//System.out.println(l + "qwe" + r);
				
				if(A<l) {
					A = r;
					sorted[i] = "1";
				}
				else {
					if(B<l) {
						B = r;
						sorted[i] = "2";
						twocount++;
					}
					else {
						imp = true;
						break;
					}
				}

				//System.out.println(Arrays.toString(sorted));
			}
			
			if(imp) {
				System.out.println("-1");
			}
			else {
				if(twocount == 0) {
					sorted[sorted.length - 1] = "2";
				}
				System.out.println(String.join(" ",sorted));
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
