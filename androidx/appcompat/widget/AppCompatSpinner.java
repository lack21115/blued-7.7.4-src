package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;

public class AppCompatSpinner extends Spinner implements TintableBackgroundView {
  private static final int[] c = new int[] { 16843505 };
  
  int a;
  
  final Rect b;
  
  private final AppCompatBackgroundHelper d;
  
  private final Context e;
  
  private ForwardingListener f;
  
  private SpinnerAdapter g;
  
  private final boolean h;
  
  private SpinnerPopup i;
  
  public AppCompatSpinner(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public AppCompatSpinner(Context paramContext, int paramInt) {
    this(paramContext, (AttributeSet)null, R.attr.spinnerStyle, paramInt);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.spinnerStyle);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    this(paramContext, paramAttributeSet, paramInt, -1);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    this(paramContext, paramAttributeSet, paramInt1, paramInt2, (Resources.Theme)null);
  }
  
  public AppCompatSpinner(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2, Resources.Theme paramTheme) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new android/graphics/Rect
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: putfield b : Landroid/graphics/Rect;
    //   18: aload_1
    //   19: aload_2
    //   20: getstatic androidx/appcompat/R$styleable.Spinner : [I
    //   23: iload_3
    //   24: iconst_0
    //   25: invokestatic obtainStyledAttributes : (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   28: astore #10
    //   30: aload_0
    //   31: new androidx/appcompat/widget/AppCompatBackgroundHelper
    //   34: dup
    //   35: aload_0
    //   36: invokespecial <init> : (Landroid/view/View;)V
    //   39: putfield d : Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   42: aload #5
    //   44: ifnull -> 64
    //   47: aload_0
    //   48: new androidx/appcompat/view/ContextThemeWrapper
    //   51: dup
    //   52: aload_1
    //   53: aload #5
    //   55: invokespecial <init> : (Landroid/content/Context;Landroid/content/res/Resources$Theme;)V
    //   58: putfield e : Landroid/content/Context;
    //   61: goto -> 102
    //   64: aload #10
    //   66: getstatic androidx/appcompat/R$styleable.Spinner_popupTheme : I
    //   69: iconst_0
    //   70: invokevirtual getResourceId : (II)I
    //   73: istore #6
    //   75: iload #6
    //   77: ifeq -> 97
    //   80: aload_0
    //   81: new androidx/appcompat/view/ContextThemeWrapper
    //   84: dup
    //   85: aload_1
    //   86: iload #6
    //   88: invokespecial <init> : (Landroid/content/Context;I)V
    //   91: putfield e : Landroid/content/Context;
    //   94: goto -> 102
    //   97: aload_0
    //   98: aload_1
    //   99: putfield e : Landroid/content/Context;
    //   102: iload #4
    //   104: istore #7
    //   106: iload #4
    //   108: iconst_m1
    //   109: if_icmpne -> 235
    //   112: aload_1
    //   113: aload_2
    //   114: getstatic androidx/appcompat/widget/AppCompatSpinner.c : [I
    //   117: iload_3
    //   118: iconst_0
    //   119: invokevirtual obtainStyledAttributes : (Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   122: astore #5
    //   124: iload #4
    //   126: istore #6
    //   128: aload #5
    //   130: astore #8
    //   132: aload #5
    //   134: iconst_0
    //   135: invokevirtual hasValue : (I)Z
    //   138: ifeq -> 154
    //   141: aload #5
    //   143: astore #8
    //   145: aload #5
    //   147: iconst_0
    //   148: iconst_0
    //   149: invokevirtual getInt : (II)I
    //   152: istore #6
    //   154: iload #6
    //   156: istore #7
    //   158: aload #5
    //   160: ifnull -> 235
    //   163: iload #6
    //   165: istore #4
    //   167: aload #5
    //   169: invokevirtual recycle : ()V
    //   172: iload #4
    //   174: istore #7
    //   176: goto -> 235
    //   179: astore #9
    //   181: goto -> 196
    //   184: astore_1
    //   185: aconst_null
    //   186: astore #8
    //   188: goto -> 223
    //   191: astore #9
    //   193: aconst_null
    //   194: astore #5
    //   196: aload #5
    //   198: astore #8
    //   200: ldc 'AppCompatSpinner'
    //   202: ldc 'Could not read android:spinnerMode'
    //   204: aload #9
    //   206: invokestatic i : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   209: pop
    //   210: iload #4
    //   212: istore #7
    //   214: aload #5
    //   216: ifnull -> 235
    //   219: goto -> 167
    //   222: astore_1
    //   223: aload #8
    //   225: ifnull -> 233
    //   228: aload #8
    //   230: invokevirtual recycle : ()V
    //   233: aload_1
    //   234: athrow
    //   235: iload #7
    //   237: ifeq -> 349
    //   240: iload #7
    //   242: iconst_1
    //   243: if_icmpeq -> 249
    //   246: goto -> 378
    //   249: new androidx/appcompat/widget/AppCompatSpinner$DropdownPopup
    //   252: dup
    //   253: aload_0
    //   254: aload_0
    //   255: getfield e : Landroid/content/Context;
    //   258: aload_2
    //   259: iload_3
    //   260: invokespecial <init> : (Landroidx/appcompat/widget/AppCompatSpinner;Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   263: astore #5
    //   265: aload_0
    //   266: getfield e : Landroid/content/Context;
    //   269: aload_2
    //   270: getstatic androidx/appcompat/R$styleable.Spinner : [I
    //   273: iload_3
    //   274: iconst_0
    //   275: invokestatic obtainStyledAttributes : (Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroidx/appcompat/widget/TintTypedArray;
    //   278: astore #8
    //   280: aload_0
    //   281: aload #8
    //   283: getstatic androidx/appcompat/R$styleable.Spinner_android_dropDownWidth : I
    //   286: bipush #-2
    //   288: invokevirtual getLayoutDimension : (II)I
    //   291: putfield a : I
    //   294: aload #5
    //   296: aload #8
    //   298: getstatic androidx/appcompat/R$styleable.Spinner_android_popupBackground : I
    //   301: invokevirtual getDrawable : (I)Landroid/graphics/drawable/Drawable;
    //   304: invokevirtual setBackgroundDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   307: aload #5
    //   309: aload #10
    //   311: getstatic androidx/appcompat/R$styleable.Spinner_android_prompt : I
    //   314: invokevirtual getString : (I)Ljava/lang/String;
    //   317: invokevirtual setPromptText : (Ljava/lang/CharSequence;)V
    //   320: aload #8
    //   322: invokevirtual recycle : ()V
    //   325: aload_0
    //   326: aload #5
    //   328: putfield i : Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   331: aload_0
    //   332: new androidx/appcompat/widget/AppCompatSpinner$1
    //   335: dup
    //   336: aload_0
    //   337: aload_0
    //   338: aload #5
    //   340: invokespecial <init> : (Landroidx/appcompat/widget/AppCompatSpinner;Landroid/view/View;Landroidx/appcompat/widget/AppCompatSpinner$DropdownPopup;)V
    //   343: putfield f : Landroidx/appcompat/widget/ForwardingListener;
    //   346: goto -> 378
    //   349: aload_0
    //   350: new androidx/appcompat/widget/AppCompatSpinner$DialogPopup
    //   353: dup
    //   354: aload_0
    //   355: invokespecial <init> : (Landroidx/appcompat/widget/AppCompatSpinner;)V
    //   358: putfield i : Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   361: aload_0
    //   362: getfield i : Landroidx/appcompat/widget/AppCompatSpinner$SpinnerPopup;
    //   365: aload #10
    //   367: getstatic androidx/appcompat/R$styleable.Spinner_android_prompt : I
    //   370: invokevirtual getString : (I)Ljava/lang/String;
    //   373: invokeinterface setPromptText : (Ljava/lang/CharSequence;)V
    //   378: aload #10
    //   380: getstatic androidx/appcompat/R$styleable.Spinner_android_entries : I
    //   383: invokevirtual getTextArray : (I)[Ljava/lang/CharSequence;
    //   386: astore #5
    //   388: aload #5
    //   390: ifnull -> 418
    //   393: new android/widget/ArrayAdapter
    //   396: dup
    //   397: aload_1
    //   398: ldc 17367048
    //   400: aload #5
    //   402: invokespecial <init> : (Landroid/content/Context;I[Ljava/lang/Object;)V
    //   405: astore_1
    //   406: aload_1
    //   407: getstatic androidx/appcompat/R$layout.support_simple_spinner_dropdown_item : I
    //   410: invokevirtual setDropDownViewResource : (I)V
    //   413: aload_0
    //   414: aload_1
    //   415: invokevirtual setAdapter : (Landroid/widget/SpinnerAdapter;)V
    //   418: aload #10
    //   420: invokevirtual recycle : ()V
    //   423: aload_0
    //   424: iconst_1
    //   425: putfield h : Z
    //   428: aload_0
    //   429: getfield g : Landroid/widget/SpinnerAdapter;
    //   432: astore_1
    //   433: aload_1
    //   434: ifnull -> 447
    //   437: aload_0
    //   438: aload_1
    //   439: invokevirtual setAdapter : (Landroid/widget/SpinnerAdapter;)V
    //   442: aload_0
    //   443: aconst_null
    //   444: putfield g : Landroid/widget/SpinnerAdapter;
    //   447: aload_0
    //   448: getfield d : Landroidx/appcompat/widget/AppCompatBackgroundHelper;
    //   451: aload_2
    //   452: iload_3
    //   453: invokevirtual a : (Landroid/util/AttributeSet;I)V
    //   456: return
    // Exception table:
    //   from	to	target	type
    //   112	124	191	java/lang/Exception
    //   112	124	184	finally
    //   132	141	179	java/lang/Exception
    //   132	141	222	finally
    //   145	154	179	java/lang/Exception
    //   145	154	222	finally
    //   200	210	222	finally
  }
  
  int a(SpinnerAdapter paramSpinnerAdapter, Drawable paramDrawable) {
    int k = 0;
    if (paramSpinnerAdapter == null)
      return 0; 
    int m = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
    int n = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
    int i = Math.max(0, getSelectedItemPosition());
    int i1 = Math.min(paramSpinnerAdapter.getCount(), i + 15);
    int j = Math.max(0, i - 15 - i1 - i);
    View view = null;
    i = 0;
    while (j < i1) {
      int i3 = paramSpinnerAdapter.getItemViewType(j);
      int i2 = k;
      if (i3 != k) {
        view = null;
        i2 = i3;
      } 
      view = paramSpinnerAdapter.getView(j, view, (ViewGroup)this);
      if (view.getLayoutParams() == null)
        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2)); 
      view.measure(m, n);
      i = Math.max(i, view.getMeasuredWidth());
      j++;
      k = i2;
    } 
    j = i;
    if (paramDrawable != null) {
      paramDrawable.getPadding(this.b);
      j = i + this.b.left + this.b.right;
    } 
    return j;
  }
  
  void a() {
    if (Build.VERSION.SDK_INT >= 17) {
      this.i.show(getTextDirection(), getTextAlignment());
      return;
    } 
    this.i.show(-1, -1);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.d;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.c(); 
  }
  
  public int getDropDownHorizontalOffset() {
    SpinnerPopup spinnerPopup = this.i;
    return (spinnerPopup != null) ? spinnerPopup.getHorizontalOffset() : ((Build.VERSION.SDK_INT >= 16) ? super.getDropDownHorizontalOffset() : 0);
  }
  
  public int getDropDownVerticalOffset() {
    SpinnerPopup spinnerPopup = this.i;
    return (spinnerPopup != null) ? spinnerPopup.getVerticalOffset() : ((Build.VERSION.SDK_INT >= 16) ? super.getDropDownVerticalOffset() : 0);
  }
  
  public int getDropDownWidth() {
    return (this.i != null) ? this.a : ((Build.VERSION.SDK_INT >= 16) ? super.getDropDownWidth() : 0);
  }
  
  final SpinnerPopup getInternalPopup() {
    return this.i;
  }
  
  public Drawable getPopupBackground() {
    SpinnerPopup spinnerPopup = this.i;
    return (spinnerPopup != null) ? spinnerPopup.getBackground() : ((Build.VERSION.SDK_INT >= 16) ? super.getPopupBackground() : null);
  }
  
  public Context getPopupContext() {
    return this.e;
  }
  
  public CharSequence getPrompt() {
    SpinnerPopup spinnerPopup = this.i;
    return (spinnerPopup != null) ? spinnerPopup.getHintText() : super.getPrompt();
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.d;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.d;
    return (appCompatBackgroundHelper != null) ? appCompatBackgroundHelper.b() : null;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    SpinnerPopup spinnerPopup = this.i;
    if (spinnerPopup != null && spinnerPopup.isShowing())
      this.i.dismiss(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.i != null && View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE)
      setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(paramInt1)), getMeasuredHeight()); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    if (savedState.a) {
      ViewTreeObserver viewTreeObserver = getViewTreeObserver();
      if (viewTreeObserver != null)
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
              public void onGlobalLayout() {
                if (!this.a.getInternalPopup().isShowing())
                  this.a.a(); 
                ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                  if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                    return;
                  } 
                  viewTreeObserver.removeGlobalOnLayoutListener(this);
                } 
              }
            }); 
    } 
  }
  
  public Parcelable onSaveInstanceState() {
    boolean bool;
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    SpinnerPopup spinnerPopup = this.i;
    if (spinnerPopup != null && spinnerPopup.isShowing()) {
      bool = true;
    } else {
      bool = false;
    } 
    savedState.a = bool;
    return (Parcelable)savedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    ForwardingListener forwardingListener = this.f;
    return (forwardingListener != null && forwardingListener.onTouch((View)this, paramMotionEvent)) ? true : super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick() {
    SpinnerPopup spinnerPopup = this.i;
    if (spinnerPopup != null) {
      if (!spinnerPopup.isShowing())
        a(); 
      return true;
    } 
    return super.performClick();
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter) {
    if (!this.h) {
      this.g = paramSpinnerAdapter;
      return;
    } 
    super.setAdapter(paramSpinnerAdapter);
    if (this.i != null) {
      Context context2 = this.e;
      Context context1 = context2;
      if (context2 == null)
        context1 = getContext(); 
      this.i.setAdapter(new DropDownAdapter(paramSpinnerAdapter, context1.getTheme()));
    } 
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.d;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramDrawable); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.d;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setDropDownHorizontalOffset(int paramInt) {
    SpinnerPopup spinnerPopup = this.i;
    if (spinnerPopup != null) {
      spinnerPopup.setHorizontalOriginalOffset(paramInt);
      this.i.setHorizontalOffset(paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      super.setDropDownHorizontalOffset(paramInt); 
  }
  
  public void setDropDownVerticalOffset(int paramInt) {
    SpinnerPopup spinnerPopup = this.i;
    if (spinnerPopup != null) {
      spinnerPopup.setVerticalOffset(paramInt);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      super.setDropDownVerticalOffset(paramInt); 
  }
  
  public void setDropDownWidth(int paramInt) {
    if (this.i != null) {
      this.a = paramInt;
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      super.setDropDownWidth(paramInt); 
  }
  
  public void setPopupBackgroundDrawable(Drawable paramDrawable) {
    SpinnerPopup spinnerPopup = this.i;
    if (spinnerPopup != null) {
      spinnerPopup.setBackgroundDrawable(paramDrawable);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 16)
      super.setPopupBackgroundDrawable(paramDrawable); 
  }
  
  public void setPopupBackgroundResource(int paramInt) {
    setPopupBackgroundDrawable(AppCompatResources.getDrawable(getPopupContext(), paramInt));
  }
  
  public void setPrompt(CharSequence paramCharSequence) {
    SpinnerPopup spinnerPopup = this.i;
    if (spinnerPopup != null) {
      spinnerPopup.setPromptText(paramCharSequence);
      return;
    } 
    super.setPrompt(paramCharSequence);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.d;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    AppCompatBackgroundHelper appCompatBackgroundHelper = this.d;
    if (appCompatBackgroundHelper != null)
      appCompatBackgroundHelper.a(paramMode); 
  }
  
  class DialogPopup implements DialogInterface.OnClickListener, SpinnerPopup {
    AlertDialog a;
    
    private ListAdapter c;
    
    private CharSequence d;
    
    DialogPopup(AppCompatSpinner this$0) {}
    
    public void dismiss() {
      AlertDialog alertDialog = this.a;
      if (alertDialog != null) {
        alertDialog.dismiss();
        this.a = null;
      } 
    }
    
    public Drawable getBackground() {
      return null;
    }
    
    public CharSequence getHintText() {
      return this.d;
    }
    
    public int getHorizontalOffset() {
      return 0;
    }
    
    public int getHorizontalOriginalOffset() {
      return 0;
    }
    
    public int getVerticalOffset() {
      return 0;
    }
    
    public boolean isShowing() {
      AlertDialog alertDialog = this.a;
      return (alertDialog != null) ? alertDialog.isShowing() : false;
    }
    
    public void onClick(DialogInterface param1DialogInterface, int param1Int) {
      this.b.setSelection(param1Int);
      if (this.b.getOnItemClickListener() != null)
        this.b.performItemClick(null, param1Int, this.c.getItemId(param1Int)); 
      dismiss();
    }
    
    public void setAdapter(ListAdapter param1ListAdapter) {
      this.c = param1ListAdapter;
    }
    
    public void setBackgroundDrawable(Drawable param1Drawable) {
      Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }
    
    public void setHorizontalOffset(int param1Int) {
      Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }
    
    public void setHorizontalOriginalOffset(int param1Int) {
      Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }
    
    public void setPromptText(CharSequence param1CharSequence) {
      this.d = param1CharSequence;
    }
    
    public void setVerticalOffset(int param1Int) {
      Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }
    
    public void show(int param1Int1, int param1Int2) {
      if (this.c == null)
        return; 
      AlertDialog.Builder builder = new AlertDialog.Builder(this.b.getPopupContext());
      CharSequence charSequence = this.d;
      if (charSequence != null)
        builder.setTitle(charSequence); 
      this.a = builder.setSingleChoiceItems(this.c, this.b.getSelectedItemPosition(), this).create();
      ListView listView = this.a.getListView();
      if (Build.VERSION.SDK_INT >= 17) {
        listView.setTextDirection(param1Int1);
        listView.setTextAlignment(param1Int2);
      } 
      this.a.show();
    }
  }
  
  static class DropDownAdapter implements ListAdapter, SpinnerAdapter {
    private SpinnerAdapter a;
    
    private ListAdapter b;
    
    public DropDownAdapter(SpinnerAdapter param1SpinnerAdapter, Resources.Theme param1Theme) {
      this.a = param1SpinnerAdapter;
      if (param1SpinnerAdapter instanceof ListAdapter)
        this.b = (ListAdapter)param1SpinnerAdapter; 
      if (param1Theme != null) {
        ThemedSpinnerAdapter themedSpinnerAdapter;
        if (Build.VERSION.SDK_INT >= 23 && param1SpinnerAdapter instanceof ThemedSpinnerAdapter) {
          themedSpinnerAdapter = (ThemedSpinnerAdapter)param1SpinnerAdapter;
          if (themedSpinnerAdapter.getDropDownViewTheme() != param1Theme) {
            themedSpinnerAdapter.setDropDownViewTheme(param1Theme);
            return;
          } 
        } else if (themedSpinnerAdapter instanceof ThemedSpinnerAdapter) {
          ThemedSpinnerAdapter themedSpinnerAdapter1 = (ThemedSpinnerAdapter)themedSpinnerAdapter;
          if (themedSpinnerAdapter1.getDropDownViewTheme() == null)
            themedSpinnerAdapter1.setDropDownViewTheme(param1Theme); 
        } 
      } 
    }
    
    public boolean areAllItemsEnabled() {
      ListAdapter listAdapter = this.b;
      return (listAdapter != null) ? listAdapter.areAllItemsEnabled() : true;
    }
    
    public int getCount() {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter == null) ? 0 : spinnerAdapter.getCount();
    }
    
    public View getDropDownView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter == null) ? null : spinnerAdapter.getDropDownView(param1Int, param1View, param1ViewGroup);
    }
    
    public Object getItem(int param1Int) {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter == null) ? null : spinnerAdapter.getItem(param1Int);
    }
    
    public long getItemId(int param1Int) {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter == null) ? -1L : spinnerAdapter.getItemId(param1Int);
    }
    
    public int getItemViewType(int param1Int) {
      return 0;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      return getDropDownView(param1Int, param1View, param1ViewGroup);
    }
    
    public int getViewTypeCount() {
      return 1;
    }
    
    public boolean hasStableIds() {
      SpinnerAdapter spinnerAdapter = this.a;
      return (spinnerAdapter != null && spinnerAdapter.hasStableIds());
    }
    
    public boolean isEmpty() {
      return (getCount() == 0);
    }
    
    public boolean isEnabled(int param1Int) {
      ListAdapter listAdapter = this.b;
      return (listAdapter != null) ? listAdapter.isEnabled(param1Int) : true;
    }
    
    public void registerDataSetObserver(DataSetObserver param1DataSetObserver) {
      SpinnerAdapter spinnerAdapter = this.a;
      if (spinnerAdapter != null)
        spinnerAdapter.registerDataSetObserver(param1DataSetObserver); 
    }
    
    public void unregisterDataSetObserver(DataSetObserver param1DataSetObserver) {
      SpinnerAdapter spinnerAdapter = this.a;
      if (spinnerAdapter != null)
        spinnerAdapter.unregisterDataSetObserver(param1DataSetObserver); 
    }
  }
  
  class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
    ListAdapter a;
    
    private CharSequence h;
    
    private final Rect i = new Rect();
    
    private int j;
    
    public DropdownPopup(AppCompatSpinner this$0, Context param1Context, AttributeSet param1AttributeSet, int param1Int) {
      super(param1Context, param1AttributeSet, param1Int);
      setAnchorView((View)this$0);
      setModal(true);
      setPromptPosition(0);
      setOnItemClickListener(new AdapterView.OnItemClickListener(this, this$0) {
            public void onItemClick(AdapterView<?> param2AdapterView, View param2View, int param2Int, long param2Long) {
              this.b.b.setSelection(param2Int);
              if (this.b.b.getOnItemClickListener() != null)
                this.b.b.performItemClick(param2View, param2Int, this.b.a.getItemId(param2Int)); 
              this.b.dismiss();
            }
          });
    }
    
    void a() {
      Drawable drawable = getBackground();
      int i = 0;
      if (drawable != null) {
        drawable.getPadding(this.b.b);
        if (ViewUtils.isLayoutRtl((View)this.b)) {
          i = this.b.b.right;
        } else {
          i = -this.b.b.left;
        } 
      } else {
        Rect rect = this.b.b;
        this.b.b.right = 0;
        rect.left = 0;
      } 
      int j = this.b.getPaddingLeft();
      int k = this.b.getPaddingRight();
      int m = this.b.getWidth();
      if (this.b.a == -2) {
        int i1 = this.b.a((SpinnerAdapter)this.a, getBackground());
        int i2 = (this.b.getContext().getResources().getDisplayMetrics()).widthPixels - this.b.b.left - this.b.b.right;
        int n = i1;
        if (i1 > i2)
          n = i2; 
        setContentWidth(Math.max(n, m - j - k));
      } else if (this.b.a == -1) {
        setContentWidth(m - j - k);
      } else {
        setContentWidth(this.b.a);
      } 
      if (ViewUtils.isLayoutRtl((View)this.b)) {
        i += m - k - getWidth() - getHorizontalOriginalOffset();
      } else {
        i += j + getHorizontalOriginalOffset();
      } 
      setHorizontalOffset(i);
    }
    
    boolean a(View param1View) {
      return (ViewCompat.isAttachedToWindow(param1View) && param1View.getGlobalVisibleRect(this.i));
    }
    
    public CharSequence getHintText() {
      return this.h;
    }
    
    public int getHorizontalOriginalOffset() {
      return this.j;
    }
    
    public void setAdapter(ListAdapter param1ListAdapter) {
      super.setAdapter(param1ListAdapter);
      this.a = param1ListAdapter;
    }
    
    public void setHorizontalOriginalOffset(int param1Int) {
      this.j = param1Int;
    }
    
    public void setPromptText(CharSequence param1CharSequence) {
      this.h = param1CharSequence;
    }
    
    public void show(int param1Int1, int param1Int2) {
      boolean bool = isShowing();
      a();
      setInputMethodMode(2);
      show();
      ListView listView = getListView();
      listView.setChoiceMode(1);
      if (Build.VERSION.SDK_INT >= 17) {
        listView.setTextDirection(param1Int1);
        listView.setTextAlignment(param1Int2);
      } 
      setSelection(this.b.getSelectedItemPosition());
      if (bool)
        return; 
      ViewTreeObserver viewTreeObserver = this.b.getViewTreeObserver();
      if (viewTreeObserver != null) {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(this) {
            public void onGlobalLayout() {
              AppCompatSpinner.DropdownPopup dropdownPopup = this.a;
              if (!dropdownPopup.a((View)dropdownPopup.b)) {
                this.a.dismiss();
                return;
              } 
              this.a.a();
              AppCompatSpinner.DropdownPopup.a(this.a);
            }
          };
        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
        setOnDismissListener(new PopupWindow.OnDismissListener(this, onGlobalLayoutListener) {
              public void onDismiss() {
                ViewTreeObserver viewTreeObserver = this.b.b.getViewTreeObserver();
                if (viewTreeObserver != null)
                  viewTreeObserver.removeGlobalOnLayoutListener(this.a); 
              }
            });
      } 
    }
  }
  
  class null implements AdapterView.OnItemClickListener {
    null(AppCompatSpinner this$0, AppCompatSpinner param1AppCompatSpinner) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      this.b.b.setSelection(param1Int);
      if (this.b.b.getOnItemClickListener() != null)
        this.b.b.performItemClick(param1View, param1Int, this.b.a.getItemId(param1Int)); 
      this.b.dismiss();
    }
  }
  
  class null implements ViewTreeObserver.OnGlobalLayoutListener {
    null(AppCompatSpinner this$0) {}
    
    public void onGlobalLayout() {
      AppCompatSpinner.DropdownPopup dropdownPopup = this.a;
      if (!dropdownPopup.a((View)dropdownPopup.b)) {
        this.a.dismiss();
        return;
      } 
      this.a.a();
      AppCompatSpinner.DropdownPopup.a(this.a);
    }
  }
  
  class null implements PopupWindow.OnDismissListener {
    null(AppCompatSpinner this$0, ViewTreeObserver.OnGlobalLayoutListener param1OnGlobalLayoutListener) {}
    
    public void onDismiss() {
      ViewTreeObserver viewTreeObserver = this.b.b.getViewTreeObserver();
      if (viewTreeObserver != null)
        viewTreeObserver.removeGlobalOnLayoutListener(this.a); 
    }
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public AppCompatSpinner.SavedState createFromParcel(Parcel param2Parcel) {
          return new AppCompatSpinner.SavedState(param2Parcel);
        }
        
        public AppCompatSpinner.SavedState[] newArray(int param2Int) {
          return new AppCompatSpinner.SavedState[param2Int];
        }
      };
    
    boolean a;
    
    SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      boolean bool;
      if (param1Parcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.a = bool;
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeByte((byte)this.a);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public AppCompatSpinner.SavedState createFromParcel(Parcel param1Parcel) {
      return new AppCompatSpinner.SavedState(param1Parcel);
    }
    
    public AppCompatSpinner.SavedState[] newArray(int param1Int) {
      return new AppCompatSpinner.SavedState[param1Int];
    }
  }
  
  static interface SpinnerPopup {
    void dismiss();
    
    Drawable getBackground();
    
    CharSequence getHintText();
    
    int getHorizontalOffset();
    
    int getHorizontalOriginalOffset();
    
    int getVerticalOffset();
    
    boolean isShowing();
    
    void setAdapter(ListAdapter param1ListAdapter);
    
    void setBackgroundDrawable(Drawable param1Drawable);
    
    void setHorizontalOffset(int param1Int);
    
    void setHorizontalOriginalOffset(int param1Int);
    
    void setPromptText(CharSequence param1CharSequence);
    
    void setVerticalOffset(int param1Int);
    
    void show(int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatSpinner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */