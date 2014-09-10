package daiict.dcom.sw.dlol;


import java.util.HashMap;

public class DlolTemplate {
	
	//HashMap<String, Boolean> templates = new HashMap<String,Boolean>();
	String template = "";
	DlolDictionary sa= new DlolDictionary();

	/*
	 * public DlolTemplate(String stmt){
	 *     template = stmt;
	 *     setTemplate();
	 *      
	 * }
	 */
	
	public DlolTemplate()
	{
		//sa.init();
		/*
		templates.put("NN_NN", false);
		templates.put("NN_NNP", false);
		templates.put("NN_JJ", false);
		templates.put("NN_VBG", false);
		templates.put("NNP_NN", false);
		templates.put("NNP_NNP", false);
		templates.put("NNP_JJ", false);
		templates.put("NNP_VBG", false);
		templates.put("JJ_NN", false);
		templates.put("JJ_JJ", false);
		templates.put("RB_NN", false);
		templates.put("RB_RB", false);
		templates.put("VBG_NN", false);
		templates.put("VBG_JJ", false);
		templates.put("VBG_RB", false);
		templates.put("VBG_VBG", false);
		*/
		
		setTemplate();
  	getSelectedTemplate();
	}
	
	
	
   String setTemplate()
   {
	   if(this.template.isEmpty())
	   {
		   setIf_NN_NN();
		  
	   }
	   else if (this.template.isEmpty())
	   {
		   setIf_NN_NNP();
	   }
	   else if(this.template.isEmpty()){
		  setIf_NN_JJ();
	   }
	   else if(this.template.isEmpty()){
			  setIf_NN_VBG();
		   }
	   else if (this.template.isEmpty())
	   {
		   setIf_NNP_NN();
	   }
	   
	   else if (this.template.isEmpty())
	   {
		   setIf_NNP_NNP();
	   }
	   else if (this.template.isEmpty())
	   {
		   setIf_NNP_VBG();
	   }
	   else if (this.template.isEmpty())
	   {
		   setIf_NNP_JJ();
	   }
	   
	   else if (this.template.isEmpty())
	   {
		   setIf_JJ_NN();
	   }
	   
	   else if (this.template.isEmpty())
	   {
		   setIf_JJ_JJ();
	   }
	   
	   else if (this.template.isEmpty())
	   {
		   setIf_RB_NN();
	   }
	   else if (this.template.isEmpty())
	   {
		   setIf_RB_RB();
	   }
	   else if (this.template.isEmpty())
	   {
		   setIf_VBG_NN();
	   }
	   else if (this.template.isEmpty())
	   {
		   setIf_VBG_JJ();
	   }
	   else if (this.template.isEmpty())
	   {
		   setIf_VBG_RB();
	   }
	   else if (this.template.isEmpty())
	   {
		   setIf_VBG_VBG();
	   }
	   
	   
	   
	return template;
   }
   
   String  setIf_VBG_VBG() {
	   	if(sa.getSubjectTag().equals("VBG")&&sa.getObjectTag().equals("VBG"))
	   	{
	         template="VBG_VBG";
	            	}
	   	return template;
			
	}

   
   String  setIf_VBG_RB() {
	   	if(sa.getSubjectTag().equals("VBG")&&sa.getObjectTag().equals("RB"))
	   	{
	         template="VBG_RB";
	            	}
	   	return template;
			
	}

   String  setIf_VBG_JJ() {
	   	if(sa.getSubjectTag().equals("VBG")&&sa.getObjectTag().equals("JJ"))
	   	{
	         template="VBG_JJ";
	            	}
	   	return template;
			
	}

   
   String  setIf_VBG_NN() {
	   	if(sa.getSubjectTag().equals("VBG")&&sa.getObjectTag().equals("NN"))
	   	{
	         template="VBG_NN";
	            	}
	   	return template;
			
	}

   
   String  setIf_RB_RB() {
	   	if(sa.getSubjectTag().equals("RB")&&sa.getObjectTag().equals("RB"))
	   	{
	         template="RB_RB";
	            	}
	   	return template;
			
	}

   String  setIf_RB_NN() {
	   	if(sa.getSubjectTag().equals("RB")&&sa.getObjectTag().equals("NN"))
	   	{
	         template="RB_NN";
	            	}
	   	return template;
			
	}
   
   String  setIf_JJ_JJ() {
	   	if(sa.getSubjectTag().equals("JJ")&&sa.getObjectTag().equals("JJ"))
	   	{
	         template="NNP_NNP";
	            	}
	   	return template;
			
	}
	 
   String  setIf_JJ_NN() {
	   	if(sa.getSubjectTag().equals("JJ")&&sa.getObjectTag().equals("NN"))
	   	{
	         template="JJ_NN";
	            	}
	   	return template;
			
	}
	 
   
   String  setIf_NNP_JJ() {
	   	if(sa.getSubjectTag().equals("NNP")&&sa.getObjectTag().equals("JJ"))
	   	{
	         template="NNP_JJ";
	            	}
	   	return template;
			
	}
	 
   
   String  setIf_NNP_VBG() {
	   	if(sa.getSubjectTag().equals("NNP")&&sa.getObjectTag().equals("VBG"))
	   	{
	         template="NNP_VBG";
	            	}
	   	return template;
			
	}
	 
   
   String  setIf_NNP_NNP() {
   	if(sa.getSubjectTag().equals("NNP")&&sa.getObjectTag().equals("NNP"))
   	{
         template="NNP_NNP";
            	}
   	return template;
		
}
   
   
   String  setIf_NNP_NN() {
   	if(sa.getSubjectTag().equals("NNP")&&sa.getObjectTag().equals("NN"))
   	{
         template="NNP_NN";
            	}
   	return template;
		
}
	
   String  setIf_NN_VBG() {
	   	if(sa.getSubjectTag().equals("NN")&&sa.getObjectTag().equals("VBG"))
	   	{
	         template="NN_VBG";
	            	}
	   	return template;
			
	}
   
   String  setIf_NN_JJ() {
   	if(sa.getSubjectTag().equals("NN")&&sa.getObjectTag().equals("JJ"))
   	{
         template="NN_JJ";
            	}
   	return template;
		
}

	
    String  setIf_NN_NNP() {
    	if(sa.getSubjectTag().equals("NN")&&sa.getObjectTag().equals("NNP"))
    	{
          template="NN_NNP";
             	}
    	return template;
		
}



	String setIf_NN_NN() {
    	if(sa.getSubjectTag().equals("NNS")&&sa.getObjectTag().equals("NNS"))
    	{
          template="NN_NN";
        //  System.out.println(template);
          
    	}
    	return template;
		
	
}



	public String  getSelectedTemplate(){
	//System.out.println(template);
	return template;
	}
		
   
   
	
}
