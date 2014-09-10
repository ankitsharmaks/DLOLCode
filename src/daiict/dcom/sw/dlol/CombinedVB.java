/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daiict.dcom.sw.dlol;


public class CombinedVB {
    int count=0;
    public String combineNN(String tagged)
    {   int m=0;
        String[] words = tagged.split(" ");
        for(int i=0;i<words.length - 1 ; i++)
        { 
            if(((words[i].contains("_VB")||words[i].contains("_TO")||words[i].contains("_IN"))&&((words[i+1].contains("_VB")||words[i+1].contains("_TO")||words[i+1].contains("_IN")))))
            {   count++;
                words[i] = words[i].replace("_VBG", "_Com"); 
                words[i] = words[i].replace("_IN", "_Com"); 
                words[i] = words[i].replace("_TO", "_Com"); 
                words[i] = words[i].replace("_VBP", "_Com"); 
                words[i] = words[i].replace("_VBN", "_Com"); 
                words[i] = words[i].replace("_VBD", "_Com");
                words[i] = words[i].replace("_VBZ", "_Com");
                words[i] = words[i].replace("_VB", "_Com");
           
             m=i;
            
            }
        }
        words[m+1]=words[m+1].replace("_VBG", "_Com");
        words[m+1]=words[m+1].replace("_IN", "_Com");
        words[m+1]=words[m+1].replace("_TO", "_Com");
        words[m+1]=words[m+1].replace("_VBP", "_Com");
        words[m+1]=words[m+1].replace("_VBN", "_Com");
        words[m+1]=words[m+1].replace("_VBD", "_Com");
        words[m+1] = words[m+1].replace("_VBZ", "_Com");
        words[m+1]=words[m+1].replace("_VB", "_Com");
        //System.out.println(words[m+1]);
        String newTagged = "";
        int k=0;
        for(int i=0;i<words.length ; i++)
        {   if(words[i].contains("_Com"))
            {  if(k<count){
            	k++;
            System.out.println(k);
        	    words[i] = words[i].replace("_Com","");
           newTagged = newTagged.concat(words[i]);}
            else if(k==count){
            	k++;
            	 words[i] = words[i].replace("_Com","_VBZ ");
                 newTagged = newTagged.concat(words[i]);
            }
           
            else{
            	 words[i] = words[i].replace("_Com","");
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
