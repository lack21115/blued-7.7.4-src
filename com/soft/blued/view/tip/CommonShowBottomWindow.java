package com.soft.blued.view.tip;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import java.util.List;

public class CommonShowBottomWindow {
  public static BasePopupView a(Context paramContext, List<BottomMenuPop.MenuItemInfo> paramList) {
    BottomMenuPop bottomMenuPop = new BottomMenuPop(paramContext);
    bottomMenuPop.b = paramList;
    return (new XPopup.Builder(paramContext)).a((BasePopupView)bottomMenuPop);
  }
  
  @Deprecated
  public static ActionSheet a(FragmentActivity paramFragmentActivity, String[] paramArrayOfString, int paramInt, ActionSheet.ActionSheetListener paramActionSheetListener) {
    paramFragmentActivity.setTheme(2131820544);
    return ActionSheet.a((Context)paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager()).a(paramFragmentActivity.getResources().getString(2131755577)).a(paramArrayOfString).a(paramInt).a(true).a(paramActionSheetListener).b();
  }
  
  @Deprecated
  public static ActionSheet a(FragmentActivity paramFragmentActivity, String[] paramArrayOfString, ActionSheet.ActionSheetListener paramActionSheetListener) {
    return a(paramFragmentActivity, paramArrayOfString, -1, paramActionSheetListener);
  }
  
  @Deprecated
  public static ActionSheet a(FragmentActivity paramFragmentActivity, String[] paramArrayOfString, String paramString, ActionSheet.ActionSheetListener paramActionSheetListener) {
    paramFragmentActivity.setTheme(2131820544);
    return ActionSheet.a((Context)paramFragmentActivity, paramFragmentActivity.getSupportFragmentManager()).a(paramFragmentActivity.getResources().getString(2131755577)).a(paramArrayOfString).b(paramString).a(true).a(paramActionSheetListener).b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\view\tip\CommonShowBottomWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */