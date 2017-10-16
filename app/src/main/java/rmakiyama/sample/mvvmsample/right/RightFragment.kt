package rmakiyama.sample.mvvmsample.right

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import rmakiyama.sample.mvvmsample.databinding.FragmentRightBinding

class RightFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance(): RightFragment = RightFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return FragmentRightBinding.inflate(inflater, container, false)
                .apply { text.text = "右だよ" }.root
    }

}
