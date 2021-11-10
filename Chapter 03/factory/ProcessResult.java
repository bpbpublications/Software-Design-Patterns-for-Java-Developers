package edu.bpb.oops.pattern.ch3.factory;

/**
 * @author Lalit Mehra
 *
 */
public class ProcessResult {

	private String processId;
	private String reportId;
	private Order order;

	private String resultCode;
	private String resultMessage;
	
	public ProcessResult(String processId, Order order, String resultCode) {
		this.processId = processId;
		this.order = order;
		this.resultCode = resultCode;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

}