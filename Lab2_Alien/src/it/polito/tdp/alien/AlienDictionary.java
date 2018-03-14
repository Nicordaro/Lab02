package it.polito.tdp.alien;

import java.util.List;

public class AlienDictionary {
	
	private List<Word> dictionary;
	
	public void addWord(String alienWord, String translation) {
		for(Word w : this.dictionary) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())){
				w.setTranslation(translation);
			}
			else
				dictionary.add(new Word(alienWord, translation));
		}
	}
	public String translateWord(String alienWord) {
		String translation=null;
		for(Word w:this.dictionary) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())){
				translation=w.getTranslation();
			}
		}
		return translation;
	}
}
