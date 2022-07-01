package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.CollapsibleActionView;
import android.view.View;
import android.widget.ImageView;

public final class SearchView extends LinearLayoutCompat implements CollapsibleActionView {
  static final SearchView$AutoCompleteTextViewReflector HIDDEN_METHOD_INVOKER = new SearchView$AutoCompleteTextViewReflector();
  
  private boolean mClearingFocus;
  
  private ImageView mCloseButton;
  
  private final ImageView mCollapsedIcon;
  
  private int mCollapsedImeOptions;
  
  private boolean mExpandedInActionView;
  
  private ImageView mGoButton;
  
  private boolean mIconified;
  
  private boolean mIconifiedByDefault;
  
  private int mMaxWidth;
  
  private View.OnClickListener mOnSearchClickListener;
  
  private Runnable mReleaseCursorRunnable;
  
  private ImageView mSearchButton;
  
  private final View mSearchEditFrame;
  
  private SearchView$SearchAutoComplete mSearchSrcTextView;
  
  private Rect mSearchSrcTextViewBounds;
  
  private Rect mSearchSrtTextViewBoundsExpanded;
  
  private final View mSubmitArea;
  
  private boolean mSubmitButtonEnabled;
  
  private int[] mTemp;
  
  private int[] mTemp2;
  
  private SearchView$UpdatableTouchDelegate mTouchDelegate;
  
  private final Runnable mUpdateDrawableStateRunnable;
  
  private ImageView mVoiceButton;
  
  private boolean mVoiceButtonEnabled;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private int getPreferredHeight() {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
  }
  
  private int getPreferredWidth() {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
  }
  
  static boolean isLandscapeMode(Context paramContext) {
    return ((paramContext.getResources().getConfiguration()).orientation == 2);
  }
  
  private boolean isSubmitAreaEnabled() {
    return ((this.mSubmitButtonEnabled || this.mVoiceButtonEnabled) && !this.mIconified);
  }
  
  private void postUpdateFocusedState() {
    post(this.mUpdateDrawableStateRunnable);
  }
  
  private void updateViewsVisibility(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: putfield mIconified : Z
    //   5: bipush #8
    //   7: istore_3
    //   8: iload_1
    //   9: ifeq -> 17
    //   12: iconst_0
    //   13: istore_2
    //   14: goto -> 20
    //   17: bipush #8
    //   19: istore_2
    //   20: aload_0
    //   21: getfield mSearchSrcTextView : Landroid/support/v7/widget/SearchView$SearchAutoComplete;
    //   24: invokevirtual getText : ()Landroid/text/Editable;
    //   27: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   30: istore #7
    //   32: iconst_1
    //   33: istore #4
    //   35: iload #7
    //   37: iconst_1
    //   38: ixor
    //   39: istore #5
    //   41: aload_0
    //   42: getfield mSearchButton : Landroid/widget/ImageView;
    //   45: iload_2
    //   46: invokevirtual setVisibility : (I)V
    //   49: aload_0
    //   50: getfield mSubmitButtonEnabled : Z
    //   53: ifeq -> 87
    //   56: aload_0
    //   57: invokespecial isSubmitAreaEnabled : ()Z
    //   60: ifeq -> 87
    //   63: aload_0
    //   64: invokevirtual hasFocus : ()Z
    //   67: ifeq -> 87
    //   70: iload #5
    //   72: ifne -> 82
    //   75: aload_0
    //   76: getfield mVoiceButtonEnabled : Z
    //   79: ifne -> 87
    //   82: iconst_0
    //   83: istore_2
    //   84: goto -> 90
    //   87: bipush #8
    //   89: istore_2
    //   90: aload_0
    //   91: getfield mGoButton : Landroid/widget/ImageView;
    //   94: iload_2
    //   95: invokevirtual setVisibility : (I)V
    //   98: aload_0
    //   99: getfield mSearchEditFrame : Landroid/view/View;
    //   102: astore #8
    //   104: iload_1
    //   105: ifeq -> 114
    //   108: bipush #8
    //   110: istore_2
    //   111: goto -> 116
    //   114: iconst_0
    //   115: istore_2
    //   116: aload #8
    //   118: iload_2
    //   119: invokevirtual setVisibility : (I)V
    //   122: aload_0
    //   123: getfield mCollapsedIcon : Landroid/widget/ImageView;
    //   126: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   129: ifnull -> 147
    //   132: aload_0
    //   133: getfield mIconifiedByDefault : Z
    //   136: ifeq -> 142
    //   139: goto -> 147
    //   142: iconst_0
    //   143: istore_2
    //   144: goto -> 150
    //   147: bipush #8
    //   149: istore_2
    //   150: aload_0
    //   151: getfield mCollapsedIcon : Landroid/widget/ImageView;
    //   154: iload_2
    //   155: invokevirtual setVisibility : (I)V
    //   158: aload_0
    //   159: getfield mSearchSrcTextView : Landroid/support/v7/widget/SearchView$SearchAutoComplete;
    //   162: invokevirtual getText : ()Landroid/text/Editable;
    //   165: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   168: iconst_1
    //   169: ixor
    //   170: istore #6
    //   172: iload #6
    //   174: ifne -> 199
    //   177: aload_0
    //   178: getfield mIconifiedByDefault : Z
    //   181: ifeq -> 194
    //   184: aload_0
    //   185: getfield mExpandedInActionView : Z
    //   188: ifne -> 194
    //   191: goto -> 199
    //   194: iconst_0
    //   195: istore_2
    //   196: goto -> 201
    //   199: iconst_1
    //   200: istore_2
    //   201: aload_0
    //   202: getfield mCloseButton : Landroid/widget/ImageView;
    //   205: astore #8
    //   207: iload_2
    //   208: ifeq -> 216
    //   211: iconst_0
    //   212: istore_2
    //   213: goto -> 219
    //   216: bipush #8
    //   218: istore_2
    //   219: aload #8
    //   221: iload_2
    //   222: invokevirtual setVisibility : (I)V
    //   225: aload_0
    //   226: getfield mCloseButton : Landroid/widget/ImageView;
    //   229: invokevirtual getDrawable : ()Landroid/graphics/drawable/Drawable;
    //   232: astore #9
    //   234: aload #9
    //   236: ifnull -> 265
    //   239: iload #6
    //   241: ifeq -> 252
    //   244: getstatic android/support/v7/widget/SearchView.ENABLED_STATE_SET : [I
    //   247: astore #8
    //   249: goto -> 257
    //   252: getstatic android/support/v7/widget/SearchView.EMPTY_STATE_SET : [I
    //   255: astore #8
    //   257: aload #9
    //   259: aload #8
    //   261: invokevirtual setState : ([I)Z
    //   264: pop
    //   265: iload #5
    //   267: ifne -> 276
    //   270: iload #4
    //   272: istore_2
    //   273: goto -> 278
    //   276: iconst_0
    //   277: istore_2
    //   278: aload_0
    //   279: getfield mVoiceButtonEnabled : Z
    //   282: ifeq -> 310
    //   285: aload_0
    //   286: getfield mIconified : Z
    //   289: ifne -> 310
    //   292: iload_2
    //   293: ifeq -> 310
    //   296: aload_0
    //   297: getfield mGoButton : Landroid/widget/ImageView;
    //   300: bipush #8
    //   302: invokevirtual setVisibility : (I)V
    //   305: iconst_0
    //   306: istore_2
    //   307: goto -> 313
    //   310: bipush #8
    //   312: istore_2
    //   313: aload_0
    //   314: getfield mVoiceButton : Landroid/widget/ImageView;
    //   317: iload_2
    //   318: invokevirtual setVisibility : (I)V
    //   321: iload_3
    //   322: istore_2
    //   323: aload_0
    //   324: invokespecial isSubmitAreaEnabled : ()Z
    //   327: ifeq -> 354
    //   330: aload_0
    //   331: getfield mGoButton : Landroid/widget/ImageView;
    //   334: invokevirtual getVisibility : ()I
    //   337: ifeq -> 352
    //   340: iload_3
    //   341: istore_2
    //   342: aload_0
    //   343: getfield mVoiceButton : Landroid/widget/ImageView;
    //   346: invokevirtual getVisibility : ()I
    //   349: ifne -> 354
    //   352: iconst_0
    //   353: istore_2
    //   354: aload_0
    //   355: getfield mSubmitArea : Landroid/view/View;
    //   358: iload_2
    //   359: invokevirtual setVisibility : (I)V
    //   362: return
  }
  
  public final void clearFocus() {
    this.mClearingFocus = true;
    super.clearFocus();
    this.mSearchSrcTextView.clearFocus();
    SearchView$SearchAutoComplete.access$000(this.mSearchSrcTextView, false);
    this.mClearingFocus = false;
  }
  
  public final void onActionViewCollapsed() {
    this.mSearchSrcTextView.setText("");
    this.mSearchSrcTextView.setSelection(this.mSearchSrcTextView.length());
    clearFocus();
    updateViewsVisibility(true);
    this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions);
    this.mExpandedInActionView = false;
  }
  
  public final void onActionViewExpanded() {
    if (this.mExpandedInActionView)
      return; 
    this.mExpandedInActionView = true;
    this.mCollapsedImeOptions = this.mSearchSrcTextView.getImeOptions();
    this.mSearchSrcTextView.setImeOptions(this.mCollapsedImeOptions | 0x2000000);
    this.mSearchSrcTextView.setText("");
    updateViewsVisibility(false);
    this.mSearchSrcTextView.requestFocus();
    SearchView$SearchAutoComplete.access$000(this.mSearchSrcTextView, true);
    if (this.mOnSearchClickListener != null)
      this.mOnSearchClickListener.onClick((View)this); 
  }
  
  protected final void onDetachedFromWindow() {
    removeCallbacks(this.mUpdateDrawableStateRunnable);
    post(this.mReleaseCursorRunnable);
    super.onDetachedFromWindow();
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean) {
      SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
      Rect rect = this.mSearchSrcTextViewBounds;
      searchView$SearchAutoComplete.getLocationInWindow(this.mTemp);
      getLocationInWindow(this.mTemp2);
      paramInt1 = this.mTemp[1] - this.mTemp2[1];
      paramInt3 = this.mTemp[0] - this.mTemp2[0];
      rect.set(paramInt3, paramInt1, searchView$SearchAutoComplete.getWidth() + paramInt3, searchView$SearchAutoComplete.getHeight() + paramInt1);
      this.mSearchSrtTextViewBoundsExpanded.set(this.mSearchSrcTextViewBounds.left, 0, this.mSearchSrcTextViewBounds.right, paramInt4 - paramInt2);
      if (this.mTouchDelegate == null) {
        this.mTouchDelegate = new SearchView$UpdatableTouchDelegate(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds, (View)this.mSearchSrcTextView);
        setTouchDelegate(this.mTouchDelegate);
        return;
      } 
      this.mTouchDelegate.setBounds(this.mSearchSrtTextViewBoundsExpanded, this.mSearchSrcTextViewBounds);
    } 
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2) {
    if (this.mIconified) {
      super.onMeasure(paramInt1, paramInt2);
      return;
    } 
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j != Integer.MIN_VALUE) {
      if (j != 0) {
        if (j != 1073741824) {
          paramInt1 = i;
        } else {
          paramInt1 = i;
          if (this.mMaxWidth > 0)
            paramInt1 = Math.min(this.mMaxWidth, i); 
        } 
      } else if (this.mMaxWidth > 0) {
        paramInt1 = this.mMaxWidth;
      } else {
        paramInt1 = getPreferredWidth();
      } 
    } else if (this.mMaxWidth > 0) {
      paramInt1 = Math.min(this.mMaxWidth, i);
    } else {
      paramInt1 = Math.min(getPreferredWidth(), i);
    } 
    i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE) {
      if (i == 0)
        paramInt2 = getPreferredHeight(); 
    } else {
      paramInt2 = Math.min(getPreferredHeight(), paramInt2);
    } 
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SearchView$SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SearchView$SavedState searchView$SavedState = (SearchView$SavedState)paramParcelable;
    super.onRestoreInstanceState(searchView$SavedState.mSuperState);
    updateViewsVisibility(searchView$SavedState.isIconified);
    requestLayout();
  }
  
  protected final Parcelable onSaveInstanceState() {
    SearchView$SavedState searchView$SavedState = new SearchView$SavedState(super.onSaveInstanceState());
    searchView$SavedState.isIconified = this.mIconified;
    return (Parcelable)searchView$SavedState;
  }
  
  final void onTextFocusChanged() {
    updateViewsVisibility(this.mIconified);
    postUpdateFocusedState();
    if (this.mSearchSrcTextView.hasFocus()) {
      SearchView$AutoCompleteTextViewReflector searchView$AutoCompleteTextViewReflector = HIDDEN_METHOD_INVOKER;
      SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
      if (searchView$AutoCompleteTextViewReflector.doBeforeTextChanged != null)
        try {
          searchView$AutoCompleteTextViewReflector.doBeforeTextChanged.invoke(searchView$SearchAutoComplete, new Object[0]);
        } catch (Exception exception) {} 
      searchView$AutoCompleteTextViewReflector = HIDDEN_METHOD_INVOKER;
      searchView$SearchAutoComplete = this.mSearchSrcTextView;
      if (searchView$AutoCompleteTextViewReflector.doAfterTextChanged != null)
        try {
          searchView$AutoCompleteTextViewReflector.doAfterTextChanged.invoke(searchView$SearchAutoComplete, new Object[0]);
          return;
        } catch (Exception exception) {} 
    } 
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    postUpdateFocusedState();
  }
  
  public final boolean requestFocus(int paramInt, Rect paramRect) {
    if (this.mClearingFocus)
      return false; 
    if (!isFocusable())
      return false; 
    if (!this.mIconified) {
      boolean bool = this.mSearchSrcTextView.requestFocus(paramInt, paramRect);
      if (bool)
        updateViewsVisibility(false); 
      return bool;
    } 
    return super.requestFocus(paramInt, paramRect);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */