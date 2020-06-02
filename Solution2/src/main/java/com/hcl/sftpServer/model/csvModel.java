package com.hcl.sftpServer.model;

public class csvModel {
	private String RESULT_TIME;
	private int GRANUALIRITY_PERIOD;
	private String OBJECT_NAME;
	private int CELL_ID;
	private int CALL_ATTEMPT;

	public csvModel(String RESULT_TIME, int GRANUALIRITY_PERIOD, String OBJECT_NAME, int CELL_ID, int CALL_ATTEMPT) {
		this.RESULT_TIME = RESULT_TIME;
		this.GRANUALIRITY_PERIOD = GRANUALIRITY_PERIOD;
		this.OBJECT_NAME = OBJECT_NAME;
		this.CELL_ID = CELL_ID;
		this.CALL_ATTEMPT = CALL_ATTEMPT;
	}

	public csvModel() {
		super();
	}

	public String getRESULT_TIME() {
		return RESULT_TIME;
	}

	public void setRESULT_TIME(String RESULT_TIME) {
		this.RESULT_TIME = RESULT_TIME;
	}

	public int getGRANUALIRITY_PERIOD() {
		return GRANUALIRITY_PERIOD;
	}

	public void setGRANUALIRITY_PERIOD(int GRANUALIRITY_PERIOD) {
		this.GRANUALIRITY_PERIOD = GRANUALIRITY_PERIOD;
	}

	public String getOBJECT_NAME() {
		return OBJECT_NAME;
	}

	public void setOBJECT_NAME(String OBJECT_NAME) {
		this.OBJECT_NAME = OBJECT_NAME;
	}

	public int getCELL_ID() {
		return CELL_ID;
	}

	public void setCELL_ID(int CELL_ID) {
		this.CELL_ID = CELL_ID;
	}

	public int getCALL_ATTEMPT() {
		return CALL_ATTEMPT;
	}

	public void setCALL_ATTEMPT(int CALL_ATTEMPT) {
		this.CALL_ATTEMPT = CALL_ATTEMPT;
	}

	
}
