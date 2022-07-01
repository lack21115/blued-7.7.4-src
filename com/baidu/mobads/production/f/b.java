package com.baidu.mobads.production.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.u;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends b implements a {
  private d A;
  
  private AdSize B;
  
  private boolean C = false;
  
  private boolean D = false;
  
  private Activity E;
  
  private RelativeLayout F;
  
  private Boolean G;
  
  public final String y = "html5_intersitial";
  
  protected final IXAdLogger z = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  public b(Context paramContext, RelativeLayout paramRelativeLayout, Boolean paramBoolean, String paramString) {
    super(paramContext);
    setId(paramString);
    setActivity(paramContext);
    setAdSlotBase(paramRelativeLayout);
    this.o = IXAdConstants4PDK.SlotType.SLOT_TYPE_INTERSTITIAL;
    this.G = paramBoolean;
    this.B = AdSize.InterstitialGame;
    XAdSDKFoundationFacade.getInstance().getAdConstants();
    this.A = new d(getApplicationContext(), getActivity(), this.o, Boolean.valueOf(true));
    this.A.d(paramString);
    this.A.f(AdSize.InterstitialGame.getValue());
    com.baidu.mobads.vo.b b1 = (com.baidu.mobads.vo.b)this.A.d();
    JSONObject jSONObject2 = b1.getAttribute();
    JSONObject jSONObject1 = jSONObject2;
    if (jSONObject2 == null)
      jSONObject1 = new JSONObject(); 
    try {
      jSONObject1.put("ABILITY", "PAUSE,");
    } catch (JSONException jSONException) {}
    b1.a(jSONObject1);
    f(paramString);
  }
  
  private ViewGroup b(Context paramContext) {
    return (ViewGroup)((Activity)paramContext).getWindow().getDecorView();
  }
  
  public void a() {
    load();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(Activity paramActivity) {
    if (this.C && !this.D) {
      this.D = true;
      this.C = false;
      this.E = paramActivity;
      start();
      Rect rect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
      this.e.setBackgroundColor(0);
      RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
      layoutParams.topMargin = rect.top;
      ViewGroup viewGroup = b((Context)paramActivity);
      this.F = new RelativeLayout((Context)paramActivity);
      this.F.addView((View)this.e, (ViewGroup.LayoutParams)layoutParams);
      viewGroup.addView((View)this.F, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      this.e.setFocusableInTouchMode(true);
      this.e.setFocusable(true);
      this.e.requestFocus();
      return;
    } 
    if (this.D) {
      this.z.w("interstitial ad is showing now");
      return;
    } 
    if (!this.C)
      this.z.w("interstitial ad is not ready"); 
  }
  
  public void a(Activity paramActivity, RelativeLayout paramRelativeLayout) {}
  
  public void a(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    this.C = true;
    if (paramHashMap != null) {
      paramIXAdContainer = (IXAdContainer)paramHashMap.get("type");
      if (paramIXAdContainer != null)
        ((String)paramIXAdContainer).equals("video"); 
    } 
  }
  
  public void a(com.baidu.mobads.openad.d.b paramb, u paramu, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{'ad':[{'id':99999999,'url':'");
    stringBuilder.append(this.A.b());
    stringBuilder.append("', type='");
    stringBuilder.append(IXAdInstanceInfo.CreativeType.HTML.getValue());
    stringBuilder.append("'}],'n':1}");
    paramu.a(paramb, stringBuilder.toString());
  }
  
  public d b() {
    return this.A;
  }
  
  public void b(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {}
  
  public void b(IXAdResponseInfo paramIXAdResponseInfo) {}
  
  public void c() {}
  
  public void d() {
    this.m = 8000;
  }
  
  public void e(IXAdContainer paramIXAdContainer, HashMap<String, Object> paramHashMap) {
    t();
    this.D = false;
  }
  
  public void request() {
    a(this.A);
  }
  
  public void start() {
    super.start();
  }
  
  public void t() {
    Activity activity = this.E;
    if (activity == null)
      return; 
    activity.runOnUiThread(new c(this));
  }
  
  public boolean w() {
    return this.C;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */