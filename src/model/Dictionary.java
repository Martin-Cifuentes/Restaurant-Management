package model;

import java.util.ArrayList;

public class Dictionary {
	public static Language actualLanguage;
	public static ArrayList<Word> words;
	public Dictionary(Language al) {
		actualLanguage = al;
	}
	
	public String getValueOf(String code) {
		int pos = findWord(code);
		if(pos >= 0) {
			return words.get(pos).getValue();
		}
		if(actualLanguage == Language.SPANISH) {
			return "No encontrado";
		}else {
			return "Not found";
		}
	}
	
	public int findWord(String code) {
		int x = -1;
		for (int i = 0; i < words.size(); i++) {
			if(words.get(i).getCode().equalsIgnoreCase(code)) {
				x = i;
			}
		}
		return x;
	}
	
	public ArrayList<Word> getWords() {
		return words;
	}

	public void setWords(ArrayList<Word> words) {
		Dictionary.words = words;
	}

	public Language getActualLanguage() {
		return actualLanguage;
	}
	public void setActualLanguage(Language al) {
		actualLanguage = al;
	}
	
}
