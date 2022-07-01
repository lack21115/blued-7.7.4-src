package org.chromium.content.browser;

import android.view.ViewGroup;

final class TapDisambiguator$1 implements PopupZoomer$OnVisibilityChangedListener {
  public final void onPopupZoomerHidden(PopupZoomer paramPopupZoomer) {
    containerView.post(new TapDisambiguator$1$2(this, paramPopupZoomer));
  }
  
  public final void onPopupZoomerShown(PopupZoomer paramPopupZoomer) {
    containerView.post(new TapDisambiguator$1$1(this, paramPopupZoomer));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\TapDisambiguator$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */