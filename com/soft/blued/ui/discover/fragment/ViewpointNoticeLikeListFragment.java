package com.soft.blued.ui.discover.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.notify.adapter.ViewPointNoticeAdapter;
import com.soft.blued.ui.notify.model.FeedNotice;
import com.soft.blued.view.tip.CommonAlertDialog;

public class ViewpointNoticeLikeListFragment extends BaseFragment {
  private View d;
  
  private NoDataAndLoadFailView e;
  
  private ListView f;
  
  private RenrenPullToRefreshListView g;
  
  private ViewPointNoticeAdapter h;
  
  private Context i;
  
  private int j = 0;
  
  private int k = 20;
  
  private boolean l = true;
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, ViewpointNoticeLikeListFragment.class, null);
  }
  
  public void a() {
    this.g = (RenrenPullToRefreshListView)this.d.findViewById(2131298144);
    this.f = (ListView)this.g.getRefreshableView();
    this.f.setClipToPadding(false);
    this.f.setScrollBarStyle(33554432);
    this.f.setHeaderDividersEnabled(false);
    this.f.setDividerHeight(0);
    this.h = new ViewPointNoticeAdapter(this.i, (IRequestHost)w_(), false);
    this.h.a(1);
    this.f.setAdapter((ListAdapter)this.h);
    this.f.setEmptyView((View)this.e);
    this.g.postDelayed(new Runnable(this) {
          public void run() {
            ViewpointNoticeLikeListFragment.a(this.a).k();
          }
        },  100L);
    this.g.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            this.a.a(true);
          }
          
          public void b() {
            this.a.a(false);
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    if (paramBoolean) {
      this.j = 1;
    } else {
      this.j++;
    } 
    FindHttpUtils.a(new BluedUIHttpResponse<BluedEntity<FeedNotice, BluedEntityBaseExtra>>(this, (IRequestHost)w_()) {
          boolean a = false;
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a = true;
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            if (this.a) {
              this.a = false;
              ViewpointNoticeLikeListFragment.d(this.b).b();
              ViewpointNoticeLikeListFragment.c(this.b).notifyDataSetChanged();
              if (ViewpointNoticeLikeListFragment.e(this.b) > 1) {
                ViewpointNoticeLikeListFragment.g(this.b);
                return;
              } 
            } else {
              ViewpointNoticeLikeListFragment.a(this.b).j();
              ViewpointNoticeLikeListFragment.a(this.b).q();
              FindHttpUtils.a(null, "liked", String.valueOf(ViewpointNoticeLikeListFragment.c(this.b).a()), (IRequestHost)this.b.w_());
            } 
          }
          
          public void onUIUpdate(BluedEntity<FeedNotice, BluedEntityBaseExtra> param1BluedEntity) {
            if (param1BluedEntity != null && param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
              ViewpointNoticeLikeListFragment.a(this.b, param1BluedEntity.hasMore());
              if (ViewpointNoticeLikeListFragment.e(this.b) == 1) {
                ChatHelperV4.a().a(3L);
                ChatHelperV4.a().a(11L);
                ChatHelperV4.a().a(22L);
                ViewpointNoticeLikeListFragment.c(this.b).a(param1BluedEntity.data);
              } else {
                ViewpointNoticeLikeListFragment.c(this.b).b(param1BluedEntity.data);
              } 
            } else {
              ViewpointNoticeLikeListFragment.d(this.b).a();
              ViewpointNoticeLikeListFragment.c(this.b).notifyDataSetChanged();
              ViewpointNoticeLikeListFragment.a(this.b, false);
            } 
            if (ViewpointNoticeLikeListFragment.f(this.b)) {
              ViewpointNoticeLikeListFragment.a(this.b).o();
              return;
            } 
            ViewpointNoticeLikeListFragment.a(this.b).p();
          }
        }"liked", this.j, this.k, (IRequestHost)w_());
  }
  
  public void k() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.d.findViewById(2131300273);
    commonTopTitleNoTrans.setCenterText(2131757114);
    commonTopTitleNoTrans.setRightImg(2131232747);
    commonTopTitleNoTrans.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            InstantLog.b("delete_all", 2);
            CommonAlertDialog.a(ViewpointNoticeLikeListFragment.b(this.a), ViewpointNoticeLikeListFragment.b(this.a).getResources().getString(2131758303), String.format(ViewpointNoticeLikeListFragment.b(this.a).getResources().getString(2131758304), new Object[] { ViewpointNoticeLikeListFragment.b(this.a).getResources().getString(2131757114) }), ViewpointNoticeLikeListFragment.b(this.a).getResources().getString(2131756100), new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    FindHttpUtils.a(new BluedUIHttpResponse(this) {
                          public void onUIUpdate(BluedEntity param3BluedEntity) {
                            AppMethods.d(2131756206);
                            ViewpointNoticeLikeListFragment.c(this.a.a.a).b();
                            ViewpointNoticeLikeListFragment.d(this.a.a.a).a();
                            ViewpointNoticeLikeListFragment.a(this.a.a.a).p();
                          }
                        },  (IRequestHost)this.a.a.w_(), "liked", String.valueOf(ViewpointNoticeLikeListFragment.c(this.a.a).a()));
                  }
                }ViewpointNoticeLikeListFragment.b(this.a).getResources().getString(2131755726), null, null);
          }
        });
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.i = (Context)getActivity();
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493109, paramViewGroup, false);
      this.e = new NoDataAndLoadFailView(this.i);
      this.e.setNoDataImg(2131232638);
      this.e.setNoDataStr(2131756738);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\ViewpointNoticeLikeListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */