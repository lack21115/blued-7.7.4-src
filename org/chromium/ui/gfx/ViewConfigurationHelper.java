package org.chromium.ui.gfx;

import android.content.res.Resources;
import android.view.ViewConfiguration;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.ui.R;

public class ViewConfigurationHelper {
  private float mDensity = (ContextUtils.sApplicationContext.getResources().getDisplayMetrics()).density;
  
  private ViewConfiguration mViewConfiguration = ViewConfiguration.get(ContextUtils.sApplicationContext);
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private ViewConfigurationHelper() {
    assert false;
  }
  
  @CalledByNative
  private static ViewConfigurationHelper createWithListener() {
    ViewConfigurationHelper viewConfigurationHelper = new ViewConfigurationHelper();
    ContextUtils.sApplicationContext.registerComponentCallbacks(new ViewConfigurationHelper$1(viewConfigurationHelper));
    return viewConfigurationHelper;
  }
  
  @CalledByNative
  private float getDoubleTapSlop() {
    return this.mViewConfiguration.getScaledDoubleTapSlop() / this.mDensity;
  }
  
  @CalledByNative
  private static int getDoubleTapTimeout() {
    return ViewConfiguration.getDoubleTapTimeout();
  }
  
  @CalledByNative
  private static int getLongPressTimeout() {
    return ViewConfiguration.getLongPressTimeout();
  }
  
  @CalledByNative
  private float getMaximumFlingVelocity() {
    return this.mViewConfiguration.getScaledMaximumFlingVelocity() / this.mDensity;
  }
  
  @CalledByNative
  private float getMinScalingSpan() {
    return getScaledMinScalingSpan() / this.mDensity;
  }
  
  @CalledByNative
  private float getMinimumFlingVelocity() {
    return this.mViewConfiguration.getScaledMinimumFlingVelocity() / this.mDensity;
  }
  
  private static int getScaledMinScalingSpan() {
    Resources resources = ContextUtils.sApplicationContext.getResources();
    int i = R.dimen.config_min_scaling_span;
    try {
      return resources.getDimensionPixelSize(i);
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      assert false;
      throw new AssertionError("MinScalingSpan resource lookup failed.");
    } 
  }
  
  @CalledByNative
  private static int getTapTimeout() {
    return ViewConfiguration.getTapTimeout();
  }
  
  @CalledByNative
  private float getTouchSlop() {
    return this.mViewConfiguration.getScaledTouchSlop() / this.mDensity;
  }
  
  private native void nativeUpdateSharedViewConfiguration(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\gfx\ViewConfigurationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */