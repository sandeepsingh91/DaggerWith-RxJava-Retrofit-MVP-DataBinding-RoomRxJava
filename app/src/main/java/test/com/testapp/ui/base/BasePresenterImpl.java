package test.com.testapp.ui.base;

import test.com.testapp.di.component.DaggerPresenterComponent;
import test.com.testapp.di.component.PresenterComponent;
import test.com.testapp.di.module.AppModule;
import test.com.testapp.di.module.NetworkModule;
import test.com.testapp.ui.TestApp;
import test.com.testapp.ui.test.TestPresenter;
import test.com.testapp.ui.user.UserPresenter;

public abstract class BasePresenterImpl implements BasePresenter {

    private BaseView view;

    public BasePresenterImpl(BaseView view) {

        this.view = view;

        PresenterComponent component = DaggerPresenterComponent
                .builder()
                .contextModule(new AppModule(TestApp.app))
                .networkModule(new NetworkModule())
                .build();

        if (this instanceof TestPresenter) {
            component.inject(this.getTestPresenter());
        } else if (this instanceof UserPresenter) {
            component.inject(this.getUserPresenter());
        }
    }

    @Override
    public UserPresenter getUserPresenter() {
        return null;
    }

    @Override
    public TestPresenter getTestPresenter() {
        return null;
    }

    @Override
    public final BaseView getView() {
        return view;
    }
}
