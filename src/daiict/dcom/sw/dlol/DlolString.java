package daiict.dcom.sw.dlol;

import java.util.Locale;



public class DlolString {
	
private String str1;

public DlolString(String str1) {
	 this.str1 = str1;
	}


public String trim(){
	return this.str1.trim();
}
public String trimBetween(String str1){

	
	str1.trim();
	//System.out.println(str1);
	while(str1.contains("  ")){
		str1 = str1.replaceAll("  ", " ");
	}
	return str1;
}


public String trimExtended(){
	this.str1.trim();
	while(this.str1.contains("  ")){
		this.str1 = this.str1.replaceAll("  ", " ");
	}
	return str1;
}

public int length()
    {
	  return this.str1.length();
	}

public String concat(String str)
{
	return this.str1.concat(str);
	}

public int compareTO(String str){
	
	return this.str1.compareTo(str);
	
	}
public char charAt(int a)
{
	return this.str1.charAt(a);}

public boolean endsWith(String str)
{
	return this.str1.endsWith(str1);
	}
public boolean equal(String str)
{
	return this.str1.equals(str);
	}
public int compareToIgnoreCase(String str)
{
	return this.str1.compareToIgnoreCase(str);
	}
public boolean contentEquals(String str) {
	return this.str1.contentEquals(str);
}

public boolean equalsIgnoreCase(String str){
	return this.str1.equalsIgnoreCase(str);
}

public boolean regionMatches(int toffset,String other, int ooffset,int len)
 {
	return this.str1.regionMatches(toffset, other, ooffset, len);
	 }

public boolean regionMatches(boolean ignoreCase,int toffset,String other,int ooffset,int len){
	
	return this.str1.regionMatches(ignoreCase, toffset, other, ooffset, len);
}

public boolean startsWith(String prefix,int toffset){
	return this.str1.startsWith(prefix,toffset);
	}

public boolean startsWith(String prefix)
{ return this.str1.startsWith(prefix);
	}

public int hashCode(){
	return this.str1.hashCode(); 
}
public int indexOf(int ch)
{ return this.str1.indexOf(ch);
	}

public int indexOf(int ch, int fromIndex)

{
	return this.str1.indexOf(ch, fromIndex); }

public int lastIndexOf(int ch){
	
	return this.str1.lastIndexOf(ch);
}

public int lastIndexOf(int ch, int fromIndex){
	return this.str1.lastIndexOf(ch, fromIndex);
}
public int indexOf(String str){
	return this.str1.indexOf(str);
}

public int indexOf(String str,int fromIndex){
	
	return this.str1.indexOf(str, fromIndex);
}
public int lastIndexOf(String str)
{ return this.str1.lastIndexOf(str);
	}

public int lastIndexOf(String str,int fromIndex){
	return this.str1.lastIndexOf(str, fromIndex);
}

public String substring(int beginIndex){
	return this.str1.substring(beginIndex);
}
public String substring(int beginIndex,int endIndex){
	return this.str1.substring(beginIndex, endIndex);
}
public CharSequence subSequence(int beginIndex,int endIndex){
	return this.str1.subSequence(beginIndex, endIndex);
}
public String replace(char oldChar,char newChar)
{return this.str1.replace(oldChar, newChar);

}
public String replace(String target,String replacement)
{return this.str1.replace(target, replacement);
	}

public boolean matches(String regex){
	return this.str1.matches(regex);
}

public String replaceFirst(String regex,String replacement){
	return this.str1.replaceAll(regex, replacement);
}

public int count(String str){
	 int  count=0;
	
	String temp = this.str1;
	
	while (temp.indexOf(str)>0){
	    temp = temp.replaceFirst(str, "");
	    count++;
	//while(temp.indexOf(str) > -1){
		//count++;
		//temp = temp.substring(temp.indexOf(str));	
		
	}
	//if(count > 1)
	//count++;
//	System.out.println(count);
	return count;
}
public boolean contains(CharSequence s){
		
	return this.str1.contains(s);
	
}

public String replaceAll(String regex,String replacement){
	return this.str1.replaceAll(regex, replacement);
}

public String[] split(String regex,int limit){
	return this.str1.split(regex, limit);
}

public String[] split(String regex){
	return this.str1.split(regex);
}
public String toLowerCase(Locale locale){
	return this.str1.toLowerCase(locale);
}

public String toLowerCase()
{return this.str1.toLowerCase();
	}

public String toUpperCase(){
	return this.str1.toUpperCase();
}

public String toString(){
	return this.str1.toString();
}

public char[] toCharArray(){
	return this.str1.toCharArray();
}
public  String valueOf(Object obj){
	return this.str1.valueOf(obj);
	}
public String valueOf(char[] data){
	return this.str1.valueOf(data);
}

public String valueOf(char[] data,int offset,int count){
	return this.str1.valueOf(data, offset, count);
}

public  String copyValueOf(char[] data,int offset,int count){
	return this.str1.copyValueOf(data, offset, count);
}
public  String copyValueOf(char[] data){
	return this.str1.copyValueOf(data);
}

public  String valueOf(boolean b){
	return this.str1.valueOf(b);
}


public  String valueOf(int i){
	return this.str1.valueOf(i);
}


public  String valueOf(long l){
	return this.str1.valueOf(l);
}

public  String valueOf(float f){
	return this.str1.valueOf(f);
}

public String valueOf(double d){
	return this.str1.valueOf(d);
}

public String intern(){
	return this.str1.intern();
}

public boolean doLeftHalvesContains(String nuancesName, String delimiter){	
	return this.getLeftHalveInclusive(delimiter).toLowerCase().contains(nuancesName);
}

public boolean doRightHalvesContains(String nuancesName, String delimiter){	
	return this.getRightHalveInclusive(delimiter).toLowerCase().contains(nuancesName);
}

public String getLeftHalveInclusive(String delimiter){
	String result = "";
	for(String s : this.split(" ")){
		if(s.equalsIgnoreCase(delimiter)){
			break;
		}
		else{
		result = result + " " + s;	
		}
	}
	result = result +" " + delimiter;
	result.trim();
	return result;
}

public String getRightHalveInclusive(String delimiter){
	String result = "";
	for(String s : this.split(" ")){
		if(!s.equalsIgnoreCase(delimiter)){
			continue;
		}
		else{
		result = result + " " + s;	
		}
	}
	result.trim();
	return result;
}


} // DLOLString class ends