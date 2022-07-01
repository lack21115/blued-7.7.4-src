package com.qq.e.comm.plugin.b;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.util.am;
import com.qq.e.comm.plugin.util.y;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class a implements ADListener {
  private static final String a = a.class.getSimpleName();
  
  private final UnifiedBannerView b;
  
  private final UnifiedBannerADListener c;
  
  private NativeExpressADView d;
  
  private d e;
  
  private boolean f;
  
  private c g = new c();
  
  a(UnifiedBannerView paramUnifiedBannerView, d paramd, UnifiedBannerADListener paramUnifiedBannerADListener, String paramString) {
    this.b = paramUnifiedBannerView;
    this.e = paramd;
    this.c = paramUnifiedBannerADListener;
    this.g.a(paramString);
  }
  
  private void c() {
    this.f = false;
  }
  
  public NativeExpressADView a() {
    return this.d;
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean && this.f)
      y.a(new Runnable(this) {
            public void run() {
              a.a(this.a).onADCloseOverlay();
              a.a(this.a, false);
            }
          }); 
  }
  
  public void onADEvent(ADEvent paramADEvent) {
    y.a(new Runnable(this, paramADEvent) {
          public void run() {
            StringBuilder stringBuilder;
            String str = a.b();
            int j = this.a.getType();
            int i = 0;
            ak.b(str, "onADEvent ( %d )", new Object[] { Integer.valueOf(j) });
            j = this.a.getType();
            if (j != 1) {
              if (j != 2) {
                StringBuilder stringBuilder1;
                d d;
                switch (j) {
                  default:
                    return;
                  case 10:
                    if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof NativeExpressADView) {
                      a.a(this.b).onADCloseOverlay();
                      return;
                    } 
                    stringBuilder1 = new StringBuilder();
                    break;
                  case 9:
                    if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof NativeExpressADView) {
                      a.a(this.b).onADOpenOverlay();
                      a.a(this.b, true);
                      return;
                    } 
                    stringBuilder1 = new StringBuilder();
                    break;
                  case 8:
                    if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof NativeExpressADView) {
                      a.a(this.b).onADLeftApplication();
                      return;
                    } 
                    stringBuilder1 = new StringBuilder();
                    break;
                  case 7:
                    if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof NativeExpressADView) {
                      a.a(this.b).onADClosed();
                      return;
                    } 
                    stringBuilder1 = new StringBuilder();
                    break;
                  case 6:
                    if ((this.a.getParas()).length == 2 && this.a.getParas()[0] instanceof NativeExpressADView && this.a.getParas()[1] instanceof String) {
                      String str1 = (String)this.a.getParas()[1];
                      if (!TextUtils.isEmpty(str1))
                        try {
                          a.f(this.b);
                          d.ext.put("clickUrl", str1);
                        } catch (Exception exception) {
                          GDTLogger.e("banner2 set click url error");
                          exception.printStackTrace();
                        }  
                      a.a(this.b).onADClicked();
                      return;
                    } 
                    stringBuilder1 = new StringBuilder();
                    break;
                  case 5:
                    if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof NativeExpressADView) {
                      a.a(this.b).onADExposure();
                    } else {
                      stringBuilder1 = new StringBuilder();
                      stringBuilder1.append("ADEvent.Params error for UnifiedBannerView(");
                      stringBuilder1.append(this.a);
                      stringBuilder1.append(")");
                      GDTLogger.e(stringBuilder1.toString());
                    } 
                    d = new d();
                    d.a("width", Integer.valueOf(am.b(a.b(this.b).getContext(), a.b(this.b).getWidth())));
                    d.a("heignt", Integer.valueOf(am.b(a.b(this.b).getContext(), a.b(this.b).getHeight())));
                    return;
                } 
              } else {
                if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof List && ((List)this.a.getParas()[0]).get(0) instanceof NativeExpressADView) {
                  if (a.b(this.b) != null)
                    a.b(this.b).destroy(); 
                  a.a(this.b, ((List<NativeExpressADView>)this.a.getParas()[0]).get(0));
                  try {
                    JSONObject jSONObject = new JSONObject(a.b(this.b).getBoundData().getProperty("ad_info"));
                    a.c(this.b).b(jSONObject.optString("cl"));
                    a.c(this.b).c(jSONObject.optString("traceid"));
                  } catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                  } 
                  while (i < a.d(this.b).getChildCount()) {
                    View view = a.d(this.b).getChildAt(i);
                    if (view instanceof NativeExpressADView)
                      ((NativeExpressADView)view).destroy(); 
                    i++;
                  } 
                  a.d(this.b).removeAllViews();
                  a.d(this.b).addView((View)a.b(this.b), (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
                  a.b(this.b).render();
                  a.a(this.b).onADReceive();
                  a.e(this.b);
                  return;
                } 
                stringBuilder = new StringBuilder();
              } 
              stringBuilder.append("ADEvent.Params error for UnifiedBannerView(");
            } else {
              if ((this.a.getParas()).length == 1 && this.a.getParas()[0] instanceof Integer) {
                i = ((Integer)this.a.getParas()[0]).intValue();
                a.a(this.b).onNoAD(ai.a(i));
                return;
              } 
              stringBuilder = new StringBuilder();
              stringBuilder.append("AdEvent.Params error for UnifiedBannerView(");
            } 
            stringBuilder.append(this.a);
            stringBuilder.append(")");
            GDTLogger.e(stringBuilder.toString());
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */