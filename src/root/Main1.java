package root;

import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

class Main1{

	public static void main (String args[]){
		System.setProperty("wordnet.database.dir", "C:/Program Files (x86)/WordNet/2.1/dict");
		WordNetDatabase database = WordNetDatabase.getFileInstance(); 
		NounSynset nounSynset;
		NounSynset[] hyponyms;

		
		Synset[] synsets = database.getSynsets("played", SynsetType.NOUN);
		for (int i = 0; i < synsets.length; i++) {
		    nounSynset = (NounSynset)(synsets[i]);
		    hyponyms = nounSynset.getHyponyms();
		    System.err.println(nounSynset.getWordForms()[0] +
		            ": " + nounSynset.getDefinition() + ") has " + hyponyms.length + " hyponyms");
		} 
	}
	
	
}