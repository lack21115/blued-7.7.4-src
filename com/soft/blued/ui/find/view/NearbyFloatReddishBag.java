package com.soft.blued.ui.find.view;

import android.content.Context;
import android.util.AttributeSet;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.soft.blued.customview.FloatReddishBag;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.log.InstantLog;

public class NearbyFloatReddishBag extends FloatReddishBag {
  public NearbyFloatReddishBag(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public NearbyFloatReddishBag(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {
    InstantLog.a("nearby_hb_click");
  }
  
  public void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    LiveHttpUtils.b(paramBluedUIHttpResponse, paramIRequestHost);
  }
  
  public void b() {
    InstantLog.a("nearby_hb_show");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\view\NearbyFloatReddishBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */