package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ForwardingListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ActionMenuItemView extends AppCompatTextView implements MenuView$ItemView, ActionMenuView.ActionMenuChildView, View.OnClickListener {
  private boolean mAllowTextWithIcon;
  
  private boolean mExpandedFormat;
  
  private ForwardingListener mForwardingListener;
  
  private Drawable mIcon;
  
  MenuItemImpl mItemData;
  
  public MenuBuilder$ItemInvoker mItemInvoker;
  
  private int mMaxIconSize;
  
  private int mMinWidth;
  
  public ActionMenuItemView$PopupCallback mPopupCallback;
  
  private int mSavedPaddingLeft;
  
  private CharSequence mTitle;
  
  public ActionMenuItemView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    Resources resources = paramContext.getResources();
    this.mAllowTextWithIcon = shouldAllowTextWithIcon();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMenuItemView, paramInt, 0);
    this.mMinWidth = typedArray.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
    typedArray.recycle();
    this.mMaxIconSize = (int)((resources.getDisplayMetrics()).density * 32.0F + 0.5F);
    setOnClickListener(this);
    this.mSavedPaddingLeft = -1;
    setSaveEnabled(false);
  }
  
  private boolean shouldAllowTextWithIcon() {
    Configuration configuration = getContext().getResources().getConfiguration();
    int i = configuration.screenWidthDp;
    int j = configuration.screenHeightDp;
    return (i >= 480 || (i >= 640 && j >= 480) || configuration.orientation == 2);
  }
  
  private void updateTextButtonVisibility() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mTitle : Ljava/lang/CharSequence;
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore_3
    //   8: iconst_1
    //   9: istore_2
    //   10: iload_2
    //   11: istore_1
    //   12: aload_0
    //   13: getfield mIcon : Landroid/graphics/drawable/Drawable;
    //   16: ifnull -> 66
    //   19: aload_0
    //   20: getfield mItemData : Landroid/support/v7/view/menu/MenuItemImpl;
    //   23: getfield mShowAsAction : I
    //   26: iconst_4
    //   27: iand
    //   28: iconst_4
    //   29: if_icmpne -> 37
    //   32: iconst_1
    //   33: istore_1
    //   34: goto -> 39
    //   37: iconst_0
    //   38: istore_1
    //   39: iload_1
    //   40: ifeq -> 64
    //   43: iload_2
    //   44: istore_1
    //   45: aload_0
    //   46: getfield mAllowTextWithIcon : Z
    //   49: ifne -> 66
    //   52: aload_0
    //   53: getfield mExpandedFormat : Z
    //   56: ifeq -> 64
    //   59: iload_2
    //   60: istore_1
    //   61: goto -> 66
    //   64: iconst_0
    //   65: istore_1
    //   66: iload_3
    //   67: iconst_1
    //   68: ixor
    //   69: iload_1
    //   70: iand
    //   71: istore_1
    //   72: aconst_null
    //   73: astore #5
    //   75: iload_1
    //   76: ifeq -> 88
    //   79: aload_0
    //   80: getfield mTitle : Ljava/lang/CharSequence;
    //   83: astore #4
    //   85: goto -> 91
    //   88: aconst_null
    //   89: astore #4
    //   91: aload_0
    //   92: aload #4
    //   94: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   97: aload_0
    //   98: getfield mItemData : Landroid/support/v7/view/menu/MenuItemImpl;
    //   101: invokevirtual getContentDescription : ()Ljava/lang/CharSequence;
    //   104: astore #4
    //   106: aload #4
    //   108: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   111: ifeq -> 142
    //   114: iload_1
    //   115: ifeq -> 124
    //   118: aconst_null
    //   119: astore #4
    //   121: goto -> 133
    //   124: aload_0
    //   125: getfield mItemData : Landroid/support/v7/view/menu/MenuItemImpl;
    //   128: invokevirtual getTitle : ()Ljava/lang/CharSequence;
    //   131: astore #4
    //   133: aload_0
    //   134: aload #4
    //   136: invokevirtual setContentDescription : (Ljava/lang/CharSequence;)V
    //   139: goto -> 148
    //   142: aload_0
    //   143: aload #4
    //   145: invokevirtual setContentDescription : (Ljava/lang/CharSequence;)V
    //   148: aload_0
    //   149: getfield mItemData : Landroid/support/v7/view/menu/MenuItemImpl;
    //   152: invokevirtual getTooltipText : ()Ljava/lang/CharSequence;
    //   155: astore #4
    //   157: aload #4
    //   159: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   162: ifeq -> 192
    //   165: iload_1
    //   166: ifeq -> 176
    //   169: aload #5
    //   171: astore #4
    //   173: goto -> 185
    //   176: aload_0
    //   177: getfield mItemData : Landroid/support/v7/view/menu/MenuItemImpl;
    //   180: invokevirtual getTitle : ()Ljava/lang/CharSequence;
    //   183: astore #4
    //   185: aload_0
    //   186: aload #4
    //   188: invokestatic setTooltipText : (Landroid/view/View;Ljava/lang/CharSequence;)V
    //   191: return
    //   192: aload_0
    //   193: aload #4
    //   195: invokestatic setTooltipText : (Landroid/view/View;Ljava/lang/CharSequence;)V
    //   198: return
  }
  
  public final MenuItemImpl getItemData() {
    return this.mItemData;
  }
  
  public final boolean hasText() {
    return !TextUtils.isEmpty(getText());
  }
  
  public final void initialize$667f453d(MenuItemImpl paramMenuItemImpl) {
    byte b;
    this.mItemData = paramMenuItemImpl;
    Drawable drawable = paramMenuItemImpl.getIcon();
    this.mIcon = drawable;
    boolean bool = false;
    if (drawable != null) {
      int k = drawable.getIntrinsicWidth();
      int j = drawable.getIntrinsicHeight();
      b = k;
      int i = j;
      if (k > this.mMaxIconSize) {
        float f = this.mMaxIconSize / k;
        b = this.mMaxIconSize;
        i = (int)(j * f);
      } 
      k = b;
      j = i;
      if (i > this.mMaxIconSize) {
        float f = this.mMaxIconSize / i;
        j = this.mMaxIconSize;
        k = (int)(b * f);
      } 
      drawable.setBounds(0, 0, k, j);
    } 
    setCompoundDrawables(drawable, null, null, null);
    updateTextButtonVisibility();
    this.mTitle = paramMenuItemImpl.getTitleForItemView(this);
    updateTextButtonVisibility();
    setId(paramMenuItemImpl.getItemId());
    if (paramMenuItemImpl.isVisible()) {
      b = bool;
    } else {
      b = 8;
    } 
    setVisibility(b);
    setEnabled(paramMenuItemImpl.isEnabled());
    if (paramMenuItemImpl.hasSubMenu() && this.mForwardingListener == null)
      this.mForwardingListener = new ActionMenuItemView$ActionMenuItemForwardingListener(this); 
  }
  
  public final boolean needsDividerAfter() {
    return hasText();
  }
  
  public final boolean needsDividerBefore() {
    return (hasText() && this.mItemData.getIcon() == null);
  }
  
  public void onClick(View paramView) {
    if (this.mItemInvoker != null)
      this.mItemInvoker.invokeItem(this.mItemData); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    this.mAllowTextWithIcon = shouldAllowTextWithIcon();
    updateTextButtonVisibility();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    boolean bool = hasText();
    if (bool && this.mSavedPaddingLeft >= 0)
      super.setPadding(this.mSavedPaddingLeft, getPaddingTop(), getPaddingRight(), getPaddingBottom()); 
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == Integer.MIN_VALUE) {
      paramInt1 = Math.min(paramInt1, this.mMinWidth);
    } else {
      paramInt1 = this.mMinWidth;
    } 
    if (i != 1073741824 && this.mMinWidth > 0 && j < paramInt1)
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2); 
    if (!bool && this.mIcon != null)
      super.setPadding((getMeasuredWidth() - this.mIcon.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom()); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return (this.mItemData.hasSubMenu() && this.mForwardingListener != null && this.mForwardingListener.onTouch((View)this, paramMotionEvent)) ? true : super.onTouchEvent(paramMotionEvent);
  }
  
  public final boolean prefersCondensedTitle() {
    return true;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mSavedPaddingLeft = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\view\menu\ActionMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */