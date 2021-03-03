package nick.child_fragment_factories.ui.configurable

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.commit
import nick.child_fragment_factories.R

abstract class FragmentDelegate(
    private val fragmentFactory: FragmentFactory
) : Fragment(R.layout.delegate_fragment) {

    override fun onAttach(context: Context) {
        childFragmentManager.fragmentFactory = fragmentFactory
        super.onAttach(context)
    }

    protected fun replaceFragment(fragmentClass: Class<out Fragment>, args: Bundle? = null) {
        childFragmentManager.commit {
            replace(R.id.container, fragmentClass, null)
        }
    }
}