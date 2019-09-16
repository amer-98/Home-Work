
import java.io.File;

import java.util.Scanner;

public class SimpleEncrypt {

	public  static Stack<Queue<Character>>readSentences(String fileName) {
		
		Stack<Queue<Character>> st=new LinkedStack<Queue<Character>>();
		
		Stack<String>st2=new LinkedStack<String>();
		
		File ff =new File(fileName);
		
		try {
			@SuppressWarnings("resource")
			Scanner ss = new Scanner(ff);
			while(ss.hasNextLine())
			{
				String s = ss.nextLine();
				st2.push(s);
			}
		} catch (Exception e) {
			
			return null;
		}
		while(!st2.empty()){
			
			String s = st2.pop();
			
			Queue<Character>q=new ArrayQueue<Character>(s.length());
			
			for(int i=0;i<s.length();i++)
			{
				q.enqueue(s.charAt(i));
			}
			
			st.push(q);
			
		}
		
		return st ;
	}

	public  static  void encrypt(Queue<Character> q,int k) {
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Stack<Character> st = new LinkedStack();
		
		int s = q.length();
		
		for(int i=0;i<s/k;i++) {
			
			for(int j=0;j<k;j++) 
				
				st.push(q.serve());
			
			while(! st.empty())
				
				q.enqueue(st.pop());
			
		}
		
		for(int n=0;n<s%k;n++) 
			
            st.push(q.serve());
		
		while(! st.empty())
			
			q.enqueue(st.pop());
		
	}

	public  static  void decrypt(Queue<Character> q,int k) {
		encrypt(q, k);
	}
    public static void encrypt(Stack<Queue<Character>> st, int k) {
		
		Stack<Queue<Character>> st2 = new LinkedStack<Queue<Character>> ();
		
		while(! st.empty()) {
			
			Queue<Character> q = st.pop();
			encrypt(q,k);
			st2.push(q);
		}
		
		while(! st2.empty()) 
			
			st.push(st2.pop());
			
		
	}
	public  static  void decrypt(Stack<Queue<Character>> st,int k) {
		encrypt(st, k);
	}

    
}
