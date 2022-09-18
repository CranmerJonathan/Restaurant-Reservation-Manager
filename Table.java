// Assignment: Assignment 10
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: This class is a blueprint for the table object.

public class Table {
    String name;
    int guests;
    Table next;
    
    public Table(int n, String name){
        this.name = name;
        guests = n;
        next = null;
    }
    

    public String toString(){
        return "\nReservation for " + name + ": party of "
                + guests + ".\n";
    }

    public class EmptyTable extends Table{

        public EmptyTable() {
            super(-1, "");
        }
    }
}

