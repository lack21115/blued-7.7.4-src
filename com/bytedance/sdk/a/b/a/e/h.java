package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.c;
import com.bytedance.sdk.a.a.e;
import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.a.t;
import com.bytedance.sdk.a.b.a.c;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class h implements Closeable {
  static final Logger a = Logger.getLogger(e.class.getName());
  
  final d.a b;
  
  private final e c;
  
  private final a d;
  
  private final boolean e;
  
  h(e parame, boolean paramBoolean) {
    this.c = parame;
    this.e = paramBoolean;
    this.d = new a(this.c);
    this.b = new d.a(4096, this.d);
  }
  
  static int a(int paramInt, byte paramByte, short paramShort) throws IOException {
    int i = paramInt;
    if ((paramByte & 0x8) != 0)
      i = paramInt - 1; 
    if (paramShort <= i)
      return (short)(i - paramShort); 
    throw e.b("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(i) });
  }
  
  static int a(e parame) throws IOException {
    byte b1 = parame.h();
    byte b2 = parame.h();
    return parame.h() & 0xFF | (b1 & 0xFF) << 16 | (b2 & 0xFF) << 8;
  }
  
  private List<c> a(int paramInt1, short paramShort, byte paramByte, int paramInt2) throws IOException {
    a a1 = this.d;
    a1.d = paramInt1;
    a1.a = paramInt1;
    a1.e = paramShort;
    a1.b = paramByte;
    a1.c = paramInt2;
    this.b.a();
    return this.b.b();
  }
  
  private void a(b paramb, int paramInt) throws IOException {
    boolean bool;
    int i = this.c.j();
    if ((Integer.MIN_VALUE & i) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    paramb.a(paramInt, i & Integer.MAX_VALUE, (this.c.h() & 0xFF) + 1, bool);
  }
  
  private void a(b paramb, int paramInt1, byte paramByte, int paramInt2) throws IOException {
    short s = 0;
    if (paramInt2 != 0) {
      boolean bool;
      if ((paramByte & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if ((paramByte & 0x8) != 0)
        s = (short)(this.c.h() & 0xFF); 
      int i = paramInt1;
      if ((paramByte & 0x20) != 0) {
        a(paramb, paramInt2);
        i = paramInt1 - 5;
      } 
      paramb.a(bool, paramInt2, -1, a(a(i, paramByte, s), s, paramByte, paramInt2));
      return;
    } 
    throw e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
  }
  
  private void b(b paramb, int paramInt1, byte paramByte, int paramInt2) throws IOException {
    short s = 0;
    if (paramInt2 != 0) {
      boolean bool2;
      boolean bool1 = true;
      if ((paramByte & 0x1) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if ((paramByte & 0x20) == 0)
        bool1 = false; 
      if (!bool1) {
        if ((paramByte & 0x8) != 0)
          s = (short)(this.c.h() & 0xFF); 
        paramInt1 = a(paramInt1, paramByte, s);
        paramb.a(bool2, paramInt2, this.c, paramInt1);
        this.c.h(s);
        return;
      } 
      throw e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
    } 
    throw e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
  }
  
  private void c(b paramb, int paramInt1, byte paramByte, int paramInt2) throws IOException {
    if (paramInt1 == 5) {
      if (paramInt2 != 0) {
        a(paramb, paramInt2);
        return;
      } 
      throw e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
    } 
    throw e.b("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void d(b paramb, int paramInt1, byte paramByte, int paramInt2) throws IOException {
    if (paramInt1 == 4) {
      if (paramInt2 != 0) {
        paramInt1 = this.c.j();
        b b1 = b.a(paramInt1);
        if (b1 != null) {
          paramb.a(paramInt2, b1);
          return;
        } 
        throw e.b("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt1) });
      } 
      throw e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
    } 
    throw e.b("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void e(b paramb, int paramInt1, byte paramByte, int paramInt2) throws IOException {
    if (paramInt2 == 0) {
      if ((paramByte & 0x1) != 0) {
        if (paramInt1 == 0) {
          paramb.b();
          return;
        } 
        throw e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
      } 
      if (paramInt1 % 6 == 0) {
        n n = new n();
        for (paramInt2 = 0; paramInt2 < paramInt1; paramInt2 += 6) {
          short s1 = this.c.i();
          int i = this.c.j();
          short s = s1;
          switch (s1) {
            default:
              s = s1;
              break;
            case 5:
              if (i >= 16384 && i <= 16777215) {
                s = s1;
                break;
              } 
              throw e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i) });
            case 4:
              s = 7;
              if (i >= 0)
                break; 
              throw e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
            case 3:
              s = 4;
              break;
            case 2:
              s = s1;
              if (i != 0) {
                if (i == 1) {
                  s = s1;
                  break;
                } 
                throw e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
              } 
              break;
            case 1:
            case 6:
              break;
          } 
          n.a(s, i);
        } 
        paramb.a(false, n);
        return;
      } 
      throw e.b("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(paramInt1) });
    } 
    throw e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
  }
  
  private void f(b paramb, int paramInt1, byte paramByte, int paramInt2) throws IOException {
    short s = 0;
    if (paramInt2 != 0) {
      if ((paramByte & 0x8) != 0)
        s = (short)(this.c.h() & 0xFF); 
      paramb.a(paramInt2, this.c.j() & Integer.MAX_VALUE, a(a(paramInt1 - 4, paramByte, s), s, paramByte, paramInt2));
      return;
    } 
    throw e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
  }
  
  private void g(b paramb, int paramInt1, byte paramByte, int paramInt2) throws IOException {
    boolean bool = false;
    if (paramInt1 == 8) {
      if (paramInt2 == 0) {
        paramInt1 = this.c.j();
        paramInt2 = this.c.j();
        if ((paramByte & 0x1) != 0)
          bool = true; 
        paramb.a(bool, paramInt1, paramInt2);
        return;
      } 
      throw e.b("TYPE_PING streamId != 0", new Object[0]);
    } 
    throw e.b("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void h(b paramb, int paramInt1, byte paramByte, int paramInt2) throws IOException {
    if (paramInt1 >= 8) {
      if (paramInt2 == 0) {
        int i = this.c.j();
        paramInt2 = this.c.j();
        paramInt1 -= 8;
        b b1 = b.a(paramInt2);
        if (b1 != null) {
          f f = f.b;
          if (paramInt1 > 0)
            f = this.c.c(paramInt1); 
          paramb.a(i, b1, f);
          return;
        } 
        throw e.b("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
      } 
      throw e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
    } 
    throw e.b("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  private void i(b paramb, int paramInt1, byte paramByte, int paramInt2) throws IOException {
    if (paramInt1 == 4) {
      long l = this.c.j() & 0x7FFFFFFFL;
      if (l != 0L) {
        paramb.a(paramInt2, l);
        return;
      } 
      throw e.b("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
    } 
    throw e.b("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(paramInt1) });
  }
  
  public void a(b paramb) throws IOException {
    if (this.e) {
      if (a(true, paramb))
        return; 
      throw e.b("Required SETTINGS preface not received", new Object[0]);
    } 
    f f = this.c.c(e.a.g());
    if (a.isLoggable(Level.FINE))
      a.fine(c.a("<< CONNECTION %s", new Object[] { f.e() })); 
    if (e.a.equals(f))
      return; 
    throw e.b("Expected a connection header but was %s", new Object[] { f.a() });
  }
  
  public boolean a(boolean paramBoolean, b paramb) throws IOException {
    try {
      this.c.a(9L);
      int i = a(this.c);
      if (i >= 0 && i <= 16384) {
        byte b1 = (byte)(this.c.h() & 0xFF);
        if (!paramBoolean || b1 == 4) {
          byte b2 = (byte)(this.c.h() & 0xFF);
          int j = this.c.j() & Integer.MAX_VALUE;
          if (a.isLoggable(Level.FINE))
            a.fine(e.a(true, j, i, b1, b2)); 
          switch (b1) {
            default:
              this.c.h(i);
              return true;
            case 8:
              i(paramb, i, b2, j);
              return true;
            case 7:
              h(paramb, i, b2, j);
              return true;
            case 6:
              g(paramb, i, b2, j);
              return true;
            case 5:
              f(paramb, i, b2, j);
              return true;
            case 4:
              e(paramb, i, b2, j);
              return true;
            case 3:
              d(paramb, i, b2, j);
              return true;
            case 2:
              c(paramb, i, b2, j);
              return true;
            case 1:
              a(paramb, i, b2, j);
              return true;
            case 0:
              break;
          } 
          b(paramb, i, b2, j);
          return true;
        } 
        throw e.b("Expected a SETTINGS frame but was %s", new Object[] { Byte.valueOf(b1) });
      } 
      throw e.b("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) });
    } catch (IOException iOException) {
      return false;
    } 
  }
  
  public void close() throws IOException {
    this.c.close();
  }
  
  static final class a implements s {
    int a;
    
    byte b;
    
    int c;
    
    int d;
    
    short e;
    
    private final e f;
    
    a(e param1e) {
      this.f = param1e;
    }
    
    private void b() throws IOException {
      int i = this.c;
      int j = h.a(this.f);
      this.d = j;
      this.a = j;
      byte b = (byte)(this.f.h() & 0xFF);
      this.b = (byte)(this.f.h() & 0xFF);
      if (h.a.isLoggable(Level.FINE))
        h.a.fine(e.a(true, this.c, this.a, b, this.b)); 
      this.c = this.f.j() & Integer.MAX_VALUE;
      if (b == 9) {
        if (this.c == i)
          return; 
        throw e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
      } 
      throw e.b("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) });
    }
    
    public long a(c param1c, long param1Long) throws IOException {
      while (true) {
        int i = this.d;
        if (i == 0) {
          this.f.h(this.e);
          this.e = 0;
          if ((this.b & 0x4) != 0)
            return -1L; 
          b();
          continue;
        } 
        param1Long = this.f.a(param1c, Math.min(param1Long, i));
        if (param1Long == -1L)
          return -1L; 
        this.d = (int)(this.d - param1Long);
        return param1Long;
      } 
    }
    
    public t a() {
      return this.f.a();
    }
    
    public void close() throws IOException {}
  }
  
  static interface b {
    void a(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean);
    
    void a(int param1Int1, int param1Int2, List<c> param1List) throws IOException;
    
    void a(int param1Int, long param1Long);
    
    void a(int param1Int, b param1b);
    
    void a(int param1Int, b param1b, f param1f);
    
    void a(boolean param1Boolean, int param1Int1, int param1Int2);
    
    void a(boolean param1Boolean, int param1Int1, int param1Int2, List<c> param1List);
    
    void a(boolean param1Boolean, int param1Int1, e param1e, int param1Int2) throws IOException;
    
    void a(boolean param1Boolean, n param1n);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */