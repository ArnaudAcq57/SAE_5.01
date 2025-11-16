package com.example.sae_5_01_frontend.ui.historique

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.sae_5_01_frontend.R
import kotlin.Int

public class HistoriqueFragmentDirections private constructor() {
  private data class ActionNavigationHistoriqueToNavigationDetails(
    public val imageId: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_navigation_historique_to_navigation_details

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("imageId", this.imageId)
        return result
      }
  }

  public companion object {
    public fun actionNavigationHistoriqueToNavigationDetails(imageId: Int): NavDirections =
        ActionNavigationHistoriqueToNavigationDetails(imageId)
  }
}
