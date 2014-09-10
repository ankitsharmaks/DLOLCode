package daiict.dcom.sw.dlol;

import java.util.ArrayList;

import daiict.dcom.sw.dlol.*;

public class DlolVariables {

	public static DlolString sentence = null;
	public static DlolNuances nuances = null;
	public static DlolDictionary2 dloldictionary=new DlolDictionary2();
	
	public static DlolTemplate template = null;
	public static ArrayList<String> triples = null;
	public static ArrayList<String> temp = null;
	
	DlolVariables(String stmt){
	 sentence = new DlolString(stmt);
	 nuances = new DlolNuances(stmt);
	 template = new DlolTemplate();
	 dloldictionary=new DlolDictionary2();
	 triples=new ArrayList<>();
	 temp=new ArrayList<>();
	// trip=new DlolTripleExtrector();
	}
}
