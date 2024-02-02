package com.design_shinbi.blackjack;

import java.util.Collections;
import java.util.List;

/**
 * カードのストック
 */

public class Stock {
 private List<Card> cards;

 public Stock() {
	 initialize();
 }
 public void initialize() {
	 List<Card> list= Card.getAllCards();
	 Collections.shuffle(list);
	 this.cards = list;
 }
 public int getNumberOfCards() {
	 return this.cards.size();
 }
 
 public Card pickCard() {//山札から１枚とる
	 Card card = this.cards.get(0);//山札から最初のカードを取得
	 this.cards.remove(0);//山札の最初のカードを取り除く
	 return card;//引いたカードの情報を戻り値として返す
 }
 /**
  * カードを山札から一枚とる
  * @return　引いたカードを戻り値として返す
  */
}
