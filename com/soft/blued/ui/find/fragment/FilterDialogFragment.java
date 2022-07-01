package com.soft.blued.ui.find.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.view.tip.dialog.CommonDialogFragment;

public class FilterDialogFragment extends CommonDialogFragment {
  public static boolean a;
  
  public static boolean b;
  
  private FilterFragment c;
  
  public void a(View paramView) {}
  
  public int f() {
    return 2131492994;
  }
  
  public int g() {
    return (int)(AppInfo.m / 6.0F * 5.0F);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    EventTrackGuy.a(GuyProtos.Event.SCREEN_PAGE_SHOW);
    a = true;
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    OutsideClickDialog outsideClickDialog = new OutsideClickDialog(getContext(), 2131820782);
    outsideClickDialog.setCanceledOnTouchOutside(true);
    outsideClickDialog.a(new OutsideClickDialog.OnOutsideClickListener(this) {
          public boolean a() {
            if (FilterDialogFragment.a(this.a) != null)
              FilterDialogFragment.a(this.a).n(); 
            return true;
          }
        });
    if (Build.VERSION.SDK_INT >= 19)
      outsideClickDialog.getWindow().addFlags(67108864); 
    return outsideClickDialog;
  }
  
  public void onDestroy() {
    super.onDestroy();
    getActivity().getWindow().setSoftInputMode(35);
    a = false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
    this.c = new FilterFragment();
    this.c.d = this;
    getChildFragmentManager().beginTransaction().replace(2131297192, (Fragment)this.c).commitAllowingStateLoss();
  }
  
  static class OutsideClickDialog extends Dialog {
    private boolean a;
    
    private OnOutsideClickListener b;
    
    public OutsideClickDialog(Context param1Context, int param1Int) {
      super(param1Context, param1Int);
    }
    
    private boolean a(Context param1Context, MotionEvent param1MotionEvent) {
      int i = (int)param1MotionEvent.getX();
      int j = (int)param1MotionEvent.getY();
      int k = ViewConfiguration.get(param1Context).getScaledWindowTouchSlop();
      View view = getWindow().getDecorView();
      int m = -k;
      return (i < m || j < m || i > view.getWidth() + k || j > view.getHeight() + k);
    }
    
    public void a(OnOutsideClickListener param1OnOutsideClickListener) {
      this.b = param1OnOutsideClickListener;
    }
    
    public boolean onTouchEvent(MotionEvent param1MotionEvent) {
      if (!this.a || !isShowing() || ((param1MotionEvent.getAction() != 1 || !a(getContext(), param1MotionEvent)) && param1MotionEvent.getAction() != 4) || this.b.a());
      return true;
    }
    
    public void setCanceledOnTouchOutside(boolean param1Boolean) {
      super.setCanceledOnTouchOutside(param1Boolean);
      this.a = param1Boolean;
    }
    
    static interface OnOutsideClickListener {
      boolean a();
    }
  }
  
  static interface OnOutsideClickListener {
    boolean a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\FilterDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */