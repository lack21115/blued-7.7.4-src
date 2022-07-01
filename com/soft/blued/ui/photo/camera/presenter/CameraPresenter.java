package com.soft.blued.ui.photo.camera.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.soft.blued.ui.photo.camera.contract.ICameraView;
import com.soft.blued.ui.photo.camera.fragment.CameraPreViewFragment;
import com.soft.blued.ui.photo.camera.model.CameraModel;
import com.soft.blued.ui.photo.camera.view.BluedCameraView;

public class CameraPresenter extends MediaBasePresent<ICameraView> implements PermissionCallbacks, BluedCameraView.OperationCallback {
  private static String a = CameraPresenter.class.getSimpleName();
  
  private CameraModel c;
  
  private Runnable d = new Runnable(this) {
      public void run() {
        ICameraView iCameraView = (ICameraView)this.a.p();
        if (iCameraView != null) {
          if (iCameraView.aX_()) {
            iCameraView.b().setFacing(CameraPresenter.a(this.a).d());
            return;
          } 
          AppInfo.n().postDelayed(CameraPresenter.b(this.a), 300L);
        } 
      }
    };
  
  public CameraPresenter() {
    if (this.c == null)
      this.c = new CameraModel(); 
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      if (paramInt1 != 1)
        return; 
      paramActivity.setResult(-1, paramIntent);
      paramActivity.finish();
      return;
    } 
    ICameraView iCameraView = (ICameraView)p();
    if (iCameraView != null)
      iCameraView.i(); 
  }
  
  public void a(Bundle paramBundle) {
    ICameraView iCameraView = (ICameraView)p();
    if (iCameraView != null) {
      StringBuilder stringBuilder1;
      Bundle bundle = iCameraView.getArguments();
      if (bundle == null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(a);
        stringBuilder1.append(" bundle == null!!!");
        StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
        iCameraView.a().finish();
        return;
      } 
      this.c.a(stringBuilder1.getInt("from"));
      iCameraView.a(this.c.a((Context)iCameraView.a()));
      iCameraView.b(this.c.b((Context)iCameraView.a()));
      iCameraView.b().setFacing(this.c.d());
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("ICameraView == null!!!");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void a(boolean paramBoolean, String paramString) {
    ICameraView iCameraView = (ICameraView)p();
    if (iCameraView != null && iCameraView.h() != null && iCameraView.h().isAdded()) {
      iCameraView.b(paramBoolean);
      if (paramBoolean) {
        CameraModel cameraModel2 = this.c;
        if (cameraModel2 != null)
          cameraModel2.a(paramString); 
        CameraModel cameraModel1 = new CameraModel();
        cameraModel1.a(this.c);
        BluedCameraView bluedCameraView = iCameraView.b();
        if (bluedCameraView != null)
          cameraModel1.b(bluedCameraView.getFacing()); 
        CameraPreViewFragment.a(iCameraView.h(), cameraModel1, 1);
      } 
    } 
  }
  
  public void a(String[] paramArrayOfString) {}
  
  public void aa_() {
    ICameraView iCameraView = (ICameraView)p();
    if (iCameraView != null && iCameraView.aX_()) {
      if (!iCameraView.g()) {
        iCameraView.e();
        return;
      } 
      iCameraView.d();
    } 
  }
  
  public void b() {}
  
  public void b(Bundle paramBundle) {}
  
  public void c() {
    ICameraView iCameraView = (ICameraView)p();
    if (iCameraView != null && iCameraView.aX_()) {
      if (!iCameraView.g()) {
        iCameraView.e();
        return;
      } 
      iCameraView.d();
    } 
  }
  
  public void d() {
    ICameraView iCameraView = (ICameraView)p();
    if (iCameraView != null && iCameraView.h() != null && iCameraView.h().isAdded())
      iCameraView.a(true); 
  }
  
  public void j() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\camera\presenter\CameraPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */