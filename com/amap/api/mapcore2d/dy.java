package com.amap.api.mapcore2d;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

public class dy {
  private dt a;
  
  private Context b;
  
  public dy(Context paramContext, boolean paramBoolean) {
    this.b = paramContext;
    this.a = a(this.b, paramBoolean);
  }
  
  private dt a(Context paramContext, boolean paramBoolean) {
    try {
      return new dt(paramContext, dt.a((Class)dx.class));
    } finally {
      paramContext = null;
      if (!paramBoolean)
        do.c((Throwable)paramContext, "sd", "gdb"); 
    } 
  }
  
  private boolean a(List<da> paramList, da paramda) {
    Iterator<da> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      if (((da)iterator.next()).equals(paramda))
        return false; 
    } 
    return true;
  }
  
  public List<da> a() {
    try {
      return this.a.a(str, da.class, true);
    } finally {
      Exception exception = null;
      exception.printStackTrace();
    } 
  }
  
  public void a(da paramda) {
    if (paramda == null)
      return; 
    try {
      if (this.a == null)
        this.a = a(this.b, false); 
      String str = da.a(paramda.a());
      List<da> list = this.a.b(str, da.class);
      if (list == null || list.size() == 0)
        return; 
    } finally {
      paramda = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */