package com.soft.blued.utils.third;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.geetest.onelogin.OneLoginHelper;
import com.geetest.onelogin.listener.AbstractOneLoginListener;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.third.model.OneLoginResult;
import org.json.JSONObject;

public class GeeTestUtils {
  public static void a(Context paramContext) {
    boolean bool = AppInfo.m();
    OneLoginHelper.with().setLogEnable(bool).init(paramContext, "a37bfc7b589306b6b4784df1e130e548").register(null, 3000);
  }
  
  public static void a(onOneLoginGetResult paramonOneLoginGetResult) {
    OneLoginHelper.with().requestToken(new AbstractOneLoginListener(paramonOneLoginGetResult) {
          public void onResult(JSONObject param1JSONObject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("取号结果为：");
            stringBuilder.append(param1JSONObject.toString());
            Logger.a("GeeTest", stringBuilder.toString());
            OneLoginResult oneLoginResult = (OneLoginResult)AppInfo.f().fromJson(param1JSONObject.toString(), OneLoginResult.class);
            if (oneLoginResult != null) {
              if (oneLoginResult.status == 200) {
                GeeTestUtils.onOneLoginGetResult onOneLoginGetResult1 = this.a;
                if (onOneLoginGetResult1 != null) {
                  onOneLoginGetResult1.a(oneLoginResult);
                  return;
                } 
              } else {
                GeeTestUtils.onOneLoginGetResult onOneLoginGetResult1 = this.a;
                if (onOneLoginGetResult1 != null) {
                  onOneLoginGetResult1.a();
                  return;
                } 
              } 
            } else {
              GeeTestUtils.onOneLoginGetResult onOneLoginGetResult1 = this.a;
              if (onOneLoginGetResult1 != null)
                onOneLoginGetResult1.a(); 
            } 
          }
        });
  }
  
  public static interface onOneLoginGetResult {
    void a();
    
    void a(OneLoginResult param1OneLoginResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\third\GeeTestUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */