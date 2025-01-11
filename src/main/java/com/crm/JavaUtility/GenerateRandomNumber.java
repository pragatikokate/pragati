package com.crm.JavaUtility;

import java.util.Random;

public class GenerateRandomNumber {
public static int random() {
	Random r = new Random();
	int value = r.nextInt(1000);
	return value;
	
	
}
}
