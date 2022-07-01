package org.chromium.content.browser.accessibility;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.ReceiverCallNotAllowedException;
import android.text.SpannableString;
import android.text.style.LocaleSpan;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.Locale;
import org.chromium.base.ContextUtils;
import org.chromium.content_public.browser.WebContents;

@TargetApi(21)
public class LollipopWebContentsAccessibility extends KitKatWebContentsAccessibility {
  private static SparseArray sAccessibilityActionMap = new SparseArray();
  
  private BroadcastReceiver mBroadcastReceiver;
  
  private String mSystemLanguageTag;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  LollipopWebContentsAccessibility(WebContents paramWebContents) {
    super(paramWebContents);
  }
  
  private void registerLocaleChangeReceiver() {
    if (!isNativeInitialized())
      return; 
    try {
      IntentFilter intentFilter = new IntentFilter("android.intent.action.LOCALE_CHANGED");
      ContextUtils.sApplicationContext.registerReceiver(this.mBroadcastReceiver, intentFilter);
    } catch (ReceiverCallNotAllowedException receiverCallNotAllowedException) {}
    this.mSystemLanguageTag = Locale.getDefault().toLanguageTag();
  }
  
  protected final void addAction(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt) {
    AccessibilityNodeInfo.AccessibilityAction accessibilityAction2 = (AccessibilityNodeInfo.AccessibilityAction)sAccessibilityActionMap.get(paramInt);
    AccessibilityNodeInfo.AccessibilityAction accessibilityAction1 = accessibilityAction2;
    if (accessibilityAction2 == null) {
      accessibilityAction1 = new AccessibilityNodeInfo.AccessibilityAction(paramInt, null);
      sAccessibilityActionMap.put(paramInt, accessibilityAction1);
    } 
    paramAccessibilityNodeInfo.addAction(accessibilityAction1);
  }
  
  protected final CharSequence computeText(String paramString1, boolean paramBoolean, String paramString2) {
    SpannableString spannableString;
    CharSequence charSequence = super.computeText(paramString1, paramBoolean, paramString2);
    if (!paramString2.isEmpty() && !paramString2.equals(this.mSystemLanguageTag)) {
      if (charSequence instanceof SpannableString) {
        spannableString = (SpannableString)charSequence;
      } else {
        spannableString = new SpannableString((CharSequence)spannableString);
      } 
      spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(paramString2)), 0, spannableString.length(), 0);
      return (CharSequence)spannableString;
    } 
    return (CharSequence)spannableString;
  }
  
  public final void onAttachedToWindow() {
    super.onAttachedToWindow();
    registerLocaleChangeReceiver();
  }
  
  public final void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (!isNativeInitialized())
      return; 
    ContextUtils.sApplicationContext.unregisterReceiver(this.mBroadcastReceiver);
  }
  
  protected final void onNativeInit() {
    super.onNativeInit();
    this.mBroadcastReceiver = new LollipopWebContentsAccessibility$1(this);
    if (this.mView.isAttachedToWindow())
      registerLocaleChangeReceiver(); 
  }
  
  protected void setAccessibilityEventCollectionInfo(AccessibilityEvent paramAccessibilityEvent, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  protected void setAccessibilityEventCollectionItemInfo(AccessibilityEvent paramAccessibilityEvent, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void setAccessibilityEventHeadingFlag(AccessibilityEvent paramAccessibilityEvent, boolean paramBoolean) {}
  
  protected void setAccessibilityEventLollipopAttributes(AccessibilityEvent paramAccessibilityEvent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2) {}
  
  protected void setAccessibilityEventRangeInfo(AccessibilityEvent paramAccessibilityEvent, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  protected void setAccessibilityNodeInfoCollectionInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt1, int paramInt2, boolean paramBoolean) {
    paramAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(paramInt1, paramInt2, paramBoolean));
  }
  
  protected void setAccessibilityNodeInfoCollectionItemInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    paramAccessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean));
  }
  
  protected void setAccessibilityNodeInfoLollipopAttributes(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2) {
    paramAccessibilityNodeInfo.setCanOpenPopup(paramBoolean1);
    paramAccessibilityNodeInfo.setContentInvalid(paramBoolean2);
    paramAccessibilityNodeInfo.setDismissable(paramBoolean2);
    paramAccessibilityNodeInfo.setMultiLine(paramBoolean4);
    paramAccessibilityNodeInfo.setInputType(paramInt1);
    paramAccessibilityNodeInfo.setLiveRegion(paramInt2);
  }
  
  protected void setAccessibilityNodeInfoRangeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
    paramAccessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(paramInt, paramFloat1, paramFloat2, paramFloat3));
  }
  
  protected void setAccessibilityNodeInfoViewIdResourceName(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString) {
    paramAccessibilityNodeInfo.setViewIdResourceName(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\LollipopWebContentsAccessibility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */