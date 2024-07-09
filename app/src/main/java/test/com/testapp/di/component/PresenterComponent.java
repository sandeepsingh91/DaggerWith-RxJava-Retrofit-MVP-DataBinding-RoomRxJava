package test.com.testapp.di.component;

import javax.inject.Singleton;

import dagger.Component;
import test.com.testapp.di.module.AppModule;
import test.com.testapp.di.module.NetworkModule;
import test.com.testapp.ui.test.TestPresenter;
import test.com.testapp.ui.user.UserPresenter;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface PresenterComponent {

    void inject(TestPresenter presenter);

    void inject(UserPresenter presenter);

    @Component.Builder
    public interface Builder {
        public PresenterComponent build();

        public Builder networkModule(NetworkModule networkModule);

        public Builder contextModule(AppModule appModule);

    }
}
