/**
 * Utilitaire de transformation de chaine de caractères
 * 
 * Fait par GregDev le 25/10/2121
 */

package fr.gregdev.capitalesgame.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class SpecialFormat {

    public static String withoutAccent(String s) {
	String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
	Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	return pattern.matcher(strTemp).replaceAll("");
    }

}
