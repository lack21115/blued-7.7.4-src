package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.superexpose.SuperExposeProtos;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.log.trackUtils.EventTrackSuperExpose;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.view.tip.CommonAlertDialog;

public class FeedPromotionTipDialogFragment extends BaseFragment implements View.OnClickListener {
  public View d;
  
  public CardView e;
  
  public LayoutInflater f;
  
  private Context g;
  
  private ImageView h;
  
  private ImageView i;
  
  private TextView j;
  
  private TextView k;
  
  private String l;
  
  private boolean m;
  
  private void a() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.l = bundle.getString("url");
      this.m = bundle.getBoolean("always");
    } 
  }
  
  private void k() {
    this.e = (CardView)this.d.findViewById(2131296659);
    if (this.m) {
      this.e.setVisibility(8);
      EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_SUCCESS_POP_SHOW);
      CommonAlertDialog.a((Context)getActivity(), getResources().getString(2131758474), getResources().getString(2131758473), getResources().getString(2131756415), new DialogInterface.OnClickListener(this) {
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_SUCCESS_POP_GO_HOT_CLICK);
              WebViewShowInfoFragment.show(FeedPromotionTipDialogFragment.a(this.a), FeedPromotionTipDialogFragment.b(this.a), 0);
            }
          }getResources().getString(2131756187), null, new DialogInterface.OnDismissListener(this) {
            public void onDismiss(DialogInterface param1DialogInterface) {
              this.a.getActivity().finish();
            }
          });
      return;
    } 
    this.e.setVisibility(0);
    this.h = (ImageView)this.d.findViewById(2131297729);
    this.k = (TextView)this.d.findViewById(2131300601);
    this.i = (ImageView)this.d.findViewById(2131297567);
    if (BluedConfig.b().n() != null) {
      if (!TextUtils.isEmpty((BluedConfig.b().n()).btn))
        this.k.setText((BluedConfig.b().n()).btn); 
      if (!TextUtils.isEmpty((BluedConfig.b().n()).img))
        ImageLoader.a((IRequestHost)w_(), (BluedConfig.b().n()).img).f().a(this.i); 
    } 
    this.j = (TextView)this.d.findViewById(2131301393);
    this.j.setText((BluedConfig.b().n()).text);
    this.h.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131297729) {
      if (i != 2131300601)
        return; 
      WebViewShowInfoFragment.show(this.g, this.l, 0);
      EventTrackSuperExpose.a(SuperExposeProtos.Event.AFTER_PUBLISH_PAGE_SUPER_EXPOSE_BUY);
      getActivity().finish();
      return;
    } 
    getActivity().finish();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.g = (Context)getActivity();
    this.f = LayoutInflater.from(this.g);
    if (this.d == null) {
      this.d = paramLayoutInflater.inflate(2131492992, paramViewGroup, false);
      a();
      k();
      StatusBarHelper.a((Activity)getActivity(), false);
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\FeedPromotionTipDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */