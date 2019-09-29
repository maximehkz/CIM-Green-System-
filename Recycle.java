package sample;


public class Recycle {
	
	private ItemType itemType;
	private double itemWeight;
	
	
	
		//constructor with parameters
	public Recycle(ItemType itemType, double itemWeight) {		
		this.itemType = itemType;
		this.itemWeight = itemWeight;	
	}
		 	
		//methods
		public ItemType getItemType() {
			return itemType;
		}
		
		
		public double getItemWeight () {
			return itemWeight;
		}
		
		public double getItemPrice() { 
			return itemType.getPrice() / itemType.getWeight() * getItemWeight();
		}
		
		
		public String showItemInfo() {
			System.out.println("\t"+ itemType.getType() + "\t\t"+ getItemWeight() + "kg" + "\t\t" + "$" + getItemPrice());
			return "\t"+ itemType.getType() + "\t"+ getItemWeight() + "kg" + "\t" + "$" + getItemPrice() + "\n";
		}
		
		
		
		
}
	

