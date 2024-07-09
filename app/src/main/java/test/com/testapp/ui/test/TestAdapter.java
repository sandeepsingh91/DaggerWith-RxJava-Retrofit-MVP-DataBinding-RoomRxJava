package test.com.testapp.ui.test;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import test.com.testapp.R;
import test.com.testapp.data.network.model.Post;
import test.com.testapp.databinding.AdapterItemBinding;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.PostViewHolder> {
    List<Post> posts = new ArrayList<>();

    Context context;

    TestAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        AdapterItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_item, parent, false);
        return new PostViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.bind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void updatePosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        private AdapterItemBinding binding;

        public PostViewHolder(AdapterItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        /**
         * Binds a post into the view
         */
        void bind(Post post) {
            binding.setPost(post);
            binding.executePendingBindings();
        }
    }
}
