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

import java.util.Properties

import scala.collection.JavaConversions.asScalaBuffer

import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation
import edu.stanford.nlp.pipeline.Annotation
import edu.stanford.nlp.pipeline.StanfordCoreNLP

object Summarizer {
  
  val props = new Properties
  
  // Possible entities: tokenize, ssplit, parse, pos, lemma, ner, sentiment
  props.put("annotators", "tokenize,ssplit,pos")
  
  // Tokenize using Spanish settings
  props.put("tokenize.language", "es")
  
  // Load the Spanish POS tagger model (rather than the default English model)
  props.put("pos.model", "edu/stanford/nlp/models/pos-tagger/spanish/spanish-distsim.tagger")
  
  val pipeline = new StanfordCoreNLP(props)
  
  def apply(text: String) = {
    val annotation = new Annotation(text)
    pipeline.annotate(annotation)
    val sentences = annotation.get(classOf[TokensAnnotation])
    val summary = new StringBuilder('[')
    for (sentence <- sentences.toList) summary ++= sentence + ", "
    (summary + ']').toString
  }
}