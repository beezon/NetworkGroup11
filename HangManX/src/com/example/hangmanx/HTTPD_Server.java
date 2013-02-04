package com.example.hangmanx;

import java.io.*;
import java.util.*;

//=====================ไปดึง Libary จาก NanoHTTPD มาใช้===================//

/**
 * An example of subclassing NanoHTTPD to make a custom HTTP server.
 */
public class HTTPD_Server extends NanoHTTPD {
	public HTTPD_Server() throws IOException {
		super(8080, new File("."));
	}

	public Response serve(String uri, String method, Properties header,
			Properties parms, Properties files) {
		if (parms.getProperty("cmd").equals("Playstatus")) {
			return new NanoHTTPD.Response(HTTP_OK, MIME_HTML,
					HelloServer.Playstatus);
		}
		if (parms.getProperty("cmd").equals("scollFinal")) {
			return new NanoHTTPD.Response(HTTP_OK, MIME_HTML,
					String.valueOf(multix.scollFinal));
		}

		return new NanoHTTPD.Response(HTTP_OK, MIME_HTML, "A");
	}

	public static void main(String[] args) {
		try {
			new HTTPD_Server();
		} catch (IOException ioe) {
			System.err.println("Couldn't start server:\n" + ioe);
			System.exit(-1);
		}
		System.out.println("Listening on port 8080. Hit Enter to stop.\n");
		try {
			System.in.read();
		} catch (Throwable t) {
		}
		;
	}
}
