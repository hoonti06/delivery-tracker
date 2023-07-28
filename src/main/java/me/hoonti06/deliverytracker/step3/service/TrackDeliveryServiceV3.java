package me.hoonti06.deliverytracker.step3.service;

import me.hoonti06.deliverytracker.step3.DeliveryLastStatusV3;
import me.hoonti06.deliverytracker.step3.UserDeliveryInfoV3;
import me.hoonti06.deliverytracker.step3.deliverytracker.DeliveryTrackerFactoryV3;
import me.hoonti06.deliverytracker.step3.deliverytracker.DeliveryTrackerV3;

public class TrackDeliveryServiceV3 {

  public void trackDelivery(final UserDeliveryInfoV3 userDeliveryInfo) {
    DeliveryTrackerFactoryV3 factory = new DeliveryTrackerFactoryV3(userDeliveryInfo);
    final DeliveryTrackerV3 tracker = factory.create();

    final DeliveryLastStatusV3 lastStatus = tracker.getLastStatus();
  }
}
