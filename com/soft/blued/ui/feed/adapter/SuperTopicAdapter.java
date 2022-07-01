package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.manager.FeedMethods;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.utils.AreaUtils;

public class SuperTopicAdapter extends BaseQuickAdapter<BluedTopic, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  private int c;
  
  private String d;
  
  private boolean e;
  
  private OnShowListener f;
  
  public SuperTopicAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493656, null);
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = (paramContext.getResources().getDisplayMetrics()).widthPixels;
  }
  
  public SuperTopicAdapter(Context paramContext, IRequestHost paramIRequestHost, int paramInt) {
    super(paramInt, null);
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = (paramContext.getResources().getDisplayMetrics()).widthPixels;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedTopic paramBluedTopic) {
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131301443);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131301508);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131301035);
    View view1 = paramBaseViewHolder.d(2131298080);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297874);
    View view2 = paramBaseViewHolder.d(2131298081);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131301106);
    if (!paramBluedTopic.isShowUrlVisited) {
      OnShowListener onShowListener = this.f;
      if (onShowListener != null)
        onShowListener.a(paramBluedTopic.super_did); 
      InstantLog.h("topic_list_item_show", paramBluedTopic.super_did);
      paramBluedTopic.isShowUrlVisited = true;
    } 
    IRequestHost iRequestHost = this.b;
    String str2 = paramBluedTopic.avatar;
    int i = 0;
    ImageLoader.a(iRequestHost, AvatarUtils.a(0, str2)).a(2131234240).a(imageView1);
    int j = paramBaseViewHolder.getAdapterPosition() - o() + 1;
    if (this.e && j >= 1 && j <= 15) {
      if (j != 1) {
        if (j != 2) {
          if (j != 3) {
            view1.setVisibility(8);
            view2.setVisibility(0);
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("NO.");
            stringBuilder1.append(j);
            textView4.setText(stringBuilder1.toString());
          } else {
            view1.setVisibility(0);
            view2.setVisibility(8);
            imageView2.setImageResource(2131234214);
          } 
        } else {
          view1.setVisibility(0);
          view2.setVisibility(8);
          imageView2.setImageResource(2131234213);
        } 
      } else {
        view1.setVisibility(0);
        view2.setVisibility(8);
        imageView2.setImageResource(2131234212);
      } 
    } else {
      view1.setVisibility(8);
      view2.setVisibility(8);
    } 
    if (!TextUtils.isEmpty(paramBluedTopic.name)) {
      textView3.setText((CharSequence)FeedMethods.a(paramBluedTopic, paramBluedTopic.name));
    } else {
      textView3.setText("");
    } 
    String str1 = paramBluedTopic.name;
    if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(this.d) && str1.contains(this.d)) {
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str1);
      while (i < str1.length()) {
        j = str1.indexOf(this.d, i);
        if (j >= 0) {
          spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.a, 2131100527)), j, this.d.length() + j, 33);
          i = Math.max(i + 1, j);
        } 
      } 
      textView3.setText((CharSequence)FeedMethods.a(paramBluedTopic, (CharSequence)spannableStringBuilder));
    } 
    boolean bool = TextUtils.isEmpty(paramBluedTopic.visited_total);
    long l2 = 0L;
    if (!bool) {
      l1 = Long.parseLong(paramBluedTopic.visited_total);
    } else {
      l1 = 0L;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(AreaUtils.a(this.a, Long.valueOf(l1)));
    stringBuilder.append(this.a.getResources().getString(2131756042));
    textView2.setText(stringBuilder.toString());
    long l1 = l2;
    if (!TextUtils.isEmpty(paramBluedTopic.join_total))
      l1 = Long.parseLong(paramBluedTopic.join_total); 
    stringBuilder = new StringBuilder();
    stringBuilder.append(AreaUtils.a(this.a, Long.valueOf(l1)));
    stringBuilder.append(this.a.getResources().getString(2131758339));
    textView1.setText(stringBuilder.toString());
  }
  
  public void a(OnShowListener paramOnShowListener) {
    this.f = paramOnShowListener;
  }
  
  public void a(String paramString) {
    this.d = paramString;
  }
  
  public void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public static interface OnShowListener {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\SuperTopicAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */