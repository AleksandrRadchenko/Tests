package p180921_jmx_test;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * Implemented this not best tutorial: {@link https://www.baeldung.com/java-management-extensions}
 * MBeans are used to interact with application remotely.
 */
public class Game implements GameMBean
{
	private String playerName;

	@Override
	public void playFootball(String clubName)
	{
		System.out.println(this.playerName + " playing football for " + clubName);
	}

	@Override
	public String getPlayerName()
	{
		System.out.println("Return playerName " + playerName);
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName)
	{
		System.out.println("Set playerName to " + playerName);
		this.playerName = playerName;
	}
	
	public static void main(String[] args)
	{
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		ObjectName objectName = null;
		try {
			objectName = new ObjectName("p180921_jmx_test:type=Football,name=FClub");
			server.registerMBean(new Game(), objectName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while (true)
		{
		}
	}
}
