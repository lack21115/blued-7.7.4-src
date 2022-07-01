package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
  final ActivityChooserViewAdapter a;
  
  final FrameLayout b;
  
  final FrameLayout c;
  
  ActionProvider d;
  
  final DataSetObserver e = new DataSetObserver(this) {
      public void onChanged() {
        super.onChanged();
        this.a.a.notifyDataSetChanged();
      }
      
      public void onInvalidated() {
        super.onInvalidated();
        this.a.a.notifyDataSetInvalidated();
      }
    };
  
  PopupWindow.OnDismissListener f;
  
  boolean g;
  
  int h = 4;
  
  private final Callbacks i;
  
  private final View j;
  
  private final Drawable k;
  
  private final ImageView l;
  
  private final ImageView m;
  
  private final int n;
  
  private final ViewTreeObserver.OnGlobalLayoutListener o = new ViewTreeObserver.OnGlobalLayoutListener(this) {
      public void onGlobalLayout() {
        if (this.a.isShowingPopup()) {
          if (!this.a.isShown()) {
            this.a.getListPopupWindow().dismiss();
            return;
          } 
          this.a.getListPopupWindow().show();
          if (this.a.d != null)
            this.a.d.subUiVisibilityChanged(true); 
        } 
      }
    };
  
  private ListPopupWindow p;
  
  private boolean q;
  
  private int r;
  
  public ActivityChooserView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActivityChooserView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActivityChooserView, paramInt, 0);
    if (Build.VERSION.SDK_INT >= 29)
      saveAttributeDataForStyleable(paramContext, R.styleable.ActivityChooserView, paramAttributeSet, typedArray, paramInt, 0); 
    this.h = typedArray.getInt(R.styleable.ActivityChooserView_initialActivityCount, 4);
    Drawable drawable = typedArray.getDrawable(R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
    typedArray.recycle();
    LayoutInflater.from(getContext()).inflate(R.layout.abc_activity_chooser_view, this, true);
    this.i = new Callbacks(this);
    this.j = findViewById(R.id.activity_chooser_view_content);
    this.k = this.j.getBackground();
    this.c = (FrameLayout)findViewById(R.id.default_activity_button);
    this.c.setOnClickListener(this.i);
    this.c.setOnLongClickListener(this.i);
    this.m = (ImageView)this.c.findViewById(R.id.image);
    FrameLayout frameLayout = (FrameLayout)findViewById(R.id.expand_activities_button);
    frameLayout.setOnClickListener(this.i);
    frameLayout.setAccessibilityDelegate(new View.AccessibilityDelegate(this) {
          public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfo param1AccessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfo);
            AccessibilityNodeInfoCompat.wrap(param1AccessibilityNodeInfo).setCanOpenPopup(true);
          }
        });
    frameLayout.setOnTouchListener(new ForwardingListener(this, (View)frameLayout) {
          public ShowableListMenu getPopup() {
            return this.a.getListPopupWindow();
          }
          
          protected boolean onForwardingStarted() {
            this.a.showPopup();
            return true;
          }
          
          protected boolean onForwardingStopped() {
            this.a.dismissPopup();
            return true;
          }
        });
    this.b = frameLayout;
    this.l = (ImageView)frameLayout.findViewById(R.id.image);
    this.l.setImageDrawable(drawable);
    this.a = new ActivityChooserViewAdapter(this);
    this.a.registerDataSetObserver(new DataSetObserver(this) {
          public void onChanged() {
            super.onChanged();
            this.a.a();
          }
        });
    Resources resources = paramContext.getResources();
    this.n = Math.max((resources.getDisplayMetrics()).widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
  }
  
  void a() {
    if (this.a.getCount() > 0) {
      this.b.setEnabled(true);
    } else {
      this.b.setEnabled(false);
    } 
    int i = this.a.getActivityCount();
    int j = this.a.getHistorySize();
    if (i == 1 || (i > 1 && j > 0)) {
      this.c.setVisibility(0);
      ResolveInfo resolveInfo = this.a.getDefaultActivity();
      PackageManager packageManager = getContext().getPackageManager();
      this.m.setImageDrawable(resolveInfo.loadIcon(packageManager));
      if (this.r != 0) {
        CharSequence charSequence = resolveInfo.loadLabel(packageManager);
        charSequence = getContext().getString(this.r, new Object[] { charSequence });
        this.c.setContentDescription(charSequence);
      } 
    } else {
      this.c.setVisibility(8);
    } 
    if (this.c.getVisibility() == 0) {
      this.j.setBackgroundDrawable(this.k);
      return;
    } 
    this.j.setBackgroundDrawable(null);
  }
  
  void a(int paramInt) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean dismissPopup() {
    if (isShowingPopup()) {
      getListPopupWindow().dismiss();
      ViewTreeObserver viewTreeObserver = getViewTreeObserver();
      if (viewTreeObserver.isAlive())
        viewTreeObserver.removeGlobalOnLayoutListener(this.o); 
    } 
    return true;
  }
  
  public ActivityChooserModel getDataModel() {
    return this.a.getDataModel();
  }
  
  ListPopupWindow getListPopupWindow() {
    if (this.p == null) {
      this.p = new ListPopupWindow(getContext());
      this.p.setAdapter((ListAdapter)this.a);
      this.p.setAnchorView((View)this);
      this.p.setModal(true);
      this.p.setOnItemClickListener(this.i);
      this.p.setOnDismissListener(this.i);
    } 
    return this.p;
  }
  
  public boolean isShowingPopup() {
    return getListPopupWindow().isShowing();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    ActivityChooserModel activityChooserModel = this.a.getDataModel();
    if (activityChooserModel != null)
      activityChooserModel.registerObserver(this.e); 
    this.q = true;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    ActivityChooserModel activityChooserModel = this.a.getDataModel();
    if (activityChooserModel != null)
      activityChooserModel.unregisterObserver(this.e); 
    ViewTreeObserver viewTreeObserver = getViewTreeObserver();
    if (viewTreeObserver.isAlive())
      viewTreeObserver.removeGlobalOnLayoutListener(this.o); 
    if (isShowingPopup())
      dismissPopup(); 
    this.q = false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.j.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!isShowingPopup())
      dismissPopup(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    View view = this.j;
    int i = paramInt2;
    if (this.c.getVisibility() != 0)
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824); 
    measureChild(view, paramInt1, i);
    setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
  }
  
  public void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel) {
    this.a.setDataModel(paramActivityChooserModel);
    if (isShowingPopup()) {
      dismissPopup();
      showPopup();
    } 
  }
  
  public void setDefaultActionButtonContentDescription(int paramInt) {
    this.r = paramInt;
  }
  
  public void setExpandActivityOverflowButtonContentDescription(int paramInt) {
    String str = getContext().getString(paramInt);
    this.l.setContentDescription(str);
  }
  
  public void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable) {
    this.l.setImageDrawable(paramDrawable);
  }
  
  public void setInitialActivityCount(int paramInt) {
    this.h = paramInt;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener) {
    this.f = paramOnDismissListener;
  }
  
  public void setProvider(ActionProvider paramActionProvider) {
    this.d = paramActionProvider;
  }
  
  public boolean showPopup() {
    if (!isShowingPopup()) {
      if (!this.q)
        return false; 
      this.g = false;
      a(this.h);
      return true;
    } 
    return false;
  }
  
  class ActivityChooserViewAdapter extends BaseAdapter {
    public static final int MAX_ACTIVITY_COUNT_DEFAULT = 4;
    
    public static final int MAX_ACTIVITY_COUNT_UNLIMITED = 2147483647;
    
    private ActivityChooserModel b;
    
    private int c = 4;
    
    private boolean d;
    
    private boolean e;
    
    private boolean f;
    
    ActivityChooserViewAdapter(ActivityChooserView this$0) {}
    
    public int getActivityCount() {
      return this.b.getActivityCount();
    }
    
    public int getCount() {
      int j = this.b.getActivityCount();
      int i = j;
      if (!this.d) {
        i = j;
        if (this.b.getDefaultActivity() != null)
          i = j - 1; 
      } 
      j = Math.min(i, this.c);
      i = j;
      if (this.f)
        i = j + 1; 
      return i;
    }
    
    public ActivityChooserModel getDataModel() {
      return this.b;
    }
    
    public ResolveInfo getDefaultActivity() {
      return this.b.getDefaultActivity();
    }
    
    public int getHistorySize() {
      return this.b.getHistorySize();
    }
    
    public Object getItem(int param1Int) {
      int i = getItemViewType(param1Int);
      if (i != 0) {
        if (i == 1)
          return null; 
        throw new IllegalArgumentException();
      } 
      i = param1Int;
      if (!this.d) {
        i = param1Int;
        if (this.b.getDefaultActivity() != null)
          i = param1Int + 1; 
      } 
      return this.b.getActivity(i);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public int getItemViewType(int param1Int) {
      return (this.f && param1Int == getCount() - 1) ? 1 : 0;
    }
    
    public boolean getShowDefaultActivity() {
      return this.d;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      // Byte code:
      //   0: aload_0
      //   1: iload_1
      //   2: invokevirtual getItemViewType : (I)I
      //   5: istore #4
      //   7: iload #4
      //   9: ifeq -> 97
      //   12: iload #4
      //   14: iconst_1
      //   15: if_icmpne -> 89
      //   18: aload_2
      //   19: ifnull -> 33
      //   22: aload_2
      //   23: astore #5
      //   25: aload_2
      //   26: invokevirtual getId : ()I
      //   29: iconst_1
      //   30: if_icmpeq -> 86
      //   33: aload_0
      //   34: getfield a : Landroidx/appcompat/widget/ActivityChooserView;
      //   37: invokevirtual getContext : ()Landroid/content/Context;
      //   40: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   43: getstatic androidx/appcompat/R$layout.abc_activity_chooser_view_list_item : I
      //   46: aload_3
      //   47: iconst_0
      //   48: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
      //   51: astore #5
      //   53: aload #5
      //   55: iconst_1
      //   56: invokevirtual setId : (I)V
      //   59: aload #5
      //   61: getstatic androidx/appcompat/R$id.title : I
      //   64: invokevirtual findViewById : (I)Landroid/view/View;
      //   67: checkcast android/widget/TextView
      //   70: aload_0
      //   71: getfield a : Landroidx/appcompat/widget/ActivityChooserView;
      //   74: invokevirtual getContext : ()Landroid/content/Context;
      //   77: getstatic androidx/appcompat/R$string.abc_activity_chooser_view_see_all : I
      //   80: invokevirtual getString : (I)Ljava/lang/String;
      //   83: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   86: aload #5
      //   88: areturn
      //   89: new java/lang/IllegalArgumentException
      //   92: dup
      //   93: invokespecial <init> : ()V
      //   96: athrow
      //   97: aload_2
      //   98: ifnull -> 114
      //   101: aload_2
      //   102: astore #5
      //   104: aload_2
      //   105: invokevirtual getId : ()I
      //   108: getstatic androidx/appcompat/R$id.list_item : I
      //   111: if_icmpeq -> 134
      //   114: aload_0
      //   115: getfield a : Landroidx/appcompat/widget/ActivityChooserView;
      //   118: invokevirtual getContext : ()Landroid/content/Context;
      //   121: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
      //   124: getstatic androidx/appcompat/R$layout.abc_activity_chooser_view_list_item : I
      //   127: aload_3
      //   128: iconst_0
      //   129: invokevirtual inflate : (ILandroid/view/ViewGroup;Z)Landroid/view/View;
      //   132: astore #5
      //   134: aload_0
      //   135: getfield a : Landroidx/appcompat/widget/ActivityChooserView;
      //   138: invokevirtual getContext : ()Landroid/content/Context;
      //   141: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
      //   144: astore_2
      //   145: aload #5
      //   147: getstatic androidx/appcompat/R$id.icon : I
      //   150: invokevirtual findViewById : (I)Landroid/view/View;
      //   153: checkcast android/widget/ImageView
      //   156: astore_3
      //   157: aload_0
      //   158: iload_1
      //   159: invokevirtual getItem : (I)Ljava/lang/Object;
      //   162: checkcast android/content/pm/ResolveInfo
      //   165: astore #6
      //   167: aload_3
      //   168: aload #6
      //   170: aload_2
      //   171: invokevirtual loadIcon : (Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;
      //   174: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
      //   177: aload #5
      //   179: getstatic androidx/appcompat/R$id.title : I
      //   182: invokevirtual findViewById : (I)Landroid/view/View;
      //   185: checkcast android/widget/TextView
      //   188: aload #6
      //   190: aload_2
      //   191: invokevirtual loadLabel : (Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
      //   194: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   197: aload_0
      //   198: getfield d : Z
      //   201: ifeq -> 224
      //   204: iload_1
      //   205: ifne -> 224
      //   208: aload_0
      //   209: getfield e : Z
      //   212: ifeq -> 224
      //   215: aload #5
      //   217: iconst_1
      //   218: invokevirtual setActivated : (Z)V
      //   221: aload #5
      //   223: areturn
      //   224: aload #5
      //   226: iconst_0
      //   227: invokevirtual setActivated : (Z)V
      //   230: aload #5
      //   232: areturn
    }
    
    public int getViewTypeCount() {
      return 3;
    }
    
    public int measureContentWidth() {
      int k = this.c;
      this.c = Integer.MAX_VALUE;
      int i = 0;
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = getCount();
      View view = null;
      int j = 0;
      while (i < i1) {
        view = getView(i, view, (ViewGroup)null);
        view.measure(m, n);
        j = Math.max(j, view.getMeasuredWidth());
        i++;
      } 
      this.c = k;
      return j;
    }
    
    public void setDataModel(ActivityChooserModel param1ActivityChooserModel) {
      ActivityChooserModel activityChooserModel = this.a.a.getDataModel();
      if (activityChooserModel != null && this.a.isShown())
        activityChooserModel.unregisterObserver(this.a.e); 
      this.b = param1ActivityChooserModel;
      if (param1ActivityChooserModel != null && this.a.isShown())
        param1ActivityChooserModel.registerObserver(this.a.e); 
      notifyDataSetChanged();
    }
    
    public void setMaxActivityCount(int param1Int) {
      if (this.c != param1Int) {
        this.c = param1Int;
        notifyDataSetChanged();
      } 
    }
    
    public void setShowDefaultActivity(boolean param1Boolean1, boolean param1Boolean2) {
      if (this.d != param1Boolean1 || this.e != param1Boolean2) {
        this.d = param1Boolean1;
        this.e = param1Boolean2;
        notifyDataSetChanged();
      } 
    }
    
    public void setShowFooterView(boolean param1Boolean) {
      if (this.f != param1Boolean) {
        this.f = param1Boolean;
        notifyDataSetChanged();
      } 
    }
  }
  
  class Callbacks implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    Callbacks(ActivityChooserView this$0) {}
    
    private void a() {
      if (this.a.f != null)
        this.a.f.onDismiss(); 
    }
    
    public void onClick(View param1View) {
      Intent intent;
      if (param1View == this.a.c) {
        this.a.dismissPopup();
        ResolveInfo resolveInfo = this.a.a.getDefaultActivity();
        int i = this.a.a.getDataModel().getActivityIndex(resolveInfo);
        intent = this.a.a.getDataModel().chooseActivity(i);
        if (intent != null) {
          intent.addFlags(524288);
          this.a.getContext().startActivity(intent);
          return;
        } 
      } else {
        if (intent == this.a.b) {
          ActivityChooserView activityChooserView = this.a;
          activityChooserView.g = false;
          activityChooserView.a(activityChooserView.h);
          return;
        } 
        throw new IllegalArgumentException();
      } 
    }
    
    public void onDismiss() {
      a();
      if (this.a.d != null)
        this.a.d.subUiVisibilityChanged(false); 
    }
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      int i = ((ActivityChooserView.ActivityChooserViewAdapter)param1AdapterView.getAdapter()).getItemViewType(param1Int);
      if (i != 0) {
        if (i == 1) {
          this.a.a(2147483647);
          return;
        } 
        throw new IllegalArgumentException();
      } 
      this.a.dismissPopup();
      if (this.a.g) {
        if (param1Int > 0) {
          this.a.a.getDataModel().setDefaultActivity(param1Int);
          return;
        } 
      } else {
        if (!this.a.a.getShowDefaultActivity())
          param1Int++; 
        Intent intent = this.a.a.getDataModel().chooseActivity(param1Int);
        if (intent != null) {
          intent.addFlags(524288);
          this.a.getContext().startActivity(intent);
        } 
      } 
    }
    
    public boolean onLongClick(View param1View) {
      if (param1View == this.a.c) {
        if (this.a.a.getCount() > 0) {
          ActivityChooserView activityChooserView = this.a;
          activityChooserView.g = true;
          activityChooserView.a(activityChooserView.h);
        } 
        return true;
      } 
      throw new IllegalArgumentException();
    }
  }
  
  public static class InnerLayout extends LinearLayout {
    private static final int[] a = new int[] { 16842964 };
    
    public InnerLayout(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(param1Context, param1AttributeSet, a);
      setBackgroundDrawable(tintTypedArray.getDrawable(0));
      tintTypedArray.recycle();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ActivityChooserView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */