package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class DropdownMenuEndIconDelegate extends EndIconDelegate {
  private static final boolean d;
  
  private final TextWatcher e = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {
        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.a;
        AutoCompleteTextView autoCompleteTextView = DropdownMenuEndIconDelegate.a(dropdownMenuEndIconDelegate, dropdownMenuEndIconDelegate.a.getEditText());
        autoCompleteTextView.post(new Runnable(this, autoCompleteTextView) {
              public void run() {
                boolean bool = this.a.isPopupShowing();
                DropdownMenuEndIconDelegate.a(this.b.a, bool);
                DropdownMenuEndIconDelegate.b(this.b.a, bool);
              }
            });
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private final View.OnFocusChangeListener f = new View.OnFocusChangeListener(this) {
      public void onFocusChange(View param1View, boolean param1Boolean) {
        this.a.a.setEndIconActivated(param1Boolean);
        if (!param1Boolean) {
          DropdownMenuEndIconDelegate.a(this.a, false);
          DropdownMenuEndIconDelegate.b(this.a, false);
        } 
      }
    };
  
  private final TextInputLayout.AccessibilityDelegate g = new TextInputLayout.AccessibilityDelegate(this, this.a) {
      public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
        if (this.a.a.getEditText().getKeyListener() == null)
          param1AccessibilityNodeInfoCompat.setClassName(Spinner.class.getName()); 
        if (param1AccessibilityNodeInfoCompat.isShowingHintText())
          param1AccessibilityNodeInfoCompat.setHintText(null); 
      }
      
      public void onPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
        super.onPopulateAccessibilityEvent(param1View, param1AccessibilityEvent);
        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.a;
        AutoCompleteTextView autoCompleteTextView = DropdownMenuEndIconDelegate.a(dropdownMenuEndIconDelegate, dropdownMenuEndIconDelegate.a.getEditText());
        if (param1AccessibilityEvent.getEventType() == 1 && DropdownMenuEndIconDelegate.a(this.a).isTouchExplorationEnabled())
          DropdownMenuEndIconDelegate.a(this.a, autoCompleteTextView); 
      }
    };
  
  private final TextInputLayout.OnEditTextAttachedListener h = new TextInputLayout.OnEditTextAttachedListener(this) {
      public void a(TextInputLayout param1TextInputLayout) {
        AutoCompleteTextView autoCompleteTextView = DropdownMenuEndIconDelegate.a(this.a, param1TextInputLayout.getEditText());
        DropdownMenuEndIconDelegate.b(this.a, autoCompleteTextView);
        DropdownMenuEndIconDelegate.c(this.a, autoCompleteTextView);
        DropdownMenuEndIconDelegate.d(this.a, autoCompleteTextView);
        autoCompleteTextView.setThreshold(0);
        autoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.b(this.a));
        autoCompleteTextView.addTextChangedListener(DropdownMenuEndIconDelegate.b(this.a));
        param1TextInputLayout.setEndIconCheckable(true);
        param1TextInputLayout.setErrorIconDrawable((Drawable)null);
        param1TextInputLayout.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.c(this.a));
        param1TextInputLayout.setEndIconVisible(true);
      }
    };
  
  private final TextInputLayout.OnEndIconChangedListener i = new TextInputLayout.OnEndIconChangedListener(this) {
      public void a(TextInputLayout param1TextInputLayout, int param1Int) {
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)param1TextInputLayout.getEditText();
        if (autoCompleteTextView != null && param1Int == 3) {
          autoCompleteTextView.removeTextChangedListener(DropdownMenuEndIconDelegate.b(this.a));
          if (autoCompleteTextView.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.d(this.a))
            autoCompleteTextView.setOnFocusChangeListener(null); 
          autoCompleteTextView.setOnTouchListener(null);
          if (DropdownMenuEndIconDelegate.c())
            autoCompleteTextView.setOnDismissListener(null); 
        } 
      }
    };
  
  private boolean j = false;
  
  private boolean k = false;
  
  private long l = Long.MAX_VALUE;
  
  private StateListDrawable m;
  
  private MaterialShapeDrawable n;
  
  private AccessibilityManager o;
  
  private ValueAnimator p;
  
  private ValueAnimator q;
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    d = bool;
  }
  
  DropdownMenuEndIconDelegate(TextInputLayout paramTextInputLayout) {
    super(paramTextInputLayout);
  }
  
  private ValueAnimator a(int paramInt, float... paramVarArgs) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(paramVarArgs);
    valueAnimator.setInterpolator(AnimationUtils.a);
    valueAnimator.setDuration(paramInt);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.a.c.setAlpha(f);
          }
        });
    return valueAnimator;
  }
  
  private AutoCompleteTextView a(EditText paramEditText) {
    if (paramEditText instanceof AutoCompleteTextView)
      return (AutoCompleteTextView)paramEditText; 
    throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
  }
  
  private MaterialShapeDrawable a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {
    ShapeAppearanceModel shapeAppearanceModel = ShapeAppearanceModel.a().b(paramFloat1).c(paramFloat1).e(paramFloat2).d(paramFloat2).a();
    MaterialShapeDrawable materialShapeDrawable = MaterialShapeDrawable.a(this.b, paramFloat3);
    materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
    materialShapeDrawable.a(0, paramInt, 0, paramInt);
    return materialShapeDrawable;
  }
  
  private void a(AutoCompleteTextView paramAutoCompleteTextView) {
    if (paramAutoCompleteTextView == null)
      return; 
    if (d())
      this.j = false; 
    if (!this.j) {
      if (d) {
        b(this.k ^ true);
      } else {
        this.k ^= 0x1;
        this.c.toggle();
      } 
      if (this.k) {
        paramAutoCompleteTextView.requestFocus();
        paramAutoCompleteTextView.showDropDown();
        return;
      } 
      paramAutoCompleteTextView.dismissDropDown();
      return;
    } 
    this.j = false;
  }
  
  private void a(AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfint, MaterialShapeDrawable paramMaterialShapeDrawable) {
    LayerDrawable layerDrawable;
    int i = MaterialColors.a((View)paramAutoCompleteTextView, R.attr.colorSurface);
    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(paramMaterialShapeDrawable.getShapeAppearanceModel());
    paramInt = MaterialColors.a(paramInt, i, 0.1F);
    materialShapeDrawable.g(new ColorStateList(paramArrayOfint, new int[] { paramInt, 0 }));
    if (d) {
      materialShapeDrawable.setTint(i);
      ColorStateList colorStateList = new ColorStateList(paramArrayOfint, new int[] { paramInt, i });
      MaterialShapeDrawable materialShapeDrawable1 = new MaterialShapeDrawable(paramMaterialShapeDrawable.getShapeAppearanceModel());
      materialShapeDrawable1.setTint(-1);
      layerDrawable = new LayerDrawable(new Drawable[] { (Drawable)new RippleDrawable(colorStateList, (Drawable)materialShapeDrawable, (Drawable)materialShapeDrawable1), (Drawable)paramMaterialShapeDrawable });
    } else {
      layerDrawable = new LayerDrawable(new Drawable[] { (Drawable)materialShapeDrawable, (Drawable)paramMaterialShapeDrawable });
    } 
    ViewCompat.setBackground((View)paramAutoCompleteTextView, (Drawable)layerDrawable);
  }
  
  private void b(AutoCompleteTextView paramAutoCompleteTextView) {
    if (d) {
      int i = this.a.getBoxBackgroundMode();
      if (i == 2) {
        paramAutoCompleteTextView.setDropDownBackgroundDrawable((Drawable)this.n);
        return;
      } 
      if (i == 1)
        paramAutoCompleteTextView.setDropDownBackgroundDrawable((Drawable)this.m); 
    } 
  }
  
  private void b(AutoCompleteTextView paramAutoCompleteTextView, int paramInt, int[][] paramArrayOfint, MaterialShapeDrawable paramMaterialShapeDrawable) {
    int i = this.a.getBoxBackgroundColor();
    paramInt = MaterialColors.a(paramInt, i, 0.1F);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramInt;
    arrayOfInt[1] = i;
    if (d) {
      ViewCompat.setBackground((View)paramAutoCompleteTextView, (Drawable)new RippleDrawable(new ColorStateList(paramArrayOfint, arrayOfInt), (Drawable)paramMaterialShapeDrawable, (Drawable)paramMaterialShapeDrawable));
      return;
    } 
    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(paramMaterialShapeDrawable.getShapeAppearanceModel());
    materialShapeDrawable.g(new ColorStateList(paramArrayOfint, arrayOfInt));
    LayerDrawable layerDrawable = new LayerDrawable(new Drawable[] { (Drawable)paramMaterialShapeDrawable, (Drawable)materialShapeDrawable });
    paramInt = ViewCompat.getPaddingStart((View)paramAutoCompleteTextView);
    i = paramAutoCompleteTextView.getPaddingTop();
    int j = ViewCompat.getPaddingEnd((View)paramAutoCompleteTextView);
    int k = paramAutoCompleteTextView.getPaddingBottom();
    ViewCompat.setBackground((View)paramAutoCompleteTextView, (Drawable)layerDrawable);
    ViewCompat.setPaddingRelative((View)paramAutoCompleteTextView, paramInt, i, j, k);
  }
  
  private void b(boolean paramBoolean) {
    if (this.k != paramBoolean) {
      this.k = paramBoolean;
      this.q.cancel();
      this.p.start();
    } 
  }
  
  private void c(AutoCompleteTextView paramAutoCompleteTextView) {
    if (paramAutoCompleteTextView.getKeyListener() != null)
      return; 
    int i = this.a.getBoxBackgroundMode();
    MaterialShapeDrawable materialShapeDrawable = this.a.getBoxBackground();
    int j = MaterialColors.a((View)paramAutoCompleteTextView, R.attr.colorControlHighlight);
    int[][] arrayOfInt = new int[2][];
    (new int[1])[0] = 16842919;
    arrayOfInt[0] = new int[1];
    arrayOfInt[1] = new int[0];
    if (i == 2) {
      a(paramAutoCompleteTextView, j, arrayOfInt, materialShapeDrawable);
      return;
    } 
    if (i == 1)
      b(paramAutoCompleteTextView, j, arrayOfInt, materialShapeDrawable); 
  }
  
  private void d(AutoCompleteTextView paramAutoCompleteTextView) {
    paramAutoCompleteTextView.setOnTouchListener(new View.OnTouchListener(this, paramAutoCompleteTextView) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 1) {
              if (DropdownMenuEndIconDelegate.e(this.b))
                DropdownMenuEndIconDelegate.b(this.b, false); 
              DropdownMenuEndIconDelegate.a(this.b, this.a);
            } 
            return false;
          }
        });
    paramAutoCompleteTextView.setOnFocusChangeListener(this.f);
    if (d)
      paramAutoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener(this) {
            public void onDismiss() {
              DropdownMenuEndIconDelegate.b(this.a, true);
              DropdownMenuEndIconDelegate.a(this.a, System.currentTimeMillis());
              DropdownMenuEndIconDelegate.a(this.a, false);
            }
          }); 
  }
  
  private boolean d() {
    long l = System.currentTimeMillis() - this.l;
    return (l < 0L || l > 300L);
  }
  
  private void e() {
    this.q = a(67, new float[] { 0.0F, 1.0F });
    this.p = a(50, new float[] { 1.0F, 0.0F });
    this.p.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            this.a.c.setChecked(DropdownMenuEndIconDelegate.f(this.a));
            DropdownMenuEndIconDelegate.g(this.a).start();
          }
        });
  }
  
  void a() {
    float f1 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
    float f2 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
    int i = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
    MaterialShapeDrawable materialShapeDrawable1 = a(f1, f1, f2, i);
    MaterialShapeDrawable materialShapeDrawable2 = a(0.0F, f1, f2, i);
    this.n = materialShapeDrawable1;
    this.m = new StateListDrawable();
    this.m.addState(new int[] { 16842922 }, (Drawable)materialShapeDrawable1);
    this.m.addState(new int[0], (Drawable)materialShapeDrawable2);
    if (d) {
      i = R.drawable.mtrl_dropdown_arrow;
    } else {
      i = R.drawable.mtrl_ic_arrow_drop_down;
    } 
    this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, i));
    this.a.setEndIconContentDescription(this.a.getResources().getText(R.string.exposed_dropdown_menu_content_description));
    this.a.setEndIconOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)this.a.a.getEditText();
            DropdownMenuEndIconDelegate.a(this.a, autoCompleteTextView);
          }
        });
    this.a.a(this.h);
    this.a.a(this.i);
    e();
    ViewCompat.setImportantForAccessibility((View)this.c, 2);
    this.o = (AccessibilityManager)this.b.getSystemService("accessibility");
  }
  
  boolean a(int paramInt) {
    return (paramInt != 0);
  }
  
  boolean b() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\DropdownMenuEndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */