package me.hoonti06.deliverytracker.step3.trackingnumber;

import me.hoonti06.deliverytracker.step3.DeliveryCompanyV3;
import me.hoonti06.deliverytracker.step3.exception.InvalidTrackingNumberExceptionV3;

public class OnlyDigitTrackingNumberV3 implements TrackingNumberV3 {

  private final TrackingNumberV3 origin;

  public OnlyDigitTrackingNumberV3(final TrackingNumberV3 origin) {
    this.origin = origin;
  }

  @Override
  public String getNumber() {
    String number = origin.getNumber();
    validate(number);
    return number;
  }

  @Override
  public DeliveryCompanyV3 getDeliveryCompany() {
    return origin.getDeliveryCompany();
  }

  private void validate(final String trackingNumber) {
    if (hasNotDigitCharacter(trackingNumber)) {
      throw new InvalidTrackingNumberExceptionV3(origin, "숫자가 아닌 문자 존재");
    }
  }

  private boolean hasNotDigitCharacter(final String trackingNumber) {
    return !hasOnlyDigit(trackingNumber);
  }

  private boolean hasOnlyDigit(final String trackingNumber) {
    return trackingNumber.chars().allMatch(Character::isDigit);
  }
}
