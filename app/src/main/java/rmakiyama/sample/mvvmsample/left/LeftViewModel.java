package rmakiyama.sample.mvvmsample.left;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import rmakiyama.sample.mvvmsample.ViewModel;

/**
 * Created by ryo.makiyama on 2017/10/16.
 */

public class LeftViewModel extends ViewModel {

    public final ObservableField<String> description = new ObservableField<>("Leftのフラグメントです");
    public final ObservableInt number = new ObservableInt(0);
    public final ObservableField<String> input = new ObservableField<>();

    public LeftViewModel() {
    }

    public void onClickAdd(@SuppressWarnings("unused") View view) {
        number.set(number.get() + 1);
    }

    public void onClickClear(@SuppressWarnings("unused") View view) {
        input.set("");
    }
}
