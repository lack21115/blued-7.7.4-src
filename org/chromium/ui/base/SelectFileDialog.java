package org.chromium.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.AsyncTask;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.ui.UiUtils;

public class SelectFileDialog implements WindowAndroid$IntentCallback {
  private static final String[] POPULAR_IMAGE_EXTENSIONS;
  
  private static final String[] POPULAR_VIDEO_EXTENSIONS;
  
  @SuppressLint({"StaticFieldLeak"})
  private static WindowAndroid sOverrideWindowAndroid;
  
  private boolean mAllowMultiple;
  
  private Uri mCameraOutputUri;
  
  boolean mCapture;
  
  private List mFileTypes;
  
  private final long mNativeSelectFileDialog;
  
  private boolean mSupportsAudioCapture;
  
  private boolean mSupportsImageCapture;
  
  private boolean mSupportsVideoCapture;
  
  private WindowAndroid mWindowAndroid;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private SelectFileDialog(long paramLong) {
    this.mNativeSelectFileDialog = paramLong;
  }
  
  private boolean acceptsSpecificType(String paramString) {
    return (this.mFileTypes.size() == 1 && TextUtils.equals(this.mFileTypes.get(0), paramString));
  }
  
  private boolean captureImage() {
    return (this.mCapture && acceptsSpecificType("image/*"));
  }
  
  private static List convertToImageMimeTypes(List paramList) {
    if (paramList.size() == 0)
      return null; 
    ArrayList<String> arrayList = new ArrayList();
    for (String str : paramList) {
      if (str.length() == 0) {
        str = "";
      } else {
        String str1 = MimeTypeMap.getFileExtensionFromUrl(str);
        if (str1.length() > 0) {
          str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str1);
          if (str == null)
            str = "application/octet-stream"; 
        } 
      } 
      if (!str.startsWith("image/"))
        return null; 
      if (!arrayList.contains(str))
        arrayList.add(str); 
    } 
    return arrayList;
  }
  
  private int countAcceptTypesFor(String paramString) {
    Iterator<String> iterator = this.mFileTypes.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i = j) {
      int j = i;
      if (((String)iterator.next()).startsWith(paramString))
        j = i + 1; 
    } 
    return i;
  }
  
  @CalledByNative
  static SelectFileDialog create(long paramLong) {
    return new SelectFileDialog(paramLong);
  }
  
  private void launchSelectFileWithCameraIntent(Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mFileTypes : Ljava/util/List;
    //   4: invokeinterface size : ()I
    //   9: ifne -> 17
    //   12: iconst_0
    //   13: istore_2
    //   14: goto -> 256
    //   17: aload_0
    //   18: ldc 'image/'
    //   20: invokespecial countAcceptTypesFor : (Ljava/lang/String;)I
    //   23: istore_2
    //   24: aload_0
    //   25: ldc 'video/'
    //   27: invokespecial countAcceptTypesFor : (Ljava/lang/String;)I
    //   30: istore_3
    //   31: iload_2
    //   32: istore #4
    //   34: iload_3
    //   35: istore #5
    //   37: aload_0
    //   38: getfield mFileTypes : Ljava/util/List;
    //   41: invokeinterface size : ()I
    //   46: iload_2
    //   47: iload_3
    //   48: iadd
    //   49: if_icmple -> 213
    //   52: aload_0
    //   53: getfield mFileTypes : Ljava/util/List;
    //   56: invokeinterface iterator : ()Ljava/util/Iterator;
    //   61: astore #8
    //   63: iload_2
    //   64: istore #4
    //   66: iload_3
    //   67: istore #5
    //   69: aload #8
    //   71: invokeinterface hasNext : ()Z
    //   76: ifeq -> 213
    //   79: aload #8
    //   81: invokeinterface next : ()Ljava/lang/Object;
    //   86: checkcast java/lang/String
    //   89: astore #9
    //   91: getstatic org/chromium/ui/base/SelectFileDialog.POPULAR_IMAGE_EXTENSIONS : [Ljava/lang/String;
    //   94: astore #10
    //   96: aload #10
    //   98: arraylength
    //   99: istore #5
    //   101: iconst_0
    //   102: istore #4
    //   104: iload #4
    //   106: iload #5
    //   108: if_icmpge -> 143
    //   111: aload #9
    //   113: aload #10
    //   115: iload #4
    //   117: aaload
    //   118: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   121: ifeq -> 134
    //   124: iload_2
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: iconst_1
    //   129: istore #5
    //   131: goto -> 146
    //   134: iload #4
    //   136: iconst_1
    //   137: iadd
    //   138: istore #4
    //   140: goto -> 104
    //   143: iconst_0
    //   144: istore #5
    //   146: iload_3
    //   147: istore #4
    //   149: iload #5
    //   151: ifne -> 207
    //   154: getstatic org/chromium/ui/base/SelectFileDialog.POPULAR_VIDEO_EXTENSIONS : [Ljava/lang/String;
    //   157: astore #10
    //   159: aload #10
    //   161: arraylength
    //   162: istore #5
    //   164: iconst_0
    //   165: istore #4
    //   167: iload #4
    //   169: iload #5
    //   171: if_icmpge -> 204
    //   174: aload #9
    //   176: aload #10
    //   178: iload #4
    //   180: aaload
    //   181: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   184: ifeq -> 195
    //   187: iload_3
    //   188: iconst_1
    //   189: iadd
    //   190: istore #4
    //   192: goto -> 207
    //   195: iload #4
    //   197: iconst_1
    //   198: iadd
    //   199: istore #4
    //   201: goto -> 167
    //   204: iload_3
    //   205: istore #4
    //   207: iload #4
    //   209: istore_3
    //   210: goto -> 63
    //   213: aload_0
    //   214: getfield mFileTypes : Ljava/util/List;
    //   217: invokeinterface size : ()I
    //   222: iload #4
    //   224: isub
    //   225: iload #5
    //   227: isub
    //   228: ifle -> 234
    //   231: goto -> 12
    //   234: iload #5
    //   236: ifle -> 254
    //   239: iload #4
    //   241: ifne -> 249
    //   244: iconst_2
    //   245: istore_2
    //   246: goto -> 256
    //   249: iconst_3
    //   250: istore_2
    //   251: goto -> 256
    //   254: iconst_1
    //   255: istore_2
    //   256: ldc 'Android.SelectFileDialogScope'
    //   258: iload_2
    //   259: iconst_4
    //   260: invokestatic recordEnumeratedHistogram : (Ljava/lang/String;II)V
    //   263: aload_0
    //   264: getfield mWindowAndroid : Lorg/chromium/ui/base/WindowAndroid;
    //   267: ldc 'android.permission.CAMERA'
    //   269: invokevirtual hasPermission : (Ljava/lang/String;)Z
    //   272: istore #6
    //   274: aload_0
    //   275: getfield mSupportsVideoCapture : Z
    //   278: istore #7
    //   280: aconst_null
    //   281: astore #10
    //   283: iload #7
    //   285: ifeq -> 307
    //   288: iload #6
    //   290: ifeq -> 307
    //   293: new android/content/Intent
    //   296: dup
    //   297: ldc 'android.media.action.VIDEO_CAPTURE'
    //   299: invokespecial <init> : (Ljava/lang/String;)V
    //   302: astore #8
    //   304: goto -> 310
    //   307: aconst_null
    //   308: astore #8
    //   310: aload_0
    //   311: getfield mWindowAndroid : Lorg/chromium/ui/base/WindowAndroid;
    //   314: ldc 'android.permission.RECORD_AUDIO'
    //   316: invokevirtual hasPermission : (Ljava/lang/String;)Z
    //   319: istore #6
    //   321: aload #10
    //   323: astore #9
    //   325: aload_0
    //   326: getfield mSupportsAudioCapture : Z
    //   329: ifeq -> 352
    //   332: aload #10
    //   334: astore #9
    //   336: iload #6
    //   338: ifeq -> 352
    //   341: new android/content/Intent
    //   344: dup
    //   345: ldc 'android.provider.MediaStore.RECORD_SOUND'
    //   347: invokespecial <init> : (Ljava/lang/String;)V
    //   350: astore #9
    //   352: aload_0
    //   353: invokespecial captureImage : ()Z
    //   356: ifeq -> 382
    //   359: aload_1
    //   360: ifnull -> 382
    //   363: aload_0
    //   364: getfield mWindowAndroid : Lorg/chromium/ui/base/WindowAndroid;
    //   367: aload_1
    //   368: aload_0
    //   369: getstatic org/chromium/ui/R$string.low_memory_error : I
    //   372: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   375: invokevirtual showIntent : (Landroid/content/Intent;Lorg/chromium/ui/base/WindowAndroid$IntentCallback;Ljava/lang/Integer;)Z
    //   378: ifeq -> 486
    //   381: return
    //   382: aload_0
    //   383: getfield mCapture : Z
    //   386: ifeq -> 403
    //   389: aload_0
    //   390: ldc 'video/*'
    //   392: invokespecial acceptsSpecificType : (Ljava/lang/String;)Z
    //   395: ifeq -> 403
    //   398: iconst_1
    //   399: istore_2
    //   400: goto -> 405
    //   403: iconst_0
    //   404: istore_2
    //   405: iload_2
    //   406: ifeq -> 434
    //   409: aload #8
    //   411: ifnull -> 434
    //   414: aload_0
    //   415: getfield mWindowAndroid : Lorg/chromium/ui/base/WindowAndroid;
    //   418: aload #8
    //   420: aload_0
    //   421: getstatic org/chromium/ui/R$string.low_memory_error : I
    //   424: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   427: invokevirtual showIntent : (Landroid/content/Intent;Lorg/chromium/ui/base/WindowAndroid$IntentCallback;Ljava/lang/Integer;)Z
    //   430: ifeq -> 486
    //   433: return
    //   434: aload_0
    //   435: getfield mCapture : Z
    //   438: ifeq -> 455
    //   441: aload_0
    //   442: ldc 'audio/*'
    //   444: invokespecial acceptsSpecificType : (Ljava/lang/String;)Z
    //   447: ifeq -> 455
    //   450: iconst_1
    //   451: istore_2
    //   452: goto -> 457
    //   455: iconst_0
    //   456: istore_2
    //   457: iload_2
    //   458: ifeq -> 486
    //   461: aload #9
    //   463: ifnull -> 486
    //   466: aload_0
    //   467: getfield mWindowAndroid : Lorg/chromium/ui/base/WindowAndroid;
    //   470: aload #9
    //   472: aload_0
    //   473: getstatic org/chromium/ui/R$string.low_memory_error : I
    //   476: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   479: invokevirtual showIntent : (Landroid/content/Intent;Lorg/chromium/ui/base/WindowAndroid$IntentCallback;Ljava/lang/Integer;)Z
    //   482: ifeq -> 486
    //   485: return
    //   486: aload_0
    //   487: getfield mWindowAndroid : Lorg/chromium/ui/base/WindowAndroid;
    //   490: invokevirtual getActivity : ()Ljava/lang/ref/WeakReference;
    //   493: invokevirtual get : ()Ljava/lang/Object;
    //   496: pop
    //   497: aload_0
    //   498: getfield mFileTypes : Ljava/util/List;
    //   501: invokestatic convertToImageMimeTypes : (Ljava/util/List;)Ljava/util/List;
    //   504: pop
    //   505: aload_0
    //   506: invokespecial shouldUseContactsPicker : ()Z
    //   509: ifeq -> 523
    //   512: invokestatic showContactsPicker$9c96337 : ()Z
    //   515: ifeq -> 523
    //   518: aload_0
    //   519: invokevirtual onFileNotSelected : ()V
    //   522: return
    //   523: aload_0
    //   524: invokespecial shouldUsePhotoPicker : ()Z
    //   527: ifeq -> 537
    //   530: invokestatic showPhotoPicker$7771399e : ()Z
    //   533: ifeq -> 537
    //   536: return
    //   537: new android/content/Intent
    //   540: dup
    //   541: ldc_w 'android.intent.action.GET_CONTENT'
    //   544: invokespecial <init> : (Ljava/lang/String;)V
    //   547: astore #10
    //   549: getstatic android/os/Build$VERSION.SDK_INT : I
    //   552: bipush #18
    //   554: if_icmplt -> 574
    //   557: aload_0
    //   558: getfield mAllowMultiple : Z
    //   561: ifeq -> 574
    //   564: aload #10
    //   566: ldc_w 'android.intent.extra.ALLOW_MULTIPLE'
    //   569: iconst_1
    //   570: invokevirtual putExtra : (Ljava/lang/String;Z)Landroid/content/Intent;
    //   573: pop
    //   574: new java/util/ArrayList
    //   577: dup
    //   578: invokespecial <init> : ()V
    //   581: astore #11
    //   583: aload_0
    //   584: invokespecial noSpecificType : ()Z
    //   587: ifne -> 687
    //   590: aload_0
    //   591: invokespecial shouldShowImageTypes : ()Z
    //   594: ifeq -> 619
    //   597: aload_1
    //   598: ifnull -> 608
    //   601: aload #11
    //   603: aload_1
    //   604: invokevirtual add : (Ljava/lang/Object;)Z
    //   607: pop
    //   608: aload #10
    //   610: ldc 'image/*'
    //   612: invokevirtual setType : (Ljava/lang/String;)Landroid/content/Intent;
    //   615: pop
    //   616: goto -> 678
    //   619: aload_0
    //   620: invokespecial shouldShowVideoTypes : ()Z
    //   623: ifeq -> 650
    //   626: aload #8
    //   628: ifnull -> 639
    //   631: aload #11
    //   633: aload #8
    //   635: invokevirtual add : (Ljava/lang/Object;)Z
    //   638: pop
    //   639: aload #10
    //   641: ldc 'video/*'
    //   643: invokevirtual setType : (Ljava/lang/String;)Landroid/content/Intent;
    //   646: pop
    //   647: goto -> 678
    //   650: aload_0
    //   651: invokespecial shouldShowAudioTypes : ()Z
    //   654: ifeq -> 678
    //   657: aload #9
    //   659: ifnull -> 670
    //   662: aload #11
    //   664: aload #9
    //   666: invokevirtual add : (Ljava/lang/Object;)Z
    //   669: pop
    //   670: aload #10
    //   672: ldc 'audio/*'
    //   674: invokevirtual setType : (Ljava/lang/String;)Landroid/content/Intent;
    //   677: pop
    //   678: aload #10
    //   680: ldc_w 'android.intent.category.OPENABLE'
    //   683: invokevirtual addCategory : (Ljava/lang/String;)Landroid/content/Intent;
    //   686: pop
    //   687: aload #11
    //   689: invokevirtual isEmpty : ()Z
    //   692: ifeq -> 741
    //   695: aload #10
    //   697: ldc_w '*/*'
    //   700: invokevirtual setType : (Ljava/lang/String;)Landroid/content/Intent;
    //   703: pop
    //   704: aload_1
    //   705: ifnull -> 715
    //   708: aload #11
    //   710: aload_1
    //   711: invokevirtual add : (Ljava/lang/Object;)Z
    //   714: pop
    //   715: aload #8
    //   717: ifnull -> 728
    //   720: aload #11
    //   722: aload #8
    //   724: invokevirtual add : (Ljava/lang/Object;)Z
    //   727: pop
    //   728: aload #9
    //   730: ifnull -> 741
    //   733: aload #11
    //   735: aload #9
    //   737: invokevirtual add : (Ljava/lang/Object;)Z
    //   740: pop
    //   741: new android/content/Intent
    //   744: dup
    //   745: ldc_w 'android.intent.action.CHOOSER'
    //   748: invokespecial <init> : (Ljava/lang/String;)V
    //   751: astore_1
    //   752: aload #11
    //   754: invokevirtual isEmpty : ()Z
    //   757: ifne -> 780
    //   760: aload_1
    //   761: ldc_w 'android.intent.extra.INITIAL_INTENTS'
    //   764: aload #11
    //   766: iconst_0
    //   767: anewarray android/content/Intent
    //   770: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   773: checkcast [Landroid/os/Parcelable;
    //   776: invokevirtual putExtra : (Ljava/lang/String;[Landroid/os/Parcelable;)Landroid/content/Intent;
    //   779: pop
    //   780: aload_1
    //   781: ldc_w 'android.intent.extra.INTENT'
    //   784: aload #10
    //   786: invokevirtual putExtra : (Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   789: pop
    //   790: aload_0
    //   791: getfield mWindowAndroid : Lorg/chromium/ui/base/WindowAndroid;
    //   794: aload_1
    //   795: aload_0
    //   796: getstatic org/chromium/ui/R$string.low_memory_error : I
    //   799: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   802: invokevirtual showIntent : (Landroid/content/Intent;Lorg/chromium/ui/base/WindowAndroid$IntentCallback;Ljava/lang/Integer;)Z
    //   805: ifne -> 812
    //   808: aload_0
    //   809: invokevirtual onFileNotSelected : ()V
    //   812: return
  }
  
  private native void nativeOnFileNotSelected(long paramLong);
  
  private native void nativeOnFileSelected(long paramLong, String paramString1, String paramString2);
  
  private native void nativeOnMultipleFilesSelected(long paramLong, String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  private boolean noSpecificType() {
    return (this.mFileTypes.size() == 1) ? (this.mFileTypes.contains("*/*")) : true;
  }
  
  @TargetApi(18)
  @CalledByNative
  private void selectFile(String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, WindowAndroid paramWindowAndroid) {
    WindowAndroid windowAndroid;
    this.mFileTypes = new ArrayList(Arrays.asList((Object[])paramArrayOfString));
    this.mCapture = paramBoolean1;
    this.mAllowMultiple = paramBoolean2;
    if (sOverrideWindowAndroid == null) {
      windowAndroid = paramWindowAndroid;
    } else {
      windowAndroid = sOverrideWindowAndroid;
    } 
    this.mWindowAndroid = windowAndroid;
    this.mSupportsImageCapture = WindowAndroid.canResolveActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
    this.mSupportsVideoCapture = WindowAndroid.canResolveActivity(new Intent("android.media.action.VIDEO_CAPTURE"));
    this.mSupportsAudioCapture = WindowAndroid.canResolveActivity(new Intent("android.provider.MediaStore.RECORD_SOUND"));
    ArrayList<String> arrayList = new ArrayList();
    if (shouldUseContactsPicker()) {
      if (!paramWindowAndroid.hasPermission("android.permission.READ_CONTACTS"))
        arrayList.add("android.permission.READ_CONTACTS"); 
    } else if (shouldUsePhotoPicker()) {
      if (!paramWindowAndroid.hasPermission("android.permission.READ_EXTERNAL_STORAGE"))
        arrayList.add("android.permission.READ_EXTERNAL_STORAGE"); 
    } else {
      if (((this.mSupportsImageCapture && shouldShowImageTypes()) || (this.mSupportsVideoCapture && shouldShowVideoTypes())) && !paramWindowAndroid.hasPermission("android.permission.CAMERA"))
        arrayList.add("android.permission.CAMERA"); 
      if (this.mSupportsAudioCapture && shouldShowAudioTypes() && !paramWindowAndroid.hasPermission("android.permission.RECORD_AUDIO"))
        arrayList.add("android.permission.RECORD_AUDIO"); 
    } 
    if (arrayList.isEmpty()) {
      launchSelectFileIntent();
      return;
    } 
    paramWindowAndroid.requestPermissions(arrayList.<String>toArray(new String[arrayList.size()]), new SelectFileDialog$$Lambda$0(this));
  }
  
  private boolean shouldShowAudioTypes() {
    return shouldShowTypes("audio/*", "audio/");
  }
  
  private boolean shouldShowImageTypes() {
    return shouldShowTypes("image/*", "image/");
  }
  
  private boolean shouldShowTypes(String paramString1, String paramString2) {
    return !noSpecificType() ? (this.mFileTypes.contains(paramString1) ? true : ((countAcceptTypesFor(paramString2) > 0))) : true;
  }
  
  private boolean shouldShowVideoTypes() {
    return shouldShowTypes("video/*", "video/");
  }
  
  private boolean shouldUseContactsPicker() {
    return (this.mFileTypes.size() != 1) ? false : (!((String)this.mFileTypes.get(0)).equals("text/json+contacts") ? false : ((UiUtils.shouldShowContactsPicker() && this.mWindowAndroid.getActivity().get() != null)));
  }
  
  private boolean shouldUsePhotoPicker() {
    List list = convertToImageMimeTypes(this.mFileTypes);
    return (!captureImage() && list != null && UiUtils.shouldShowPhotoPicker() && this.mWindowAndroid.getActivity().get() != null);
  }
  
  final void launchSelectFileIntent() {
    boolean bool = this.mWindowAndroid.hasPermission("android.permission.CAMERA");
    if (this.mSupportsImageCapture && bool) {
      (new SelectFileDialog$GetCameraIntentTask(this, Boolean.valueOf(false), this.mWindowAndroid, this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
      return;
    } 
    launchSelectFileWithCameraIntent(null);
  }
  
  final void onFileNotSelected() {
    boolean bool;
    long l = this.mNativeSelectFileDialog;
    if (convertToImageMimeTypes(this.mFileTypes) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      RecordHistogram.recordCount100Histogram("Android.SelectFileDialogImgCount", 0); 
    nativeOnFileNotSelected(l);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\SelectFileDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */