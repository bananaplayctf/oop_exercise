package cart.Cart;


import disc.DigitalVideoDisc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private static int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
        }
        else System.out.println("Maximum order reached");
    }

//    public void addDigitalVideoDisc(disc.DigitalVideoDisc.DigitalVideoDisc [] dvdList) {
//        if (dvdList.length + qtyOrdered <  MAX_NUMBERS_ORDERED) {
//            for (disc.DigitalVideoDisc.DigitalVideoDisc disc: dvdList) {
//                itemsOrdered[qtyOrdered] = disc;
//                System.out.println("The disc has been added");
//                qtyOrdered += 1;
//            }
//        }
//        else System.out.println("Maximum order reached if added");
//    }
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
            } else {
                System.out.println("Maximum order reached");
                break;
            }
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("No item to remove");
            return;
        }
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isequal(disc)) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered --;
                System.out.println("Item remove successfully");
                return;
            }
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". " + disc.toString()); // Using toString() method
            totalCost += disc.getCost();
        }
        System.out.println("Total cost: " + totalCost);
        System.out.println("***************************************************");
    }

    public void searchDVDByID(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            if (disc.getId() == id) {
                found = true;
                System.out.println(disc);
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
    }

    public void searchDVDByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            if (disc.getTitle().equals(title)) {
                found = true;
                System.out.println(disc);
            }
        }
        if (!found) {
            System.out.println("No match found for Title: " + title);
        }
    }

}