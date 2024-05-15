package hust.soict.cyber.test.disc;

import hust.soict.cyber.aims.media.DigitalVideoDisc;

public class TestingPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

//        changeTitle(jungleDVD, cinderellaDVD.getTitle());
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
//    public static void swap(Object o1, Object o2) {
//        Object tmp = o1;
//        o1 = o2;
//        o2 = tmp;
//    }
    public static void changeTitle (DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void swap (DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
        // Create temporary copies to hold original values
        String tempTitle = disc1.getTitle();
        String tempCategory = disc1.getCategory();
        String tempDirector = disc1.getDirector();
        int tempLength = disc1.getLength();
        float tempCost = disc1.getCost();

        // Set disc1 attributes to disc2 values
        disc1.setTitle(disc2.getTitle());
        disc1.setCategory(disc2.getCategory());
        disc1.setDirector(disc2.getDirector());
        disc1.setLength(disc2.getLength());
        disc1.setCost(disc2.getCost());

        // Set disc2 attributes to temporary (original disc1) values
        disc2.setTitle(tempTitle);
        disc2.setCategory(tempCategory);
        disc2.setDirector(tempDirector);
        disc2.setLength(tempLength);
        disc2.setCost(tempCost);
    }
}
