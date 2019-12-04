package it.unipd.tos.model;


public class MenuItem{
	public enum ItemType{Panini, Fritti, Bevande};
	public ItemType tipo;
	public String name;
	public double price;
	public MenuItem(ItemType t, String n, double p) {
		tipo=t;
		name=n;
		price=p;
	}	
}