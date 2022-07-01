package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.EndMemberAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

public class RankingView extends LinearLayout {
  private ImageView a;
  
  private TextView b;
  
  private LinearLayout c;
  
  private ImageView d;
  
  private TextView e;
  
  private LinearLayout f;
  
  private ImageView g;
  
  private TextView h;
  
  private LinearLayout i;
  
  private LinearLayout j;
  
  private LinearLayout k;
  
  private SmartRefreshLayout l;
  
  private RecyclerView m;
  
  private EndMemberAdapter n;
  
  private int o;
  
  private int p = 1;
  
  private String q;
  
  private BaseYYStudioFragment r;
  
  public RankingView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public RankingView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RankingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    this.o = DensityUtils.a(getContext(), 10.0F);
    LayoutInflater.from(getContext()).inflate(R.layout.view_ranking_layoug, (ViewGroup)this, true);
    this.m = (RecyclerView)findViewById(R.id.member_list_view);
    this.l = (SmartRefreshLayout)findViewById(R.id.refresh_view);
    this.l.c(false);
    this.j = (LinearLayout)findViewById(R.id.layout_no);
    this.k = (LinearLayout)findViewById(R.id.layout_no_title);
    this.i = (LinearLayout)findViewById(R.id.ll_no3_layout);
    this.g = (ImageView)findViewById(R.id.iv_no_3);
    this.h = (TextView)findViewById(R.id.tv_name_no3);
    this.f = (LinearLayout)findViewById(R.id.ll_no1_layout);
    this.e = (TextView)findViewById(R.id.tv_name_no1);
    this.d = (ImageView)findViewById(R.id.iv_no_1);
    this.c = (LinearLayout)findViewById(R.id.ll_no2_layout);
    this.b = (TextView)findViewById(R.id.tv_name_no2);
    this.a = (ImageView)findViewById(R.id.iv_no_2);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.m.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            if (param1RecyclerView.getChildAdapterPosition(param1View) == 0)
              param1Rect.top = RankingView.a(this.a); 
            param1Rect.bottom = RankingView.a(this.a);
          }
        });
    this.m.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.l.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            RankingView.b(this.a);
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            RankingView.a(this.a, 1);
            RankingView.b(this.a);
          }
        });
  }
  
  private void b() {
    this.l.h();
    this.l.g();
  }
  
  private void d(YYUserInfo paramYYUserInfo) {
    if (paramYYUserInfo == null)
      return; 
    YYRoomInfoManager.d().c().a(getContext(), paramYYUserInfo.getUid(), paramYYUserInfo.getName(), paramYYUserInfo.getAvatar(), paramYYUserInfo.vbadge, 2);
  }
  
  private void getMembers() {
    YYRoomHttpUtils.h(this.q, this.p, new BluedUIHttpResponse<BluedEntityA<YYUserInfo>>(this, (IRequestHost)this.r.w_()) {
          protected void a(BluedEntityA<YYUserInfo> param1BluedEntityA) {
            if (RankingView.c(this.a) == 1) {
              RankingView.d(this.a).c(param1BluedEntityA.data);
            } else {
              RankingView.d(this.a).a(param1BluedEntityA.data);
            } 
            if (param1BluedEntityA.hasMore()) {
              RankingView.e(this.a);
              RankingView.f(this.a).b(true);
              return;
            } 
            RankingView.f(this.a).b(false);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            RankingView.g(this.a);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            RankingView.g(this.a);
          }
        }(IRequestHost)this.r.w_());
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, String paramString) {
    this.r = paramBaseYYStudioFragment;
    this.q = paramString;
    this.n = new EndMemberAdapter(paramBaseYYStudioFragment);
    this.m.setAdapter((RecyclerView.Adapter)this.n);
    getMembers();
  }
  
  public void a(YYUserInfo paramYYUserInfo) {
    this.k.setVisibility(0);
    this.j.setVisibility(0);
    this.f.setVisibility(0);
    ImageLoader.a((IRequestHost)this.r.w_(), paramYYUserInfo.getAvatar()).a(R.drawable.user_bg_round).a(this.d);
    this.e.setText(paramYYUserInfo.getName());
    this.d.setOnClickListener(new View.OnClickListener(this, paramYYUserInfo) {
          public void onClick(View param1View) {
            RankingView.a(this.b, this.a);
          }
        });
  }
  
  public void b(YYUserInfo paramYYUserInfo) {
    this.c.setVisibility(0);
    ImageLoader.a((IRequestHost)this.r.w_(), paramYYUserInfo.getAvatar()).a(R.drawable.user_bg_round).a(this.a);
    this.b.setText(paramYYUserInfo.getName());
    this.a.setOnClickListener(new View.OnClickListener(this, paramYYUserInfo) {
          public void onClick(View param1View) {
            RankingView.a(this.b, this.a);
          }
        });
  }
  
  public void c(YYUserInfo paramYYUserInfo) {
    this.i.setVisibility(0);
    ImageLoader.a((IRequestHost)this.r.w_(), paramYYUserInfo.getAvatar()).a(R.drawable.user_bg_round).a(this.g);
    this.h.setText(paramYYUserInfo.getName());
    this.g.setOnClickListener(new View.OnClickListener(this, paramYYUserInfo) {
          public void onClick(View param1View) {
            RankingView.a(this.b, this.a);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\RankingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */