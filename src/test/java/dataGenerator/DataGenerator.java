package dataGenerator;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataGenerator {
    static Faker faker = new Faker(new Locale ("en-US"));

    public String firstNameGenerate() {
        return faker.name().firstName();
    }

    public String lastNameGenerate() {
        return faker.name().lastName();
    }
    public String fullNameGenerate(){
        return faker.name ().fullName ();
    }
    public String emailGenerate() {
        return faker.bothify("????##@mail.com");
    }
}
