package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;
import no.hvl.dat110.system.controller.Sensor;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] request) {
		
		byte[] reply;
		byte rpcid;
		
		rpcid = request[0];
		String message = RPCUtils.unmarshallString(request);
		write(message);
		
		reply = RPCUtils.marshallVoid(rpcid);
		 
		// TODO: 
		// implement unmarshalling, call, and marshall for write RPC method
		// look at how this is done int he SensorImpl for the read method
		
//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}
		
		return reply;
	}
}
