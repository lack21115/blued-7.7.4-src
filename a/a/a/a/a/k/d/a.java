package a.a.a.a.a.k.d;

import android.view.Choreographer;
import java.util.concurrent.TimeUnit;

public final class a implements Choreographer.FrameCallback {
  public static final a a = new a();
  
  public static final long b = TimeUnit.NANOSECONDS.convert(1L, TimeUnit.SECONDS);
  
  public static final long c = TimeUnit.NANOSECONDS.convert(10L, TimeUnit.SECONDS);
  
  public static long d = 0L;
  
  public static long e = 0L;
  
  public static int f = 0;
  
  public static int g = 0;
  
  public static boolean h = false;
  
  public void a() {
    if (!h)
      return; 
    h = false;
    g = 0;
    f = 0;
    e = 0L;
    d = 0L;
  }
  
  public void b() {
    h = true;
  }
  
  public int c() {
    d();
    return g;
  }
  
  public final void d() {
    if (g == 0 || e - d >= c) {
      long l1 = e;
      long l2 = d;
      g = Math.round((float)(f * b) / (float)(l1 - l2));
      d = e;
      f = 0;
    } 
  }
  
  public void doFrame(long paramLong) {
    f++;
    if (d == 0L) {
      d = paramLong;
      Choreographer.getInstance().postFrameCallback(this);
      return;
    } 
    e = paramLong;
    if (h) {
      Choreographer.getInstance().removeFrameCallback(this);
      return;
    } 
    Choreographer.getInstance().postFrameCallback(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */