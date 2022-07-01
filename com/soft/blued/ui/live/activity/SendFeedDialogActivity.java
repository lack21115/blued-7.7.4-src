package com.soft.blued.ui.live.activity;

import android.os.Bundle;
import android.widget.TextView;
import com.blued.android.module.live_china.activity.LiveFloatDialogActivity;
import com.soft.blued.ui.discover.fragment.SendFeedFloatManager;
import com.soft.blued.ui.feed.manager.FeedSendManager;
import com.soft.blued.ui.msg.customview.GlobalTaskFloatManager;

public class SendFeedDialogActivity extends LiveFloatDialogActivity {
  public int i;
  
  public void d() {
    TextView textView = (TextView)this.h.findViewById(2131300703);
    int i = this.i;
    if (i == 0) {
      textView.setText(getString(2131756404));
      return;
    } 
    if (i == 1)
      textView.setText(getString(2131759004)); 
  }
  
  public void e() {
    int i = this.i;
    if (i == 0) {
      if (FeedSendManager.a().d() != null && FeedSendManager.a().d().size() > 0) {
        SendFeedFloatManager.a().d();
        return;
      } 
    } else if (i == 1) {
      GlobalTaskFloatManager.a().c();
    } 
  }
  
  public void f() {
    if (this.i == 0) {
      SendFeedFloatManager.a().a(false);
      SendFeedFloatManager.a().c();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.i = getIntent().getIntExtra("type", 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\activity\SendFeedDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */