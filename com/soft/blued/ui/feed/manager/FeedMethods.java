package com.soft.blued.ui.feed.manager;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.message.MessageProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.CenterAlignImageSpan;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.feed.model.BluedADExtra;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.IFeedDataObserver;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.util.ArrayList;
import java.util.Iterator;

public class FeedMethods {
  public static int a(int paramInt) {
    byte b = 4;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 4) {
          if (paramInt != 5)
            return (paramInt == 6) ? 1 : 0; 
        } else {
          return 0;
        } 
      } else {
        return 3;
      } 
    } else {
      b = 2;
    } 
    return b;
  }
  
  public static int a(Context paramContext, long paramLong) {
    return (paramLong != 0L) ? (int)((System.currentTimeMillis() - paramLong) / 3600000L) : 0;
  }
  
  public static SpannableStringBuilder a(BluedTopic paramBluedTopic, CharSequence paramCharSequence) {
    Drawable drawable;
    if (paramBluedTopic.is_new == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("new ");
      stringBuilder.append(paramCharSequence);
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
      drawable = AppInfo.d().getResources().getDrawable(2131232224);
      drawable.setBounds(0, 0, AppMethods.a(18), AppMethods.a(18));
      spannableStringBuilder.setSpan(new CenterAlignImageSpan(drawable), 0, 3, 33);
      return spannableStringBuilder;
    } 
    return new SpannableStringBuilder((CharSequence)drawable);
  }
  
  public static CharSequence a(Context paramContext, int paramInt1, FeedComment paramFeedComment, int paramInt2, int paramInt3) {
    return a(paramContext, paramInt1, paramFeedComment, 0, paramInt2, paramInt3);
  }
  
  public static CharSequence a(Context paramContext, int paramInt1, FeedComment paramFeedComment, int paramInt2, int paramInt3, int paramInt4) {
    if (!StringUtils.e(paramFeedComment.comment_id)) {
      String str1;
      if (paramFeedComment.reply_name != null) {
        str1 = paramFeedComment.reply_name.replace(":", "");
      } else {
        str1 = "";
      } 
      String str5 = paramFeedComment.comment_content;
      String str2 = paramFeedComment.reply_uid;
      String str3 = paramFeedComment.reply_avatar;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramContext.getResources().getString(2131758580));
      stringBuilder.append(" ");
      String str4 = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(str4);
      stringBuilder.append(str1);
      stringBuilder.append(": ");
      stringBuilder.append(str5);
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
      spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.toString().indexOf(str4), 17);
      try {
        int i = spannableStringBuilder.toString().indexOf(str4) + str4.length();
        paramInt2 = i;
        if (i >= spannableStringBuilder.toString().length())
          paramInt2 = spannableStringBuilder.toString().length() - 1; 
        str5 = spannableStringBuilder.toString().substring(paramInt2, spannableStringBuilder.toString().indexOf(":"));
        String str = a(paramInt3, 0);
        try {
          UserNameClickSpan userNameClickSpan = new UserNameClickSpan(paramContext, str5, str2, str1, str3, str, paramInt4);
          paramInt2 = spannableStringBuilder.toString().indexOf(str4) + str4.length();
          paramInt4 = spannableStringBuilder.toString().indexOf(":") + 1;
          spannableStringBuilder.setSpan(userNameClickSpan, paramInt2, paramInt4, 17);
          spannableStringBuilder.setSpan(new StyleSpan(1), paramInt2, paramInt4, 17);
        } catch (Exception null) {}
      } catch (Exception exception) {}
      exception.printStackTrace();
    } 
    return "";
  }
  
  public static String a() {
    return "feed_like_anim_752.png";
  }
  
  public static String a(int paramInt1, int paramInt2) {
    String str1;
    if (paramInt1 != 0) {
      if (paramInt1 != 2) {
        if (paramInt1 != 14) {
          if (paramInt1 != 4) {
            if (paramInt1 != 5) {
              if (paramInt1 != 6) {
                switch (paramInt1) {
                  default:
                    str1 = "";
                    break;
                  case 12:
                    str1 = "PAGE_FEED_LIKE";
                    break;
                  case 11:
                    str1 = "PAGE_FEED_MINE";
                    break;
                  case 10:
                    str1 = "feed_image";
                    break;
                } 
              } else {
                str1 = "feed_square";
              } 
            } else {
              str1 = "topic_detail";
            } 
          } else {
            str1 = "feed_nearby";
          } 
        } else {
          str1 = "PAGE_FEED_DETAIL_MORE";
        } 
      } else {
        str1 = "feed_detail";
      } 
    } else {
      str1 = "feed_followed";
    } 
    String str2 = str1;
    if (paramInt2 == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append("_vote");
      str2 = stringBuilder.toString();
    } 
    return str2;
  }
  
  public static String a(Context paramContext) {
    if (paramContext == null)
      return ""; 
    String[] arrayOfString = paramContext.getResources().getStringArray(2130903053);
    return arrayOfString[(int)(Math.random() * (arrayOfString.length - 1))];
  }
  
  public static String a(Context paramContext, int paramInt) {
    ArrayList arrayList = new ArrayList();
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt == 3)
          arrayList = BluedPreferences.bp(); 
      } else {
        arrayList = BluedPreferences.bo();
      } 
    } else {
      arrayList = BluedPreferences.bn();
    } 
    String str2 = "";
    String str1 = str2;
    if (arrayList != null) {
      str1 = str2;
      if (arrayList.size() > 0) {
        Iterator<BluedADExtra> iterator = arrayList.iterator();
        str1 = "";
        while (iterator.hasNext()) {
          BluedADExtra bluedADExtra = iterator.next();
          Long long_ = Long.valueOf(bluedADExtra.local_closed_time);
          int i = a(paramContext, long_.longValue());
          if ((long_.longValue() != 0L && i < bluedADExtra.close_time) || bluedADExtra.close_time == -1) {
            StringBuilder stringBuilder = new StringBuilder();
            if (StringUtils.e(str1)) {
              str1 = "";
            } else {
              str1 = ",";
            } 
            stringBuilder.append(str1);
            stringBuilder.append(bluedADExtra.ads_id);
            str1 = stringBuilder.toString();
            continue;
          } 
          iterator.remove();
        } 
        if (paramInt != 1) {
          if (paramInt != 2) {
            if (paramInt == 3)
              BluedPreferences.c(arrayList); 
          } else {
            BluedPreferences.b(arrayList);
          } 
        } else {
          BluedPreferences.a(arrayList);
        } 
      } 
    } 
    return str1;
  }
  
  public static void a(Context paramContext, int paramInt, ImageView paramImageView, TextView paramTextView) {
    if (paramInt != 1) {
      if (paramInt != 2) {
        paramImageView.setImageResource(2131232225);
        paramTextView.setText(paramContext.getString(2131756438));
        return;
      } 
      paramImageView.setImageResource(2131232227);
      paramTextView.setText(paramContext.getString(2131756459));
      return;
    } 
    paramImageView.setImageResource(2131232226);
    paramTextView.setText(paramContext.getString(2131756458));
  }
  
  public static void a(Context paramContext, TextView paramTextView, FeedComment paramFeedComment, String paramString, int paramInt) {
    String str2 = paramFeedComment.reply_name;
    String str4 = paramFeedComment.comment_content;
    String str3 = paramFeedComment.reply_uid;
    String str1 = paramFeedComment.reply_avatar;
    String str5 = paramContext.getResources().getString(2131758580);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str5);
    stringBuilder.append(str2);
    stringBuilder.append(": ");
    stringBuilder.append(str4);
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder.toString());
    spannableStringBuilder.setSpan(new StyleSpan(1), spannableStringBuilder.toString().indexOf(str5) + str5.length(), spannableStringBuilder.toString().indexOf(":"), 17);
    spannableStringBuilder.setSpan(new UserNameClickSpan(paramContext, spannableStringBuilder.toString().substring(spannableStringBuilder.toString().indexOf(str5) + str5.length(), spannableStringBuilder.toString().indexOf(":")), str3, str2, str1, paramString, paramInt), spannableStringBuilder.toString().indexOf(str5) + str5.length(), spannableStringBuilder.toString().indexOf(":"), 17);
    TypefaceUtils.a(paramTextView, (CharSequence)spannableStringBuilder, 0, paramString);
  }
  
  public static void a(ImageView paramImageView, int paramInt) {
    if (paramImageView == null)
      return; 
    if (paramInt == 1) {
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2131232188);
      return;
    } 
    paramImageView.setVisibility(8);
  }
  
  public static void a(TextView paramTextView, FeedComment paramFeedComment, String paramString) {
    TypefaceUtils.a(paramTextView, paramFeedComment.comment_content, 0, paramString);
  }
  
  public static void a(FragmentActivity paramFragmentActivity, BluedIngSelfFeed paramBluedIngSelfFeed, IRequestHost paramIRequestHost) {
    // Byte code:
    //   0: invokestatic b : ()[I
    //   3: astore #4
    //   5: aload_0
    //   6: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   9: ldc_w 2130903070
    //   12: invokevirtual getStringArray : (I)[Ljava/lang/String;
    //   15: astore #5
    //   17: iconst_0
    //   18: istore_3
    //   19: iload_3
    //   20: aload #4
    //   22: arraylength
    //   23: if_icmpge -> 47
    //   26: aload #4
    //   28: iload_3
    //   29: iaload
    //   30: aload_1
    //   31: getfield reading_scope : I
    //   34: if_icmpne -> 40
    //   37: goto -> 49
    //   40: iload_3
    //   41: iconst_1
    //   42: iadd
    //   43: istore_3
    //   44: goto -> 19
    //   47: iconst_m1
    //   48: istore_3
    //   49: aload_0
    //   50: aload #5
    //   52: iload_3
    //   53: new com/soft/blued/ui/feed/manager/FeedMethods$13
    //   56: dup
    //   57: aload_0
    //   58: aload #4
    //   60: aload_1
    //   61: aload_2
    //   62: invokespecial <init> : (Landroidx/fragment/app/FragmentActivity;[ILcom/soft/blued/ui/feed/model/BluedIngSelfFeed;Lcom/blued/android/core/net/IRequestHost;)V
    //   65: invokestatic a : (Landroidx/fragment/app/FragmentActivity;[Ljava/lang/String;ILcom/soft/blued/customview/ActionSheet$ActionSheetListener;)Lcom/soft/blued/customview/ActionSheet;
    //   68: pop
    //   69: return
  }
  
  public static void a(LifecycleOwner paramLifecycleOwner, IFeedDataObserver paramIFeedDataObserver) {
    LiveEventBus.get("feed_delete", String.class).observe(paramLifecycleOwner, new Observer<String>(paramIFeedDataObserver) {
          public void a(String param1String) {
            if (param1String == null)
              return; 
            this.a.d(param1String);
          }
        });
    LiveEventBus.get("feed_comment_setting", BluedIngSelfFeed.class).observe(paramLifecycleOwner, new Observer<BluedIngSelfFeed>(paramIFeedDataObserver) {
          public void a(BluedIngSelfFeed param1BluedIngSelfFeed) {
            if (param1BluedIngSelfFeed == null)
              return; 
            this.a.a(param1BluedIngSelfFeed.feed_id, param1BluedIngSelfFeed.allow_comments);
          }
        });
    LiveEventBus.get("feed_read_setting", BluedIngSelfFeed.class).observe(paramLifecycleOwner, new Observer<BluedIngSelfFeed>(paramIFeedDataObserver) {
          public void a(BluedIngSelfFeed param1BluedIngSelfFeed) {
            if (param1BluedIngSelfFeed == null)
              return; 
            this.a.b(param1BluedIngSelfFeed.feed_id, param1BluedIngSelfFeed.reading_scope);
          }
        });
    LiveEventBus.get("feed_like_change", BluedIngSelfFeed.class).observe(paramLifecycleOwner, new Observer<BluedIngSelfFeed>(paramIFeedDataObserver) {
          public void a(BluedIngSelfFeed param1BluedIngSelfFeed) {
            if (param1BluedIngSelfFeed == null)
              return; 
            this.a.c(param1BluedIngSelfFeed.feed_id, param1BluedIngSelfFeed.iliked);
          }
        });
    LiveEventBus.get("feed_add_comment", FeedComment.class).observe(paramLifecycleOwner, new Observer<FeedComment>(paramIFeedDataObserver) {
          public void a(FeedComment param1FeedComment) {
            if (param1FeedComment == null)
              return; 
            this.a.a(param1FeedComment);
          }
        });
    LiveEventBus.get("feed_delete_comment", FeedComment.class).observe(paramLifecycleOwner, new Observer<FeedComment>(paramIFeedDataObserver) {
          public void a(FeedComment param1FeedComment) {
            if (param1FeedComment == null)
              return; 
            this.a.a(param1FeedComment.feed_id, param1FeedComment.comment_id);
          }
        });
    LiveEventBus.get("feed_add_repost", FeedRepost.class).observe(paramLifecycleOwner, new Observer<FeedRepost>(paramIFeedDataObserver) {
          public void a(FeedRepost param1FeedRepost) {
            if (param1FeedRepost == null)
              return; 
            this.a.a(param1FeedRepost);
          }
        });
    LiveEventBus.get("feed_delete_repost", String.class).observe(paramLifecycleOwner, new Observer<String>(paramIFeedDataObserver) {
          public void a(String param1String) {
            if (param1String == null)
              return; 
            this.a.e(param1String);
          }
        });
    LiveEventBus.get("feed_relation_ship", UserInfoEntity.class).observe(paramLifecycleOwner, new Observer<UserInfoEntity>(paramIFeedDataObserver) {
          public void a(UserInfoEntity param1UserInfoEntity) {
            if (param1UserInfoEntity == null)
              return; 
            this.a.b(param1UserInfoEntity.uid, param1UserInfoEntity.relationship);
          }
        });
    LiveEventBus.get("feed_vote_change", BluedIngSelfFeed.class).observe(paramLifecycleOwner, new Observer<BluedIngSelfFeed>(paramIFeedDataObserver) {
          public void a(BluedIngSelfFeed param1BluedIngSelfFeed) {
            if (param1BluedIngSelfFeed == null)
              return; 
            this.a.a(param1BluedIngSelfFeed);
          }
        });
    LiveEventBus.get("feed_dynamic_skin", Integer.class).observe(paramLifecycleOwner, new Observer<Integer>(paramIFeedDataObserver) {
          public void a(Integer param1Integer) {
            this.a.a(param1Integer.intValue());
          }
        });
    LiveEventBus.get("feed_avatar_widget", Integer.class).observe(paramLifecycleOwner, new Observer<Integer>(paramIFeedDataObserver) {
          public void a(Integer param1Integer) {
            this.a.b(param1Integer.intValue());
          }
        });
  }
  
  public static int[] a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean) {
    byte b;
    int i = DensityUtils.a(paramContext, 20.0F);
    int j = DensityUtils.a(paramContext, 4.0F);
    if (paramBoolean) {
      b = DensityUtils.a(paramContext, 20.0F);
    } else {
      b = 0;
    } 
    if (paramInt1 == paramInt2) {
      paramInt1 = (AppInfo.l - i - j * 2) * 2 / 3 + j - b;
      paramInt2 = paramInt1;
    } else if (paramInt1 < paramInt2) {
      paramInt1 = (AppInfo.l - i - j * 2) * 2 / 3 + j - b;
      paramInt2 = paramInt1 * 3 / 2;
    } else {
      paramInt1 = AppInfo.l - DensityUtils.a(paramContext, 20.0F) - b;
      paramInt2 = paramInt1 * 2 / 3;
    } 
    return new int[] { paramInt1, paramInt2 };
  }
  
  public static MessageProtos.StrangerSource b(int paramInt1, int paramInt2) {
    MessageProtos.StrangerSource strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
    if (paramInt1 != 2)
      if (paramInt1 != 10) {
        if (paramInt1 != 14)
          return (paramInt1 != 4) ? ((paramInt1 != 5) ? ((paramInt1 != 6) ? strangerSource : ((paramInt2 == 1) ? MessageProtos.StrangerSource.APPRECIATE_FIND : MessageProtos.StrangerSource.FEED_FIND_PLAZA)) : MessageProtos.StrangerSource.SUPER_TOPIC_DETAIL) : ((paramInt2 == 1) ? MessageProtos.StrangerSource.APPRECIATE_NEARBY : MessageProtos.StrangerSource.FIND_PLAZA_NEARBY); 
      } else {
        return MessageProtos.StrangerSource.FIND_PLAZA_IMAGE;
      }  
    return MessageProtos.StrangerSource.PAGE_FEED_DETAIL_MORE;
  }
  
  public static CharSequence b(Context paramContext, int paramInt1, FeedComment paramFeedComment, int paramInt2, int paramInt3) {
    if (!StringUtils.e(paramFeedComment.comment_id)) {
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(paramFeedComment.comment_content);
      spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.toString().indexOf(":") + 1, 17);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(spannableStringBuilder);
      stringBuilder.append("");
      return TextUtils.isEmpty(stringBuilder.toString()) ? "" : StringUtils.a(StringUtils.a(StringUtils.a((CharSequence)spannableStringBuilder, paramInt1, 1), true, true, false, null, true, "", a(paramInt2, 0)), true, new boolean[0]);
    } 
    return "";
  }
  
  public static void b(FragmentActivity paramFragmentActivity, BluedIngSelfFeed paramBluedIngSelfFeed, IRequestHost paramIRequestHost) {
    int j;
    String[] arrayOfString1 = paramFragmentActivity.getResources().getStringArray(2130903067);
    String[] arrayOfString2 = paramFragmentActivity.getResources().getStringArray(2130903068);
    byte b = 0;
    int i = 0;
    while (true) {
      j = b;
      if (i < arrayOfString2.length) {
        String str = arrayOfString2[i];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramBluedIngSelfFeed.allow_comments);
        stringBuilder.append("");
        if (str.equals(stringBuilder.toString())) {
          j = i;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    CommonShowBottomWindow.a(paramFragmentActivity, arrayOfString1, j, new ActionSheet.ActionSheetListener(arrayOfString2, paramFragmentActivity, paramBluedIngSelfFeed, paramIRequestHost) {
          public void a(ActionSheet param1ActionSheet, int param1Int) {
            param1Int = Integer.parseInt(this.a[param1Int]);
            Dialog dialog = DialogUtils.a((Context)this.b);
            FeedHttpUtils.a(this.c.feed_id, param1Int, new BluedUIHttpResponse<BluedEntity>(this, param1Int, dialog) {
                  public void onFailure(Throwable param2Throwable, int param2Int, String param2String) {
                    super.onFailure(param2Throwable, param2Int, param2String);
                    AppMethods.a(this.c.b.getResources().getString(2131758330));
                  }
                  
                  public void onUIFinish() {
                    super.onUIFinish();
                    DialogUtils.b(this.b);
                  }
                  
                  public void onUIStart() {
                    super.onUIStart();
                    DialogUtils.a(this.b);
                  }
                  
                  public void onUIUpdate(BluedEntity param2BluedEntity) {
                    AppMethods.a(this.c.b.getResources().getString(2131756206));
                    this.c.c.allow_comments = this.a;
                    LiveEventBus.get("feed_comment_setting").post(this.c.c);
                  }
                }this.d);
          }
          
          public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
        });
  }
  
  public static int[] b() {
    return new int[] { 0, 1, 2 };
  }
  
  public static CharSequence c(Context paramContext, int paramInt1, FeedComment paramFeedComment, int paramInt2, int paramInt3) {
    if (!StringUtils.e(paramFeedComment.comment_id)) {
      String str1;
      String str2;
      String str3;
      String str7 = paramFeedComment.note;
      if (paramFeedComment.user_name != null) {
        str2 = paramFeedComment.user_name.replace(":", "");
      } else {
        str2 = "";
      } 
      if (paramFeedComment.reply_name != null) {
        str3 = paramFeedComment.reply_name.replace(":", "");
      } else {
        str3 = "";
      } 
      String str10 = paramFeedComment.comment_content;
      String str4 = paramFeedComment.comment_uid;
      String str5 = paramFeedComment.reply_uid;
      String str6 = paramFeedComment.user_avatar;
      String str8 = paramFeedComment.reply_avatar;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(" ");
      stringBuilder2.append(paramContext.getResources().getString(2131758580));
      stringBuilder2.append(" ");
      String str9 = stringBuilder2.toString();
      if (!StringUtils.e(str7)) {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(StringUtils.a(str7, str2));
        stringBuilder2.append(str9);
        stringBuilder2.append(str3);
        stringBuilder2.append(": ");
        stringBuilder2.append(str10);
        str1 = stringBuilder2.toString();
      } else {
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str2);
        stringBuilder2.append(str9);
        stringBuilder2.append(str3);
        stringBuilder2.append(": ");
        stringBuilder2.append(str10);
        str1 = stringBuilder2.toString();
      } 
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str1);
      spannableStringBuilder.setSpan(new UserNameClickSpan(paramContext, spannableStringBuilder.toString().substring(0, spannableStringBuilder.toString().indexOf(str9)), str4, str2, str6, a(paramInt2, 0), paramInt3), 0, spannableStringBuilder.toString().indexOf(str9), 17);
      spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.toString().indexOf(str9), 17);
      try {
        int j = spannableStringBuilder.toString().indexOf(str9) + str9.length();
        int i = j;
        if (j >= spannableStringBuilder.toString().length())
          i = spannableStringBuilder.toString().length() - 1; 
        UserNameClickSpan userNameClickSpan = new UserNameClickSpan(paramContext, spannableStringBuilder.toString().substring(i, spannableStringBuilder.toString().indexOf(":")), str5, str3, str8, a(paramInt2, 0), paramInt3);
        paramInt3 = spannableStringBuilder.toString().indexOf(str9) + str9.length();
        i = spannableStringBuilder.toString().indexOf(":") + 1;
        spannableStringBuilder.setSpan(userNameClickSpan, paramInt3, i, 17);
        spannableStringBuilder.setSpan(new StyleSpan(1), paramInt3, i, 17);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(spannableStringBuilder);
      stringBuilder1.append("");
      return TextUtils.isEmpty(stringBuilder1.toString()) ? "" : StringUtils.a(StringUtils.a(StringUtils.a((CharSequence)spannableStringBuilder, paramInt1, 1), true, true, false, null, true, "", a(paramInt2, 0)), true, new boolean[0]);
    } 
    return "";
  }
  
  public static CharSequence d(Context paramContext, int paramInt1, FeedComment paramFeedComment, int paramInt2, int paramInt3) {
    if (!StringUtils.e(paramFeedComment.comment_id)) {
      String str1;
      String str2;
      String str5 = paramFeedComment.note;
      if (paramFeedComment.user_name != null) {
        str2 = paramFeedComment.user_name.replace(":", "");
      } else {
        str2 = "";
      } 
      String str6 = paramFeedComment.comment_content;
      String str3 = paramFeedComment.comment_uid;
      String str4 = paramFeedComment.user_avatar;
      if (!StringUtils.e(str5)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(StringUtils.a(str5, str2));
        stringBuilder1.append(": ");
        stringBuilder1.append(str6);
        str1 = stringBuilder1.toString();
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(": ");
        stringBuilder1.append(str6);
        str1 = stringBuilder1.toString();
      } 
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str1);
      spannableStringBuilder.setSpan(new UserNameClickSpan(paramContext, spannableStringBuilder.toString().substring(0, spannableStringBuilder.toString().indexOf(":") + 1), str3, str2, str4, a(paramInt2, 0), paramInt3), 0, spannableStringBuilder.toString().indexOf(":") + 1, 17);
      spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.toString().indexOf(":") + 1, 17);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(spannableStringBuilder);
      stringBuilder.append("");
      return TextUtils.isEmpty(stringBuilder.toString()) ? "" : StringUtils.a(StringUtils.a(StringUtils.a((CharSequence)spannableStringBuilder, paramInt1, 1), true, true, false, null, true, "", a(paramInt2, 0)), true, new boolean[0]);
    } 
    return "";
  }
  
  public static class UserNameClickSpan extends ClickableSpan {
    Context a;
    
    String b;
    
    String c;
    
    String d;
    
    String e;
    
    String f;
    
    int g;
    
    public UserNameClickSpan(Context param1Context, String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, int param1Int) {
      this.a = param1Context;
      this.b = param1String1;
      this.c = param1String2;
      this.d = param1String3;
      this.e = param1String4;
      this.f = param1String5;
      this.g = param1Int;
    }
    
    public void onClick(View param1View) {
      Selection.removeSelection((Spannable)((TextView)param1View).getText());
      if (!StringUtils.d(this.c)) {
        AppMethods.d(2131755842);
        return;
      } 
      if (!StringUtils.e(this.c)) {
        UserInfoFragmentNew.a(this.a, this.c, this.f);
        return;
      } 
      UserInfoFragmentNew.c(this.a, this.d, this.f);
    }
    
    public void updateDrawState(TextPaint param1TextPaint) {
      if (this.g == 0)
        this.g = BluedSkinUtils.a(this.a, 2131100838); 
      param1TextPaint.setColor(BluedSkinUtils.a(this.a, this.g));
      param1TextPaint.setUnderlineText(false);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\manager\FeedMethods.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */