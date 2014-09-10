package root;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import net.sf.mmm.util.text.base.EnglishSingularizer;
import daiict.dcom.sw.corpus.NormalizeVarients;
import daiict.dcom.sw.dlol.CombinedNNPP;
import daiict.dcom.sw.dlol.CombinedVB;
import daiict.dcom.sw.dlol.DlolNuances;
import daiict.dcom.sw.dlol.DlolString;
import daiict.dcom.sw.dlol.DlolTemplate;
import daiict.dcom.sw.dlol.DlolDictionary;
import daiict.dcom.sw.dlol.DlolTripleExtrector;
import daiict.dcom.sw.dlol.DlolVariables;
//import daiict.dcom.sw.dlol.New;
import daiict.dcom.sw.dlol.Sentence_Extractor;
import daiict.dcom.sw.tagger.Tagger;
import dlol.preprocessing.Preprocessing;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.modeshape.common.text.Inflector;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import daiict.dcom.sw.dlol.combineNN;


public class Main {
	public static FileWriter out ;
	public static BufferedWriter bfout; 
	public static void main (String args[]) throws ClassNotFoundException, IOException{
		
	//Sentence_Extractor senex=new Sentence_Extractor();
		
		pipeline();
	}

	public static void pipeline() throws ClassNotFoundException, IOException, IndexOutOfBoundsException{
		Preprocessing pr=new Preprocessing();
		pr.preprocess();
	
		  DlolVariables variables = null;
		  DlolTripleExtrector dex= null;
		
		 // DlolVariables.atmTripleLogger.write(variables.triples, false);
		 // DlolVariables.atmTripleLogger.close(false);
		  EnglishSingularizer singluar = EnglishSingularizer.INSTANCE;
		  
		  
		  /*String[] sentences = new String[variables.triples.size()];
		  for(int i=0;i<variables.triples.size();i++){
			  sentences[i] = variables.triples.get(i);
		  }*/
		  

          Inflector infl = new Inflector();               
          MaxentTagger tagger1 = new MaxentTagger("I:\\ankit\\Dropbox\\Padhai_WTF\\QA\\DLOL-NONISA - New Code\\DLOL-NONISA\\ExternalLib\\stanford-postagger-2014-01-04\\models\\english-left3words-distsim.tagger"); 
 for(int i=0;i<variables.triples.size();i++){
	  String s=variables.triples.get(i);
	  
	  
	  s.trim();
	
	 String tagged = tagger1.tagString(s);
	 //System.out.println(tagged);
	
		System.out.println(tagged);
		  variables.dloldictionary.fillDictionary(tagged);
	 
	  String s1[]=tagged.split(" ");
	  
	  String result=""; 
	  String str1=variables.dloldictionary.getRelation();
      //System.out.println(str1);
	  for(int j=0;j<s1.length;j++){
		  String s3="";
		 // System.out.println(s1[j]);
		
                        //  System.out.println("^^^^^^One");
		  if(s1[j].contains(" is_")||s1[j].contains(" was_")||s1[j].contains("'s")||s1[j].contains(variables.dloldictionary.getRelationBegin())||s1[j].contains(" includes_")||s1[j].contains(" has_")||s1[j].contains(variables.dloldictionary.getRelation())){
                            result+=s1[j];
                        //   System.out.println("^^^^^^two");
                          }
		  else {
			  String st2=s1[j];
			  String s8[]=st2.split("_");
			  for(int k=0;k<s8.length;k++){
                            //System.out.println("^^^^^^Before singular: "+s1[j]);
		    //s3=singluar.transform(s1[j]);	
                            s3 = infl.singularize(s8[0]).concat("_"+s8[1]);}
                            //System.out.println("^^^^^^After singular: "+s3);
                          }	  
                          result+=s3+" "; 
                          //System.out.println();
                  }
	  result.trim();
	  variables.triples.remove(s);
	  variables.triples.add(i,result);
	  }
 System.out.println(variables.triples);


		  
	/*	 for(int i=0;i<variables.triples.size();i++){
			  String s=variables.triples.get(i);
			  String s1[]=s.split("\\s+");
			  String result=""; 
			  for(int j=0;j<s1.length;j++){
				  String s3="";
				  if(s1[j].equals("is")||s1[j].equals("was")||s1[j].contains("'s")||s1[j].equals(variables.dloldictionary.getRelation())||s1[j].equals("includes")){
				result+=s1[j];}
				  else {
				   s3=singluar.transform(s1[j]);	}	  
				  result+=s3+" ";}
			  variables.triples.remove(s);
			  variables.triples.add(i,result);
			  }*/
		// System.out.println(variables.triples);
		 //DlolVariables.snglrLogger.write(variables.triples, false);
		  //DlolVariables.snglrLogger.close(false);
		  
	/*	  for(int i=0;i<variables.triples.size();i++){
			  String s=variables.triples.get(i);
			  NormalizeVarients nv=new NormalizeVarients(s);
		  String s3=nv.normalizedSentance(s);
		  variables.triples.remove(s);
		  variables.triples.add(i,s3);
			  }
		  System.out.println(variables.triples);    */
  
		  //DlolVariables.normalizeLogger.write(variables.triples, false);
		  //DlolVariables.normalizeLogger.close(false);
		 //DlolVariables.atmTripleLogger1.comparison();
			String path="e:/sample3.owl";
			//ExtendedOwl eo=new ExtendedOwl();
			out = new FileWriter(new File("I:\\ankit\\Dropbox\\Padhai_WTF\\QA\\DLOL-NONISA - New Code\\DLOL-NONISA\\Corpus\\interesting.txt"));
		
		//	MaxentTagger tagger = new MaxentTagger("E:/DLOL-NONISA/ExternalLib/stanford-postagger-2014-01-04/models/english-left3words-distsim.tagger");
		 for(int i=0;i<variables.triples.size();i++){
			
			  String s=variables.triples.get(i);
			  s.trim();
		
			// String tagged = tagger.tagString(s);
			 
			 combineNN combNN = new combineNN();
			s = combNN.combineNN(s);

			//System.out.println(tagged);
		 CombinedNNPP combNNPP= new CombinedNNPP();
			s = combNNPP.combineNN(s);
			
		CombinedVB cvb=new CombinedVB();
		 s=cvb.combineNN(s);
			//	System.out.println(tagged);
				  variables.dloldictionary.fillDictionary(s);
				//System.out.println("HI");
				  String prop=DlolVariables.dloldictionary.getRelation();
				  String sub=DlolVariables.dloldictionary.getSubject();
				  String obj=DlolVariables.dloldictionary.getObject();
				  System.out.println("HEllo");
				  System.out.println("Sub----->"+sub);
					System.out.println("Obj----->"+obj);
				System.out.println("Prop----->"+prop);
		
			    String submod=DlolVariables.dloldictionary.getSubjectModifier();
				
				String objmod=DlolVariables.dloldictionary.getObjectModifier();
			//	String obj=DlolVariables.dloldictionary.getObject();
				String secsub=DlolVariables.dloldictionary.getSecondSubject();
				String secrel=DlolVariables.dloldictionary.getSecondRelation();
				String secobj=DlolVariables.dloldictionary.secondObject();
				//String secrel="";
				System.out.println("Sub----->"+sub);
				System.out.println("Obj----->"+obj);
			System.out.println("Prop----->"+prop);
			System.out.println("Second Sub="+secsub);
			System.out.println("Second Rel="+secrel);
			System.out.println("Second Obj="+secobj);
			System.out.println("HHHHHHHHHHHHH"+variables.triples.size());
			//Scanner in = new Scanner(new File("E:/DLOL-NONISA/Corpus/interesting.txt"));
				bfout = new BufferedWriter(out);
			String sample;
			//sample="Subject-["+sub+"] Relation-["+prop+"] Object-["+obj+"] Second Subject-["+secsub+"] Second Relation-["+secrel+"] Second Object ["+secobj+"]";
			sample = DlolVariables.dloldictionary.getAll();
			//bfout.write(sentences[i]);
			bfout.newLine();
			bfout.write(s);
			bfout.newLine();
			bfout.write(sample);
			bfout.newLine();
			bfout.newLine();
			bfout.newLine();
			bfout.flush();
			
		
		
		 
		 }}
	

	
}
