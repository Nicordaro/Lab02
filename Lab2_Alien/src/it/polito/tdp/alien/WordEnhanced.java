package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	private String alienWord;
	private String translation;
	
	private List<String> listTranslation = new ArrayList<String>();
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation=translation;
		listTranslation.add(translation);
	}
	
	
	public String getAlienWord() {
		return alienWord;
	}


	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}


	public String getTranslation() {	
		String translationTmp=listTranslation.get(0).toUpperCase();
		if(listTranslation.size()>1) {
			for(int i=1; i<listTranslation.size(); i++) {
			translationTmp+= " oppure "+listTranslation.get(i).toUpperCase();
			}
		}
		return translationTmp;
	}


	public void setTranslation(String translation) {
		this.listTranslation.add(translation);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}


}
