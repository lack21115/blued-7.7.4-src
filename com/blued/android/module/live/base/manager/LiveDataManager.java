package com.blued.android.module.live.base.manager;

import com.blued.android.module.common.model.CommonGiftPackageModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveDataManager {
  private static volatile LiveDataManager a;
  
  private long b;
  
  private String c;
  
  private long d;
  
  private final Map<String, List<CommonGiftPackageModel>> e = new HashMap<String, List<CommonGiftPackageModel>>();
  
  private String f = null;
  
  private boolean g = false;
  
  private int h = 0;
  
  public static LiveDataManager a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/live/base/manager/LiveDataManager.a : Lcom/blued/android/module/live/base/manager/LiveDataManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/live/base/manager/LiveDataManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/live/base/manager/LiveDataManager.a : Lcom/blued/android/module/live/base/manager/LiveDataManager;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/live/base/manager/LiveDataManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/live/base/manager/LiveDataManager.a : Lcom/blued/android/module/live/base/manager/LiveDataManager;
    //   25: ldc com/blued/android/module/live/base/manager/LiveDataManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/live/base/manager/LiveDataManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/live/base/manager/LiveDataManager.a : Lcom/blued/android/module/live/base/manager/LiveDataManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(int paramInt) {
    this.h = paramInt;
  }
  
  public void a(long paramLong) {
    this.b = paramLong;
    this.c = String.valueOf(paramLong);
  }
  
  public void a(String paramString) {
    if (this.e.containsKey(paramString))
      this.e.remove(paramString); 
  }
  
  public void a(String paramString, List<CommonGiftPackageModel> paramList) {
    if (paramList != null && paramList.size() > 0) {
      if (b(paramString) != null)
        ((List)this.e.get(paramString)).clear(); 
      ((List<CommonGiftPackageModel>)this.e.get(paramString)).addAll(paramList);
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public List<CommonGiftPackageModel> b(String paramString) {
    if (!this.e.containsKey(paramString) || this.e.get(paramString) == null)
      this.e.put(paramString, new ArrayList<CommonGiftPackageModel>()); 
    return this.e.get(paramString);
  }
  
  public void b() {
    this.b = 0L;
    this.c = "";
    this.g = false;
  }
  
  public void b(long paramLong) {
    this.d = paramLong;
  }
  
  public String c() {
    return this.c;
  }
  
  public void c(String paramString) {
    if (paramString != null)
      this.f = paramString; 
  }
  
  public long d() {
    return this.d;
  }
  
  public String e() {
    return this.f;
  }
  
  public boolean f() {
    return this.g;
  }
  
  public int g() {
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\manager\LiveDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */