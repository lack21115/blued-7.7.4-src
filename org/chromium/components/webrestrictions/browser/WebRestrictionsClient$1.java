package org.chromium.components.webrestrictions.browser;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

final class WebRestrictionsClient$1 extends ContentObserver {
  WebRestrictionsClient$1(Handler paramHandler) {
    super(paramHandler);
  }
  
  public final void onChange(boolean paramBoolean) {
    onChange(paramBoolean, null);
  }
  
  public final void onChange(boolean paramBoolean, Uri paramUri) {
    WebRestrictionsClient.this.nativeOnWebRestrictionsChanged(nativeProvider);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\webrestrictions\browser\WebRestrictionsClient$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */