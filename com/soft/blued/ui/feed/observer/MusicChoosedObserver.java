package com.soft.blued.ui.feed.observer;

import java.util.ArrayList;
import java.util.List;

public class MusicChoosedObserver {
  private static MusicChoosedObserver a = new MusicChoosedObserver();
  
  private List<IMusicDownloadObserver> b = new ArrayList<IMusicDownloadObserver>();
  
  public static MusicChoosedObserver a() {
    return a;
  }
  
  public void a(IMusicDownloadObserver paramIMusicDownloadObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 25
    //   6: aload_0
    //   7: getfield b : Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface add : (Ljava/lang/Object;)Z
    //   16: pop
    //   17: goto -> 25
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    // Exception table:
    //   from	to	target	type
    //   6	17	20	finally
  }
  
  public void a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/List;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_3
    //   12: aload_3
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 49
    //   21: aload_3
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/soft/blued/ui/feed/observer/MusicChoosedObserver$IMusicDownloadObserver
    //   30: astore #4
    //   32: aload #4
    //   34: ifnull -> 12
    //   37: aload #4
    //   39: aload_1
    //   40: aload_2
    //   41: invokeinterface b : (Ljava/lang/String;Ljava/lang/String;)V
    //   46: goto -> 12
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	52	finally
    //   12	32	52	finally
    //   37	46	52	finally
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/List;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 44
    //   21: aload_1
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/soft/blued/ui/feed/observer/MusicChoosedObserver$IMusicDownloadObserver
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull -> 12
    //   35: aload_2
    //   36: invokeinterface p : ()V
    //   41: goto -> 12
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	47	finally
    //   12	31	47	finally
    //   35	41	47	finally
  }
  
  public void b(IMusicDownloadObserver paramIMusicDownloadObserver) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 25
    //   6: aload_0
    //   7: getfield b : Ljava/util/List;
    //   10: aload_1
    //   11: invokeinterface remove : (Ljava/lang/Object;)Z
    //   16: pop
    //   17: goto -> 25
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    // Exception table:
    //   from	to	target	type
    //   6	17	20	finally
  }
  
  public void b(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/List;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_3
    //   12: aload_3
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 49
    //   21: aload_3
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast com/soft/blued/ui/feed/observer/MusicChoosedObserver$IMusicDownloadObserver
    //   30: astore #4
    //   32: aload #4
    //   34: ifnull -> 12
    //   37: aload #4
    //   39: aload_1
    //   40: aload_2
    //   41: invokeinterface c : (Ljava/lang/String;Ljava/lang/String;)V
    //   46: goto -> 12
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	52	finally
    //   12	32	52	finally
    //   37	46	52	finally
  }
  
  public static interface IMusicDownloadObserver {
    void b(String param1String1, String param1String2);
    
    void c(String param1String1, String param1String2);
    
    void p();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\observer\MusicChoosedObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */