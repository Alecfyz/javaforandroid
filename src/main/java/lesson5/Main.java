package lesson5;

import java.util.Random;

public class Main {
    public static Random random = new Random();
    protected static int minAge = 18;
    protected static int maxAge = 65;
    public static void main(String[] args) {
Employee[] empsAr = new Employee[6];
        empsAr[0] = new Employee("Изаура", "Марковна", "Шниперсон", getRandAge(), "Впередсмотрящий", "asd@asd.dd", "322-233-332-223", 17000);
        empsAr[1] = new Employee("ТиаБАлду", "иванОвич", "закОВЫкин", getRandAge());
        empsAr[2] = new Employee("ИВАН", "ПЕТРОВИЧ", "ЗЮЗЬ", getRandAge());
        empsAr[3] = new Employee("Доздраперма", "Иосифовна", "Влавлапут", getRandAge());
        empsAr[4] = new Employee("Си", "Лунь", "По", getRandAge());
        empsAr[5] = new Employee("ГадЯ", "ПетровиЧ", "ХреновА", getRandAge());
        System.out.printf("---%n");

int over40 = 0;
        for (int i = 0; i < empsAr.length; i++) {

            if (empsAr[i].getAge() > 40) {
                over40++;
                empsAr[i].printInfo();
            }
        }

        System.out.printf("Старичков возрастом свыше 40: " + over40);
    }

    private static int getRandAge(){
        return (int)(minAge + random.nextInt(maxAge - minAge + 1) );
    }
}
