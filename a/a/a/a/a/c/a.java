package a.a.a.a.a.c;

import a.a.a.a.a.e.h;
import android.content.Context;

public final class a {
  public static final String[] a = new String[] { "com.panda.videoliveplatform", "tv.panda.live.broadcast", "com.panda.videolivetv", "com.panda.videolivehd" };
  
  public static a b = new a();
  
  public boolean c = false;
  
  public static a a() {
    return b;
  }
  
  public void a(Context paramContext) {
    int i = 0;
    this.c = false;
    String str = h.i(paramContext);
    if (str != null) {
      if (str.isEmpty())
        return; 
      int j = a.length;
      while (i < j) {
        if (str.equals(a[i])) {
          this.c = true;
          return;
        } 
        i++;
      } 
    } 
  }
  
  public boolean b() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */