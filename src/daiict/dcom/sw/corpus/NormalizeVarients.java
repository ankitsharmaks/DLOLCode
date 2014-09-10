package daiict.dcom.sw.corpus;

public class NormalizeVarients {

	String sentence;

	public static String[] anyOneOf = { "any one of", "Any one of",
			"only one of", "Only one of", "One of", "one of", };
	public static String[] only = { "Only", "only", };

	public static String[] like = { "a special sort of", "a sort of",
			"a form of", "a variation of", "approximately", "Approximately",
			"close to", "Close to", "roughly", "Roughly", "sort of", "Sort of",
			"more or less like", "More or less like", "around", "Around",
			"Similar to", "similar to", "Alike to", "alike to", "Like wise",
			"like wise", "Like ", "like", "Nearly", "nearly", };

	public static String[] NonXORAdverb = { "finally", "Finally", "lastly, ",
			"Lastly,", "in conclusion, ", "In conclusion,", "ultimately,",
			"Ultimately,", "in the end, ", "In the end,", "at last, ",
			"At last,", "at long last", "At long last", "typically" };

	public static String[] XORAdverb = { "sometimes", "Sometimes", "sometime",
			"Sometimes", "eventually", "Eventually", "gradually", "Gradually",
			"bit by bit", "Bit by bit", "step by step", "Step by step", "soon",
			"Soon", "yet", "Yet", "subsequently", "Subsequently", "ulterior",
			"Ulterior", "latterly", "Latterly", "afterward ", "Afterward",
			"until", "Until", "sooner or later", "Sooner or later", "in time",
			"In time", "one of these days", "One of these days", "in the end",
			"In the end", "at length", "At length", "is becoming", };

	public static String[] definitionalForm = { "is known to be",
			"is of several type of", "is any of several types of",
			"is the most important kind of", "is a most important kind of",
			"is an most important kind of", "is the some important kind of",
			"is a some important kind of", "is any member of",
			"is an important kind of", "is a taxonomic category of",
			"is a broad category of", "is members of", "is members of",
			"is the most important kind of", "is an important kind of",
			"is a sub-category of", "is a subset of", "is a sub-class of",
			"is a subcategory of", "is a category of",
			"is a particular kind of", "is a generic type of",
			"is any member of", "are a kind of", "any of several types of",
			"is a part of the order", "is very large type of",
			"are members of class", "is member of class",
			"are in the subclass", "are a type of", "is a special type of",
			"is a type of", "is in the subclass", "is kind of", "is type of",
			"is subclass of", "is subset of", "are kind of", "are type of",
			"are subclass of", "are subset of", "are members of class",
			"are member of class", "is member of class", "is members of class",
			"is", "are", "is a", "is an", "are a", "are an", };

	public static String[] thatVariation = { "that", "which", "who" };

	public static String[] inverseOfISA = { "contains", "Contains", "includes",
			"Includes", "is superclass of", "Is superclass of", "incorporate",
			"Incorporate", "contain", "Contain", "comprise", "Comprise",
			"incorporates", "Incorporates" };

	public static String[] suchas = { "such as", "Such as", "especially",
			"Especially", "specifically", "Specifically", "particularly",
			"Particularly", };

	public static String[] someVarients = // {{ quantier some array elements
	{ "Not nearly all", "not nearly all", "somewhat", "Somewhat", "some",
			"Some", "nearly all", "Nearly all", "nearly all of",
			"Nearly all of", "much", "Much", "very much", "Very much",
			"much of", "Much of", "much of the", "Much of the", "lot", "Lot",
			"lot of ", "Lot of", "a lot of", "A lot of", "lot many",
			"Lot many", "a good deal of", "A good deal of",
			"a good deal of the", "A good deal of the", "a great deal of",
			"A great deal of", "a great deal of the", "A great deal of the",
			"few", "Few", "a few", "A few", "most", "Most", "most of ",
			"Most of", "most of the", "Most of the", "hardly any",
			"Hardly any", "nearly all", "Nearly all", "many", "Many",
			"very many", "Very many", "many of", "Many of", "many of the",
			"Many of the", "a lot many", "A lot many", "hardly much",
			"Hardly much", "hardly many", "Hardly many", "hardly a lot of",
			"Hardly a lot of", "hardly a few", "Hardly a few", "not some",
			"Not some", "not nearly all", "Not nearly all",
			"not nearly all of", "Not nearly all of", "not much", "Not much",
			"not very much", "Not very much", "not much of", "Not much of",
			"not much of the", "Not much of the", "not lot", "Not lot",
			"not lot of ", "Not lot of", "not a lot of", "Not a lot of",
			"not lot many", "Not lot many", "not a good deal of",
			"Not a good deal of", "not a good deal of the",
			"Not a good deal of the", "not a great deal of",
			"Not a great deal of", "not a great deal of the",
			"Not a great deal of the", "not few", "Not few", "not a few",
			"Not a few", "not most", "Not most", "not most of ", "Not most of",
			"not most of the", "Not most of the", "not hardly any",
			"Not hardly any", "not nearly all", "Not nearly all", "not many",
			"Not many", "not very many", "Not very many", "not many of",
			"Not many of", "not many of the", "Not many of the",
			"not a lot many", "Not a lot many", "not hardly much",
			"Not hardly much", "not hardly many", "Not hardly many",
			"not hardly a lot of", "Not hardly a lot of", "not hardly a few ",
			"Not hardly a few", "about some", "About some", "about nearly all",
			"About nearly all", "about nearly all of", "About nearly all of",
			"about much", "About much", "about very much", "About very much",
			"about much of", "About much of", "about much of the",
			"About much of the", "about lot", "About lot", "about lot of ",
			"About lot of", "about a lot of", "About a lot of",
			"about lot many", "About lot many", "about a good deal of",
			"About a good deal of", "about a good deal of the",
			"About a good deal of the", "about a great deal of",
			"About a great deal of", "about a great deal of the",
			"About a great deal of the", "about few", "About few",
			"about a few", "About a few", "about most", "About most",
			"about most of ", "About most of", "about most of the",
			"About most of the", "about hardly any", "About hardly any",
			"about nearly all", "About nearly all", "about many", "About many",
			"about very many", "About very many", "about many of",
			"About many of", "about many of the", "About many of the",
			"about a lot many", "About a lot many", "about hardly much",
			"About hardly much", "about hardly many", "About hardly many",
			"about hardly a lot of", "About hardly a lot of",
			"about hardly a few ", "About hardly a few", "just about some",
			"Just about some", "just about nearly all",
			"Just about nearly all", "just about nearly all of",
			"Just about nearly all of", "just about much", "Just about much",
			"just about very much", "Just about very much",
			"just about much of", "Just about much of",
			"just about much of the", "Just about much of the",
			"just about lot", "Just about lot", "just about lot of ",
			"Just about lot of", "just about a lot of", "Just about a lot of",
			"just about lot many", "Just about lot many",
			"just about a good deal of", "Just about a good deal of",
			"just about a good deal of the", "Just about a good deal of the",
			"just about a great deal of", "Just about a great deal of",
			"just about a great deal of the", "Just about a great deal of the",
			"just about few", "Just about few", "just about a few",
			"Just about a few", "just about most", "Just about most",
			"just about most of ", "Just about most of",
			"just about most of the", "Just about most of the",
			"just about hardly any", "Just about hardly any",
			"just about nearly all", "Just about nearly all",
			"just about many", "Just about many", "just about very many",
			"Just about very many", "just about many of", "Just about many of",
			"just about many of the", "Just about many of the",
			"just about a lot many", "Just about a lot many",
			"just about hardly much", "Just about hardly much",
			"just about hardly many", "Just about hardly many",
			"just about hardly a lot of", "Just about hardly a lot of",
			"just about hardly a few ", "Just about hardly a few",
			"a significant amount of", "A significant amount of",
			"a significant sum of", "A significant sum of",
			"a significant quantity of", "A significant quantity of",
			"a significant measure of", "A significant measure of",
			"a substantial amount of", "A substantial amount of",
			"a substantial sum of", "A substantial sum of",
			"a substantial quantity of", "A substantial quantity of",
			"a substantial measure of", "A substantial measure of",
			"a important amount of", "A important amount of",
			"a important sum of", "A important sum of",
			"a important quantity of", "A important quantity of",
			"a important measure of", "A important measure of",
			"a crucial amount of", "A crucial amount of", "a crucial sum of",
			"A crucial sum of", "a crucial quantity of",
			"A crucial quantity of", "a crucial measure of",
			"A crucial measure of", "a solid amount of", "A solid amount of",
			"a solid sum of", "A solid sum of", "a solid quantity of",
			"A solid quantity of", "a solid measure of", "A solid measure of",
			"a considerable amount of", "A considerable amount of",
			"a considerable sum of", "A considerable sum of",
			"a considerable quantity of", "A considerable quantity of",
			"a considerable measure of", "A considerable measure of",
			"a major amount of", "A major amount of", "a major sum of",
			"A major sum of", "a major quantity of", "A major quantity of",
			"a major measure of", "A major measure of",
			"a significant portion of", "A significant portion of",
			"a significant part of", "A significant part of",
			"a significant section of", "A significant section of",
			"a significant devision of", "A significant devision of",
			"a significant piece of", "A significant piece of",
			"a significant component of", "A significant component of",
			"a significant share of", "A significant share of",
			"a significant percentage of", "A significant percentage of",
			"a substantial portion of", "A substantial portion of",
			"a substantial part of", "A substantial part of",
			"a substantial section of", "A substantial section of",
			"a substantial devision of", "A substantial devision of",
			"a substantial piece of", "A substantial piece of",
			"a substantial component of", "A substantial component of",
			"a substantial share of", "A substantial share of",
			"a substantial percentage of", "A substantial percentage of",
			"a important portion of", "A important portion of",
			"a important part of", "A important part of",
			"a important section of", "A important section of",
			"a important devision of", "A important devision of",
			"a important piece of", "A important piece of",
			"a important component of", "A important component of",
			"a important share of", "A important share of",
			"a important percentage of", "A important percentage of",
			"a crucial portion of", "A crucial portion of",
			"a crucial part of", "A crucial part of", "a crucial section of",
			"A crucial section of", "a crucial devision of",
			"A crucial devision of", "a crucial piece of",
			"A crucial piece of", "a crucial component of",
			"A crucial component of", "a crucial share of",
			"A crucial share of", "a crucial percentage of",
			"A crucial percentage of", "a solid portion of",
			"A solid portion of", "a solid part of", "A solid part of",
			"a solid section of", "A solid section of", "a solid devision of",
			"A solid devision of", "a solid piece of", "A solid piece of",
			"a solid component of", "A solid component of", "a solid share of",
			"A solid share of", "a solid percentage of",
			"A solid percentage of", "a considerable portion of",
			"A considerable portion of", "a considerable part of",
			"A considerable part of", "a considerable section of",
			"A considerable section of", "a considerable devision of",
			"A considerable devision of", "a considerable piece of",
			"A considerable piece of", "a considerable component of",
			"A considerable component of", "a considerable share of",
			"A considerable share of", "a considerable percentage of",
			"A considerable percentage of", "a major portion of",
			"A major portion of", "a major part of", "A major part of",
			"a major section of", "A major section of", "a major devision of",
			"A major devision of", "a major piece of", "A major piece of",
			"a major component of", "A major component of", "a major share of",
			"A major share of", "a major percentage of",
			"A major percentage of", "a significant amount of",
			"A significant amount of", "a significant sum of",
			"A significant sum of", "a significant quantity of",
			"A significant quantity of", "a significant measure of",
			"A significant measure of", "a substantial amount of",
			"A substantial amount of", "a substantial sum of",
			"A substantial sum of", "a substantial quantity of",
			"A substantial quantity of", "a substantial measure of",
			"A substantial measure of", "a important amount of",
			"A important amount of", "a important sum of",
			"A important sum of", "a important quantity of",
			"A important quantity of", "a important measure of",
			"A important measure of", "a crucial amount of",
			"A crucial amount of", "a crucial sum of", "A crucial sum of",
			"a crucial quantity of", "A crucial quantity of",
			"a crucial measure of", "A crucial measure of",
			"a solid amount of", "A solid amount of", "a solid sum of",
			"A solid sum of", "a solid quantity of", "A solid quantity of",
			"a solid measure of", "A solid measure of",
			"a considerable amount of", "A considerable amount of",
			"a considerable sum of", "A considerable sum of",
			"a considerable quantity of", "A considerable quantity of",
			"a considerable measure of", "A considerable measure of",
			"a major amount of", "A major amount of", "a major sum of",
			"A major sum of", "a major quantity of", "A major quantity of",
			"a major measure of", "A major measure of", "a large portion of",
			"A large portion of", "a large part of", "A large part of",
			"a large section of", "A large section of", "a large devision of",
			"A large devision of", "a large piece of", "A large piece of",
			"a large component of", "A large component of", "a large share of",
			"A large share of", "a large percentage of",
			"A large percentage of", "a big portion of", "A big portion of",
			"a big part of", "A big part of", "a big section of",
			"A big section of", "a big devision of", "A big devision of",
			"a big piece of", "A big piece of", "a big component of",
			"A big component of", "a big share of", "A big share of",
			"a big percentage of", "A big percentage of", "a fair portion of",
			"A fair portion of", "a fair part of", "A fair part of",
			"a fair section of", "A fair section of", "a fair devision of",
			"A fair devision of", "a fair piece of", "A fair piece of",
			"a fair component of", "A fair component of", "a fair share of",
			"A fair share of", "a fair percentage of", "A fair percentage of",
			"a orotund portion of", "A orotund portion of",
			"a orotund part of", "A orotund part of", "a orotund section of",
			"A orotund section of", "a orotund devision of",
			"A orotund devision of", "a orotund piece of",
			"A orotund piece of", "a orotund component of",
			"A orotund component of", "a orotund share of",
			"A orotund share of", "a orotund percentage of",
			"A orotund percentage of", "a tumid portion of",
			"A tumid portion of", "a tumid part of", "A tumid part of",
			"a tumid section of", "A tumid section of", "a tumid devision of",
			"A tumid devision of", "a tumid piece of", "A tumid piece of",
			"a tumid component of", "A tumid component of", "a tumid share of",
			"A tumid share of", "a tumid percentage of",
			"A tumid percentage of", "a turgid portion of",
			"A turgid portion of", "a turgid part of", "A turgid part of",
			"a turgid section of", "A turgid section of",
			"a turgid devision of", "A turgid devision of",
			"a turgid piece of", "A turgid piece of", "a turgid component of",
			"A turgid component of", "a turgid share of", "A turgid share of",
			"a turgid percentage of", "A turgid percentage of",
			"a humangous portion of", "A humangous portion of",
			"a humangous part of", "A humangous part of",
			"a humangous section of", "A humangous section of",
			"a humangous devision of", "A humangous devision of",
			"a humangous piece of", "A humangous piece of",
			"a humangous component of", "A humangous component of",
			"a humangous share of", "A humangous share of",
			"a humangous percentage of", "A humangous percentage of",
			"a magnanimous portion of", "A magnanimous portion of",
			"a magnanimous part of", "A magnanimous part of",
			"a magnanimous section of", "A magnanimous section of",
			"a magnanimous devision of", "A magnanimous devision of",
			"a magnanimous piece of", "A magnanimous piece of",
			"a magnanimous component of", "A magnanimous component of",
			"a magnanimous share of", "A magnanimous share of",
			"a magnanimous percentage of", "A magnanimous percentage of",
			"a prominent portion of", "A prominent portion of",
			"a prominent part of", "A prominent part of",
			"a prominent section of", "A prominent section of",
			"a prominent devision of", "A prominent devision of",
			"a prominent piece of", "A prominent piece of",
			"a prominent component of", "A prominent component of",
			"a prominent share of", "A prominent share of",
			"a prominent percentage of", "A prominent percentage of",
			"a heavy portion of", "A heavy portion of", "a heavy part of",
			"A heavy part of", "a heavy section of", "A heavy section of",
			"a heavy devision of", "A heavy devision of", "a heavy piece of",
			"A heavy piece of", "a heavy component of", "A heavy component of",
			"a heavy share of", "A heavy share of", "a heavy percentage of",
			"A heavy percentage of", "a gravid portion of",
			"A gravid portion of", "a gravid part of", "A gravid part of",
			"a gravid section of", "A gravid section of",
			"a gravid devision of", "A gravid devision of",
			"a gravid piece of", "A gravid piece of", "a gravid component of",
			"A gravid component of", "a gravid share of", "A gravid share of",
			"a gravid percentage of", "A gravid percentage of",
			"a great portion of", "A great portion of", "a great part of",
			"A great part of", "a great section of", "A great section of",
			"a great devision of", "A great devision of", "a great piece of",
			"A great piece of", "a great component of", "A great component of",
			"a great share of", "A great share of", "a great percentage of",
			"A great percentage of", "a smaller portion of",
			"A smaller portion of", "a smaller part of", "A smaller part of",
			"a smaller section of", "A smaller section of",
			"a smaller devision of", "A smaller devision of",
			"a smaller piece of", "A smaller piece of",
			"a smaller component of", "A smaller component of",
			"a smaller share of", "A smaller share of",
			"a smaller percentage of", "A smaller percentage of",
			"a small portion of", "A small portion of", "a small part of",
			"A small part of", "a small section of", "A small section of",
			"a small devision of", "A small devision of", "a small piece of",
			"A small piece of", "a small component of", "A small component of",
			"a small share of", "A small share of", "a small percentage of",
			"A small percentage of", "a largest portion of",
			"A largest portion of", "a largest part of", "A largest part of",
			"a largest section of", "A largest section of",
			"a largest devision of", "A largest devision of",
			"a largest piece of", "A largest piece of",
			"a largest component of", "A largest component of",
			"a largest share of", "A largest share of",
			"a largest percentage of", "A largest percentage of",
			"a tiny portion of", "A tiny portion of", "a tiny part of",
			"A tiny part of", "a tiny section of", "A tiny section of",
			"a tiny devision of", "A tiny devision of", "a tiny piece of",
			"A tiny piece of", "a tiny component of", "A tiny component of",
			"a tiny share of", "A tiny share of", "a tiny percentage of",
			"A tiny percentage of", }; // }}

	public static String[] quantifierNone = { "the opposite of", "none of",
			"None of", "not any of", "Not any of", "not", "Not", "no", "No", };

	public static String[] quantifierAll = { "yet", "also", "mostly", "any",
			"all", "All", "whole of", "Whole of", "every", "Every", "each of",
			"Each of", "each one of", "Each one of", "Every one", "every one",
			"Everyone", "everyone", "any", "Any", };

	public static String[] quantifierAAn = { "an", "An", "a", "A", };

	public static String[] sameAs = { "same as", "equivalent to",
			"equivalent as", "equal to", "equal as", "also called as", // boot
																		// strap
			"known as", // boot strap
			"commonly known as", // boot strap
			"popularly known as", // boot strap
			"sometimes known as", };

	public NormalizeVarients(String sentence) {
		this.sentence = sentence;
	}

	
	public String normalizedSentance(String sentence) {

		sentence=normalizedSomeVarients(sentence);
		sentence=normalizedSameAs(sentence);
		sentence=normalizedQuantifierAll(sentence);
		sentence=normalizedQuantifierAan(sentence);
		sentence=normalizedDefinitionalForm(sentence); 
		sentence=normalizedAnyOf(sentence); 
		sentence=normalizeLike(sentence); 
		sentence=normalizeOnly(sentence); 
		sentence=normalizeNonXORAdverb(sentence); 
		sentence=normalizeXORAdverb(sentence); 
		sentence=normalizeQuantifierNone(sentence);
		sentence=normalizeThatVariation(sentence);
		sentence=normalizeInverseofISA(sentence);
		sentence=normalizeSuchAs(sentence);
		return sentence;
	}

	public String normalizedSomeVarients(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < someVarients.length; i++) {
			if (dSentence.toLowerCase().contains(someVarients[i])) {

				return dSentence.toString().replaceAll(someVarients[i], "some");

			}

		} // }}
		return dSentence.toString();
	}
	
	public String normalizedSameAs(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < sameAs.length; i++) {
			if (dSentence.toLowerCase().contains(sameAs[i])) {

				return dSentence.toString().replaceAll(sameAs[i], "same as");

			}

		} // }}
		return dSentence.toString();
	}
	
	public String normalizedQuantifierAll(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < quantifierAll.length; i++) {
			if (dSentence.toLowerCase().contains(quantifierAll[i])) {

				return dSentence.toString().replaceAll(quantifierAll[i], "yet");

			}

		} // }}
		return dSentence.toString();
	}

	
	public String normalizedQuantifierAan(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < quantifierAAn.length; i++) {
			if (dSentence.toLowerCase().contains(quantifierAAn[i])) {

				return dSentence.toString().replaceAll(quantifierAAn[i], "an");

			}

		} // }}
		return dSentence.toString();
	}
	
	public String normalizedDefinitionalForm(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < definitionalForm.length; i++) {
			if (dSentence.toLowerCase().contains(definitionalForm[i])) {

				return dSentence.toString().replaceAll(definitionalForm[i], "is");

			}

		} // }}
		return dSentence.toString();
	}
	public String normalizedAnyOf(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < anyOneOf.length; i++) {
			if (dSentence.toLowerCase().contains(anyOneOf[i])) {

				return dSentence.toString().replaceAll(anyOneOf[i], "any one of");

			}

		} // }}
		return dSentence.toString();
	}
	
	public String normalizeLike(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < like.length; i++) {
			if (dSentence.toLowerCase().contains(like[i])) {

				return dSentence.toString().replaceAll(like[i], "a sort of");

			}

		} // }}
		return dSentence.toString();
	}
	
	public String normalizeOnly(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < only.length; i++) {
			if (dSentence.toLowerCase().contains(only[i])) {

				return dSentence.toString().replaceAll(only[i], "only");

			}

		} // }}
		return dSentence.toString();
	}
	
	public String normalizeNonXORAdverb(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < NonXORAdverb.length; i++) {
			if (dSentence.toLowerCase().contains(NonXORAdverb[i])) {

				return dSentence.toString().replaceAll(NonXORAdverb[i], "");

			}

		} // }}
		return dSentence.toString();
	}
	
	public String normalizeXORAdverb(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < XORAdverb.length; i++) {
			if (dSentence.toLowerCase().contains(XORAdverb[i])) {

				return dSentence.toString().replaceAll(XORAdverb[i], "eventually");

			}

		} // }}
		return dSentence.toString();
	}
	public String normalizeQuantifierNone(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < quantifierNone.length; i++) {
			if (dSentence.toLowerCase().contains(quantifierNone[i])) {

				return dSentence.toString().replaceAll(quantifierNone[i], "not");

			}

		} // }}
		return dSentence.toString();
	}
	public String normalizeThatVariation(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < thatVariation.length; i++) {
			if (dSentence.toLowerCase().contains(thatVariation[i])) {

				return dSentence.toString().replaceAll(thatVariation[i], "that");

			}

		} // }}
		return dSentence.toString();
	}
	
	public String normalizeInverseofISA(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < inverseOfISA.length; i++) {
			if (dSentence.toLowerCase().contains(inverseOfISA[i])) {

				return dSentence.toString().replaceAll(inverseOfISA[i], "include");

			}

		} // }}
		return dSentence.toString();
	}
	
	public String normalizeSuchAs(String sentence) {
		String dSentence = new String(sentence);
		// {{ replace some
		for (int i = 0; i < suchas.length; i++) {
			if (dSentence.toLowerCase().contains(suchas[i])) {

				return dSentence.toString().replaceAll(suchas[i], "such as");

			}

		} // }}
		return dSentence.toString();
	}
	
	
	
}
