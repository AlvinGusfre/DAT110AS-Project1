package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		int temp;
		
		byte[] req = RPCUtils.marshallVoid(RPCID);
		byte[] resp = rpcclient.call(req);
		
		temp = RPCUtils.unmarshallInteger(resp);
		
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}
		
		return temp;
	}
}
