package androidx.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21 {
  public static Object createVolumeProvider(int paramInt1, int paramInt2, int paramInt3, Delegate paramDelegate) {
    return new VolumeProvider(paramInt1, paramInt2, paramInt3, paramDelegate) {
        public void onAdjustVolume(int param1Int) {
          this.a.onAdjustVolume(param1Int);
        }
        
        public void onSetVolumeTo(int param1Int) {
          this.a.onSetVolumeTo(param1Int);
        }
      };
  }
  
  public static void setCurrentVolume(Object paramObject, int paramInt) {
    ((VolumeProvider)paramObject).setCurrentVolume(paramInt);
  }
  
  public static interface Delegate {
    void onAdjustVolume(int param1Int);
    
    void onSetVolumeTo(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\media\VolumeProviderCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */