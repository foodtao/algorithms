package d.algorithms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
	
	
	public static void main(String[] args){
		System.out.println(isChineseChar("e"));
		System.out.println(isChineseChar("("));
		System.out.println(isChineseChar("£¨"));
		System.out.println(isChineseChar("¡ªrtrt@"));
		System.out.println(isChineseChar(" "));
		System.out.println(isChineseChar("ËÎrrr"));
	}
	
	public static boolean isChineseChar(String str){        
		boolean temp = false;        
		Pattern p=Pattern.compile("[\u4e00-\u9fa5]");        
		Matcher m=p.matcher(str);        
		if(m.find()){            
			temp =  true;        
		}        
		return temp;    
	}
	
	public static int singleCahrToNum(String value){
		char[] chars = value.toCharArray();
		
		return (int)chars[0];
		
	}
	
	public static String stringToNum(String value)  
	{  
	    StringBuffer sbu = new StringBuffer();  
	    char[] chars = value.toCharArray();   
	    for (int i = 0; i < chars.length; i++) {  
	        if(i != chars.length - 1)  
	        {  
	            sbu.append((int)chars[i]).append(",");  
	        }  
	        else {  
	            sbu.append((int)chars[i]);  
	        }  
	    }  
	    return sbu.toString();  
	}
	
	public static String numToString(String value)  
	{  
	    StringBuffer sbu = new StringBuffer();  
	    String[] chars = value.split(",");  
	    for (int i = 0; i < chars.length; i++) {  
	        sbu.append((char) Integer.parseInt(chars[i]));  
	    }  
	    return sbu.toString();  
	} 
	
}
