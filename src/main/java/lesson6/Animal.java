package lesson6;

public abstract class Animal {
    protected String name;
    private String color;
    protected int age;
    protected String animClass;

    protected static int animalsCount;


    protected boolean canSweem;
    protected boolean canRun;

    protected int maxRunLenght;
    protected int allTimeRunLen = 0;

    protected int maxSweemLenght;
    protected int allTimeSweemLen = 0;



    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        animalsCount++;
    }

    public Animal(String name) {
        this(name, "зеленый", 1);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                '}';
    }

    public abstract void voice();

    public void printInfo(){
        System.out.println(this);
    }


    public void doRun(int len){
        if (len >0 && len <= this.maxRunLenght){
            this.allTimeRunLen += len;
            System.out.printf("I`m a %s named %s and I just ran for %d meters! And I`m ran for %d meters at all!%n", this.animClass, this.name, len, this.allTimeRunLen);
        } else if (len > this.maxRunLenght){
            this.allTimeRunLen += this.maxRunLenght;
            System.out.printf("I`m just a poor %s from a poor family! I can`t run over %d meters distance! I`ll try it for you! And I`m ran for %d meters at all!%n", this.animClass, this.maxRunLenght, this.allTimeRunLen);
        }
    }

    public void doSweem(int len){
        if(!this.canSweem) {
            System.out.printf("%nI. AM. %s %s. AND. I. CAN. NOT. SWEEEEEEEEEEEEEEEEEM!!!!%n", this.animClass, this.name);
            return;
        }
        if (len >0 && len <= this.maxSweemLenght){
            this.allTimeSweemLen += len;
            System.out.printf("I`m a %s named %s and I just swam for %d meters! And I`m swam for %d meters at all!%n", this.animClass, this.name, len, this.allTimeSweemLen);
        } else if (len > this.maxSweemLenght){
            this.allTimeSweemLen += this.maxSweemLenght;
            System.out.printf("I`m just a poor %s from a poor family! I can`t sweem over %d meters distance! I`ll try it for you! And I`m swam for %d meters at all!%n", this.animClass, this.maxSweemLenght, this.allTimeSweemLen);
        }
    }



    public static int getAnimalsCount(){
        return animalsCount;
    }

    public static void showAllAnimals(){
        System.out.printf("%n-=-=-=-%nВсего котов %d, собак %d, а всего животин - %d%n", Cat.catsCount, Dog.dogsCount, getAnimalsCount());
    }
}
