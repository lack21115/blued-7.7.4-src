package com.soft.blued.ui.circle.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.utils.third.QiniuUploadUtils;

public class CircleInfoSettingPresenter extends MvpPresenter {
  private MyCircleModel h;
  
  private String i;
  
  private String j;
  
  private boolean k;
  
  private void a(String paramString, BluedAlbum paramBluedAlbum) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {
            this.a.b("upload_photo", false);
            AppMethods.d(2131755404);
          }
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            this.a.e(param1String1);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.h = (MyCircleModel)paramBundle1.getSerializable("circle_data");
      if (TextUtils.isEmpty(this.h.description))
        this.h.description = AppUtils.a(2131755866); 
      a("circle_details", this.h);
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void d(String paramString) {
    this.j = paramString;
    if (TextUtils.isEmpty(this.i)) {
      e("");
      return;
    } 
    m();
  }
  
  public void e(String paramString) {
    CircleHttpUtils.b(new BluedUIHttpResponse(this, g(), paramString) {
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            this.b.b("upload_photo", true);
            if (param1Boolean) {
              AppMethods.d(2131755873);
              if (!TextUtils.isEmpty(this.a))
                (CircleInfoSettingPresenter.a(this.b)).cover = this.a; 
              (CircleInfoSettingPresenter.a(this.b)).description = CircleInfoSettingPresenter.b(this.b);
              LiveEventBus.get("circle_info_modify").post(CircleInfoSettingPresenter.a(this.b));
              this.b.i();
            } 
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }n(), paramString, this.j, g());
  }
  
  public void f(String paramString) {
    this.i = paramString;
  }
  
  public void m() {
    FeedHttpUtils.a(null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, g()) {
          protected BluedEntityA<BluedAlbum> a(String param1String) {
            BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA)super.parseData(param1String);
            if (bluedEntityA != null)
              try {
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                  BluedAlbum bluedAlbum = bluedEntityA.data.get(0);
                  CircleInfoSettingPresenter.a(this.a, CircleInfoSettingPresenter.c(this.a), bluedAlbum);
                  return bluedEntityA;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
            return bluedEntityA;
          }
          
          public void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {}
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            AppMethods.d(2131755404);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a.b("upload_photo", false);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("upload_photo");
          }
        });
  }
  
  public String n() {
    return this.h.circle_id;
  }
  
  public String o() {
    return TextUtils.isEmpty(this.i) ? this.h.cover : this.i;
  }
  
  public String p() {
    return this.h.description;
  }
  
  public boolean q() {
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CircleInfoSettingPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */