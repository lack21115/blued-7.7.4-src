package com.huawei.updatesdk.b.e.a;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c {
  public static final ThreadPoolExecutor a = new ThreadPoolExecutor(2, 2, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\e\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */