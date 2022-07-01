package com.soft.blued.ui.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.chat.data.BadgeData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.view.MedalView;
import com.blued.android.module.live_china.view.PopAnchorBadge;
import com.blued.android.module.live_china.view.PopAnchorBadgeCenter;

public class MedalViewHorizontal extends MedalView {
  public MedalViewHorizontal(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void c() {
    this.a = this.c.inflate(2131493879, null);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      case 2131299210:
        if (this.h != null && this.h.size() >= 3) {
          Context context = this.b;
          String str1 = this.d;
          String str2 = this.e;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(((BadgeData)this.h.get(2)).id);
          stringBuilder.append("");
          PopAnchorBadgeCenter.b(context, str1, str2, stringBuilder.toString(), (PopAnchorBadge.DismissLisnter)this, (IRequestHost)this.g);
        } 
        break;
      case 2131299209:
        if (this.h != null && this.h.size() >= 2) {
          Context context = this.b;
          String str1 = this.d;
          String str2 = this.e;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(((BadgeData)this.h.get(1)).id);
          stringBuilder.append("");
          PopAnchorBadgeCenter.b(context, str1, str2, stringBuilder.toString(), (PopAnchorBadge.DismissLisnter)this, (IRequestHost)this.g);
        } 
        break;
      case 2131299208:
        if (this.h != null && this.h.size() >= 1) {
          Context context = this.b;
          String str1 = this.d;
          String str2 = this.e;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(((BadgeData)this.h.get(0)).id);
          stringBuilder.append("");
          PopAnchorBadgeCenter.b(context, str1, str2, stringBuilder.toString(), (PopAnchorBadge.DismissLisnter)this, (IRequestHost)this.g);
        } 
        break;
    } 
    if (this.h != null && this.h.size() >= 1) {
      if (this.f instanceof com.blued.android.module.live_china.fragment.RecordingOnliveFragment) {
        this.i.Q();
        return;
      } 
      LiveRefreshUIObserver.a().d(4);
      LiveSetDataObserver.a().e(4);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\view\MedalViewHorizontal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */