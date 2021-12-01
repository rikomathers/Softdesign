package com.example.tz.framework

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject
import javax.inject.Singleton

@InternalCoroutinesApi
@Singleton
class MainNavHostFragment : NavHostFragment() {

    private val TAG: String = "MainNavHostFragment"

    var mainNavController: MainNavController? = null
        get() {
            if (field == null) {
                Log.d("TAG","NavController is NULL")
            }
            return field
        }

    @Inject
    lateinit var mainFragmentFactory: MainFragmentFactory

    override fun onAttach(context: Context) {
        ((activity?.application) as BaseApplication)
            .appComponent
            .mainComponent()
            .create()
            .inject(this)

        childFragmentManager.fragmentFactory = mainFragmentFactory
        try {
            mainNavController = context as MainNavController
        } catch (e: ClassCastException) {
            Log.d("TAG","$context must implement MainNavController")
        }
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainNavController?.setNavController(this.navController)
    }

    companion object {

        const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"

        @JvmStatic
        fun create(
            @NavigationRes graphId: Int = 0
        ): MainNavHostFragment {
            var bundle: Bundle? = null
            if (graphId != 0) {
                bundle = Bundle()
                bundle.putInt(KEY_GRAPH_ID, graphId)
            }
            val result = MainNavHostFragment()
            if (bundle != null) {
                result.arguments = bundle
            }
            return result
        }
    }
}