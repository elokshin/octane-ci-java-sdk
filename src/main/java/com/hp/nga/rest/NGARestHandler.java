package com.hp.nga.rest;

/**
 * Created by gullery on 07/01/2016.
 */

public class NGARestHandler {
	private static final NGARestHandler instance = new NGARestHandler();

	private NGARestHandler() {
	}

	public static NGARestHandler getInstance() {
		return instance;
	}

	public NGAResponse handle(NGARequest request) {
		NGAResponse response = null;
		return response;
	}

	private void doRoute(NGARequest request) {
		String[] pathNodes = request.getUrl().split("/");
	}
}