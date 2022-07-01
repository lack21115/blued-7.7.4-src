package com.soft.blued.ui.feed.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.fragment.SuperTopicDetailFragment;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.utils.click.SingleClickProxy;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;

public class MyTopicAdapter extends SuperTopicAdapter {
  public Context a;
  
  public MY_TOPIC_PAGE b;
  
  public IRequestHost c;
  
  public Dialog d;
  
  public MyTopicAdapter(Context paramContext, MY_TOPIC_PAGE paramMY_TOPIC_PAGE, IRequestHost paramIRequestHost) {
    super(paramContext, paramIRequestHost, 2131493596);
    this.a = paramContext;
    this.b = paramMY_TOPIC_PAGE;
    this.c = paramIRequestHost;
    this.d = DialogUtils.a(this.a);
  }
  
  public void a(int paramInt, String paramString) {
    String str = this.a.getResources().getString(2131756176);
    FragmentActivity fragmentActivity = (FragmentActivity)this.a;
    ActionSheet.ActionSheetListener actionSheetListener = new ActionSheet.ActionSheetListener(this, paramInt, paramString) {
        public void a(ActionSheet param1ActionSheet, int param1Int) {
          if (TextUtils.equals(param1ActionSheet.a(param1Int), this.c.a.getResources().getString(2131756176)))
            this.c.b(this.a, this.b); 
        }
        
        public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
      };
    CommonShowBottomWindow.a(fragmentActivity, new String[] { str }, actionSheetListener);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedTopic paramBluedTopic) {
    super.a(paramBaseViewHolder, paramBluedTopic);
    TextView textView = (TextView)paramBaseViewHolder.d(2131301356);
    View view = paramBaseViewHolder.d(2131298026);
    textView.setVisibility(0);
    if (paramBluedTopic.is_audited == 1) {
      view.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this, paramBluedTopic) {
              public void onClick(View param1View) {
                if (this.b.b == MyTopicAdapter.MY_TOPIC_PAGE.b) {
                  EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_DETAIL_SHOW, FeedProtos.DetailFrom.SUPER_TOPIC_JOIN);
                } else if (this.b.b == MyTopicAdapter.MY_TOPIC_PAGE.a) {
                  EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_DETAIL_SHOW, FeedProtos.DetailFrom.SUPER_TOPIC_CREATE);
                } 
                SuperTopicDetailFragment.a(this.b.a, this.a.super_did);
              }
            }));
      if (this.b == MY_TOPIC_PAGE.b) {
        view.setOnLongClickListener(new View.OnLongClickListener(this, paramBaseViewHolder, paramBluedTopic) {
              public boolean onLongClick(View param1View) {
                this.c.a(this.a.getAdapterPosition(), this.b.super_did);
                return true;
              }
            });
      } else {
        view.setOnLongClickListener(null);
      } 
      if (!TextUtils.isEmpty(paramBluedTopic.ranking)) {
        if ("en".equals(BlueAppLocal.c().getLanguage())) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("NO.");
          stringBuilder.append(paramBluedTopic.ranking);
          textView.setText(stringBuilder.toString());
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramBluedTopic.ranking);
          stringBuilder.append("名");
          textView.setText(stringBuilder.toString());
        } 
        textView.setTextColor(this.a.getResources().getColor(2131100838));
      } else {
        textView.setVisibility(8);
      } 
    } else {
      view.setOnClickListener(null);
      view.setOnLongClickListener(null);
      textView.setText(2131759099);
      textView.setTextColor(this.a.getResources().getColor(2131100716));
    } 
    if (this.b == MY_TOPIC_PAGE.b) {
      textView.setVisibility(8);
      return;
    } 
    if (this.b == MY_TOPIC_PAGE.a)
      textView.setVisibility(0); 
  }
  
  public void b(int paramInt, String paramString) {
    Context context = this.a;
    CommonAlertDialog.a(context, "", context.getResources().getString(2131756394), this.a.getResources().getString(2131756086), new DialogInterface.OnClickListener(this, paramInt, paramString) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            FeedHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<UserBasicModel>>(this, this.c.c) {
                  protected void a(BluedEntityA<UserBasicModel> param2BluedEntityA) {
                    if (this.a.a >= 0) {
                      this.a.c.d(this.a.a);
                      this.a.c.notifyDataSetChanged();
                    } 
                  }
                  
                  public void onUIFinish() {
                    super.onUIFinish();
                    DialogUtils.b(this.a.c.d);
                  }
                  
                  public void onUIStart() {
                    super.onUIStart();
                    DialogUtils.a(this.a.c.d);
                  }
                }this.b, this.c.c);
          }
        }null, null, null);
  }
  
  public enum MY_TOPIC_PAGE {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\MyTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */