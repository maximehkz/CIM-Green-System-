package sample;


public class ItemType {

		private String typeName;
		private double typePrice;
		private double weightForPrice;
		
		//constructor with parameters
		public ItemType (String typeName, double itemPrice, double weightForPrice2) {
			this.typeName = typeName;
			this.typePrice = itemPrice;
			this.weightForPrice = weightForPrice2;
		}
		
		//default constructor
		public ItemType() {
			
		}
		
		//methods
		public void setType(String typeName) {
			this.typeName = typeName;
		}
		
		public void setPrice(int typePrice) {
			this.typePrice = typePrice;
		}
		
		public void setWeight(int weightForPrice) {
			this.weightForPrice = weightForPrice;
		} 
		
		public String getType() {
			return typeName;
		}
		
		public double getPrice() {
			return typePrice;
		}
		
		public double getWeight() {
			return weightForPrice;
		}
		


		
		public String showTypeInfo() {
			System.out.println("\t"+ getType() + ":" + "\t\t"+ "$" + getPrice() +" for "+ getWeight() + "kg(s)");
			return "\t"+ getType() + ":" + "\t\t"+ "$" + getPrice() +" for "+ getWeight() + "kg(s)\n";
		}
		
	  	
}

