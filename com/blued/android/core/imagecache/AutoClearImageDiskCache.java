package com.blued.android.core.imagecache;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.blued.android.core.utils.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class AutoClearImageDiskCache {
  private static AutoClearImageDiskCache a;
  
  private ClearTask b;
  
  public static AutoClearImageDiskCache a() {
    // Byte code:
    //   0: ldc com/blued/android/core/imagecache/AutoClearImageDiskCache
    //   2: monitorenter
    //   3: getstatic com/blued/android/core/imagecache/AutoClearImageDiskCache.a : Lcom/blued/android/core/imagecache/AutoClearImageDiskCache;
    //   6: ifnonnull -> 19
    //   9: new com/blued/android/core/imagecache/AutoClearImageDiskCache
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/blued/android/core/imagecache/AutoClearImageDiskCache.a : Lcom/blued/android/core/imagecache/AutoClearImageDiskCache;
    //   19: getstatic com/blued/android/core/imagecache/AutoClearImageDiskCache.a : Lcom/blued/android/core/imagecache/AutoClearImageDiskCache;
    //   22: astore_0
    //   23: ldc com/blued/android/core/imagecache/AutoClearImageDiskCache
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/blued/android/core/imagecache/AutoClearImageDiskCache
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'AutoClearImageDiskCache'
    //   4: ldc 'startClearTask()'
    //   6: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: iconst_1
    //   11: istore_2
    //   12: iload_2
    //   13: istore_1
    //   14: aload_0
    //   15: getfield b : Lcom/blued/android/core/imagecache/AutoClearImageDiskCache$ClearTask;
    //   18: ifnull -> 48
    //   21: aload_0
    //   22: getfield b : Lcom/blued/android/core/imagecache/AutoClearImageDiskCache$ClearTask;
    //   25: invokevirtual getStatus : ()Landroid/os/AsyncTask$Status;
    //   28: astore_3
    //   29: aload_3
    //   30: getstatic android/os/AsyncTask$Status.PENDING : Landroid/os/AsyncTask$Status;
    //   33: if_acmpeq -> 95
    //   36: iload_2
    //   37: istore_1
    //   38: aload_3
    //   39: getstatic android/os/AsyncTask$Status.RUNNING : Landroid/os/AsyncTask$Status;
    //   42: if_acmpne -> 48
    //   45: goto -> 95
    //   48: iload_1
    //   49: ifeq -> 87
    //   52: invokestatic a : ()Ljava/lang/String;
    //   55: astore_3
    //   56: aload_3
    //   57: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   60: ifne -> 87
    //   63: aload_0
    //   64: new com/blued/android/core/imagecache/AutoClearImageDiskCache$ClearTask
    //   67: dup
    //   68: aload_3
    //   69: invokespecial <init> : (Ljava/lang/String;)V
    //   72: putfield b : Lcom/blued/android/core/imagecache/AutoClearImageDiskCache$ClearTask;
    //   75: aload_0
    //   76: getfield b : Lcom/blued/android/core/imagecache/AutoClearImageDiskCache$ClearTask;
    //   79: iconst_0
    //   80: anewarray java/lang/Void
    //   83: invokevirtual execute : ([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   86: pop
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: astore_3
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_3
    //   94: athrow
    //   95: iconst_0
    //   96: istore_1
    //   97: goto -> 48
    // Exception table:
    //   from	to	target	type
    //   2	10	90	finally
    //   14	36	90	finally
    //   38	45	90	finally
    //   52	87	90	finally
  }
  
  static class ClearTask extends AsyncTask<Void, Void, Boolean> {
    private String a;
    
    public ClearTask(String param1String) {
      this.a = param1String;
    }
    
    protected Boolean a(Void... param1VarArgs) {
      SimpleDateFormat simpleDateFormat;
      try {
        if (!TextUtils.isEmpty(this.a)) {
          File file = new File(this.a);
          if (file.exists() && file.isDirectory()) {
            File[] arrayOfFile = file.listFiles();
            if (arrayOfFile == null)
              return Boolean.valueOf(false); 
            if (arrayOfFile.length <= 100)
              return Boolean.valueOf(false); 
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
              Arrays.sort(arrayOfFile, new AutoClearImageDiskCache.LastModifiedFileComparator());
            } catch (Exception exception1) {
              exception1.printStackTrace();
            } 
          } else {
            return Boolean.valueOf(false);
          } 
        } else {
          return Boolean.valueOf(false);
        } 
      } catch (OutOfMemoryError outOfMemoryError) {
        outOfMemoryError.printStackTrace();
        return Boolean.valueOf(false);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      int i;
      for (i = 0; i < exception.length / 3; i++) {
        Exception exception1 = exception[i];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delete ");
        stringBuilder.append(exception1.getName());
        stringBuilder.append("\t");
        stringBuilder.append(simpleDateFormat.format(new Date(exception1.lastModified())));
        Log.a("AutoClearImageDiskCache", stringBuilder.toString());
        exception1.delete();
      } 
      return Boolean.valueOf(true);
    }
    
    protected void a(Boolean param1Boolean) {
      super.onPostExecute(param1Boolean);
      if (param1Boolean != null)
        param1Boolean.booleanValue(); 
    }
  }
  
  static class CountCheckTask extends AsyncTask<Void, Void, Boolean> {
    private String a;
    
    protected Boolean a(Void... param1VarArgs) {
      try {
        if (!TextUtils.isEmpty(this.a)) {
          File file = new File(this.a);
          if (file.exists() && file.isDirectory()) {
            String[] arrayOfString = file.list();
            if (arrayOfString != null) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("image count:");
              stringBuilder.append(arrayOfString.length);
              Log.a("AutoClearImageDiskCache", stringBuilder.toString());
              if (arrayOfString.length >= 5000)
                return Boolean.valueOf(true); 
            } 
          } 
        } 
      } catch (OutOfMemoryError outOfMemoryError) {
        outOfMemoryError.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      return Boolean.valueOf(false);
    }
    
    protected void a(Boolean param1Boolean) {
      super.onPostExecute(param1Boolean);
      if (param1Boolean != null && param1Boolean.booleanValue())
        AutoClearImageDiskCache.a().b(); 
    }
  }
  
  static class LastModifiedFileComparator implements Comparator {
    private LastModifiedFileComparator() {}
    
    public int compare(Object param1Object1, Object param1Object2) {
      param1Object1 = param1Object1;
      param1Object2 = param1Object2;
      int i = param1Object1.lastModified() - param1Object2.lastModified() cmp 0L;
      return (i < 0) ? -1 : ((i > 0) ? 1 : 0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\AutoClearImageDiskCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */