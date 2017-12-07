package uk.ac.brunel.cs1702;
import java.util.ArrayList;
import java.util.List;

public class MyStore {
	private List<ItemForSale> items = null;
	public MyStore() {
		this.items = new ArrayList<ItemForSale>();
	}
	
	public void setItems(List<ItemForSale> items){
		this.items = items;
	}

	public static void main(String[] args) {
        MyStore myStore = new MyStore();
        myStore.items.add(new ItemForSale("Herbal Health Supplements", 10, 5));
        myStore.items.add(new ItemForSale("Aged Parmesan cheese", 20, 10));
        myStore.items.add(new ItemForSale("Local soda drink", 20, 3));
        myStore.items.add(new ItemForSale("World War I Medals", 0, 80));
        myStore.items.add(new ItemForSale("Tickets to Iron Maiden concert", 15, 20));
        myStore.items.add(new ItemForSale("Special cake baked in store", 3, 6));
        myStore.updateInventory();
        System.out.println("Inventory Updated!");
    }
    public void updateInventory() {
        for (int i = 0; i < items.size(); i++) {
	                if (items.get(i).getPrice() > 0 && items.get(i).getPrice() < 50) {	
	                	//price cannot be negative or go above 50
	                	//what happens to price of each product
	                        soda(i);
	                        herbs(i);
	                        cheese(i);
	                        tickets(i);
	                        cake(i);
                }
	                
            if (!items.get(i).getName().equals("World War I Medals")) {	
                items.get(i).setNumberOfDaysToSellIn(items.get(i).getNumberOfDaysToSellIn() - 1);
                // numberofdays goes -1 to all except medals
            }
            tickets2(i);
        }
    }
    
    public void herbs(int i) {
    	if(items.get(i).getName().equals("Herbal Health Supplements")){
            items.get(i).setPrice(items.get(i).getPrice() - 1);
    	}
    }
    public void cheese(int i){
    	if(items.get(i).getName().equals("Aged Parmesan cheese")){
    		items.get(i).setPrice(items.get(i).getPrice() + 1);
    	}
    }
 
    public void soda(int i) {
    	if(items.get(i).getName().equals("Local soda drink")) {
            items.get(i).setPrice(items.get(i).getPrice() - 1);
    	}
    }
    
    public void tickets(int i) {
    	if(items.get(i).getName().equals("Tickets to Iron Maiden concert")) {
            items.get(i).setPrice(items.get(i).getPrice() + 1);
            //price goes +1
            if (items.get(i).getNumberOfDaysToSellIn() < 11) {
            	//once number of days is 10 or less, price goes +2
                    items.get(i).setPrice(items.get(i).getPrice() + 1);
                    //once number of days is 5 or less, price goes +3
                    if (items.get(i).getNumberOfDaysToSellIn() < 6) {
                            items.get(i).setPrice(items.get(i).getPrice() + 1);
                    }
            }
    	}
    }
    public void tickets2(int i) {
    	if(items.get(i).getName().equals("Tickets to Iron Maiden concert")) {
        if (items.get(i).getNumberOfDaysToSellIn() < 0) {
        	//once the number of days reaches 0 or below, the price becomes 0
            		items.get(i).setPrice(items.get(i).getPrice() - items.get(i).getPrice());
        }
    	}
    }
    
    public void cake(int i){
    	if(items.get(i).getName().equals("Special cake baked in store")){
    			items.get(i).setPrice(items.get(i).getPrice() -2);
    	}
    }
}

