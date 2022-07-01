package a.a.a.a.a.k.d;

import a.a.a.a.a.e.h;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

public final class f {
  public static Context a;
  
  public static String b;
  
  public a c = new a(this);
  
  public b d = new b(this);
  
  public d e = new d(this);
  
  public c f;
  
  public ArrayList<Float> g;
  
  public ArrayList<Float> h;
  
  public ArrayList<Float> i;
  
  public ArrayList<Float> j;
  
  public e k = new e();
  
  public static String a(String paramString) {
    return (paramString == null || "".equals(paramString)) ? "-" : paramString;
  }
  
  public final float a(ArrayList<Float> paramArrayList) {
    float f3 = 0.0F;
    float f2 = 0.0F;
    float f1 = f3;
    if (paramArrayList != null) {
      f1 = f3;
      if (!paramArrayList.isEmpty()) {
        Iterator<Float> iterator = paramArrayList.iterator();
        for (f1 = f2; iterator.hasNext(); f1 += ((Float)iterator.next()).floatValue());
        f1 /= paramArrayList.size();
      } 
    } 
    return f1;
  }
  
  public final String a(int paramInt1, int paramInt2) {
    float f1 = a(this.g);
    float f2 = a(this.h);
    float f3 = a(this.i);
    float f4 = a(this.j);
    int i = a.a.a.a.a.k.c.a.h();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.e.toString());
    stringBuilder.append("\t");
    stringBuilder.append(String.format("%.3f", new Object[] { Float.valueOf(f1) }));
    stringBuilder.append("\t");
    stringBuilder.append(String.format("%.3f", new Object[] { Float.valueOf(f2) }));
    stringBuilder.append("\t");
    stringBuilder.append(String.format("%.3f", new Object[] { Float.valueOf(f3) }));
    stringBuilder.append("\t");
    stringBuilder.append(String.format("%.3f", new Object[] { Float.valueOf(f4) }));
    stringBuilder.append("\t");
    stringBuilder.append("librtmp-1.1.0;PLDroidCameraStreaming-3.0.0");
    stringBuilder.append("\t");
    stringBuilder.append(i);
    stringBuilder.append("\t");
    stringBuilder.append(i());
    stringBuilder.append("\t");
    stringBuilder.append(0);
    stringBuilder.append("\t");
    stringBuilder.append(0);
    stringBuilder.append("\t");
    stringBuilder.append(0);
    stringBuilder.append("\t");
    stringBuilder.append(a((String)null));
    stringBuilder.append("\t");
    stringBuilder.append(paramInt1);
    stringBuilder.append("\t");
    stringBuilder.append(paramInt2);
    return stringBuilder.toString();
  }
  
  public void a(Context paramContext) {
    paramContext = paramContext.getApplicationContext();
    a = paramContext;
    this.k.a(paramContext);
    b = h.k(a);
  }
  
  public void a(Intent paramIntent) {
    String str2 = paramIntent.getStringExtra("videoEncoderType");
    String str3 = paramIntent.getStringExtra("audioEncoderType");
    int i = paramIntent.getIntExtra("videoFps", -1);
    int j = paramIntent.getIntExtra("audioFps", -1);
    long l = paramIntent.getLongExtra("gopTime", -1L);
    int k = paramIntent.getIntExtra("tcpConnect", 0);
    int m = paramIntent.getIntExtra("rtmpConnect", 0);
    int n = paramIntent.getIntExtra("firstByte", 0);
    this.c.a("stream_start", "v5");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.d.toString());
    stringBuilder.append("\t");
    stringBuilder.append(a(str2));
    stringBuilder.append("\t");
    stringBuilder.append(a(str3));
    stringBuilder.append("\t");
    stringBuilder.append(i);
    stringBuilder.append("\t");
    stringBuilder.append(j);
    stringBuilder.append("\t");
    stringBuilder.append(l);
    stringBuilder.append("\t");
    stringBuilder.append(k);
    stringBuilder.append("\t");
    stringBuilder.append(m);
    stringBuilder.append("\t");
    stringBuilder.append(n);
    stringBuilder.append("\n");
    String str1 = stringBuilder.toString();
    d(str1);
    c(str1);
  }
  
  public void b(Intent paramIntent) {
    long l1 = paramIntent.getLongExtra("beginAt", 0L);
    long l2 = paramIntent.getLongExtra("endAt", 0L);
    long l3 = paramIntent.getLongExtra("gopTime", -1L);
    int i = paramIntent.getIntExtra("videoSendFrames", -1);
    int j = paramIntent.getIntExtra("videoDroppedFrames", -1);
    int k = paramIntent.getIntExtra("audioSendFrames", -1);
    int m = paramIntent.getIntExtra("audioDroppedFrames", -1);
    long l4 = paramIntent.getLongExtra("totalSendBytes", -1L);
    int n = paramIntent.getIntExtra("tcpFullTime", 0);
    int i1 = paramIntent.getIntExtra("errorCode", 0);
    int i2 = paramIntent.getIntExtra("errorOSCode", 0);
    this.c.a("stream_end", "v5");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.d.toString());
    stringBuilder.append("\t");
    stringBuilder.append(l1);
    stringBuilder.append("\t");
    stringBuilder.append(l2);
    stringBuilder.append("\t");
    stringBuilder.append(l3);
    stringBuilder.append("\t");
    stringBuilder.append(i);
    stringBuilder.append("\t");
    stringBuilder.append(j);
    stringBuilder.append("\t");
    stringBuilder.append(k);
    stringBuilder.append("\t");
    stringBuilder.append(m);
    stringBuilder.append("\t");
    stringBuilder.append(l4);
    stringBuilder.append("\t");
    stringBuilder.append(n);
    stringBuilder.append("\t");
    stringBuilder.append(a(i1, i2));
    stringBuilder.append("\n");
    String str = stringBuilder.toString();
    d(str);
    c(str);
    a.a.a.a.a.k.b.b();
  }
  
  public void c() {
    this.k.b();
  }
  
  public final void c(String paramString) {
    this.k.b(paramString);
  }
  
  public b d() {
    return this.d;
  }
  
  public final void d(String paramString) {
    this.k.a(paramString);
  }
  
  public void e() {
    j();
  }
  
  public void f() {
    k();
  }
  
  public c g() {
    if (this.f == null)
      this.f = new c(this); 
    return this.f;
  }
  
  public void h() {
    this.c.a("stream", "v5");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.d.toString());
    stringBuilder.append("\t");
    stringBuilder.append(this.f.toString());
    stringBuilder.append("\n");
    d(stringBuilder.toString());
  }
  
  public final String i() {
    // Byte code:
    //   0: getstatic a/a/a/a/a/k/d/f.a : Landroid/content/Context;
    //   3: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   6: astore #8
    //   8: invokestatic a : ()Ljava/lang/String;
    //   11: astore #9
    //   13: invokestatic d : ()Ljava/lang/String;
    //   16: astore #10
    //   18: aload #8
    //   20: ldc_w 'WIFI'
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: istore_3
    //   27: aload #8
    //   29: ldc_w 'None'
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: istore #4
    //   37: aconst_null
    //   38: astore #7
    //   40: iconst_0
    //   41: istore_2
    //   42: iconst_0
    //   43: istore_1
    //   44: iload_3
    //   45: ifeq -> 102
    //   48: getstatic a/a/a/a/a/k/d/f.a : Landroid/content/Context;
    //   51: invokestatic f : (Landroid/content/Context;)[Ljava/lang/String;
    //   54: astore #5
    //   56: aload #5
    //   58: ifnull -> 166
    //   61: aload #5
    //   63: arraylength
    //   64: iconst_2
    //   65: if_icmplt -> 166
    //   68: aload #5
    //   70: iconst_0
    //   71: aaload
    //   72: astore #6
    //   74: iload_1
    //   75: istore_2
    //   76: aload #5
    //   78: iconst_1
    //   79: aaload
    //   80: invokestatic d : (Ljava/lang/String;)Z
    //   83: ifeq -> 94
    //   86: aload #5
    //   88: iconst_1
    //   89: aaload
    //   90: invokestatic parseInt : (Ljava/lang/String;)I
    //   93: istore_2
    //   94: iconst_0
    //   95: istore_1
    //   96: aconst_null
    //   97: astore #5
    //   99: goto -> 175
    //   102: iload #4
    //   104: ifne -> 166
    //   107: getstatic a/a/a/a/a/k/d/f.a : Landroid/content/Context;
    //   110: invokestatic g : (Landroid/content/Context;)[Ljava/lang/String;
    //   113: astore #11
    //   115: aload #11
    //   117: ifnull -> 166
    //   120: aload #11
    //   122: arraylength
    //   123: iconst_2
    //   124: if_icmplt -> 166
    //   127: aload #11
    //   129: iconst_0
    //   130: aaload
    //   131: astore #6
    //   133: aload #6
    //   135: astore #5
    //   137: aload #11
    //   139: iconst_1
    //   140: aaload
    //   141: invokestatic d : (Ljava/lang/String;)Z
    //   144: ifeq -> 169
    //   147: aload #11
    //   149: iconst_1
    //   150: aaload
    //   151: invokestatic parseInt : (Ljava/lang/String;)I
    //   154: istore_1
    //   155: aload #6
    //   157: astore #5
    //   159: aload #7
    //   161: astore #6
    //   163: goto -> 175
    //   166: aconst_null
    //   167: astore #5
    //   169: iconst_0
    //   170: istore_1
    //   171: aload #7
    //   173: astore #6
    //   175: new java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial <init> : ()V
    //   182: astore #7
    //   184: aload #7
    //   186: aload #8
    //   188: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   191: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload #7
    //   197: ldc '\\t'
    //   199: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload #7
    //   205: aload #9
    //   207: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   210: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload #7
    //   216: ldc '\\t'
    //   218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload #7
    //   224: aload #10
    //   226: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload #7
    //   235: ldc '\\t'
    //   237: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload #7
    //   243: aload #6
    //   245: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload #7
    //   254: ldc '\\t'
    //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload #7
    //   262: aload #5
    //   264: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload #7
    //   273: ldc '\\t'
    //   275: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload #7
    //   281: iload_2
    //   282: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload #7
    //   288: ldc '\\t'
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload #7
    //   296: iload_1
    //   297: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload #7
    //   303: invokevirtual toString : ()Ljava/lang/String;
    //   306: areturn
  }
  
  public final void j() {
    this.c.a("network_change", "v5");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.c.toString());
    stringBuilder.append("\t");
    stringBuilder.append(this.e.toString());
    stringBuilder.append("\t");
    stringBuilder.append(i());
    stringBuilder.append("\n");
    c(stringBuilder.toString());
  }
  
  public final void k() {
    float f1;
    a.a.a.a.a.k.c.a.a a1 = a.a.a.a.a.k.c.a.e();
    a.a.a.a.a.k.c.a.b b1 = a.a.a.a.a.k.c.a.a(a);
    float f3 = a1.a / 100.0F;
    float f4 = a1.b / 100.0F;
    long l = b1.a;
    float f2 = 0.0F;
    if (l != 0L) {
      f2 = (float)b1.b;
      f1 = (float)l;
      f2 /= f1;
      f1 = (float)b1.c / f1;
    } else {
      f1 = 0.0F;
    } 
    if (this.g == null)
      this.g = new ArrayList<Float>(); 
    if (this.h == null)
      this.h = new ArrayList<Float>(); 
    if (this.i == null)
      this.i = new ArrayList<Float>(); 
    if (this.j == null)
      this.j = new ArrayList<Float>(); 
    this.g.add(Float.valueOf(f3));
    this.h.add(Float.valueOf(f4));
    this.i.add(Float.valueOf(f2));
    this.j.add(Float.valueOf(f1));
  }
  
  public final class a {
    public String a;
    
    public long b;
    
    public a(f this$0) {}
    
    public final void a() {
      this.b = System.currentTimeMillis();
    }
    
    public void a(String param1String1, String param1String2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String1);
      stringBuilder.append(".");
      stringBuilder.append(param1String2);
      this.a = stringBuilder.toString();
    }
    
    public String toString() {
      a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(f.b(this.a));
      stringBuilder.append("\t");
      stringBuilder.append(this.b);
      stringBuilder.append("\t");
      stringBuilder.append(f.b(f.a()));
      stringBuilder.append("\t");
      stringBuilder.append(f.b("3.0.0"));
      return stringBuilder.toString();
    }
  }
  
  public final class b {
    public String a;
    
    public String b;
    
    public String c;
    
    public String d;
    
    public String e;
    
    public b(f this$0) {}
    
    public void a(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {
      this.a = param1String1;
      this.b = param1String2;
      this.e = param1String3;
      this.c = param1String4;
      this.d = param1String5;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(f.a(this.f).toString());
      stringBuilder.append("\t");
      stringBuilder.append(f.b(this.a));
      stringBuilder.append("\t");
      stringBuilder.append(f.b(this.b));
      stringBuilder.append("\t");
      stringBuilder.append(f.b(this.c));
      stringBuilder.append("\t");
      stringBuilder.append(f.b(this.d));
      stringBuilder.append("\t");
      stringBuilder.append(f.b(this.e));
      return stringBuilder.toString();
    }
  }
  
  public final class c {
    public int a = 0;
    
    public long b = 0L;
    
    public long c = 0L;
    
    public int d = 0;
    
    public int e = 0;
    
    public int f = 0;
    
    public int g = 0;
    
    public int h = 0;
    
    public int i = 0;
    
    public int j = 0;
    
    public long k = 0L;
    
    public long l = 0L;
    
    public int m;
    
    public c(f this$0) {}
    
    public boolean a(long param1Long1, long param1Long2, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8, long param1Long3, long param1Long4, int param1Int9) {
      this.b = param1Long1;
      this.c = param1Long2;
      this.a = param1Int1;
      this.d = param1Int2;
      this.e = param1Int3;
      this.f = param1Int4;
      this.g = param1Int5;
      this.h = param1Int6;
      this.i = param1Int7;
      this.j = param1Int6;
      this.j = param1Int8;
      this.k = param1Long3;
      this.l = param1Long4;
      this.m = param1Int9;
      return true;
    }
    
    public String toString() {
      StringBuilder stringBuilder1 = new StringBuilder();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.b);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.c);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.a);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.d);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.e);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.f);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.g);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.h);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.i);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.j);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.k);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(this.l);
      stringBuilder2.append("\t");
      stringBuilder1.append(stringBuilder2.toString());
      stringBuilder1.append(this.m);
      return stringBuilder1.toString();
    }
  }
  
  public final class d {
    public String a;
    
    public String b;
    
    public String c;
    
    public String d;
    
    public String e;
    
    public d(f this$0) {}
    
    public final void a() {
      this.a = h.i();
      this.b = "Android";
      this.c = h.j();
      this.d = h.i(f.b());
      this.e = h.j(f.b());
    }
    
    public String toString() {
      a();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(f.b(this.a));
      stringBuilder.append("\t");
      stringBuilder.append(f.b(this.b));
      stringBuilder.append("\t");
      stringBuilder.append(f.b(this.c));
      stringBuilder.append("\t");
      stringBuilder.append(f.b(this.d));
      stringBuilder.append("\t");
      stringBuilder.append(f.b(this.e));
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */