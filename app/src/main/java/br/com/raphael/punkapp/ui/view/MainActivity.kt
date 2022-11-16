package br.com.raphael.punkapp.ui.view

import br.com.raphael.punkapp.databinding.ActivityMainBinding
import br.com.raphael.punkapp.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate)