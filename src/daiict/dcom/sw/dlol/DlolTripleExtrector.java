package daiict.dcom.sw.dlol;

import java.util.ArrayList;

public class DlolTripleExtrector{
	
	private String stmt;
	private ArrayList<String> subjectList = new ArrayList<String>();
	private ArrayList<String> objectList = new ArrayList<String>();
	private ArrayList<String> objectList1 = new ArrayList<String>();
	private String relation = "";
	private String relation1 = "";
	public ArrayList<String> triples= new ArrayList<String>();;
    DlolVariables variables=null;
    
	public DlolTripleExtrector(String stmt){
		//stmt=this.stmt;
		
	}
	public ArrayList<String> getTriples(String stmt)
	{ 
		int m=(DlolVariables.dloldictionary.keys.indexOf("and"));
		int l= DlolVariables.dloldictionary.keys.indexOf(",");
		  System.out.println(""+m);
		  if(m>l){
			  m=m;
		  }
		  else
			  m=l;
		  if(m==-1){
			 
			  String s = "";
				String []sen=stmt.split(" ");
				 for(int i=0;i<sen.length;i++){
					 String st=sen[i];
					 String []arr=st.split("_");
					  s+=arr[0]+" ";
				 }
				s=s.trim();
				triples.add(s);
				return triples;
		  }
		  int n=m-1;
		  int k=m+1;
		  System.out.println();
		 String s3 = DlolVariables.dloldictionary.values.get(n);
		 String s1 = DlolVariables.dloldictionary.values.get(k);
		 if(s3.contains("VB")&&s1.contains("VB")){
			 
			 ArrayList<String> rel= new ArrayList<String>();
              	String submod=variables.dloldictionary.getSubjectModifier();	
				String sub=variables.dloldictionary.getSubject();
				System.out.println(sub);
			 	String obmod=variables.dloldictionary.getObjectModifier();
			 	String obj=variables.dloldictionary.getObject();
			 	int j=variables.dloldictionary.keys.indexOf(obj);
			 	for(int i=n;i<j;i++){
			 	String val=variables.dloldictionary.values.get(i);
			 	String val2=variables.dloldictionary.keys.get(i);
			 	if(val.contains("VB"))
			 		
			 		rel.add(val2);
			 	}
			 	
				
				
				for(int i=0;i<rel.size();i++)
				{
					String total=submod+" "+sub+" "+rel.get(i)+" "+obmod+" "+obj;
					
					total=total.trim();
				DlolString dl=new DlolString(total);
				total=dl.trimBetween(total);
					
					triples.add(total);
				}
				return triples;
		 }
	 if(stmt.contains("and")&& stmt.contains("respectivly")){
		
		subjectList = getSubjectList(stmt);
		objectList = getObjectList(stmt);
		objectList1=getObjectList1(stmt);
		relation = DlolVariables.dloldictionary.getRelation();
		
		for(int i=0;i<subjectList.size();i++){
	
			triples.add(subjectList.get(i)+ " " + relation +" "+ objectList.get(i));}
		System.out.println(triples);
	return triples	;
	}
	  
	 if(stmt.contains("and")||stmt.contains(",")){
		 System.out.println("HI");
			subjectList = getSubjectList(stmt);
			objectList = getObjectList(stmt);
			objectList1=getObjectList1(stmt);
			relation = DlolVariables.dloldictionary.getRelation();
			
			System.out.println(relation1);
			generateTriples(subjectList, relation, objectList);
			relation1=DlolVariables.dloldictionary.getSecondRelation();
			return generateTriples(subjectList, relation1, objectList1);}
	else{
		String s = "";
		String []sen=stmt.split(" ");
		 for(int i=0;i<sen.length;i++){
			 String st=sen[i];
			 String []arr=st.split("_");
			  s+=arr[0]+" ";
		 }
		s=s.trim();
		triples.add(s);
		return triples;
	}
	}
	
	private ArrayList<String> getObjectList(String stmt) {
	
	      // int index= DlolVariables.dloldictionary.keys.indexOf(DlolVariables.dloldictionary.getRelation());
	       //int index1=DlolVariables.dloldictionary.keys.indexOf("and");
	{ 
		String object = DlolVariables.dloldictionary.getRightHalve();
		object = " " + object + " ";
		DlolString obg = new DlolString(object);
		System.out.println(object);
		String str=DlolVariables.dloldictionary.getSecondRelation();
	    if(!str.equals("")){
	   
	    	 System.out.println(DlolVariables.dloldictionary.getRelation());
	    	 int index6=variables.dloldictionary.keys.size()-1;
	    	 int index5=variables.dloldictionary.keys.indexOf(variables.dloldictionary.getRelation())+1;
	    	
				object="";
				int i;
				for( i=index5;i<=index6;i++){
					String s=DlolVariables.dloldictionary.keys.get(i);
					String s1=DlolVariables.dloldictionary.values.get(i);
					if(s.equals(DlolVariables.dloldictionary.getSecondRelation())||s.equals(","))break;
				    if(s1.equals("NN")||s1.equals("NNP")||s1.equals("NNPB")||s1.equals("NNS")||s1.equals("JJ")||s1.equals("CC"))
					object+=s+" ";
				    } 
				
				String temp="";
			
				for(int j=i+1;j<=index6;j++){
					String s=DlolVariables.dloldictionary.keys.get(j);
					temp+=s+" ";
					
				}
				
				 temp=temp.replace("who", "");
				 temp=temp.replace("respectivly", "");
				 temp=temp.replace("Who", "");
				 temp=temp.replace("when", "");
				 temp=temp.replace("When", "");
				 temp=temp.replace("either", "");
				 temp=temp.replace("Either", "");
				 temp=temp.replace("what", "");
				 temp=temp.replace("What", "");
				 temp=temp.replace("which", "");
				 temp=temp.replace("Which", "");
				 temp=temp.replace("That", "");
				 temp=temp.replace("that", "");
				 temp=temp.replace(" , ", "");
				 temp=temp.replace(",", "");
				 temp=temp.replace("  ", " ");
				 object = object.replace("respectivly","");
				 object = object.replace("who","");
				 object = object.replace("Who","");
				 object = object.replace("when","");
				 object = object.replace("When","");
				 object = object.replace("either","");
				 object = object.replace("Either","");
				 object = object.replace("what","");
				 object = object.replace("What","");
				 object = object.replace("which","");
				 object = object.replace(", which","");
				 object = object.replace("Which","");
				 object = object.replace("that","");
				 object = object.replace(", that","");
				 object = object.replace("That","");
				 object = object.replace(" ,","");
				 object = object.replace(" , ","");
				 object = object.replace(",","");
				 object = object.replace("  "," ");
				
				 String[] subjects = temp.split("and");
					for(String s : subjects){
						
						//this.objectList1.add(s);
						}
					
				//System.out.println(object);
	     }
	
if(obg.contains("respectivly")){
	object = object.replace("respectivly","");
}
		
		if(obg.count(",") == 1 && obg.contains(" and ")){
			object = object.replace(", and"," and ");
			object = object.replace(",","and");

		}
	//System.out.println(object);
		 
		if(obg.count(",") > 1 && obg.contains(" and ")){
			object = object.replaceAll(", and","and");
			object = object.replace(",","and");
		   
		}
		//System.out.println(object);
		String[] objects = object.split(" and ");
		for(String s : objects){
			this.objectList.add(s.trim());
		}
		 
		
		if(objectList.contains("same")||objectList.contains("similar")){
			objectList=subjectList;
		}
	  System.out.println(objectList);
		return this.objectList;}
		
		
	}
	
	
	private ArrayList<String> getObjectList1(String stmt) {
		
	      // int index= DlolVariables.dloldictionary.keys.indexOf(DlolVariables.dloldictionary.getRelation());
	       //int index1=DlolVariables.dloldictionary.keys.indexOf("and");
	{ 
		String object = DlolVariables.dloldictionary.getRightHalve();
		object = " " + object + " ";
		DlolString obg = new DlolString(object);
		System.out.println(object);
		String str=DlolVariables.dloldictionary.getSecondRelation();
	    if(!str.equals("")){
	    System.out.println("Hi");
	    	 System.out.println(DlolVariables.dloldictionary.getRelation());
	    	 int index6=variables.dloldictionary.keys.size()-1;
	    	 int index5=variables.dloldictionary.keys.indexOf(variables.dloldictionary.getRelation())+1;
	    	 System.out.println(index5);
				object="";
				int i;
				for( i=index5;i<=index6;i++){
					String s=DlolVariables.dloldictionary.keys.get(i);
					String s1=DlolVariables.dloldictionary.values.get(i);
					if(s.equals(DlolVariables.dloldictionary.getSecondRelation()))break;
				    if(s1.equals("NN")||s1.equals("NNP")||s1.equals("NNPB")||s1.equals("NNS")||s1.equals("JJ"))
					object+=s+" ";
				    } 
				
				String temp="";
			
				for(int j=i+1;j<=index6;j++){
					String s=DlolVariables.dloldictionary.keys.get(j);
					temp+=s+" ";
					
				}
				//System.out.println(temp);
				 temp=temp.replace("who", "");
				 temp=temp.replace("Who", "");
				 temp=temp.replace("when", "");
				 temp=temp.replace("When", "");
				 temp=temp.replace("either", "");
				 temp=temp.replace("Either", "");
				 temp=temp.replace("what", "");
				 temp=temp.replace("What", "");
				 temp=temp.replace("which", "");
				 temp=temp.replace("Which", "");
				 temp=temp.replace("That", "");
				 temp=temp.replace("that", "");
				 temp=temp.replace(" , ", "");
				 temp=temp.replace(",", "");
				 temp=temp.replace("  ", " ");
				 object = object.replace("who","");
				 object = object.replace("Who","");
				 object = object.replace("when","");
				 object = object.replace("When","");
				 object = object.replace("either","");
				 object = object.replace("Either","");
				 object = object.replace("what","");
				 object = object.replace("What","");
				 object = object.replace("which","");
				 object = object.replace(", which","");
				 object = object.replace("Which","");
				 object = object.replace("that","");
				 object = object.replace(", that","");
				 object = object.replace("That","");
				 object = object.replace(" ,","");
				 object = object.replace(" , ","");
				 object = object.replace(",","");
				 object = object.replace("  "," ");
				
				 String[] subjects = temp.split("and");
					for(String s : subjects){
						
						this.objectList1.add(s);
						}
					System.out.println(objectList);
				//System.out.println(object);
	     }
	
	
		
		if(obg.count(",") == 1 && obg.contains(" and ")){
			object = object.replace(", and"," and ");
			object = object.replace(",","and");

		}
	//System.out.println(object);
		 
		if(obg.count(",") > 1 && obg.contains(" and ")){
			object = object.replaceAll(", and","and");
			object = object.replace(",","and");
		   
		}
		//System.out.println(object);
		String[] objects = object.split(" and ");
		for(String s : objects){
			//this.objectList.add(s.trim());
		}
		 
		
		if(objectList1.contains("same")||objectList1.contains("similar")){
			objectList1=subjectList;
		}
	  System.out.println(objectList1);
		return this.objectList1;}
		
		
	}
	
	
	
	
	private ArrayList<String> getSubjectList(String stmt){
		DlolVariables.dloldictionary.fillDictionary(stmt);
		
	 int index= DlolVariables.dloldictionary.keys.indexOf(DlolVariables.dloldictionary.getRelation());
	     
	  int index1=DlolVariables.dloldictionary.keys.indexOf("and");
	  int index8=DlolVariables.dloldictionary.keys.indexOf("whereas");
	 // System.out.println(index8);
	  if(index1>index8)index1=index1;
	  else index1=index8;
		if(index>index1)
		{
		String subject = DlolVariables.dloldictionary.getLeftHalve();
		subject = " " + subject + " ";
		//System.out.println(subject);
		subject.toLowerCase();
		DlolString sub = new DlolString(subject);
		sub.toLowerCase();
	
		if((sub.contains("such")||sub.contains("Such"))&&(sub.contains("as")||sub.contains("As"))){
			if(sub.contains("such as")){
				int index3= DlolVariables.dloldictionary.keys.indexOf("such");
				for(int i=index3;i>=0;i--){
					String s=DlolVariables.dloldictionary.values.get(i);
					if(s.equals("NN")||s.equals("NNP")||s.equals("NNS")){break;}
					index3--;
				}
				String s2=DlolVariables.dloldictionary.keys.get(index3+1);
				objectList.add(s2);
				int index2=DlolVariables.dloldictionary.keys.indexOf("such");
				int index4=DlolVariables.dloldictionary.keys.indexOf(DlolVariables.dloldictionary.getRelation());
				subject="";
				for(int i=index2;i<index4;i++){
					String s=DlolVariables.dloldictionary.keys.get(i);
					subject+=s+" ";
				}
				subject = subject.replace("such as","");
				subject = subject.replace(", such as","");
				}
			else{
				int index3= DlolVariables.dloldictionary.keys.indexOf("as");
				//System.out.println(index3);
				for(int i=index3;i>=0;i--){
					String s=DlolVariables.dloldictionary.values.get(i);
					if(s.equals("NN")||s.equals("NNP")||s.equals("NNS")){break;}
					index3--;
				}
				
				String s2=DlolVariables.dloldictionary.keys.get(index3);
				objectList.add(s2);
				int index2=DlolVariables.dloldictionary.keys.indexOf("as");
				int index4=DlolVariables.dloldictionary.keys.indexOf(DlolVariables.dloldictionary.getRelation());
				subject="";
				for(int i=index2+1;i<index4;i++){
					String s=DlolVariables.dloldictionary.keys.get(i);
					subject+=s+" ";
				}
						}
			}
		
	
		if(sub.contains("including")||sub.contains("Including")){
			int index3= DlolVariables.dloldictionary.keys.indexOf("including");
			
			for(int i=index3;i>=0;i--){
				String s=DlolVariables.dloldictionary.values.get(i);
				if(s.equals("NN")||s.equals("NNP")||s.equals("NNS")||s.equals("NNPS")){break;}
				index3--;
			}
			String s2=DlolVariables.dloldictionary.keys.get(index3);
			
			objectList.add(s2);
			int index2=DlolVariables.dloldictionary.keys.indexOf("including");
			int index4=DlolVariables.dloldictionary.keys.indexOf(DlolVariables.dloldictionary.getRelation());
			subject="";
			for(int i=index2+1;i<index4;i++){
				String s=DlolVariables.dloldictionary.keys.get(i);
				subject+=s+" ";
			}
			subject = subject.replace("including","");
			subject = subject.replace(", including","");
			subject = subject.replace("Including","");
			subject = subject.replace(", Including","");
		}
		if(sub.contains("especially")||sub.contains("Especially")){
	int index3= DlolVariables.dloldictionary.keys.indexOf("especially");
			
			for(int i=index3;i>=0;i--){
				String s=DlolVariables.dloldictionary.values.get(i);
				if(s.equals("NN")||s.equals("NNP")||s.equals("NNS")||s.equals("NNPS")){break;}
				index3--;
			}
			String s2=DlolVariables.dloldictionary.keys.get(index3);
			
			objectList.add(s2);
			int index2=DlolVariables.dloldictionary.keys.indexOf("especially");
			int index4=DlolVariables.dloldictionary.keys.indexOf(DlolVariables.dloldictionary.getRelation());
			subject="";
			for(int i=index2+1;i<index4;i++){
				String s=DlolVariables.dloldictionary.keys.get(i);
				subject+=s+" ";
			}
			subject = subject.replace("especially","");
			subject = subject.replace(", especially","");
			subject = subject.replace("Especially","");
			subject = subject.replace(", Especially","");
			
		}
		if(sub.contains("either")||sub.contains("Either")){ 
			
			
		}
		
         if(sub.contains("Who")||sub.contains("who")||sub.contains("What")||sub.contains("what")||sub.contains("Where")||sub.contains("where")||sub.contains("Which")||sub.contains("which")||sub.contains("that")||sub.contains("That")||sub.contains("When")||sub.contains("when"))
         {
        	//System.out.println(sub.toString());
				int index6=variables.dloldictionary.keys.indexOf(variables.dloldictionary.getRelation());
				//System.out.println(index6);
				subject="";
				int i;
				for( i=0;i<index6;i++){
					String s=DlolVariables.dloldictionary.keys.get(i);
					if(s.equals("is")||s.equals("are"))break;
					subject+=s+" ";
			}   String temp="";
			    
				for(int j=i+1;j<index6;j++){
					String s=DlolVariables.dloldictionary.keys.get(j);
					temp+=s+" ";
				}
				 
				 temp=temp.replace("who", "");
				 temp=temp.replace("Who", "");
				 temp=temp.replace("when", "");
				 temp=temp.replace("When", "");
				 temp=temp.replace("either", "");
				 temp=temp.replace("Either", "");
				 temp=temp.replace("what", "");
				 temp=temp.replace("What", "");
				 temp=temp.replace("which", "");
				 temp=temp.replace("Which", "");
				 temp=temp.replace("That", "");
				 temp=temp.replace("that", "");
				 temp=temp.replace(" ,", "");
				 temp=temp.replace(",", "");
				 temp=temp.replace("  ", " ");
				 subject = subject.replace("who","");
		  		 subject = subject.replace("Who","");
		  		 subject = subject.replace("either","");
			     subject = subject.replace("Either","");
			     subject = subject.replace("what","");
			     subject = subject.replace("What","");
			  	 subject = subject.replace("which","");
			  	 subject = subject.replace("Which","");
			  	 subject = subject.replace("That","");
			  	 subject = subject.replace("that","");
			  	 subject = subject.replace(" ,","");
				 subject = subject.replace(",","");
				 subject = subject.replace("  "," ");
				 String[] subjects = temp.split(" and ");
					for(String s : subjects){
						if(s.equals(""))break;
						this.objectList.add(s);
						
						
					}
					
			//System.out.println("Subject="+subject);
					
 			}	 
 			
         
	
		if(sub.count(",") == 1 && sub.contains(" and ")){
			subject = subject.replace(", and","and");
		   subject = subject.replace(",","and");
			
		}
		
		if(sub.count(",") > 1 && sub.contains(" and ")){
			
			subject = subject.replaceAll(", and",",");
			subject = subject.replace(",","and");
			
		}
		
	
		String[] subjects = subject.split(" and ");
		for(String s : subjects){
			this.subjectList.add(s);
			
			
		}
		
		return this.subjectList;}
else{
			int index7=variables.dloldictionary.keys.indexOf(variables.dloldictionary.getSecondRelation());
			
			if(index7>=0){
			int index3=variables.dloldictionary.keys.indexOf("and");
		     
			
			  int index9=DlolVariables.dloldictionary.keys.indexOf("whereas");
			  
			  if(index3>index9)index3=index3;
			  else index3=index9;
			 
			int index4=variables.dloldictionary.keys.size()-1;
			String s2="";
			for(int i=0;i<index3;i++){
				String s3=variables.dloldictionary.keys.get(i);
				s2=s2+s3+" ";
			}
			triples.add(s2);
			//System.out.println(triples);
			String s4="";
			for(int i=index3+1;i<index4+1;i++){
				String s3=variables.dloldictionary.keys.get(i);
				
				s4=s4+s3+" ";
			}
			
			triples.add(s4);
			return triples;
		}
			else{
				int index3=variables.dloldictionary.keys.indexOf("and");
	
				int index4=variables.dloldictionary.keys.size()-1;
				int index5=variables.dloldictionary.keys.indexOf(variables.dloldictionary.getRelation());
				String s2="";
				for(int i=0;i<index3;i++){
					String s3=variables.dloldictionary.keys.get(i);
					s2=s2+s3+" ";
				}
				triples.add(s2);
				String s4="";
				for(int i=0;i<=index5;i++){
					String s3=variables.dloldictionary.keys.get(i);
					s4=s4+s3+" ";
				}
				for(int i=index3+1;i<=index4;i++){
					String s3=variables.dloldictionary.keys.get(i);
					s4=s4+s3+" ";
				}
				triples.add(s4);
				return triples;
			}
				
}

/*
	*/
			
			
	}

	
	private ArrayList<String> generateTriples(ArrayList<String> subjectList,
			String relation, ArrayList<String> objectList) {
		  int index= DlolVariables.dloldictionary.keys.indexOf(DlolVariables.dloldictionary.getRelation());
	    System.out.println("relation------"+relation);
	       int index1=DlolVariables.dloldictionary.keys.indexOf("and");
	       int index9=DlolVariables.dloldictionary.keys.indexOf("whereas");
			  
			  if(index1>index9)index1=index1;
			  else index1=index9;
	       if(index<index1){return triples;}
	     
         for(int i=0;i<subjectList.size();i++){
        	 for (int j=0;j<objectList.size();j++){
        		triples.add(subjectList.get(i)+ " " + relation +" "+ objectList.get(j));
        		 
        	 }
         }		
		return triples;
	}
	

}
