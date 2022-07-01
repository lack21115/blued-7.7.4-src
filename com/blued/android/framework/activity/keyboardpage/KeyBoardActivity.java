package com.blued.android.framework.activity.keyboardpage;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.utils.KeyboardUtils;

public class KeyBoardActivity extends FragmentActivity {
  public View a;
  
  public boolean b;
  
  private void a() {
    try {
      LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
      layoutParams.height = KeyboardUtils.a();
      this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      return;
    } catch (Exception exception) {
      RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      layoutParams.height = KeyboardUtils.a();
      this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      return;
    } 
  }
  
  private void a(View paramView) {
    if (paramView.getVisibility() == 4) {
      getWindow().setSoftInputMode(19);
      try {
        Thread.sleep(200L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      paramView.setVisibility(8);
    } 
  }
  
  private void b(View paramView) {
    if (paramView.getVisibility() == 0) {
      try {
        Thread.sleep(200L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      paramView.setVisibility(4);
    } 
  }
  
  public void a(int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\activity\keyboardpage\KeyBoardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */