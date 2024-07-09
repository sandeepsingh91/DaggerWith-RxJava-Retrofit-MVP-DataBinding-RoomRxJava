package test.com.testapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import test.com.testapp.ui.user.UserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swapFragment(new UserFragment(), "TestFragment", true);
    }

    private void swapFragment(final Fragment newFragment, final String tag, final Boolean addToStack) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


                    transaction.replace(R.id.container, newFragment, tag);

                    if (addToStack) {
                        transaction.addToBackStack(null);
                    }

                    transaction.commitAllowingStateLoss();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        new Handler().postDelayed(runnable, 1);
    }
}
