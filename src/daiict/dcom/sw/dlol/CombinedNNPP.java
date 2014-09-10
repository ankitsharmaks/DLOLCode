/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daiict.dcom.sw.dlol;


public class CombinedNNPP {
    
    public String combineNN(String tagged)
    {   int m=0;
    int count=0;
        String[] words = tagged.split(" ");
        for(int i=0;i<words.length - 1 ; i++)
        {
        	 if(((words[i].endsWith("_NNP")||words[i+1].contains("_CD"))&&(words[i+1].endsWith("_NNP")||words[i+1].contains("_CD")))||((words[i].endsWith("_NN")||words[i+1].contains("_CD"))&&(words[i+1].endsWith("_NN")||words[i+1].contains("_CD")))||((words[i].endsWith("_NNPS")||words[i+1].contains("_CD"))&&(words[i+1].endsWith("_NNPS")||words[i+1].contains("_CD")))||((words[i].endsWith("_NNS")||words[i+1].contains("_CD"))&&(words[i+1].endsWith("_NNS")||words[i+1].contains("_CD"))))   {   count++;
                words[i] = words[i].replaceFirst("_NNPS", "_COMNN"); 
                words[i] = words[i].replaceFirst("_NNP", "_COMNN"); 
                words[i] = words[i].replaceFirst("_NNS", "_COMNN"); 
                words[i] = words[i].replaceFirst("_NN", "_COMNN"); 
                words[i] = words[i].replaceFirst("_IN", "_COMNN");
                words[i] = words[i].replaceFirst("_CD", "_COMNN");
m=i;
            }
           }
        words[m+1] = words[m+1].replaceFirst("_NNPS", "_COMNN"); 
        words[m+1] = words[m+1].replaceFirst("_NNP", "_COMNN"); 
        words[m+1] = words[m+1].replaceFirst("_NNS", "_COMNN"); 
        words[m+1] = words[m+1].replaceFirst("_NN", "_COMNN"); 
        words[m+1] = words[m+1].replaceFirst("_IN", "_COMNN");
        words[m+1] = words[m+1].replaceFirst("_CD", "_COMNN");
        String newTagged = "";
        int k=0;
        for(int i=0;i<words.length ; i++)
        {   if(words[i].contains("_COMNN"))
        	{  
        	if(k<count){k++;
        	  words[i] = words[i].replaceFirst("_COMNN",""); 
                newTagged = newTagged.concat(words[i]);
            }
        	 else if(k==count){
             	k++;
             	 words[i] = words[i].replace("_COMNN","_NNP ");
                  newTagged = newTagged.concat(words[i]);
             }
        	  else{
             	 words[i] = words[i].replace("_COMNN","");
                  newTagged = newTagged.concat(words[i]);
             }
        	
        	}
            else
                newTagged = newTagged.concat(words[i]+" ");
        }
            
        
       System.out.println("*****NEWTAGGED: " + newTagged);
        return newTagged;
    }
    
}
