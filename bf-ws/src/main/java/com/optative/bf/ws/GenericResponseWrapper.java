package com.optative.bf.ws;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GenericResponseWrapper extends HttpServletResponseWrapper {

	private ByteArrayOutputStream output;
	private FilterServletOutputStream filterStream;
	private PrintWriter printWriter;
	private int contentLength;
	private String contentType;

	public GenericResponseWrapper(HttpServletResponse response) {
		super(response);

		output = new ByteArrayOutputStream();
		filterStream = new FilterServletOutputStream(output);
		printWriter = new PrintWriter(output, true);
	}

	public byte[] getData() {
		return output.toByteArray();
	}

	public ServletOutputStream getOutputStream() {
		return filterStream;
	}

	public PrintWriter getWriter() {
		return printWriter;
	}

	public void setContentLength(int length) {
		this.contentLength = length;
		super.setContentLength(length);
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentType(String type) {
		this.contentType = type;
		super.setContentType(type);
	}

	public String getContentType() {
		return contentType;
	}
}
