package edu.bpb.oops.pattern.ch4.builder.builder.impl;

import edu.bpb.oops.pattern.ch4.builder.DeploymentAction;
import edu.bpb.oops.pattern.ch4.builder.builder.DeploymentBuilder;

/**
 * An implementation of a Deployment Builder
 * 
 * @author Lalit Mehra
 *
 */
public class BasicDeploymentBuilder implements DeploymentBuilder {

	private DeploymentAction action;

	public BasicDeploymentBuilder() {
		action = new DeploymentAction();
	}

	@Override
	public DeploymentAction build() {
		action.setDescription("Basic Deployment Scheme");
		return action;
	}
}
