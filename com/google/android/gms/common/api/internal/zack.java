package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

final class zack extends zap {
  public zack(zaci paramzaci, Looper paramLooper) {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage) {
    String str;
    int i = paramMessage.what;
    if (i != 0) {
      StringBuilder stringBuilder;
      if (i != 1) {
        i = paramMessage.what;
        stringBuilder = new StringBuilder(70);
        stringBuilder.append("TransformationResultHandler received unknown message type: ");
        stringBuilder.append(i);
        Log.e("TransformedResultImpl", stringBuilder.toString());
        return;
      } 
      RuntimeException runtimeException = (RuntimeException)((Message)stringBuilder).obj;
      str = String.valueOf(runtimeException.getMessage());
      if (str.length() != 0) {
        str = "Runtime exception on the transformation worker thread: ".concat(str);
      } else {
        str = new String("Runtime exception on the transformation worker thread: ");
      } 
      Log.e("TransformedResultImpl", str);
      throw runtimeException;
    } 
    null = (PendingResult)((Message)str).obj;
    synchronized (zaci.zad(this.zaa)) {
      zaci zaci1 = (zaci)Preconditions.checkNotNull(zaci.zae(this.zaa));
      if (null == null) {
        zaci.zaa(zaci1, new Status(13, "Transform returned null"));
      } else if (null instanceof zaca) {
        zaci.zaa(zaci1, ((zaca)null).zaa());
      } else {
        zaci1.zaa(null);
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */