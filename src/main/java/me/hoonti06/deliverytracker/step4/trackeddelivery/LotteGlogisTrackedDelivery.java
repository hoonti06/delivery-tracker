package me.hoonti06.deliverytracker.step4.trackeddelivery;

import me.hoonti06.deliverytracker.step4.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step4.parseddeliverydocument.ParsedDeliveryDocument;

public class LotteGlogisTrackedDelivery implements TrackedDelivery {

  private final ParsedDeliveryDocument parsedDeliveryDocument;

  public LotteGlogisTrackedDelivery(final ParsedDeliveryDocument parsedDeliveryDocument) {
    this.parsedDeliveryDocument = parsedDeliveryDocument;
  }

  @Override
  public DeliveryLastStatus getLastStatus() {
    return parsedDeliveryDocument.getLastStatus();
  }
}
