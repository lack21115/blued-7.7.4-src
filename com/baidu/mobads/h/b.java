package com.baidu.mobads.h;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobad.nativevideo.XAdVideoResponse;
import com.baidu.mobads.q;
import com.baidu.mobads.utils.d;
import dalvik.system.DexClassLoader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class b extends RelativeLayout {
  private Context a;
  
  private a b;
  
  private View c;
  
  private String d = "TvtfWYI1/aJhqbnwJ3f1NpdlWii72QtgZNj6vCzWTzeryGCytmYPBnjkQ3CBaxEa";
  
  private DexClassLoader e;
  
  public b(Context paramContext) {
    super(paramContext);
    a(paramContext);
    setBackgroundColor(Color.parseColor("#000000"));
  }
  
  private void a(Context paramContext) {
    this.a = paramContext;
    paramContext = this.a;
    this.e = com.baidu.mobads.f.b.d();
    if (this.e == null)
      this.e = q.a(this.a); 
    this.c = (View)q.a(d.a(this.d), (ClassLoader)this.e, new Class[] { Context.class }, new Object[] { paramContext });
    View view = this.c;
    if (view != null)
      addView(view, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1)); 
  }
  
  public long a() {
    return (this.c != null) ? ((Long)q.a(d.a(this.d), this.c, (ClassLoader)this.e, "getCurrentPosition", new Class[0], new Object[0])).longValue() : 0L;
  }
  
  public void a(XAdVideoResponse paramXAdVideoResponse) {
    if (paramXAdVideoResponse == null)
      return; 
    if (this.c != null)
      q.a(d.a(this.d), this.c, (ClassLoader)this.e, "setAdData", new Class[] { Object.class }, new Object[] { paramXAdVideoResponse }); 
  }
  
  public void a(a parama) {
    this.b = parama;
    try {
      Class clazz = q.a("com.component.patchad.IPatchAdListener", (ClassLoader)this.e);
      ClassLoader classLoader = clazz.getClassLoader();
      a a1 = new a(this);
      Object object = Proxy.newProxyInstance(classLoader, new Class[] { clazz }, a1);
      return;
    } finally {
      parama = null;
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (this.c != null)
      q.a(d.a(this.d), this.c, (ClassLoader)this.e, "setVideoVolume", new Class[] { boolean.class }, new Object[] { Boolean.valueOf(paramBoolean) }); 
  }
  
  public long b() {
    return (this.c != null) ? ((Long)q.a(d.a(this.d), this.c, (ClassLoader)this.e, "getDuration", new Class[0], new Object[0])).longValue() : 0L;
  }
  
  class a implements InvocationHandler {
    a(b this$0) {}
    
    public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) {
      param1Object = param1Method.getName();
      if (TextUtils.isEmpty((CharSequence)param1Object))
        return null; 
      if (param1Object.equals("playCompletion")) {
        if (b.a(this.a) != null) {
          b.a(this.a).a();
          return null;
        } 
      } else if (param1Object.equals("playFailure")) {
        if (b.a(this.a) != null) {
          b.a(this.a).b();
          return null;
        } 
      } else if (param1Object.equals("onAdShow") && b.a(this.a) != null) {
        b.a(this.a).c();
      } 
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */