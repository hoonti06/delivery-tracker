package me.hoonti06.deliverytracker.step4.parseddeliverydocument;

import me.hoonti06.deliverytracker.step4.DeliveryLastStatus;

public class FakeParsedDeliveryDocument implements ParsedDeliveryDocument {
    private final DeliveryLastStatus deliveryLastStatus;

    public FakeParsedDeliveryDocument(final DeliveryLastStatus deliveryLastStatus) {
        this.deliveryLastStatus = deliveryLastStatus;
    }

    @Override
    public DeliveryLastStatus getLastStatus() {
        return deliveryLastStatus;
    }
}
