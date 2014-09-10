package daiict.dcom.sw.dlol;

import daiict.dcom.sw.dlol.ExtendedOwl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.OWLXMLOntologyFormat;
import org.semanticweb.owlapi.io.StreamDocumentTarget;
import org.semanticweb.owlapi.io.StringDocumentSource;
import org.semanticweb.owlapi.io.StringDocumentTarget;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.AddOntologyAnnotation;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDatatypeRestriction;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLException;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.model.RemoveAxiom;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLClassAtom;
import org.semanticweb.owlapi.model.SWRLObjectPropertyAtom;
import org.semanticweb.owlapi.model.SWRLRule;
import org.semanticweb.owlapi.model.SWRLVariable;
import org.semanticweb.owlapi.profiles.OWL2DLProfile;
import org.semanticweb.owlapi.profiles.OWLProfileReport;
import org.semanticweb.owlapi.profiles.OWLProfileViolation;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.util.AutoIRIMapper;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredSubClassAxiomGenerator;
import org.semanticweb.owlapi.util.OWLClassExpressionVisitorAdapter;
import org.semanticweb.owlapi.util.OWLEntityRemover;
import org.semanticweb.owlapi.util.OWLObjectVisitorExAdapter;
import org.semanticweb.owlapi.util.OWLOntologyMerger;
import org.semanticweb.owlapi.util.OWLOntologyWalker;
import org.semanticweb.owlapi.util.OWLOntologyWalkerVisitor;
import org.semanticweb.owlapi.util.SimpleIRIMapper;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.semanticweb.owlapi.vocab.OWLFacet;
import org.semanticweb.owlapi.vocab.OWLRDFVocabulary;

import uk.ac.manchester.cs.owlapi.modularity.ModuleType;
import uk.ac.manchester.cs.owlapi.modularity.SyntacticLocalityModuleExtractor;


public class TutorialSnippets {
	
    
    public static void main(String args[]) throws Exception{
    OWLDataFactory df = OWLManager.getOWLDataFactory();
    String submod="Beautiful";
	String sub="Man";
	String objmod="Beautiful";
	String obj="woman";
	String prop="loves";
	double value=18;
	boolean isForAll=true;
	String path="e:/sample3.owl";
	ExtendedOwl eo=new ExtendedOwl();
	//eo.createDataObject(sub, prop, obj, isForAll, value);
	eo.createObjectProperty(submod,sub, prop,objmod, obj, true);
	eo.save(path);
	testOntologyLoading();
         
        
    
}
	 public static void testOntologyLoading() throws Exception {
	        OWLOntologyManager m = OWLManager.createOWLOntologyManager();
	        //System.out.println(pizza_iri);
	        OWLOntology o = m.createOntology(IRI.create(new File("e:/sample2.owl")));
	        OWLDataFactory factory = m.getOWLDataFactory();
	        OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
	        OWLClass b = factory.getOWLClass(IRI.create("B"));
	        OWLClass c = factory.getOWLClass(IRI.create("C"));
	        OWLClass a = factory.getOWLClass(IRI.create("A"));
	        OWLAxiom bSubsetC = factory.getOWLSubClassOfAxiom(b, c);
	       // m.addAxiom(o, bSubsetC);
	        
	        OWLDataProperty hasAge = factory.getOWLDataProperty(IRI.create("hasAge"));
	       
	        OWLDataRange greaterThan18 = factory.getOWLDatatypeRestriction(
	        		factory.getIntegerOWLDatatype(), OWLFacet.MIN_INCLUSIVE, factory.getOWLLiteral(18));
	        
	        OWLClassExpression adultDefinition = factory.getOWLDataSomeValuesFrom(hasAge,
	                greaterThan18);
	        
	        
	        OWLClass adult = factory.getOWLClass(IRI.create("#Adult"));
	        OWLSubClassOfAxiom ax = factory.getOWLSubClassOfAxiom(adult, adultDefinition);
	        m.applyChange(new AddAxiom(o, ax));	
	        
	        OWLIndividual matthew = factory.getOWLNamedIndividual(IRI.create("#matthew"));
	        OWLIndividual peter = factory.getOWLNamedIndividual(IRI.create("#peter"));
	  
	        OWLObjectProperty hasFather = factory.getOWLObjectProperty(IRI.create("#hasFather"));
	        OWLObjectProperty hasTest = factory.getOWLObjectProperty(IRI.create("#hasTest"));
	        OWLObjectPropertyAssertionAxiom assertion = factory.getOWLObjectPropertyAssertionAxiom(hasFather, matthew, peter);
	       
		     
	        AddAxiom addAxiomChange = new AddAxiom(o, assertion);
	        m.applyChange(addAxiomChange);

	        OWLClass personClass = factory.getOWLClass(IRI.create( "#Person"));
	        OWLClassAssertionAxiom ax1 = factory.getOWLClassAssertionAxiom(personClass, matthew);
	        OWLObjectIntersectionOf bAndC = factory.getOWLObjectIntersectionOf(b, c);
	        OWLObjectUnionOf bOrc=factory.getOWLObjectUnionOf(b,c);
	       
	       OWLObjectProperty hasLove=OWLObjectProperty(IRI.create("#hasLove"));
	       OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(IRI.create("#hasLove"));
        	
        //	System.out.println(relation);
	        
	        OWLEquivalentClassesAxiom AequalsBandC = factory.getOWLEquivalentClassesAxiom(b,bAndC);
	        OWLEquivalentClassesAxiom AequalsBorC = factory.getOWLEquivalentClassesAxiom(b,bOrc);
	        OWLObjectAllValuesFrom right = factory.getOWLObjectAllValuesFrom(relation, bAndC);
	        
	        OWLEquivalentClassesAxiom AB = factory.getOWLEquivalentClassesAxiom(a,right);
	        m.addAxiom(o, AB);
	        //m.addAxiom(o, AequalsBandC);
	        //m.addAxiom(o, AequalsBorC);
	        //m.addAxiom(o, ax1);
	       
	      
	        
	        
	       
	        System.out.println(adultDefinition.asDisjunctSet());
	        
	        OWLOntologyFormat format = m.getOntologyFormat(o);
	    	System.out.println(" format: " + format);
	   	 m.saveOntology(o,format);
	        
	        
	        
	        
	        
	        
	        for(OWLAxiom A : o.getAxioms()){
	        	System.out.println(A.toString());
	        }
	    }
	private static OWLObjectProperty OWLObjectProperty(IRI create) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

 
