package com.soft.blued.ui.photo.camera.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.media.selector.present.MediaBasePresent;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.soft.blued.constant.CameraContents;
import com.soft.blued.ui.login_register.model.AdultVerifyModel;
import com.soft.blued.ui.photo.camera.contract.ICameraPreView;
import com.soft.blued.ui.photo.camera.model.CameraModel;
import com.soft.blued.ui.photo.camera.utils.CameraImageUtils;
import java.io.Serializable;

public class CameraPreViewPresenter extends MediaBasePresent<ICameraPreView> {
  private static String a = CameraPreViewPresenter.class.getSimpleName();
  
  private CameraModel c;
  
  private int d = 0;
  
  private AdultVerifyModel e;
  
  public void a() {
    ICameraPreView iCameraPreView = (ICameraPreView)p();
    if (this.c != null && iCameraPreView != null) {
      iCameraPreView.a(true);
      iCameraPreView.d();
      this.c.a(new BluedUIHttpResponse<BluedEntity<AdultVerifyModel, BluedEntityBaseExtra>>(this) {
            String a;
            
            public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
              super.onFailure(param1Throwable, param1Int, param1String);
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              if (param1Int == 4036712) {
                CameraPreViewPresenter.a(this.b, 3);
                this.a = param1String;
                return true;
              } 
              CameraPreViewPresenter.a(this.b, 2);
              return super.onUIFailure(param1Int, param1String);
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              ICameraPreView iCameraPreView = (ICameraPreView)this.b.p();
              if (iCameraPreView != null)
                iCameraPreView.a(false); 
              int i = CameraPreViewPresenter.a(this.b);
              if (i != 2) {
                if (i != 3)
                  return; 
                if (CameraPreViewPresenter.b(this.b).a() == 1)
                  ((ICameraPreView)this.b.p()).c(this.a); 
              } 
              if (iCameraPreView != null)
                iCameraPreView.aY_(); 
            }
            
            public void onUIStart() {
              super.onUIStart();
              this.a = "";
              CameraPreViewPresenter.a(this.b, 0);
            }
            
            public void onUIUpdate(BluedEntity<AdultVerifyModel, BluedEntityBaseExtra> param1BluedEntity) {
              if (param1BluedEntity != null && param1BluedEntity.hasData()) {
                CameraPreViewPresenter.a(this.b, (AdultVerifyModel)param1BluedEntity.getSingleData());
                CameraPreViewPresenter.a(this.b, 1);
              } 
            }
          }iCameraPreView.b());
    } 
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {
    ICameraPreView iCameraPreView = (ICameraPreView)p();
    if (iCameraPreView != null) {
      Bundle bundle = iCameraPreView.getArguments();
      if (bundle == null) {
        iCameraPreView.a().finish();
        return;
      } 
      this.c = (CameraModel)bundle.getSerializable("camera_model_key");
      CameraModel cameraModel = this.c;
      if (cameraModel == null) {
        iCameraPreView.a().finish();
        return;
      } 
      int i = cameraModel.e();
      if (i != 0)
        iCameraPreView.b(CameraImageUtils.a(i)); 
      i = this.c.f();
      if (i != 0)
        iCameraPreView.a(i); 
      CameraContents.a.execute(new Runnable(this) {
            public void run() {
              ICameraPreView iCameraPreView = (ICameraPreView)this.a.p();
              if (iCameraPreView != null)
                iCameraPreView.a(BitmapFactory.decodeFile(CameraPreViewPresenter.b(this.a).b())); 
            }
          });
      iCameraPreView.a(this.c.a((Context)iCameraPreView.a()));
      iCameraPreView.b(this.c.c((Context)iCameraPreView.a()));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("ICameraPreView == null!!!");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void b() {
    ICameraPreView iCameraPreView = (ICameraPreView)p();
    if (iCameraPreView != null) {
      Intent intent = new Intent();
      intent.putExtra("KEY_AV_MODEL", (Serializable)this.e);
      intent.putExtra("KEY_FILE_PATH", this.c.b());
      iCameraPreView.a().setResult(-1, intent);
      iCameraPreView.a().finish();
    } 
  }
  
  public void b(Bundle paramBundle) {}
  
  public void c() {
    int i = this.d;
    if (i != 0) {
      if (i == 1) {
        b();
        return;
      } 
      if (p() != null) {
        ((ICameraPreView)p()).e();
        return;
      } 
    } else if (p() != null) {
      ((ICameraPreView)p()).d();
    } 
  }
  
  public void j() {}
  
  public static interface AV_RESULT {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\camera\presenter\CameraPreViewPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */