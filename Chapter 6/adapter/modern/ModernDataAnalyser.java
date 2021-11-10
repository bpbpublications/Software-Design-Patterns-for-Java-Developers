package edu.bpb.oops.pattern.ch6.adapter.modern;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.bpb.oops.pattern.ch6.adapter.exception.DataStorageException;
import edu.bpb.oops.pattern.ch6.adapter.util.StorageType;

/**
 * Describes the functionalities provided by a modern data analyser 
 * 
 * @author Lalit Mehra
 *
 */
public interface ModernDataAnalyser {

	public void store(StorageType storage, Map<String, String> data) throws IllegalArgumentException, DataStorageException;
	
	public List<String> fetch(StorageType storage, Set<String> searchKeys) throws IllegalArgumentException, DataStorageException;
	
}
