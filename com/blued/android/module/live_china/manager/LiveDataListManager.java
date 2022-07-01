package com.blued.android.module.live_china.manager;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.same.Logger;
import java.util.ArrayList;
import java.util.List;

public class LiveDataListManager {
  private static LiveDataListManager c;
  
  private List<Long> a = new ArrayList<Long>();
  
  private List<LiveRoomData> b = new ArrayList<LiveRoomData>();
  
  public static LiveDataListManager a() {
    if (c == null)
      c = new LiveDataListManager(); 
    return c;
  }
  
  private static void a(Context paramContext, LiveRoomData paramLiveRoomData, int paramInt) {
    PlayingOnliveFragment.a(paramContext, paramLiveRoomData, paramInt, a().b());
  }
  
  public static boolean a(Context paramContext, long paramLong, int paramInt, String paramString) {
    List<LiveRoomData> list = a().b();
    if (list.size() == 1)
      return false; 
    int i;
    for (i = 0; i < list.size(); i++) {
      LiveRoomData liveRoomData = list.get(i);
      Logger.a("ddrb", new Object[] { "liveData.lid = ", Long.valueOf(liveRoomData.lid), "-- sessionId = ", Long.valueOf(paramLong) });
      if (liveRoomData.lid == paramLong) {
        if (paramInt == 0) {
          paramInt = i + 1;
          if (paramInt == list.size()) {
            liveRoomData = list.get(0);
            paramInt = 0;
          } else {
            liveRoomData = list.get(paramInt);
          } 
        } else if (i == 0) {
          liveRoomData = list.get(list.size() - 1);
          paramInt = list.size() - 1;
        } else {
          paramInt = i - 1;
          liveRoomData = list.get(paramInt);
        } 
        d(list);
        if (liveRoomData.lid == 0L)
          return false; 
        liveRoomData.comeCode = paramString;
        a(paramContext, liveRoomData, paramInt);
        return true;
      } 
    } 
    return false;
  }
  
  private static void d(List<LiveRoomData> paramList) {
    for (LiveRoomData liveRoomData : paramList) {
      if (LiveRoomManager.a().h() == null)
        return; 
      if (TextUtils.equals((LiveRoomManager.a().h()).comeCode, "live_end_recommend")) {
        paramList.remove(liveRoomData);
        break;
      } 
    } 
  }
  
  public void a(LiveRoomData paramLiveRoomData, long paramLong) {
    int i;
    for (i = 0; i < this.b.size(); i++) {
      if (LiveRoomManager.a().h() == null)
        return; 
      if (((LiveRoomData)this.b.get(i)).lid == paramLong) {
        this.b.add(i + 1, paramLiveRoomData);
        return;
      } 
    } 
  }
  
  public void a(List<LiveRoomData> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/List;
    //   6: invokeinterface clear : ()V
    //   11: aload_0
    //   12: getfield b : Ljava/util/List;
    //   15: invokeinterface clear : ()V
    //   20: aload_1
    //   21: ifnull -> 38
    //   24: aload_1
    //   25: invokeinterface size : ()I
    //   30: ifle -> 38
    //   33: aload_0
    //   34: aload_1
    //   35: invokevirtual b : (Ljava/util/List;)V
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
    //   2	20	41	finally
    //   24	38	41	finally
  }
  
  public List<LiveRoomData> b() {
    return this.b;
  }
  
  public void b(List<LiveRoomData> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 101
    //   6: iconst_0
    //   7: istore_2
    //   8: iload_2
    //   9: aload_1
    //   10: invokeinterface size : ()I
    //   15: if_icmpge -> 101
    //   18: aload_0
    //   19: getfield a : Ljava/util/List;
    //   22: aload_1
    //   23: iload_2
    //   24: invokeinterface get : (I)Ljava/lang/Object;
    //   29: checkcast com/blued/android/module/live_china/model/LiveRoomData
    //   32: getfield lid : J
    //   35: invokestatic valueOf : (J)Ljava/lang/Long;
    //   38: invokeinterface contains : (Ljava/lang/Object;)Z
    //   43: ifne -> 89
    //   46: aload_0
    //   47: getfield a : Ljava/util/List;
    //   50: aload_1
    //   51: iload_2
    //   52: invokeinterface get : (I)Ljava/lang/Object;
    //   57: checkcast com/blued/android/module/live_china/model/LiveRoomData
    //   60: getfield lid : J
    //   63: invokestatic valueOf : (J)Ljava/lang/Long;
    //   66: invokeinterface add : (Ljava/lang/Object;)Z
    //   71: pop
    //   72: aload_0
    //   73: getfield b : Ljava/util/List;
    //   76: aload_1
    //   77: iload_2
    //   78: invokeinterface get : (I)Ljava/lang/Object;
    //   83: invokeinterface add : (Ljava/lang/Object;)Z
    //   88: pop
    //   89: iload_2
    //   90: iconst_1
    //   91: iadd
    //   92: istore_2
    //   93: goto -> 8
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: aload_0
    //   102: monitorexit
    //   103: return
    // Exception table:
    //   from	to	target	type
    //   8	89	96	finally
  }
  
  public void c(List<LiveRoomData> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Ljava/util/List;
    //   6: invokeinterface clear : ()V
    //   11: aload_1
    //   12: ifnull -> 70
    //   15: iconst_0
    //   16: istore_2
    //   17: iload_2
    //   18: aload_1
    //   19: invokeinterface size : ()I
    //   24: if_icmpge -> 70
    //   27: aload_1
    //   28: iload_2
    //   29: invokeinterface get : (I)Ljava/lang/Object;
    //   34: checkcast com/blued/android/module/live_china/model/LiveRoomData
    //   37: astore_3
    //   38: aload_3
    //   39: ifnull -> 52
    //   42: aload_3
    //   43: getfield live_type : I
    //   46: ifne -> 52
    //   49: goto -> 63
    //   52: aload_0
    //   53: getfield b : Ljava/util/List;
    //   56: aload_3
    //   57: invokeinterface add : (Ljava/lang/Object;)Z
    //   62: pop
    //   63: iload_2
    //   64: iconst_1
    //   65: iadd
    //   66: istore_2
    //   67: goto -> 17
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	73	finally
    //   17	38	73	finally
    //   42	49	73	finally
    //   52	63	73	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\LiveDataListManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */