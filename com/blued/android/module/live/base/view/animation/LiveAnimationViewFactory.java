package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.core.AppMethods;
import java.lang.ref.WeakReference;
import java.util.Map;

public class LiveAnimationViewFactory {
  private Map<Integer, WeakReference<BaseLiveAnimationView>> a = (Map<Integer, WeakReference<BaseLiveAnimationView>>)new ArrayMap();
  
  private BaseLiveAnimationView a(Context paramContext, int paramInt, String paramString, ScaleType paramScaleType) {
    WeakReference<BaseLiveAnimationView> weakReference = this.a.get(Integer.valueOf(paramInt));
    if (weakReference != null) {
      BaseLiveAnimationView baseLiveAnimationView1 = weakReference.get();
      if (baseLiveAnimationView1 != null) {
        baseLiveAnimationView1.a(paramString);
        return baseLiveAnimationView1;
      } 
      baseLiveAnimationView = b(paramContext, paramInt, paramString, paramScaleType);
      this.a.put(Integer.valueOf(paramInt), new WeakReference<BaseLiveAnimationView>(baseLiveAnimationView));
      return baseLiveAnimationView;
    } 
    BaseLiveAnimationView baseLiveAnimationView = b((Context)baseLiveAnimationView, paramInt, paramString, paramScaleType);
    this.a.put(Integer.valueOf(paramInt), new WeakReference<BaseLiveAnimationView>(baseLiveAnimationView));
    return baseLiveAnimationView;
  }
  
  private BaseLiveAnimationView a(Context paramContext, String paramString1, String paramString2, String paramString3, ScaleType paramScaleType) {
    return AppMethods.c(19) ? (!TextUtils.isEmpty(paramString3) ? a(paramContext, 7, paramString3, paramScaleType) : (!TextUtils.isEmpty(paramString2) ? a(paramContext, 1, paramString2, paramScaleType) : a(paramContext, 0, paramString1, paramScaleType))) : (!TextUtils.isEmpty(paramString3) ? a(paramContext, 7, paramString3, paramScaleType) : a(paramContext, 0, paramString1, paramScaleType));
  }
  
  private BaseLiveAnimationView b(Context paramContext, int paramInt, String paramString, ScaleType paramScaleType) {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    switch (paramInt) {
      default:
        if (paramScaleType == ScaleType.a) {
          bool1 = bool3;
          return new GifLiveAnimationView(paramContext, "", bool1);
        } 
        break;
      case 7:
        return new LiveMp4AnimationView(paramContext, paramString, paramScaleType);
      case 6:
        return new MoneyRainView(paramContext);
      case 5:
        return new SuperCastleView(paramContext);
      case 4:
        return new SuperShipView(paramContext);
      case 3:
        return new SuperPlaneView(paramContext);
      case 2:
        return new SuperCarView(paramContext);
      case 1:
        if (paramScaleType != ScaleType.a)
          bool1 = false; 
        return new ApngLiveAnimationView(paramContext, paramString, bool1);
      case 0:
        if (paramScaleType == ScaleType.a) {
          bool1 = bool2;
        } else {
          bool1 = false;
        } 
        return new GifLiveAnimationView(paramContext, paramString, bool1);
    } 
    bool1 = false;
    return new GifLiveAnimationView(paramContext, "", bool1);
  }
  
  public BaseLiveAnimationView a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, ScaleType paramScaleType) {
    return !TextUtils.isEmpty(paramString4) ? ("car".equals(paramString4) ? a(paramContext, 2, "", paramScaleType) : ("plane".equals(paramString4) ? a(paramContext, 3, "", paramScaleType) : ("ship".equals(paramString4) ? a(paramContext, 4, "", paramScaleType) : ("tower".equals(paramString4) ? a(paramContext, 5, "", paramScaleType) : ("hongbao".equals(paramString4) ? a(paramContext, 6, "", paramScaleType) : a(paramContext, paramString1, paramString2, paramString3, paramScaleType)))))) : a(paramContext, paramString1, paramString2, paramString3, paramScaleType);
  }
  
  public enum ScaleType {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\LiveAnimationViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */