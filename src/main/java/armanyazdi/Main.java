package armanyazdi;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Generate Persian Full Names in Farsi:
        System.out.println(PersianNames.fullNameFarsi("male"));
        System.out.println(PersianNames.fullNameFarsi("female"));
        System.out.println(PersianNames.fullNameFarsi("random"));
        System.out.println(PersianNames.fullNameFarsi()); // Default: "random"

        // Generate Persian Full Names in English:
        System.out.println(PersianNames.fullNameEnglish("m"));
        System.out.println(PersianNames.fullNameEnglish("f"));
        System.out.println(PersianNames.fullNameEnglish("r"));
        System.out.println(PersianNames.fullNameEnglish()); // Default: "random"

        // Generate First Names and Last Names in Farsi:
        System.out.println(PersianNames.firstNameFarsi("m"));
        System.out.println(PersianNames.firstNameFarsi("f"));
        System.out.println(PersianNames.firstNameFarsi("r"));
        System.out.println(PersianNames.lastNameFarsi());

        // Generate First Names and Last Names in English:
        System.out.println(PersianNames.firstNameEnglish("m"));
        System.out.println(PersianNames.firstNameEnglish("f"));
        System.out.println(PersianNames.firstNameEnglish("r"));
        System.out.println(PersianNames.lastNameEnglish());
    }
}