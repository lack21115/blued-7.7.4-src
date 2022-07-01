package a.a.a.a.a.k.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;

public final class d {
  public static Context a;
  
  public f b;
  
  public Object c = new Object();
  
  public boolean d = false;
  
  public BroadcastReceiver e = new a(this);
  
  public BroadcastReceiver f = new b(this);
  
  public d() {}
  
  public static d a() {
    return c.a;
  }
  
  public void a(Context paramContext) {
    synchronized (this.c) {
      if (this.d || paramContext == null)
        return; 
      a = paramContext.getApplicationContext();
      f f1 = new f();
      this.b = f1;
      f1.a(paramContext);
      a.a.a.a.a.k.a.a().a(this.e, new IntentFilter("pldroid-qos-filter"));
      a.registerReceiver(this.f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      this.d = true;
      return;
    } 
  }
  
  public final boolean a(Intent paramIntent) {
    int i = paramIntent.getIntExtra("pldroid-qos-msg-type", -1);
    if (i != 4) {
      switch (i) {
        default:
          return true;
        case 164:
          this.b.b(paramIntent);
        case 163:
          this.b.a(paramIntent);
        case 162:
          this.b.f();
        case 161:
          break;
      } 
      b(paramIntent);
    } 
    this.b.d().a(paramIntent.getStringExtra("scheme"), paramIntent.getStringExtra("domain"), paramIntent.getStringExtra("remoteIp"), paramIntent.getStringExtra("path"), paramIntent.getStringExtra("reqid"));
    this.b.f();
    a.a.a.a.a.k.c.a.f();
  }
  
  public void b(Context paramContext) {
    synchronized (this.c) {
      if (a == null || !this.d)
        return; 
      a.unregisterReceiver(this.f);
      a = null;
      a.a.a.a.a.k.a.a().a(this.e);
      this.b.c();
      this.d = false;
      return;
    } 
  }
  
  public final void b(Intent paramIntent) {
    int i;
    long l1 = paramIntent.getLongExtra("beginAt", 0L);
    long l2 = paramIntent.getLongExtra("endAt", 0L);
    int k = paramIntent.getIntExtra("videoSourceFps", 0);
    int n = (int)paramIntent.getLongExtra("dropVideoFrameNum", 0L);
    int m = paramIntent.getIntExtra("audioSourceFps", 0);
    int j = (int)paramIntent.getLongExtra("dropAudioFrameNum", 0L);
    int i1 = (int)(l2 - l1);
    if (i1 == 0) {
      i = k;
    } else {
      i = k - n * 1000 / i1;
    } 
    if (i1 == 0) {
      j = m;
    } else {
      j = m - j * 1000 / i1;
    } 
    i1 = paramIntent.getIntExtra("sentVideoFps", 0);
    int i2 = (int)paramIntent.getLongExtra("video_buffer_dropped_frames", 0L);
    int i3 = paramIntent.getIntExtra("sentAudioFps", 0);
    long l3 = paramIntent.getIntExtra("audioBitrate", 0);
    long l4 = paramIntent.getIntExtra("videoBitrate", 0);
    int i4 = paramIntent.getIntExtra("videoFilterTime", 0);
    this.b.g().a(l1, l2, k, n, m, i, j, i1, i2, i3, l3, l4, i4);
    this.b.h();
  }
  
  public class a extends BroadcastReceiver {
    public a(d this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if (!"pldroid-qos-filter".equals(param1Intent.getAction()))
        return; 
      d.a(this.a, param1Intent);
    }
  }
  
  public class b extends BroadcastReceiver {
    public b(d this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(param1Intent.getAction()))
        return; 
      AsyncTask.execute(new a(this));
    }
    
    public class a implements Runnable {
      public a(d.b this$0) {}
      
      public void run() {
        d.a(this.a.a).e();
      }
    }
  }
  
  public class a implements Runnable {
    public a(d this$0) {}
    
    public void run() {
      d.a(this.a.a).e();
    }
  }
  
  public static class c {
    public static final d a = new d(null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */