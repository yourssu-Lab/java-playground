package yourssu.comment.domain;

public class Comment {
    private final Long id;
    private final Long authorUserId;
    private final String content;

    public Comment(Long id, Long authorUserId, String content) {
        this.id = id;
        this.authorUserId = authorUserId;
        this.content = content;
    }
}
