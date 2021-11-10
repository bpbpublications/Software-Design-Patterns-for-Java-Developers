package edu.bpb.oops.pattern.ch4.builder.test;

import edu.bpb.oops.pattern.ch4.builder.DeploymentManager;
import edu.bpb.oops.pattern.ch4.builder.DeploymentStrategy;

/**
 * Initiates a deployemnt
 * 
 * @author Lalit Mehra
 *
 */
public class DeploymentInitiator {
	
	public static void initiate() {
		DeploymentManager.deploy(DeploymentStrategy.WEB);
		System.out.println();
		DeploymentManager.deploy(DeploymentStrategy.CONSOLE);
		System.out.println();
		DeploymentManager.deploy(DeploymentStrategy.WEBMQ);
		System.out.println();
		DeploymentManager.deploy(DeploymentStrategy.VANILLA);
	}
	
	public static void main(String[] args) {
		initiate();
	}

}