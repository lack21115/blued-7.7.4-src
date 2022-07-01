package com.facebook.stetho.inspector.elements.android;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.FragmentCompat;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor;
import javax.annotation.Nullable;

final class ActivityDescriptor extends AbstractChainedDescriptor<Activity> implements HighlightableDescriptor<Activity> {
  private static void getDialogFragments(@Nullable FragmentCompat paramFragmentCompat, Activity paramActivity, Accumulator<Object> paramAccumulator) {
    if (paramFragmentCompat != null) {
      if (!paramFragmentCompat.getFragmentActivityClass().isInstance(paramActivity))
        return; 
      Object object = paramFragmentCompat.forFragmentActivity().getFragmentManager(paramActivity);
      if (object == null)
        return; 
      object = paramFragmentCompat.forFragmentManager().getAddedFragments(object);
      if (object == null)
        return; 
      int i = 0;
      int j = object.size();
      while (i < j) {
        Object object1 = object.get(i);
        if (paramFragmentCompat.getDialogFragmentClass().isInstance(object1))
          paramAccumulator.store(object1); 
        i++;
      } 
    } 
  }
  
  @Nullable
  public Object getElementToHighlightAtPosition(Activity<Activity> paramActivity, int paramInt1, int paramInt2, Rect paramRect) {
    Activity<Activity> activity;
    Descriptor.Host host = getHost();
    if (host instanceof AndroidDescriptorHost) {
      Window window = paramActivity.getWindow();
      HighlightableDescriptor highlightableDescriptor = ((AndroidDescriptorHost)host).getHighlightableDescriptor(window);
    } else {
      activity = null;
      paramActivity = activity;
    } 
    return (paramActivity == null) ? null : paramActivity.getElementToHighlightAtPosition(activity, paramInt1, paramInt2, paramRect);
  }
  
  @Nullable
  public View getViewAndBoundsForHighlighting(Activity<Activity> paramActivity, Rect paramRect) {
    Activity<Activity> activity;
    Descriptor.Host host = getHost();
    if (host instanceof AndroidDescriptorHost) {
      Window window = paramActivity.getWindow();
      HighlightableDescriptor highlightableDescriptor = ((AndroidDescriptorHost)host).getHighlightableDescriptor(window);
    } else {
      activity = null;
      paramActivity = activity;
    } 
    return (paramActivity == null) ? null : paramActivity.getViewAndBoundsForHighlighting(activity, paramRect);
  }
  
  protected void onGetChildren(Activity paramActivity, Accumulator<Object> paramAccumulator) {
    getDialogFragments(FragmentCompat.getSupportLibInstance(), paramActivity, paramAccumulator);
    getDialogFragments(FragmentCompat.getFrameworkInstance(), paramActivity, paramAccumulator);
    Window window = paramActivity.getWindow();
    if (window != null)
      paramAccumulator.store(window); 
  }
  
  protected String onGetNodeName(Activity paramActivity) {
    return StringUtil.removePrefix(paramActivity.getClass().getName(), "android.app.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ActivityDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */