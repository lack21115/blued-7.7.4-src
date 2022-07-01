package com.tencent.bugly.yaq.proguard;

import android.content.ContentValues;

public interface o {
  byte[] a();
  
  String b();
  
  boolean c();
  
  final class a extends Thread {
    private int a;
    
    private n b;
    
    private String c;
    
    private ContentValues d;
    
    private boolean e;
    
    private String[] f;
    
    private String g;
    
    private String[] h;
    
    private String i;
    
    private String j;
    
    private String k;
    
    private String l;
    
    private String m;
    
    private String[] n;
    
    private int o;
    
    private String p;
    
    private byte[] q;
    
    public a(o this$0, int param1Int, n param1n) {
      this.a = param1Int;
      this.b = param1n;
      throw new VerifyError("bad dex opcode");
    }
    
    public final void a(int param1Int, String param1String, byte[] param1ArrayOfbyte) {
      this.o = param1Int;
      this.p = param1String;
      this.q = param1ArrayOfbyte;
      throw new VerifyError("bad dex opcode");
    }
    
    public final void a(boolean param1Boolean, String param1String1, String[] param1ArrayOfString1, String param1String2, String[] param1ArrayOfString2, String param1String3, String param1String4, String param1String5, String param1String6) {
      this.e = param1Boolean;
      this.c = param1String1;
      this.f = param1ArrayOfString1;
      this.g = param1String2;
      this.h = param1ArrayOfString2;
      this.i = param1String3;
      this.j = param1String4;
      this.k = param1String5;
      this.l = param1String6;
      throw new VerifyError("bad dex opcode");
    }
    
    public final void run() {
      switch (this.a) {
        default:
          throw new VerifyError("bad dex opcode");
        case 1:
          o.a(this.r, this.c, this.d, this.b);
        case 2:
          o.a(this.r, this.c, this.m, this.n, this.b);
        case 3:
          o.a(this.r, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
        case 4:
          o.a(this.r, this.o, this.p, this.q, this.b);
        case 5:
          o.a(this.r, this.o, this.b);
        case 6:
          break;
      } 
      o o1 = this.r;
      o.a(this.o, this.p, this.b);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */