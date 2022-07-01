package com.blued.android.module.im.grpc;

import android.os.Handler;
import android.os.HandlerThread;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.util.Logger;
import com.blued.das.apm.ApmProtos;
import com.google.protobuf.Any;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.HashSet;

public abstract class BaseConnector {
  private static final int[] a = new int[] { 
      3000, 3000, 5000, 5000, 10000, 10000, 30000, 30000, 30000, 60000, 
      60000, 60000 };
  
  private volatile ConnectState b;
  
  private volatile boolean c = false;
  
  private Logger d;
  
  private String e = "";
  
  private boolean f = false;
  
  private boolean g = false;
  
  private HashSet<OnConnectStateListener> h = new HashSet<OnConnectStateListener>();
  
  private Runnable i = new Runnable(this) {
      public void run() {
        if (this.a.b())
          BaseConnector.b(this.a).e(new Object[] { "**** reconnect **** [", Integer.valueOf(BaseConnector.a(this.a)), "]" }); 
        BaseConnector.c(this.a);
      }
    };
  
  private int j = 0;
  
  private volatile HandlerThread k = null;
  
  private volatile Handler l = null;
  
  private ChannelManager m;
  
  private HeartBeat n;
  
  private Runnable o = null;
  
  private volatile long p = 0L;
  
  private ClientCall<Any, Any> q = null;
  
  private ClientCall.Listener<Any> r = new ClientCall.Listener<Any>(this) {
      public void a(Any param1Any) {
        if (this.a.b())
          BaseConnector.b(this.a).d(new Object[] { " << onMessage @", Thread.currentThread().getName(), " : ", param1Any }); 
        if (param1Any == null)
          return; 
        BaseConnector.a(this.a, new Runnable(this, param1Any) {
              public void run() {
                BaseConnector.a(this.b.a, this.a);
              }
            });
      }
      
      public void onClose(Status param1Status, Metadata param1Metadata) {
        if (this.a.b()) {
          String str1;
          String str2;
          Logger logger = BaseConnector.b(this.a);
          String str3 = Thread.currentThread().getName();
          if (param1Status == null) {
            str1 = "status is null!";
          } else {
            str1 = param1Status.toString();
          } 
          if (param1Metadata == null) {
            str2 = "trailers is null!";
          } else {
            str2 = param1Metadata.toString();
          } 
          logger.e(new Object[] { " << onClose : @", str3, " ", str1, "\n", str2 });
        } 
        BaseConnector.a(this.a, new Runnable(this, param1Status, param1Metadata) {
              public void run() {
                BaseConnector.a(this.c.a, this.a, this.b);
              }
            });
      }
      
      public void onHeaders(Metadata param1Metadata) {
        if (this.a.b()) {
          String str1;
          Logger logger = BaseConnector.b(this.a);
          String str2 = Thread.currentThread().getName();
          if (param1Metadata == null) {
            str1 = "";
          } else {
            str1 = param1Metadata.toString();
          } 
          logger.a(new Object[] { " << onHeaders @", str2, str1 });
        } 
        BaseConnector.a(this.a, new Runnable(this, param1Metadata) {
              public void run() {
                BaseConnector.a(this.b.a, this.a);
              }
            });
      }
      
      public void onReady() {
        if (this.a.b())
          BaseConnector.b(this.a).a(new Object[] { " << onReady @", Thread.currentThread().getName() }); 
      }
    };
  
  public BaseConnector(ChannelManager paramChannelManager) {
    this.m = paramChannelManager;
  }
  
  private void a(int paramInt, Exception paramException) {
    long l = System.currentTimeMillis() - this.p;
    BluedStatistics.b().a(a(), paramInt, l, paramException, this.m.a(), this.m.b());
    if (b())
      this.d.a(new Object[] { "writeApm : code=", Integer.valueOf(paramInt), ", elapseTime=", Long.valueOf(l) }); 
  }
  
  private void a(ConnectState paramConnectState) {
    a(paramConnectState, (Any)null);
  }
  
  private void a(ConnectState paramConnectState, Any paramAny) {
    this.b = paramConnectState;
    HashSet<OnConnectStateListener> hashSet = new HashSet();
    synchronized (this.h) {
      hashSet.addAll(this.h);
      for (OnConnectStateListener onConnectStateListener : hashSet) {
        int i = null.a[paramConnectState.ordinal()];
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 4)
                continue; 
              onConnectStateListener.onDisconnected();
              continue;
            } 
            onConnectStateListener.onReceive(paramAny);
            continue;
          } 
          onConnectStateListener.onConnected();
          continue;
        } 
        onConnectStateListener.onConnecting();
      } 
      return;
    } 
  }
  
  private void a(Metadata paramMetadata) {
    if (b())
      this.d.a(new Object[] { "  << onClientCallHeaders : @", Thread.currentThread().getName() }); 
    a(200, (Exception)null);
    n();
    this.j = 0;
    if (this.f)
      o(); 
    a(ConnectState.b);
  }
  
  private void a(Status paramStatus, Metadata paramMetadata) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual b : ()Z
    //   4: ifeq -> 32
    //   7: aload_0
    //   8: getfield d : Lcom/blued/android/statistics/util/Logger;
    //   11: iconst_2
    //   12: anewarray java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc '  << onClientCallClose : @'
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: invokestatic currentThread : ()Ljava/lang/Thread;
    //   25: invokevirtual getName : ()Ljava/lang/String;
    //   28: aastore
    //   29: invokevirtual a : ([Ljava/lang/Object;)V
    //   32: aload_0
    //   33: invokespecial n : ()V
    //   36: aload_0
    //   37: getfield f : Z
    //   40: ifeq -> 47
    //   43: aload_0
    //   44: invokespecial q : ()V
    //   47: aload_0
    //   48: getfield b : Lcom/blued/android/module/im/grpc/BaseConnector$ConnectState;
    //   51: getstatic com/blued/android/module/im/grpc/BaseConnector$ConnectState.a : Lcom/blued/android/module/im/grpc/BaseConnector$ConnectState;
    //   54: if_acmpne -> 62
    //   57: iconst_1
    //   58: istore_3
    //   59: goto -> 64
    //   62: iconst_0
    //   63: istore_3
    //   64: bipush #100
    //   66: istore #4
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_1
    //   71: ifnull -> 265
    //   74: aload_1
    //   75: invokevirtual asException : ()Lio/grpc/StatusException;
    //   78: astore #7
    //   80: aload_1
    //   81: invokevirtual getCode : ()Lio/grpc/Status$Code;
    //   84: invokevirtual value : ()I
    //   87: istore #5
    //   89: aload_1
    //   90: invokevirtual getDescription : ()Ljava/lang/String;
    //   93: astore_2
    //   94: aload_2
    //   95: astore #8
    //   97: aload_2
    //   98: ifnonnull -> 105
    //   101: ldc ''
    //   103: astore #8
    //   105: getstatic com/blued/android/module/im/grpc/BaseConnector$7.b : [I
    //   108: aload_1
    //   109: invokevirtual getCode : ()Lio/grpc/Status$Code;
    //   112: invokevirtual ordinal : ()I
    //   115: iaload
    //   116: istore #4
    //   118: iload #4
    //   120: iconst_1
    //   121: if_icmpeq -> 250
    //   124: iload #4
    //   126: iconst_2
    //   127: if_icmpeq -> 237
    //   130: iload #4
    //   132: iconst_3
    //   133: if_icmpeq -> 237
    //   136: iload #4
    //   138: iconst_4
    //   139: if_icmpeq -> 181
    //   142: iload #4
    //   144: iconst_5
    //   145: if_icmpeq -> 158
    //   148: iload #5
    //   150: istore #4
    //   152: aload #7
    //   154: astore_2
    //   155: goto -> 265
    //   158: iload #5
    //   160: istore #4
    //   162: aload #7
    //   164: astore_2
    //   165: aload_0
    //   166: getfield m : Lcom/blued/android/module/im/grpc/ChannelManager;
    //   169: invokevirtual g : ()Z
    //   172: ifne -> 265
    //   175: iconst_1
    //   176: istore #6
    //   178: goto -> 253
    //   181: aload #8
    //   183: ldc_w 'blued_connector_auth_timeout'
    //   186: invokevirtual equals : (Ljava/lang/Object;)Z
    //   189: ifeq -> 202
    //   192: iload #5
    //   194: istore #4
    //   196: aload #7
    //   198: astore_2
    //   199: goto -> 265
    //   202: aload #8
    //   204: ldc_w 'blued_connector_ping_timeout'
    //   207: invokevirtual equals : (Ljava/lang/Object;)Z
    //   210: ifeq -> 216
    //   213: goto -> 175
    //   216: iload #5
    //   218: istore #4
    //   220: aload #7
    //   222: astore_2
    //   223: aload #8
    //   225: ldc_w 'blued_connector_cancel'
    //   228: invokevirtual equals : (Ljava/lang/Object;)Z
    //   231: ifeq -> 265
    //   234: goto -> 250
    //   237: iconst_0
    //   238: istore #6
    //   240: iload #5
    //   242: istore #4
    //   244: aload #7
    //   246: astore_2
    //   247: goto -> 268
    //   250: iconst_0
    //   251: istore #6
    //   253: iconst_0
    //   254: istore_3
    //   255: iload #5
    //   257: istore #4
    //   259: aload #7
    //   261: astore_2
    //   262: goto -> 268
    //   265: iconst_1
    //   266: istore #6
    //   268: iload_3
    //   269: ifeq -> 279
    //   272: aload_0
    //   273: iload #4
    //   275: aload_2
    //   276: invokespecial a : (ILjava/lang/Exception;)V
    //   279: aload_0
    //   280: invokevirtual b : ()Z
    //   283: ifeq -> 351
    //   286: aload_0
    //   287: getfield d : Lcom/blued/android/statistics/util/Logger;
    //   290: bipush #7
    //   292: anewarray java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: ldc_w '    << onClose reconnect='
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: iload #6
    //   305: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   308: aastore
    //   309: dup
    //   310: iconst_2
    //   311: ldc_w ' [retry='
    //   314: aastore
    //   315: dup
    //   316: iconst_3
    //   317: aload_0
    //   318: getfield j : I
    //   321: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   324: aastore
    //   325: dup
    //   326: iconst_4
    //   327: ldc_w ', delayTime='
    //   330: aastore
    //   331: dup
    //   332: iconst_5
    //   333: aload_0
    //   334: invokespecial i : ()I
    //   337: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   340: aastore
    //   341: dup
    //   342: bipush #6
    //   344: ldc_w ']'
    //   347: aastore
    //   348: invokevirtual d : ([Ljava/lang/Object;)V
    //   351: iload #6
    //   353: ifeq -> 363
    //   356: aload_0
    //   357: invokespecial j : ()V
    //   360: goto -> 367
    //   363: aload_0
    //   364: invokespecial h : ()V
    //   367: aload_0
    //   368: iconst_0
    //   369: putfield c : Z
    //   372: return
  }
  
  private void a(Runnable paramRunnable) {
    if (this.l != null && paramRunnable != null)
      this.l.post(paramRunnable); 
  }
  
  private void a(Runnable paramRunnable, long paramLong) {
    if (this.l != null && paramRunnable != null)
      this.l.postDelayed(paramRunnable, paramLong); 
  }
  
  private void c(Any paramAny) {
    if (b())
      this.d.a(new Object[] { "  << onClientCallMessage : @", Thread.currentThread().getName() }); 
    if (this.f)
      p(); 
    try {
      paramAny = a(paramAny);
      if (paramAny != null) {
        a(ConnectState.c, paramAny);
        return;
      } 
    } catch (Exception exception) {
      if (b())
        this.d.e(new Object[] { "   << onMessage exception @", Thread.currentThread().getName(), " : \n", exception }); 
    } 
  }
  
  private void g() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual b : ()Z
    //   6: ifeq -> 26
    //   9: aload_0
    //   10: getfield d : Lcom/blued/android/statistics/util/Logger;
    //   13: iconst_1
    //   14: anewarray java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w '**** create thread ****'
    //   22: aastore
    //   23: invokevirtual e : ([Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getstatic com/blued/android/module/im/grpc/BaseConnector$ConnectState.a : Lcom/blued/android/module/im/grpc/BaseConnector$ConnectState;
    //   30: invokespecial a : (Lcom/blued/android/module/im/grpc/BaseConnector$ConnectState;)V
    //   33: new java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore_1
    //   41: aload_1
    //   42: aload_0
    //   43: getfield e : Ljava/lang/String;
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_1
    //   51: ldc_w '-connector'
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_0
    //   59: new android/os/HandlerThread
    //   62: dup
    //   63: aload_1
    //   64: invokevirtual toString : ()Ljava/lang/String;
    //   67: invokespecial <init> : (Ljava/lang/String;)V
    //   70: putfield k : Landroid/os/HandlerThread;
    //   73: aload_0
    //   74: getfield k : Landroid/os/HandlerThread;
    //   77: invokevirtual start : ()V
    //   80: aload_0
    //   81: new android/os/Handler
    //   84: dup
    //   85: aload_0
    //   86: getfield k : Landroid/os/HandlerThread;
    //   89: invokevirtual getLooper : ()Landroid/os/Looper;
    //   92: invokespecial <init> : (Landroid/os/Looper;)V
    //   95: putfield l : Landroid/os/Handler;
    //   98: aload_0
    //   99: monitorexit
    //   100: return
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	101	finally
    //   26	98	101	finally
  }
  
  private void h() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual b : ()Z
    //   6: ifeq -> 26
    //   9: aload_0
    //   10: getfield d : Lcom/blued/android/statistics/util/Logger;
    //   13: iconst_1
    //   14: anewarray java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w '**** destroy thread ****'
    //   22: aastore
    //   23: invokevirtual e : ([Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield k : Landroid/os/HandlerThread;
    //   30: ifnull -> 58
    //   33: aload_0
    //   34: getfield k : Landroid/os/HandlerThread;
    //   37: invokevirtual quit : ()Z
    //   40: pop
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield l : Landroid/os/Handler;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield k : Landroid/os/HandlerThread;
    //   51: aload_0
    //   52: getstatic com/blued/android/module/im/grpc/BaseConnector$ConnectState.d : Lcom/blued/android/module/im/grpc/BaseConnector$ConnectState;
    //   55: invokespecial a : (Lcom/blued/android/module/im/grpc/BaseConnector$ConnectState;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	61	finally
    //   26	58	61	finally
  }
  
  private int i() {
    int[] arrayOfInt = a;
    int i = this.j;
    if (i >= arrayOfInt.length)
      i = arrayOfInt.length - 1; 
    return arrayOfInt[i];
  }
  
  private void j() {
    if (this.l != null) {
      this.l.postDelayed(this.i, i());
      this.j++;
      a(ConnectState.a);
    } 
  }
  
  private void k() {
    a(new Runnable(this) {
          public void run() {
            if (this.a.b())
              BaseConnector.b(this.a).e(new Object[] { "**** cancel ****" }); 
            if (BaseConnector.d(this.a) != null)
              BaseConnector.d(this.a).cancel("blued_connector_cancel", null); 
          }
        });
  }
  
  private void l() {
    try {
      CallOptions callOptions;
      this.c = true;
      if (this.g) {
        callOptions = CallOptions.DEFAULT.withCompression("gzip");
      } else {
        callOptions = CallOptions.DEFAULT;
      } 
      this.q = this.m.e().newCall(c(), callOptions);
      m();
      this.p = System.currentTimeMillis();
      if (b())
        this.d.b(new Object[] { "## connector START!" }); 
      this.q.start(this.r, this.m.f());
      this.q.setMessageCompression(this.g);
      this.q.request(2147483647);
      if (b())
        this.d.b(new Object[] { "## connector FINISH!" }); 
    } catch (Exception exception) {
      a(Status.fromThrowable(exception).getCode().value(), exception);
      this.c = false;
      if (b())
        this.d.e(new Object[] { "## connect ERROR! \n", exception }); 
    } 
    if (!this.c) {
      ClientCall<Any, Any> clientCall = this.q;
      if (clientCall != null)
        clientCall.cancel("blued_connector_cancel", null); 
    } 
  }
  
  private void m() {
    if (this.o == null) {
      if (b())
        this.d.d(new Object[] { "startAuthTimeoutChecker!" }); 
      this.o = new Runnable(this) {
          public void run() {
            if (BaseConnector.d(this.a) != null) {
              BaseConnector.d(this.a).cancel("blued_connector_auth_timeout", null);
              if (this.a.b())
                BaseConnector.b(this.a).d(new Object[] { "AuthTimeout!" }); 
            } 
          }
        };
      a(this.o, 30000L);
    } 
  }
  
  private void n() {
    if (this.o != null) {
      if (b())
        this.d.d(new Object[] { "cancelAuthTimeoutChecker!" }); 
      if (this.l != null)
        this.l.removeCallbacks(this.o); 
      this.o = null;
    } 
  }
  
  private void o() {
    if (this.n == null) {
      this.n = new HeartBeat(this.l);
      this.n.a(new HeartBeat.OnBeatListener(this) {
            public void a() {
              if (this.a.b())
                BaseConnector.b(this.a).a(new Object[] { "  -- HeartBeat onPing @", Thread.currentThread().getName() }); 
              try {
                this.a.d();
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                return;
              } 
            }
            
            public void b() {
              if (this.a.b())
                BaseConnector.b(this.a).d(new Object[] { "  -- HeartBeat onTimeOut @", Thread.currentThread().getName() }); 
              if (BaseConnector.d(this.a) != null)
                BaseConnector.d(this.a).cancel("blued_connector_ping_timeout", null); 
            }
          });
    } 
  }
  
  private void p() {
    HeartBeat heartBeat = this.n;
    if (heartBeat != null)
      heartBeat.a(); 
  }
  
  private void q() {
    HeartBeat heartBeat = this.n;
    if (heartBeat != null) {
      heartBeat.b();
      this.n = null;
    } 
  }
  
  protected abstract ApmProtos.GrpcConnectTypeProto.BUSINESS a();
  
  protected abstract Any a(Any paramAny) throws Exception;
  
  public void a(OnConnectStateListener paramOnConnectStateListener) {
    if (paramOnConnectStateListener != null)
      synchronized (this.h) {
        this.h.add(paramOnConnectStateListener);
        return;
      }  
  }
  
  public void a(String paramString) {
    this.e = paramString;
    this.d = new Logger(paramString);
  }
  
  public void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public void b(OnConnectStateListener paramOnConnectStateListener) {
    if (paramOnConnectStateListener != null)
      synchronized (this.h) {
        this.h.remove(paramOnConnectStateListener);
        return;
      }  
  }
  
  public void b(Any paramAny) {
    a(new Runnable(this, paramAny) {
          public void run() {
            if (BaseConnector.d(this.b) != null && BaseConnector.d(this.b).isReady() && this.a != null) {
              BaseConnector.d(this.b).sendMessage(this.a);
              if (this.b.b())
                BaseConnector.b(this.b).c(new Object[] { "    >> send data :", this.a }); 
            } 
          }
        });
  }
  
  public void b(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  protected abstract boolean b();
  
  protected abstract MethodDescriptor c();
  
  protected abstract void d();
  
  public void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Landroid/os/HandlerThread;
    //   6: ifnonnull -> 25
    //   9: aload_0
    //   10: invokespecial g : ()V
    //   13: aload_0
    //   14: getfield l : Landroid/os/Handler;
    //   17: aload_0
    //   18: getfield i : Ljava/lang/Runnable;
    //   21: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   24: pop
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	25	28	finally
  }
  
  public void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield k : Landroid/os/HandlerThread;
    //   6: ifnull -> 38
    //   9: aload_0
    //   10: getfield l : Landroid/os/Handler;
    //   13: aload_0
    //   14: getfield i : Ljava/lang/Runnable;
    //   17: invokevirtual removeCallbacks : (Ljava/lang/Runnable;)V
    //   20: aload_0
    //   21: getfield c : Z
    //   24: ifeq -> 34
    //   27: aload_0
    //   28: invokespecial k : ()V
    //   31: goto -> 38
    //   34: aload_0
    //   35: invokespecial h : ()V
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	41	finally
    //   34	38	41	finally
  }
  
  enum ConnectState {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\grpc\BaseConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */