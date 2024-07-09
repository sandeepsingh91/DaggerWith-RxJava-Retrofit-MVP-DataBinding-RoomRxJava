package test.com.testapp.ui.base;

import test.com.testapp.ui.test.TestFragment;
import test.com.testapp.ui.user.UserFragment;

public interface BaseFragment {

    public UserFragment getUserFragment();

    public TestFragment getTestFragment();
}
