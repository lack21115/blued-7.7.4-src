package org.chromium.base;

import android.os.AsyncTask;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class AsyncTask$ChromeThreadPoolExecutor extends ThreadPoolExecutor {
  AsyncTask$ChromeThreadPoolExecutor() {
    this(AsyncTask.access$200(), AsyncTask.access$300(), 30L, TimeUnit.SECONDS, AsyncTask.access$400(), AsyncTask.access$500());
  }
  
  private AsyncTask$ChromeThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory) {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    allowCoreThreadTimeOut(true);
  }
  
  private static String findClassNamesWithTooManyRunnables(Map paramMap) {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry entry : paramMap.entrySet()) {
      if (((Integer)entry.getValue()).intValue() > 32) {
        stringBuilder.append((String)entry.getKey());
        stringBuilder.append(' ');
      } 
    } 
    return (stringBuilder.length() == 0) ? "NO CLASSES FOUND" : stringBuilder.toString();
  }
  
  private static String getClassName(Runnable paramRunnable) {
    Class<?> clazz1;
    Class<?> clazz2 = paramRunnable.getClass();
    if (clazz2 == AsyncTask$NamedFutureTask.class) {
      try {
        clazz1 = ((AsyncTask$NamedFutureTask)paramRunnable).this$0.getClass();
      } catch (NoSuchFieldException noSuchFieldException) {
        if (!BuildConfig.DCHECK_IS_ON) {
          clazz1 = clazz2;
          return clazz1.getName();
        } 
      } catch (IllegalAccessException illegalAccessException) {
        if (!BuildConfig.DCHECK_IS_ON) {
          clazz1 = clazz2;
        } else {
          throw new RuntimeException(illegalAccessException);
        } 
      } 
    } else {
      clazz1 = clazz2;
      if (clazz2.getEnclosingClass() == AsyncTask.class) {
        Field field = clazz2.getDeclaredField("this$0");
        field.setAccessible(true);
        clazz1 = field.get(illegalAccessException).getClass();
      } 
    } 
    return clazz1.getName();
  }
  
  public final void execute(Runnable paramRunnable) {
    try {
      super.execute(paramRunnable);
      return;
    } catch (RejectedExecutionException rejectedExecutionException) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      Runnable[] arrayOfRunnable = (Runnable[])getQueue().toArray((Object[])new Runnable[0]);
      int j = arrayOfRunnable.length;
      for (int i = 0; i < j; i++) {
        byte b;
        String str = getClassName(arrayOfRunnable[i]);
        if (hashMap.containsKey(str)) {
          b = ((Integer)hashMap.get(str)).intValue();
        } else {
          b = 0;
        } 
        hashMap.put(str, Integer.valueOf(b + 1));
      } 
      StringBuilder stringBuilder = new StringBuilder("Prominent classes in AsyncTask: ");
      stringBuilder.append(findClassNamesWithTooManyRunnables(hashMap));
      throw new RejectedExecutionException(stringBuilder.toString(), rejectedExecutionException);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\AsyncTask$ChromeThreadPoolExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */