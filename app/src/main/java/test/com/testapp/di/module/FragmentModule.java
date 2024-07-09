package test.com.testapp.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import test.com.testapp.ui.base.BaseView;
import test.com.testapp.ui.test.TestPresenter;
import test.com.testapp.ui.user.UserPresenter;

@Module
public class FragmentModule {

    BaseView view;

    public FragmentModule(BaseView view) {
        this.view = view;
    }

    @Singleton
    @Provides
    public TestPresenter provideTestPresenter() {
        return new TestPresenter(view);
    }

    @Singleton
    @Provides
    public UserPresenter provideUserPresenter() {
        return new UserPresenter(view);
    }


}
