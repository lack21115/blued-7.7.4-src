package org.chromium.content.browser.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.RenderCoordinatesImpl;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.accessibility.captioning.CaptioningController;
import org.chromium.content.browser.accessibility.captioning.SystemCaptioningBridge;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.AccessibilitySnapshotNode;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsAccessibility;
import org.chromium.ui.base.WindowAndroid;

public class WebContentsAccessibilityImpl extends AccessibilityNodeProvider implements AccessibilityManager.AccessibilityStateChangeListener, WindowEventObserver, WebContentsAccessibility {
  private boolean mAccessibilityEnabledForTesting;
  
  private int mAccessibilityFocusId;
  
  private Rect mAccessibilityFocusRect;
  
  protected AccessibilityManager mAccessibilityManager;
  
  private View mAutofillPopupView;
  
  private CaptioningController mCaptioningController;
  
  private Context mContext;
  
  private int mCurrentRootId;
  
  private boolean mInitialized;
  
  private boolean mIsHovering;
  
  private boolean mIsObscuredByAnotherView;
  
  private int mLastHoverId = -1;
  
  private boolean mNativeAccessibilityAllowed;
  
  protected long mNativeObj;
  
  private boolean mNotifyFrameInfoInitializedCalled;
  
  private boolean mPendingScrollToMakeNodeVisible;
  
  private String mProductVersion;
  
  private int mSelectionEndIndex;
  
  private int mSelectionGranularity;
  
  private int mSelectionNodeId;
  
  private int mSelectionStartIndex;
  
  private Runnable mSendWindowContentChangedRunnable;
  
  private boolean mShouldFocusOnPageLoad;
  
  public boolean mTouchExplorationEnabled;
  
  private boolean mUserHasTouchExplored;
  
  protected ViewGroup mView;
  
  private final WebContentsImpl mWebContents;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  protected WebContentsAccessibilityImpl(WebContents paramWebContents) {
    this.mWebContents = (WebContentsImpl)paramWebContents;
  }
  
  @CalledByNative
  private void addAccessibilityNodeInfoActions(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13, boolean paramBoolean14) {
    addAction(paramAccessibilityNodeInfo, 1024);
    addAction(paramAccessibilityNodeInfo, 2048);
    addAction(paramAccessibilityNodeInfo, 256);
    addAction(paramAccessibilityNodeInfo, 512);
    addAction(paramAccessibilityNodeInfo, 16908342);
    addAction(paramAccessibilityNodeInfo, 16908348);
    if (paramBoolean8 && paramBoolean9) {
      addAction(paramAccessibilityNodeInfo, 2097152);
      addAction(paramAccessibilityNodeInfo, 32768);
      if (paramBoolean14) {
        addAction(paramAccessibilityNodeInfo, 131072);
        addAction(paramAccessibilityNodeInfo, 65536);
        addAction(paramAccessibilityNodeInfo, 16384);
      } 
    } 
    if (paramBoolean1)
      addAction(paramAccessibilityNodeInfo, 4096); 
    if (paramBoolean2)
      addAction(paramAccessibilityNodeInfo, 8192); 
    if (paramBoolean3)
      addAction(paramAccessibilityNodeInfo, 16908344); 
    if (paramBoolean4)
      addAction(paramAccessibilityNodeInfo, 16908346); 
    if (paramBoolean5)
      addAction(paramAccessibilityNodeInfo, 16908345); 
    if (paramBoolean6)
      addAction(paramAccessibilityNodeInfo, 16908347); 
    if (paramBoolean10)
      if (paramBoolean11) {
        addAction(paramAccessibilityNodeInfo, 2);
      } else {
        addAction(paramAccessibilityNodeInfo, 1);
      }  
    if (this.mAccessibilityFocusId == paramInt) {
      addAction(paramAccessibilityNodeInfo, 128);
    } else {
      addAction(paramAccessibilityNodeInfo, 64);
    } 
    if (paramBoolean7)
      addAction(paramAccessibilityNodeInfo, 16); 
    if (paramBoolean12)
      addAction(paramAccessibilityNodeInfo, 262144); 
    if (paramBoolean13)
      addAction(paramAccessibilityNodeInfo, 524288); 
  }
  
  @CalledByNative
  private void addAccessibilityNodeInfoChild(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt) {
    paramAccessibilityNodeInfo.addChild((View)this.mView, paramInt);
  }
  
  @CalledByNative
  private void announceLiveRegionText(String paramString) {
    this.mView.announceForAccessibility(paramString);
  }
  
  private AccessibilityEvent buildAccessibilityEvent(int paramInt1, int paramInt2) {
    if (isAccessibilityEnabled()) {
      if (!isFrameInfoInitialized())
        return null; 
      this.mView.postInvalidate();
      AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain(paramInt2);
      accessibilityEvent.setPackageName(this.mContext.getPackageName());
      accessibilityEvent.setSource((View)this.mView, paramInt1);
      if (!nativePopulateAccessibilityEvent(this.mNativeObj, accessibilityEvent, paramInt1, paramInt2)) {
        accessibilityEvent.recycle();
        return null;
      } 
      return accessibilityEvent;
    } 
    return null;
  }
  
  public static WebContentsAccessibilityImpl create(Context paramContext, ViewGroup paramViewGroup, WebContents paramWebContents, String paramString) {
    WebContentsAccessibilityImpl webContentsAccessibilityImpl = (WebContentsAccessibilityImpl)paramWebContents.getOrSetUserData(WebContentsAccessibilityImpl.class, WebContentsAccessibilityImpl$UserDataFactoryLazyHolder.access$100());
    assert false;
    throw new AssertionError();
  }
  
  @TargetApi(23)
  private void createVirtualStructure(ViewStructure paramViewStructure, AccessibilitySnapshotNode paramAccessibilitySnapshotNode, int paramBoolean) {
    int i;
    paramViewStructure.setClassName(paramAccessibilitySnapshotNode.className);
    if (paramAccessibilitySnapshotNode.hasSelection) {
      paramViewStructure.setText(paramAccessibilitySnapshotNode.text, paramAccessibilitySnapshotNode.startSelection, paramAccessibilitySnapshotNode.endSelection);
    } else {
      paramViewStructure.setText(paramAccessibilitySnapshotNode.text);
    } 
    RenderCoordinatesImpl renderCoordinatesImpl = this.mWebContents.mRenderCoordinates;
    int m = (int)renderCoordinatesImpl.fromLocalCssToPix(paramAccessibilitySnapshotNode.x);
    int n = (int)renderCoordinatesImpl.fromLocalCssToPix(paramAccessibilitySnapshotNode.y);
    int j = (int)renderCoordinatesImpl.fromLocalCssToPix(paramAccessibilitySnapshotNode.width);
    int k = (int)renderCoordinatesImpl.fromLocalCssToPix(paramAccessibilitySnapshotNode.height);
    Rect rect = new Rect(m, n, m + j, n + k);
    boolean bool = paramAccessibilitySnapshotNode.isRootNode;
    n = 0;
    if (bool) {
      rect.offset(0, (int)renderCoordinatesImpl.mTopContentOffsetYPix);
      if (!paramBoolean)
        rect.offset(-((int)renderCoordinatesImpl.getScrollXPix()), -((int)renderCoordinatesImpl.getScrollYPix())); 
    } 
    paramViewStructure.setDimens(rect.left, rect.top, 0, 0, j, k);
    paramViewStructure.setChildCount(paramAccessibilitySnapshotNode.children.size());
    j = n;
    if (paramAccessibilitySnapshotNode.hasStyle) {
      float f = renderCoordinatesImpl.fromLocalCssToPix(paramAccessibilitySnapshotNode.textSize);
      paramBoolean = paramAccessibilitySnapshotNode.bold;
      if (paramAccessibilitySnapshotNode.italic) {
        j = 2;
      } else {
        j = 0;
      } 
      if (paramAccessibilitySnapshotNode.underline) {
        k = 4;
      } else {
        k = 0;
      } 
      if (paramAccessibilitySnapshotNode.lineThrough) {
        m = 8;
      } else {
        m = 0;
      } 
      paramViewStructure.setTextStyle(f, paramAccessibilitySnapshotNode.color, paramAccessibilitySnapshotNode.bgcolor, paramBoolean | j | k | m);
      i = n;
    } 
    while (i < paramAccessibilitySnapshotNode.children.size()) {
      createVirtualStructure(paramViewStructure.asyncNewChild(i), paramAccessibilitySnapshotNode.children.get(i), true);
      int i1 = i + 1;
    } 
    paramViewStructure.asyncCommit();
  }
  
  @CalledByNative
  private void finishGranularityMove(String paramString, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2) {
    AccessibilityEvent accessibilityEvent1 = buildAccessibilityEvent(this.mSelectionNodeId, 8192);
    if (accessibilityEvent1 == null)
      return; 
    AccessibilityEvent accessibilityEvent2 = buildAccessibilityEvent(this.mSelectionNodeId, 131072);
    if (accessibilityEvent2 == null) {
      accessibilityEvent1.recycle();
      return;
    } 
    if (paramBoolean2) {
      this.mSelectionEndIndex = paramInt2;
    } else {
      this.mSelectionEndIndex = paramInt1;
    } 
    if (!paramBoolean1)
      this.mSelectionStartIndex = this.mSelectionEndIndex; 
    if (nativeIsEditableText(this.mNativeObj, this.mSelectionNodeId) && nativeIsFocused(this.mNativeObj, this.mSelectionNodeId))
      nativeSetSelection(this.mNativeObj, this.mSelectionNodeId, this.mSelectionStartIndex, this.mSelectionEndIndex); 
    accessibilityEvent1.setFromIndex(this.mSelectionStartIndex);
    accessibilityEvent1.setToIndex(this.mSelectionStartIndex);
    accessibilityEvent1.setItemCount(paramString.length());
    if (paramBoolean2 && nativeIsEditableText(this.mNativeObj, this.mSelectionNodeId)) {
      accessibilityEvent2.setFromIndex(paramInt1 - 1);
      accessibilityEvent2.setToIndex(paramInt2 - 1);
    } else {
      accessibilityEvent2.setFromIndex(paramInt1);
      accessibilityEvent2.setToIndex(paramInt2);
    } 
    accessibilityEvent2.setItemCount(paramString.length());
    accessibilityEvent2.setMovementGranularity(this.mSelectionGranularity);
    accessibilityEvent2.setContentDescription(paramString);
    if (paramBoolean2) {
      accessibilityEvent2.setAction(256);
    } else {
      accessibilityEvent2.setAction(512);
    } 
    this.mView.requestSendAccessibilityEvent((View)this.mView, accessibilityEvent1);
    this.mView.requestSendAccessibilityEvent((View)this.mView, accessibilityEvent2);
  }
  
  public static WebContentsAccessibilityImpl fromWebContents(WebContents paramWebContents) {
    return (WebContentsAccessibilityImpl)paramWebContents.getOrSetUserData(WebContentsAccessibilityImpl.class, null);
  }
  
  @CalledByNative
  private int getAccessibilityServiceEventTypeMask() {
    Iterator iterator = this.mAccessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
    int i;
    for (i = 0; iterator.hasNext(); i |= ((AccessibilityServiceInfo)iterator.next()).eventTypes);
    return i;
  }
  
  @CalledByNative
  private int getAccessibilityServiceFeedbackTypeMask() {
    Iterator iterator = this.mAccessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
    int i;
    for (i = 0; iterator.hasNext(); i |= ((AccessibilityServiceInfo)iterator.next()).feedbackType);
    return i;
  }
  
  @CalledByNative
  private int getAccessibilityServiceFlagsMask() {
    Iterator iterator = this.mAccessibilityManager.getEnabledAccessibilityServiceList(-1).iterator();
    int i;
    for (i = 0; iterator.hasNext(); i |= ((AccessibilityServiceInfo)iterator.next()).flags);
    return i;
  }
  
  private static Bundle getOrCreateBundleForAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    Bundle bundle2 = (Bundle)paramAccessibilityEvent.getParcelableData();
    Bundle bundle1 = bundle2;
    if (bundle2 == null) {
      bundle1 = new Bundle();
      paramAccessibilityEvent.setParcelableData((Parcelable)bundle1);
    } 
    return bundle1;
  }
  
  @CalledByNative
  private void handleCheckStateChanged(int paramInt) {
    sendAccessibilityEvent(paramInt, 1);
  }
  
  @CalledByNative
  private void handleClicked(int paramInt) {
    sendAccessibilityEvent(paramInt, 1);
  }
  
  @CalledByNative
  private void handleContentChanged(int paramInt) {
    int i = nativeGetRootId(this.mNativeObj);
    if (i != this.mCurrentRootId) {
      this.mCurrentRootId = i;
      sendWindowContentChangedOnView();
      return;
    } 
    sendAccessibilityEvent(paramInt, 2048);
  }
  
  @CalledByNative
  private void handleEditableTextChanged(int paramInt) {
    sendAccessibilityEvent(paramInt, 16);
  }
  
  @CalledByNative
  private void handleFocusChanged(int paramInt) {
    if (!this.mShouldFocusOnPageLoad && this.mAccessibilityFocusId == -1)
      return; 
    sendAccessibilityEvent(paramInt, 8);
    moveAccessibilityFocusToId(paramInt);
  }
  
  @CalledByNative
  private void handleHover(int paramInt) {
    if (this.mLastHoverId == paramInt)
      return; 
    if (!this.mIsHovering)
      return; 
    sendAccessibilityEvent(paramInt, 128);
    if (this.mLastHoverId != -1)
      sendAccessibilityEvent(this.mLastHoverId, 256); 
    this.mLastHoverId = paramInt;
  }
  
  @CalledByNative
  private void handleNavigate() {
    this.mAccessibilityFocusId = -1;
    this.mAccessibilityFocusRect = null;
    this.mUserHasTouchExplored = false;
    sendWindowContentChangedOnView();
  }
  
  @CalledByNative
  private void handlePageLoaded(int paramInt) {
    if (!this.mShouldFocusOnPageLoad)
      return; 
    if (this.mUserHasTouchExplored)
      return; 
    moveAccessibilityFocusToIdAndRefocusIfNeeded(paramInt);
  }
  
  @CalledByNative
  private void handleScrollPositionChanged(int paramInt) {
    sendAccessibilityEvent(paramInt, 4096);
  }
  
  @CalledByNative
  private void handleScrolledToAnchor(int paramInt) {
    moveAccessibilityFocusToId(paramInt);
  }
  
  @CalledByNative
  private void handleSliderChanged(int paramInt) {
    sendAccessibilityEvent(paramInt, 4096);
  }
  
  @CalledByNative
  private void handleTextSelectionChanged(int paramInt) {
    sendAccessibilityEvent(paramInt, 8192);
  }
  
  private boolean isAccessibilityEnabled() {
    return (isNativeInitialized() && (this.mAccessibilityEnabledForTesting || this.mAccessibilityManager.isEnabled()));
  }
  
  private boolean isFrameInfoInitialized() {
    if (this.mWebContents == null)
      return true; 
    RenderCoordinatesImpl renderCoordinatesImpl = this.mWebContents.mRenderCoordinates;
    return (renderCoordinatesImpl.mContentWidthCss == 0.0D) ? ((renderCoordinatesImpl.mContentHeightCss != 0.0D)) : true;
  }
  
  private static boolean isValidMovementGranularity(int paramInt) {
    if (paramInt != 4)
      switch (paramInt) {
        default:
          return false;
        case 1:
        case 2:
          break;
      }  
    return true;
  }
  
  private boolean jumpToElementType(int paramInt, String paramString, boolean paramBoolean) {
    paramInt = nativeFindElementType(this.mNativeObj, paramInt, paramString, paramBoolean);
    if (paramInt == 0)
      return false; 
    moveAccessibilityFocusToId(paramInt);
    nativeScrollToMakeNodeVisible(this.mNativeObj, this.mAccessibilityFocusId);
    return true;
  }
  
  private boolean moveAccessibilityFocusToId(int paramInt) {
    if (paramInt == this.mAccessibilityFocusId)
      return false; 
    nativeMoveAccessibilityFocus(this.mNativeObj, this.mAccessibilityFocusId, paramInt);
    this.mAccessibilityFocusId = paramInt;
    this.mAccessibilityFocusRect = null;
    this.mSelectionNodeId = this.mAccessibilityFocusId;
    this.mSelectionGranularity = 0;
    this.mSelectionStartIndex = -1;
    this.mSelectionEndIndex = nativeGetTextLength(this.mNativeObj, paramInt);
    if (nativeIsAutofillPopupNode(this.mNativeObj, this.mAccessibilityFocusId))
      this.mAutofillPopupView.requestFocus(); 
    sendAccessibilityEvent(this.mAccessibilityFocusId, 32768);
    return true;
  }
  
  private void moveAccessibilityFocusToIdAndRefocusIfNeeded(int paramInt) {
    if (paramInt == this.mAccessibilityFocusId) {
      sendAccessibilityEvent(paramInt, 65536);
      this.mAccessibilityFocusId = -1;
    } 
    moveAccessibilityFocusToId(paramInt);
  }
  
  private native boolean nativeAdjustSlider(long paramLong, int paramInt, boolean paramBoolean);
  
  private native void nativeBlur(long paramLong);
  
  private native void nativeClick(long paramLong, int paramInt);
  
  private native void nativeEnable(long paramLong);
  
  private native int nativeFindElementType(long paramLong, int paramInt, String paramString, boolean paramBoolean);
  
  private native void nativeFocus(long paramLong, int paramInt);
  
  private native int nativeGetEditableTextSelectionEnd(long paramLong, int paramInt);
  
  private native int nativeGetEditableTextSelectionStart(long paramLong, int paramInt);
  
  private native int nativeGetIdForElementAfterElementHostingAutofillPopup(long paramLong);
  
  private native int nativeGetRootId(long paramLong);
  
  private native int nativeGetTextLength(long paramLong, int paramInt);
  
  private native long nativeInit(WebContents paramWebContents);
  
  private native boolean nativeIsAutofillPopupNode(long paramLong, int paramInt);
  
  private native boolean nativeIsEditableText(long paramLong, int paramInt);
  
  private native boolean nativeIsEnabled(long paramLong);
  
  private native boolean nativeIsFocused(long paramLong, int paramInt);
  
  private native boolean nativeIsNodeValid(long paramLong, int paramInt);
  
  private native boolean nativeIsSlider(long paramLong, int paramInt);
  
  private native void nativeMoveAccessibilityFocus(long paramLong, int paramInt1, int paramInt2);
  
  private native boolean nativeNextAtGranularity(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);
  
  private native void nativeOnAutofillPopupDismissed(long paramLong);
  
  private native void nativeOnAutofillPopupDisplayed(long paramLong);
  
  private native boolean nativePopulateAccessibilityEvent(long paramLong, AccessibilityEvent paramAccessibilityEvent, int paramInt1, int paramInt2);
  
  private native boolean nativePopulateAccessibilityNodeInfo(long paramLong, AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt);
  
  private native boolean nativePreviousAtGranularity(long paramLong, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3);
  
  private native boolean nativeScroll(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeScrollToMakeNodeVisible(long paramLong, int paramInt);
  
  private native void nativeSetSelection(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private native void nativeSetTextFieldValue(long paramLong, int paramInt, String paramString);
  
  private native void nativeShowContextMenu(long paramLong, int paramInt);
  
  @CalledByNative
  private void notifyFrameInfoInitialized() {
    if (this.mNotifyFrameInfoInitializedCalled)
      return; 
    this.mNotifyFrameInfoInitializedCalled = true;
    sendWindowContentChangedOnView();
    if (!this.mShouldFocusOnPageLoad)
      return; 
    if (this.mAccessibilityFocusId != -1)
      moveAccessibilityFocusToIdAndRefocusIfNeeded(this.mAccessibilityFocusId); 
  }
  
  @CalledByNative
  private boolean onHoverEvent(int paramInt) {
    if (!isAccessibilityEnabled())
      return false; 
    if (paramInt == 10) {
      this.mIsHovering = false;
      if (this.mLastHoverId != -1) {
        sendAccessibilityEvent(this.mLastHoverId, 256);
        this.mLastHoverId = -1;
      } 
      if (this.mPendingScrollToMakeNodeVisible)
        nativeScrollToMakeNodeVisible(this.mNativeObj, this.mAccessibilityFocusId); 
      this.mPendingScrollToMakeNodeVisible = false;
      return true;
    } 
    this.mIsHovering = true;
    this.mUserHasTouchExplored = true;
    return true;
  }
  
  private void sendAccessibilityEvent(int paramInt1, int paramInt2) {
    if (paramInt1 == -1) {
      this.mView.sendAccessibilityEvent(paramInt2);
      return;
    } 
    AccessibilityEvent accessibilityEvent = buildAccessibilityEvent(paramInt1, paramInt2);
    if (accessibilityEvent != null)
      this.mView.requestSendAccessibilityEvent((View)this.mView, accessibilityEvent); 
  }
  
  @CalledByNative
  private void sendDelayedWindowContentChangedEvent() {
    if (this.mSendWindowContentChangedRunnable != null)
      return; 
    this.mSendWindowContentChangedRunnable = new WebContentsAccessibilityImpl$2(this);
    this.mView.postDelayed(this.mSendWindowContentChangedRunnable, 500L);
  }
  
  private void sendWindowContentChangedOnView() {
    if (this.mSendWindowContentChangedRunnable != null) {
      this.mView.removeCallbacks(this.mSendWindowContentChangedRunnable);
      this.mSendWindowContentChangedRunnable = null;
    } 
    this.mView.sendAccessibilityEvent(2048);
  }
  
  @CalledByNative
  private void setAccessibilityEventBooleanAttributes(AccessibilityEvent paramAccessibilityEvent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    paramAccessibilityEvent.setChecked(paramBoolean1);
    paramAccessibilityEvent.setEnabled(paramBoolean2);
    paramAccessibilityEvent.setPassword(paramBoolean3);
    paramAccessibilityEvent.setScrollable(paramBoolean4);
  }
  
  @CalledByNative
  private void setAccessibilityEventClassName(AccessibilityEvent paramAccessibilityEvent, String paramString) {
    paramAccessibilityEvent.setClassName(paramString);
  }
  
  @CalledByNative
  private void setAccessibilityEventListAttributes(AccessibilityEvent paramAccessibilityEvent, int paramInt1, int paramInt2) {
    paramAccessibilityEvent.setCurrentItemIndex(paramInt1);
    paramAccessibilityEvent.setItemCount(paramInt2);
  }
  
  @CalledByNative
  private void setAccessibilityEventScrollAttributes(AccessibilityEvent paramAccessibilityEvent, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramAccessibilityEvent.setScrollX(paramInt1);
    paramAccessibilityEvent.setScrollY(paramInt2);
    paramAccessibilityEvent.setMaxScrollX(paramInt3);
    paramAccessibilityEvent.setMaxScrollY(paramInt4);
  }
  
  @CalledByNative
  private void setAccessibilityEventSelectionAttrs(AccessibilityEvent paramAccessibilityEvent, int paramInt1, int paramInt2, int paramInt3, String paramString) {
    paramAccessibilityEvent.setFromIndex(paramInt1);
    paramAccessibilityEvent.setToIndex(paramInt2);
    paramAccessibilityEvent.setItemCount(paramInt3);
    paramAccessibilityEvent.getText().add(paramString);
  }
  
  @CalledByNative
  private void setAccessibilityEventTextChangedAttrs(AccessibilityEvent paramAccessibilityEvent, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2) {
    paramAccessibilityEvent.setFromIndex(paramInt1);
    paramAccessibilityEvent.setAddedCount(paramInt2);
    paramAccessibilityEvent.setRemovedCount(paramInt3);
    paramAccessibilityEvent.setBeforeText(paramString1);
    paramAccessibilityEvent.getText().add(paramString2);
  }
  
  @CalledByNative
  private void setAccessibilityNodeInfoBooleanAttributes(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10) {
    paramAccessibilityNodeInfo.setCheckable(paramBoolean1);
    paramAccessibilityNodeInfo.setChecked(paramBoolean2);
    paramAccessibilityNodeInfo.setClickable(paramBoolean3);
    paramAccessibilityNodeInfo.setEnabled(paramBoolean4);
    paramAccessibilityNodeInfo.setFocusable(paramBoolean5);
    paramAccessibilityNodeInfo.setFocused(paramBoolean6);
    paramAccessibilityNodeInfo.setPassword(paramBoolean7);
    paramAccessibilityNodeInfo.setScrollable(paramBoolean8);
    paramAccessibilityNodeInfo.setSelected(paramBoolean9);
    paramAccessibilityNodeInfo.setVisibleToUser(paramBoolean10);
    paramAccessibilityNodeInfo.setMovementGranularities(7);
    if (this.mAccessibilityFocusId == paramInt) {
      paramAccessibilityNodeInfo.setAccessibilityFocused(true);
      return;
    } 
    paramAccessibilityNodeInfo.setAccessibilityFocused(false);
  }
  
  @CalledByNative
  private void setAccessibilityNodeInfoClassName(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString) {
    paramAccessibilityNodeInfo.setClassName(paramString);
  }
  
  @CalledByNative
  private void setAccessibilityNodeInfoLocation(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean) {
    Rect rect = new Rect(paramInt4, paramInt5, paramInt4 + paramInt6, paramInt5 + paramInt7);
    if (paramBoolean)
      rect.offset(0, (int)this.mWebContents.mRenderCoordinates.mTopContentOffsetYPix); 
    paramAccessibilityNodeInfo.setBoundsInParent(rect);
    rect = new Rect(paramInt2, paramInt3, paramInt6 + paramInt2, paramInt7 + paramInt3);
    convertWebRectToAndroidCoordinates(rect);
    paramAccessibilityNodeInfo.setBoundsInScreen(rect);
    if (paramInt1 == this.mAccessibilityFocusId && paramInt1 != this.mCurrentRootId) {
      if (this.mAccessibilityFocusRect == null) {
        this.mAccessibilityFocusRect = rect;
        return;
      } 
      if (!this.mAccessibilityFocusRect.equals(rect)) {
        this.mAccessibilityFocusRect = rect;
        moveAccessibilityFocusToIdAndRefocusIfNeeded(paramInt1);
      } 
    } 
  }
  
  @CalledByNative
  private void setAccessibilityNodeInfoParent(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt) {
    paramAccessibilityNodeInfo.setParent((View)this.mView, paramInt);
  }
  
  @SuppressLint({"NewApi"})
  @CalledByNative
  private void setAccessibilityNodeInfoText(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2) {
    paramAccessibilityNodeInfo.setText(computeText(paramString1, paramBoolean2, paramString2));
  }
  
  private void setGranularityAndUpdateSelection(int paramInt) {
    this.mSelectionGranularity = paramInt;
    if (this.mSelectionGranularity == 0) {
      this.mSelectionStartIndex = -1;
      this.mSelectionEndIndex = -1;
    } 
    if (nativeIsEditableText(this.mNativeObj, this.mAccessibilityFocusId) && nativeIsFocused(this.mNativeObj, this.mAccessibilityFocusId)) {
      this.mSelectionStartIndex = nativeGetEditableTextSelectionStart(this.mNativeObj, this.mAccessibilityFocusId);
      this.mSelectionEndIndex = nativeGetEditableTextSelectionEnd(this.mNativeObj, this.mAccessibilityFocusId);
    } 
  }
  
  private void setState(boolean paramBoolean) {
    if (!paramBoolean) {
      this.mNativeAccessibilityAllowed = false;
      this.mTouchExplorationEnabled = false;
      return;
    } 
    this.mNativeAccessibilityAllowed = true;
    this.mTouchExplorationEnabled = this.mAccessibilityManager.isTouchExplorationEnabled();
  }
  
  protected void addAction(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt) {
    if (paramInt > 2097152)
      return; 
    paramAccessibilityNodeInfo.addAction(paramInt);
  }
  
  protected CharSequence computeText(String paramString1, boolean paramBoolean, String paramString2) {
    SpannableString spannableString;
    if (paramBoolean) {
      spannableString = new SpannableString(paramString1);
      spannableString.setSpan(new URLSpan(""), 0, spannableString.length(), 0);
      return (CharSequence)spannableString;
    } 
    return (CharSequence)spannableString;
  }
  
  protected final void convertWebRectToAndroidCoordinates(Rect paramRect) {
    RenderCoordinatesImpl renderCoordinatesImpl = this.mWebContents.mRenderCoordinates;
    paramRect.offset(-((int)renderCoordinatesImpl.mScrollXCss), -((int)renderCoordinatesImpl.mScrollYCss));
    paramRect.left = (int)renderCoordinatesImpl.fromLocalCssToPix(paramRect.left);
    paramRect.top = (int)renderCoordinatesImpl.fromLocalCssToPix(paramRect.top);
    paramRect.bottom = (int)renderCoordinatesImpl.fromLocalCssToPix(paramRect.bottom);
    paramRect.right = (int)renderCoordinatesImpl.fromLocalCssToPix(paramRect.right);
    paramRect.offset(0, (int)renderCoordinatesImpl.mTopContentOffsetYPix);
    int[] arrayOfInt = new int[2];
    this.mView.getLocationOnScreen(arrayOfInt);
    paramRect.offset(arrayOfInt[0], arrayOfInt[1]);
    int i = arrayOfInt[1] + (int)renderCoordinatesImpl.mTopContentOffsetYPix;
    int j = this.mView.getHeight() + i;
    if (paramRect.top < i)
      paramRect.top = i; 
    if (paramRect.bottom > j)
      paramRect.bottom = j; 
  }
  
  public AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt) {
    if (!isAccessibilityEnabled())
      return null; 
    int i = nativeGetRootId(this.mNativeObj);
    if (paramInt == -1) {
      AccessibilityNodeInfo accessibilityNodeInfo1 = AccessibilityNodeInfo.obtain((View)this.mView);
      AccessibilityNodeInfo accessibilityNodeInfo2 = AccessibilityNodeInfo.obtain((View)this.mView);
      this.mView.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo2);
      Rect rect = new Rect();
      accessibilityNodeInfo2.getBoundsInParent(rect);
      accessibilityNodeInfo1.setBoundsInParent(rect);
      accessibilityNodeInfo2.getBoundsInScreen(rect);
      accessibilityNodeInfo1.setBoundsInScreen(rect);
      ViewParent viewParent = this.mView.getParentForAccessibility();
      if (viewParent instanceof View)
        accessibilityNodeInfo1.setParent((View)viewParent); 
      accessibilityNodeInfo1.setVisibleToUser(accessibilityNodeInfo2.isVisibleToUser());
      accessibilityNodeInfo1.setEnabled(accessibilityNodeInfo2.isEnabled());
      accessibilityNodeInfo1.setPackageName(accessibilityNodeInfo2.getPackageName());
      accessibilityNodeInfo1.setClassName(accessibilityNodeInfo2.getClassName());
      if (isFrameInfoInitialized())
        accessibilityNodeInfo1.addChild((View)this.mView, i); 
      return accessibilityNodeInfo1;
    } 
    if (!isFrameInfoInitialized())
      return null; 
    AccessibilityNodeInfo accessibilityNodeInfo = AccessibilityNodeInfo.obtain((View)this.mView);
    accessibilityNodeInfo.setPackageName(this.mContext.getPackageName());
    accessibilityNodeInfo.setSource((View)this.mView, paramInt);
    if (paramInt == i)
      accessibilityNodeInfo.setParent((View)this.mView); 
    if (nativePopulateAccessibilityNodeInfo(this.mNativeObj, accessibilityNodeInfo, paramInt))
      return accessibilityNodeInfo; 
    accessibilityNodeInfo.recycle();
    return null;
  }
  
  public List findAccessibilityNodeInfosByText(String paramString, int paramInt) {
    return new ArrayList();
  }
  
  public final AccessibilityNodeProvider getAccessibilityNodeProvider() {
    boolean bool;
    if (this.mIsObscuredByAnotherView)
      return null; 
    if (!isNativeInitialized()) {
      if (!this.mNativeAccessibilityAllowed)
        return null; 
      this.mNativeObj = nativeInit((WebContents)this.mWebContents);
      onNativeInit();
    } 
    if (isNativeInitialized()) {
      bool = nativeIsEnabled(this.mNativeObj);
    } else {
      bool = false;
    } 
    if (!bool) {
      nativeEnable(this.mNativeObj);
      return null;
    } 
    return this;
  }
  
  @CalledByNative
  protected int getAccessibilityServiceCapabilitiesMask() {
    return 0;
  }
  
  protected final boolean isNativeInitialized() {
    return (this.mNativeObj != 0L);
  }
  
  protected native boolean nativeAreInlineTextBoxesLoaded(long paramLong, int paramInt);
  
  protected native int[] nativeGetCharacterBoundingBoxes(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  protected native String nativeGetSupportedHtmlElementTypes(long paramLong);
  
  protected native void nativeLoadInlineTextBoxes(long paramLong, int paramInt);
  
  public void onAccessibilityStateChanged(boolean paramBoolean) {
    setState(paramBoolean);
  }
  
  public void onAttachedToWindow() {
    this.mAccessibilityManager.addAccessibilityStateChangeListener(this);
    refreshState();
    CaptioningController captioningController = this.mCaptioningController;
    captioningController.mSystemCaptioningBridge.addListener((SystemCaptioningBridge.SystemCaptioningBridgeListener)captioningController);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDIPScaleChanged(float paramFloat) {}
  
  public void onDetachedFromWindow() {
    this.mAccessibilityManager.removeAccessibilityStateChangeListener(this);
    CaptioningController captioningController = this.mCaptioningController;
    captioningController.mSystemCaptioningBridge.removeListener((SystemCaptioningBridge.SystemCaptioningBridgeListener)captioningController);
  }
  
  protected void onNativeInit() {
    this.mAccessibilityFocusId = -1;
    this.mSelectionNodeId = -1;
    this.mIsHovering = false;
    this.mCurrentRootId = -1;
  }
  
  @CalledByNative
  protected void onNativeObjectDestroyed() {
    this.mNativeObj = 0L;
  }
  
  @TargetApi(23)
  public final void onProvideVirtualStructure(ViewStructure paramViewStructure, boolean paramBoolean) {
    if (this.mWebContents.isIncognito()) {
      paramViewStructure.setChildCount(0);
      return;
    } 
    paramViewStructure.setChildCount(1);
    ViewStructure viewStructure = paramViewStructure.asyncNewChild(0);
    WebContentsImpl webContentsImpl = this.mWebContents;
    WebContentsAccessibilityImpl$1 webContentsAccessibilityImpl$1 = new WebContentsAccessibilityImpl$1(this, viewStructure, paramBoolean);
    webContentsImpl.nativeRequestAccessibilitySnapshot(webContentsImpl.mNativeWebContentsAndroid, webContentsAccessibilityImpl$1);
  }
  
  public final void onRotationChanged(int paramInt) {}
  
  public final void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {}
  
  public final void onWindowFocusChanged(boolean paramBoolean) {}
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle) {
    if (isAccessibilityEnabled()) {
      String str;
      boolean bool;
      boolean bool1;
      if (!nativeIsNodeValid(this.mNativeObj, paramInt1))
        return false; 
      switch (paramInt2) {
        default:
          return false;
        case 16908348:
          nativeShowContextMenu(this.mNativeObj, paramInt1);
          return true;
        case 16908347:
          return nativeScroll(this.mNativeObj, paramInt1, 5);
        case 16908346:
          return nativeScroll(this.mNativeObj, paramInt1, 3);
        case 16908345:
          return nativeScroll(this.mNativeObj, paramInt1, 4);
        case 16908344:
          return nativeScroll(this.mNativeObj, paramInt1, 2);
        case 16908342:
          nativeScrollToMakeNodeVisible(this.mNativeObj, paramInt1);
          return true;
        case 2097152:
          if (!nativeIsEditableText(this.mNativeObj, paramInt1))
            return false; 
          if (paramBundle == null)
            return false; 
          str = paramBundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
          if (str == null)
            return false; 
          nativeSetTextFieldValue(this.mNativeObj, paramInt1, str);
          nativeSetSelection(this.mNativeObj, paramInt1, str.length(), str.length());
          return true;
        case 262144:
        case 524288:
          nativeClick(this.mNativeObj, paramInt1);
          return true;
        case 131072:
          if (!nativeIsEditableText(this.mNativeObj, paramInt1))
            return false; 
          if (str != null) {
            paramInt2 = str.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
            bool = str.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
          } else {
            paramInt2 = 0;
            bool = false;
          } 
          nativeSetSelection(this.mNativeObj, paramInt1, paramInt2, bool);
          return true;
        case 65536:
          if (this.mWebContents != null) {
            this.mWebContents.cut();
            return true;
          } 
          return false;
        case 32768:
          if (this.mWebContents != null) {
            this.mWebContents.paste();
            return true;
          } 
          return false;
        case 16384:
          if (this.mWebContents != null) {
            this.mWebContents.copy();
            return true;
          } 
          return false;
        case 8192:
          return nativeIsSlider(this.mNativeObj, paramInt1) ? nativeAdjustSlider(this.mNativeObj, paramInt1, false) : nativeScroll(this.mNativeObj, paramInt1, 1);
        case 4096:
          return nativeIsSlider(this.mNativeObj, paramInt1) ? nativeAdjustSlider(this.mNativeObj, paramInt1, true) : nativeScroll(this.mNativeObj, paramInt1, 0);
        case 2048:
          if (str == null)
            return false; 
          str = str.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
          return (str == null) ? false : jumpToElementType(paramInt1, str.toUpperCase(Locale.US), false);
        case 1024:
          if (str == null)
            return false; 
          str = str.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
          return (str == null) ? false : jumpToElementType(paramInt1, str.toUpperCase(Locale.US), true);
        case 512:
          if (str == null)
            return false; 
          paramInt2 = str.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
          bool1 = str.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
          if (!isValidMovementGranularity(paramInt2))
            return false; 
          if (paramInt1 != this.mSelectionNodeId)
            return false; 
          setGranularityAndUpdateSelection(paramInt2);
          return nativePreviousAtGranularity(this.mNativeObj, this.mSelectionGranularity, bool1, paramInt1, this.mSelectionEndIndex);
        case 256:
          if (str == null)
            return false; 
          paramInt2 = str.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
          bool1 = str.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
          if (!isValidMovementGranularity(paramInt2))
            return false; 
          if (paramInt1 != this.mSelectionNodeId)
            return false; 
          setGranularityAndUpdateSelection(paramInt2);
          return nativeNextAtGranularity(this.mNativeObj, this.mSelectionGranularity, bool1, paramInt1, this.mSelectionStartIndex);
        case 128:
          sendAccessibilityEvent(paramInt1, 65536);
          if (this.mAccessibilityFocusId == paramInt1) {
            nativeMoveAccessibilityFocus(this.mNativeObj, this.mAccessibilityFocusId, -1);
            this.mAccessibilityFocusId = -1;
            this.mAccessibilityFocusRect = null;
          } 
          return true;
        case 64:
          if (!moveAccessibilityFocusToId(paramInt1))
            return true; 
          if (!this.mIsHovering) {
            nativeScrollToMakeNodeVisible(this.mNativeObj, this.mAccessibilityFocusId);
            return true;
          } 
          this.mPendingScrollToMakeNodeVisible = true;
          return true;
        case 16:
          if (!this.mView.hasFocus())
            this.mView.requestFocus(); 
          nativeClick(this.mNativeObj, paramInt1);
          return true;
        case 2:
          nativeBlur(this.mNativeObj);
          return true;
        case 1:
          break;
      } 
      if (!this.mView.hasFocus())
        this.mView.requestFocus(); 
      nativeFocus(this.mNativeObj, paramInt1);
      return true;
    } 
    return false;
  }
  
  public final boolean performAction$68e2e3ea() {
    return false;
  }
  
  public final void refreshState() {
    setState(this.mAccessibilityManager.isEnabled());
  }
  
  @CalledByNative
  protected void setAccessibilityEventCollectionInfo(AccessibilityEvent paramAccessibilityEvent, int paramInt1, int paramInt2, boolean paramBoolean) {
    Bundle bundle = getOrCreateBundleForAccessibilityEvent(paramAccessibilityEvent);
    bundle.putInt("AccessibilityNodeInfo.CollectionInfo.rowCount", paramInt1);
    bundle.putInt("AccessibilityNodeInfo.CollectionInfo.columnCount", paramInt2);
    bundle.putBoolean("AccessibilityNodeInfo.CollectionInfo.hierarchical", paramBoolean);
  }
  
  @CalledByNative
  protected void setAccessibilityEventCollectionItemInfo(AccessibilityEvent paramAccessibilityEvent, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Bundle bundle = getOrCreateBundleForAccessibilityEvent(paramAccessibilityEvent);
    bundle.putInt("AccessibilityNodeInfo.CollectionItemInfo.rowIndex", paramInt1);
    bundle.putInt("AccessibilityNodeInfo.CollectionItemInfo.rowSpan", paramInt2);
    bundle.putInt("AccessibilityNodeInfo.CollectionItemInfo.columnIndex", paramInt3);
    bundle.putInt("AccessibilityNodeInfo.CollectionItemInfo.columnSpan", paramInt4);
  }
  
  @CalledByNative
  protected void setAccessibilityEventHeadingFlag(AccessibilityEvent paramAccessibilityEvent, boolean paramBoolean) {
    getOrCreateBundleForAccessibilityEvent(paramAccessibilityEvent).putBoolean("AccessibilityNodeInfo.CollectionItemInfo.heading", paramBoolean);
  }
  
  @CalledByNative
  protected void setAccessibilityEventLollipopAttributes(AccessibilityEvent paramAccessibilityEvent, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2) {
    Bundle bundle = getOrCreateBundleForAccessibilityEvent(paramAccessibilityEvent);
    bundle.putBoolean("AccessibilityNodeInfo.canOpenPopup", paramBoolean1);
    bundle.putBoolean("AccessibilityNodeInfo.contentInvalid", paramBoolean2);
    bundle.putBoolean("AccessibilityNodeInfo.dismissable", paramBoolean3);
    bundle.putBoolean("AccessibilityNodeInfo.multiLine", paramBoolean4);
    bundle.putInt("AccessibilityNodeInfo.inputType", paramInt1);
    bundle.putInt("AccessibilityNodeInfo.liveRegion", paramInt2);
  }
  
  @CalledByNative
  protected void setAccessibilityEventRangeInfo(AccessibilityEvent paramAccessibilityEvent, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {
    Bundle bundle = getOrCreateBundleForAccessibilityEvent(paramAccessibilityEvent);
    bundle.putInt("AccessibilityNodeInfo.RangeInfo.type", paramInt);
    bundle.putFloat("AccessibilityNodeInfo.RangeInfo.min", paramFloat1);
    bundle.putFloat("AccessibilityNodeInfo.RangeInfo.max", paramFloat2);
    bundle.putFloat("AccessibilityNodeInfo.RangeInfo.current", paramFloat3);
  }
  
  @CalledByNative
  protected void setAccessibilityNodeInfoCollectionInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  @CalledByNative
  protected void setAccessibilityNodeInfoCollectionItemInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {}
  
  @CalledByNative
  protected void setAccessibilityNodeInfoKitKatAttributes(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, boolean paramBoolean3) {}
  
  @CalledByNative
  protected void setAccessibilityNodeInfoLollipopAttributes(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2) {}
  
  @CalledByNative
  protected void setAccessibilityNodeInfoOAttributes(AccessibilityNodeInfo paramAccessibilityNodeInfo, boolean paramBoolean) {}
  
  @CalledByNative
  protected void setAccessibilityNodeInfoRangeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  @CalledByNative
  protected void setAccessibilityNodeInfoViewIdResourceName(AccessibilityNodeInfo paramAccessibilityNodeInfo, String paramString) {}
  
  @CalledByNative
  boolean shouldExposePasswordText() {
    ContentResolver contentResolver = this.mContext.getContentResolver();
    return (Build.VERSION.SDK_INT >= 26) ? ((Settings.System.getInt(contentResolver, "show_password", 1) == 1)) : ((Settings.Secure.getInt(contentResolver, "speak_password", 0) == 1));
  }
  
  @CalledByNative
  boolean shouldRespectDisplayedPasswordText() {
    return (Build.VERSION.SDK_INT >= 26);
  }
  
  public final boolean supportsAction$134632() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\WebContentsAccessibilityImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */