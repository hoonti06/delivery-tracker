package me.hoonti06.deliverytracker.step3.trackingnumber;

import java.util.Arrays;
import me.hoonti06.deliverytracker.step3.DeliveryCompanyV3;
import me.hoonti06.deliverytracker.step3.exception.InvalidTrackingNumberExceptionV3;

public class ValidLengthTrackingNumberV3 implements TrackingNumberV3 {

  private final TrackingNumberV3 origin;
  private final int[] validLengthList;

  public ValidLengthTrackingNumberV3(final TrackingNumberV3 origin, final int[] validLengthList) {
    this.origin = origin;
    this.validLengthList = validLengthList;
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
    if (isTrackingNumberLengthWrong(trackingNumber)) {
      throw new InvalidTrackingNumberExceptionV3(
          origin,
          String.format("유효 길이: %s", Arrays.toString(validLengthList))
      );
    }
  }

  private boolean isTrackingNumberLengthWrong(final String trackingNumber) {
    return !isTrackingNumberLengthCorrect(trackingNumber);
  }

  private boolean isTrackingNumberLengthCorrect(final String trackingNumber) {
    return Arrays.stream(validLengthList)
        .anyMatch(i -> i == trackingNumber.length());
  }
}

