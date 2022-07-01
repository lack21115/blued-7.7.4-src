package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;

public class ActionMenuItemView extends AppCompatTextView implements View.OnClickListener, MenuView.ItemView, ActionMenuView.ActionMenuChildView {
  MenuItemImpl a;
  
  MenuBuilder.ItemInvoker b;
  
  PopupCallback c;
  
  private CharSequence d;
  
  private Drawable e;
  
  private ForwardingListener f;
  
  private boolean g;
  
  private boolean h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  public ActionMenuItemView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    Resources resources = paramContext.getResources();
    this.g = a();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionMenuItemView, paramInt, 0);
    this.i = typedArray.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
    typedArray.recycle();
    this.k = (int)((resources.getDisplayMetrics()).density * 32.0F + 0.5F);
    setOnClickListener(this);
    this.j = -1;
    setSaveEnabled(false);
  }
  
  private boolean a() {
    Configuration configuration = getContext().getResources().getConfiguration();
    int i = configuration.screenWidthDp;
    int j = configuration.screenHeightDp;
    return (i >= 480 || (i >= 640 && j >= 480) || configuration.orientation == 2);
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Ljava/lang/CharSequence;
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore_3
    //   8: iconst_1
    //   9: istore_2
    //   10: iload_2
    //   11: istore_1
    //   12: aload_0
    //   13: getfield e : Landroid/graphics/drawable/Drawable;
    //   16: ifnull -> 52
    //   19: aload_0
    //   20: getfield a : Landroidx/appcompat/view/menu/MenuItemImpl;
    //   23: invokevirtual showsTextAsAction : ()Z
    //   26: ifeq -> 50
    //   29: iload_2
    //   30: istore_1
    //   31: aload_0
    //   32: getfield g : Z
    //   35: ifne -> 52
    //   38: aload_0
    //   39: getfield h : Z
    //   42: ifeq -> 50
    //   45: iload_2
    //   46: istore_1
    //   47: goto -> 52
    //   50: iconst_0
    //   51: istore_1
    //   52: iload_3
    //   53: iconst_1
    //   54: ixor
    //   55: iload_1
    //   56: iand
    //   57: istore_1
    //   58: aconst_null
    //   59: astore #5
    //   61: iload_1
    //   62: ifeq -> 74
    //   65: aload_0
    //   66: getfield d : Ljava/lang/CharSequence;
    //   69: astore #4
    //   71: goto -> 77
    //   74: aconst_null
    //   75: astore #4
    //   77: aload_0
    //   78: aload #4
    //   80: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   83: aload_0
    //   84: getfield a : Landroidx/appcompat/view/menu/MenuItemImpl;
    //   87: invokevirtual getContentDescription : ()Ljava/lang/CharSequence;
    //   90: astore #4
    //   92: aload #4
    //   94: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   97: ifeq -> 128
    //   100: iload_1
    //   101: ifeq -> 110
    //   104: aconst_null
    //   105: astore #4
    //   107: goto -> 119
    //   110: aload_0
    //   111: getfield a : Landroidx/appcompat/view/menu/MenuItemImpl;
    //   114: invokevirtual getTitle : ()Ljava/lang/CharSequence;
    //   117: astore #4
    //   119: aload_0
    //   120: aload #4
    //   122: invokevirtual setContentDescription : (Ljava/lang/CharSequence;)V
    //   125: goto -> 134
    //   128: aload_0
    //   129: aload #4
    //   131: invokevirtual setContentDescription : (Ljava/lang/CharSequence;)V
    //   134: aload_0
    //   135: getfield a : Landroidx/appcompat/view/menu/MenuItemImpl;
    //   138: invokevirtual getTooltipText : ()Ljava/lang/CharSequence;
    //   141: astore #4
    //   143: aload #4
    //   145: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   148: ifeq -> 178
    //   151: iload_1
    //   152: ifeq -> 162
    //   155: aload #5
    //   157: astore #4
    //   159: goto -> 171
    //   162: aload_0
    //   163: getfield a : Landroidx/appcompat/view/menu/MenuItemImpl;
    //   166: invokevirtual getTitle : ()Ljava/lang/CharSequence;
    //   169: astore #4
    //   171: aload_0
    //   172: aload #4
    //   174: invokestatic setTooltipText : (Landroid/view/View;Ljava/lang/CharSequence;)V
    //   177: return
    //   178: aload_0
    //   179: aload #4
    //   181: invokestatic setTooltipText : (Landroid/view/View;Ljava/lang/CharSequence;)V
    //   184: return
  }
  
  public MenuItemImpl getItemData() {
    return this.a;
  }
  
  public boolean hasText() {
    return TextUtils.isEmpty(getText()) ^ true;
  }
  
  public void initialize(MenuItemImpl paramMenuItemImpl, int paramInt) {
    this.a = paramMenuItemImpl;
    setIcon(paramMenuItemImpl.getIcon());
    setTitle(paramMenuItemImpl.a(this));
    setId(paramMenuItemImpl.getItemId());
    if (paramMenuItemImpl.isVisible()) {
      paramInt = 0;
    } else {
      paramInt = 8;
    } 
    setVisibility(paramInt);
    setEnabled(paramMenuItemImpl.isEnabled());
    if (paramMenuItemImpl.hasSubMenu() && this.f == null)
      this.f = new ActionMenuItemForwardingListener(this); 
  }
  
  public boolean needsDividerAfter() {
    return hasText();
  }
  
  public boolean needsDividerBefore() {
    return (hasText() && this.a.getIcon() == null);
  }
  
  public void onClick(View paramView) {
    MenuBuilder.ItemInvoker itemInvoker = this.b;
    if (itemInvoker != null)
      itemInvoker.invokeItem(this.a); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    this.g = a();
    b();
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    boolean bool = hasText();
    if (bool) {
      int k = this.j;
      if (k >= 0)
        super.setPadding(k, getPaddingTop(), getPaddingRight(), getPaddingBottom()); 
    } 
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int j = getMeasuredWidth();
    if (i == Integer.MIN_VALUE) {
      paramInt1 = Math.min(paramInt1, this.i);
    } else {
      paramInt1 = this.i;
    } 
    if (i != 1073741824 && this.i > 0 && j < paramInt1)
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2); 
    if (!bool && this.e != null)
      super.setPadding((getMeasuredWidth() - this.e.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom()); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.a.hasSubMenu()) {
      ForwardingListener forwardingListener = this.f;
      if (forwardingListener != null && forwardingListener.onTouch((View)this, paramMotionEvent))
        return true; 
    } 
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean prefersCondensedTitle() {
    return true;
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean) {
    if (this.h != paramBoolean) {
      this.h = paramBoolean;
      MenuItemImpl menuItemImpl = this.a;
      if (menuItemImpl != null)
        menuItemImpl.actionFormatChanged(); 
    } 
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.e = paramDrawable;
    if (paramDrawable != null) {
      int m = paramDrawable.getIntrinsicWidth();
      int n = paramDrawable.getIntrinsicHeight();
      int k = this.k;
      int j = m;
      int i = n;
      if (m > k) {
        float f = k / m;
        i = (int)(n * f);
        j = k;
      } 
      n = this.k;
      m = j;
      k = i;
      if (i > n) {
        float f = n / i;
        m = (int)(j * f);
        k = n;
      } 
      paramDrawable.setBounds(0, 0, m, k);
    } 
    setCompoundDrawables(paramDrawable, null, null, null);
    b();
  }
  
  public void setItemInvoker(MenuBuilder.ItemInvoker paramItemInvoker) {
    this.b = paramItemInvoker;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.j = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(PopupCallback paramPopupCallback) {
    this.c = paramPopupCallback;
  }
  
  public void setShortcut(boolean paramBoolean, char paramChar) {}
  
  public void setTitle(CharSequence paramCharSequence) {
    this.d = paramCharSequence;
    b();
  }
  
  public boolean showsIcon() {
    return true;
  }
  
  class ActionMenuItemForwardingListener extends ForwardingListener {
    public ActionMenuItemForwardingListener(ActionMenuItemView this$0) {
      super((View)this$0);
    }
    
    public ShowableListMenu getPopup() {
      return (this.a.c != null) ? this.a.c.getPopup() : null;
    }
    
    public boolean onForwardingStarted() {
      MenuBuilder.ItemInvoker itemInvoker = this.a.b;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (itemInvoker != null) {
        bool1 = bool2;
        if (this.a.b.invokeItem(this.a.a)) {
          ShowableListMenu showableListMenu = getPopup();
          bool1 = bool2;
          if (showableListMenu != null) {
            bool1 = bool2;
            if (showableListMenu.isShowing())
              bool1 = true; 
          } 
        } 
      } 
      return bool1;
    }
  }
  
  public static abstract class PopupCallback {
    public abstract ShowableListMenu getPopup();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\menu\ActionMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */