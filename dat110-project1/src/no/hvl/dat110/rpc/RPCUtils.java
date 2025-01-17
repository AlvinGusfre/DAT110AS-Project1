package no.hvl.dat110.rpc;

import java.math.BigInteger;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;
		byte[] stringBytes = str.getBytes();
		
		encoded = new byte[str.getBytes().length + 1];
		encoded[0] = rpcid;
		
		for (int i = 0; i < stringBytes.length; i++)
		{
			encoded[i+1] = stringBytes[i];
		}
		
		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static String unmarshallString(byte[] data) 
	{

		String decoded = new String(Arrays.copyOfRange(data, 1, data.length));

		// TODO: unmarshall String contained in data into decoded

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) 
	{

		byte[] encoded = new byte[1];
		
		encoded[0] = rpcid;
		
		return encoded;

	}

	public static void unmarshallVoid(byte[] data) 
	{

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) 
	{

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) 
	{

		return (data[1] > 0);

	}
	
	public static byte[] marshallInteger(byte rpcid, int x) 
	{

		byte[] encoded;
		byte[] num = BigInteger.valueOf(x).toByteArray();
		encoded = new byte[num.length + 1];
		// TODO: marshall RPC identifier and string into byte array

		encoded[0] = rpcid;
		for(int i = 0; i < num.length; i++) 
		{
			encoded[i+1] = num[i];
		}
		// TODO: marshall RPC identifier and string into byte array

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) 
	{

		int decoded;
		byte[] dat = new byte[data.length - 1];
		for(int i = 0; i < dat.length; i++) 
		{
			dat[i] = data[i+1];
		}
		decoded = new BigInteger(dat).intValue();

		return decoded;
		
	}
}
