package com.blued.android.module.external_sense_library.model;

import android.text.TextUtils;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StickerDataModel implements Serializable {
  private static final String b;
  
  public List<StickerBaseModel> a = new ArrayList<StickerBaseModel>();
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_");
    stringBuilder.append(StickerDataModel.class.getSimpleName());
    b = stringBuilder.toString();
  }
  
  private StickerBaseModel a(String paramString) {
    StickerBaseModel stickerBaseModel1;
    boolean bool = TextUtils.isEmpty(paramString);
    StickerBaseModel stickerBaseModel2 = null;
    if (bool)
      return null; 
    Iterator<StickerBaseModel> iterator = this.a.iterator();
    while (true) {
      stickerBaseModel1 = stickerBaseModel2;
      if (iterator.hasNext()) {
        stickerBaseModel1 = iterator.next();
        if (stickerBaseModel1 != null && paramString.equals(stickerBaseModel1.name))
          break; 
        continue;
      } 
      break;
    } 
    return stickerBaseModel1;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt) {
    StickerBaseModel stickerBaseModel1;
    boolean bool;
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2)) {
      LogUtils.b(b, "name==null || path==null", new Object[0]);
      return;
    } 
    StickerBaseModel stickerBaseModel2 = a(paramString1);
    if (stickerBaseModel2 == null) {
      stickerBaseModel2 = new StickerBaseModel();
      stickerBaseModel2.name = paramString1;
      bool = true;
      stickerBaseModel1 = stickerBaseModel2;
    } else {
      bool = false;
      stickerBaseModel1 = stickerBaseModel2;
    } 
    stickerBaseModel1.path = paramString2;
    stickerBaseModel1.localPath = paramString3;
    paramString2 = b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(stickerBaseModel1.name);
    stringBuilder.append(" | 3 localPath:");
    stringBuilder.append(stickerBaseModel1.localPath);
    LogUtils.b(paramString2, stringBuilder.toString(), new Object[0]);
    stickerBaseModel1.stickerState = paramInt;
    if (bool)
      this.a.add(stickerBaseModel1); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\model\StickerDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */