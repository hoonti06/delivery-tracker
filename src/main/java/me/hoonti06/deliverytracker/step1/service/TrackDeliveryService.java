package me.hoonti06.deliverytracker.step1.service;

import me.hoonti06.deliverytracker.step1.DeliveryLastStatus;
import me.hoonti06.deliverytracker.step1.UserDeliveryInfo;
import me.hoonti06.deliverytracker.step1.trackeddelivery.TrackedDelivery;
import me.hoonti06.deliverytracker.step1.trackeddelivery.TrackedDeliveryFactory;

public class TrackDeliveryService {

  public void trackDelivery(final UserDeliveryInfo userDeliveryInfo) {
    TrackedDeliveryFactory factory = new TrackedDeliveryFactory(userDeliveryInfo);
    final TrackedDelivery trackedDelivery = factory.create();
    final DeliveryLastStatus lastStatus = trackedDelivery.getLastStatus();
  }
}
