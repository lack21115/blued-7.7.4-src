package org.chromium.content.browser.selection;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import org.chromium.base.ThreadUtils;

final class LGEmailActionModeWorkaroundImpl$2 extends AnimatorListenerAdapter {
  public final void onAnimationEnd(Animator paramAnimator) {
    ThreadUtils.postOnUiThread(new LGEmailActionModeWorkaroundImpl$2$1(this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\LGEmailActionModeWorkaroundImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */