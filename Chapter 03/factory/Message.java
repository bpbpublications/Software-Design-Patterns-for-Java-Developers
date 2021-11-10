package edu.bpb.oops.pattern.ch3.factory;

/**
 * 
 * @author Lalit Mehra
 *
 */
public class Message {

	private String processId;
	private String reportId;
	private String orderId;
	private String body;

	private String code;
	private String message;

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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void extract(ProcessResult result) {
		// TODO Process Result
		System.out.println("extract and store data from process result");
	}

}
