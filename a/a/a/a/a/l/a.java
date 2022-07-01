package a.a.a.a.a.l;

import a.a.a.a.a.e.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.qiniu.pili.droid.streaming.ScreenCaptureSessionListener;
import com.qiniu.pili.droid.streaming.screen.ScreenCaptureRequestActivity;

public final class a {
  public static a a;
  
  public boolean b;
  
  public boolean c;
  
  public VirtualDisplay d;
  
  public MediaProjection e;
  
  public c f;
  
  public ScreenCaptureSessionListener g;
  
  public int h;
  
  public Intent i;
  
  public int j;
  
  public int k;
  
  public int l;
  
  public Surface m;
  
  public final Handler n = new Handler(Looper.getMainLooper());
  
  public Runnable o = new a(this);
  
  public BroadcastReceiver p = new b(this);
  
  public static a a() {
    e.g.c("ScreenCapturer", "get screenCapturer instance");
    if (a == null)
      a = new a(); 
    return a;
  }
  
  public void a(c paramc) {
    boolean bool;
    e e = e.g;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setOnScreenCaptureListener ");
    if (paramc != null) {
      bool = true;
    } else {
      bool = false;
    } 
    stringBuilder.append(bool);
    e.c("ScreenCapturer", stringBuilder.toString());
    this.f = paramc;
  }
  
  public void a(Context paramContext, c paramc) {
    if (this.c || this.b) {
      if (this.b && paramc != null) {
        e.c.d("ScreenCapturer", "already inited");
        paramc.b(true);
      } 
      e.c.d("ScreenCapturer", "initing or inited");
      return;
    } 
    this.c = true;
    this.f = paramc;
    LocalBroadcastManager.getInstance(paramContext).registerReceiver(this.p, new IntentFilter("intent.ACTION_REQUEST_SCREEN_CAPTURE_RESULT"));
    ScreenCaptureSessionListener screenCaptureSessionListener = this.g;
    if (screenCaptureSessionListener == null || !screenCaptureSessionListener.onRequestScreenCapture("intent.ACTION_REQUEST_SCREEN_CAPTURE_RESULT", "extra.KEY_RESULT_CODE", "extra.KEY_RESULT_DATA")) {
      Intent intent = new Intent(paramContext, ScreenCaptureRequestActivity.class);
      intent.setFlags(268435456);
      paramContext.startActivity(intent);
    } 
    e.c.c("ScreenCapturer", "init to request permission for screen capturer");
  }
  
  public void a(ScreenCaptureSessionListener paramScreenCaptureSessionListener) {
    this.g = paramScreenCaptureSessionListener;
  }
  
  public boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, Surface paramSurface) {
    if (this.d != null && this.e != null) {
      if (this.j == paramInt1 && this.k == paramInt2 && this.l == paramInt3 && this.m == paramSurface) {
        e.c.d("ScreenCapturer", "Capturing is ongoing!!!");
        return false;
      } 
      e.c.d("ScreenCapturer", "Stopping the previous capturing...");
      b();
    } 
    this.j = paramInt1;
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramSurface;
    MediaProjection mediaProjection = ((MediaProjectionManager)paramContext.getSystemService("media_projection")).getMediaProjection(this.h, this.i);
    this.e = mediaProjection;
    if (mediaProjection != null) {
      this.d = mediaProjection.createVirtualDisplay("ScreenCapturer-display", paramInt1, paramInt2, paramInt3, 16, paramSurface, null, null);
      this.n.post(this.o);
      e e = e.c;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Capturing for width:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" height:");
      stringBuilder.append(paramInt2);
      stringBuilder.append(" dpi:");
      stringBuilder.append(paramInt3);
      e.c("ScreenCapturer", stringBuilder.toString());
      return true;
    } 
    e.g.d("ScreenCapturer", "Get MediaProjection failed");
    return false;
  }
  
  public void b() {
    e.g.c("ScreenCapturer", "stopCapturing");
    this.n.removeCallbacks(this.o);
    VirtualDisplay virtualDisplay = this.d;
    if (virtualDisplay != null) {
      virtualDisplay.release();
      this.d = null;
    } 
    MediaProjection mediaProjection = this.e;
    if (mediaProjection != null) {
      mediaProjection.stop();
      this.e = null;
    } 
    c c1 = this.f;
    if (c1 != null) {
      c1.a(true);
      this.f = null;
    } 
  }
  
  public class a implements Runnable {
    public a(a this$0) {}
    
    public void run() {
      a.b(this.a).postDelayed(a.a(this.a), 10L);
      if (a.c(this.a) != null)
        a.c(this.a).a(false); 
    }
  }
  
  public class b extends BroadcastReceiver {
    public b(a this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      boolean bool;
      e.g.c("ScreenCapturer", "receive broadcase handle screen capturer");
      LocalBroadcastManager.getInstance(param1Context).unregisterReceiver(this);
      a.a(this.a, param1Intent.getIntExtra("extra.KEY_RESULT_CODE", 0));
      a.a(this.a, (Intent)param1Intent.getParcelableExtra("extra.KEY_RESULT_DATA"));
      a a1 = this.a;
      if (a.d(a1) == -1) {
        bool = true;
      } else {
        bool = false;
      } 
      a.a(a1, bool);
      if (a.c(this.a) != null)
        a.c(this.a).b(a.e(this.a)); 
      a.b(this.a, false);
    }
  }
  
  public static interface c {
    void a(boolean param1Boolean);
    
    void b(boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */