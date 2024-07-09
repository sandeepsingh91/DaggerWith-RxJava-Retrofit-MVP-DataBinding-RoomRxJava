package test.com.testapp.ui;

import android.app.Application;

public class TestApp extends Application {

    public static TestApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
