package d.algorithms.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortHelper {
	
	public static Map<String, Integer> sortMapByValue(Map<String, Integer> oriMap) {  
	    Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();  
	    if (oriMap != null && !oriMap.isEmpty()) {  
	        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(oriMap.entrySet());  
	        Collections.sort(entryList,  
	                new Comparator<Map.Entry<String, Integer>>() {  
	                    public int compare(Entry<String, Integer> entry1,  
	                            Entry<String, Integer> entry2) {  
	                        int value1 = 0, value2 = 0;  
	                        try {  
	                            value1 = entry1.getValue();  
	                            value2 = entry2.getValue();  
	                        } catch (NumberFormatException e) {  
	                            value1 = 0;  
	                            value2 = 0;  
	                        }  
	                        return value2 - value1;  
	                    }  
	                });  
	        Iterator<Map.Entry<String, Integer>> iter = entryList.iterator();  
	        Map.Entry<String, Integer> tmpEntry = null;  
	        while (iter.hasNext()) {  
	            tmpEntry = iter.next();  
	            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());  
	        }  
	    }  
	    return sortedMap;  
	} 
	
	public static void main(String[] args){
		
		
	}
	
}
