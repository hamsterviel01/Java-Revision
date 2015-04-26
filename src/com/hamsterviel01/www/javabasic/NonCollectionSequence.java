package com.hamsterviel01.www.javabasic;

import java.util.Iterator;

class PetSequence {
	protected Pet[] pets = new Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence {
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>(){
			private int index = 0;
			public boolean hasNext() {
				return index < pets.length;
			}
		};
	}
	
	static class testIterable implements Iterable {
		int var1;
		public static void testVar(){
			System.out.println("");
		}
		@Override
		public Iterator<T> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
