package com.soft.blued.utils.password;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.DelayRepeatTaskUtils;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.google.gson.Gson;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.regex.Pattern;

public class PasswordCheckUtils {
  private static PasswordCheckUtils a;
  
  private CheckCallBackListener b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private String g;
  
  private Context h;
  
  private int i;
  
  private IRequestHost j;
  
  private BluedUIHttpResponse a(PWD_CHECK_PAGE paramPWD_CHECK_PAGE) {
    return new BluedUIHttpResponse<BluedEntityA<PasswordCheckResultModel>>(this, this.j, paramPWD_CHECK_PAGE) {
        int a;
        
        String b;
        
        boolean c;
        
        protected BluedEntityA<PasswordCheckResultModel> a(String param1String) {
          if (PasswordCheckUtils.null.a[this.d.ordinal()] != 2)
            return (BluedEntityA<PasswordCheckResultModel>)super.parseData(param1String); 
          BluedEntityA<PasswordCheckResultModel> bluedEntityA = (BluedEntityA)super.parseData(param1String);
          if (bluedEntityA != null)
            try {
              if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                String str = AesCrypto.c(((PasswordCheckResultModel)bluedEntityA.data.get(0))._);
                PasswordCheckResultModel passwordCheckResultModel = (PasswordCheckResultModel)AppInfo.f().fromJson(str, PasswordCheckResultModel.class);
                bluedEntityA.data.set(0, passwordCheckResultModel);
                return bluedEntityA;
              } 
            } catch (Exception exception) {
              exception.printStackTrace();
              this.c = true;
            }  
          return bluedEntityA;
        }
        
        protected void a(BluedEntityA<PasswordCheckResultModel> param1BluedEntityA) {
          if (PasswordCheckUtils.a(this.e) != null) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              Logger.a("pwd_check", param1BluedEntityA);
              PasswordCheckResultModel passwordCheckResultModel = param1BluedEntityA.data.get(0);
              if (StringUtils.e(passwordCheckResultModel.password)) {
                this.a = 20;
                this.b = PasswordCheckUtils.b(this.e);
                return;
              } 
              this.a = passwordCheckResultModel.getStrength_level();
              this.b = passwordCheckResultModel.password;
              return;
            } 
            Logger.a("pwd_check", "no data back");
            this.a = 20;
          } 
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          this.c = true;
          this.a = 20;
          return true;
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.a);
          stringBuilder.append(";");
          stringBuilder.append(PasswordCheckUtils.c(this.e));
          stringBuilder.append(";");
          stringBuilder.append(PasswordCheckUtils.b(this.e));
          Logger.a("pwd_check", stringBuilder.toString());
          if ((this.c || PasswordCheckUtils.b(this.e).equals(this.b)) && PasswordCheckUtils.a(this.e) != null) {
            int i = Math.min(this.a, PasswordCheckUtils.c(this.e));
            stringBuilder = new StringBuilder();
            stringBuilder.append("min:");
            stringBuilder.append(i);
            Logger.a("pwd_check", stringBuilder.toString());
            if (i != 0) {
              if (i != 10) {
                if (i != 20) {
                  PasswordCheckUtils.a(this.e).a(i, PasswordCheckUtils.d(this.e).getString(2131758489));
                  return;
                } 
                PasswordCheckUtils.a(this.e).a(i, PasswordCheckUtils.d(this.e).getString(2131758493));
                return;
              } 
              PasswordCheckUtils.a(this.e).a(i, PasswordCheckUtils.d(this.e).getString(2131758494));
              return;
            } 
            PasswordCheckUtils.a(this.e).a(i, PasswordCheckUtils.d(this.e).getString(2131758492));
          } 
        }
      };
  }
  
  public static PasswordCheckUtils a() {
    // Byte code:
    //   0: ldc com/soft/blued/utils/password/PasswordCheckUtils
    //   2: monitorenter
    //   3: getstatic com/soft/blued/utils/password/PasswordCheckUtils.a : Lcom/soft/blued/utils/password/PasswordCheckUtils;
    //   6: ifnonnull -> 19
    //   9: new com/soft/blued/utils/password/PasswordCheckUtils
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/soft/blued/utils/password/PasswordCheckUtils.a : Lcom/soft/blued/utils/password/PasswordCheckUtils;
    //   19: getstatic com/soft/blued/utils/password/PasswordCheckUtils.a : Lcom/soft/blued/utils/password/PasswordCheckUtils;
    //   22: astore_0
    //   23: ldc com/soft/blued/utils/password/PasswordCheckUtils
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/soft/blued/utils/password/PasswordCheckUtils
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  private String a(String paramString) {
    String str = paramString;
    if (paramString != null) {
      if (TextUtils.isEmpty(paramString))
        return paramString; 
      if (paramString.contains("@")) {
        String[] arrayOfString = paramString.split("@");
        if (arrayOfString.length > 0)
          return arrayOfString[0]; 
      } 
      str = paramString;
      if (paramString.contains("-")) {
        String[] arrayOfString = paramString.split("-");
        str = paramString;
        if (arrayOfString.length >= 1)
          str = arrayOfString[1]; 
      } 
    } 
    return str;
  }
  
  private void b(PWD_CHECK_PAGE paramPWD_CHECK_PAGE) {
    ArrayMap<String, String> arrayMap = new ArrayMap();
    arrayMap.put("token", this.g);
    arrayMap.put("dev_id", DeviceUtils.g());
    arrayMap.put("type", "mobile");
    arrayMap.put("stage", "strength");
    arrayMap.put("password", this.f);
    arrayMap.put("dev_dna", BluedDeviceIdentity.a().d());
    arrayMap.put("smid", BluedDeviceIdentity.a().e());
    arrayMap.put("boxid", BluedDeviceIdentity.a().f());
    Logger.a("pwd_check", arrayMap);
    Map<String, String> map = BluedHttpTools.a();
    Gson gson = AppInfo.f();
    try {
      map.put("_", AesCrypto.b(gson.toJson(arrayMap)));
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/passport/identity");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)a(paramPWD_CHECK_PAGE), this.j).b(BluedHttpTools.a(false)).a(BluedHttpTools.a(map)).i();
  }
  
  private boolean b() {
    String str = this.e;
    return (str == null || TextUtils.isEmpty(str)) ? false : Pattern.compile("(?=^.{8,}$)(?=(?:.*?\\d){1})(?=.*[a-z])(?=(?:.*?[A-Z]){1})(?=(?:.*?[`~!@#$%^&*()_+=\\-\\\\\\[\\]{}'\";:/?.>,<|]){1})(?!.*\\s)[0-9a-zA-Z`~!@#$%^&*()_+=\\-\\\\\\[\\]{}'\";:/?.>,<|]*$").matcher(this.e).find();
  }
  
  private void c(PWD_CHECK_PAGE paramPWD_CHECK_PAGE) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("password", this.f);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/users/");
    stringBuilder.append((UserInfo.a().i()).uid);
    stringBuilder.append("/password");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)a(paramPWD_CHECK_PAGE), this.j).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  private boolean c() {
    String str = this.e;
    if (str != null) {
      if (TextUtils.isEmpty(str))
        return false; 
      if (Pattern.compile("^[0-9]+$").matcher(this.e).find() && this.e.length() < 14)
        return true; 
      if (Pattern.compile("^[a-z]+$").matcher(this.e).find() && (this.e.length() == 6 || this.e.length() == 7))
        return true; 
      if (Pattern.compile("^[A-Z]+$").matcher(this.e).find() && (this.e.length() == 6 || this.e.length() == 7))
        return true; 
    } 
    return false;
  }
  
  private int d() {
    String str2 = this.e;
    if (str2 == null || TextUtils.isEmpty(str2) || this.e.length() < 6)
      return 3; 
    if (this.e.equals(this.d))
      return 2; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("account:");
    stringBuilder.append(this.c);
    Logger.a("pwd_check", stringBuilder.toString());
    String str1 = this.c;
    if (str1 != null) {
      if (str1.equals(this.e))
        return 1; 
      str1 = a(this.c);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("email str:");
      stringBuilder1.append(str1);
      Logger.a("pwd_check", stringBuilder1.toString());
      if (str1.equals(this.e))
        return 1; 
    } 
    return 0;
  }
  
  public void a(Context paramContext, String paramString1, String paramString2) {
    PasswordCheckUtils passwordCheckUtils = a;
    passwordCheckUtils.c = paramString1;
    passwordCheckUtils.d = paramString2;
    this.h = paramContext;
  }
  
  public void a(CheckCallBackListener paramCheckCallBackListener, IRequestHost paramIRequestHost) {
    PasswordCheckUtils passwordCheckUtils = a;
    passwordCheckUtils.b = paramCheckCallBackListener;
    passwordCheckUtils.j = paramIRequestHost;
  }
  
  public void a(String paramString1, String paramString2, PWD_CHECK_PAGE paramPWD_CHECK_PAGE) {
    DelayRepeatTaskUtils.a("check_pwd_lvl", new -$$Lambda$PasswordCheckUtils$C0g-Xlj0V4KtYdJGIp8qhvk3-ao(this, paramString1, paramString2, paramPWD_CHECK_PAGE), 500);
  }
  
  static interface CLIENT_FORBIDDEN_RESULT {}
  
  public static interface CheckCallBackListener {
    void a();
    
    void a(int param1Int, String param1String);
  }
  
  public static interface PASSWORD_LVL {}
  
  public enum PWD_CHECK_PAGE {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\password\PasswordCheckUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */