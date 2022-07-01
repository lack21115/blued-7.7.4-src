package com.blued.android.module.shortvideo;

import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.base.base.IBaseInterface;
import com.blued.android.module.base.shortvideo.ISaveInterface;
import com.blued.android.module.base.shortvideo.IShortVideo;
import com.blued.android.module.base.shortvideo.ITranscodingVideoListener;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.shortvideo.fragment.AuthRecorderFragment;
import com.blued.android.module.shortvideo.fragment.EditFragment;
import com.blued.android.module.shortvideo.fragment.EditPreViewFragment;
import com.blued.android.module.shortvideo.fragment.SaveVideoFragment;
import com.blued.android.module.shortvideo.fragment.ShineFragment;
import com.blued.android.module.shortvideo.fragment.TrimFragment;
import com.blued.android.module.shortvideo.manager.StvFragmentManager;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.utils.StvMediaUtils;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEnv;
import java.io.File;

public class ShortVideoModule {
  protected static IShortVideo a = new IShortVideo() {
      public void a(Bundle param1Bundle, int param1Int, ISaveInterface param1ISaveInterface) {
        ShortVideoModule.b();
        if (param1Bundle == null)
          return; 
        CommonModel commonModel = (CommonModel)param1Bundle.getSerializable("commont_model");
        EditDataModel.SerializableData serializableData = (EditDataModel.SerializableData)param1Bundle.getSerializable("serializeble_data");
        if (serializableData == null || TextUtils.isEmpty(serializableData.getVideoPath()))
          if (commonModel != null) {
            if (TextUtils.isEmpty(commonModel.getVideoPath()))
              return; 
          } else {
            return;
          }  
        StvMediaUtils.a(AppInfo.d(), commonModel, serializableData, param1Int, serializableData.getPrePageType(), param1ISaveInterface);
      }
      
      public void a(Object param1Object, int param1Int1, int param1Int2) {
        ShortVideoModule.b();
        AuthRecorderFragment.a(param1Object, param1Int1, param1Int2);
      }
      
      public void a(Object param1Object, int param1Int1, int param1Int2, int param1Int3) {
        ShortVideoModule.b();
        ShineFragment.a(param1Object, param1Int1, param1Int2, param1Int3);
      }
      
      public void a(Object param1Object, int param1Int1, String param1String1, String param1String2, int param1Int2) {
        ShortVideoModule.b();
        ShineFragment.a(param1Object, param1Int1, param1String1, param1String2, param1Int2);
      }
      
      public void a(Object param1Object, Bundle param1Bundle, int param1Int) {
        ShortVideoModule.b();
        EditPreViewFragment.a(param1Object, param1Bundle, param1Int);
      }
      
      public void a(Object param1Object, Bundle param1Bundle, int param1Int1, int param1Int2) {
        ShortVideoModule.b();
        if (param1Bundle == null)
          return; 
        SaveVideoFragment.a(param1Object, param1Bundle, param1Int1, param1Int2);
      }
      
      public void a(Object param1Object, String param1String, int param1Int1, int param1Int2) {
        ShortVideoModule.b();
        TrimFragment.a(param1Object, param1String, param1Int1, param1Int2);
      }
      
      public void a(Object param1Object, String param1String1, String param1String2, int param1Int) {
        ShortVideoModule.b();
        EditFragment.a(param1Object, param1String1, param1String2, param1Int);
      }
      
      public void a(String param1String) {
        ShortVideoModule.b();
        StvFragmentManager.a().a(param1String);
      }
      
      public void a(String param1String, ITranscodingVideoListener param1ITranscodingVideoListener) {
        ShortVideoModule.b();
        if (param1ITranscodingVideoListener == null)
          return; 
        if (TextUtils.isEmpty(param1String) || !(new File(param1String)).exists()) {
          param1ITranscodingVideoListener.a(false, param1String, null);
          return;
        } 
        EditDataModel editDataModel = StvMediaUtils.a(param1String);
        if (editDataModel == null || !editDataModel.isTranscode()) {
          Logger.b("StvMediaUtils", new Object[] { "no need Transcode" });
          param1ITranscodingVideoListener.a(param1String, false);
          return;
        } 
        Logger.b("StvMediaUtils", new Object[] { "need Transcode" });
        StvMediaUtils.a(editDataModel, param1ITranscodingVideoListener);
      }
      
      public boolean a() {
        ShortVideoModule.b();
        return StvFragmentManager.a().c();
      }
      
      public void b(Object param1Object, int param1Int1, int param1Int2) {
        ShortVideoModule.b();
        a(param1Object, param1Int1, 0, param1Int2);
      }
      
      public void b(String param1String) {
        ShortVideoModule.b();
        StvFragmentManager.a().b(param1String);
      }
      
      public boolean b() {
        ShortVideoModule.b();
        return StvFragmentManager.a().d();
      }
      
      public void c() {
        ShortVideoModule.b();
        StvFragmentManager.a().b();
      }
      
      public void d() {
        ShortVideoModule.b();
        StvMediaUtils.a();
      }
    };
  
  private static boolean b = false;
  
  public static void a() {
    ShortVideoProxy.e().a((IBaseInterface)a);
  }
  
  private static void c() {
    if (b) {
      PLShortVideoEnv.init(AppInfo.d());
      b = true;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\ShortVideoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */