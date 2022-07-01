package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {
  private static final View.AccessibilityDelegate a = new View.AccessibilityDelegate();
  
  private final View.AccessibilityDelegate b;
  
  private final View.AccessibilityDelegate c;
  
  public AccessibilityDelegateCompat() {
    this(a);
  }
  
  public AccessibilityDelegateCompat(View.AccessibilityDelegate paramAccessibilityDelegate) {
    this.b = paramAccessibilityDelegate;
    this.c = new AccessibilityDelegateAdapter(this);
  }
  
  static List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> a(View paramView) {
    List<?> list2 = (List)paramView.getTag(R.id.tag_accessibility_actions);
    List<?> list1 = list2;
    if (list2 == null)
      list1 = Collections.emptyList(); 
    return (List)list1;
  }
  
  private boolean a(int paramInt, View paramView) {
    SparseArray sparseArray = (SparseArray)paramView.getTag(R.id.tag_accessibility_clickable_spans);
    if (sparseArray != null) {
      WeakReference<ClickableSpan> weakReference = (WeakReference)sparseArray.get(paramInt);
      if (weakReference != null) {
        ClickableSpan clickableSpan = weakReference.get();
        if (a(clickableSpan, paramView)) {
          clickableSpan.onClick(paramView);
          return true;
        } 
      } 
    } 
    return false;
  }
  
  private boolean a(ClickableSpan paramClickableSpan, View paramView) {
    if (paramClickableSpan != null) {
      ClickableSpan[] arrayOfClickableSpan = AccessibilityNodeInfoCompat.getClickableSpans(paramView.createAccessibilityNodeInfo().getText());
      for (int i = 0; arrayOfClickableSpan != null && i < arrayOfClickableSpan.length; i++) {
        if (paramClickableSpan.equals(arrayOfClickableSpan[i]))
          return true; 
      } 
    } 
    return false;
  }
  
  View.AccessibilityDelegate a() {
    return this.c;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return this.b.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView) {
    if (Build.VERSION.SDK_INT >= 16) {
      AccessibilityNodeProvider accessibilityNodeProvider = this.b.getAccessibilityNodeProvider(paramView);
      if (accessibilityNodeProvider != null)
        return new AccessibilityNodeProviderCompat(accessibilityNodeProvider); 
    } 
    return null;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    this.b.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    this.b.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat.unwrap());
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    this.b.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
    return this.b.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle) {
    List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = a(paramView);
    boolean bool2 = false;
    int i = 0;
    while (true) {
      bool1 = bool2;
      if (i < list.size()) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = list.get(i);
        if (accessibilityActionCompat.getId() == paramInt) {
          bool1 = accessibilityActionCompat.perform(paramView, paramBundle);
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    bool2 = bool1;
    if (!bool1) {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 16)
        bool2 = this.b.performAccessibilityAction(paramView, paramInt, paramBundle); 
    } 
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = bool2;
      if (paramInt == R.id.accessibility_action_clickable_span)
        bool1 = a(paramBundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), paramView); 
    } 
    return bool1;
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt) {
    this.b.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    this.b.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  static final class AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
    final AccessibilityDelegateCompat a;
    
    AccessibilityDelegateAdapter(AccessibilityDelegateCompat param1AccessibilityDelegateCompat) {
      this.a = param1AccessibilityDelegateCompat;
    }
    
    public boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return this.a.dispatchPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View param1View) {
      AccessibilityNodeProviderCompat accessibilityNodeProviderCompat = this.a.getAccessibilityNodeProvider(param1View);
      return (accessibilityNodeProviderCompat != null) ? (AccessibilityNodeProvider)accessibilityNodeProviderCompat.getProvider() : null;
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      this.a.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfo param1AccessibilityNodeInfo) {
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap(param1AccessibilityNodeInfo);
      accessibilityNodeInfoCompat.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(param1View));
      accessibilityNodeInfoCompat.setHeading(ViewCompat.isAccessibilityHeading(param1View));
      accessibilityNodeInfoCompat.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(param1View));
      this.a.onInitializeAccessibilityNodeInfo(param1View, accessibilityNodeInfoCompat);
      accessibilityNodeInfoCompat.addSpansToExtras(param1AccessibilityNodeInfo.getText(), param1View);
      List<AccessibilityNodeInfoCompat.AccessibilityActionCompat> list = AccessibilityDelegateCompat.a(param1View);
      for (int i = 0; i < list.size(); i++)
        accessibilityNodeInfoCompat.addAction(list.get(i)); 
    }
    
    public void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      this.a.onPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return this.a.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent);
    }
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
      return this.a.performAccessibilityAction(param1View, param1Int, param1Bundle);
    }
    
    public void sendAccessibilityEvent(View param1View, int param1Int) {
      this.a.sendAccessibilityEvent(param1View, param1Int);
    }
    
    public void sendAccessibilityEventUnchecked(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      this.a.sendAccessibilityEventUnchecked(param1View, param1AccessibilityEvent);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\AccessibilityDelegateCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */