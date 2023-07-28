package me.hoonti06.deliverytracker.step1.trackeddelivery;

import java.util.Arrays;
import me.hoonti06.deliverytracker.step1.exception.InvalidTrackingNumberException;

public class LotteGlogisTrackingNumberValidator {

  private static final int[] VALID_TRACKING_NUMBER_LENGTH_LIST = {12};
  private final String trackingNumber;

  public LotteGlogisTrackingNumberValidator(final String trackingNumber) {
    this.trackingNumber = trackingNumber;
  }

  public void validate() {
    if (hasNotDigitCharacter()) {
      throw new InvalidTrackingNumberException(trackingNumber, "숫자가 아닌 문자 존재");
    }

    if (isTrackingNumberLengthWrong()) {
      throw new InvalidTrackingNumberException(trackingNumber, "잘못된 송장번호");
    }
  }

  private boolean hasNotDigitCharacter() {
    return !hasOnlyDigit();
  }

  private boolean hasOnlyDigit() {
    return trackingNumber.chars().allMatch(Character::isDigit);
  }

  private boolean isTrackingNumberLengthWrong() {
    return !isTrackingNumberLengthCorrect();
  }

  private boolean isTrackingNumberLengthCorrect() {
    return Arrays.stream(VALID_TRACKING_NUMBER_LENGTH_LIST)
        .anyMatch(i -> i == trackingNumber.length());
  }

}
