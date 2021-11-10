package edu.bpb.oops.pattern.ch6.adapter.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Dummy implementation of a connecter implementation that allows to connect to elastic data source
 * 
 * @author Lalit Mehra
 *
 */
public class ElasticConnector {

	public List<String> fetch(Set<String> searchKeys) {
		return Collections.emptyList();
	}

}
