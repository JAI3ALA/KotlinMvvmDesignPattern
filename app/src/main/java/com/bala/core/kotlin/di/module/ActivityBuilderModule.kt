package com.bala.core.kotlin.di.module

import com.bala.core.kotlin.view.activity.bala.TodoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Define all your activities here
 */

@Module(includes = [FragmentBuilderModule::class])
interface ActivityBuilderModule {

    @ContributesAndroidInjector
    fun contributeTodoActivity(): TodoActivity
}