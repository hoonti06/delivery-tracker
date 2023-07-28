package me.hoonti06.deliverytracker.step3;

public enum DeliveryCompanyV3 {
  LOTTE_GLOGIS("롯데글로벌로지스");

  private final String nameKr;

  DeliveryCompanyV3(final String nameKr) {
    this.nameKr = nameKr;
  }

  public String getNameKr() {
    return nameKr;
  }
}
