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

package com.okode.socialrules.actions

import org.slf4j.LoggerFactory

import com.okode.socialrules.SocialListenerAdapter
import com.typesafe.scalalogging.Logger

import twitter4j.Status
import twitter4j.StatusUpdate

// @Component
class LeadDetector extends SocialListenerAdapter {

  private val logger = Logger(LoggerFactory.getLogger(classOf[LeadDetector]))
  private var coupon = 0
  
  override def onStatus(status: Status) {
    val product = ProductBuilder(status.getText)
    logger.info(s"[$product]: ${status.getText}")
    
    if (product != Product.None) {
      val message = s"@${status.getUser.getScreenName} Use the code [${coupon += 1}] for $product in ${product.url}"
      twitter.updateStatus(new StatusUpdate(message).inReplyToStatusId(status.getId))
    }
  }
  
}
