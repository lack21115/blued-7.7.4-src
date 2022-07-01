package cn.mmachina;

import android.content.Context;
import com.tencent.ams.a.b.a;

public class JniClient {
  public static int a = 1;
  
  static {
    try {
      return;
    } finally {
      Exception exception = null;
      a.a("JniClientQQ", "load mma so error.", exception);
    } 
  }
  
  public static native String MDString(String paramString1, Context paramContext, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\mmachina\JniClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */