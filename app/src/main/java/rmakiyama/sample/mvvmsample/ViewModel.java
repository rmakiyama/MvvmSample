package rmakiyama.sample.mvvmsample;

/**
 * Created by ryo.makiyama on 2017/10/16.
 */

public abstract class ViewModel {

    public abstract void onResume();

    public abstract void onPause();

    void destroy() {
    }
}
