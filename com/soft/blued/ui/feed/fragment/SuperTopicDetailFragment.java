package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.client.feed.FeedProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.FloatFooterView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.observer.ICircleDataObserver;
import com.soft.blued.ui.feed.adapter.FeedListAdapterForRecyclerView;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.feed.model.FeedParse;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;

public class SuperTopicDetailFragment extends BaseFragment implements View.OnClickListener {
  private String A;
  
  private BluedTopic B;
  
  private BluedUIHttpResponse C = new BluedUIHttpResponse<BluedEntityA<BluedTopic>>(this, (IRequestHost)w_()) {
      private boolean b;
      
      protected BluedEntityA<BluedTopic> a(String param1String) {
        BluedEntityA<BluedTopic> bluedEntityA = (BluedEntityA)super.parseData(param1String);
        if (bluedEntityA != null) {
          if (!bluedEntityA.hasData())
            return bluedEntityA; 
          for (BluedIngSelfFeed bluedIngSelfFeed : ((BluedTopic)bluedEntityA.data.get(0)).tt)
            bluedIngSelfFeed.feedParse = new FeedParse(SuperTopicDetailFragment.b(this.a), bluedIngSelfFeed, 5); 
        } 
        return bluedEntityA;
      }
      
      public void a(BluedEntityA<BluedTopic> param1BluedEntityA) {
        SuperTopicDetailFragment.b(this.a, param1BluedEntityA.hasMore());
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0 && ((BluedTopic)param1BluedEntityA.data.get(0)).tt != null) {
          if (param1BluedEntityA.hasMore()) {
            SuperTopicDetailFragment.b(this.a, true);
            SuperTopicDetailFragment.c(this.a).b(true);
          } else {
            SuperTopicDetailFragment.b(this.a, false);
            SuperTopicDetailFragment.c(this.a).b(false);
          } 
          if (SuperTopicDetailFragment.d(this.a) == 1) {
            if (param1BluedEntityA.data.get(0) != null && !TextUtils.isEmpty(((BluedTopic)param1BluedEntityA.data.get(0)).name))
              this.a.a(param1BluedEntityA.data.get(0)); 
            if (((BluedTopic)param1BluedEntityA.data.get(0)).tt.size() == 0) {
              SuperTopicDetailFragment.e(this.a).a();
            } else {
              SuperTopicDetailFragment.e(this.a).c();
            } 
          } 
          if (SuperTopicDetailFragment.d(this.a) == 1) {
            SuperTopicDetailFragment.f(this.a).a(((BluedTopic)param1BluedEntityA.data.get(0)).tt);
            return;
          } 
          SuperTopicDetailFragment.f(this.a).b(((BluedTopic)param1BluedEntityA.data.get(0)).tt);
          return;
        } 
        if (SuperTopicDetailFragment.d(this.a) != 1) {
          SuperTopicDetailFragment.g(this.a);
          SuperTopicDetailFragment.b(this.a, false);
        } 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.b = true;
        return super.onUIFailure(param1Int, param1String);
      }
      
      public void onUIFinish() {
        SuperTopicDetailFragment.c(this.a).g();
        SuperTopicDetailFragment.c(this.a).h();
        if (SuperTopicDetailFragment.f(this.a).n().size() == 0) {
          if (this.b) {
            SuperTopicDetailFragment.e(this.a).b();
            return;
          } 
          SuperTopicDetailFragment.e(this.a).a();
          return;
        } 
        SuperTopicDetailFragment.e(this.a).c();
      }
    };
  
  private RecyclerView.OnScrollListener D = new RecyclerView.OnScrollListener(this) {
      public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
        if (SuperTopicDetailFragment.f(this.a) != null && (SuperTopicDetailFragment.f(this.a)).p != null)
          (SuperTopicDetailFragment.f(this.a)).p.onScrollStateChanged(param1RecyclerView, param1Int); 
        if (SuperTopicDetailFragment.h(this.a) != null && param1Int == 0) {
          if (!param1RecyclerView.canScrollVertically(-1)) {
            SuperTopicDetailFragment.h(this.a).a();
            return;
          } 
          if (!param1RecyclerView.canScrollVertically(1))
            SuperTopicDetailFragment.h(this.a).b(); 
        } 
      }
      
      public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
        if (SuperTopicDetailFragment.f(this.a) != null && (SuperTopicDetailFragment.f(this.a)).p != null)
          (SuperTopicDetailFragment.f(this.a)).p.onScrolled(param1RecyclerView, param1Int1, param1Int2); 
        if (param1Int2 < 0) {
          SuperTopicDetailFragment.h(this.a).a();
          return;
        } 
        if (param1Int2 > 0)
          SuperTopicDetailFragment.h(this.a).b(); 
      }
    };
  
  private Context d;
  
  private View e;
  
  private CommonTopTitleNoTrans f;
  
  private SmartRefreshLayout g;
  
  private RecyclerView h;
  
  private FeedListAdapterForRecyclerView i;
  
  private View j;
  
  private ImageView k;
  
  private ImageView l;
  
  private TextView m;
  
  private TextView n;
  
  private TextView o;
  
  private TextView p;
  
  private TextView q;
  
  private View r;
  
  private NoDataAndLoadFailView s;
  
  private FloatFooterView t;
  
  private LoadOptions u;
  
  private String v;
  
  private int w = 1;
  
  private int x = 20;
  
  private boolean y = true;
  
  private String z;
  
  public static void a(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("topic_id", paramString);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, SuperTopicDetailFragment.class, bundle);
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.w = 1; 
    if (this.w == 1)
      this.y = true; 
    if (!this.y) {
      int i = this.w;
      if (i != 1) {
        this.w = i - 1;
        AppMethods.a(this.d.getResources().getString(2131756083));
        this.g.g();
        this.g.h();
        return;
      } 
    } 
    Context context = this.d;
    BluedUIHttpResponse bluedUIHttpResponse = this.C;
    String str1 = this.A;
    String str2 = this.z;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.w);
    stringBuilder1.append("");
    String str3 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.x);
    stringBuilder2.append("");
    FeedHttpUtils.a(context, bluedUIHttpResponse, str1, str2, "time", str3, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  public static void b(Context paramContext, String paramString) {
    Bundle bundle = new Bundle();
    bundle.putString("topic", paramString);
    TerminalActivity.a(bundle);
    TerminalActivity.d(paramContext, SuperTopicDetailFragment.class, bundle);
  }
  
  private void k() {
    this.u = new LoadOptions();
    LoadOptions loadOptions = this.u;
    loadOptions.d = 2131234240;
    loadOptions.b = 2131234240;
    loadOptions.a(AppInfo.l >> 1, AppInfo.l >> 1);
  }
  
  private void l() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.z = bundle.getString("topic_id");
      this.A = bundle.getString("topic");
    } 
  }
  
  private void m() {
    this.f = (CommonTopTitleNoTrans)this.e.findViewById(2131300273);
    this.f.setCenterText(2131758956);
    this.f.a();
    this.f.setLeftClickListener(this);
  }
  
  private void n() {
    this.t = (FloatFooterView)this.e.findViewById(2131298800);
    this.t.setOnBtnClickListener(new -$$Lambda$SuperTopicDetailFragment$2sPeLHNC8Mp7tYGiubIg41InLlk(this));
  }
  
  private void o() {
    this.j = LayoutInflater.from(this.d).inflate(2131493802, null);
    this.k = (ImageView)this.j.findViewById(2131297444);
    this.l = (ImageView)this.j.findViewById(2131297432);
    this.l.setOnClickListener(this);
    this.m = (TextView)this.j.findViewById(2131301088);
    this.n = (TextView)this.j.findViewById(2131300685);
    this.o = (TextView)this.j.findViewById(2131301508);
    this.p = (TextView)this.j.findViewById(2131300937);
    this.q = (TextView)this.j.findViewById(2131300663);
    this.r = this.j.findViewById(2131301657);
    this.s = (NoDataAndLoadFailView)this.j.findViewById(2131299389);
    this.s.setTopSpace(DensityUtils.a(this.d, 58.0F));
    this.s.setImageScale(0.7F);
    this.s.c();
    this.g = (SmartRefreshLayout)this.e.findViewById(2131299616);
    this.h = (RecyclerView)this.e.findViewById(2131299605);
    this.i = new FeedListAdapterForRecyclerView(new ArrayList(), this.d, (IRequestHost)w_(), this.h, 5);
    this.i.b(this.j);
    this.h.setAdapter((RecyclerView.Adapter)this.i);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 1);
    this.h.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.h.addOnScrollListener(this.D);
    this.g.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            SuperTopicDetailFragment.a(this.a);
            SuperTopicDetailFragment.a(this.a, false);
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            SuperTopicDetailFragment.a(this.a, true);
          }
        });
    this.g.i();
  }
  
  private void p() {
    EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_BTN_CLICK, FeedProtos.FeedFrom.SUPER_TOPIC_DETAIL);
    if (!TextUtils.isEmpty(this.z) && !TextUtils.isEmpty(this.A)) {
      FeedPostFragment.a(getContext(), this.z, this.A);
      return;
    } 
    FeedPostFragment.a(getContext());
  }
  
  protected void a() {
    BluedTopic bluedTopic = new BluedTopic();
    bluedTopic.super_did = this.B.super_did;
    bluedTopic.avatar = this.B.avatar;
    bluedTopic.name = this.B.name;
    if (StringUtils.e(this.B.description)) {
      bluedTopic.description = this.d.getResources().getString(2131758746);
    } else {
      bluedTopic.description = this.B.description;
    } 
    ShareUtils.a().a(this.d, bluedTopic);
  }
  
  public void a(BluedTopic paramBluedTopic) {
    if (paramBluedTopic != null) {
      this.z = paramBluedTopic.super_did;
      this.A = paramBluedTopic.name;
      this.B = paramBluedTopic;
      this.f.setRightImg(2131232497);
      this.f.setRightClickListener(new -$$Lambda$SuperTopicDetailFragment$EVOXHflNvViDUef_UfywT609nog(this));
      if (!TextUtils.isEmpty(paramBluedTopic.avatar)) {
        this.v = paramBluedTopic.avatar;
        ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, paramBluedTopic.avatar)).a(2131234240).d().a(this.k);
        ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, paramBluedTopic.avatar)).a(2131234240).a(6.0F).a(this.l);
      } else {
        this.l.setImageResource(2131234240);
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramBluedTopic.name);
      stringBuilder2.append("  ");
      SpannableString spannableString = new SpannableString(stringBuilder2.toString());
      Drawable drawable = this.d.getResources().getDrawable(2131234211);
      drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
      spannableString.setSpan(new ImageSpan(drawable), spannableString.length() - 1, spannableString.length(), 33);
      this.m.setText((CharSequence)spannableString);
      this.m.setVisibility(0);
      TextView textView = this.n;
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(this.d.getString(2131758961));
      stringBuilder3.append(paramBluedTopic.creator_name);
      textView.setText(stringBuilder3.toString());
      this.n.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(this) {
            public void onSystemUiVisibilityChange(int param1Int) {}
          });
      if (!TextUtils.isEmpty(paramBluedTopic.visited_total)) {
        long l = Long.parseLong(paramBluedTopic.visited_total);
        textView = this.o;
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(AreaUtils.a(this.d, Long.valueOf(l)));
        stringBuilder3.append(this.d.getString(2131756042));
        textView.setText(stringBuilder3.toString());
      } 
      if (!TextUtils.isEmpty(paramBluedTopic.join_total)) {
        long l = Long.parseLong(paramBluedTopic.join_total);
        textView = this.p;
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(AreaUtils.a(this.d, Long.valueOf(l)));
        stringBuilder3.append(this.d.getString(2131758339));
        textView.setText(stringBuilder3.toString());
      } 
      if (TextUtils.isEmpty(paramBluedTopic.description)) {
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        return;
      } 
      this.q.setVisibility(0);
      this.r.setVisibility(0);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.d.getString(2131758963));
      stringBuilder1.append(paramBluedTopic.description);
      CharSequence charSequence = StringUtils.a(StringUtils.a(stringBuilder1.toString(), DensityUtils.a(this.d, 14.0F), 0), true, new boolean[0]);
      this.q.setText(charSequence);
    } 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131297432)
        return; 
      Context context = this.d;
      String str = this.v;
      LoadOptions loadOptions = this.u;
      BasePhotoFragment.a(context, new String[] { str }, 0, 14, loadOptions);
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493327, paramViewGroup, false);
      k();
      l();
      m();
      n();
      o();
      FeedMethods.a((LifecycleOwner)getActivity(), (IFeedDataObserver)this.i);
      CircleMethods.registerFeedListObserver((LifecycleOwner)getActivity(), (ICircleDataObserver)this.i);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onPause() {
    super.onPause();
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.i;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.c(); 
  }
  
  public void onResume() {
    super.onResume();
    FeedListAdapterForRecyclerView feedListAdapterForRecyclerView = this.i;
    if (feedListAdapterForRecyclerView != null)
      feedListAdapterForRecyclerView.b(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\SuperTopicDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */