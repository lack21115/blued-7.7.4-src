package com.blued.android.config;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.utils.BluedPreferences;

public class FlexDebugSevConfig {
  private static volatile FlexDebugSevConfig a;
  
  private DebugSevConfigModel b = h();
  
  public static FlexDebugSevConfig a() {
    // Byte code:
    //   0: getstatic com/blued/android/config/FlexDebugSevConfig.a : Lcom/blued/android/config/FlexDebugSevConfig;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/config/FlexDebugSevConfig
    //   8: monitorenter
    //   9: getstatic com/blued/android/config/FlexDebugSevConfig.a : Lcom/blued/android/config/FlexDebugSevConfig;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/config/FlexDebugSevConfig
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/config/FlexDebugSevConfig.a : Lcom/blued/android/config/FlexDebugSevConfig;
    //   25: ldc com/blued/android/config/FlexDebugSevConfig
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/config/FlexDebugSevConfig
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/config/FlexDebugSevConfig.a : Lcom/blued/android/config/FlexDebugSevConfig;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void a(DebugSevConfigModel paramDebugSevConfigModel) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("updateModel, ");
    stringBuilder.append(paramDebugSevConfigModel);
    Log.v("FlexDebugSevConfig", stringBuilder.toString());
    if (paramDebugSevConfigModel != null) {
      this.b = paramDebugSevConfigModel;
      g();
      return;
    } 
    BluedPreferences.as("");
  }
  
  private void g() {
    String str = AppInfo.f().toJson(this.b);
    if (!TextUtils.isEmpty(str))
      BluedPreferences.as(str); 
  }
  
  private DebugSevConfigModel h() {
    String str = BluedPreferences.eu();
    return !TextUtils.isEmpty(str) ? (DebugSevConfigModel)AppInfo.f().fromJson(str, DebugSevConfigModel.class) : new DebugSevConfigModel();
  }
  
  public DebugSevConfigModel b() {
    return this.b;
  }
  
  public void c() {
    AppHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<DebugSevConfigModel>>(this, null) {
          protected void a(BluedEntityA<DebugSevConfigModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              DebugSevConfigModel debugSevConfigModel = (DebugSevConfigModel)param1BluedEntityA.getSingleData();
              FlexDebugSevConfig.a(this.a, debugSevConfigModel);
              LiveMsgSendManager.a().c();
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            Log.e("FlexDebugSevConfig", "updateSevConfig failed");
            return true;
          }
        });
  }
  
  public boolean d() {
    return (b() != null && (b()).android_grpc_im == 1);
  }
  
  public boolean e() {
    return (b() != null && (b()).android_grpc_live == 1);
  }
  
  public void f() {
    a = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\config\FlexDebugSevConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */