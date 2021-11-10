package edu.bpb.oops.pattern.ch4.builder.builder;

import edu.bpb.oops.pattern.ch4.builder.DeploymentAction;

/**
 * Builder interface that provides methods to build a deployment object 
 * 
 * @author Lalit Mehra
 *
 */
public interface DeploymentBuilder {
	
	public DeploymentAction build();
	
	public default DeploymentBuilder installServer() {
		return this;
	}

	public default DeploymentBuilder installProjectManager() {
		return this;
	}
	
	public default DeploymentBuilder installDatabase() {
		return this;
	}
	
	public default DeploymentBuilder installMQ() {
		return this;
	}

}
