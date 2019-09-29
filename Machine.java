package sample;



import java.io.*;
import java.util.ArrayList;

public class Machine {
	
	private double maxWeight;
	private double currentWeight;
	public ArrayList<ItemType> itemTypeList;
	public  ArrayList<Recycle> recycleItemList;
	
	
	public Machine() {
		maxWeight = 100;
		currentWeight = 0;
		itemTypeList = new ArrayList<ItemType>();
		recycleItemList = new ArrayList<Recycle>();
		
	}
	
	
	public boolean aboveZero(double num) {
		if (num <= 0)
			return false;
		return true;
	}
	
	public void newItemType(String typeName,
			double itemPrice, double weightForPrice) {

		if ((!aboveZero(itemPrice)) || (!aboveZero(weightForPrice))) {
			System.out.println("Item Price has to be above zero!");
		}else {

			int i = indexOfItemTypeByName(typeName);
		
			if (i != -1)	{
				System.out.println("Itemtype "	+ typeName
						+ " exists in the ItemTypeList");	
			
			}else {
		
		
				ItemType itemType = new ItemType(typeName, itemPrice, weightForPrice);
				itemTypeList.add(itemType);
			}
		}
	}
	
	
	private int indexOfItemTypeByName(String typeName) {
		int i = -1;
		for (int j = 0; j < itemTypeList.size(); j++) {
			if (typeName.equalsIgnoreCase(itemTypeList.get(j).getType())) {
				i = j;
				break;
			}
		}
		return i;
	} 
	
	
	
	
	public ArrayList<ItemType> getTypeList() {
		
		return itemTypeList;
	}
	
	
	public void clearItemTypeList() {
		if (itemTypeList == null)
			itemTypeList = new ArrayList<ItemType>();
		else
			itemTypeList.clear();
		
	}
	
	public String showTypeList() {
		String typeList = "";
		if (itemTypeList.size() == 0) {
			System.out.println("There are no existing itemtypes");
		}

		int i;
		System.out.println("List of itemtypes and price by weight in kg:");
		System.out.println("\t" + "Type" + "\t\t" + "price for weight(kg)");

		for (i = 0; i < itemTypeList.size(); i++) {
			typeList += itemTypeList.get(i).showTypeInfo();
		}
		return typeList;
	}

	public double getCurrentWeight() {
		return currentWeight;
	}
	
	public void addRecycleItem(String typeName, double itemWeight) {
		
		
		
		ItemType itemType = getItemType(typeName);
		
		if (!aboveZero(itemWeight)) {
			System.out.println("Item's weight must be above zero!");
			
		}

		// Does not allow an item that is not permitted and shown as a recyclable item
		int index = this.indexOfItemTypeByName(typeName);
		if (index == -1) {
			System.out.println("Item type " + typeName + " doesnt exist!");
			
		}else {
		
			// Does not allow an item if Machine is full
			if (machineIsFull(itemWeight)) {	
			
				System.out.println("Machine doesnt have enough space left");
			}else {
				
				Recycle recycleItem = new Recycle(itemType, itemWeight);
				recycleItemList.add(recycleItem);
				currentWeight += recycleItem.getItemWeight();	
				System.out.println("Item " + typeName + " of " + itemWeight + " kg has been added to receipt!");
			}
		}
	}
	
	
	public ItemType getItemType(String typeName) {
		int i;
		for (i = 0; i < itemTypeList.size(); i++) {
			if (typeName.equalsIgnoreCase(itemTypeList.get(i).getType()))
				return itemTypeList.get(i);
		}
		return null;
	}

	public boolean machineIsFull(double itemWeight) {
		if (currentWeight + itemWeight > maxWeight)
			return true;
		else
			return false;
	}

	public void clearRecycleItemList() {
		if (recycleItemList == null)
			recycleItemList = new ArrayList<Recycle>();
		else
			recycleItemList.clear();
		
	}
	
	public ArrayList<Recycle> getAvailableItemList() {
		return recycleItemList;
	}
	
	
	public double moneyToUser() {
		int i;
		double totalAmount = 0;
		for (i = 0; i < recycleItemList.size(); i++) {
			totalAmount += recycleItemList.get(i).getItemPrice();
		}
		return totalAmount;
	}
	
	public String printReceipt() {
		String receipt = "";
		if (recycleItemList.size() == 0) {
			System.out.println("Recycle machine is empty!");


		}else {
			
			int i;
			System.out.println("\t" + "Item" + "\t\t" + "weight(kg) " +"\t"+
					"price");

			for (i = 0; i < itemTypeList.size(); i++) {
				receipt += recycleItemList.get(i).showItemInfo();
			}
			System.out.println("\n\tTotal" + "\t\t\t\t" + "$" +moneyToUser());
			
		}
		return receipt;
		
	}
	
}
