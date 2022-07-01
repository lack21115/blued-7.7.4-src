package com.soft.blued.ui.group.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.model.BluedGroupOpsAlreadyNotify;
import com.soft.blued.ui.group.model.BluedMyGroupNotify;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class GroupNotifyAdapter extends BaseAdapter {
  public Dialog a;
  
  private List<BluedMyGroupNotify> b;
  
  private LayoutInflater c;
  
  private Context d;
  
  private LoadOptions e;
  
  private IRequestHost f;
  
  public GroupNotifyAdapter(Context paramContext, List<BluedMyGroupNotify> paramList, IRequestHost paramIRequestHost) {
    this.f = paramIRequestHost;
    this.b = paramList;
    this.d = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.e = new LoadOptions();
    LoadOptions loadOptions = this.e;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    this.a = DialogUtils.a(paramContext);
  }
  
  private void a(ViewHolder paramViewHolder, BluedMyGroupNotify paramBluedMyGroupNotify, int paramInt) {
    if (paramViewHolder != null) {
      if (paramBluedMyGroupNotify == null)
        return; 
      ViewHolder.a(paramViewHolder).setVisibility(8);
      ViewHolder.b(paramViewHolder).setOnClickListener(new View.OnClickListener(this, paramBluedMyGroupNotify) {
            public void onClick(View param1View) {
              GroupNotifyAdapter.a(this.b, this.a);
            }
          });
      ViewHolder.c(paramViewHolder).setOnClickListener(new View.OnClickListener(this, paramBluedMyGroupNotify, paramViewHolder) {
            public void onClick(View param1View) {
              UserBasicModel userBasicModel = new UserBasicModel();
              userBasicModel.uid = this.a.getApplied_uid();
              userBasicModel.name = this.a.getApplied_name();
              userBasicModel.avatar = this.a.getApplied_avatar();
              UserInfoFragmentNew.a(GroupNotifyAdapter.a(this.c), userBasicModel, null, (View)GroupNotifyAdapter.ViewHolder.c(this.b));
            }
          });
      UserRelationshipUtils.a(ViewHolder.d(paramViewHolder), paramBluedMyGroupNotify.getVbadge(), 3);
      ViewHolder.e(paramViewHolder).setVisibility(8);
      if (paramBluedMyGroupNotify.getIs_read().equals("1")) {
        ViewHolder.f(paramViewHolder).setBackgroundResource(2131100980);
      } else {
        ViewHolder.f(paramViewHolder).setBackgroundResource(2131100339);
      } 
      if (paramBluedMyGroupNotify.getOps().equals("allowed")) {
        ViewHolder.g(paramViewHolder).setText(2131756800);
        ViewHolder.h(paramViewHolder).setVisibility(8);
        ViewHolder.g(paramViewHolder).setVisibility(0);
      } else if (paramBluedMyGroupNotify.getOps().equals("denied")) {
        ViewHolder.g(paramViewHolder).setText(2131756758);
        ViewHolder.h(paramViewHolder).setVisibility(8);
        ViewHolder.g(paramViewHolder).setVisibility(0);
      } else {
        ViewHolder.h(paramViewHolder).setText(2131756799);
        ViewHolder.h(paramViewHolder).setVisibility(0);
        ViewHolder.g(paramViewHolder).setVisibility(8);
      } 
      ImageLoader.a(this.f, paramBluedMyGroupNotify.getApplied_avatar()).a(2131234356).c().a(ViewHolder.c(paramViewHolder));
      if (!StringUtils.e(paramBluedMyGroupNotify.getReason())) {
        ViewHolder.i(paramViewHolder).setVisibility(0);
        ViewHolder.j(paramViewHolder).setVisibility(8);
        if (!StringUtils.e(paramBluedMyGroupNotify.getApplied_name())) {
          ViewHolder.k(paramViewHolder).setVisibility(0);
          ViewHolder.k(paramViewHolder).setText(paramBluedMyGroupNotify.getApplied_name());
        } else {
          ViewHolder.k(paramViewHolder).setVisibility(4);
        } 
        if (!StringUtils.e(paramBluedMyGroupNotify.getGroups_name())) {
          ViewHolder.l(paramViewHolder).setVisibility(0);
          TextView textView = ViewHolder.l(paramViewHolder);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.d.getResources().getString(2131756635));
          stringBuilder.append(" ");
          stringBuilder.append(paramBluedMyGroupNotify.getGroups_name());
          textView.setText(stringBuilder.toString());
        } else {
          ViewHolder.l(paramViewHolder).setVisibility(4);
        } 
        ViewHolder.m(paramViewHolder).setText(paramBluedMyGroupNotify.getReason());
      } else {
        ViewHolder.i(paramViewHolder).setVisibility(8);
        ViewHolder.j(paramViewHolder).setVisibility(0);
        if (!StringUtils.e(paramBluedMyGroupNotify.getApplied_name())) {
          ViewHolder.n(paramViewHolder).setVisibility(0);
          ViewHolder.n(paramViewHolder).setText(paramBluedMyGroupNotify.getApplied_name());
        } else {
          ViewHolder.n(paramViewHolder).setVisibility(4);
        } 
        if (!StringUtils.e(paramBluedMyGroupNotify.getGroups_name())) {
          ViewHolder.o(paramViewHolder).setVisibility(0);
          TextView textView = ViewHolder.o(paramViewHolder);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(this.d.getResources().getString(2131756635));
          stringBuilder.append(" ");
          stringBuilder.append(paramBluedMyGroupNotify.getGroups_name());
          textView.setText(stringBuilder.toString());
        } else {
          ViewHolder.o(paramViewHolder).setVisibility(4);
        } 
      } 
      if (paramBluedMyGroupNotify.getGroupsStatus() == 2) {
        ViewHolder.h(paramViewHolder).setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                AppMethods.d(2131756753);
              }
            });
        return;
      } 
      if (paramBluedMyGroupNotify.getGroupsStatus() == 1) {
        ViewHolder.h(paramViewHolder).setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {
                AppMethods.d(2131756754);
              }
            });
        return;
      } 
      ViewHolder.h(paramViewHolder).setOnClickListener(new View.OnClickListener(this, paramInt, paramViewHolder, paramBluedMyGroupNotify) {
            public void onClick(View param1View) {
              // Byte code:
              //   0: aload_0
              //   1: getfield d : Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;
              //   4: invokestatic b : (Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;)Ljava/util/List;
              //   7: aload_0
              //   8: getfield a : I
              //   11: invokeinterface get : (I)Ljava/lang/Object;
              //   16: checkcast com/soft/blued/ui/group/model/BluedMyGroupNotify
              //   19: invokevirtual getIid : ()Ljava/lang/String;
              //   22: astore #11
              //   24: aload_0
              //   25: getfield b : Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter$ViewHolder;
              //   28: invokestatic f : (Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter$ViewHolder;)Landroid/widget/RelativeLayout;
              //   31: ldc 2131100980
              //   33: invokevirtual setBackgroundResource : (I)V
              //   36: new java/io/File
              //   39: dup
              //   40: aload_0
              //   41: getfield d : Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;
              //   44: invokestatic a : (Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;)Landroid/content/Context;
              //   47: invokevirtual getFilesDir : ()Ljava/io/File;
              //   50: ldc 'groupnofyalread'
              //   52: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
              //   55: astore #12
              //   57: new org/json/JSONArray
              //   60: dup
              //   61: invokespecial <init> : ()V
              //   64: astore #9
              //   66: iconst_0
              //   67: istore_2
              //   68: iconst_0
              //   69: istore #5
              //   71: iconst_0
              //   72: istore #6
              //   74: iconst_0
              //   75: istore_3
              //   76: iconst_0
              //   77: istore #7
              //   79: iconst_0
              //   80: istore #4
              //   82: aload #12
              //   84: invokevirtual exists : ()Z
              //   87: ifeq -> 322
              //   90: new java/io/FileInputStream
              //   93: dup
              //   94: aload #12
              //   96: invokespecial <init> : (Ljava/io/File;)V
              //   99: astore_1
              //   100: new java/io/BufferedInputStream
              //   103: dup
              //   104: aload_1
              //   105: invokespecial <init> : (Ljava/io/InputStream;)V
              //   108: astore #10
              //   110: new java/lang/StringBuffer
              //   113: dup
              //   114: invokespecial <init> : ()V
              //   117: astore #13
              //   119: aload #10
              //   121: invokevirtual available : ()I
              //   124: ifeq -> 142
              //   127: aload #13
              //   129: aload #10
              //   131: invokevirtual read : ()I
              //   134: i2c
              //   135: invokevirtual append : (C)Ljava/lang/StringBuffer;
              //   138: pop
              //   139: goto -> 119
              //   142: aload #10
              //   144: invokevirtual close : ()V
              //   147: aload_1
              //   148: invokevirtual close : ()V
              //   151: new org/json/JSONArray
              //   154: dup
              //   155: aload #13
              //   157: invokevirtual toString : ()Ljava/lang/String;
              //   160: invokespecial <init> : (Ljava/lang/String;)V
              //   163: astore_1
              //   164: iload #6
              //   166: istore_3
              //   167: aload_1
              //   168: astore #9
              //   170: aload_0
              //   171: getfield d : Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;
              //   174: invokestatic b : (Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;)Ljava/util/List;
              //   177: aload_0
              //   178: getfield a : I
              //   181: invokeinterface get : (I)Ljava/lang/Object;
              //   186: checkcast com/soft/blued/ui/group/model/BluedMyGroupNotify
              //   189: invokevirtual getTimestamp : ()Ljava/lang/String;
              //   192: astore #10
              //   194: iload #6
              //   196: istore_3
              //   197: aload_1
              //   198: astore #9
              //   200: aload_1
              //   201: invokevirtual length : ()I
              //   204: istore #6
              //   206: iload #5
              //   208: istore_2
              //   209: aload_1
              //   210: astore #9
              //   212: iload #6
              //   214: ifle -> 300
              //   217: iconst_0
              //   218: istore_2
              //   219: iload #4
              //   221: istore_3
              //   222: iload_3
              //   223: aload_1
              //   224: invokevirtual length : ()I
              //   227: if_icmpge -> 259
              //   230: aload #10
              //   232: aload_1
              //   233: iload_3
              //   234: invokevirtual get : (I)Ljava/lang/Object;
              //   237: invokevirtual toString : ()Ljava/lang/String;
              //   240: invokevirtual equals : (Ljava/lang/Object;)Z
              //   243: istore #8
              //   245: iload #8
              //   247: ifeq -> 252
              //   250: iconst_1
              //   251: istore_2
              //   252: iload_3
              //   253: iconst_1
              //   254: iadd
              //   255: istore_3
              //   256: goto -> 222
              //   259: aload_1
              //   260: astore #9
              //   262: goto -> 300
              //   265: astore #9
              //   267: iload_2
              //   268: istore_3
              //   269: goto -> 312
              //   272: astore #10
              //   274: goto -> 287
              //   277: astore #10
              //   279: goto -> 287
              //   282: astore #10
              //   284: aload #9
              //   286: astore_1
              //   287: iload_2
              //   288: istore_3
              //   289: aload_1
              //   290: astore #9
              //   292: aload #10
              //   294: invokevirtual printStackTrace : ()V
              //   297: aload_1
              //   298: astore #9
              //   300: goto -> 402
              //   303: astore #10
              //   305: aload #9
              //   307: astore_1
              //   308: aload #10
              //   310: astore #9
              //   312: aload #9
              //   314: astore #10
              //   316: aload_1
              //   317: astore #9
              //   319: goto -> 395
              //   322: aload #9
              //   324: aload_0
              //   325: getfield d : Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;
              //   328: invokestatic b : (Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;)Ljava/util/List;
              //   331: aload_0
              //   332: getfield a : I
              //   335: invokeinterface get : (I)Ljava/lang/Object;
              //   340: checkcast com/soft/blued/ui/group/model/BluedMyGroupNotify
              //   343: invokevirtual getTimestamp : ()Ljava/lang/String;
              //   346: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
              //   349: pop
              //   350: new java/io/FileOutputStream
              //   353: dup
              //   354: aload #12
              //   356: invokespecial <init> : (Ljava/io/File;)V
              //   359: astore_1
              //   360: aload_1
              //   361: aload #9
              //   363: invokevirtual toString : ()Ljava/lang/String;
              //   366: invokevirtual getBytes : ()[B
              //   369: invokevirtual write : ([B)V
              //   372: aload_1
              //   373: invokevirtual close : ()V
              //   376: iload #7
              //   378: istore_2
              //   379: goto -> 402
              //   382: astore_1
              //   383: aload_1
              //   384: invokevirtual printStackTrace : ()V
              //   387: iload #7
              //   389: istore_2
              //   390: goto -> 402
              //   393: astore #10
              //   395: aload #10
              //   397: invokevirtual printStackTrace : ()V
              //   400: iload_3
              //   401: istore_2
              //   402: iload_2
              //   403: ifne -> 468
              //   406: aload #9
              //   408: aload_0
              //   409: getfield d : Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;
              //   412: invokestatic b : (Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;)Ljava/util/List;
              //   415: aload_0
              //   416: getfield a : I
              //   419: invokeinterface get : (I)Ljava/lang/Object;
              //   424: checkcast com/soft/blued/ui/group/model/BluedMyGroupNotify
              //   427: invokevirtual getTimestamp : ()Ljava/lang/String;
              //   430: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
              //   433: pop
              //   434: new java/io/FileOutputStream
              //   437: dup
              //   438: aload #12
              //   440: invokespecial <init> : (Ljava/io/File;)V
              //   443: astore_1
              //   444: aload_1
              //   445: aload #9
              //   447: invokevirtual toString : ()Ljava/lang/String;
              //   450: invokevirtual getBytes : ()[B
              //   453: invokevirtual write : ([B)V
              //   456: aload_1
              //   457: invokevirtual close : ()V
              //   460: goto -> 468
              //   463: astore_1
              //   464: aload_1
              //   465: invokevirtual printStackTrace : ()V
              //   468: aload #11
              //   470: invokestatic e : (Ljava/lang/String;)Z
              //   473: ifne -> 512
              //   476: aload_0
              //   477: getfield d : Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;
              //   480: invokestatic a : (Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;)Landroid/content/Context;
              //   483: new com/soft/blued/ui/group/adapter/GroupNotifyAdapter$5$1
              //   486: dup
              //   487: aload_0
              //   488: invokespecial <init> : (Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter$5;)V
              //   491: invokestatic a : ()Lcom/soft/blued/user/UserInfo;
              //   494: invokevirtual i : ()Lcom/soft/blued/ui/login_register/model/BluedLoginResult;
              //   497: invokevirtual getUid : ()Ljava/lang/String;
              //   500: aload #11
              //   502: aload_0
              //   503: getfield d : Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;
              //   506: invokestatic c : (Lcom/soft/blued/ui/group/adapter/GroupNotifyAdapter;)Lcom/blued/android/core/net/IRequestHost;
              //   509: invokestatic d : (Landroid/content/Context;Lcom/blued/android/framework/http/BluedUIHttpResponse;Ljava/lang/String;Ljava/lang/String;Lcom/blued/android/core/net/IRequestHost;)V
              //   512: return
              // Exception table:
              //   from	to	target	type
              //   82	119	393	java/io/IOException
              //   119	139	393	java/io/IOException
              //   142	151	393	java/io/IOException
              //   151	164	282	org/json/JSONException
              //   151	164	393	java/io/IOException
              //   170	194	277	org/json/JSONException
              //   170	194	303	java/io/IOException
              //   200	206	277	org/json/JSONException
              //   200	206	303	java/io/IOException
              //   222	245	272	org/json/JSONException
              //   222	245	265	java/io/IOException
              //   292	297	303	java/io/IOException
              //   322	376	382	java/lang/Exception
              //   322	376	393	java/io/IOException
              //   383	387	393	java/io/IOException
              //   406	460	463	java/lang/Exception
            }
          });
    } 
  }
  
  private void a(BluedMyGroupNotify paramBluedMyGroupNotify) {
    // Byte code:
    //   0: new android/os/Bundle
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #9
    //   9: aload_1
    //   10: ifnull -> 144
    //   13: aload_1
    //   14: invokevirtual getGroupsStatus : ()I
    //   17: iconst_2
    //   18: if_icmpne -> 36
    //   21: aload_1
    //   22: invokevirtual getAppliedType : ()I
    //   25: iconst_2
    //   26: if_icmpne -> 36
    //   29: ldc_w 2131756753
    //   32: invokestatic d : (I)V
    //   35: return
    //   36: aload_1
    //   37: invokevirtual getGroupsStatus : ()I
    //   40: iconst_1
    //   41: if_icmpne -> 59
    //   44: aload_1
    //   45: invokevirtual getAppliedType : ()I
    //   48: iconst_2
    //   49: if_icmpne -> 59
    //   52: ldc_w 2131756754
    //   55: invokestatic d : (I)V
    //   58: return
    //   59: new com/soft/blued/ui/group/model/BluedGroupOpsNotify
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: astore #10
    //   68: aload_1
    //   69: getfield operator : Lcom/soft/blued/ui/group/model/BluedGroupOpsNotify;
    //   72: ifnonnull -> 94
    //   75: aload #10
    //   77: ldc_w ''
    //   80: putfield uid : Ljava/lang/String;
    //   83: aload #10
    //   85: ldc_w ''
    //   88: putfield name : Ljava/lang/String;
    //   91: goto -> 118
    //   94: aload #10
    //   96: aload_1
    //   97: getfield operator : Lcom/soft/blued/ui/group/model/BluedGroupOpsNotify;
    //   100: getfield uid : Ljava/lang/String;
    //   103: putfield uid : Ljava/lang/String;
    //   106: aload #10
    //   108: aload_1
    //   109: getfield operator : Lcom/soft/blued/ui/group/model/BluedGroupOpsNotify;
    //   112: getfield name : Ljava/lang/String;
    //   115: putfield name : Ljava/lang/String;
    //   118: aload #9
    //   120: ldc_w 'opsuid'
    //   123: aload #10
    //   125: getfield uid : Ljava/lang/String;
    //   128: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload #9
    //   133: ldc_w 'opsname'
    //   136: aload #10
    //   138: getfield name : Ljava/lang/String;
    //   141: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload #9
    //   146: ldc_w 'UID'
    //   149: aload_1
    //   150: invokevirtual getApplied_uid : ()Ljava/lang/String;
    //   153: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload #9
    //   158: ldc_w 'nickname'
    //   161: aload_1
    //   162: invokevirtual getApplied_name : ()Ljava/lang/String;
    //   165: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload #9
    //   170: ldc_w 'avatar'
    //   173: aload_1
    //   174: invokevirtual getApplied_avatar : ()Ljava/lang/String;
    //   177: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload #9
    //   182: ldc_w 'age'
    //   185: aload_1
    //   186: invokevirtual getApplied_age : ()Ljava/lang/String;
    //   189: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload #9
    //   194: ldc_w 'height'
    //   197: aload_1
    //   198: invokevirtual getApplied_height : ()Ljava/lang/String;
    //   201: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload #9
    //   206: ldc_w 'weight'
    //   209: aload_1
    //   210: invokevirtual getApplied_weight : ()Ljava/lang/String;
    //   213: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload #9
    //   218: ldc_w 'role'
    //   221: aload_1
    //   222: invokevirtual getApplied_role : ()Ljava/lang/String;
    //   225: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload #9
    //   230: ldc_w 'groupName'
    //   233: aload_1
    //   234: invokevirtual getGroups_name : ()Ljava/lang/String;
    //   237: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload #9
    //   242: ldc_w 'group avatar'
    //   245: aload_1
    //   246: invokevirtual getGroups_avatar : ()Ljava/lang/String;
    //   249: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload #9
    //   254: ldc_w 'groupId'
    //   257: aload_1
    //   258: invokevirtual getGroups_gid : ()Ljava/lang/String;
    //   261: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload #9
    //   266: ldc_w 'applyDescrible'
    //   269: aload_1
    //   270: invokevirtual getReason : ()Ljava/lang/String;
    //   273: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload #9
    //   278: ldc_w 'iid'
    //   281: aload_1
    //   282: invokevirtual getIid : ()Ljava/lang/String;
    //   285: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload #9
    //   290: ldc_w 'ops'
    //   293: aload_1
    //   294: invokevirtual getOps : ()Ljava/lang/String;
    //   297: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload #9
    //   302: ldc_w 'time'
    //   305: aload_1
    //   306: invokevirtual getTimestamp : ()Ljava/lang/String;
    //   309: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload #9
    //   314: ldc_w 'type'
    //   317: aload_1
    //   318: invokevirtual getAppliedType : ()I
    //   321: invokevirtual putInt : (Ljava/lang/String;I)V
    //   324: aload #9
    //   326: ldc_w 'vbadge'
    //   329: aload_1
    //   330: invokevirtual getVbadge : ()I
    //   333: invokevirtual putInt : (Ljava/lang/String;I)V
    //   336: aload_0
    //   337: getfield d : Landroid/content/Context;
    //   340: ldc_w com/soft/blued/ui/group/GroupNotifyInfoFragment
    //   343: aload #9
    //   345: invokestatic d : (Landroid/content/Context;Ljava/lang/Class;Landroid/os/Bundle;)V
    //   348: new java/io/File
    //   351: dup
    //   352: aload_0
    //   353: getfield d : Landroid/content/Context;
    //   356: invokevirtual getFilesDir : ()Ljava/io/File;
    //   359: ldc_w 'groupnofyalread'
    //   362: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   365: astore #12
    //   367: new org/json/JSONArray
    //   370: dup
    //   371: invokespecial <init> : ()V
    //   374: astore #10
    //   376: iconst_0
    //   377: istore_2
    //   378: iconst_0
    //   379: istore #5
    //   381: iconst_0
    //   382: istore #6
    //   384: iconst_0
    //   385: istore_3
    //   386: iconst_0
    //   387: istore #7
    //   389: iconst_0
    //   390: istore #4
    //   392: aload #12
    //   394: invokevirtual exists : ()Z
    //   397: ifeq -> 622
    //   400: new java/io/FileInputStream
    //   403: dup
    //   404: aload #12
    //   406: invokespecial <init> : (Ljava/io/File;)V
    //   409: astore #9
    //   411: new java/io/BufferedInputStream
    //   414: dup
    //   415: aload #9
    //   417: invokespecial <init> : (Ljava/io/InputStream;)V
    //   420: astore #11
    //   422: new java/lang/StringBuffer
    //   425: dup
    //   426: invokespecial <init> : ()V
    //   429: astore #13
    //   431: aload #11
    //   433: invokevirtual available : ()I
    //   436: ifeq -> 454
    //   439: aload #13
    //   441: aload #11
    //   443: invokevirtual read : ()I
    //   446: i2c
    //   447: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   450: pop
    //   451: goto -> 431
    //   454: aload #11
    //   456: invokevirtual close : ()V
    //   459: aload #9
    //   461: invokevirtual close : ()V
    //   464: new org/json/JSONArray
    //   467: dup
    //   468: aload #13
    //   470: invokevirtual toString : ()Ljava/lang/String;
    //   473: invokespecial <init> : (Ljava/lang/String;)V
    //   476: astore #9
    //   478: iload #6
    //   480: istore_3
    //   481: aload #9
    //   483: astore #10
    //   485: aload_1
    //   486: invokevirtual getTimestamp : ()Ljava/lang/String;
    //   489: astore #11
    //   491: iload #6
    //   493: istore_3
    //   494: aload #9
    //   496: astore #10
    //   498: aload #9
    //   500: invokevirtual length : ()I
    //   503: istore #6
    //   505: iload #5
    //   507: istore_2
    //   508: aload #9
    //   510: astore #10
    //   512: iload #6
    //   514: ifle -> 604
    //   517: iconst_0
    //   518: istore_2
    //   519: iload #4
    //   521: istore_3
    //   522: iload_3
    //   523: aload #9
    //   525: invokevirtual length : ()I
    //   528: if_icmpge -> 561
    //   531: aload #11
    //   533: aload #9
    //   535: iload_3
    //   536: invokevirtual get : (I)Ljava/lang/Object;
    //   539: invokevirtual toString : ()Ljava/lang/String;
    //   542: invokevirtual equals : (Ljava/lang/Object;)Z
    //   545: istore #8
    //   547: iload #8
    //   549: ifeq -> 554
    //   552: iconst_1
    //   553: istore_2
    //   554: iload_3
    //   555: iconst_1
    //   556: iadd
    //   557: istore_3
    //   558: goto -> 522
    //   561: aload #9
    //   563: astore #10
    //   565: goto -> 604
    //   568: astore #11
    //   570: goto -> 696
    //   573: astore #11
    //   575: goto -> 589
    //   578: astore #11
    //   580: goto -> 589
    //   583: astore #11
    //   585: aload #10
    //   587: astore #9
    //   589: iload_2
    //   590: istore_3
    //   591: aload #9
    //   593: astore #10
    //   595: aload #11
    //   597: invokevirtual printStackTrace : ()V
    //   600: aload #9
    //   602: astore #10
    //   604: aload #10
    //   606: astore #9
    //   608: goto -> 701
    //   611: astore #11
    //   613: aload #10
    //   615: astore #9
    //   617: iload_3
    //   618: istore_2
    //   619: goto -> 696
    //   622: aload #10
    //   624: aload_1
    //   625: invokevirtual getTimestamp : ()Ljava/lang/String;
    //   628: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   631: pop
    //   632: new java/io/FileOutputStream
    //   635: dup
    //   636: aload #12
    //   638: invokespecial <init> : (Ljava/io/File;)V
    //   641: astore #9
    //   643: aload #9
    //   645: aload #10
    //   647: invokevirtual toString : ()Ljava/lang/String;
    //   650: invokevirtual getBytes : ()[B
    //   653: invokevirtual write : ([B)V
    //   656: aload #9
    //   658: invokevirtual close : ()V
    //   661: aload #10
    //   663: astore #9
    //   665: iload #7
    //   667: istore_2
    //   668: goto -> 701
    //   671: astore #9
    //   673: aload #9
    //   675: invokevirtual printStackTrace : ()V
    //   678: aload #10
    //   680: astore #9
    //   682: iload #7
    //   684: istore_2
    //   685: goto -> 701
    //   688: astore #11
    //   690: iload_3
    //   691: istore_2
    //   692: aload #10
    //   694: astore #9
    //   696: aload #11
    //   698: invokevirtual printStackTrace : ()V
    //   701: iload_2
    //   702: ifne -> 747
    //   705: aload #9
    //   707: aload_1
    //   708: invokevirtual getTimestamp : ()Ljava/lang/String;
    //   711: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   714: pop
    //   715: new java/io/FileOutputStream
    //   718: dup
    //   719: aload #12
    //   721: invokespecial <init> : (Ljava/io/File;)V
    //   724: astore_1
    //   725: aload_1
    //   726: aload #9
    //   728: invokevirtual toString : ()Ljava/lang/String;
    //   731: invokevirtual getBytes : ()[B
    //   734: invokevirtual write : ([B)V
    //   737: aload_1
    //   738: invokevirtual close : ()V
    //   741: return
    //   742: astore_1
    //   743: aload_1
    //   744: invokevirtual printStackTrace : ()V
    //   747: return
    // Exception table:
    //   from	to	target	type
    //   392	431	688	java/io/IOException
    //   431	451	688	java/io/IOException
    //   454	464	688	java/io/IOException
    //   464	478	583	org/json/JSONException
    //   464	478	688	java/io/IOException
    //   485	491	578	org/json/JSONException
    //   485	491	611	java/io/IOException
    //   498	505	578	org/json/JSONException
    //   498	505	611	java/io/IOException
    //   522	547	573	org/json/JSONException
    //   522	547	568	java/io/IOException
    //   595	600	611	java/io/IOException
    //   622	661	671	java/lang/Exception
    //   622	661	688	java/io/IOException
    //   673	678	688	java/io/IOException
    //   705	741	742	java/lang/Exception
  }
  
  private void b(ViewHolder paramViewHolder, BluedMyGroupNotify paramBluedMyGroupNotify, int paramInt) {
    if (paramViewHolder != null && paramBluedMyGroupNotify != null) {
      String str2;
      ViewHolder.b(paramViewHolder).setOnClickListener(new View.OnClickListener(this, paramBluedMyGroupNotify) {
            public void onClick(View param1View) {
              GroupNotifyAdapter.a(this.b, this.a);
            }
          });
      ViewHolder.i(paramViewHolder).setVisibility(8);
      ViewHolder.j(paramViewHolder).setVisibility(0);
      ViewHolder.h(paramViewHolder).setVisibility(8);
      ViewHolder.g(paramViewHolder).setVisibility(8);
      ViewHolder.d(paramViewHolder).setVisibility(8);
      if (paramBluedMyGroupNotify.getIs_read().equals("1")) {
        ViewHolder.f(paramViewHolder).setBackgroundResource(2131100980);
      } else {
        ViewHolder.f(paramViewHolder).setBackgroundResource(2131100339);
      } 
      ImageLoader.a(this.f, paramBluedMyGroupNotify.getApplied_avatar()).a(2131234356).c().a(ViewHolder.c(paramViewHolder));
      ViewHolder.c(paramViewHolder).setOnClickListener(new View.OnClickListener(this, paramBluedMyGroupNotify) {
            public void onClick(View param1View) {
              GroupNotifyAdapter.a(this.b, this.a);
            }
          });
      String str1 = "";
      if (1 == paramInt) {
        ViewHolder.e(paramViewHolder).setVisibility(0);
        ViewHolder.p(paramViewHolder).setVisibility(8);
        str1 = paramBluedMyGroupNotify.getGroups_name();
        str2 = this.d.getResources().getString(2131756759);
      } else if (3 == paramInt) {
        ViewHolder.e(paramViewHolder).setVisibility(0);
        ViewHolder.p(paramViewHolder).setVisibility(8);
        str1 = paramBluedMyGroupNotify.getApplied_name();
        str2 = this.d.getResources().getString(2131756762);
      } else if (paramInt == 0) {
        ViewHolder.e(paramViewHolder).setVisibility(8);
        ViewHolder.p(paramViewHolder).setVisibility(0);
        str1 = paramBluedMyGroupNotify.getGroups_name();
        str2 = this.d.getResources().getString(2131756761);
      } else {
        str2 = "";
      } 
      if (!StringUtils.e(paramBluedMyGroupNotify.getGroups_name())) {
        ViewHolder.n(paramViewHolder).setVisibility(0);
        ViewHolder.n(paramViewHolder).setText(paramBluedMyGroupNotify.getGroups_name());
      } else {
        ViewHolder.n(paramViewHolder).setVisibility(4);
      } 
      if (!StringUtils.e(str1)) {
        ViewHolder.o(paramViewHolder).setVisibility(0);
        str1 = String.format(str2, new Object[] { str1 });
        ViewHolder.o(paramViewHolder).setText(str1);
      } else {
        ViewHolder.o(paramViewHolder).setVisibility(4);
      } 
      if (!StringUtils.e(paramBluedMyGroupNotify.getTimestamp())) {
        String str = TimeAndDateUtils.g(this.d, TimeAndDateUtils.b(paramBluedMyGroupNotify.getTimestamp()));
        ViewHolder.a(paramViewHolder).setVisibility(0);
        ViewHolder.a(paramViewHolder).setText(str);
        return;
      } 
      ViewHolder.a(paramViewHolder).setVisibility(8);
    } 
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public Object getItem(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    BluedMyGroupNotify bluedMyGroupNotify = this.b.get(paramInt);
    if (paramView == null) {
      paramView = this.c.inflate(2131493547, paramViewGroup, false);
      viewHolder = new ViewHolder(this, paramView);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    if (paramInt == 13)
      Logger.a("GroupNotify_test", new Object[] { "applied_type = ", Integer.valueOf(bluedMyGroupNotify.getAppliedType()) }); 
    if (bluedMyGroupNotify.getAppliedType() == 0) {
      b(viewHolder, bluedMyGroupNotify, 0);
      return paramView;
    } 
    if (3 == bluedMyGroupNotify.getAppliedType()) {
      b(viewHolder, bluedMyGroupNotify, 3);
      return paramView;
    } 
    if (1 == bluedMyGroupNotify.getAppliedType()) {
      b(viewHolder, bluedMyGroupNotify, 1);
      return paramView;
    } 
    if (2 == bluedMyGroupNotify.getAppliedType())
      a(viewHolder, bluedMyGroupNotify, paramInt); 
    return paramView;
  }
  
  class ViewHolder {
    private RelativeLayout b;
    
    private LinearLayout c;
    
    private ImageView d;
    
    private ImageView e;
    
    private LinearLayout f;
    
    private TextView g;
    
    private TextView h;
    
    private TextView i;
    
    private LinearLayout j;
    
    private TextView k;
    
    private TextView l;
    
    private TextView m;
    
    private TextView n;
    
    private TextView o;
    
    private TextView p;
    
    private TextView q;
    
    public ViewHolder(GroupNotifyAdapter this$0, View param1View) {
      this.b = (RelativeLayout)param1View.findViewById(2131299706);
      this.d = (ImageView)param1View.findViewById(2131297952);
      this.e = (ImageView)param1View.findViewById(2131297789);
      this.c = (LinearLayout)param1View.findViewById(2131298856);
      this.f = (LinearLayout)param1View.findViewById(2131298853);
      this.g = (TextView)param1View.findViewById(2131301477);
      this.h = (TextView)param1View.findViewById(2131300838);
      this.i = (TextView)param1View.findViewById(2131300836);
      this.j = (LinearLayout)param1View.findViewById(2131298852);
      this.k = (TextView)param1View.findViewById(2131300844);
      this.l = (TextView)param1View.findViewById(2131301476);
      this.m = (TextView)param1View.findViewById(2131300837);
      this.n = (TextView)param1View.findViewById(2131300861);
      this.o = (TextView)param1View.findViewById(2131296594);
      this.p = (TextView)param1View.findViewById(2131300835);
      this.q = (TextView)param1View.findViewById(2131300828);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\adapter\GroupNotifyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */