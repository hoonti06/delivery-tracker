# Step1

## 개선점

- `LotteGlogisTrackedDelivery` 클래스에서 ‘송장번호(trackingNumber)의 유효성을 검증하는
  기능’을  `LotteGlogisTrackingNumberValidator` 클래스로 분리
    - 송장번호의 유효성 검증만 테스트할 수 있게 되었다
- `LotteGlogisTrackedDelivery` 클래스에서 ‘HTML 파싱 기능’을 `LotteGlogisParsedDocument` 클래스로 분리
    - 배송완료, 배송중 등 여러 시점의 HTML 파일을 저장해놓고 테스트 코드에 활용한다
    - 항상 테스트 코드가 성공하게 된다

## 문제점

- 아직도 `LotteGlogisTrackedDelivery` 클래스는 테스트할 수 없는 상태이다
- `LotteGlogisTrackingNumberValidator` 의 경우 아직 2가지 역할(길이 검증, 문자 검증)을 가지고 있다