package hw04;
import java.util.ArrayList;
/**
 * The purpose of this object is to create a 2D Linked List and create multiple methods that can successfully manipulate the 
 * LinkedList.
 * @author Brian Contreras,  400400309, CS-2013, Sections 03 & 04
 *https://calstatela.instructuremedia.com/embed/32762e5f-fb0f-4bbc-a9d0-64d0102c1394
 * @param <E> Generic 
 */
public class Array2D<E> {
	//data fields
	//The amount of rows in the LinkedList
	private int rowSize;
	//The amount of columns in the LinkedList
	private int colSize;
	//initializing all pointer Nodes
	protected Array2DNode head;
	protected Array2DNode rowTail;
	protected Array2DNode colTail;
	//Constructors
	//Creates a empty LinkedList as the default constructor
	public Array2D() {
		this.rowSize = 0;
		this.colSize = 0;
		this.head = null;
		this.colTail = null;
		this.rowTail = null;
	}
	//Constructor that Accepts a 2D array
	/**
	 * This is the constructor that accepts a 2d array in order to create a Linked List
	 * @param arr the values passed to the LinkedList
	 */
	public Array2D(E[][] arr) {
		/**
		 * What this constructor does is manipulates a 2d array by using each index as a 
		 * individual array and then using the add Row method in a for loop to be able to populate the entire 
		 * LinkedList.
		 */
		for(int i = arr.length-1 ; i >= 0;i--) {
			this.addFirstRow(arr[i]);
		}		
	}
	/**
	 * This method was created to be able to add a column to the beginning of the LinkedList 
	 * while reassigning the head and rowTail pointers
	 * @param values The values that you wish to add to the Linked List
	 * <b>
	 * The values that are being passed into the array must match the row Size or else a exception will
	 * be thrown.
	 */
	public void addFirstCol(E...values ) {
		/**
		 * The first if statement will check if the size of the rows are the same as the length of the values.
		 * This is done to make sure that the Linked List is formatted propertly.
		 */
		if(this.rowSize == values.length) {
			/**
			 * The first step is to create a reference to the original head variable so that no data is lost,
			 * the next step was to assign the head value to first value of the values provided.
			 * <b>
			 * once the oldHead pointer and the new head is initialized then the next step will be to connect 
			 * the head with the oldHead with the nextCol pointer.
			 * <b>
			 * After the oldHead and the head are connected we will make 2 Nodes in order to tranverse the 
			 * rest of the LinkedList and add and connect the new values of the values provided. 
			 * The 2 traversal nodes will be called Current(referring to head) and OldCurrent(referring to the oldHead pointer)
			 * <b>
			 * These nodes will be placed in a for loop that begins at 1 since the first value was already used to initialize the new head
			 * pointer. This for loop will first assign the nextRow pointer to the next value of the values provided, once the nextRow
			 * pointer is initialized then the current will tranverse the the nextRow, the oldCurrent will also tranverse to the 
			 * nextRow as the oldCurrent's nextRow pointers are already initialized,
			 * <b>
			 * Once both tranversed 1 row then we will connect current to oldCurrent with a nextCol pointer, this will be done until the 
			 * for loop is completed.
			 * <b>
			 * however in order to update the rowTail as well we simply add a if statement to the end of the for loop to check if 
			 * the loop is on the last run and if true then the current value will be the new rowTail pointer.
			 * Once completed the colSize will update and the method will end.
			 */
			Array2DNode oldHead = this.head;
			this.head = new Array2DNode(values[0]);
			if(values.length ==1) {
				rowTail = head;
			}
			head.nextCol = oldHead;
			Array2DNode current = head;
			Array2DNode oldCurrent = oldHead;
			for(int i = 1; i < values.length;i++) {
				current.nextRow = new Array2DNode(values[i]);
				current = current.nextRow;
				oldCurrent = oldCurrent.nextRow;
				current.nextCol = oldCurrent;
				if(i == values.length-1) {
					this.rowTail = current;
				}
			}
			this.colSize = this.colSize+1;
			
		}
		/**
		 * This else if statement was created to make sure that this method is compatible  with a empty LinkedList
		 * , if the LinkedList is indeed empty it will initialize all the pointer variables.
		 */
		else if(this.head == null) {
			/**
			 * Since none of the pointers are initialized due to this being a empty LinkedList, we will first initialize the head 
			 * variable with the first value of the values provided.
			 * Once the head is initialized then we will assign the colTail to the head, and if there is only 1 value provided we will also
			 * point the rowTail to the head. This is done because the for loop starts at index 1 so if there was only 1 value then the
			 * rowTail would not be initialized.
			 * <b>
			 * we Start the for loop at 1 since we used the first value to initialize the head, we use a current Node 
			 * to traverse assigning current to head. and the for loop will assign the next value provided as the nextRow
			 * Node for the current Node, once the nextRow is assighned then current will become the nextRow and repeat until 
			 * there are no more values to add.
			 * <b>
			 * For the last run of the for loop the rowTail Node will be assigned to the current Node since it is the 
			 * last Node in the row.
			 * <b>
			 * The colSize will be 1 since this is the first column and the rowSize will be 
			 * the length of the values provided.
			 */
			head = new Array2DNode(values[0]);
			colTail = head;
			if(values.length ==1) {
				rowTail = head;
			}
			Array2DNode current = head;
			for(int i = 1;i<values.length;i++) {
				current.nextRow = new Array2DNode(values[i]);
				current = current.nextRow;
				if(i == values.length -1) {
					rowTail = current;
				}
			}
			this.colSize =1;
			this.rowSize = values.length;
		}
		/**
		 * This is thrown if the length of the values provided are not the same as the row size
		 * with the exception of the LinkedList being empty.
		 */
		else {
			throw  new IllegalArgumentException("The length of the Array and the rows don't match");
		}
		
	}
	/**
	 * This method was created to be able to add a Row to the beginning of the LinkedList.
	 * assigning  new head and colTail nodes.
	 * @param values values that wish to be added to the LInkedList.
	 * These values need to be the same lenght as the size of the colSize or else a exception will be thrown
	 * <b>
	 * This method works similar to the addFirstColMethod.
	 */
	public void addFirstRow(E...values ) {
		/**
		 * The Method is first set up with if and else if statements to check if the 
		 * values are the right length and if the LinkedList is empty.
		 */
		if(this.colSize == values.length) {
			/**
			 * The rowSize is increased by 1 as there is a new row being added.
			 * <b>
			 * The first step is to create 2 reference Nodes for both the head and colTail to make sure that
			 * no data is accidentally deleted. Once the 2 references are created then we will assign the head value
			 * to the first value of the values provided.
			 * Then we will connect the head Node with the oldHead Node and once this is done then we will create 2 Nodes to tranverse 
			 * and connect the list, current Node(referrencing the head) and oldCurrent(referrencing the oldHead). If the 
			 * value's length is 1 then the colTail will be assigned to the head because the for loop begins at index 1.
			 * <b>
			 * The current Node will connect to the OldCurrent Node with nextRow.
			 * What the for loop does is creates a new Node and connects the Node in one step using the 
			 * nextCol pointer, and once the new current Node is created then the current Node will become the nextCol Node.
			 * The OldCurrent Node will connect to the NextCol Node and update to the nextCol Node, once updated then 
			 * the Current Node and OldCurrent Node will connect with NextRow pointer. This will continue for the rest of the loop.
			 * <b>
			 * Once the loop is on the last run then it will assign the colTail to the current Node since it will be the last Node.
			 */
			this.rowSize = this.rowSize + 1;
			Array2DNode oldHead = head;
			Array2DNode oldColTail = colTail;

			head = new Array2DNode(values[0]);
			head.nextRow = oldHead;
			if(values.length == 1) {
				colTail = head;
			}
			Array2DNode current = head;
			Array2DNode oldCurrent = oldHead;
			for(int i =1;i<values.length;i++) {
				current.nextCol = new Array2DNode(values[i]);
				current = current.nextCol;
				oldCurrent = oldCurrent.nextCol;
				current.nextRow = oldCurrent;
				if(i == values.length-1) {
					this.colTail = current;
				}
			}
		}
		/**
		 * This will be called if the LinkedList is empty.
		 * The Head node will be assigned to the first value of the values given. 
		 * Since this is the first Row the rowTail will be a reference to the head.
		 * <b>
		 * If the values lenght is 1 then the colTail will be a reference to the head because the next for loop starts at index 1.
		 */
		else if(head == null) {
			head = new Array2DNode(values[0]);
			rowTail = head;
			/**
			 * Since there will only be 1 row we only need one Current Node.
			 * The rowSize will be 1 and the colSize will be the lenght of the values provided.
			 * 
			 */
			Array2DNode current = head;
			rowSize = 1;
			colSize = values.length;
			if(values.length ==1) {
				colTail = head;
			}
			/**
			 * This for loop will assign the nextCol of current to the next value of the values given, once 
			 * the value is assigned then the current value will update to the nextCol Node. 
			 * This will repeat until all values are added, and for the last run the colTail will be 
			 * referenced to the current Node since it is the Last column value.
			 */
			for(int i = 1; i < values.length;i++) {
				current.nextCol = new Array2DNode(values[i]);
				current = current.nextCol;
				if(i == values.length-1) {
					colTail = current;
				}
			}
		}
		/**
		 * Thrown if the values length is not the same as the colSize.
		 */
		else {
			throw  new IllegalArgumentException("The length of the Array and the columns don't match");
		}
		
	}
	/**
	 * The purpose of this method is to add values to the end of a LinkedList.
	 * @param values The values that wish to be added to the LInkedList
	 * This values must match the colSize or else a exception will be thrown.
	 */
	public void addLastRow(E... values) {
		/**
		 * The rowSize will increase by 1.
		 * The the reference to the rowTail Node will be created as prevRow,
		 * and the rowTail will update to the first value of the values provided.
		 * A refernece the rowTail will be created as currentCol Node and then the 
		 * prevRow and currentCol Nodes will be connected by nextRow.
		 */
		if(values.length == this.colSize) {
			rowSize = rowSize +1;
			Array2DNode prevRow = rowTail;
			rowTail.nextRow = new Array2DNode(values[0]);
			rowTail = rowTail.nextRow;
			Array2DNode currentCol = rowTail;
			prevRow.nextRow = currentCol;
			/**
			 * This for loop will start at index 1 since the first value was already 
			 * initialized. 
			 * This for loop will create a new Node with the values given and then connect the currentCol
			 * Node with the nextCol pointer. once connected the currentCol Node will update to the 
			 * nextCol Node. The prevRow will also update to the nextCol and once both are updated then 
			 * they will connect with nextRow. 
			 * This will continue until all the values are added.
			 */
			for(int i = 1;i<values.length;i++) {
				currentCol.nextCol = new Array2DNode(values[i]);
				currentCol = currentCol.nextCol;
				prevRow = prevRow.nextCol;
				prevRow.nextRow =currentCol;
			}
		}
		else if(head == null) {
			/**
			 * This is the same process as the Add FirstRow if the LinkedLIst is empty.
			 */
			head = new Array2DNode(values[0]);
			rowTail = head;
			Array2DNode current = head;
			rowSize = 1;
			colSize = values.length;
			if(values.length ==1) {
				colTail = head;
			}
			for(int i = 1; i < values.length;i++) {
				current.nextCol = new Array2DNode(values[i]);
				current = current.nextCol;
				if(i == values.length-1) {
					colTail = current;
				}
			}
		}
		/**
		 * If the values length does not match with the colSize then this will be thrown.
		 */
		else {
			throw  new IllegalArgumentException("The length of the Array and the columns don't match");
		}
	}
	/**
	 * This method will add a Column to the end of the LinkedList.
	 * @param values The values that will be added into the LinkedList
	 * If the value length is not the same as the rowSize then a exception will be thrown.
	 */
	public void addLastCol(E...values) {
		if(values.length == rowSize()) {
			/**
			 * First the colSize will increase by 1 since a column will be added to the LinkedList.
			 * We then create a reference to the colTail and assign the colTail to the first value of 
			 * the values provided. The oldColTail Node will connect to the currentColTail Node with  nextCol pointer.
			 * Once connected 2 reference Nodes will be created in order to tranverse the list.
			 * 
			 */
		colSize = colSize +1;
		Array2DNode oldColTail = colTail;
		colTail = new Array2DNode(values[0]);
		oldColTail.nextCol = colTail;
		Array2DNode current = colTail;
		Array2DNode oldCurrent = oldColTail;
		/**
		 * This for loop will assign the current next Node to the next value provided.And then the current node will update to 
		 * the nextRow. The oldCurrent will also update to the next oldCurrent node. 
		 * Then the Current and oldCurrent Node will connect with nextCol.
		 * This will be repeated until all values are added.
		 */
		for(int i = 1; i < values.length;i++) {
			current.nextRow = new Array2DNode(values[i]);
			current = current.nextRow;
			oldCurrent = oldCurrent.nextRow;
			oldCurrent.nextCol = current;
		}
	}
		/**
		 * Called if the LinkedList is empty.
		 */
		else if(head == null) {
			/**
			 * Same procedure as the AddFirstColumn is the head value is null.
			 */
			head = new Array2DNode(values[0]);
			colTail = head;
			if(values.length ==1) {
				rowTail = head;
			}
			Array2DNode current = head;
			for(int i = 1;i<values.length;i++) {
				current.nextRow = new Array2DNode(values[i]);
				current = current.nextRow;
				if(i == values.length -1) {
					rowTail = current;
				}
			}
			this.colSize =1;
			this.rowSize = values.length;
		}
		/**
		 * Thrown if the values length does not match the rowSize.
		 */
		else {
			throw  new IllegalArgumentException("The length of the Array and the rows don't match");
		}
	}
	/**
	 * This method is used to insert values at a specific index.
	 * @param index The index in which the user wishes to place the values
	 * @param values The values that the user wishes  to insert into the LinkedList
	 */
	public void insertCol(int index,E...values) {
		/**
		 * This will check if the index is 0 and if the values entered are the correct size.
		 * If so then the addFirstColMethod will be called to insert to the beginning of the LinkedList.
		 */
		 if(index == 0 && values.length == rowSize) {
			this.addFirstCol(values);
		}
		 /**
		  * If the LInkedList is empty and the Index is 0 then the addFirstCol method will be
		  * called because the LinkedList is empty.
		  */
		 else if(head == null && index == 0) {
			 this.addFirstCol(values);
		 }
		 /**
		  * This will check if the index is in the appropriate bounds
		  */
			else if( index > colSize || index<0) {
				throw  new  IndexOutOfBoundsException("Index Out of Bounds");
			}
		 /**
		  * If the index is the same as the colSize then the addLast column method will be called.
		  * The length of the values are checked as well in order to make sure that the LinkedLIst
		  * is populated correctly.
		  */
		else if(index == colSize() && values.length == rowSize()) {
			this.addLastCol(values);
		}
		 /**
		  * This is when the values are the correct length.
		  * First the colSize will increase by 1 as there is a new column being 
		  * added into the LinkedList.
		  * Second there is a current Node that is created referencing the head.
		  * In order to get the correct Column to insert the values we must use a for loop that starts at 1
		  * to be able to move around the col of the LInkedList. This forLoopadvances the current node 
		  * with the nextCol pointer as many times as there a index.
		  * <b>
		  * Once the current Node is in the appropriate column we will then create a reference to the
		  * nextCol of the current Node and call it oldNext. 
		  * This is done to be able to keep a reference to the old data and not lose any data in the
		  * inserstion.
		  * <b>
		  * when the oldNext Node is created then, a new Node called newNext is created with the first value of 
		  * the values provided. Once created then the currentNode is connected to newNext with nextCol and then
		  * the nextNext Node is connected to oldNext with nextCol to make sure that no data is lost.
		  * <b>
		  * The forloop will advance the current and oldNext Nodes down 1 row and will then 
		  * advance the newNExt node with a new node that is created with the next value provided.
		  * Once created the current Node connects to newNext with the nextCol pointer and the newNext connects 
		  * to oldNext with the nextCol pointer to make sure everything is pointing properly.
		  * <b>
		  * This is repeated until all the values are added.
		  */
		else if(values.length == rowSize()) {
			colSize = colSize + 1;
				Array2DNode current = head;
				for(int i = 1 ; i < index ;i++) {
					current = current.nextCol;
				}
				Array2DNode oldNext = current.nextCol;
				Array2DNode newNext = new Array2DNode(values[0]);
				current.nextCol = newNext;
				newNext.nextCol = oldNext;
				for(int i = 1 ; i < values.length;i++) {
					current = current.nextRow;
					oldNext = oldNext.nextRow;
					newNext.nextRow = new Array2DNode(values[i]);
					newNext = newNext.nextRow;
					current.nextCol = newNext;
					newNext.nextCol = oldNext;
				}
				
			
		}
//		 /**
//		  * If the LinkedList is empty then the addLastCOlumn method is thrown.
//		  */
//		else if(head == null) {
//			this.addLastCol(values);
//		}
		 /**
		  * This is thrown when the length of the values does not match the length of the rowSize.
		  */
		else {
			throw  new IllegalArgumentException("The length of the Array and the rows don't match");
		}
	}
	/**
	 * The purpose of this is to add a column of values at a specific index 
	 * @param index The index of the LinkedList that the user wishes to populate.
	 * @param values The values that wish to be added in the LinkedList.
	 */
	public void insertRow(int index, E...values) {
		/**
		 * This will be called if the LinkedList is empty and if the LinkedList index is 0
		 * because it would not make sense for the index to be any greater than 0 since the LinkedList is empty.
		 * <b>
		 * This will call the Add First Row method since there is nothing origianlly.
		 */
		if(head == null && index == 0) {
			this.addFirstRow(values);
		}
		/**
		 * This will check if the Index is valid
		 */
		else if(index > rowSize || index < 0) {
			throw  new  IndexOutOfBoundsException("Index Out of Bounds");
		}
		/**
		 * This will check if the if the values length is the appropriate size
		 * to be added to the LInkedList.
		 */
		else if(values.length != colSize) {
			throw  new IllegalArgumentException("The length of the Array and the rows don't match");
		}
		/**
		 * This will check if the Index is 0 so that we can just use a AddFirstRow method.
		 */
		else if(index == 0) {
			this.addFirstRow(values);
		}
		/**
		 * This will check if the Index is at the end of the array if so then we will call
		 * the AddListRow method.
		 */
		else if(index == rowSize()) {
			this.addLastRow(values);
		}
		/**
		 * This first step is to increase the rowSize,
		 * After that then a current Node is created referrencing the head.
		 * <b>
		 * Then this current Node is placed inside a for loop in order to tranverse the 
		 * LinkedList to make sure that the row is in the appropriate place.
		 */
		else {
			rowSize = rowSize + 1;
			Array2DNode current = head;
			for(int i = 1 ; i < index; i++) {
				current = current.nextRow;
			}
			/**
			 * Once the current is updated to the correct Node in the LinkedList, then we will 
			 * create a oldNext Node referencing the nextRow, also a newNExt node that created a new node with the
			 * new values from the values presented.
			 * <b>
			 * Once all the Nodes are created then they will be connected with Current Node NextRow being newNExt node, and
			 * the newNext node NextRow being oldNExt.
			 * What this does is connect all the nodes.
			 */
			Array2DNode oldNext = current.nextRow;
			Array2DNode newNext = new Array2DNode(values[0]);
			current.nextRow = newNext;
			newNext.nextRow = oldNext;
			/**
			 * This for Loop will move the Current and oldNext Nodes to the nextCol and for the 
			 * newNExt Node it will reference the nextCol to the next value of the Value array.
			 * Once created then the nextNode will update to the nextCol Node.
			 * <b>
			 * when All the nodes are updated they will be connected using current nextRow =newNext 
			 * and then newNext node will be connected to the oldNext with newNext nextRow = oldNext.
			 * This will repeat until all the values are added.
			 */
			for(int i = 1; i < values.length;i++) {
				current = current.nextCol;
				oldNext = oldNext.nextCol;
				newNext.nextCol = new Array2DNode(values[i]);
				newNext = newNext.nextCol;
				current.nextRow = newNext;
				newNext.nextRow = oldNext;
			}
		}
		
	}
	/**
	 * This will delete the First Column of the LinkedList
	 */
	public void deleteFirstCol() {
		/**
		 * This if statement will check if the LinkedList is empty if so then a 
		 * IllegalStateException will be thrown since there is nothing to delete.
		 */
		if(head == null) {
			throw new IllegalStateException("The LinkedList is empty so there is nothing to delete");
		}
		/**
		 * If the LinkedList is not empty then first we will decrease the colSize by 1 as we are deleting a column.
		 * What this will do is assign the head to the nexthead Node and assign the rowTail to the nextRowTail.
		 * <b>
		 * What this does is deletes the entire column because there is nothing to reference these nodes so they are not in the LinkedList 
		 * anymore.
		 */
		colSize = colSize -1;
		head = head.nextCol;
		rowTail = rowTail.nextCol;
		/**
		 * If there is only one Column and it gets deleted then this will also update the rowSize to 0
		 */
		if(colSize == 0) {
			rowSize =0;
		}
	}
	/**
	 * This will delete the first Row of the LinkedList.
	 */
	public void deleteFirstRow() {
		/**
		 * This if statement will check if the LinkedList is empty if so then a 
		 * IllegalStateException will be thrown since there is nothing to delete.
		 */
		if(head == null) {
			throw new IllegalStateException("The LinkedList is empty so there is nothing to delete");
		}
		/**
		 * This will decrease the size of the rowSize
		 * Once the rowSize is decreased then we will assign the headNode
		 * to the head nextRow, and the colTal Node to the colTail nextRow what this does
		 * is makes no reference to all the previous Nodes in the previous row therefore deleting them.
		 */
		rowSize = rowSize -1;
		head = head.nextRow;
		colTail = colTail.nextRow;
		/**
		 * If the Last row is deleted then this will also update the colSize to 0.
		 */
		if(rowSize == 0) {
			colSize = 0;
		}
	}
	/**
	 * This method will delete the lastCol of the LinkedList
	 */
	public void deleteLastCol() {
		/**
		 * This if statement will check if the LinkedList is empty if so then a 
		 * IllegalStateException will be thrown since there is nothing to delete.
		 */
		if(head == null) {
			throw new IllegalStateException("The LinkedList is empty so there is nothing to delete");
		}
		/**
		 * This will essentially check if there is only 1 Col because if the colTail and head are the same
		 * node then that means that it is one row. If it is one row Then the deleteFirstCol method will work.
		 */
		else if(head == colTail) {
			this.deleteFirstCol();
		}
		else {
			/**
			 * This will first decrease the colSize by 1 since we will be deleting a column.
			 * After that then there will be a current node that is referrencing the head node, once created then
			 * there will be a while Loop that will check what Node is before the colTail, if the nextCol Node 
			 * is not the colTail then the current Node will advance until it reaches the node before the colTail.
			 */
		colSize = colSize -1;
		Array2DNode current = head;
		while(current.nextCol != colTail) {
			current = current.nextCol;
		}
		/**
		 * This will make the current node turn into the colTail.
		 * then we will assign the current Node to the colTail Node in order to tranverse down the LinkedList.
		 */
		colTail = current;
		current = colTail;
		/**
		 * This while loop will make the nextCol value of current null, essentially making sure
		 * that they are not pointing to anything since this will be the last Node.
		 * Once the nextCol node is turned Null then the current Node will advance down the list until 
		 * the LinkedList ends.
		 */
		while(current != null) {
			current.nextCol = null;
			current = current.nextRow;
		}
		/**
		 * If the Last Column is deleted then the rowSize will also turn into 0.
		 */
		if(colSize == 0) {
			rowSize =0;
		}
		}
	}
	/**
	 * This method will delete the last Row of the LinkedList.
	 */
	public void deleteLastRow() {
		/**
		 * This if statement will check if the LinkedList is empty if so then a 
		 * IllegalStateException will be thrown since there is nothing to delete.
		 */
		if(head == null) {
			throw new IllegalStateException("The LinkedList is empty so there is nothing to delete");
		}
		/**
		 * This will check if the LinkedList only has 1 Row if so then the delete First Row method will be called.
		 */
		else if(head == rowTail) {
			this.deleteFirstRow();
		}
		/**
		 * This will first decrease the RowSize by 1, 
		 * Once the row Size is lowered by 1 then there will be a current Node referrencing the head.
		 * 
		 */
		else {
		rowSize = rowSize -1;
		Array2DNode current= head;
		/**
		 * A while Loop will be called that will check if the nextRow of the Current is the rowTail 
		 * what this does is moves the current node to the node before the rowTail.
		 */
		while(current.nextRow != rowTail) {
			current = current.nextRow;
		}
		/**
		 * Once the Node is the Node before the rowTail we will set the rowTail to the current Node and set the
		 * current Node to the rowTailNode.
		 */
		rowTail = current;
		current = rowTail;
		/**
		 * This while loop will go down the row and make the nextRow null, then move to the nextCol which will 
		 * continue until it reaches the end of the row. 
		 * Making the nextRow nodes null will make it so that the current node is not pointing to anything.
		 */
		while(current != null) {
			current.nextRow = null;
			current = current.nextCol;
		}
		/**
		 * if there is only 1 row then this will set the colSize to 0 as well.
		 */
		if(rowSize == 0) {
			colSize = 0;
		}
		}
	}
	/**
	 * This method will delete any Column at any Index.
	 * @param index The index which you wish to delete.
	 */
	public void deleteCol(int index) {
		/**
		 * This if statement will check if the LinkedList is empty if so then a 
		 * IllegalStateException will be thrown since there is nothing to delete.
		 */
		if(head == null) {
			throw new IllegalStateException("The LinkedList is empty so there is nothing to delete");
		}
		/**
		 * This will check if the index is in bounds of the columns.
		 */
		else if(index < 0 || index > colSize()) {
			throw  new  IndexOutOfBoundsException("Index Out of Bounds");
		}
		/**
		 * If there is only 1 column then the only index that would work would be the 0 index, so what 
		 * this does is checks if the index is 1 when the colSize is 1 if true a indexOutofBounds exception is thrown.
		 */
		else if(index == colSize && colSize == 1) {
			throw  new  IndexOutOfBoundsException("Index Out of Bounds");
		}
		/**
		 * If the index is 0 then we will call the deleteFirstCol method.
		 */
		else if (index == 0) {
			this.deleteFirstCol();
		}
		/**
		 * If the index is the same as the colSize then the deleteLastCol method will be called.
		 */
		else if (index == colSize()) {
			this.deleteLastCol();
		}
		/**
		 * This will first decrease the colSize by 1.
		 * it will then assign the current Node to reference the headNode.
		 * <b>
		 * The for loop will traverse the current node to the column that wishes to be deleted.
		 */
		else {
			colSize = colSize -1 ;
			Array2DNode current = head;
			for( int i = 1; i < index;i++) {
				current = current.nextCol;
			}
			/**
			 * This while Loop will repeat until current finishes going through all the Nodes in the column.
			 * What this does is references the next Node to equal the next next Node essentially 
			 * Deleting the currentnextNode. And this is repeated until the column ends.
			 */
			while(current != null) {
				current.nextCol = current.nextCol.nextCol;
				current = current.nextRow;
			}
		}
	}
	/**
	 * This method will delete a specific Row at the given index.
	 * @param index the Index where the user wishes to delete the Row.
	 */
	public void deleteRow(int index) {
		/**
		 * This if statement will check if the LinkedList is empty if so then a 
		 * IllegalStateException will be thrown since there is nothing to delete.
		 */
		if(head == null) {
			throw new IllegalStateException("The LinkedList is empty so there is nothing to delete");
		}
		/**
		 * This will check if the index is in bounds
		 */
		else if(index <0 || index > rowSize()) {
			throw  new  IndexOutOfBoundsException("Index Out of Bounds");
		}
		/**
		 * This is used since if there is only one row the rowSize will be 1 but there will be no index at 1, which will be out of 
		 * bounds. 
		 */
		else if(index == rowSize && rowSize == 1) {
			throw  new  IndexOutOfBoundsException("Index Out of Bounds");
		}
		/**
		 * If the index is 0 then the deleteFirstRow method will be called.
		 */
		else if(index == 0 ) {
			this.deleteFirstRow();
		}
		/**
		 * If the index is the last Row of the LinkedList then the delete lastRow method will be called.
		 */
		else if (index == rowSize()) {
			this.deleteLastRow();
		}
		/**
		 * First the rowSize will decrease by 1.
		 * Then there will be a current Node that will reference the head Node.
		 * After this we will use a for loop to traverse the current node to the 
		 * chosen Index.
		 */
		else {
			rowSize = rowSize-1;
			Array2DNode current = head;
			for( int i = 1; i < index;i++) {
				current = current.nextRow;
			}
			/**
			 * This while loop will go down the column and will make the current
			 * next Row equal to the current nextRow nextRow what this does is essentially,
			 * just skip the oldNextRow node so there will be nothing pointing to it.
			 * <b>
			 * Then the current node will update to the nextCol Node.
			 */
			while(current != null) {
				current.nextRow = current.nextRow.nextRow;
				current = current.nextCol;
			}
			
		}
	}
	/**
	 * The purpose of this is the get the item of a Node at a given index.
	 * @param rowIndex the Row where you would like to get the data from.
	 * @param colIndex the Col where you would like to get the data from.
	 * @return returns the E value item of the selected Node.
	 */
	public E get(int rowIndex, int colIndex) {
		/**
		 * This if statement checks if both RowIndex and colIndex are in bounds if not a exception is thrown.
		 */
		if(rowIndex < 0 || rowIndex >rowSize-1 || colIndex<0 || colIndex > colSize-1) {
			throw  new  IndexOutOfBoundsException("Index Out of Bounds");
		}
		/**
		 * This creates a current Node that is a referrence of the Head Node.
		 */
		Array2DNode current = head;
		/**
		 * This for loop will traverse the current Node by updating the current to the nextCol Node
		 * until the Node is at the correct Column.
		 */
		for(int i = 0; i < colIndex;i++) {
			current = current.nextCol;
		}
		/**
		 * This for loop will then traverse down the selected column by updating the current Node to the nextRow node
		 * and will update until the Node is at the correct Row.
		 */
		for(int i = 0; i < rowIndex;i++) {
			current = current.nextRow;
		}
		/**
		 * Once the current Node is at the current Index for both column and Row we will use a 
		 * getItem method for the current Node and then return the item of the current Node.
		 */
		return (E) current.getItem();
	}
	/**
	 * This method will return a ArrayList of the selected Column.
	 * @param colIndex The index of the column the user wishes to select.
	 * @return A arrayList of the entire column.
	 */
	public ArrayList<E> getCol(int colIndex){
		/**
		 * Creates a empty ArrayList.
		 */
		ArrayList<E> colList = new ArrayList<E>();
		/**
		 * This if statement will check if the ColIndex is valid if not then a exception will be thrown.
		 */
		if(colIndex < 0 || colIndex > colSize-1) {
			throw  new  IndexOutOfBoundsException("Index Out of Bounds");
		}
		/**
		 * This will create a current Node that references the head Node and then use 
		 * a forloop to traverse the columns until you are at the selected Column.
		 */
		Array2DNode current = head;
		for(int i = 0; i < colIndex;i++) {
			current = current.nextCol;
		}
		/**
		 * Once the current Node is at the correct column, we will use a while loop 
		 * to go down the column and add the Item of the current Node as it goes down the
		 *  column to the empty ArrayList.
		 */
		while(current != null) {
			colList.add((E)current.getItem());
			current = current.nextRow;
		}
		/**
		 * Return the arrayList populated with the column.
		 */
		return colList;
	}
	/**
	 * This method will return a ArrayList of the selected Row.
	 * @param rowIndex The row that the user selects.
	 * @return A arrayList populated with the appropriate Row.
	 */
	public ArrayList<E> getRow(int rowIndex){
		/**
		 * Creates a empty ArrayList.
		 */
		ArrayList<E> rowList = new ArrayList<E>();
		/**
		 * Checks if the rowIndex is valid if not then a IndexOutOfBounds exception is thrown.
		 */
		if(rowIndex < 0 || rowIndex > rowSize-1) {
			throw  new  IndexOutOfBoundsException("Index Out of Bounds");
		}
		/**
		 * This will create a current Node that is a reference of the Head node and then
		 * use a for loop to traverse to the selected Row.
		 */
		Array2DNode current = head;
		for(int i = 0; i < rowIndex;i++) {
			current = current.nextRow;
		}
		/**
		 * This while Loop will go down the entire Row column by column.
		 * And as the current Node updates the item inside the current Node will be added to the
		 * empty arrayList. Once the whileLoop ends then the ArrayList will be populated with the entire Row.
		 */
		while(current != null) {
			rowList.add((E)current.getItem());
			current = current.nextCol;
		}
		/**
		 * This will return the populated rowList.
		 */
		return rowList;
	}
	/**
	 * This method will change the item value of the Node at the selected Indexes.
	 * @param rowIndex The selected Row
	 * @param colIndex The selected Column
	 * @param item The item that you wish to put at this index.
	 */
	public void set(int rowIndex, int colIndex, E item) {
		/**
		 * This will check if both the row and column Indexes are valid, if not then
		 * a exception will be thrown.
		 */
		if(rowIndex < 0 || rowIndex >rowSize-1 || colIndex<0 || colIndex > colSize-1) {
			throw  new  IndexOutOfBoundsException("Index Out of Bounds");
		}
		/**
		 * This is similar to the get method where a currentNode is created and referencing the head Node.
		 * And once created it will use a for loop to make sure the current Node is at the appropriate Column, and then 
		 * use another for loop to make sure that the current Node is at  the correct Row.
		 * Once the current Node is in the correct place we will use the setItem Method for the Array2DNode
		 * and place the item that the user put inside the parameter.
		 */
		Array2DNode current = head;
		for(int i = 0; i < colIndex;i++) {
			current = current.nextCol;
		}
		for(int i = 0; i < rowIndex;i++) {
			current = current.nextRow;
		}
		current.setItem(item);
	}
	/**
	 * This method will return the rowSize 
	 * @return the rowSize.
	 */
	public int rowSize() {
		return this.rowSize;
	}
	/**
	 * This method will return the colSize.
	 * @return the ColSize.
	 */
	public int colSize() {
		return this.colSize;
	}
	/**
	 * returns a String representation of LinkedList.
	 */
	@Override
	public String toString() {
		/**
		 * Creates a empty String,
		 * then creates 2 references to the head one for the 
		 * current Row and one for the Current Column.
		 */
		String answer = "";
		Array2DNode<E> currentRow = this.head;
		Array2DNode<E> currentCol = this.head;
		/**
		 * This Nested While loop will Go row by row, and for 
		 * each row the While Loop on the inside will go column by column and this will repeat until all the 
		 * Nodes are collected.
		 */
		while(currentRow != null) {
			while(currentCol != null) {
				answer += String.valueOf(currentCol) + ", ";
				currentCol = currentCol.nextCol;
			}
			answer += "\n";
			currentRow = currentRow.nextRow;
			currentCol = currentRow;
			
		}
		/**
		 * Returns the String representation of the LinkedList.
		 */
		return answer;
	}
	/**
	 * This will return a String representation of the LinkedList presented 
	 * Column by Column instead of Row by Row.
	 * @return A String representation of the LinkedList column by column.
	 */
	public String toStringColByCol() {
		/**
		 * The first part of this method is similar to the original toString.
		 * Where there is a empty String first, and 2 references to the head Nodes
		 * CurrentRow and CurrentCol.
		 * 
		 */
		String answer = "";
		Array2DNode<E> currentRow = this.head;
		Array2DNode<E> currentCol = this.head;
		/*
		 * The difference for this method is that instead of having the nestWhile loop traverse Row by Row it will
		 * instead traverse Column by Column.
		 * What this does is adds a entire Column to the String and then goes to the Next Column and will continue until 
		 * the LinkedList ends.
		 */
		while(currentCol != null) {
			while(currentRow != null) {
				answer += String.valueOf(currentRow) + ", ";
				currentRow = currentRow.nextRow;
			}
			answer += "\n";
			currentCol = currentCol.nextCol;
			currentRow = currentCol;
			
		}
		return answer;
	}
}
