package daiict.dcom.sw.dlol;

import java.util.ArrayList;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DlolNuances {

	String sentence = "";
	DlolString dlolSentence = null;
	ArrayList<String> nuancesList = null;
	String suchAs = "such as";
	String anyOneOfSubject = "any one of subject";
	String anyOneOfObject = "any one of object";
	String Only = "only";
	String Like = "like";
	String Same="same";
	String sameAs="same as";
	String Yet="yet";
	String An="an";
	String Is="is";
	String aSortOf="a sort of";
	String eventually="evantually";
	String Not="not";
	String That="that";
	String Include="include";
	
	
	
	
	public DlolNuances(String sentence){
	 this.sentence = " " + sentence.toLowerCase();
	 dlolSentence = new DlolString(sentence);
	 nuancesList = new ArrayList<String>();
	} // constructor ends
	
	public DlolNuances() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> findNuances(String delimiter){
		if(isSuchAsPresent()){
			nuancesList.add(suchAs);
		}
		
		if(isAnyOneOfSubject(delimiter)){
			nuancesList.add(anyOneOfSubject);
		}
		
		if(isAnyOneOfObject(delimiter)){
			nuancesList.add(anyOneOfObject);
		}
		
		if(isOnlyPresent()){
			nuancesList.add(Only);
		}
		if(isLikePresent()){
			nuancesList.add(Like);
		}
		if(isSamePresent()){
			nuancesList.add(Same);
		}
		
		if(isSameAsPresent()){
			nuancesList.add(sameAs);
		}

		if(isYetPresent()){
			nuancesList.add(Yet);
		}
		
		if(isAnPresent()){
			nuancesList.add(An);
		}
		if(isIsPresent()){
			nuancesList.add(Is);
		}
		if(isASortOfPresent()){
			nuancesList.add(aSortOf);
		}
		if(isEventuallyPresent()){
			nuancesList.add(eventually);
		}
		if(isNotPresent()){
			nuancesList.add(Not);
		}
		
		if(isThatPresent()){
			nuancesList.add(That);
		}

		if(isIncludePresent()){
			nuancesList.add(Include);
		}
		return nuancesList;
	}
	
	
	private boolean isIncludePresent() {
		Pattern pattern = Pattern.compile(".* include .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();	
	}

	private boolean isThatPresent() {
		Pattern pattern = Pattern.compile(".* that .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();	
	}

	private boolean isNotPresent() {
		Pattern pattern = Pattern.compile(".* not .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();	
	}

	private boolean isEventuallyPresent() {
		Pattern pattern = Pattern.compile(".* eventually .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();	
	}

	private boolean isASortOfPresent() {
		Pattern pattern = Pattern.compile(".* a sort of .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();	
	}

	private boolean isIsPresent() {
		Pattern pattern = Pattern.compile(".* is .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();	
	}

	private boolean isAnPresent() {
		Pattern pattern = Pattern.compile(".* an .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();	
	}

	private boolean isYetPresent() {
		Pattern pattern = Pattern.compile(".* yet .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();		
	}

	private boolean isSameAsPresent() {
		Pattern pattern = Pattern.compile(".* same as .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();		
	}

	private boolean isSamePresent() {
		Pattern pattern = Pattern.compile(".* same .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();		
	}

	private boolean isLikePresent() {
		Pattern pattern = Pattern.compile(".* like .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();		
	}

	private boolean isOnlyPresent() {
		Pattern pattern = Pattern.compile(".* only .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();		
	}

	private boolean isAnyOneOfObject(String delimiter) {
		Pattern pattern = Pattern.compile(".* any one of .*");
		Matcher matcher = pattern.matcher(dlolSentence.getRightHalveInclusive(delimiter));
		return matcher.matches();		
		
	}

	private boolean isAnyOneOfSubject(String delimiter) {
		Pattern pattern = Pattern.compile(".* any one of .*");
		Matcher matcher = pattern.matcher(dlolSentence.getLeftHalveInclusive(delimiter));
		return matcher.matches();		
	}

	private boolean isSuchAsPresent(){
		Pattern pattern = Pattern.compile(".* such as .*");
		Matcher matcher = pattern.matcher(this.sentence);
		return matcher.matches();		
	}
	
	

	
		
	
} //  class ends

