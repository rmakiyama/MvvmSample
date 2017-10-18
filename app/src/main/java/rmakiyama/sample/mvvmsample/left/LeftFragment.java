package rmakiyama.sample.mvvmsample.left;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import rmakiyama.sample.mvvmsample.databinding.FragmentLeftBinding;

public class LeftFragment extends Fragment implements LeftNavigator {

    private FragmentLeftBinding binding;

    public static LeftFragment newInstance() {
        return new LeftFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeftBinding.inflate(inflater, container, false);
        binding.setViewModel(new LeftViewModel(this));
        binding.title.setText("Left");
        return binding.getRoot();
    }

    @Override
    public void showDialog(@NotNull String message) {
        new AlertDialog.Builder(getContext())
                .setMessage(message)
                .show();
    }
}
