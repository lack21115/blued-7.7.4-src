package org.chromium.android_webview;

import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Iterator;
import org.chromium.base.Callback;
import org.chromium.base.ThreadUtils;
import org.chromium.net.GURLUtils;

public final class AwGeolocationPermissions {
  public final SharedPreferences mSharedPreferences;
  
  public AwGeolocationPermissions(SharedPreferences paramSharedPreferences) {
    this.mSharedPreferences = paramSharedPreferences;
  }
  
  public static String getOriginKey(String paramString) {
    paramString = GURLUtils.getOrigin(paramString);
    if (paramString.isEmpty())
      return null; 
    StringBuilder stringBuilder = new StringBuilder("AwGeolocationPermissions%");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public final void allow(String paramString) {
    paramString = getOriginKey(paramString);
    if (paramString != null)
      this.mSharedPreferences.edit().putBoolean(paramString, true).apply(); 
  }
  
  public final void clear(String paramString) {
    paramString = getOriginKey(paramString);
    if (paramString != null)
      this.mSharedPreferences.edit().remove(paramString).apply(); 
  }
  
  public final void clearAll() {
    Iterator<String> iterator = this.mSharedPreferences.getAll().keySet().iterator();
    SharedPreferences.Editor editor;
    for (editor = null; iterator.hasNext(); editor = editor1) {
      String str = iterator.next();
      SharedPreferences.Editor editor1 = editor;
      if (str.startsWith("AwGeolocationPermissions%")) {
        editor1 = editor;
        if (editor == null)
          editor1 = this.mSharedPreferences.edit(); 
        editor1.remove(str);
      } 
    } 
    if (editor != null)
      editor.apply(); 
  }
  
  public final void getAllowed(String paramString, Callback paramCallback) {
    ThreadUtils.postOnUiThread(new AwGeolocationPermissions$$Lambda$0(paramCallback, isOriginAllowed(paramString)));
  }
  
  public final void getOrigins(Callback paramCallback) {
    HashSet<String> hashSet = new HashSet();
    for (String str : this.mSharedPreferences.getAll().keySet()) {
      if (str.startsWith("AwGeolocationPermissions%"))
        hashSet.add(str.substring(25)); 
    } 
    ThreadUtils.postOnUiThread(new AwGeolocationPermissions$$Lambda$1(paramCallback, hashSet));
  }
  
  public final boolean isOriginAllowed(String paramString) {
    return this.mSharedPreferences.getBoolean(getOriginKey(paramString), false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwGeolocationPermissions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */