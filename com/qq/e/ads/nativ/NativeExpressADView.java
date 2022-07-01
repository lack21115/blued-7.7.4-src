package com.qq.e.ads.nativ;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class NativeExpressADView extends FrameLayout {
  private NEADVI a;
  
  private boolean b = false;
  
  private volatile boolean c = false;
  
  private volatile boolean d = false;
  
  private NativeExpressMediaListener e;
  
  public Map<String, String> ext = new HashMap<String, String>();
  
  private AdData f;
  
  private volatile boolean g = false;
  
  private ViewBindStatusListener h;
  
  public NativeExpressADView(NEADI paramNEADI, Context paramContext, ADSize paramADSize, String paramString1, String paramString2, JSONObject paramJSONObject, HashMap<String, JSONObject> paramHashMap) {
    super(paramContext);
    this.f = a(paramHashMap);
    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, paramContext, paramString1, paramNEADI, paramADSize, paramString2, paramJSONObject, paramHashMap) {
          public void run() {
            if (GDTADManager.getInstance().initWith(this.a, this.b))
              try {
                return;
              } finally {
                Exception exception = null;
                GDTLogger.e("Exception while init Native Express AD View plugin", exception);
              }  
            GDTLogger.e("Fail to init ADManager");
          }
        });
  }
  
  private static AdData a(HashMap<String, JSONObject> paramHashMap) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnull -> 53
    //   6: aload_0
    //   7: ldc 'adinfo'
    //   9: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast org/json/JSONObject
    //   15: astore_0
    //   16: goto -> 19
    //   19: aload_0
    //   20: ifnull -> 33
    //   23: aload_0
    //   24: ldc 'adinfo'
    //   26: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   29: astore_0
    //   30: goto -> 35
    //   33: aconst_null
    //   34: astore_0
    //   35: aload_0
    //   36: instanceof com/qq/e/comm/pi/AdData
    //   39: ifeq -> 47
    //   42: aload_0
    //   43: checkcast com/qq/e/comm/pi/AdData
    //   46: astore_1
    //   47: aload_1
    //   48: areturn
    //   49: astore_0
    //   50: goto -> 33
    //   53: aconst_null
    //   54: astore_0
    //   55: goto -> 19
    // Exception table:
    //   from	to	target	type
    //   6	16	49	org/json/JSONException
    //   23	30	49	org/json/JSONException
  }
  
  public void destroy() {
    NEADVI nEADVI = this.a;
    if (nEADVI != null)
      nEADVI.destroy(); 
  }
  
  public AdData getBoundData() {
    return this.f;
  }
  
  public void negativeFeedback() {
    boolean bool;
    if (!this.b) {
      bool = true;
    } else {
      NEADVI nEADVI = this.a;
      if (nEADVI != null) {
        nEADVI.reportAdNegative();
        bool = false;
      } else {
        GDTLogger.e("Native Express negativeFeedback  core is null");
        return;
      } 
    } 
    this.g = bool;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    ViewBindStatusListener viewBindStatusListener = this.h;
    if (viewBindStatusListener != null)
      viewBindStatusListener.onAttachedToWindow(); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    ViewBindStatusListener viewBindStatusListener = this.h;
    if (viewBindStatusListener != null)
      viewBindStatusListener.onDetachedFromWindow(); 
  }
  
  public void onFinishTemporaryDetach() {
    super.onFinishTemporaryDetach();
    ViewBindStatusListener viewBindStatusListener = this.h;
    if (viewBindStatusListener != null)
      viewBindStatusListener.onFinishTemporaryDetach(); 
  }
  
  public void onStartTemporaryDetach() {
    super.onStartTemporaryDetach();
    ViewBindStatusListener viewBindStatusListener = this.h;
    if (viewBindStatusListener != null)
      viewBindStatusListener.onStartTemporaryDetach(); 
  }
  
  public void preloadVideo() {
    if (!this.b) {
      this.c = true;
      return;
    } 
    NEADVI nEADVI = this.a;
    if (nEADVI != null) {
      nEADVI.preloadVideo();
      return;
    } 
    GDTLogger.e("Native Express AD View Init Error");
  }
  
  public void render() {
    if (!this.b) {
      this.d = true;
      return;
    } 
    NEADVI nEADVI = this.a;
    if (nEADVI != null) {
      nEADVI.render();
      return;
    } 
    GDTLogger.e("Native Express AD View Init Error");
  }
  
  public void setAdSize(ADSize paramADSize) {
    NEADVI nEADVI = this.a;
    if (nEADVI != null)
      nEADVI.setAdSize(paramADSize); 
  }
  
  public void setMediaListener(NativeExpressMediaListener paramNativeExpressMediaListener) {
    this.e = paramNativeExpressMediaListener;
    NEADVI nEADVI = this.a;
    if (nEADVI != null && paramNativeExpressMediaListener != null)
      nEADVI.setAdListener(new NativeExpressAD.ADListenerAdapter(paramNativeExpressMediaListener)); 
  }
  
  public void setViewBindStatusListener(ViewBindStatusListener paramViewBindStatusListener) {
    this.h = paramViewBindStatusListener;
  }
  
  public static interface ViewBindStatusListener {
    void onAttachedToWindow();
    
    void onDetachedFromWindow();
    
    void onFinishTemporaryDetach();
    
    void onStartTemporaryDetach();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\NativeExpressADView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */