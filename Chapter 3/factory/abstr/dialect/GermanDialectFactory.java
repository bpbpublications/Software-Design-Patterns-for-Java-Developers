package edu.bpb.oops.pattern.ch3.factory.abstr.dialect;

import edu.bpb.oops.pattern.ch3.factory.abstr.Converter;
import edu.bpb.oops.pattern.ch3.factory.abstr.Formatter;
import edu.bpb.oops.pattern.ch3.factory.abstr.Reader;
import edu.bpb.oops.pattern.ch3.factory.abstr.ResponseDialectFactory;
import edu.bpb.oops.pattern.ch3.factory.abstr.impl.DefaultReader;
import edu.bpb.oops.pattern.ch3.factory.abstr.impl.GermanDialectConverter;
import edu.bpb.oops.pattern.ch3.factory.abstr.impl.JsonFormatter;

/**
 * @author Lalit Mehra
 *
 */
public class GermanDialectFactory implements ResponseDialectFactory {

	@Override
	public Formatter getFormatter() {
		return new JsonFormatter();
	}

	@Override
	public Converter getConverter() {
		return new GermanDialectConverter();
	}

	@Override
	public Reader getReader() {
		return new DefaultReader();
	}

}
