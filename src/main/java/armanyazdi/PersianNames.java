package armanyazdi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class PersianNames {
    private static byte genderNumber;
    private static final String[] files = {"male_en.txt", "female_en.txt", "male_fa.txt", "female_fa.txt"};
    private static String[] somePrefixes, someSuffixes, moreSuffixes, arabicNames;
    private static final ArrayList<String> firstNamesEnglish = new ArrayList<>();
    private static final ArrayList<String> lastNamesEnglish = new ArrayList<>();
    private static final ArrayList<String> firstNamesFarsi = new ArrayList<>();
    private static final ArrayList<String> lastNamesFarsi = new ArrayList<>();

    private static void setGender(String sex) {
        switch (sex.toLowerCase()) {
            case "male", "m" -> genderNumber = 0;
            case "female", "f" -> genderNumber = 1;
            case "random", "r" -> genderNumber = (byte) Math.round(Math.random());
            default -> genderNumber = (byte) Math.round(Math.random());
        }
    }

    public static String firstNameEnglish(String sex) throws FileNotFoundException {
        setGender(sex);
        File file = new File("src/main/resources/files/" + files[genderNumber]);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            firstNamesEnglish.add((Arrays.toString(data.split("\n"))));
        }

        reader.close();
        return firstNamesEnglish.get((int) (Math.random() * firstNamesEnglish.size())).replace("[", "").replace("]", "");
    }

    public static String firstNameEnglish() throws FileNotFoundException {
        return firstNameEnglish("random");
    }

    public static String lastNameEnglish() throws FileNotFoundException {
        // English Prefixes and Suffixes
        somePrefixes = new String[]{
                "", "", "",
                "Mir",
                "Agha",
                "Shah",
                "Haj",
                "Haji",
                "Sheikh"
        };
        someSuffixes = new String[]{
                "", "", "", "", "", "", "", "", "", "", "", "", "",
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
                "nejad",
                "bayat"
        };
        moreSuffixes = new String[]{
                "i", "i", "i", "i", "i", "i", "i", "i", "i", "i",
                "pour",
                "zadeh",
                "far",
                "fard",
                "khani",
                "vand",
                "lou",
                "nia",
                "zehi",
                "nejad"
        };

        // Arabic Names
        arabicNames = new String[]{
                "Abbas",
                "Abdollah",
                "Abolfazl",
                "Ahmad",
                "Akbar",
                "Davoud",
                "Ebrahim",
                "Esmaeil",
                "Hakim",
                "Hassan",
                "Hossein",
                "Kamal",
                "Mansour",
                "Mahmoud",
                "Mohammad",
                "Nasser",
                "Nassir",
                "Rahim",
                "Rahman",
                "Saleh",
                "Soleiman",
                "Soltan",
                "Yaghoub",
                "Yousef"
        };

        File file = new File("src/main/resources/files/" + files[0]);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            lastNamesEnglish.add(Arrays.toString(data.split("\n")));
        }

        reader.close();
        String lastName = lastNamesEnglish.get((int) (Math.random() * lastNamesEnglish.size())).replace("[", "").replace("]", "");

        if (lastName.equals("Mostafa") || lastName.equals("Mousa") || lastName.equals("Yahya"))
            lastName += "vi";
        else if (lastName.equals("Morteza"))
            lastName = lastName.replace("ez", "az") + "vi";
        else if (lastName.equals("Ali") || lastName.equals("Mahdi"))
            lastName = lastName.replace("i", new String[]{"i", "avi"}[(byte) (Math.round(Math.random()))]);
        else if (lastName.equals("Khosro"))
            lastName = lastName.replace("ro", "ravi");
        else if (lastName.charAt(lastName.length() -1) == 'a' || lastName.charAt(lastName.length() -1) == 'o' || lastName.charAt(lastName.length() -1) == 'u')
            lastName += "ei";
        else if (lastName.charAt(lastName.length() -1) == 'i')
            assert true;
        else {
            lastName += new String[]{"i", ""}[(byte) (Math.round(Math.random()))];
        }

        if (Arrays.asList(arabicNames).contains(lastName.substring(0, lastName.length() - 1))) {
            String prefix = somePrefixes[(byte) (Math.random() * somePrefixes.length)];
            if (!Objects.equals(prefix, "") && prefix.charAt(prefix.length() -1) == lastName.toLowerCase().charAt(0))
                lastName = prefix + " " + lastName;
            else
                lastName = prefix + lastName.toLowerCase();
        }
        else if (lastName.length() > 10 && lastName.charAt(lastName.length() -1) == 'i')
            lastName += "";
        else if (lastName.length() > 10 && lastName.charAt(lastName.length() -1) != 'i')
            lastName += "i";
        else if (lastName.charAt(lastName.length() -1) == 'i')
            lastName += someSuffixes[(byte) (Math.random() * someSuffixes.length)];
        else
            lastName += moreSuffixes[(byte) (Math.random() * moreSuffixes.length)];

        while (lastName.toLowerCase().endsWith("ali") || lastName.toLowerCase().endsWith("mahdi") || lastName.equals("Mani") || lastName.equals("Gholi"))
            lastName += someSuffixes[(byte) (Math.random() * someSuffixes.length)];

        return lastName;
    }

    public static String fullNameEnglish(String sex) throws FileNotFoundException {
        return firstNameEnglish(sex) + " " + lastNameEnglish();
    }

    public static String fullNameEnglish() throws FileNotFoundException {
        return fullNameEnglish("random");
    }

    public static String firstNameFarsi(String sex) throws FileNotFoundException {
        setGender(sex);
        File file = new File("src/main/resources/files/" + files[genderNumber + 2]);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            firstNamesFarsi.add((Arrays.toString(data.split("\n"))));
        }

        reader.close();
        return firstNamesFarsi.get((int) (Math.random() * firstNamesFarsi.size())).replace("[", "").replace("]", "");
    }

    public static String firstNameFarsi() throws FileNotFoundException {
        return firstNameFarsi("random");
    }

    public static String lastNameFarsi() throws FileNotFoundException {
        // Farsi Prefixes and Suffixes
        somePrefixes = new String[]{
                "", "", "",
                "میر",
                "آقا",
                "شاه ",
                "حاج ",
                "حاجی ",
                "شیخ "
        };
        someSuffixes = new String[]{
                "", "", "", "", "", "", "", "", "", "", "", "", "",
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
                " نژاد",
                " بیات"
        };
        moreSuffixes = new String[]{
                "ی", "ی", "ی", "ی", "ی", "ی", "ی", "ی", "ی", "ی",
                " پور",
                " زاده",
                " فر",
                " فرد",
                " خانی",
                " وند",
                " لو",
                " نیا",
                " زهی",
                " نژاد"
        };

        // Arabic Names
        arabicNames = new String[]{
                "ابراهیم",
                "ابوالفضل",
                "احمد",
                "اسماعیل",
                "اکبر",
                "حسن",
                "حسین",
                "حکیم",
                "داود",
                "رحمان",
                "رحیم",
                "سلطان",
                "سلیمان",
                "صالح",
                "عباس",
                "عبدالله",
                "کمال",
                "محمد",
                "محمود",
                "منصور",
                "ناصر",
                "نصیر",
                "یعقوب",
                "یوسف"
        };

        File file = new File("src/main/resources/files/" + files[2]);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            lastNamesFarsi.add(Arrays.toString(data.split("\n")));
        }

        reader.close();
        String lastName = lastNamesFarsi.get((int) (Math.random() * lastNamesFarsi.size())).replace("[", "").replace("]", "");

        if (lastName.equals("مرتضی") || lastName.equals("مصطفی") || lastName.equals("موسی"))
            lastName = lastName.replace("ی", "وی");
        else if (lastName.equals("یحیی"))
            lastName = lastName.replace("یی", "یوی");
        else if (lastName.equals("علی") || lastName.equals("مهدی"))
            lastName = lastName.replace("ی", new String[]{"ی", "وی"}[(byte) (Math.round(Math.random()))]);
        else if (lastName.equals("خسرو"))
            assert true;
        else if (lastName.charAt(lastName.length() -1) == 'ا' || lastName.charAt(lastName.length() -1) == 'و')
            lastName += "ئی";
        else if (lastName.charAt(lastName.length() -1) == 'ی')
            assert true;
        else {
            lastName += new String[]{"ی", ""}[(byte) (Math.round(Math.random()))];
        }

        if (Arrays.asList(arabicNames).contains(lastName.substring(0, lastName.length() - 1)))
            lastName = somePrefixes[(byte) (Math.random() * somePrefixes.length)] + lastName;
        else if (lastName.charAt(lastName.length() -1) == 'ی')
            lastName += someSuffixes[(byte) (Math.random() * someSuffixes.length)];
        else
            lastName += moreSuffixes[(byte) (Math.random() * moreSuffixes.length)];

        while (lastName.endsWith("علی") || lastName.endsWith("مهدی") || lastName.equals("عیسی") || lastName.equals("مانی") || lastName.equals("قلی"))
            lastName += someSuffixes[(byte) (Math.random() * someSuffixes.length)];

        return lastName;
    }

    public static String fullNameFarsi(String sex) throws FileNotFoundException {
        return firstNameFarsi(sex) + " " + lastNameFarsi();
    }

    public static String fullNameFarsi() throws FileNotFoundException {
        return fullNameFarsi("random");
    }
}