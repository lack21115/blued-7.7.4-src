package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;
import java.io.IOException;

public class SM {
  private a a;
  
  private String b;
  
  private a c;
  
  private a d;
  
  private String e;
  
  private d f;
  
  private d g = null;
  
  private d h;
  
  private String i;
  
  private c j;
  
  private String k;
  
  private String l = "";
  
  private Context m;
  
  private String n;
  
  public SM(Context paramContext) {
    this.m = paramContext;
    this.a = new a();
    this.d = new a();
    this.h = new b();
    this.j = new c();
    this.n = SystemUtil.buildNewPathByProcessName("e_qq_com_setting");
    try {
      this.k = StringUtil.readAll(new File(this.m.getDir(this.n, 0), "gdt_suid"));
    } finally {
      paramContext = null;
      this.k = null;
    } 
    c();
  }
  
  private void a() {
    e.a<d> a1 = e.b(this.m);
    if (a1 != null) {
      this.e = a1.a();
      this.f = a1.b();
      return;
    } 
    GDTLogger.d("Load Local SDK Cloud setting fail");
  }
  
  private void b() {
    e.a<a> a1 = e.a(this.m);
    if (a1 != null) {
      this.c = a1.b();
      this.b = a1.a();
      return;
    } 
    GDTLogger.d("Load Local DEV Cloud setting fail");
  }
  
  private void c() {
    e.a<c> a1 = e.c(this.m);
    if (a1 != null) {
      this.j = a1.b();
      this.i = a1.a();
      return;
    } 
    GDTLogger.d("Load Local DEV Cloud setting fail");
  }
  
  public Object get(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        if (this.a != null) {
          Object object = this.a.a(paramString);
          if (object != null)
            return object; 
        } 
        if (this.c != null) {
          Object object = this.c.a(paramString);
          if (object != null)
            return object; 
        } 
      } finally {
        Exception exception = null;
        StringBuilder stringBuilder = new StringBuilder("Exception in settingManager.get Setting for key:");
        stringBuilder.append(paramString);
      }  
    return null;
  }
  
  public Object getDebugSetting() {
    return null;
  }
  
  public String getDevCloudSettingSig() {
    return this.b;
  }
  
  public Object getForPlacement(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return get(paramString1); 
      try {
        if (this.j != null) {
          Object object = this.j.a(paramString1, paramString2);
          if (object != null)
            return object; 
        } 
        if (this.a != null) {
          Object object = this.a.a(paramString1, paramString2);
          if (object != null)
            return object; 
        } 
        if (this.c != null) {
          Object object = this.c.a(paramString1, paramString2);
          if (object != null)
            return object; 
        } 
        return get(paramString1);
      } finally {
        paramString1 = null;
      } 
    } 
    return null;
  }
  
  public int getInteger(String paramString, int paramInt) {
    Object object = get(paramString);
    int i = paramInt;
    if (object != null) {
      i = paramInt;
      if (object instanceof Integer)
        i = ((Integer)object).intValue(); 
    } 
    return i;
  }
  
  public int getIntegerForPlacement(String paramString1, String paramString2, int paramInt) {
    Object object = getForPlacement(paramString1, paramString2);
    int i = paramInt;
    if (object != null) {
      i = paramInt;
      if (object instanceof Integer)
        i = ((Integer)object).intValue(); 
    } 
    return i;
  }
  
  public String getPlacementCloudSettingSig() {
    return this.i;
  }
  
  public String getSdkCloudSettingSig() {
    return this.e;
  }
  
  public String getSettingDir() {
    return this.n;
  }
  
  public String getSid() {
    return this.l;
  }
  
  public String getString(String paramString) {
    Object object = get(paramString);
    return (object == null) ? null : object.toString();
  }
  
  public String getStringForPlacement(String paramString1, String paramString2) {
    Object object = getForPlacement(paramString1, paramString2);
    return (object == null) ? null : object.toString();
  }
  
  public String getSuid() {
    return this.k;
  }
  
  public void modifyDebugSetting(String paramString, Object paramObject) {
    TextUtils.isEmpty(paramString);
  }
  
  public void setDEVCodeSetting(String paramString, Object paramObject) {
    this.d.a(paramString, paramObject);
  }
  
  public void setDEVCodeSetting(String paramString1, Object paramObject, String paramString2) {
    this.d.a(paramString1, paramObject, paramString2);
  }
  
  public void updateContextSetting(String paramString) {
    try {
      a a1 = new a();
      return;
    } finally {
      paramString = null;
      GDTLogger.report("Exception while update Context Setting", (Throwable)paramString);
    } 
  }
  
  public void updateDEVCloudSetting(String paramString1, String paramString2) {
    if (e.b(this.m, paramString1, paramString2))
      b(); 
  }
  
  public void updatePlacementSetting(String paramString1, String paramString2) {
    if (TextUtils.isEmpty(paramString1) && TextUtils.isEmpty(paramString2)) {
      e.d(this.m);
      this.j = new c();
      this.i = null;
      return;
    } 
    if (e.c(this.m, paramString1, paramString2))
      c(); 
  }
  
  public void updateSDKCloudSetting(String paramString1, String paramString2) {
    if (e.a(this.m, paramString1, paramString2))
      a(); 
  }
  
  public void updateSID(String paramString) {
    this.l = paramString;
  }
  
  public void updateSUID(String paramString) {
    if (!TextUtils.isEmpty(paramString) && !paramString.equals(this.k)) {
      this.k = paramString;
      try {
        StringUtil.writeTo(paramString, new File(this.m.getDir(this.n, 0), "gdt_suid"));
        return;
      } catch (IOException iOException) {
        GDTLogger.report("Exception while persit suid", iOException);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\setting\SM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */