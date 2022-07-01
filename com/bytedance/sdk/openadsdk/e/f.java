package com.bytedance.sdk.openadsdk.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;

public class f {
  private e a;
  
  private a b;
  
  private Context c;
  
  private AudioManager d;
  
  private boolean e = false;
  
  public f(Context paramContext) {
    this.c = paramContext;
    this.d = (AudioManager)paramContext.getApplicationContext().getSystemService("audio");
  }
  
  public void a() {
    try {
      this.b = new a(this);
      IntentFilter intentFilter = new IntentFilter();
      intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
      return;
    } finally {
      Exception exception = null;
      t.a("VolumeChangeObserver", "registerReceiverError: ", exception);
    } 
  }
  
  public void a(e parame) {
    this.a = parame;
  }
  
  public void b() {
    if (this.e)
      try {
        this.c.unregisterReceiver(this.b);
        this.a = null;
        return;
      } finally {
        Exception exception = null;
      }  
  }
  
  public int c() {
    int i = -1;
    try {
      return i;
    } finally {
      Exception exception = null;
      t.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", exception);
    } 
  }
  
  public e d() {
    return this.a;
  }
  
  static class a extends BroadcastReceiver {
    private WeakReference<f> a;
    
    public a(f param1f) {
      this.a = new WeakReference<f>(param1f);
    }
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      try {
        if ("android.media.VOLUME_CHANGED_ACTION".equals(param1Intent.getAction()) && param1Intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
          t.b("VolumeChangeObserver", "媒体音量改变通.......");
          f f = this.a.get();
          if (f != null) {
            e e = f.d();
            if (e != null) {
              int i = f.c();
              if (i >= 0)
                return; 
            } 
          } 
        } 
      } finally {
        param1Context = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\e\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */