package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Display extends RPCStub {

	private byte RPCID = 1;

	public void write(String message) {
		
		byte[] req = RPCUtils.marshallString(RPCID, message);
		byte[] resp = rpcclient.call(req);
		
		RPCUtils.unmarshallVoid(resp);
				
		// TODO
		// implement marshalling, call and unmarshalling for write RPC method
	}
}
