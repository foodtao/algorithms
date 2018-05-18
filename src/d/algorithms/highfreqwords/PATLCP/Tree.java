package d.algorithms.highfreqwords.PATLCP;

public class Tree {
	
	private TreeNode rootNode = null;
	
	public Tree(){
		rootNode = new TreeNode(new Character((char)0));
	}
	
	/**
	 * 添加词到词树中
	 * @param str 词
	 * @param isReverse 是否反向
	 */
	public void addWords(String str,int freq,boolean isReverse){
		
		char[] charArray = str.toCharArray();
		int begin = 0;
		if(isReverse){
			begin = charArray.length - 1;
		}
		
		addWords(rootNode,charArray,begin,freq,isReverse);
		
	}
	
	public TreeNode getRootNode(){
		return rootNode;
	}
	
	private void addWords(TreeNode parent,char[] charArray,int begin, int freq,boolean isReverse){
		
//		if(charArray[begin] == '墅'){
//			System.out.println("");
//		}
		
		Character c = charArray[begin];
		TreeNode node = new TreeNode(c);
		
		if(parent.getChild() == null || !parent.getChild().containsKey(c)){
			parent.setChild(node);
		}else{
			node = parent.getChild().get(c);
		}
		
		if((isReverse && begin == 0) || (!isReverse && begin == charArray.length - 1)){
			node.setFreq(freq);
			node.setWholeWord(true);
			node.setWholeWord(String.valueOf(charArray));
		}else{

			if(isReverse){
				begin--;
			}else{
				begin++;
			}
			
			addWords(parent.getChild().get(c),charArray,begin,freq,isReverse);
		}
		
	}
	
	
	
}
