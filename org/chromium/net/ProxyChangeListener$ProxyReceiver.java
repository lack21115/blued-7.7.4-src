package org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.base.annotations.UsedByReflection;

@UsedByReflection
class ProxyChangeListener$ProxyReceiver extends BroadcastReceiver {
  private ProxyChangeListener$ProxyReceiver() {}
  
  private static ProxyChangeListener$ProxyConfig extractNewProxy(Intent paramIntent) {
    try {
      String[] arrayOfString;
      String str2;
      String str3;
      if (Build.VERSION.SDK_INT < 21) {
        str2 = "android.net.ProxyProperties";
        str3 = "proxy";
      } else {
        str2 = "android.net.ProxyInfo";
        str3 = "android.intent.extra.PROXY_INFO";
      } 
      Object object = paramIntent.getExtras().get(str3);
      if (object == null)
        return null; 
      Class<?> clazz = Class.forName(str2);
      Method method2 = clazz.getDeclaredMethod("getHost", new Class[0]);
      Method method1 = clazz.getDeclaredMethod("getPort", new Class[0]);
      Method method3 = clazz.getDeclaredMethod("getExclusionList", new Class[0]);
      String str1 = (String)method2.invoke(object, new Object[0]);
      int i = ((Integer)method1.invoke(object, new Object[0])).intValue();
      if (Build.VERSION.SDK_INT < 21) {
        arrayOfString = ((String)method3.invoke(object, new Object[0])).split(",");
      } else {
        arrayOfString = (String[])method3.invoke(object, new Object[0]);
      } 
      if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
        object = clazz.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(object, new Object[0]);
        if (!TextUtils.isEmpty((CharSequence)object))
          return new ProxyChangeListener$ProxyConfig(str1, i, (String)object, arrayOfString); 
      } else if (Build.VERSION.SDK_INT >= 21) {
        object = clazz.getDeclaredMethod("getPacFileUrl", new Class[0]).invoke(object, new Object[0]);
        if (!Uri.EMPTY.equals(object))
          return new ProxyChangeListener$ProxyConfig(str1, i, object.toString(), arrayOfString); 
      } 
      return new ProxyChangeListener$ProxyConfig(str1, i, null, arrayOfString);
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder("Using no proxy configuration due to exception:");
      stringBuilder.append(classNotFoundException);
      Log.e("ProxyChangeListener", stringBuilder.toString());
      return null;
    } catch (NoSuchMethodException noSuchMethodException) {
      StringBuilder stringBuilder = new StringBuilder("Using no proxy configuration due to exception:");
      stringBuilder.append(noSuchMethodException);
      Log.e("ProxyChangeListener", stringBuilder.toString());
      return null;
    } catch (IllegalAccessException illegalAccessException) {
      StringBuilder stringBuilder = new StringBuilder("Using no proxy configuration due to exception:");
      stringBuilder.append(illegalAccessException);
      Log.e("ProxyChangeListener", stringBuilder.toString());
      return null;
    } catch (InvocationTargetException invocationTargetException) {
      StringBuilder stringBuilder = new StringBuilder("Using no proxy configuration due to exception:");
      stringBuilder.append(invocationTargetException);
      Log.e("ProxyChangeListener", stringBuilder.toString());
      return null;
    } catch (NullPointerException nullPointerException) {
      StringBuilder stringBuilder = new StringBuilder("Using no proxy configuration due to exception:");
      stringBuilder.append(nullPointerException);
      Log.e("ProxyChangeListener", stringBuilder.toString());
      return null;
    } 
  }
  
  @UsedByReflection
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (paramIntent.getAction().equals("android.intent.action.PROXY_CHANGE"))
      ProxyChangeListener.access$200(ProxyChangeListener.this, new ProxyChangeListener$ProxyReceiver$1(this, paramIntent)); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\ProxyChangeListener$ProxyReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */