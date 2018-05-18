package d.algorithms.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

	public static void writeToFile(String content,boolean isappend,String filePath){
//		FileWriter fw = null;
//		try {
//			fw = new FileWriter(filePath, isappend);
//
//			fw.write(content);
//			fw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (fw != null) {
//					fw.close();
//					fw = null;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		try{
			FileOutputStream fos = new FileOutputStream(filePath,isappend);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			osw.write(content);
			osw.flush();
			osw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static List<String> loadData(String filename){
		List<String> data = new ArrayList<String>();
		try{
			File file = new File(filename);
			Reader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
			BufferedReader br = new BufferedReader(reader);
			String lineTxt = null;
			while((lineTxt = br.readLine()) != null){
				if(lineTxt != null && !lineTxt.isEmpty()){
					data.add(lineTxt);
				}
			}
			br.close();
		}catch(Exception e){
			
		}
		return data;
	}
}
