package edu.bpb.oops.pattern.ch4.builder.builder.impl;

import edu.bpb.oops.pattern.ch4.builder.DeploymentAction;
import edu.bpb.oops.pattern.ch4.builder.DeploymentStrategy;
import edu.bpb.oops.pattern.ch4.builder.builder.DeploymentBuilder;
import edu.bpb.oops.pattern.ch4.builder.resource.Database;
import edu.bpb.oops.pattern.ch4.builder.resource.ProjectManager;
import edu.bpb.oops.pattern.ch4.builder.resource.impl.Gradle;
import edu.bpb.oops.pattern.ch4.builder.resource.impl.MySqlDatabase;

/**
 * An implementation of a Deployment Builder
 * 
 * @author Lalit Mehra
 *
 */
public class ConsoleDeploymentBuilder implements DeploymentBuilder {

	private DeploymentAction action;
	private ProjectManager projectManager;
	private Database database;
	
	@Override
	public DeploymentBuilder installProjectManager() {
		System.out.println("Configuring Gradle");
		projectManager = new Gradle();
		return this;
	}
	
	@Override
	public DeploymentBuilder installDatabase() {
		System.out.println("Configuring MySQL Database");
		database = new MySqlDatabase();
		return this;
	}
	
	@Override
	public DeploymentAction build() {
		if(null == database || null == projectManager) 
			throw new IllegalStateException();
		
		action = new DeploymentAction();
		action.setDatabase(database);
		action.setProManager(projectManager);
		action.setDescription(DeploymentStrategy.CONSOLE.strategy());
		return action;
	}
}
