package com.baidu.mobads.nativecpu.a;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.o;
import com.baidu.mobads.production.p;
import com.baidu.mobads.production.u;
import com.baidu.mobads.utils.q;
import com.baidu.mobads.vo.c;
import com.baidu.mobads.vo.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a extends b {
  private HashMap<String, Object> A = new HashMap<String, Object>();
  
  private AtomicBoolean B = new AtomicBoolean(false);
  
  private int C;
  
  private int D;
  
  private int[] E;
  
  private boolean F;
  
  private IOAdEventListener G;
  
  private String H;
  
  private q I = q.a();
  
  private c y;
  
  private Object z;
  
  public a(Context paramContext, String paramString) {
    super(paramContext);
    setActivity(paramContext);
    this.H = paramString;
  }
  
  private void t() {
    IOAdEventListener iOAdEventListener = this.G;
    if (iOAdEventListener != null) {
      Object object = this.z;
      if (object != null) {
        c c1 = this.y;
        if (c1 != null) {
          c1.a(object, "addEventListener", new Object[] { "AdLoaded", iOAdEventListener });
          this.y.a(this.z, "addEventListener", new Object[] { "AdEmptyList", this.G });
          this.y.a(this.z, "addEventListener", new Object[] { "AdError", this.G });
          this.y.a(this.z, "addEventListener", new Object[] { "AdUserClick", this.G });
          this.y.a(this.z, "addEventListener", new Object[] { "AdStatusChange", this.G });
          this.y.a(this.z, "addEventListener", new Object[] { "vdieoCacheSucc", this.G });
          this.y.a(this.z, "addEventListener", new Object[] { "vdieoCacheFailed", this.G });
        } 
      } 
    } 
  }
  
  public void a() {
    try {
      removeAllListeners();
      if (this.y != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(int paramInt) {
    try {
      this.m = paramInt;
      if (this.y != null)
        return; 
    } finally {
      Exception exception = null;
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int[] paramArrayOfint, boolean paramBoolean, Map<String, Object> paramMap) {
    try {
      this.A.clear();
      if (paramMap != null)
        this.A.putAll(paramMap); 
      if (this.B.get() && this.y != null)
        return; 
      this.D = paramInt1;
      this.C = paramInt2;
      this.E = paramArrayOfint;
      this.F = paramBoolean;
      addEventListener("AdError", this.G);
      return;
    } finally {
      paramArrayOfint = null;
      this.I.d((Throwable)paramArrayOfint);
    } 
  }
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {}
  
  public void a(IXAdResponseInfo paramIXAdResponseInfo) {
    try {
      n();
      Context context = getApplicationContext();
      Activity activity = getActivity();
      p p = new p(this.f, this);
      this.k = new a(this, context, activity, IXAdConstants4PDK.SlotType.SLOT_TYPE_CPU);
      o o = new o(this.f, activity, this.k.d(), null, (IXAdContainerEventListener)p, getAdResponseInfo(), null);
      this.y = c.a(this.f, "com.baidu.mobads.container.nativecpu.interfaces.RCPUAdProd");
      c c1 = this.y;
      boolean bool = false;
      String str = this.H;
      this.z = c1.a(new Class[] { IXAdContainerContext.class, String.class }, new Object[] { o, str });
      t();
      this.y.a(this.z, "loadAd", new Object[] { Integer.valueOf(this.D), Integer.valueOf(this.C), this.E, Boolean.valueOf(this.F), this.A });
      AtomicBoolean atomicBoolean = this.B;
      return;
    } finally {
      paramIXAdResponseInfo = null;
      this.I.d((Throwable)paramIXAdResponseInfo);
    } 
  }
  
  public void a(b paramb, u paramu, int paramInt) {
    try {
      a(this.f);
      setAdResponseInfo((IXAdResponseInfo)new c("{'ad':[{'id':99999999,'url':'http://127.0.0.1', type='CPUNative'}],'n':1}"));
    } finally {
      paramb = null;
    } 
  }
  
  public void a(IOAdEventListener paramIOAdEventListener) {
    this.G = paramIOAdEventListener;
  }
  
  public List<Object> b() {
    ArrayList<Object> arrayList = new ArrayList();
    try {
      return arrayList;
    } finally {
      Exception exception = null;
      this.I.d(exception.getMessage());
    } 
  }
  
  public void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {}
  
  public void b(IXAdResponseInfo paramIXAdResponseInfo) {}
  
  public void c() {}
  
  public void d() {}
  
  public IXAdRequestInfo getAdRequestInfo() {
    return (IXAdRequestInfo)this.k;
  }
  
  public void request() {}
  
  class a extends d {
    public a(a this$0, Context param1Context, Activity param1Activity, IXAdConstants4PDK.SlotType param1SlotType) {
      super(param1Context, param1Activity, param1SlotType);
    }
    
    public HashMap<String, String> a() {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      if (a.a(this.a).size() > 0)
        for (String str : a.a(this.a).keySet()) {
          Object object = a.a(this.a).get(str);
          if (object instanceof String)
            hashMap.put(str, object); 
        }  
      return (HashMap)hashMap;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\nativecpu\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */