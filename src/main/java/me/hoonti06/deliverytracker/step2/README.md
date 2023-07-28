# Step2

## 개선점

- `TrackingNumber` 인터페이스 추가
- 기존에 송장번호 유효성 검증 기능을 담당하는 `LotteGlogisTrackingNumberValidator` 를 `TrackingNumber` 인터페이스 구현체들로 구현
  (Yegor의 https://www.yegor256.com/2015/02/26/composable-decorators.html 를 읽고 감명 받아 데코레이터 패턴으로 작성하게 되었다)
  - `TrackingNumber` 구현체
    - `DefaultTrackingNumber` : 단순 String wrapper
    - `HyphenRemovedTrackingNumber` : 기존 송번장호의 일부를 변환하여 리턴
    - `OnlyDigitTrackingNumber` : 송장번호가 숫자로만 이루어져 있는지 검증
    - `ValidLengthTrackingNumber` : 송장번호의 길이 유효성 검증
  - validator가 가졌던 여러 역할을 분리할 수 있었다

## 문제점

- `LotteGlogisTracker` 클래스에 대한 개선은 아직 진행되지 않았다

