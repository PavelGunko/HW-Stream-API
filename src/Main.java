import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void Person() {


        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (
                int i = 0;
                i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );

        }
        //Найти количество несовершеннолетних (т.е. людей младше 18 лет)
        private static void method1 () {
            List<Person> persons = Person();
            long Person = persons.stream()
                    .filter(person -> person.getAge() <= 17)
                    .count();
            System.out.println("Количество несовершеннолетних " + persons);


        }
        // Получить список фамилий призывников (т.е. мужчин от 18 и до 27 лет).
        private static void method2 () {
            persons.stream().filter((person) -> person.getAge() >= 18 && person.getAge() < 27 && person.getSex() == Sex.MAN)
                    .collect(Collectors.toList());


            Map<String, List<Person>> index = new HashMap<>();
            for (Person person : persons) {
                index.computeIfAbsent(person.getFamily(), k -> new ArrayList<>()).add(person);
            }
            System.out.println("Фамилии призывников " + persons);

        }

                /*Получить отсортированный по фамилии список потенциально
                работоспособных людей с высшим образованием в выборке (т.е. людей с высшим
                        образованием от 18 до 60 лет для женщин и до 65 лет для мужчин).*/
        private static void method3 () {
            persons.stream().filter((person) -> person.getAge() >= 18 && person.getSex() == Sex.MAN && person.getAge() < 65)
                    .filter((person) -> (person.getSex() == Sex.WOMAN && person.getAge() < 60));


        }
        System.out.println("Список фамилий работоспособных людей с высшим образованием " + persons);
    }

}

