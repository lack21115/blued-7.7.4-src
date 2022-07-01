package org.chromium.policy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class AbstractAppRestrictionsProvider$1 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    AbstractAppRestrictionsProvider.this.refresh();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\policy\AbstractAppRestrictionsProvider$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */