package com.sgk.profile.presentation

import androidx.lifecycle.ViewModel
import com.sgk.profile.domain.use_case.GetProfilePageData
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
     val getProfilePageData: GetProfilePageData,
     val moshi: Moshi
): ViewModel(){



}