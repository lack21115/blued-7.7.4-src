package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

class ClearTextEndIconDelegate extends EndIconDelegate {
  private final TextWatcher d = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {
        if (this.a.a.getSuffixText() != null)
          return; 
        ClearTextEndIconDelegate.a(this.a, ClearTextEndIconDelegate.a(param1Editable));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private final View.OnFocusChangeListener e = new View.OnFocusChangeListener(this) {
      public void onFocusChange(View param1View, boolean param1Boolean) {
        boolean bool1 = TextUtils.isEmpty((CharSequence)((EditText)param1View).getText());
        boolean bool = true;
        ClearTextEndIconDelegate clearTextEndIconDelegate = this.a;
        if ((bool1 ^ true) != 0 && param1Boolean) {
          param1Boolean = bool;
        } else {
          param1Boolean = false;
        } 
        ClearTextEndIconDelegate.a(clearTextEndIconDelegate, param1Boolean);
      }
    };
  
  private final TextInputLayout.OnEditTextAttachedListener f = new TextInputLayout.OnEditTextAttachedListener(this) {
      public void a(TextInputLayout param1TextInputLayout) {
        boolean bool;
        EditText editText = param1TextInputLayout.getEditText();
        if (editText.hasFocus() && ClearTextEndIconDelegate.a(editText.getText())) {
          bool = true;
        } else {
          bool = false;
        } 
        param1TextInputLayout.setEndIconVisible(bool);
        param1TextInputLayout.setEndIconCheckable(false);
        editText.setOnFocusChangeListener(ClearTextEndIconDelegate.a(this.a));
        editText.removeTextChangedListener(ClearTextEndIconDelegate.b(this.a));
        editText.addTextChangedListener(ClearTextEndIconDelegate.b(this.a));
      }
    };
  
  private final TextInputLayout.OnEndIconChangedListener g = new TextInputLayout.OnEndIconChangedListener(this) {
      public void a(TextInputLayout param1TextInputLayout, int param1Int) {
        EditText editText = param1TextInputLayout.getEditText();
        if (editText != null && param1Int == 2) {
          editText.removeTextChangedListener(ClearTextEndIconDelegate.b(this.a));
          if (editText.getOnFocusChangeListener() == ClearTextEndIconDelegate.a(this.a))
            editText.setOnFocusChangeListener(null); 
        } 
      }
    };
  
  private AnimatorSet h;
  
  private ValueAnimator i;
  
  ClearTextEndIconDelegate(TextInputLayout paramTextInputLayout) {
    super(paramTextInputLayout);
  }
  
  private ValueAnimator a(float... paramVarArgs) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(paramVarArgs);
    valueAnimator.setInterpolator(AnimationUtils.a);
    valueAnimator.setDuration(100L);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.a.c.setAlpha(f);
          }
        });
    return valueAnimator;
  }
  
  private void b(boolean paramBoolean) {
    boolean bool;
    if (this.a.e() == paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    if (paramBoolean) {
      this.i.cancel();
      this.h.start();
      if (bool) {
        this.h.end();
        return;
      } 
    } else {
      this.h.cancel();
      this.i.start();
      if (bool)
        this.i.end(); 
    } 
  }
  
  private static boolean b(Editable paramEditable) {
    return (paramEditable.length() > 0);
  }
  
  private void c() {
    ValueAnimator valueAnimator1 = d();
    ValueAnimator valueAnimator2 = a(new float[] { 0.0F, 1.0F });
    this.h = new AnimatorSet();
    this.h.playTogether(new Animator[] { (Animator)valueAnimator1, (Animator)valueAnimator2 });
    this.h.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationStart(Animator param1Animator) {
            this.a.a.setEndIconVisible(true);
          }
        });
    this.i = a(new float[] { 1.0F, 0.0F });
    this.i.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            this.a.a.setEndIconVisible(false);
          }
        });
  }
  
  private ValueAnimator d() {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.8F, 1.0F });
    valueAnimator.setInterpolator(AnimationUtils.d);
    valueAnimator.setDuration(150L);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.a.c.setScaleX(f);
            this.a.c.setScaleY(f);
          }
        });
    return valueAnimator;
  }
  
  void a() {
    this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, R.drawable.mtrl_ic_cancel));
    this.a.setEndIconContentDescription(this.a.getResources().getText(R.string.clear_text_end_icon_content_description));
    this.a.setEndIconOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Editable editable = this.a.a.getEditText().getText();
            if (editable != null)
              editable.clear(); 
          }
        });
    this.a.a(this.f);
    this.a.a(this.g);
    c();
  }
  
  void a(boolean paramBoolean) {
    if (this.a.getSuffixText() == null)
      return; 
    b(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\textfield\ClearTextEndIconDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */