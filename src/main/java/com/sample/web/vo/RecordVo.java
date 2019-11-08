/*****************************************************************************
 * Copyright(c) 2014 neonexSoft. All rights reserved.
 * This software is the proprietary information of neonexSoft. 
 * 
 * Description : 
 * Create on 2016. 3. 07. leesh
*****************************************************************************/
package com.sample.web.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*****************************************************************************
 * 
 *  @packageName : com.lotte.cps.vo
 *  @fileName : RecordVo.java
 *  @author : leesh
 *  @since 2016. 3. 07.
 *  @version 1.0 
 *  @see  :  
 *  @revision : 2016. 3. 07.
 *  
 *  result VO
 *  
 *  <pre>
 *  << Modification Information >>
 *    DATE	           NAME			DESC
 *     -----------	 ----------   ---------------------------------------
 *     2016. 3. 07.        leesh       create RecordVo.java
 *  </pre>
 ******************************************************************************/
public class RecordVo extends BaseVo {
    
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

	public static boolean isCamelName(String key,String pattern){

		
		if (key.indexOf(pattern)>0) return false;
		
		String temp;
		for (int idx = 0;idx<key.length();idx++){
			temp = key.substring(idx, idx+1);
			if(idx==0 && temp.equals(temp.toUpperCase())){
				return  false;
			}
			else if(idx>0 && temp.equals(temp.toUpperCase())){
				return  true;
			}
		}
		
		return true;
	}
	
	
	public static String convertUnderscoreNameToPropertyName(String input){
		
		
		String pattern = "_";
		String REPLACE = "";		
		
		if (isCamelName(input,pattern)) return input;

		Pattern p = Pattern.compile(pattern);

		// get a matcher object
		Matcher m = p.matcher(input);
		StringBuffer sb = new StringBuffer();
		StringBuffer temp = null;
		int idx = 0;
		while(m.find()) {
			temp = new StringBuffer();
			m.appendReplacement(temp, REPLACE);
			toUpperLowwerCase( sb, temp,  idx++);
		}
		temp = new StringBuffer();
		m.appendTail(temp);
		toUpperLowwerCase( sb, temp,  idx);
		//System.out.println(sb.toString());		
		
		return sb.toString();
	}

	public static void toUpperLowwerCase(StringBuffer sb,StringBuffer temp, int idx){
		
		if (idx==0){
			sb.append(temp.toString().toLowerCase());
		}
		else {
			String tempStr = temp.toString();
			//System.out.println("tempStr  : "+tempStr);
	        for(int j = 0; j < tempStr.length(); j++){
	        	if (j==0){
	        		sb.append(tempStr.substring(j,j+1).toUpperCase());
	        	}
	        	else {
	        		sb.append(tempStr.substring(j,j+1).toLowerCase());
	        	}
	        }
		}
	}
	
	public Object put(Object key, Object value) {
		Object convertKEy = convertUnderscoreNameToPropertyName(String.valueOf(key));
		return super.put((Object)convertKEy, value);
	}
    
	public Object putOrg(Object key, Object value) {
		return super.put(String.valueOf(key), value);
	}  	
}
