package com.hamsterviel01.www.javabasic;

import java.util.*;

enum Pet{
	DOG, CAT, FLY, TIGER, DOLPHIN
}

public class TestList {
	public static void main(String[] args){
		List pets = new ArrayList();
		List<Pet> petParameterized = new ArrayList<Pet>();
		List<Pet> petOriginal = new ArrayList<Pet>(Arrays.asList(Pet.DOG, Pet.CAT, Pet.CAT, Pet.FLY, Pet.DOLPHIN));
		
		petParameterized.add(Pet.DOG);
		Collections.addAll(petParameterized, Pet.DOG, Pet.CAT, Pet.CAT, Pet.FLY);
		System.out.println(petParameterized);
		System.out.println(petParameterized.size());
		
		pets.add(Pet.DOG);
//		pets.add(Pet.TIGER);
		
		petParameterized.retainAll(pets);
		System.out.println(petParameterized);
//		petParameterized.removeAll(pets);
//		System.out.println(petParameterized);
		
		petParameterized = new ArrayList<Pet>(petOriginal);
		petParameterized.addAll(pets);
		System.out.println(petParameterized);
		Object[] petArray = petParameterized.toArray();
	}
}
