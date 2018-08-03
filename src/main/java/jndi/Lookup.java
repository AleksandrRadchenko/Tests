package jndi;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Lookup {
	public static final String name = "test.txt";
	public static void main(String[] args) throws NamingException {
		Hashtable<String, String> env = new Hashtable<>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
		Context ctx = new InitialContext(env);
		Object obj = ctx.lookup(name);
		System.out.println(name + " is boundto: " + obj);
		
	}
}
