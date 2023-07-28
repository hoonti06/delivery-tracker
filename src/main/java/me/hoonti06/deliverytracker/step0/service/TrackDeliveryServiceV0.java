package me.hoonti06.deliverytracker.step0.service;

import me.hoonti06.deliverytracker.step0.DeliveryLastStatusV0;
import me.hoonti06.deliverytracker.step0.UserDeliveryInfoV0;
import me.hoonti06.deliverytracker.step0.deliverytracker.DeliveryTrackerFactoryV0;
import me.hoonti06.deliverytracker.step0.deliverytracker.DeliveryTrackerV0;

public class TrackDeliveryServiceV0 {

  public void trackDelivery(final UserDeliveryInfoV0 userDeliveryInfo) {
    DeliveryTrackerFactoryV0 factory = new DeliveryTrackerFactoryV0(userDeliveryInfo);
    final DeliveryTrackerV0 tracker = factory.create();
    final DeliveryLastStatusV0 lastStatus = tracker.getLastStatus();
  }
}
