package org.chromium.android_webview;

import android.view.View;
import android.view.autofill.AutofillManager;
import java.lang.ref.WeakReference;
import java.util.ListIterator;

final class AwAutofillManager$AutofillInputUIMonitor extends AutofillManager.AutofillCallback {
  private WeakReference mManager;
  
  public AwAutofillManager$AutofillInputUIMonitor(AwAutofillManager paramAwAutofillManager) {
    this.mManager = new WeakReference<AwAutofillManager>(paramAwAutofillManager);
  }
  
  public final void onAutofillEvent(View paramView, int paramInt1, int paramInt2) {
    boolean bool;
    AwAutofillManager awAutofillManager = this.mManager.get();
    if (awAutofillManager == null)
      return; 
    if (paramInt2 == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    awAutofillManager.mIsAutofillInputUIShowing = bool;
    if (paramInt2 == 1) {
      ListIterator<WeakReference<AwAutofillManager$InputUIObserver>> listIterator = awAutofillManager.mInputUIObservers.listIterator();
      while (listIterator.hasNext()) {
        AwAutofillManager$InputUIObserver awAutofillManager$InputUIObserver = ((WeakReference<AwAutofillManager$InputUIObserver>)listIterator.next()).get();
        if (awAutofillManager$InputUIObserver == null) {
          listIterator.remove();
          continue;
        } 
        awAutofillManager$InputUIObserver.onInputUIShown();
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwAutofillManager$AutofillInputUIMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */