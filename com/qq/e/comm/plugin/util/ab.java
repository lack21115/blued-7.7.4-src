package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CopyOnWriteArrayList;

public class ab {
  private static final String a = ab.class.getSimpleName();
  
  private String[] b;
  
  private String[] c;
  
  private CopyOnWriteArrayList<String> d;
  
  private boolean e;
  
  private ab() {
    d();
  }
  
  public static ab a() {
    return a.a();
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    c c = new c();
    c.a(paramString3);
    u.a(1130004, 0, c, (new d()).a("package", paramString1).a("trace", paramString2));
  }
  
  private void b(String paramString) {
    u.a(1130003, 0, null, (new d()).a("adapter", paramString));
  }
  
  private void d() {
    String str = GDTADManager.getInstance().getSM().getString("mcClaNa");
    if (!TextUtils.isEmpty(str))
      this.b = str.split(","); 
    str = GDTADManager.getInstance().getSM().getString("mcPackNa");
    if (!TextUtils.isEmpty(str))
      this.c = str.split(","); 
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool = false;
    if (sM.getInteger("mcena", 0) == 1)
      bool = true; 
    this.e = bool;
    this.d = new CopyOnWriteArrayList<String>();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("mIsEnableCheck: ");
    stringBuilder.append(this.e);
    stringBuilder.append(" mClassNames: ");
    stringBuilder.append(this.b);
    stringBuilder.append(" mPackages: ");
    stringBuilder.append(this.c);
    GDTLogger.d(stringBuilder.toString());
  }
  
  public void a(String paramString) {
    if (!this.e)
      return; 
    if (!this.d.contains(paramString)) {
      String[] arrayOfString = this.c;
      if (arrayOfString != null && arrayOfString.length != 0) {
        if (this.d.size() >= 10)
          this.d.remove(0); 
        this.d.add(paramString);
        StackTraceElement[] arrayOfStackTraceElement = (new Exception()).getStackTrace();
        t.a.execute(new Runnable(this, arrayOfStackTraceElement, paramString) {
              public void run() {
                StringBuilder stringBuilder = new StringBuilder("checkPackage:");
                String[] arrayOfString = ab.b(this.c);
                int k = arrayOfString.length;
                int i = 0;
                int j = 0;
                boolean bool = false;
                while (i < k) {
                  String str = arrayOfString[i];
                  int m = j + 1;
                  StackTraceElement[] arrayOfStackTraceElement = this.a;
                  int n = arrayOfStackTraceElement.length;
                  j = 0;
                  while (j < n) {
                    StackTraceElement stackTraceElement = arrayOfStackTraceElement[j];
                    boolean bool1 = bool;
                    if (stackTraceElement != null) {
                      String str1 = stackTraceElement.getClassName();
                      bool1 = bool;
                      if (!TextUtils.isEmpty(str1)) {
                        if (m == 1) {
                          stringBuilder.append("\t");
                          stringBuilder.append(stackTraceElement.toString());
                        } 
                        bool1 = bool;
                        if (!TextUtils.isEmpty(str)) {
                          bool1 = bool;
                          if (str1.contains(str)) {
                            StringBuilder stringBuilder1 = new StringBuilder();
                            stringBuilder1.append(ab.c());
                            stringBuilder1.append("调用栈中：");
                            stringBuilder1.append(str1);
                            stringBuilder1.append(" 存在包名：");
                            stringBuilder1.append(str);
                            GDTLogger.d(stringBuilder1.toString());
                            bool1 = true;
                          } 
                        } 
                      } 
                    } 
                    j++;
                    bool = bool1;
                  } 
                  if (bool) {
                    ab.a(this.c, str, stringBuilder.toString(), this.b);
                    return;
                  } 
                  i++;
                  j = m;
                } 
              }
            });
      } 
    } 
  }
  
  public void b() {
    if (!this.e)
      return; 
    String[] arrayOfString = this.b;
    if (arrayOfString != null && arrayOfString.length != 0)
      t.a.execute(new Runnable(this) {
            public void run() {
              String[] arrayOfString = ab.a(this.a);
              int j = arrayOfString.length;
              int i = 0;
              while (true) {
                if (i < j) {
                  String str = arrayOfString[i];
                  try {
                    Class.forName(str);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ab.c());
                    stringBuilder.append("宿主APP中存在三方聚合 SDK 类：");
                    stringBuilder.append(str);
                    GDTLogger.d(stringBuilder.toString());
                    ab.a(this.a, str);
                  } catch (ClassNotFoundException classNotFoundException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(ab.c());
                    stringBuilder.append("第三方聚合 SDK 类：");
                    stringBuilder.append(str);
                    stringBuilder.append(" 不存在");
                    GDTLogger.d(stringBuilder.toString());
                  } 
                  i++;
                  continue;
                } 
                return;
              } 
            }
          }); 
  }
  
  static class a {
    private static ab a = new ab();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */