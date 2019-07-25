package com.mockito.mockitodemo;

public class SomeBusinessImpl {
	private DataService dataService;
	
	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatest = Integer.MIN_VALUE;
		
		for (int value : data) {
			if (value > greatest) {
				greatest = value;
			}
		}
		
		return greatest;
	}
}

