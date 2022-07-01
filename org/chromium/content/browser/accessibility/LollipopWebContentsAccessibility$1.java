package org.chromium.content.browser.accessibility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Locale;

final class LollipopWebContentsAccessibility$1 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    LollipopWebContentsAccessibility.access$002(LollipopWebContentsAccessibility.this, Locale.getDefault().toLanguageTag());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\LollipopWebContentsAccessibility$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */