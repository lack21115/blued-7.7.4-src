package com.soft.blued.emoticon.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.Zip;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.google.common.base.Charsets;
import com.google.gson.reflect.TypeToken;
import com.soft.blued.emoticon.model.EmoticonModel;
import com.soft.blued.emoticon.model.EmoticonPackageModel;
import com.soft.blued.emoticon.model.EmotionPackDownload;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmotionManager {
  static final Pattern a;
  
  private static Set<EmotionPackListener> b;
  
  private static EmoticonPackageModel c;
  
  private static List<EmoticonPackageModel> d = new ArrayList<EmoticonPackageModel>();
  
  private static boolean e = false;
  
  private static boolean f = false;
  
  private static BluedUIHttpResponse g;
  
  static {
    a = Pattern.compile("\\S*[?]\\S*");
    g = new BluedUIHttpResponse<BluedEntityA<EmoticonPackageModel>>() {
        protected void a(BluedEntityA<EmoticonPackageModel> param1BluedEntityA) {
          ArrayList arrayList2 = new ArrayList();
          if (param1BluedEntityA.data != null)
            arrayList2.addAll(param1BluedEntityA.data); 
          ArrayList arrayList1 = new ArrayList();
          for (int i = 0; i < EmotionManager.j().size(); i++) {
            if (!StringUtils.e(((EmoticonPackageModel)EmotionManager.j().get(i)).code) && !((EmoticonPackageModel)EmotionManager.j().get(i)).isDefaultEmotionPacks)
              arrayList1.add(EmotionManager.j().get(i)); 
          } 
          EmotionManager.a(arrayList1, arrayList2);
        }
      };
  }
  
  private static EmoticonPackageModel a(String paramString, boolean paramBoolean) {
    try {
      boolean bool1;
      EmoticonPackageModel emoticonPackageModel = (EmoticonPackageModel)AppInfo.f().fromJson(paramString, (new TypeToken<EmoticonPackageModel>() {
          
          }).getType());
      boolean bool2 = false;
      Iterator<EmoticonPackageModel> iterator = d.iterator();
      while (true) {
        bool1 = bool2;
        if (iterator.hasNext()) {
          EmoticonPackageModel emoticonPackageModel1 = iterator.next();
          if (!TextUtils.isEmpty(emoticonPackageModel1.code) && emoticonPackageModel1.code.equals(emoticonPackageModel.code)) {
            bool1 = true;
            break;
          } 
          continue;
        } 
        break;
      } 
      if (!bool1) {
        a(emoticonPackageModel, paramBoolean);
        return emoticonPackageModel;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/EmotionsPack/");
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString, EmotionLoadListener paramEmotionLoadListener) {
    if (paramEmotionLoadListener != null)
      ChatHttpUtils.a(paramContext, new BluedUIHttpResponse<BluedEntityA<EmotionPackDownload>>(paramString, paramEmotionLoadListener) {
            protected void a(BluedEntityA<EmotionPackDownload> param1BluedEntityA) {
              if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0)
                EmotionManager.a(((EmotionPackDownload)param1BluedEntityA.data.get(0)).download, this.a, this.b); 
            }
          }paramString); 
  }
  
  public static void a(EmotionPackListener paramEmotionPackListener) {
    if (b == null)
      b = new HashSet<EmotionPackListener>(); 
    b.add(paramEmotionPackListener);
  }
  
  private static void a(EmoticonPackageModel paramEmoticonPackageModel, boolean paramBoolean) {
    byte b = 0;
    if (paramEmoticonPackageModel != null) {
      paramEmoticonPackageModel.itemPadding = 25;
      paramEmoticonPackageModel.emoticonType = 1;
      paramEmoticonPackageModel.row = 4;
      paramEmoticonPackageModel.line = 2;
      paramEmoticonPackageModel.isDownLoad = true;
      if (paramBoolean) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("assets://DefaultEmotions/");
        stringBuilder.append(paramEmoticonPackageModel.code);
        stringBuilder.append("/");
        stringBuilder.append(paramEmoticonPackageModel.icon);
        paramEmoticonPackageModel.icon = stringBuilder.toString();
        paramEmoticonPackageModel.isDefaultEmotionPacks = true;
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("file://");
        stringBuilder.append(i());
        stringBuilder.append("/");
        stringBuilder.append(paramEmoticonPackageModel.code);
        stringBuilder.append("/");
        stringBuilder.append(paramEmoticonPackageModel.icon);
        paramEmoticonPackageModel.icon = stringBuilder.toString();
        paramEmoticonPackageModel.isDefaultEmotionPacks = false;
      } 
      if (paramEmoticonPackageModel.emotions != null)
        for (int i = 0; i < paramEmoticonPackageModel.emotions.size(); i++) {
          EmoticonModel emoticonModel = paramEmoticonPackageModel.emotions.get(i);
          if (paramBoolean) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("assets://DefaultEmotions/");
            stringBuilder.append(paramEmoticonPackageModel.code);
            stringBuilder.append("/");
            stringBuilder.append(emoticonModel.small);
            emoticonModel.url = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("assets://DefaultEmotions/");
            stringBuilder.append(paramEmoticonPackageModel.code);
            stringBuilder.append("/");
            stringBuilder.append(emoticonModel.original);
            emoticonModel.url_original = stringBuilder.toString();
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("file://");
            stringBuilder.append(i());
            stringBuilder.append("/");
            stringBuilder.append(paramEmoticonPackageModel.code);
            stringBuilder.append("/");
            stringBuilder.append(emoticonModel.small);
            emoticonModel.url = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("file://");
            stringBuilder.append(i());
            stringBuilder.append("/");
            stringBuilder.append(paramEmoticonPackageModel.code);
            stringBuilder.append("/");
            stringBuilder.append(emoticonModel.original);
            emoticonModel.url_original = stringBuilder.toString();
          } 
          emoticonModel.emoticonType = 1;
          emoticonModel.packageCode = paramEmoticonPackageModel.code;
        }  
      d.add(paramEmoticonPackageModel);
      b(d);
    } 
    if (!StringUtils.e(BluedPreferences.bg())) {
      String[] arrayOfString = BluedPreferences.bg().split(",");
      if (arrayOfString.length > 0)
        for (int i = b; i < arrayOfString.length; i++) {
          if (arrayOfString[i].equals(paramEmoticonPackageModel.code) && paramEmoticonPackageModel.isDefaultEmotionPacks)
            d.remove(paramEmoticonPackageModel); 
        }  
    } 
  }
  
  public static void a(File paramFile) {
    if (paramFile.exists()) {
      if (paramFile.isFile()) {
        paramFile.delete();
      } else if (paramFile.isDirectory()) {
        File[] arrayOfFile = paramFile.listFiles();
        for (int i = 0; i < arrayOfFile.length; i++)
          a(arrayOfFile[i]); 
      } 
      paramFile.delete();
    } 
  }
  
  public static void a(String paramString) {
    try {
      String str2 = AppMethods.b(a());
      String str3 = Zip.a(paramString, str2);
      paramString = str2;
      if (!TextUtils.isEmpty(str3)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append(File.separator);
        stringBuilder1.append(str3);
        str1 = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("filePath: ");
      stringBuilder.append(str1);
      LogUtils.c(stringBuilder.toString());
      String str1 = e(str1);
      if (TextUtils.isEmpty(str1)) {
        LogUtils.c("download emotion can't get json");
        return;
      } 
      EmoticonPackageModel emoticonPackageModel = a(str1, false);
      if (emoticonPackageModel != null) {
        BluedPreferences.a(emoticonPackageModel.code, System.currentTimeMillis());
        b(d);
      } 
      if (b != null) {
        Iterator<EmotionPackListener> iterator = b.iterator();
        while (iterator.hasNext())
          ((EmotionPackListener)iterator.next()).a(); 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public static void a(String paramString1, String paramString2, EmotionLoadListener paramEmotionLoadListener) {
    String str = d(paramString1);
    StringBuilder stringBuilder2 = new StringBuilder();
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(a());
    stringBuilder3.append("/SingleEmotions");
    stringBuilder2.append(AppMethods.b(stringBuilder3.toString()));
    stringBuilder2.append(File.separator);
    stringBuilder2.append(paramString2);
    stringBuilder2.append(".");
    stringBuilder2.append(str);
    paramString2 = stringBuilder2.toString();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("filePath: ");
    stringBuilder1.append(paramString2);
    LogUtils.c(stringBuilder1.toString());
    EmoticonModel emoticonModel = new EmoticonModel();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("file://");
    stringBuilder2.append(paramString2);
    emoticonModel.url_original = stringBuilder2.toString();
    FileDownloader.a(paramString1, paramString2, new FileHttpResponseHandler(paramEmotionLoadListener, emoticonModel) {
          public void a(File param1File) {
            this.a.a(this.b);
          }
          
          public void a(Throwable param1Throwable, int param1Int, File param1File) {
            this.a.b(this.b);
          }
          
          public void onFinish() {
            this.a.c(this.b);
          }
        }null);
  }
  
  private static void a(List<String> paramList) {
    for (int i = 0; i < paramList.size(); i++)
      a(paramList.get(i), false); 
  }
  
  public static void b() {
    if (!e) {
      e = true;
      c = h();
      k();
    } 
  }
  
  public static void b(EmotionPackListener paramEmotionPackListener) {
    Set<EmotionPackListener> set = b;
    if (set != null)
      set.remove(paramEmotionPackListener); 
  }
  
  public static void b(String paramString) {
    int i = 0;
    boolean bool;
    for (bool = false; i < d.size(); bool = bool1) {
      boolean bool1 = bool;
      if (!StringUtils.e(((EmoticonPackageModel)d.get(i)).code)) {
        bool1 = bool;
        if (((EmoticonPackageModel)d.get(i)).code.equals(paramString)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append(paramString);
          stringBuilder2.append(",");
          stringBuilder1.append(stringBuilder2.toString());
          BluedPreferences.I(stringBuilder1.toString().substring(0, stringBuilder1.toString().length() - 1));
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(i());
          stringBuilder1.append(File.separator);
          stringBuilder1.append(paramString);
          File file = new File(stringBuilder1.toString());
          if (file.exists()) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(file.getAbsolutePath());
            stringBuilder2.append(System.currentTimeMillis());
            File file1 = new File(stringBuilder2.toString());
            file.renameTo(file1);
            a(file1);
          } 
          synchronized (d) {
            d.remove(i);
            bool1 = true;
          } 
        } 
      } 
      i++;
    } 
    BluedPreferences.H(paramString);
    if (bool) {
      Set<EmotionPackListener> set = b;
      if (set != null) {
        Iterator<EmotionPackListener> iterator = set.iterator();
        while (iterator.hasNext())
          ((EmotionPackListener)iterator.next()).a(); 
      } 
    } 
  }
  
  private static void b(List<EmoticonPackageModel> paramList) {
    if (paramList == null)
      return; 
    Collections.sort(paramList, new EmotionComparator());
  }
  
  private static void b(List<EmoticonPackageModel> paramList1, List<EmoticonPackageModel> paramList2) {
    HashSet<String> hashSet1 = new HashSet();
    HashSet<String> hashSet2 = new HashSet();
    Iterator<EmoticonPackageModel> iterator = paramList1.iterator();
    while (iterator.hasNext())
      hashSet1.add(((EmoticonPackageModel)iterator.next()).code); 
    iterator = paramList2.iterator();
    while (iterator.hasNext())
      hashSet2.add(((EmoticonPackageModel)iterator.next()).code); 
    hashSet1.removeAll(hashSet2);
    paramList2 = new ArrayList(hashSet1);
    int i = 0;
    while (i < paramList2.size()) {
      synchronized (d) {
        b((String)paramList2.get(i));
        i++;
      } 
    } 
  }
  
  public static EmoticonModel c(String paramString) {
    List<EmoticonPackageModel> list = e();
    String[] arrayOfString = paramString.split("_");
    int j = list.size();
    int i;
    for (i = 0; i < j; i++) {
      if (!StringUtils.e(arrayOfString[0]) && arrayOfString[0].equals(((EmoticonPackageModel)list.get(i)).code)) {
        int m = ((EmoticonPackageModel)list.get(i)).emotions.size();
        for (int k = 0; k < m; k++) {
          if (!StringUtils.e(arrayOfString[1]) && arrayOfString[1].equals(((EmoticonModel)((EmoticonPackageModel)list.get(i)).emotions.get(k)).code)) {
            ((EmoticonPackageModel)list.get(i)).singleEmotion = ((EmoticonPackageModel)list.get(i)).emotions.get(k);
            return ((EmoticonPackageModel)list.get(i)).singleEmotion;
          } 
        } 
      } 
    } 
    EmoticonModel emoticonModel = new EmoticonModel();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(i());
    stringBuilder.append("/SingleEmotions/");
    File file = new File(stringBuilder.toString());
    if (file.exists()) {
      File[] arrayOfFile = file.listFiles();
      int k = arrayOfFile.length;
      for (i = 0; i < k; i++) {
        if (arrayOfFile[i].getName().substring(0, arrayOfFile[i].getName().lastIndexOf(".")).equals(paramString) && (new File(file, arrayOfFile[i].getName())).isFile()) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("file://");
          stringBuilder1.append(i());
          stringBuilder1.append(File.separator);
          stringBuilder1.append("SingleEmotions");
          stringBuilder1.append(File.separator);
          stringBuilder1.append(arrayOfFile[i].getName());
          emoticonModel.url_original = stringBuilder1.toString();
          return emoticonModel;
        } 
      } 
    } 
    return null;
  }
  
  public static void c() {
    if (!f) {
      f = true;
      b();
      l();
      EmoticonPackageModel emoticonPackageModel = c;
      if (emoticonPackageModel != null)
        d.add(0, emoticonPackageModel); 
    } 
  }
  
  public static String d(String paramString) {
    Matcher matcher = a.matcher(paramString);
    String[] arrayOfString = paramString.split("/");
    String str = arrayOfString[arrayOfString.length - 1];
    try {
      if (matcher.find())
        return str.split("\\?")[0].split("\\.")[1]; 
    } finally {}
    return str.split("\\.")[1];
  }
  
  public static void d() {
    f = false;
    d.clear();
  }
  
  private static String e(String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append(File.separator);
      stringBuilder.append("res.json");
      InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(stringBuilder.toString()), Charsets.c);
    } finally {
      null = null;
    } 
    try {
      null.printStackTrace();
      return null;
    } finally {
      CommonTools.a((Reader)paramString);
    } 
  }
  
  public static List<EmoticonPackageModel> e() {
    if (System.currentTimeMillis() - BluedPreferences.bf().longValue() > 3600000L)
      ChatHttpUtils.b(AppInfo.d(), g, UserInfo.a().i().getUid()); 
    null = new ArrayList();
    synchronized (d) {
      null.clear();
      null.addAll(d);
      return null;
    } 
  }
  
  public static List<String> f() {
    List<EmoticonPackageModel> list = e();
    ArrayList<String> arrayList = new ArrayList();
    if (!TypeUtils.a(list))
      for (EmoticonPackageModel emoticonPackageModel : list) {
        if (!TextUtils.isEmpty(emoticonPackageModel.code))
          arrayList.add(emoticonPackageModel.code); 
      }  
    return arrayList;
  }
  
  private static List<String> f(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    File[] arrayOfFile = (new File(paramString)).listFiles();
    int j = arrayOfFile.length;
    for (int i = 0; i < j; i++) {
      String str = e(arrayOfFile[i].getAbsolutePath());
      if (!TextUtils.isEmpty(str))
        arrayList.add(str); 
    } 
    return arrayList;
  }
  
  public static String g() {
    List<EmoticonPackageModel> list = e();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < list.size(); i++) {
      if (!StringUtils.e(((EmoticonPackageModel)list.get(i)).code)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(((EmoticonPackageModel)list.get(i)).code);
        stringBuilder1.append(",");
        stringBuilder.append(stringBuilder1.toString());
      } 
    } 
    return (stringBuilder.toString().length() > 0) ? stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1) : "";
  }
  
  public static EmoticonPackageModel h() {
    EmoticonPackageModel emoticonPackageModel = new EmoticonPackageModel();
    emoticonPackageModel.emoticonType = 0;
    emoticonPackageModel.emotions = new ArrayList();
    emoticonPackageModel.icon = "system_default_emotion";
    emoticonPackageModel.isShowDelBtn = true;
    emoticonPackageModel.itemPadding = 25;
    emoticonPackageModel.row = 7;
    emoticonPackageModel.line = 3;
    new Emotion(AppInfo.d());
    if (Emotion.b.length == Emotion.a.length) {
      for (int i = 0; i < Emotion.b.length; i++) {
        EmoticonModel emoticonModel = new EmoticonModel();
        emoticonModel.code = Emotion.a[i];
        emoticonModel.original = Emotion.b[i];
        emoticonModel.emoticonType = 0;
        emoticonPackageModel.emotions.add(emoticonModel);
      } 
      return emoticonPackageModel;
    } 
    throw new RuntimeException("default small emotion data invalid");
  }
  
  public static String i() {
    return AppMethods.b(a());
  }
  
  private static void k() {
    Exception exception;
    try {
    
    } finally {
      exception = null;
      exception.printStackTrace();
    } 
    int i = 0;
    while (i < exception.length) {
      AssetManager assetManager = AppInfo.d().getAssets();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DefaultEmotions");
      stringBuilder.append(File.separator);
      stringBuilder.append((String)exception[i]);
      stringBuilder.append(File.separator);
      stringBuilder.append("res.json");
      InputStream inputStream = assetManager.open(stringBuilder.toString());
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charsets.c));
      StringBuffer stringBuffer = new StringBuffer();
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          stringBuffer.append(str);
          continue;
        } 
        bufferedReader.close();
        inputStream.close();
        a(stringBuffer.toString(), true);
        i++;
      } 
    } 
  }
  
  private static void l() {
    try {
      a(f(i()));
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  static class EmotionComparator implements Comparator<EmoticonPackageModel> {
    private EmotionComparator() {}
    
    public int a(EmoticonPackageModel param1EmoticonPackageModel1, EmoticonPackageModel param1EmoticonPackageModel2) {
      if (TextUtils.isEmpty(param1EmoticonPackageModel1.code) && TextUtils.isEmpty(param1EmoticonPackageModel2.code))
        return 0; 
      boolean bool = TextUtils.isEmpty(param1EmoticonPackageModel1.code);
      byte b = -1;
      if (bool)
        return -1; 
      if (TextUtils.isEmpty(param1EmoticonPackageModel2.code))
        return 1; 
      long l1 = BluedPreferences.G(param1EmoticonPackageModel1.code);
      long l2 = BluedPreferences.G(param1EmoticonPackageModel2.code);
      if (l1 == l2)
        return param1EmoticonPackageModel2.code.compareTo(param1EmoticonPackageModel1.code); 
      if (l2 > l1)
        b = 1; 
      return b;
    }
    
    public boolean equals(Object param1Object) {
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\emoticon\manager\EmotionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */