package de.ordersmart.portal.framework.app.di.main.keys

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class MainFragmentKey(val value: KClass<out Fragment>)
