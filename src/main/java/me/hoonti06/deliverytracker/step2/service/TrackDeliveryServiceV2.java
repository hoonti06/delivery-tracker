package me.hoonti06.deliverytracker.step2.service;

import me.hoonti06.deliverytracker.step2.DeliveryLastStatusV2;
import me.hoonti06.deliverytracker.step2.UserDeliveryInfoV2;
import me.hoonti06.deliverytracker.step2.deilverytracker.DeliveryTrackerFactoryV2;
import me.hoonti06.deliverytracker.step2.deilverytracker.DeliveryTrackerV2;

public class TrackDeliveryServiceV2 {

  public void trackDelivery(final UserDeliveryInfoV2 userDeliveryInfo) {
    DeliveryTrackerFactoryV2 factory = new DeliveryTrackerFactoryV2(userDeliveryInfo);
    final DeliveryTrackerV2 tracker = factory.create();

    final DeliveryLastStatusV2 lastStatus = tracker.getLastStatus();
  }
}
