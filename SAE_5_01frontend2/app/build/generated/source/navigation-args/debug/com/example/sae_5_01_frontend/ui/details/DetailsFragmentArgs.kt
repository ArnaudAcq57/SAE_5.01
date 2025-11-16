package com.example.sae_5_01_frontend.ui.details

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class DetailsFragmentArgs(
  public val imageId: Int,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("imageId", this.imageId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("imageId", this.imageId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailsFragmentArgs {
      bundle.setClassLoader(DetailsFragmentArgs::class.java.classLoader)
      val __imageId : Int
      if (bundle.containsKey("imageId")) {
        __imageId = bundle.getInt("imageId")
      } else {
        throw IllegalArgumentException("Required argument \"imageId\" is missing and does not have an android:defaultValue")
      }
      return DetailsFragmentArgs(__imageId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailsFragmentArgs {
      val __imageId : Int?
      if (savedStateHandle.contains("imageId")) {
        __imageId = savedStateHandle["imageId"]
        if (__imageId == null) {
          throw IllegalArgumentException("Argument \"imageId\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"imageId\" is missing and does not have an android:defaultValue")
      }
      return DetailsFragmentArgs(__imageId)
    }
  }
}
