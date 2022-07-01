package com.huawei.updatesdk.a.a.c.h;

import android.content.Context;
import com.huawei.updatesdk.a.a.c.e;
import com.huawei.updatesdk.a.b.d.c.b;
import java.util.ArrayList;
import java.util.Set;

public class a extends b {
  private String abis_;
  
  private String deviceFeatures_;
  
  private int dpi_;
  
  private String preferLan_;
  
  private a() {}
  
  public static class b {
    private final Context a;
    
    private boolean b;
    
    private Set<String> c;
    
    private String[] d;
    
    private boolean e;
    
    public b(Context param1Context) {
      this.a = param1Context;
    }
    
    private String b() {
      ArrayList<String> arrayList = new ArrayList<String>(b.d(this.a));
      Set<String> set = this.c;
      if (set != null)
        for (String str : set) {
          if (!arrayList.contains(str))
            arrayList.add(str); 
        }  
      return this.e ? e.a(b.a(arrayList, this.d), ",") : e.a(arrayList, ",");
    }
    
    public b a(boolean param1Boolean) {
      this.b = param1Boolean;
      return this;
    }
    
    public a a() {
      a a = new a(null);
      a.a(a, e.a(b.e(), ","));
      a.a(a, Integer.parseInt(b.f(this.a)));
      a.b(a, b());
      if (this.b)
        a.c(a, b.a(this.a)); 
      return a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */