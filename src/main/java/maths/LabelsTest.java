package maths;

import org.apache.log4j.*;

public class LabelsTest
{
	public static void main(String[] args)
	{
		final Logger logger = Logger.getLogger(LabelsTest.class);
		logger.log(Level.DEBUG, LabelsTest.class);
		int i = 2;
	    FILTER_LOOP:
	        while(i != 0) {
	          switch(i) {
	          case 1: return;
	          case 2: break FILTER_LOOP;
	          case 3: i = 1;
	          }
	        }
	}
}
