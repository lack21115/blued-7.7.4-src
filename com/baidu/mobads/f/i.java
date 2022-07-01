package com.baidu.mobads.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.utils.IXAdLogger;

class i extends Handler {
  i(g paramg, Looper paramLooper) {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage) {
    IXAdLogger iXAdLogger;
    String str = paramMessage.getData().getString("CODE");
    e e = (e)paramMessage.getData().getParcelable("APK_INFO");
    if ("OK".equals(str)) {
      b b = new b(e.e(), g.a(this.a), e);
      try {
        if (this.a.g == g.f) {
          b.a();
          b.a(g.f());
          if (g.b != null)
            g.b.a = e.b(); 
          g.b(this.a);
          if (g.c(this.a)) {
            g.a(this.a, false);
            g.a(this.a, g.d(this.a), "load remote file just downloaded");
          } 
        } else {
          g.a(this.a, b);
          g g1 = this.a;
          b.a(g.f());
          g.b(this.a, true);
        } 
      } catch (a a) {
      
      } finally {}
    } else {
      iXAdLogger = g.e(this.a);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mOnApkDownloadCompleted: download failed, code: ");
      stringBuilder.append(str);
      iXAdLogger.d("XAdApkLoader", stringBuilder.toString());
      g.b(this.a, false);
      if (g.c(this.a)) {
        g.a(this.a, false);
        g.a(this.a, false, "Refused to download remote for version...");
      } 
      return;
    } 
    iXAdLogger.delete();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */