package daiict.dcom.sw.dlol;

import java.util.*; 

import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.ling.*; 
import edu.stanford.nlp.ling.CoreAnnotations.*;  
import java.io.FileNotFoundException;
import java.util.Scanner;
 
public class Lamatizer {
 
	 public static void main(String[] args)
	  {
	 /* Properties props = new Properties(); 
	 props.put("annotators", "tokenize, ssplit, pos, lemma"); 
	  StanfordCoreNLP pipeline = new StanfordCoreNLP(props, false);
	  String text = "walking"; 
	  Annotation document = pipeline.process(text);  
	  for(CoreMap sentence: document.get(SentencesAnnotation.class)) {      
	    for(CoreLabel token: sentence.get(TokensAnnotation.class)) {       
	    String word = token.get(TextAnnotation.class);      
	    String lemma = token.get(LemmaAnnotation.class); 
	    System.out.println("lemmatized version :" + lemma);
	    } } */
		 
		 Properties props = new Properties(); 
		 props.put("annotators", "tokenize, ssplit, pos, lemma"); 
		  StanfordCoreNLP pipeline = new StanfordCoreNLP();
		  String text = "walking"; 
		  Annotation document = pipeline.process(text);  
		  for(CoreMap sentence: document.get(SentencesAnnotation.class)) {      
		    for(CoreLabel token: sentence.get(TokensAnnotation.class)) {       
		    String word = token.get(TextAnnotation.class);      
		    String lemma = token.get(LemmaAnnotation.class); 
		    System.out.println("lemmatized version :" + lemma);
		    } } 
	  }
    }