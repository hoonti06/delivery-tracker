package me.hoonti06.deliverytracker.step2.trackingnumber;

import java.util.Arrays;
import me.hoonti06.deliverytracker.step2.DeliveryCompanyV2;
import me.hoonti06.deliverytracker.step2.exception.InvalidTrackingNumberExceptionV2;

public class ValidLengthTrackingNumberV2 implements TrackingNumberV2 {

  private final TrackingNumberV2 origin;
  private final int[] validLengthList;

  public ValidLengthTrackingNumberV2(final TrackingNumberV2 origin, final int[] validLengthList) {
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
  public DeliveryCompanyV2 getDeliveryCompany() {
    return origin.getDeliveryCompany();
  }

  private void validate(final String trackingNumber) {
    if (isTrackingNumberLengthWrong(trackingNumber)) {
      throw new InvalidTrackingNumberExceptionV2(
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

