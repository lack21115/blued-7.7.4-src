package com.soft.blued.ui.circle.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.discover.model.CircleBaseMember;
import java.util.List;

public class CircleMemberAdapter extends BaseMultiItemQuickAdapter<CircleBaseMember.Member, BaseViewHolder> implements StickyHeaderHandler {
  private IRequestHost a;
  
  private int b;
  
  public CircleMemberAdapter(IRequestHost paramIRequestHost, int paramInt) {
    super(null);
    this.a = paramIRequestHost;
    this.b = paramInt;
    b(1, 2131493481);
    b(2, 2131493481);
    b(0, 2131493480);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, CircleBaseMember.Member paramMember) {
    paramBaseViewHolder.a(2131300877, paramMember.name);
    paramBaseViewHolder.a(2131301127, String.valueOf(paramMember.number));
    paramBaseViewHolder.f(2131301127, BluedSkinUtils.a(this.k, 2131100716));
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, CircleBaseMember.Member paramMember) {
    paramBaseViewHolder.a(2131300877, paramMember.name);
    paramBaseViewHolder.a(2131301127, String.valueOf(paramMember.number));
    paramBaseViewHolder.f(2131301127, BluedSkinUtils.a(this.k, 2131100838));
  }
  
  private void d(BaseViewHolder paramBaseViewHolder, CircleBaseMember.Member paramMember) {
    boolean bool;
    CircleMethods.setLevelMark((ImageView)paramBaseViewHolder.d(2131297820), paramMember.admin_level);
    if (paramMember.is_mute == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    paramBaseViewHolder.b(2131297870, bool);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297804);
    TextView textView = (TextView)paramBaseViewHolder.d(2131301088);
    if (paramMember.is_locked == 1) {
      textView.setText(2131755897);
      ImageLoader.a(this.a, 2131234356).c().a(imageView);
    } else {
      textView.setText(paramMember.name);
      ImageLoader.a(this.a, paramMember.avatar).a(2131234356).c().a(imageView);
    } 
    if (paramMember.is_anonym == 1) {
      bool = true;
    } else {
      bool = false;
    } 
    paramBaseViewHolder.b(2131297682, bool);
    paramBaseViewHolder.c(2131296768);
    paramBaseViewHolder.c(2131297863);
    View view = paramBaseViewHolder.d(2131297863);
    if (this.b == 1)
      if (paramMember.isOwner()) {
        view.setVisibility(8);
      } else {
        view.setVisibility(0);
      }  
    if (this.b == 2) {
      if (paramMember.isOwner()) {
        view.setVisibility(8);
        return;
      } 
      if (paramMember.isManager()) {
        view.setVisibility(8);
        return;
      } 
      view.setVisibility(0);
    } 
  }
  
  public List<?> a() {
    return n();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, CircleBaseMember.Member paramMember) {
    int i = paramMember.adapterType;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        c(paramBaseViewHolder, paramMember);
        return;
      } 
      b(paramBaseViewHolder, paramMember);
      return;
    } 
    d(paramBaseViewHolder, paramMember);
  }
  
  public void a(boolean paramBoolean) {
    for (CircleBaseMember.Member member : this.n) {
      if (member.adapterType == 1) {
        if (paramBoolean) {
          member.number++;
        } else {
          member.number--;
        } 
        notifyDataSetChanged();
        break;
      } 
    } 
  }
  
  public void e(boolean paramBoolean) {
    for (CircleBaseMember.Member member : this.n) {
      if (member.adapterType == 2) {
        if (paramBoolean) {
          member.number++;
        } else {
          member.number--;
        } 
        notifyDataSetChanged();
        break;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleMemberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */