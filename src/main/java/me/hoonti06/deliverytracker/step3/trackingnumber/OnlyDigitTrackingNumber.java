package me.hoonti06.deliverytracker.step3.trackingnumber;

import me.hoonti06.deliverytracker.step3.exception.InvalidTrackingNumberException;

public class OnlyDigitTrackingNumber implements TrackingNumber {

  private final TrackingNumber origin;

  public OnlyDigitTrackingNumber(final TrackingNumber origin) {
    this.origin = origin;
  }

  @Override
  public String getNumber() {
    String number = origin.getNumber();
    validate(number);
    return number;
  }

  private void validate(final String trackingNumber) {
    if (hasNotDigitCharacter(trackingNumber)) {
      throw new InvalidTrackingNumberException("숫자가 아닌 문자 존재");
    }
  }

  private boolean hasNotDigitCharacter(final String trackingNumber) {
    return !hasOnlyDigit(trackingNumber);
  }

  private boolean hasOnlyDigit(final String trackingNumber) {
    return trackingNumber.chars().allMatch(Character::isDigit);
  }
}
