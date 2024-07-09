package test.com.testapp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.TestSubscriber;
import test.com.testapp.data.network.PostApi;
import test.com.testapp.data.network.model.Post;
import test.com.testapp.ui.test.TestPresenter;
import test.com.testapp.ui.test.TestView;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    @Mock
    TestView testView;

    @Mock
    TestPresenter mPresenter;

    @Mock
    PostApi mPostApi;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mPresenter = new TestPresenter(testView);


        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void fetchData() {

        List<Post> post = new ArrayList<>();
        Post p = new Post(0, 0, "String title", "String body");
        post.add(p);

       // TestSubscriber<List<Post>> subscriber = new TestSubscriber<>();
      //  when(mPostApi.getPosts()).thenReturn(Observable.just(post));
        mPresenter.loadPosts();
        InOrder inOrder = Mockito.inOrder(testView);

       // inOrder.verify(testView, times(1)).showLoading();
        inOrder.verify(testView, times(1)).updatePosts(post);
      //  inOrder.verify(testView, times(1)).hideLoading();
    }
}