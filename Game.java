package com.serialisation.object;

import java.io.Serializable;

public class Game implements Serializable {
	private String nom,style;
	private double prix;
	private  Notice noticeJeu;
	/**
	 * @param nom
	 * @param style
	 * @param prix
	 */
	public Game(String nom, String style, double prix) {
		super();
		this.nom = nom;
		this.style = style;
		this.prix = prix;
		this.noticeJeu= new Notice("francais");
	}
	public String toString() {
		return "Nom du Jeu: " + this.nom +
	           "\nStyle du Jeu: " + this.style +" \n"+
				"Prix du Jeu: " + this.prix+"\n"
				+this.noticeJeu;
	}

}
