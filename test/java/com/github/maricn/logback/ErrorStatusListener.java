/*
 * Copyright (c) 2019. Eric Draken - ericdraken.com
 */

package com.github.maricn.logback;

import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusListener;

/**
 * Quick Logback status listener for basic testing
 */
public class ErrorStatusListener implements StatusListener
{
	static String lastMessage = "";

	@Override
	public void addStatusEvent( Status status )
	{
		if ( status.getLevel() >= Status.WARN )
		{
			System.out.println( status.getMessage() );
			lastMessage = status.getMessage();
		}
	}
}
