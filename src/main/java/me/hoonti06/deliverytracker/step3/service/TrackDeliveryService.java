package me.hoonti06.deliverytracker.step3.service;

import me.hoonti06.deliverytracker.step3.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step3.UserDeliveryInfo;
import me.hoonti06.deliverytracker.step3.trackeddelivery.TrackedDeliveryFactory;
import me.hoonti06.deliverytracker.step3.trackeddelivery.TrackedDelivery;

public class TrackDeliveryService {

  public void trackDelivery(final UserDeliveryInfo userDeliveryInfo) {
    TrackedDeliveryFactory factory = new TrackedDeliveryFactory(userDeliveryInfo);
    final TrackedDelivery trackedDelivery = factory.create();

    final DeliveryLastStatus lastStatus = trackedDelivery.getLastStatus();
  }
}
