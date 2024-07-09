package test.com.testapp.ui.test;

import android.content.SharedPreferences;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import test.com.testapp.data.network.PostApi;
import test.com.testapp.data.network.model.Post;
import test.com.testapp.ui.base.BasePresenterImpl;
import test.com.testapp.ui.base.BaseView;

public class TestPresenter extends BasePresenterImpl {

    @Inject
    PostApi postApi;

    @Inject
    SharedPreferences sharedPreferences;


    public TestPresenter(BaseView testView) {
        super(testView);

        boolean test = sharedPreferences.getBoolean("test", false);
        System.out.println("TestPresenter.TestPresenter : " + test);
    }

    public void loadPosts() {

        getView().onCreate();

        postApi.getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        getView().onComplete();
                    }
                })
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        ((TestView) getView()).onReceivePosts(posts);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onError("unknown_error");
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override
    public TestPresenter getTestPresenter() {
        return this;
    }

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onViewDestroyed() {

    }
}
