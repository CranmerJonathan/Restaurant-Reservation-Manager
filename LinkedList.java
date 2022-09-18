// Assignment: Assignment 10
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: This class constructs the Linked List.


public class LinkedList {
	//Declaring/initiating variables
    Table first;
    int size;
    private EmptyTable emptyTable = new EmptyTable();
    String listReservations;
    
    //Linked List constructor
    public LinkedList(){
        first = null;
        size = 0;
    }

    //Method to add Table objects
    public void add(int numberOfGuests, String name){
        Table newGuest = new Table(numberOfGuests, name);
        if(first == null){
            first = newGuest;
        }
        else{
            Table pointer = first;
            while(pointer.next != null)
                pointer = pointer.next;

            pointer.next = newGuest;
        }
        size++;
    }
    
    //Method to remove first table object
    public Table removeFirst() {
    	Table returned = first;
    	if (first != null) {
    		first = first.next;
    		size--;
    		return returned;
    		
    	}
    	return emptyTable;
    }
    
    //Method to remove last table object
    public Table removeLast() {
    	Table pointer = first;
    	if (size == 0) {
    		return null;
    	}
    	while (pointer.next.next != null) {
    		pointer = pointer.next;
    	}
    	Table pointer2 = pointer.next;
    	pointer.next = pointer2.next;
    	size--;
    	return pointer2;
    }
    
    //method to remove requested table object
    public Table removeMiddle(String name) {
    	Table pointer = first;
    	
    	if (size == 0) {
    		return null;
    	}
    	
    	int index = getPosition(name);
    	
    	for (int i = 0; i < index - 1; i++) { 
    		pointer = pointer.next;
    	}
    	Table t = pointer.next;
    	pointer.next = t.next;
    	size--;
    	return t;
    }
    
    //Method to remove table with a specific guest amount
    public Table removeGuest(String guest) {
    	if (size == 0) {
    		return emptyTable;
    	}
    	int position = getPosition(guest);
    	
    	if (position == 0) {
    		return removeFirst();
    	}
    	else if (position == size - 1) {
    		return removeLast();
    	} 
    	else if (position == -1) {
    		return emptyTable;
    	}
    	else {
    		return removeMiddle(guest);
    	}
    }
    
    //Method to get poisition of desired table
    public int getPosition(String name) {
    	Table pointer = first;
    	int i = 0;
    	
    	while (pointer != null) {
    		if (name.compareTo(pointer.name) == 0) {
    			return i;
    		}
    		pointer = pointer.next;
    		i++;
    	}
    	
    	return -1;
    }
    
    //Method to get number of tables with desired number of guests
    public int getNumberOfParties(int numGuest) {
    	Table pointer = first;
    	int i = 0;
    	int j = 0;
    	for (i = 0; i < size; i ++) {
    		if (numGuest == pointer.guests) {
    			j++;
    		}
			pointer = pointer.next;
    	}
    	
    	return j;
    }
    
    //Method to list Tables
    public String listReservations() {
    	listReservations = "";
    	Table pointer = first;
    	if (pointer == null) {
    		listReservations = "No reservations in queue at this time.\n";
    	}
    	else {
    		while (pointer != null) {
    			listReservations += pointer.toString();
    			pointer = pointer.next;
    		}
    		listReservations += "\nTotal reservations: " + size + ".\n";
    	}
    	return listReservations;
    }
}
