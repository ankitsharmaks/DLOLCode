/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daiict.dcom.sw.dlol;


public class combineNN {
    
    public String combineNN(String tagged)
    {
        String[] words = tagged.split(" ");
        for(int i=0;i<words.length - 1 ; i++)
        {
            if((words[i].endsWith("_NNP")&&words[i+1].endsWith("_NNP"))||(words[i].endsWith("_NN")&&words[i+1].endsWith("_NN"))||(words[i].endsWith("_NNPS")&&words[i+1].endsWith("_NNPS"))||(words[i].endsWith("_NNS")&&words[i+1].endsWith("_NNS")))
            {   
                words[i] = words[i].replaceFirst("_NNPS", "_COMNN"); 
                words[i] = words[i].replaceFirst("_NNP", "_COMNN"); 
                words[i] = words[i].replaceFirst("_NNS", "_COMNN"); 
                words[i] = words[i].replaceFirst("_NN", "_COMNN"); 

            }
        }
        String newTagged = "";
        for(int i=0;i<words.length ; i++)
        {   if(words[i].contains("_COMNN"))
            {   words[i] = words[i].replaceFirst("_COMNN",""); 
                newTagged = newTagged.concat(words[i]);
            }
            else
                newTagged = newTagged.concat(words[i]+" ");
        }
            
        
        System.out.println("*****NEWTAGGED: " + newTagged);
        return newTagged;
    }
    
}
