# ☑️ 문제 1. “유저 → 주문 → 주문상품” 전체에서 평균 주문 금액 구하기

## 구조
```java
class User {
    List<Order> orders;
}

class Order {
    List<OrderItem> items;
}

class OrderItem {
    String name;
    int price;
    int count;
}
```

## 요구사항
- 모든 유저의 모든 주문 상품을 `flatMap`으로 펼친다.
- 각 주문 상품별로 `(price * count)` 값을 계산한다.
- 계산된 값 전체로 평균 주문 금액을 구한다.
