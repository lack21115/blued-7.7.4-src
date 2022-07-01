package com.soft.blued.ui.live.view;

import android.content.Context;
import android.util.AttributeSet;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.soft.blued.customview.FloatReddishBag;
import com.soft.blued.http.LiveHttpUtils;

public class LiveListFloatReddishBag extends FloatReddishBag {
  public LiveListFloatReddishBag(Context paramContext) {
    super(paramContext);
  }
  
  public LiveListFloatReddishBag(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public LiveListFloatReddishBag(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {}
  
  public void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    LiveHttpUtils.a(paramBluedUIHttpResponse, paramIRequestHost);
  }
  
  public void b() {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\view\LiveListFloatReddishBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */