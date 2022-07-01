package com.huawei.updatesdk.a.b.c;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public final class b {
  private Intent a;
  
  private b(Intent paramIntent) {
    this.a = paramIntent;
  }
  
  public static b a(Intent paramIntent) {
    return new b(paramIntent);
  }
  
  public int a(String paramString, int paramInt) {
    if (d())
      try {
        return this.a.getIntExtra(paramString, paramInt);
      } catch (Exception exception) {
        Log.e("SecureIntent", "getIntExtra exception!");
      }  
    return paramInt;
  }
  
  public String a() {
    boolean bool = d();
    String str = "";
    if (bool) {
      str = this.a.getAction();
      if (str == null)
        return ""; 
    } 
    return str;
  }
  
  public String a(String paramString) {
    if (d())
      try {
        return this.a.getStringExtra(paramString);
      } catch (Exception exception) {
        Log.e("SecureIntent", "getStringExtra exception!");
      }  
    return "";
  }
  
  public boolean a(String paramString, boolean paramBoolean) {
    if (d())
      try {
        return this.a.getBooleanExtra(paramString, paramBoolean);
      } catch (Exception exception) {
        Log.e("SecureIntent", "getBooleanExtra exception!");
      }  
    return paramBoolean;
  }
  
  public long b(String paramString, int paramInt) {
    if (d())
      try {
        return this.a.getLongExtra(paramString, paramInt);
      } catch (Exception exception) {
        Log.e("SecureIntent", "getIntExtra exception!");
      }  
    return paramInt;
  }
  
  public Bundle b() {
    return d() ? this.a.getExtras() : null;
  }
  
  public Intent c() {
    return this.a;
  }
  
  public boolean d() {
    return (this.a != null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\b\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */