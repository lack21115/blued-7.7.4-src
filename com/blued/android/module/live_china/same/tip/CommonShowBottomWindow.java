package com.blued.android.module.live_china.same.tip;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.media.selector.view.ActionSheet;

public class CommonShowBottomWindow {
  public static ActionSheet a(FragmentActivity paramFragmentActivity, String[] paramArrayOfString, String paramString, ActionSheet.ActionSheetListener paramActionSheetListener) {
    paramFragmentActivity.setTheme(R.style.ActionSheetStyleIOS7);
    return ActionSheet.a((Context)paramFragmentActivity, paramFragmentActivity.getFragmentManager()).a(paramFragmentActivity.getResources().getString(R.string.biao_v4_cancel)).a(paramArrayOfString).b(paramString).a(true).a(paramActionSheetListener).b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\same\tip\CommonShowBottomWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */