// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {

    Zodiac capricorn = Zodiac.CAPRICORN;
    Zodiac leo = Zodiac.LEO;
    System.out.println(capricorn.name());
    Zodiac taurus = Zodiac.valueOf("TAURUS");
    // put your code here
  }
}
enum Zodiac {
  ARIES,
  TAURUS,
  GEMINI,
  CANCER,
  LEO,
  VIRGO,
  LIBRA,
  SCORPIO,
  SAGITTARIUS,
  CAPRICORN,
  AQUARIUS,
  PISCES
}