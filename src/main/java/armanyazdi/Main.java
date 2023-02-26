package armanyazdi;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // Generate Persian names in Farsi:
        System.out.println(PersianNames.fullNameFa("male"));
        System.out.println(PersianNames.fullNameFa("female"));
        System.out.println(PersianNames.fullNameFa("random"));
        System.out.println(PersianNames.fullNameFa()); // Default: "random"

        // Generate Persian names in English:
        System.out.println(PersianNames.fullNameEn("m"));
        System.out.println(PersianNames.fullNameEn("f"));
        System.out.println(PersianNames.fullNameEn("r"));
        System.out.println(PersianNames.fullNameEn()); // Default: "random"
    }
}