package org.corfudb.protocols.rdma;

import java.nio.ByteBuffer;

import com.ibm.darpc.DaRPCMessage;

public class RdmaRpcRequest implements DaRPCMessage {
	public static int BASE_SIZE = 12;
	public static int BUFFER_SIZE = 4096;
	public static int SERIALIZED_SIZE = BASE_SIZE + BUFFER_SIZE; // We limit logData size to 1KB
	
	private int cmd;
	private int requestID;
	private int logDataBufferSize;
	private ByteBuffer logDataBuffer;
	
	public RdmaRpcRequest(){
	}

	public int size() {
		return SERIALIZED_SIZE;
	}

	@Override
	public void update(ByteBuffer buffer) {
		cmd = buffer.getInt();
		requestID = buffer.getInt();
		logDataBufferSize = buffer.getInt();

		int offset = buffer.position();
		logDataBuffer = buffer.duplicate();
		logDataBuffer.position(offset);
		logDataBuffer.limit(offset + logDataBufferSize);
	}

	@Override
	public int write(ByteBuffer buffer) {
		buffer.putInt(cmd);
		buffer.putInt(requestID);
		buffer.putInt(logDataBuffer.limit());
		if(logDataBuffer.limit() > BUFFER_SIZE) {
			System.out.printf("[ERROR] log size of %d exceeds RDMA buffer size of %d, please adjust it accordingly\n", logDataBuffer.limit(), BUFFER_SIZE);
		}
		buffer.put(logDataBuffer);
		// We may change this to the actual put size
		return SERIALIZED_SIZE;
	}

	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int id) {
		this.requestID = id;
	}

	public ByteBuffer getLogDataBuffer() {
		return logDataBuffer;
	}

	public void setLogDataBuffer(ByteBuffer buffer) {
		this.logDataBuffer = buffer;
	}
}