package assignment3;

import java.util.*;

public class DFS {
	
	/**
	 * Private helper function for ComputeDFS. Mutates a word to generate other words.
	 * @param word is the String for which mutations are to be found.
	 * @param Input is the set of words remaining in the dictionary.
	 * @return ArrayList comprising of all the words remaining 
	 * in the dictionary which differ from word by one letter.
	 */
	private static ArrayList <String> oneletteroff(String word, Set<String> Input){

		char [] wordarray = word.toCharArray();
		char[]copyarray = Arrays.copyOf(wordarray, word.length());

	
		ArrayList <String>a1 = new ArrayList<String>();
		for(int k =0; k<5;k++){
			for(char b = 'A';b<='Z';b++){
				if(wordarray[k]==b){}
				else{
					copyarray[k]=b;	
					String checkword = String.valueOf(copyarray);
					if(Input.contains(checkword)){
						a1.add(checkword);
					}
				}
			}
			copyarray[k]= wordarray[k];
		}
		return a1;
	}

	/**
	 * Performs a Depth-First Search to generate a word ladder.
	 * @param start is the word which is to be found. 
	 * @param end is the last word which would terminate the word ladder.
	 * @param Dictionary is the set of words to be checked.
	 * @return Flipped ArrayList consisting of the words found using depth search.
	 */
	public static ArrayList<String> ComputeDFS(String start, String end, Set<String>Dictionary){
		String newstart = start.toUpperCase();
		String newend =end.toUpperCase();
		Dictionary.remove(newstart);
		ArrayList<String> a2 = oneletteroff(start,Dictionary);
		int checklength =a2.size();
		if (checklength ==0){
			ArrayList<String> a3 = new ArrayList<String>();
			return a3;
		}
		if(a2.contains(newend)){
			ArrayList<String> ans = new ArrayList<String>(Arrays.asList(end));
			return ans;
		}
		Dictionary.removeAll(a2);
	
		for(int count =0; count<checklength;count++){
			
			ArrayList<String> DownTheRabbitHole = ComputeDFS(a2.get(count),end,Dictionary);
			if(DownTheRabbitHole.isEmpty()){}
			else{
				String tobeadded =a2.get(count);
				DownTheRabbitHole.add(tobeadded);
				return DownTheRabbitHole;
			}	
		}
	
		ArrayList<String> a4 = new ArrayList<String>();
		return a4;
	}
}
