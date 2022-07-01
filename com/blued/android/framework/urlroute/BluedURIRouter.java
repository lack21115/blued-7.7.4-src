package com.blued.android.framework.urlroute;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.HashidEncryptTool;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class BluedURIRouter {
  private static final String a = BluedURIRouter.class.getName();
  
  private static volatile BluedURIRouter b;
  
  private ConcurrentHashMap<String, Action> c = new ConcurrentHashMap<String, Action>();
  
  private String d = null;
  
  private String[] e = null;
  
  private String[] f = null;
  
  private String g = "";
  
  private String h = "blued_uri_router.json";
  
  private String i = "blued_uri_prefix.json";
  
  private boolean j = true;
  
  public static BluedURIRouter a() {
    // Byte code:
    //   0: getstatic com/blued/android/framework/urlroute/BluedURIRouter.b : Lcom/blued/android/framework/urlroute/BluedURIRouter;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/framework/urlroute/BluedURIRouter
    //   8: monitorenter
    //   9: getstatic com/blued/android/framework/urlroute/BluedURIRouter.b : Lcom/blued/android/framework/urlroute/BluedURIRouter;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/framework/urlroute/BluedURIRouter
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/framework/urlroute/BluedURIRouter.b : Lcom/blued/android/framework/urlroute/BluedURIRouter;
    //   25: ldc com/blued/android/framework/urlroute/BluedURIRouter
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/framework/urlroute/BluedURIRouter
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/framework/urlroute/BluedURIRouter.b : Lcom/blued/android/framework/urlroute/BluedURIRouter;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private String a(String paramString1, String paramString2, String paramString3) {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return paramString3; 
      str = paramString2;
    } 
    return str;
  }
  
  private String e(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      paramString = paramString.trim();
      if (paramString.length() > 0)
        return paramString; 
    } 
    return "";
  }
  
  private String f(String paramString) {
    if (AppInfo.d() == null) {
      if (!AppInfo.m())
        return null; 
      throw new RuntimeException("AppInfo getAppContext() is null !");
    } 
    if (TextUtils.isEmpty(paramString)) {
      if (!AppInfo.m())
        return null; 
      throw new RuntimeException("config name is null !");
    } 
    try {
    
    } catch (Exception null) {
    
    } finally {
      paramString = null;
      if (paramString != null)
        try {
          paramString.close();
        } catch (Exception exception) {} 
    } 
    if (exception != null)
      try {
        exception.close();
        return null;
      } catch (Exception exception1) {
        return null;
      }  
    return null;
  }
  
  private boolean f() {
    try {
      if (this.e == null) {
        StringBuilder stringBuilder2;
        StringBuilder stringBuilder1;
        String str = f(this.i);
        if (TextUtils.isEmpty(str)) {
          if (!AppInfo.m())
            return false; 
          stringBuilder2 = new StringBuilder();
          stringBuilder2.append(this.i);
          stringBuilder2.append(" is empty !!");
          throw new RuntimeException(stringBuilder2.toString());
        } 
        JSONObject jSONObject = new JSONObject((String)stringBuilder2);
        this.d = jSONObject.optString("protocol");
        boolean bool = TextUtils.isEmpty(this.d);
        if (bool) {
          if (!AppInfo.m())
            return false; 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("protocal is empty in ");
          stringBuilder1.append(this.i);
          stringBuilder1.append(" !!");
          throw new RuntimeException(stringBuilder1.toString());
        } 
        JSONArray jSONArray2 = stringBuilder1.optJSONArray("hostname");
        if (jSONArray2 != null) {
          int j = jSONArray2.length();
          this.e = new String[j];
          for (int i = 0; i < j; i++)
            this.e[i] = jSONArray2.optString(i); 
        } 
        if (this.e == null || this.e.length == 0) {
          if (!AppInfo.m())
            return false; 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("hostname is empty in ");
          stringBuilder1.append(this.i);
          stringBuilder1.append(" !!");
          throw new RuntimeException(stringBuilder1.toString());
        } 
        JSONArray jSONArray1 = stringBuilder1.optJSONArray("cookie-domain");
        if (jSONArray1 != null) {
          int j = jSONArray1.length();
          this.f = new String[j];
          for (int i = 0; i < j; i++)
            this.f[i] = jSONArray1.optString(i); 
        } 
        if (this.f == null || this.f.length == 0) {
          if (!AppInfo.m())
            return false; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("cookie-domain is empty in ");
          stringBuilder.append(this.i);
          stringBuilder.append(" !!");
          throw new RuntimeException(stringBuilder.toString());
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return true;
  }
  
  private boolean g() {
    ConcurrentHashMap<String, Action> concurrentHashMap = this.c;
    if (concurrentHashMap == null || concurrentHashMap.size() == 0)
      try {
        String str = f(this.h);
        if (TextUtils.isEmpty(str))
          return false; 
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> iterator = jSONObject.keys();
        label45: while (true) {
          if (iterator.hasNext()) {
            String str2 = iterator.next();
            JSONObject jSONObject1 = jSONObject.optJSONObject(str2);
            if (jSONObject1 == null)
              continue; 
            String str3 = jSONObject1.optString("method", "");
            if (TextUtils.isEmpty(str3))
              continue; 
            String str1 = jSONObject1.optString("class", "");
            str = str1;
            if (TextUtils.isEmpty(str1)) {
              if (TextUtils.isEmpty(this.g)) {
                if (!AppInfo.m())
                  continue; 
                throw new RuntimeException("please invoke setDefaultAdapterClass() firstly !!");
              } 
              str = this.g;
            } 
            String str4 = jSONObject1.optString("return", "");
            Action action = new Action();
            action.a = str2;
            action.b = str;
            action.c = str3;
            action.d = str4.equalsIgnoreCase("void");
            if (jSONObject1.has("args")) {
              if (!jSONObject1.isNull("args")) {
                JSONArray jSONArray = jSONObject1.optJSONArray("args");
                if (jSONArray != null) {
                  int i = jSONArray.length();
                  if (i > 0) {
                    FunctionArguments[] arrayOfFunctionArguments = new FunctionArguments[i];
                    for (int j = 0;; j++) {
                      FunctionArguments functionArguments;
                      if (j < i) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(j);
                        functionArguments = new FunctionArguments();
                        functionArguments.a = jSONObject2.keys().next();
                        if (!jSONObject2.isNull(functionArguments.a)) {
                          jSONObject2 = jSONObject2.optJSONObject(functionArguments.a);
                          functionArguments.b = jSONObject2.optString("type", "");
                          functionArguments.c = jSONObject2.optString("default", "");
                          functionArguments.d = jSONObject2.optBoolean("require", false);
                        } 
                      } else {
                        action.e = arrayOfFunctionArguments;
                        this.c.put(str2, action);
                        continue label45;
                      } 
                      arrayOfFunctionArguments[j] = functionArguments;
                    } 
                    break;
                  } 
                  continue;
                } 
                continue;
              } 
              continue;
            } 
            continue;
          } 
          return true;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return true;
  }
  
  private boolean h() {
    return (f() && g());
  }
  
  public Uri a(String paramString, int paramInt) {
    if (!TextUtils.isEmpty(paramString) && paramString.trim().length() > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(paramInt);
      String str = stringBuilder.toString();
      return a("http://common.blued.com", "webbrowse", new String[] { "weburl", "webFromPage" }, new String[] { paramString, str });
    } 
    return null;
  }
  
  public Uri a(String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2) {
    if (!TextUtils.isEmpty(paramString2) && paramString2.trim().length() > 0) {
      StringBuilder stringBuilder = new StringBuilder(paramString1);
      stringBuilder.append("?action=");
      stringBuilder.append(paramString2);
      if (paramArrayOfString1 != null && paramArrayOfString2 != null && paramArrayOfString1.length == paramArrayOfString2.length) {
        int i = 0;
        while (true) {
          if (i < paramArrayOfString1.length) {
            if (!TextUtils.isEmpty(paramArrayOfString1[i]) && paramArrayOfString1[i].trim().length() != 0)
              try {
                stringBuilder.append("&");
                stringBuilder.append(paramArrayOfString1[i]);
                stringBuilder.append("=");
                stringBuilder.append(URLEncoder.encode(paramArrayOfString2[i], "UTF-8"));
              } catch (UnsupportedEncodingException unsupportedEncodingException) {} 
            i++;
            continue;
          } 
          return Uri.parse(stringBuilder.toString());
        } 
      } 
      return Uri.parse(stringBuilder.toString());
    } 
    return null;
  }
  
  public void a(String paramString) {
    this.g = e(paramString);
  }
  
  public void a(boolean paramBoolean) {
    this.j = paramBoolean;
  }
  
  public boolean a(Context paramContext, Uri paramUri) {
    if (paramUri == null)
      return false; 
    try {
      Action action = this.c.get(paramUri.getQueryParameter("action"));
      if (action == null)
        return false; 
      if (action.e == null || action.e.length == 0) {
        i = 0;
      } else {
        i = action.e.length;
      } 
      int j = i + 1;
      Class[] arrayOfClass = new Class[j];
      Object[] arrayOfObject = new Object[j];
      arrayOfClass[0] = Context.class;
      arrayOfObject[0] = paramContext;
      if (AppInfo.m()) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("paramsSize=");
        stringBuilder.append(j);
        Log.d(str, stringBuilder.toString());
      } 
      for (int i = 1;; i++) {
        String str = "''";
        if (i < j) {
          FunctionArguments functionArguments = action.e[i - 1];
          String str1 = paramUri.getQueryParameter(functionArguments.a);
          if (AppInfo.m()) {
            String str2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(functionArguments.a);
            stringBuilder.append(" = ");
            if (!TextUtils.isEmpty(str1))
              str = str1; 
            stringBuilder.append(str);
            Log.d(str2, stringBuilder.toString());
          } 
          if (functionArguments.d && TextUtils.isEmpty(str1))
            return false; 
          boolean bool = TextUtils.isEmpty(functionArguments.b);
          if (bool || functionArguments.b.equalsIgnoreCase("string")) {
            arrayOfClass[i] = String.class;
            arrayOfObject[i] = a(str1, functionArguments.c, "");
          } else {
            if (functionArguments.b.equalsIgnoreCase("hashid")) {
              arrayOfClass[i] = String.class;
              str1 = a(str1, functionArguments.c, "");
              str = str1;
              if (!TextUtils.isEmpty(str1)) {
                str1 = HashidEncryptTool.a(str1);
                str = str1;
                if (functionArguments.d) {
                  str = str1;
                  if (TextUtils.isEmpty(str1))
                    return false; 
                } 
              } 
            } else {
              bool = functionArguments.b.equalsIgnoreCase("int");
              if (bool) {
                arrayOfClass[i] = int.class;
                arrayOfObject[i] = Integer.valueOf(Integer.parseInt(a(str1, functionArguments.c, "0")));
              } else if (functionArguments.b.equalsIgnoreCase("long")) {
                arrayOfClass[i] = long.class;
                arrayOfObject[i] = Long.valueOf(Long.parseLong(a(str1, functionArguments.c, "0")));
              } else {
                bool = functionArguments.b.equalsIgnoreCase("float");
                if (bool) {
                  arrayOfClass[i] = float.class;
                  arrayOfObject[i] = Float.valueOf(Float.parseFloat(a(str1, functionArguments.c, "0.0")));
                } else if (functionArguments.b.equalsIgnoreCase("boolean")) {
                  arrayOfClass[i] = boolean.class;
                  arrayOfObject[i] = Boolean.valueOf(Boolean.parseBoolean(a(str1, functionArguments.c, "false")));
                } else if (functionArguments.b.equalsIgnoreCase("double")) {
                  arrayOfClass[i] = double.class;
                  arrayOfObject[i] = Double.valueOf(Double.parseDouble(a(str1, functionArguments.c, "0.0")));
                } 
              } 
              i++;
            } 
            arrayOfObject[i] = str;
          } 
        } else {
          if (AppInfo.m()) {
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            while (true) {
              if (i < arrayOfObject.length) {
                Object object;
                if (arrayOfObject[i] == null) {
                  str = "''";
                } else {
                  object = arrayOfObject[i];
                } 
                stringBuilder.append(object);
                j = i + 1;
                i = j;
                if (j < arrayOfObject.length) {
                  stringBuilder.append(", ");
                  i = j;
                } 
                continue;
              } 
              String str1 = a;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("\n  ");
              stringBuilder1.append(action.b);
              stringBuilder1.append("\n    ");
              if (action.d) {
                str = "void ";
              } else {
                str = "boolean ";
              } 
              stringBuilder1.append(str);
              stringBuilder1.append(action.c);
              stringBuilder1.append("( ");
              stringBuilder1.append(stringBuilder.toString());
              stringBuilder1.append(" )  \n ");
              Log.d(str1, stringBuilder1.toString());
              Method method = Class.forName(action.b).getMethod(action.c, arrayOfClass);
              if (action.d) {
                method.invoke(null, arrayOfObject);
                return true;
              } 
              return ((Boolean)method.invoke(null, arrayOfObject)).booleanValue();
            } 
            break;
          } 
          continue;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return false;
    } 
  }
  
  public void b(String paramString) {
    this.h = e(paramString);
  }
  
  public boolean b() {
    return this.j;
  }
  
  public String c() {
    return this.d;
  }
  
  public void c(String paramString) {
    this.i = e(paramString);
  }
  
  public Uri d(String paramString) {
    if (AppInfo.m()) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("url:");
      stringBuilder.append(paramString);
      Log.d(str, stringBuilder.toString());
    } 
    if (TextUtils.isEmpty(paramString))
      return null; 
    try {
      Uri uri = Uri.parse(paramString);
      if (uri == null || TextUtils.isEmpty(uri.getScheme())) {
        if (AppInfo.m()) {
          String str1 = a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("uri.getScheme():");
          stringBuilder.append(uri.getScheme());
          Log.d(str1, stringBuilder.toString());
        } 
        return null;
      } 
      if (!h())
        return null; 
      if (!uri.getScheme().equalsIgnoreCase(this.d)) {
        String[] arrayOfString = this.e;
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (arrayOfString != null) {
          String str1 = uri.getHost();
          String[] arrayOfString1 = this.e;
          int j = arrayOfString1.length;
          int i = 0;
          while (true) {
            bool1 = bool2;
            if (i < j) {
              if (arrayOfString1[i].equalsIgnoreCase(str1)) {
                bool1 = true;
                break;
              } 
              i++;
              continue;
            } 
            break;
          } 
        } 
        if (!bool1)
          return null; 
      } 
      String str = uri.getQueryParameter("action");
      if (TextUtils.isEmpty(str))
        return null; 
      if ((Action)this.c.get(str) == null)
        return null; 
    } catch (Exception exception) {
      return null;
    } 
    return (Uri)exception;
  }
  
  public String[] d() {
    return f() ? this.e : null;
  }
  
  public String[] e() {
    return f() ? this.f : null;
  }
  
  class Action {
    String a;
    
    String b;
    
    String c;
    
    boolean d = false;
    
    BluedURIRouter.FunctionArguments[] e = null;
    
    private Action(BluedURIRouter this$0) {}
  }
  
  class FunctionArguments {
    public String a = "";
    
    public String b = "";
    
    public String c = "";
    
    public boolean d = false;
    
    private FunctionArguments(BluedURIRouter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\urlroute\BluedURIRouter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */