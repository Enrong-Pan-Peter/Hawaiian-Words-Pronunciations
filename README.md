# Hawaiian Word Pronunciations

## Overview
This project is inspired by the author's interest in the Hawaiian language. This program computes the English pronunciation of Hawaiian words. The program maps Hawaiian consonants, vowels, and diphthongs to their respective English pronunciations, handling special pronunciation rules such as the `ʻokina` and changes in the pronunciation of `W`.

## Files

### `HawaiianWords.java`
This class provides the core functionality for generating English-based pronunciations of Hawaiian words. It:
- Defines the valid Hawaiian consonants and vowels.
- Maps consonants and vowels to their English equivalents.
- Implements methods to check whether characters belong to specific Hawaiian phonetic categories.
- Handles pronunciation changes based on vowel placement.
- Constructs the English pronunciation of words, inserting hyphens between syllables.

### `MappingResult.java`
This class stores the result of character mappings from Hawaiian words to their English pronunciation. It:
- Stores the mapped pronunciation value.
- Tracks the number of characters consumed during mapping.
- Helps structure the pronunciation logic in `HawaiianWords.java`.

## How It Works

### Pronunciation Rules
The program follows the phonetic rules of Hawaiian pronunciation:
- Hawaiian words only contain vowels (A, E, I, O, U) and specific consonants (`ʻ`, H, K, L, M, N, P, W).
- The pronunciation of `W` varies based on the preceding vowel.
- Vowel pairs (diphthongs) have unique sounds (e.g., `AU` is pronounced "OW").
- Words are broken into syllables with a hyphen between them.

### Processing a Word
1. The program reads a Hawaiian word.
2. It iterates through the word, identifying consonants, vowels, and diphthongs.
3. It maps each element to its English pronunciation.
4. It inserts hyphens between syllables.
5. The final pronunciation is printed.

### Example Output
The program produces output like:
```
'OE => OH-WEH
IWA => EE-VAH
ALOHA => A-LO-HA
KAMEHAMEHA => KA-MEH-HA-MEH-HA
HUMUHUMUNUKUNUKUAPUA'A => HUMU-HUMU-NUKU-NUKU-A-PU-A'AH
```

## Usage

### Compilation
To compile the project, run:
```sh
javac HawaiianWords.java MappingResult.java
```

### Execution
To generate English pronunciations, run:
```sh
java HawaiianWords
```

### Expected Output
The program will print the English pronunciation of a set of predefined Hawaiian words.

## Future Improvements
- Extend support for more phonetic rules.
- Implement a user interface for entering words dynamically.
- Add audio output for pronunciation assistance.

## License
This project is licensed under the MIT License.

## Author
Pan, Enrong