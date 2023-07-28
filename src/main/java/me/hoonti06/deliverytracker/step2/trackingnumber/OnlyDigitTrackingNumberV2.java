package me.hoonti06.deliverytracker.step2.trackingnumber;

import me.hoonti06.deliverytracker.step2.DeliveryCompanyV2;
import me.hoonti06.deliverytracker.step2.exception.InvalidTrackingNumberExceptionV2;

public class OnlyDigitTrackingNumberV2 implements TrackingNumberV2 {

  private final TrackingNumberV2 origin;

  public OnlyDigitTrackingNumberV2(final TrackingNumberV2 origin) {
    this.origin = origin;
  }

  @Override
  public String getNumber() {
    String number = origin.getNumber();
    validate(number);
    return number;
  }

  @Override
  public DeliveryCompanyV2 getDeliveryCompany() {
    return origin.getDeliveryCompany();
  }

  private void validate(final String trackingNumber) {
    if (hasNotDigitCharacter(trackingNumber)) {
      throw new InvalidTrackingNumberExceptionV2(origin, "숫자가 아닌 문자 존재");
    }
  }

  private boolean hasNotDigitCharacter(final String trackingNumber) {
    return !hasOnlyDigit(trackingNumber);
  }

  private boolean hasOnlyDigit(final String trackingNumber) {
    return trackingNumber.chars().allMatch(Character::isDigit);
  }
}
