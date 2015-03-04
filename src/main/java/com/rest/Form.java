<<<<<<< HEAD
package com.rest;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class Form {

	public Form() {
	}

	private byte[] data;

	public byte[] getData() {
		return data;
	}

	@FormParam("file")
	@PartType("application/octet-stream")
	public void setData(byte[] data) {
		this.data = data;
	}

}
=======
package com.rest;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class Form {

	public Form() {
	}

	private byte[] data;

	public byte[] getData() {
		return data;
	}

	@FormParam("file")
	@PartType("application/octet-stream")
	public void setData(byte[] data) {
		this.data = data;
	}

}
>>>>>>> 0ddfb1a8027a6a4e45bf83d6e2aa9b14d5628b18
