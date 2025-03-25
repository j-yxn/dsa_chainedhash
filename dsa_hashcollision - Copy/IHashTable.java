package dsa_hashcollision;

public interface IHashTable {
	public void create(int size);	// create a new, empty hash table of the indicated size
	public void fill(int[] data);	// fill the hash table with data contained in an integer array
	public void insert(int value);	// insert a new value into the hash table
	public int getHash(int value);	// this returns the result of your hash function
	public void print();			// print the table slots and any items those slots contain
	
	/* As part of the interface, any class implementing this interface will get this error class "for free". */
	public class HashTableError extends RuntimeException {
		static final long serialVersionUID = 0;
		
	    public HashTableError(String errorMessage) {
	        super(errorMessage);
	    }
	}
}
