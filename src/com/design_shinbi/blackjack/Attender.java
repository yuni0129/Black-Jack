package com.design_shinbi.blackjack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * アテンダーのクラス
 */

public abstract class Attender {
	
	public static final int stock = 0;
	protected List<Card> cards;
    protected String name;
    public static int number;
  

    public Attender(String name) {
        this.name = name;
        initialize();
    }

    public void initialize() {
        this.cards = new ArrayList<Card>();
    }

    public void start(Stock stock) {
        this.cards.clear();
        for(int i = 0; i < 2; i++) {
            Card card = stock.pickCard();
            this.cards.add(card);
        }
    }

    public String getName() {
        return name;
    }

    public void hit(Stock stock) {//Aが11になるのは多くて1枚、最初は1を足してみる
        Card card = stock.pickCard();
        this.cards.add(card);
    }
	public static int calculateStrengthFromList(List<Card> list) {
		int strength = 0;     // 合計の強さ
        boolean havingAce = false;
        
        for(Card card : list) {
        	int number = card.getNumber();
        	if(number == 1) {
        		havingAce = true;//Aをもっている情報をtrue
        	}
        	if(number > 10) {
        		number = 10;//絵札は10
        	}
        	strength += number;
        }
        
        if(havingAce && strength <= 11) {//Aを持っていて、合計が11以下だったら
        	strength += 10;
        }
        
        if(strength > 21) {
        	strength = 0;
        }
        
        return strength;
	
	}	
		
		public int calculateStrength() {
	        int strength = calculateStrengthFromList(this.cards);//オブジェクトが持っている手札を計算する
	        return strength;
	    }

	    public String toString() {
	        String string = name + ": ";
	        for(int i = 0; i < this.cards.size(); i++) {
	            Card card = this.cards.get(i);
	            string = string + card.toString();
	        }
	        return string;
	    }

	    public void display() {
	        System.out.println(this.toString());
	    }

	    public abstract void play(Stock stock) throws IOException;


}

