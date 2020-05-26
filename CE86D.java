import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class CE86D {
	public static void main(String[] args) throws NumberFormatException, IOException {
		FastReader sc=new FastReader();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arrs = new int[n];
		int[] caps = new int[k];
		
		for(int nn=0; nn<n; nn++) {
			arrs[nn] = sc.nextInt();
		}
		
		Arrays.sort(arrs);
		
		for(int kk=0; kk<k; kk++) {
			caps[kk] = sc.nextInt();
		}
		
		int[] limit = new int[n+10];
		
		int indn = 0;
		int indk = k-1;
		while(indn < n && indk >= 0) {
			//out.println(indn + " " + indk);
			limit[indn] = indk+1;
			indn++;
			while(indk >= 0 && indn+1 > caps[indk]) {
				indk--;
			}
		}
		
		out.print(Arrays.toString(limit));
		
		out.flush();
	}
	
	
	
	public class BinaryHeap {
		
		private static final int d= 2;
		private int[] heap;
		private int heapSize;
		
		/**
		 * This will initialize our heap with default size. 
		 */
		public BinaryHeap(int capacity){
			heapSize = 0;
			heap = new int[ capacity+1];
			Arrays.fill(heap, -1);
			
		}
		
		/**
		 *  This will check if the heap is empty or not
		 *  Complexity: O(1)
		 */
		public boolean isEmpty(){
			return heapSize==0;
		}
		
		/**
		 *  This will check if the heap is full or not
		 *  Complexity: O(1)
		 */
		public boolean isFull(){
			return heapSize == heap.length;
		}
		
		
		private int parent(int i){
			return (i-1)/d;
		}
		
		private int kthChild(int i,int k){
			return d*i  +k;
		}
		
		/**
		 *  This will insert new element in to heap
		 *  Complexity: O(log N)
		 *  As worst case scenario, we need to traverse till the root
		 */
		public void insert(int x){
			if(isFull())
				throw new NoSuchElementException("Heap is full, No space to insert new element");
			heap[heapSize++] = x;
			heapifyUp(heapSize-1);
		}
		
		/**
		 *  This will delete element at index x
		 *  Complexity: O(log N)
		 * 
		 */
		public int delete(int x){
			if(isEmpty())
				throw new NoSuchElementException("Heap is empty, No element to delete");
			int key = heap[x];
			heap[x] = heap[heapSize -1];
			heapSize--;
			heapifyDown(x);
			return key;
		}

		/**
		 *  This method used to maintain the heap property while inserting an element.
		 *  
		 */
		private void heapifyUp(int i) {
			int temp = heap[i];
			while(i>0 && temp > heap[parent(i)]){
				heap[i] = heap[parent(i)];
				i = parent(i);
			}
			heap[i] = temp;
		}
		
		/**
		 *  This method used to maintain the heap property while deleting an element.
		 *  
		 */
		private void heapifyDown(int i){
			int child;
			int temp = heap[i];
			while(kthChild(i, 1) < heapSize){
				child = maxChild(i);
				if(temp < heap[child]){
					heap[i] = heap[child];
				}else
					break;
				
				i = child;
			}
			heap[i] = temp;
		}

		private int maxChild(int i) {
			int leftChild = kthChild(i, 1);
			int rightChild = kthChild(i, 2);
			
			return heap[leftChild]>heap[rightChild]?leftChild:rightChild;
		}
		
		/**
		 *  This method used to print all element of the heap
		 *  
		 */
		public void printHeap()
		    {
		        System.out.print("\nHeap = ");
		        for (int i = 0; i < heapSize; i++)
		            System.out.print(heap[i] +" ");
		        System.out.println();
		    }
		/**
		 *  This method returns the max element of the heap.
		 *  complexity: O(1)
		 */
		 public int findMax(){
			 if(isEmpty())
				 throw new NoSuchElementException("Heap is empty.");
			 return heap[0];
		 }
		 
//		 public static void main(String[] args){
//			 BinaryHeap maxHeap = new BinaryHeap(10);
//			 maxHeap.insert(10);
//			 maxHeap.insert(4);
//			 maxHeap.insert(9);
//			 maxHeap.insert(1);
//			 maxHeap.insert(7);
//			 maxHeap.insert(5);
//			 maxHeap.insert(3);
//			 
//			 maxHeap.printHeap();
//			 maxHeap.delete(5);
//			 maxHeap.printHeap();
//			 
//		 }
	}
	
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader()
	{br=new BufferedReader(new InputStreamReader(System.in), 32768);}
	String next(){while(st==null||!st.hasMoreElements())
	{try{st=new StringTokenizer(br.readLine());}
	catch(IOException e){e.printStackTrace();}}return st.nextToken();}
	int nextInt(){return Integer.parseInt(next());}
	long nextLong(){return Long.parseLong(next());}
	double nextDouble(){return Double.parseDouble(next());}
	String nextLine(){String str="";try{str=br.readLine();}
	catch(IOException e){e.printStackTrace();}return str;}}
}
