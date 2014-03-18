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
	 * Normalizes the received text, i.e. extracting the accent from accented letters. 
	 * <p>
	 * Example:<br/>
	 * "Descripción corta" -> "Descripcion corta"
	 * 
	 * @param text
	 */
	static String normalize(String text) {
		Normalizer.normalize(text, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
	}
	
	/**
	 * If the text has 2 or more words, it concatenates them, using camel case format and set to lower case the first letter.
	 * <p>
	 * Example:<br/>
	 * "Descripcion corta" -> "descripcionCorta"
	 * 
	 * @param text
	 */
	static String toCamelCase(String text) {
		String newText = text.toLowerCase().split(' ').collect{ it.capitalize() }.join()
		Introspector.decapitalize(newText)
	}
	
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
		toCamelCase(normalize(text))
	}
	

}
