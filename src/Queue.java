public interface Queue<T>{
public T serve();
public void enqueue(T e);
public int length();
public boolean full();
public int multiEnqueue (T els[], int k);
public int multiServe(T els[], int k);
}
