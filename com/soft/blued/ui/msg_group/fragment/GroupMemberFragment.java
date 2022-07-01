package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.ui.msg_group.adapter.GroupMemberAdapter;
import com.soft.blued.ui.msg_group.model.GroupMemberModel;
import com.soft.blued.ui.msg_group.presenter.GroupMemberPresenter;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class GroupMemberFragment extends MvpFragment<GroupMemberPresenter> implements View.OnClickListener {
  @BindView(2131296865)
  ImageView ctt_left_img;
  
  private GroupMemberAdapter d;
  
  private NoDataAndLoadFailView e;
  
  private ListView f;
  
  @BindView(2131297224)
  FrameLayout frame_layout;
  
  private boolean g = true;
  
  private PopMenu h;
  
  private MenuViewHolder i;
  
  @BindView(2131297741)
  ImageView iv_delete;
  
  @BindView(2131297924)
  ImageView iv_sort;
  
  private Unbinder j;
  
  @BindView(2131299213)
  RenrenPullToRefreshListView mListViewWrapper;
  
  @BindView(2131299689)
  RelativeLayout rl_bottom;
  
  @BindView(2131300702)
  TextView tv_delete;
  
  private void c(String paramString) {
    String str;
    Context context = getContext();
    if (TextUtils.isEmpty(paramString) && this.d.c.size() > 1) {
      str = getString(2131756691);
    } else {
      str = getString(2131756692);
    } 
    CommonAlertDialog.a(context, "", str, getContext().getResources().getString(2131756100), new DialogInterface.OnClickListener(this, paramString) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            if (TextUtils.isEmpty(this.a) && (GroupMemberFragment.c(this.b)).c.size() > 0) {
              for (String str1 : (GroupMemberFragment.c(this.b)).c) {
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append(str1);
                stringBuilder1.append(",");
                stringBuilder.append(stringBuilder1.toString());
              } 
            } else if (!TextUtils.isEmpty(this.a)) {
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(this.a);
              stringBuilder1.append(",");
              stringBuilder.append(stringBuilder1.toString());
            } 
            String str = stringBuilder.toString();
            ((GroupMemberPresenter)this.b.s()).a(str.substring(0, str.length() - 1), 4, new int[0]);
            param1DialogInterface.dismiss();
          }
        }getContext().getResources().getString(2131756057), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        },  null);
  }
  
  private void d(String paramString) {
    this.h.d();
    ((GroupMemberPresenter)s()).l = paramString;
    u();
  }
  
  private void l() {
    LiveEventBus.get("delete_member", GroupMemberModel.class).observe((LifecycleOwner)this, new Observer<GroupMemberModel>(this) {
          public void a(GroupMemberModel param1GroupMemberModel) {
            if (param1GroupMemberModel.group_role == 1)
              return; 
            if (((GroupMemberPresenter)this.a.s()).m == 3)
              return; 
            if (((GroupMemberPresenter)this.a.s()).m == 2 && param1GroupMemberModel.group_role != 3)
              return; 
            GroupMemberFragment.a(this.a, param1GroupMemberModel.uid);
          }
        });
  }
  
  private void m() {
    View view = LayoutInflater.from(getContext()).inflate(2131493945, null);
    this.i = new MenuViewHolder();
    this.j = ButterKnife.a(this.i, view);
    this.h = new PopMenu(getContext(), view);
    this.i.rl_item0.setOnClickListener(this);
    this.i.rl_item1.setOnClickListener(this);
    this.i.rl_item2.setOnClickListener(this);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    this.e = new NoDataAndLoadFailView(getContext());
    this.e.setNoDataImg(2131232643);
    this.e.c();
    this.frame_layout.addView((View)this.e);
    m();
    this.mListViewWrapper.setRefreshEnabled(true);
    this.f = (ListView)this.mListViewWrapper.getRefreshableView();
    this.f.setClipToPadding(false);
    this.f.setScrollBarStyle(33554432);
    this.f.setHeaderDividersEnabled(false);
    this.f.setDividerHeight(0);
    this.mListViewWrapper.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            GroupMemberFragment.a(this.a, true);
            this.a.u();
          }
          
          public void b() {
            if (!GroupMemberFragment.a(this.a)) {
              AppMethods.a(this.a.getResources().getString(2131756083));
              return;
            } 
            ((GroupMemberPresenter)this.a.s()).f();
          }
        });
    this.tv_delete.setOnClickListener(this);
    this.ctt_left_img.setOnClickListener(this);
    if (((GroupMemberPresenter)s()).m == 1 || ((GroupMemberPresenter)s()).m == 2) {
      this.iv_delete.setVisibility(0);
      this.iv_sort.setVisibility(0);
      this.iv_sort.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (GroupMemberFragment.b(this.a).a()) {
                GroupMemberFragment.b(this.a).d();
                return;
              } 
              GroupMemberFragment.b(this.a).a((View)this.a.iv_sort);
            }
          });
      this.iv_delete.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              (GroupMemberFragment.c(this.a)).b ^= 0x1;
              GroupMemberFragment.c(this.a).notifyDataSetChanged();
              if ((GroupMemberFragment.c(this.a)).b) {
                this.a.rl_bottom.setVisibility(0);
                return;
              } 
              (GroupMemberFragment.c(this.a)).c.clear();
              this.a.rl_bottom.setVisibility(8);
            }
          });
    } 
    l();
    this.iv_sort.setVisibility(8);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    this.mListViewWrapper.j();
    this.mListViewWrapper.q();
  }
  
  public void a(List<GroupMemberModel> paramList) {
    if (this.d == null) {
      this.d = new GroupMemberAdapter(getContext(), 4, ((GroupMemberPresenter)s()).m, (IRequestHost)w_());
      this.f.setAdapter((ListAdapter)this.d);
    } 
    this.d.a(paramList);
    if (this.g)
      this.mListViewWrapper.o(); 
  }
  
  public void k() {
    LiveEventBus.get("kick_out_member", Void.class).post(null);
    this.rl_bottom.setVisibility(8);
    this.d.a();
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296865) {
      if (i != 2131300702) {
        switch (i) {
          default:
            return;
          case 2131299715:
            if (((GroupMemberPresenter)s()).l.equals("talk_asc"))
              return; 
            this.i.checkbox0.setVisibility(8);
            this.i.checkbox1.setVisibility(8);
            this.i.checkbox2.setVisibility(0);
            d("talk_asc");
            return;
          case 2131299714:
            if (((GroupMemberPresenter)s()).l.equals("talk"))
              return; 
            this.i.checkbox0.setVisibility(8);
            this.i.checkbox1.setVisibility(0);
            this.i.checkbox2.setVisibility(8);
            d("talk");
            return;
          case 2131299713:
            break;
        } 
        if (((GroupMemberPresenter)s()).l.equals("joined"))
          return; 
        this.i.checkbox0.setVisibility(0);
        this.i.checkbox1.setVisibility(8);
        this.i.checkbox2.setVisibility(8);
        d("joined");
        return;
      } 
      if (this.d.c.size() <= 0)
        return; 
      c((String)null);
      return;
    } 
    C();
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.j.unbind();
  }
  
  public int p() {
    return 2131493061;
  }
  
  public void y() {
    super.y();
    this.g = false;
    this.mListViewWrapper.p();
  }
  
  static class MenuViewHolder {
    @BindView(2131296731)
    public CheckBox checkbox0;
    
    @BindView(2131296732)
    public CheckBox checkbox1;
    
    @BindView(2131296733)
    public CheckBox checkbox2;
    
    @BindView(2131299713)
    public RelativeLayout rl_item0;
    
    @BindView(2131299714)
    public RelativeLayout rl_item1;
    
    @BindView(2131299715)
    public RelativeLayout rl_item2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupMemberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */