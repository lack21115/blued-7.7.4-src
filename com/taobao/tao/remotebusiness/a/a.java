package com.taobao.tao.remotebusiness.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.taobao.tao.remotebusiness.IRemoteProcessListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopProgressEvent;
import mtopsdk.mtop.util.MtopStatistics;

public final class a extends Handler {
  private static Handler a;
  
  private a(Looper paramLooper) {
    super(paramLooper);
  }
  
  public static Handler a() {
    // Byte code:
    //   0: ldc com/taobao/tao/remotebusiness/a/a
    //   2: monitorenter
    //   3: getstatic com/taobao/tao/remotebusiness/a/a.a : Landroid/os/Handler;
    //   6: ifnonnull -> 22
    //   9: new com/taobao/tao/remotebusiness/a/a
    //   12: dup
    //   13: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   16: invokespecial <init> : (Landroid/os/Looper;)V
    //   19: putstatic com/taobao/tao/remotebusiness/a/a.a : Landroid/os/Handler;
    //   22: getstatic com/taobao/tao/remotebusiness/a/a.a : Landroid/os/Handler;
    //   25: astore_0
    //   26: ldc com/taobao/tao/remotebusiness/a/a
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: ldc com/taobao/tao/remotebusiness/a/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	31	finally
    //   22	26	31	finally
  }
  
  public static b a(MtopListener paramMtopListener, MtopEvent paramMtopEvent, MtopBusiness paramMtopBusiness) {
    return new b(paramMtopListener, paramMtopEvent, paramMtopBusiness);
  }
  
  private static boolean a(b paramb) {
    if (paramb == null) {
      TBSdkLog.d("mtop.rb-HandlerMgr", paramb.d.getSeqNo(), "HandlerMsg is null.");
      return false;
    } 
    if (paramb.d.isTaskCanceled()) {
      TBSdkLog.b("mtop.rb-HandlerMgr", paramb.d.getSeqNo(), "The request of RemoteBusiness is canceled.");
      return false;
    } 
    return true;
  }
  
  public final void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 1) {
      if (i != 2) {
        if (i == 3) {
          MtopStatistics.RbStatisticData rbStatisticData1;
          MtopStatistics.RbStatisticData rbStatisticData2;
          b b = (b)paramMessage.obj;
          if (!a(b))
            return; 
          TBSdkLog.b("mtop.rb-HandlerMgr", b.d.getSeqNo(), "onReceive: ON_FINISHED.");
          long l2 = System.currentTimeMillis();
          long l1 = 0L;
          if (b.e != null) {
            MtopStatistics mtopStatistics = b.e.g();
            if (mtopStatistics != null) {
              MtopStatistics.RbStatisticData rbStatisticData = mtopStatistics.i();
              rbStatisticData.g = l2 - b.d.onBgFinishTime;
              MtopStatistics mtopStatistics1 = mtopStatistics;
              rbStatisticData1 = rbStatisticData;
              if (b.e.d() != null) {
                l1 = (b.e.d()).length;
                mtopStatistics1 = mtopStatistics;
                rbStatisticData1 = rbStatisticData;
              } 
            } else {
              rbStatisticData1 = null;
              MtopStatistics mtopStatistics1 = mtopStatistics;
            } 
          } else {
            rbStatisticData2 = null;
            rbStatisticData1 = rbStatisticData2;
          } 
          b.d.doFinish(b.e, b.c);
          long l3 = System.currentTimeMillis();
          if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("doFinishTime=");
            stringBuilder1.append(l3 - l2);
            stringBuilder1.append("; dataSize=");
            stringBuilder1.append(l1);
            stringBuilder1.append("; ");
            if (rbStatisticData1 != null)
              stringBuilder1.append(rbStatisticData1.toString()); 
            String str = b.d.getSeqNo();
            StringBuilder stringBuilder2 = new StringBuilder("onReceive: ON_FINISHED. ");
            stringBuilder2.append(stringBuilder1.toString());
            TBSdkLog.b("mtop.rb-HandlerMgr", str, stringBuilder2.toString());
          } 
          if (rbStatisticData2 != null)
            rbStatisticData2.a(true); 
        } 
      } else {
        b b = (b)paramMessage.obj;
        if (!a(b))
          return; 
        TBSdkLog.b("mtop.rb-HandlerMgr", b.d.getSeqNo(), "onReceive: ON_HEADER.");
      } 
    } else {
      b b = (b)paramMessage.obj;
      if (!a(b))
        return; 
      TBSdkLog.b("mtop.rb-HandlerMgr", b.d.getSeqNo(), "onReceive: ON_DATA_RECEIVED.");
      ((IRemoteProcessListener)b.a).onDataReceived((MtopProgressEvent)b.b, b.d.getReqContext());
    } 
    paramMessage.obj = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */