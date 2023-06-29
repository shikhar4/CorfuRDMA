package org.corfudb.protocols.rdma;

import com.ibm.darpc.DaRPCProtocol;

public class RdmaRpcProtocol implements DaRPCProtocol<RdmaRpcRequest, RdmaRpcResponse> {
	public static final int FUNCTION_FOO = 1;
	public static final int FUNCTION_BAR = 2;	
	
	@Override
	public RdmaRpcRequest createRequest() {
		return new RdmaRpcRequest();
	}

	@Override
	public RdmaRpcResponse createResponse() {
		return new RdmaRpcResponse();
	}
}
