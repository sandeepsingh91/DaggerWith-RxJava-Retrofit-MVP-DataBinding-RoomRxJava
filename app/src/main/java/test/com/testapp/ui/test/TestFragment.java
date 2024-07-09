package test.com.testapp.ui.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import test.com.testapp.R;
import test.com.testapp.data.network.model.Post;
import test.com.testapp.databinding.FragmentTestBinding;
import test.com.testapp.ui.base.BaseFragmentImpl;

public class TestFragment extends BaseFragmentImpl implements TestView {

    FragmentTestBinding binding;

    TestAdapter adapter;

    @Inject
    TestPresenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public TestFragment getTestFragment() {
        return this;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // presenter.onViewDestoryed();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        adapter = new TestAdapter(getContext());

        binding.setAdapter(adapter);
        binding.setLayoutManager(new LinearLayoutManager(getContext()));

        presenter.loadPosts();

    }


    @Override
    public void onReceivePosts(List<Post> posts) {

        System.out.println("TestFragment.updatePosts");
        adapter.updatePosts(posts);
    }

    @Override
    public void onCreate() {
        binding.setProgressVisibility(View.GONE);

    }

    @Override
    public void onComplete() {
        binding.setProgressVisibility(View.GONE);
    }

    @Override
    public void onError(int stringResID) {
        Toast.makeText(getContext(), getString(stringResID), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_LONG).show();
    }
}
