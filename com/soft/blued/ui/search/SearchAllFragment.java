package com.soft.blued.ui.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.das.message.MessageProtos;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.find.adapter.SearchNewAdapter;
import com.soft.blued.ui.find.fragment.SearchUserFragment;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.search.adapter.SearchAllAdapter;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.ui.search.presenter.SearchAllPresenter;
import java.util.List;

public class SearchAllFragment extends MvpFragment<SearchAllPresenter> {
  private String d;
  
  private SearchNewAdapter e;
  
  private SearchAllAdapter f;
  
  @BindView(2131298141)
  RecyclerView listMessage;
  
  @BindView(2131298142)
  RecyclerView listPerson;
  
  @BindView(2131298761)
  NestedScrollView llContentView;
  
  @BindView(2131298914)
  View llLine;
  
  @BindView(2131298963)
  RelativeLayout llMsgView;
  
  @BindView(2131299125)
  RelativeLayout llUserView;
  
  @BindView(2131299293)
  SearchView msgSearchView;
  
  @BindView(2131299389)
  NoDataAndLoadFailView noDataView;
  
  @BindView(2131299459)
  FrameLayout personLoading;
  
  @BindView(2131301053)
  TextView tvMoreMsg;
  
  @BindView(2131301054)
  TextView tvMorePerson;
  
  @BindView(2131301114)
  TextView tvNoResults;
  
  @BindView(2131301304)
  TextView tvSearchMsg;
  
  @BindView(2131301305)
  TextView tvSearchPerson;
  
  private void E() {
    this.noDataView.setOnTouchEvent(false);
    this.noDataView.setTopSpace(DensityUtils.a(getContext(), 40.0F));
    this.noDataView.setImageScale(0.7F);
    this.noDataView.setNoDataStr(2131758071);
    this.noDataView.setNoDataImg(2131232639);
  }
  
  private void F() {
    if (this.f.n().size() > 0 && this.e.n().size() == 0) {
      Log.v("drb", "暂无数据");
      this.llUserView.setVisibility(0);
      this.tvNoResults.setVisibility(0);
      this.tvSearchPerson.setVisibility(0);
      this.llLine.setVisibility(8);
      return;
    } 
    if (this.f.n().size() == 0 && this.e.n().size() == 0) {
      this.llContentView.setVisibility(8);
      this.noDataView.setVisibility(0);
      return;
    } 
    if (this.f.n().size() > 0 && this.e.n().size() > 0)
      this.llLine.setVisibility(0); 
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putBoolean("from", paramBoolean);
    TerminalActivity.d(paramContext, SearchAllFragment.class, bundle);
  }
  
  private void m() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.listPerson.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.listPerson.setNestedScrollingEnabled(false);
    this.e = new SearchNewAdapter(null, (Activity)getActivity(), (IRequestHost)w_(), "", this.listPerson);
    this.listPerson.setAdapter((RecyclerView.Adapter)this.e);
  }
  
  private void n() {
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.listMessage.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.listMessage.setNestedScrollingEnabled(false);
    this.f = new SearchAllAdapter((BaseFragment)this);
    this.listMessage.setAdapter((RecyclerView.Adapter)this.f);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.llLine.setVisibility(8);
    this.llMsgView.setVisibility(8);
    this.llUserView.setVisibility(8);
    this.msgSearchView.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            SearchAllFragment.a(this.a, "");
            this.a.personLoading.setVisibility(8);
            this.a.C();
            Log.v("drb", "onCancel");
          }
          
          public void a(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("doSearch:");
            stringBuilder.append(param1String);
            Log.v("drb", stringBuilder.toString());
            if (TextUtils.isEmpty(param1String)) {
              SearchAllFragment.a(this.a).n().clear();
              SearchAllFragment.b(this.a).n().clear();
              this.a.llContentView.setVisibility(8);
              this.a.noDataView.setVisibility(8);
              this.a.tvSearchPerson.setVisibility(8);
              this.a.listPerson.setVisibility(8);
              this.a.tvMorePerson.setVisibility(8);
              this.a.tvNoResults.setVisibility(8);
              Log.v("drb", "--doSearch showEmpty");
              return;
            } 
            if (this.a.llContentView != null)
              this.a.llContentView.setVisibility(0); 
            if (this.a.noDataView != null)
              this.a.noDataView.setVisibility(8); 
            SearchAllFragment.a(this.a, param1String);
            if (((SearchAllPresenter)this.a.s()).h)
              EventTrackMessage.c(MessageProtos.Event.MSG_SCREEN_SEARCH_BOX_SUCCESS, SearchAllFragment.c(this.a)); 
            ((SearchAllPresenter)this.a.s()).d(param1String);
            if (this.a.llLine == null);
          }
          
          public void b() {
            SearchAllFragment.a(this.a, "");
            SearchAllFragment.a(this.a).n().clear();
            SearchAllFragment.b(this.a).n().clear();
            this.a.personLoading.setVisibility(8);
            this.a.llContentView.setVisibility(8);
            this.a.noDataView.setVisibility(8);
            Log.v("drb", "clearContent");
          }
        });
    this.tvMoreMsg.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            SearchMessageFragment.a(this.a.getContext(), SearchAllFragment.c(this.a));
          }
        });
    this.tvMorePerson.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            SearchUserFragment.a(this.a.getContext(), SearchAllFragment.c(this.a));
          }
        });
    m();
    n();
    E();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #4
    //   9: aload #4
    //   11: ldc_w 'dismissDataLoading type:'
    //   14: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload #4
    //   20: aload_1
    //   21: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: ldc 'drb'
    //   27: aload #4
    //   29: invokevirtual toString : ()Ljava/lang/String;
    //   32: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   35: pop
    //   36: new java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial <init> : ()V
    //   43: astore #4
    //   45: aload #4
    //   47: ldc_w 'dismissDataLoading messageAdapter size :'
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload #4
    //   56: aload_0
    //   57: getfield f : Lcom/soft/blued/ui/search/adapter/SearchAllAdapter;
    //   60: invokevirtual n : ()Ljava/util/List;
    //   63: invokeinterface size : ()I
    //   68: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 'drb'
    //   74: aload #4
    //   76: invokevirtual toString : ()Ljava/lang/String;
    //   79: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: new java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial <init> : ()V
    //   90: astore #4
    //   92: aload #4
    //   94: ldc_w 'dismissDataLoading personAdapter size :'
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload #4
    //   103: aload_0
    //   104: getfield e : Lcom/soft/blued/ui/find/adapter/SearchNewAdapter;
    //   107: invokevirtual n : ()Ljava/util/List;
    //   110: invokeinterface size : ()I
    //   115: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: ldc 'drb'
    //   121: aload #4
    //   123: invokevirtual toString : ()Ljava/lang/String;
    //   126: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   129: pop
    //   130: aload_1
    //   131: invokevirtual hashCode : ()I
    //   134: istore_3
    //   135: iload_3
    //   136: ldc_w -157516238
    //   139: if_icmpeq -> 167
    //   142: iload_3
    //   143: ldc_w 1060515318
    //   146: if_icmpeq -> 152
    //   149: goto -> 182
    //   152: aload_1
    //   153: ldc_w 'MESSAGE_LIST'
    //   156: invokevirtual equals : (Ljava/lang/Object;)Z
    //   159: ifeq -> 182
    //   162: iconst_1
    //   163: istore_3
    //   164: goto -> 184
    //   167: aload_1
    //   168: ldc_w 'PERSON_LOADING'
    //   171: invokevirtual equals : (Ljava/lang/Object;)Z
    //   174: ifeq -> 182
    //   177: iconst_0
    //   178: istore_3
    //   179: goto -> 184
    //   182: iconst_m1
    //   183: istore_3
    //   184: iload_3
    //   185: ifeq -> 189
    //   188: return
    //   189: aload_0
    //   190: getfield personLoading : Landroid/widget/FrameLayout;
    //   193: bipush #8
    //   195: invokevirtual setVisibility : (I)V
    //   198: aload_0
    //   199: invokespecial F : ()V
    //   202: return
  }
  
  public void a(List<UserFindResult> paramList) {
    Log.v("drb", "notifyPersonList");
    this.llUserView.setVisibility(0);
    this.tvSearchPerson.setVisibility(0);
    this.listPerson.setVisibility(0);
    this.tvNoResults.setVisibility(8);
    if (paramList.size() <= 3) {
      this.e.a(paramList, this.d);
      this.tvMorePerson.setVisibility(8);
      return;
    } 
    this.e.a(paramList.subList(0, 3), this.d);
    this.tvMorePerson.setVisibility(0);
  }
  
  public void b(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial b : (Ljava/lang/String;)V
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore_3
    //   13: aload_3
    //   14: ldc_w 'showDataLoading type:'
    //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_1
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 'drb'
    //   29: aload_3
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: aload_1
    //   38: invokevirtual hashCode : ()I
    //   41: istore_2
    //   42: iload_2
    //   43: ldc_w -157516238
    //   46: if_icmpeq -> 74
    //   49: iload_2
    //   50: ldc_w 1060515318
    //   53: if_icmpeq -> 59
    //   56: goto -> 89
    //   59: aload_1
    //   60: ldc_w 'MESSAGE_LIST'
    //   63: invokevirtual equals : (Ljava/lang/Object;)Z
    //   66: ifeq -> 89
    //   69: iconst_1
    //   70: istore_2
    //   71: goto -> 91
    //   74: aload_1
    //   75: ldc_w 'PERSON_LOADING'
    //   78: invokevirtual equals : (Ljava/lang/Object;)Z
    //   81: ifeq -> 89
    //   84: iconst_0
    //   85: istore_2
    //   86: goto -> 91
    //   89: iconst_m1
    //   90: istore_2
    //   91: iload_2
    //   92: ifeq -> 114
    //   95: iload_2
    //   96: iconst_1
    //   97: if_icmpeq -> 101
    //   100: return
    //   101: aload_0
    //   102: getfield f : Lcom/soft/blued/ui/search/adapter/SearchAllAdapter;
    //   105: invokevirtual n : ()Ljava/util/List;
    //   108: invokeinterface clear : ()V
    //   113: return
    //   114: aload_0
    //   115: getfield e : Lcom/soft/blued/ui/find/adapter/SearchNewAdapter;
    //   118: invokevirtual n : ()Ljava/util/List;
    //   121: invokeinterface clear : ()V
    //   126: aload_0
    //   127: getfield personLoading : Landroid/widget/FrameLayout;
    //   130: iconst_0
    //   131: invokevirtual setVisibility : (I)V
    //   134: aload_0
    //   135: getfield tvNoResults : Landroid/widget/TextView;
    //   138: bipush #8
    //   140: invokevirtual setVisibility : (I)V
    //   143: aload_0
    //   144: getfield tvSearchPerson : Landroid/widget/TextView;
    //   147: bipush #8
    //   149: invokevirtual setVisibility : (I)V
    //   152: aload_0
    //   153: getfield listPerson : Landroidx/recyclerview/widget/RecyclerView;
    //   156: bipush #8
    //   158: invokevirtual setVisibility : (I)V
    //   161: aload_0
    //   162: getfield tvMorePerson : Landroid/widget/TextView;
    //   165: bipush #8
    //   167: invokevirtual setVisibility : (I)V
    //   170: aload_0
    //   171: getfield llLine : Landroid/view/View;
    //   174: bipush #8
    //   176: invokevirtual setVisibility : (I)V
    //   179: return
  }
  
  public void b(List<SearchSessionModel> paramList) {
    this.llMsgView.setVisibility(0);
    if (paramList.size() <= 3) {
      this.f.a(paramList, this.d);
      this.tvMoreMsg.setVisibility(8);
    } else {
      this.f.a(paramList.subList(0, 3), this.d);
      this.tvMoreMsg.setVisibility(0);
    } 
    Log.v("drb", "notifyMessageList");
  }
  
  public void k() {
    Log.v("drb", "notifyPersonEmpty");
    if (((SearchAllPresenter)s()).h)
      this.llLine.setVisibility(8); 
  }
  
  public void l() {
    this.llMsgView.setVisibility(8);
    Log.v("drb", "messageEmpty");
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    if (((SearchAllPresenter)s()).h) {
      ((RelativeLayout.LayoutParams)this.llLine.getLayoutParams()).addRule(3, 2131298963);
      ((RelativeLayout.LayoutParams)this.llUserView.getLayoutParams()).addRule(3, 2131298914);
    } else {
      ((RelativeLayout.LayoutParams)this.llMsgView.getLayoutParams()).addRule(3, 2131298914);
      ((RelativeLayout.LayoutParams)this.llLine.getLayoutParams()).addRule(3, 2131299125);
    } 
    b(new Runnable(this) {
          public void run() {
            this.a.msgSearchView.a(true);
            KeyboardUtils.c((Activity)this.a.getActivity());
            this.a.msgSearchView.getEditView().requestFocus();
            this.a.msgSearchView.getEditView().setCursorVisible(true);
          }
        },  500L);
  }
  
  public int p() {
    return 2131493305;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\SearchAllFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */