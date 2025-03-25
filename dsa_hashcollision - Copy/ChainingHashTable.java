package dsa_hashcollision;

public class ChainingHashTable implements IHashTable {
    private DoublyLinkedList[] table;
    private int count = 0;
    
    // create a new, empty hash table of the indicated size
    public void create(int size) {
        count = 0;
        table = new DoublyLinkedList[size];
        
        for (int i = 0; i < size; i++) {
            table[i] = new DoublyLinkedList();
        }
    }
    
    // create a new, empty hash table of the indicated size, and fill it with data
    public void create(int size, int[] data) {
        create(size);
        fill(data);
    }
    
    // fill the hash table with data contained in an integer array
    public void fill(int[] data) {
        if (table == null) {
            throw new HashTableError("The hash table has not been initialized");
        }
        
        if (data.length + count > table.length) {
            throw new HashTableError("Data length: " + data.length + " plus existing data size: " + count + " is greater than the hash table size: " + table.length);
        }
        
        for (int i = 0; i < data.length; i++) {
            insert(data[i]);
        }
    }
    
    // insert a new value into the hash table
    public void insert(int value) {
        if (table == null) {
            throw new HashTableError("The hash table has not been initialized");
        }
        
        if (count == table.length) {
            throw new HashTableError("The hash table is full");
        }
        
        int hashVal = getHash(value);
        placeValueInTable(hashVal, value);
        
        count++;
    }
    
    // this returns the result of your hash function
    public int getHash(int value) {
        if (table == null) {  // Note: We need the error checks here
            throw new HashTableError("The hash table has not been initialized");
        }
        
        if (table.length == 0) {  // since the method can be called directly
            throw new HashTableError("The hash table is empty");
        }
        
        long hash = 1;
        String v = String.valueOf(value);
        for (int i = 0; i < v.length(); i++) {
            hash = (hash + v.charAt(i)) * 23;
        }
        
        return (int)(hash % table.length);
    }
    
    // attempt to place a given value at a specified hash slot, handling collisions if they occur
    private void placeValueInTable(int hash, int value) {
        DoublyLinkedList list = table[hash];
        list.add(value);
    }
    
    // print the table slots and any items those slots contain
    public void print() {
        for (int i = 0; i < table.length; i++) {
            table[i].print();
        }
    }
}