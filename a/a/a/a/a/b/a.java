package a.a.a.a.a.b;

import android.hardware.Camera;

public final class a implements Camera.AutoFocusMoveCallback {
  public a a;
  
  public a(a parama) {
    this.a = parama;
  }
  
  public void onAutoFocusMoving(boolean paramBoolean, Camera paramCamera) {
    a a1 = this.a;
    if (a1 != null)
      a1.a(paramBoolean, paramCamera); 
  }
  
  public static interface a {
    void a(boolean param1Boolean, Camera param1Camera);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */