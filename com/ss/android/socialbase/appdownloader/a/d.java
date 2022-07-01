package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.downloader.g.c;
import java.io.File;
import org.json.JSONObject;

public class d {
  public static a a(Context paramContext, String paramString, JSONObject paramJSONObject, c paramc) {
    h h;
    String str2 = null;
    String str1 = str2;
    if (paramc != null) {
      str1 = str2;
      if (paramContext != null) {
        if (paramJSONObject == null)
          return null; 
        str1 = paramc.k();
        if (TextUtils.isEmpty(str1))
          return null; 
        File file = new File(str1);
        byte b = -1;
        switch (paramString.hashCode()) {
          case 112220422:
            if (paramString.equals("vivo2"))
              b = 1; 
            break;
          case 112220421:
            if (paramString.equals("vivo1"))
              b = 0; 
            break;
          case 105958546:
            if (paramString.equals("oppo2"))
              b = 3; 
            break;
          case 105958545:
            if (paramString.equals("oppo1"))
              b = 2; 
            break;
          case -1349088399:
            if (paramString.equals("custom"))
              b = 4; 
            break;
        } 
        if (b != 0)
          return (a)((b != 1) ? ((b != 2) ? ((b != 3) ? ((b != 4) ? null : new c(paramContext, file.getAbsolutePath(), paramJSONObject)) : new g(paramContext, file.getAbsolutePath())) : new f(paramContext, file.getAbsolutePath())) : new i(paramContext, file.getAbsolutePath())); 
        h = new h(paramContext, paramc.n());
      } 
    } 
    return h;
  }
  
  public static boolean a(Context paramContext, String paramString, JSONObject paramJSONObject) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {
      i i;
      h h;
      if (paramString == null)
        return false; 
      Context context = null;
      String str = c.a(paramContext);
      if (TextUtils.isEmpty(str))
        return false; 
      byte b = -1;
      switch (paramString.hashCode()) {
        case 112220422:
          if (paramString.equals("vivo2"))
            b = 1; 
          break;
        case 112220421:
          if (paramString.equals("vivo1"))
            b = 0; 
          break;
        case 105958546:
          if (paramString.equals("oppo2"))
            b = 3; 
          break;
        case 105958545:
          if (paramString.equals("oppo1"))
            b = 2; 
          break;
        case -1349088399:
          if (paramString.equals("custom"))
            b = 4; 
          break;
      } 
      if (b != 0) {
        f f;
        if (b != 1) {
          g g;
          if (b != 2) {
            c c;
            if (b != 3) {
              if (b != 4) {
                paramContext = context;
              } else {
                c = new c(paramContext, str, paramJSONObject);
              } 
            } else {
              g = new g((Context)c, str);
            } 
          } else {
            f = new f((Context)g, str);
          } 
        } else {
          i = new i((Context)f, str);
        } 
      } else {
        h = new h((Context)i, str);
      } 
      bool1 = bool2;
      if (h != null) {
        bool1 = bool2;
        if (h.a())
          bool1 = true; 
      } 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */