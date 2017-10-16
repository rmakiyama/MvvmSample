package rmakiyama.sample.mvvmsample.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import rmakiyama.sample.mvvmsample.R;
import rmakiyama.sample.mvvmsample.center.CenterFragment;
import rmakiyama.sample.mvvmsample.databinding.ActivityMainBinding;
import rmakiyama.sample.mvvmsample.left.LeftFragment;
import rmakiyama.sample.mvvmsample.right.RightFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initView();
    }

    private void initView() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, LeftFragment.newInstance()).commit();
        binding.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                final FragmentManager manager = getSupportFragmentManager();
                switch (item.getItemId()) {
                    case R.id.left:
                        manager.beginTransaction()
                                .replace(R.id.container, LeftFragment.newInstance())
                                .commit();
                        return true;
                    case R.id.center:
                        manager.beginTransaction()
                                .replace(R.id.container, CenterFragment.newInstance())
                                .commit();
                        return true;
                    case R.id.right:
                        manager.beginTransaction()
                                .replace(R.id.container, RightFragment.newInstance())
                                .commit();
                        return true;
                }
                return false;
            }
        });
    }

}
