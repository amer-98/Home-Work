public class ArrayQueue<T> implements Queue<T>{
	private int maxsize;
	private int size;
	private int head, tail;
	private T[] nodes;


	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int n) {
		maxsize = n;
		size = 0;
		head = tail = 0;
		nodes = (T[])new Object[n];

	}
	
	public void enqueue(T e) {
		nodes[tail] = e;
		tail = (tail + 1) % maxsize;
		size++;
	}

	public T serve () {
		T e = nodes[head];
		head = (head + 1) % maxsize;
		size--;
		return e;
	}

	public int length () {
		return size;
	}

	public boolean full () {
		return size == maxsize;
	}

	public int multiEnqueue (T els[], int k) {
		
		int l = 0;
		int y = k;
		
		while(size!=maxsize && y != 0) {
			
			int z = k-y;
			
			y--;
			
			T x = els[z];
				
			enqueue(x);
	
			l++;
				
		}
		
		return l;
	
		
	}
	
	public int multiServe(T els[], int k) {
		
		int l = 0;
		
		while(size != 0 && k != 0) {
			
			T x = serve();
			
			els[l++] = x;
			k--;
		}
		
		return l;
		
	}
	

}
