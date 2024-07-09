package test.com.testapp.ui.base;

public interface BaseView {

    void onCreate();

    void onComplete();

    void onError(int stringResID);

    void onError(String errorMessage);
}
