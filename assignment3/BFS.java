package assignment3;

import java.util.*;

public class BFS{
	
	
	public static ArrayList<String> runBFS(String start, String end, Set<String> dictionary){ 
		LinkedList<FIFONode> FIFO = new LinkedList<FIFONode>();
	
		FIFONode startnode = new FIFONode(start, 7, 'a');
		FIFONode endnode = new FIFONode(end, 8, 'a');
	
		FIFO.add(startnode);
		dictionary.remove(startnode);
	
		while(!(FIFO.isEmpty())){
			String top_word = FIFO.remove().word;
			if(top_word.equals(endnode.word)){
				//TODO create ArrayList
			}
			//TODO progress
		}
		ArrayList<String> emptyArrayList = new ArrayList<String>();
		return emptyArrayList;
	}
}
