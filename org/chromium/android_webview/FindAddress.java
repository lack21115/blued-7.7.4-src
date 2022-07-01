package org.chromium.android_webview;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class FindAddress {
  private static final Pattern sHouseNumberRe;
  
  private static final Pattern sLocationNameRe;
  
  private static final Pattern sStateRe;
  
  private static final FindAddress$ZipRange[] sStateZipCodeRanges = new FindAddress$ZipRange[] { 
      new FindAddress$ZipRange(99, 99, -1), new FindAddress$ZipRange(35, 36, -1), new FindAddress$ZipRange(71, 72, -1), new FindAddress$ZipRange(96, 96, -1), new FindAddress$ZipRange(85, 86, -1), new FindAddress$ZipRange(90, 96, -1), new FindAddress$ZipRange(80, 81, -1), new FindAddress$ZipRange(6, 6, -1), new FindAddress$ZipRange(20, 20, -1), new FindAddress$ZipRange(19, 19, -1), 
      new FindAddress$ZipRange(32, 34, -1), new FindAddress$ZipRange(96, 96, -1), new FindAddress$ZipRange(30, 31, -1), new FindAddress$ZipRange(96, 96, -1), new FindAddress$ZipRange(96, 96, -1), new FindAddress$ZipRange(50, 52, -1), new FindAddress$ZipRange(83, 83, -1), new FindAddress$ZipRange(60, 62, -1), new FindAddress$ZipRange(46, 47, -1), new FindAddress$ZipRange(66, 67, 73), 
      new FindAddress$ZipRange(40, 42, -1), new FindAddress$ZipRange(70, 71, -1), new FindAddress$ZipRange(1, 2, -1), new FindAddress$ZipRange(20, 21, -1), new FindAddress$ZipRange(3, 4, -1), new FindAddress$ZipRange(96, 96, -1), new FindAddress$ZipRange(48, 49, -1), new FindAddress$ZipRange(55, 56, -1), new FindAddress$ZipRange(63, 65, -1), new FindAddress$ZipRange(96, 96, -1), 
      new FindAddress$ZipRange(38, 39, -1), new FindAddress$ZipRange(55, 56, -1), new FindAddress$ZipRange(27, 28, -1), new FindAddress$ZipRange(58, 58, -1), new FindAddress$ZipRange(68, 69, -1), new FindAddress$ZipRange(3, 4, -1), new FindAddress$ZipRange(7, 8, -1), new FindAddress$ZipRange(87, 88, 86), new FindAddress$ZipRange(88, 89, 96), new FindAddress$ZipRange(10, 14, 0), 
      new FindAddress$ZipRange(43, 45, -1), new FindAddress$ZipRange(73, 74, -1), new FindAddress$ZipRange(97, 97, -1), new FindAddress$ZipRange(15, 19, -1), new FindAddress$ZipRange(6, 6, 0), new FindAddress$ZipRange(96, 96, -1), new FindAddress$ZipRange(2, 2, -1), new FindAddress$ZipRange(29, 29, -1), new FindAddress$ZipRange(57, 57, -1), new FindAddress$ZipRange(37, 38, -1), 
      new FindAddress$ZipRange(75, 79, 87), new FindAddress$ZipRange(84, 84, -1), new FindAddress$ZipRange(22, 24, 20), new FindAddress$ZipRange(6, 9, -1), new FindAddress$ZipRange(5, 5, -1), new FindAddress$ZipRange(98, 99, -1), new FindAddress$ZipRange(53, 54, -1), new FindAddress$ZipRange(24, 26, -1), new FindAddress$ZipRange(82, 83, -1) };
  
  private static final Pattern sSuffixedNumberRe;
  
  private static final Pattern sWordRe = Pattern.compile("[^,*•\t                　\n\013\f\r  ]+(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
  
  private static final Pattern sZipCodeRe;
  
  static {
    sHouseNumberRe = Pattern.compile("(?:one|\\d+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|\\d+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t                　\n\013\f\r  ]|$)", 2);
    sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t                　]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t                　]+of[\t                　]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t                　]+states[\t                　]+of[\t                　]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t                　]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t                　]+mariana[\t                　]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t                　]+carolina)|(nd|north[\t                　]+dakota)|(ne|nebraska)|(nh|new[\t                　]+hampshire)|(nj|new[\t                　]+jersey)|(nm|new[\t                　]+mexico)|(nv|nevada)|(ny|new[\t                　]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t                　]+rico)|(pw|palau)|(ri|rhode[\t                　]+island)|(sc|south[\t                　]+carolina)|(sd|south[\t                　]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t                　]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t                　]+virginia)|(wy|wyoming))(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
    sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
    sSuffixedNumberRe = Pattern.compile("(\\d+)(st|nd|rd|th)", 2);
    sZipCodeRe = Pattern.compile("(?:\\d{5}(?:-\\d{4})?)(?=[,*•\t                　\n\013\f\r  ]|$)", 2);
    throw new VerifyError("bad dex opcode");
  }
  
  private static boolean checkHouseNumber(String paramString) {
    int i = 0;
    int j;
    for (j = 0; i < paramString.length(); j = k) {
      int k = j;
      if (Character.isDigit(paramString.charAt(i)))
        k = j + 1; 
      i++;
    } 
    if (j > 5)
      return false; 
    Matcher matcher = sSuffixedNumberRe.matcher(paramString);
    if (matcher.find()) {
      String str1;
      i = Integer.parseInt(matcher.group(1));
      if (i == 0)
        return false; 
      String str2 = matcher.group(2).toLowerCase(Locale.getDefault());
      switch (i % 10) {
        default:
          return str2.equals("th");
        case 3:
          if (i % 100 == 13) {
            str1 = "th";
          } else {
            str1 = "rd";
          } 
          return str2.equals(str1);
        case 2:
          if (i % 100 == 12) {
            str1 = "th";
          } else {
            str1 = "nd";
          } 
          return str2.equals(str1);
        case 1:
          break;
      } 
      if (i % 100 == 11) {
        str1 = "th";
      } else {
        str1 = "st";
      } 
      return str2.equals(str1);
    } 
    return true;
  }
  
  public static String findAddress(String paramString) {
    Matcher matcher = sHouseNumberRe.matcher(paramString);
    boolean bool = false;
    for (int i = 0; matcher.find(i); i = matcher.end()) {
      if (checkHouseNumber(matcher.group(bool))) {
        int k = matcher.start();
        int j = matcher.end();
        Matcher matcher1 = sWordRe.matcher(paramString);
        String str = "";
        boolean bool4 = true;
        boolean bool3 = true;
        boolean bool2 = true;
        byte b = -1;
        boolean bool1 = false;
        i = -1;
        while (true) {
          boolean bool5 = bool;
          int m = j;
          bool = false;
          str = matcher1.group(0);
          j = matcher1.end();
          object4 = SYNTHETIC_LOCAL_VARIABLE_6;
          object3 = SYNTHETIC_LOCAL_VARIABLE_4;
          object1 = SYNTHETIC_LOCAL_VARIABLE_10;
          object2 = SYNTHETIC_LOCAL_VARIABLE_12;
          object = SYNTHETIC_LOCAL_VARIABLE_13;
        } 
        if (object > null)
          return paramString.substring(k, object); 
        Object object = -object;
        continue;
      } 
      continue;
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\FindAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */