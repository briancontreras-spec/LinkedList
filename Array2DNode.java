package hw04;
/**
 * The purpose of this class is just to create a 2dNode 
 * to work with the 2dLinkedList.
 * @author Brian Contreras,  400400309, CS-2013, Sections 03 & 04
 *https://calstatela.instructuremedia.com/embed/32762e5f-fb0f-4bbc-a9d0-64d0102c1394
 * @param <E>
 */
public class Array2DNode<E> {
	//Data fields
	private E item;
	protected Array2DNode nextRow;
	protected Array2DNode nextCol;
	//Constructor
	public Array2DNode(E item) {
		this.item = item;
	}
	//getter and setter for the item data field.
	public E getItem() {
		return item;
	}
	public void setItem(E item) {
		this.item = item;
	}
	/**
	 * Uses the String.value of to be able to print out a string value.
	 */
	public String toString() {
		return  String.valueOf(item);
	}

}
