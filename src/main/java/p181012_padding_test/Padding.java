package p181012_padding_test;

import org.apache.commons.lang3.StringUtils;

public class Padding
{
	private static String recordLength = "6";
	
	public static void main(String[] args)
	{
		System.out.println(setRecord("AB") + "|");
	}
	
	private static String setRecord(final String logRecord)
	{
		final int recordLengthIntValue = Integer.parseInt(recordLength);

		if (logRecord.length() > recordLengthIntValue)
		{
			return logRecord.substring(0, recordLengthIntValue);
		}
		return StringUtils.rightPad(logRecord, recordLengthIntValue);
	}
}
