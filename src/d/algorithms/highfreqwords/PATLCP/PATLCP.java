package d.algorithms.highfreqwords.PATLCP;

import java.util.List;

import d.algorithms.utils.FileHelper;
import d.algorithms.utils.StringHelper;

public class PATLCP {
	
	public static void main(String[] args){
		
		String[] keywords = {"如家快捷酒店","汉庭酒店","莫泰快捷酒店"};
		
		String[] suffixWords = new String[500];
		
		String[] patArray = generatePATArray();
		
		int[] patSortArray = sortPAT(patArray);
		
		for(int i = 0;i<patArray.length;i++){
			System.out.print(patArray[i] + ",");
		}
		System.out.println("");
		
		for(int j = 0;j<patSortArray.length;j++){
			System.out.print(patArray[patSortArray[j]] + ",");
		}
	}
	
	
	/**
	 * 生产Pat数组
	 * @return
	 */
	private static String[] generatePATArray(){
		
		String[] pat = new String[500];
		int index = 0;
		
		List<String> names = FileHelper.loadData("D:\\MyConfiguration\\zfd13587\\Desktop\\corpus1.txt");
		
		for(String name : names){
			if(!name.isEmpty()){
				name = name.trim();
				for(int i = 0;i<name.length() -1;i++){
					pat[index] = name.substring(i,name.length());
					index++;
					if(index >= pat.length){
						pat = extendArray(pat);
					}
				}
			}
		}
		
		for(int i=pat.length-1;i>=0;i--){
			
		}
		
		return  pat;
	}
	
	/**
	 * 对pat采用基数排序进行排序
	 * @param pat
	 * @return 排序后的数组，存源数组对应字符串的下标
	 */
	private static int[] sortPAT(String[] patArray){
		
		Vertex[] patsortArray = new Vertex[500];
		
		int sortIndex = 0; //排第几位，0表示最后一位，1表示最后第二位，以此类推
		
		int arrayIndex = 0; //pat数组的索引
		
		int maxStringLength = 0;
		
		//将pat数组放到邻接链表中，并按字符串的最后一位ascii码排序
		//并记录最长的字符串，用于决定后面要重拍多少次
		for(String pat : patArray){
			if(pat == null || pat.isEmpty()){
				continue;
			}
			if(pat.length() > maxStringLength){
				maxStringLength = pat.length();
			}
			
			int ascii = StringHelper.singleCahrToNum(pat.substring(pat.length() - 1,pat.length()));
			if(ascii > patsortArray.length){
				patsortArray = extendArrayEnsureLength(patsortArray, ascii);
			}
			
			if(patsortArray[ascii] != null){
				Edge edge = new Edge();
				edge.wordIndex = arrayIndex;
				edge.sortIndex = sortIndex;
				
				Edge link = patsortArray[ascii].link;
				if(link == null){
					patsortArray[ascii].link = edge;
				}else{
					while(link.nextLink != null){
						link = link.nextLink;
					}
					link.nextLink = edge;
				}
				
			}else{
				Vertex vertex = new Vertex();
				Edge edge = new Edge();
				edge.wordIndex = arrayIndex;
				vertex.link = edge;
				patsortArray[ascii] = vertex;
			}
			arrayIndex++;
		}
		
		//调整邻接链表，进行基数排序
		sortIndex++;
		for(int i = 1;i<maxStringLength;i++){
			for(Vertex vertex : patsortArray){
				if(vertex != null && vertex.link != null){
					Edge edge = vertex.link;
					while(edge != null){
						if(edge.sortIndex != sortIndex){
							edge.sortIndex = sortIndex;
							vertex.link = edge.nextLink;
							edge.nextLink = null;
							String name = patArray[edge.wordIndex];
							
							int index = 0;
							if(sortIndex < name.length()){
								index = StringHelper.singleCahrToNum(name.substring(name.length() - sortIndex - 1,name.length() - sortIndex));
							}
							if(index > patsortArray.length){
								patsortArray = extendArrayEnsureLength(patsortArray, index);
							}
							Vertex v = null;
							if(patsortArray[index] == null){
								v = new Vertex();
								patsortArray[index] = v;
							}else{
								v = patsortArray[index];
							}
							if(v.link == null){
								v.link = edge;
							}else{
								Edge tmp = v.link;
								while(tmp.nextLink != null){
									tmp = tmp.nextLink;
								}
								tmp.nextLink = edge;
							}
							
						}else{
							break;
						}
						edge = vertex.link;
					}
				}
			}
			sortIndex++;
		}
		
		int[] res = new int[patArray.length];
		int resIndex = 0;
		for(Vertex vertex : patsortArray){
			if(vertex != null && vertex.link != null){
				Edge edge = vertex.link;
				res[resIndex] = edge.wordIndex;
				resIndex++;
				while(edge.nextLink != null){
					edge = edge.nextLink;
					res[resIndex] = edge.wordIndex;
					resIndex++;
				}
				
			}
		}
		
		return res;
	}
	
	/**
	 * 数组扩展
	 * @param source
	 * @return
	 */
	public static String[] extendArray(String[] source){
		String[] newArray = new String[source.length + 500];
		for(int i = 0;i<source.length;i++){
			newArray[i] = source[i];
		}
		
		source = newArray;
		
		return source;
	}
	
	/**
	 * 扩展数组到指定长度
	 * @param source
	 * @param length
	 * @return
	 */
	public static Vertex[] extendArrayEnsureLength(Vertex[] source,int length){
		Vertex[] newArray = new Vertex[length+1];
		for(int i = 0;i<source.length;i++){
			newArray[i] = source[i];
		}
		
		source = newArray;
		
		return source;
		
		
	}
}
