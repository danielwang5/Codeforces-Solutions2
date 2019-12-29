import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CG3C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(sc.readLine());
		
		int[] posdict = new int[n];
		int[] list = new int[n];
		
		String[] t = sc.readLine().split(" ");
		for(int x=0; x<n; x++){
			int l = Integer.parseInt(t[x])-1;
			posdict[l] = x;
			list[x] = l;
		}
		
		//ArrayList<Integer> swaplog = new ArrayList<Integer>();
		
		System.out.println(3*n);
		
		int middle1 = n/2 - 1;
		int middle2 = n/2;
		int k = 0;
		
		for(int i=n/2-1; i>=0; i--) {
			
			k = posdict[middle1];
			
			if(k < middle1) {
				System.out.println((k+1) + " " + n);
				swap(list,k,n-1,posdict);
				
				System.out.println((middle1+1) + " " + n);
				swap(list,middle1,n-1,posdict);
			}
			else if(k > middle1){
				System.out.println(1 + " " + (k+1));
				swap(list,0,k,posdict);
				System.out.println(1 + " " + n);
				swap(list,0,n-1,posdict);
				System.out.println((middle1+1) + " " + n);
				swap(list,middle1,n-1,posdict);
			}
			else {
				System.out.println(1 + " " + 1);
				System.out.println(1 + " " + 1);
				System.out.println(1 + " " + 1);
			}
			k = posdict[middle2];
			
			if(k > middle2) {
				System.out.println(1 + " " + (k+1));
				swap(list,0,k,posdict);
				
				System.out.println(1 + " " + (middle2+1));
				swap(list,0,middle2,posdict);
				
				System.out.println(1 + " " + 1);
			}
			else if(k < middle2) {
				System.out.println((k+1) + " " + n);
				swap(list,k,n-1,posdict);
				System.out.println(1 + " " + n);
				swap(list,0,n-1,posdict);
				System.out.println(1 + " " + (middle2+1));
				swap(list,0,middle2,posdict);
			}
			else {
				System.out.println(1 + " " + 1);
				System.out.println(1 + " " + 1);
				System.out.println(1 + " " + 1);
			}
			
			middle1--;
			middle2++;
			
			
			
		}
		
		//System.out.println(swaplog.size()/2);
		
		
//		for(int i=0; i<swaplog.size(); i+=2) {
//			System.out.println(swaplog.get(i) + " " + swaplog.get(i+1));
//		}
	
	}
	
	public static final <T> void swap (int[] list, int i, int j, int[] posdict) {
		
		int ii = list[i];
		int jj = list[j];
	
		posdict[ii] = j;
		posdict[jj] = i;
		
		list[j] = ii;
		list[i] = jj;
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
