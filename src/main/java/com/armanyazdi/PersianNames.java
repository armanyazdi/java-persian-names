package com.armanyazdi;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class PersianNames {
    private static byte genderNumber;
    private static String[] somePrefixes, someSuffixes, moreSuffixes;
    private static final ArrayList<String> firstNamesEnglish = new ArrayList<>();
    private static final ArrayList<String> lastNamesEnglish = new ArrayList<>();
    private static final ArrayList<String> firstNamesFarsi = new ArrayList<>();
    private static final ArrayList<String> lastNamesFarsi = new ArrayList<>();
    private static final ArrayList<String> someNames = new ArrayList<>();

    private static void setGender(String sex) {
        switch (sex.toLowerCase()) {
            case "male", "m" -> genderNumber = 0;
            case "female", "f" -> genderNumber = 1;
            default -> genderNumber = (byte) Math.round(Math.random());
        }
    }

    private static void fileReader(int number, ArrayList<String> list) {
        String[] files = {"male_en.txt", "female_en.txt", "male_fa.txt", "female_fa.txt"};

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data/".concat(files[number])));
            String line;
            while ((line = reader.readLine()) != null) list.add(line);
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String firstNameEnglish(String sex) {
        setGender(sex);
        fileReader(genderNumber, firstNamesEnglish);

        return firstNamesEnglish.get((int) (Math.random() * firstNamesEnglish.size()));
    }

    public static String firstNameEnglish() {
        return firstNameEnglish("r");
    }

    public static String lastNameEnglish() {
        // English Prefixes and Suffixes
        somePrefixes = new String[]{
                "Mir",
                "Agha",
                "Pour",
                "Nour",
                "Amir",
                "Shah",
                "Haj",
                "Haji",
                "Sheikh",
                "Mirza",
                "Beig"
        };
        someSuffixes = new String[]{
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
                "pour",
                "zadeh",
                "far",
                "fard",
                "an",
                "kia",
                "rad",
                "zand",
                "khah",
                "nia",
                "mehr",
                "azar",
                "nejad",
                "bayat",
                "yekta"
        };
        moreSuffixes = new String[]{
                "i", "i", "i", "i", "i", "i", "i", "i", "i", "i", "i",
                "pour",
                "zadeh",
                "far",
                "fard",
                "khani",
                "vand",
                "lou",
                "nia",
                "zehi",
                "nejad",
                "beigi"
        };

        fileReader(0, lastNamesEnglish);
        for (byte i = 0; i < 23; i++) someNames.add(lastNamesEnglish.get(i));
        String lastName = lastNamesEnglish.get((int) (Math.random() * lastNamesEnglish.size()));

        if (lastName.equals("Mostafa") || lastName.equals("Mousa") || lastName.equals("Yahya") || lastName.equals("Kasra"))
            lastName += "vi";
        else if (lastName.equals("Morteza"))
            lastName = lastName.replace("ez", "az") + "vi";
        else if (lastName.equals("Ali") || lastName.equals("Mahdi"))
            lastName = lastName.replace("i", new String[]{"i", "avi"}[(byte) (Math.round(Math.random()))]);
        else if (lastName.equals("Khosro"))
            lastName = lastName.replace("ro", "ravi");
        else if (lastName.endsWith("a") || lastName.endsWith("o") || lastName.endsWith("u"))
            lastName += "ei";
        else if (lastName.endsWith("i"))
            assert true;
        else
            lastName += new String[]{"i", ""}[(byte) (Math.round(Math.random()))];

        if (someNames.contains(lastName.substring(0, lastName.length() - 1)) || someNames.contains(lastName.substring(0, lastName.length() - 2))) {
            String prefix = somePrefixes[(byte) (Math.random() * somePrefixes.length)];
            String suffix = someSuffixes[(byte) (Math.random() * someSuffixes.length)];
            if (suffix.equals("") && !Objects.equals(prefix, "") && prefix.charAt(prefix.length() - 1) == lastName.toLowerCase().charAt(0))
                lastName = prefix + " " + lastName;
            else if (suffix.equals(""))
                lastName = prefix + lastName.toLowerCase();
            else
                lastName += suffix;
        }
        else if ((lastName.length() <= 5 && lastName.endsWith("i")) || (lastName.toLowerCase().endsWith("ali") || lastName.toLowerCase().endsWith("mahdi")))
            lastName += new String[]{"pour", "zadeh", "far", "fard", "an", "kia", "khani", "vand", "nia", "nejad", "beigi"}[(byte) (Math.round(Math.random() * 10))];
        else if (lastName.length() > 10 && lastName.endsWith("i"))
            lastName += "";
        else if (lastName.length() > 10 && !lastName.endsWith("i"))
            lastName += "i";
        else if (lastName.endsWith("i"))
            lastName += someSuffixes[(byte) (Math.random() * someSuffixes.length)];
        else
            lastName += moreSuffixes[(byte) (Math.random() * moreSuffixes.length)];

        return lastName;
    }

    public static String fullNameEnglish(String sex) {
        return firstNameEnglish(sex) + " " + lastNameEnglish();
    }

    public static String fullNameEnglish() {
        return fullNameEnglish("r");
    }

    public static String firstNameFarsi(String sex) {
        setGender(sex);
        fileReader(genderNumber + 2, firstNamesFarsi);

        return firstNamesFarsi.get((int) (Math.random() * firstNamesFarsi.size()));
    }

    public static String firstNameFarsi() {
        return firstNameFarsi("r");
    }

    public static String lastNameFarsi() {
        // Farsi Prefixes and Suffixes
        somePrefixes = new String[]{
                "میر",
                "آقا",
                "پور",
                "نور",
                "امیر",
                "شاه ",
                "حاج ",
                "حاجی ",
                "شیخ ",
                "میرزا ",
                "بیگ "
        };
        someSuffixes = new String[]{
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
                " پور",
                " زاده",
                " فر",
                " فرد",
                "ان",
                " کیا",
                " راد",
                " زند",
                " خواه",
                " نیا",
                " مهر",
                " آذر",
                " نژاد",
                " بیات",
                " یکتا"
        };
        moreSuffixes = new String[]{
                "ی", "ی", "ی", "ی", "ی", "ی", "ی", "ی", "ی", "ی", "ی",
                " پور",
                " زاده",
                " فر",
                " فرد",
                " خانی",
                " وند",
                " لو",
                " نیا",
                " زهی",
                " نژاد",
                " بیگی"
        };

        fileReader(2, lastNamesFarsi);
        for (byte i = 0; i < 23; i++) someNames.add(lastNamesFarsi.get(i));
        String lastName = lastNamesFarsi.get((int) (Math.random() * lastNamesFarsi.size()));

        if (lastName.equals("مرتضی") || lastName.equals("مصطفی") || lastName.equals("موسی") || lastName.equals("کسری"))
            lastName = lastName.replace("ی", "وی");
        else if (lastName.equals("یحیی"))
            lastName = lastName.replace("یی", "یوی");
        else if (lastName.equals("علی") || lastName.equals("مهدی"))
            lastName = lastName.replace("ی", new String[]{"ی", "وی"}[(byte) (Math.round(Math.random()))]);
        else if (lastName.equals("خسرو"))
            assert true;
        else if (lastName.endsWith("ا") || lastName.endsWith("و"))
            lastName += "یی";
        else if (lastName.endsWith("ی"))
            assert true;
        else
            lastName += new String[]{"ی", ""}[(byte) (Math.round(Math.random()))];

        if (someNames.contains(lastName.substring(0, lastName.length() - 1)) || someNames.contains(lastName.substring(0, lastName.length() - 2))) {
            String prefix = somePrefixes[(byte) (Math.random() * somePrefixes.length)];
            String suffix = someSuffixes[(byte) (Math.random() * someSuffixes.length)];
            if (suffix.equals(""))
                lastName = prefix + lastName;
            else
                lastName += suffix;
        }
        else if ((lastName.length() <= 4 && lastName.endsWith("ی")) || (lastName.endsWith("علی") || lastName.endsWith("مهدی")))
            lastName += new String[]{" پور", " زاده", " فر", " فرد", "ان", " کیا", " خانی", " وند", " نیا", " نژاد", " بیگی"}[(byte) (Math.round(Math.random() * 10))];
        else if (lastName.endsWith("ی"))
            lastName += someSuffixes[(byte) (Math.random() * someSuffixes.length)];
        else
            lastName += moreSuffixes[(byte) (Math.random() * moreSuffixes.length)];

        return lastName;
    }

    public static String fullNameFarsi(String sex) {
        return firstNameFarsi(sex) + " " + lastNameFarsi();
    }

    public static String fullNameFarsi() {
        return fullNameFarsi("r");
    }
}