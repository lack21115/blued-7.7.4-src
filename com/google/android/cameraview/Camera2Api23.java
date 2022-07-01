package com.google.android.cameraview;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;

class Camera2Api23 extends Camera2 {
  protected void a(SizeMap paramSizeMap, StreamConfigurationMap paramStreamConfigurationMap) {
    if (paramStreamConfigurationMap.getHighResolutionOutputSizes(256) != null)
      for (Size size : paramStreamConfigurationMap.getHighResolutionOutputSizes(256))
        paramSizeMap.a(new Size(size.getWidth(), size.getHeight()));  
    if (paramSizeMap.c())
      super.a(paramSizeMap, paramStreamConfigurationMap); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\cameraview\Camera2Api23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */