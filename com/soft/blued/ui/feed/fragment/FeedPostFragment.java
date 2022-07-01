package com.soft.blued.ui.feed.fragment;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.util.Pair;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.BroadcastFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.upload.qiniu.UploadModel;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.base.shortvideo.ISaveInterface;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.client.vote.VoteProtos;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.soft.blued.customview.EditInputNumView;
import com.soft.blued.customview.TextViewFixTouchForDynamic;
import com.soft.blued.customview.emoji.manager.Emoji;
import com.soft.blued.customview.emoji.view.EmojiEditText;
import com.soft.blued.customview.emoji.view.EmojiKeyboardLayout;
import com.soft.blued.db.model.NewFeedModel;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.log.trackUtils.EventTrackVote;
import com.soft.blued.ui.feed.adapter.FeedPostImageAdapter;
import com.soft.blued.ui.feed.adapter.FeedPostTopicAdapter;
import com.soft.blued.ui.feed.dialog.FeedPostLocationDialogFragment;
import com.soft.blued.ui.feed.dialog.FeedPostReadAuthDialogFragment;
import com.soft.blued.ui.feed.dialog.FeedPostTopicDialogFragment;
import com.soft.blued.ui.feed.manager.ChildPhotoManager;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.manager.VideoUploadManager;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.ui.feed.vm.FeedPostViewModel;
import com.soft.blued.ui.msg.DialogSkipFragment;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.ui.video.fragment.AlbumSelectDialogFragment;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.MarkDownLinkHelper;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.ViewUtils;
import com.soft.blued.utils.click.SingleClickProxy;
import com.soft.blued.utils.click.SingleItemChildClickProxy;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.pop.BluedPopupWindow;
import com.soft.blued.view.tip.pop.GestureAnimTipView;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FeedPostFragment extends BroadcastFragment implements View.OnClickListener {
  protected LinearLayout A;
  
  protected ImageView B;
  
  protected TextView C;
  
  protected CardView D;
  
  protected ImageView E;
  
  protected ImageView F;
  
  protected CardView G;
  
  protected ImageView H;
  
  protected ImageView I;
  
  protected View J;
  
  protected View K;
  
  protected ShapeLinearLayout L;
  
  protected ImageView M;
  
  protected TextView N;
  
  protected ImageView O;
  
  protected RecyclerView P;
  
  protected ShapeLinearLayout Q;
  
  protected ImageView R;
  
  protected TextView S;
  
  protected ImageView T;
  
  protected ShapeLinearLayout U;
  
  protected ImageView V;
  
  protected TextView W;
  
  protected ImageView X;
  
  protected ImageView Y;
  
  protected ImageView Z;
  
  protected EditDataModel.SerializableData aA;
  
  protected boolean aB;
  
  protected String aC;
  
  BluedPopupWindow aD;
  
  GestureAnimTipView aE;
  
  private FeedPostTopicAdapter aF;
  
  private boolean aG = false;
  
  private boolean aH = false;
  
  private int aI;
  
  private FeedPostViewModel aJ;
  
  private TextWatcher aK = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      private SpannableStringBuilder d;
      
      private SpannableStringBuilder e;
      
      public void afterTextChanged(Editable param1Editable) {
        try {
          this.a.r.removeTextChangedListener(FeedPostFragment.l(this.a));
          if (!this.a.ai.a(this.a, this.d.toString(), this.e.toString(), param1Editable, this.a.r.getSelectionEnd()))
            this.a.r.setSelection(Math.max(this.a.r.getSelectionStart(), 0)); 
          MarkDownLinkHelper.a((EditText)this.a.r, (CharSequence)this.d, (CharSequence)this.e, param1Editable, this.b, this.c);
          this.a.r.addTextChangedListener(FeedPostFragment.l(this.a));
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        FeedPostFragment.j(this.a);
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        this.d = new SpannableStringBuilder(param1CharSequence);
        this.b = this.a.r.getSelectionStart();
        this.c = this.a.r.getSelectionEnd();
      }
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        this.e = new SpannableStringBuilder(param1CharSequence);
      }
    };
  
  private DialogInterface.OnDismissListener aL = new DialogInterface.OnDismissListener(this) {
      public void onDismiss(DialogInterface param1DialogInterface) {
        this.a.J();
      }
    };
  
  protected ImageView aa;
  
  protected ImageView ab;
  
  protected ImageView ac;
  
  protected EmojiKeyboardLayout ad;
  
  protected View ae;
  
  protected CheckBox af;
  
  protected RecyclerView ag;
  
  protected FeedPostImageAdapter ah;
  
  protected AtChooseUserHelper ai;
  
  protected boolean aj;
  
  protected boolean ak;
  
  protected Emotion al;
  
  protected BluedIngSelfFeed am;
  
  protected NewFeedModel an;
  
  protected ShareEntity ao;
  
  protected BluedTopic ap;
  
  protected StvResultModel aq;
  
  protected int ar = -1;
  
  protected boolean as;
  
  protected boolean at;
  
  protected String au;
  
  protected boolean av;
  
  protected boolean aw;
  
  protected boolean ax;
  
  protected StvResultModel ay;
  
  protected String az;
  
  protected Context e;
  
  protected View f;
  
  protected KeyboardListenLinearLayout o;
  
  protected ImageView p;
  
  protected ShapeTextView q;
  
  protected EmojiEditText r;
  
  protected EditInputNumView s;
  
  protected LinearLayout t;
  
  protected CardView u;
  
  protected ImageView v;
  
  protected TextView w;
  
  protected TextView x;
  
  protected LinearLayout y;
  
  protected TextViewFixTouchForDynamic z;
  
  private void K() {
    this.aJ.e().observe((LifecycleOwner)this, new Observer<List<BluedTopic>>(this) {
          public void a(List<BluedTopic> param1List) {
            FeedPostFragment.c(this.a).c(param1List);
          }
        });
    this.aJ.c().observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            FeedPostFragment.d(this.a);
          }
        });
    this.aJ.d().observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            FeedPostFragment.d(this.a);
          }
        });
    this.aJ.f().observe((LifecycleOwner)this, new Observer<BluedTopic>(this) {
          public void a(BluedTopic param1BluedTopic) {
            FeedPostFragment.e(this.a);
          }
        });
    this.aJ.o().observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            FeedPostFragment.f(this.a);
          }
        });
    this.aJ.y().observe((LifecycleOwner)this, new Observer<Integer>(this) {
          public void a(Integer param1Integer) {
            this.a.ae.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.a.ae.getLayoutParams();
            layoutParams.height = param1Integer.intValue();
            this.a.ae.setLayoutParams(layoutParams);
          }
        });
    this.aJ.D().observe((LifecycleOwner)this, new Observer<Boolean>(this) {
          public void a(Boolean param1Boolean) {
            this.a.H();
            if (this.a.F()) {
              FeedPostFragment.g(this.a);
              return;
            } 
            FeedPostFragment.h(this.a);
          }
        });
    this.aJ.A().observe((LifecycleOwner)this, new Observer<Intent>(this) {
          public void a(Intent param1Intent) {
            FeedPostFragment.a(this.a, param1Intent);
          }
        });
  }
  
  private void L() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.am = (BluedIngSelfFeed)bundle.getSerializable("feed_data");
      this.an = (NewFeedModel)bundle.getSerializable("feed_send_data");
      this.ap = (BluedTopic)bundle.getSerializable("super_topic_key");
      this.aq = (StvResultModel)bundle.getSerializable("music_video_data");
      this.ao = (ShareEntity)bundle.getSerializable("share_entity");
      ShareEntity shareEntity = this.ao;
      if (shareEntity != null)
        this.ar = shareEntity.shareType; 
      this.aJ.a(bundle.getString("super_topic_avatar"));
      this.aJ.f().setValue(new BluedTopic(bundle.getString("super_topic_id"), bundle.getString("super_topic_name")));
      this.aG = bundle.getBoolean("is_attention_show_dot");
      this.aH = bundle.getBoolean("is_show_promotion");
      if (bundle.getBoolean("is_back")) {
        this.p.setImageDrawable(BluedSkinUtils.b(this.e, 2131232743));
        if (!TextUtils.isEmpty(this.aJ.g())) {
          this.L.setOnClickListener(null);
          this.O.setVisibility(8);
        } 
      } 
    } 
    StvResultModel stvResultModel = this.aq;
    int i = 0;
    if (stvResultModel != null && stvResultModel.a()) {
      this.ax = true;
      this.ay = this.aq;
      this.D.setVisibility(0);
      ImageLoader.d((IRequestHost)w_(), this.ay.c()).a(2131232201).a(this.E);
      this.ag.setVisibility(8);
      ac();
    } 
    if (this.ar == 0) {
      NewFeedModel newFeedModel1 = this.an;
      if (newFeedModel1 != null)
        newFeedModel1.is_url = 1; 
    } 
    NewFeedModel newFeedModel = this.an;
    if (newFeedModel != null) {
      if (newFeedModel.is_super_topics == 1) {
        this.aJ.a(this.an.super_topics_avatar);
        this.aJ.f().setValue(new BluedTopic(this.an.super_did, this.an.super_topics_name));
      } 
      this.aJ.o().setValue(this.an.address);
      this.aJ.b(this.an.getLat());
      this.aJ.b(this.an.getLng());
      this.aJ.c().setValue(Integer.valueOf(this.an.reading_scope));
      this.aJ.d().setValue(Integer.valueOf(this.an.allow_comments));
    } 
    if (this.aJ.f().getValue() != null && !TextUtils.isEmpty(((BluedTopic)this.aJ.f().getValue()).name) && !TextUtils.isEmpty(this.aJ.g()))
      this.r.setHint(2131758964); 
    newFeedModel = this.an;
    if (newFeedModel != null) {
      String str = newFeedModel.getPics();
      if (!TextUtils.isEmpty(str)) {
        String[] arrayOfString = str.split(";");
        if (this.an.is_vote == 1) {
          if (arrayOfString.length > 0) {
            if (arrayOfString[0].contains("http://") || arrayOfString[0].contains("https://")) {
              ImageFileLoader.a((IRequestHost)w_()).a(arrayOfString[0]).a(new ImageFileLoader.OnLoadFileListener(this, arrayOfString) {
                    public void onUIFinish(File param1File, Exception param1Exception) {
                      if (param1File != null && param1File.exists())
                        FeedPostFragment.a(this.b, this.a[0]); 
                    }
                  }).a();
              return;
            } 
            b(arrayOfString[0]);
            return;
          } 
        } else {
          while (i < arrayOfString.length) {
            if (arrayOfString[i].contains("http://") || arrayOfString[i].contains("https://")) {
              ImageFileLoader.a((IRequestHost)w_()).a(arrayOfString[i]).a(new -$$Lambda$FeedPostFragment$3WvDZJ5IvZilPSxl0l-DCqCiSDI(this)).a();
            } else {
              SelectPhotoManager.a().a(new ChildImageInfo(arrayOfString[i]));
            } 
            i++;
          } 
        } 
      } 
    } 
  }
  
  private void M() {
    BluedIngSelfFeed bluedIngSelfFeed = this.am;
    if (bluedIngSelfFeed != null)
      if (bluedIngSelfFeed.repost != null) {
        this.at = true;
        this.af.setVisibility(0);
        if (this.am.repost.is_url == 1) {
          this.y.setVisibility(0);
          bluedIngSelfFeed = this.am.repost;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(StringUtils.c(this.am.repost.user_name, this.am.repost.feed_uid));
          stringBuilder.append(":");
          stringBuilder.append(this.am.repost.feed_content);
          bluedIngSelfFeed.feed_content = stringBuilder.toString();
          CharSequence charSequence = StringUtils.a(StringUtils.a(StringUtils.a(this.am.repost.feed_content, (int)this.z.getTextSize(), 0), true, true, true, ""), true, new boolean[0]);
          this.z.setText(charSequence);
          this.z.setVisibility(0);
          if (this.am.repost.feed_extras != null) {
            if (!StringUtils.e(this.am.repost.feed_extras.title))
              this.C.setText(this.am.repost.feed_extras.title); 
            if (this.am.repost.feed_extras.thumb != null && this.am.repost.feed_extras.thumb.size() > 0)
              ImageLoader.a((IRequestHost)w_(), this.am.repost.feed_extras.thumb.get(0)).a(2131232201).a(this.B); 
          } 
        } else {
          this.u.setVisibility(0);
          BluedIngSelfFeed bluedIngSelfFeed1 = this.am.repost;
          if (bluedIngSelfFeed1 != null)
            if (bluedIngSelfFeed1.is_share_super_topics == 1) {
              this.w.setText(bluedIngSelfFeed1.share_s_t_name);
              ImageLoader.a((IRequestHost)w_(), bluedIngSelfFeed1.share_s_t_avatar).a(2131231369).a(this.v);
              if (!TextUtils.isEmpty(bluedIngSelfFeed1.share_s_t_des)) {
                this.x.setText(c(bluedIngSelfFeed1.share_s_t_des));
              } else {
                this.x.setText(this.e.getResources().getString(2131758768));
              } 
              this.u.findViewById(2131301685).setVisibility(0);
            } else if (bluedIngSelfFeed1.is_share_circle == 1) {
              this.av = true;
              this.af.setVisibility(0);
              this.w.setText(bluedIngSelfFeed1.circle_title);
              if (bluedIngSelfFeed1.is_video_posts == 1 && bluedIngSelfFeed1.feed_videos != null && bluedIngSelfFeed1.feed_videos.length > 0) {
                ImageLoader.a((IRequestHost)w_(), bluedIngSelfFeed1.feed_videos[0]).a(2131231280).a(this.v);
              } else if (bluedIngSelfFeed1.feed_pics != null && bluedIngSelfFeed1.feed_pics.length > 0) {
                ImageLoader.a((IRequestHost)w_(), bluedIngSelfFeed1.feed_pics[0]).a(2131231280).a(this.v);
              } else {
                this.v.setImageResource(2131231280);
              } 
              this.x.setText(c(bluedIngSelfFeed1.feed_pure_content));
            } else if (bluedIngSelfFeed1.is_share_posting == 1) {
              this.av = true;
              this.af.setVisibility(0);
              this.w.setText(bluedIngSelfFeed1.share_circle_title);
              ImageLoader.a((IRequestHost)w_(), bluedIngSelfFeed1.share_circle_posting_pic).a(2131231280).c(2131231280).a(this.v);
              this.x.setText(c(bluedIngSelfFeed1.share_circle_posting_content));
            } else {
              String str;
              this.w.setText(bluedIngSelfFeed1.user_name);
              if (bluedIngSelfFeed1.feed_pics != null && bluedIngSelfFeed1.feed_pics.length > 0) {
                str = bluedIngSelfFeed1.feed_pics[0];
              } else {
                str = bluedIngSelfFeed1.user_avatar;
              } 
              ImageLoader.a((IRequestHost)w_(), str).a(2131231369).a(this.v);
              if (TextUtils.isEmpty(bluedIngSelfFeed1.feed_content)) {
                if ("1".equals(bluedIngSelfFeed1.is_videos)) {
                  this.x.setText(this.e.getResources().getString(2131758620));
                } else {
                  this.x.setText(this.e.getResources().getString(2131758619));
                } 
              } else {
                this.x.setText(c(bluedIngSelfFeed1.feed_content));
              } 
            }  
        } 
      } else {
        this.af.setVisibility(8);
      }  
    if (this.an != null) {
      Log.v("drb", "重新编辑");
      if (this.an.is_repost == 1) {
        Log.v("drb", "重新编辑 is_repost == 1");
        this.at = true;
        this.u.setVisibility(0);
        ImageLoader.a((IRequestHost)w_(), this.an.forwardImage).a(2131231369).a(this.v);
        this.w.setText(this.an.forwardName);
        if (TextUtils.isEmpty(this.an.forwardContent)) {
          if (this.an.isVideo == 1) {
            this.x.setText(this.e.getResources().getString(2131758620));
          } else {
            this.x.setText(this.e.getResources().getString(2131758619));
          } 
        } else {
          this.x.setText(c(this.an.forwardContent));
        } 
      } else if (this.an.isVideo == 1) {
        Log.v("drb", "重新编辑 isVideo == 1");
        this.ax = true;
        this.D.setVisibility(0);
        ImageLoader.d((IRequestHost)w_(), this.an.localPath).a(2131232201).a(this.E);
        if (this.ay == null)
          this.ay = new StvResultModel(); 
        this.ay.c(this.an.videoPath);
        this.ay.c(this.an.localVideoPath);
        this.ay.a(true);
        this.ay.b(this.an.localPath);
        this.ay.b(this.an.videoSize);
        this.ay.a((long)(this.an.duration * 1000.0F));
      } else if (!TextUtils.isEmpty(this.an.share_posting_id)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("重新编辑 mNewFeedModel.share_posting_id :");
        stringBuilder.append(this.an.share_posting_id);
        Log.v("drb", stringBuilder.toString());
        this.av = true;
        this.u.setVisibility(0);
        this.w.setText(this.an.forwardName);
        ImageLoader.a((IRequestHost)w_(), this.an.forwardImage).a(2131231280).a(this.v);
        this.x.setText(c(this.an.forwardContent));
      } 
    } 
    int i = this.ar;
    if (i == 0) {
      this.as = true;
      this.u.setVisibility(0);
      this.w.setLines(2);
      String str2 = this.ao.netImgUrl;
      String str1 = str2;
      if (this.ao.flag == 0) {
        str1 = str2;
        if (!TextUtils.isEmpty(this.ao.fileUrl))
          str1 = this.ao.fileUrl; 
      } 
      if (!TextUtils.isEmpty(str1)) {
        ImageWrapper imageWrapper;
        if (str1.contains("http")) {
          imageWrapper = ImageLoader.a((IRequestHost)w_(), str1);
        } else {
          imageWrapper = ImageLoader.d((IRequestHost)w_(), (String)imageWrapper);
        } 
        imageWrapper.a(2131232201).a(this.v);
      } 
      ShareEntity shareEntity = this.ao;
      if (shareEntity != null) {
        if (!StringUtils.e(shareEntity.title)) {
          this.w.setText(this.ao.title);
        } else {
          this.w.setText(this.ao.linkUrl);
        } 
        this.x.setVisibility(8);
        return;
      } 
    } else {
      if (i == 1) {
        a(this.ao.content);
        return;
      } 
      if (i == 1)
        a(this.ao.content); 
    } 
  }
  
  private void N() {
    if (this.ap != null) {
      this.aw = true;
      this.u.setVisibility(0);
      this.an = new NewFeedModel();
      NewFeedModel newFeedModel1 = this.an;
      newFeedModel1.is_share_super_topics = 1;
      newFeedModel1.forwardName = this.ap.name;
      this.an.forwardContent = this.ap.description;
      this.an.forwardImage = this.ap.avatar;
      this.an.share_s_t_did = this.ap.super_did;
    } 
    NewFeedModel newFeedModel = this.an;
    if (newFeedModel != null && newFeedModel.is_share_super_topics == 1) {
      this.aw = true;
      this.u.setVisibility(0);
      this.u.findViewById(2131301685).setVisibility(0);
      ImageLoader.a((IRequestHost)w_(), this.an.forwardImage).a(2131231369).a(this.v);
      this.w.setText(this.an.forwardName);
      this.x.setText(c(this.an.forwardContent));
    } 
  }
  
  private void O() {
    this.s.a((EditText)this.r, B());
    this.r.addTextChangedListener(this.aK);
    if (this.ar == 0 && this.ao != null) {
      this.r.setText("");
      return;
    } 
    BluedIngSelfFeed bluedIngSelfFeed = this.am;
    if (bluedIngSelfFeed != null) {
      String str = bluedIngSelfFeed.feed_content;
      if (TextUtils.isEmpty(str))
        return; 
      a(str);
      this.au = this.r.getText().toString();
      this.r.setSelection(0);
    } 
    NewFeedModel newFeedModel = this.an;
    if (newFeedModel != null) {
      String str = newFeedModel.getContent();
      if (TextUtils.isEmpty(str))
        return; 
      a(str);
    } 
  }
  
  private void P() {
    this.p = (ImageView)this.f.findViewById(2131297729);
    this.q = (ShapeTextView)this.f.findViewById(2131301186);
    this.p.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.q.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.t = (LinearLayout)this.f.findViewById(2131298089);
    this.u = (CardView)this.f.findViewById(2131298063);
    this.v = (ImageView)this.f.findViewById(2131297202);
    this.w = (TextView)this.f.findViewById(2131297203);
    this.x = (TextView)this.f.findViewById(2131297201);
    this.y = (LinearLayout)this.f.findViewById(2131299080);
    this.z = (TextViewFixTouchForDynamic)this.f.findViewById(2131301148);
    this.A = (LinearLayout)this.f.findViewById(2131299942);
    this.B = (ImageView)this.f.findViewById(2131297555);
    this.C = (TextView)this.f.findViewById(2131301337);
    this.D = (CardView)this.f.findViewById(2131298101);
    this.E = (ImageView)this.f.findViewById(2131297576);
    this.F = (ImageView)this.f.findViewById(2131297962);
    this.F.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.E.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.G = (CardView)this.f.findViewById(2131298066);
    this.H = (ImageView)this.f.findViewById(2131297500);
    this.I = (ImageView)this.f.findViewById(2131297814);
    this.H.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.I.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.K = this.f.findViewById(2131298060);
    this.J = this.f.findViewById(2131297044);
    this.L = (ShapeLinearLayout)this.f.findViewById(2131298095);
    this.M = (ImageView)this.f.findViewById(2131297929);
    this.N = (TextView)this.f.findViewById(2131301364);
    this.O = (ImageView)this.f.findViewById(2131297930);
    this.L.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.O.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.Q = (ShapeLinearLayout)this.f.findViewById(2131298071);
    this.R = (ImageView)this.f.findViewById(2131297837);
    this.S = (TextView)this.f.findViewById(2131300998);
    this.T = (ImageView)this.f.findViewById(2131297838);
    this.Q.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.T.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.U = (ShapeLinearLayout)this.f.findViewById(2131298088);
    this.V = (ImageView)this.f.findViewById(2131297906);
    this.W = (TextView)this.f.findViewById(2131301232);
    this.X = (ImageView)this.f.findViewById(2131297907);
    this.U.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.X.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.P = (RecyclerView)this.f.findViewById(2131299799);
    this.P.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this.e, 0, false));
    this.aF = new FeedPostTopicAdapter();
    this.aF.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (param1View.getId() == 2131299752) {
              BluedTopic bluedTopic = FeedPostFragment.c(this.a).n().get(param1Int);
              FeedPostFragment.a(this.a).f().setValue(new BluedTopic(bluedTopic.super_did, bluedTopic.name));
              EventTrackFeed.d(FeedProtos.Event.FEED_PUBLISH_TOPIC_CLICK, bluedTopic.super_did);
            } 
          }
        });
    this.P.setAdapter((RecyclerView.Adapter)this.aF);
    this.Y = (ImageView)this.f.findViewById(2131297812);
    this.Z = (ImageView)this.f.findViewById(2131297891);
    this.aa = (ImageView)this.f.findViewById(2131297690);
    this.ab = (ImageView)this.f.findViewById(2131297753);
    this.ac = (ImageView)this.f.findViewById(2131297972);
    this.Y.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.Z.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.aa.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.ab.setOnClickListener(this);
    this.ac.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.ae = this.f.findViewById(2131300000);
    this.af = (CheckBox)this.f.findViewById(2131296668);
  }
  
  private void Q() {
    this.r = (EmojiEditText)this.f.findViewById(2131296977);
    this.s = (EditInputNumView)this.f.findViewById(2131297597);
    this.al = new Emotion(this.e);
    this.r.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1View.getId() == 2131296977) {
              param1View.getParent().requestDisallowInterceptTouchEvent(true);
              if (param1MotionEvent.getAction() == 1)
                param1View.getParent().requestDisallowInterceptTouchEvent(false); 
            } 
            return false;
          }
        });
    MarkDownLinkHelper.a(this.r);
  }
  
  private void R() {
    this.ad = (EmojiKeyboardLayout)this.f.findViewById(2131296983);
    this.ad.setKeyboardColor(2);
    this.ad.setFragmentManager(getChildFragmentManager());
    ViewGroup.LayoutParams layoutParams = this.ad.getLayoutParams();
    layoutParams.height = KeyboardUtils.a();
    this.ad.setLayoutParams(layoutParams);
    this.ad.setEmojiCallback(new EmojiKeyboardLayout.EmojiCallback(this) {
          public void a() {
            KeyEvent keyEvent = new KeyEvent(0, 67);
            this.a.r.onKeyDown(67, keyEvent);
          }
          
          public void a(Emoji param1Emoji) {
            SpannableString spannableString = new SpannableString(param1Emoji.a());
            if (this.a.i.getText().length() + spannableString.length() <= this.a.B())
              this.a.r.getText().insert(this.a.r.getSelectionStart(), (CharSequence)spannableString); 
          }
        });
  }
  
  private void S() {
    this.o = (KeyboardListenLinearLayout)this.f.findViewById(2131297980);
    this.o.setBackgroundColor(BluedSkinUtils.a(this.e, 2131100728));
    a((View)this.ad, this.o, (EditText)this.r);
  }
  
  private void T() {
    this.ag = (RecyclerView)this.f.findViewById(2131299783);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.e, 3);
    this.ag.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    OnItemDragListener onItemDragListener = new OnItemDragListener(this) {
        public void a(RecyclerView.ViewHolder param1ViewHolder, int param1Int) {
          FeedPostFragment.i(this.a);
          if (this.a.aj)
            KeyboardUtils.a((Activity)this.a.getActivity()); 
          ((BaseViewHolder)param1ViewHolder).b(2131296961, true);
        }
        
        public void a(RecyclerView.ViewHolder param1ViewHolder1, int param1Int1, RecyclerView.ViewHolder param1ViewHolder2, int param1Int2) {}
        
        public void b(RecyclerView.ViewHolder param1ViewHolder, int param1Int) {
          ((BaseViewHolder)param1ViewHolder).b(2131296961, false);
          this.a.ah.d();
        }
      };
    this.ah = new FeedPostImageAdapter((IRequestHost)w_());
    ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback((BaseItemDraggableAdapter)this.ah);
    ItemTouchHelper itemTouchHelper = new ItemTouchHelper((ItemTouchHelper.Callback)itemDragAndSwipeCallback);
    itemTouchHelper.attachToRecyclerView(this.ag);
    itemDragAndSwipeCallback.a(15);
    itemDragAndSwipeCallback.b(48);
    this.ah.a();
    this.ah.a(itemTouchHelper);
    this.ah.a(onItemDragListener);
    this.ah.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            FeedPostFragment.i(this.a);
            BasePhotoFragment.a((Context)this.a.getActivity(), param1Int, 0, null);
          }
        });
    this.ah.a((BaseQuickAdapter.OnItemChildClickListener)new SingleItemChildClickProxy(new BaseQuickAdapter.OnItemChildClickListener(this) {
            public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
              int i = param1View.getId();
              if (i != 2131297422) {
                if (i != 2131297813)
                  return; 
                SelectPhotoManager.a().b(this.a.ah.n().get(param1Int));
                AlbumSelectInfo albumSelectInfo = (AlbumSelectInfo)FeedPostFragment.a(this.a).z().getValue();
                if (albumSelectInfo != null)
                  albumSelectInfo.a(((ChildImageInfo)this.a.ah.n().get(param1Int)).mImagePath); 
                FeedPostFragment.a(this.a).B().setValue(((ChildImageInfo)this.a.ah.n().get(param1Int)).mImagePath);
                this.a.ah.c();
                FeedPostFragment.j(this.a);
                FeedPostFragment.h(this.a);
                return;
              } 
              EventTrackFeed.a(FeedProtos.Event.FEED_ADD_PHOTO, FeedProtos.AddType.ADD, this.a.E());
              FeedPostFragment.k(this.a);
            }
          }));
    this.ag.setAdapter((RecyclerView.Adapter)this.ah);
  }
  
  private void U() {
    if (y()) {
      this.q.setAlpha(1.0F);
      return;
    } 
    this.q.setAlpha(0.3F);
  }
  
  private void V() {
    if (this.aJ.G()) {
      this.N.setText(((BluedTopic)this.aJ.f().getValue()).name);
      ShapeHelper.b((ShapeHelper.ShapeView)this.L, 2131100718);
      if (TextUtils.isEmpty(this.aJ.g())) {
        this.O.setVisibility(0);
      } else {
        this.O.setVisibility(8);
      } 
      this.P.setVisibility(8);
      return;
    } 
    this.N.setText(2131756437);
    ShapeHelper.b((ShapeHelper.ShapeView)this.L, 2131100881);
    this.O.setVisibility(8);
    this.P.setVisibility(0);
  }
  
  private void W() {
    if (!TextUtils.isEmpty((CharSequence)this.aJ.o().getValue())) {
      this.S.setText((CharSequence)this.aJ.o().getValue());
      ShapeHelper.b((ShapeHelper.ShapeView)this.Q, 2131100718);
      this.T.setVisibility(0);
      return;
    } 
    this.S.setText(2131756429);
    ShapeHelper.b((ShapeHelper.ShapeView)this.Q, 2131100881);
    this.T.setVisibility(8);
  }
  
  private void X() {
    if (((Integer)this.aJ.c().getValue()).intValue() == 0 && ((Integer)this.aJ.d().getValue()).intValue() == 0) {
      this.W.setText(2131756432);
      ShapeHelper.b((ShapeHelper.ShapeView)this.U, 2131100881);
      this.X.setVisibility(8);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    int i = ((Integer)this.aJ.c().getValue()).intValue();
    if (i != 0) {
      if (i != 1) {
        if (i == 2)
          stringBuilder.append(this.e.getString(2131756459)); 
      } else {
        stringBuilder.append(this.e.getString(2131756458));
      } 
    } else {
      stringBuilder.append(this.e.getString(2131756438));
    } 
    stringBuilder.append("、");
    i = ((Integer)this.aJ.d().getValue()).intValue();
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i == 3)
            stringBuilder.append(this.e.getString(2131756420)); 
        } else {
          stringBuilder.append(this.e.getString(2131756421));
        } 
      } else {
        stringBuilder.append(this.e.getString(2131756422));
      } 
    } else {
      stringBuilder.append(this.e.getString(2131756419));
    } 
    this.W.setText(stringBuilder);
    ShapeHelper.b((ShapeHelper.ShapeView)this.U, 2131100718);
    this.X.setVisibility(0);
  }
  
  private void Y() {
    if (!z()) {
      if (Z())
        DialogSkipFragment.a((Context)getActivity(), 4); 
      this.ad.setVisibility(8);
      int i = this.ah.D();
      if (!D() && 9 - i == 9 && !Z()) {
        AlbumSelectDialogFragment.a.a(getActivity(), 4, 3, 9, 109, false).a(this.aL);
        this.aI = 1;
        return;
      } 
      AlbumSelectDialogFragment.a.a(getActivity(), 4, 1, 9, 109, false).a(this.aL);
    } 
  }
  
  private boolean Z() {
    return LiveFloatManager.a().F();
  }
  
  private View a(MotionEvent paramMotionEvent) {
    for (View view : ViewUtils.a(this.f)) {
      if (ViewUtils.a(view, paramMotionEvent) && view.getVisibility() == 0)
        return view; 
    } 
    return null;
  }
  
  public static void a(Context paramContext) {
    if (PopMenuUtils.a(paramContext))
      return; 
    TerminalActivity.d(paramContext, FeedPostFragment.class, new Bundle());
  }
  
  public static void a(Context paramContext, StvResultModel paramStvResultModel) {
    if (PopMenuUtils.a(paramContext))
      return; 
    Bundle bundle = new Bundle();
    bundle.putSerializable("music_video_data", (Serializable)paramStvResultModel);
    TerminalActivity.d(paramContext, FeedPostFragment.class, bundle);
  }
  
  public static void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed) {
    if (PopMenuUtils.a(paramContext))
      return; 
    Bundle bundle = new Bundle();
    bundle.putSerializable("feed_data", (Serializable)paramBluedIngSelfFeed);
    TerminalActivity.d(paramContext, FeedPostFragment.class, bundle);
  }
  
  public static void a(Context paramContext, BluedTopic paramBluedTopic) {
    if (PopMenuUtils.a(paramContext))
      return; 
    if (paramBluedTopic == null)
      return; 
    Bundle bundle = new Bundle();
    bundle.putSerializable("super_topic_key", (Serializable)paramBluedTopic);
    TerminalActivity.d(paramContext, FeedPostFragment.class, bundle);
  }
  
  public static void a(Context paramContext, ShareEntity paramShareEntity) {
    a(paramContext, paramShareEntity, (String)null, (String)null);
  }
  
  public static void a(Context paramContext, ShareEntity paramShareEntity, String paramString1, String paramString2) {
    a(paramContext, paramShareEntity, paramString1, paramString2, false);
  }
  
  public static void a(Context paramContext, ShareEntity paramShareEntity, String paramString1, String paramString2, boolean paramBoolean) {
    if (PopMenuUtils.a(paramContext))
      return; 
    NewFeedModel newFeedModel = new NewFeedModel();
    if (!StringUtils.e(paramShareEntity.title)) {
      newFeedModel.setContent(paramShareEntity.title);
    } else {
      newFeedModel.setContent(paramShareEntity.linkUrl);
    } 
    if (!StringUtils.e(paramShareEntity.netImgUrl)) {
      newFeedModel.setPics(paramShareEntity.netImgUrl);
    } else if (!StringUtils.e(paramShareEntity.fileUrl)) {
      newFeedModel.setPics(paramShareEntity.fileUrl);
    } 
    Bundle bundle = new Bundle();
    bundle.putSerializable("feed_send_data", (Serializable)newFeedModel);
    bundle.putSerializable("share_entity", (Serializable)paramShareEntity);
    bundle.putBoolean("is_show_promotion", paramBoolean);
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      bundle.putString("super_topic_id", paramString1);
      bundle.putString("super_topic_name", paramString2);
    } 
    TerminalActivity.d(paramContext, FeedPostFragment.class, bundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2) {
    if (PopMenuUtils.a(paramContext))
      return; 
    Bundle bundle = new Bundle();
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      bundle.putString("super_topic_id", paramString1);
      bundle.putString("super_topic_name", paramString2);
    } 
    TerminalActivity.d(paramContext, FeedPostFragment.class, bundle);
  }
  
  public static void a(Context paramContext, boolean paramBoolean) {
    if (PopMenuUtils.a(paramContext))
      return; 
    Bundle bundle = new Bundle();
    bundle.putBoolean("is_attention_show_dot", paramBoolean);
    TerminalActivity.d(paramContext, FeedPostFragment.class, bundle);
  }
  
  private void a(Intent paramIntent) {
    if (paramIntent != null) {
      StvResultModel stvResultModel = (StvResultModel)paramIntent.getSerializableExtra("result_model");
      if (stvResultModel != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@@@@ ");
        stringBuilder.append(stvResultModel.toString());
        StvLogUtils.d(stringBuilder.toString(), new Object[0]);
        if (stvResultModel.a()) {
          Log.d("chenjiemei", "SHINE_OR_TAKE_PHOTO");
          if (paramIntent.getSerializableExtra("serializeble_data") != null)
            this.aA = (EditDataModel.SerializableData)paramIntent.getSerializableExtra("serializeble_data"); 
          this.ax = true;
          this.ay = stvResultModel;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("SHINE_OR_TAKE_PHOTO stvResultModel firstimage");
          stringBuilder1.append(this.ay.c());
          Log.d("chenjiemei", stringBuilder1.toString());
          this.D.setVisibility(0);
          ImageLoader.d((IRequestHost)w_(), this.ay.c()).a(2131232201).a(this.E);
          ac();
          return;
        } 
        this.ax = false;
        ChildImageInfo childImageInfo = new ChildImageInfo();
        childImageInfo.mImagePath = stvResultModel.b();
        SelectPhotoManager.a().a(childImageInfo);
        H();
      } 
    } 
  }
  
  public static void a(Fragment paramFragment, String paramString1, String paramString2, int paramInt) {
    if (PopMenuUtils.a(paramFragment.getContext()))
      return; 
    Bundle bundle = new Bundle();
    bundle.putString("super_topic_avatar", paramString1);
    bundle.putString("super_topic_name", paramString2);
    bundle.putBoolean("is_back", true);
    TerminalActivity.a(paramFragment, FeedPostFragment.class, bundle, paramInt);
  }
  
  private void a(boolean paramBoolean) {
    if (paramBoolean) {
      J();
      return;
    } 
    af();
  }
  
  private boolean aa() {
    if (this.av) {
      AppMethods.d(2131755940);
      return true;
    } 
    return false;
  }
  
  private void ab() {
    if (this.aA != null) {
      Bundle bundle = new Bundle();
      bundle.putSerializable("serializeble_data", (Serializable)this.aA);
      byte b = 0;
      if (C())
        b = 3; 
      ShortVideoProxy.e().a(this, bundle, b, 120);
    } 
  }
  
  private void ac() {
    if (this.aA != null) {
      Bundle bundle = new Bundle();
      bundle.putSerializable("serializeble_data", (Serializable)this.aA);
      byte b = 0;
      if (C())
        b = 3; 
      ShortVideoProxy.e().a(bundle, b, new ISaveInterface(this) {
            public void a() {
              Logger.b("FeedSend", new Object[] { "saveVideoNoUI onSaveVideoCanceled" });
            }
            
            public void a(float param1Float) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("saveVideoNoUI onProgress v");
              stringBuilder.append(param1Float);
              Logger.b("FeedSend", new Object[] { stringBuilder.toString() });
            }
            
            public void a(int param1Int) {
              Logger.b("FeedSend", new Object[] { "saveVideoNoUI onSaveFailed" });
            }
            
            public void a(StvResultModel param1StvResultModel) {
              FeedPostFragment feedPostFragment = this.a;
              feedPostFragment.ay = param1StvResultModel;
              feedPostFragment.aA = null;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("saveVideoNoUI onSaveSucess videoFeed");
              stringBuilder.append(this.a.ay.f());
              Logger.b("FeedSend", new Object[] { stringBuilder.toString() });
              FeedPostFragment.m(this.a);
            }
            
            public void b() {}
          });
    } 
  }
  
  private void ad() {
    Log.d("FendSend", "cancleUploadVideo");
    if (!StringUtils.e(this.az)) {
      VideoUploadManager.a().a(this.az);
      this.az = null;
    } 
  }
  
  private void ae() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("uploadVideo videoFeed.getFirstFrameImgPath()");
    stringBuilder.append(this.ay.c());
    Log.d("FeedSend", stringBuilder.toString());
    StvResultModel stvResultModel = this.ay;
    if (stvResultModel != null) {
      if (StringUtils.e(stvResultModel.f()))
        return; 
      Pair pair1 = new Pair(this.ay.c(), "");
      Pair pair2 = new Pair(this.ay.f(), "");
      VideoUploadManager.a().a(pair1, pair2, new VideoUploadManager.VideoUploadListener(this) {
            public void a(String param1String, int param1Int) {
              this.a.az = param1String;
            }
            
            public void a(String param1String, boolean param1Boolean, ArrayList<Pair<String, UploadModel>> param1ArrayList, List<Pair<String, String>> param1List) {
              this.a.az = param1String;
            }
          });
    } 
  }
  
  private void af() {
    if (!this.r.isFocusable()) {
      this.r.setFocusable(true);
      this.r.setFocusableInTouchMode(true);
    } 
    this.r.requestFocus();
  }
  
  private void ag() {
    byte b;
    af();
    this.ae.setVisibility(8);
    this.ad.setVisibility(0);
    if (this.aJ.y().getValue() != null) {
      b = ((Integer)this.aJ.y().getValue()).intValue();
    } else {
      b = 0;
    } 
    ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[] { b - ah(), 0 });
    valueAnimator.setTarget(this.ad);
    valueAnimator.setInterpolator((TimeInterpolator)new AccelerateInterpolator());
    valueAnimator.setDuration(200L).start();
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("values = ");
            stringBuilder.append(i);
            Log.d("onAnimationUpdate", stringBuilder.toString());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.a.ad.getLayoutParams();
            marginLayoutParams.bottomMargin = i;
            this.a.ad.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
          }
        });
    this.ab.setImageDrawable(BluedSkinUtils.b(this.e, 2131232209));
  }
  
  private int ah() {
    return (this.ad.getMeasuredHeight() > 0) ? this.ad.getMeasuredHeight() : KeyboardUtils.a();
  }
  
  private void ai() {
    if (!F())
      return; 
    if (!BluedPreferences.eK())
      return; 
    if (this.aE == null) {
      this.aE = new GestureAnimTipView(this.e);
      this.aE.setText(2131756424);
      this.aD = BluedPopupWindow.Builder.a((Activity)getContext(), (View)this.aE).a(true).a();
      this.aD.setOnDismissListener(new PopupWindow.OnDismissListener(this) {
            public void onDismiss() {
              FeedPostFragment feedPostFragment = this.a;
              feedPostFragment.aD = null;
              feedPostFragment.aE = null;
            }
          });
      this.aE.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              FeedPostFragment.i(this.a);
            }
          });
      this.aD.setOutsideTouchable(false);
      this.aD.a((View)this.ag, 1, 3, DensityUtils.a(this.e, 15.0F), 0, false);
      this.aE.a("gesture_anim_tip_anim_774.png", (IRequestHost)w_());
      BluedPreferences.eJ();
    } 
  }
  
  private void aj() {
    if (this.ag.getVisibility() != 0 || this.ah.A() < 2)
      ak(); 
  }
  
  private void ak() {
    BluedPopupWindow bluedPopupWindow = this.aD;
    if (bluedPopupWindow != null) {
      GestureAnimTipView gestureAnimTipView = this.aE;
      if (gestureAnimTipView != null)
        gestureAnimTipView.a((PopupWindow)bluedPopupWindow); 
    } 
  }
  
  public static void b(Context paramContext, NewFeedModel paramNewFeedModel) {
    if (PopMenuUtils.a(paramContext))
      return; 
    Bundle bundle = new Bundle();
    bundle.putSerializable("feed_send_data", (Serializable)paramNewFeedModel);
    TerminalActivity.d(paramContext, FeedPostFragment.class, bundle);
  }
  
  private void b(String paramString) {
    this.aB = true;
    this.aC = paramString;
    ImageLoader.d((IRequestHost)w_(), this.aC).a(2131232201).a(this.H);
    this.G.setVisibility(0);
    this.ag.setVisibility(8);
  }
  
  private CharSequence c(String paramString) {
    return TextUtils.isEmpty(paramString) ? null : StringUtils.a(StringUtils.a((CharSequence)new SpannableStringBuilder(paramString), DensityUtils.a(this.e, 14.0F), 1), true, true, false, null, true, "", "");
  }
  
  public boolean A() {
    return (this.at || this.aB || this.ax || this.as || this.aw || this.av);
  }
  
  public int B() {
    return !this.at ? 512 : 256;
  }
  
  public boolean C() {
    return (this.ah.D() > 0);
  }
  
  public boolean D() {
    return false;
  }
  
  protected FeedProtos.FeedType E() {
    return this.aJ.G() ? FeedProtos.FeedType.SUPER_TOPIC : FeedProtos.FeedType.COMMON;
  }
  
  protected boolean F() {
    return (this.ag.getVisibility() == 0 && this.ah.A() >= 2);
  }
  
  protected void G() {
    byte b;
    this.aJ.a(E());
    EventTrackFeed.a(FeedProtos.Event.FEED_ADD_PHOTO, FeedProtos.AddType.HALF_SCREEN, E());
    AlbumSelectDialogFragment.Companion companion = AlbumSelectDialogFragment.a;
    FragmentActivity fragmentActivity = getActivity();
    if (Z()) {
      b = 1;
    } else {
      b = 3;
    } 
    companion.a(fragmentActivity, 4, b, 9, 109, true).a(new AlbumSelectDialogFragment.AlbumSelectOnDismissListener(this) {
          public View a(MotionEvent param1MotionEvent) {
            View view = FeedPostFragment.a(this.a, param1MotionEvent);
            if (view != null) {
              if (view.getId() == 2131297422 || view.getId() == this.a.Y.getId())
                view.setTag(Integer.valueOf(101)); 
              if (view.getId() == this.a.L.getId() || view.getId() == this.a.Q.getId() || view.getId() == this.a.U.getId() || view.getId() == this.a.O.getId() || view.getId() == this.a.T.getId() || view.getId() == this.a.X.getId() || view.getId() == 2131297813 || view.getId() == 2131299752)
                view.setTag(Integer.valueOf(102)); 
            } 
            return view;
          }
          
          public void a(DialogFragment param1DialogFragment, View param1View) {
            if (param1View == null) {
              this.a.J();
              return;
            } 
            if (param1View.getId() == this.a.ab.getId()) {
              FeedPostFragment.b(this.a);
              return;
            } 
            if (param1View.getId() == this.a.L.getId() || param1View.getId() == this.a.Q.getId() || param1View.getId() == this.a.U.getId()) {
              param1View.callOnClick();
              return;
            } 
            param1View.callOnClick();
          }
        });
  }
  
  public void H() {
    this.ah.c();
    if (A()) {
      this.ag.setVisibility(8);
    } else {
      this.ag.setVisibility(0);
    } 
    U();
  }
  
  public void I() {
    SelectPhotoManager.a().d();
    ChildPhotoManager.a().d();
  }
  
  protected void J() {
    a(new Runnable(this) {
          public void run() {
            if (this.a.w_().isActive()) {
              FeedPostFragment.n(this.a);
              KeyboardUtils.c((Activity)this.a.getActivity());
              this.a.ae.setVisibility(8);
            } 
          }
        },  150L);
  }
  
  public boolean V_() {
    if (this.ad.getVisibility() == 0) {
      this.ad.setVisibility(8);
      this.ab.setImageDrawable(BluedSkinUtils.b(this.e, 2131232207));
      return true;
    } 
    x();
    return true;
  }
  
  protected void a(String paramString) {
    CharSequence charSequence = StringUtils.a(paramString, (int)this.r.getTextSize(), 3);
    charSequence = StringUtils.a(MarkDownLinkHelper.a(getContext(), charSequence, true, 2131100849), true, true, true, null, true, "", "");
    this.r.setText(charSequence);
    EmojiEditText emojiEditText = this.r;
    emojiEditText.setSelection(emojiEditText.length());
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.aj = false;
      if (this.ak) {
        this.ad.setVisibility(0);
        this.ab.setImageDrawable(BluedSkinUtils.b(this.e, 2131232209));
      } else {
        this.ab.setImageDrawable(BluedSkinUtils.b(this.e, 2131232207));
      } 
      this.ak = false;
      if (this.ad.getVisibility() != 0) {
        this.r.setCursorVisible(false);
        return;
      } 
    } else {
      this.aj = true;
      this.ad.setVisibility(8);
      this.r.setCursorVisible(true);
      this.ab.setImageDrawable(BluedSkinUtils.b(this.e, 2131232207));
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
      if (paramInt1 != 109) {
        if (paramInt1 != 110) {
          if (paramInt1 != 120) {
            if (paramInt1 == 9090)
              this.ai.a((EditText)this.r, paramIntent, this.aK); 
          } else if (paramIntent != null) {
            StvResultModel stvResultModel = (StvResultModel)paramIntent.getSerializableExtra("result_model");
            if (stvResultModel != null && stvResultModel.a()) {
              this.ax = true;
              this.ay = stvResultModel;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("VEDIO_SAVE_SUCCESS,stvResultModel firstimage");
              stringBuilder.append(this.ay.c());
              Log.d("chenjiemei", stringBuilder.toString());
              a(new Runnable(this) {
                    public void run() {
                      this.a.w();
                    }
                  });
              StatisticsProxy.a().a("sv_music_used", stvResultModel.j());
              StatisticsProxy.a().a("sv_filter_used", stvResultModel.k());
              int i = this.aI;
              if (i == 5) {
                StatisticsProxy.a().a("feed_send_click", Integer.valueOf(0));
              } else if (i == 1) {
                StatisticsProxy.a().a("feed_send_click", Integer.valueOf(1));
              } 
            } 
          } 
        } else if (paramIntent != null) {
          String str = paramIntent.getStringExtra("voting_picture_path");
          if (!TextUtils.isEmpty(str)) {
            this.aB = true;
            this.aC = str;
            this.G.setVisibility(0);
            ImageLoader.d((IRequestHost)w_(), this.aC).a(2131232201).a(this.H);
          } 
        } 
      } else {
        a(paramIntent);
      }  
    if (paramInt1 == 109 || paramInt1 == 110 || paramInt1 == 9090)
      J(); 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    boolean bool = this.aj;
    int i = paramView.getId();
    Integer integer = Integer.valueOf(0);
    switch (i) {
      default:
        return;
      case 2131301186:
        if (this.ax && this.aA != null) {
          ab();
          return;
        } 
        w();
        return;
      case 2131298095:
        if (aa())
          return; 
        KeyboardUtils.a((Activity)getActivity());
        this.ad.setVisibility(8);
        EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_SEARCH_SHOW);
        FeedPostTopicDialogFragment.c.a(getFragmentManager()).a(new DialogInterface.OnDismissListener(this, bool) {
              public void onDismiss(DialogInterface param1DialogInterface) {
                FeedPostFragment.a(this.b, this.a);
              }
            });
        return;
      case 2131298088:
        KeyboardUtils.a((Activity)getActivity());
        this.ad.setVisibility(8);
        FeedPostReadAuthDialogFragment.a.a(getFragmentManager()).a(new DialogInterface.OnDismissListener(this, bool) {
              public void onDismiss(DialogInterface param1DialogInterface) {
                FeedPostFragment.a(this.b, this.a);
              }
            });
        return;
      case 2131298071:
        if (aa())
          return; 
        KeyboardUtils.a((Activity)getActivity());
        this.ad.setVisibility(8);
        FeedPostLocationDialogFragment.a.a(getFragmentManager()).a(new DialogInterface.OnDismissListener(this, bool) {
              public void onDismiss(DialogInterface param1DialogInterface) {
                FeedPostFragment.a(this.b, this.a);
              }
            });
        return;
      case 2131297972:
        EventTrackVote.a(VoteProtos.Event.VOTE_BTN_CLICK);
        if (aa())
          return; 
        if (this.ah.D() > 0 || this.ax || this.at || this.as) {
          AppMethods.d(2131756425);
          return;
        } 
        if (!z()) {
          v();
          return;
        } 
        return;
      case 2131297962:
        this.D.setVisibility(8);
        this.ax = false;
        H();
        ad();
        return;
      case 2131297930:
        this.aJ.f().setValue(null);
        return;
      case 2131297907:
        this.aJ.c().setValue(integer);
        this.aJ.d().setValue(integer);
        return;
      case 2131297891:
        if (aa())
          return; 
        if (!z()) {
          KeyboardUtils.a((Activity)getActivity());
          this.ad.setVisibility(8);
          if (!PopMenuUtils.a(this.e)) {
            if (C()) {
              ShortVideoProxy.e().b(this, 3, 109);
              return;
            } 
            ShortVideoProxy.e().b(this, 0, 109);
            this.aI = 5;
            return;
          } 
        } 
        return;
      case 2131297838:
        this.aJ.o().setValue("");
        this.aJ.b(null);
        this.aJ.c(null);
        return;
      case 2131297814:
        this.G.setVisibility(8);
        this.aB = false;
        this.aC = null;
        H();
        return;
      case 2131297812:
        EventTrackFeed.a(FeedProtos.Event.FEED_ADD_PHOTO, FeedProtos.AddType.ICON, E());
        if (aa())
          return; 
        Y();
        return;
      case 2131297753:
        if (this.ad.getVisibility() == 0) {
          KeyboardUtils.c((Activity)getActivity());
          return;
        } 
        if (this.aj) {
          this.ak = true;
          KeyboardUtils.a((Activity)getActivity());
          return;
        } 
        ag();
        return;
      case 2131297729:
        x();
        return;
      case 2131297690:
        this.r.getText().replace(this.r.getSelectionStart(), this.r.getSelectionEnd(), "");
        this.r.getText().insert(this.r.getSelectionStart(), "@");
        return;
      case 2131297576:
        if (aa())
          return; 
        if (this.ay != null && this.aA != null) {
          Bundle bundle = new Bundle();
          bundle.putSerializable("serializeble_data", (Serializable)this.aA);
          ShortVideoProxy.e().a(this, bundle, 0);
          return;
        } 
        if (this.ay != null) {
          ShortVideoProxy.e().a(this, this.ay.f(), this.ay.c(), 0);
          return;
        } 
        return;
      case 2131297500:
        break;
    } 
    if (aa())
      return; 
    Context context = this.e;
    String str = this.aC;
    BasePhotoFragment.a(context, new String[] { str }, 0, 0, null, null, null, str);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    this.ai = new AtChooseUserHelper(this.e);
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493126, paramViewGroup, false);
      this.aJ = (FeedPostViewModel)(new ViewModelProvider(getActivity().getViewModelStore(), (ViewModelProvider.Factory)new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()))).get(FeedPostViewModel.class);
      P();
      Q();
      R();
      T();
      S();
      L();
      M();
      N();
      O();
      K();
      u();
      t();
      getActivity().getWindow().setSoftInputMode(18);
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public void onDestroy() {
    super.onDestroy();
    SelectPhotoManager.a().d();
  }
  
  public void onResume() {
    super.onResume();
    H();
    af();
    U();
  }
  
  protected void t() {
    if (this.am != null || this.an != null || this.ao != null) {
      J();
      return;
    } 
    a(new Runnable(this) {
          public void run() {
            FeedPostFragment.a(this.a).e(this.a.f.getHeight());
            this.a.G();
          }
        });
  }
  
  protected void u() {
    if (this.av) {
      this.P.setVisibility(8);
      return;
    } 
    this.aJ.H();
    this.P.setVisibility(0);
  }
  
  protected void v() {
    PictureVoteEditFragment.a((Fragment)this, 110);
  }
  
  protected void w() {
    // Byte code:
    //   0: aload_0
    //   1: getfield r : Lcom/soft/blued/customview/emoji/view/EmojiEditText;
    //   4: invokevirtual getText : ()Landroid/text/Editable;
    //   7: invokestatic a : (Landroid/text/Editable;)Ljava/lang/String;
    //   10: astore #5
    //   12: aload_0
    //   13: invokevirtual y : ()Z
    //   16: istore_2
    //   17: ldc_w ''
    //   20: astore #6
    //   22: iload_2
    //   23: ifne -> 110
    //   26: aload #5
    //   28: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   31: ifne -> 99
    //   34: aload_0
    //   35: getfield e : Landroid/content/Context;
    //   38: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   41: ldc_w 2131757864
    //   44: invokevirtual getString : (I)Ljava/lang/String;
    //   47: astore_3
    //   48: new java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: astore #4
    //   57: aload #4
    //   59: aload_0
    //   60: getfield s : Lcom/soft/blued/customview/EditInputNumView;
    //   63: invokevirtual getEditMaxLength : ()I
    //   66: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #4
    //   72: ldc_w ''
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: iconst_1
    //   81: anewarray java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload #4
    //   88: invokevirtual toString : ()Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   95: invokestatic a : (Ljava/lang/CharSequence;)V
    //   98: return
    //   99: aload_0
    //   100: ldc_w 2131758687
    //   103: invokevirtual getString : (I)Ljava/lang/String;
    //   106: invokestatic a : (Ljava/lang/CharSequence;)V
    //   109: return
    //   110: aload #5
    //   112: astore #4
    //   114: aload #5
    //   116: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   119: ifne -> 319
    //   122: aload_0
    //   123: getfield s : Lcom/soft/blued/customview/EditInputNumView;
    //   126: invokevirtual a : ()Z
    //   129: ifeq -> 197
    //   132: aload_0
    //   133: getfield e : Landroid/content/Context;
    //   136: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   139: ldc_w 2131757864
    //   142: invokevirtual getString : (I)Ljava/lang/String;
    //   145: astore_3
    //   146: new java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial <init> : ()V
    //   153: astore #4
    //   155: aload #4
    //   157: aload_0
    //   158: getfield s : Lcom/soft/blued/customview/EditInputNumView;
    //   161: invokevirtual getEditMaxLength : ()I
    //   164: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload #4
    //   170: ldc_w ''
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_3
    //   178: iconst_1
    //   179: anewarray java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: aload #4
    //   186: invokevirtual toString : ()Ljava/lang/String;
    //   189: aastore
    //   190: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   193: invokestatic a : (Ljava/lang/CharSequence;)V
    //   196: return
    //   197: aload #5
    //   199: astore_3
    //   200: aload #5
    //   202: aload_0
    //   203: getfield au : Ljava/lang/String;
    //   206: invokevirtual equals : (Ljava/lang/Object;)Z
    //   209: ifeq -> 240
    //   212: new java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial <init> : ()V
    //   219: astore_3
    //   220: aload_3
    //   221: ldc_w '转发动态'
    //   224: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_3
    //   229: aload #5
    //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_3
    //   236: invokevirtual toString : ()Ljava/lang/String;
    //   239: astore_3
    //   240: invokestatic a : ()Lcom/soft/blued/ui/feed/manager/FeedSendManager;
    //   243: invokevirtual c : ()Landroidx/collection/ArrayMap;
    //   246: astore #5
    //   248: aload #5
    //   250: invokevirtual keySet : ()Ljava/util/Set;
    //   253: invokeinterface iterator : ()Ljava/util/Iterator;
    //   258: astore #7
    //   260: aload_3
    //   261: astore #4
    //   263: aload #7
    //   265: invokeinterface hasNext : ()Z
    //   270: ifeq -> 319
    //   273: aload #7
    //   275: invokeinterface next : ()Ljava/lang/Object;
    //   280: checkcast java/lang/String
    //   283: astore #4
    //   285: aload_3
    //   286: aload #4
    //   288: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   291: ifeq -> 260
    //   294: aload_3
    //   295: aload #4
    //   297: aload #4
    //   299: aload #5
    //   301: aload #4
    //   303: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast java/lang/String
    //   309: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   312: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   315: astore_3
    //   316: goto -> 260
    //   319: new com/soft/blued/db/model/NewFeedModel
    //   322: dup
    //   323: invokespecial <init> : ()V
    //   326: astore #5
    //   328: aload_0
    //   329: getfield af : Landroid/widget/CheckBox;
    //   332: invokevirtual isChecked : ()Z
    //   335: ifeq -> 347
    //   338: aload #5
    //   340: iconst_1
    //   341: putfield repost_also_comment : I
    //   344: goto -> 353
    //   347: aload #5
    //   349: iconst_0
    //   350: putfield repost_also_comment : I
    //   353: aload #5
    //   355: aload_0
    //   356: getfield ai : Lcom/soft/blued/utils/AtChooseUserHelper;
    //   359: aload #4
    //   361: invokevirtual b : (Ljava/lang/String;)Ljava/lang/String;
    //   364: invokevirtual setContent : (Ljava/lang/String;)V
    //   367: aload #5
    //   369: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
    //   372: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
    //   375: invokevirtual getUid : ()Ljava/lang/String;
    //   378: invokestatic parseLong : (Ljava/lang/String;)J
    //   381: invokevirtual setLoadName : (J)V
    //   384: aload #5
    //   386: aload_0
    //   387: getfield aJ : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   390: invokevirtual o : ()Landroidx/lifecycle/MutableLiveData;
    //   393: invokevirtual getValue : ()Ljava/lang/Object;
    //   396: checkcast java/lang/String
    //   399: putfield address : Ljava/lang/String;
    //   402: aload #5
    //   404: aload_0
    //   405: getfield aJ : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   408: invokevirtual p : ()Ljava/lang/String;
    //   411: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   414: invokevirtual setLat : (Ljava/lang/String;)V
    //   417: aload #5
    //   419: aload_0
    //   420: getfield aJ : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   423: invokevirtual q : ()Ljava/lang/String;
    //   426: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   429: invokevirtual setLng : (Ljava/lang/String;)V
    //   432: aload #5
    //   434: aload_0
    //   435: getfield aJ : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   438: invokevirtual c : ()Landroidx/lifecycle/MutableLiveData;
    //   441: invokevirtual getValue : ()Ljava/lang/Object;
    //   444: checkcast java/lang/Integer
    //   447: invokevirtual intValue : ()I
    //   450: putfield reading_scope : I
    //   453: aload #5
    //   455: aload_0
    //   456: getfield aJ : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   459: invokevirtual d : ()Landroidx/lifecycle/MutableLiveData;
    //   462: invokevirtual getValue : ()Ljava/lang/Object;
    //   465: checkcast java/lang/Integer
    //   468: invokevirtual intValue : ()I
    //   471: putfield allow_comments : I
    //   474: aload_0
    //   475: getfield ar : I
    //   478: ifne -> 581
    //   481: aload_0
    //   482: getfield ao : Lcom/soft/blued/ui/share_custom/Model/ShareEntity;
    //   485: ifnull -> 581
    //   488: aload #5
    //   490: iconst_1
    //   491: putfield is_url : I
    //   494: new com/soft/blued/ui/feed/model/FeedExtra
    //   497: dup
    //   498: invokespecial <init> : ()V
    //   501: astore_3
    //   502: aload_3
    //   503: aload_0
    //   504: getfield ao : Lcom/soft/blued/ui/share_custom/Model/ShareEntity;
    //   507: getfield linkUrl : Ljava/lang/String;
    //   510: putfield url : Ljava/lang/String;
    //   513: aload_3
    //   514: getfield url : Ljava/lang/String;
    //   517: invokestatic e : (Ljava/lang/String;)Z
    //   520: ifne -> 547
    //   523: aload_3
    //   524: getfield url : Ljava/lang/String;
    //   527: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   530: ifnull -> 547
    //   533: aload_3
    //   534: aload_3
    //   535: getfield url : Ljava/lang/String;
    //   538: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   541: invokevirtual getHost : ()Ljava/lang/String;
    //   544: putfield domain : Ljava/lang/String;
    //   547: aload_3
    //   548: aload_0
    //   549: getfield ao : Lcom/soft/blued/ui/share_custom/Model/ShareEntity;
    //   552: getfield title : Ljava/lang/String;
    //   555: putfield title : Ljava/lang/String;
    //   558: aload_3
    //   559: aload_0
    //   560: getfield ao : Lcom/soft/blued/ui/share_custom/Model/ShareEntity;
    //   563: getfield content : Ljava/lang/String;
    //   566: putfield description : Ljava/lang/String;
    //   569: aload #5
    //   571: invokestatic f : ()Lcom/google/gson/Gson;
    //   574: aload_3
    //   575: invokevirtual toJson : (Ljava/lang/Object;)Ljava/lang/String;
    //   578: putfield extraJSON : Ljava/lang/String;
    //   581: aload_0
    //   582: getfield ax : Z
    //   585: ifeq -> 707
    //   588: aload_0
    //   589: getfield ay : Lcom/blued/android/module/base/shortvideo/StvResultModel;
    //   592: astore_3
    //   593: aload_3
    //   594: ifnull -> 707
    //   597: aload #5
    //   599: aload_3
    //   600: invokevirtual f : ()Ljava/lang/String;
    //   603: putfield videoPath : Ljava/lang/String;
    //   606: aload #5
    //   608: aload_0
    //   609: getfield ay : Lcom/blued/android/module/base/shortvideo/StvResultModel;
    //   612: invokevirtual f : ()Ljava/lang/String;
    //   615: putfield localVideoPath : Ljava/lang/String;
    //   618: aload #5
    //   620: iconst_1
    //   621: putfield isVideo : I
    //   624: aload #5
    //   626: aload_0
    //   627: getfield ay : Lcom/blued/android/module/base/shortvideo/StvResultModel;
    //   630: invokevirtual c : ()Ljava/lang/String;
    //   633: putfield localPath : Ljava/lang/String;
    //   636: aload #5
    //   638: aload_0
    //   639: getfield ay : Lcom/blued/android/module/base/shortvideo/StvResultModel;
    //   642: invokevirtual c : ()Ljava/lang/String;
    //   645: invokevirtual setPics : (Ljava/lang/String;)V
    //   648: aload #5
    //   650: iconst_1
    //   651: invokevirtual setSize : (I)V
    //   654: aload #5
    //   656: aload_0
    //   657: getfield ay : Lcom/blued/android/module/base/shortvideo/StvResultModel;
    //   660: invokevirtual e : ()J
    //   663: putfield videoSize : J
    //   666: aload #5
    //   668: aload_0
    //   669: getfield ay : Lcom/blued/android/module/base/shortvideo/StvResultModel;
    //   672: invokevirtual d : ()J
    //   675: l2f
    //   676: ldc_w 1000.0
    //   679: fdiv
    //   680: putfield duration : F
    //   683: aload #5
    //   685: aload_0
    //   686: getfield az : Ljava/lang/String;
    //   689: putfield videoTaskID : Ljava/lang/String;
    //   692: aload #5
    //   694: aload_0
    //   695: getfield ay : Lcom/blued/android/module/base/shortvideo/StvResultModel;
    //   698: invokevirtual j : ()Ljava/lang/String;
    //   701: putfield music_id : Ljava/lang/String;
    //   704: goto -> 905
    //   707: aload_0
    //   708: getfield aB : Z
    //   711: ifeq -> 756
    //   714: aload_0
    //   715: getfield aC : Ljava/lang/String;
    //   718: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   721: ifne -> 756
    //   724: aload #5
    //   726: iconst_1
    //   727: putfield is_vote : I
    //   730: aload_0
    //   731: getfield aC : Ljava/lang/String;
    //   734: astore_3
    //   735: aload #5
    //   737: aload_3
    //   738: putfield localPath : Ljava/lang/String;
    //   741: aload #5
    //   743: aload_3
    //   744: invokevirtual setPics : (Ljava/lang/String;)V
    //   747: aload #5
    //   749: iconst_1
    //   750: invokevirtual setSize : (I)V
    //   753: goto -> 905
    //   756: new java/lang/StringBuffer
    //   759: dup
    //   760: invokespecial <init> : ()V
    //   763: astore_3
    //   764: aload_0
    //   765: getfield ah : Lcom/soft/blued/ui/feed/adapter/FeedPostImageAdapter;
    //   768: invokevirtual n : ()Ljava/util/List;
    //   771: astore #4
    //   773: iconst_0
    //   774: istore_1
    //   775: iload_1
    //   776: aload #4
    //   778: invokeinterface size : ()I
    //   783: if_icmpge -> 884
    //   786: iload_1
    //   787: ifne -> 809
    //   790: aload #5
    //   792: aload #4
    //   794: iload_1
    //   795: invokeinterface get : (I)Ljava/lang/Object;
    //   800: checkcast com/soft/blued/ui/feed/model/ChildImageInfo
    //   803: getfield mImagePath : Ljava/lang/String;
    //   806: putfield localPath : Ljava/lang/String;
    //   809: aload #4
    //   811: iload_1
    //   812: invokeinterface get : (I)Ljava/lang/Object;
    //   817: checkcast com/soft/blued/ui/feed/model/ChildImageInfo
    //   820: getfield mImagePath : Ljava/lang/String;
    //   823: invokestatic e : (Ljava/lang/String;)Z
    //   826: ifne -> 877
    //   829: new java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial <init> : ()V
    //   836: astore #7
    //   838: aload #7
    //   840: aload #4
    //   842: iload_1
    //   843: invokeinterface get : (I)Ljava/lang/Object;
    //   848: checkcast com/soft/blued/ui/feed/model/ChildImageInfo
    //   851: getfield mImagePath : Ljava/lang/String;
    //   854: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload #7
    //   860: ldc_w ';'
    //   863: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload_3
    //   868: aload #7
    //   870: invokevirtual toString : ()Ljava/lang/String;
    //   873: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   876: pop
    //   877: iload_1
    //   878: iconst_1
    //   879: iadd
    //   880: istore_1
    //   881: goto -> 775
    //   884: aload #5
    //   886: aload_3
    //   887: invokevirtual toString : ()Ljava/lang/String;
    //   890: invokevirtual setPics : (Ljava/lang/String;)V
    //   893: aload #5
    //   895: aload #4
    //   897: invokeinterface size : ()I
    //   902: invokevirtual setSize : (I)V
    //   905: aload #5
    //   907: iconst_1
    //   908: invokevirtual setState : (I)V
    //   911: aload #5
    //   913: invokestatic currentTimeMillis : ()J
    //   916: invokevirtual setTime : (J)V
    //   919: aload_0
    //   920: getfield am : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   923: astore_3
    //   924: aload_3
    //   925: ifnull -> 1234
    //   928: aload_3
    //   929: getfield repost : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   932: astore_3
    //   933: aload_3
    //   934: ifnull -> 1344
    //   937: aload_3
    //   938: getfield is_share_circle : I
    //   941: iconst_1
    //   942: if_icmpne -> 1065
    //   945: aload #5
    //   947: aload_0
    //   948: getfield am : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   951: getfield feed_id : Ljava/lang/String;
    //   954: putfield feed_id : Ljava/lang/String;
    //   957: aload #5
    //   959: aload_0
    //   960: getfield am : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   963: getfield feed_id : Ljava/lang/String;
    //   966: putfield share_posting_id : Ljava/lang/String;
    //   969: aload #5
    //   971: iconst_0
    //   972: putfield is_repost : I
    //   975: aload #5
    //   977: aload_3
    //   978: getfield circle_title : Ljava/lang/String;
    //   981: putfield forwardName : Ljava/lang/String;
    //   984: aload #5
    //   986: aload_3
    //   987: getfield feed_pure_content : Ljava/lang/String;
    //   990: putfield forwardContent : Ljava/lang/String;
    //   993: aload_3
    //   994: getfield is_video_posts : I
    //   997: iconst_1
    //   998: if_icmpne -> 1030
    //   1001: aload_3
    //   1002: getfield feed_videos : [Ljava/lang/String;
    //   1005: ifnull -> 1030
    //   1008: aload_3
    //   1009: getfield feed_videos : [Ljava/lang/String;
    //   1012: arraylength
    //   1013: ifle -> 1030
    //   1016: aload #5
    //   1018: aload_3
    //   1019: getfield feed_videos : [Ljava/lang/String;
    //   1022: iconst_0
    //   1023: aaload
    //   1024: putfield forwardImage : Ljava/lang/String;
    //   1027: goto -> 1056
    //   1030: aload_3
    //   1031: getfield feed_pics : [Ljava/lang/String;
    //   1034: ifnull -> 1056
    //   1037: aload_3
    //   1038: getfield feed_pics : [Ljava/lang/String;
    //   1041: arraylength
    //   1042: ifle -> 1056
    //   1045: aload #5
    //   1047: aload_3
    //   1048: getfield feed_pics : [Ljava/lang/String;
    //   1051: iconst_0
    //   1052: aaload
    //   1053: putfield forwardImage : Ljava/lang/String;
    //   1056: aload #5
    //   1058: iconst_1
    //   1059: putfield isForwardHeader : I
    //   1062: goto -> 1344
    //   1065: aload_3
    //   1066: getfield is_share_posting : I
    //   1069: iconst_1
    //   1070: if_icmpne -> 1136
    //   1073: aload #5
    //   1075: aload_0
    //   1076: getfield am : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   1079: getfield feed_id : Ljava/lang/String;
    //   1082: putfield feed_id : Ljava/lang/String;
    //   1085: aload #5
    //   1087: aload_3
    //   1088: getfield feed_id : Ljava/lang/String;
    //   1091: putfield share_posting_id : Ljava/lang/String;
    //   1094: aload #5
    //   1096: iconst_1
    //   1097: putfield is_repost : I
    //   1100: aload #5
    //   1102: aload_3
    //   1103: getfield share_circle_title : Ljava/lang/String;
    //   1106: putfield forwardName : Ljava/lang/String;
    //   1109: aload #5
    //   1111: aload_3
    //   1112: getfield share_circle_posting_content : Ljava/lang/String;
    //   1115: putfield forwardContent : Ljava/lang/String;
    //   1118: aload #5
    //   1120: aload_3
    //   1121: getfield share_circle_posting_pic : Ljava/lang/String;
    //   1124: putfield forwardImage : Ljava/lang/String;
    //   1127: aload #5
    //   1129: iconst_1
    //   1130: putfield isForwardHeader : I
    //   1133: goto -> 1344
    //   1136: aload #5
    //   1138: aload_0
    //   1139: getfield am : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   1142: getfield feed_id : Ljava/lang/String;
    //   1145: putfield feed_id : Ljava/lang/String;
    //   1148: aload #5
    //   1150: iconst_1
    //   1151: putfield is_repost : I
    //   1154: aload #5
    //   1156: aload_3
    //   1157: getfield is_ads : I
    //   1160: putfield is_ads : I
    //   1163: aload #5
    //   1165: aload_3
    //   1166: getfield user_name : Ljava/lang/String;
    //   1169: putfield forwardName : Ljava/lang/String;
    //   1172: aload #5
    //   1174: aload_3
    //   1175: getfield feed_content : Ljava/lang/String;
    //   1178: putfield forwardContent : Ljava/lang/String;
    //   1181: aload_3
    //   1182: getfield feed_pics : [Ljava/lang/String;
    //   1185: ifnull -> 1216
    //   1188: aload_3
    //   1189: getfield feed_pics : [Ljava/lang/String;
    //   1192: arraylength
    //   1193: ifle -> 1216
    //   1196: aload #5
    //   1198: aload_3
    //   1199: getfield feed_pics : [Ljava/lang/String;
    //   1202: iconst_0
    //   1203: aaload
    //   1204: putfield forwardImage : Ljava/lang/String;
    //   1207: aload #5
    //   1209: iconst_1
    //   1210: putfield isForwardHeader : I
    //   1213: goto -> 1344
    //   1216: aload #5
    //   1218: aload_3
    //   1219: getfield user_avatar : Ljava/lang/String;
    //   1222: putfield forwardImage : Ljava/lang/String;
    //   1225: aload #5
    //   1227: iconst_0
    //   1228: putfield isForwardHeader : I
    //   1231: goto -> 1344
    //   1234: aload_0
    //   1235: getfield an : Lcom/soft/blued/db/model/NewFeedModel;
    //   1238: astore_3
    //   1239: aload_3
    //   1240: ifnull -> 1344
    //   1243: aload #5
    //   1245: aload_3
    //   1246: getfield feed_id : Ljava/lang/String;
    //   1249: putfield feed_id : Ljava/lang/String;
    //   1252: aload #5
    //   1254: aload_0
    //   1255: getfield an : Lcom/soft/blued/db/model/NewFeedModel;
    //   1258: getfield is_repost : I
    //   1261: putfield is_repost : I
    //   1264: aload #5
    //   1266: aload_0
    //   1267: getfield an : Lcom/soft/blued/db/model/NewFeedModel;
    //   1270: getfield forwardName : Ljava/lang/String;
    //   1273: putfield forwardName : Ljava/lang/String;
    //   1276: aload #5
    //   1278: aload_0
    //   1279: getfield an : Lcom/soft/blued/db/model/NewFeedModel;
    //   1282: getfield forwardContent : Ljava/lang/String;
    //   1285: putfield forwardContent : Ljava/lang/String;
    //   1288: aload #5
    //   1290: aload_0
    //   1291: getfield an : Lcom/soft/blued/db/model/NewFeedModel;
    //   1294: getfield forwardImage : Ljava/lang/String;
    //   1297: putfield forwardImage : Ljava/lang/String;
    //   1300: aload #5
    //   1302: aload_0
    //   1303: getfield an : Lcom/soft/blued/db/model/NewFeedModel;
    //   1306: getfield is_ads : I
    //   1309: putfield is_ads : I
    //   1312: aload #5
    //   1314: aload_0
    //   1315: getfield an : Lcom/soft/blued/db/model/NewFeedModel;
    //   1318: getfield share_posting_id : Ljava/lang/String;
    //   1321: putfield share_posting_id : Ljava/lang/String;
    //   1324: invokestatic a : ()Lcom/soft/blued/db/NewFeedDao;
    //   1327: aload_0
    //   1328: getfield an : Lcom/soft/blued/db/model/NewFeedModel;
    //   1331: invokevirtual c : (Lcom/soft/blued/db/model/NewFeedModel;)V
    //   1334: invokestatic a : ()Lcom/soft/blued/ui/feed/manager/FeedSendManager;
    //   1337: aload_0
    //   1338: getfield an : Lcom/soft/blued/db/model/NewFeedModel;
    //   1341: invokevirtual c : (Lcom/soft/blued/db/model/NewFeedModel;)V
    //   1344: aload_0
    //   1345: getfield aJ : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   1348: invokevirtual G : ()Z
    //   1351: ifeq -> 1414
    //   1354: aload #5
    //   1356: iconst_1
    //   1357: putfield is_super_topics : I
    //   1360: aload #5
    //   1362: aload_0
    //   1363: getfield aJ : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   1366: invokevirtual f : ()Landroidx/lifecycle/MutableLiveData;
    //   1369: invokevirtual getValue : ()Ljava/lang/Object;
    //   1372: checkcast com/soft/blued/ui/feed/model/BluedTopic
    //   1375: getfield super_did : Ljava/lang/String;
    //   1378: putfield super_did : Ljava/lang/String;
    //   1381: aload #5
    //   1383: aload_0
    //   1384: getfield aJ : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   1387: invokevirtual f : ()Landroidx/lifecycle/MutableLiveData;
    //   1390: invokevirtual getValue : ()Ljava/lang/Object;
    //   1393: checkcast com/soft/blued/ui/feed/model/BluedTopic
    //   1396: getfield name : Ljava/lang/String;
    //   1399: putfield super_topics_name : Ljava/lang/String;
    //   1402: aload #5
    //   1404: aload_0
    //   1405: getfield aJ : Lcom/soft/blued/ui/feed/vm/FeedPostViewModel;
    //   1408: invokevirtual g : ()Ljava/lang/String;
    //   1411: putfield super_topics_avatar : Ljava/lang/String;
    //   1414: aload_0
    //   1415: getfield aw : Z
    //   1418: ifeq -> 1439
    //   1421: aload #5
    //   1423: iconst_1
    //   1424: putfield is_share_super_topics : I
    //   1427: aload #5
    //   1429: aload_0
    //   1430: getfield ap : Lcom/soft/blued/ui/feed/model/BluedTopic;
    //   1433: getfield super_did : Ljava/lang/String;
    //   1436: putfield share_s_t_did : Ljava/lang/String;
    //   1439: aload #5
    //   1441: getfield is_vote : I
    //   1444: iconst_1
    //   1445: if_icmpne -> 1460
    //   1448: getstatic com/blued/das/client/vote/VoteProtos$Event.VOTE_PUBLISH_BTN_CLICK : Lcom/blued/das/client/vote/VoteProtos$Event;
    //   1451: getstatic com/blued/das/client/vote/VoteProtos$FeedType.VOTE : Lcom/blued/das/client/vote/VoteProtos$FeedType;
    //   1454: invokestatic a : (Lcom/blued/das/client/vote/VoteProtos$Event;Lcom/blued/das/client/vote/VoteProtos$FeedType;)V
    //   1457: goto -> 1469
    //   1460: getstatic com/blued/das/client/vote/VoteProtos$Event.VOTE_PUBLISH_BTN_CLICK : Lcom/blued/das/client/vote/VoteProtos$Event;
    //   1463: getstatic com/blued/das/client/vote/VoteProtos$FeedType.COMMON : Lcom/blued/das/client/vote/VoteProtos$FeedType;
    //   1466: invokestatic a : (Lcom/blued/das/client/vote/VoteProtos$Event;Lcom/blued/das/client/vote/VoteProtos$FeedType;)V
    //   1469: getstatic com/blued/das/client/feed/FeedProtos$Event.FEED_PUBLISH_CONFIRM_BTN_CLICK : Lcom/blued/das/client/feed/FeedProtos$Event;
    //   1472: astore #7
    //   1474: aload #5
    //   1476: getfield is_super_topics : I
    //   1479: iconst_1
    //   1480: if_icmpne -> 1490
    //   1483: getstatic com/blued/das/client/feed/FeedProtos$FeedType.SUPER_TOPIC : Lcom/blued/das/client/feed/FeedProtos$FeedType;
    //   1486: astore_3
    //   1487: goto -> 1494
    //   1490: getstatic com/blued/das/client/feed/FeedProtos$FeedType.COMMON : Lcom/blued/das/client/feed/FeedProtos$FeedType;
    //   1493: astore_3
    //   1494: aload #5
    //   1496: getfield super_did : Ljava/lang/String;
    //   1499: astore #8
    //   1501: aload_0
    //   1502: getfield ay : Lcom/blued/android/module/base/shortvideo/StvResultModel;
    //   1505: astore #9
    //   1507: aload #6
    //   1509: astore #4
    //   1511: aload #9
    //   1513: ifnull -> 1523
    //   1516: aload #9
    //   1518: invokevirtual j : ()Ljava/lang/String;
    //   1521: astore #4
    //   1523: aload #7
    //   1525: aload_3
    //   1526: aload #8
    //   1528: aload #4
    //   1530: aload_0
    //   1531: getfield af : Landroid/widget/CheckBox;
    //   1534: invokevirtual isChecked : ()Z
    //   1537: invokestatic a : (Lcom/blued/das/client/feed/FeedProtos$Event;Lcom/blued/das/client/feed/FeedProtos$FeedType;Ljava/lang/String;Ljava/lang/String;Z)V
    //   1540: aload_0
    //   1541: getfield aG : Z
    //   1544: ifeq -> 1553
    //   1547: aload #5
    //   1549: iconst_1
    //   1550: putfield is_attention_show_dot : I
    //   1553: invokestatic a : ()Lcom/soft/blued/db/NewFeedDao;
    //   1556: aload #5
    //   1558: invokevirtual a : (Lcom/soft/blued/db/model/NewFeedModel;)V
    //   1561: invokestatic a : ()Lcom/soft/blued/manager/SendNotificationManager;
    //   1564: aload_0
    //   1565: getfield aH : Z
    //   1568: putfield b : Z
    //   1571: invokestatic a : ()Lcom/soft/blued/ui/feed/manager/FeedSendManager;
    //   1574: aload #5
    //   1576: invokevirtual a : (Lcom/soft/blued/db/model/NewFeedModel;)V
    //   1579: aload #5
    //   1581: invokevirtual getSize : ()I
    //   1584: ifle -> 1600
    //   1587: ldc_w 'feed_send_click'
    //   1590: iconst_2
    //   1591: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1594: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   1597: goto -> 1622
    //   1600: aload_0
    //   1601: getfield y : Landroid/widget/LinearLayout;
    //   1604: invokevirtual getVisibility : ()I
    //   1607: bipush #8
    //   1609: if_icmpne -> 1622
    //   1612: ldc_w 'feed_send_click'
    //   1615: iconst_3
    //   1616: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1619: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;)V
    //   1622: aload_0
    //   1623: invokevirtual I : ()V
    //   1626: aload_0
    //   1627: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   1630: invokestatic a : (Landroid/app/Activity;)V
    //   1633: new android/content/Intent
    //   1636: dup
    //   1637: invokespecial <init> : ()V
    //   1640: astore_3
    //   1641: aload_3
    //   1642: ldc_w 'close_page'
    //   1645: iconst_1
    //   1646: invokevirtual putExtra : (Ljava/lang/String;Z)Landroid/content/Intent;
    //   1649: pop
    //   1650: aload_0
    //   1651: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   1654: iconst_m1
    //   1655: aload_3
    //   1656: invokevirtual setResult : (ILandroid/content/Intent;)V
    //   1659: aload_0
    //   1660: invokevirtual getActivity : ()Landroidx/fragment/app/FragmentActivity;
    //   1663: invokevirtual finish : ()V
    //   1666: return
  }
  
  protected void x() {
    CommonAlertDialog.a((Context)getActivity(), getResources().getString(2131756931), getResources().getString(2131758215), getResources().getString(2131756127), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {}
        },  getResources().getString(2131756598), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.I();
            this.a.a(new Runnable(this) {
                  public void run() {
                    this.a.a.getActivity().finish();
                  }
                },  200L);
          }
        }null);
  }
  
  public boolean y() {
    if (this.s.a())
      return false; 
    NewFeedModel newFeedModel = this.an;
    return (newFeedModel != null && newFeedModel.is_share_super_topics == 1) ? true : (!TextUtils.isEmpty(this.r.getText().toString().trim()) ? true : (this.ah.B() ? true : ((this.ax && this.ay != null) ? true : ((this.aB && !TextUtils.isEmpty(this.aC)) ? true : (this.as ? true : (this.at ? (!this.av) : false))))));
  }
  
  public boolean z() {
    if (this.at || this.as || this.aw) {
      AppMethods.d(2131756427);
      return true;
    } 
    if (this.ax) {
      AppMethods.d(2131756428);
      return true;
    } 
    if (this.ah.D() >= 9) {
      AppMethods.a(String.format(getResources().getString(2131757865), new Object[] { Integer.valueOf(9) }));
      return true;
    } 
    if (this.aB) {
      AppMethods.d(2131756426);
      return true;
    } 
    return false;
  }
  
  public static interface ShareToFeedType {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\FeedPostFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */