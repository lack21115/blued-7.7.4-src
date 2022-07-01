package com.soft.blued.ui.notify.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.fragment.CirclePostDetailsFragment;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.feed.fragment.FeedDetailsFragment;
import com.soft.blued.ui.feed.fragment.ReplyCommentFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.notify.model.FeedNotice;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class SystemNoticeAdapter extends BaseMultiItemQuickAdapter<FeedNotice, BaseViewHolder> {
  private boolean a;
  
  private int b = 0;
  
  private IRequestHost c;
  
  private FragmentManager d;
  
  private Context e;
  
  private OnReadListener f;
  
  public SystemNoticeAdapter(Context paramContext, IRequestHost paramIRequestHost, FragmentManager paramFragmentManager, boolean paramBoolean) {
    super(null);
    this.a = paramBoolean;
    this.c = paramIRequestHost;
    this.d = paramFragmentManager;
    this.e = paramContext;
    b(0, 2131493657);
    b(1, 2131493657);
  }
  
  private void a(ImageView paramImageView, FeedNotice paramFeedNotice) {
    ImageLoader.a(this.c, paramFeedNotice.avatar).a(2131234356).c().a(paramImageView);
    paramImageView.setOnClickListener(new View.OnClickListener(this, paramFeedNotice, paramImageView) {
          public void onClick(View param1View) {
            if (this.a.is_anonym == 1) {
              AppMethods.d(2131755842);
              return;
            } 
            this.a.has_read = 1;
            if (SystemNoticeAdapter.b(this.c) != null)
              SystemNoticeAdapter.b(this.c).a(); 
            this.c.notifyDataSetChanged();
            UserInfoFragmentNew.a(SystemNoticeAdapter.a(this.c), (UserBasicModel)this.a, "", (View)this.b);
          }
        });
  }
  
  private void a(TextView paramTextView, ImageView paramImageView1, ImageView paramImageView2, FeedNotice paramFeedNotice) {
    if (paramFeedNotice.feed_pics != null && paramFeedNotice.feed_pics.length > 0) {
      paramTextView.setVisibility(8);
      paramImageView2.setVisibility(0);
      paramImageView1.setVisibility(8);
      ImageLoader.a(this.c, paramFeedNotice.feed_pics[0]).a(2131231369).a(paramImageView2);
      return;
    } 
    if ("1".equals(paramFeedNotice.is_videos) && paramFeedNotice.feed_videos != null && paramFeedNotice.feed_videos.length > 0) {
      paramTextView.setVisibility(8);
      paramImageView2.setVisibility(0);
      paramImageView1.setVisibility(0);
      ImageLoader.a(this.c, paramFeedNotice.feed_videos[0]).a(2131231369).a(paramImageView2);
      return;
    } 
    paramTextView.setVisibility(0);
    paramImageView2.setVisibility(8);
    paramImageView1.setVisibility(8);
    if (!TextUtils.isEmpty(paramFeedNotice.feed_content)) {
      paramTextView.setText(StringUtils.a(StringUtils.a(paramFeedNotice.feed_content, (int)paramTextView.getTextSize(), 1), false, true, false, ""));
      return;
    } 
    paramTextView.setText("");
  }
  
  private void a(TextView paramTextView1, TextView paramTextView2, FeedNotice paramFeedNotice) {
    if (TextUtils.equals("0", paramFeedNotice.type) || TextUtils.equals("1", paramFeedNotice.type) || TextUtils.equals("6", paramFeedNotice.type) || TextUtils.equals("9", paramFeedNotice.type)) {
      paramTextView2.setVisibility(0);
      paramTextView1.setVisibility(8);
      if (paramFeedNotice.comment_deleted == 1) {
        paramTextView2.setTextColor(BluedSkinUtils.a(this.e, 2131100844));
        paramTextView2.setText(2131756046);
        return;
      } 
      paramTextView2.setTextColor(BluedSkinUtils.a(this.e, 2131100838));
      if (!TextUtils.isEmpty(paramFeedNotice.content)) {
        TypefaceUtils.a(paramTextView2, paramFeedNotice.content, 1, "");
        return;
      } 
      paramTextView2.setText("");
      return;
    } 
    paramTextView2.setVisibility(8);
    paramTextView1.setVisibility(0);
    if (paramFeedNotice.from == 1) {
      paramTextView1.setText(2131755884);
      return;
    } 
    if (paramFeedNotice.is_comments_liked == 1) {
      paramTextView1.setText(this.e.getResources().getString(2131757120));
      return;
    } 
    paramTextView1.setText(this.e.getResources().getString(2131757119));
  }
  
  private void a(TextView paramTextView, FeedNotice paramFeedNotice) {
    if (!TextUtils.isEmpty(paramFeedNotice.note)) {
      paramTextView.setText(paramFeedNotice.note);
    } else {
      paramTextView.setText(paramFeedNotice.name);
    } 
    UserRelationshipUtils.a(this.e, paramTextView, (UserBasicModel)paramFeedNotice);
  }
  
  private void b(TextView paramTextView, FeedNotice paramFeedNotice) {
    if (!TextUtils.isEmpty(paramFeedNotice.timestamp)) {
      paramTextView.setText(TimeAndDateUtils.a(this.e, TimeAndDateUtils.b(paramFeedNotice.timestamp)));
      return;
    } 
    paramTextView.setText("");
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, FeedNotice paramFeedNotice) {
    View view1 = paramBaseViewHolder.d(2131299753);
    if (paramFeedNotice.has_read == 0) {
      view1.setBackgroundColor(BluedSkinUtils.a(this.e, 2131100881));
    } else {
      view1.setBackgroundColor(BluedSkinUtils.a(this.e, 2131100728));
    } 
    paramBaseViewHolder.b(2131300760, false).b(2131300786, false);
    UserRelationshipUtils.a((ImageView)paramBaseViewHolder.d(2131297575), paramFeedNotice.vbadge, 3);
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
    ImageLoader.a(this.c, AvatarUtils.a(0, paramFeedNotice.avatar)).a(2131234356).c().a(imageView1);
    imageView1.setOnClickListener(new View.OnClickListener(this, paramFeedNotice, imageView1) {
          public void onClick(View param1View) {
            this.a.has_read = 1;
            this.c.notifyDataSetChanged();
            UserInfoFragmentNew.a(SystemNoticeAdapter.a(this.c), (UserBasicModel)this.a, "", (View)this.b);
          }
        });
    if (!TextUtils.isEmpty(paramFeedNotice.note)) {
      paramBaseViewHolder.a(2131299358, paramFeedNotice.note);
    } else {
      paramBaseViewHolder.a(2131299358, paramFeedNotice.name);
    } 
    UserRelationshipUtils.a(this.e, (TextView)paramBaseViewHolder.d(2131299358), (UserBasicModel)paramFeedNotice);
    UserRelationshipUtils.a((ImageView)paramBaseViewHolder.d(2131297581), (UserBasicModel)paramFeedNotice);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131299381);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131301789);
    textView1.setVisibility(0);
    textView2.setVisibility(8);
    String str = paramFeedNotice.type;
    byte b = -1;
    int i = str.hashCode();
    if (i != 55) {
      if (i != 56) {
        if (i == 1567 && str.equals("10"))
          b = 2; 
      } else if (str.equals("8")) {
        b = 1;
      } 
    } else if (str.equals("7")) {
      b = 0;
    } 
    if (b != 0) {
      if (b != 1) {
        if (b == 2)
          textView1.setText(2131755951); 
      } else {
        textView1.setText(this.e.getString(2131759323));
      } 
    } else {
      textView1.setText(this.e.getString(2131759322));
    } 
    textView1 = (TextView)paramBaseViewHolder.d(2131300267);
    if (!TextUtils.isEmpty(paramFeedNotice.timestamp)) {
      textView1.setText(TimeAndDateUtils.a(this.e, TimeAndDateUtils.b(paramFeedNotice.timestamp)));
    } else {
      textView1.setText("");
    } 
    textView1 = (TextView)paramBaseViewHolder.d(2131296838);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131299472);
    if (paramFeedNotice.feed_pics != null && paramFeedNotice.feed_pics.length > 0) {
      textView1.setVisibility(8);
      imageView2.setVisibility(0);
      ImageLoader.a(this.c, paramFeedNotice.feed_pics[0]).c(2131231369).a(2131231369).a(imageView2);
    } else {
      textView1.setVisibility(0);
      imageView2.setVisibility(8);
      if (!TextUtils.isEmpty(paramFeedNotice.feed_content)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtils.a(paramFeedNotice.feed_content, false, true, false, ""));
        stringBuilder.append("");
        textView1.setText(stringBuilder.toString());
      } else {
        textView1.setText("");
      } 
    } 
    View view2 = paramBaseViewHolder.d(2131298758);
    view2.setOnClickListener(new View.OnClickListener(this, paramFeedNotice) {
          public void onClick(View param1View) {
            this.a.has_read = 1;
            this.b.notifyDataSetChanged();
            BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
            bluedIngSelfFeed.feed_id = this.a.feed_id;
            bluedIngSelfFeed.aid = this.a.aid;
            bluedIngSelfFeed.is_ads = this.a.is_ads;
            bluedIngSelfFeed.is_vote = 1;
            if ("10".equals(this.a.type)) {
              CirclePostDetailsFragment.a(SystemNoticeAdapter.a(this.b), this.a.feed_id, FeedProtos.NoteSource.UNKNOWN_NOTE_SOURCE);
              return;
            } 
            FeedDetailsFragment.a(SystemNoticeAdapter.a(this.b), bluedIngSelfFeed, -1, 0);
          }
        });
    view1.setOnClickListener(new View.OnClickListener(this, paramFeedNotice, view2) {
          public void onClick(View param1View) {
            this.a.has_read = 1;
            this.c.notifyDataSetChanged();
            this.b.callOnClick();
          }
        });
    paramBaseViewHolder.d(2131300760).setOnClickListener(new View.OnClickListener(this, paramFeedNotice) {
          public void onClick(View param1View) {
            this.a.has_read = 1;
            this.b.notifyDataSetChanged();
            ReplyCommentFragment.a(SystemNoticeAdapter.a(this.b), this.a);
          }
        });
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, FeedNotice paramFeedNotice) {
    int i;
    NoticeHolder noticeHolder = new NoticeHolder(paramBaseViewHolder.z());
    if (this.a) {
      noticeHolder.l.setVisibility(0);
    } else {
      noticeHolder.l.setVisibility(8);
    } 
    View view = NoticeHolder.a(noticeHolder);
    Context context = this.e;
    if (paramFeedNotice.has_read == 0) {
      i = 2131100881;
    } else {
      i = 2131100728;
    } 
    view.setBackgroundColor(BluedSkinUtils.a(context, i));
    a(noticeHolder.e, paramFeedNotice);
    a(noticeHolder.a, paramFeedNotice);
    UserRelationshipUtils.a(noticeHolder.i, paramFeedNotice.vbadge, 3);
    UserRelationshipUtils.a(noticeHolder.m, (UserBasicModel)paramFeedNotice);
    ImageView imageView = noticeHolder.n;
    if (paramFeedNotice.is_anonym == 1) {
      i = 0;
    } else {
      i = 8;
    } 
    imageView.setVisibility(i);
    a(noticeHolder.g, noticeHolder.f, paramFeedNotice);
    b(noticeHolder.d, paramFeedNotice);
    a(noticeHolder.h, noticeHolder.c, noticeHolder.b, paramFeedNotice);
    noticeHolder.h.setTextColor(BluedSkinUtils.a(this.e, 2131100838));
    noticeHolder.b.setOnClickListener(new View.OnClickListener(this, noticeHolder) {
          public void onClick(View param1View) {
            this.a.j.callOnClick();
          }
        });
    if (paramFeedNotice.from_top == 1) {
      noticeHolder.l.setText(2131755962);
    } else {
      noticeHolder.l.setText(2131758286);
    } 
    if (paramFeedNotice.from == 1) {
      noticeHolder.k.setText(2131756571);
    } else {
      noticeHolder.k.setText(2131756572);
    } 
    if (this.b == 1) {
      noticeHolder.k.setVisibility(8);
    } else {
      noticeHolder.k.setVisibility(0);
    } 
    boolean bool = AtChooseUserHelper.c(paramFeedNotice.content);
    noticeHolder.j.setOnClickListener(new View.OnClickListener(this, paramFeedNotice, bool) {
          public void onClick(View param1View) {
            boolean bool;
            FeedProtos.Event event = FeedProtos.Event.MSG_NOTICE_COMMENT_CLICK;
            String str2 = this.a.comment_id;
            String str3 = this.a.circle_id;
            String str4 = this.a.feed_id;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.id);
            String str1 = "";
            stringBuilder.append("");
            String str5 = stringBuilder.toString();
            if (this.a.must_anonym_reply == 1) {
              bool = true;
            } else {
              bool = false;
            } 
            EventTrackFeed.a(event, str2, str3, str4, str5, bool);
            this.a.has_read = 1;
            if (SystemNoticeAdapter.b(this.c) != null)
              SystemNoticeAdapter.b(this.c).a(); 
            this.c.notifyDataSetChanged();
            if (this.a.comment_deleted != 1)
              str1 = this.a.comment_id; 
            if (this.a.from == 1) {
              FeedProtos.NoteSource noteSource;
              Context context = SystemNoticeAdapter.a(this.c);
              str3 = this.a.feed_id;
              if (this.b) {
                noteSource = FeedProtos.NoteSource.NOTICE_COMMENT_AT;
              } else {
                noteSource = FeedProtos.NoteSource.NOTICE_COMMENT_ENTER;
              } 
              CirclePostDetailsFragment.a(context, str3, str1, noteSource, false);
              return;
            } 
            BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
            bluedIngSelfFeed.feed_id = this.a.feed_id;
            bluedIngSelfFeed.aid = this.a.aid;
            bluedIngSelfFeed.is_ads = this.a.is_ads;
            FeedDetailsFragment.a(SystemNoticeAdapter.a(this.c), bluedIngSelfFeed, str1, -1);
          }
        });
    noticeHolder.h.setOnClickListener(new View.OnClickListener(this, noticeHolder) {
          public void onClick(View param1View) {
            this.a.j.callOnClick();
          }
        });
    noticeHolder.l.setOnClickListener(new View.OnClickListener(this, paramFeedNotice, bool) {
          public void onClick(View param1View) {
            FeedProtos.Event event = FeedProtos.Event.MSG_NOTICE_COMMENT_REPLY;
            String str1 = this.a.comment_id;
            String str2 = this.a.circle_id;
            String str3 = this.a.feed_id;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.id);
            stringBuilder.append("");
            EventTrackFeed.a(event, str1, str2, str3, stringBuilder.toString());
            this.a.has_read = 1;
            if (SystemNoticeAdapter.b(this.c) != null)
              SystemNoticeAdapter.b(this.c).a(); 
            this.c.notifyDataSetChanged();
            if (this.a.from_top == 1) {
              FeedProtos.NoteSource noteSource;
              Context context = SystemNoticeAdapter.a(this.c);
              str2 = this.a.feed_id;
              if (this.b) {
                noteSource = FeedProtos.NoteSource.NOTICE_COMMENT_AT;
              } else {
                noteSource = FeedProtos.NoteSource.NOTICE_COMMENT_ENTER;
              } 
              CirclePostDetailsFragment.a(context, str2, noteSource);
              return;
            } 
            if (this.a.admin_level == 3) {
              CircleMethods.joinCircle(SystemNoticeAdapter.a(this.c), new CircleMethods.JoinViewChangeListener(this) {
                    public void joinViewChange(CircleJoinState param2CircleJoinState) {
                      this.a.a.setJoinState(param2CircleJoinState);
                      this.a.c.notifyDataSetChanged();
                    }
                  },  this.a.getJoinState(), SystemNoticeAdapter.c(this.c), SystemNoticeAdapter.d(this.c), false, true);
              return;
            } 
            ReplyCommentFragment.a(SystemNoticeAdapter.a(this.c), this.a);
          }
        });
    if (!paramFeedNotice.isShowUrlVisited) {
      FeedProtos.Event event = FeedProtos.Event.MSG_NOTICE_COMMENT_SHOW;
      String str1 = paramFeedNotice.comment_id;
      String str2 = paramFeedNotice.circle_id;
      String str3 = paramFeedNotice.feed_id;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramFeedNotice.id);
      stringBuilder.append("");
      EventTrackFeed.a(event, str1, str2, str3, stringBuilder.toString());
      paramFeedNotice.isShowUrlVisited = true;
    } 
  }
  
  public long a() {
    ArrayList<Long> arrayList = new ArrayList();
    n();
    if (n().isEmpty())
      return 0L; 
    Iterator iterator = n().iterator();
    while (iterator.hasNext())
      arrayList.add(Long.valueOf(((FeedNotice)iterator.next()).notification_id)); 
    return ((Long)Collections.<Long>max(arrayList)).longValue();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, FeedNotice paramFeedNotice) {
    if (paramBaseViewHolder.getItemViewType() != 1) {
      c(paramBaseViewHolder, paramFeedNotice);
      return;
    } 
    b(paramBaseViewHolder, paramFeedNotice);
  }
  
  public void a(OnReadListener paramOnReadListener) {
    this.f = paramOnReadListener;
  }
  
  public int b() {
    Iterator iterator = n().iterator();
    int i = 0;
    while (iterator.hasNext()) {
      if (((FeedNotice)iterator.next()).has_read == 0)
        i++; 
    } 
    return i;
  }
  
  public void c() {
    Iterator iterator = n().iterator();
    while (iterator.hasNext())
      ((FeedNotice)iterator.next()).has_read = 1; 
    notifyDataSetChanged();
  }
  
  public static class NoticeHolder {
    public ImageView a;
    
    public ImageView b;
    
    public ImageView c;
    
    public TextView d;
    
    public TextView e;
    
    public TextView f;
    
    public TextView g;
    
    public TextView h;
    
    public ImageView i;
    
    public View j;
    
    public TextView k;
    
    public TextView l;
    
    public ImageView m;
    
    public ImageView n;
    
    private View o;
    
    public NoticeHolder(View param1View) {
      this.o = param1View;
      this.a = (ImageView)param1View.findViewById(2131297362);
      this.b = (ImageView)param1View.findViewById(2131299472);
      this.c = (ImageView)param1View.findViewById(2131301596);
      this.d = (TextView)param1View.findViewById(2131300267);
      this.e = (TextView)param1View.findViewById(2131299358);
      this.f = (TextView)param1View.findViewById(2131299381);
      this.g = (TextView)param1View.findViewById(2131301789);
      this.h = (TextView)param1View.findViewById(2131296838);
      this.i = (ImageView)param1View.findViewById(2131297575);
      this.j = param1View.findViewById(2131298758);
      this.k = (TextView)param1View.findViewById(2131300786);
      this.l = (TextView)param1View.findViewById(2131300760);
      this.m = (ImageView)param1View.findViewById(2131297581);
      this.n = (ImageView)param1View.findViewById(2131297682);
    }
  }
  
  public static interface OnReadListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\SystemNoticeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */