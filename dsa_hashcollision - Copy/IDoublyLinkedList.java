package dsa_hashcollision;

public interface IDoublyLinkedList {
	public void add(int k);				// appends the specified integer to the end of the list
	public void add(int index, int k);	// inserts the specified integer at the specified position index in the list, adds it to the end of the list if the index is the length of the current index, and throws an error otherwise
	public void clear();				// removes all the integers from the list
	public boolean contains(int k);		// returns true if the list contains a specified integer, false otherwise
	public int get(int index);			// returns the integer at the specified position in the list, and throws an error if the list doesn't have that index
	public int getFirst();				// returns the first integer in the list or throws an error if the list is empty
	public int getLast();				// returns the last integer in the list or throws an error if the list is empty
	public int indexOf(int k);			// returns the index in the list of the first occurrence of the specified integer, or -1 if the list does not contain that integer
	public int length();				// returns the number of integers in the list, or 0 if the list does not contain any integers
	public int peekFirst();				// returns the first integer of the list or throws an error if the list is empty
	public int peekLast();				// returns the last integer of the list or throws an error if the list is empty
	public int popFirst();				// returns the first integer of the list and removes it from the list, or throws an error if the list is empty
	public int popLast();				// returns the last integer of the list and removes it from the list, or throws an error if the list is empty
	public void print();				// prints the list beginning with "[", then the integers with spaces separating each, then a "]", and prints [] if the list is empty
	public void printReverse();			// prints the list beginning with "[", then the integers in reverse order with spaces separating each, then a "]", and prints [] if the list is empty
	public void remove(int index);		// removes the integer at the specified position in the list, and throws an error if the list doesn't have that index
	public void set(int index, int k);	// sets a new value for the integer at the specified position in the list, and throws an error if the list doesn't have that index
}
