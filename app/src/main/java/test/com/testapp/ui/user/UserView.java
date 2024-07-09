package test.com.testapp.ui.user;

import java.util.List;

import test.com.testapp.data.db.model.User;
import test.com.testapp.ui.base.BaseView;

public interface UserView extends BaseView {

    void onReceiveUsers(List<User> users);

    void onReceiveUser(User user);
}
