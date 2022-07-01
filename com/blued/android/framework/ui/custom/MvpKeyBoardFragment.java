package com.blued.android.framework.ui.custom;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.KeyboardUtils;

public abstract class MvpKeyBoardFragment<T extends MvpPresenter> extends MvpFragment<T> {
  public KeyboardListenLinearLayout d;
  
  public View e;
  
  public EditText f;
  
  public View g;
  
  public View h;
  
  public boolean i;
  
  public boolean j;
  
  public boolean W_() {
    return super.W_();
  }
  
  public String X_() {
    return super.X_();
  }
  
  public void a(int paramInt) {}
  
  protected void a(View paramView) {
    if (paramView.getVisibility() == 4)
      paramView.setVisibility(8); 
  }
  
  public void a(View paramView1, KeyboardListenLinearLayout paramKeyboardListenLinearLayout, EditText paramEditText, View paramView2) {
    this.e = paramView1;
    this.d = paramKeyboardListenLinearLayout;
    this.f = paramEditText;
    this.g = paramView2;
    l();
  }
  
  public void a(KeyboardListenLinearLayout paramKeyboardListenLinearLayout) {
    this.d = paramKeyboardListenLinearLayout;
    k();
  }
  
  public void aL_() {
    super.aL_();
    KeyboardListenLinearLayout keyboardListenLinearLayout = this.d;
    if (keyboardListenLinearLayout != null)
      keyboardListenLinearLayout.setOnKeyboardStateChangedListener(null); 
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = false;
    this.j = false;
  }
  
  protected void b(View paramView) {
    if (paramView.getVisibility() == 0)
      paramView.setVisibility(4); 
  }
  
  protected void k() {
    this.d.setOnKeyboardStateChangedListener(new KeyboardListenLinearLayout.IOnKeyboardStateChangedListener(this) {
          public void a(int param1Int) {
            if (param1Int != -3) {
              if (param1Int != -2)
                return; 
              this.a.a(-2);
              return;
            } 
            this.a.a(-3);
          }
        });
  }
  
  protected void l() {
    this.d.setOnKeyboardStateChangedListener(new KeyboardListenLinearLayout.IOnKeyboardStateChangedListener(this) {
          public void a(int param1Int) {
            if (param1Int != -3) {
              if (param1Int != -2)
                return; 
              MvpKeyBoardFragment mvpKeyBoardFragment = this.a;
              mvpKeyBoardFragment.a(mvpKeyBoardFragment.e);
              this.a.a(-2);
              this.a.i = false;
              return;
            } 
            this.a.getActivity().getWindow().setSoftInputMode(19);
            if (this.a.j) {
              MvpKeyBoardFragment mvpKeyBoardFragment = this.a;
              mvpKeyBoardFragment.b(mvpKeyBoardFragment.e);
            } else {
              MvpKeyBoardFragment mvpKeyBoardFragment = this.a;
              mvpKeyBoardFragment.a(mvpKeyBoardFragment.e);
            } 
            this.a.m();
            this.a.a(-3);
            this.a.i = true;
          }
        });
  }
  
  protected void m() {
    ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
    layoutParams.height = KeyboardUtils.a();
    this.e.setLayoutParams(layoutParams);
  }
  
  public void n() {
    if (this.e.getVisibility() == 0) {
      this.f.setFocusable(true);
      this.f.setFocusableInTouchMode(true);
      this.f.requestFocus();
      KeyboardUtils.c((Activity)getActivity());
      m();
      return;
    } 
    this.e.setVisibility(0);
    this.g.setVisibility(0);
    KeyboardUtils.a((Activity)getActivity());
    m();
    a(-4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\custom\MvpKeyBoardFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */