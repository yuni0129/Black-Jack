package com.design_shinbi.blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * カード管理クラス、１オブジェクトが１枚のカードになる
 */

public class Card {//オブジェクト
 private Suit suit;
 private int number;
 
 /**
  *コンストラクタ （コンストラクタの説明）
  * @param suit　トランプのマーク(引数の説明)
  * @param number　トランプの数字(引数の説明)
  */
 
 public Card(Suit suit, int number) {//コンストラクタ
	 this.suit = suit;//フィールドのsui//引数のsuit
	 this.number = number;	 	 
 }
/**
 * トランプのマークを取得(メソッドの説明)
 * @returnトランプのマーク(戻り値の説明)
 */
public Suit getSuit() {//getter
	return suit;
}
/**
 * トランプの数字を取得
 * @returnトランプの数字
 */

public int getNumber() {//getter
	return number;
}
 /*static 静的な　オブジェクトに依存しない (クラス名).(フィールド名/メソッド名)
  *dynamic 動的な　オブジェクトごとの情報や処理/オブジェクトが決まっている　(オブジェクト).(フィールド名/メソッド名)
  */
/**
 * カードのマークを数字に置き換える
 * @param number
 * @returnマークを数字にしてそれを文字列にして返す
 */

public static String getNumberString(int number) {//数字の文字列を取得する
	String string = null;
    if(number == 1) {
        string = "A";
    }
    else if(number == 11) {
        string = "J";
    }
    else if(number == 12) {
        string = "Q";
    }
    else if(number == 13) {
        string = "K";
    }
    else if(number >= 2 && number <= 10) {
        string = Integer.toString(number);
    }

    return string;
}
/**
 * 文字列に変換する
 */
public String toString() {
    String string = String.format(
        "[%s%s]", //マークと数字
        this.suit.getName(), getNumberString(this.number)
    );
    return string;
}
//Arraylistが配列の代わりになる
/**
 * トランプのカード54枚すべて取得する
 * @returnカードのリスト
 */
public static List<Card> getAllCards() {//54枚すべて取得する
    List<Card> list = new ArrayList<Card>();
    
    for(Suit suit : Suit.values()) {//拡張子
        for(int number = 1; number <= 13; number++) {
            Card card = new Card(suit, number);
            list.add(card);//to.String
        }
    }

    return list;
}
}
