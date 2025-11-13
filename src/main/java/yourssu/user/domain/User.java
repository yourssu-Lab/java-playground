package yourssu.user.domain;

import java.util.List;
import yourssu.post.domain.Post;

public class User {
    private final Long id;
    private final String name;
    private final List<Post> posts;

    public User(Long id, String name, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
    }
}
