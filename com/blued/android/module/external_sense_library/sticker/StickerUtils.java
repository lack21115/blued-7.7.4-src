package com.blued.android.module.external_sense_library.sticker;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.external_sense_library.model.StickerDataModel;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.SenseLibSPMgr;
import com.google.gson.reflect.TypeToken;

public class StickerUtils {
  private static final String a;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_");
    stringBuilder.append(StickerUtils.class.getSimpleName());
    a = stringBuilder.toString();
  }
  
  public static StickerDataModel a() {
    String str1 = SenseLibSPMgr.a().b();
    if (TextUtils.isEmpty(str1))
      return new StickerDataModel(); 
    String str2 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("readStickerConfig:");
    stringBuilder.append(str1);
    LogUtils.b(str2, stringBuilder.toString(), new Object[0]);
    return (StickerDataModel)AppInfo.f().fromJson(str1, (new TypeToken<StickerDataModel>() {
        
        }).getType());
  }
  
  public static void a(StickerDataModel paramStickerDataModel) {
    if (paramStickerDataModel == null) {
      LogUtils.b(a, "stickerDataModel ==null", new Object[0]);
      return;
    } 
    String str1 = AppInfo.f().toJson(paramStickerDataModel);
    String str2 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("writeStickerConfig:");
    stringBuilder.append(str1);
    LogUtils.b(str2, stringBuilder.toString(), new Object[0]);
    SenseLibSPMgr.a().a(str1);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      LogUtils.b(a, "writeStickerConfig name == null || path == null", new Object[0]);
      return;
    } 
    StickerDataModel stickerDataModel = a();
    stickerDataModel.a(paramString1, paramString2, paramString3, paramInt);
    a(stickerDataModel);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\sticker\StickerUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */