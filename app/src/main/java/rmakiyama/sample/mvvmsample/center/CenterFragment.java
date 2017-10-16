package rmakiyama.sample.mvvmsample.center;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import rmakiyama.sample.mvvmsample.databinding.FragmentCenterBinding;

public class CenterFragment extends Fragment {

    private FragmentCenterBinding binding;

    public static CenterFragment newInstance() {
        return new CenterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCenterBinding.inflate(inflater, container, false);
        binding.text.setText("センターだよ");
        return binding.getRoot();
    }

}
