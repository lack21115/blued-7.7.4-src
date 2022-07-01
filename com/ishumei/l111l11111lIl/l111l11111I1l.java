package com.ishumei.l111l11111lIl;

import android.os.Build;
import com.ishumei.l1111l111111Il.l11l1111I1l;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import com.ishumei.smantifraud.SmAntiFraud;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

public final class l111l11111I1l {
  private SmAntiFraud.SmOption l1111l111111Il = SmAntiFraud.l1111l111111Il;
  
  private l111l11111I1l() {}
  
  public static l111l11111I1l l1111l111111Il() {
    return l1111l111111Il.l1111l111111Il();
  }
  
  private com.ishumei.l1111l111111Il.l111l11111I1l l111l11111lIl() {
    com.ishumei.l1111l111111Il.l111l11111I1l l111l11111I1l1 = new com.ishumei.l1111l111111Il.l111l11111I1l();
    l111l11111I1l1.l11l1111I11l("exception");
    l111l11111I1l1.l111l1111llIl("android");
    l111l11111I1l1.l111l1111lIl("3.0.6");
    l111l11111I1l1.l111l1111lI1l(Build.VERSION.RELEASE);
    l111l11111I1l1.l11l1111lIIl(Build.MODEL);
    l111l11111I1l1.l111l11111Il(this.l1111l111111Il.l11l1111I1ll());
    l111l11111I1l1.l111l1111l1Il(this.l1111l111111Il.l11l11IlIIll());
    l111l11111I1l1.l111l11111lIl(l11l1111I1l.l1111l111111Il().l111l11111lIl());
    l111l11111I1l1.l111l11111I1l(l11l1111I1l.l1111l111111Il().l111l11111I1l());
    l111l11111I1l1.l1111l111111Il(l11l1111I1l.l1111l111111Il().l111l11111Il());
    return l111l11111I1l1;
  }
  
  private static String l111l11111lIl(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    try {
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      while (true) {
        paramThrowable.printStackTrace(printWriter);
        paramThrowable = paramThrowable.getCause();
        if (paramThrowable != null)
          continue; 
        printWriter.close();
        String str2 = stringWriter.toString();
        String str1 = str2;
        if (str2.length() > 4096)
          str1 = str2.substring(0, 4096); 
        return str1;
      } 
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public final String l1111l111111Il(Throwable paramThrowable) {
    try {
      com.ishumei.l1111l111111Il.l111l11111I1l l111l11111I1l1 = new com.ishumei.l1111l111111Il.l111l11111I1l();
      l111l11111I1l1.l11l1111I11l("exception");
      l111l11111I1l1.l111l1111llIl("android");
      l111l11111I1l1.l111l1111lIl("3.0.6");
      l111l11111I1l1.l111l1111lI1l(Build.VERSION.RELEASE);
      l111l11111I1l1.l11l1111lIIl(Build.MODEL);
      l111l11111I1l1.l111l11111Il(this.l1111l111111Il.l11l1111I1ll());
      l111l11111I1l1.l111l1111l1Il(this.l1111l111111Il.l11l11IlIIll());
      l111l11111I1l1.l111l11111lIl(l11l1111I1l.l1111l111111Il().l111l11111lIl());
      l111l11111I1l1.l111l11111I1l(l11l1111I1l.l1111l111111Il().l111l11111I1l());
      l111l11111I1l1.l1111l111111Il(l11l1111I1l.l1111l111111Il().l111l11111Il());
      l111l11111I1l1.l11l1111I1l(l111l11111lIl(paramThrowable));
      null = l111l1111lIl.l111l11111lIl(l111l1111lIl.l1111l111111Il(l111l11111I1l1).toString().getBytes());
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("organization", l111l11111I1l1.l1111l111111Il());
      jSONObject.put("os", "android");
      jSONObject.put("appId", this.l1111l111111Il.l11l11IlIIll());
      jSONObject.put("encode", 1);
      jSONObject.put("data", null);
      jSONObject.put("tn", "");
      return jSONObject.toString();
    } finally {
      paramThrowable = null;
    } 
  }
  
  static final class l1111l111111Il {
    private static final l111l11111I1l l1111l111111Il = new l111l11111I1l((byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111lIl\l111l11111I1l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */