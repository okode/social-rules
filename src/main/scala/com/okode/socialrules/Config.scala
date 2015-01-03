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

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class Config {

  @Value("${twitter.consumer.key}")
  val consumerKey: String = null
  
  @Value("${twitter.consumer.secret}")
  val consumerSecret: String = null

  @Value("${twitter.accesstoken}")
  val accessToken: String = null

  @Value("${twitter.accesstoken.secret}")
  val accessTokenSecret: String = null

  @Value("${track.keywords}")
  val trackKeywords: Array[String] = null
  
  @Value("${track.languages}")
  val trackLanguages: Array[String] = null
  
}