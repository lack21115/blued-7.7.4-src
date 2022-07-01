package org.chromium.ui.base;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ContextUtils;
import org.chromium.ui.UiUtils;

public final class ActivityWindowAndroid extends WindowAndroid implements View.OnLayoutChangeListener, ApplicationStatus.ActivityStateListener {
  private boolean mListenToActivityState;
  
  private int mNextRequestCode;
  
  public ActivityWindowAndroid(Context paramContext, boolean paramBoolean) {
    super(paramContext);
    Activity activity = activityFromContext(paramContext);
    if (activity != null) {
      this.mListenToActivityState = paramBoolean;
      if (paramBoolean)
        ApplicationStatus.registerStateListenerForActivity(this, activity); 
      this.mPermissionDelegate = new ActivityAndroidPermissionDelegate(getActivity());
      return;
    } 
    throw new IllegalArgumentException("Context is not and does not wrap an Activity");
  }
  
  public final WeakReference getActivity() {
    return new WeakReference<Activity>(activityFromContext(getContext().get()));
  }
  
  public final int getActivityState() {
    return this.mListenToActivityState ? ApplicationStatus.getStateForActivity(getActivity().get()) : super.getActivityState();
  }
  
  public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    boolean bool = UiUtils.isKeyboardShowing(getActivity().get(), paramView);
    if (this.mIsKeyboardShowing != bool) {
      this.mIsKeyboardShowing = bool;
      Iterator iterator = this.mKeyboardVisibilityListeners.iterator();
      while (iterator.hasNext())
        iterator.next(); 
    } 
  }
  
  public final int showCancelableIntent(Intent paramIntent, WindowAndroid$IntentCallback paramWindowAndroid$IntentCallback, Integer paramInteger) {
    Activity activity = getActivity().get();
    if (activity == null)
      return -1; 
    int i = this.mNextRequestCode + 1000;
    this.mNextRequestCode = (this.mNextRequestCode + 1) % 100;
    try {
      String str;
      activity.startActivityForResult(paramIntent, i);
      this.mOutstandingIntents.put(i, paramWindowAndroid$IntentCallback);
      HashMap<Integer, String> hashMap = this.mIntentErrors;
      if (paramInteger == null) {
        paramIntent = null;
      } else {
        str = ContextUtils.sApplicationContext.getString(paramInteger.intValue());
      } 
      hashMap.put(Integer.valueOf(i), str);
      return i;
    } catch (ActivityNotFoundException activityNotFoundException) {
      return -1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\ActivityWindowAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */