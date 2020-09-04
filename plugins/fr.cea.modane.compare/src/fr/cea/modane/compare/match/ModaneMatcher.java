package fr.cea.modane.compare.match;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.compare.internal.utils.DiffUtil;
import org.eclipse.emf.compare.match.eobject.EqualityHelperExtensionProvider.SpecificMatch;
import org.eclipse.emf.compare.utils.IEqualityHelper;
import org.eclipse.emf.ecore.EObject;

import fr.cea.modane.modane.ArgDefinition;
import fr.cea.modane.modane.EntryPoint;
import fr.cea.modane.modane.Enumeration;
import fr.cea.modane.modane.EnumerationLiteral;
import fr.cea.modane.modane.Function;
import fr.cea.modane.modane.Interface;
import fr.cea.modane.modane.Item;
import fr.cea.modane.modane.ItemGroup;
import fr.cea.modane.modane.ItemGroupType;
import fr.cea.modane.modane.ItemType;
import fr.cea.modane.modane.Legacy;
import fr.cea.modane.modane.ModaneModel;
import fr.cea.modane.modane.Module;
import fr.cea.modane.modane.NamedElement;
import fr.cea.modane.modane.OverrideFunction;
import fr.cea.modane.modane.Pty;
import fr.cea.modane.modane.PtyOrArgType;
import fr.cea.modane.modane.Reference;
import fr.cea.modane.modane.Referenceable;
import fr.cea.modane.modane.Service;
import fr.cea.modane.modane.Simple;
import fr.cea.modane.modane.SimpleType;
import fr.cea.modane.modane.Struct;
import fr.cea.modane.modane.UnitTestFunction;
import fr.cea.modane.modane.VarDefinition;
import fr.cea.modane.modane.VarReference;
import fr.cea.modane.modane.Variable;
import fr.cea.modane.modane.util.ModaneSwitch;

@SuppressWarnings("restriction")
public class ModaneMatcher extends ModaneSwitch<SpecificMatch> {
	
	private final double STRING_SIMILARITY_THRESHSOLD = 0.7d;
	
	private EObject object2 = null;
	
	private Map<EObject, String> cacheQualifiedNames = new HashMap<EObject, String>();
	
	private Map<EObject, Collection<EObject>> cacheMatchingObjects = new HashMap<EObject, Collection<EObject>>();

	public SpecificMatch matchingEObjects(EObject object1, EObject object2, IEqualityHelper equalityHelper) {
		if (object1 == null || object2 == null) {
			return SpecificMatch.UNMATCH;
		}
		
		// Objects must have the same class
		if (!object1.eClass().equals(object2.eClass())) {
			return SpecificMatch.UNMATCH;
		}
		
		// Compute matching
		return doSwitchBetweenObjects(object1, object2);
	}
	
	private void putInCacheOfMatchingObjects(EObject object1, EObject object2) {
		Collection<EObject> matchingObjects = null;
		if (cacheMatchingObjects.containsKey(object1)) {
			matchingObjects = cacheMatchingObjects.get(object1);;
		} else {
			matchingObjects = new ArrayList<EObject>();
			cacheMatchingObjects.put(object1, matchingObjects);
		}
		matchingObjects.add(object2);
	}
	
	private boolean inCacheOfMatchingObjects(EObject object1, EObject object2) {
		if (cacheMatchingObjects.containsKey(object1)) {
			return cacheMatchingObjects.get(object1).contains(object2);
		} else if (cacheMatchingObjects.containsKey(object2)) {
			return cacheMatchingObjects.get(object2).contains(object1);
		}
		return false;
	}
	
	private SpecificMatch doSwitchBetweenObjects(EObject o1, EObject o2) {
		this.object2 = o2;
		
		// Check in cache
		if (inCacheOfMatchingObjects(o1, o2)) {
			return SpecificMatch.MATCH;
		}
		
		SpecificMatch match = super.doSwitch(o1);
		// Put the result into cache
		if (SpecificMatch.MATCH.equals(match)) {
			putInCacheOfMatchingObjects(o1, o2);
		}
		
		return match;
	}

	@Override
	public SpecificMatch caseModaneModel(ModaneModel o1) {
		ModaneModel o2 = (ModaneModel)object2;
		
		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		} else {
			return SpecificMatch.UNMATCH;
		}
	}
	
	@Override
	public SpecificMatch caseService(Service o1) {
		Service o2 = (Service)object2;
		
		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		} else {
			// Interfaces, properties, functions and override functions must match
			if (matchingCollections(o1.getInterfaces(), o2.getInterfaces())
					&& matchingPropertiesLists(o1.getProperties(), o2.getProperties())
					&& matchingFunctionsContentsLists(o1.getFunctions(), o2.getFunctions())
					&& matchingOverrideFuncsContentsLists(o1.getOverrideFuncs(), o2.getOverrideFuncs())) {
				return SpecificMatch.MATCH;
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseModule(Module o1) {
		Module o2 = (Module)object2;
		
		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		} else {
			// Interfaces, properties, entry points, functions and override functions must match
			if (matchingCollections(o1.getInterfaces(), o2.getInterfaces())
					&& matchingPropertiesLists(o1.getProperties(), o2.getProperties())
					&& matchingEntrypointsLists(o1.getEntryPoints(), o2.getEntryPoints())
					&& matchingFunctionsContentsLists(o1.getFunctions(), o2.getFunctions())
					&& matchingOverrideFuncsContentsLists(o1.getOverrideFuncs(), o2.getOverrideFuncs())) {
				return SpecificMatch.MATCH;
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseStruct(Struct o1) {
		Struct o2 = (Struct)object2;
		
		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		} else {
			// Parents, properties, functions must match
			if (matchingCollections(o1.getParents(), o2.getParents())
					&& matchingPropertiesLists(o1.getProperties(), o2.getProperties())) {
				return SpecificMatch.MATCH;
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseInterface(Interface o1) {
		Interface o2 = (Interface)object2;

		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		} else {
			// Parents, properties, functions must match
			if (matchingCollections(o1.getParents(), o2.getParents())
					&& matchingPropertiesLists(o1.getProperties(), o2.getProperties())
					&& matchingFunctionsContentsLists(o1.getFunctions(), o2.getFunctions())) {
				return SpecificMatch.MATCH;
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseEnumeration(Enumeration o1) {
		Enumeration o2 = (Enumeration)object2;

		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		} else {
			// Literals must have same name and value
			if (o1.getLiterals().size() == o2.getLiterals().size()) {
				Iterator<EnumerationLiteral> i1 = o1.getLiterals().iterator();
				Iterator<EnumerationLiteral> i2 = o2.getLiterals().iterator();
				while (i1.hasNext() && i2.hasNext()) {
					EnumerationLiteral e1 = i1.next();
					EnumerationLiteral e2 = i2.next();
					
					// Names must be the same
					if (	(e1.getName() == null && e2.getName() != null)
							|| (e1.getName() != null && e2.getName() == null)
							|| !e1.getName().equals(e2.getName())	) {
						return SpecificMatch.UNMATCH;
					}
					// Values must be the same
					if (	(e1.getValue() == null && e2.getValue() != null)
							|| (e1.getValue() != null && e2.getValue() == null)
							|| !e1.getValue().equals(e2.getValue())	) {
						return SpecificMatch.UNMATCH;
					}
				}
				return SpecificMatch.MATCH;
			}
			
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseLegacy(Legacy o1) {
		Legacy o2 = (Legacy)object2;

		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		} else {
			// OriginFile must be the same
			if (o1.getOriginFile() != null
					&& o1.getOriginFile().equals(o2.getOriginFile())) {
				return SpecificMatch.MATCH;
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseVariable(Variable o1) {
		Variable o2 = (Variable)object2;

		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		} else {
			// If names match
			if (o1.getName() != null && o1.getName().equals(o2.getName())) {
				// Support, multiplicity and type must match
				if (o1.getSupport() != null && o1.getSupport().equals(o2.getSupport())
						&& o1.getMultiplicity() != null && o1.getMultiplicity().equals(o2.getMultiplicity())
						&& o1.getType() != null && o1.getType().equals(o2.getType())) {
					return SpecificMatch.MATCH;
				}				
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseArgDefinition(ArgDefinition o1) {
		ArgDefinition o2 = (ArgDefinition)object2;

		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		} else {
			// Containers must match
			if (matchingContainers(o1, o2)) {
				// Names match
				if (o1.getName() != null && o1.getName().equals(o2.getName())) {
					return SpecificMatch.MATCH;
				}
				// Direction and type must match
				if (o1.getDirection() != null && o1.getDirection().equals(o2.getDirection())
						&& o1.getType() != null && o1.getType().equals(o2.getType())) {
					return SpecificMatch.MATCH;
				}
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseSimple(Simple o1) {
		Simple o2 = (Simple)object2;

		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Type must be the same
			if (o1.getType() != null && o1.getType().equals(o2.getType())) {
				return SpecificMatch.MATCH;
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseItem(Item o1) {
		Item o2 = (Item)object2;

		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Type must be the same
			if (o1.getType() != null && o1.getType().equals(o2.getType())) {
				return SpecificMatch.MATCH;
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseItemGroup(ItemGroup o1) {
		ItemGroup o2 = (ItemGroup)object2;

		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Type must be the same
			if (o1.getType() != null && o1.getType().equals(o2.getType())) {
				return SpecificMatch.MATCH;
			}
		}

		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseReference(Reference o1) {
		Reference o2 = (Reference)object2;
		
		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Target must match
			if (SpecificMatch.MATCH.equals(doSwitchBetweenObjects(o1.getTarget(), o2.getTarget()))) {
				return SpecificMatch.MATCH;
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseEnumerationLiteral(EnumerationLiteral o1) {
		EnumerationLiteral o2 = (EnumerationLiteral)object2;
		
		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Name is the same
			if (o1.getName() != null && o1.getName().equals(o2.getName())) {
				return SpecificMatch.MATCH;
			}
		}
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch casePty(Pty o1) {
		Pty o2 = (Pty)object2;
		
		// Qualified names match
		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		}
		
		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Name is the same
			if (o1.getName() != null && o1.getName().equals(o2.getName())) {
				return SpecificMatch.MATCH;
			}
			// Name is similar
			if (similarStrings(o1.getName(), o2.getName())) {
				// Compare types
				return doSwitchBetweenObjects(o1.getType(), o2.getType());
			}
		}
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseFunction(Function o1) {
		Function o2 = (Function)object2;

		// Qualified names match
		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		}
		
		// Containers must match
		if (matchingContainers(o1, o2) && matchingFunctionsContents(o1, o2)) {
			return SpecificMatch.MATCH;
		}
		return SpecificMatch.UNMATCH;
	}
	
	private boolean matchingFunctionsContentsLists(Collection<Function> c1, Collection<Function> c2) {
		if (c1.size() != c2.size()) {
			return false;
		} else {
			Iterator<Function> i1 = c1.iterator();
			Iterator<Function> i2 = c2.iterator();
			while (i1.hasNext() && i2.hasNext()) {
				Function f1 = i1.next();
				Function f2 = i2.next();
				
				if (!matchingFunctionsContents(f1, f2)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean matchingFunctionsContents(Function o1, Function o2) {
		// Name is the same
		if (o1.getName() != null && o1.getName().equals(o2.getName())) {
			return true;
		}
		// Name is similar
		if (similarStrings(o1.getName(), o2.getName())) {
			// Compare types and support
			if (matchingPtyOrArgType(o1.getType(), o2.getType())
					&& ((o1 == null && o2 == null) || o1.getSupport().equals(o2.getSupport()))) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public SpecificMatch caseOverrideFunction(OverrideFunction o1) {
		OverrideFunction o2 = (OverrideFunction)object2;
	
		// Containers  must match
		if (matchingContainers(o1, o2)) {
			// Function must match
			return doSwitchBetweenObjects(o1.getFunc(), o2.getFunc());
		}
		return SpecificMatch.UNMATCH;
				
	}
	
	private boolean matchingOverrideFuncsContentsLists(Collection<OverrideFunction> c1, Collection<OverrideFunction> c2) {
		if (c1.size() != c2.size()) {
			return false;
		} else {
			Iterator<OverrideFunction> i1 = c1.iterator();
			Iterator<OverrideFunction> i2 = c2.iterator();
			while (i1.hasNext() && i2.hasNext()) {
				OverrideFunction of1 = i1.next();
				OverrideFunction of2 = i2.next();
				
				if (!SpecificMatch.MATCH.equals(doSwitchBetweenObjects(of1.getFunc(), of2.getFunc()))) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public SpecificMatch caseEntryPoint(EntryPoint o1) {
		EntryPoint o2 = (EntryPoint)object2;
		
		// Qualified names match
		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		}
		
		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Name is the same
			if (o1.getName() != null && o1.getName().equals(o2.getName())) {
				return SpecificMatch.MATCH;
			}
		}
		return SpecificMatch.UNMATCH;
	}
	
	private boolean matchingEntrypointsLists(Collection<EntryPoint> c1, Collection<EntryPoint> c2) {
		if (c1.size() != c2.size()) {
			return false;
		} else {
			Iterator<EntryPoint> i1 = c1.iterator();
			Iterator<EntryPoint> i2 = c2.iterator();
			while (i1.hasNext() && i2.hasNext()) {
				EntryPoint e1 = i1.next();
				EntryPoint e2 = i2.next();
				
				if (!(e1.getName() != null && e1.getName().equals(e2.getName()))) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public SpecificMatch caseUnitTestFunction(UnitTestFunction o1) {
		UnitTestFunction o2 = (UnitTestFunction)object2;

		// Qualified names match
		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		}
		
		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Name is the same
			if (o1.getName() != null && o1.getName().equals(o2.getName())) {
				return SpecificMatch.MATCH;
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseVarReference(VarReference o1) {
		VarReference o2 = (VarReference)object2;

		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Direction and variable must match
			if (o1.getDirection() != null && o1.getDirection().equals(o2.getDirection())) {
				return doSwitchBetweenObjects(o1.getVariable(), o2.getVariable());
			}
		}
		
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch caseVarDefinition(VarDefinition o1) {
		VarDefinition o2 = (VarDefinition)object2;

		// Qualified names match
		if (matchingQualifiedNames(o1, o2)) {
			return SpecificMatch.MATCH;
		}
		
		// Containers must match
		if (matchingContainers(o1, o2)) {
			// Name is the same
			if (o1.getName() != null && o1.getName().equals(o2.getName())) {
				return SpecificMatch.MATCH;
			}
			// Name is similar
			if (similarStrings(o1.getName(), o2.getName())) {
				// Compare types, support and direction
				if (o1.getType() != null && o1.getType().equals(o2.getType())
						&& o1.getSupport() != null && o1.getSupport().equals(o2.getSupport())
						&& o1.getDirection() != null && o1.getDirection().equals(o2.getDirection())) {
					return SpecificMatch.MATCH;
				}
			}
		}
		return SpecificMatch.UNMATCH;
	}
	
	@Override
	public SpecificMatch defaultCase(EObject object) {
		return SpecificMatch.UNKNOWN;
	}
	
	/**
	 * We need a specific method to match collection of properties as we can not test if containers match or it will create an infinite loop
	 * @param o1
	 * @param o2
	 * @return
	 */
	private boolean matchingPropertiesLists(Collection<Pty> c1, Collection<Pty> c2) {
		if (c1.size() != c2.size()) {
			return false;
		} else {
			Iterator<Pty> i1 = c1.iterator();
			Iterator<Pty> i2 = c2.iterator();
			while (i1.hasNext() && i2.hasNext()) {
				Pty p1 = i1.next();
				Pty p2 = i2.next();
				
				// Name is the same
				boolean sameName = (p1.getName() == null || p1.getName().equals(p2.getName()));
				if (!sameName) {
					// Name is similar and type is the same
					boolean similarNameAndSameType = similarStrings(p1.getName(), p2.getName())
							&& matchingPtyOrArgType(p1.getType(), p2.getType());
					if (!similarNameAndSameType) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private boolean matchingPtyOrArgType(PtyOrArgType p1, PtyOrArgType p2) {
		if (p1 == null && p2 == null) {
			return true;
		}
		if (p1 instanceof Item && p2 instanceof Item) {
			ItemType t1 = ((Item)p1).getType();
			ItemType t2 = ((Item)p2).getType();
			return t1 != null && t1.equals(t2);
		}
		if (p1 instanceof ItemGroup && p2 instanceof ItemGroup) {
			ItemGroupType t1 = ((ItemGroup)p1).getType();
			ItemGroupType t2 = ((ItemGroup)p2).getType();
			return t1 != null && t1.equals(t2);
		}
		if (p1 instanceof Simple && p2 instanceof Simple) {
			SimpleType t1 = ((Simple)p1).getType();
			SimpleType t2 = ((Simple)p2).getType();
			return t1 != null && t1.equals(t2);
		}
		if (p1 instanceof Reference && p2 instanceof Reference) {
			Referenceable t1 = ((Reference)p1).getTarget();
			Referenceable t2 = ((Reference)p2).getTarget();
			return SpecificMatch.MATCH.equals(doSwitchBetweenObjects(t1, t2));
		}
		
		return false;
		
	}
	
	private boolean matchingContainers(EObject o1, EObject o2) {
		return SpecificMatch.MATCH.equals(doSwitchBetweenObjects(o1.eContainer(), o2.eContainer()));
	}
	
	@SuppressWarnings("unchecked")
	private boolean matchingCollections(Collection<? extends EObject> c1, Collection<? extends EObject> c2) {
		if (c1.size() != c2.size()) {
			return false;
		} else {
			Iterator<EObject> i1 = (Iterator<EObject>) c1.iterator();
			Iterator<EObject> i2 = (Iterator<EObject>) c2.iterator();
			while (i1.hasNext() && i2.hasNext()) {
				EObject e1 = (EObject)i1.next();
				EObject e2 = (EObject)i2.next();
				SpecificMatch m = doSwitchBetweenObjects(e1, e2);
				if (!SpecificMatch.MATCH.equals(m)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean matchingQualifiedNames(EObject o1, EObject o2) {
		String n1 = getQualifiedName(o1);
		String n2 = getQualifiedName(o2);
		return n1 != null && n1.equals(n2);
	}
	
	private String getQualifiedName(EObject o) {
		if (cacheQualifiedNames.containsKey(o)) {
			return cacheQualifiedNames.get(o);
		}
		String name = null;
		boolean nameFound = false;
		if (o instanceof NamedElement) {
			name = ((NamedElement) o).getName();
			nameFound = true;
		} else if (o instanceof ModaneModel) {
			name = ((ModaneModel) o).getName();
			nameFound = true;
		}
		if (nameFound) {
			String parentName = getQualifiedName(o.eContainer());
			if (parentName != null) {
				name = parentName + "::" + name;
			}
			cacheQualifiedNames.put(o, name);
			return name;
		}
		return null;
	}
	
	private boolean similarStrings(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		return STRING_SIMILARITY_THRESHSOLD < DiffUtil.diceCoefficient(s1, s2);
	}
}
