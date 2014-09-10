package daiict.dcom.sw.tagger;

import java.io.IOException;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class Tagger  {

	private MaxentTagger tagger = null;
	
	public Tagger(String taggerModelFile) throws ClassNotFoundException, IOException{
		tagger =  new MaxentTagger(taggerModelFile);
	}
	
	public MaxentTagger getTagger()
	{
		return this.tagger;
	}
	
	public void setTagger(String taggerModelFile) throws ClassNotFoundException, IOException
	{
		tagger =  new MaxentTagger(taggerModelFile);
	}
	
	public String tagString(String sentence){
		return tagger.tagString(sentence);
	}
}
