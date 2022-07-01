package com.blued.android.module.yy_china.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYEndInfoModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.List;

public class YYOtherEndView extends LinearLayout implements FollowStatusObserver {
  private BaseYYStudioFragment a;
  
  private ImageView b;
  
  private RelativeLayout c;
  
  private RankingView d;
  
  private ImageView e;
  
  private TextView f;
  
  private ShapeTextView g;
  
  private YYUserInfo h;
  
  private String i;
  
  public YYOtherEndView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYOtherEndView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYOtherEndView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_other_end_layout, (ViewGroup)this, true);
    this.b = (ImageView)findViewById(R.id.iv_end_close);
    this.c = (RelativeLayout)findViewById(R.id.yy_end_title);
    this.d = (RankingView)findViewById(R.id.ranking_view);
    this.e = (ImageView)findViewById(R.id.img_view);
    this.f = (TextView)findViewById(R.id.tv_name_view);
    this.g = (ShapeTextView)findViewById(R.id.tv_follow_view);
    if (StatusBarHelper.a())
      ((LinearLayout.LayoutParams)this.c.getLayoutParams()).topMargin = StatusBarHelper.a(getContext()); 
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYRoomInfoManager.d().l();
            YYOtherEndView.a(this.a).getActivity().finish();
          }
        });
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (YYOtherEndView.b(this.a) == null)
              return; 
            YYRoomInfoManager.d().b(this.a.getContext(), YYOtherEndView.b(this.a).getUid(), "", (IRequestHost)YYOtherEndView.a(this.a).w_());
          }
        });
    this.e.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (YYOtherEndView.b(this.a) == null)
              return; 
            YYRoomInfoManager.d().l();
            YYOtherEndView.a(this.a).getActivity().finish();
            YYRoomInfoManager.d().c().a(YYOtherEndView.c(this.a).getContext(), YYOtherEndView.b(this.a).getUid(), YYOtherEndView.b(this.a).getName(), YYOtherEndView.b(this.a).getAvatar(), (YYOtherEndView.b(this.a)).vbadge, 2);
          }
        });
  }
  
  private void a(String paramString) {
    YYRoomHttpUtils.e(paramString, new BluedUIHttpResponse<BluedEntityA<YYEndInfoModel>>(this, (IRequestHost)this.a.w_()) {
          protected void a(BluedEntityA<YYEndInfoModel> param1BluedEntityA) {
            YYOtherEndView.a(this.a, ((YYEndInfoModel)param1BluedEntityA.getSingleData()).anchor);
            if (YYOtherEndView.b(this.a) != null) {
              ImageLoader.a((IRequestHost)YYOtherEndView.a(this.a).w_(), YYOtherEndView.b(this.a).getAvatar()).a(R.drawable.user_bg_round).a(YYOtherEndView.c(this.a));
              YYOtherEndView.d(this.a).setText(YYOtherEndView.b(this.a).getName());
              YYOtherEndView.e(this.a).setText(UserRelationshipUtils.a(this.a.getContext(), (YYOtherEndView.b(this.a)).relationship));
            } 
            List<YYUserInfo> list = ((YYEndInfoModel)param1BluedEntityA.getSingleData()).rank_list;
            if (list != null) {
              if (list.isEmpty())
                return; 
              if (list.size() > 0)
                YYOtherEndView.f(this.a).a(list.get(0)); 
              if (list.size() > 1)
                YYOtherEndView.f(this.a).b(list.get(1)); 
              if (list.size() > 2)
                YYOtherEndView.f(this.a).c(list.get(2)); 
            } 
          }
        }(IRequestHost)this.a.w_());
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.a = paramBaseYYStudioFragment;
    KeyboardUtils.a((Activity)paramBaseYYStudioFragment.getActivity());
    setVisibility(0);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    this.i = yYRoomModel.uid;
    ImageLoader.a((IRequestHost)paramBaseYYStudioFragment.w_(), yYRoomModel.avatar).a(R.drawable.user_bg_round).a(this.e);
    this.f.setText(yYRoomModel.name);
    if (TextUtils.equals(yYRoomModel.relationship, "1") || TextUtils.equals(yYRoomModel.relationship, "3")) {
      this.g.setVisibility(8);
    } else {
      this.g.setVisibility(0);
      this.g.setText(UserRelationshipUtils.a(getContext(), yYRoomModel.relationship));
    } 
    RankingView rankingView = this.d;
    if (rankingView != null)
      rankingView.a(paramBaseYYStudioFragment, yYRoomModel.room_id); 
    a(yYRoomModel.room_id);
    YYRoomInfoManager.d().l();
  }
  
  public void a(String paramString1, String paramString2) {
    if (!TextUtils.equals(paramString1, this.i))
      return; 
    if (TextUtils.equals(paramString2, "1") || TextUtils.equals(paramString2, "3")) {
      this.g.setVisibility(8);
      return;
    } 
    this.g.setVisibility(0);
    this.g.setText(UserRelationshipUtils.a(getContext(), paramString2));
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    YYObserverManager.a().a(this);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    YYObserverManager.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYOtherEndView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */