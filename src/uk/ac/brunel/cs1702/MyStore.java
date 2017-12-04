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
            if (!items.get(i).getName().equals("Aged Parmesan cheese")
                    && !items.get(i).getName().equals("Tickets to Iron Maiden concert")) {
                if (items.get(i).getPrice() > 0) {
                    if (!items.get(i).getName().equals("World War I Medals")) {
                        items.get(i).setPrice(items.get(i).getPrice() - 1);
                    }
                }
            } else {
                if (items.get(i).getPrice() < 50) {
                    items.get(i).setPrice(items.get(i).getPrice() + 1);

                    if (items.get(i).getName().equals("Tickets to Iron Maiden concert")) {
                        if (items.get(i).getNumberOfDaysToSellIn() < 11) {
                            if (items.get(i).getPrice() < 50) {
                                items.get(i).setPrice(items.get(i).getPrice() + 1);
                            }
                        }

                        if (items.get(i).getNumberOfDaysToSellIn() < 6) {
                            if (items.get(i).getPrice() < 50) {
                                items.get(i).setPrice(items.get(i).getPrice() + 1);
                            }
                        }
                    }
                }
            }

            if (!items.get(i).getName().equals("World War I Medals")) {
                items.get(i).setNumberOfDaysToSellIn(items.get(i).getNumberOfDaysToSellIn() - 1);
            }

            if (items.get(i).getNumberOfDaysToSellIn() < 0) {
                if (!items.get(i).getName().equals("Aged Parmesan cheese")) {
                    if (!items.get(i).getName().equals("Tickets to Iron Maiden concert")) {
                        if (items.get(i).getPrice() > 0) {
                            if (!items.get(i).getName().equals("World War I Medals")) {
                                items.get(i).setPrice(items.get(i).getPrice() - 1);
                            }
                        }
                    } else {
                        items.get(i).setPrice(items.get(i).getPrice() - items.get(i).getPrice());
                    }
                } else {
                    if (items.get(i).getPrice() < 50) {
                        items.get(i).setPrice(items.get(i).getPrice() + 1);
                    }
                }
            }
        }
    }
}

