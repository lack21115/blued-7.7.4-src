package androidx.media;

import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
  public static final int VOLUME_CONTROL_ABSOLUTE = 2;
  
  public static final int VOLUME_CONTROL_FIXED = 0;
  
  public static final int VOLUME_CONTROL_RELATIVE = 1;
  
  private final int a;
  
  private final int b;
  
  private int c;
  
  private Callback d;
  
  private Object e;
  
  public VolumeProviderCompat(int paramInt1, int paramInt2, int paramInt3) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public final int getCurrentVolume() {
    return this.c;
  }
  
  public final int getMaxVolume() {
    return this.b;
  }
  
  public final int getVolumeControl() {
    return this.a;
  }
  
  public Object getVolumeProvider() {
    if (this.e == null && Build.VERSION.SDK_INT >= 21)
      this.e = VolumeProviderCompatApi21.createVolumeProvider(this.a, this.b, this.c, new VolumeProviderCompatApi21.Delegate(this) {
            public void onAdjustVolume(int param1Int) {
              this.a.onAdjustVolume(param1Int);
            }
            
            public void onSetVolumeTo(int param1Int) {
              this.a.onSetVolumeTo(param1Int);
            }
          }); 
    return this.e;
  }
  
  public void onAdjustVolume(int paramInt) {}
  
  public void onSetVolumeTo(int paramInt) {}
  
  public void setCallback(Callback paramCallback) {
    this.d = paramCallback;
  }
  
  public final void setCurrentVolume(int paramInt) {
    this.c = paramInt;
    Object object = getVolumeProvider();
    if (object != null && Build.VERSION.SDK_INT >= 21)
      VolumeProviderCompatApi21.setCurrentVolume(object, paramInt); 
    object = this.d;
    if (object != null)
      object.onVolumeChanged(this); 
  }
  
  public static abstract class Callback {
    public abstract void onVolumeChanged(VolumeProviderCompat param1VolumeProviderCompat);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ControlType {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\VolumeProviderCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */