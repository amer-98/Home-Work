public interface Stack<T>{
public T pop( );
public void push(T e);
public boolean empty( );
public boolean full( );
public int multiPush(T els[], int k);
public int multiPop(T els[], int k);
}
