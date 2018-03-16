package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
		
	private List<WordEnhanced> dictionary=new ArrayList<WordEnhanced>();
	
	public void addWord(String alienWord, String translation) {
		if(dictionary.size()==0) {
			WordEnhanced we = new WordEnhanced(alienWord, translation);
			we.setTranslation(translation);
			dictionary.add(we);
		}
		else {
		for(WordEnhanced we : this.dictionary) {
			if(we.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())){
				we.setTranslation(translation);
			}
			else
				dictionary.add(new WordEnhanced(alienWord, translation));
		}}
	}
	public String translateWord(String alienWord) {
		String translation="";
		if(alienWord.contains("?")) {
			String alienWordIncomplete="";
			int place=-1;
			List<String> incompleteWords=new LinkedList<String>();
		
			char[] cArray = alienWord.toCharArray();
			for(int i =0; i<cArray.length;i++) {
			if(cArray[i]=='?') {
				place=i;
			}
			
		}
		for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
			cArray[place]=alphabet;
			alienWordIncomplete=String.valueOf(cArray);
			for(WordEnhanced w:this.dictionary) {
				if(w.getAlienWord().toLowerCase().equals(alienWordIncomplete.toLowerCase())){
					incompleteWords.add(alienWordIncomplete);
				}
			}
		}
		for(String s: incompleteWords) {
			translation+=" Trovata questa possibile traduzione: "+s.toUpperCase();
		}
		}
		else {
		
		for(WordEnhanced w:this.dictionary) {
			if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())){
				translation=w.getTranslation().toUpperCase();
			}
		}}
		if(translation.length()==0) {
			translation=null;
		}
		return translation;
	}
}
