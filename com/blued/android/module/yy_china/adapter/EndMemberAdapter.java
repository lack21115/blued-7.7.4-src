package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

public class EndMemberAdapter extends BaseQuickAdapter<YYUserInfo, BaseViewHolder> implements FollowStatusObserver {
  private IRequestHost a;
  
  private BaseYYStudioFragment b;
  
  public EndMemberAdapter(BaseYYStudioFragment paramBaseYYStudioFragment) {
    super(R.layout.item_end_member_layout, new ArrayList());
    this.b = paramBaseYYStudioFragment;
    this.a = (IRequestHost)paramBaseYYStudioFragment.w_();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYUserInfo paramYYUserInfo) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_member_view);
    TextView textView1 = (TextView)paramBaseViewHolder.d(R.id.tv_member_name);
    TextView textView2 = (TextView)paramBaseViewHolder.d(R.id.tv_member_style);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(R.id.tv_follow);
    ImageLoader.a(this.a, paramYYUserInfo.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
    textView1.setText(paramYYUserInfo.getName());
    textView2.setText(String.format(textView2.getResources().getString(R.string.yy_years_height_weight), new Object[] { paramYYUserInfo.age, paramYYUserInfo.height, paramYYUserInfo.weight, UserRelationshipUtils.a(textView2.getContext(), null, paramYYUserInfo.role) }));
    if (TextUtils.equals(paramYYUserInfo.getUid(), YYRoomInfoManager.d().e()) || TextUtils.equals(paramYYUserInfo.relationship, "8") || TextUtils.equals(paramYYUserInfo.relationship, "4")) {
      shapeTextView.setVisibility(8);
    } else {
      shapeTextView.setVisibility(0);
    } 
    shapeTextView.setText(UserRelationshipUtils.a(shapeTextView.getContext(), paramYYUserInfo.relationship));
    shapeTextView.setOnClickListener(new View.OnClickListener(this, paramYYUserInfo, shapeTextView) {
          public void onClick(View param1View) {
            if (TextUtils.equals(this.a.relationship, "1") || TextUtils.equals(this.a.relationship, "3")) {
              YYRoomInfoManager.d().a(this.b.getContext(), this.a.getUid(), "", EndMemberAdapter.a(this.c));
              return;
            } 
            YYRoomInfoManager.d().b(this.b.getContext(), this.a.getUid(), "", EndMemberAdapter.a(this.c));
          }
        });
    imageView.setOnClickListener(new View.OnClickListener(this, imageView, paramYYUserInfo) {
          public void onClick(View param1View) {
            YYRoomInfoManager.d().c().a(this.a.getContext(), this.b.getUid(), this.b.getName(), this.b.getAvatar(), this.b.vbadge, 2);
            YYRoomInfoManager.d().l();
            EndMemberAdapter.b(this.c).getActivity().finish();
          }
        });
  }
  
  public void a(String paramString1, String paramString2) {
    Iterator<YYUserInfo> iterator = n().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i++) {
      YYUserInfo yYUserInfo = iterator.next();
      if (TextUtils.equals(paramString1, yYUserInfo.getUid())) {
        yYUserInfo.relationship = paramString2;
        break;
      } 
    } 
    notifyItemChanged(i);
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {
    super.onAttachedToRecyclerView(paramRecyclerView);
    YYObserverManager.a().a(this);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView) {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    YYObserverManager.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\EndMemberAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */