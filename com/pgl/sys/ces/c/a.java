package com.pgl.sys.ces.c;

import android.content.Context;
import com.pgl.a.a.b;
import com.pgl.sys.ces.a.c;
import com.pgl.sys.ces.b;

public class a extends b {
  private Context b = null;
  
  public a(Context paramContext, String paramString) {
    super(paramContext, paramString);
    this.b = paramContext;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(com.pgl.a.a.a.a());
    stringBuilder.append("/v2/r");
    stringBuilder.append(a());
    this.a = stringBuilder.toString();
  }
  
  public String a() {
    try {
      str = (this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0)).versionName;
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("?os=0&ver=0.6.08.27.03-PGL-DO&m=2");
    stringBuilder.append("&app_ver=");
    stringBuilder.append(str);
    String str = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("&region=");
    stringBuilder.append(c.c(this.b));
    str = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("&appkey=");
    stringBuilder.append(b.b());
    str = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("&did=");
    stringBuilder.append(b.c());
    return stringBuilder.toString();
  }
  
  public boolean a(int paramInt, byte[] paramArrayOfbyte) {
    if (paramInt == 200 && paramArrayOfbyte != null)
      try {
      
      } finally {
        paramArrayOfbyte = null;
      }  
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\pgl\sys\ces\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */