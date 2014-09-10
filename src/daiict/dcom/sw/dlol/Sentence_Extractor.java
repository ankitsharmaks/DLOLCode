/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daiict.dcom.sw.dlol;

import daiict.dcom.sw.dlol.DlolParameter;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ankit
 */
public class Sentence_Extractor {   
    DlolParameter para = new DlolParameter();
    ArrayList<String> keys = new ArrayList<String>();
    ArrayList<String> values = new ArrayList<String>();
    
    public Sentence_Extractor() throws IOException, ClassNotFoundException {
        String paraPath = para.getParaPath();  
        String content = readFile(paraPath, StandardCharsets.UTF_8);
        //System.out.println("!!!!!!"+content);
        content = content.replaceAll(" ,", ", ");
        
        String exparaPath = para.getExParaPath();
        FileWriter fstream = new FileWriter(exparaPath);
        BufferedWriter exout = new BufferedWriter(fstream);
        
        MaxentTagger tagger = new MaxentTagger("E:/DLOL-NONISA/ExternalLib/stanford-postagger-2014-01-04/models/english-left3words-distsim.tagger");
        String tagged = tagger.tagString(content);
        tagged=tagged.replaceAll("_,", "_XX");
        System.out.println("!!Tagged:" + tagged);
        String[] sentences = tagged.split("_. ");
        System.out.println("------------Test2:"+sentences[0]);
        for(int i=0;i<sentences.length;i++){
           if(!sentences[i].contains(" not_") && !sentences[i].contains("n't_")){
                System.out.println("!!if not");
                String temp = "";
                String key;
                tag_indexed(sentences[i]);
                System.out.println("keys size:"+this.keys.size()+"   values size:"+this.values.size());
                for(int j=0;j<this.keys.size();j++){
                    key = this.keys.get(j);
                    System.out.println("-------key: "+key);
                    temp = temp.concat(key+" ");                    
                }
                System.out.println("!!!Temp:"+temp);
                temp = removeBracketTags(temp);
                temp=temp.trim();
                exout.write(temp);				
                exout.newLine();
                System.out.println("!!Temp:"+temp);
            }                
        }
         exout.close();
         fstream.close();
    }

    private String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }

    private void tag_indexed(String sentence) throws ArrayIndexOutOfBoundsException {
        System.out.println("!!tagged indexfn:");
        this.keys.clear();
        this.values.clear();
        
        sentence = sentence.trim();
        
        System.out.println(sentence);
        
        if(sentence.endsWith(".")  || sentence.endsWith("?") || sentence.endsWith("!"))
              sentence = sentence.substring(0,sentence.length() - 1);
        sentence = sentence.replaceAll(",_, ", "");
        sentence = sentence.trim();
        System.out.println(sentence);
        String[] tokens = sentence.split(" ");
        for(int i=0; i<tokens.length; i++){
                if(tokens[i].toString().contains("_,"))
                {   System.out.println("********************");
                    System.err.println(",_,");
                    tokens[i] = tokens[i].replace(",_,", "");
                }
                String[] parts = tokens[i].split("_");
                if(parts.length == 2)
                {System.out.println("part0:"+parts[0]+"   part1:"+parts[1]);
                this.keys.add(parts[0]);
                this.values.add(parts[1]);
                }
                
	}
    }

    private String removeBracketTags(String temp) {
        
        System.out.println("!!in bracfunc:"+temp);
        if(temp.contains("-LRB-"))
            temp = temp.replaceAll("-LRB-", "");
        
        if(temp.contains("-RRB-"))
            temp = temp.replaceAll("-RRB-", "");
        
        return temp;
    }
}