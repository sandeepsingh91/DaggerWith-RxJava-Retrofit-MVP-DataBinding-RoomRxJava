package test.com.testapp.data.network.model;

public class Post {

    public Integer id;
    public String title;
    public String body;
    private Integer userId;

    public Post(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
