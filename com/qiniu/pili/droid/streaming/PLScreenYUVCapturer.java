package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.l.c;
import android.app.Activity;
import android.content.Intent;

public class PLScreenYUVCapturer {
  public static final int REQUEST_CODE = 2008;
  
  public c mScreenYUVCapturerCore = new c();
  
  public boolean isCapturing() {
    return this.mScreenYUVCapturerCore.d();
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    return this.mScreenYUVCapturerCore.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void prepare(ScreenSetting paramScreenSetting, PLScreenYUVCapturerListener paramPLScreenYUVCapturerListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mScreenYUVCapturerCore : La/a/a/a/a/l/c;
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual a : (Lcom/qiniu/pili/droid/streaming/ScreenSetting;Lcom/qiniu/pili/droid/streaming/PLScreenYUVCapturerListener;)V
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
  }
  
  public void release() {
    this.mScreenYUVCapturerCore.c();
  }
  
  public void requestScreenCapture(Activity paramActivity) {
    this.mScreenYUVCapturerCore.a(paramActivity);
  }
  
  public void start() {
    this.mScreenYUVCapturerCore.a();
  }
  
  public void stop() {
    this.mScreenYUVCapturerCore.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\PLScreenYUVCapturer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */