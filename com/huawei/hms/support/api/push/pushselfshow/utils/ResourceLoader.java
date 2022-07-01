package com.huawei.hms.support.api.push.pushselfshow.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

public class ResourceLoader {
  public static final String TAG = "ResourceLoader";
  
  public static int loadArrayResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "array", paramString);
  }
  
  public static int loadColorResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "color", paramString);
  }
  
  public static int loadDimenResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "dimen", paramString);
  }
  
  public static int loadDrawableResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "drawable", paramString);
  }
  
  public static int loadDrawableResourceIdByMetaDataName(Context paramContext, String paramString) {
    try {
      ApplicationInfo applicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (applicationInfo != null) {
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null)
          return bundle.getInt(paramString); 
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      HMSLog.w("ResourceLoader", "load meta data resource failed.");
    } 
    return 0;
  }
  
  public static int loadIdResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "id", paramString);
  }
  
  public static int loadLayoutResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "layout", paramString);
  }
  
  public static int loadMenuResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "menu", paramString);
  }
  
  public static int loadPluralsResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "plurals", paramString);
  }
  
  public static int loadResourceId(Context paramContext, String paramString1, String paramString2) {
    try {
      int j = paramContext.getResources().getIdentifier(paramString2, paramString1, paramContext.getPackageName());
      int i = j;
      if (j == 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramContext.getPackageName());
        stringBuilder.append(".R$");
        stringBuilder.append(paramString1);
        Field field = Class.forName(stringBuilder.toString()).getField(paramString2);
        j = Integer.parseInt(field.get(field.getName()).toString());
        i = j;
        if (j == 0) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Error-resourceType=");
          stringBuilder1.append(paramString1);
          stringBuilder1.append("--resourceName=");
          stringBuilder1.append(paramString2);
          stringBuilder1.append("--resourceId =");
          stringBuilder1.append(j);
          HMSLog.i("ResourceLoader", stringBuilder1.toString());
          i = j;
        } 
      } 
      return i;
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("!!!! ResourceLoader: ClassNotFoundException-resourceType=");
      stringBuilder.append(paramString1);
      stringBuilder.append("--resourceName=");
      stringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", stringBuilder.toString(), classNotFoundException);
    } catch (NoSuchFieldException noSuchFieldException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("!!!! ResourceLoader: NoSuchFieldException-resourceType=");
      stringBuilder.append(paramString1);
      stringBuilder.append("--resourceName=");
      stringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", stringBuilder.toString(), noSuchFieldException);
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("!!!! ResourceLoader: NumberFormatException-resourceType=");
      stringBuilder.append(paramString1);
      stringBuilder.append("--resourceName=");
      stringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", stringBuilder.toString(), numberFormatException);
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("!!!! ResourceLoader: IllegalAccessException-resourceType=");
      stringBuilder.append(paramString1);
      stringBuilder.append("--resourceName=");
      stringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", stringBuilder.toString(), illegalAccessException);
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("!!!! ResourceLoader: IllegalArgumentException-resourceType=");
      stringBuilder.append(paramString1);
      stringBuilder.append("--resourceName=");
      stringBuilder.append(paramString2);
      HMSLog.e("ResourceLoader", stringBuilder.toString(), illegalArgumentException);
    } 
    return 0;
  }
  
  public static int loadStringResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "string", paramString);
  }
  
  public static int loadStyleResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "style", paramString);
  }
  
  public static int loadXmlResourceId(Context paramContext, String paramString) {
    return loadResourceId(paramContext, "xml", paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\push\pushselfsho\\utils\ResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */