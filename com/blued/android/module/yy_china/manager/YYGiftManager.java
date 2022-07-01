package com.blued.android.module.yy_china.manager;

import android.os.Build;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.external_sense_library.manager.StickerDataManager;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class YYGiftManager {
  private static YYGiftManager a = new YYGiftManager();
  
  private Set<String> b = new HashSet<String>();
  
  public static YYGiftManager a() {
    return a;
  }
  
  private void a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    ImageFileLoader.a(null).b(paramString).a(new ImageFileLoader.OnLoadFileListener(this, paramString) {
          public void onUIFinish(File param1File, Exception param1Exception) {
            if (param1File == null || !param1File.exists())
              synchronized (YYGiftManager.a(this.b)) {
                if (YYGiftManager.a(this.b).contains(this.a))
                  return; 
                YYGiftManager.a(this.b).add(this.a);
                ImageFileLoader.a(null).a(this.a).a();
                return;
              }  
          }
        }).a();
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
  
  private void b(List<YYGiftPackageModel> paramList) {
    Logger.a("drb", new Object[] { "downLoadStickerRecourse" });
    if (paramList != null)
      for (YYGiftPackageModel yYGiftPackageModel : paramList) {
        if (yYGiftPackageModel != null && yYGiftPackageModel.type_name.equals("ar_goods")) {
          List list = yYGiftPackageModel.goods;
          if (list != null) {
            Logger.a("drb", new Object[] { "网络列表个数为： ", Integer.valueOf(list.size()) });
            ArrayList<StickerBaseModel> arrayList = new ArrayList();
            for (YYGiftModel yYGiftModel : list) {
              StickerBaseModel stickerBaseModel = new StickerBaseModel();
              stickerBaseModel.name = yYGiftModel.anim_code;
              stickerBaseModel.path = yYGiftModel.resource_url;
              arrayList.add(stickerBaseModel);
            } 
            StickerDataManager.init(arrayList, null);
          } 
        } 
      }  
  }
  
  private void c(List<YYGiftPackageModel> paramList) {
    if (paramList != null)
      for (YYGiftPackageModel yYGiftPackageModel : paramList) {
        if (yYGiftPackageModel != null && TextUtils.equals(yYGiftPackageModel.type_name, "normal_goods")) {
          List<YYGiftModel> list = yYGiftPackageModel.goods;
          for (int i = 0; list != null && i < list.size(); i++) {
            YYGiftModel yYGiftModel = list.get(i);
            a(yYGiftModel.images_static);
            if (Build.VERSION.SDK_INT > 18) {
              if (!TextUtils.isEmpty(yYGiftModel.images_mp4)) {
                b(yYGiftModel.images_mp4);
              } else if (!TextUtils.isEmpty(yYGiftModel.images_apng2)) {
                a(yYGiftModel.images_apng2);
              } else {
                a(yYGiftModel.images_gif);
              } 
            } else {
              a(yYGiftModel.images_gif);
            } 
          } 
        } 
      }  
  }
  
  public void a(List<YYGiftPackageModel> paramList) {
    a(paramList, false);
  }
  
  public void a(List<YYGiftPackageModel> paramList, boolean paramBoolean) {
    Logger.a("drb", new Object[] { "downloadGiftRes" });
    ThreadManager.a().a(new ThreadExecutor(this, "downloadGiftRes", paramList, paramBoolean) {
          public void execute() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.a);
            YYGiftManager.a(this.c, arrayList);
            if (this.b)
              YYGiftManager.b(this.c, arrayList); 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\manager\YYGiftManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */