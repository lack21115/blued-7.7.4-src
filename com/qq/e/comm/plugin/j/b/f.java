package com.qq.e.comm.plugin.j.b;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.j.b;
import com.qq.e.comm.plugin.j.b.a.a;
import com.qq.e.comm.plugin.j.b.a.b;
import com.qq.e.comm.plugin.j.c;
import com.qq.e.comm.plugin.j.d;
import com.qq.e.comm.plugin.j.e;
import com.qq.e.comm.plugin.j.f;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class f implements e, f {
  private static final com.qq.e.comm.plugin.j.a s = new com.qq.e.comm.plugin.j.a() {
      public void a() {}
      
      public void a(long param1Long1, long param1Long2, int param1Int) {}
      
      public void a(long param1Long, boolean param1Boolean) {}
      
      public void a(c param1c) {}
      
      public void a(File param1File, long param1Long) {}
      
      public void b() {}
      
      public void c() {}
    };
  
  private final String a;
  
  private final File b;
  
  private final int c;
  
  private final b d;
  
  private final l e;
  
  private final ExecutorService f;
  
  private a g;
  
  private AtomicBoolean h = new AtomicBoolean(false);
  
  private int i;
  
  private String j;
  
  private f k;
  
  private g l;
  
  private long m = -1L;
  
  private int n;
  
  private long o;
  
  private long p;
  
  private final List<h> q = new ArrayList<h>();
  
  private com.qq.e.comm.plugin.j.a r;
  
  public f(String paramString, File paramFile, int paramInt, b paramb) {
    this.a = paramString;
    this.b = paramFile;
    this.c = paramInt;
    this.d = new b(paramb.a(), paramb.b(), paramb.c());
    this.e = new b();
    this.f = paramb.d();
  }
  
  private File a(int paramInt) {
    String str = this.b.getName();
    File file = this.b.getParentFile();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append("_");
    stringBuilder.append(paramInt);
    return new File(file, stringBuilder.toString());
  }
  
  private Future<Pair<Integer, String>> a(a parama) {
    ExecutorService executorService = this.f;
    return (executorService == null) ? new n<Pair<Integer, String>>(parama) : executorService.submit(parama);
  }
  
  private void a(long paramLong, l.a[] paramArrayOfa) {
    int j = paramArrayOfa.length;
    long[] arrayOfLong1 = new long[j];
    long[] arrayOfLong2 = new long[j];
    int i;
    for (i = 0; i < j; i++) {
      long l1;
      arrayOfLong1[i] = paramArrayOfa[i].b();
      File file = a(i);
      if (file != null) {
        l1 = file.length();
      } else {
        l1 = 0L;
      } 
      arrayOfLong2[i] = l1;
    } 
    this.l = new g(paramLong, arrayOfLong1, arrayOfLong2);
    this.l.a(this);
  }
  
  private void a(List<File> paramList) {
    if (this.b.exists())
      this.b.delete(); 
    if (paramList.isEmpty())
      return; 
    for (File file : paramList) {
      if (file.exists())
        file.delete(); 
    } 
  }
  
  private boolean a(List<File> paramList, List<l.a> paramList1) {
    boolean bool;
    if (paramList1.size() != paramList.size()) {
      this.i |= 0x1;
      this.j = "RangeCount!=PartitionFileCount";
      bool = false;
    } else {
      boolean bool1 = true;
      int i = 0;
      while (true) {
        bool = bool1;
        if (i < paramList1.size()) {
          long l1 = ((l.a)paramList1.get(i)).b();
          bool = bool1;
          if (l1 > 0L) {
            if (l1 != ((File)paramList.get(i)).length()) {
              this.i |= 0x1;
              this.j = "PartitionFileSize!=RangeSize";
              bool1 = false;
            } 
            i++;
            continue;
          } 
        } 
        break;
      } 
    } 
    if (!bool) {
      Iterator<File> iterator = paramList.iterator();
      while (iterator.hasNext())
        ((File)iterator.next()).delete(); 
    } 
    return bool;
  }
  
  private boolean b(List<File> paramList) {
    // Byte code:
    //   0: invokestatic currentTimeMillis : ()J
    //   3: lstore_3
    //   4: aload_1
    //   5: invokeinterface size : ()I
    //   10: iconst_1
    //   11: if_icmpne -> 65
    //   14: aload_1
    //   15: iconst_0
    //   16: invokeinterface get : (I)Ljava/lang/Object;
    //   21: checkcast java/io/File
    //   24: aload_0
    //   25: getfield b : Ljava/io/File;
    //   28: invokestatic renameTo : (Ljava/io/File;Ljava/io/File;)Z
    //   31: ifne -> 192
    //   34: aload_0
    //   35: aload_0
    //   36: getfield i : I
    //   39: sipush #16384
    //   42: ior
    //   43: putfield i : I
    //   46: ldc 'ExceptionWhileRenameTmpFileToTargetFile'
    //   48: astore_1
    //   49: aload_0
    //   50: aload_1
    //   51: putfield j : Ljava/lang/String;
    //   54: aload_0
    //   55: invokestatic currentTimeMillis : ()J
    //   58: lload_3
    //   59: lsub
    //   60: putfield m : J
    //   63: iconst_0
    //   64: ireturn
    //   65: new java/io/FileOutputStream
    //   68: dup
    //   69: aload_0
    //   70: getfield b : Ljava/io/File;
    //   73: iconst_0
    //   74: invokespecial <init> : (Ljava/io/File;Z)V
    //   77: astore #5
    //   79: sipush #8192
    //   82: newarray byte
    //   84: astore #6
    //   86: aload_1
    //   87: invokeinterface iterator : ()Ljava/util/Iterator;
    //   92: astore #7
    //   94: aload #7
    //   96: invokeinterface hasNext : ()Z
    //   101: ifeq -> 155
    //   104: new java/io/FileInputStream
    //   107: dup
    //   108: aload #7
    //   110: invokeinterface next : ()Ljava/lang/Object;
    //   115: checkcast java/io/File
    //   118: invokespecial <init> : (Ljava/io/File;)V
    //   121: astore #8
    //   123: aload #8
    //   125: aload #6
    //   127: invokevirtual read : ([B)I
    //   130: istore_2
    //   131: iload_2
    //   132: ifle -> 147
    //   135: aload #5
    //   137: aload #6
    //   139: iconst_0
    //   140: iload_2
    //   141: invokevirtual write : ([BII)V
    //   144: goto -> 123
    //   147: aload #8
    //   149: invokevirtual close : ()V
    //   152: goto -> 94
    //   155: aload #5
    //   157: invokevirtual close : ()V
    //   160: aload_1
    //   161: invokeinterface iterator : ()Ljava/util/Iterator;
    //   166: astore_1
    //   167: aload_1
    //   168: invokeinterface hasNext : ()Z
    //   173: ifeq -> 192
    //   176: aload_1
    //   177: invokeinterface next : ()Ljava/lang/Object;
    //   182: checkcast java/io/File
    //   185: invokevirtual delete : ()Z
    //   188: pop
    //   189: goto -> 167
    //   192: aload_0
    //   193: getfield b : Ljava/io/File;
    //   196: invokevirtual exists : ()Z
    //   199: ifne -> 219
    //   202: aload_0
    //   203: aload_0
    //   204: getfield i : I
    //   207: ldc 32768
    //   209: ior
    //   210: putfield i : I
    //   213: ldc 'DownloadFileNotExist'
    //   215: astore_1
    //   216: goto -> 49
    //   219: aload_0
    //   220: invokestatic currentTimeMillis : ()J
    //   223: lload_3
    //   224: lsub
    //   225: putfield m : J
    //   228: iconst_1
    //   229: ireturn
    //   230: astore_1
    //   231: aload_0
    //   232: iconst_1
    //   233: aload_0
    //   234: getfield i : I
    //   237: ior
    //   238: putfield i : I
    //   241: new java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial <init> : ()V
    //   248: astore #5
    //   250: aload #5
    //   252: ldc 'UnknownExceptionWhileMerge:'
    //   254: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload #5
    //   260: aload_1
    //   261: invokevirtual getMessage : ()Ljava/lang/String;
    //   264: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload #5
    //   270: invokevirtual toString : ()Ljava/lang/String;
    //   273: astore_1
    //   274: aload_0
    //   275: aload_1
    //   276: putfield j : Ljava/lang/String;
    //   279: goto -> 54
    //   282: astore_1
    //   283: aload_0
    //   284: aload_0
    //   285: getfield i : I
    //   288: iconst_2
    //   289: ior
    //   290: putfield i : I
    //   293: new java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial <init> : ()V
    //   300: astore #5
    //   302: aload #5
    //   304: ldc_w 'UnknownIOExceptionWhileMerge:'
    //   307: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload #5
    //   313: aload_1
    //   314: invokevirtual getMessage : ()Ljava/lang/String;
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload #5
    //   323: invokevirtual toString : ()Ljava/lang/String;
    //   326: astore_1
    //   327: goto -> 274
    //   330: astore_1
    //   331: aload_0
    //   332: invokestatic currentTimeMillis : ()J
    //   335: lload_3
    //   336: lsub
    //   337: putfield m : J
    //   340: aload_1
    //   341: athrow
    // Exception table:
    //   from	to	target	type
    //   4	46	282	java/io/IOException
    //   4	46	230	finally
    //   49	54	282	java/io/IOException
    //   49	54	230	finally
    //   65	94	282	java/io/IOException
    //   65	94	230	finally
    //   94	123	282	java/io/IOException
    //   94	123	230	finally
    //   123	131	282	java/io/IOException
    //   123	131	230	finally
    //   135	144	282	java/io/IOException
    //   135	144	230	finally
    //   147	152	282	java/io/IOException
    //   147	152	230	finally
    //   155	167	282	java/io/IOException
    //   155	167	230	finally
    //   167	189	282	java/io/IOException
    //   167	189	230	finally
    //   192	213	282	java/io/IOException
    //   192	213	230	finally
    //   231	274	330	finally
    //   274	279	330	finally
    //   283	327	330	finally
  }
  
  private boolean b(List<File> paramList, List<l.a> paramList1) {
    File file = a(0);
    if (this.h.get()) {
      GDTLogger.d("download paused, quit");
      return false;
    } 
    try {
      String str;
      long l1;
      l.a[] arrayOfA;
      this.g = this.d.a(this.a, file.length(), -1L);
      if (!this.g.h()) {
        this.i |= this.g.b();
        this.j = this.g.g();
        this.g.f();
        ak.a("main fail, code = %d, msg = %s", new Object[] { Integer.valueOf(this.g.b()), this.g.g() });
        return false;
      } 
      ArrayList<Future<Pair<Integer, String>>> arrayList = new ArrayList();
      if (this.g.c()) {
        l1 = this.g.d();
        l1 = file.length() + l1;
        arrayOfA = this.e.a(l1, this.c);
        i().a(l1, true);
      } else if (!file.exists() || file.delete()) {
        l1 = this.g.d();
        arrayOfA = new l.a[1];
        arrayOfA[0] = new l.a(0L, l1);
        i().a(l1, false);
      } else {
        this.i |= 0x2000;
        str = "FailToDeleteMainPartitionFile";
        this.j = str;
      } 
      a(l1, arrayOfA);
      paramList1.add(arrayOfA[0]);
      e e1 = new e(this.g, file, arrayOfA[0].b());
      arrayList.add(a(new a(e1, this.l.a(0))));
      str.add(file);
      this.q.add(e1);
      for (int i = 1; i < arrayOfA.length && !this.h.get(); i++) {
        paramList1.add(arrayOfA[i]);
        file = a(i);
        str.add(file);
        m m = new m(this.a, file, arrayOfA[i].a(), arrayOfA[i].b(), this.d);
        this.q.add(m);
        arrayList.add(a(new a(m, this.l.a(i))));
      } 
      for (Future<Pair> future : arrayList) {
        try {
          Pair pair = future.get();
          if (((Integer)pair.first).intValue() != 0) {
            this.i |= ((Integer)pair.first).intValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.j);
            stringBuilder.append((String)pair.second);
            stringBuilder.append(";\t");
            this.j = stringBuilder.toString();
          } 
        } finally {
          future = null;
          this.i |= 0x1;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.j);
          stringBuilder.append("ExceptionWhileExecutePartitionWorks:");
          stringBuilder.append(future.getMessage());
          stringBuilder.append("\t");
        } 
      } 
      this.g.f();
      if (this.i == 0)
        return true; 
    } catch (IOException iOException) {
      ak.a("main exception: %s", iOException.toString());
      this.i |= 0x2;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("IOExceptionWhileCreateConnection ");
      stringBuilder.append(iOException.getMessage());
      String str = stringBuilder.toString();
      this.j = str;
    } 
    return false;
  }
  
  private boolean f() {
    long l1 = System.currentTimeMillis();
    boolean bool2 = false;
    this.i = 0;
    this.j = "";
    i().a();
    if (!g())
      return false; 
    ArrayList<File> arrayList = new ArrayList();
    ArrayList<l.a> arrayList1 = new ArrayList();
    boolean bool1 = bool2;
    if (b(arrayList, arrayList1)) {
      bool1 = bool2;
      if (a(arrayList, arrayList1)) {
        bool1 = bool2;
        if (b(arrayList)) {
          bool1 = bool2;
          if (this.i == 0)
            bool1 = true; 
        } 
      } 
    } 
    this.p = System.currentTimeMillis() - l1;
    this.n = arrayList.size();
    if (bool1) {
      l1 = this.b.length();
    } else {
      l1 = -1L;
    } 
    this.o = l1;
    if (bool1) {
      i().a(this.b, this.p);
      return bool1;
    } 
    if (d.c(this.i)) {
      this.i = 512;
      this.j = "DownloaderIsPausedManual";
      i().b();
      return bool1;
    } 
    if (d.d(this.i)) {
      this.i = 256;
      this.j = "DownloaderIsCanceledManual";
      i().c();
      a(arrayList);
      return bool1;
    } 
    i().a(new c(this.i, this.j));
    return bool1;
  }
  
  private boolean g() {
    com.qq.e.comm.plugin.j.a a1;
    c c;
    if (TextUtils.isEmpty(this.a)) {
      this.i |= 0x8000000;
      this.j = "UrlEmptyError";
      a1 = i();
      c = new c(this.i, this.j);
    } else {
      File file = this.b;
      if (file == null) {
        file = null;
      } else {
        file = file.getParentFile();
      } 
      if (file == null || (!file.exists() && !file.mkdirs())) {
        this.i |= 0x800;
        this.j = "FailToCreateDirectory";
        a1 = i();
        c = new c(this.i, this.j);
      } else {
        return true;
      } 
    } 
    a1.a(c);
    return false;
  }
  
  private void h() {
    if (!this.h.compareAndSet(false, true))
      return; 
    a a1 = this.g;
    if (a1 != null)
      a1.f(); 
    Iterator<h> iterator = this.q.iterator();
    while (iterator.hasNext())
      ((h)iterator.next()).c(); 
  }
  
  private com.qq.e.comm.plugin.j.a i() {
    com.qq.e.comm.plugin.j.a a2 = this.r;
    com.qq.e.comm.plugin.j.a a1 = a2;
    if (a2 == null)
      a1 = s; 
    return a1;
  }
  
  public int a() {
    return this.i;
  }
  
  public void a(long paramLong1, long paramLong2) {
    if (this.r != null) {
      int i;
      if (paramLong2 <= 0L) {
        i = 0;
      } else {
        i = (int)(100L * paramLong1 / paramLong2);
      } 
      this.r.a(paramLong1, paramLong2, i);
    } 
    f f1 = this.k;
    if (f1 != null)
      f1.a(paramLong1, paramLong2); 
  }
  
  public void a(com.qq.e.comm.plugin.j.a parama) {
    this.r = parama;
  }
  
  public void a(f paramf) {
    this.k = paramf;
  }
  
  public String b() {
    return this.j;
  }
  
  public boolean c() {
    try {
      return f();
    } catch (Exception exception) {
      i().a(new c(1, exception.getMessage(), exception));
      return false;
    } 
  }
  
  public void d() {
    h();
    this.i |= 0x200;
  }
  
  public void e() {
    h();
    this.i |= 0x100;
  }
  
  static class a implements Callable<Pair<Integer, String>> {
    private final h a;
    
    private final c b;
    
    public a(h param1h, c param1c) {
      this.a = param1h;
      this.b = param1c;
    }
    
    public Pair<Integer, String> a() throws Exception {
      this.a.a(this.b);
      return new Pair(Integer.valueOf(this.a.b()), this.a.a());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */