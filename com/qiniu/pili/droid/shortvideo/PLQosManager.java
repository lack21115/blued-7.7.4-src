package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import com.qiniu.pili.droid.shortvideo.core.QosManager;

public class PLQosManager {
  public static void disableReport(Context paramContext) {
    QosManager.a(paramContext).c();
  }
  
  public static void enableReport(Context paramContext) {
    QosManager.a(paramContext).b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\PLQosManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */