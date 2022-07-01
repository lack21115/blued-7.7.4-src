package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.view.BluedLinearLayoutManager;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.AudienceAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.observer.AudienceCountObserver;
import com.blued.android.module.yy_china.observer.AudiencesChangedObserver;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;

public class YYAudienceListView extends LinearLayout implements AudienceCountObserver, AudiencesChangedObserver {
  private BaseYYStudioFragment a;
  
  private RecyclerView b;
  
  private AudienceAdapter c;
  
  private int d;
  
  private TextView e;
  
  private int f = 0;
  
  public YYAudienceListView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYAudienceListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYAudienceListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    Logger.e("YYAudienceListView", new Object[] { "YYAudienceListView initView ... " });
    this.d = DensityUtils.a(getContext(), 10.0F);
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_audience_list, (ViewGroup)this, true);
    this.b = (RecyclerView)findViewById(R.id.rv_fans_list_view);
    this.e = (TextView)findViewById(R.id.tv_audience_view);
    BluedLinearLayoutManager bluedLinearLayoutManager = new BluedLinearLayoutManager(getContext());
    bluedLinearLayoutManager.setOrientation(0);
    this.b.setLayoutManager((RecyclerView.LayoutManager)bluedLinearLayoutManager);
    this.b.addItemDecoration(new RecyclerView.ItemDecoration(this) {
          public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
            if (param1RecyclerView.getChildAdapterPosition(param1View) == 0)
              param1Rect.left = YYAudienceListView.a(this.a); 
            param1Rect.right = YYAudienceListView.a(this.a);
          }
        });
    this.e.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYAudienceListView.b(this.a).z();
          }
        });
  }
  
  private void getMembers() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.a(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYAudienceModel>>(this, (IRequestHost)this.a.w_()) {
          protected void a(BluedEntityA<YYAudienceModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              boolean bool;
              if (!param1BluedEntityA.hasData())
                return; 
              YYAudienceListView.c(this.a).c(null);
              this.a.setVisibility(0);
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("response model is empty : ");
              if (yYRoomModel == null) {
                bool = true;
              } else {
                bool = false;
              } 
              stringBuilder.append(bool);
              Logger.e("YYAudienceListView", new Object[] { stringBuilder.toString() });
              if (yYRoomModel != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("response list size : ");
                stringBuilder.append(param1BluedEntityA.data.size());
                Logger.e("YYAudienceListView", new Object[] { stringBuilder.toString() });
                yYRoomModel.setAudiences(param1BluedEntityA.data);
              } 
              this.a.a(param1BluedEntityA.extra.total);
            } 
          }
        }(IRequestHost)this.a.w_());
  }
  
  public void a(int paramInt) {
    this.a.a(new Runnable(this, paramInt) {
          public void run() {
            YYAudienceListView.d(this.b).setText(String.format(this.b.getResources().getString(R.string.yy_audience_count), new Object[] { Integer.valueOf(this.a) }));
          }
        });
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    Logger.e("YYAudienceListView", new Object[] { "YYAudienceListView init ... " });
    this.a = paramBaseYYStudioFragment;
    this.c = new AudienceAdapter(getContext(), paramBaseYYStudioFragment);
    this.b.setAdapter((RecyclerView.Adapter)this.c);
    this.c.a(new BaseQuickAdapter.OnItemClickListener(this, paramBaseYYStudioFragment) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (param1Int > YYAudienceListView.c(this.b).n().size())
              return; 
            YYAudienceModel yYAudienceModel = YYAudienceListView.c(this.b).n().get(param1Int);
            if (yYAudienceModel == null)
              return; 
            BaseYYStudioFragment baseYYStudioFragment = this.a;
            String str1 = yYAudienceModel.getUid();
            String str2 = yYAudienceModel.getName();
            String str3 = yYAudienceModel.getAvatar();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.O());
            stringBuilder.append("");
            baseYYStudioFragment.a(str1, str2, str3, stringBuilder.toString(), false);
          }
        });
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      this.f = yYRoomModel.getAudienceCount();
      if (yYRoomModel.isCPChannel()) {
        this.b.setVisibility(4);
      } else {
        this.b.setVisibility(0);
      } 
    } 
    a(this.f);
  }
  
  public void a(List<YYAudienceModel> paramList) {
    this.a.a(new Runnable(this, paramList) {
          public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("notifyMembers size : ");
            stringBuilder.append(this.a.size());
            Logger.e("YYAudienceListView", new Object[] { stringBuilder.toString() });
            if (this.b.getVisibility() != 0)
              this.b.setVisibility(0); 
            YYAudienceListView.c(this.b).c(this.a);
          }
        });
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    Logger.e("YYAudienceListView", new Object[] { "YYAudienceListView onAttachedToWindow ... " });
    YYObserverManager.a().a(this);
    YYObserverManager.a().a(this);
    getMembers();
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Logger.e("YYAudienceListView", new Object[] { "YYAudienceListView onDetachedFromWindow ... " });
    YYObserverManager.a().b(this);
    YYObserverManager.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYAudienceListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */