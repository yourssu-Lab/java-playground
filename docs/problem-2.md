# 🧩 문제 2. “유저 → 게시글 → 댓글”에서 유저별 댓글 수 및 가장 활발한 유저 구하기

## 도메인 구조
```java
class User {
    Long id;
    String name;
    List<Post> posts;
}

class Post {
    Long id;
    String title;
    List<Comment> comments;
}

class Comment {
    Long id;
    Long authorUserId;
    String content;
}
```

## 포인트
- 글을 쓴 유저와 댓글을 단 유저(`authorUserId`)가 다를 수 있다.
- 다른 사용자가 작성한 글에 댓글을 남기는 상황을 고려해야 한다.

## 요구사항
1. 유저별 총 댓글 수 구하기
   - 입력: `List<User> allUsers`
   - 모든 유저의 모든 게시글의 모든 댓글을 대상으로 한다.
   - 각 댓글의 `authorUserId`를 기준으로 “유저별 총 댓글 수”를 `Map<Long, Long>` 형태로 계산한다.
     - `key`: 댓글 작성자의 `authorUserId`
     - `value`: 해당 사용자가 작성한 댓글 수
