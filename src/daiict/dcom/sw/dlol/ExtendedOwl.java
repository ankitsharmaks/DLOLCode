package daiict.dcom.sw.dlol;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.change.OntologyAnnotationChangeData;
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
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
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
import org.semanticweb.owlapi.model.OWLObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyFormat;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLPropertyAxiom;
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



public class ExtendedOwl{
	
	//private String iri = "http://www.daiict.ac.in/dcomp/sw/dlol";
	private String iri = "e:/sample4.owl";
	private IRI ns =  IRI.create(iri);
	OWLOntologyManager m = OWLManager.createOWLOntologyManager();
	OWLDataFactory factory = m.getOWLDataFactory();
    OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
    OWLOntology o = null; 
    
    public ExtendedOwl(){
    	try{
    		o = m.createOntology(IRI.create(iri));
    		System.out.println(o);
    	} catch (Exception e){
    		System.out.println("Cannot create ontology");
    	}
    }
    
    public void createSubsumption(String a,String b){    	
    	 	OWLClass left = factory.getOWLClass(IRI.create(ns +a));
	        OWLClass right = factory.getOWLClass(IRI.create(ns + b));
	        OWLAxiom leftSubsetRight = factory.getOWLSubClassOfAxiom(left, right);
	        m.addAxiom(o, leftSubsetRight);
	        
    }
		
    private OWLClassExpression createUnion(Set<OWLClass> list){    	
    	return factory.getOWLObjectUnionOf(list);   	
    }
    
    private OWLClassExpression createIntersection(Set<OWLClass> list){    	
    	return factory.getOWLObjectIntersectionOf(list);   	
    }
    
    
    public void createUnion(String subject, ArrayList<String> objects, boolean isSubset){
    	OWLAxiom axiom = null;
    	if(isSubset){
    		axiom = factory.getOWLSubClassOfAxiom(transform(subject), createUnion(transform(objects)));
    	} else {
    		axiom = factory.getOWLEquivalentClassesAxiom(transform(subject), createUnion(transform(objects)));
    	}
    	
    	m.addAxiom(this.o, axiom);
    }
    
    public void createIntersection(String subject, ArrayList<String> objects, boolean isSubset){
    	OWLAxiom axiom = null;
    	if(isSubset){
    		axiom = factory.getOWLSubClassOfAxiom(transform(subject), createIntersection(transform(objects)));
    	} else {
    		axiom = factory.getOWLEquivalentClassesAxiom(transform(subject), createIntersection(transform(objects)));
    	}
    	
    	m.addAxiom(this.o, axiom);
    }
    
    private OWLClass transform(String cls){
    	return factory.getOWLClass(augment(cls));
    }
    
    private Set<OWLClass> transform(ArrayList<String> sClasses){
    	Set<OWLClass> oClasses = new TreeSet<OWLClass>();
    	
    	for(String s : sClasses){
    		oClasses.add(factory.getOWLClass(augment(s)));
    	}
    	
    	return oClasses;
    }
    public boolean doExist(String a){
    	if(factory.getOWLClass(augment(a)).equals(null))
    	return false;
    	else
    		return true;
    }
    
    public void createObjectProperty( String submod,String subject,String prop,String objmod, String object, boolean isForAll){
    	if(isForAll){
    		/*OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
        	OWLObjectAllValuesFrom right = factory.getOWLObjectAllValuesFrom(relation, factory.getOWLClass(augment(object)));
        	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(factory.getOWLClass(augment(subject)), right);
        	m.addAxiom(this.o, axiom);*/
    		if(!submod.equals("")&&!objmod.equals("")){
        		OWLClass left=factory.getOWLClass(modaugment(submod,subject));
        		System.out.println(left);
        		OWLClass subj=factory.getOWLClass(augment(subject));
        		OWLClass obj=factory.getOWLClass(augment(object));
        		OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
        		OWLClass right1=factory.getOWLClass(modaugment(objmod,object));
        		OWLObjectAllValuesFrom right = factory.getOWLObjectAllValuesFrom(relation,right1);
            	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(left, right);
            	 OWLAxiom modsubSubsetsub = factory.getOWLSubClassOfAxiom(left,subj);
            	 OWLAxiom modobSubsetob = factory.getOWLSubClassOfAxiom(right1,obj);
            	m.addAxiom(this.o, axiom);
            	m.addAxiom(this.o, modsubSubsetsub);
            	m.addAxiom(this.o, modobSubsetob);
            	}
        		if(!submod.equals("")&&objmod.equals("")){
        			OWLClass left=factory.getOWLClass(modaugment(submod,subject));
            		System.out.println(left);
            		OWLClass subj=factory.getOWLClass(augment(subject));
            		
            		OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
            		OWLClass right1=factory.getOWLClass(augment(object));
            		OWLObjectAllValuesFrom right = factory.getOWLObjectAllValuesFrom(relation,right1);
                	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(left, right);
                	 OWLAxiom modsubSubsetsub = factory.getOWLSubClassOfAxiom(left,subj);
                	
                	m.addAxiom(this.o, axiom);
                	m.addAxiom(this.o, modsubSubsetsub);
                	
        		}
        		if(submod.equals("")&&!objmod.equals("")){
            		
            		OWLClass subj=factory.getOWLClass(augment(subject));
            		OWLClass obj=factory.getOWLClass(augment(object));
            		OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
            		OWLClass right1=factory.getOWLClass(modaugment(objmod,object));
                	OWLObjectAllValuesFrom right = factory.getOWLObjectAllValuesFrom(relation,right1);
                	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(subj, right);
                	
                	 OWLAxiom modobSubsetob = factory.getOWLSubClassOfAxiom(right1,obj);
                	m.addAxiom(this.o, axiom);
                	
                	m.addAxiom(this.o, modobSubsetob);
                	}
    	if(submod.equals("")&&objmod.equals("")){
            		
            		OWLClass subj=factory.getOWLClass(augment(subject));
            		OWLClass obj=factory.getOWLClass(augment(object));
            		OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
            	
                	OWLObjectAllValuesFrom right = factory.getOWLObjectAllValuesFrom(relation,obj);
                	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(subj, right);
                	
                	 
                	m.addAxiom(this.o, axiom);
                	
                
                	}
    	} else {
    		/*OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
        	OWLObjectSomeValuesFrom right = factory.getOWLObjectSomeValuesFrom(relation, factory.getOWLClass(augment(object)));
        	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(factory.getOWLClass(augment(subject)), right);
        	m.addAxiom(this.o, axiom);*/
    		if(!submod.equals("")&&!objmod.equals("")){
    		OWLClass left=factory.getOWLClass(modaugment(submod,subject));
    		System.out.println(left);
    		OWLClass subj=factory.getOWLClass(augment(subject));
    		OWLClass obj=factory.getOWLClass(augment(object));
    		OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
    		OWLClass right1=factory.getOWLClass(modaugment(objmod,object));
        	OWLObjectSomeValuesFrom right = factory.getOWLObjectSomeValuesFrom(relation,right1);
        	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(left, right);
        	 OWLAxiom modsubSubsetsub = factory.getOWLSubClassOfAxiom(left,subj);
        	 OWLAxiom modobSubsetob = factory.getOWLSubClassOfAxiom(right1,obj);
        	m.addAxiom(this.o, axiom);
        	m.addAxiom(this.o, modsubSubsetsub);
        	m.addAxiom(this.o, modobSubsetob);
        	}
    		if(!submod.equals("")&&objmod.equals("")){
    			OWLClass left=factory.getOWLClass(modaugment(submod,subject));
        		System.out.println(left);
        		OWLClass subj=factory.getOWLClass(augment(subject));
        		
        		OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
        		OWLClass right1=factory.getOWLClass(augment(object));
            	OWLObjectSomeValuesFrom right = factory.getOWLObjectSomeValuesFrom(relation,right1);
            	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(left, right);
            	 OWLAxiom modsubSubsetsub = factory.getOWLSubClassOfAxiom(left,subj);
            	
            	m.addAxiom(this.o, axiom);
            	m.addAxiom(this.o, modsubSubsetsub);
            	
    		}
    		if(submod.equals("")&&!objmod.equals("")){
        		
        		OWLClass subj=factory.getOWLClass(augment(subject));
        		OWLClass obj=factory.getOWLClass(augment(object));
        		OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
        		OWLClass right1=factory.getOWLClass(modaugment(objmod,object));
            	OWLObjectSomeValuesFrom right = factory.getOWLObjectSomeValuesFrom(relation,right1);
            	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(subj, right);
            	
            	 OWLAxiom modobSubsetob = factory.getOWLSubClassOfAxiom(right1,obj);
            	m.addAxiom(this.o, axiom);
            	
            	m.addAxiom(this.o, modobSubsetob);
            	}
	if(submod.equals("")&&objmod.equals("")){
        		
        		OWLClass subj=factory.getOWLClass(augment(subject));
        		OWLClass obj=factory.getOWLClass(augment(object));
        		OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
        	
            	OWLObjectSomeValuesFrom right = factory.getOWLObjectSomeValuesFrom(relation,obj);
            	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(subj, right);
            	
            	 
            	m.addAxiom(this.o, axiom);
            	
            
            	}
    	}
    }
    
    
   

	public void createDataObject(String subject,String prop, String object,boolean isForAll,double value) throws OWLOntologyStorageException{
    	if(isForAll){
    		//System.out.println(object);
    		OWLDataPropertyExpression relation = factory.getOWLDataProperty(augment(prop));
    		OWLDataRange datarange = factory.getOWLDatatypeRestriction(
	        		factory.getDoubleOWLDatatype(), OWLFacet.MIN_INCLUSIVE, factory.getOWLLiteral(value));
        	
        	 OWLClassExpression dataexp = factory.getOWLDataSomeValuesFrom(relation,
        			 datarange);
       
        	 OWLClass ob = factory.getOWLClass(augment(object));
 	        OWLSubClassOfAxiom ax = factory.getOWLSubClassOfAxiom(ob, dataexp);
 	        System.out.println(ax);
 	        m.applyChange(new AddAxiom(o, ax));	
 	     
        
    	} else {	//System.out.println(subject);
    		OWLObjectPropertyExpression relation = factory.getOWLObjectProperty(augment(prop));
        	OWLObjectSomeValuesFrom right = factory.getOWLObjectSomeValuesFrom(relation, factory.getOWLClass(augment(object)));
        	OWLAxiom axiom = factory.getOWLEquivalentClassesAxiom(factory.getOWLClass(augment(subject)), right);
        	m.addAxiom(this.o, axiom);
    	}
    	  for(OWLAxiom A : o.getAxioms()){
	        	System.out.println(A.toString());
	        }
    	
    	
    }
    
    private IRI augment(String a){
    	return IRI.create(ns + "#" + a);
    }
    private IRI modaugment(String b,String a){
    	return IRI.create(ns + "#" +b+a);
    }
    
    public void save(String path) throws OWLOntologyStorageException, OWLOntologyCreationException{
    	  File file = new File(path);
    	  m.saveOntology(o, IRI.create(file.toURI()));
    }
}
