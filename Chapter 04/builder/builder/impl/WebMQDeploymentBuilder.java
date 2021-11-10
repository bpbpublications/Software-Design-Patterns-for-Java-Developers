package edu.bpb.oops.pattern.ch4.builder.builder.impl;

import edu.bpb.oops.pattern.ch4.builder.DeploymentAction;
import edu.bpb.oops.pattern.ch4.builder.DeploymentStrategy;
import edu.bpb.oops.pattern.ch4.builder.builder.DeploymentBuilder;
import edu.bpb.oops.pattern.ch4.builder.resource.MessagingQueue;
import edu.bpb.oops.pattern.ch4.builder.resource.impl.RabbitMQ;

/**
 * An implementation of a Deployment Builder
 * 
 * @author Lalit Mehra
 *
 */
public class WebMQDeploymentBuilder extends WebDeploymentBuilder {

	private MessagingQueue queue;
	
	@Override
	public DeploymentBuilder installMQ() {
		System.out.println("Configuring RabbitMQ");
		queue = new RabbitMQ();
		return this;
	}	
	
	@Override
	public DeploymentAction build() {
		if (null == database || null == projectManager || null == server || null == queue)  
			throw new IllegalStateException();
		
		action = new DeploymentAction();
		action.setDatabase(database);
		action.setProManager(projectManager);
		action.setServer(server);
		action.setQueue(queue);
		action.setDescription(DeploymentStrategy.WEBMQ.strategy());
		return action;
	}

}
