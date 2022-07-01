package com.soft.blued.ui.video.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.database.DataSetObserver;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.fragment.HotCommentsFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.observer.CommentListDataObserver;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.user.fragment.ReportFragmentNew;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoCommentAdapter extends BaseAdapter implements CommentListDataObserver.ICommentDataObserver {
  LoadOptions a;
  
  private Context b;
  
  private LayoutInflater c;
  
  private List<FeedComment> d = new ArrayList<FeedComment>();
  
  private int e;
  
  private IRequestHost f;
  
  private BluedIngSelfFeed g;
  
  private FeedCommentListner h;
  
  private boolean i = true;
  
  private boolean j = true;
  
  private String k = "shine_video_detail";
  
  public VideoCommentAdapter(Context paramContext, IRequestHost paramIRequestHost, BluedIngSelfFeed paramBluedIngSelfFeed, FeedCommentListner paramFeedCommentListner, boolean paramBoolean) {
    this.b = paramContext;
    this.h = paramFeedCommentListner;
    this.g = paramBluedIngSelfFeed;
    this.f = paramIRequestHost;
    this.i = paramBoolean;
    this.a = new LoadOptions();
    LoadOptions loadOptions = this.a;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    int i = this.e;
    loadOptions.a(i >> 1, i >> 1);
    this.c = LayoutInflater.from(paramContext);
    this.e = (paramContext.getResources().getDisplayMetrics()).widthPixels;
  }
  
  private void a(View paramView, FeedComment paramFeedComment) {
    if (paramFeedComment != null)
      paramView.setOnLongClickListener(new View.OnLongClickListener(this, paramFeedComment) {
            public boolean onLongClick(View param1View) {
              ArrayList<String> arrayList = new ArrayList();
              arrayList.add(VideoCommentAdapter.a(this.b).getResources().getString(2131758501));
              if (!this.a.comment_uid.equals(UserInfo.a().i().getUid()))
                arrayList.add(VideoCommentAdapter.a(this.b).getResources().getString(2131758584)); 
              if ("1".equals(this.a.comment_allow_delete))
                arrayList.add(VideoCommentAdapter.a(this.b).getResources().getString(2131756176)); 
              CommonShowBottomWindow.a((FragmentActivity)VideoCommentAdapter.a(this.b), arrayList.<String>toArray(new String[arrayList.size()]), new ActionSheet.ActionSheetListener(this) {
                    public void a(ActionSheet param2ActionSheet, int param2Int) {
                      String str = param2ActionSheet.a(param2Int);
                      if (str.equals(VideoCommentAdapter.a(this.a.b).getResources().getString(2131758501))) {
                        this.a.b.a(this.a.a);
                        return;
                      } 
                      if (str.equals(VideoCommentAdapter.a(this.a.b).getResources().getString(2131756176))) {
                        this.a.b.b(this.a.a);
                        return;
                      } 
                      if (str.equals(VideoCommentAdapter.a(this.a.b).getResources().getString(2131758584)))
                        ReportFragmentNew.a(VideoCommentAdapter.a(this.a.b), this.a.a.comment_id, this.a.a.feed_id, this.a.a.user_name); 
                    }
                    
                    public void a(ActionSheet param2ActionSheet, boolean param2Boolean) {}
                  });
              return true;
            }
          }); 
  }
  
  private void a(TextView paramTextView, FeedComment paramFeedComment) {
    String str2 = paramFeedComment.reply_name;
    String str4 = paramFeedComment.comment_content;
    String str3 = paramFeedComment.reply_uid;
    String str1 = paramFeedComment.reply_avatar;
    String str5 = this.b.getResources().getString(2131758580);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str5);
    stringBuilder.append(str2);
    stringBuilder.append(": ");
    stringBuilder.append(str4);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
    spannableStringBuilder.setSpan(new RevoClickSpan(this, this.b, spannableStringBuilder.toString().substring(spannableStringBuilder.toString().indexOf(str5) + str5.length(), spannableStringBuilder.toString().indexOf(":")), str3, str2, str1), spannableStringBuilder.toString().indexOf(str5) + str5.length(), spannableStringBuilder.toString().indexOf(":"), 17);
    TypefaceUtils.a(paramTextView, (CharSequence)spannableStringBuilder, 1, "");
  }
  
  private void b(TextView paramTextView, FeedComment paramFeedComment) {
    TypefaceUtils.a(paramTextView, paramFeedComment.comment_content, 1, "");
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.j = true;
    this.g = paramBluedIngSelfFeed;
    this.d.clear();
    notifyDataSetChanged();
  }
  
  public void a(FeedComment paramFeedComment) {
    String str = paramFeedComment.comment_content;
    if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
      ((ClipboardManager)this.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
    } else {
      ((ClipboardManager)this.b.getSystemService("clipboard")).setText(RegExpUtils.a(str));
    } 
    AppMethods.a(this.b.getResources().getString(2131756130));
  }
  
  public void a(FeedComment paramFeedComment, ImageView paramImageView, TextView paramTextView) {
    boolean bool;
    InstantLog.a("shine_video_comment_like_btn_click");
    String str1 = paramFeedComment.comment_id;
    String str2 = paramFeedComment.feed_id;
    if (paramFeedComment.iliked == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    CommentListDataObserver.a().a(str1, bool);
    FeedHttpUtils.a(str2, str1, bool, null, this.f, true);
  }
  
  public void a(FeedComment paramFeedComment, String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 101
    //   4: aload_0
    //   5: getfield i : Z
    //   8: ifeq -> 101
    //   11: aload_1
    //   12: aload_1
    //   13: getfield user_vbadge : I
    //   16: putfield vbadge : I
    //   19: iconst_0
    //   20: istore_3
    //   21: iload_3
    //   22: aload_0
    //   23: getfield d : Ljava/util/List;
    //   26: invokeinterface size : ()I
    //   31: if_icmpge -> 63
    //   34: aload_0
    //   35: getfield d : Ljava/util/List;
    //   38: iload_3
    //   39: invokeinterface get : (I)Ljava/lang/Object;
    //   44: checkcast com/soft/blued/ui/feed/model/FeedComment
    //   47: getfield isLastHotComment : Z
    //   50: ifeq -> 56
    //   53: goto -> 65
    //   56: iload_3
    //   57: iconst_1
    //   58: iadd
    //   59: istore_3
    //   60: goto -> 21
    //   63: iconst_m1
    //   64: istore_3
    //   65: iload_3
    //   66: iconst_m1
    //   67: if_icmpne -> 84
    //   70: aload_0
    //   71: getfield d : Ljava/util/List;
    //   74: iconst_0
    //   75: aload_1
    //   76: invokeinterface add : (ILjava/lang/Object;)V
    //   81: goto -> 97
    //   84: aload_0
    //   85: getfield d : Ljava/util/List;
    //   88: iload_3
    //   89: iconst_1
    //   90: iadd
    //   91: aload_1
    //   92: invokeinterface add : (ILjava/lang/Object;)V
    //   97: aload_0
    //   98: invokevirtual notifyDataSetChanged : ()V
    //   101: return
  }
  
  public void a(String paramString) {
    if (!StringUtils.e(paramString)) {
      List<FeedComment> list = this.d;
      if (list != null && list.size() > 0) {
        for (int i = 0; i < this.d.size(); i++) {
          if (paramString.equals(((FeedComment)this.d.get(i)).comment_id) && ((FeedComment)this.d.get(i)).isLastHotComment) {
            int j = i - 1;
            if (j >= 0) {
              ((FeedComment)this.d.get(j)).isLastHotComment = ((FeedComment)this.d.get(i)).isLastHotComment;
              ((FeedComment)this.d.get(j)).isHasMoreHotComment = ((FeedComment)this.d.get(i)).isHasMoreHotComment;
              break;
            } 
          } 
        } 
        Iterator<FeedComment> iterator = this.d.iterator();
        while (iterator.hasNext()) {
          if (paramString.equals(((FeedComment)iterator.next()).comment_id))
            iterator.remove(); 
        } 
        notifyDataSetChanged();
      } 
    } 
  }
  
  public void a(String paramString, int paramInt) {
    if (!StringUtils.e(paramString)) {
      List<FeedComment> list = this.d;
      if (list != null && list.size() > 0) {
        for (int i = 0; i < this.d.size(); i++) {
          if (paramString.equals(((FeedComment)this.d.get(i)).comment_id)) {
            ((FeedComment)this.d.get(i)).iliked = paramInt;
            if (paramInt == 1) {
              FeedComment feedComment = this.d.get(i);
              feedComment.liked_count++;
            } else {
              FeedComment feedComment = this.d.get(i);
              feedComment.liked_count--;
            } 
          } 
        } 
        notifyDataSetChanged();
      } 
    } 
  }
  
  public void a(List<FeedComment> paramList) {
    this.d.clear();
    if (paramList != null && paramList.size() > 0)
      this.d.addAll(paramList); 
    notifyDataSetChanged();
  }
  
  public boolean a() {
    return this.j;
  }
  
  public void b() {
    this.j = false;
  }
  
  public void b(FeedComment paramFeedComment) {
    String str = this.b.getString(2131756931);
    CharSequence charSequence = StringUtils.a(paramFeedComment.comment_content, false, true, false, "");
    if (charSequence.length() > 14) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(charSequence.subSequence(0, 14));
      stringBuilder.append("...");
      charSequence = stringBuilder.toString();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(charSequence);
      stringBuilder.append("");
      charSequence = stringBuilder.toString();
    } 
    charSequence = String.format(this.b.getResources().getString(2131756179), new Object[] { charSequence });
    Context context = this.b;
    CommonAlertDialog.a(context, str, (String)charSequence, context.getResources().getString(2131756176), new DialogInterface.OnClickListener(this, paramFeedComment) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            String str1 = this.a.feed_id;
            String str2 = this.a.comment_id;
            FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this) {
                  protected BluedEntityA<Object> a(String param2String) {
                    return (BluedEntityA<Object>)super.parseData(param2String);
                  }
                  
                  public void a(BluedEntityA<Object> param2BluedEntityA) {
                    CommentListDataObserver.a().a(this.a.a.comment_id);
                    LiveEventBus.get("feed_delete_comment").post(this.a.a);
                    AppMethods.a(AppInfo.d().getResources().getString(2131756175));
                  }
                  
                  public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
                    AppMethods.a(AppInfo.d().getResources().getString(2131756082));
                    super.onFailure(param2Throwable, param2Int, param2String);
                  }
                }true, str1, str2, (VideoCommentAdapter.b(this.b)).is_ads, VideoCommentAdapter.e(this.b));
          }
        }null, null, null);
  }
  
  public void b(List<FeedComment> paramList) {
    if (paramList != null && paramList.size() > 0) {
      Logger.b("VideoCommentAdapter", new Object[] { "addFeedItems:", Integer.valueOf(paramList.size()) });
      this.d.addAll(paramList);
      notifyDataSetChanged();
    } 
  }
  
  public int getCount() {
    return this.d.size();
  }
  
  public Object getItem(int paramInt) {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.c.inflate(2131494118, paramViewGroup, false);
      viewHolder1.a = (ImageView)view.findViewById(2131297362);
      viewHolder1.d = (TextView)view.findViewById(2131296838);
      viewHolder1.c = (TextView)view.findViewById(2131299358);
      viewHolder1.b = (TextView)view.findViewById(2131300267);
      viewHolder1.e = (ImageView)view.findViewById(2131297575);
      viewHolder1.g = (ImageView)view.findViewById(2131297461);
      viewHolder1.f = view.findViewById(2131298011);
      viewHolder1.h = (TextView)view.findViewById(2131300653);
      viewHolder1.i = (TextView)view.findViewById(2131300584);
      viewHolder1.j = (LinearLayout)view.findViewById(2131298958);
      viewHolder1.k = (TextView)view.findViewById(2131301052);
      viewHolder1.l = (ImageView)view.findViewById(2131297429);
      viewHolder1.m = (ImageView)view.findViewById(2131297581);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    FeedComment feedComment = this.d.get(paramInt);
    if (feedComment.iliked == 1) {
      viewHolder1.g.setImageResource(2131234148);
      viewHolder1.h.setTextColor(this.b.getResources().getColor(2131100963));
    } else {
      viewHolder1.g.setImageResource(2131234149);
      viewHolder1.h.setTextColor(this.b.getResources().getColor(2131100967));
    } 
    if (feedComment.liked_count > 0) {
      TextView textView1 = viewHolder1.h;
      Context context = this.b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(feedComment.liked_count);
      stringBuilder.append("");
      textView1.setText(AreaUtils.a(context, stringBuilder.toString()));
    } else {
      viewHolder1.h.setText(AreaUtils.a(this.b, "0"));
    } 
    ImageView imageView = viewHolder1.g;
    TextView textView = viewHolder1.h;
    viewHolder1.f.setOnClickListener(new View.OnClickListener(this, feedComment, imageView, textView) {
          public void onClick(View param1View) {
            this.d.a(this.a, this.b, this.c);
          }
        });
    if (feedComment.isLastHotComment) {
      viewHolder1.i.setVisibility(8);
      viewHolder1.j.setVisibility(0);
      if (feedComment.isHasMoreHotComment) {
        viewHolder1.l.setVisibility(0);
        viewHolder1.k.setText(this.b.getResources().getString(2131757933));
        viewHolder1.j.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                HotCommentsFragment.a(VideoCommentAdapter.a(this.a), VideoCommentAdapter.b(this.a));
              }
            });
      } else {
        viewHolder1.k.setText(this.b.getResources().getString(2131755214));
        viewHolder1.l.setVisibility(8);
        viewHolder1.j.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {}
            });
      } 
    } else {
      viewHolder1.j.setVisibility(8);
      viewHolder1.i.setVisibility(0);
    } 
    UserRelationshipUtils.a(viewHolder1.e, feedComment.vbadge, 3);
    ImageLoader.a(this.f, AvatarUtils.a(1, feedComment.user_avatar)).a(2131234356).c().a(viewHolder1.a);
    if (!TextUtils.isEmpty(feedComment.comment_timestamp)) {
      viewHolder1.b.setText(TimeAndDateUtils.i(this.b, TimeAndDateUtils.b(feedComment.comment_timestamp)));
    } else {
      viewHolder1.b.setText("");
    } 
    if (!StringUtils.e(feedComment.user_name)) {
      if (!StringUtils.e(feedComment.note)) {
        viewHolder1.c.setText(StringUtils.a(feedComment.note, feedComment.user_name.replace(":", "")));
      } else {
        viewHolder1.c.setText(feedComment.user_name.replace(":", ""));
      } 
    } else {
      viewHolder1.c.setText("");
    } 
    UserRelationshipUtils.a(this.b, viewHolder1.c, (UserBasicModel)feedComment, 2131100809);
    UserRelationshipUtils.a(viewHolder1.m, (UserBasicModel)feedComment);
    if (!StringUtils.e(feedComment.is_reply)) {
      if ("1".equals(feedComment.is_reply)) {
        a(viewHolder1.d, feedComment);
      } else if ("0".equals(feedComment.is_reply)) {
        b(viewHolder1.d, feedComment);
      } else {
        viewHolder1.d.setText("");
      } 
    } else {
      viewHolder1.d.setText("");
    } 
    imageView = viewHolder1.a;
    viewHolder1.c.setOnClickListener(new View.OnClickListener(this, feedComment, imageView) {
          public void onClick(View param1View) {
            if (!this.a.comment_uid.equals(UserInfo.a().i().getUid())) {
              UserBasicModel userBasicModel = new UserBasicModel();
              userBasicModel.name = this.a.user_name;
              userBasicModel.uid = this.a.comment_uid;
              userBasicModel.avatar = this.a.user_avatar;
              UserInfoFragmentNew.a(VideoCommentAdapter.a(this.c), userBasicModel, VideoCommentAdapter.c(this.c), (View)this.b);
            } 
          }
        });
    viewHolder1.a.setOnClickListener(new View.OnClickListener(this, feedComment, imageView) {
          public void onClick(View param1View) {
            if (!this.a.comment_uid.equals(UserInfo.a().i().getUid())) {
              UserBasicModel userBasicModel = new UserBasicModel();
              userBasicModel.name = this.a.user_name;
              userBasicModel.uid = this.a.comment_uid;
              userBasicModel.avatar = this.a.user_avatar;
              UserInfoFragmentNew.a(VideoCommentAdapter.a(this.c), userBasicModel, VideoCommentAdapter.c(this.c), (View)this.b);
            } 
          }
        });
    a((View)viewHolder2, feedComment);
    viewHolder2.setOnClickListener(new View.OnClickListener(this, feedComment) {
          public void onClick(View param1View) {
            if (!PopMenuUtils.a(VideoCommentAdapter.a(this.b)))
              VideoCommentAdapter.d(this.b).a(this.a); 
          }
        });
    return (View)viewHolder2;
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {
    super.registerDataSetObserver(paramDataSetObserver);
    CommentListDataObserver.a().a(this);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {
    super.unregisterDataSetObserver(paramDataSetObserver);
    CommentListDataObserver.a().b(this);
  }
  
  public static interface FeedCommentListner {
    void a(FeedComment param1FeedComment);
  }
  
  static interface LIKED {}
  
  public class RevoClickSpan extends ClickableSpan {
    Context a;
    
    String b;
    
    String c;
    
    String d;
    
    String e;
    
    public RevoClickSpan(VideoCommentAdapter this$0, Context param1Context, String param1String1, String param1String2, String param1String3, String param1String4) {
      this.a = param1Context;
      this.b = param1String1;
      this.c = param1String2;
      this.d = param1String3;
      this.e = param1String4;
    }
    
    public void onClick(View param1View) {
      Selection.removeSelection((Spannable)((TextView)param1View).getText());
      if (!StringUtils.e(this.c)) {
        UserInfoFragmentNew.a(this.a, this.c, "");
        return;
      } 
      UserInfoFragmentNew.c(this.a, this.d, "");
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      param1TextPaint.setColor(this.a.getResources().getColor(2131100556));
      param1TextPaint.setUnderlineText(false);
    }
  }
  
  class ViewHolder {
    public ImageView a;
    
    public TextView b;
    
    public TextView c;
    
    public TextView d;
    
    public ImageView e;
    
    public View f;
    
    public ImageView g;
    
    public TextView h;
    
    public TextView i;
    
    public LinearLayout j;
    
    public TextView k;
    
    public ImageView l;
    
    public ImageView m;
    
    private ViewHolder(VideoCommentAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\adapter\VideoCommentAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */