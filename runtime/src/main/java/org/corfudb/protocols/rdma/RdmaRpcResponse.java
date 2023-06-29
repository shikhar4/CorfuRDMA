package org.corfudb.protocols.rdma;

import java.nio.ByteBuffer;

import com.ibm.darpc.DaRPCMessage;

public class RdmaRpcResponse implements DaRPCMessage {
	public static int SERIALIZED_SIZE = 24;
	
	private int error;
	private int requestID;
	private long time;
	private int type;
	
	public RdmaRpcResponse(){
	}
	
	public int size() {
		return SERIALIZED_SIZE;
	}

	@Override
	public void update(ByteBuffer buffer) {
		error = buffer.getInt();
		requestID = buffer.getInt();
		time = buffer.getLong();
		type = buffer.getInt();
	}

	@Override
	public int write(ByteBuffer buffer) {
		buffer.putInt(error);
		buffer.putInt(requestID);
		buffer.putLong(time);
		buffer.putInt(type);
		
		return SERIALIZED_SIZE;
	}

	public int getError() {
		return error;
	}

	public int getRequestID() {
		return requestID;
	}

	public long getTime() {
		return time;
	}

	public int getType() {
		return type;
	}

	public void setError(int error) {
		this.error = error;
	}

	public void setRequestId(int id) {
		this.requestID = id;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "" + requestID;
	}
}