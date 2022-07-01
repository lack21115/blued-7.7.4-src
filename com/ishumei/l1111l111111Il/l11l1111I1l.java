package com.ishumei.l1111l111111Il;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.ishumei.dfp.SMSDK;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class l11l1111I1l {
  private static String l1111l111111Il = "sm";
  
  private static l11l1111I1l l111l1111lIl;
  
  private l111l1111lI1l l111l11111I1l;
  
  private l111l1111lI1l l111l11111Il;
  
  private l111l1111lI1l l111l11111lIl;
  
  private l111l1111lI1l l111l1111l1Il;
  
  private l111l1111lI1l l111l1111lI1l;
  
  private l111l1111lI1l l111l1111llIl;
  
  public static l11l1111I1l l1111l111111Il() {
    // Byte code:
    //   0: getstatic com/ishumei/l1111l111111Il/l11l1111I1l.l111l1111lIl : Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   3: ifnonnull -> 37
    //   6: ldc com/ishumei/l1111l111111Il/l11l1111I1l
    //   8: monitorenter
    //   9: getstatic com/ishumei/l1111l111111Il/l11l1111I1l.l111l1111lIl : Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   12: ifnonnull -> 25
    //   15: new com/ishumei/l1111l111111Il/l11l1111I1l
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ishumei/l1111l111111Il/l11l1111I1l.l111l1111lIl : Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   25: ldc com/ishumei/l1111l111111Il/l11l1111I1l
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ishumei/l1111l111111Il/l11l1111I1l
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ishumei/l1111l111111Il/l11l1111I1l.l111l1111lIl : Lcom/ishumei/l1111l111111Il/l11l1111I1l;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private static String l1111l111111Il(List<l111l1111lI1l> paramList) {
    Iterator<l111l1111lI1l> iterator = paramList.iterator();
    while (true) {
      if (iterator.hasNext()) {
        l111l1111lI1l l111l1111lI1l1 = iterator.next();
        try {
          String str = l111l1111lI1l1.l111l11111I1l();
          boolean bool = TextUtils.isEmpty(str);
          return str;
        } finally {
          l111l1111lI1l1 = null;
        } 
      } 
      return "";
    } 
  }
  
  final void l1111l111111Il(l111l11111lIl paraml111l11111lIl) {
    paraml111l11111lIl.l111l1111l1Il(this.l111l11111lIl.l111l11111I1l());
    paraml111l11111lIl.l111l1111llIl(this.l111l11111I1l.l111l11111I1l());
    paraml111l11111lIl.l1l11l1Il(this.l111l11111Il.l111l11111I1l());
    paraml111l11111lIl.l1l11l1Il1l(this.l111l1111l1Il.l111l11111I1l());
    paraml111l11111lIl.l11l11l1I1l(this.l111l1111llIl.l111l11111I1l());
    paraml111l11111lIl.l1l11l1I1Il(this.l111l1111lI1l.l111l11111I1l());
    paraml111l11111lIl.l11l1111Il1l(l111l11111Il());
  }
  
  final void l1111l111111Il(String paramString) {
    l111l1111lI1l l111l1111lI1l1 = this.l111l11111lIl;
    if (l111l1111lI1l1 != null)
      l111l1111lI1l1.l111l11111lIl(paramString); 
    l111l1111lI1l1 = this.l111l11111I1l;
    if (l111l1111lI1l1 != null)
      l111l1111lI1l1.l111l11111lIl(paramString); 
  }
  
  public final void l1111l111111Il(String paramString1, String paramString2) {
    /* monitor enter ThisExpression{ObjectType{com/ishumei/l1111l111111Il/l11l1111I1l}} */
    try {
      this.l111l11111lIl = new l111l1111lIl(paramString2);
      this.l111l11111I1l = new l111l11111Il(paramString2, paramString1);
      this.l111l11111Il = new l11l1111I11l((byte)0);
      this.l111l1111l1Il = new l111l1111l1Il();
      this.l111l1111llIl = new l11l1111I1l((byte)0);
      this.l111l1111lI1l = new l111l1111llIl(paramString1);
      /* monitor exit ThisExpression{ObjectType{com/ishumei/l1111l111111Il/l11l1111I1l}} */
      return;
    } catch (Exception exception) {
      /* monitor exit ThisExpression{ObjectType{com/ishumei/l1111l111111Il/l11l1111I1l}} */
      return;
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/ishumei/l1111l111111Il/l11l1111I1l}} */
    throw paramString1;
  }
  
  public final String l111l11111I1l() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l111l11111I1l : Lcom/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l;
    //   6: ifnonnull -> 14
    //   9: aload_0
    //   10: monitorexit
    //   11: ldc ''
    //   13: areturn
    //   14: aload_0
    //   15: getfield l111l11111I1l : Lcom/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l;
    //   18: invokeinterface l111l11111I1l : ()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	28	finally
    //   14	24	28	finally
  }
  
  public final String l111l11111Il() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_3
    //   3: anewarray com/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l
    //   6: dup
    //   7: iconst_0
    //   8: aload_0
    //   9: getfield l111l11111lIl : Lcom/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l;
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: aload_0
    //   16: getfield l111l1111llIl : Lcom/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l;
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: aload_0
    //   23: getfield l111l11111Il : Lcom/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l;
    //   26: aastore
    //   27: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   30: invokeinterface iterator : ()Ljava/util/Iterator;
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface hasNext : ()Z
    //   42: ifeq -> 73
    //   45: aload_2
    //   46: invokeinterface next : ()Ljava/lang/Object;
    //   51: checkcast com/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l
    //   54: invokeinterface l111l11111I1l : ()Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   64: istore_1
    //   65: iload_1
    //   66: ifne -> 36
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: areturn
    //   73: aload_0
    //   74: monitorexit
    //   75: ldc ''
    //   77: areturn
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	36	78	finally
    //   36	65	78	finally
  }
  
  public final String l111l11111lIl() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l111l11111lIl : Lcom/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l;
    //   6: ifnonnull -> 14
    //   9: aload_0
    //   10: monitorexit
    //   11: ldc ''
    //   13: areturn
    //   14: aload_0
    //   15: getfield l111l11111lIl : Lcom/ishumei/l1111l111111Il/l11l1111I1l$l111l1111lI1l;
    //   18: invokeinterface l111l11111I1l : ()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	28	finally
    //   14	24	28	finally
  }
  
  static abstract class l1111l111111Il extends l111l11111lIl {
    private l1111l111111Il() {
      super((byte)0);
    }
    
    private static String l111l11111Il() {
      return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    
    protected abstract List<String> l1111l111111Il();
    
    public final void l1111l111111Il(String param1String) {
      try {
        List<String> list = l1111l111111Il();
        if (list != null) {
          if (list.size() == 0)
            return; 
          String str = Environment.getExternalStorageDirectory().getAbsolutePath();
          Iterator<String> iterator = list.iterator();
          while (true) {
            if (iterator.hasNext()) {
              String str1 = iterator.next();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(str);
              stringBuilder.append(File.separator);
              stringBuilder.append(str1);
              File file = new File(stringBuilder.toString());
              try {
                if (file.exists())
                  continue; 
                file.getParentFile().mkdirs();
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(file.getPath());
                stringBuilder1.append(".tmp");
                File file1 = new File(stringBuilder1.toString());
                boolean bool = com.ishumei.l111l1111llIl.l111l1111lI1l.l1111l111111Il(param1String);
                if (!bool) {
                  FileWriter fileWriter;
                  stringBuilder = null;
                  try {
                    FileWriter fileWriter1 = new FileWriter(file1);
                    try {
                      fileWriter1.write(param1String);
                      continue;
                    } finally {
                      File file2;
                      file = null;
                      fileWriter = fileWriter1;
                    } 
                  } finally {}
                  if (fileWriter != null)
                    fileWriter.close(); 
                  throw stringBuilder1;
                } 
                throw new IOException("file or bytes empty");
              } catch (Exception exception) {
                continue;
              } 
            } 
            return;
          } 
        } 
        return;
      } catch (Exception exception) {
        return;
      } 
    }
    
    public String l111l11111lIl() {
      try {
        List<String> list = l1111l111111Il();
        if (list == null || list.size() == 0)
          return null; 
        String str = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator<String> iterator = list.iterator();
        while (true) {
          if (iterator.hasNext()) {
            String str1 = iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(File.separator);
            stringBuilder.append(str1);
            File file = new File(stringBuilder.toString());
            try {
              if (!file.exists())
                continue; 
              return com.ishumei.l111l1111llIl.l111l1111lIl.l1111l111111Il(file);
            } catch (Exception exception) {
              continue;
            } 
          } 
          return "";
        } 
      } catch (Exception exception) {}
      return "";
    }
  }
  
  static abstract class l111l11111I1l extends l111l11111lIl {
    private l111l11111I1l() {
      super((byte)0);
    }
    
    private static SharedPreferences l111l11111I1l(String param1String) {
      Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
      return (context == null) ? null : context.getSharedPreferences(param1String, 0);
    }
    
    protected abstract String l1111l111111Il();
    
    public final void l1111l111111Il(String param1String) {
      try {
        String str2 = l1111l111111Il();
        String str1 = l111l11111Il();
        if (!TextUtils.isEmpty(str2)) {
          if (TextUtils.isEmpty(str1))
            return; 
          SharedPreferences sharedPreferences = l111l11111I1l(str2);
          if (sharedPreferences == null)
            return; 
          SharedPreferences.Editor editor = sharedPreferences.edit();
          editor.putString(str1, param1String);
          editor.apply();
        } 
        return;
      } catch (Exception exception) {
        return;
      } 
    }
    
    protected abstract String l111l11111Il();
    
    public String l111l11111lIl() {
      try {
        String str2 = l1111l111111Il();
        String str1 = l111l11111Il();
        if (!TextUtils.isEmpty(str2)) {
          if (TextUtils.isEmpty(str1))
            return null; 
          SharedPreferences sharedPreferences = l111l11111I1l(str2);
          return (sharedPreferences == null) ? null : sharedPreferences.getString(str1, "");
        } 
        return null;
      } catch (Exception exception) {
        return "";
      } 
    }
  }
  
  static final class l111l11111Il extends l1111l111111Il {
    private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d18b978a929d9c9e9c979aa0");
    
    private static final String[] l111l11111lIl = new String[] { com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d19e919b908d969b"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("af969c8b8a8d9a8c"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bb90889193909e9b"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bb909c8a929a918b8c") };
    
    private List<String> l111l11111I1l;
    
    private String l111l11111Il;
    
    l111l11111Il(String param1String1, String param1String2) {
      super((byte)0);
      this.l111l11111Il = param1String1;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l1111l111111Il);
      stringBuilder.append(param1String2);
      String str = stringBuilder.toString();
      this.l111l11111I1l = new ArrayList<String>();
      String[] arrayOfString = l111l11111lIl;
      while (i < 4) {
        String str1 = arrayOfString[i];
        List<String> list = this.l111l11111I1l;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(File.separator);
        stringBuilder1.append(str);
        list.add(stringBuilder1.toString());
        i++;
      } 
    }
    
    protected final List<String> l1111l111111Il() {
      return this.l111l11111I1l;
    }
    
    public final void l111l11111lIl(String param1String) {
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.l111l11111Il);
        stringBuilder.append("_");
        stringBuilder.append(param1String);
        super.l111l11111lIl(com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111lIl(stringBuilder.toString().getBytes()));
        return;
      } catch (IOException iOException) {
        return;
      } 
    }
  }
  
  static abstract class l111l11111lIl implements l111l1111lI1l {
    private ReadWriteLock l1111l111111Il = new ReentrantReadWriteLock(true);
    
    private l111l11111lIl() {}
    
    protected abstract void l1111l111111Il(String param1String);
    
    public final String l111l11111I1l() {
      try {
        boolean bool = this.l1111l111111Il.readLock().tryLock(50L, TimeUnit.MILLISECONDS);
        if (bool)
          try {
            return l111l11111lIl();
          } finally {
            this.l1111l111111Il.readLock().unlock();
          }  
      } catch (Exception exception) {}
      return "";
    }
    
    protected abstract String l111l11111lIl();
    
    public void l111l11111lIl(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return; 
      try {
        this.l1111l111111Il.writeLock().lock();
      } catch (Exception exception) {
      
      } finally {
        this.l1111l111111Il.writeLock().unlock();
      } 
      this.l1111l111111Il.writeLock().unlock();
    }
  }
  
  static final class l111l1111l1Il extends l1111l111111Il {
    private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c978a929a96d18b878b");
    
    private List<String> l111l11111lIl = new ArrayList<String>();
    
    l111l1111l1Il() {
      super((byte)0);
      this.l111l11111lIl.add(l1111l111111Il);
    }
    
    protected final List<String> l1111l111111Il() {
      return this.l111l11111lIl;
    }
  }
  
  static interface l111l1111lI1l {
    String l111l11111I1l();
    
    void l111l11111lIl(String param1String);
  }
  
  static final class l111l1111lIl extends l111l11111I1l {
    private String l1111l111111Il;
    
    l111l1111lIl(String param1String) {
      super((byte)0);
      Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
      if (context == null)
        return; 
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1String);
        stringBuilder.append("_");
        stringBuilder.append(context.getPackageName());
        this.l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lIl.l111l1111l1Il(stringBuilder.toString());
        return;
      } catch (Exception exception) {
        return;
      } 
    }
    
    protected final String l1111l111111Il() {
      return this.l1111l111111Il;
    }
    
    protected final String l111l11111Il() {
      return this.l1111l111111Il;
    }
  }
  
  static final class l111l1111llIl extends l1111l111111Il {
    private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("d18b978a929d9c9e9c979aa0969b87a0");
    
    private static final String[] l111l11111lIl = new String[] { "", com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bbbcb6b2"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("af969c8b8a8d9a8c"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bb90889193909e9b"), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("bb909c8a929a918b8c") };
    
    private List<String> l111l11111I1l;
    
    private String l111l11111Il;
    
    l111l1111llIl(String param1String) {
      super((byte)0);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l1111l111111Il);
      stringBuilder.append(param1String);
      this.l111l11111Il = stringBuilder.toString();
      this.l111l11111I1l = new ArrayList<String>();
      String[] arrayOfString = l111l11111lIl;
      while (i < 5) {
        String str = arrayOfString[i];
        List<String> list = this.l111l11111I1l;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append(File.separator);
        stringBuilder1.append(this.l111l11111Il);
        list.add(stringBuilder1.toString());
        i++;
      } 
    }
    
    protected final List<String> l1111l111111Il() {
      return this.l111l11111I1l;
    }
    
    public final String l111l11111lIl() {
      String str = super.l111l11111lIl();
      return TextUtils.isEmpty(str) ? "" : SMSDK.xx6(str, this.l111l11111Il);
    }
  }
  
  static final class l11l1111I11l extends l111l11111I1l {
    private l11l1111I11l() {
      super((byte)0);
    }
    
    protected final String l1111l111111Il() {
      return com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c9092d18c978a929a96");
    }
    
    protected final String l111l11111Il() {
      return com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9a89969c9a969b");
    }
  }
  
  static final class l11l1111I1l extends l111l11111I1l {
    private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("a08c978a929a96");
    
    private l11l1111I1l() {
      super((byte)0);
    }
    
    protected final String l1111l111111Il() {
      Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
      if (context == null)
        return null; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(context.getPackageName());
      stringBuilder.append(l1111l111111Il);
      return com.ishumei.l111l1111llIl.l111l1111lIl.l111l1111l1Il(stringBuilder.toString());
    }
    
    protected final String l111l11111Il() {
      return l1111l111111Il();
    }
    
    public final String l111l11111lIl() {
      String str = super.l111l11111lIl();
      return TextUtils.isEmpty(str) ? "" : SMSDK.xx6(str, l1111l111111Il());
    }
  }
  
  static final class l11l1111lIIl extends l111l11111I1l {
    private static final String l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c9092d18c978a929a96");
    
    private static final String l111l11111lIl = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9a89969c9a969b");
    
    l11l1111lIIl() {
      super((byte)0);
    }
    
    protected final String l1111l111111Il() {
      return l1111l111111Il;
    }
    
    protected final String l111l11111Il() {
      return l111l11111lIl;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l1111l111111Il\l11l1111I1l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */