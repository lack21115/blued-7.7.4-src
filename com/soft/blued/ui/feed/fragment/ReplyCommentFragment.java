package com.soft.blued.ui.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.fragment.CommonWriteTextFragment;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.notify.model.FeedNotice;
import com.soft.blued.utils.StringUtils;

public class ReplyCommentFragment extends CommonWriteTextFragment {
  private static String n = "REPLY_ID";
  
  private static String o = "REPLY_UID";
  
  private static String p = "FID";
  
  private static String q = "FEED_ID";
  
  private static String r = "IS_ADS";
  
  private static String s = "AID";
  
  private static String t = "VID";
  
  private static String u = "IS_FEED";
  
  private static String v = "IS_ANONYMOUS";
  
  private String A;
  
  private String B;
  
  private boolean C;
  
  private boolean D;
  
  private int E;
  
  private Dialog F;
  
  private String w;
  
  private String x;
  
  private String y;
  
  private String z;
  
  public static void a(Context paramContext, FeedNotice paramFeedNotice) {
    Bundle bundle = new Bundle();
    bundle.putString("max_count", "256");
    bundle.putString("string_edit_hint", paramContext.getResources().getString(2131759362));
    bundle.putString("string_edit", "");
    bundle.putString("string_center", paramContext.getResources().getString(2131758581));
    bundle.putString("string_right", paramContext.getResources().getString(2131758680));
    bundle.putInt("REQUEST_CODE_KEY", 3);
    bundle.putString(n, paramFeedNotice.comment_id);
    bundle.putString(q, paramFeedNotice.feed_id);
    bundle.putInt(r, paramFeedNotice.is_ads);
    bundle.putString(s, paramFeedNotice.aid);
    String str = u;
    int i = paramFeedNotice.from;
    boolean bool2 = false;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    bundle.putBoolean(str, bool1);
    str = v;
    boolean bool1 = bool2;
    if (paramFeedNotice.must_anonym_reply == 1)
      bool1 = true; 
    bundle.putBoolean(str, bool1);
    TerminalActivity.d(paramContext, ReplyCommentFragment.class, bundle);
  }
  
  public void a() {
    this.m.setCenterText(getString(2131758581));
    this.m.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.a(0);
          }
        });
    this.m.setRightText(2131758680);
    this.m.setRightTextColor(2131100541);
    this.m.setRightClickListener(null);
    if (getArguments() != null) {
      this.w = getArguments().getString(n);
      this.x = getArguments().getString(o);
      this.y = getArguments().getString(p);
      this.z = getArguments().getString(q);
      this.E = getArguments().getInt(r);
      this.A = getArguments().getString(s);
      this.B = getArguments().getString(t);
      this.C = getArguments().getBoolean(u);
      this.D = getArguments().getBoolean(v);
    } 
    a((TextWatcher)null);
  }
  
  public void a(TextWatcher paramTextWatcher) {
    super.a(new TextWatcher(this, paramTextWatcher) {
          public void afterTextChanged(Editable param1Editable) {
            TextWatcher textWatcher = this.a;
            if (textWatcher != null)
              textWatcher.afterTextChanged(param1Editable); 
            if (StringUtils.e(param1Editable.toString())) {
              this.b.m.setRightTextColor(2131100555);
              this.b.m.setRightClickListener(null);
              return;
            } 
            this.b.m.setRightTextColor(2131100527);
            this.b.m.setRightClickListener(new View.OnClickListener(this) {
                  public void onClick(View param2View) {
                    if (ReplyCommentFragment.a(this.a.b).length() > ReplyCommentFragment.b(this.a.b)) {
                      AppMethods.a(String.format(this.a.b.d.getResources().getString(2131757864), new Object[] { Integer.valueOf(ReplyCommentFragment.c(this.a.b)) }));
                      return;
                    } 
                    this.a.b.a(-1);
                  }
                });
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
            TextWatcher textWatcher = this.a;
            if (textWatcher != null)
              textWatcher.beforeTextChanged(param1CharSequence, param1Int1, param1Int2, param1Int3); 
          }
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
            TextWatcher textWatcher = this.a;
            if (textWatcher != null)
              textWatcher.onTextChanged(param1CharSequence, param1Int1, param1Int2, param1Int3); 
          }
        });
  }
  
  public boolean a(int paramInt, String paramString) {
    if (paramInt == -1 && !TextUtils.isEmpty(paramString) && w_() != null && w_().isActive()) {
      if (this.F == null)
        this.F = DialogUtils.a((Context)getActivity()); 
      FeedComment feedComment = new FeedComment();
      feedComment.comment_id = this.w;
      feedComment.is_ads = this.E;
      feedComment.aid = this.A;
      BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
      bluedIngSelfFeed.feed_id = this.z;
      BluedUIHttpResponse bluedUIHttpResponse = new BluedUIHttpResponse(this, (IRequestHost)w_()) {
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(ReplyCommentFragment.d(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ReplyCommentFragment.d(this.a));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            AppMethods.d(2131756206);
            this.a.getActivity().finish();
          }
        };
      if (this.C) {
        FeedHttpUtils.a(bluedUIHttpResponse, bluedIngSelfFeed, feedComment, paramString, (IRequestHost)w_());
      } else {
        CircleHttpUtils.a(bluedUIHttpResponse, bluedIngSelfFeed, feedComment, paramString, this.D, -1, (IRequestHost)w_());
      } 
      return false;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\ReplyCommentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */