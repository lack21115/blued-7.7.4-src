package cn.com.chinatelecom.account.api.c;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class a {
  private static Executor b = Executors.newSingleThreadExecutor();
  
  public Handler a = new Handler(Looper.getMainLooper());
  
  public static void a(Runnable paramRunnable) {
    b.execute(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */