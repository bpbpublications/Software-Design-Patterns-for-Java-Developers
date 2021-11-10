package edu.bpb.oops.pattern.ch4.builder.builder.impl;

import edu.bpb.oops.pattern.ch4.builder.DeploymentAction;
import edu.bpb.oops.pattern.ch4.builder.DeploymentStrategy;
import edu.bpb.oops.pattern.ch4.builder.builder.DeploymentBuilder;
import edu.bpb.oops.pattern.ch4.builder.resource.Database;
import edu.bpb.oops.pattern.ch4.builder.resource.ProjectManager;
import edu.bpb.oops.pattern.ch4.builder.resource.WebServer;
import edu.bpb.oops.pattern.ch4.builder.resource.impl.ApacheTomcat;
import edu.bpb.oops.pattern.ch4.builder.resource.impl.Maven;
import edu.bpb.oops.pattern.ch4.builder.resource.impl.Oracle;

/**
 * An implementation of a Deployment Builder
 * 
 * @author Lalit Mehra
 *
 */
public class WebDeploymentBuilder implements DeploymentBuilder {

	protected DeploymentAction action;
	protected ProjectManager projectManager;
	protected Database database;
	protected WebServer server;
	
	@Override
	public DeploymentBuilder installServer() {
		System.out.println("Configuring Apache Tomcat");
		server = new ApacheTomcat();
		return this;
	}
	
	@Override
	public DeploymentBuilder installProjectManager() {
		System.out.println("Configuring Maven");
		projectManager = new Maven();
		return this;
	}
	
	@Override
	public DeploymentBuilder installDatabase() {
		System.out.println("Configuring Oracle Database");
		database = new Oracle();
		return this;
	}
	
	@Override
	public DeploymentAction build() {
		if (null == database || null == projectManager || null == server) 
			throw new IllegalStateException();
		
		action = new DeploymentAction();
		action.setDatabase(database);
		action.setProManager(projectManager);
		action.setServer(server);
		action.setDescription(DeploymentStrategy.WEB.strategy());
		return action;
	}

}
