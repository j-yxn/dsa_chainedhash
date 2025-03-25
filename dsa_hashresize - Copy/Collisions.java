package dsa_hashresize;

public class Collisions {
	private static final int DATA_SIZE = 100;
	private static final int DATA_MAX = 800;
	private static final int HASH_TABLE_SIZE = 300;
	
	public static void main(String[] args) {
		// create a new hash table
		ChainingHashTable chain = new ChainingHashTable();
		
		// generate data to fill the hash table
		int[] data = new int[DATA_SIZE];
		for (int i = 0; i < DATA_SIZE; i++) {
			int item = (int)(Math.random() * DATA_MAX);
			data[i] = item;
		}
		
		// fill the table and print the resultant hashing
		chain.create(HASH_TABLE_SIZE);
		chain.fill(data);
		chain.print();
		chain.resize(HASH_TABLE_SIZE + 100);
		chain.print();
	}
}
