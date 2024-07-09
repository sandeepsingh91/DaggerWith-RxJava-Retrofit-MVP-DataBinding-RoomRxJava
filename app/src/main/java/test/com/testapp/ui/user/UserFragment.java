package test.com.testapp.ui.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import test.com.testapp.R;
import test.com.testapp.data.db.model.User;
import test.com.testapp.databinding.FragmentUserBinding;
import test.com.testapp.ui.base.BaseFragmentImpl;

public class UserFragment extends BaseFragmentImpl implements UserView {

    FragmentUserBinding binding;

    @Inject
    UserPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
        return binding.getRoot();

    }

    @Override
    public UserFragment getUserFragment() {
        return this;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addUser();
            }
        });


        binding.loadUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadUsers();
            }
        });

        binding.loadUserId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadUsersById(new int[]{1, 2});
            }
        });

        binding.loadUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.findByName("test", "test");
            }
        });
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(int stringResID) {

    }

    @Override
    public void onError(String errorMessage) {

    }

    @Override
    public void onReceiveUsers(List<User> users) {

    }

    @Override
    public void onReceiveUser(User user) {

    }
}