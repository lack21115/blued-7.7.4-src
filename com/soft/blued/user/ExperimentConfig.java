package com.soft.blued.user;

import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.google.gson.Gson;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.login_register.model.PayExperimentConfigModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;

public class ExperimentConfig {
  private static ExperimentConfig b;
  
  private Gson a;
  
  private PayExperimentConfigModel c;
  
  private ExperimentConfig() {
    String str = BluedPreferences.F();
    this.a = AppInfo.f();
    if (!StringUtils.e(str)) {
      this.c = (PayExperimentConfigModel)this.a.fromJson(str, PayExperimentConfigModel.class);
      return;
    } 
    this.c = new PayExperimentConfigModel();
  }
  
  public static ExperimentConfig a() {
    // Byte code:
    //   0: ldc com/soft/blued/user/ExperimentConfig
    //   2: monitorenter
    //   3: getstatic com/soft/blued/user/ExperimentConfig.b : Lcom/soft/blued/user/ExperimentConfig;
    //   6: ifnonnull -> 19
    //   9: new com/soft/blued/user/ExperimentConfig
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/soft/blued/user/ExperimentConfig.b : Lcom/soft/blued/user/ExperimentConfig;
    //   19: getstatic com/soft/blued/user/ExperimentConfig.b : Lcom/soft/blued/user/ExperimentConfig;
    //   22: astore_0
    //   23: ldc com/soft/blued/user/ExperimentConfig
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/soft/blued/user/ExperimentConfig
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public PayExperimentConfigModel b() {
    return this.c;
  }
  
  public void c() {
    PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<PayExperimentConfigModel>>(this, null) {
          protected void a(BluedEntityA<PayExperimentConfigModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.getSingleData() != null) {
              ExperimentConfig.a(this.a, (PayExperimentConfigModel)param1BluedEntityA.getSingleData());
              try {
                BluedPreferences.g(ExperimentConfig.a(this.a).toJson(param1BluedEntityA.getSingleData()));
                return;
              } catch (Exception exception) {
                return;
              } 
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\user\ExperimentConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */