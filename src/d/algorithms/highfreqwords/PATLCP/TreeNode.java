package d.algorithms.highfreqwords.PATLCP;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {
	
	private Character word;
	
	private boolean isWholeWord = false; //ÊÇ·ñ³É´Ê
	
	private String wholeWord = "";
	
	private int freq;
	
	private Map<Character,TreeNode> child = null;
	
	public TreeNode(Character c){
		this.word = c;
	}

	public Character getWord() {
		return word;
	}

	public boolean isWholeWord() {
		return isWholeWord;
	}

	public void setWholeWord(boolean isWholeWord) {
		this.isWholeWord = isWholeWord;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public Map<Character,TreeNode> getChild() {
		return child;
	}

	public void setChild(TreeNode node) {
		if(child == null){
			child = new HashMap<Character,TreeNode>();
		}
		child.put(node.getWord(), node);
	}

	public String getWholeWord() {
		return wholeWord;
	}

	public void setWholeWord(String wholeWord) {
		this.wholeWord = wholeWord;
	}
	
}
