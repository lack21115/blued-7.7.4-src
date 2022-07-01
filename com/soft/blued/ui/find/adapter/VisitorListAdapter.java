package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.das.guy.GuyProtos;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.soft.blued.constant.ADConstants;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.customview.bluedad.BluedADConstraintLayout;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.find.viewholder.VisitorViewHolder;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.utils.ADClosePopOptionsUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.TTADUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitorListAdapter extends BaseAdapter {
  private static int c = 7;
  
  public boolean a = false;
  
  public List<String> b = new ArrayList<String>();
  
  private Context d;
  
  private IRequestHost e;
  
  private LayoutInflater f;
  
  private List<BluedMyVisitorList> g = new ArrayList<BluedMyVisitorList>();
  
  private int h;
  
  private int i = 0;
  
  private LoadOptions j;
  
  private String k;
  
  public VisitorListAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    this.d = paramContext;
    this.e = paramIRequestHost;
    this.f = LayoutInflater.from(paramContext);
    this.h = (paramContext.getResources().getDisplayMetrics()).widthPixels;
    this.j = new LoadOptions();
    LoadOptions loadOptions = this.j;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    int i = this.h;
    loadOptions.a(i >> 1, i >> 1);
  }
  
  private void a(int paramInt) {
    List<BluedMyVisitorList> list = this.g;
    if (list != null && list.size() > 4 && !((BluedMyVisitorList)this.g.get(4)).isShowAdVisited && 1 == this.i && paramInt == 4) {
      EventTrackGuy.a(GuyProtos.Event.AD_PRE_ROW_SHOW, 11);
      ((BluedMyVisitorList)this.g.get(4)).isShowAdVisited = true;
    } 
  }
  
  private void a(BluedMyVisitorList paramBluedMyVisitorList, int paramInt) {
    int i;
    if (paramInt > this.g.size() - 1) {
      i = this.g.size() - 1;
      paramInt = 1;
    } else {
      boolean bool = false;
      i = paramInt;
      paramInt = bool;
    } 
    BluedMyVisitorList bluedMyVisitorList = this.g.get(i);
    if (bluedMyVisitorList != null) {
      if (bluedMyVisitorList.is_interested != 1 && bluedMyVisitorList.is_ads != 1) {
        paramBluedMyVisitorList.visitors_time = bluedMyVisitorList.visitors_time;
        return;
      } 
      if (paramInt == 0)
        a(paramBluedMyVisitorList, i + 1); 
    } 
  }
  
  public void a(String paramString) {
    this.k = paramString;
  }
  
  public void a(List<BluedMyVisitorList> paramList, int paramInt) {
    this.i = paramInt;
    this.a = false;
    this.g.clear();
    this.b.clear();
    if (paramList != null && paramList.size() > 0) {
      for (paramInt = 0; paramInt < paramList.size(); paramInt++) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(((BluedMyVisitorList)paramList.get(paramInt)).uid);
        stringBuilder1.append(((BluedMyVisitorList)paramList.get(paramInt)).aid);
        stringBuilder1.append(((BluedMyVisitorList)paramList.get(paramInt)).is_ads);
        String str = stringBuilder1.toString();
        this.b.add(str);
        if (BlueAppLocal.d()) {
          ((BluedMyVisitorList)paramList.get(paramInt)).height = StringUtils.a(((BluedMyVisitorList)paramList.get(paramInt)).height, BlueAppLocal.c(), false);
          ((BluedMyVisitorList)paramList.get(paramInt)).weight = StringUtils.b(((BluedMyVisitorList)paramList.get(paramInt)).weight, BlueAppLocal.c(), false);
        } else {
          ((BluedMyVisitorList)paramList.get(paramInt)).height = StringUtils.a(((BluedMyVisitorList)paramList.get(paramInt)).height, BlueAppLocal.c(), true);
          ((BluedMyVisitorList)paramList.get(paramInt)).weight = StringUtils.b(((BluedMyVisitorList)paramList.get(paramInt)).weight, BlueAppLocal.c(), true);
        } 
        BluedMyVisitorList bluedMyVisitorList = paramList.get(paramInt);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("singleData.is_ads：");
        stringBuilder2.append(bluedMyVisitorList.is_ads);
        stringBuilder2.append(" -- adms_type：");
        stringBuilder2.append(bluedMyVisitorList.adms_type);
        Log.v("drb", stringBuilder2.toString());
        if (bluedMyVisitorList.is_ads == 1 && "4".equalsIgnoreCase(bluedMyVisitorList.adms_type) && "user".equalsIgnoreCase(bluedMyVisitorList.adms_mark))
          TTADUtils.a(this.d, "945022031", new TTADUtils.TTGetOriginAdListener(this, bluedMyVisitorList) {
                public void a() {
                  VisitorListAdapter.a(this.b).remove(this.a);
                  this.b.notifyDataSetChanged();
                }
                
                public void a(TTNativeAd param1TTNativeAd) {
                  this.a.avatar = ((TTImage)param1TTNativeAd.getImageList().get(0)).getImageUrl();
                  this.a.name = param1TTNativeAd.getTitle();
                  this.a.description = param1TTNativeAd.getDescription();
                  BluedMyVisitorList bluedMyVisitorList = this.a;
                  bluedMyVisitorList.can_close = 1;
                  bluedMyVisitorList.ttNativeAdData = param1TTNativeAd;
                  this.b.notifyDataSetChanged();
                }
                
                public void b() {
                  VisitorListAdapter.a(this.b).remove(this.a);
                  this.b.notifyDataSetChanged();
                }
              }); 
      } 
      this.g.addAll(paramList);
    } 
    notifyDataSetChanged();
  }
  
  public void b(List<BluedMyVisitorList> paramList, int paramInt) {
    this.i = paramInt;
    if (paramList != null && paramList.size() > 0) {
      Iterator<BluedMyVisitorList> iterator = paramList.iterator();
      while (iterator.hasNext()) {
        BluedMyVisitorList bluedMyVisitorList = iterator.next();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bluedMyVisitorList.uid);
        stringBuilder.append(bluedMyVisitorList.aid);
        stringBuilder.append(bluedMyVisitorList.is_ads);
        String str = stringBuilder.toString();
        if (this.b.contains(str)) {
          iterator.remove();
          continue;
        } 
        if (BlueAppLocal.d()) {
          bluedMyVisitorList.height = StringUtils.a(bluedMyVisitorList.height, BlueAppLocal.c(), false);
          bluedMyVisitorList.weight = StringUtils.b(bluedMyVisitorList.weight, BlueAppLocal.c(), false);
          continue;
        } 
        bluedMyVisitorList.height = StringUtils.a(bluedMyVisitorList.height, BlueAppLocal.c(), true);
        bluedMyVisitorList.weight = StringUtils.b(bluedMyVisitorList.weight, BlueAppLocal.c(), true);
      } 
      this.g.addAll(paramList);
      notifyDataSetChanged();
    } 
  }
  
  public int getCount() {
    return this.g.size();
  }
  
  public Object getItem(int paramInt) {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt) {
    BluedMyVisitorList bluedMyVisitorList = this.g.get(paramInt);
    int i = bluedMyVisitorList.is_interested;
    paramInt = 0;
    if (i == 1)
      return 3; 
    if (bluedMyVisitorList.is_ads == 1) {
      String str = bluedMyVisitorList.adms_type;
      paramInt = -1;
      i = str.hashCode();
      if (i != -1396342996) {
        if (i != 52) {
          if (i == 3599307 && str.equals("user"))
            paramInt = 0; 
        } else if (str.equals("4")) {
          paramInt = 2;
        } 
      } else if (str.equals("banner")) {
        paramInt = 1;
      } 
      if (paramInt != 0)
        return (paramInt != 1) ? ((paramInt != 2) ? 0 : (bluedMyVisitorList.adms_mark.equalsIgnoreCase("user") ? 4 : 5)) : 1; 
      paramInt = 2;
    } 
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    DNOriginADViewHolder dNOriginADViewHolder1;
    TTOriginADViewHolder tTOriginADViewHolder1;
    View view2;
    NativeAdViewHolder nativeAdViewHolder1;
    View view1;
    DNOriginADViewHolder dNOriginADViewHolder2;
    TTOriginADViewHolder tTOriginADViewHolder2;
    ShowVipViewHolder showVipViewHolder;
    NativeAdViewHolder nativeAdViewHolder2;
    AdViewHolder adViewHolder;
    a(paramInt);
    int i = paramInt + 1;
    BluedMyVisitorList bluedMyVisitorList = this.g.get(paramInt);
    bluedMyVisitorList.last_visit_time = this.k;
    switch (getItemViewType(paramInt)) {
      default:
        if (paramView == null) {
          paramView = this.f.inflate(2131493694, null);
          VisitorViewHolder visitorViewHolder1 = new VisitorViewHolder(this.d, this.e, paramView, this.j, this.i);
          paramView.setTag(visitorViewHolder1);
          visitorViewHolder1.a(bluedMyVisitorList, paramInt);
          return paramView;
        } 
        break;
      case 6:
        if (paramView == null) {
          View view = this.f.inflate(2131493696, null);
          dNOriginADViewHolder1 = new DNOriginADViewHolder(this, view);
          view.setTag(dNOriginADViewHolder1);
        } else {
          DNOriginADViewHolder dNOriginADViewHolder = (DNOriginADViewHolder)dNOriginADViewHolder1.getTag();
          dNOriginADViewHolder2 = dNOriginADViewHolder1;
          dNOriginADViewHolder1 = dNOriginADViewHolder;
        } 
        a(bluedMyVisitorList, i);
        dNOriginADViewHolder1.a(bluedMyVisitorList, paramInt);
        return (View)dNOriginADViewHolder2;
      case 4:
        if (dNOriginADViewHolder1 == null) {
          View view = this.f.inflate(2131493696, null);
          tTOriginADViewHolder1 = new TTOriginADViewHolder(this, view);
          view.setTag(tTOriginADViewHolder1);
        } else {
          TTOriginADViewHolder tTOriginADViewHolder = (TTOriginADViewHolder)tTOriginADViewHolder1.getTag();
          tTOriginADViewHolder2 = tTOriginADViewHolder1;
          tTOriginADViewHolder1 = tTOriginADViewHolder;
        } 
        a(bluedMyVisitorList, i);
        tTOriginADViewHolder1.a(bluedMyVisitorList, paramInt);
        return (View)tTOriginADViewHolder2;
      case 3:
        if (!this.a)
          this.a = true; 
        if (tTOriginADViewHolder1 == null) {
          view2 = this.f.inflate(2131493697, null);
          showVipViewHolder = new ShowVipViewHolder(this, view2);
          view2.setTag(showVipViewHolder);
        } else {
          showVipViewHolder = (ShowVipViewHolder)view2.getTag();
        } 
        showVipViewHolder.a(bluedMyVisitorList, paramInt);
        return view2;
      case 2:
        if (view2 == null) {
          View view = this.f.inflate(2131493696, null);
          nativeAdViewHolder1 = new NativeAdViewHolder(this, view);
          view.setTag(nativeAdViewHolder1);
        } else {
          NativeAdViewHolder nativeAdViewHolder = (NativeAdViewHolder)nativeAdViewHolder1.getTag();
          nativeAdViewHolder2 = nativeAdViewHolder1;
          nativeAdViewHolder1 = nativeAdViewHolder;
        } 
        a(bluedMyVisitorList, i);
        nativeAdViewHolder1.a(bluedMyVisitorList, paramInt);
        return (View)nativeAdViewHolder2;
      case 1:
      case 5:
        if (nativeAdViewHolder1 == null) {
          view1 = this.f.inflate(2131493690, null);
          adViewHolder = new AdViewHolder(this, view1);
          view1.setTag(adViewHolder);
        } else {
          adViewHolder = (AdViewHolder)view1.getTag();
        } 
        adViewHolder.a(bluedMyVisitorList, paramInt);
        return view1;
    } 
    VisitorViewHolder visitorViewHolder = (VisitorViewHolder)view1.getTag();
    visitorViewHolder.a(bluedMyVisitorList, paramInt);
    return view1;
  }
  
  public int getViewTypeCount() {
    return c;
  }
  
  class AdViewHolder {
    public BannerADView a;
    
    private BluedMyVisitorList c;
    
    private int d;
    
    public AdViewHolder(VisitorListAdapter this$0, View param1View) {
      this.a = (BannerADView)param1View.findViewById(2131296495);
    }
    
    public void a(BluedMyVisitorList param1BluedMyVisitorList, int param1Int) {
      this.c = param1BluedMyVisitorList;
      this.d = param1Int;
      this.a.a(VisitorListAdapter.b(this.b), (BluedADExtra)param1BluedMyVisitorList, ADConstants.AD_POSITION.b, new BannerADView.ADListener(this, param1BluedMyVisitorList) {
            public void a() {
              VisitorListAdapter.a(this.b.b).remove(this.a);
              this.b.b.notifyDataSetChanged();
            }
            
            public void b() {
              VisitorListAdapter.a(this.b.b).remove(this.a);
              this.b.b.notifyDataSetChanged();
            }
          });
    }
  }
  
  class null implements BannerADView.ADListener {
    null(VisitorListAdapter this$0, BluedMyVisitorList param1BluedMyVisitorList) {}
    
    public void a() {
      VisitorListAdapter.a(this.b.b).remove(this.a);
      this.b.b.notifyDataSetChanged();
    }
    
    public void b() {
      VisitorListAdapter.a(this.b.b).remove(this.a);
      this.b.b.notifyDataSetChanged();
    }
  }
  
  class DNOriginADViewHolder extends NativeAdViewHolder {
    private ImageView i;
    
    private TextView j;
    
    public DNOriginADViewHolder(VisitorListAdapter this$0, View param1View) {
      super(this$0, param1View);
      this.i = (ImageView)param1View.findViewById(2131297570);
      this.j = (TextView)param1View.findViewById(2131300489);
    }
    
    public void a() {
      super.a();
      this.i.setVisibility(0);
      this.j.setVisibility(8);
    }
    
    public void a(BluedMyVisitorList param1BluedMyVisitorList, int param1Int) {
      super.a(param1BluedMyVisitorList, param1Int);
      this.g.a((BluedADExtra)param1BluedMyVisitorList, -$$Lambda$VisitorListAdapter$DNOriginADViewHolder$ukGNndFngCkoKKUG5vfhFM-qF0Y.INSTANCE);
      ImageLoader.a(VisitorListAdapter.b(this.a), param1BluedMyVisitorList.target_url).a(this.i);
    }
  }
  
  class NativeAdViewHolder {
    private BluedMyVisitorList a;
    
    public LinearLayout b;
    
    public ImageView c;
    
    public TextView d;
    
    public ImageView e;
    
    public TextView f;
    
    public BluedADConstraintLayout g;
    
    private int i;
    
    public NativeAdViewHolder(VisitorListAdapter this$0, View param1View) {
      this.b = (LinearLayout)param1View.findViewById(2131298075);
      this.c = (ImageView)param1View.findViewById(2131299686);
      this.d = (TextView)param1View.findViewById(2131301096);
      this.e = (ImageView)param1View.findViewById(2131297529);
      this.f = (TextView)param1View.findViewById(2131301095);
      this.g = (BluedADConstraintLayout)param1View.findViewById(2131296537);
    }
    
    private void b() {
      if (this.i < VisitorListAdapter.a(this.h).size())
        VisitorListAdapter.a(this.h).remove(this.i); 
      this.h.notifyDataSetChanged();
    }
    
    public void a() {
      this.g.setADData((BluedADExtra)this.a);
      ImageLoader.a(VisitorListAdapter.b(this.h), this.a.avatar).a(2131234356).c().a(this.c);
      this.d.setText(this.a.name);
      this.f.setText(this.a.description);
      if (this.a.can_close == 1) {
        this.e.setVisibility(0);
        this.e.setOnClickListener(new -$$Lambda$VisitorListAdapter$NativeAdViewHolder$LMEfSZKgbWIrsPIEa5QAJSjf60Q(this));
      } else {
        this.e.setVisibility(8);
      } 
      if (StringUtils.a(this.a.last_visit_time, 0L) < StringUtils.a(this.a.visitors_time, 0L)) {
        this.b.setBackground((Drawable)new ColorDrawable(BluedSkinUtils.a(VisitorListAdapter.c(this.h), 2131100733)));
        return;
      } 
      this.b.setBackground(BluedSkinUtils.b(VisitorListAdapter.c(this.h), 2131233702));
    }
    
    public void a(BluedMyVisitorList param1BluedMyVisitorList, int param1Int) {
      this.a = param1BluedMyVisitorList;
      this.i = param1Int;
      a();
    }
  }
  
  class ShowVipViewHolder implements View.OnClickListener {
    private BluedMyVisitorList b;
    
    private int c;
    
    private ConstraintLayout d;
    
    private LinearLayout e;
    
    private TextView f;
    
    private RecyclerView g;
    
    private VisitorGitVipAvatarAdapter h;
    
    private ImageView i;
    
    private ImageView j;
    
    private boolean k = false;
    
    public ShowVipViewHolder(VisitorListAdapter this$0, View param1View) {
      this.d = (ConstraintLayout)param1View.findViewById(2131298083);
      this.e = (LinearLayout)param1View.findViewById(2131298067);
      this.f = (TextView)param1View.findViewById(2131300803);
      this.g = (RecyclerView)param1View.findViewById(2131299605);
      this.i = (ImageView)param1View.findViewById(2131297432);
      this.j = (ImageView)param1View.findViewById(2131297486);
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, VisitorListAdapter.c(this$0), this$0) {
          public boolean canScrollVertically() {
            return false;
          }
        };
      linearLayoutManager.setOrientation(0);
      this.g.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    }
    
    private void a() {
      if (!this.k) {
        this.k = true;
        if (this.b.is_vip == 0)
          InstantLog.a("visitor_vip_show"); 
      } 
    }
    
    private void b() {
      if (this.b.is_vip == 1) {
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        return;
      } 
      this.d.setVisibility(0);
      this.e.setVisibility(8);
      this.f.setOnClickListener(this);
      if (this.g.getAdapter() == null) {
        this.h = new VisitorGitVipAvatarAdapter(VisitorListAdapter.c(this.a), VisitorListAdapter.b(this.a));
        this.g.setAdapter((RecyclerView.Adapter)this.h);
      } 
      this.h.c(this.b.profile_picture);
      this.h.notifyDataSetChanged();
      LoadOptions loadOptions = new LoadOptions();
      loadOptions.d = 2131234358;
      loadOptions.b = 2131234358;
      loadOptions.a(VisitorListAdapter.d(this.a) >> 1, VisitorListAdapter.d(this.a) >> 1);
      if (this.b.profile_picture != null && this.b.profile_picture.size() > 0) {
        ImageLoader.a(VisitorListAdapter.b(this.a), ((BluedMyVisitorList.ProfilePicture)this.b.profile_picture.get(0)).url).a(2131234358).a(2.0F, VisitorListAdapter.c(this.a).getResources().getColor(2131100528)).a(this.i);
        this.i.setVisibility(0);
        this.g.setVisibility(0);
      } else {
        this.i.setVisibility(8);
        this.g.setVisibility(8);
      } 
      if (TextUtils.isEmpty(this.b.fuzzy_profile_picture)) {
        this.j.setVisibility(8);
        return;
      } 
      this.j.setVisibility(0);
      ImageLoader.a(VisitorListAdapter.b(this.a), ((BluedMyVisitorList.ProfilePicture)this.b.profile_picture.get(0)).url).a(2131234358).a(2.0F, VisitorListAdapter.c(this.a).getResources().getColor(2131100528)).d().a(this.j);
    }
    
    public void a(BluedMyVisitorList param1BluedMyVisitorList, int param1Int) {
      this.b = param1BluedMyVisitorList;
      this.c = param1Int;
      b();
      a();
    }
    
    public void onClick(View param1View) {
      if (param1View.getId() != 2131300803)
        return; 
      InstantLog.a("visitor_vip_buy_click");
      PayUtils.a(VisitorListAdapter.c(this.a), 12, "nearby_visit_bottom_buy");
    }
  }
  
  class null extends LinearLayoutManager {
    null(VisitorListAdapter this$0, Context param1Context, VisitorListAdapter param1VisitorListAdapter) {
      super(param1Context);
    }
    
    public boolean canScrollVertically() {
      return false;
    }
  }
  
  class TTOriginADViewHolder extends NativeAdViewHolder {
    private ImageView i;
    
    public TTOriginADViewHolder(VisitorListAdapter this$0, View param1View) {
      super(this$0, param1View);
      this.i = (ImageView)param1View.findViewById(2131297570);
    }
    
    public void a() {
      super.a();
      this.i.setVisibility(0);
    }
    
    public void a(BluedMyVisitorList param1BluedMyVisitorList, int param1Int) {
      super.a(param1BluedMyVisitorList, param1Int);
      this.g.a((BluedADExtra)param1BluedMyVisitorList, -$$Lambda$VisitorListAdapter$TTOriginADViewHolder$CfQNlUWmFBan5UfearwN8lYLoqE.INSTANCE);
      if (param1BluedMyVisitorList.ttNativeAdData != null) {
        ArrayList<LinearLayout> arrayList = new ArrayList();
        arrayList.add(this.b);
        param1BluedMyVisitorList.ttNativeAdData.registerViewForInteraction((ViewGroup)this.b, arrayList, arrayList, new TTNativeAd.AdInteractionListener(this, param1BluedMyVisitorList) {
              public void onAdClicked(View param2View, TTNativeAd param2TTNativeAd) {
                FindHttpUtils.a(this.a.click_url);
              }
              
              public void onAdCreativeClick(View param2View, TTNativeAd param2TTNativeAd) {
                FindHttpUtils.a(this.a.click_url);
              }
              
              public void onAdShow(TTNativeAd param2TTNativeAd) {}
            });
      } 
    }
  }
  
  class null implements TTNativeAd.AdInteractionListener {
    null(VisitorListAdapter this$0, BluedMyVisitorList param1BluedMyVisitorList) {}
    
    public void onAdClicked(View param1View, TTNativeAd param1TTNativeAd) {
      FindHttpUtils.a(this.a.click_url);
    }
    
    public void onAdCreativeClick(View param1View, TTNativeAd param1TTNativeAd) {
      FindHttpUtils.a(this.a.click_url);
    }
    
    public void onAdShow(TTNativeAd param1TTNativeAd) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\adapter\VisitorListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */