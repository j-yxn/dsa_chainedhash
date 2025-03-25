package dsa_hashcollision;


public class DoublyLinkedList implements IDoublyLinkedList {
    // Node definition for doubly linked list
    public class Node{
        int data;                   // holds the integer
        Node next;                  // acts as the pointer to the next member of the list
        Node prev;                  // acts as the pointer to the previous member of the list
        public Node(int data) {        // constructor for the new node
            this.data = data;       // having this as the only line ensures the next and prev values will be null by default
        }
    }  
    
    // initially head and tail pointers point to null
    private Node head = null;
    private Node tail = null;
    private int length = 0;
    
    
    // appends the specified integer to the end of the list
    public void add(int k) {
        Node kNode = new Node(k);
    	// veriiying if the  list is empty
        if (head == null) {
        	// set head to k
            head = kNode;
            // set tail to head;
            tail = kNode;
        } else {
        	// set tail's next pointer to k
            tail.next = kNode;
            kNode.prev = tail;
            // set tail to its next pointer
            tail = tail.next;
        }
        // increment list length by 1
        length++;
    }
    
    // inserts the specified integer at the specified position index in the list, adds it to the end of the list if the index is the length of the current index, and throws an error otherwise
    public void add(int index, int k) {
    	// if index inputted is less than 0 or more than the list length
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index Out of Bounds Error, try again.");
        }
        // create a new node with integer k
        Node kNode = new Node(k);
        // if the index is at the beginning of the list
        if (index == 0) {
        	kNode.next = head;
            if (head != null) {
                head.prev = kNode;
            }
            head = kNode;
            // if the list is empty, update the tail to the new node
            if (tail == null) {
                tail = kNode;
            }
         // if the index is at the end of the list
        } else if (index == length) {
            tail.next = kNode;
            kNode.prev = tail;
            tail = kNode;
         // if the index is in the middle of the list
        } else {
            Node point = head;
            // for loop through the list
            for (int i = 0; i < index - 1; i++) {
            	point = point.next;
            }
            // insert the new node at index
            kNode.next = point.next;
            kNode.prev = point;
            point.next = kNode;
            kNode.next.prev = kNode;
        }
        // increment list length by 1
        length++;
    }
	
    // removes all the integers from the list
	public void clear() {	 
		head = null;
	    tail = null;
	    length = 0;
	}
	
	// returns true if the list contains a specified integer, false otherwise
	public boolean contains(int k) {
		// start at the beginning of the list
      	Node point = head;
      	// while loop through the list until the end is reached
		while (point != null) {
			// if the current node is the value k
      		if (point.data == k) {
      			// return true
                return true;
            }
      		// move on to the next node in the list
      		point = point.next;
        }
		// if k was not found, return false
        return false;
	}
	
	// returns the integer at the specified position in the list, and throws an error if the list doesn't have that index
	public int get(int index) {		
		// if index inputted is less than 0 or more than the list length
		if (index < 0 || index > length) {
			throw new IndexOutOfBoundsException("Index Out of Bounds Error, try again.");
        }		
		// start at the beginning of the list
		Node point = head;
        for (int i = 0; i < index; i++) {
        	point = point.next;
        }
        // return the integer value at index
        return point.data;
	}
	
	// returns the first integer in the list or throws an error if the list is empty
	public int getFirst() {	
		// if the list is empty
	    if (head == null) {
            throw new IllegalStateException("List is empty, try again.");
        }
	    // return the value of the first element in the list
		return head.data;
	}
	
	// returns the last integer in the list or throws an error if the list is empty
	public int getLast() {	
		// if the list is empty
		if (tail == null) {
	            throw new IllegalStateException("List is empty, try again.");
	        }
		// return the value of the last element in the list
		return tail.data;
	}
		
	// returns the index in the list of the first occurrence of the specified integer, or -1 if the list does not contain that integer
	public int indexOf(int k) {	
		// start at the beginning of the list
		Node point = head;
		// initialize an index variable to store the current position 
	    int index = 0;
	    // while loop through the list until the end is reached
	    while (point != null) {
	    	// if the current node contains k
	    	if (point.data == k) {
	    		 // return the index 
	    		return index;
	    	}
	    	// move to the next node in the list
	    	point = point.next;
	    	// increment the index by 1
	    	index++;
	    }
	    // if k was not found, return -1
	    return -1;
	}
	
	// returns the number of integers in the list, or 0 if the list does not contain any integers
	public int length() {		
		return length;
	}
	
	// returns the first integer of the list or throws an error if the list is empty
	public int peekFirst() {			
		return getFirst();
	}
	
	// returns the last integer of the list or throws an error if the list is empty
	public int peekLast() {				
		 return getLast();
	}
	
	// returns the first integer of the list and removes it from the list, or throws an error if the list is empty
	public int popFirst() {
		// if the list is empty
		if (head == null) {
			 throw new IllegalStateException("List is empty, try again.");
		}
		// store the value of the first element
        int value = head.data;
        // shift the head to the next node
        head = head.next;
        // if the list is not empty after changes, update the prev pointer of the new head to null
        if (head != null) {
            head.prev = null;
        } else {
            // if the list is empty after changes, update tail to null
            tail = null;
        }
        // decrement the list length by 1
        length--;
        // return the removed value
        return value;
	}
	
	// returns the last integer of the list and removes it from the list, or throws an error if the list is empty
	public int popLast() {	
		// if the list is empty
		if (head == null) {
			 throw new IllegalStateException("List is empty, try again.");
		}	
        // store the value of the last element
        int value = tail.data;
        // if there is only one element in the list
        if (head == tail) {
            // set head and tail to null
            head = null;
            tail = null;
        } else {
            // update tail to the previous node
            tail = tail.prev;
            // set next pointer of the new tail to null
            if (tail != null) {
                tail.next = null;
            }
        }
        // decrement the list length by 1
        length--;
        // return the removed value
        return value;
	}
	
	// prints the list beginning with "[", then the integers with spaces separating each, then a "]", and prints [] if the list is empty
	public void print() {				
		System.out.print("[");
		// start at the beginning of the list
        Node point = head;
        while (point != null) {
            System.out.print(point.data);
            // move to the next node in the list
            point = point.next;
            // if there is another value in the list, print a space
            if (point != null) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
	}

    // prints the list beginning with "[", then the integers in reverse order with spaces separating each, then a "]", and prints [] if the list is empty
    public void printReverse() {
        if (tail == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" ");
            }
            current = current.prev;
        }
        System.out.println("]");
    }   
	
	// removes the integer at the specified position in the list, and throws an error if the list doesn't have that index
	public void remove(int index) {
		// if index inputted is less than 0 or more than the list length
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index Out of Bounds Error, try again.");
        }
        // if the specified index is at the beginning of the list
        if (index == 0) {
        	// move the head to the next node
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;  
            }
         // else if the index is in the middle or at the end of the list
        } else {
            Node point = head;
            for (int i = 0; i < index - 1; i++) {
            	point = point.next;
            }
            // remove the node at the index by updating the next and prev pointers
            point.next = point.next.next;
            if (point.next != null) {
                point.next.prev = point;
            } else {
                tail = point;  
            }
        }
        // decrement the length of the list
        length--;
    }

	// sets a new value for the integer at the specified position in the list, and throws an error if the list doesn't have that index
	public void set(int index, int k) {		
		// if index inputted is less than 0 or more than the list length
		if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index Out of Bounds Error, try again.");
        }
		// start at the beginning of the list
        Node point = head;
        for (int i = 0; i < index; i++) {
        	point = point.next;
        }
        // set the value of the node at the  index to k
        point.data = k;
	}
}