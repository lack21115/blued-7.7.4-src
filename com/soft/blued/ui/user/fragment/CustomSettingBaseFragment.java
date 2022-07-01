package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.das.vip.VipProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.adapter.VIPCustomSettingAdapter;
import com.soft.blued.ui.user.model.DynamicSkinModel;
import com.soft.blued.ui.user.model.VIPCustomSettingBase;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.TimeAndDateUtils;
import java.util.Iterator;
import java.util.List;

public abstract class CustomSettingBaseFragment extends BaseFragment implements View.OnClickListener {
  public Context d;
  
  public View e;
  
  public Dialog f;
  
  public PullToRefreshRecyclerView g;
  
  public RecyclerView h;
  
  public NoDataAndLoadFailView i;
  
  public VIPCustomSettingAdapter j;
  
  public int k;
  
  public int l;
  
  public String m;
  
  private VipProtos.FromType n = VipProtos.FromType.UNKNOWN_FROM;
  
  private void c(int paramInt) {
    BluedUIHttpResponse<BluedEntityA<DynamicSkinModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<DynamicSkinModel>>(this, (IRequestHost)w_(), paramInt) {
        protected void a(BluedEntityA<DynamicSkinModel> param1BluedEntityA) {
          this.b.b(this.a);
          for (VIPCustomSettingBase vIPCustomSettingBase : this.b.j.n()) {
            vIPCustomSettingBase.lastSelected = false;
            if (vIPCustomSettingBase.id == this.a)
              vIPCustomSettingBase.lastSelected = true; 
          } 
          this.b.j.notifyDataSetChanged();
        }
        
        public void onUIFinish() {
          this.b.f.dismiss();
        }
        
        public void onUIStart() {
          super.onUIStart();
          this.b.f.show();
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    MineHttpUtils.a(bluedUIHttpResponse, stringBuilder.toString(), k());
  }
  
  private void c(VIPCustomSettingBase paramVIPCustomSettingBase) {
    c(paramVIPCustomSettingBase.id);
    a(paramVIPCustomSettingBase.id);
  }
  
  private void s() {
    this.l = getArguments().getInt("KEY_VIP_GRADE");
    this.m = getArguments().getString("KEY_VIP_DETAIL");
    this.n = (VipProtos.FromType)getArguments().getSerializable("KEY_VIP_FROM_TYPE");
  }
  
  private void t() {
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.setCenterText(l());
    commonTopTitleNoTrans.setLeftClickListener(this);
    commonTopTitleNoTrans.setLeftImg(2131232744);
    commonTopTitleNoTrans.setCenterTextColor(2131100728);
    commonTopTitleNoTrans.e();
    commonTopTitleNoTrans.a();
  }
  
  private void u() {
    this.f = DialogUtils.a(this.d);
    this.i = new NoDataAndLoadFailView(this.d);
    this.i.c();
    this.i.setImageScale(0.7F);
    this.i.setNoDataImg(2131232633);
    this.g = (PullToRefreshRecyclerView)this.e.findViewById(2131301764);
    this.g.setRefreshEnabled(false);
    this.h = (RecyclerView)this.g.getRefreshableView();
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.d, 3);
    this.h.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    this.j = new VIPCustomSettingAdapter(this.d, this.l, this.m, n(), a());
    this.j.e((View)this.i);
    View view = new View(this.d);
    view.setLayoutParams(new ViewGroup.LayoutParams(0, DensityUtils.a(this.d, 75.0F)));
    this.j.c(view);
    this.h.setAdapter((RecyclerView.Adapter)this.j);
    this.j.a(new -$$Lambda$CustomSettingBaseFragment$EB-xRAIXMykymfyqLcJGZjQVxW8(this));
  }
  
  private void v() {
    MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<VIPCustomSettingBase>>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA<VIPCustomSettingBase> param1BluedEntityA) {
            // Byte code:
            //   0: ldc 'drb'
            //   2: ldc 'getBluedTheme onUIUpdate'
            //   4: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
            //   7: pop
            //   8: iconst_1
            //   9: istore_2
            //   10: new com/soft/blued/ui/user/model/DynamicSkinModel
            //   13: dup
            //   14: iconst_1
            //   15: iconst_1
            //   16: iconst_1
            //   17: invokespecial <init> : (ZIZ)V
            //   20: astore_3
            //   21: aload_3
            //   22: aload_0
            //   23: getfield a : Lcom/soft/blued/ui/user/fragment/CustomSettingBaseFragment;
            //   26: getfield d : Landroid/content/Context;
            //   29: invokevirtual getResources : ()Landroid/content/res/Resources;
            //   32: ldc 2131756173
            //   34: invokevirtual getString : (I)Ljava/lang/String;
            //   37: putfield name : Ljava/lang/String;
            //   40: aload_0
            //   41: getfield a : Lcom/soft/blued/ui/user/fragment/CustomSettingBaseFragment;
            //   44: getfield j : Lcom/soft/blued/ui/user/adapter/VIPCustomSettingAdapter;
            //   47: aload_3
            //   48: invokevirtual a : (Ljava/lang/Object;)V
            //   51: aload_1
            //   52: invokevirtual hasData : ()Z
            //   55: ifeq -> 168
            //   58: aload_1
            //   59: getfield data : Ljava/util/List;
            //   62: invokeinterface iterator : ()Ljava/util/Iterator;
            //   67: astore #4
            //   69: aload #4
            //   71: invokeinterface hasNext : ()Z
            //   76: ifeq -> 140
            //   79: aload #4
            //   81: invokeinterface next : ()Ljava/lang/Object;
            //   86: checkcast com/soft/blued/ui/user/model/VIPCustomSettingBase
            //   89: astore #5
            //   91: aload #5
            //   93: getfield selected : I
            //   96: iconst_1
            //   97: if_icmpne -> 69
            //   100: aload #5
            //   102: iconst_1
            //   103: putfield lastSelected : Z
            //   106: aload_0
            //   107: getfield a : Lcom/soft/blued/ui/user/fragment/CustomSettingBaseFragment;
            //   110: aload #5
            //   112: getfield id : I
            //   115: putfield k : I
            //   118: aload_3
            //   119: iconst_0
            //   120: putfield selected : I
            //   123: aload_3
            //   124: iconst_0
            //   125: putfield lastSelected : Z
            //   128: aload_0
            //   129: getfield a : Lcom/soft/blued/ui/user/fragment/CustomSettingBaseFragment;
            //   132: aload #5
            //   134: invokevirtual b : (Lcom/soft/blued/ui/user/model/VIPCustomSettingBase;)V
            //   137: goto -> 142
            //   140: iconst_0
            //   141: istore_2
            //   142: iload_2
            //   143: ifne -> 154
            //   146: aload_0
            //   147: getfield a : Lcom/soft/blued/ui/user/fragment/CustomSettingBaseFragment;
            //   150: aload_3
            //   151: invokevirtual b : (Lcom/soft/blued/ui/user/model/VIPCustomSettingBase;)V
            //   154: aload_0
            //   155: getfield a : Lcom/soft/blued/ui/user/fragment/CustomSettingBaseFragment;
            //   158: getfield j : Lcom/soft/blued/ui/user/adapter/VIPCustomSettingAdapter;
            //   161: aload_1
            //   162: getfield data : Ljava/util/List;
            //   165: invokevirtual a : (Ljava/util/Collection;)V
            //   168: return
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            Log.v("drb", "getBluedTheme onUIFailure");
            if (this.a.j.n().size() == 0) {
              DynamicSkinModel dynamicSkinModel = new DynamicSkinModel(true, 1, true);
              this.a.j.a(dynamicSkinModel);
            } 
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish() {
            this.a.f.dismiss();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.f.show();
          }
        }k());
  }
  
  public abstract int a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(VIPCustomSettingBase paramVIPCustomSettingBase);
  
  public abstract void b(int paramInt);
  
  public abstract void b(VIPCustomSettingBase paramVIPCustomSettingBase);
  
  public abstract String k();
  
  public abstract String l();
  
  public abstract int m();
  
  public abstract Drawable n();
  
  public abstract int o();
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296863) {
      if (i != 2131296867)
        return; 
      r();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(o(), paramViewGroup, false);
      s();
      t();
      u();
      v();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public boolean p() {
    return ((UserInfo.a().i()).vip_grade != 0);
  }
  
  public void q() {
    PayUtils.a(this.d, this.l, this.m, m(), this.n);
  }
  
  public void r() {
    Iterator<VIPCustomSettingBase> iterator = this.j.n().iterator();
    while (iterator.hasNext()) {
      VIPCustomSettingBase vIPCustomSettingBase = iterator.next();
      if (vIPCustomSettingBase.selected == 1) {
        if (vIPCustomSettingBase.is_termination == 1) {
          String str = this.d.getResources().getString(2131757122);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(vIPCustomSettingBase.stop_time);
          stringBuilder.append("");
          str = String.format(str, new Object[] { TimeAndDateUtils.a(stringBuilder.toString()) });
          Context context = this.d;
          CommonAlertDialog.a(context, "", str, context.getResources().getString(2131755597), new -$$Lambda$CustomSettingBaseFragment$UhAVCHKpDJkqmkXja3HevLiLZGk(this, vIPCustomSettingBase), this.d.getResources().getString(2131755577), null, null);
          return;
        } 
        c(vIPCustomSettingBase);
        break;
      } 
    } 
  }
  
  public static interface CUSTOM_TYPE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\CustomSettingBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */