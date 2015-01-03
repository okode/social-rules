/**
 * Copyright 2015 Okode | www.okode.com
 *
 * This file is part of social-rules.
 *
 * social-rules is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 * 
 * social-rules is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with social-rules.
 * If not, see http://www.gnu.org/licenses/.
 */

package com.okode.socialrules.nlp

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

import com.okode.socialrules.SocialListenerAdapter
import com.typesafe.scalalogging.Logger

import twitter4j.Status

@Component
class Analyzer extends SocialListenerAdapter {

  private val logger = Logger(LoggerFactory.getLogger(classOf[Analyzer]))
  
  override def onStatus(status: Status) {
    logger.info(Summarizer(status.getText))
  }
}