package com.soft.blued.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.das.client.commentguide.CommentGuideProtos;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.trackUtils.EventTrackCommentGuide;
import com.soft.blued.ui.setting.fragment.FeedbackFragment;

public class MarketTool {
  private static MarketTool a;
  
  public static MarketTool a() {
    // Byte code:
    //   0: getstatic com/soft/blued/utils/MarketTool.a : Lcom/soft/blued/utils/MarketTool;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/utils/MarketTool
    //   8: monitorenter
    //   9: getstatic com/soft/blued/utils/MarketTool.a : Lcom/soft/blued/utils/MarketTool;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/utils/MarketTool
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/utils/MarketTool.a : Lcom/soft/blued/utils/MarketTool;
    //   25: ldc com/soft/blued/utils/MarketTool
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/utils/MarketTool
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/utils/MarketTool.a : Lcom/soft/blued/utils/MarketTool;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(Context paramContext) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #5
    //   9: aload #5
    //   11: ldc 'market://details?id='
    //   13: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload #5
    //   19: aload_1
    //   20: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   23: invokevirtual getPackageName : ()Ljava/lang/String;
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload #5
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   38: astore #7
    //   40: new android/content/Intent
    //   43: dup
    //   44: ldc 'android.intent.action.VIEW'
    //   46: aload #7
    //   48: invokespecial <init> : (Ljava/lang/String;Landroid/net/Uri;)V
    //   51: astore #6
    //   53: aload #6
    //   55: ldc 268435456
    //   57: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   60: pop
    //   61: getstatic com/blued/android/core/AppInfo.c : Ljava/lang/String;
    //   64: astore #5
    //   66: aload_1
    //   67: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   70: astore #8
    //   72: iconst_0
    //   73: istore_3
    //   74: aload #8
    //   76: aload #6
    //   78: iconst_0
    //   79: invokevirtual queryIntentActivities : (Landroid/content/Intent;I)Ljava/util/List;
    //   82: astore #8
    //   84: aload #5
    //   86: invokevirtual hashCode : ()I
    //   89: lookupswitch default -> 533, -1472132929 -> 319, -1472131999 -> 304, -1472131038 -> 289, -1472131007 -> 273, -1472130976 -> 258, -1472130883 -> 242, -1472130046 -> 227, -1471209439 -> 211, -1470285887 -> 195, -1463544224 -> 180
    //   180: aload #5
    //   182: ldc 'a9999a'
    //   184: invokevirtual equals : (Ljava/lang/Object;)Z
    //   187: ifeq -> 338
    //   190: iconst_0
    //   191: istore_2
    //   192: goto -> 340
    //   195: aload #5
    //   197: ldc 'a2001a'
    //   199: invokevirtual equals : (Ljava/lang/Object;)Z
    //   202: ifeq -> 338
    //   205: bipush #9
    //   207: istore_2
    //   208: goto -> 340
    //   211: aload #5
    //   213: ldc 'a1000a'
    //   215: invokevirtual equals : (Ljava/lang/Object;)Z
    //   218: ifeq -> 338
    //   221: bipush #7
    //   223: istore_2
    //   224: goto -> 340
    //   227: aload #5
    //   229: ldc 'a0031a'
    //   231: invokevirtual equals : (Ljava/lang/Object;)Z
    //   234: ifeq -> 338
    //   237: iconst_3
    //   238: istore_2
    //   239: goto -> 340
    //   242: aload #5
    //   244: ldc 'a0025a'
    //   246: invokevirtual equals : (Ljava/lang/Object;)Z
    //   249: ifeq -> 338
    //   252: bipush #6
    //   254: istore_2
    //   255: goto -> 340
    //   258: aload #5
    //   260: ldc 'a0022a'
    //   262: invokevirtual equals : (Ljava/lang/Object;)Z
    //   265: ifeq -> 338
    //   268: iconst_4
    //   269: istore_2
    //   270: goto -> 340
    //   273: aload #5
    //   275: ldc 'a0021a'
    //   277: invokevirtual equals : (Ljava/lang/Object;)Z
    //   280: ifeq -> 338
    //   283: bipush #8
    //   285: istore_2
    //   286: goto -> 340
    //   289: aload #5
    //   291: ldc 'a0020a'
    //   293: invokevirtual equals : (Ljava/lang/Object;)Z
    //   296: ifeq -> 338
    //   299: iconst_1
    //   300: istore_2
    //   301: goto -> 340
    //   304: aload #5
    //   306: ldc 'a0010a'
    //   308: invokevirtual equals : (Ljava/lang/Object;)Z
    //   311: ifeq -> 338
    //   314: iconst_5
    //   315: istore_2
    //   316: goto -> 340
    //   319: aload #5
    //   321: ldc 'a0001a'
    //   323: invokevirtual equals : (Ljava/lang/Object;)Z
    //   326: istore #4
    //   328: iload #4
    //   330: ifeq -> 338
    //   333: iconst_2
    //   334: istore_2
    //   335: goto -> 340
    //   338: iconst_m1
    //   339: istore_2
    //   340: ldc 'com.tencent.android.qqdownloader'
    //   342: astore #6
    //   344: aload #6
    //   346: astore #5
    //   348: iload_2
    //   349: tableswitch default -> 404, 0 -> 418, 1 -> 418, 2 -> 578, 3 -> 571, 4 -> 564, 5 -> 557, 6 -> 550, 7 -> 543, 8 -> 536, 9 -> 411
    //   404: aload #6
    //   406: astore #5
    //   408: goto -> 418
    //   411: ldc 'com.meizu.mstore'
    //   413: astore #5
    //   415: goto -> 418
    //   418: aload #8
    //   420: invokeinterface size : ()I
    //   425: ifle -> 532
    //   428: iload_3
    //   429: istore_2
    //   430: iload_2
    //   431: aload #8
    //   433: invokeinterface size : ()I
    //   438: if_icmpge -> 532
    //   441: aload #8
    //   443: iload_2
    //   444: invokeinterface get : (I)Ljava/lang/Object;
    //   449: checkcast android/content/pm/ResolveInfo
    //   452: astore #6
    //   454: aload #6
    //   456: getfield activityInfo : Landroid/content/pm/ActivityInfo;
    //   459: getfield packageName : Ljava/lang/String;
    //   462: astore #9
    //   464: aload #9
    //   466: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   469: aload #5
    //   471: invokevirtual equals : (Ljava/lang/Object;)Z
    //   474: ifeq -> 520
    //   477: new android/content/Intent
    //   480: dup
    //   481: ldc 'android.intent.action.VIEW'
    //   483: aload #7
    //   485: invokespecial <init> : (Ljava/lang/String;Landroid/net/Uri;)V
    //   488: astore #5
    //   490: aload #5
    //   492: new android/content/ComponentName
    //   495: dup
    //   496: aload #9
    //   498: aload #6
    //   500: getfield activityInfo : Landroid/content/pm/ActivityInfo;
    //   503: getfield name : Ljava/lang/String;
    //   506: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   509: invokevirtual setComponent : (Landroid/content/ComponentName;)Landroid/content/Intent;
    //   512: pop
    //   513: aload_1
    //   514: aload #5
    //   516: invokevirtual startActivity : (Landroid/content/Intent;)V
    //   519: return
    //   520: iload_2
    //   521: iconst_1
    //   522: iadd
    //   523: istore_2
    //   524: goto -> 430
    //   527: astore_1
    //   528: aload_1
    //   529: invokevirtual printStackTrace : ()V
    //   532: return
    //   533: goto -> 338
    //   536: ldc 'com.pp.assistant'
    //   538: astore #5
    //   540: goto -> 418
    //   543: ldc 'com.xiaomi.market'
    //   545: astore #5
    //   547: goto -> 418
    //   550: ldc 'com.bbk.appstore'
    //   552: astore #5
    //   554: goto -> 418
    //   557: ldc 'com.qihoo.appstore'
    //   559: astore #5
    //   561: goto -> 418
    //   564: ldc 'com.oppo.market'
    //   566: astore #5
    //   568: goto -> 418
    //   571: ldc 'com.huawei.appmarket'
    //   573: astore #5
    //   575: goto -> 418
    //   578: ldc 'com.baidu.appsearch'
    //   580: astore #5
    //   582: goto -> 418
    // Exception table:
    //   from	to	target	type
    //   0	72	527	java/lang/Exception
    //   74	180	527	java/lang/Exception
    //   180	190	527	java/lang/Exception
    //   195	205	527	java/lang/Exception
    //   211	221	527	java/lang/Exception
    //   227	237	527	java/lang/Exception
    //   242	252	527	java/lang/Exception
    //   258	268	527	java/lang/Exception
    //   273	283	527	java/lang/Exception
    //   289	299	527	java/lang/Exception
    //   304	314	527	java/lang/Exception
    //   319	328	527	java/lang/Exception
    //   418	428	527	java/lang/Exception
    //   430	519	527	java/lang/Exception
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    EventTrackCommentGuide.a(CommentGuideProtos.Event.COMMENT_WINDOW_SHOW, paramString5);
    View view = View.inflate(paramContext, 2131492988, null);
    AlertDialog alertDialog = (new AlertDialog.Builder(paramContext)).setView(view).create();
    ImageView imageView = (ImageView)view.findViewById(2131297729);
    TextView textView1 = (TextView)view.findViewById(2131301409);
    TextView textView2 = (TextView)view.findViewById(2131300663);
    TextView textView3 = (TextView)view.findViewById(2131301184);
    TextView textView4 = (TextView)view.findViewById(2131301099);
    textView1.setText(paramString1);
    textView2.setText(paramString2);
    textView3.setText(paramString3);
    textView4.setText(paramString4);
    imageView.setOnClickListener(new View.OnClickListener(this, alertDialog) {
          public void onClick(View param1View) {
            this.a.dismiss();
            EventTrackCommentGuide.a(CommentGuideProtos.Event.COMMENT_WINDOW_CLOSE_CLICK);
          }
        });
    textView3.setOnClickListener(new View.OnClickListener(this, alertDialog, paramContext) {
          public void onClick(View param1View) {
            this.a.dismiss();
            this.c.a(this.b);
            EventTrackCommentGuide.a(CommentGuideProtos.Event.COMMENT_WINDOW_RATE_CLICK);
          }
        });
    textView4.setOnClickListener(new View.OnClickListener(this, alertDialog, paramContext) {
          public void onClick(View param1View) {
            this.a.dismiss();
            InstantLog.a("my_suggestion");
            FeedbackFragment.a(this.b);
            EventTrackCommentGuide.a(CommentGuideProtos.Event.COMMENT_WINDOW_FEEDBACK_CLICK);
          }
        });
    alertDialog.getWindow().setBackgroundDrawableResource(17170445);
    alertDialog.show();
  }
  
  public Intent b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("market://details?id=");
    stringBuilder.append(AppInfo.d().getPackageName());
    return new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\MarketTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */