package com.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessTest {
	
	@Mock
	DataService dataService;
	
	@InjectMocks
	SomeBusinessImpl someBusiness;
	
	@Test
	public void findTheGreatestFromAllData() {
		when(dataService.retrieveAllData()).thenReturn(new int[] {10, 20, 30});
	
		assertEquals(someBusiness.findTheGreatestFromAllData(), 30);
	}
	
	@Test
	public void findTheGreatestFromAllData_MultipleReturns() {
		when(dataService.retrieveAllData())
			.thenReturn(new int[] {10, 20, 30})
			.thenReturn(new int[] {201, 1000, 303})
			.thenReturn(new int[] {22, 1, 500});

	
		assertEquals(someBusiness.findTheGreatestFromAllData(), 30);
		assertEquals(someBusiness.findTheGreatestFromAllData(), 1000);
		assertEquals(someBusiness.findTheGreatestFromAllData(), 500);
	}
	
	@Test
	public void findTheGreatestFromAllDataWithEmptyArray() {
		when(dataService.retrieveAllData()).thenReturn(new int[] {});
	
		assertEquals(someBusiness.findTheGreatestFromAllData(), Integer.MIN_VALUE);
	}

}
