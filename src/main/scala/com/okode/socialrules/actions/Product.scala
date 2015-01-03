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

object Product extends Enumeration {

    val None   = Value("", "")
    val Car    = Value("coche", "http://ow.ly/B82fp")
    val Health = Value("salud", "http://ow.ly/B82fp")
    val Life   = Value("vida", "http://ow.ly/B82fp")
    val Home   = Value("hogar", "http://ow.ly/B82fp")
    
    class ProductValue(name: String, val url: String) extends Val(nextId, name)
    protected final def Value(name: String, url: String): ProductValue = new ProductValue(name, url)

}