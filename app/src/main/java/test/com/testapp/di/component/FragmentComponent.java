package test.com.testapp.di.component;

import android.support.v4.app.Fragment;

import javax.inject.Singleton;

import dagger.Component;
import test.com.testapp.di.module.FragmentModule;
import test.com.testapp.ui.test.TestFragment;
import test.com.testapp.ui.user.UserFragment;

@Singleton
@Component(modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(TestFragment fragment);

    void inject(UserFragment fragment);


    @Component.Builder
    public interface Builder {
        public FragmentComponent build();

        public Builder fragmentModule(FragmentModule fragmentModule);

    }
}
