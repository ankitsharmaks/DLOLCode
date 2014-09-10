package daiict.dcom.sw.dlol;


public class DlolParameter {

	
	public String getCorpusPrefix() {
		return corpusPrefix;
	}
	public void setCorpusPrefix(String corpusPrefix) {
		this.corpusPrefix = corpusPrefix;
	}
	public String getFilePrefix() {
		return filePrefix;
	}
	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}
	public String getTaggerfilePrefix() {
		return taggerfilePrefix;
	}
	public void setTaggerfilePrefix(String taggerfilePrefix) {
		this.taggerfilePrefix = taggerfilePrefix;
	}
	public String getCorpusName() {
		return corpusName;
	}
	public void setCorpusName(String corpusName) {
		this.corpusName = corpusName;
	}
	public String getInterMediateName() {
		return InterMediateName;
	}
	public void setInterMediateName(String interMediateName) {
		InterMediateName = interMediateName;
	}
	public String getCorpusPath() {
		return corpusPath;
	}
	public void setCorpusPath(String corpusPath) {
		this.corpusPath = corpusPath;
	}
	public String getTaggedPath() {
		return taggedPath;
	}
	public void setTaggedPath(String taggedPath) {
		this.taggedPath = taggedPath;
	}
	public String getNormalizePath() {
		return normalizePath;
	}
	public void setNormalizePath(String normalizePath) {
		this.normalizePath = normalizePath;
	}
	public String getSingularizedPath() {
		return singularizedPath;
	}
	public void setSingularizedPath(String singularizedPath) {
		this.singularizedPath = singularizedPath;
	}
	public String getDigitizePath() {
		return digitizePath;
	}
	public void setDigitizePath(String digitizePath) {
		this.digitizePath = digitizePath;
	}
	public String getExtractedTriplePath() {
		return extractedTriplePath;
	}
	public void setExtractedTriplePath(String extractedTriplePath) {
		this.extractedTriplePath = extractedTriplePath;
	}
	public String getOntologyPath() {
		return ontologyPath;
	}
	public void setOntologyPath(String ontologyPath) {
		this.ontologyPath = ontologyPath;
	}
	public String getTaggerModelFile() {
		return taggerModelFile;
	}
	public void setTaggerModelFile(String taggerModelFile) {
		this.taggerModelFile = taggerModelFile;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public String getParaPath() {
		return paragraph;
		}  
		         public String getExParaPath() {
		return extracted_paragraph;
		}  
	public String getCorpusPath1() {
					return corpusPath1;
				}
				public void setCorpusPath1(String corpusPath1) {
					this.corpusPath1 = corpusPath1;
				}
	private String corpusPrefix="I:\\ankit\\Dropbox\\Padhai_WTF\\QA\\DLOL-NONISA - New Code\\DLOL-NONISA\\Corpus\\" ;
	private String filePrefix = "I:\\ankit\\Dropbox\\Padhai_WTF\\QA\\DLOL-NONISA - New Code\\DLOL-NONISA\\IntermediateFiles\\";
	private String taggerfilePrefix="I:\\ankit\\Dropbox\\Padhai_WTF\\QA\\DLOL-NONISA - New Code\\DLOL-NONISA\\LibReference\\Tagger\\";
	private String corpusName = "corpus";
	private String corpusName1 = "corpus";
    private String InterMediateName = "intermediate";
	private String corpusPath = corpusPrefix + corpusName + ".txt";
	private String corpusPath1 = corpusPrefix + corpusName1 + ".txt";
	private String taggedPath = filePrefix + "t_" + corpusName +".txt";
	private String normalizePath = corpusPrefix + "n_" + corpusName +".txt";
	private String singularizedPath = filePrefix + "s_"  + corpusName + ".txt";
	private String digitizePath = filePrefix+ "d_" + corpusName + ".txt";
	private String extractedTriplePath = filePrefix+"x_" + corpusName + ".txt";
	private String ontologyPath = corpusPrefix + corpusName + ".owl";
	private String taggerModelFile = taggerfilePrefix+"english-left3words-distsim.tagger";
	private String sentence="";
	 private String paragraph = corpusPrefix + "para.txt";
     private String extracted_paragraph = corpusPrefix + "corpus.txt";
}
