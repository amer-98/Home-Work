public class LinkedStack<T> implements Stack<T> {
	
	@SuppressWarnings("hiding")
	public class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node () {
			data = null;
			next = null;
		}
		
		public Node (T val) {
			data = val;
			next = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		
	}

	
	private Node<T> top;

	
	public LinkedStack() {
		top = null;
	}
	public boolean empty(){
		return top == null;
	}
	
	public boolean full(){
		return false;
	}
	public void push(T e){
		Node<T> tmp = new Node<T>(e);
		tmp.next = top;
		top = tmp;
	}
	public T pop(){
		if(empty())
			return null;
		T e = top.data;
		top = top.next;
		return e;
	}
	
	public int multiPush(T els[], int k) {
		
		int count=0;
		for (int i=0; i < k ;i++) {
		
			push(els[i]);
			count++;
		}
		
		return count;
	}
	
	public int multiPop(T els[], int k) {
		
		int count=0;
		
		for(int i=0;i<k;i++) 
			
			if(!empty()) {
				
				els[i]=pop();
				count++;
			}
		
		return count;
		
	}
	

		
			
}
	
