package test.com.testapp.ui.test;

import java.util.List;

import test.com.testapp.data.network.model.Post;
import test.com.testapp.ui.base.BaseView;

public interface TestView extends BaseView {

    void onReceivePosts(List<Post> posts);
}
