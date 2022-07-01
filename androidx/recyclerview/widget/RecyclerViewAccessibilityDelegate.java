package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
  final RecyclerView a;
  
  private final ItemDelegate b;
  
  public RecyclerViewAccessibilityDelegate(RecyclerView paramRecyclerView) {
    this.a = paramRecyclerView;
    AccessibilityDelegateCompat accessibilityDelegateCompat = getItemDelegate();
    if (accessibilityDelegateCompat != null && accessibilityDelegateCompat instanceof ItemDelegate) {
      this.b = (ItemDelegate)accessibilityDelegateCompat;
      return;
    } 
    this.b = new ItemDelegate(this);
  }
  
  boolean b() {
    return this.a.hasPendingAdapterUpdates();
  }
  
  public AccessibilityDelegateCompat getItemDelegate() {
    return this.b;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    if (paramView instanceof RecyclerView && !b()) {
      RecyclerView recyclerView = (RecyclerView)paramView;
      if (recyclerView.getLayoutManager() != null)
        recyclerView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent); 
    } 
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (!b() && this.a.getLayoutManager() != null)
      this.a.getLayoutManager().a(paramAccessibilityNodeInfoCompat); 
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle) {
    return super.performAccessibilityAction(paramView, paramInt, paramBundle) ? true : ((!b() && this.a.getLayoutManager() != null) ? this.a.getLayoutManager().a(paramInt, paramBundle) : false);
  }
  
  public static class ItemDelegate extends AccessibilityDelegateCompat {
    final RecyclerViewAccessibilityDelegate a;
    
    private Map<View, AccessibilityDelegateCompat> b = new WeakHashMap<View, AccessibilityDelegateCompat>();
    
    public ItemDelegate(RecyclerViewAccessibilityDelegate param1RecyclerViewAccessibilityDelegate) {
      this.a = param1RecyclerViewAccessibilityDelegate;
    }
    
    void b(View param1View) {
      AccessibilityDelegateCompat accessibilityDelegateCompat = ViewCompat.getAccessibilityDelegate(param1View);
      if (accessibilityDelegateCompat != null && accessibilityDelegateCompat != this)
        this.b.put(param1View, accessibilityDelegateCompat); 
    }
    
    AccessibilityDelegateCompat c(View param1View) {
      return this.b.remove(param1View);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      AccessibilityDelegateCompat accessibilityDelegateCompat = this.b.get(param1View);
      return (accessibilityDelegateCompat != null) ? accessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(param1View, param1AccessibilityEvent) : super.dispatchPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View param1View) {
      AccessibilityDelegateCompat accessibilityDelegateCompat = this.b.get(param1View);
      return (accessibilityDelegateCompat != null) ? accessibilityDelegateCompat.getAccessibilityNodeProvider(param1View) : super.getAccessibilityNodeProvider(param1View);
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      AccessibilityDelegateCompat accessibilityDelegateCompat = this.b.get(param1View);
      if (accessibilityDelegateCompat != null) {
        accessibilityDelegateCompat.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
        return;
      } 
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      if (!this.a.b() && this.a.a.getLayoutManager() != null) {
        this.a.a.getLayoutManager().a(param1View, param1AccessibilityNodeInfoCompat);
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.b.get(param1View);
        if (accessibilityDelegateCompat != null) {
          accessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
          return;
        } 
        super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
        return;
      } 
      super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
    }
    
    public void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      AccessibilityDelegateCompat accessibilityDelegateCompat = this.b.get(param1View);
      if (accessibilityDelegateCompat != null) {
        accessibilityDelegateCompat.onPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
        return;
      } 
      super.onPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      AccessibilityDelegateCompat accessibilityDelegateCompat = this.b.get(param1ViewGroup);
      return (accessibilityDelegateCompat != null) ? accessibilityDelegateCompat.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent) : super.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent);
    }
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
      if (!this.a.b() && this.a.a.getLayoutManager() != null) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.b.get(param1View);
        if (accessibilityDelegateCompat != null) {
          if (accessibilityDelegateCompat.performAccessibilityAction(param1View, param1Int, param1Bundle))
            return true; 
        } else if (super.performAccessibilityAction(param1View, param1Int, param1Bundle)) {
          return true;
        } 
        return this.a.a.getLayoutManager().a(param1View, param1Int, param1Bundle);
      } 
      return super.performAccessibilityAction(param1View, param1Int, param1Bundle);
    }
    
    public void sendAccessibilityEvent(View param1View, int param1Int) {
      AccessibilityDelegateCompat accessibilityDelegateCompat = this.b.get(param1View);
      if (accessibilityDelegateCompat != null) {
        accessibilityDelegateCompat.sendAccessibilityEvent(param1View, param1Int);
        return;
      } 
      super.sendAccessibilityEvent(param1View, param1Int);
    }
    
    public void sendAccessibilityEventUnchecked(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      AccessibilityDelegateCompat accessibilityDelegateCompat = this.b.get(param1View);
      if (accessibilityDelegateCompat != null) {
        accessibilityDelegateCompat.sendAccessibilityEventUnchecked(param1View, param1AccessibilityEvent);
        return;
      } 
      super.sendAccessibilityEventUnchecked(param1View, param1AccessibilityEvent);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\RecyclerViewAccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */