package com.tencent.tbs.sdk.extension.partner.incrupdate.a;

import android.content.Context;
import com.tencent.tbs.sdk.extension.partner.incrupdate.a.a.a;
import java.io.File;
import java.io.PrintStream;
import java.util.List;

public class e {
  private g a = (g)new a();
  
  private File b;
  
  private File c;
  
  private boolean b(String paramString1, String paramString2) {
    PrintStream printStream;
    this.b = new File(paramString1);
    if (!this.b.exists()) {
      printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("required file not found: ");
      stringBuilder.append(paramString1);
      printStream.println(stringBuilder.toString());
      return false;
    } 
    this.c = new File((String)printStream);
    if (this.c.exists()) {
      if (!this.c.delete()) {
        PrintStream printStream1 = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Qar can't create: ");
        stringBuilder.append((String)printStream);
        printStream1.println(stringBuilder.toString());
        return false;
      } 
    } else if (!this.c.getParentFile().exists()) {
      this.c.mkdirs();
    } 
    return true;
  }
  
  public void a(List<String> paramList) {
    this.a.a(paramList);
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2) {
    return b(paramString1, paramString2) ? this.a.a(paramContext, this.b, this.c) : false;
  }
  
  public boolean a(String paramString1, String paramString2) {
    return b(paramString1, paramString2) ? this.a.a(paramString1, paramString2) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\incrupdate\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */