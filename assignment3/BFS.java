package assignment3;

import java.util.*;

public class BFS{
	
	private static ArrayList<String> GenerateLadderBFS(FIFONode endnode){
		ArrayList<String> ladder = new ArrayList<String>();
		ladder.add(endnode.word);
		String retrace = endnode.word;
		for (int i = endnode.index.size() -1; i >= 0; i-- ){
			char [] retracechar = retrace.toCharArray();
			retracechar[endnode.index.get(i)] = endnode.value.get(i);
			retrace = String.copyValueOf(retracechar);
			ladder.add(retrace);
		}
		return ladder;
		
	}
	
	private static void OneLetterOffBFS(FIFONode parent, Set<String> dictionary, LinkedList<FIFONode> FIFO){
		char [] wordarray = parent.word.toCharArray();
		char[]copyarray = Arrays.copyOf(wordarray, parent.word.length());
		
		for(int k = 0; k < 5;k++){
			for(char b = 'A';b <= 'Z'; b++){
				if(wordarray[k] == b){}
				else{
					copyarray[k] = b;	
					String checkword = String.valueOf(copyarray);
					if(dictionary.contains(checkword)){
						Integer k_int = Integer.valueOf(k);
						Character b_char = Character.valueOf(wordarray[k]);
						FIFONode newnode = new FIFONode(parent, checkword, k_int, b_char);
						FIFO.add(newnode);
						dictionary.remove(checkword);
					}		
				}
			}
			copyarray[k]= wordarray[k];
		}
		return;
	}
	
	public static ArrayList<String> runBFS(String start, String end, Set<String> dictionary){ 
		LinkedList<FIFONode> FIFO = new LinkedList<FIFONode>();
	
		FIFONode startnode = new FIFONode(start);
	
		FIFO.add(startnode);
		dictionary.remove(startnode);
	
		while(!(FIFO.isEmpty())){
			FIFONode top_node = FIFO.remove();
			if(top_node.word.equals(end)){
				ArrayList<String> ladder = GenerateLadderBFS(top_node);
				return ladder;
			}
			OneLetterOffBFS(top_node, dictionary, FIFO);
		}
		ArrayList<String> emptyArrayList = new ArrayList<String>();
		return emptyArrayList;
	}
}
