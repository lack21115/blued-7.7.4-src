package org.chromium.content.browser.selection;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.text.style.UpdateAppearance;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.textclassifier.TextClassifier;
import java.util.List;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.RecordUserAction;
import org.chromium.content.R;
import org.chromium.content.browser.ContentClassFactory;
import org.chromium.content.browser.ContentFeatureList;
import org.chromium.content.browser.GestureListenerManagerImpl;
import org.chromium.content.browser.PopupController;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.input.ImeAdapterImpl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.ActionModeCallbackHelper;
import org.chromium.content_public.browser.ImeEventObserver;
import org.chromium.content_public.browser.SelectionClient;
import org.chromium.content_public.browser.SelectionPopupController;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.DeviceFormFactor;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

@TargetApi(23)
public class SelectionPopupControllerImpl extends ActionModeCallbackHelper implements PopupController.HideablePopup, WindowEventObserver, ImeEventObserver, SelectionPopupController, ViewAndroidDelegate.ContainerViewObserver {
  static boolean sShouldGetReadbackViewFromWindowAndroid;
  
  private ActionMode mActionMode;
  
  private AdditionalMenuItemProvider mAdditionalMenuItemProvider;
  
  private int mAllowedMenuItems;
  
  private ActionMode.Callback mCallback;
  
  private boolean mCanEditRichly;
  
  boolean mCanSelectAllForPastePopup;
  
  private SelectionClient.Result mClassificationResult;
  
  private Context mContext;
  
  private boolean mEditable;
  
  private SelectionInsertionHandleObserver mHandleObserver;
  
  boolean mHasSelection;
  
  private boolean mHidden;
  
  private boolean mInitialized;
  
  private boolean mIsPasswordType;
  
  private String mLastSelectedText;
  
  private int mLastSelectionOffset;
  
  private long mNativeSelectionPopupController;
  
  private ActionMode.Callback mNonSelectionCallback;
  
  private PastePopupMenu mPastePopupMenu;
  
  private PopupController mPopupController;
  
  private boolean mPreserveSelectionOnNextLossOfFocus;
  
  private Runnable mRepeatingHideRunnable;
  
  private SelectionClient.ResultCallback mResultCallback;
  
  private SelectionClient mSelectionClient;
  
  private SmartSelectionMetricsLogger mSelectionMetricsLogger;
  
  private final Rect mSelectionRect = new Rect();
  
  private boolean mUnselectAllOnDismiss;
  
  View mView;
  
  private boolean mWasPastePopupShowingOnInsertionDragStart;
  
  WebContentsImpl mWebContents;
  
  WindowAndroid mWindowAndroid;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public SelectionPopupControllerImpl(WebContents paramWebContents) {
    this.mWebContents = (WebContentsImpl)paramWebContents;
  }
  
  private boolean canPaste() {
    return ((ClipboardManager)this.mContext.getSystemService("clipboard")).hasPrimaryClip();
  }
  
  private void clearSelection() {
    if (this.mWebContents != null) {
      if (!isActionModeSupported())
        return; 
      WebContentsImpl webContentsImpl = this.mWebContents;
      if (!webContentsImpl.isDestroyed())
        webContentsImpl.nativeCollapseSelection(webContentsImpl.mNativeWebContentsAndroid); 
      this.mClassificationResult = null;
      return;
    } 
  }
  
  public static SelectionPopupControllerImpl create(Context paramContext, WindowAndroid paramWindowAndroid, WebContents paramWebContents) {
    SelectionPopupControllerImpl selectionPopupControllerImpl = (SelectionPopupControllerImpl)paramWebContents.getOrSetUserData(SelectionPopupControllerImpl.class, SelectionPopupControllerImpl$UserDataFactoryLazyHolder.access$000());
    assert false;
    throw new AssertionError();
  }
  
  private void createActionMenu(ActionMode paramActionMode, Menu paramMenu) {
    initializeMenu(this.mContext, paramActionMode, paramMenu);
    if (Build.VERSION.SDK_INT >= 26 && this.mClassificationResult != null && this.mClassificationResult.hasNamedAction())
      paramMenu.add(R.id.select_action_menu_assist_items, 16908353, 1, this.mClassificationResult.label).setIcon(this.mClassificationResult.icon); 
    if (!this.mEditable || !canPaste()) {
      paramMenu.removeItem(R.id.select_action_menu_paste);
      paramMenu.removeItem(R.id.select_action_menu_paste_as_plain_text);
    } 
    if (!canPasteAsPlainText())
      paramMenu.removeItem(R.id.select_action_menu_paste_as_plain_text); 
    if (!this.mHasSelection) {
      paramMenu.removeItem(R.id.select_action_menu_select_all);
      paramMenu.removeItem(R.id.select_action_menu_cut);
      paramMenu.removeItem(R.id.select_action_menu_copy);
      paramMenu.removeItem(R.id.select_action_menu_share);
      paramMenu.removeItem(R.id.select_action_menu_web_search);
    } else {
      if (!this.mEditable)
        paramMenu.removeItem(R.id.select_action_menu_cut); 
      if (this.mEditable || !isSelectActionModeAllowed(1))
        paramMenu.removeItem(R.id.select_action_menu_share); 
      if (this.mEditable || this.mWebContents.isIncognito() || !isSelectActionModeAllowed(2))
        paramMenu.removeItem(R.id.select_action_menu_web_search); 
      if (this.mIsPasswordType) {
        paramMenu.removeItem(R.id.select_action_menu_copy);
        paramMenu.removeItem(R.id.select_action_menu_cut);
      } 
    } 
    setPasteAsPlainTextMenuItemTitle(paramMenu);
    Context context = this.mWindowAndroid.getContext().get();
    if (this.mClassificationResult != null && this.mAdditionalMenuItemProvider != null && context != null)
      this.mAdditionalMenuItemProvider.addMenuItems(context, paramMenu, this.mClassificationResult.textClassification); 
    if (this.mHasSelection) {
      if (this.mIsPasswordType)
        return; 
      if (Build.VERSION.SDK_INT >= 23) {
        if (!isSelectActionModeAllowed(4))
          return; 
        List<ResolveInfo> list = this.mContext.getPackageManager().queryIntentActivities(createProcessTextIntent(), 0);
        for (int i = 0; i < list.size(); i++) {
          ResolveInfo resolveInfo = list.get(i);
          CharSequence charSequence = resolveInfo.loadLabel(this.mContext.getPackageManager());
          MenuItem menuItem = paramMenu.add(R.id.select_action_menu_text_processing_menus, 0, i + 100, charSequence);
          boolean bool = this.mEditable;
          menuItem.setIntent(createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", bool ^ true).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name)).setShowAsAction(1);
        } 
        return;
      } 
      return;
    } 
  }
  
  @TargetApi(23)
  private static Intent createProcessTextIntent() {
    return (new Intent()).setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
  }
  
  private void destroyActionModeAndKeepSelection() {
    this.mUnselectAllOnDismiss = false;
    finishActionMode();
  }
  
  private void finishActionMode() {
    this.mHidden = false;
    if (this.mView != null)
      this.mView.removeCallbacks(this.mRepeatingHideRunnable); 
    if (isActionModeValid()) {
      this.mActionMode.finish();
      this.mActionMode = null;
    } 
  }
  
  public static SelectionPopupControllerImpl fromWebContents(WebContents paramWebContents) {
    return (SelectionPopupControllerImpl)paramWebContents.getOrSetUserData(SelectionPopupControllerImpl.class, null);
  }
  
  @CalledByNative
  private Context getContext() {
    return this.mContext;
  }
  
  private float getDeviceScaleFactor() {
    return this.mWebContents.mRenderCoordinates.mDeviceScaleFactor;
  }
  
  private PopupController getPopupController() {
    if (this.mPopupController == null)
      this.mPopupController = PopupController.fromWebContents((WebContents)this.mWebContents); 
    return this.mPopupController;
  }
  
  private Rect getSelectionRectRelativeToContainingView() {
    float f = getDeviceScaleFactor();
    Rect rect = new Rect((int)(this.mSelectionRect.left * f), (int)(this.mSelectionRect.top * f), (int)(this.mSelectionRect.right * f), (int)(this.mSelectionRect.bottom * f));
    rect.offset(0, (int)this.mWebContents.mRenderCoordinates.mTopContentOffsetYPix);
    return rect;
  }
  
  private void hideActionModeTemporarily(long paramLong) {
    assert false;
    throw new AssertionError();
  }
  
  private void initHandleObserver() {
    MagnifierAnimator magnifierAnimator;
    ContentClassFactory.get();
    SelectionPopupControllerImpl$$Lambda$0 selectionPopupControllerImpl$$Lambda$0 = new SelectionPopupControllerImpl$$Lambda$0(this);
    if (Build.VERSION.SDK_INT < 28 || !ContentFeatureList.isEnabled("EnhancedSelectionInsertionHandle")) {
      selectionPopupControllerImpl$$Lambda$0 = null;
    } else {
      magnifierAnimator = new MagnifierAnimator(new MagnifierWrapperImpl(selectionPopupControllerImpl$$Lambda$0));
    } 
    this.mHandleObserver = magnifierAnimator;
  }
  
  public static void initializeMenu(Context paramContext, ActionMode paramActionMode, Menu paramMenu) {
    try {
      paramActionMode.getMenuInflater().inflate(R.menu.select_action_menu, paramMenu);
      return;
    } catch (android.content.res.Resources.NotFoundException notFoundException) {
      (new MenuInflater(paramContext)).inflate(R.menu.select_action_menu, paramMenu);
      return;
    } 
  }
  
  private boolean isActionModeSupported() {
    return (this.mCallback != EMPTY_CALLBACK);
  }
  
  private boolean isFloatingActionMode() {
    return (supportsFloatingActionMode() && isActionModeValid() && this.mActionMode.getType() == 1);
  }
  
  private boolean isPastePopupShowing() {
    return (this.mPastePopupMenu != null);
  }
  
  private boolean isSelectActionModeAllowed(int paramInt) {
    boolean bool;
    if ((this.mAllowedMenuItems & paramInt) != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (paramInt == 1) {
      if (bool) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (this.mContext.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        } 
        if (paramInt != 0)
          return true; 
      } 
      return false;
    } 
    return bool;
  }
  
  private native long nativeInit(WebContents paramWebContents);
  
  private native void nativeSetTextHandlesTemporarilyHidden(long paramLong, boolean paramBoolean);
  
  @CalledByNative
  private void onSelectWordAroundCaretAck(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  @CalledByNative
  private void onSelectionChanged(String paramString) {
    if (paramString.length() == 0 && this.mHasSelection && this.mSelectionMetricsLogger != null)
      this.mSelectionMetricsLogger.logSelectionAction(this.mLastSelectedText, this.mLastSelectionOffset, 107, null); 
    this.mLastSelectedText = paramString;
  }
  
  public static String sanitizeQuery(String paramString, int paramInt) {
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.length() < paramInt)
        return paramString; 
      StringBuilder stringBuilder = new StringBuilder("Truncating oversized query (");
      stringBuilder.append(paramString.length());
      stringBuilder.append(").");
      Log.w("SelectionPopupCtlr", stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramString.substring(0, paramInt));
      stringBuilder.append("…");
      return stringBuilder.toString();
    } 
    return paramString;
  }
  
  @TargetApi(26)
  public static void setPasteAsPlainTextMenuItemTitle(Menu paramMenu) {
    MenuItem menuItem = paramMenu.findItem(R.id.select_action_menu_paste_as_plain_text);
    if (menuItem == null)
      return; 
    assert false;
    throw new AssertionError();
  }
  
  private void showPastePopup() {
    try {
      this.mPastePopupMenu.show(getSelectionRectRelativeToContainingView());
      return;
    } catch (android.view.WindowManager.BadTokenException badTokenException) {
      return;
    } 
  }
  
  private static boolean supportsFloatingActionMode() {
    return (Build.VERSION.SDK_INT >= 23);
  }
  
  private void updateTextSelectionUI(boolean paramBoolean) {
    if (this.mNativeSelectionPopupController != 0L)
      nativeSetTextHandlesTemporarilyHidden(this.mNativeSelectionPopupController, paramBoolean ^ true); 
    if (paramBoolean) {
      restoreSelectionPopupsIfNecessary();
      return;
    } 
    destroyActionModeAndKeepSelection();
    getPopupController().hideAllPopups();
  }
  
  public final boolean canPasteAsPlainText() {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i < 26)
      return false; 
    if (!this.mCanEditRichly)
      return false; 
    ClipboardManager clipboardManager = (ClipboardManager)this.mContext.getSystemService("clipboard");
    if (!clipboardManager.hasPrimaryClip())
      return false; 
    ClipData clipData = clipboardManager.getPrimaryClip();
    ClipDescription clipDescription = clipData.getDescription();
    CharSequence charSequence = clipData.getItemAt(0).getText();
    if (clipDescription.hasMimeType("text/plain") && charSequence instanceof Spanned) {
      Spanned spanned = (Spanned)charSequence;
      i = 0;
      while (true) {
        if (i < 3) {
          (new Class[3])[0] = CharacterStyle.class;
          (new Class[3])[1] = ParagraphStyle.class;
          (new Class[3])[2] = UpdateAppearance.class;
          Class clazz = (new Class[3])[i];
          if (spanned.nextSpanTransition(-1, spanned.length(), clazz) < spanned.length()) {
            i = 1;
            break;
          } 
          i++;
          continue;
        } 
        i = bool;
        break;
      } 
      if (i != 0)
        return true; 
    } 
    return clipDescription.hasMimeType("text/html");
  }
  
  public final void destroyActionModeAndUnselect() {
    this.mUnselectAllOnDismiss = true;
    finishActionMode();
  }
  
  public final void destroyPastePopup() {
    if (isPastePopupShowing()) {
      this.mPastePopupMenu.hide();
      this.mPastePopupMenu = null;
    } 
  }
  
  public final ActionModeCallbackHelper getActionModeCallbackHelper() {
    return this;
  }
  
  public final SelectionClient.ResultCallback getResultCallback() {
    return this.mResultCallback;
  }
  
  public final String getSelectedText() {
    return this.mLastSelectedText;
  }
  
  public final TextClassifier getTextClassifier() {
    assert false;
    throw new AssertionError();
  }
  
  public final void hide() {
    destroyPastePopup();
  }
  
  public final void hideActionMode(boolean paramBoolean) {
    if (!isFloatingActionMode())
      return; 
    if (this.mHidden == paramBoolean)
      return; 
    this.mHidden = paramBoolean;
    if (this.mHidden) {
      this.mRepeatingHideRunnable.run();
      return;
    } 
    this.mView.removeCallbacks(this.mRepeatingHideRunnable);
    hideActionModeTemporarily(300L);
  }
  
  @CalledByNative
  public void hidePopupsAndPreserveSelection() {
    destroyActionModeAndKeepSelection();
    getPopupController().hideAllPopups();
  }
  
  public final boolean isActionModeValid() {
    return (this.mActionMode != null);
  }
  
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem) {
    String str;
    if (!isActionModeValid())
      return true; 
    int i = paramMenuItem.getItemId();
    int j = paramMenuItem.getGroupId();
    if (this.mHasSelection && this.mSelectionMetricsLogger != null) {
      SmartSelectionMetricsLogger smartSelectionMetricsLogger = this.mSelectionMetricsLogger;
      String str1 = this.mLastSelectedText;
      int k = this.mLastSelectionOffset;
      char c = 'i';
      if (j != 16908353)
        if (i == R.id.select_action_menu_select_all) {
          c = 'È';
        } else if (i == R.id.select_action_menu_cut) {
          c = 'g';
        } else if (i == R.id.select_action_menu_copy) {
          c = 'e';
        } else if (i == R.id.select_action_menu_paste || i == R.id.select_action_menu_paste_as_plain_text) {
          c = 'f';
        } else if (i == R.id.select_action_menu_share) {
          c = 'h';
        } else if (i != 16908353) {
          c = 'l';
        }  
      smartSelectionMetricsLogger.logSelectionAction(str1, k, c, this.mClassificationResult);
    } 
    if (j == R.id.select_action_menu_assist_items && i == 16908353) {
      if (this.mClassificationResult != null && this.mClassificationResult.hasNamedAction()) {
        assert false;
        throw new AssertionError();
      } 
      paramActionMode.finish();
      return true;
    } 
    if (i == R.id.select_action_menu_select_all) {
      selectAll();
      return true;
    } 
    if (i == R.id.select_action_menu_cut) {
      this.mWebContents.cut();
      paramActionMode.finish();
      return true;
    } 
    if (i == R.id.select_action_menu_copy) {
      this.mWebContents.copy();
      paramActionMode.finish();
      return true;
    } 
    if (i == R.id.select_action_menu_paste) {
      this.mWebContents.paste();
      paramActionMode.finish();
      return true;
    } 
    if (Build.VERSION.SDK_INT >= 26 && i == R.id.select_action_menu_paste_as_plain_text) {
      pasteAsPlainText();
      paramActionMode.finish();
      return true;
    } 
    if (i == R.id.select_action_menu_share) {
      RecordUserAction.record("MobileActionMode.Share");
      str = sanitizeQuery(this.mLastSelectedText, 100000);
      if (!TextUtils.isEmpty(str)) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        try {
          Intent intent1 = Intent.createChooser(intent, this.mContext.getString(R.string.actionbar_share));
          intent1.setFlags(268435456);
          this.mContext.startActivity(intent1);
        } catch (ActivityNotFoundException null) {}
      } 
      paramActionMode.finish();
      return true;
    } 
    if (i == R.id.select_action_menu_web_search) {
      RecordUserAction.record("MobileActionMode.WebSearch");
      str = sanitizeQuery(this.mLastSelectedText, 1000);
      if (!TextUtils.isEmpty(str)) {
        Intent intent = new Intent("android.intent.action.WEB_SEARCH");
        intent.putExtra("new_search", true);
        intent.putExtra("query", str);
        intent.putExtra("com.android.browser.application_id", this.mContext.getPackageName());
        intent.addFlags(268435456);
        try {
          this.mContext.startActivity(intent);
        } catch (ActivityNotFoundException activityNotFoundException2) {}
      } 
      paramActionMode.finish();
      return true;
    } 
    if (j == R.id.select_action_menu_text_processing_menus) {
      Intent intent = activityNotFoundException2.getIntent();
      RecordUserAction.record("MobileActionMode.ProcessTextIntent");
      assert false;
      throw new AssertionError();
    } 
    if (j == 16908353) {
      if (this.mAdditionalMenuItemProvider != null) {
        this.mAdditionalMenuItemProvider.performAction((MenuItem)str, this.mView);
        activityNotFoundException1.finish();
      } 
      return true;
    } 
    return false;
  }
  
  public final void onAttachedToWindow() {
    updateTextSelectionUI(true);
  }
  
  public final void onBeforeSendKeyEvent(KeyEvent paramKeyEvent) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreateActionMode(ActionMode paramActionMode, Menu paramMenu) {
    CharSequence charSequence;
    if (DeviceFormFactor.isWindowOnTablet(this.mWindowAndroid)) {
      charSequence = this.mContext.getString(R.string.actionbar_textselection_title);
    } else {
      charSequence = null;
    } 
    paramActionMode.setTitle(charSequence);
    paramActionMode.setSubtitle(null);
    createActionMenu(paramActionMode, paramMenu);
  }
  
  public final void onDIPScaleChanged(float paramFloat) {}
  
  public final void onDestroyActionMode() {
    this.mActionMode = null;
    if (this.mUnselectAllOnDismiss)
      clearSelection(); 
  }
  
  public final void onDetachedFromWindow() {
    updateTextSelectionUI(false);
  }
  
  @CalledByNative
  void onDragUpdate(float paramFloat1, float paramFloat2) {
    if (this.mHandleObserver != null) {
      float f1 = getDeviceScaleFactor();
      float f2 = this.mWebContents.mRenderCoordinates.mTopContentOffsetYPix;
      this.mHandleObserver.handleDragStartedOrMoved(paramFloat1 * f1, paramFloat2 * f1 + f2);
    } 
  }
  
  public final void onGetContentRect$4c31e730(Rect paramRect) {
    paramRect.set(getSelectionRectRelativeToContainingView());
  }
  
  public final void onImeEvent() {}
  
  public final void onNodeAttributeUpdated(boolean paramBoolean1, boolean paramBoolean2) {
    if (!paramBoolean1)
      destroyPastePopup(); 
    if (paramBoolean1 != this.mEditable || paramBoolean2 != this.mIsPasswordType) {
      this.mEditable = paramBoolean1;
      this.mIsPasswordType = paramBoolean2;
      if (isActionModeValid())
        this.mActionMode.invalidate(); 
    } 
  }
  
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu) {
    if (this.mAdditionalMenuItemProvider != null)
      this.mAdditionalMenuItemProvider.clearMenuItemListeners(); 
    paramMenu.removeGroup(R.id.select_action_menu_default_items);
    paramMenu.removeGroup(R.id.select_action_menu_assist_items);
    paramMenu.removeGroup(R.id.select_action_menu_text_processing_menus);
    paramMenu.removeGroup(16908353);
    createActionMenu(paramActionMode, paramMenu);
    return true;
  }
  
  public final void onReceivedProcessTextResult(int paramInt, Intent paramIntent) {
    if (this.mWebContents != null && paramInt == -1) {
      if (paramIntent == null)
        return; 
      if (this.mHasSelection) {
        if (!this.mEditable)
          return; 
        CharSequence charSequence = paramIntent.getCharSequenceExtra("android.intent.extra.PROCESS_TEXT");
        if (charSequence != null) {
          WebContentsImpl webContentsImpl = this.mWebContents;
          charSequence = charSequence.toString();
          webContentsImpl.nativeReplace(webContentsImpl.mNativeWebContentsAndroid, (String)charSequence);
        } 
        return;
      } 
      return;
    } 
  }
  
  public final void onRotationChanged(int paramInt) {
    if (Build.VERSION.SDK_INT >= 23 && isActionModeValid()) {
      hidePopupsAndPreserveSelection();
      showActionModeOrClearOnFailure();
    } 
  }
  
  @CalledByNative
  void onSelectionEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int i = paramInt4;
    if (paramInt2 == paramInt4)
      i = paramInt4 + 1; 
    paramInt4 = paramInt5;
    if (paramInt3 == paramInt5)
      paramInt4 = paramInt5 + 1; 
    switch (paramInt1) {
      default:
        assert false;
        throw new AssertionError("Invalid selection event type.");
      case 10:
        if (this.mWasPastePopupShowingOnInsertionDragStart)
          this.mWebContents.showContextMenuAtTouchHandle(this.mSelectionRect.left, this.mSelectionRect.bottom); 
        this.mWasPastePopupShowingOnInsertionDragStart = false;
        if (this.mHandleObserver != null)
          this.mHandleObserver.handleDragStopped(); 
        break;
      case 9:
        this.mWasPastePopupShowingOnInsertionDragStart = isPastePopupShowing();
        destroyPastePopup();
        break;
      case 8:
        destroyPastePopup();
        if (!this.mHasSelection)
          this.mSelectionRect.setEmpty(); 
        break;
      case 7:
        if (this.mWasPastePopupShowingOnInsertionDragStart) {
          destroyPastePopup();
        } else {
          this.mWebContents.showContextMenuAtTouchHandle(this.mSelectionRect.left, this.mSelectionRect.bottom);
        } 
        this.mWasPastePopupShowingOnInsertionDragStart = false;
        break;
      case 6:
        this.mSelectionRect.set(paramInt2, paramInt3, i, paramInt4);
        if (!GestureListenerManagerImpl.fromWebContents((WebContents)this.mWebContents).isScrollInProgress() && isPastePopupShowing()) {
          showPastePopup();
          break;
        } 
        destroyPastePopup();
        break;
      case 5:
        this.mSelectionRect.set(paramInt2, paramInt3, i, paramInt4);
        break;
      case 4:
        this.mWebContents.showContextMenuAtTouchHandle(paramInt2, paramInt4);
        if (this.mHandleObserver != null)
          this.mHandleObserver.handleDragStopped(); 
        break;
      case 3:
        hideActionMode(true);
        break;
      case 2:
        this.mLastSelectedText = "";
        this.mLastSelectionOffset = 0;
        this.mHasSelection = false;
        this.mUnselectAllOnDismiss = false;
        this.mSelectionRect.setEmpty();
        if (this.mSelectionClient != null)
          this.mSelectionClient.cancelAllRequests(); 
        finishActionMode();
        break;
      case 1:
        this.mSelectionRect.set(paramInt2, paramInt3, i, paramInt4);
        if (supportsFloatingActionMode() && isActionModeValid())
          this.mActionMode.invalidateContentRect(); 
        break;
      case 0:
        break;
    } 
    if (this.mSelectionClient != null) {
      getDeviceScaleFactor();
      paramInt1 = this.mSelectionRect.left;
      paramInt1 = this.mSelectionRect.bottom;
    } 
  }
  
  public final void onUpdateContainerView(ViewGroup paramViewGroup) {
    assert false;
    throw new AssertionError();
  }
  
  public final void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2) {
    if (paramBoolean1) {
      restoreSelectionPopupsIfNecessary();
      return;
    } 
    (ImeAdapterImpl.fromWebContents((WebContents)this.mWebContents)).mFocusPreOSKViewportRect.setEmpty();
    if (this.mPreserveSelectionOnNextLossOfFocus) {
      this.mPreserveSelectionOnNextLossOfFocus = false;
      hidePopupsAndPreserveSelection();
      return;
    } 
    destroyActionModeAndUnselect();
    this.mWebContents.dismissTextHandles();
    PopupController.hideAll((WebContents)this.mWebContents);
    clearSelection();
  }
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {
    this.mWindowAndroid = paramWindowAndroid;
    initHandleObserver();
    destroyPastePopup();
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    if (supportsFloatingActionMode() && isActionModeValid())
      this.mActionMode.onWindowFocusChanged(paramBoolean); 
  }
  
  final void pasteAsPlainText() {
    WebContentsImpl webContentsImpl = this.mWebContents;
    webContentsImpl.nativePasteAsPlainText(webContentsImpl.mNativeWebContentsAndroid);
  }
  
  public final void restoreSelectionPopupsIfNecessary() {
    if (this.mHasSelection && !isActionModeValid())
      showActionModeOrClearOnFailure(); 
  }
  
  public final void selectAll() {
    this.mWebContents.selectAll();
    this.mClassificationResult = null;
    if (this.mEditable) {
      RecordUserAction.record("MobileActionMode.SelectAllWasEditable");
      return;
    } 
    RecordUserAction.record("MobileActionMode.SelectAllWasNonEditable");
  }
  
  public final void setActionModeCallback(ActionMode.Callback paramCallback) {
    this.mCallback = paramCallback;
  }
  
  public final void setAllowedMenuItems(int paramInt) {
    this.mAllowedMenuItems = paramInt;
  }
  
  public final void setNonSelectionActionModeCallback(ActionMode.Callback paramCallback) {
    this.mNonSelectionCallback = paramCallback;
  }
  
  public final void setSelectionClient(SelectionClient paramSelectionClient) {
    this.mSelectionClient = paramSelectionClient;
    if (this.mSelectionClient != null)
      this.mSelectionMetricsLogger = (SmartSelectionMetricsLogger)this.mSelectionClient.getSelectionMetricsLogger(); 
    this.mClassificationResult = null;
    assert false;
  }
  
  public final void setTextClassifier(TextClassifier paramTextClassifier) {
    assert false;
    throw new AssertionError();
  }
  
  public final void showActionModeOrClearOnFailure() {
    if (isActionModeSupported()) {
      if (!this.mHasSelection)
        return; 
      if (isActionModeValid() && !isFloatingActionMode()) {
        try {
          this.mActionMode.invalidate();
        } catch (NullPointerException nullPointerException) {
          Log.w("SelectionPopupCtlr", "Ignoring NPE from ActionMode.invalidate() as workaround for L", new Object[] { nullPointerException });
        } 
        hideActionMode(false);
        return;
      } 
      destroyActionModeAndKeepSelection();
      assert false;
      throw new AssertionError();
    } 
  }
  
  @CalledByNative
  public void showSelectionMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt7) {
    boolean bool;
    int i = paramInt4;
    if (supportsFloatingActionMode())
      i = paramInt4 + paramInt5; 
    this.mSelectionRect.set(paramInt1, paramInt2, paramInt3, i);
    this.mEditable = paramBoolean1;
    this.mLastSelectedText = paramString;
    this.mLastSelectionOffset = paramInt6;
    if (paramString.length() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.mHasSelection = bool;
    this.mIsPasswordType = paramBoolean2;
    this.mCanSelectAllForPastePopup = paramBoolean3;
    this.mCanEditRichly = paramBoolean4;
    this.mUnselectAllOnDismiss = true;
    if (this.mHasSelection) {
      paramInt1 = ApiCompatibilityUtils.isDeviceProvisioned(this.mContext) ^ true | this.mWebContents.isIncognito();
      if (paramInt1 == 0 && this.mSelectionMetricsLogger != null && paramInt7 != 7) {
        SmartSelectionMetricsLogger smartSelectionMetricsLogger;
        String str;
        switch (paramInt7) {
          default:
            smartSelectionMetricsLogger = this.mSelectionMetricsLogger;
            str = this.mLastSelectedText;
            paramInt2 = this.mLastSelectionOffset;
            smartSelectionMetricsLogger.mTracker = SmartSelectionMetricsLogger.createTracker(smartSelectionMetricsLogger.mContext, paramBoolean1);
            smartSelectionMetricsLogger.mConverter = new SelectionIndicesConverter();
            smartSelectionMetricsLogger.mConverter.updateSelectionState(str, paramInt2);
            smartSelectionMetricsLogger.mConverter.mInitialStartOffset = paramInt2;
            smartSelectionMetricsLogger.logEvent(smartSelectionMetricsLogger.mSelectionEventProxy.createSelectionStarted(0));
            break;
          case 10:
            this.mSelectionMetricsLogger.logSelectionAction(this.mLastSelectedText, this.mLastSelectionOffset, 201, null);
            break;
          case 9:
            this.mSelectionMetricsLogger.logSelectionModified(this.mLastSelectedText, this.mLastSelectionOffset, this.mClassificationResult);
            break;
        } 
      } 
      if (paramInt1 == 0 && paramInt7 == 9) {
        showActionModeOrClearOnFailure();
        return;
      } 
      if (paramInt1 != 0 || this.mSelectionClient == null || !this.mSelectionClient.requestSelectionPopupUpdates(paramBoolean5))
        showActionModeOrClearOnFailure(); 
      return;
    } 
    if (this.mView.getParent() != null) {
      if (this.mView.getVisibility() != 0)
        return; 
      if (supportsFloatingActionMode() || canPaste() || this.mNonSelectionCallback != null) {
        destroyPastePopup();
        SelectionPopupControllerImpl$2 selectionPopupControllerImpl$2 = new SelectionPopupControllerImpl$2(this);
        Context context = this.mWindowAndroid.getContext().get();
        if (context != null) {
          if (supportsFloatingActionMode()) {
            this.mPastePopupMenu = new FloatingPastePopupMenu(context, this.mView, selectionPopupControllerImpl$2, this.mNonSelectionCallback);
          } else {
            this.mPastePopupMenu = new LegacyPastePopupMenu(context, this.mView, selectionPopupControllerImpl$2);
          } 
          showPastePopup();
        } 
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\selection\SelectionPopupControllerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */