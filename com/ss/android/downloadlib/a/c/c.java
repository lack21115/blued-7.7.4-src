package com.ss.android.downloadlib.a.c;

import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.e.g;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.k.a;
import java.io.File;
import java.util.List;

public class c {
  public static void a() {
    List<com.ss.android.socialbase.downloader.g.c> list = d.h().a(j.a());
    if (list != null && list.size() > 0)
      for (int i = 0; i < list.size(); i++) {
        com.ss.android.socialbase.downloader.g.c c1 = list.get(i);
        File file = new File(c1.l(), c1.m());
        long l3 = file.lastModified();
        long l2 = a.a(c1.g()).a("download_file_expire_hours", 0) * 3600000L;
        long l1 = l2;
        if (l2 <= 0L)
          l1 = 604800000L; 
        if (file.isFile() && file.exists() && System.currentTimeMillis() - l3 >= l1) {
          a(file);
          f.a(j.a()).j(c1.g());
        } 
      }  
  }
  
  public static void a(File paramFile) {
    // Byte code:
    //   0: new java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial <init> : (Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: ldc '1'
    //   14: invokevirtual getBytes : ()[B
    //   17: invokevirtual write : ([B)V
    //   20: aload_2
    //   21: astore_1
    //   22: aload_2
    //   23: invokevirtual close : ()V
    //   26: goto -> 64
    //   29: astore_3
    //   30: goto -> 42
    //   33: astore_0
    //   34: aconst_null
    //   35: astore_1
    //   36: goto -> 71
    //   39: astore_3
    //   40: aconst_null
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_3
    //   45: invokevirtual printStackTrace : ()V
    //   48: aload_2
    //   49: ifnull -> 64
    //   52: aload_2
    //   53: invokevirtual close : ()V
    //   56: goto -> 64
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual printStackTrace : ()V
    //   64: aload_0
    //   65: invokevirtual delete : ()Z
    //   68: pop
    //   69: return
    //   70: astore_0
    //   71: aload_1
    //   72: ifnull -> 87
    //   75: aload_1
    //   76: invokevirtual close : ()V
    //   79: goto -> 87
    //   82: astore_1
    //   83: aload_1
    //   84: invokevirtual printStackTrace : ()V
    //   87: aload_0
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   0	9	39	java/lang/Exception
    //   0	9	33	finally
    //   11	20	29	java/lang/Exception
    //   11	20	70	finally
    //   22	26	29	java/lang/Exception
    //   22	26	70	finally
    //   44	48	70	finally
    //   52	56	59	java/lang/Exception
    //   75	79	82	java/lang/Exception
  }
  
  public static void b() {
    List<com.ss.android.socialbase.downloader.g.c> list = f.a(j.a()).b("application/vnd.android.package-archive");
    if (list != null) {
      if (list.isEmpty())
        return; 
      for (int i = 0; i < list.size(); i++) {
        com.ss.android.socialbase.downloader.g.c c1 = list.get(i);
        if (c1 != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(c1.k());
          stringBuilder.append(File.separator);
          stringBuilder.append(c1.h());
          String str = stringBuilder.toString();
          File file = new File(str);
          if (file.exists()) {
            long l3 = System.currentTimeMillis();
            long l4 = file.lastModified();
            long l2 = a.a(c1.g()).a("download_complete_file_expire_hours", 0) * 3600000L;
            long l1 = l2;
            if (l2 <= 0L)
              l1 = 604800000L; 
            boolean bool = true;
            if (l3 - l4 < l1 && !g.d(j.a(), str))
              bool = false; 
            if (bool)
              a(file); 
          } 
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */