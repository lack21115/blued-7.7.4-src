package com.soft.blued.ui.circle.fragment;

import android.view.View;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.soft.blued.ui.circle.presenter.CircleJoinMemberPresenter;
import com.soft.blued.ui.circle.presenter.CircleMuteMemberPresenter;
import com.soft.blued.ui.discover.model.CircleBaseMember;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;

public class CircleMuteMemberFragment extends CircleJoinMemberFragment<CircleMuteMemberPresenter> {
  protected void a(CircleBaseMember.Member paramMember, int paramInt) {
    ArrayList<BottomMenuPop.MenuItemInfo> arrayList = new ArrayList();
    BasePopupView basePopupView = CommonShowBottomWindow.a(getContext(), arrayList);
    BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
    menuItemInfo.a = getResources().getString(2131755901);
    menuItemInfo.b = 2131100837;
    menuItemInfo.c = new -$$Lambda$CircleMuteMemberFragment$sSp1uYx8pX5RJH5FwmfFbNC-FPM(this, paramMember, paramInt, basePopupView);
    arrayList.add(menuItemInfo);
    basePopupView.h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleMuteMemberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */