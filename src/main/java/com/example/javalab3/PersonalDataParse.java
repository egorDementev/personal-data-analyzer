package com.example.javalab3;

import java.time.LocalDate;
import java.time.Period;

public class PersonalDataParse {
    /**
     * Variables that store a person's first name, last name, patronymic and date of birth
     */
    private final String name;
    private final String surname;
    private final String patronymic;
    private final LocalDate birthdayDate;

    /**
     * A function that parses two strings via split and writes all data to class variables
     * Throws an error message if the data is entered incorrectly or missing
     * @param fullNameOfUser A string that contains the first name, last name and patronymic separated by a space
     * @param dateOfBirthday Contains the date of birth of a person in the format yyyy-mm-dd
     */
    PersonalDataParse(String fullNameOfUser, String dateOfBirthday) {
        try {
            String[] fullName = fullNameOfUser.split(" ");
            name = fullName[1];
            surname = fullName[0];
            patronymic = fullName[2];
        }
        catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Name entered incorrectly...");
        }

        try {
            String[] date = dateOfBirthday.split("-");
            birthdayDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        }
        catch (IndexOutOfBoundsException | NullPointerException e) {
            throw new RuntimeException("Date entered incorrectly...");
        }
    }

    /**
     * Counts the age of a person
     * @return the number of full years a person has lived in the number format
     */
    public Integer getAge() {
        int age = Period.between(birthdayDate, LocalDate.now()).getYears();
        if (age >= 0) return age;
        throw new RuntimeException("Incorrect date...");
    }

    /**
     * determines the gender of a person and throws out an exception if the patronymic is entered incorrectly, or it is not Russian
     * @return a line with the name of the gender
     */
    public String getGender() {
        try {
            String endOfPatronymic = patronymic.substring(patronymic.length() - 2);
            if (endOfPatronymic.equals("ич")) { return "Мужчина"; }
            if (endOfPatronymic.equals("на")) { return "Женщина"; }
            throw new RuntimeException("There is no such Russian patronymic...");
        }
        catch (IndexOutOfBoundsException e) {
            throw new RuntimeException("Patronymic entered incorrectly...");
        }
    }

    /**
     * determines the correct spelling of the word year depending on the age of the person
     * @param age the number of full years a person has lived
     * @return a string with the correct spelling of the word year
     */
    public String spellingYears(int age) {
        if (age % 10 == 1 && age % 100 != 11) { return " год"; }
        if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) { return " года"; }
        return " лет";
    }

    /**
     * based on the name, surname and patronymic of a person builds his initials
     * @return a string with the initials of a person
     */
    public String getInitials() {
        return surname.toUpperCase().charAt(0) + surname.toLowerCase().substring(1) + " " + name.toUpperCase().charAt(0) + ". " + patronymic.toUpperCase().charAt(0) + ".";
    }
}
