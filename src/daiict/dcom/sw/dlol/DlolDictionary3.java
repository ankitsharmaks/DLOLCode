package daiict.dcom.sw.dlol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class DlolDictionary3 extends LinkedHashMap<String, String> {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Multimap<String, String> dictionary =  ArrayListMultimap.create();
	ArrayList<String> keys = new ArrayList<String>();
	ArrayList<String> values = new ArrayList<String>();
	Boolean b=false;
	public DlolDictionary3(){
		super();
	}
	public void fillDictionary(String sentence){
		sentence=sentence.trim();
		System.out.println(sentence);
		String[] tokens = sentence.split(" ");
		for(String t : tokens){
			String[] parts = t.split("_");
			this.keys.add(parts[0]);
			this.values.add(parts[1]);
			//this.dictionary.put(parts[0], parts[1]);
			//System.out.println(parts[0]);
			//System.out.println(this.dictionary.put(parts[0], parts[1]));
		}
	}
	
	public void display(){
		for(int i=0;i<this.keys.size();i++){
			String key = this.keys.get(i);
			String value = this.values.get(i);
			System.out.println(key +" = "+value);
		}
	}
	
	public int getIndexOf(String str) {
		for (int i = 0; i < this.keys.size(); i++) {
			String strVal = this.values.get(i);
			if (strVal.compareToIgnoreCase(str) == 0)
				return i;
		}
		return -1;
	}
	
	public String getSubject(){
		int index1=this.keys.indexOf(getRelation());
		int index=0;
		String value="";
		if(getIndexOf("WDT")>getIndexOf("WP"))
			index=getIndexOf("WDT");
			else
				index=getIndexOf("WP");
		if(index>getIndexOf("WRB")){index=index;}
		else
			index=getIndexOf("WRB");
	if(index<index1){
		value=this.values.get(index);
		while(!value.equals("NNP")&&!value.equals("NN")){
		index--;
		if(index==0)break;}
		return this.keys.get(index);
	}
	else{int index2=this.keys.indexOf(getRelation());
		index2 = index2-1;
		if(index2 < 0)
			return "";
		else if ((index2 == getIndexOf("JJ") )|| (index2 == getIndexOf("DT")) )
			return "";
		else
			return this.keys.get(index2);
	}
	
	}
	public String getSecondSubject(){
		
		int index=0;
		if(getIndexOf("WDT")>getIndexOf("WP"))
			index=getIndexOf("WDT");
			else
				index=getIndexOf("WP");
		
		
		if(index>getIndexOf("WRB")){index=index;}
		else
			index=getIndexOf("WRB");
		String value=this.values.get(index);
		String value1=this.keys.get(index);
		if(value1.equals("who")){int in=this.keys.indexOf(getSubject()); return this.keys.get(in);};
		while(!value.equals("NNP")&&!value.equals("NN")){
		index++;
		value=this.values.get(index);
		if(index==this.keys.size()-1)break;
		}
		
		return this.keys.get(index);
	}
	public String getVerb(){
		int index=this.keys.indexOf(getRelation());
		/*if(getIndexOf("VBZ")>getIndexOf("VBD"))
			index=getIndexOf("VBZ");
			else
				index=getIndexOf("VBD");
		//index=getIndexOf("VBD");*/
		if(index < 0)
			return "";
		else
			return this.keys.get(index);
	}

	public String getSubjectModifier(){
		int index = this.keys.indexOf(getSubject());
		int index1=0;
		
		String result=""; 
		//result=this.keys.get(index1);
		//System.out.println(result);
		for(int i=0;i<index;i++){
			result+=this.keys.get(i)+" ";
			//result+=result+" ";
		}
		//System.out.println(result);
		return result.trim();
		/*if (index < 0)
			return "";
		else
			return this.keys.get(index);
	*/
		}
	
	public String getSubjectQuantifier(){
		int index = this.keys.indexOf(getSubject());
		int indexom=0;
		String	valueom = this.values.get(indexom);
		//System.out.println(valueom);
		while(!valueom.equals("DT")){
			if(indexom==index){break;}
			indexom++;
			
		valueom = this.values.get(indexom);
		
		}
		//System.out.println(valueom);
		if(valueom.equals("DT"))
		return this.keys.get(indexom);
		else
			return "";
		/*if(index < 0)
			return "";
		else
			return this.keys.get(index);
	*/
		}
	
	public int getKeySize(){
		return this.keys.size()-1;
	}
	public void PropFirst()
	{  
		int index,index1,index2;
		index=getIndexOf("IN");
		
		if(index==0){
			index=0;
			 
			String valueom = this.values.get(index);
			String value=this.keys.get(index);
			//System.out.println(valueom);
			int ind=this.keys.indexOf(",");
	         ind--;
			while(!valueom.equals("WRB")&&!valueom.equals("WDT")&&!valueom.equals("WP"))
			{   //System.out.println(index);
			
				this.keys.remove(index);
				this.values.remove(index);
				this.keys.add(ind,value);
				this.values.add(ind,valueom);
				//index++;
				
				valueom = this.values.get(index);
				value=this.keys.get(index);
				//System.out.println(valueom);
					
			}
			//System.out.println(valueom);
			
			valueom = this.values.get(index);
			value=this.keys.get(index);
			this.keys.remove(index);
			this.values.remove(index);
			this.keys.add(ind,value);
			this.values.add(ind,valueom);
			
			
			}
		else{
			
		}		
	}
	public String getObject(){
		int index = this.keys.size()-1;
		int indexvb=this.keys.indexOf(getRelation());;
	
		if (index == indexvb)
		{
		  return "";
		}
		
		
		else
		{   
			String valueom = this.values.get(indexvb);
			String value=this.keys.get(indexvb);
			//System.out.println(value);
			while(!valueom.equals("NNP")&&!valueom.equals("NN"))
			{ 
				indexvb++;
				valueom = this.values.get(indexvb);
				value=this.keys.get(indexvb);
				if(indexvb==this.keys.size()-1)
				{break;}
				//System.out.println(valueom);
				}
			if(indexvb==this.keys.size()-1&&!valueom.equals("NN")){
				return "";
			}
			//System.out.println(indexvb);
			if(indexvb!=this.keys.size()-1)
			{ 
			String str1="";
			valueom=this.values.get(indexvb);
			value=this.keys.get(indexvb);
			//System.out.println(valueom);
			if(valueom.equals("NNP")||valueom.equals("NN")){
				//System.out.println(this.keys.size()-1);
				while((valueom.equals("NNP")&&indexvb!=this.keys.size()-1)||(valueom.equals("NN")&&indexvb!=this.keys.size()-1))
				{   //System.out.println(1);
					value=this.keys.get(indexvb);
					//System.out.println(value);
					if(valueom.equals("NNP")||valueom.equals("NN")){
						str1=str1+" "+value;
					indexvb++;
					
				    valueom = this.values.get(indexvb);
					value=this.keys.get(indexvb);
					
						
					}
					
				}
				
			}b=true;
			return str1;
			}	
			//
		else{b=true;
			return this.keys.get(indexvb);}}
	}
	
	public String getObjectModifier(){
		int index = this.keys.indexOf(getObject());
		if(b == false){
			return "";
		}
		else{
			int indexvb = this.keys.indexOf(getRelation());
			int indexo = this.keys.size()-1;
		//System.out.println(indexvb);
			String result = "";
			String value="";
			if(indexo == indexvb){
				return "";
			}
			else{
				for(int i=indexvb+1;i<indexo;i++){
					value=this.values.get(i);
					//System.out.println(value);
					if(value.equals("NNP")||value.equals("NN"))break;
					result = result + this.keys.get(i) +" ";
				}
				return result.trim();				
		}
		}
		
	}
	
	public String getRelation(){
		int index=0;
		
		String value="",value1="";
		value=this.values.get(index);
		while(!value.equals("VBZ")&&!value.equals("VBD")&&!value.equals("VBP")&&!value.equals("VBN")){
			index++;
			value=this.values.get(index);
		}
		int index1=index+1;
		value1=this.values.get(index1);
		if(value1.equals("VBZ")||value1.equals("VBD")||value1.equals("VBP")||value1.equals("VBN"))
		return this.keys.get(index1);
		else return this.keys.get(index);
		/*if(getIndexOf("VBZ")>getIndexOf("VBD"))
			index=getIndexOf("VBZ");
			else
				index=getIndexOf("VBD");
		if(index>getIndexOf("VBP")){index=index;}
		else
			index=getIndexOf("VBP");
		if(index>getIndexOf("VBN")){index=index;}
		else
			index=getIndexOf("VBN");
		//index=getIndexOf("VBD");	
		return this.keys.get(index);*/
	}
	public String getObjectQuantifier(){
		int index = this.keys.size()-1;
		int index2=this.keys.indexOf(getObject());
		int indexvb=this.keys.indexOf(getRelation());
		/*if(getIndexOf("VBZ")>getIndexOf("VBD"))
			indexvb=getIndexOf("VBZ");
			else
				indexvb=getIndexOf("VBD");*/
		//indexvb = getIndexOf("VBD");
		if (b == false)
		{	return "";
		}
	else if ((index-indexvb)>1)
		{
		int	indexom = indexvb+1;
			String	valueom = this.values.get(indexom);
		while(!valueom.equals("DT")&&indexom!=this.keys.size()-1){
			indexom++;
		valueom = this.values.get(indexom);
		}
		if(valueom.equals("DT"))
		return this.keys.get(indexom);
		else
			return "";
		/*if (valueom.equals("DT"))
				return this.keys.get(indexom);
			else 
				return "";
		*/
	}
	else 
		return "";
	}
	
	public String getSubjectTag(){
		String key = getSubject();
		int index = this.keys.indexOf(key);
		if(index != -1)
			return this.values.get(index);
		else 			
			return "";
		}
	
	public String getSubjectModifierTag(){
		int index = 0;
		String result = "";
		if(this.values.get(0) == "DT"){
			index = 1;
		}
		
		for(int i=0;i<this.keys.indexOf(getSubject());i++){
			result = result + this.values.get(i) + " ";
		}
		
		return result.trim();
	}
	
	public String getSubjectQuantifierTag(){
		String key = getSubjectQuantifier();
		int index = this.keys.indexOf(key);
		if(index != -1)
			return this.values.get(index);
		else 			
			return "";
		//String tag = this.dictionary.get(key);
		
	}
	public String getobjectQuantifierTag(){
		int key1 = this.keys.indexOf(getObjectQuantifier());
		if(key1 != -1)
			return this.values.get(key1);
		else 			
			return "";
	}
    public	String getObjectTag(){
		String	key = getObject();
		//System.out.println(key);
		//int index = this.keys.indexOf(key);
		if(b == true){
			int index=this.keys.indexOf(getRelation());
			int indexend=this.keys.size()-1;
			String value="",result=""; 
			value=this.values.get(index);
			while(!value.equals("NN")&&!value.equals("NNP")){
				index++;
				value=this.values.get(index);
			}
			//
			//result=value;
			for(int i=index;i<=indexend;i++){
				value=this.values.get(i);
				if(value.equals("NN")||value.equals("NNP")){
					result+=this.values.get(i)+" ";
				}
				else{
					break;
				}
				
			}
			return result;}
		else 			
			return "";
		
		}
	public String getSecondRelation(){
		if (b==false){return "";}
		else{
			
			int index=0,index1=0;
			String value="";
			if(getIndexOf("WDT")>getIndexOf("WP"))
				index=getIndexOf("WDT");
				else
					index=getIndexOf("WP");
			
			
			if(index>getIndexOf("WRB")){index=index;}
			else
				index=getIndexOf("WRB");
			//if(index==-1)
				//return "";
		 index1=this.keys.indexOf(getRelation());
			if(index<index1){
				index1++;
				if(index1==this.keys.size()-1)return "";
				value=this.values.get(index1);
				//System.out.println(value);
				while(!value.equals("VBZ")&&!value.equals("VBD")&&!value.equals("VBP")&&!value.equals("VBN")){
					index1++;
					
					if(index1==this.keys.size()-1)break;
					value=this.values.get(index1);
				}
				return this.keys.get(index1);
			}
			else{
				
			for(int i=index;i<this.keys.size()-1;i++){
				value=this.values.get(i);
				if(value.equals("VBZ")||value.equals("VBD")||value.equals("VBP")){
				//System.out.println(i);
					return this.keys.get(i);
				}}
			}
			
		}
		return null;
	}
	
	public String secondObject(){
		if (b==false){return "";}
		else{ int index=0,index1=0;
		String value="";
	
			if(getIndexOf("WDT")>getIndexOf("WP"))
				index=getIndexOf("WDT");
				else
					index=getIndexOf("WP");
			
			
			if(index>getIndexOf("WRB")){index=index;}
			else
				index=getIndexOf("WRB");
			if(index==-1)return "";
			
			for(int i=index;i<this.keys.size()-1;i++){
				
				value=this.values.get(i);
				if(value.equals("VBZ")||value.equals("VBD")||value.equals("VBP")){
				//System.out.println(i);
					index1=i;
				}
			}
			
			
			 //index1=this.keys.indexOf(getSecondRelation());
			//System.out.println(index1);
			if(index1==-1||index1==0)return "";
			else{
			for(int i=index1+1;i<=this.keys.size()-1;i++){
				//System.out.println(this.keys.get(i));
				if(this.values.get(i).equals("NN")||this.values.get(i).equals("NNP")){
					return this.keys.get(i);
				}
			     
			}}
			
			}
		
		
		
		return null;
	}
	public String getSecondObjectModifier(){
		
		if (b==false){return "";}
		else{ int index=0,index1=0;
		String value="",value1="",result="";
			if(getIndexOf("WDT")>getIndexOf("WP"))
				index=getIndexOf("WDT");
				else
					index=getIndexOf("WP");
			
			
			if(index>getIndexOf("WRB")){index=index;}
			else
				index=getIndexOf("WRB");
			if(index==-1)return "";
			for(int i=index;i<this.keys.size();i++){
				value=this.values.get(i);
				if(value.equals("VBZ")||value.equals("VBD")||value.equals("VBP")){
				//System.out.println(i);
					index1=i;
				}
			}
			 //index1=this.keys.indexOf(getSecondRelation());
			//System.out.println(index1);
			if(index1==-1)return "";
			else{index1=index1+1;
			if(index1==this.keys.size()-1){return "";}
				value=this.values.get(index1);
				//System.out.println(value);
				//value1=this.keys.get(index1+1);
			while(!value.equals("NN")||!value.equals("NNP")){
				value1=this.keys.get(index1);
				
		        result+=" "+value1;
				index1++;
				if(index1==this.keys.size()-1)break;
				value=this.values.get(index1);
				
				value1=this.keys.get(index1);
				
				}
			return result;  
			}
			
			}
		
		
		
	
	}
	public String getSecondObjectQuantifier(){
		
		if (b==false){return "";}
		else{ int index=0,index1=0;
		String value="",value1="",result="";
			if(getIndexOf("WDT")>getIndexOf("WP"))
				index=getIndexOf("WDT");
				else
					index=getIndexOf("WP");
			
			
			if(index>getIndexOf("WRB")){index=index;}
			else
				index=getIndexOf("WRB");
			if(index==-1)return "";
			for(int i=index;i<this.keys.size();i++){
				value=this.values.get(i);
				if(value.equals("VBZ")||value.equals("VBD")||value.equals("VBP")){
				//System.out.println(i);
					index1=i;
				}
			}
			 //index1=this.keys.indexOf(getSecondRelation());
			//System.out.println(index1);
			if(index1==-1)return "";
			else{index1=index1+1;
			if(index1==this.keys.size()-1){return "";}
				value=this.values.get(index1);
				//value1=this.keys.get(index1+1);
			while(!value.equals("NN")||!value.equals("NNP")){
				value1=this.keys.get(index1);
				
		     
				index1++;
				if(index1==this.keys.size()-1)break;
				if(value.equals("DT")){
					   result+=" "+value1;
				}
				value=this.values.get(index1);
				value1=this.keys.get(index1);
				
				}
			return result;  
			}}
	}
	public String getLeftHalve(){
		
		//String[] tokens = sentence.split(" ");
		/*
		String delimeter="";
		String sent = "";
		String result="";
		for(String t : tokens){
			String[] parts = t.split("_");
			this.dictionary.put(parts[0], parts[1]);
			//System.out.println(getVerb());
			
			if(parts[0].equals(getVerb()))
			{
				
			break;
			
			}
			else{
				result=result+" "+parts[0];
			}
			
			
		}
		return result;
		*/
		String leftHalve = "";
		int relationIndx=this.keys.indexOf(getRelation());
		/*if(getIndexOf("VBZ")>getIndexOf("VBD"))
			relationIndx=getIndexOf("VBZ");
			else
				relationIndx=getIndexOf("VBD");*/
		//relationIndx = getIndexOf("VBD");
		for(int i=0;i<relationIndx;i++){
			String token = this.keys.get(i);
			leftHalve = leftHalve + token + " ";
			//System.out.println(token);
		}
	 return leftHalve.trim(); 
		
		
		}
	
	
	
	public String getRightHalve(){
	/*	String[] tokens = sentence.split(" ");
		String delimeter="";
		String sent = "";
		boolean flag=false;
		String result="";
		for(String t : tokens){
			String[] parts = t.split("_");
			this.dictionary.put(parts[0], parts[1]);
			//System.out.println(getVerb());
			
			if(parts[0].equals(getVerb()))
			{
				
			flag=true;
			
			}
			else{
				 if(flag){
					   result=result+ " "+ parts[0];
					   
				   }
			}
			
			
		}
		return result;
	*/
		
		String rightHalve = "";
		int relationIndx = this.keys.size()-1;
		int vrbIndx;
		if(getIndexOf("VBZ")>getIndexOf("VBD"))
			vrbIndx=getIndexOf("VBZ");
			else
				vrbIndx=getIndexOf("VBD");
		
		//vrbIndx= getIndexOf("VBZ")+1 ;
		//vrbIndx= getIndexOf("VBD")+1 ;
		
		for(int i=vrbIndx;i<relationIndx+1;i++){
			String token = this.keys.get(i);
			rightHalve = rightHalve + token + " ";
			//System.out.println(token);
		}
		return rightHalve.trim();
	
		}
	public String getObjectModifierTag() {
	    int obindex= this.keys.indexOf(getObject());
	    if(b==false)
	    {return "";
	    }
	    int index=this.keys.indexOf(getRelation());
		//String str=getObjectModifier();;
		String result = "";
		String value="";
		for(int i=index+1;i<=this.keys.size()-1;i++){
			value=this.values.get(i);
			if(value.equals("NN")||value.equals("NNP"))
				break;
			result = result + this.values.get(i) + " ";
		}
		
		return result.trim();
		
	}
	
	
	/*public void removeElement(string element,boolean b){
		if(b==true){
			int elementindex= getindexof(element);
			
		}*/
		
	}


