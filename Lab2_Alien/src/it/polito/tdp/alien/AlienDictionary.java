package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
		
	private List<WordEnhanced> dictionary=new LinkedList<WordEnhanced>();
	private List<String> incompleteWords=new LinkedList<String>();
	
	public void addWord(String alienWord, String translation) {
		if(dictionary.size()==0) {
			WordEnhanced we = new WordEnhanced(alienWord, translation);
			//we.setTranslation(translation);
			dictionary.add(we);
		}
	//	WordEnhanced toAdd = new WordEnhanced(alienWord, translation);
		else {
		for(WordEnhanced we : this.dictionary) {
			if(alienWord.toLowerCase().equals(we.getAlienWord().toLowerCase())) {
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
		
			//Trasformo la parola in un array di caratteri
			char[] cArray = alienWord.toCharArray();
			for(int i =0; i<cArray.length;i++) {
				if(cArray[i]=='?') {
					place=i;
					break;
				}
			
			}
			
			//Sostituisco tutte le lettere dell'alfabeto per vedere se trovo un match nel dizionario
			for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
				cArray[place]=alphabet;
				alienWordIncomplete=String.valueOf(cArray);
				
			//Se trovo match, lo aggiungo tra le possibili parole (lista alienWordIncomplete)
				for(WordEnhanced w:this.dictionary) {
					if(w.getAlienWord().toLowerCase().equals(alienWordIncomplete.toLowerCase())){
						incompleteWords.add(alienWordIncomplete);
					}
				}
			}
			for(String s: incompleteWords) {
				for(WordEnhanced w: this.dictionary) {
					if(w.getAlienWord().toLowerCase().equals(s.toLowerCase())) {
						translation+=" Trovata questa possibile traduzione: "+w.getTranslation();
					}
				}
			}
				
		} 
			else {
				for(WordEnhanced w: this.dictionary) {
					if(w.getAlienWord().toLowerCase().equals(alienWord.toLowerCase())) {
						translation=w.getTranslation();
					}
				}
			}
		
		if(translation.length()==0) {
			translation=null;
		}
		return translation;
	}
}
