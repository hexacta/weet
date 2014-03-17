package com.hexacta.weet.utils

import java.beans.Introspector
import java.text.Normalizer

/**
 * Provides string utility methods.
 * 
 * @author gmassenzano
 */
class StringUtils {
	
	/**
	 * It first normalized the received text, i.e. extracting the accent from accented letters. Then, it if the text has 2 or more words,
	 * it concatenates them, using camel case format. Last step is set to lower case the first letter. It returns the transformed string.
	 * <p>
	 * Example:<br/>
	 * "Descripción corta" -> "descripcionCorta"
	 * 
	 * @param text
	 */
	static String toNormalizedCamelCase(String text) {
		def newText = Normalizer.normalize(text, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
		newText = newText.toLowerCase().split(' ').collect{ it.capitalize() }.join()
		Introspector.decapitalize(newText)
	}
	

}
