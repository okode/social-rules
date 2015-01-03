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

import org.apache.commons.lang3.StringUtils

object ProductBuilder {

  def apply(text: String) = {
    var product = Product.None
    if (StringUtils.containsIgnoreCase(text, "wxw") && StringUtils.containsIgnoreCase(text, "horror")) {
      if (StringUtils.containsIgnoreCase(text, "coche")) product = Product.Car
      if (StringUtils.containsIgnoreCase(text, "vehiculo")) product = Product.Car
      if (StringUtils.containsIgnoreCase(text, "vehículo")) product = Product.Car
      if (StringUtils.containsIgnoreCase(text, "casa")) product = Product.Home
      if (StringUtils.containsIgnoreCase(text, "hogar")) product = Product.Home
      if (StringUtils.containsIgnoreCase(text, "vida")) product = Product.Life
      if (StringUtils.containsIgnoreCase(text, "muerte")) product = Product.Life
      if (StringUtils.containsIgnoreCase(text, "morir")) product = Product.Life
      if (StringUtils.containsIgnoreCase(text, "muerto")) product = Product.Life
      if (StringUtils.containsIgnoreCase(text, "familia")) product = Product.Life
      if (StringUtils.containsIgnoreCase(text, "enfermedad")) product = Product.Health
      if (StringUtils.containsIgnoreCase(text, "dentista")) product = Product.Health
      if (StringUtils.containsIgnoreCase(text, "hospital")) product = Product.Health
    }
    product
  }
  
}