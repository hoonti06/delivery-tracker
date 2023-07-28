package me.hoonti06.deliverytracker.step4.deliverycompanyconnection;

import org.jsoup.nodes.Document;

public class FakeDeliveryCompanyConnection implements DeliveryCompanyConnection {
    private final Document document;

    public FakeDeliveryCompanyConnection(final Document document) {
        this.document = document;
    }

    @Override
    public Document getDocument() {
        return document;
    }
}
