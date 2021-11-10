package edu.bpb.oops.pattern.ch4.builder;

/**
 * Processes a deployment based on the deployment action passed
 * 
 * @author Lalit Mehra
 *
 */
public class VMDeployer {
	
	public static void deploy(DeploymentAction action) {
		System.out.println("Initiating deployment for " + action.getDescription());
		System.out.println("Verifying deployment");
		System.out.println(action.getDescription() + " deployed!");
		
		ImmutableDeploymentAction action1 = new ImmutableDeploymentAction.DeploymentBuilder().build();
		System.out.println(action1);
	}

}
