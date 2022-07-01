package com.soft.blued.ui.live.presenter;

import android.content.Context;
import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.utils.third.QiniuUploadUtils;

public abstract class LiveBaseImprovePresenter extends MvpPresenter {
  public final int h = 0;
  
  public final int i = 1;
  
  private void a(String paramString, BluedAlbum paramBluedAlbum, int paramInt) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this, paramInt) {
          public void a(String param1String) {
            int i = this.a;
            if (i != 0) {
              if (i != 1)
                return; 
              this.b.b("LIVE_CARD_BACK_UPLOAD", true);
              return;
            } 
            this.b.b("LIVE_CARD_FRONT_UPLOAD", true);
          }
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("七牛上传成功：");
            stringBuilder.append(this.a);
            Log.v("pk", stringBuilder.toString());
            this.b.a(this.a, param1String1);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(Context paramContext, String paramString, int paramInt) {
    LiveHttpUtils.a(paramContext, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, g(), paramString, paramInt) {
          protected void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {
            if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              BluedAlbum bluedAlbum = param1BluedEntityA.data.get(0);
              LiveBaseImprovePresenter.a(this.c, this.a, bluedAlbum, this.b);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("获取token成功：");
              stringBuilder.append(this.b);
              Log.v("pk", stringBuilder.toString());
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            param1Int = this.b;
            if (param1Int != 0) {
              if (param1Int == 1)
                this.c.b("LIVE_CARD_BACK_UPLOAD", true); 
            } else {
              this.c.b("LIVE_CARD_FRONT_UPLOAD", true);
            } 
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {}
          
          public void onUIStart() {}
        }g());
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveBaseImprovePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */