# Step3

## 개선점

- `Connection`을 `LotteGlogisTracker` 클래스의 인스턴스 변수로 갖게 된다
    - Connection을 주입 받을 수 있게 되었다
    - FakeConnection과 FakeResponse를 구현하여 `LotteGlogisTracker` 를 테스트할 때 직접 실제 URL에 접속하여 HTML을 받아오지 않아도 되었다
- `LotteGlogisTracker` 클래스에서 주 Ctor와 부 Ctor로 구성했다
    - Yegor의 https://www.yegor256.com/2015/05/28/one-primary-constructor.html 참고