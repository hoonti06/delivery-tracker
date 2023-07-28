package me.hoonti06.deliverytracker.step2;

public enum DeliveryCompanyV2 {
  LOTTE_GLOGIS("롯데글로벌로지스");

  private final String nameKr;

  DeliveryCompanyV2(final String nameKr) {
    this.nameKr = nameKr;
  }

  public String getNameKr() {
    return nameKr;
  }
}
