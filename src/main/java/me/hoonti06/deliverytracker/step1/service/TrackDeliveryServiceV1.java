package me.hoonti06.deliverytracker.step1.service;

import me.hoonti06.deliverytracker.step1.DeliveryLastStatusV1;
import me.hoonti06.deliverytracker.step1.UserDeliveryInfoV1;
import me.hoonti06.deliverytracker.step1.deliverytracker.DeliveryTrackerFactoryV1;
import me.hoonti06.deliverytracker.step1.deliverytracker.DeliveryTrackerV1;

public class TrackDeliveryServiceV1 {

  public void trackDelivery(final UserDeliveryInfoV1 userDeliveryInfo) {
    DeliveryTrackerFactoryV1 factory = new DeliveryTrackerFactoryV1(userDeliveryInfo);
    final DeliveryTrackerV1 tracker = factory.create();
    final DeliveryLastStatusV1 lastStatus = tracker.getLastStatus();
  }
}
