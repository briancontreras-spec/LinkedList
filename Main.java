package hw04;
/**
 * The purpose of this class is to test all of the methods for the 2dLinkedList.
 * @author Brian Contreras,  400400309, CS-2013, Sections 03 & 04
 * https://calstatela.instructuremedia.com/embed/32762e5f-fb0f-4bbc-a9d0-64d0102c1394
 *
 */
public class Main {

	public static void main(String[] args) {
		Integer[][] intArr = {
				{1,2,3,4,5,6},
				{7,8,9,10,11,12},
				{13,14,15,16,17,18}				
		};
		Array2D testList = new Array2D(intArr);
		Array2D emptyTestList = new Array2D();
		System.out.println("Testing the Constructor that accepts values, intArr");
		System.out.println(testList);
		System.out.println();
		System.out.println("Testing if the Empty Constructor works:");
		System.out.println(emptyTestList);
		System.out.println("Nothing printed becasue there is nothing in the list");
		System.out.println();
		//Testing out the Add First and Last Methods
		System.out.println("Adding the first column to the TestList and the empty List");
		testList.addFirstCol(10,20,30);
		emptyTestList.addFirstCol(10,20,30);
		System.out.println("Printing out the new TestList with added col:");
		System.out.println(testList);
		System.out.println("Printing out the new emptyTestlist with added col:");
		System.out.println(emptyTestList);
		System.out.println();
		System.out.println("Checking if the proper exception is thrown");
		try {
			testList.addFirstCol(0);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		Array2D emptyTestList1 = new Array2D();
		System.out.println("Testing out the addFirstRow methods");
		testList.addFirstRow(100,200,300,400,500,600,700);
		System.out.println(testList);
		
		System.out.println("Testing out the addFirstRow method in a empty LinkedList");
		emptyTestList1.addFirstRow(10,20,30,40);
		System.out.println(emptyTestList1);
		System.out.println("Testing out the improper value input");
		try {
			testList.addFirstRow(0);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		//Testing out the Last Col and Last Row
		testList.addLastCol(11,22,33,44);
		emptyTestList = new Array2D();
		emptyTestList.addLastCol(11,22,33,44);
		System.out.println(testList);
		System.out.println(emptyTestList);
		try {
			testList.addLastCol(0);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		//Testing the Last Row
		testList.addLastRow(111,222,333,444,555,666,777,888);
		System.out.println(testList);
		emptyTestList = new Array2D();
		emptyTestList.addLastRow(10,20,30,40);
		System.out.println(emptyTestList);
		try {
			testList.addLastRow(0);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		testList = new Array2D(intArr);
		emptyTestList = new Array2D();
		emptyTestList.insertCol(0, 10,20,30);
		emptyTestList.insertRow(2, 100);
		System.out.println(emptyTestList);
		emptyTestList = new Array2D();
		emptyTestList.insertRow(0, 10,20,30,40);
		System.out.println(emptyTestList);
		
		emptyTestList = new Array2D();
		try {
		emptyTestList.insertRow(1, 10,20,30,40);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("herllo");
		emptyTestList = new Array2D();
		try {
		emptyTestList.insertCol(1, 10,20,30,40);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		testList.deleteFirstCol();
		
		System.out.println(testList);
		testList.deleteFirstRow();
		System.out.println(testList);
		
		testList.deleteLastCol();
		System.out.println(testList);
		
		testList.deleteLastRow();
		System.out.println(testList);
		
		testList.deleteCol(2);
		System.out.println(testList);
		
		testList.deleteRow(0);
		System.out.println(testList);
		emptyTestList = new Array2D();
		try {
			emptyTestList.deleteCol(0);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		testList = new Array2D(intArr);
		System.out.println(testList);
		System.out.println(testList.get(1, 5));
		System.out.println(testList.getCol(0));
		System.out.println(testList.getRow(0));
		
//		System.out.println(emptyTestList.getRow(0));
		System.out.println(testList);
		System.out.println();
		System.out.println(testList.toStringColByCol());
		
		testList.set(1, 5, 1000);
		System.out.println(testList);
		
		

		}
}
