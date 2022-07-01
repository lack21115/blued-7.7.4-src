package org.chromium.content.browser.picker;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.NumberPicker;

@SuppressLint({"DefaultLocale"})
public final class MultiFieldTimePickerDialog extends AlertDialog implements DialogInterface.OnClickListener {
  private final NumberPicker mAmPmSpinner;
  
  private final int mBaseMilli;
  
  private final NumberPicker mHourSpinner;
  
  private final boolean mIs24hourFormat;
  
  private final MultiFieldTimePickerDialog$OnMultiFieldTimeSetListener mListener;
  
  private final NumberPicker mMilliSpinner;
  
  private final NumberPicker mMinuteSpinner;
  
  private final NumberPicker mSecSpinner;
  
  private final int mStep;
  
  public MultiFieldTimePickerDialog(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, MultiFieldTimePickerDialog$OnMultiFieldTimeSetListener paramMultiFieldTimePickerDialog$OnMultiFieldTimeSetListener) {
    // Byte code:
    //   0: iload #9
    //   2: istore #12
    //   4: aload_0
    //   5: aload_1
    //   6: iload_2
    //   7: invokespecial <init> : (Landroid/content/Context;I)V
    //   10: aload_0
    //   11: aload #11
    //   13: putfield mListener : Lorg/chromium/content/browser/picker/MultiFieldTimePickerDialog$OnMultiFieldTimeSetListener;
    //   16: aload_0
    //   17: iload #12
    //   19: putfield mStep : I
    //   22: aload_0
    //   23: iload #10
    //   25: putfield mIs24hourFormat : Z
    //   28: iload #8
    //   30: istore #9
    //   32: iload #7
    //   34: istore #8
    //   36: iload #9
    //   38: istore_2
    //   39: iload #7
    //   41: iload #9
    //   43: if_icmplt -> 52
    //   46: iconst_0
    //   47: istore #8
    //   49: ldc 86399999
    //   51: istore_2
    //   52: iload #12
    //   54: iflt -> 68
    //   57: iload #12
    //   59: istore #9
    //   61: iload #12
    //   63: ldc 86400000
    //   65: if_icmplt -> 72
    //   68: ldc 60000
    //   70: istore #9
    //   72: aload_1
    //   73: ldc 'layout_inflater'
    //   75: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   78: checkcast android/view/LayoutInflater
    //   81: getstatic org/chromium/content/R$layout.multi_field_time_picker_dialog : I
    //   84: aconst_null
    //   85: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   88: astore #11
    //   90: aload_0
    //   91: aload #11
    //   93: invokevirtual setView : (Landroid/view/View;)V
    //   96: aload_0
    //   97: aload #11
    //   99: getstatic org/chromium/content/R$id.hour : I
    //   102: invokevirtual findViewById : (I)Landroid/view/View;
    //   105: checkcast android/widget/NumberPicker
    //   108: putfield mHourSpinner : Landroid/widget/NumberPicker;
    //   111: aload_0
    //   112: aload #11
    //   114: getstatic org/chromium/content/R$id.minute : I
    //   117: invokevirtual findViewById : (I)Landroid/view/View;
    //   120: checkcast android/widget/NumberPicker
    //   123: putfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   126: aload_0
    //   127: aload #11
    //   129: getstatic org/chromium/content/R$id.second : I
    //   132: invokevirtual findViewById : (I)Landroid/view/View;
    //   135: checkcast android/widget/NumberPicker
    //   138: putfield mSecSpinner : Landroid/widget/NumberPicker;
    //   141: aload_0
    //   142: aload #11
    //   144: getstatic org/chromium/content/R$id.milli : I
    //   147: invokevirtual findViewById : (I)Landroid/view/View;
    //   150: checkcast android/widget/NumberPicker
    //   153: putfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   156: aload_0
    //   157: aload #11
    //   159: getstatic org/chromium/content/R$id.ampm : I
    //   162: invokevirtual findViewById : (I)Landroid/view/View;
    //   165: checkcast android/widget/NumberPicker
    //   168: putfield mAmPmSpinner : Landroid/widget/NumberPicker;
    //   171: iload #8
    //   173: ldc 3600000
    //   175: idiv
    //   176: istore #7
    //   178: iload_2
    //   179: ldc 3600000
    //   181: idiv
    //   182: istore #13
    //   184: iload #8
    //   186: iload #7
    //   188: ldc 3600000
    //   190: imul
    //   191: isub
    //   192: istore #15
    //   194: iload_2
    //   195: iload #13
    //   197: ldc 3600000
    //   199: imul
    //   200: isub
    //   201: istore #16
    //   203: iload #7
    //   205: iload #13
    //   207: if_icmpne -> 224
    //   210: aload_0
    //   211: getfield mHourSpinner : Landroid/widget/NumberPicker;
    //   214: iconst_0
    //   215: invokevirtual setEnabled : (Z)V
    //   218: iload #7
    //   220: istore_2
    //   221: goto -> 226
    //   224: iload_3
    //   225: istore_2
    //   226: iload #10
    //   228: ifeq -> 253
    //   231: aload_0
    //   232: getfield mAmPmSpinner : Landroid/widget/NumberPicker;
    //   235: bipush #8
    //   237: invokevirtual setVisibility : (I)V
    //   240: iload #7
    //   242: istore_3
    //   243: iload #13
    //   245: istore #7
    //   247: iload_2
    //   248: istore #8
    //   250: goto -> 442
    //   253: iload #7
    //   255: bipush #12
    //   257: idiv
    //   258: istore #8
    //   260: iload #13
    //   262: bipush #12
    //   264: idiv
    //   265: istore #14
    //   267: iload_2
    //   268: bipush #12
    //   270: idiv
    //   271: istore #12
    //   273: aload_0
    //   274: getfield mAmPmSpinner : Landroid/widget/NumberPicker;
    //   277: iload #8
    //   279: invokevirtual setMinValue : (I)V
    //   282: aload_0
    //   283: getfield mAmPmSpinner : Landroid/widget/NumberPicker;
    //   286: iload #14
    //   288: invokevirtual setMaxValue : (I)V
    //   291: aload_0
    //   292: getfield mAmPmSpinner : Landroid/widget/NumberPicker;
    //   295: iconst_2
    //   296: anewarray java/lang/String
    //   299: dup
    //   300: iconst_0
    //   301: aload_1
    //   302: getstatic org/chromium/content/R$string.time_picker_dialog_am : I
    //   305: invokevirtual getString : (I)Ljava/lang/String;
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: aload_1
    //   312: getstatic org/chromium/content/R$string.time_picker_dialog_pm : I
    //   315: invokevirtual getString : (I)Ljava/lang/String;
    //   318: aastore
    //   319: invokevirtual setDisplayedValues : ([Ljava/lang/String;)V
    //   322: iload_2
    //   323: bipush #12
    //   325: irem
    //   326: istore_2
    //   327: iload_2
    //   328: istore_3
    //   329: iload_2
    //   330: ifne -> 336
    //   333: bipush #12
    //   335: istore_3
    //   336: iload #8
    //   338: iload #14
    //   340: if_icmpne -> 414
    //   343: aload_0
    //   344: getfield mAmPmSpinner : Landroid/widget/NumberPicker;
    //   347: iconst_0
    //   348: invokevirtual setEnabled : (Z)V
    //   351: iload #7
    //   353: bipush #12
    //   355: irem
    //   356: istore #12
    //   358: iload #13
    //   360: bipush #12
    //   362: irem
    //   363: istore #13
    //   365: iload #12
    //   367: ifne -> 381
    //   370: iload #13
    //   372: ifne -> 381
    //   375: bipush #12
    //   377: istore_2
    //   378: goto -> 420
    //   381: iload #12
    //   383: ifne -> 392
    //   386: iload #13
    //   388: istore_2
    //   389: goto -> 420
    //   392: iload #8
    //   394: istore #14
    //   396: iload #12
    //   398: istore_2
    //   399: iload #13
    //   401: istore #7
    //   403: iload #13
    //   405: ifne -> 428
    //   408: iload #12
    //   410: istore_2
    //   411: goto -> 420
    //   414: iload #12
    //   416: istore #8
    //   418: iconst_1
    //   419: istore_2
    //   420: bipush #12
    //   422: istore #7
    //   424: iload #8
    //   426: istore #14
    //   428: aload_0
    //   429: getfield mAmPmSpinner : Landroid/widget/NumberPicker;
    //   432: iload #14
    //   434: invokevirtual setValue : (I)V
    //   437: iload_3
    //   438: istore #8
    //   440: iload_2
    //   441: istore_3
    //   442: iload_3
    //   443: iload #7
    //   445: if_icmpne -> 456
    //   448: aload_0
    //   449: getfield mHourSpinner : Landroid/widget/NumberPicker;
    //   452: iconst_0
    //   453: invokevirtual setEnabled : (Z)V
    //   456: aload_0
    //   457: getfield mHourSpinner : Landroid/widget/NumberPicker;
    //   460: iload_3
    //   461: invokevirtual setMinValue : (I)V
    //   464: aload_0
    //   465: getfield mHourSpinner : Landroid/widget/NumberPicker;
    //   468: iload #7
    //   470: invokevirtual setMaxValue : (I)V
    //   473: aload_0
    //   474: getfield mHourSpinner : Landroid/widget/NumberPicker;
    //   477: iload #8
    //   479: invokevirtual setValue : (I)V
    //   482: new org/chromium/content/browser/picker/MultiFieldTimePickerDialog$NumberFormatter
    //   485: dup
    //   486: ldc '%02d'
    //   488: invokespecial <init> : (Ljava/lang/String;)V
    //   491: astore_1
    //   492: iload #15
    //   494: ldc 60000
    //   496: idiv
    //   497: istore #8
    //   499: iload #16
    //   501: ldc 60000
    //   503: idiv
    //   504: istore #13
    //   506: iload #15
    //   508: iload #8
    //   510: ldc 60000
    //   512: imul
    //   513: isub
    //   514: istore #14
    //   516: iload #16
    //   518: iload #13
    //   520: ldc 60000
    //   522: imul
    //   523: isub
    //   524: istore #16
    //   526: iload_3
    //   527: iload #7
    //   529: if_icmpne -> 591
    //   532: aload_0
    //   533: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   536: iload #8
    //   538: invokevirtual setMinValue : (I)V
    //   541: aload_0
    //   542: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   545: iload #13
    //   547: invokevirtual setMaxValue : (I)V
    //   550: iload #8
    //   552: iload #13
    //   554: if_icmpne -> 608
    //   557: aload_0
    //   558: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   561: iconst_1
    //   562: anewarray java/lang/String
    //   565: dup
    //   566: iconst_0
    //   567: aload_1
    //   568: iload #8
    //   570: invokevirtual format : (I)Ljava/lang/String;
    //   573: aastore
    //   574: invokevirtual setDisplayedValues : ([Ljava/lang/String;)V
    //   577: aload_0
    //   578: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   581: iconst_0
    //   582: invokevirtual setEnabled : (Z)V
    //   585: iload #8
    //   587: istore_2
    //   588: goto -> 611
    //   591: aload_0
    //   592: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   595: iconst_0
    //   596: invokevirtual setMinValue : (I)V
    //   599: aload_0
    //   600: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   603: bipush #59
    //   605: invokevirtual setMaxValue : (I)V
    //   608: iload #4
    //   610: istore_2
    //   611: aload_0
    //   612: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   615: iload_2
    //   616: invokevirtual setValue : (I)V
    //   619: iload #9
    //   621: ldc 3600000
    //   623: irem
    //   624: ifne -> 644
    //   627: aload_0
    //   628: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   631: iconst_0
    //   632: invokevirtual setEnabled : (Z)V
    //   635: aload_0
    //   636: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   639: iload #8
    //   641: invokevirtual setValue : (I)V
    //   644: aload_0
    //   645: getfield mMinuteSpinner : Landroid/widget/NumberPicker;
    //   648: aload_1
    //   649: invokevirtual setFormatter : (Landroid/widget/NumberPicker$Formatter;)V
    //   652: iload #9
    //   654: ldc 60000
    //   656: if_icmplt -> 681
    //   659: aload #11
    //   661: getstatic org/chromium/content/R$id.second_colon : I
    //   664: invokevirtual findViewById : (I)Landroid/view/View;
    //   667: bipush #8
    //   669: invokevirtual setVisibility : (I)V
    //   672: aload_0
    //   673: getfield mSecSpinner : Landroid/widget/NumberPicker;
    //   676: bipush #8
    //   678: invokevirtual setVisibility : (I)V
    //   681: iload #14
    //   683: sipush #1000
    //   686: idiv
    //   687: istore #12
    //   689: iload #16
    //   691: sipush #1000
    //   694: idiv
    //   695: istore #15
    //   697: iload #14
    //   699: iload #12
    //   701: sipush #1000
    //   704: imul
    //   705: isub
    //   706: istore_2
    //   707: iload #16
    //   709: iload #15
    //   711: sipush #1000
    //   714: imul
    //   715: isub
    //   716: istore #14
    //   718: iload_3
    //   719: iload #7
    //   721: if_icmpne -> 791
    //   724: iload #8
    //   726: iload #13
    //   728: if_icmpne -> 791
    //   731: aload_0
    //   732: getfield mSecSpinner : Landroid/widget/NumberPicker;
    //   735: iload #12
    //   737: invokevirtual setMinValue : (I)V
    //   740: aload_0
    //   741: getfield mSecSpinner : Landroid/widget/NumberPicker;
    //   744: iload #15
    //   746: invokevirtual setMaxValue : (I)V
    //   749: iload #12
    //   751: iload #15
    //   753: if_icmpne -> 808
    //   756: aload_0
    //   757: getfield mSecSpinner : Landroid/widget/NumberPicker;
    //   760: iconst_1
    //   761: anewarray java/lang/String
    //   764: dup
    //   765: iconst_0
    //   766: aload_1
    //   767: iload #12
    //   769: invokevirtual format : (I)Ljava/lang/String;
    //   772: aastore
    //   773: invokevirtual setDisplayedValues : ([Ljava/lang/String;)V
    //   776: aload_0
    //   777: getfield mSecSpinner : Landroid/widget/NumberPicker;
    //   780: iconst_0
    //   781: invokevirtual setEnabled : (Z)V
    //   784: iload #12
    //   786: istore #4
    //   788: goto -> 812
    //   791: aload_0
    //   792: getfield mSecSpinner : Landroid/widget/NumberPicker;
    //   795: iconst_0
    //   796: invokevirtual setMinValue : (I)V
    //   799: aload_0
    //   800: getfield mSecSpinner : Landroid/widget/NumberPicker;
    //   803: bipush #59
    //   805: invokevirtual setMaxValue : (I)V
    //   808: iload #5
    //   810: istore #4
    //   812: aload_0
    //   813: getfield mSecSpinner : Landroid/widget/NumberPicker;
    //   816: iload #4
    //   818: invokevirtual setValue : (I)V
    //   821: aload_0
    //   822: getfield mSecSpinner : Landroid/widget/NumberPicker;
    //   825: aload_1
    //   826: invokevirtual setFormatter : (Landroid/widget/NumberPicker$Formatter;)V
    //   829: iload #9
    //   831: sipush #1000
    //   834: if_icmplt -> 859
    //   837: aload #11
    //   839: getstatic org/chromium/content/R$id.second_dot : I
    //   842: invokevirtual findViewById : (I)Landroid/view/View;
    //   845: bipush #8
    //   847: invokevirtual setVisibility : (I)V
    //   850: aload_0
    //   851: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   854: bipush #8
    //   856: invokevirtual setVisibility : (I)V
    //   859: iload #6
    //   861: iload #9
    //   863: iconst_2
    //   864: idiv
    //   865: iadd
    //   866: iload #9
    //   868: idiv
    //   869: iload #9
    //   871: imul
    //   872: istore #4
    //   874: iload #9
    //   876: iconst_1
    //   877: if_icmpeq -> 1012
    //   880: iload #9
    //   882: bipush #10
    //   884: if_icmpeq -> 1012
    //   887: iload #9
    //   889: bipush #100
    //   891: if_icmpne -> 897
    //   894: goto -> 1012
    //   897: iload #9
    //   899: sipush #1000
    //   902: if_icmpge -> 1181
    //   905: new java/util/ArrayList
    //   908: dup
    //   909: invokespecial <init> : ()V
    //   912: astore_1
    //   913: iload_2
    //   914: istore_3
    //   915: iload_3
    //   916: iload #14
    //   918: if_icmpge -> 950
    //   921: aload_1
    //   922: ldc '%03d'
    //   924: iconst_1
    //   925: anewarray java/lang/Object
    //   928: dup
    //   929: iconst_0
    //   930: iload_3
    //   931: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   934: aastore
    //   935: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   938: invokevirtual add : (Ljava/lang/Object;)Z
    //   941: pop
    //   942: iload_3
    //   943: iload #9
    //   945: iadd
    //   946: istore_3
    //   947: goto -> 915
    //   950: aload_0
    //   951: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   954: iconst_0
    //   955: invokevirtual setMinValue : (I)V
    //   958: aload_0
    //   959: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   962: aload_1
    //   963: invokevirtual size : ()I
    //   966: iconst_1
    //   967: isub
    //   968: invokevirtual setMaxValue : (I)V
    //   971: aload_0
    //   972: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   975: iload #4
    //   977: iload_2
    //   978: isub
    //   979: iload #9
    //   981: idiv
    //   982: invokevirtual setValue : (I)V
    //   985: aload_0
    //   986: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   989: aload_1
    //   990: aload_1
    //   991: invokevirtual size : ()I
    //   994: anewarray java/lang/String
    //   997: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   1000: checkcast [Ljava/lang/String;
    //   1003: invokevirtual setDisplayedValues : ([Ljava/lang/String;)V
    //   1006: aload_0
    //   1007: iload_2
    //   1008: putfield mBaseMilli : I
    //   1011: return
    //   1012: iload_3
    //   1013: iload #7
    //   1015: if_icmpne -> 1072
    //   1018: iload #8
    //   1020: iload #13
    //   1022: if_icmpne -> 1072
    //   1025: iload #12
    //   1027: iload #15
    //   1029: if_icmpne -> 1072
    //   1032: aload_0
    //   1033: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   1036: iload_2
    //   1037: iload #9
    //   1039: idiv
    //   1040: invokevirtual setMinValue : (I)V
    //   1043: aload_0
    //   1044: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   1047: iload #14
    //   1049: iload #9
    //   1051: idiv
    //   1052: invokevirtual setMaxValue : (I)V
    //   1055: iload_2
    //   1056: iload #14
    //   1058: if_icmpne -> 1093
    //   1061: aload_0
    //   1062: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   1065: iconst_0
    //   1066: invokevirtual setEnabled : (Z)V
    //   1069: goto -> 1096
    //   1072: aload_0
    //   1073: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   1076: iconst_0
    //   1077: invokevirtual setMinValue : (I)V
    //   1080: aload_0
    //   1081: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   1084: sipush #999
    //   1087: iload #9
    //   1089: idiv
    //   1090: invokevirtual setMaxValue : (I)V
    //   1093: iload #4
    //   1095: istore_2
    //   1096: iload #9
    //   1098: iconst_1
    //   1099: if_icmpne -> 1121
    //   1102: aload_0
    //   1103: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   1106: new org/chromium/content/browser/picker/MultiFieldTimePickerDialog$NumberFormatter
    //   1109: dup
    //   1110: ldc '%03d'
    //   1112: invokespecial <init> : (Ljava/lang/String;)V
    //   1115: invokevirtual setFormatter : (Landroid/widget/NumberPicker$Formatter;)V
    //   1118: goto -> 1170
    //   1121: iload #9
    //   1123: bipush #10
    //   1125: if_icmpne -> 1147
    //   1128: aload_0
    //   1129: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   1132: new org/chromium/content/browser/picker/MultiFieldTimePickerDialog$NumberFormatter
    //   1135: dup
    //   1136: ldc '%02d'
    //   1138: invokespecial <init> : (Ljava/lang/String;)V
    //   1141: invokevirtual setFormatter : (Landroid/widget/NumberPicker$Formatter;)V
    //   1144: goto -> 1170
    //   1147: iload #9
    //   1149: bipush #100
    //   1151: if_icmpne -> 1170
    //   1154: aload_0
    //   1155: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   1158: new org/chromium/content/browser/picker/MultiFieldTimePickerDialog$NumberFormatter
    //   1161: dup
    //   1162: ldc '%d'
    //   1164: invokespecial <init> : (Ljava/lang/String;)V
    //   1167: invokevirtual setFormatter : (Landroid/widget/NumberPicker$Formatter;)V
    //   1170: aload_0
    //   1171: getfield mMilliSpinner : Landroid/widget/NumberPicker;
    //   1174: iload_2
    //   1175: iload #9
    //   1177: idiv
    //   1178: invokevirtual setValue : (I)V
    //   1181: aload_0
    //   1182: iconst_0
    //   1183: putfield mBaseMilli : I
    //   1186: return
  }
  
  private static int getPickerValue(NumberPicker paramNumberPicker) {
    paramNumberPicker.clearFocus();
    return paramNumberPicker.getValue();
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt) {
    paramInt = getPickerValue(this.mHourSpinner);
    int j = getPickerValue(this.mMinuteSpinner);
    int k = getPickerValue(this.mSecSpinner);
    int m = getPickerValue(this.mMilliSpinner);
    int n = this.mStep;
    int i1 = this.mBaseMilli;
    int i = paramInt;
    if (!this.mIs24hourFormat) {
      int i2 = getPickerValue(this.mAmPmSpinner);
      i = paramInt;
      if (paramInt == 12)
        i = 0; 
      i += i2 * 12;
    } 
    this.mListener.onTimeSet(i, j, k, m * n + i1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\MultiFieldTimePickerDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */