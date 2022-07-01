package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LivePKProgressModel;
import com.blued.android.module.live_china.model.LivePKProgressUserModel;
import com.blued.android.module.live_china.model.LivePkBannerItemModel;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;

public class LivePKUserBanner extends FrameLayout implements View.OnClickListener {
  private View a;
  
  private View b;
  
  private View c;
  
  private View d;
  
  private ImageView e;
  
  private RecyclerView f;
  
  private RecyclerView g;
  
  private View h;
  
  private View i;
  
  private int j = 0;
  
  private String k;
  
  private LivePkAdapter l;
  
  private LivePkAdapter m;
  
  public LivePKUserBanner(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LivePKUserBanner(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    d();
    a();
  }
  
  private void d() {
    LayoutInflater.from(getContext()).inflate(R.layout.live_pk_user_banner, (ViewGroup)this);
    this.e = (ImageView)findViewById(R.id.iv_vs);
    this.c = findViewById(R.id.fl_left);
    this.d = findViewById(R.id.fl_right);
    this.f = (RecyclerView)findViewById(R.id.rv_pk_left);
    this.g = (RecyclerView)findViewById(R.id.rv_pk_right);
    this.h = findViewById(R.id.fl_left_fail);
    this.i = findViewById(R.id.fl_right_fail);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.f.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.g.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.l = new LivePkAdapter(this, getContext(), 0);
    this.m = new LivePkAdapter(this, getContext(), 1);
    this.f.setAdapter((RecyclerView.Adapter)this.l);
    this.g.setAdapter((RecyclerView.Adapter)this.m);
    this.a = findViewById(R.id.view_left);
    this.b = findViewById(R.id.view_right);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  public void a() {
    this.k = "0";
    this.j = 0;
    setPkState(this.j);
    setData((LivePKProgressModel)null);
  }
  
  public void a(String paramString) {
    if (TextUtils.equals(paramString, this.k))
      return; 
    this.k = paramString;
    this.j = 0;
    setPkState(this.j);
    setData((LivePKProgressModel)null);
  }
  
  public void a(String paramString, int paramInt, LivePKProgressModel paramLivePKProgressModel) {
    this.k = paramString;
    this.j = paramInt;
    setPkState(this.j);
    setData(paramLivePKProgressModel);
  }
  
  public void b() {
    EventTrackLive.a(LiveProtos.Event.LIVE_PK_AUDIENCE_SEAT_CLICK, false);
    LivePkBannerModel livePkBannerModel = new LivePkBannerModel();
    livePkBannerModel.lid = this.k;
    livePkBannerModel.type = 0;
    livePkBannerModel.pk_state = this.j;
    LiveEventBus.get("live_pk_dialog").post(livePkBannerModel);
  }
  
  public void c() {
    EventTrackLive.a(LiveProtos.Event.LIVE_PK_AUDIENCE_SEAT_CLICK, true);
    LivePkBannerModel livePkBannerModel = new LivePkBannerModel();
    livePkBannerModel.lid = this.k;
    livePkBannerModel.type = 1;
    livePkBannerModel.pk_state = this.j;
    LiveEventBus.get("live_pk_dialog").post(livePkBannerModel);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.view_left) {
      b();
      return;
    } 
    if (paramView.getId() == R.id.view_right)
      c(); 
  }
  
  public void setData(LivePKProgressModel paramLivePKProgressModel) {
    LivePKProgressModel livePKProgressModel = paramLivePKProgressModel;
    if (paramLivePKProgressModel == null)
      livePKProgressModel = new LivePKProgressModel(); 
    ArrayList<LivePkBannerItemModel> arrayList1 = new ArrayList();
    boolean bool = false;
    int j = 0;
    int i;
    for (i = 0; j < 3; i = k) {
      LivePkBannerItemModel livePkBannerItemModel = new LivePkBannerItemModel();
      livePkBannerItemModel.index = ++j;
      int k = i;
      if (livePKProgressModel.top != null) {
        k = i;
        if (i < livePKProgressModel.top.size()) {
          livePkBannerItemModel.uid = ((LivePKProgressUserModel)livePKProgressModel.top.get(i)).uid;
          livePkBannerItemModel.avatar = ((LivePKProgressUserModel)livePKProgressModel.top.get(i)).avatar;
          k = i + 1;
        } 
      } 
      arrayList1.add(livePkBannerItemModel);
    } 
    ArrayList<LivePkBannerItemModel> arrayList2 = new ArrayList();
    i = 0;
    j = bool;
    while (j < 3) {
      LivePkBannerItemModel livePkBannerItemModel = new LivePkBannerItemModel();
      livePkBannerItemModel.index = ++j;
      int k = i;
      if (livePKProgressModel.target_top != null) {
        k = i;
        if (i < livePKProgressModel.target_top.size()) {
          livePkBannerItemModel.uid = ((LivePKProgressUserModel)livePKProgressModel.target_top.get(i)).uid;
          livePkBannerItemModel.avatar = ((LivePKProgressUserModel)livePKProgressModel.target_top.get(i)).avatar;
          k = i + 1;
        } 
      } 
      arrayList2.add(livePkBannerItemModel);
      i = k;
    } 
    ArrayList arrayList = new ArrayList();
    for (i = arrayList1.size() - 1; i >= 0; i--)
      arrayList.add(arrayList1.get(i)); 
    this.l.a(arrayList);
    this.m.a(arrayList2);
  }
  
  public void setPkState(int paramInt) {
    this.j = paramInt;
    paramInt = this.j;
    if (paramInt == 0) {
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      this.f.setAlpha(1.0F);
      this.g.setAlpha(1.0F);
    } else if (paramInt == 1) {
      this.h.setVisibility(8);
      this.i.setVisibility(0);
      this.f.setAlpha(1.0F);
      this.g.setAlpha(0.5F);
    } else if (paramInt == 2) {
      this.h.setVisibility(0);
      this.i.setVisibility(8);
      this.f.setAlpha(0.5F);
      this.g.setAlpha(1.0F);
    } 
    this.l.notifyDataSetChanged();
    this.m.notifyDataSetChanged();
  }
  
  class LivePkAdapter extends CommonRecycleAdapter<LivePkBannerItemModel> {
    private int e;
    
    public LivePkAdapter(LivePKUserBanner this$0, Context param1Context, int param1Int) {
      super(param1Context);
      this.e = param1Int;
    }
    
    public int a(int param1Int) {
      return R.layout.live_pk_user_banner_item;
    }
    
    protected void a(LivePkBannerItemModel param1LivePkBannerItemModel, int param1Int, CommonRecycleAdapter.CommonAdapterHolder param1CommonAdapterHolder) {
      if (param1LivePkBannerItemModel == null)
        return; 
      ImageView imageView = (ImageView)param1CommonAdapterHolder.c(R.id.iv_avatar);
      ImageWrapper imageWrapper = ImageLoader.a(null, param1LivePkBannerItemModel.avatar).c();
      if (this.e == 0) {
        param1Int = R.drawable.live_pk_banner_item_default_left;
      } else {
        param1Int = R.drawable.live_pk_banner_item_default_right;
      } 
      imageWrapper.a(param1Int).a(imageView);
      if (this.e == 0) {
        param1CommonAdapterHolder.c(R.id.view_dd_bg, R.drawable.live_pk_banner_item_avatar_blue_dd_bg);
        param1CommonAdapterHolder.c(R.id.view_bg, R.drawable.live_pk_banner_item_avatar_blue_bg);
        param1CommonAdapterHolder.c(R.id.tv_num, R.drawable.live_pk_banner_item_num_blue_bg);
      } else {
        param1CommonAdapterHolder.c(R.id.view_dd_bg, R.drawable.live_pk_banner_item_avatar_red_dd_bg);
        param1CommonAdapterHolder.c(R.id.view_bg, R.drawable.live_pk_banner_item_avatar_red_bg);
        param1CommonAdapterHolder.c(R.id.tv_num, R.drawable.live_pk_banner_item_num_red_bg);
      } 
      if (param1LivePkBannerItemModel.index == 1) {
        if (LivePKUserBanner.a(this.a) == 0) {
          param1CommonAdapterHolder.b(R.id.iv_mvp, 8);
          param1CommonAdapterHolder.b(R.id.tv_num, 0);
          param1Int = R.id.tv_num;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(param1LivePkBannerItemModel.index);
          param1CommonAdapterHolder.a(param1Int, stringBuilder.toString());
          return;
        } 
        if (LivePKUserBanner.a(this.a) == 1) {
          if (this.e == 0) {
            param1CommonAdapterHolder.b(R.id.iv_mvp, 0);
            param1CommonAdapterHolder.b(R.id.tv_num, 8);
            return;
          } 
          param1CommonAdapterHolder.b(R.id.iv_mvp, 8);
          param1CommonAdapterHolder.b(R.id.tv_num, 0);
          param1Int = R.id.tv_num;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(param1LivePkBannerItemModel.index);
          param1CommonAdapterHolder.a(param1Int, stringBuilder.toString());
          return;
        } 
        if (LivePKUserBanner.a(this.a) == 2) {
          if (this.e == 0) {
            param1CommonAdapterHolder.b(R.id.iv_mvp, 8);
            param1CommonAdapterHolder.b(R.id.tv_num, 0);
            param1Int = R.id.tv_num;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(param1LivePkBannerItemModel.index);
            param1CommonAdapterHolder.a(param1Int, stringBuilder.toString());
            return;
          } 
          param1CommonAdapterHolder.b(R.id.iv_mvp, 0);
          param1CommonAdapterHolder.b(R.id.tv_num, 8);
          return;
        } 
      } else {
        if (param1LivePkBannerItemModel.index == 2) {
          param1CommonAdapterHolder.b(R.id.iv_mvp, 8);
          param1CommonAdapterHolder.b(R.id.tv_num, 0);
          param1Int = R.id.tv_num;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(param1LivePkBannerItemModel.index);
          param1CommonAdapterHolder.a(param1Int, stringBuilder.toString());
          return;
        } 
        if (param1LivePkBannerItemModel.index == 3) {
          param1CommonAdapterHolder.b(R.id.iv_mvp, 8);
          param1CommonAdapterHolder.b(R.id.tv_num, 0);
          param1Int = R.id.tv_num;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("");
          stringBuilder.append(param1LivePkBannerItemModel.index);
          param1CommonAdapterHolder.a(param1Int, stringBuilder.toString());
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LivePKUserBanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */