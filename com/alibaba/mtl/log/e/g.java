package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

public class g {
  private static g a = new g();
  
  private a a;
  
  private b a = new b();
  
  private g() {
    this.a = (b)new a();
  }
  
  public static g a() {
    return (g)a;
  }
  
  public String[] a(String[] paramArrayOfString, boolean paramBoolean) {
    b b1;
    if (paramBoolean) {
      b1 = this.a;
    } else {
      b1 = this.a;
    } 
    if (b1 != null && paramArrayOfString != null && paramArrayOfString.length > 0) {
      Arrays.sort(paramArrayOfString, b1);
      return paramArrayOfString;
    } 
    return null;
  }
  
  class a implements Comparator<String> {
    private a(g this$0) {}
    
    public int compare(String param1String1, String param1String2) {
      return (!TextUtils.isEmpty(param1String1) && !TextUtils.isEmpty(param1String2)) ? param1String1.compareTo(param1String2) : 0;
    }
  }
  
  class b implements Comparator<String> {
    private b(g this$0) {}
    
    public int compare(String param1String1, String param1String2) {
      return (!TextUtils.isEmpty(param1String1) && !TextUtils.isEmpty(param1String2)) ? (param1String1.compareTo(param1String2) * -1) : 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */