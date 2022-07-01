package com.blued.android.module.external_sense_library.sticker;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.external_sense_library.contract.IGetStickerListener;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.external_sense_library.model.StickerDataModel;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.StickerConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class StickerLoader {
  private static final String a;
  
  private Map<String, Integer> b = new HashMap<String, Integer>();
  
  private HashMap<String, IGetStickerListener> c = new HashMap<String, IGetStickerListener>();
  
  private volatile Hashtable<String, StickerBaseModel> d = new Hashtable<String, StickerBaseModel>();
  
  private volatile StickerDataModel e = StickerUtils.a();
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Blued_Sense_");
    stringBuilder.append(StickerLoader.class.getSimpleName());
    a = stringBuilder.toString();
  }
  
  private StickerLoader() {
    if (this.e.a != null && !this.e.a.isEmpty()) {
      ArrayList<StickerBaseModel> arrayList = new ArrayList();
      for (StickerBaseModel stickerBaseModel : this.e.a) {
        if (stickerBaseModel != null && !TextUtils.isEmpty(stickerBaseModel.name)) {
          if (!this.d.containsKey(stickerBaseModel.name)) {
            this.d.put(stickerBaseModel.name, stickerBaseModel);
            this.b.put(stickerBaseModel.name, Integer.valueOf(stickerBaseModel.stickerState));
            continue;
          } 
          arrayList.add(stickerBaseModel);
        } 
      } 
      if (arrayList.size() > 0) {
        for (StickerBaseModel stickerBaseModel : arrayList)
          this.e.a.remove(stickerBaseModel); 
        StickerUtils.a(this.e);
      } 
    } 
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt) {
    if (((Integer)this.b.get(paramString1)).intValue() != 2) {
      this.b.put(paramString1, Integer.valueOf(paramInt));
      StickerBaseModel stickerBaseModel2 = this.d.get(paramString1);
      StickerBaseModel stickerBaseModel1 = stickerBaseModel2;
      if (stickerBaseModel2 == null)
        stickerBaseModel1 = new StickerBaseModel(); 
      stickerBaseModel1.name = paramString1;
      stickerBaseModel1.path = paramString2;
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString1);
      stringBuilder.append(" | 1 localPath:");
      stringBuilder.append(paramString3);
      LogUtils.b(str, stringBuilder.toString(), new Object[0]);
      stickerBaseModel1.localPath = paramString3;
      stickerBaseModel1.stickerState = paramInt;
      this.d.put(paramString1, stickerBaseModel1);
      StickerUtils.a(paramString1, paramString2, paramString3, paramInt);
    } 
  }
  
  public Map<String, Integer> a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.putAll(this.b);
    return (Map)hashMap;
  }
  
  public void a(String paramString1, String paramString2, IGetStickerListener paramIGetStickerListener, IRequestHost paramIRequestHost) {
    if (paramIGetStickerListener != null)
      this.c.put(paramString1, paramIGetStickerListener); 
    if (!StickerDownLoader.a(paramString1)) {
      StickerDownLoader.a(paramString1, paramString2, new IGetStickerListener(this, paramString1, paramString2) {
            public void onFailed(ErrorCode.PlayStickerCode param1PlayStickerCode, String param1String) {
              StickerLoader stickerLoader = this.c;
              String str = this.a;
              StickerLoader.a(stickerLoader, str, this.b, StickerConfig.a(str), 0);
              AppInfo.n().post(new Runnable(this, param1PlayStickerCode, param1String) {
                    public void run() {
                      if (StickerLoader.a(this.c.c).get(this.c.a) != null)
                        ((IGetStickerListener)StickerLoader.a(this.c.c).get(this.c.a)).onFailed(this.a, this.b); 
                    }
                  });
            }
            
            public void onSuccess(String param1String1, String param1String2) {
              StickerLoader.a(this.c, param1String1, this.b, param1String2, 2);
              AppInfo.n().post(new Runnable(this, param1String1, param1String2) {
                    public void run() {
                      if (StickerLoader.a(this.c.c).get(this.a) != null)
                        ((IGetStickerListener)StickerLoader.a(this.c.c).get(this.a)).onSuccess(this.a, this.b); 
                    }
                  });
            }
            
            public void onSyncStart() {
              StickerLoader stickerLoader = this.c;
              String str = this.a;
              StickerLoader.a(stickerLoader, str, this.b, StickerConfig.a(str), 1);
              AppInfo.n().post(new Runnable(this) {
                    public void run() {
                      if (StickerLoader.a(this.a.c).get(this.a.a) != null)
                        ((IGetStickerListener)StickerLoader.a(this.a.c).get(this.a.a)).onSyncStart(); 
                    }
                  });
            }
          }paramIRequestHost);
      return;
    } 
    a(paramString1, paramString2, "", 1);
    paramString2 = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(" _贴纸正在下载...");
    LogUtils.d(paramString2, stringBuilder.toString(), new Object[0]);
  }
  
  public void a(List<StickerBaseModel> paramList) {
    if (paramList != null) {
      ArrayList<StickerBaseModel> arrayList = new ArrayList();
      for (StickerBaseModel stickerBaseModel : paramList) {
        if (stickerBaseModel != null && !TextUtils.isEmpty(stickerBaseModel.name) && !TextUtils.isEmpty(stickerBaseModel.path) && !this.d.containsKey(stickerBaseModel.name)) {
          this.d.put(stickerBaseModel.name, stickerBaseModel);
          this.b.put(stickerBaseModel.name, Integer.valueOf(stickerBaseModel.stickerState));
          arrayList.add(stickerBaseModel);
        } 
      } 
      if ((this.e.a == null || this.e.a.size() <= 0) && arrayList.size() > 0) {
        this.e.a.addAll(arrayList);
        StickerUtils.a(this.e);
      } 
    } 
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield d : Ljava/util/Hashtable;
    //   13: aload_1
    //   14: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   17: ifeq -> 68
    //   20: aload_0
    //   21: getfield d : Ljava/util/Hashtable;
    //   24: aload_1
    //   25: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast com/blued/android/module/external_sense_library/model/StickerBaseModel
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull -> 68
    //   36: aload_3
    //   37: getfield localPath : Ljava/lang/String;
    //   40: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   43: ifne -> 68
    //   46: new java/io/File
    //   49: dup
    //   50: aload_3
    //   51: getfield localPath : Ljava/lang/String;
    //   54: invokespecial <init> : (Ljava/lang/String;)V
    //   57: invokevirtual exists : ()Z
    //   60: ifeq -> 68
    //   63: iconst_1
    //   64: istore_2
    //   65: goto -> 70
    //   68: iconst_0
    //   69: istore_2
    //   70: iload_2
    //   71: ifeq -> 91
    //   74: aload_0
    //   75: getfield b : Ljava/util/Map;
    //   78: aload_1
    //   79: iconst_2
    //   80: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   83: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   88: pop
    //   89: iload_2
    //   90: ireturn
    //   91: aload_0
    //   92: getfield b : Ljava/util/Map;
    //   95: aload_1
    //   96: iconst_0
    //   97: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   100: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   105: pop
    //   106: iload_2
    //   107: ireturn
  }
  
  public static class Builder {
    public StickerLoader a() {
      return new StickerLoader();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\sticker\StickerLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */