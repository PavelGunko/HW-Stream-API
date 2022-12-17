import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args){

        Collection<Person> filledPersonCollection = GeneratorPerson.getFilledPersonCollection();

        long count = filledPersonCollection.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("Количество несовершеннолетних " + count);
        System.out.println("======================");

        List<String> menToArmy = filledPersonCollection.stream()
                .filter(person -> person.getAge() > 17 && person.getAge() < 28 && Sex.MAN == person.getSex())
                .map(Person::getFamily)
                .collect(Collectors.toList());

        System.out.println("Фамилии призывников" + menToArmy);
        System.out.println("======================");

        List<Person> personList = filledPersonCollection.stream()
                .filter(person -> Education.HIGHER == person.getEducation())
                .filter(person -> {
                    switch (person.getSex()) {
                        case MAN:
                            return person.getAge() > 17 && person.getAge() < 65;
                        case WOMAN:
                            return person.getAge() > 17 && person.getAge() < 60;
                        default:
                            return false;
                    }
                })
                .collect(Collectors.toList());
        System.out.println("Список фамилий работоспособных людей с высшим образованием " + personList);
        System.out.println("======================");

    }

}

