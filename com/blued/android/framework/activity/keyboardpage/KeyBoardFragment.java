package com.blued.android.framework.activity.keyboardpage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.blued.android.framework.activity.HomeTabFragment;
import com.blued.android.framework.utils.KeyboardUtils;

public class KeyBoardFragment extends HomeTabFragment {
  private static long e;
  
  public KeyboardListenLinearLayout g;
  
  public View h;
  
  public EditText i;
  
  public View j;
  
  public View k;
  
  public boolean l;
  
  public View m;
  
  public boolean n;
  
  public static boolean aP_() {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - e;
    if (0L < l2 && l2 < 600L)
      return true; 
    e = l1;
    return false;
  }
  
  public boolean C_() {
    return true;
  }
  
  public void N_() {
    if (aP_())
      return; 
    if (this.h.getVisibility() == 0) {
      this.h.setVisibility(8);
      this.i.setFocusable(true);
      this.i.setFocusableInTouchMode(true);
      this.i.requestFocus();
      KeyboardUtils.c((Activity)getActivity());
      n();
      return;
    } 
    this.h.setVisibility(0);
    KeyboardUtils.a((Activity)getActivity());
    n();
    e_(-4);
  }
  
  public void O_() {
    if (this.h.getVisibility() == 0) {
      this.i.setFocusable(true);
      this.i.setFocusableInTouchMode(true);
      this.i.requestFocus();
      KeyboardUtils.c((Activity)getActivity());
      n();
      return;
    } 
    this.h.setVisibility(0);
    this.j.setVisibility(0);
    KeyboardUtils.a((Activity)getActivity());
    n();
    e_(-4);
  }
  
  public void P_() {
    if (this.h.getVisibility() == 0) {
      if (this.j.getVisibility() == 0 || this.m.getVisibility() == 0) {
        this.k.setVisibility(0);
        this.j.setVisibility(8);
        this.m.setVisibility(8);
        e_(-5);
        return;
      } 
      this.i.setFocusable(true);
      this.i.setFocusableInTouchMode(true);
      this.i.requestFocus();
      KeyboardUtils.c((Activity)getActivity());
      n();
      return;
    } 
    this.h.setVisibility(0);
    this.k.setVisibility(0);
    this.j.setVisibility(8);
    this.m.setVisibility(8);
    KeyboardUtils.a((Activity)getActivity());
    n();
    e_(-5);
  }
  
  public void Q_() {
    if (this.h.getVisibility() == 0) {
      if (this.k.getVisibility() == 0 || this.j.getVisibility() == 0) {
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.m.setVisibility(0);
        e_(-6);
        return;
      } 
      this.i.setFocusable(true);
      this.i.setFocusableInTouchMode(true);
      this.i.requestFocus();
      KeyboardUtils.c((Activity)getActivity());
      n();
      return;
    } 
    this.h.setVisibility(0);
    this.m.setVisibility(0);
    this.k.setVisibility(8);
    this.j.setVisibility(8);
    KeyboardUtils.a((Activity)getActivity());
    n();
    e_(-4);
  }
  
  public boolean W_() {
    return super.W_();
  }
  
  public String X_() {
    return super.X_();
  }
  
  public void a(View paramView, KeyboardListenLinearLayout paramKeyboardListenLinearLayout, EditText paramEditText) {
    this.h = paramView;
    this.g = paramKeyboardListenLinearLayout;
    this.i = paramEditText;
    m();
  }
  
  public void a(View paramView1, KeyboardListenLinearLayout paramKeyboardListenLinearLayout, EditText paramEditText, View paramView2) {
    this.h = paramView1;
    this.g = paramKeyboardListenLinearLayout;
    this.i = paramEditText;
    this.j = paramView2;
    m();
  }
  
  public void a(View paramView1, KeyboardListenLinearLayout paramKeyboardListenLinearLayout, EditText paramEditText, View paramView2, View paramView3, View paramView4) {
    this.h = paramView1;
    this.g = paramKeyboardListenLinearLayout;
    this.i = paramEditText;
    this.j = paramView2;
    this.k = paramView3;
    this.m = paramView4;
    m();
  }
  
  public void a(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    this.g = paramKeyboardListenLinearLayout;
    aQ_();
  }
  
  protected void aQ_() {
    this.g.setOnKeyboardStateChangedListener(new KeyboardListenLinearLayout.IOnKeyboardStateChangedListener(this) {
          public void a(int param1Int) {
            if (param1Int != -3) {
              if (param1Int != -2)
                return; 
              this.a.e_(-2);
              return;
            } 
            this.a.e_(-3);
          }
        });
  }
  
  protected void b(View paramView) {
    if (paramView.getVisibility() == 4)
      paramView.setVisibility(8); 
  }
  
  protected void c(View paramView) {
    if (paramView.getVisibility() == 0)
      paramView.setVisibility(4); 
  }
  
  public void e_(int paramInt) {}
  
  protected void m() {
    this.g.setOnKeyboardStateChangedListener(new KeyboardListenLinearLayout.IOnKeyboardStateChangedListener(this) {
          public void a(int param1Int) {
            if (param1Int != -3) {
              if (param1Int != -2)
                return; 
              KeyBoardFragment keyBoardFragment = this.a;
              keyBoardFragment.b(keyBoardFragment.h);
              this.a.e_(-2);
              this.a.l = false;
              return;
            } 
            this.a.getActivity().getWindow().setSoftInputMode(19);
            if (this.a.n) {
              KeyBoardFragment keyBoardFragment = this.a;
              keyBoardFragment.c(keyBoardFragment.h);
            } else {
              KeyBoardFragment keyBoardFragment = this.a;
              keyBoardFragment.b(keyBoardFragment.h);
            } 
            this.a.n();
            this.a.e_(-3);
            this.a.l = true;
          }
        });
  }
  
  protected void n() {
    ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
    layoutParams.height = KeyboardUtils.a();
    this.h.setLayoutParams(layoutParams);
  }
  
  public void q() {
    if (this.h.getVisibility() == 0) {
      if (this.k.getVisibility() == 0 || this.m.getVisibility() == 0) {
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        this.m.setVisibility(8);
        e_(-4);
        return;
      } 
      this.i.setFocusable(true);
      this.i.setFocusableInTouchMode(true);
      this.i.requestFocus();
      KeyboardUtils.c((Activity)getActivity());
      n();
      return;
    } 
    this.h.setVisibility(0);
    this.j.setVisibility(0);
    this.k.setVisibility(8);
    this.m.setVisibility(8);
    KeyboardUtils.a((Activity)getActivity());
    n();
    e_(-4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\activity\keyboardpage\KeyBoardFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */