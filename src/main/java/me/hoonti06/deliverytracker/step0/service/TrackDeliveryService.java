package me.hoonti06.deliverytracker.step0.service;

import me.hoonti06.deliverytracker.step0.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step0.UserDeliveryInfo;
import me.hoonti06.deliverytracker.step0.trackeddelivery.TrackedDelivery;
import me.hoonti06.deliverytracker.step0.trackeddelivery.TrackedDeliveryFactory;

public class TrackDeliveryService {

  public void trackDelivery(final UserDeliveryInfo userDeliveryInfo) {
    TrackedDeliveryFactory factory = new TrackedDeliveryFactory(userDeliveryInfo);
    final TrackedDelivery trackedDelivery = factory.create();
    final DeliveryLastStatus lastStatus = trackedDelivery.getLastStatus();
  }
}
