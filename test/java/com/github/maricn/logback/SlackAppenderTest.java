/*
 * Copyright (c) 2019. Eric Draken - ericdraken.com
 */

package com.github.maricn.logback;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;


class SlackAppenderTest
{
	@Test
	void simulateWebhookTrouble() throws InterruptedException
	{
		final Logger logger = LoggerFactory.getLogger( MethodHandles.lookup().lookupClass() );

		ErrorStatusListener.lastMessage = "";
		logger.info( "This will fail to post to Slack" );
		Thread.sleep( 5000 );

		assertThat( ErrorStatusListener.lastMessage, Matchers.containsString( "Slack POST request failed" ) );
	}
}