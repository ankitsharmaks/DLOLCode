package daiict.dcom.sw.dlol;

import java.io.IOException;

public class HashtableDemo {

	public static void main(String[] args) throws IOException {
		//Sentencedict dict = new Sentencedict();
		//dict.init("data.txt");
		DlolDictionary dict = new DlolDictionary();
		String stmt="some_DT handsome_JJ man_NN are_VBZ some_DT beautiful_JJ woman_NN";
		dict.fillDictionary(stmt);
		System.out.println("Left Halve := " + dict.getLeftHalve());
		System.out.println("Right Halve := " + dict.getRightHalve());
		dict.display();
		
		System.out.println("Index of DT : " + dict.getIndexOf("DT"));
		System.out.println("Index of JJ : " + dict.getIndexOf("JJ"));
		System.out.println("Index of NNS : " + dict.getIndexOf("NNS"));
		System.out.println("Index of NNP : " + dict.getIndexOf("NNP"));
		System.out.println("Index of NN : " + dict.getIndexOf("NN"));
		System.out.println("Index of VBZ : " + dict.getIndexOf("VBZ"));
		System.out.println("Index of ABC : " + dict.getIndexOf("ABC"));
		System.out.println("Subject is : " + dict.getSubject());
		System.out.println("Subject Modifier is : " + dict.getSubjectModifier());
		System.out.println("Subject Quantifier is : " + dict.getSubjectQuantifier());
		System.out.println("Verb is : " + dict.getVerb());
		System.out.println("Object is : " + dict.getObject());
		System.out.println("Object Modifier is : " +dict.getObjectModifier());
		System.out.println("Object Quantifier is : " +dict.getObjectQuantifier());
		System.out.println("Subject Tag is : "+dict.getSubjectTag());
		System.out.println("Subject Quantifier Tag is : "+dict.getSubjectQuantifierTag());
		System.out.println("object Tag is : "+dict.getObjectTag());
		System.out.println("object Quantifier Tag is : "+dict.getobjectQuantifierTag());
		System.out.println("Left Halve of sentence is : "+dict.getLeftHalve());
		//System.out.println("Right Halve of sentence is : "+dict.getRightHalve());
		
		
	}
}
