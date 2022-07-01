package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.activity.keyboardpage.SwitchPanelRelativeLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.emoticon.manager.EmotionManager;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.emoticon.model.EmoticonPackageModel;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import com.soft.blued.emoticon.ui.EmoticonsPageView;
import com.soft.blued.emoticon.ui.EmoticonsToolBarView;
import com.soft.blued.emoticon.ui.IViewStateListener;
import com.soft.blued.ui.feed.adapter.FeedDetailsCommentListAdapter;
import com.soft.blued.ui.feed.contract.IHotCommentsContract;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.presenter.HotCommentsPresenter;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.PopMenuUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HotCommentsFragment extends KeyBoardFragment implements View.OnClickListener, IHotCommentsContract.IView {
  private EditText A;
  
  private View B;
  
  private View C;
  
  private EmoticonsPageView D;
  
  private EmoticonsIndicatorView E;
  
  private EmoticonsToolBarView F;
  
  private AtChooseUserHelper G;
  
  private View H;
  
  private SwitchPanelRelativeLayout I;
  
  private TextWatcher J = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      private String d;
      
      private String e;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = HotCommentsFragment.a(this.a).getSelectionStart();
        this.c = HotCommentsFragment.a(this.a).getSelectionEnd();
        HotCommentsFragment.a(this.a).removeTextChangedListener(HotCommentsFragment.i(this.a));
        if (!HotCommentsFragment.j(this.a).a(this.a, this.d, this.e, param1Editable, this.c))
          HotCommentsFragment.a(this.a).setSelection(this.b); 
        HotCommentsFragment.a(this.a).addTextChangedListener(HotCommentsFragment.i(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1CharSequence);
        stringBuilder.append("");
        this.d = stringBuilder.toString();
      }
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1CharSequence);
        stringBuilder.append("");
        this.e = stringBuilder.toString();
      }
    };
  
  public KeyboardListenLinearLayout e;
  
  public View f;
  
  private Context o;
  
  private View p;
  
  private FeedDetailsCommentListAdapter q;
  
  private NoDataAndLoadFailView r;
  
  private SmartRefreshLayout s;
  
  private RecyclerView t;
  
  private NoDataAndLoadFailView u;
  
  private IHotCommentsContract.IPresenter v;
  
  private BluedIngSelfFeed w;
  
  private View x;
  
  private Emotion y;
  
  private View z;
  
  public static void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (paramBluedIngSelfFeed != null) {
      Bundle bundle = new Bundle();
      bundle.putSerializable("feedData", (Serializable)paramBluedIngSelfFeed);
      TerminalActivity.a(bundle);
      TerminalActivity.d(paramContext, HotCommentsFragment.class, bundle);
    } 
  }
  
  private void v() {
    if (getArguments() != null)
      this.w = (BluedIngSelfFeed)getArguments().getSerializable("feedData"); 
  }
  
  public boolean V_() {
    if (this.I.getVisibility() == 0) {
      this.I.setVisibility(8);
      return true;
    } 
    return false;
  }
  
  public void a() {
    this.s.b(true);
  }
  
  public void a(String paramString) {
    KeyboardUtils.c((Activity)getActivity());
    this.A.setHint(paramString);
  }
  
  public void a(List<FeedComment> paramList) {
    this.q.a(paramList);
  }
  
  public void aH_() {
    this.r.c();
  }
  
  public void aI_() {
    this.r.a();
  }
  
  public void b() {
    this.s.b(false);
  }
  
  public void b(List<FeedComment> paramList) {
    this.q.c(paramList);
  }
  
  public void d() {
    this.s.g();
    this.s.h();
  }
  
  public void e() {
    KeyboardUtils.a((Activity)getActivity());
    this.v.a(true);
    this.v.b("");
    this.v.a("");
    this.A.setHint("");
    this.A.setText("");
    KeyboardUtils.a((Activity)getActivity());
    this.I.setVisibility(8);
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      if (this.I.getVisibility() != 0) {
        this.x.setVisibility(8);
        return;
      } 
    } else {
      this.A.requestFocus();
      this.x.setVisibility(0);
      this.x.setOnTouchListener(new View.OnTouchListener(this) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              KeyboardUtils.a((Activity)this.a.getActivity());
              HotCommentsFragment.g(this.a).setVisibility(8);
              HotCommentsFragment.h(this.a).setVisibility(8);
              return true;
            }
          });
    } 
  }
  
  public void h() {
    this.r.b();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1) {
      if (paramInt1 == 9090) {
        this.G.a(this.A, paramIntent, this.J);
        a(new Runnable(this) {
              public void run() {
                HotCommentsFragment.a(this.a).requestFocus();
                KeyboardUtils.c((Activity)this.a.getActivity());
              }
            },  300L);
      } 
    } else if (paramInt1 == 9090) {
      a(new Runnable(this) {
            public void run() {
              HotCommentsFragment.a(this.a).requestFocus();
              KeyboardUtils.c((Activity)this.a.getActivity());
            }
          },  300L);
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    String str;
    switch (paramView.getId()) {
      default:
        return;
      case 2131301637:
        PopMenuUtils.a(this.o);
        return;
      case 2131299890:
        str = this.A.getText().toString();
        if (!TextUtils.isEmpty(str.trim())) {
          str = this.G.b(str);
          this.v.a(str, false);
          return;
        } 
        AppMethods.d(2131756414);
        return;
      case 2131297025:
        O_();
        return;
      case 2131296863:
        break;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(16);
    this.o = (Context)getActivity();
    this.G = new AtChooseUserHelper(this.o);
    View view = this.p;
    if (view == null) {
      this.p = paramLayoutInflater.inflate(2131493123, paramViewGroup, false);
      v();
      this.v = (IHotCommentsContract.IPresenter)new HotCommentsPresenter(this.o, this.w, this, (IRequestHost)w_());
      t();
      a((View)this.I, this.e, this.A, this.f);
      u();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.p.getParent()).removeView(this.p);
    } 
    return this.p;
  }
  
  public void onResume() {
    super.onResume();
    if (this.H != null) {
      if (PopMenuUtils.a()) {
        this.H.setVisibility(0);
        return;
      } 
      this.H.setVisibility(8);
    } 
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void t() {
    this.H = this.p.findViewById(2131301637);
    if (PopMenuUtils.a()) {
      this.H.setVisibility(0);
    } else {
      this.H.setVisibility(8);
    } 
    this.H.setOnClickListener(this);
    this.r = new NoDataAndLoadFailView(this.o);
    this.r.c();
    this.s = (SmartRefreshLayout)this.p.findViewById(2131299616);
    this.s.c(true);
    this.t = (RecyclerView)this.p.findViewById(2131299605);
    this.t.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext()));
    this.t.setClipToPadding(false);
    this.t.setScrollBarSize(33554432);
    this.I = (SwitchPanelRelativeLayout)this.p.findViewById(2131296984);
    if (this.q == null) {
      this.q = new FeedDetailsCommentListAdapter(this.o, (IRequestHost)w_(), "feed_hot_comment_detail");
      this.u = new NoDataAndLoadFailView(getContext());
      this.u.setNoDataImg(2131232635);
      this.q.e((View)this.u);
      this.s.d(100);
    } 
    this.t.setAdapter((RecyclerView.Adapter)this.q);
    this.s.a(new OnRefreshLoadMoreListener(this) {
          public void a(RefreshLayout param1RefreshLayout) {
            HotCommentsFragment.b(this.a).c();
          }
          
          public void onRefresh(RefreshLayout param1RefreshLayout) {
            HotCommentsFragment.b(this.a).b();
          }
        });
    this.q.a(new FeedDetailsCommentListAdapter.FeedCommentListener(this) {
          public void a(FeedComment param1FeedComment) {
            HotCommentsFragment.b(this.a).d().contentClick(param1FeedComment);
          }
        });
    this.z = this.p.findViewById(2131296550);
    this.A = (EditText)this.z.findViewById(2131296971);
    this.A.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(256) });
    this.A.addTextChangedListener(this.J);
    this.B = this.z.findViewById(2131297025);
    this.B.setOnClickListener(this);
    this.C = this.z.findViewById(2131299890);
    this.C.setOnClickListener(this);
    this.e = (KeyboardListenLinearLayout)this.p.findViewById(2131297981);
    this.x = this.p.findViewById(2131297985);
    this.f = this.p.findViewById(2131296983);
    this.z.setVisibility(0);
    this.y = new Emotion(this.o);
    ArrayList<EmoticonPackageModel> arrayList = new ArrayList();
    arrayList.add(EmotionManager.h());
    this.D = (EmoticonsPageView)this.f.findViewById(2131301643);
    this.E = (EmoticonsIndicatorView)this.f.findViewById(2131301642);
    this.F = (EmoticonsToolBarView)this.f.findViewById(2131301644);
    this.F.setModel(true);
    this.F.a((IRequestHost)w_(), arrayList);
    this.D.a((IRequestHost)w_(), arrayList);
    this.D.setOnIndicatorListener(new EmoticonsPageView.OnEmoticonsPageViewListener(this) {
          public void a(int param1Int) {
            HotCommentsFragment.c(this.a).a(param1Int);
          }
          
          public void a(int param1Int1, int param1Int2) {
            HotCommentsFragment.c(this.a).a(param1Int1, param1Int2);
          }
          
          public void b(int param1Int) {
            HotCommentsFragment.c(this.a).setIndicatorCount(param1Int);
          }
          
          public void c(int param1Int) {
            HotCommentsFragment.c(this.a).b(param1Int);
          }
        });
    this.D.setIViewListener(new IViewStateListener(this) {
          public void a(EmoticonModel param1EmoticonModel) {
            if (HotCommentsFragment.a(this.a) != null) {
              KeyEvent keyEvent;
              SpannableString spannableString;
              HotCommentsFragment.a(this.a).setFocusable(true);
              HotCommentsFragment.a(this.a).setFocusableInTouchMode(true);
              HotCommentsFragment.a(this.a).requestFocus();
              if (param1EmoticonModel.eventType == 1L) {
                keyEvent = new KeyEvent(0, 67);
                HotCommentsFragment.a(this.a).onKeyDown(67, keyEvent);
                return;
              } 
              if (((EmoticonModel)keyEvent).eventType == 2L)
                return; 
              if (((EmoticonModel)keyEvent).emoji == null) {
                spannableString = HotCommentsFragment.d(this.a).a(((EmoticonModel)keyEvent).code);
                HotCommentsFragment.a(this.a).getText().insert(HotCommentsFragment.a(this.a).getSelectionStart(), (CharSequence)spannableString);
                return;
              } 
              HotCommentsFragment.a(this.a).append(((EmoticonModel)spannableString).emoji.a());
            } 
          }
          
          public void c(int param1Int) {
            HotCommentsFragment.e(this.a).setToolBtnSelect(param1Int);
          }
        });
    this.F.setOnToolBarItemClickListener(new EmoticonsToolBarView.OnToolBarItemClickListener(this) {
          public void a(int param1Int) {
            HotCommentsFragment.f(this.a).setPageSelect(param1Int);
          }
        });
  }
  
  public void u() {
    View view = this.p.findViewById(2131300293);
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    layoutParams.height = StatusBarHelper.a(getContext());
    view.setLayoutParams(layoutParams);
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.p.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131757027));
    commonTopTitleNoTrans.setLeftClickListener(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\HotCommentsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */