package rmakiyama.sample.mvvmsample.left;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rmakiyama.sample.mvvmsample.databinding.FragmentLeftBinding;

public class LeftFragment extends Fragment {

    private FragmentLeftBinding binding;

    public static LeftFragment newInstance() {
        return new LeftFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeftBinding.inflate(inflater, container, false);
        binding.setViewModel(new LeftViewModel());
        binding.title.setText("Left");
        return binding.getRoot();
    }

}
