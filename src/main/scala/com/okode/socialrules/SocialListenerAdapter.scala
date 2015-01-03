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

package com.okode.socialrules

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import twitter4j.FilterQuery
import twitter4j.StatusListener
import twitter4j.TwitterFactory
import twitter4j.TwitterStreamFactory
import twitter4j.auth.AccessToken
import twitter4j.Status
import twitter4j.StatusDeletionNotice
import twitter4j.StallWarning

abstract class SocialListenerAdapter extends StatusListener {

  @Autowired
  private val config: Config = null

  protected var twitter = TwitterFactory.getSingleton
  private val twitterStream = TwitterStreamFactory.getSingleton

  @PostConstruct
  def init() {
    val accessToken = new AccessToken(config.accessToken, config.accessTokenSecret)
    twitter.setOAuthConsumer(config.consumerKey, config.consumerSecret)
    twitter.setOAuthAccessToken(accessToken)
    twitterStream.setOAuthConsumer(config.consumerKey, config.consumerSecret)
    twitterStream.setOAuthAccessToken(accessToken)
    twitterStream.addListener(this)
    twitterStream.filter(new FilterQuery().track(config.trackKeywords).language(config.trackLanguages))
  }
  
  override def onException(ex: Exception) {}
  override def onStatus(status: Status) {}
  override def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}
  override def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}
  override def onScrubGeo(useId: Long, upToStatusId: Long) {}
  override def onStallWarning(warning: StallWarning) {}
  
}