package net.tutorial;

import org.apache.log4j.Logger;

public class Calculator{
	
  private static final Logger LOGGER = Logger.getLogger(Calculator.class);

  public static void main (String args[]){
    Math m = new Math();
	
	System.out.println("5 + 9 = " + m.add(5, 9));
	
	System.out.println("8 - 2 = " + m.sub(8, 2));	
	
	System.out.println("4 x 7 = " + m.multiply(4, 7));
	
	LOGGER.info("Calculation completed.");
  }
}