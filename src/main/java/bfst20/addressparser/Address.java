package bfst20.addressparser;

import java.util.regex.*;

import java.util.regex.Pattern;

public class Address {

  private static Model model;

  public final String street, house, floor, side, postcode, city;

  private Address(
          String _street, String _house, String _floor, String _side, String _postcode, String _city) {
    street = _street;
    house = _house;
    floor = _floor;
    side = _side;
    postcode = _postcode;
    city = _city;
  }

  public String toString() {
    return street + " " + house + ", " + floor + " " + side + "\n" + postcode + " " + city;
  }

  //Regular expression lavet med Lene Borup Randlov.
  static String regex = "^[ ,\\._-]*(?<street>[0-9a-zA-ZæøåÆØÅ \\.,-]+?)[ ,\\._-]+(?<house>[0-9a-zA-ZæøåÆØÅ]*)(([ ,\\._-]+(?<floor>[0-9]{1,3})[ ,\\._-]+(?<side>[0-9]+))|())[ ,\\._-]*((?<postcode>[0-9]{4})|())(([ ,\\._-]*(?<city>[a-zA-ZæøåÆØÅ .,-]+?))|())[ ,\\._-]*$";
  static Pattern pattern = Pattern.compile(regex);

  public static Address parse(String input) {
    var matcher = pattern.matcher(input);
    if (matcher.matches()) {
      return new Builder()
              .street(matcher.group("street"))
              .house(matcher.group("house"))
              .floor(matcher.group("floor"))
              .side(matcher.group("side"))
              .postcode(matcher.group("postcode"))
              .city(matcher.group("city"))
              .build();
    } else {
      throw new IllegalArgumentException("Cannot parse: " + input);
    }
  }

  public static class Builder {
    private String street, house, floor, side, postcode, city;

    public Builder street(String _street) {
      street = _street;
      return this;
    }

    public Builder house(String _house) {
      house = _house;
      return this;
    }

    public Builder floor(String _floor) {
      floor = _floor;
      return this;
    }

    public Builder side(String _side) {
      side = _side;
      return this;
    }

    public Builder postcode(String _postcode) {
      postcode = _postcode;
      return this;
    }

    public Builder city(String _city) {
      city = _city;
      return this;
    }

    public Address build() {
      return new Address(street, house, floor, side, postcode, city);
    }
  }
}