package a.a.a.a.a.a.j;

import a.a.a.a.a.e.e;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class c extends f {
  public e a;
  
  public volatile a b;
  
  public final void a() {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield w : La/a/a/a/a/a/j/f$a;
    //   5: getfield a : La/a/a/a/a/a/i/c;
    //   8: invokevirtual a : (La/a/a/a/a/a/i/c;)V
    //   11: aload_0
    //   12: getfield v : La/a/a/a/a/a/c;
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull -> 26
    //   20: aload_1
    //   21: invokeinterface d : ()V
    //   26: aload_0
    //   27: lconst_0
    //   28: putfield y : J
    //   31: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   34: ldc 'ScreenDataTransfer'
    //   36: ldc 'startEncoding -'
    //   38: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_0
    //   42: monitorenter
    //   43: aload_0
    //   44: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   47: putfield t : La/a/a/a/a/f/c;
    //   50: aload_0
    //   51: invokevirtual e : ()V
    //   54: aload_0
    //   55: monitorexit
    //   56: return
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   43	56	57	finally
    //   58	60	57	finally
  }
  
  public void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : La/a/a/a/a/a/j/e;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 16
    //   11: aload_2
    //   12: iload_1
    //   13: invokevirtual a : (I)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: astore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	19	finally
    //   11	16	19	finally
  }
  
  public final void a(a.a.a.a.a.a.i.c paramc) {
    try {
      this.a = new e(paramc);
      return;
    } catch (IOException iOException) {
      throw new RuntimeException(iOException);
    } 
  }
  
  public void a(f.a parama) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 19
    //   6: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   9: ldc 'ScreenDataTransfer'
    //   11: ldc 'config is null when startEncoding'
    //   13: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield t : La/a/a/a/a/f/c;
    //   23: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   26: if_acmpne -> 42
    //   29: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   32: ldc 'ScreenDataTransfer'
    //   34: ldc 'startEncoding failed as already being running'
    //   36: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield t : La/a/a/a/a/f/c;
    //   46: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   49: if_acmpne -> 77
    //   52: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   55: ldc 'ScreenDataTransfer'
    //   57: ldc 'set pending action as START'
    //   59: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload_0
    //   63: getstatic a/a/a/a/a/f/a.b : La/a/a/a/a/f/a;
    //   66: putfield u : La/a/a/a/a/f/a;
    //   69: aload_0
    //   70: aload_1
    //   71: putfield x : La/a/a/a/a/a/j/f$a;
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: aload_0
    //   78: getfield t : La/a/a/a/a/f/c;
    //   81: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   84: if_acmpne -> 122
    //   87: aload_0
    //   88: getfield u : La/a/a/a/a/f/a;
    //   91: getstatic a/a/a/a/a/f/a.c : La/a/a/a/a/f/a;
    //   94: if_acmpne -> 119
    //   97: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   100: ldc 'ScreenDataTransfer'
    //   102: ldc 'set pending action as RESTART'
    //   104: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: getstatic a/a/a/a/a/f/a.d : La/a/a/a/a/f/a;
    //   111: putfield u : La/a/a/a/a/f/a;
    //   114: aload_0
    //   115: aload_1
    //   116: putfield x : La/a/a/a/a/a/j/f$a;
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   125: ldc 'ScreenDataTransfer'
    //   127: ldc 'startEncoding +'
    //   129: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_0
    //   133: aload_1
    //   134: putfield w : La/a/a/a/a/a/j/f$a;
    //   137: aload_0
    //   138: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   141: putfield t : La/a/a/a/a/f/c;
    //   144: new android/os/HandlerThread
    //   147: dup
    //   148: ldc 'ScreenDataTransfer'
    //   150: invokespecial <init> : (Ljava/lang/String;)V
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual start : ()V
    //   158: aload_0
    //   159: new a/a/a/a/a/a/j/c$a
    //   162: dup
    //   163: aload_1
    //   164: invokevirtual getLooper : ()Landroid/os/Looper;
    //   167: aload_0
    //   168: invokespecial <init> : (Landroid/os/Looper;La/a/a/a/a/a/j/c;)V
    //   171: putfield b : La/a/a/a/a/a/j/c$a;
    //   174: aload_0
    //   175: invokevirtual a : ()V
    //   178: aload_0
    //   179: monitorexit
    //   180: return
    //   181: astore_1
    //   182: aload_0
    //   183: monitorexit
    //   184: aload_1
    //   185: athrow
    // Exception table:
    //   from	to	target	type
    //   6	16	181	finally
    //   19	39	181	finally
    //   42	74	181	finally
    //   77	119	181	finally
    //   122	178	181	finally
  }
  
  public Surface b(f.a parama) {
    a(parama);
    e e1 = this.a;
    return (e1 != null) ? e1.e() : null;
  }
  
  public final void b() {
    e e1 = this.a;
    if (e1 != null)
      e1.a(false); 
  }
  
  public void b(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : La/a/a/a/a/f/c;
    //   6: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   9: if_acmpne -> 25
    //   12: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   15: ldc 'ScreenDataTransfer'
    //   17: ldc 'stopEncoding failed as not being running'
    //   19: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield t : La/a/a/a/a/f/c;
    //   29: getstatic a/a/a/a/a/f/c.b : La/a/a/a/a/f/c;
    //   32: if_acmpne -> 55
    //   35: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   38: ldc 'ScreenDataTransfer'
    //   40: ldc 'set pending action as STOP'
    //   42: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getstatic a/a/a/a/a/f/a.c : La/a/a/a/a/f/a;
    //   49: putfield u : La/a/a/a/a/f/a;
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield t : La/a/a/a/a/f/c;
    //   59: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   62: if_acmpne -> 95
    //   65: aload_0
    //   66: getfield u : La/a/a/a/a/f/a;
    //   69: getstatic a/a/a/a/a/f/a.b : La/a/a/a/a/f/a;
    //   72: if_acmpne -> 92
    //   75: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   78: ldc 'ScreenDataTransfer'
    //   80: ldc 'clear pending start action'
    //   82: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: getstatic a/a/a/a/a/f/a.a : La/a/a/a/a/f/a;
    //   89: putfield u : La/a/a/a/a/f/a;
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   98: ldc 'ScreenDataTransfer'
    //   100: ldc 'stopEncoding +'
    //   102: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: getstatic a/a/a/a/a/f/c.d : La/a/a/a/a/f/c;
    //   109: putfield t : La/a/a/a/a/f/c;
    //   112: aload_0
    //   113: getfield b : La/a/a/a/a/a/j/c$a;
    //   116: aload_0
    //   117: getfield b : La/a/a/a/a/a/j/c$a;
    //   120: iconst_1
    //   121: iload_1
    //   122: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   125: invokevirtual obtainMessage : (ILjava/lang/Object;)Landroid/os/Message;
    //   128: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   131: pop
    //   132: aload_0
    //   133: monitorexit
    //   134: return
    //   135: astore_2
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_2
    //   139: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	135	finally
    //   25	52	135	finally
    //   55	92	135	finally
    //   95	132	135	finally
  }
  
  public final void c() {
    e e1 = this.a;
    if (e1 != null)
      e1.b(); 
  }
  
  public void c(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield t : La/a/a/a/a/f/c;
    //   6: getstatic a/a/a/a/a/f/c.c : La/a/a/a/a/f/c;
    //   9: if_acmpne -> 130
    //   12: invokestatic a : ()La/a/a/a/a/a/j/a;
    //   15: invokevirtual b : ()Z
    //   18: ifeq -> 24
    //   21: goto -> 130
    //   24: aload_0
    //   25: aload_0
    //   26: getfield y : J
    //   29: lconst_1
    //   30: ladd
    //   31: putfield y : J
    //   34: invokestatic d : ()Z
    //   37: ifeq -> 111
    //   40: aload_0
    //   41: getfield y : J
    //   44: ldc2_w 2
    //   47: lrem
    //   48: lconst_0
    //   49: lcmp
    //   50: ifne -> 111
    //   53: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   56: ldc 'ScreenDataTransfer'
    //   58: ldc 'Drop the in frame'
    //   60: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield w : La/a/a/a/a/a/j/f$a;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnull -> 111
    //   72: aload_2
    //   73: getfield a : La/a/a/a/a/a/i/c;
    //   76: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   79: astore_2
    //   80: aload_2
    //   81: aload_2
    //   82: getfield l : J
    //   85: lconst_1
    //   86: ladd
    //   87: putfield l : J
    //   90: aload_0
    //   91: getfield w : La/a/a/a/a/a/j/f$a;
    //   94: getfield a : La/a/a/a/a/a/i/c;
    //   97: invokevirtual e : ()La/a/a/a/a/a/i/c$b;
    //   100: astore_2
    //   101: aload_2
    //   102: aload_2
    //   103: getfield w : J
    //   106: lconst_1
    //   107: ladd
    //   108: putfield w : J
    //   111: aload_0
    //   112: getfield b : La/a/a/a/a/a/j/c$a;
    //   115: aload_0
    //   116: getfield b : La/a/a/a/a/a/j/c$a;
    //   119: iconst_2
    //   120: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   123: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   126: pop
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	133	finally
    //   24	68	133	finally
    //   72	111	133	finally
    //   111	127	133	finally
  }
  
  public final void d(boolean paramBoolean) {
    // Byte code:
    //   0: invokestatic myLooper : ()Landroid/os/Looper;
    //   3: invokevirtual quit : ()V
    //   6: aload_0
    //   7: getfield a : La/a/a/a/a/a/j/e;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull -> 31
    //   15: iload_1
    //   16: ifeq -> 31
    //   19: aload_2
    //   20: invokevirtual a : ()V
    //   23: aload_0
    //   24: getfield a : La/a/a/a/a/a/j/e;
    //   27: iconst_1
    //   28: invokevirtual a : (Z)V
    //   31: aload_0
    //   32: invokevirtual c : ()V
    //   35: aload_0
    //   36: getfield v : La/a/a/a/a/a/c;
    //   39: astore_2
    //   40: aload_2
    //   41: ifnull -> 50
    //   44: aload_2
    //   45: invokeinterface a : ()V
    //   50: getstatic a/a/a/a/a/e/e.f : La/a/a/a/a/e/e;
    //   53: ldc 'ScreenDataTransfer'
    //   55: ldc 'stopEncoding -'
    //   57: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_0
    //   61: monitorenter
    //   62: aload_0
    //   63: getstatic a/a/a/a/a/f/c.a : La/a/a/a/a/f/c;
    //   66: putfield t : La/a/a/a/a/f/c;
    //   69: aload_0
    //   70: invokevirtual e : ()V
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: astore_2
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   62	75	76	finally
    //   77	79	76	finally
  }
  
  public static class a extends Handler {
    public WeakReference<c> a;
    
    public a(Looper param1Looper, c param1c) {
      super(param1Looper);
      this.a = new WeakReference<c>(param1c);
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      Object object = param1Message.obj;
      c c = this.a.get();
      e e = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("EncoderHandler what:");
      stringBuilder.append(i);
      stringBuilder.append(",encoder=");
      stringBuilder.append(c);
      e.c("ScreenDataTransfer", stringBuilder.toString());
      if (c == null) {
        e.f.d("ScreenDataTransfer", "EncoderHandler.handleMessage: encoder is null");
        return;
      } 
      if (i != 1) {
        if (i == 2) {
          c.a(c);
          return;
        } 
        object = new StringBuilder();
        object.append("Unhandled msg what=");
        object.append(i);
        throw new RuntimeException(object.toString());
      } 
      c.a(c, ((Boolean)object).booleanValue());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\a\j\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */