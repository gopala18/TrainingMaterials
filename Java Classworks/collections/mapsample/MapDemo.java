package com.csscorp.collections.mapsample;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer,String> employees=new HashMap<>();
		employees.put(100, "Charles");
		employees.put(101, "John");
		employees.put(102, "Darwin");
		
		System.out.println(employees.get(101));
		System.out.println(employees.containsKey(103));
		
		Set<Entry<Integer,String>> mapentries=employees.entrySet();
		System.out.println(mapentries.toString());
		for(Entry<Integer,String> data:mapentries) {
			System.out.println(data.getKey());
			System.out.println(data.getValue());
		}
	}
}
