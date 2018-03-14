package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	
	private List<WordEnhanced> dictionary=new ArrayList<WordEnhanced>();
	
	public void addWord(String alienWord, String translation) {
		if(dictionary.size()==0) {
			WordEnhanced we = new WordEnhanced(alienWord, translation);
			we.setTranslation(translation);
			dictionary.add(we);
		}
		for(WordEnhanced w : this.dictionary) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())){
				w.setTranslation(translation);
			}
			else
				dictionary.add(new WordEnhanced(alienWord, translation));
		}
	}
	public String translateWord(String alienWord) {
		String translation=null;
		for(WordEnhanced w:this.dictionary) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())){
				translation=w.getTranslation();
			}
		}
		return translation;
	}
}
