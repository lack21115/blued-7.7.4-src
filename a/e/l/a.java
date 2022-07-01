package a.e.l;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements View.OnTouchListener {
  public static final int s = ViewConfiguration.getTapTimeout();
  
  public final a b;
  
  public final Interpolator c;
  
  public final View d;
  
  public Runnable e;
  
  public float[] f;
  
  public float[] g;
  
  public int h;
  
  public int i;
  
  public float[] j;
  
  public float[] k;
  
  public float[] l;
  
  public boolean m;
  
  public boolean n;
  
  public boolean o;
  
  public boolean p;
  
  public boolean q;
  
  public boolean r;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public a(View paramView) {
    new a();
    throw new VerifyError("bad dex opcode");
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
    return (paramFloat1 > paramFloat3) ? paramFloat3 : ((paramFloat1 < paramFloat2) ? paramFloat2 : paramFloat1);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 > paramInt3) ? paramInt3 : ((paramInt1 < paramInt2) ? paramInt2 : paramInt1);
  }
  
  public final float a(float paramFloat1, float paramFloat2) {
    if (paramFloat2 == 0.0F)
      return 0.0F; 
    throw new VerifyError("bad dex opcode");
  }
  
  public final float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
    throw new VerifyError("bad dex opcode");
  }
  
  public a a(boolean paramBoolean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public void a() {
    long l = SystemClock.uptimeMillis();
    MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean b() {
    throw new VerifyError("bad dex opcode");
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static class a {
    public int a;
    
    public int b;
    
    public float c;
    
    public float d;
    
    public long e;
    
    public long f;
    
    public int g;
    
    public int h;
    
    public long i;
    
    public float j;
    
    public int k;
    
    public a() {
      throw new VerifyError("bad dex opcode");
    }
    
    public final float a(long param1Long) {
      throw new VerifyError("bad dex opcode");
    }
    
    public void a() {
      AnimationUtils.currentAnimationTimeMillis();
      throw new VerifyError("bad dex opcode");
    }
    
    public void b() {
      AnimationUtils.currentAnimationTimeMillis();
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public class b implements Runnable {
    public b(a this$0) {}
    
    public void run() {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\e\l\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */