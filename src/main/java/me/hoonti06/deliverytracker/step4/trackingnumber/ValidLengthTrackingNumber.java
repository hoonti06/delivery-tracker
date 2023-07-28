package me.hoonti06.deliverytracker.step4.trackingnumber;

import java.util.Arrays;
import me.hoonti06.deliverytracker.step4.exception.InvalidTrackingNumberException;

public class ValidLengthTrackingNumber implements TrackingNumber {

  private final TrackingNumber origin;
  private final int[] validLengthList;

  public ValidLengthTrackingNumber(final TrackingNumber origin, final int[] validLengthList) {
    this.origin = origin;
    this.validLengthList = validLengthList;
  }

  @Override
  public String getNumber() {
    String number = origin.getNumber();
    validate(number);
    return number;
  }

  private void validate(final String trackingNumber) {
    if (isTrackingNumberLengthWrong(trackingNumber)) {
      throw new InvalidTrackingNumberException(
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

