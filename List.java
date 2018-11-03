/*
 * The interface List defines all the abstract methods that will be implemented in the ArrayList class
 * The interface uses the generic E because it will be implemented in the ArrayList class, so the elements 
 * can be of any type
 */
public interface List<E> {
	public void add(Object o);
	public void add(Object o,int index);
	public String ArrayPrintOut();
	public Object get(int index);
	public int size();
	public boolean isEmpty();
	public boolean isIn(Object ob);
	public int find (Object n);
	public void remove (Object n);
	

}
