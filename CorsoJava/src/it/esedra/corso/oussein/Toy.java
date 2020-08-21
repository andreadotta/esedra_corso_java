package it.esedra.corso.oussein;

public class Toy implements Comparable<Toy> {
	private String name;    // nome del gioccho
	private int price;      // price del gioccho
	private String description;   // description del gioccho
	private int promo;            // promo del gioccho
	
	public Toy(String name,int price, String desc,int promo) {
		this.name=name;
		this.price=price;
		this.description=desc;
		this.promo=promo;
		
	}
	public String getName() {
		return name;
	} 
	public int getPrice() {
		return price;
	}
	public String getDesc() {
		return description;
	}
	public int getPromo() {
		return promo;
	}
	@Override
	public int compareTo(Toy toy2) {
		if(this.promo> toy2.getPromo()) {
			return -1;
		}else {
			return 1;
		}
		
		
	}

}
