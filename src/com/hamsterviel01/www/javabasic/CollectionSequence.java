package com.hamsterviel01.www.javabasic;

import typeinfo.pets.*;
import java.util.*;

public class CollectionSequence extends AbstractCollection<Pet> {
  private Pet[] pets = Pets.createArray(8);
  List<Integer> arrayList = new ArrayList<Integer>();
  Iterator iterator = arrayList.iterator();
  public int size() { return pets.length; }
  public Iterator<Pet> iterator() {
    return new Iterator<Pet>() {
      private int index = 0;
      public boolean hasNext() {
        return index < pets.length;
      }
      public Pet next() { return pets[index++]; }
      public void remove() { // Not implemented
        throw new UnsupportedOperationException();
      }
    };
  }
  public static void main(String[] args) {
    CollectionSequence c = new CollectionSequence();
    InterfaceVsIterator.display(c);
    InterfaceVsIterator.display(c.iterator());
  }
} 

class InterfaceVsIterator {
	public static void display(Iterator<Pet> it) {
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();
	}

	public static void display(Collection<Pet> pets) {
		for (Pet p : pets)
			System.out.print(p.id() + ":" + p + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		List<Pet> petList = Pets.arrayList(8);
		Set<Pet> petSet = new HashSet<Pet>(petList);
		Map<String, Pet> petMap = new LinkedHashMap<String, Pet>();
		String[] names = ("Ralph, Eric, Robin, Lacey, "
				+ "Britney, Sam, Spot, Fluffy").split(", ");
		for (int i = 0; i < names.length; i++)
			petMap.put(names[i], petList.get(i));
		display(petList);
		display(petSet);
		display(petList.iterator());
		display(petSet.iterator());
		System.out.println(petMap);
		System.out.println(petMap.keySet());
		display(petMap.values());
		display(petMap.values().iterator());
	}
}
