/**
 * 
 */
package p180812_test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aleksandr_Radchenko
 * @since 2018-11-30
 *
 */
public class MethodReference
{
	public static void main(String[] args)
	{
//		printDiffs(fos, diffTranUsage.stream().map(tranUsage -> tranUsage.getGuid()).collect(Collectors.toList()),
		MethodReference mr = new MethodReference();
		List<BillableTransaction> transactions = Arrays.asList(mr.new BillableTransaction("a"), mr.new BillableTransaction("b"));
		
		List<String> guids = transactions.stream().map(BillableTransaction::getGuid).collect(Collectors.toList());
		
		System.out.println("giuds = " + guids);
	}
	
	class BillableTransaction 
	{
		private String guid;

		public BillableTransaction(String guid)
		{
			this.guid = guid;
		}

		public String getGuid()
		{
			return guid;
		}

		public void setGuid(String guid)
		{
			this.guid = guid;
		}
	}
}
