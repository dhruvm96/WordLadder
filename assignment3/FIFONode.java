package assignment3;
import java.util.*;
public class FIFONode {
	public String word;
	public ArrayList<Integer> index = new ArrayList<Integer>();
	public ArrayList<Character> value = new ArrayList<Character>();
	
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
