package com.fr.djibril.listusermvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fr.djibril.listusermvvm.ui.user.ListUserViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListUserViewModel::class)
    internal abstract fun listUserViewModel(listUserViewModel: ListUserViewModel): ViewModel
}
