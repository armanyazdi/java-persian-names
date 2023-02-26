package armanyazdi;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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
    }
}