/* WORD LADDER Main.java
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
import java.io.*;

public class Main {
	
	public static String g_start; // Global for start word
	public static String g_end;	  // Global for end word
	
	public static void main(String[] args) throws Exception {
		
		Scanner kb;	// input Scanner for commands
		PrintStream ps;	// output file
		// If arguments are specified, read/write from/to files instead of Std IO.
		if (args.length != 0) {
			kb = new Scanner(new File(args[0]));
			ps = new PrintStream(new File(args[1]));
			System.setOut(ps);			// redirect output to ps
		} else {
			kb = new Scanner(System.in);// default from Stdin
			ps = System.out;			// default to Stdout
		}
		while(true){
		initialize(); // Unused
		ArrayList<String> input = parse(kb);
		//ArrayList<String> ladder = getWordLadderDFS(input.get(0), input.get(1));
		ArrayList<String> ladder = getWordLadderBFS(input.get(0), input.get(1));
		printLadder(ladder);
		}
	}
	
	/**
	 * initialize() is an unused function.
	 */
	public static void initialize() {
		// Unused
	}
	
	/**
	 * @param keyboard Scanner connected to System.in
	 * @return ArrayList of 2 Strings containing start word and end word. 
	 * If command is /quit, return empty ArrayList. 
	 */
	public static ArrayList<String> parse(Scanner keyboard) {
		String word_one = keyboard.next();
		String word_two = keyboard.next();
		if(word_one.equals("/quit") || word_two.equals("/quit")){
			System.exit(0);
		}
		ArrayList<String> input = new ArrayList<String>();
		input.add(word_one.toUpperCase());
		input.add(word_two.toUpperCase());
		return input;
	}
	
	/**
	 * Wrapper function that makes the dictionary and calls ComputeDFS.
	 * @param start is the word which is to be found. 
	 * @param end is the last word which would terminate the word ladder.
	 * @return Ordered ArrayList consisting of the words found using depth search.
	 */
	public static ArrayList<String> getWordLadderDFS(String start, String end) {
		start = start.toUpperCase();
		end = end.toUpperCase();
		g_start = start;
		g_end = end;
		Set<String> dict = makeDictionary();
		ArrayList<String>ans = DFS.ComputeDFS(start, end, dict);
		if(!(ans.isEmpty())){
			ans.add(start);
			Collections.reverse(ans);
		}
		return ans;
	}
	
	/**
	 * Wrapper function that makes the dictionary and calls runBFS.
	 * @param start is the starting word in the ladder.
	 * @param end is the ending word in the ladder.
	 * @return the ordered word ladder.
	 */
    public static ArrayList<String> getWordLadderBFS(String start, String end) {
		start = start.toUpperCase();
		end = end.toUpperCase();
		g_start = start;
		g_end = end;
    	Set<String> dict = makeDictionary();
		ArrayList<String> ladder = BFS.runBFS(start, end, dict);
		if(!(ladder.isEmpty())){
			Collections.reverse(ladder);
		}
		return ladder;
	}
    
    /**
     * (PROVIDED FUNCTION) Parses the dictionary file into a set.
     * @return the dictionary as a set.
     */
	public static Set<String>  makeDictionary () {
		Set<String> words = new HashSet<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new File("five_letter_words.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File not Found!");
			e.printStackTrace();
			System.exit(1);
		}
		while (infile.hasNext()) {
			words.add(infile.next().toUpperCase());
		}
		return words;
	}
	
	/**
	 * Flips the word ladder and prints it.
	 * @param ladder is the ordered word ladder from either ComputeDFS or runBFS.
	 */
	public static void printLadder(ArrayList<String> ladder) {
		if(ladder.isEmpty()){
			System.out.println("no word ladder can be found between "+(g_start.toLowerCase())+" and "+(g_end.toLowerCase())+".");
			return;
		}
		System.out.println("a "+(ladder.size()-2)+"-rung word ladder exists between "+(ladder.get(0).toLowerCase())+" and "+(ladder.get(ladder.size()-1).toLowerCase())+".");
		for(int i = 0; i < ladder.size(); i++){
			System.out.println(ladder.get(i).toLowerCase());
		}
		
	} 
}