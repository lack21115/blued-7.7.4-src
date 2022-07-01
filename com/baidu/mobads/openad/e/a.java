package com.baidu.mobads.openad.e;

import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class a implements IOAdTimer {
  private static String c = "OAdTimer";
  
  protected int a = 300;
  
  private IOAdTimer.EventHandler b;
  
  private int d;
  
  private int e;
  
  private int f;
  
  private Timer g;
  
  private AtomicInteger h;
  
  private TimerTask i;
  
  public a(int paramInt) {
    this(paramInt, 300);
  }
  
  public a(int paramInt1, int paramInt2) {
    this.a = paramInt2;
    paramInt1 /= this.a;
    IXAdLogger iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
    String str = c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RendererTimer(duration=");
    stringBuilder.append(paramInt1);
    stringBuilder.append(")");
    iXAdLogger.d(str, stringBuilder.toString());
    this.d = paramInt1;
    this.e = paramInt1;
    this.g = new Timer();
    this.h = new AtomicInteger(-1);
  }
  
  public int getCurrentCount() {
    return this.f;
  }
  
  public int getRepeatCount() {
    return this.d;
  }
  
  public void pause() {
    XAdSDKFoundationFacade.getInstance().getAdLogger().d(c, "pause");
    this.h.set(1);
  }
  
  public void reset() {
    XAdSDKFoundationFacade.getInstance().getAdLogger().d(c, "reset");
    this.h.set(-1);
    this.e = this.d;
  }
  
  public void resume() {
    XAdSDKFoundationFacade.getInstance().getAdLogger().d(c, "resume");
    this.h.set(0);
  }
  
  public void setEventHandler(IOAdTimer.EventHandler paramEventHandler) {
    this.b = paramEventHandler;
  }
  
  public void start() {
    XAdSDKFoundationFacade.getInstance().getAdLogger().d(c, "start");
    this.h.set(0);
    try {
      this.i = new b(this);
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public void stop() {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   3: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   6: getstatic com/baidu/mobads/openad/e/a.c : Ljava/lang/String;
    //   9: ldc 'stop'
    //   11: invokeinterface d : (Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: aload_0
    //   18: getfield h : Ljava/util/concurrent/atomic/AtomicInteger;
    //   21: iconst_2
    //   22: invokevirtual set : (I)V
    //   25: aload_0
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield i : Ljava/util/TimerTask;
    //   31: ifnull -> 47
    //   34: aload_0
    //   35: getfield i : Ljava/util/TimerTask;
    //   38: invokevirtual cancel : ()Z
    //   41: pop
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield i : Ljava/util/TimerTask;
    //   47: aload_0
    //   48: getfield b : Lcom/baidu/mobads/openad/interfaces/utils/IOAdTimer$EventHandler;
    //   51: ifnull -> 59
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield b : Lcom/baidu/mobads/openad/interfaces/utils/IOAdTimer$EventHandler;
    //   59: aload_0
    //   60: getfield g : Ljava/util/Timer;
    //   63: ifnull -> 86
    //   66: aload_0
    //   67: getfield g : Ljava/util/Timer;
    //   70: invokevirtual purge : ()I
    //   73: pop
    //   74: aload_0
    //   75: getfield g : Ljava/util/Timer;
    //   78: invokevirtual cancel : ()V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield g : Ljava/util/Timer;
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Exception table:
    //   from	to	target	type
    //   27	47	89	finally
    //   47	59	89	finally
    //   59	86	89	finally
    //   86	88	89	finally
    //   90	92	89	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */