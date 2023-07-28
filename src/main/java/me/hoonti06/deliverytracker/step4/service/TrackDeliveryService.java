package me.hoonti06.deliverytracker.step4.service;

import me.hoonti06.deliverytracker.step4.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step4.UserDeliveryInfo;
import me.hoonti06.deliverytracker.step4.trackeddelivery.TrackedDelivery;
import me.hoonti06.deliverytracker.step4.trackeddelivery.TrackedDeliveryFactory;

public class TrackDeliveryService {

  public void trackDelivery(final UserDeliveryInfo userDeliveryInfo) {
    TrackedDeliveryFactory factory = new TrackedDeliveryFactory(userDeliveryInfo);
    final TrackedDelivery trackedDelivery = factory.create();

    final DeliveryLastStatus lastStatus = trackedDelivery.getLastStatus();
  }
}
