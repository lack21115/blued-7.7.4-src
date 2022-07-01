package com.baidu.mobads.production.rewardvideo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.mobads.MobRewardVideoImpl;

public class MobRewardVideoActivity extends Activity {
  MobRewardVideoImpl a = new MobRewardVideoImpl(this);
  
  public void finish() {
    super.finish();
    this.a.finish();
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.a.onAttachedToWindow();
  }
  
  public void onBackPressed() {
    if (!this.a.onBackPressed())
      super.onBackPressed(); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.a.onCreate(paramBundle);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    this.a.onDestroy();
  }
  
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.a.onDetachedFromWindow();
  }
  
  protected void onPause() {
    super.onPause();
    this.a.onPause();
  }
  
  protected void onResume() {
    super.onResume();
    this.a.onResume();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.a.onTouchEvent(paramMotionEvent) ? true : super.onTouchEvent(paramMotionEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    this.a.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\rewardvideo\MobRewardVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */