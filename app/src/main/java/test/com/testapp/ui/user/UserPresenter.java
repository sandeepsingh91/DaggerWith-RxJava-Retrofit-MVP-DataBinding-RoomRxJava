package test.com.testapp.ui.user;

import android.annotation.SuppressLint;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;
import test.com.testapp.data.db.AppDatabase;
import test.com.testapp.data.db.model.User;
import test.com.testapp.ui.base.BasePresenterImpl;
import test.com.testapp.ui.base.BaseView;

public class UserPresenter extends BasePresenterImpl {


    final Executor executor = Executors.newFixedThreadPool(2);
    @Inject
    AppDatabase db;

    public UserPresenter(BaseView view) {
        super(view);

    }

    public void addUser() {
        User user = new User();

        user.setFirstName("Test");
        user.setLastName("test");

        executor.execute(() -> {
            db.userDao().insertAll(user);
        });
    }


    @SuppressLint("CheckResult")
    public void loadUsers() {

        getView().onCreate();

        db.userDao().getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe((List<User> users) -> {
                    ((UserView) getView()).onReceiveUsers(users);
                    getView().onComplete();
                });
    }

    public void loadUsersById(int[] userIds) {

        getView().onCreate();

        db.userDao().loadAllByIds(userIds)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        getView().onComplete();
                    }
                })
                .subscribe(new DisposableMaybeObserver<List<User>>() {
                    @Override
                    public void onSuccess(List<User> users) {
                        // if return 0 row goes here
                        // if data found goes here
                        ((UserView) getView()).onReceiveUsers(users);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("UserPresenter.onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("UserPresenter.onComplete");
                    }
                });

    }

    public void findByName(String first, String last) {

        getView().onCreate();

        db.userDao().findByName(first, last)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        getView().onComplete();
                    }
                })
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // This called everytime
                        getView().onCreate();
                    }

                    @Override
                    public void onSuccess(User user) {
                        // if data found goes here
                        ((UserView) getView()).onReceiveUser(user);
                    }


                    @Override
                    public void onError(Throwable e) {
                        // if no data found goes here
                        ((UserView) getView()).onReceiveUser(null);
                    }
                });
    }

    @Override
    public UserPresenter getUserPresenter() {
        return this;
    }

    @Override
    public void onViewCreated() {

    }

    @Override
    public void onViewDestroyed() {

    }

}
