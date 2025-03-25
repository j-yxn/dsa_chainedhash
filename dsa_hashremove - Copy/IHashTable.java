package dsa_hashremove;

public interface IHashTable {
	public void create(int size);	// create a new, empty hash table of the indicated size
	public void fill(int[] data);	// fill the hash table with data contained in an integer array
	public void insert(int value);	// insert a new value into the hash table
	public int getHash(int value);	// this returns the result of your hash function
	public void print();			// print the table slots and any items those slots contain
	public void resize(int size);	// resize the table to the new size, and re-slot all existing items
	public int search(int k);		// find the value k in the table, returning it's bucket number, or -1 if it is not found
	public boolean remove(int k);	// remove the first instance of k found in the table, returns true if found, false otherwise
	
	/* As part of the interface, any class implementing this interface will get this error class "for free". */
	public class HashTableError extends RuntimeException {
		static final long serialVersionUID = 0;
		
	    public HashTableError(String errorMessage) {
	        super(errorMessage);
	    }
	}
}
