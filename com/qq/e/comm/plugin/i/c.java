package com.qq.e.comm.plugin.i;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.comm.pi.DFA;

public final class c implements DFA {
  private IGDTApkListener a;
  
  private b b = new b();
  
  private HandlerThread c;
  
  private Handler d;
  
  public c(IGDTApkListener paramIGDTApkListener) {
    this.a = paramIGDTApkListener;
    this.c = new HandlerThread("GDTApkDelegate");
    this.c.start();
    this.d = new Handler(this, this.c.getLooper(), paramIGDTApkListener) {
        public void handleMessage(Message param1Message) {
          super.handleMessage(param1Message);
          c.a(this.b).a(this.a);
          c.b(this.b).removeCallbacks(null);
        }
      };
  }
  
  public final void loadGDTApk() {
    Handler handler = this.d;
    if (handler != null)
      handler.sendEmptyMessage(0); 
  }
  
  public final void startInstall(Context paramContext, GDTApk paramGDTApk) {
    b b1 = this.b;
    if (b1 != null)
      b1.a(paramContext, paramGDTApk, this.a); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */