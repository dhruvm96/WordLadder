package assignment3;
// TODO Fix This
public class FIFONode {
	public String word;
	public int index_changed; // 7 = start node, 8 = end node
	public char changed_to;
	
	public FIFONode(){}
	
	public FIFONode(String word, int index_changed, char changed_to){
		this.word = word;
		this.index_changed = index_changed;
		this.changed_to = changed_to;
	}
}
