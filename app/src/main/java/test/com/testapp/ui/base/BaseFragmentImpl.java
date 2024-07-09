package test.com.testapp.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.com.testapp.di.component.DaggerFragmentComponent;
import test.com.testapp.di.component.FragmentComponent;
import test.com.testapp.di.module.FragmentModule;
import test.com.testapp.ui.test.TestFragment;
import test.com.testapp.ui.user.UserFragment;

public abstract class BaseFragmentImpl extends Fragment implements BaseFragment, BaseView {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentComponent component = DaggerFragmentComponent
                .builder()
                .fragmentModule(new FragmentModule(this))
                .build();

        if (this instanceof UserFragment) {
            component.inject(this.getUserFragment());
        } else if (this instanceof TestFragment) {
            component.inject(this.getTestFragment());
        }
    }

    @Override
    public UserFragment getUserFragment() {
        return null;
    }

    @Override
    public TestFragment getTestFragment() {
        return null;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
