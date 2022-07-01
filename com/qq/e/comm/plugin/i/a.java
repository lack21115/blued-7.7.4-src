package com.qq.e.comm.plugin.i;

import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.comm.plugin.a.c;

class a implements GDTApk {
  private final String a;
  
  private final String b;
  
  private final String c;
  
  private final String d;
  
  private final String e;
  
  private final c f;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, c paramc) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramc;
  }
  
  public c a() {
    return this.f;
  }
  
  public String getAppName() {
    return this.d;
  }
  
  public String getDesc() {
    return this.c;
  }
  
  public String getLogoUrl() {
    return this.e;
  }
  
  public String getPackageName() {
    return this.a;
  }
  
  public String getTitle() {
    return this.b;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Apk{packageName='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", title='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", desc='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", appName='");
    stringBuilder.append(this.d);
    stringBuilder.append('\'');
    stringBuilder.append(", logoUrl='");
    stringBuilder.append(this.e);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */