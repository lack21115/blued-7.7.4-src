package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceView;

public class SSSurfaceView extends SurfaceView {
  public SSSurfaceView(Context paramContext) {
    super(paramContext);
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    if (paramInt == 0)
      super.onWindowVisibilityChanged(paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\renderview\SSSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */