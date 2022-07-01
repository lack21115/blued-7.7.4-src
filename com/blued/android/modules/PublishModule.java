package com.blued.android.modules;

import android.content.Context;
import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.base.base.IBaseInterface;
import com.blued.android.module.base.http.IPublish;
import com.blued.android.module.base.http.PublishProxy;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.shortvideo.utils.StvMediaUtils;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.http.FlashVideoHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.third.QiniuUploadUtils;
import java.io.File;

public class PublishModule {
  public static final String a = PublishModule.class.getSimpleName();
  
  static IPublish b = new IPublish() {
      private void a(Context param1Context, String param1String1, String param1String2, BluedAlbum param1BluedAlbum, PublishProxy.IUploadAuthVideoListener param1IUploadAuthVideoListener) {
        QiniuUploadUtils.a(StvMediaUtils.b(param1String1), param1BluedAlbum, new QiniuUploadTools.QiNiuListener(this, param1IUploadAuthVideoListener, param1Context, param1String1, param1String2) {
              public void a(String param2String) {
                Logger.b(PublishModule.a, new Object[] { "uploadQiNiu = onFailure", param2String });
                this.a.a(-1, param2String);
              }
              
              public void a(String param2String, double param2Double) {
                this.a.a(param2String, param2Double);
              }
              
              public void a(String param2String1, String param2String2) {
                Logger.b(PublishModule.a, new Object[] { "uploadQiNiu = onSuccess", param2String1 });
                if (this.a.a())
                  return; 
                PublishModule.null.a(this.e, this.b, this.c, param2String1, this.d, this.a);
              }
              
              public boolean a() {
                return this.a.a();
              }
            });
      }
      
      private void a(Context param1Context, String param1String1, String param1String2, String param1String3, PublishProxy.IUploadAuthVideoListener param1IUploadAuthVideoListener) {
        FlashVideoHttpUtils.a(param1Context, new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed>>(this, param1String1, param1IUploadAuthVideoListener) {
              boolean a = false;
              
              int b = -1;
              
              String c = "";
              
              public boolean onUIFailure(int param2Int, String param2String) {
                Logger.b(PublishModule.a, new Object[] { "getTokenForVideoAuth = onFailure | statusCode =", Integer.valueOf(param2Int), " | errorMessage = ", param2String });
                this.a = true;
                this.b = param2Int;
                this.c = param2String;
                return super.onUIFailure(param2Int, param2String);
              }
              
              public void onUIFinish() {
                if (this.a)
                  this.e.a(this.b, this.c); 
              }
              
              public void onUIStart() {
                Logger.b(PublishModule.a, new Object[] { " synPhotoServer onStart()" });
                super.onUIStart();
              }
              
              public void onUIUpdate(BluedEntity<BluedIngSelfFeed, BluedIngSelfFeed> param2BluedEntity) {
                Logger.b(PublishModule.a, new Object[] { "synPhotoServer = onSuccess" });
                try {
                  if (BluedHttpUtils.a(param2BluedEntity.code, param2BluedEntity.message)) {
                    StvThreadPoolHelper.a().a((Runnable)new StvThreadPoolHelper.StvThread(new Runnable(this) {
                            public void run() {
                              if (this.a.d != null) {
                                File file = new File(this.a.d);
                                if (file.exists())
                                  file.delete(); 
                              } 
                            }
                          }));
                    if (this.e.a())
                      return; 
                    this.e.b();
                    return;
                  } 
                } catch (Exception exception) {
                  Logger.b(PublishModule.a, new Object[] { "e = ", exception });
                  exception.printStackTrace();
                } 
              }
            }param1String2);
      }
      
      private void a(PublishProxy.ILiveApplyListener param1ILiveApplyListener, int param1Int) {
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<BluedLiveListData>>(this, param1ILiveApplyListener) {
              protected void a(BluedEntityA<BluedLiveListData> param2BluedEntityA) {
                Log.i("xpm", "postApplyComplete SUCCESS");
                PublishProxy.ILiveApplyListener iLiveApplyListener = this.a;
                if (iLiveApplyListener != null)
                  iLiveApplyListener.a(); 
              }
              
              public boolean onUIFailure(int param2Int, String param2String) {
                Log.i("xpm", "postApplyComplete FAIL");
                PublishProxy.ILiveApplyListener iLiveApplyListener = this.a;
                if (iLiveApplyListener != null)
                  iLiveApplyListener.a(param2Int, param2String); 
                AppMethods.a(param2String);
                return false;
              }
              
              public void onUIFinish() {
                super.onUIFinish();
              }
              
              public void onUIStart() {
                super.onUIStart();
              }
            }UserInfo.a().i().getUid(), param1Int);
      }
      
      public void a(Context param1Context, int param1Int, PublishProxy.ILiveApplyListener param1ILiveApplyListener) {
        a(param1ILiveApplyListener, param1Int);
      }
      
      public void a(Context param1Context, String param1String, int param1Int, PublishProxy.IUploadAuthVideoListener param1IUploadAuthVideoListener) {
        if (param1IUploadAuthVideoListener == null)
          return; 
        AppHttpUtils.a(null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, param1Context, param1String, param1Int, param1IUploadAuthVideoListener) {
              boolean a = false;
              
              int b = -1;
              
              String c = "";
              
              protected void a(BluedEntityA<BluedAlbum> param2BluedEntityA) {
                if (BluedHttpUtils.a(param2BluedEntityA.code, param2BluedEntityA.message)) {
                  if (param2BluedEntityA.data != null && param2BluedEntityA.data.size() > 0) {
                    BluedAlbum bluedAlbum = param2BluedEntityA.data.get(0);
                    PublishModule.null  = this.h;
                    Context context = this.d;
                    String str = this.e;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.f);
                    stringBuilder.append("");
                    PublishModule.null.a(, context, str, stringBuilder.toString(), bluedAlbum, this.g);
                    return;
                  } 
                  this.g.a(this.b, this.c);
                  return;
                } 
                this.g.a(this.b, this.c);
              }
              
              public boolean onUIFailure(int param2Int, String param2String) {
                Logger.b(PublishModule.a, new Object[] { "getTokenForVideoAuth = onFailure | statusCode =", Integer.valueOf(param2Int), " | errorMessage = ", param2String });
                this.a = true;
                this.b = param2Int;
                this.c = param2String;
                return super.onUIFailure(param2Int, param2String);
              }
              
              public void onUIFinish() {
                if (this.a)
                  this.g.a(this.b, this.c); 
              }
            });
      }
    };
  
  public static void a() {
    PublishProxy.a().a((IBaseInterface)b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\PublishModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */