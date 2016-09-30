/* WORD LADDER FIFONode.java
 * EE422C Project 3 submission by
 * Replace <...> with your actual data.
 * <Abhinav Mohan>
 * <am73643>
 * <16455>
 * <Dhruv Mathew>
 * <dkm989>
 * <16455>
 * Slip days used: <0>
 * Git URL: https://github.com/dhruvm96/WordLadder
 * Fall 2016
 */

package assignment3;
import java.util.*;
public class FIFONode { // Payload for FIFO
	public String word;  // The word contained in the FIFONode
	public ArrayList<Integer> index = new ArrayList<Integer>();     // Keeps track of all the changes (indexes)
	public ArrayList<Character> value = new ArrayList<Character>(); // Keeps track of all the changes (values)
	
	public FIFONode(String word){ // For the first FIFONode
		this.word = word;
	} 
	
	public FIFONode(FIFONode b, String word, Integer index_of_change, Character value_of_change){ // For the other FIFONodes
		this.word = word;
		for(int i =0;i<b.index.size();i++){
			this.index.add(b.index.get(i));
		}
		this.index.add(index_of_change);
		for(int i =0;i<b.index.size();i++){
			this.value.add(b.value.get(i));
		}
		this.value.add(value_of_change);
	}
}