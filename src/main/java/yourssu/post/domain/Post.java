package yourssu.post.domain;

import java.util.List;
import yourssu.comment.domain.Comment;

public class Post {
    private final Long id;
    private final String title;
    private final List<Comment> comments;

    public Post(Long id, String title, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.comments = comments;
    }
}
