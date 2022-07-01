package com.soft.blued.ui.photo.camera.view;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.utils.Houyi;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.CameraView;
import com.soft.blued.R;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.constant.CameraContents;
import com.soft.blued.ui.photo.camera.utils.CameraImageUtils;
import com.soft.blued.utils.Logger;
import java.io.File;
import java.util.Date;

public class BluedCameraView extends CameraView implements PermissionCallbacks {
  private static final String d = BluedCameraView.class.getSimpleName();
  
  private static final int[] i = new int[] { 3, 0, 1 };
  
  CameraView.Callback c = new CameraView.Callback(this) {
      public void a(CameraView param1CameraView) {
        if (!BluedCameraView.a(this.a))
          BluedCameraView.a(this.a, true); 
        if (AppInfo.m())
          Logger.c(BluedCameraView.i(), new Object[] { "onCameraOpened" }); 
      }
      
      public void a(CameraView param1CameraView, byte[] param1ArrayOfbyte) {
        if (AppInfo.m()) {
          int i;
          String str = BluedCameraView.i();
          if (param1ArrayOfbyte == null) {
            i = 0;
          } else {
            i = param1ArrayOfbyte.length;
          } 
          Logger.c(str, new Object[] { "onPictureTaken ", Integer.valueOf(i) });
        } 
        if (BluedCameraView.b(this.a) != null)
          BluedCameraView.b(this.a).d(); 
        if (param1CameraView == null || param1ArrayOfbyte == null || param1ArrayOfbyte.length <= 0) {
          if (BluedCameraView.b(this.a) != null)
            BluedCameraView.b(this.a).a(false, null); 
          return;
        } 
        BluedCameraView.d(this.a).post(new Runnable(this, param1ArrayOfbyte) {
              public void run() {
                boolean bool;
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(AppInfo.d().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
                stringBuilder1.append(CameraContents.c);
                stringBuilder1.append(CameraContents.d.format(new Date()));
                String str = stringBuilder1.toString();
                byte[] arrayOfByte = this.a;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(".jpg");
                str = CameraImageUtils.a(arrayOfByte, stringBuilder2.toString()).getAbsolutePath();
                Houyi.a().a(str).b();
                File file = CameraImageUtils.a(CameraImageUtils.a(str, BluedCameraView.c(this.b.a)), str);
                CameraImageUtils.a(str);
                if (file.length() <= 0L) {
                  bool = false;
                } else {
                  bool = true;
                } 
                AppInfo.n().post(new Runnable(this, bool, str) {
                      public void run() {
                        if (BluedCameraView.b(this.c.b.a) != null)
                          BluedCameraView.b(this.c.b.a).a(this.a, this.b); 
                      }
                    });
              }
            });
      }
      
      public void b(CameraView param1CameraView) {
        if (AppInfo.m())
          Logger.c(BluedCameraView.i(), new Object[] { "onCameraClosed" }); 
      }
    };
  
  private OperationCallback e;
  
  private Handler f;
  
  private float g = 1.0F;
  
  private boolean h = false;
  
  public BluedCameraView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public BluedCameraView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BluedCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    String str = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BluedCameraView, paramInt, 0).getString(0);
    if (!TextUtils.isEmpty(str)) {
      AspectRatio aspectRatio = AspectRatio.a(str);
      this.g = aspectRatio.a() * 1.0F / aspectRatio.b();
    } 
    j();
  }
  
  private Handler getBgHandler() {
    if (this.f == null) {
      HandlerThread handlerThread = new HandlerThread(CameraContents.b);
      handlerThread.start();
      this.f = new Handler(handlerThread.getLooper());
    } 
    return this.f;
  }
  
  private void j() {
    a(this.c);
  }
  
  public void a(OperationCallback paramOperationCallback) {
    this.e = paramOperationCallback;
    PermissionHelper.b(this);
  }
  
  public void a(String[] paramArrayOfString) {
    OperationCallback operationCallback = this.e;
    if (operationCallback != null)
      operationCallback.b(); 
  }
  
  public void aa_() {
    b();
  }
  
  public boolean f() {
    return this.h;
  }
  
  public void g() {
    c();
  }
  
  public void h() {
    if (this.f != null) {
      if (Build.VERSION.SDK_INT >= 18) {
        this.f.getLooper().quitSafely();
      } else {
        this.f.getLooper().quit();
      } 
      this.f = null;
    } 
  }
  
  public static interface OperationCallback {
    void a(boolean param1Boolean, String param1String);
    
    void b();
    
    void d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\camera\view\BluedCameraView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */