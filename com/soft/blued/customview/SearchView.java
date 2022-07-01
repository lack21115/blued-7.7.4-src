package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.utils.SearchTaskTool;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.soft.blued.R;
import com.soft.blued.utils.StringUtils;

public class SearchView extends LinearLayout implements BluedSkinSupportable, SearchTaskTool.TaskListener {
  public View a = null;
  
  public LayoutInflater b;
  
  private View c;
  
  private SearchEditText d;
  
  private ImageView e;
  
  private ImageView f;
  
  private TextView g;
  
  private boolean h;
  
  private boolean i;
  
  private OnSearchInfoListener j;
  
  private Context k;
  
  private int l;
  
  private boolean m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private float q;
  
  private float r;
  
  private RelativeLayout s;
  
  private ShapeLinearLayout t;
  
  private boolean u = true;
  
  public SearchView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = paramContext;
    a(this.k, paramAttributeSet);
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet) {
    if (this.a != null)
      return; 
    this.k = paramContext;
    this.i = false;
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CommonSearchView);
    this.m = typedArray.getBoolean(0, false);
    this.n = typedArray.getResourceId(2, 0);
    this.o = typedArray.getColor(4, 0);
    this.p = typedArray.getColor(3, 0);
    this.q = typedArray.getDimension(5, 0.0F);
    this.r = typedArray.getFloat(1, -1.0F);
    this.b = LayoutInflater.from(this.k);
    this.a = getRootView();
    this.t = (ShapeLinearLayout)this.a.findViewById(2131296967);
    this.s = (RelativeLayout)this.a.findViewById(2131299725);
    this.c = this.a.findViewById(2131299871);
    this.d = (SearchEditText)this.a.findViewById(2131299865);
    float f = this.q;
    if (f != 0.0F)
      this.d.setTextSize(f); 
    int i = this.p;
    if (i != 0) {
      this.d.setTextColor(i);
    } else {
      this.d.setTextColor(BluedSkinUtils.a(this.k, 2131100838));
    } 
    i = this.n;
    if (i != 0)
      this.d.setHint(i); 
    i = this.o;
    if (i != 0) {
      this.d.setHintTextColor(i);
    } else {
      this.d.setHintTextColor(BluedSkinUtils.a(this.k, 2131100844));
    } 
    f = this.r;
    if (f >= 0.0F)
      setDelaymillis((long)f); 
    this.e = (ImageView)this.a.findViewById(2131299863);
    this.f = (ImageView)this.a.findViewById(2131299867);
    this.g = (TextView)this.a.findViewById(2131299860);
    if (!this.m) {
      this.c.setVisibility(8);
      this.g.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (!TextUtils.isEmpty((CharSequence)SearchView.a(this.a).getText()))
                SearchView.a(this.a).setText(""); 
              if (SearchView.b(this.a) != null)
                SearchView.b(this.a).a(); 
            }
          });
      this.d.setEditorActionListener(true);
      this.d.addTextChangedListener(new TextWatcher(this) {
            public void afterTextChanged(Editable param1Editable) {}
            
            public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
            
            public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
              if (!StringUtils.e(SearchView.a(this.a).getText().toString())) {
                SearchView.c(this.a).setVisibility(0);
                return;
              } 
              SearchView.c(this.a).setVisibility(8);
            }
          });
      this.d.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              SearchView.a(this.a).setFocusableInTouchMode(true);
              SearchView.a(this.a).requestFocus();
              ((InputMethodManager)this.a.getContext().getSystemService("input_method")).showSoftInput((View)SearchView.a(this.a), 0);
            }
          });
      this.d.a(this);
      this.e.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              SearchView.a(this.a).setText("");
              if (SearchView.b(this.a) != null)
                SearchView.b(this.a).b(); 
            }
          });
    } else {
      this.d.setFocusable(false);
      this.c.setVisibility(0);
    } 
    addView(this.a);
  }
  
  public void a(String paramString) {
    OnSearchInfoListener onSearchInfoListener = this.j;
    if (onSearchInfoListener != null)
      onSearchInfoListener.a(paramString); 
  }
  
  public void a(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield u : Z
    //   6: istore #5
    //   8: iload #5
    //   10: ifne -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield i : Z
    //   20: istore #5
    //   22: iload #5
    //   24: iload_1
    //   25: if_icmpne -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield h : Z
    //   35: istore #5
    //   37: iload #5
    //   39: ifeq -> 45
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: invokevirtual getContext : ()Landroid/content/Context;
    //   49: ldc 45.0
    //   51: invokestatic a : (Landroid/content/Context;F)I
    //   54: istore_3
    //   55: aload_0
    //   56: getfield t : Lcom/blued/android/framework/view/shape/ShapeLinearLayout;
    //   59: invokevirtual getWidth : ()I
    //   62: istore #4
    //   64: iload #4
    //   66: ifeq -> 177
    //   69: aload_0
    //   70: iload_1
    //   71: putfield i : Z
    //   74: aload_0
    //   75: getfield l : I
    //   78: ifne -> 187
    //   81: iload_1
    //   82: ifeq -> 187
    //   85: aload_0
    //   86: iload #4
    //   88: putfield l : I
    //   91: goto -> 187
    //   94: iload #4
    //   96: iload_3
    //   97: iadd
    //   98: istore_2
    //   99: aload_0
    //   100: getfield d : Lcom/blued/android/framework/view/SearchEditText;
    //   103: iconst_0
    //   104: invokevirtual setFocusableInTouchMode : (Z)V
    //   107: iconst_2
    //   108: newarray int
    //   110: dup
    //   111: iconst_0
    //   112: iload #4
    //   114: iastore
    //   115: dup
    //   116: iconst_1
    //   117: iload_2
    //   118: iastore
    //   119: invokestatic ofInt : ([I)Landroid/animation/ValueAnimator;
    //   122: astore #6
    //   124: aload #6
    //   126: ldc2_w 300
    //   129: invokevirtual setDuration : (J)Landroid/animation/ValueAnimator;
    //   132: pop
    //   133: aload #6
    //   135: new android/view/animation/LinearInterpolator
    //   138: dup
    //   139: invokespecial <init> : ()V
    //   142: invokevirtual setInterpolator : (Landroid/animation/TimeInterpolator;)V
    //   145: aload #6
    //   147: new com/soft/blued/customview/SearchView$5
    //   150: dup
    //   151: aload_0
    //   152: invokespecial <init> : (Lcom/soft/blued/customview/SearchView;)V
    //   155: invokevirtual addUpdateListener : (Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V
    //   158: aload #6
    //   160: new com/soft/blued/customview/SearchView$6
    //   163: dup
    //   164: aload_0
    //   165: iload_3
    //   166: invokespecial <init> : (Lcom/soft/blued/customview/SearchView;I)V
    //   169: invokevirtual addListener : (Landroid/animation/Animator$AnimatorListener;)V
    //   172: aload #6
    //   174: invokevirtual start : ()V
    //   177: aload_0
    //   178: monitorexit
    //   179: return
    //   180: astore #6
    //   182: aload_0
    //   183: monitorexit
    //   184: aload #6
    //   186: athrow
    //   187: iload_1
    //   188: ifeq -> 94
    //   191: iload #4
    //   193: iload_3
    //   194: isub
    //   195: istore_2
    //   196: goto -> 107
    // Exception table:
    //   from	to	target	type
    //   2	8	180	finally
    //   16	22	180	finally
    //   31	37	180	finally
    //   45	64	180	finally
    //   69	81	180	finally
    //   85	91	180	finally
    //   99	107	180	finally
    //   107	177	180	finally
  }
  
  public void g() {
    this.d.setTextColor(BluedSkinUtils.a(getContext(), 2131100838));
    this.d.setHintTextColor(BluedSkinUtils.a(getContext(), 2131100470));
    ShapeHelper.b((ShapeHelper.ShapeView)this.t, 2131100857);
    this.f.setImageDrawable(BluedSkinUtils.b(getContext(), 2131232699));
  }
  
  public SearchEditText getEditView() {
    return this.d;
  }
  
  public View getRootView() {
    return this.b.inflate(2131494231, null);
  }
  
  public View getSearchRootView() {
    return this.a;
  }
  
  public void setDelaymillis(long paramLong) {
    SearchEditText searchEditText = this.d;
    if (searchEditText != null)
      searchEditText.setDelaymillis(paramLong); 
  }
  
  public void setMaskLayerOnClickListener(View.OnClickListener paramOnClickListener) {
    if (paramOnClickListener != null) {
      this.c.setVisibility(0);
      this.c.setOnClickListener(paramOnClickListener);
    } 
  }
  
  public void setOnSearchInfoListener(OnSearchInfoListener paramOnSearchInfoListener) {
    this.j = paramOnSearchInfoListener;
  }
  
  public void setRootBgColor(int paramInt) {
    this.s.setBackgroundColor(paramInt);
  }
  
  public void setShapeModel(ShapeModel paramShapeModel) {
    this.t.setShapeModel(paramShapeModel);
  }
  
  public static interface OnSearchInfoListener {
    void a();
    
    void a(String param1String);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\SearchView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */