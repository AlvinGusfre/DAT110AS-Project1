package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length <= 127) {
			this.payload = payload; // TODO: check for length within boundary
		} else {
			return;
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = new byte[128];

		encoded[0] = (byte) payload.length;

		for (int i = 1; i < payload.length - 1; i++) 
		{
			encoded[i] = payload[i - 1];
		}

		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format

		return encoded;

	}

	public void decapsulate(byte[] received) {
		
		for (int i = 1; i < (int)received[0]; i++)
		{
			payload[i-1] = received[i];
		}
		
		
		// TODO
		// decapsulate the data contained in the received byte array and store it
		// in the payload of this message


	}
}
