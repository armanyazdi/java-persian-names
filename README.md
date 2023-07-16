# Persian Names Java

A Java library for generating random Persian (Farsi) names.

This package generates frequently logical names (a mix of popular Persian and Arabic names with common Persian family name suffixes).

Note: This repository is Java port of Python [persian-names](https://github.com/armanyazdi/persian-names).

## Installation

- [ ] Upload artifact to Maven Central Repository

## Usage

Let's take a look at what an example test case would look like using `persian-names`.

### Generate Persian Full Names in Farsi:

```java
String fullName = PersianNames.fullNameFarsi("male");   // or fullNameFarsi("m")
String fullName = PersianNames.fullNameFarsi("female"); // or fullNameFarsi("f")
String fullName = PersianNames.fullNameFarsi("random"); // or fullNameFarsi("r")
String fullName = PersianNames.fullNameFarsi();         // Default: "random"
```

#### Example:

```java
System.out.println(PersianNames.fullNameFarsi("m")); // اشکان محمدرضائیان
System.out.println(PersianNames.fullNameFarsi("f")); // مهسا امیری
System.out.println(PersianNames.fullNameFarsi("r")); // بیتا خسروی راد
```

### Generate Persian Full Names in English:

```java
String fullName = PersianNames.fullNameEnglish("male");   // or fullNameEnglish("m")
String fullName = PersianNames.fullNameEnglish("female"); // or fullNameEnglish("f")
String fullName = PersianNames.fullNameEnglish("random"); // or fullNameEnglish("r")
String fullName = PersianNames.fullNameEnglish();         // Default: "random"
```

#### Example:

```java
System.out.println(PersianNames.fullNameEnglish("m")); // Arsalan Mohammadi
System.out.println(PersianNames.fullNameEnglish("f")); // Sara Alipour
System.out.println(PersianNames.fullNameEnglish("r")); // Danial Ferdosi
```

### Generate First Names and Last Names in Farsi:

```java
// First Name
String firstName = PersianNames.firstNameFarsi("male");   // or firstNameFarsi("m")
String firstName = PersianNames.firstNameFarsi("female"); // or firstNameFarsi("f")
String firstName = PersianNames.firstNameFarsi("random"); // or firstNameFarsi("r")
String firstName = PersianNames.firstNameFarsi();         // Default: "random"

// Last Name
String lastName = PersianNames.lastNameFarsi();
```

#### Example:

```java
System.out.println(PersianNames.firstNameFarsi("m")); // آرمان
System.out.println(PersianNames.firstNameFarsi("f")); // ساحل
System.out.println(PersianNames.firstNameFarsi("r")); // علیرضا
System.out.println(PersianNames.lastNameFarsi());     // شیخ اسماعیلی
```

### Generate First Names and Last Names in English:

```java
// First Name
String firstName = PersianNames.firstNameEnglish("male");   // or firstNameEnglish("m")
String firstName = PersianNames.firstNameEnglish("female"); // or firstNameEnglish("f")
String firstName = PersianNames.firstNameEnglish("random"); // or firstNameEnglish("r")
String firstName = PersianNames.firstNameEnglish();         // Default: "random"

// Last Name
String lastName = PersianNames.lastNameEnglish();
```

#### Example:

```java
System.out.println(PersianNames.firstNameEnglish("m")); // Mehrad
System.out.println(PersianNames.firstNameEnglish("f")); // Darya
System.out.println(PersianNames.firstNameEnglish("r")); // Baran
System.out.println(PersianNames.lastNameEnglish());     // Bakhtiarizadeh
```

## License

`persian-names` is available under the [MIT license](https://github.com/armanyazdi/persian-names-java/blob/master/LICENSE).