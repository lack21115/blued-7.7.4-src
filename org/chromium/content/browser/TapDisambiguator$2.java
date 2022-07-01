package org.chromium.content.browser;

import android.view.ViewGroup;

final class TapDisambiguator$2 implements PopupZoomer$OnTapListener {
  public final void onResolveTapDisambiguation(long paramLong, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (TapDisambiguator.access$100(TapDisambiguator.this) == 0L)
      return; 
    containerView.requestFocus();
    TapDisambiguator.access$200(TapDisambiguator.this, TapDisambiguator.access$100(TapDisambiguator.this), paramLong, paramFloat1, paramFloat2, paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\TapDisambiguator$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */