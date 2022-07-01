package com.blued.android.modules;

import android.provider.MediaStore;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.base.album.ITakePhoto;
import com.blued.android.module.base.album.TakePhotoProxy;
import com.blued.android.module.base.base.IBaseInterface;
import java.io.File;
import java.io.FileNotFoundException;

public class TakePhotoModule {
  protected static ITakePhoto a = new ITakePhoto() {
      public void a(String param1String) {
        if ((new File(param1String)).exists()) {
          try {
            String str = param1String.substring(param1String.lastIndexOf("/") + 1, param1String.length() - 1);
            if (!TextUtils.isEmpty(str))
              MediaStore.Images.Media.insertImage(AppInfo.d().getContentResolver(), param1String, str, null); 
          } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
          } 
          AppUtils.a(AppInfo.d(), param1String, false);
        } 
      }
    };
  
  public static void a() {
    TakePhotoProxy.a().a((IBaseInterface)a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\modules\TakePhotoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */