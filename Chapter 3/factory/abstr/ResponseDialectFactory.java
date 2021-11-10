package edu.bpb.oops.pattern.ch3.factory.abstr;

/**
 * @author Lalit Mehra
 *
 */
public interface ResponseDialectFactory {
	
	public Formatter getFormatter();
	
	public Converter getConverter();
	
	public Reader getReader();

}
