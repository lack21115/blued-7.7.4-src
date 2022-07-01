package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

final class zabb extends zap {
  zabb(zaaz paramzaaz, Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    StringBuilder stringBuilder;
    int i = paramMessage.what;
    if (i != 1) {
      if (i != 2) {
        i = paramMessage.what;
        stringBuilder = new StringBuilder(31);
        stringBuilder.append("Unknown message id: ");
        stringBuilder.append(i);
        Log.w("GACStateManager", stringBuilder.toString());
        return;
      } 
      throw (RuntimeException)stringBuilder.obj;
    } 
    ((zaay)((Message)stringBuilder).obj).zaa(this.zaa);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zabb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */