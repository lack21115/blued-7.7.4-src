package com.qq.e.ads.nativ.express2;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NativeExpressAD2 extends AbstractAD<NEIADI> {
  private int a;
  
  private int b;
  
  private VideoOption2 c;
  
  private AdLoadListener d;
  
  private List<Integer> e = Collections.synchronizedList(new ArrayList<Integer>());
  
  public NativeExpressAD2(Context paramContext, String paramString, AdLoadListener paramAdLoadListener) {
    if (GDTADManager.getInstance().isInitialized()) {
      String str = GDTADManager.getInstance().getAppStatus().getAPPID();
      if (paramContext == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(paramString) || paramAdLoadListener == null) {
        GDTLogger.e(String.format("NativeExpressSecondAD Constructor params error, context=%s, appId=%s, posId=%s, listener=%s", new Object[] { paramContext, str, paramString, paramAdLoadListener }));
        a(paramAdLoadListener, 2001);
        return;
      } 
      this.d = paramAdLoadListener;
      a(paramContext, str, paramString, paramAdLoadListener);
      return;
    } 
    GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
    if (paramAdLoadListener != null)
      paramAdLoadListener.onNoAD(a.a(2003)); 
  }
  
  public void loadAd(int paramInt) {
    String str;
    if (!c()) {
      str = "AD init Paras OR Context error,details in logs produced while init NativeAD";
    } else {
      if (!b()) {
        this.e.add(Integer.valueOf(paramInt));
        return;
      } 
      NEIADI nEIADI = (NEIADI)a();
      if (nEIADI != null) {
        nEIADI.loadAd(paramInt);
        return;
      } 
      str = "Native Express AD Init error, see more logs";
    } 
    GDTLogger.e(str);
  }
  
  public void setAdSize(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
    NEIADI nEIADI = (NEIADI)a();
    if (nEIADI != null)
      nEIADI.setAdSize(paramInt1, paramInt2); 
  }
  
  public void setVideoOption2(VideoOption2 paramVideoOption2) {
    this.c = paramVideoOption2;
    NEIADI nEIADI = (NEIADI)a();
    if (nEIADI != null)
      nEIADI.setVideoOption(paramVideoOption2); 
  }
  
  public static interface AdLoadListener extends AbstractAD.BasicADListener {
    void onLoadSuccess(List<NativeExpressADData2> param1List);
  }
  
  static class AdLoadListenerAdapter implements ADListener {
    private NativeExpressAD2.AdLoadListener a;
    
    AdLoadListenerAdapter(NativeExpressAD2.AdLoadListener param1AdLoadListener) {
      this.a = param1AdLoadListener;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      if (this.a != null) {
        int i = param1ADEvent.getType();
        if (i != 1) {
          if (i != 2)
            return; 
          if ((param1ADEvent.getParas()).length == 1 && param1ADEvent.getParas()[0] instanceof Integer) {
            this.a.onNoAD(a.a(((Integer)param1ADEvent.getParas()[0]).intValue()));
          } else {
            StringBuilder stringBuilder1 = new StringBuilder("ADEvent.Params error for NativeExpressSecondAD(");
            stringBuilder1.append(param1ADEvent);
            stringBuilder1.append(")");
            GDTLogger.e(stringBuilder1.toString());
          } 
        } 
        if ((param1ADEvent.getParas()).length == 1 && param1ADEvent.getParas()[0] instanceof List) {
          this.a.onLoadSuccess((List<NativeExpressADData2>)param1ADEvent.getParas()[0]);
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder("ADEvent.Params error for NativeExpressSecondAD(");
        stringBuilder.append(param1ADEvent);
        stringBuilder.append(")");
        GDTLogger.e(stringBuilder.toString());
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\express2\NativeExpressAD2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */