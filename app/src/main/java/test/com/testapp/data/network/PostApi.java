package test.com.testapp.data.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import test.com.testapp.data.network.model.Post;

public interface PostApi {

    @GET("/posts")
    Observable<List<Post>> getPosts();
}