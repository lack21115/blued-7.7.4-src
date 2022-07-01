package com.qiniu.pili.droid.crash;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;

class a {
  private Context a;
  
  a(Context paramContext) {
    this.a = paramContext;
  }
  
  private boolean a(String paramString1, String paramString2) {
    int i;
    if (paramString1.length() < paramString2.length()) {
      i = paramString1.length();
    } else {
      i = paramString2.length();
    } 
    boolean bool2 = false;
    boolean bool1 = false;
    int j = 0;
    while (j != i) {
      char c1 = paramString1.charAt(j);
      char c2 = paramString2.charAt(j);
      if (c1 == c2) {
        j++;
        continue;
      } 
      if (c1 > c2)
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool2;
    if (paramString1.length() > paramString2.length())
      bool1 = true; 
    return bool1;
  }
  
  void a() {
    SharedPreferences sharedPreferences = this.a.getSharedPreferences("plcrash", 0);
    if (a("3.1.1", sharedPreferences.getString("lastVersion", "3.1.1"))) {
      f.a().b();
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString("lastVersion", "3.1.1");
      editor.apply();
    } 
  }
  
  void b() {
    (new Thread(new Runnable(this) {
          public void run() {
            File[] arrayOfFile = f.a().e();
            int j = arrayOfFile.length;
            int i = 0;
            while (true) {
              if (i < j) {
                byte b;
                File file = arrayOfFile[i];
                g g = new g(file);
                try {
                  b = g.a().intValue();
                } catch (Exception exception) {
                  file.delete();
                  b = 0;
                } 
                if (b < 'Ǵ')
                  file.delete(); 
                i++;
                continue;
              } 
              return;
            } 
          }
        })).start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */