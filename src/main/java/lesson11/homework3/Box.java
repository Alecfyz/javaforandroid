package lesson11.homework3;

import java.util.ArrayList;

public class Box<E extends Fruit> {
    private ArrayList<E> fruits;
    private String itemsType;

    public Box() {
        fruits = new ArrayList<>();
        itemsType = "";
        System.out.println("Новая коробка!");
    }

    public void add(E item) {
        if (itemsType.equals("")) {
            itemsType = this.getClass().getName();
        }
        fruits.add(item);
        System.out.println("Добавили фрукт " + item.getClass() + " весом " + item.getWeight() + " в коробку.");
    }

    public float getBoxWeight() {
        fruits.trimToSize();
        if (fruits.size() == 0) {
            return 0;
        }
        return fruits.get(0).getWeight() * fruits.size();
    }

    public int getItemsCount() {
        fruits.trimToSize();
        return fruits.size();
    }

    public boolean compare(Box otherBox) {
        float diff = Math.abs(getBoxWeight() - otherBox.getBoxWeight());
//        System.out.println("Diff = " + diff);
        return diff < 0.1;
    }

    public void emptyTo(Box<E> otherBox) {
        while (this.fruits.size() > 0) {
            otherBox.add(fruits.get(0));
            this.fruits.remove(this.fruits.size() - 1);
            this.fruits.trimToSize();
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                ", itemsType='" + itemsType + '\'' +
                '}';
    }
}


