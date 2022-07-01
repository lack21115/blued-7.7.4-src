package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class a extends t {
  static a a;
  
  private static final long b = TimeUnit.SECONDS.toMillis(60L);
  
  private static final long d = TimeUnit.MILLISECONDS.toNanos(b);
  
  private boolean e;
  
  private a f;
  
  private long g;
  
  private static void a(a parama, long paramLong, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/a/a/a
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/a/a/a.a : Lcom/bytedance/sdk/a/a/a;
    //   6: ifnonnull -> 29
    //   9: new com/bytedance/sdk/a/a/a
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/bytedance/sdk/a/a/a.a : Lcom/bytedance/sdk/a/a/a;
    //   19: new com/bytedance/sdk/a/a/a$a
    //   22: dup
    //   23: invokespecial <init> : ()V
    //   26: invokevirtual start : ()V
    //   29: invokestatic nanoTime : ()J
    //   32: lstore #5
    //   34: lload_1
    //   35: lconst_0
    //   36: lcmp
    //   37: istore #4
    //   39: iload #4
    //   41: ifeq -> 69
    //   44: iload_3
    //   45: ifeq -> 69
    //   48: aload_0
    //   49: lload_1
    //   50: aload_0
    //   51: invokevirtual d : ()J
    //   54: lload #5
    //   56: lsub
    //   57: invokestatic min : (JJ)J
    //   60: lload #5
    //   62: ladd
    //   63: putfield g : J
    //   66: goto -> 97
    //   69: iload #4
    //   71: ifeq -> 85
    //   74: aload_0
    //   75: lload_1
    //   76: lload #5
    //   78: ladd
    //   79: putfield g : J
    //   82: goto -> 97
    //   85: iload_3
    //   86: ifeq -> 177
    //   89: aload_0
    //   90: aload_0
    //   91: invokevirtual d : ()J
    //   94: putfield g : J
    //   97: aload_0
    //   98: lload #5
    //   100: invokespecial b : (J)J
    //   103: lstore_1
    //   104: getstatic com/bytedance/sdk/a/a/a.a : Lcom/bytedance/sdk/a/a/a;
    //   107: astore #7
    //   109: aload #7
    //   111: getfield f : Lcom/bytedance/sdk/a/a/a;
    //   114: ifnull -> 145
    //   117: lload_1
    //   118: aload #7
    //   120: getfield f : Lcom/bytedance/sdk/a/a/a;
    //   123: lload #5
    //   125: invokespecial b : (J)J
    //   128: lcmp
    //   129: ifge -> 135
    //   132: goto -> 145
    //   135: aload #7
    //   137: getfield f : Lcom/bytedance/sdk/a/a/a;
    //   140: astore #7
    //   142: goto -> 109
    //   145: aload_0
    //   146: aload #7
    //   148: getfield f : Lcom/bytedance/sdk/a/a/a;
    //   151: putfield f : Lcom/bytedance/sdk/a/a/a;
    //   154: aload #7
    //   156: aload_0
    //   157: putfield f : Lcom/bytedance/sdk/a/a/a;
    //   160: aload #7
    //   162: getstatic com/bytedance/sdk/a/a/a.a : Lcom/bytedance/sdk/a/a/a;
    //   165: if_acmpne -> 173
    //   168: ldc com/bytedance/sdk/a/a/a
    //   170: invokevirtual notify : ()V
    //   173: ldc com/bytedance/sdk/a/a/a
    //   175: monitorexit
    //   176: return
    //   177: new java/lang/AssertionError
    //   180: dup
    //   181: invokespecial <init> : ()V
    //   184: athrow
    //   185: astore_0
    //   186: ldc com/bytedance/sdk/a/a/a
    //   188: monitorexit
    //   189: aload_0
    //   190: athrow
    // Exception table:
    //   from	to	target	type
    //   3	29	185	finally
    //   29	34	185	finally
    //   48	66	185	finally
    //   74	82	185	finally
    //   89	97	185	finally
    //   97	109	185	finally
    //   109	132	185	finally
    //   135	142	185	finally
    //   145	173	185	finally
    //   177	185	185	finally
  }
  
  private static boolean a(a parama) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/a/a/a
    //   2: monitorenter
    //   3: getstatic com/bytedance/sdk/a/a/a.a : Lcom/bytedance/sdk/a/a/a;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 45
    //   11: aload_1
    //   12: getfield f : Lcom/bytedance/sdk/a/a/a;
    //   15: aload_0
    //   16: if_acmpne -> 37
    //   19: aload_1
    //   20: aload_0
    //   21: getfield f : Lcom/bytedance/sdk/a/a/a;
    //   24: putfield f : Lcom/bytedance/sdk/a/a/a;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield f : Lcom/bytedance/sdk/a/a/a;
    //   32: ldc com/bytedance/sdk/a/a/a
    //   34: monitorexit
    //   35: iconst_0
    //   36: ireturn
    //   37: aload_1
    //   38: getfield f : Lcom/bytedance/sdk/a/a/a;
    //   41: astore_1
    //   42: goto -> 7
    //   45: ldc com/bytedance/sdk/a/a/a
    //   47: monitorexit
    //   48: iconst_1
    //   49: ireturn
    //   50: astore_0
    //   51: ldc com/bytedance/sdk/a/a/a
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	50	finally
    //   11	32	50	finally
    //   37	42	50	finally
  }
  
  static a ai_() throws InterruptedException {
    a a1 = a.f;
    a a2 = null;
    if (a1 == null) {
      long l1 = System.nanoTime();
      a.class.wait(b);
      a1 = a2;
      if (a.f == null) {
        a1 = a2;
        if (System.nanoTime() - l1 >= d)
          a1 = a; 
      } 
      return a1;
    } 
    long l = a1.b(System.nanoTime());
    if (l > 0L) {
      long l1 = l / 1000000L;
      a.class.wait(l1, (int)(l - 1000000L * l1));
      return null;
    } 
    a.f = a1.f;
    a1.f = null;
    return a1;
  }
  
  private long b(long paramLong) {
    return this.g - paramLong;
  }
  
  public final r a(r paramr) {
    return new r(this, paramr) {
        public t a() {
          return this.b;
        }
        
        public void a_(c param1c, long param1Long) throws IOException {
          u.a(param1c.b, 0L, param1Long);
          while (true) {
            long l = 0L;
            if (param1Long > 0L) {
              long l1;
              o o = param1c.a;
              while (true) {
                l1 = l;
                if (l < 65536L) {
                  l += (o.c - o.b);
                  if (l >= param1Long) {
                    l1 = param1Long;
                    break;
                  } 
                  o = o.f;
                  continue;
                } 
                break;
              } 
              this.b.a();
              try {
                this.a.a_(param1c, l1);
                param1Long -= l1;
                this.b.a(true);
                continue;
              } catch (IOException iOException) {
                throw this.b.a(iOException);
              } finally {}
              this.b.a(false);
              throw param1c;
            } 
            break;
          } 
        }
        
        public void close() throws IOException {
          Exception exception;
          this.b.a();
          try {
            this.a.close();
            this.b.a(true);
            return;
          } catch (IOException null) {
            throw this.b.a(exception);
          } finally {}
          this.b.a(false);
          throw exception;
        }
        
        public void flush() throws IOException {
          Exception exception;
          this.b.a();
          try {
            this.a.flush();
            this.b.a(true);
            return;
          } catch (IOException null) {
            throw this.b.a(exception);
          } finally {}
          this.b.a(false);
          throw exception;
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("AsyncTimeout.sink(");
          stringBuilder.append(this.a);
          stringBuilder.append(")");
          return stringBuilder.toString();
        }
      };
  }
  
  public final s a(s params) {
    return new s(this, params) {
        public long a(c param1c, long param1Long) throws IOException {
          this.b.a();
          try {
            param1Long = this.a.a(param1c, param1Long);
            this.b.a(true);
            return param1Long;
          } catch (IOException iOException) {
            throw this.b.a(iOException);
          } finally {}
          this.b.a(false);
          throw param1c;
        }
        
        public t a() {
          return this.b;
        }
        
        public void close() throws IOException {
          Exception exception;
          this.b.a();
          try {
            this.a.close();
            this.b.a(true);
            return;
          } catch (IOException null) {
            throw this.b.a(exception);
          } finally {}
          this.b.a(false);
          throw exception;
        }
        
        public String toString() {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("AsyncTimeout.source(");
          stringBuilder.append(this.a);
          stringBuilder.append(")");
          return stringBuilder.toString();
        }
      };
  }
  
  final IOException a(IOException paramIOException) throws IOException {
    return !b() ? paramIOException : b(paramIOException);
  }
  
  public final void a() {
    if (!this.e) {
      long l = aj_();
      boolean bool = ak_();
      if (l == 0L && !bool)
        return; 
      this.e = true;
      a(this, l, bool);
      return;
    } 
    throw new IllegalStateException("Unbalanced enter/exit");
  }
  
  final void a(boolean paramBoolean) throws IOException {
    if (b()) {
      if (!paramBoolean)
        return; 
      throw b(null);
    } 
  }
  
  protected IOException b(IOException paramIOException) {
    InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null)
      interruptedIOException.initCause(paramIOException); 
    return interruptedIOException;
  }
  
  public final boolean b() {
    if (!this.e)
      return false; 
    this.e = false;
    return a(this);
  }
  
  protected void c() {}
  
  static final class a extends Thread {
    a() {
      super("Okio Watchdog");
      setDaemon(true);
    }
    
    public void run() {
      // Byte code:
      //   0: ldc com/bytedance/sdk/a/a/a
      //   2: monitorenter
      //   3: invokestatic ai_ : ()Lcom/bytedance/sdk/a/a/a;
      //   6: astore_1
      //   7: aload_1
      //   8: ifnonnull -> 17
      //   11: ldc com/bytedance/sdk/a/a/a
      //   13: monitorexit
      //   14: goto -> 0
      //   17: aload_1
      //   18: getstatic com/bytedance/sdk/a/a/a.a : Lcom/bytedance/sdk/a/a/a;
      //   21: if_acmpne -> 32
      //   24: aconst_null
      //   25: putstatic com/bytedance/sdk/a/a/a.a : Lcom/bytedance/sdk/a/a/a;
      //   28: ldc com/bytedance/sdk/a/a/a
      //   30: monitorexit
      //   31: return
      //   32: ldc com/bytedance/sdk/a/a/a
      //   34: monitorexit
      //   35: aload_1
      //   36: invokevirtual c : ()V
      //   39: goto -> 0
      //   42: astore_1
      //   43: ldc com/bytedance/sdk/a/a/a
      //   45: monitorexit
      //   46: aload_1
      //   47: athrow
      //   48: astore_1
      //   49: goto -> 0
      // Exception table:
      //   from	to	target	type
      //   0	3	48	java/lang/InterruptedException
      //   3	7	42	finally
      //   11	14	42	finally
      //   17	31	42	finally
      //   32	35	42	finally
      //   35	39	48	java/lang/InterruptedException
      //   43	46	42	finally
      //   46	48	48	java/lang/InterruptedException
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */