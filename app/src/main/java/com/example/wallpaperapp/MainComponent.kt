package com.example.wallpaperapp

import dagger.Component

@Component(modules = [NetworkModule::class])
interface MainComponent {

    fun inject(mainActivity: MainActivity)
}