package dlol.preprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

import daiict.dcom.sw.corpus.NormalizeVarients;
import daiict.dcom.sw.dlol.CombinedNNPP;
import daiict.dcom.sw.dlol.CombinedVB;
import daiict.dcom.sw.dlol.DlolDictionary;
import daiict.dcom.sw.dlol.DlolDictionary1;
import daiict.dcom.sw.dlol.DlolDictionary2;
import daiict.dcom.sw.dlol.DlolParameter;
import daiict.dcom.sw.dlol.DlolTripleExtrector;
import daiict.dcom.sw.dlol.DlolVariables;
import daiict.dcom.sw.dlol.PreProcess;
import daiict.dcom.sw.dlol.combineNN;
import daiict.dcom.sw.tagger.Tagger;

public class Preprocessing {

	DlolParameter dl = new DlolParameter();
	Tagger tagger = null;
	String corpusPath = dl.getCorpusPath();
	String digitalPath = dl.getDigitizePath();
	String normalizePath=dl.getNormalizePath();
	String taggerModelFile = dl.getTaggerModelFile();
	private String sentence;

	public Preprocessing() throws ClassNotFoundException, IOException {
		tagger = new Tagger(taggerModelFile);
	}

	public void preprocess() throws IOException {
		tagSentences();
		normalizeSentences();
		
	}

	public void normalizeSentences() throws IOException
	{  
		NormalizeVarients normalize = new NormalizeVarients(sentence);
		File file = new File(corpusPath);

		try {

			Scanner scanner = new Scanner(file);
			
			FileWriter fstream = new FileWriter(normalizePath);
			BufferedWriter out = new BufferedWriter(fstream);

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();
			//	String tagged = tagger.tagString(line);
				String line1=normalize.normalizedSentance(line);
				out.write("\n" + line1 + "\n");
				out.newLine();
			}
			scanner.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		
	}
	
	public void tagSentences() throws IOException {
		File file = new File(corpusPath);

		try {

			Scanner scanner = new Scanner(file);
			FileWriter fstream = new FileWriter(digitalPath);
			BufferedWriter out = new BufferedWriter(fstream);
			DlolVariables variables = null;
			
			variables.temp=new ArrayList<String>();
			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();
				String tagged = tagger.tagString(line);
				System.out.println(tagged);
				 //combineNN combNN = new combineNN();
				//	tagged = combNN.combineNN(tagged);
				
				 
				tagged.trim();
				
				String st1=tagged;
				  variables.dloldictionary.fillDictionary(tagged);
			PreProcess pr=new PreProcess();
		
		 
				pr.preProcess(tagged);
			
				variables.triples=new ArrayList<String>();
				for(int k=0;k<variables.temp.size();k++){
					
				String st=variables.temp.get(k);
				
				tagged=tagger.tagString(st);
				st1=tagged;
				
				tagged=variables.dloldictionary.PropFirst();
				tagged.trim();
				if(tagged.equals(""))tagged=st1;
				DlolTripleExtrector dex= new DlolTripleExtrector(tagged.trim());
				 //System.out.println(tagged);
				 dex = new DlolTripleExtrector(tagged);
			   
				ArrayList<String> s3=dex.getTriples(tagged);
			
				
				for(int i=0;i<s3.size();i++){
					String s2=s3.get(i);
					
		         variables.triples.add(s2);
					System.out.println(variables.triples);
				}

				
				
				out.write("\n" + tagged + "\n");
				//DlolDictionary2 dd=new DlolDictionary2();
				//dd.fillDictionary(tagged);
			/*	dd.PropFirst();
				dd.display();
				System.out.println("Subject: "+dd.getSubject());
				System.out.println("Relation: "+dd.getRelation());
				System.out.println("Object: "+dd.getObject());
				System.out.println("Second Subject: "+dd.getSecondSubject());
				System.out.println("Second Relation: "+dd.getSecondRelation());
				System.out.println("Second Object: "+dd.secondObject());*/
				/*System.out.println("Subject modifier: "+dd.getSubjectModifier());
				System.out.println("Object modifier: "+dd.getObjectModifier());
				System.out.println("Subject Quantifier: "+dd.getSubjectQuantifier());
				System.out.println("Object Quantifier: "+dd.getObjectQuantifier());
				System.out.println("Subject modifier Tag: "+dd.getSubjectModifierTag());
				System.out.println("Object modifier Tag: "+dd.getObjectModifierTag());
				System.out.println("Subject Quantifier Tag: "+dd.getSubjectQuantifierTag());
				System.out.println("Object Quantifier Tag: "+dd.getobjectQuantifierTag());
				System.out.println("Subject Tag: "+dd.getSubjectTag());
				System.out.println("Object Tag: "+dd.getObjectTag());
				
			    System.out.println("Second Object modifier: "+dd.getSecondObjectModifier());
				System.out.println("Second Object Quantifier: "+dd.getSecondObjectQuantifier());
				*/
				out.newLine();
			}}
			scanner.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}