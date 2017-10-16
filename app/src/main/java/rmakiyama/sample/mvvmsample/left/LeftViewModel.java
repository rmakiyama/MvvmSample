package rmakiyama.sample.mvvmsample.left;

import android.databinding.ObservableField;

import rmakiyama.sample.mvvmsample.ViewModel;

/**
 * Created by ryo.makiyama on 2017/10/16.
 */

public class LeftViewModel extends ViewModel {

    public final ObservableField<String> description = new ObservableField<>("Leftのフラグメントです");

    public LeftViewModel() {
    }
}
