package com.bytedance.sdk.openadsdk.h.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.h.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class c extends a {
  public final File a;
  
  private final LinkedHashMap<String, File> b;
  
  private final ReentrantReadWriteLock c;
  
  private final ReentrantReadWriteLock.ReadLock d;
  
  private final ReentrantReadWriteLock.WriteLock e;
  
  private final Set<a> f;
  
  private volatile long g;
  
  private volatile float h;
  
  private final b i;
  
  private final Runnable j;
  
  private final Handler k;
  
  public c(File paramFile) throws IOException {
    String str;
    this.b = new LinkedHashMap<String, File>(0, 0.75F, true);
    this.c = new ReentrantReadWriteLock();
    this.d = this.c.readLock();
    this.e = this.c.writeLock();
    this.f = Collections.newSetFromMap(new ConcurrentHashMap<a, Boolean>());
    this.g = 104857600L;
    this.h = 0.5F;
    this.i = new b();
    this.j = new Runnable(this) {
        public void run() {
          com.bytedance.sdk.openadsdk.i.a.a().c(new Runnable(this) {
                public void run() {
                  c.a(this.a.a, c.a(this.a.a));
                }
              }1);
        }
      };
    this.k = new Handler(Looper.getMainLooper());
    if (paramFile == null || !paramFile.exists() || !paramFile.isDirectory() || !paramFile.canRead() || !paramFile.canWrite()) {
      if (paramFile == null) {
        str = " dir null";
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("exists: ");
        stringBuilder1.append(str.exists());
        stringBuilder1.append(", isDirectory: ");
        stringBuilder1.append(str.isDirectory());
        stringBuilder1.append(", canRead: ");
        stringBuilder1.append(str.canRead());
        stringBuilder1.append(", canWrite: ");
        stringBuilder1.append(str.canWrite());
        str = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("dir error!  ");
      stringBuilder.append(str);
      throw new IOException(stringBuilder.toString());
    } 
    this.a = (File)str;
    com.bytedance.sdk.openadsdk.i.a.a().c(new Runnable(this) {
          public void run() {
            c.b(this.a);
          }
        },  5);
  }
  
  private String a(File paramFile) {
    return paramFile.getName();
  }
  
  private void b() {
    this.e.lock();
    try {
      File[] arrayOfFile = this.a.listFiles();
      if (arrayOfFile != null && arrayOfFile.length > 0) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>(arrayOfFile.length);
        ArrayList<File> arrayList = new ArrayList(arrayOfFile.length);
        int j = arrayOfFile.length;
        for (int i = 0;; i++) {
          if (i < j) {
            File file = arrayOfFile[i];
            if (file.isFile()) {
              arrayList.add(file);
              hashMap.put(file, Long.valueOf(file.lastModified()));
            } 
          } else {
            Collections.sort(arrayList, new Comparator<File>(this, hashMap) {
                  public int a(File param1File1, File param1File2) {
                    int i = ((Long)this.a.get(param1File1)).longValue() - ((Long)this.a.get(param1File2)).longValue() cmp 0L;
                    return (i < 0) ? -1 : ((i > 0) ? 1 : 0);
                  }
                });
            for (File file : arrayList)
              this.b.put(a(file), file); 
            this.e.unlock();
            c();
          } 
        } 
      } 
      this.e.unlock();
    } finally {
      this.e.unlock();
    } 
  }
  
  private void b(long paramLong) {
    // Byte code:
    //   0: new java/util/HashSet
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #12
    //   9: aload_0
    //   10: getfield e : Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   13: invokevirtual lock : ()V
    //   16: lconst_0
    //   17: lstore #4
    //   19: aload_0
    //   20: getfield b : Ljava/util/LinkedHashMap;
    //   23: invokevirtual entrySet : ()Ljava/util/Set;
    //   26: invokeinterface iterator : ()Ljava/util/Iterator;
    //   31: astore #10
    //   33: aload #10
    //   35: invokeinterface hasNext : ()Z
    //   40: ifeq -> 76
    //   43: aload #10
    //   45: invokeinterface next : ()Ljava/lang/Object;
    //   50: checkcast java/util/Map$Entry
    //   53: invokeinterface getValue : ()Ljava/lang/Object;
    //   58: checkcast java/io/File
    //   61: invokevirtual length : ()J
    //   64: lstore #6
    //   66: lload #4
    //   68: lload #6
    //   70: ladd
    //   71: lstore #4
    //   73: goto -> 33
    //   76: lload #4
    //   78: lload_1
    //   79: lcmp
    //   80: ifgt -> 91
    //   83: aload_0
    //   84: getfield e : Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   87: invokevirtual unlock : ()V
    //   90: return
    //   91: lload_1
    //   92: l2f
    //   93: fstore_3
    //   94: fload_3
    //   95: aload_0
    //   96: getfield h : F
    //   99: fmul
    //   100: f2l
    //   101: lstore #6
    //   103: new java/util/HashSet
    //   106: dup
    //   107: invokespecial <init> : ()V
    //   110: astore #10
    //   112: aload_0
    //   113: getfield b : Ljava/util/LinkedHashMap;
    //   116: invokevirtual entrySet : ()Ljava/util/Set;
    //   119: invokeinterface iterator : ()Ljava/util/Iterator;
    //   124: astore #11
    //   126: aload #11
    //   128: invokeinterface hasNext : ()Z
    //   133: ifeq -> 304
    //   136: aload #11
    //   138: invokeinterface next : ()Ljava/lang/Object;
    //   143: checkcast java/util/Map$Entry
    //   146: astore #13
    //   148: aload #13
    //   150: invokeinterface getValue : ()Ljava/lang/Object;
    //   155: checkcast java/io/File
    //   158: astore #14
    //   160: aload #14
    //   162: ifnull -> 285
    //   165: aload #14
    //   167: invokevirtual exists : ()Z
    //   170: ifeq -> 285
    //   173: lload #4
    //   175: lstore_1
    //   176: aload_0
    //   177: getfield i : Lcom/bytedance/sdk/openadsdk/h/a/c$b;
    //   180: aload_0
    //   181: aload #14
    //   183: invokespecial a : (Ljava/io/File;)Ljava/lang/String;
    //   186: invokevirtual c : (Ljava/lang/String;)Z
    //   189: ifne -> 447
    //   192: aload #14
    //   194: invokevirtual length : ()J
    //   197: lstore #8
    //   199: new java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial <init> : ()V
    //   206: astore #15
    //   208: aload #15
    //   210: aload #14
    //   212: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload #15
    //   221: ldc_w '-tmp'
    //   224: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: new java/io/File
    //   231: dup
    //   232: aload #15
    //   234: invokevirtual toString : ()Ljava/lang/String;
    //   237: invokespecial <init> : (Ljava/lang/String;)V
    //   240: astore #15
    //   242: lload #4
    //   244: lstore_1
    //   245: aload #14
    //   247: aload #15
    //   249: invokevirtual renameTo : (Ljava/io/File;)Z
    //   252: ifeq -> 447
    //   255: aload #12
    //   257: aload #15
    //   259: invokevirtual add : (Ljava/lang/Object;)Z
    //   262: pop
    //   263: lload #4
    //   265: lload #8
    //   267: lsub
    //   268: lstore_1
    //   269: aload #10
    //   271: aload #13
    //   273: invokeinterface getKey : ()Ljava/lang/Object;
    //   278: invokevirtual add : (Ljava/lang/Object;)Z
    //   281: pop
    //   282: goto -> 447
    //   285: aload #10
    //   287: aload #13
    //   289: invokeinterface getKey : ()Ljava/lang/Object;
    //   294: invokevirtual add : (Ljava/lang/Object;)Z
    //   297: pop
    //   298: lload #4
    //   300: lstore_1
    //   301: goto -> 447
    //   304: aload #10
    //   306: invokevirtual iterator : ()Ljava/util/Iterator;
    //   309: astore #13
    //   311: aload #10
    //   313: astore #11
    //   315: aload #13
    //   317: invokeinterface hasNext : ()Z
    //   322: ifeq -> 369
    //   325: aload #13
    //   327: invokeinterface next : ()Ljava/lang/Object;
    //   332: checkcast java/lang/String
    //   335: astore #11
    //   337: aload_0
    //   338: getfield b : Ljava/util/LinkedHashMap;
    //   341: aload #11
    //   343: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   346: pop
    //   347: goto -> 311
    //   350: astore #11
    //   352: goto -> 360
    //   355: astore #11
    //   357: aconst_null
    //   358: astore #10
    //   360: aload #11
    //   362: invokevirtual printStackTrace : ()V
    //   365: aload #10
    //   367: astore #11
    //   369: aload_0
    //   370: getfield e : Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   373: invokevirtual unlock : ()V
    //   376: aload_0
    //   377: getfield f : Ljava/util/Set;
    //   380: invokeinterface iterator : ()Ljava/util/Iterator;
    //   385: astore #10
    //   387: aload #10
    //   389: invokeinterface hasNext : ()Z
    //   394: ifeq -> 417
    //   397: aload #10
    //   399: invokeinterface next : ()Ljava/lang/Object;
    //   404: checkcast com/bytedance/sdk/openadsdk/h/a/c$a
    //   407: aload #11
    //   409: invokeinterface a : (Ljava/util/Set;)V
    //   414: goto -> 387
    //   417: invokestatic a : ()Lcom/bytedance/sdk/openadsdk/i/a;
    //   420: new com/bytedance/sdk/openadsdk/h/a/c$5
    //   423: dup
    //   424: aload_0
    //   425: aload #12
    //   427: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/h/a/c;Ljava/util/HashSet;)V
    //   430: iconst_1
    //   431: invokevirtual c : (Ljava/lang/Runnable;I)V
    //   434: return
    //   435: astore #10
    //   437: aload_0
    //   438: getfield e : Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   441: invokevirtual unlock : ()V
    //   444: aload #10
    //   446: athrow
    //   447: lload_1
    //   448: lstore #4
    //   450: lload_1
    //   451: lload #6
    //   453: lcmp
    //   454: ifgt -> 126
    //   457: goto -> 304
    // Exception table:
    //   from	to	target	type
    //   19	33	355	finally
    //   33	66	355	finally
    //   94	112	355	finally
    //   112	126	350	finally
    //   126	160	350	finally
    //   165	173	350	finally
    //   176	242	350	finally
    //   245	263	350	finally
    //   269	282	350	finally
    //   285	298	350	finally
    //   304	311	350	finally
    //   315	347	350	finally
    //   360	365	435	finally
  }
  
  private void c() {
    this.k.removeCallbacks(this.j);
    this.k.postDelayed(this.j, 10000L);
  }
  
  public void a() {
    d.c().d();
    Context context = e.a();
    if (context != null)
      com.bytedance.sdk.openadsdk.h.b.c.a(context).a(0); 
    this.k.removeCallbacks(this.j);
    com.bytedance.sdk.openadsdk.i.a.a().c(new Runnable(this) {
          public void run() {
            c.a(this.a, 0L);
          }
        }1);
  }
  
  public void a(long paramLong) {
    this.g = paramLong;
    c();
  }
  
  public void a(a parama) {
    if (parama != null)
      this.f.add(parama); 
  }
  
  public void a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.i.a(paramString); 
  }
  
  public void b(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.i.b(paramString); 
  }
  
  public File c(String paramString) {
    this.d.lock();
    File file = this.b.get(paramString);
    this.d.unlock();
    if (file != null)
      return file; 
    file = new File(this.a, paramString);
    this.e.lock();
    this.b.put(paramString, file);
    this.e.unlock();
    Iterator<a> iterator = this.f.iterator();
    while (iterator.hasNext())
      ((a)iterator.next()).a(paramString); 
    c();
    return file;
  }
  
  public File d(String paramString) {
    if (this.d.tryLock()) {
      File file = this.b.get(paramString);
      this.d.unlock();
      return file;
    } 
    return null;
  }
  
  public static interface a {
    void a(String param1String);
    
    void a(Set<String> param1Set);
  }
  
  static final class b {
    private final Map<String, Integer> a = new HashMap<String, Integer>();
    
    private b() {}
    
    void a(String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   6: ifne -> 65
      //   9: aload_0
      //   10: getfield a : Ljava/util/Map;
      //   13: aload_1
      //   14: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   19: checkcast java/lang/Integer
      //   22: astore_2
      //   23: aload_2
      //   24: ifnonnull -> 45
      //   27: aload_0
      //   28: getfield a : Ljava/util/Map;
      //   31: aload_1
      //   32: iconst_1
      //   33: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   36: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   41: pop
      //   42: goto -> 65
      //   45: aload_0
      //   46: getfield a : Ljava/util/Map;
      //   49: aload_1
      //   50: aload_2
      //   51: invokevirtual intValue : ()I
      //   54: iconst_1
      //   55: iadd
      //   56: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   59: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   64: pop
      //   65: aload_0
      //   66: monitorexit
      //   67: return
      //   68: astore_1
      //   69: aload_0
      //   70: monitorexit
      //   71: aload_1
      //   72: athrow
      // Exception table:
      //   from	to	target	type
      //   2	23	68	finally
      //   27	42	68	finally
      //   45	65	68	finally
    }
    
    void b(String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   6: ifne -> 69
      //   9: aload_0
      //   10: getfield a : Ljava/util/Map;
      //   13: aload_1
      //   14: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   19: checkcast java/lang/Integer
      //   22: astore_2
      //   23: aload_2
      //   24: ifnull -> 69
      //   27: aload_2
      //   28: invokevirtual intValue : ()I
      //   31: iconst_1
      //   32: if_icmpne -> 49
      //   35: aload_0
      //   36: getfield a : Ljava/util/Map;
      //   39: aload_1
      //   40: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
      //   45: pop
      //   46: goto -> 69
      //   49: aload_0
      //   50: getfield a : Ljava/util/Map;
      //   53: aload_1
      //   54: aload_2
      //   55: invokevirtual intValue : ()I
      //   58: iconst_1
      //   59: isub
      //   60: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   63: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   68: pop
      //   69: aload_0
      //   70: monitorexit
      //   71: return
      //   72: astore_1
      //   73: aload_0
      //   74: monitorexit
      //   75: aload_1
      //   76: athrow
      // Exception table:
      //   from	to	target	type
      //   2	23	72	finally
      //   27	46	72	finally
      //   49	69	72	finally
    }
    
    boolean c(String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   6: ifne -> 24
      //   9: aload_0
      //   10: getfield a : Ljava/util/Map;
      //   13: aload_1
      //   14: invokeinterface containsKey : (Ljava/lang/Object;)Z
      //   19: istore_2
      //   20: aload_0
      //   21: monitorexit
      //   22: iload_2
      //   23: ireturn
      //   24: aload_0
      //   25: monitorexit
      //   26: iconst_0
      //   27: ireturn
      //   28: astore_1
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_1
      //   32: athrow
      // Exception table:
      //   from	to	target	type
      //   2	20	28	finally
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */