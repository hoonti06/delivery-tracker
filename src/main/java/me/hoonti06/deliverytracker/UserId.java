package me.hoonti06.deliverytracker;

public class UserId {

  private final Long value;

  public UserId(Long value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value.toString();
  }
}
