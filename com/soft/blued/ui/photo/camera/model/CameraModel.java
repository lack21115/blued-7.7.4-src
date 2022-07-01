package com.soft.blued.ui.photo.camera.model;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.user.AVConfig;
import com.soft.blued.utils.third.QiniuUploadUtils;
import java.io.Serializable;

public class CameraModel implements Serializable {
  private int a;
  
  private String b;
  
  private int c;
  
  public int a() {
    return this.a;
  }
  
  public String a(Context paramContext) {
    return (a() == 1) ? (AVConfig.a().b()).face_title : ((a() == 2) ? paramContext.getResources().getString(2131755392) : "");
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(BluedUIHttpResponse<BluedEntityA<BluedAlbum>> paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    if (TextUtils.isEmpty(g())) {
      if (paramBluedUIHttpResponse != null)
        paramBluedUIHttpResponse.onFinish(); 
      return;
    } 
    paramBluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, paramBluedUIHttpResponse, paramIRequestHost) {
        boolean a = false;
        
        protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
          if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
            BluedAlbum bluedAlbum = (BluedAlbum)param1BluedEntityA.getSingleData();
            QiniuUploadUtils.a(this.d.b(), bluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
                  public void a(String param2String) {
                    AppMethods.d(2131756082);
                    if (this.a.b != null)
                      this.a.b.onFinish(); 
                  }
                  
                  public void a(String param2String, double param2Double) {}
                  
                  public void a(String param2String1, String param2String2) {
                    if (this.a.d.a() == 1) {
                      LoginRegisterHttpUtils.b(this.a.b, this.a.c, param2String1);
                      return;
                    } 
                    if (this.a.d.a() == 2)
                      LoginRegisterHttpUtils.a(this.a.b, this.a.c, param2String1); 
                  }
                  
                  public boolean a() {
                    return false;
                  }
                });
            return;
          } 
          AppMethods.d(2131756082);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          this.a = true;
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          BluedUIHttpResponse bluedUIHttpResponse = this.b;
          if (bluedUIHttpResponse != null)
            bluedUIHttpResponse.onFinish(); 
        }
      };
    if (a() == 1) {
      LoginRegisterHttpUtils.a(paramBluedUIHttpResponse, paramIRequestHost);
      return;
    } 
    if (a() == 2)
      LoginRegisterHttpUtils.b(paramBluedUIHttpResponse, paramIRequestHost); 
  }
  
  public void a(CameraModel paramCameraModel) {
    if (paramCameraModel != null) {
      a(paramCameraModel.a());
      a(paramCameraModel.b());
      b(paramCameraModel.c());
    } 
  }
  
  public void a(String paramString) {
    this.b = paramString;
  }
  
  public String b() {
    return this.b;
  }
  
  public String b(Context paramContext) {
    return (a() == 1) ? (AVConfig.a().b()).face_tips : ((a() == 2) ? paramContext.getResources().getString(2131755394) : "");
  }
  
  public void b(int paramInt) {
    this.c = paramInt;
  }
  
  public int c() {
    return this.c;
  }
  
  public String c(Context paramContext) {
    return paramContext.getResources().getString(2131755270);
  }
  
  public int d() {
    int i = a();
    boolean bool = false;
    if (i == 1) {
      bool = true;
    } else {
      a();
    } 
    b(bool);
    return bool;
  }
  
  public int e() {
    return (a() == 1) ? 2131231194 : ((a() == 2) ? 2131231361 : 0);
  }
  
  public int f() {
    return (a() == 1) ? 2131755382 : ((a() == 2) ? 2131755383 : 0);
  }
  
  public String g() {
    return (a() == 1) ? "/blued/faceplus/face" : ((a() == 2) ? "/blued/faceplus/ocidcard" : null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\camera\model\CameraModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */