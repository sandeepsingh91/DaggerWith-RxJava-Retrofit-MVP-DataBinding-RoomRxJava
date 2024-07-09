package test.com.testapp.ui.base;

import test.com.testapp.ui.test.TestPresenter;
import test.com.testapp.ui.user.UserPresenter;

public interface BasePresenter<T> {

    public void onViewCreated();

    public void onViewDestroyed();

    public TestPresenter getTestPresenter();

    public UserPresenter getUserPresenter();

    public T getView();

}
