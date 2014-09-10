package daiict.dcom.sw.dlol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class PreProcess{
	
public	void preProcess(String tag){
	if(tag.contains("so")||tag.contains("did")||tag.contains("either")||tag.contains("too")||tag.contains("niether"))
	{DlolVariables variables=null;
	System.out.println(tag);
	
	String st1=DlolVariables.dloldictionary.getRelation();


int m=variables.dloldictionary.keys.indexOf(st1);
		//System.out.println(m);
		int k=0;
		String total="";
		for(int i=m;i<variables.dloldictionary.keys.size();i++){
			String st=variables.dloldictionary.values.get(i);
			String st5=variables.dloldictionary.keys.get(i);
			k=i;
			total=total+" "+st5;
			if(st.contains("NN")){
		
				break;
			}
		}
		//System.out.println(k);
		String rt="";
	for(int i=0;i<=k;i++){
			String rm=DlolVariables.dloldictionary.keys.get(i);
			rt=rt+" "+rm;
		
		}
	rt=rt.trim();
	System.out.println(rt);
	   DlolVariables.temp.add(rt);
		//
	  String rt2="";
	for(int i=k+1;i<variables.dloldictionary.keys.size();i++)
	{
	String	st2=variables.dloldictionary.keys.get(i);
		if(st2.equals("so")||st2.equals("did")||st2.equals("does")||st2.equals("too")||st2.equals("either")||st2.equals("neither")){
			rt2=rt2;
		}
		else{
			rt2= rt2+" "+st2;
	}

	}
rt2=rt2.concat(total);
	rt2=rt2.trim();
	System.out.println(rt2);
	DlolVariables.temp.add(rt2);
	 //System.out.println(variables.triples);
	}
	else
	{  String s = "";
	String []sen=tag.split(" ");
	 for(int i=0;i<sen.length;i++){
		 String st=sen[i];
		 String []arr=st.split("_");
		  s+=arr[0]+" ";
	 }
	s=s.trim();
	System.out.println("HHHHHHHHH"+s);
		DlolVariables.temp.add(s);
	}
}

	
}