package com.baidu.mobads.production.h;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends b implements IXLinearAdSlot, IOAdEventDispatcher {
  private a y;
  
  private boolean z;
  
  public b(Context paramContext, String paramString) {
    super(paramContext);
    setId(paramString);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_PREROLL;
    this.z = true;
  }
  
  private void a(Set<String> paramSet) {
    a a1 = new a();
    Iterator<String> iterator = paramSet.iterator();
    while (iterator.hasNext()) {
      com.baidu.mobads.openad.d.b b1 = new com.baidu.mobads.openad.d.b(iterator.next(), "");
      b1.e = 1;
      a1.a(b1, Boolean.valueOf(true));
    } 
  }
  
  public d a() {
    return this.y;
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    if (paramIXAdContainer.getAdContainerContext().getAdInstanceInfo().getCreativeType() == IXAdInstanceInfo.CreativeType.STATIC_IMAGE || paramIXAdContainer.getAdContainerContext().getAdInstanceInfo().getCreativeType() == IXAdInstanceInfo.CreativeType.GIF) {
      com.baidu.mobads.vo.b b1 = (com.baidu.mobads.vo.b)this.y.d();
      JSONObject jSONObject2 = b1.getAttribute();
      JSONObject jSONObject1 = jSONObject2;
      if (jSONObject2 == null)
        jSONObject1 = new JSONObject(); 
      try {
        jSONObject1.put("supportTipView", this.z);
      } catch (JSONException jSONException) {}
      b1.a(jSONObject1);
      start();
    } 
  }
  
  public void a(com.baidu.mobads.openad.d.b paramb, u paramu, int paramInt) {
    String str = (String)getParameter().get("AD_REQUESTING_TIMEOUT");
    int i = paramInt;
    if (str != null)
      try {
        i = Integer.parseInt(str);
      } catch (Exception exception) {
        i = paramInt;
      }  
    paramu.a(paramb, i);
  }
  
  public void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    HashSet<String> hashSet = new HashSet();
    hashSet.addAll(paramIXAdContainer.getAdContainerContext().getAdInstanceInfo().getStartTrackers());
    a(hashSet);
  }
  
  public void b(IXAdResponseInfo paramIXAdResponseInfo) {}
  
  public void c() {
    this.u.i("XPrerollAdSlot", "afterAdContainerInit()");
    dispatchEvent((IOAdEvent)new com.baidu.mobads.openad.c.b("complete"));
  }
  
  public void d() {
    this.m = 8000;
  }
  
  public void e(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    super.e(paramIXAdContainer, paramHashMap);
    this.l = IXAdConstants4PDK.SlotState.COMPLETED;
  }
  
  public int getDuration() {
    return (this.h == null) ? super.getDuration() : (int)this.h.getDuration();
  }
  
  public Object getParameter(String paramString) {
    return null;
  }
  
  public int getPlayheadTime() {
    return (this.h == null) ? super.getPlayheadTime() : (int)this.h.getPlayheadTime();
  }
  
  public boolean h() {
    return true;
  }
  
  public void load() {
    this.r.set(true);
    super.load();
  }
  
  public void notifyVisitorAction(IXAdConstants4PDK.VisitorAction paramVisitorAction) {}
  
  public void pause() {
    IXAdLogger iXAdLogger = this.u;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pause()");
    stringBuilder.append(getSlotState().getValue());
    iXAdLogger.i("XPrerollAdSlot", stringBuilder.toString());
    if (getSlotState() == IXAdConstants4PDK.SlotState.PLAYING)
      super.pause(); 
  }
  
  public void request() {
    // Byte code:
    //   0: aload_0
    //   1: new com/baidu/mobads/production/h/a
    //   4: dup
    //   5: aload_0
    //   6: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   9: aload_0
    //   10: invokevirtual getActivity : ()Landroid/app/Activity;
    //   13: aload_0
    //   14: getfield o : Lcom/baidu/mobads/interfaces/IXAdConstants4PDK$SlotType;
    //   17: aload_0
    //   18: invokespecial <init> : (Landroid/content/Context;Landroid/app/Activity;Lcom/baidu/mobads/interfaces/IXAdConstants4PDK$SlotType;Lcom/baidu/mobads/interfaces/IXAdProd;)V
    //   21: putfield y : Lcom/baidu/mobads/production/h/a;
    //   24: aload_0
    //   25: getfield y : Lcom/baidu/mobads/production/h/a;
    //   28: aload_0
    //   29: invokevirtual getId : ()Ljava/lang/String;
    //   32: invokevirtual d : (Ljava/lang/String;)V
    //   35: aload_0
    //   36: invokevirtual getParameter : ()Ljava/util/HashMap;
    //   39: astore #5
    //   41: aload #5
    //   43: ldc_w 'BASE_WIDTH'
    //   46: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast java/lang/String
    //   52: astore #4
    //   54: aload #5
    //   56: ldc_w 'BASE_HEIGHT'
    //   59: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast java/lang/String
    //   65: astore #5
    //   67: iconst_0
    //   68: istore_3
    //   69: aload #4
    //   71: ifnull -> 83
    //   74: aload #4
    //   76: invokestatic parseInt : (Ljava/lang/String;)I
    //   79: istore_1
    //   80: goto -> 85
    //   83: iconst_0
    //   84: istore_1
    //   85: iload_3
    //   86: istore_2
    //   87: aload #5
    //   89: ifnull -> 98
    //   92: aload #5
    //   94: invokestatic parseInt : (Ljava/lang/String;)I
    //   97: istore_2
    //   98: aload_0
    //   99: getfield y : Lcom/baidu/mobads/production/h/a;
    //   102: iload_1
    //   103: invokevirtual d : (I)V
    //   106: aload_0
    //   107: getfield y : Lcom/baidu/mobads/production/h/a;
    //   110: iload_2
    //   111: invokevirtual e : (I)V
    //   114: aload_0
    //   115: aload_0
    //   116: getfield y : Lcom/baidu/mobads/production/h/a;
    //   119: invokespecial a : (Lcom/baidu/mobads/vo/d;)Z
    //   122: pop
    //   123: return
    //   124: astore #4
    //   126: goto -> 83
    //   129: astore #4
    //   131: iload_3
    //   132: istore_2
    //   133: goto -> 98
    // Exception table:
    //   from	to	target	type
    //   74	80	124	java/lang/Exception
    //   92	98	129	java/lang/Exception
  }
  
  public void resume() {
    IXAdLogger iXAdLogger = this.u;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resume()");
    stringBuilder.append(getSlotState().getValue());
    iXAdLogger.i("XPrerollAdSlot", stringBuilder.toString());
    if (getSlotState() == IXAdConstants4PDK.SlotState.PAUSED)
      super.resume(); 
  }
  
  public void setActivityState(IXAdConstants4PDK.ActivityState paramActivityState) {}
  
  public void setContentVideoAssetCurrentTimePosition(double paramDouble) {}
  
  public void setMaxAdNum(int paramInt) {}
  
  public void setMaxDuration(int paramInt) {}
  
  public void setParameter(String paramString, Object paramObject) {}
  
  public void setSupportTipView(boolean paramBoolean) {
    this.z = paramBoolean;
  }
  
  public void setVideoDisplayBase(RelativeLayout paramRelativeLayout) {
    this.e = paramRelativeLayout;
  }
  
  public void setVideoState(IXAdConstants4PDK.VideoState paramVideoState) {}
  
  public void start() {
    if (this.r.get()) {
      super.start();
      return;
    } 
    load();
  }
  
  public void stop() {
    IXAdLogger iXAdLogger = this.u;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stop()");
    stringBuilder.append(getSlotState().getValue());
    iXAdLogger.i("XPrerollAdSlot", stringBuilder.toString());
    super.stop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */