package com.bytedance.tea.crash.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.tea.crash.b.a;
import com.bytedance.tea.crash.b.a.a;
import com.bytedance.tea.crash.c;
import com.bytedance.tea.crash.c.c;
import com.bytedance.tea.crash.g.h;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.upload.b;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import org.json.JSONObject;

public final class d {
  private Context a;
  
  public d(Context paramContext) {
    this.a = paramContext;
  }
  
  private c a(String paramString, JSONObject paramJSONObject) {
    if (paramJSONObject == null && TextUtils.isEmpty(paramString))
      return null; 
    if (paramString.startsWith("launch_"))
      return c.a; 
    if (paramString.startsWith("anr_"))
      return c.d; 
    if (paramString.startsWith("java_")) {
      if (paramJSONObject.optInt("is_dart") == 1)
        return c.g; 
      if (paramJSONObject.optInt("isJava") == 1)
        return c.b; 
    } 
    return null;
  }
  
  private void a() {
    try {
      SharedPreferences sharedPreferences = this.a.getSharedPreferences("npth", 0);
      long l = sharedPreferences.getLong("history_time", -1L);
      if (l < 0L) {
        sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
        return;
      } 
      if (System.currentTimeMillis() - l > 86400000L) {
        com.bytedance.tea.crash.g.d.a(h.b(this.a));
        sharedPreferences.edit().putLong("history_time", System.currentTimeMillis()).apply();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private File[] a(File paramFile, String paramString) {
    return !paramFile.exists() ? null : (TextUtils.isEmpty(paramString) ? paramFile.listFiles() : paramFile.listFiles(new FilenameFilter(this) {
          public boolean accept(File param1File, String param1String) {
            return (param1String != null && param1String.endsWith(".npth"));
          }
        }));
  }
  
  private void b() {
    File[] arrayOfFile = a(h.a(this.a), ".npth");
    if (arrayOfFile == null)
      return; 
    Arrays.sort(arrayOfFile, Collections.reverseOrder());
    for (int i = 0; i < arrayOfFile.length && i < 50; i++) {
      File file = arrayOfFile[i];
      try {
        if (a.a().a(file.getAbsolutePath())) {
          com.bytedance.tea.crash.g.d.a(file);
        } else {
          c c = com.bytedance.tea.crash.g.d.c(file.getAbsolutePath());
          if (c != null && c.b() != null) {
            JSONObject jSONObject = c.b();
            a(file.getName(), jSONObject);
            c.b().put("upload_scene", "launch_scan");
            if (b.a(c.a(), jSONObject.toString(), c.c()).a() && !com.bytedance.tea.crash.g.d.a(file))
              a.a().a(a.a(file.getAbsolutePath())); 
          } 
        } 
      } catch (Exception exception) {
        j.b(exception);
      } 
    } 
  }
  
  public void a(boolean paramBoolean) {
    a();
    if (paramBoolean)
      b(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */