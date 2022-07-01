package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class ManifestParser {
  private final Context a;
  
  public ManifestParser(Context paramContext) {
    this.a = paramContext;
  }
  
  private static GlideModule a(String paramString) {
    try {
      Class<?> clazz = Class.forName(paramString);
      paramString = null;
      try {
        String str = (String)clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        paramString = str;
      } catch (InstantiationException instantiationException) {
        a(clazz, instantiationException);
      } catch (IllegalAccessException illegalAccessException) {
        a(clazz, illegalAccessException);
      } catch (NoSuchMethodException noSuchMethodException) {
        a(clazz, noSuchMethodException);
      } catch (InvocationTargetException invocationTargetException) {
        a(clazz, invocationTargetException);
      } 
      if (paramString instanceof GlideModule)
        return (GlideModule)paramString; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Expected instanceof GlideModule, but found: ");
      stringBuilder.append(paramString);
      throw new RuntimeException(stringBuilder.toString());
    } catch (ClassNotFoundException classNotFoundException) {
      throw new IllegalArgumentException("Unable to find GlideModule implementation", classNotFoundException);
    } 
  }
  
  private static void a(Class<?> paramClass, Exception paramException) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unable to instantiate GlideModule implementation for ");
    stringBuilder.append(paramClass);
    throw new RuntimeException(stringBuilder.toString(), paramException);
  }
  
  public List<GlideModule> a() {
    if (Log.isLoggable("ManifestParser", 3))
      Log.d("ManifestParser", "Loading Glide modules"); 
    ArrayList<GlideModule> arrayList = new ArrayList();
    try {
      ApplicationInfo applicationInfo = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128);
      if (applicationInfo.metaData == null) {
        if (Log.isLoggable("ManifestParser", 3)) {
          Log.d("ManifestParser", "Got null app info metadata");
          return arrayList;
        } 
      } else {
        if (Log.isLoggable("ManifestParser", 2)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Got app info metadata: ");
          stringBuilder.append(applicationInfo.metaData);
          Log.v("ManifestParser", stringBuilder.toString());
        } 
        for (String str : applicationInfo.metaData.keySet()) {
          if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
            arrayList.add(a(str));
            if (Log.isLoggable("ManifestParser", 3)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Loaded Glide module: ");
              stringBuilder.append(str);
              Log.d("ManifestParser", stringBuilder.toString());
            } 
          } 
        } 
        if (Log.isLoggable("ManifestParser", 3))
          Log.d("ManifestParser", "Finished loading Glide modules"); 
        return arrayList;
      } 
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      throw new RuntimeException("Unable to find metadata to parse GlideModules", nameNotFoundException);
    } 
    return (List<GlideModule>)nameNotFoundException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\module\ManifestParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */