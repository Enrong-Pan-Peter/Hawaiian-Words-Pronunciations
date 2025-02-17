package a2;

/**
 * Provides methods for computing the English pronunciation of Hawaiian words.
 */
public class HawaiianWords {
	
	private HawaiianWords() {}

	/**
	 * String containing the vowels of the Hawaiian language.
	 */
	public static final String VOWELS = "AEIOU";

	/**
	 * String containing the consonants of the Hawaiian language.
	 */
	public static final String CONSONANTS = "'HKLMNPW";

	/**
	 * Array mapping consonants to their English-sounding pronunciations. The
	 * consonants are found in the even-numbered indexes. For a consonant located at
	 * index i, its English-sounding pronunciation is found at index i+1.
	 * 
	 * <p>
	 * The consonant {@code W} is special in that its pronunciation changes if it
	 * immediately follows a vowel.
	 */
	public static final String[] CONSONANT_MAPPINGS = {
			"'", "'",
			"H", "H",
			"K", "K", 
			"L", "L", 
			"M", "M", 
			"N", "N",
			"P", "P", 
			"W", "W", 
			"AW", "W",
			"EW", "V", 
			"IW", "V", 
			"OW", "W", 
			"UW", "W", 
	};
	
	/**
	 * Array mapping vowels and vowel-pairs to their English-sounding
	 * pronunciations. The vowel or vowel pair are found in the even-numbered
	 * indexes. For a vowel or vowel pair located at index i, its English-sounding
	 * pronunciation is found at index i+1.
	 */
	public static final String[] VOWEL_MAPPINGS = {
			"A", "AH",
			"E", "EH",
			"I", "EE",
			"O", "OH",
			"U", "OO",
			"AI", "EYE", 
			"AE", "EYE", 
			"AO", "OW", 
			"AU", "OW", 
			"EI", "AY",
			"EU", "EH-OO", 
			"IU", "EW",
			"OE", "OH-WEH",
			"OI", "OY", 
			"OU", "OW", 
			"UI", "OOEY"
	};
	

	/**
	 * Returns {@code true} if and only if {@code c} is a Hawaiian vowel.
	 * 
	 * @param c a character
	 * @return {@code true} if and only if {@code c} is a Hawaiian vowel
	 */
	public static boolean isVowel(char c) {
		
		for (int i = 0; i < VOWELS.length(); i++) {
			
			char ofString = VOWELS.charAt(i);
			
			if (ofString == c) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns {@code true} if and only if {@code c} is a space character.
	 * 
	 * @param c a character
	 * @return {@code true} if and only if {@code c} is a space character
	 */
	public static boolean isSpace(char c) {
		return c == ' ';
	}
	
	/**
	 * Returns {@code true} if and only if {@code c} is a Hawaiian consonant.
	 * 
	 * @param c a character
	 * @return {@code true} if and only if {@code c} is a Hawaiian consonant
	 */
	public static boolean isConsonant(char c) {
		
		for (int i = 0; i < CONSONANTS.length(); i++) {
			
			char ofString = CONSONANTS.charAt(i);
			
			if (ofString == c) {
				return true;
			}
		}
		
		return false;	
	}
	
	/**
	 * Returns {@code true} if and only if {@code c} is the 'okina character.
	 * 
	 * @param c a character
	 * @return {@code true} if and only if {@code c} is the 'okina character
	 */
	public static boolean isOkina(char c) {
		return c == '\'';
	}
	
	/**
	 * Returns {@code true} if and only if the string {@code word} is made up of
	 * only space characters, Hawaiian vowels, and Hawaiian consonants.
	 * 
	 * @param word a string
	 * @return {@code true} if {@code word} might be a valid Hawaiian word,
	 *         {@code false} otherwise
	 */
	public static boolean mightBeValid(String word) {
		
		for (int i = 0; i < word.length(); i++) {
			
			char atIndexI = word.charAt(i);
			
			if (!(isVowel(atIndexI) || isConsonant(atIndexI) || isSpace(atIndexI))) {
				return false;
			}
		}
		
		return true; 
	}	
	
	
	/**
	 * Returns the English-sounding pronunciation of the consonant stored in
	 * {@code s}. The consonant {@code W} is special in that its pronunciation
	 * changes if it immediately follows a vowel.
	 * 
	 * <p>
	 * Returns {@code null} if the pronunciation for {@code s} is not found.
	 * 
	 * @param s a Hawaiian consonant or a Hawaiian vowel followed by {@code W}.
	 * @return the English-sounding pronunciation of the consonant, or {@code null}
	 *         if the pronunciation for {@code s} is not found
	 */
	public static String mapConsonant(String s) {

		for (int i = 0; i < CONSONANT_MAPPINGS.length; i = i + 2) {
			
			if (CONSONANT_MAPPINGS[i].equals(s)) {
				return CONSONANT_MAPPINGS[i + 1];
			}
		}
		
		return null;
	}
	
	/**
	 *
	 * Returns the English-sounding pronunciation of the vowel or vowel pair stored
	 * in {@code s}.
	 * 
	 * <p>
	 * Returns {@code null} if the pronunciation for {@code s} is not found.
	 * 
	 * @param s a Hawaiian vowel or vowel pair
	 * @return the English-sounding pronunciation of the vowel or vowel pair, or
	 *         {@code null} if the pronunciation for {@code s} is not found
	 */
	public static String mapVowel(String s) {
		
		for (int i = 0; i < VOWEL_MAPPINGS.length; i = i + 2) {
			
			if (VOWEL_MAPPINGS[i].equals(s)) {
				return VOWEL_MAPPINGS[i + 1];
			}
		}
		
		return null;
	}
	
	
	/**
	 * Returns the {@code MappingResult} for the space character. The returned
	 * result has a {@code value} equal to {@code " "} and a {@code charsConsumed}
	 * value of {@code 1}.
	 * 
	 * @return the {@code MappingResult} for the space character
	 */
	public static MappingResult handleSpace() {
		MappingResult res = new MappingResult();
		res.value = " ";
		res.charsConsumed = 1;
		return res;
	}
	
	/**
	 * Returns the {@code MappingResult} for the consonant character {@code c} found
	 * in the string {@code word} at location {@code index}. If a mapping exists,
	 * then the returned result has a {@code charsConsumed} value of {@code 1}.
	 * 
	 * <p>
	 * {@code word} and {@code index} are used if {@code c} is equal to {@code 'W'}
	 * because the pronunciation of {@code 'W'} changes if it occurs after a vowel.
	 * 
	 * @param c     a Hawaiian consonant character
	 * @param word  the word containing {@code c}
	 * @param index the index at which {@code c} occurs in {@code word}
	 * @return the {@code MappingResult} for the consonant character {@code c} or
	 *         {@code null} if no such mapping is found
	 */
	public static MappingResult handleConsonant(char c, String word, int index) {

		MappingResult res = new MappingResult();
		
		if (c == 'W' && index != 0) {
			res.value = mapConsonant("" + word.charAt(index - 1) + c);
			res.charsConsumed = 1;
			
			return res;
		}
		
		res.value = mapConsonant("" + c);
		res.charsConsumed = 1;
		
		return res;
	}
	
	/**
	 * Returns the {@code MappingResult} for the vowel character {@code c} found
	 * in the string {@code word} at location {@code index}. If a mapping exists,
	 * then the returned result has a {@code charsConsumed} value of {@code 1}
	 * if {@code c} maps to a single vowel, or {@code 2} if {@code c} and its
	 * following character map to a double vowel.
	 * 
	 * <p>
	 * {@code word} and {@code index} are used if {@code c} is followed by another
	 * vowel to handle the pronunciation of double vowels.
	 * 
	 * @param c     a Hawaiian consonant character
	 * @param word  the word containing {@code c}
	 * @param index the index at which {@code c} occurs in {@code word}
	 * @return the {@code MappingResult} for the vowel character {@code c} or
	 *         {@code null} if no such mapping is found
	 */
	public static MappingResult handleVowel(char c, String word, int index) {

		MappingResult res = new MappingResult();
		
		if (index + 1 < word.length()) {
			String possibleDoubleVowel = "" + c + word.charAt(index + 1);
			String possibleDoubleVowelRes = mapVowel(possibleDoubleVowel);
			
			if (possibleDoubleVowelRes != null) {
				res.value = possibleDoubleVowelRes;
				res.charsConsumed = 2;
				
				return res;
			}
		}
		
		String singleVowelRes = mapVowel("" + c);
		res.value = singleVowelRes;
		res.charsConsumed = 1;
		
		return res;
	}
		
	/**
	 * Computes the pronunciation mapping of the character located at {@code index}
	 * in the string {@code word}.
	 * 
	 * @param word  a word
	 * @param index an index
	 * @return the pronunciation mapping of the character located at {@code index}
	 *         in the string {@code word}, or {@code null} if no such mapping exists
	 * @throws IllegalArgumentException if the index is out of bounds for {@code word}
	 */
	public static MappingResult mapUnconsumed(String word, int index) {
		
		if (index < 0 || index >= word.length()) {
			throw new IllegalArgumentException("index out of bounds: " + index);
		}
		
		char c = word.charAt(index);
		if (isSpace(c)) {
			return HawaiianWords.handleSpace();
		}
		else if (isConsonant(c)) {
			return HawaiianWords.handleConsonant(c, word, index);
		}
		else {
			return HawaiianWords.handleVowel(c, word, index);
		}
	}

	/**
	 * Computes the English pronunciation of a Hawaiian word. Syllables are
	 * separated using a {@code '-'} character.
	 * 
	 * @param word a Hawaiian word
	 * @return the English pronunciation of {@code word}
	 */
	public static String pronounce(String word) {
		
		if (!HawaiianWords.mightBeValid(word)) {
			return "not a Hawaiian word";
		}
		String pro = "";
		
		for (int i = 0; i < word.length(); ) {
			char c = word.charAt(i);
			MappingResult res = HawaiianWords.mapUnconsumed(word, i);
			pro = pro + res.value;
			i = i + res.charsConsumed;
			
			if (HawaiianWords.isVowel(c) && i < word.length() && !HawaiianWords.isSpace(word.charAt(i)) && !HawaiianWords.isOkina(word.charAt(i))) {
				pro = pro + "-";
			}
		}
		
		return pro;
	}

	/**
	 * For testing purposes.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		String[] words = { 
				"'OE",
				"IWA", 
				"KOU",
				"'AWA",
				"KANE",
				"KO'U",
				"ALOHA",
				"HUAAI",
				"MAKUA",
				"BONJOUR",
				"HOALOHA",
				"KAIAPUNI",
				"KAKAHIAKA",
				"KEIKIKANE",
				"E KOMO MAI", 
				"KAMEHAMEHA",
				"HUMUHUMUNUKUNUKUAPUA'A",
		};
		
		for (String s : words) {
			System.out.println(s + " => " + pronounce(s));
		}

	}

}
