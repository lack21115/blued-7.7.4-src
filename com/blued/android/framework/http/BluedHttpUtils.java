package com.blued.android.framework.http;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.provider.ProviderHolder;
import com.google.gson.reflect.TypeToken;

public class BluedHttpUtils {
  public static boolean a = false;
  
  public static IErrorHandler b = new IErrorHandler() {
      public boolean a(int param1Int, String param1String) {
        if (param1Int == 401) {
          ProviderHolder.a().b().a(param1String);
        } else if (param1Int == 4010001) {
          ProviderHolder.a().b().c();
        } else if (param1Int == 4031101 || param1Int == 4031102 || param1Int == 4031201 || param1Int == 403009032) {
          ProviderHolder.a().b().d();
        } 
        if ((BluedHttpUtils.a || param1Int >= 0) && !TextUtils.isEmpty(param1String))
          AppMethods.a(param1String); 
        return true;
      }
    };
  
  public static Pair<Integer, String> a(Throwable paramThrowable, int paramInt, String paramString) {
    int i = 0;
    byte b = 0;
    if (paramThrowable != null && paramThrowable instanceof javax.net.ssl.SSLException)
      return new Pair(Integer.valueOf(0), ProviderHolder.a().c().b()); 
    String str2 = "";
    int j = b;
    String str1 = str2;
    try {
      if (!TextUtils.isEmpty(paramString)) {
        j = b;
        BluedEntityA bluedEntityA = (BluedEntityA)AppInfo.f().fromJson(paramString, (new TypeToken<BluedEntityA<Object>>() {
            
            }).getType());
        j = b;
        i = bluedEntityA.code;
        j = i;
        String str = bluedEntityA.message;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      str1 = str2;
      i = j;
    } 
    if (i != 0)
      paramInt = i; 
    paramString = str1;
    if (TextUtils.isEmpty(str1))
      paramString = ProviderHolder.a().c().a(paramInt); 
    return new Pair(Integer.valueOf(paramInt), paramString);
  }
  
  public static void a(boolean paramBoolean) {
    if (AppInfo.m() || paramBoolean) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    a = paramBoolean;
  }
  
  @Deprecated
  public static boolean a(int paramInt, String paramString) {
    return b(null, paramInt, paramString);
  }
  
  @Deprecated
  public static boolean a(Throwable paramThrowable, int paramInt, String paramString, IErrorHandler paramIErrorHandler) {
    boolean bool;
    if (paramInt == 200 && paramThrowable == null)
      return true; 
    Pair<Integer, String> pair = a(paramThrowable, paramInt, paramString);
    paramInt = ((Integer)pair.first).intValue();
    String str = (String)pair.second;
    if (paramIErrorHandler != null) {
      bool = paramIErrorHandler.a(paramInt, str);
    } else {
      bool = false;
    } 
    if (!bool)
      b.a(paramInt, str); 
    return false;
  }
  
  @Deprecated
  public static boolean b(Throwable paramThrowable, int paramInt, String paramString) {
    return a(paramThrowable, paramInt, paramString, null);
  }
  
  public static interface IErrorHandler {
    boolean a(int param1Int, String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\http\BluedHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */