package com.soft.blued.ui.circle.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpUtils;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.smartrefresh.BluedAdapterLoadMoreView;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.adapter.CircleRecommendListAdapter;
import com.soft.blued.ui.circle.adapter.CircleTalkAdapter;
import com.soft.blued.ui.circle.adapter.MyCircleAdapter;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.presenter.CirclePresenter;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.live.view.RecommendLoadMoreView;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.FindViewUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleNewFragment extends MvpFragment<CirclePresenter> {
  private Context d;
  
  private NoDataAndLoadFailView e;
  
  private CircleTalkAdapter f;
  
  private HeaderHolder g;
  
  private Unbinder h;
  
  private MyCircleAdapter i;
  
  private CircleRecommendListAdapter j;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131299616)
  SmartRefreshLayout refreshLayout;
  
  @BindView(2131299968)
  View skeleton;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, CircleNewFragment.class, null);
  }
  
  private void k() {
    this.skeleton.setVisibility(0);
  }
  
  private void l() {
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
  }
  
  private void m() {
    this.refreshLayout.b(false);
    this.refreshLayout.a(new OnRefreshListener(this) {
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            ((CirclePresenter)this.a.s()).e();
          }
        });
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.f = new CircleTalkAdapter(this.d, (IRequestHost)w_());
    this.f.a(false);
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.f);
    this.e = new NoDataAndLoadFailView(this.d);
    this.e.setNoDataImg(2131232633);
    this.e.setNoDataStr(2131755868);
    this.f.e((View)this.e);
    this.f.d(true);
    this.f.a((LoadMoreView)new BluedAdapterLoadMoreView());
    this.f.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            ((CirclePresenter)this.a.s()).f();
          }
        },  this.recyclerView);
    this.f.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            int i = param1View.getId();
            if (i != 2131299371 && i != 2131299375)
              return; 
            BluedIngSelfFeed bluedIngSelfFeed = CircleNewFragment.a(this.a).n().get(param1Int);
            CircleDetailsFragment.a(CircleNewFragment.b(this.a), bluedIngSelfFeed.circle_id, bluedIngSelfFeed.feed_id, CircleConstants.CIRCLE_FROM_PAGE.FIND_CIRCLE_DISCUSS_LIST);
          }
        });
    this.f.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            ((TextView)FindViewUtils.a(param1View, 2131299369)).setTextColor(BluedSkinUtils.a(CircleNewFragment.b(this.a), 2131100844));
            BluedIngSelfFeed bluedIngSelfFeed = CircleNewFragment.a(this.a).n().get(param1Int);
            CircleNewFragment.a(this.a).a(bluedIngSelfFeed.feed_id);
            CirclePostDetailsFragment.a(CircleNewFragment.b(this.a), bluedIngSelfFeed, FeedProtos.NoteSource.NOTE_LIST);
          }
        });
  }
  
  private void n() {
    View view = View.inflate(this.d, 2131493739, null);
    this.g = new HeaderHolder(this);
    this.h = ButterKnife.a(this.g, view);
    this.f.b(view);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.d);
    linearLayoutManager.setOrientation(0);
    this.g.mHeaderRecyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.i = new MyCircleAdapter((IRequestHost)w_());
    this.g.mHeaderRecyclerView.setAdapter((RecyclerView.Adapter)this.i);
    this.i.a((LoadMoreView)new RecommendLoadMoreView());
    this.i.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            List<MyCircleModel> list = CircleNewFragment.c(this.a).n();
            if (list != null) {
              MyCircleModel myCircleModel = list.get(param1Int);
              if (myCircleModel.isHotBase) {
                EventTrackFeed.a(FeedProtos.Event.CIRCLE_FIND_PAGE_SHOW, FeedProtos.CircleSource.FIND_CIRCLE_HOT);
                CircleListFragment.a(CircleNewFragment.b(this.a), CircleConstants.CIRCLE_FROM_PAGE.HOT_CIRCLE);
                return;
              } 
              CircleDetailsFragment.a(CircleNewFragment.b(this.a), myCircleModel, CircleConstants.CIRCLE_FROM_PAGE.FIND_CIRCLE_MINE);
            } 
          }
        });
    this.g.mHeaderNewBaseAll.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackFeed.b(FeedProtos.Event.FIND_CIRCLE_MINE_ALL_CLICK);
            CircleListFragment.a(CircleNewFragment.b(this.a), CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE);
          }
        });
    this.g.newBaseTitle.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackFeed.b(FeedProtos.Event.FIND_CIRCLE_NOTE_MINE_CLICK);
            CircleTalkFragment.a(CircleNewFragment.b(this.a));
          }
        });
    linearLayoutManager = new LinearLayoutManager(this.d);
    linearLayoutManager.setOrientation(0);
    this.g.mHeaderRecommendRecyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.j = new CircleRecommendListAdapter(this.d, (IRequestHost)w_());
    this.g.mHeaderRecommendRecyclerView.setAdapter((RecyclerView.Adapter)this.j);
    this.g.mHeaderRecommendMore.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackFeed.b(FeedProtos.Event.FIND_CIRCLE_RECOMMEND_MORE_CLICK);
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_FIND_PAGE_SHOW, FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND);
            CircleTypeListFragment.e.a(CircleNewFragment.b(this.a), CircleConstants.CIRCLE_FROM_PAGE.HOT_CIRCLE, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_HOME_RECOMMEND);
          }
        });
    this.g.llRankLayout.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackFeed.a(FeedProtos.Event.CIRCLE_HOT_POST_BANNER_CLICK);
            WebViewShowInfoFragment.show(CircleNewFragment.b(this.a), H5Url.a(55, new Object[] { "1" }));
          }
        });
  }
  
  public Map<Integer, List<MyCircleModel>> a(List<MyCircleModel> paramList, int paramInt) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put(Integer.valueOf(1), new ArrayList());
    for (MyCircleModel myCircleModel : paramList) {
      List<MyCircleModel> list = (List)hashMap.get(Integer.valueOf(hashMap.size()));
      paramList = list;
      if (list.size() == paramInt) {
        paramList = new ArrayList<MyCircleModel>();
        hashMap.put(Integer.valueOf(hashMap.size() + 1), paramList);
      } 
      paramList.add(myCircleModel);
    } 
    return (Map)hashMap;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.d = getContext();
    l();
    m();
    n();
    k();
  }
  
  public void a(String paramString, List paramList) {
    byte b;
    super.a(paramString, paramList);
    this.skeleton.setVisibility(8);
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 2034961053:
        if (paramString.equals("data_delete_feed")) {
          b = 8;
          break;
        } 
      case 2026743192:
        if (paramString.equals("data_base_talk_list")) {
          b = 0;
          break;
        } 
      case 1995579013:
        if (paramString.equals("data_rank_list_error")) {
          b = 7;
          break;
        } 
      case 1607616673:
        if (paramString.equals("data_base_talk_list_error")) {
          b = 1;
          break;
        } 
      case -233872522:
        if (paramString.equals("data_recommend_list")) {
          b = 4;
          break;
        } 
      case -431176232:
        if (paramString.equals("data_my_new_base_list_error")) {
          b = 3;
          break;
        } 
      case -1597579847:
        if (paramString.equals("data_hot_rank_time")) {
          b = 6;
          break;
        } 
      case -1597817974:
        if (paramString.equals("data_hot_rank_list")) {
          b = 5;
          break;
        } 
      case -1755310065:
        if (paramString.equals("data_my_new_base_list")) {
          b = 2;
          break;
        } 
    } 
    switch (b) {
      default:
        return;
      case 8:
        MvpUtils.a(paramList, String.class, new MvpUtils.DataHandler<String>(this) {
              public void a() {}
              
              public void a(String param1String) {
                CircleNewFragment.a(this.a).b(param1String);
              }
            });
        return;
      case 7:
        this.g.llRankLayout.setVisibility(8);
        return;
      case 6:
        MvpUtils.a(paramList, Long.class, new MvpUtils.DataHandler<Long>(this) {
              public void a() {
                (CircleNewFragment.d(this.a)).tvRankUpdateTime.setVisibility(8);
              }
              
              public void a(Long param1Long) {
                String str = TimeAndDateUtils.d(CircleNewFragment.b(this.a), param1Long.longValue() * 1000L);
                if (str != null && str.length() > 2) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append(str.substring(0, str.length() - 2));
                  stringBuilder.append("00");
                  str = stringBuilder.toString();
                  stringBuilder = new StringBuilder();
                  stringBuilder.append(str);
                  stringBuilder.append(CircleNewFragment.b(this.a).getString(2131755961));
                  str = stringBuilder.toString();
                  (CircleNewFragment.d(this.a)).tvRankUpdateTime.setText(str);
                  return;
                } 
                (CircleNewFragment.d(this.a)).tvRankUpdateTime.setVisibility(8);
              }
            });
        return;
      case 5:
        MvpUtils.a(paramList, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>(this) {
              private void a(BluedIngSelfFeed param1BluedIngSelfFeed, LinearLayout param1LinearLayout, TextView param1TextView, View param1View) {
                String str;
                byte b = 0;
                param1LinearLayout.setVisibility(0);
                if (!TextUtils.isEmpty(param1BluedIngSelfFeed.head)) {
                  str = param1BluedIngSelfFeed.head;
                } else {
                  str = param1BluedIngSelfFeed.feed_content;
                } 
                if (!TextUtils.isEmpty(str)) {
                  str = str.trim();
                } else {
                  str = "";
                } 
                param1TextView.setText(str);
                if (param1BluedIngSelfFeed.is_recommend != 1)
                  b = 8; 
                param1View.setVisibility(b);
              }
              
              public void a() {
                (CircleNewFragment.d(this.a)).llRankLayout.setVisibility(8);
              }
              
              public void a(List<BluedIngSelfFeed> param1List) {
                (CircleNewFragment.d(this.a)).llRank1.setVisibility(8);
                (CircleNewFragment.d(this.a)).llRank2.setVisibility(8);
                (CircleNewFragment.d(this.a)).llRank3.setVisibility(8);
                if (param1List.size() > 0) {
                  (CircleNewFragment.d(this.a)).llRankLayout.setVisibility(0);
                  a(param1List.get(0), (CircleNewFragment.d(this.a)).llRank1, (CircleNewFragment.d(this.a)).tvRankTitle1, (View)(CircleNewFragment.d(this.a)).rankIcon1);
                } else {
                  (CircleNewFragment.d(this.a)).llRankLayout.setVisibility(8);
                } 
                if (param1List.size() > 1)
                  a(param1List.get(1), (CircleNewFragment.d(this.a)).llRank2, (CircleNewFragment.d(this.a)).tvRankTitle2, (View)(CircleNewFragment.d(this.a)).rankIcon2); 
                if (param1List.size() > 2)
                  a(param1List.get(2), (CircleNewFragment.d(this.a)).llRank3, (CircleNewFragment.d(this.a)).tvRankTitle3, (View)(CircleNewFragment.d(this.a)).rankIcon3); 
              }
            });
        return;
      case 4:
        MvpUtils.a(paramList, MyCircleModel.class, new MvpUtils.DataListHandler<MyCircleModel>(this) {
              public void a() {
                (CircleNewFragment.d(this.a)).mNewBaseRecommendLayout.setVisibility(8);
              }
              
              public void a(List<MyCircleModel> param1List) {
                if (param1List.size() > 0) {
                  (CircleNewFragment.d(this.a)).mNewBaseRecommendLayout.setVisibility(0);
                  ArrayList<MyCircleModel> arrayList = new ArrayList();
                  for (List<MyCircleModel> list : this.a.a(param1List, 2).values()) {
                    MyCircleModel myCircleModel = new MyCircleModel();
                    myCircleModel.circleModelList = new ArrayList();
                    myCircleModel.circleModelList.addAll(list);
                    arrayList.add(myCircleModel);
                  } 
                  CircleNewFragment.e(this.a).c(arrayList);
                  return;
                } 
                (CircleNewFragment.d(this.a)).mNewBaseRecommendLayout.setVisibility(8);
              }
            });
        return;
      case 3:
        this.g.mNewBaseLayout.setVisibility(8);
        return;
      case 2:
        MvpUtils.a(paramList, MyCircleModel.class, new MvpUtils.DataListHandler<MyCircleModel>(this) {
              private void b(List<MyCircleModel> param1List) {
                CircleNewFragment.c(this.a).c(param1List);
                if (CircleNewFragment.c(this.a).n().size() > 0) {
                  (CircleNewFragment.d(this.a)).mNewBaseLayout.setVisibility(0);
                  return;
                } 
                (CircleNewFragment.d(this.a)).mNewBaseLayout.setVisibility(8);
              }
              
              public void a() {
                b(null);
                (CircleNewFragment.d(this.a)).mNewBaseLayout.setVisibility(8);
              }
              
              public void a(List<MyCircleModel> param1List) {
                b(param1List);
              }
            });
        return;
      case 0:
        MvpUtils.a(paramList, BluedIngSelfFeed.class, new MvpUtils.DataListHandler<BluedIngSelfFeed>(this) {
              public void a() {}
              
              public void a(List<BluedIngSelfFeed> param1List) {
                CircleNewFragment.a(this.a).c(param1List);
              }
            });
        break;
      case 1:
        break;
    } 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: invokespecial a : (Ljava/lang/String;Z)V
    //   6: aload_1
    //   7: invokevirtual hashCode : ()I
    //   10: istore_3
    //   11: iload_3
    //   12: ldc_w -1290256561
    //   15: if_icmpeq -> 43
    //   18: iload_3
    //   19: ldc_w 623698297
    //   22: if_icmpeq -> 28
    //   25: goto -> 58
    //   28: aload_1
    //   29: ldc_w '_load_type_loadmore_'
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 58
    //   38: iconst_1
    //   39: istore_3
    //   40: goto -> 60
    //   43: aload_1
    //   44: ldc_w '_load_type_refresh_'
    //   47: invokevirtual equals : (Ljava/lang/Object;)Z
    //   50: ifeq -> 58
    //   53: iconst_0
    //   54: istore_3
    //   55: goto -> 60
    //   58: iconst_m1
    //   59: istore_3
    //   60: iload_3
    //   61: ifeq -> 70
    //   64: iload_3
    //   65: iconst_1
    //   66: if_icmpeq -> 70
    //   69: return
    //   70: aload_0
    //   71: getfield refreshLayout : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   74: invokevirtual g : ()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
    //   77: pop
    //   78: aload_0
    //   79: getfield f : Lcom/soft/blued/ui/circle/adapter/CircleTalkAdapter;
    //   82: invokevirtual l : ()V
    //   85: aload_0
    //   86: getfield f : Lcom/soft/blued/ui/circle/adapter/CircleTalkAdapter;
    //   89: invokevirtual getItemCount : ()I
    //   92: iconst_2
    //   93: if_icmpne -> 115
    //   96: iload_2
    //   97: ifeq -> 108
    //   100: aload_0
    //   101: getfield e : Lcom/soft/blued/customview/NoDataAndLoadFailView;
    //   104: invokevirtual a : ()V
    //   107: return
    //   108: aload_0
    //   109: getfield e : Lcom/soft/blued/customview/NoDataAndLoadFailView;
    //   112: invokevirtual b : ()V
    //   115: return
  }
  
  public void aL_() {
    super.aL_();
    Unbinder unbinder = this.h;
    if (unbinder != null)
      unbinder.unbind(); 
  }
  
  public int p() {
    return 2131493254;
  }
  
  public void u() {
    ((CirclePresenter)s()).e();
  }
  
  public void x() {
    super.x();
    this.f.c(true);
  }
  
  public void y() {
    super.y();
    this.f.c(false);
  }
  
  public class HeaderHolder {
    @BindView(2131299031)
    LinearLayout llRank1;
    
    @BindView(2131299032)
    LinearLayout llRank2;
    
    @BindView(2131299033)
    LinearLayout llRank3;
    
    @BindView(2131299034)
    LinearLayout llRankLayout;
    
    @BindView(2131299338)
    ImageView mHeaderJoinImage;
    
    @BindView(2131299336)
    LinearLayout mHeaderNewBaseAll;
    
    @BindView(2131299342)
    LinearLayout mHeaderRecommendMore;
    
    @BindView(2131299343)
    RecyclerView mHeaderRecommendRecyclerView;
    
    @BindView(2131299347)
    RecyclerView mHeaderRecyclerView;
    
    @BindView(2131299339)
    RelativeLayout mNewBaseLayout;
    
    @BindView(2131299341)
    RelativeLayout mNewBaseRecommendLayout;
    
    @BindView(2131299378)
    View newBaseTitle;
    
    @BindView(2131299564)
    ImageView rankIcon1;
    
    @BindView(2131299565)
    ImageView rankIcon2;
    
    @BindView(2131299566)
    ImageView rankIcon3;
    
    @BindView(2131301219)
    TextView tvRankTitle1;
    
    @BindView(2131301220)
    TextView tvRankTitle2;
    
    @BindView(2131301221)
    TextView tvRankTitle3;
    
    @BindView(2131301222)
    TextView tvRankUpdateTime;
    
    public HeaderHolder(CircleNewFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleNewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */