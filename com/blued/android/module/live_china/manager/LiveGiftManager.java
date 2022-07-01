package com.blued.android.module.live_china.manager;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.net.http.QueueFileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.external_sense_library.manager.StickerDataManager;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.model.LiveZanExtraModel;
import com.blued.android.module.live_china.observer.ZanRefreshObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LiveGiftManager {
  private static LiveGiftManager a = new LiveGiftManager();
  
  private LiveZanExtraModel b;
  
  public static LiveGiftManager a() {
    return a;
  }
  
  private void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    String str = RecyclingUtils.d(paramString);
    if (TextUtils.isEmpty(str))
      return; 
    if (!(new File(str)).exists()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("downloadFilesAsync url:");
      stringBuilder.append(paramString);
      stringBuilder.append("  filePath:");
      stringBuilder.append(str);
      Log.i("===xpp", stringBuilder.toString());
    } 
    str = RecyclingUtils.d(paramString);
    QueueFileDownloader.QueueFileListener queueFileListener = new QueueFileDownloader.QueueFileListener(this) {
        public void a(int param1Int1, int param1Int2, String param1String1, String param1String2) {
          ImageFileLoader.a(null).a(param1String2, param1String1).a();
        }
      };
    QueueFileDownloader.a(new String[] { paramString }, new String[] { str }, queueFileListener, null, true);
  }
  
  private void b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    File file = new File(AppInfo.d().getExternalCacheDir(), "gift");
    if (!file.exists())
      file.mkdirs(); 
    file = new File(file, Md5.a(paramString));
    if (!file.exists()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(file.getPath());
      stringBuilder.append(".temp");
      String str = stringBuilder.toString();
      FileDownloader.a(paramString, str, new FileHttpResponseHandler(this, file, str) {
            public void a(File param1File) {
              if (param1File != null && param1File.exists())
                param1File.renameTo(this.a); 
            }
            
            public void onFinish() {
              (new File(this.b)).deleteOnExit();
            }
          }null);
    } 
  }
  
  private void b(List<LiveGiftPackageModel> paramList) {
    Logger.a("drb", new Object[] { "downLoadStickerRecourse" });
    if (paramList != null)
      for (LiveGiftPackageModel liveGiftPackageModel : paramList) {
        if (liveGiftPackageModel != null && liveGiftPackageModel.type_name.equals("ar_goods")) {
          List list = liveGiftPackageModel.goods;
          if (list != null) {
            Logger.a("drb", new Object[] { "网络列表个数为： ", Integer.valueOf(list.size()) });
            ArrayList<StickerBaseModel> arrayList = new ArrayList();
            for (LiveGiftModel liveGiftModel : list) {
              StickerBaseModel stickerBaseModel = new StickerBaseModel();
              stickerBaseModel.name = liveGiftModel.anim_code;
              stickerBaseModel.path = liveGiftModel.resource_url;
              arrayList.add(stickerBaseModel);
            } 
            AppInfo.n().post(new Runnable(this, arrayList) {
                  public void run() {
                    StickerDataManager.init(this.a, null);
                  }
                });
          } 
        } 
      }  
  }
  
  private void c(List<LiveGiftPackageModel> paramList) {
    if (paramList != null)
      for (LiveGiftPackageModel liveGiftPackageModel : paramList) {
        if (liveGiftPackageModel != null && liveGiftPackageModel.type_name.equals("normal_goods")) {
          List<LiveGiftModel> list = liveGiftPackageModel.goods;
          for (int i = 0; list != null && i < list.size(); i++) {
            LiveGiftModel liveGiftModel = list.get(i);
            a(liveGiftModel.images_static);
            if (Build.VERSION.SDK_INT > 18) {
              if (!TextUtils.isEmpty(liveGiftModel.images_mp4)) {
                b(liveGiftModel.images_mp4);
              } else if (!TextUtils.isEmpty(liveGiftModel.images_apng2)) {
                a(liveGiftModel.images_apng2);
              } else {
                a(liveGiftModel.images_gif);
              } 
            } else {
              a(liveGiftModel.images_gif);
            } 
          } 
        } 
      }  
  }
  
  public void a(LiveZanExtraModel paramLiveZanExtraModel) {
    this.b = paramLiveZanExtraModel;
    if (paramLiveZanExtraModel != null && paramLiveZanExtraModel.like_style == null) {
      LiveRoomPreferences.a("");
      ZanRefreshObserver.a().a(null);
    } 
    paramLiveZanExtraModel = this.b;
    if (paramLiveZanExtraModel != null && paramLiveZanExtraModel.like_style != null && this.b.like_style.random != null) {
      StringBuffer stringBuffer = new StringBuffer();
      for (int i = 0; i < this.b.like_style.random.length; i++) {
        stringBuffer.append(this.b.like_style.random[i]);
        stringBuffer.append(";");
      } 
      LiveRoomPreferences.a(stringBuffer.toString());
      ZanRefreshObserver.a().a(this.b.like_style.random);
    } 
  }
  
  public void a(List<LiveGiftPackageModel> paramList) {
    a(paramList, false);
  }
  
  public void a(List<LiveGiftPackageModel> paramList, boolean paramBoolean) {
    Logger.a("drb", new Object[] { "downloadGiftRes" });
    ThreadManager.a().a(new ThreadExecutor(this, "downloadGiftRes", paramList, paramBoolean) {
          public void execute() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            LiveGiftManager.a(this.c, arrayList);
            if (this.b)
              LiveGiftManager.b(this.c, arrayList); 
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    LiveRoomHttpUtils.h(new BluedUIHttpResponse<BluedEntity<LiveGiftPackageModel, LiveZanExtraModel>>(this, paramBoolean) {
          public void onUIUpdate(BluedEntity<LiveGiftPackageModel, LiveZanExtraModel> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.data != null) {
              String str = AppInfo.f().toJson(param1BluedEntity);
              LiveDataManager.a().c(str);
            } 
            LiveGiftManager.a().a(param1BluedEntity.data, this.a);
            if (param1BluedEntity.extra != null) {
              LiveGiftManager.a().a((LiveZanExtraModel)param1BluedEntity.extra);
              LiveEventBus.get("live_gift_zan_model").post(param1BluedEntity.extra);
            } 
          }
        });
  }
  
  public LiveZanExtraModel b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\LiveGiftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */