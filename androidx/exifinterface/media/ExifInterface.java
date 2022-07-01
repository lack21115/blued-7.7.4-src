package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.util.Log;
import android.util.Pair;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ExifInterface {
  private static final HashMap<String, ExifTag>[] A;
  
  public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
  
  public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
  
  private static final HashSet<String> B;
  
  public static final int[] BITS_PER_SAMPLE_GREYSCALE_1;
  
  public static final int[] BITS_PER_SAMPLE_GREYSCALE_2;
  
  public static final int[] BITS_PER_SAMPLE_RGB;
  
  private static final HashMap<Integer, Integer> C;
  
  public static final int COLOR_SPACE_S_RGB = 1;
  
  public static final int COLOR_SPACE_UNCALIBRATED = 65535;
  
  public static final short CONTRAST_HARD = 2;
  
  public static final short CONTRAST_NORMAL = 0;
  
  public static final short CONTRAST_SOFT = 1;
  
  public static final int DATA_DEFLATE_ZIP = 8;
  
  public static final int DATA_HUFFMAN_COMPRESSED = 2;
  
  public static final int DATA_JPEG = 6;
  
  public static final int DATA_JPEG_COMPRESSED = 7;
  
  public static final int DATA_LOSSY_JPEG = 34892;
  
  public static final int DATA_PACK_BITS_COMPRESSED = 32773;
  
  public static final int DATA_UNCOMPRESSED = 1;
  
  public static final short EXPOSURE_MODE_AUTO = 0;
  
  public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
  
  public static final short EXPOSURE_MODE_MANUAL = 1;
  
  public static final short EXPOSURE_PROGRAM_ACTION = 6;
  
  public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
  
  public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
  
  public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
  
  public static final short EXPOSURE_PROGRAM_MANUAL = 1;
  
  public static final short EXPOSURE_PROGRAM_NORMAL = 2;
  
  public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
  
  public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
  
  public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
  
  public static final short FILE_SOURCE_DSC = 3;
  
  public static final short FILE_SOURCE_OTHER = 0;
  
  public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
  
  public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
  
  public static final short FLAG_FLASH_FIRED = 1;
  
  public static final short FLAG_FLASH_MODE_AUTO = 24;
  
  public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
  
  public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
  
  public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
  
  public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
  
  public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
  
  public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
  
  public static final short FORMAT_CHUNKY = 1;
  
  public static final short FORMAT_PLANAR = 2;
  
  public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
  
  public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
  
  public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
  
  public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
  
  public static final short GAIN_CONTROL_NONE = 0;
  
  public static final String GPS_DIRECTION_MAGNETIC = "M";
  
  public static final String GPS_DIRECTION_TRUE = "T";
  
  public static final String GPS_DISTANCE_KILOMETERS = "K";
  
  public static final String GPS_DISTANCE_MILES = "M";
  
  public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
  
  public static final String GPS_MEASUREMENT_2D = "2";
  
  public static final String GPS_MEASUREMENT_3D = "3";
  
  public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
  
  public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
  
  public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
  
  public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
  
  public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
  
  public static final String GPS_SPEED_KNOTS = "N";
  
  public static final String GPS_SPEED_MILES_PER_HOUR = "M";
  
  public static final String LATITUDE_NORTH = "N";
  
  public static final String LATITUDE_SOUTH = "S";
  
  public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
  
  public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
  
  public static final short LIGHT_SOURCE_D50 = 23;
  
  public static final short LIGHT_SOURCE_D55 = 20;
  
  public static final short LIGHT_SOURCE_D65 = 21;
  
  public static final short LIGHT_SOURCE_D75 = 22;
  
  public static final short LIGHT_SOURCE_DAYLIGHT = 1;
  
  public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
  
  public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
  
  public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
  
  public static final short LIGHT_SOURCE_FLASH = 4;
  
  public static final short LIGHT_SOURCE_FLUORESCENT = 2;
  
  public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
  
  public static final short LIGHT_SOURCE_OTHER = 255;
  
  public static final short LIGHT_SOURCE_SHADE = 11;
  
  public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
  
  public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
  
  public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
  
  public static final short LIGHT_SOURCE_TUNGSTEN = 3;
  
  public static final short LIGHT_SOURCE_UNKNOWN = 0;
  
  public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
  
  public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
  
  public static final String LONGITUDE_EAST = "E";
  
  public static final String LONGITUDE_WEST = "W";
  
  public static final short METERING_MODE_AVERAGE = 1;
  
  public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
  
  public static final short METERING_MODE_MULTI_SPOT = 4;
  
  public static final short METERING_MODE_OTHER = 255;
  
  public static final short METERING_MODE_PARTIAL = 6;
  
  public static final short METERING_MODE_PATTERN = 5;
  
  public static final short METERING_MODE_SPOT = 3;
  
  public static final short METERING_MODE_UNKNOWN = 0;
  
  public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
  
  public static final int ORIENTATION_FLIP_VERTICAL = 4;
  
  public static final int ORIENTATION_NORMAL = 1;
  
  public static final int ORIENTATION_ROTATE_180 = 3;
  
  public static final int ORIENTATION_ROTATE_270 = 8;
  
  public static final int ORIENTATION_ROTATE_90 = 6;
  
  public static final int ORIENTATION_TRANSPOSE = 5;
  
  public static final int ORIENTATION_TRANSVERSE = 7;
  
  public static final int ORIENTATION_UNDEFINED = 0;
  
  public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
  
  public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
  
  public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
  
  public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
  
  public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
  
  public static final int REDUCED_RESOLUTION_IMAGE = 1;
  
  public static final short RENDERED_PROCESS_CUSTOM = 1;
  
  public static final short RENDERED_PROCESS_NORMAL = 0;
  
  public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
  
  public static final short RESOLUTION_UNIT_INCHES = 2;
  
  public static final short SATURATION_HIGH = 0;
  
  public static final short SATURATION_LOW = 0;
  
  public static final short SATURATION_NORMAL = 0;
  
  public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
  
  public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
  
  public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
  
  public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
  
  public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
  
  public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
  
  public static final short SENSITIVITY_TYPE_REI = 2;
  
  public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
  
  public static final short SENSITIVITY_TYPE_SOS = 1;
  
  public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
  
  public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
  
  public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
  
  public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
  
  public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
  
  public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
  
  public static final short SENSOR_TYPE_NOT_DEFINED = 1;
  
  public static final short SENSOR_TYPE_ONE_CHIP = 2;
  
  public static final short SENSOR_TYPE_THREE_CHIP = 4;
  
  public static final short SENSOR_TYPE_TRILINEAR = 7;
  
  public static final short SENSOR_TYPE_TWO_CHIP = 3;
  
  public static final short SHARPNESS_HARD = 2;
  
  public static final short SHARPNESS_NORMAL = 0;
  
  public static final short SHARPNESS_SOFT = 1;
  
  public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
  
  public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
  
  public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
  
  public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
  
  public static final String TAG_APERTURE_VALUE = "ApertureValue";
  
  public static final String TAG_ARTIST = "Artist";
  
  public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
  
  public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
  
  public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
  
  public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
  
  public static final String TAG_CFA_PATTERN = "CFAPattern";
  
  public static final String TAG_COLOR_SPACE = "ColorSpace";
  
  public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
  
  public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
  
  public static final String TAG_COMPRESSION = "Compression";
  
  public static final String TAG_CONTRAST = "Contrast";
  
  public static final String TAG_COPYRIGHT = "Copyright";
  
  public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
  
  public static final String TAG_DATETIME = "DateTime";
  
  public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
  
  public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
  
  public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
  
  public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
  
  public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
  
  public static final String TAG_DNG_VERSION = "DNGVersion";
  
  public static final String TAG_EXIF_VERSION = "ExifVersion";
  
  public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
  
  public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
  
  public static final String TAG_EXPOSURE_MODE = "ExposureMode";
  
  public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
  
  public static final String TAG_EXPOSURE_TIME = "ExposureTime";
  
  public static final String TAG_FILE_SOURCE = "FileSource";
  
  public static final String TAG_FLASH = "Flash";
  
  public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
  
  public static final String TAG_FLASH_ENERGY = "FlashEnergy";
  
  public static final String TAG_FOCAL_LENGTH = "FocalLength";
  
  public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
  
  public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
  
  public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
  
  public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
  
  public static final String TAG_F_NUMBER = "FNumber";
  
  public static final String TAG_GAIN_CONTROL = "GainControl";
  
  public static final String TAG_GAMMA = "Gamma";
  
  public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
  
  public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
  
  public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
  
  public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
  
  public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
  
  public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
  
  public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
  
  public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
  
  public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
  
  public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
  
  public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
  
  public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
  
  public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
  
  public static final String TAG_GPS_DOP = "GPSDOP";
  
  public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
  
  public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
  
  public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
  
  public static final String TAG_GPS_LATITUDE = "GPSLatitude";
  
  public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
  
  public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
  
  public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
  
  public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
  
  public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
  
  public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
  
  public static final String TAG_GPS_SATELLITES = "GPSSatellites";
  
  public static final String TAG_GPS_SPEED = "GPSSpeed";
  
  public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
  
  public static final String TAG_GPS_STATUS = "GPSStatus";
  
  public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
  
  public static final String TAG_GPS_TRACK = "GPSTrack";
  
  public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
  
  public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
  
  public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
  
  public static final String TAG_IMAGE_LENGTH = "ImageLength";
  
  public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
  
  public static final String TAG_IMAGE_WIDTH = "ImageWidth";
  
  public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
  
  public static final String TAG_ISO_SPEED = "ISOSpeed";
  
  public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
  
  public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
  
  @Deprecated
  public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
  
  public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
  
  public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
  
  public static final String TAG_LENS_MAKE = "LensMake";
  
  public static final String TAG_LENS_MODEL = "LensModel";
  
  public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
  
  public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
  
  public static final String TAG_LIGHT_SOURCE = "LightSource";
  
  public static final String TAG_MAKE = "Make";
  
  public static final String TAG_MAKER_NOTE = "MakerNote";
  
  public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
  
  public static final String TAG_METERING_MODE = "MeteringMode";
  
  public static final String TAG_MODEL = "Model";
  
  public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
  
  public static final String TAG_OECF = "OECF";
  
  public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
  
  public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
  
  public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
  
  public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
  
  public static final String TAG_ORIENTATION = "Orientation";
  
  public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
  
  public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
  
  public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
  
  public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
  
  public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
  
  public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
  
  public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
  
  public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
  
  public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
  
  public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
  
  public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
  
  public static final String TAG_RW2_ISO = "ISO";
  
  public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
  
  public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
  
  public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
  
  public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
  
  public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
  
  public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
  
  public static final String TAG_SATURATION = "Saturation";
  
  public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
  
  public static final String TAG_SCENE_TYPE = "SceneType";
  
  public static final String TAG_SENSING_METHOD = "SensingMethod";
  
  public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
  
  public static final String TAG_SHARPNESS = "Sharpness";
  
  public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
  
  public static final String TAG_SOFTWARE = "Software";
  
  public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
  
  public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
  
  public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
  
  public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
  
  public static final String TAG_STRIP_OFFSETS = "StripOffsets";
  
  public static final String TAG_SUBFILE_TYPE = "SubfileType";
  
  public static final String TAG_SUBJECT_AREA = "SubjectArea";
  
  public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
  
  public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
  
  public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
  
  public static final String TAG_SUBSEC_TIME = "SubSecTime";
  
  public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
  
  public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
  
  public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
  
  public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
  
  public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
  
  public static final String TAG_USER_COMMENT = "UserComment";
  
  public static final String TAG_WHITE_BALANCE = "WhiteBalance";
  
  public static final String TAG_WHITE_POINT = "WhitePoint";
  
  public static final String TAG_X_RESOLUTION = "XResolution";
  
  public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
  
  public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
  
  public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
  
  public static final String TAG_Y_RESOLUTION = "YResolution";
  
  private static final Pattern U;
  
  private static final Pattern V;
  
  @Deprecated
  public static final int WHITEBALANCE_AUTO = 0;
  
  @Deprecated
  public static final int WHITEBALANCE_MANUAL = 1;
  
  public static final short WHITE_BALANCE_AUTO = 0;
  
  public static final short WHITE_BALANCE_MANUAL = 1;
  
  public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
  
  public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
  
  static final byte[] a;
  
  static final String[] b;
  
  static final int[] c;
  
  static final byte[] d;
  
  static final ExifTag[][] e;
  
  static final Charset f;
  
  static final byte[] g;
  
  private static final List<Integer> h;
  
  private static final List<Integer> i;
  
  private static final byte[] j;
  
  private static final byte[] k;
  
  private static SimpleDateFormat l;
  
  private static final ExifTag[] m;
  
  private static final ExifTag[] n;
  
  private static final ExifTag[] o;
  
  private static final ExifTag[] p;
  
  private static final ExifTag[] q;
  
  private static final ExifTag r;
  
  private static final ExifTag[] s;
  
  private static final ExifTag[] t;
  
  private static final ExifTag[] u;
  
  private static final ExifTag[] v;
  
  private static final ExifTag[] w;
  
  private static final ExifTag x;
  
  private static final ExifTag y;
  
  private static final HashMap<Integer, ExifTag>[] z;
  
  private final String D;
  
  private final AssetManager.AssetInputStream E;
  
  private int F;
  
  private final HashMap<String, ExifAttribute>[] G;
  
  private Set<Integer> H;
  
  private ByteOrder I;
  
  private boolean J;
  
  private int K;
  
  private int L;
  
  private byte[] M;
  
  private int N;
  
  private int O;
  
  private int P;
  
  private int Q;
  
  private int R;
  
  private int S;
  
  private boolean T;
  
  static {
    Integer integer1 = Integer.valueOf(1);
    Integer integer2 = Integer.valueOf(3);
    Integer integer3 = Integer.valueOf(2);
    Integer integer4 = Integer.valueOf(8);
    h = Arrays.asList(new Integer[] { integer1, Integer.valueOf(6), integer2, integer4 });
    Integer integer5 = Integer.valueOf(7);
    Integer integer6 = Integer.valueOf(5);
    i = Arrays.asList(new Integer[] { integer3, integer5, Integer.valueOf(4), integer6 });
    BITS_PER_SAMPLE_RGB = new int[] { 8, 8, 8 };
    BITS_PER_SAMPLE_GREYSCALE_1 = new int[] { 4 };
    BITS_PER_SAMPLE_GREYSCALE_2 = new int[] { 8 };
    a = new byte[] { -1, -40, -1 };
    j = new byte[] { 79, 76, 89, 77, 80, 0 };
    k = new byte[] { 79, 76, 89, 77, 80, 85, 83, 0, 73, 73 };
    b = new String[] { 
        "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", 
        "SRATIONAL", "SINGLE", "DOUBLE" };
    c = new int[] { 
        0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 
        8, 4, 8, 1 };
    d = new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 };
    m = new ExifTag[] { 
        new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), 
        new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), 
        new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), 
        new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), 
        new ExifTag("JpgFromRaw", 46, 7) };
    n = new ExifTag[] { 
        new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("ComponentsConfiguration", 37121, 7), 
        new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), 
        new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), 
        new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), 
        new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), 
        new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4) };
    o = new ExifTag[] { 
        new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), 
        new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), 
        new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), 
        new ExifTag("GPSDifferential", 30, 3) };
    p = new ExifTag[] { new ExifTag("InteroperabilityIndex", 1, 2) };
    q = new ExifTag[] { 
        new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ThumbnailImageWidth", 256, 3, 4), new ExifTag("ThumbnailImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), 
        new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), 
        new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), 
        new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4) };
    r = new ExifTag("StripOffsets", 273, 3);
    s = new ExifTag[] { new ExifTag("ThumbnailImage", 256, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4) };
    t = new ExifTag[] { new ExifTag("PreviewImageStart", 257, 4), new ExifTag("PreviewImageLength", 258, 4) };
    u = new ExifTag[] { new ExifTag("AspectFrame", 4371, 3) };
    v = new ExifTag[] { new ExifTag("ColorSpace", 55, 3) };
    ExifTag[] arrayOfExifTag1 = m;
    e = new ExifTag[][] { arrayOfExifTag1, n, o, p, q, arrayOfExifTag1, s, t, u, v };
    w = new ExifTag[] { new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1) };
    x = new ExifTag("JPEGInterchangeFormat", 513, 4);
    y = new ExifTag("JPEGInterchangeFormatLength", 514, 4);
    ExifTag[][] arrayOfExifTag = e;
    z = (HashMap<Integer, ExifTag>[])new HashMap[arrayOfExifTag.length];
    A = (HashMap<String, ExifTag>[])new HashMap[arrayOfExifTag.length];
    B = new HashSet<String>(Arrays.asList(new String[] { "FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp" }));
    C = new HashMap<Integer, Integer>();
    f = Charset.forName("US-ASCII");
    g = "Exif\000\000".getBytes(f);
    l = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
    l.setTimeZone(TimeZone.getTimeZone("UTC"));
    for (int i = 0; i < e.length; i++) {
      z[i] = new HashMap<Integer, ExifTag>();
      A[i] = new HashMap<String, ExifTag>();
      for (ExifTag exifTag : e[i]) {
        z[i].put(Integer.valueOf(exifTag.number), exifTag);
        A[i].put(exifTag.name, exifTag);
      } 
    } 
    C.put(Integer.valueOf((w[0]).number), integer6);
    C.put(Integer.valueOf((w[1]).number), integer1);
    C.put(Integer.valueOf((w[2]).number), integer3);
    C.put(Integer.valueOf((w[3]).number), integer2);
    C.put(Integer.valueOf((w[4]).number), integer5);
    C.put(Integer.valueOf((w[5]).number), integer4);
    U = Pattern.compile(".*[1-9].*");
    V = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
  }
  
  public ExifInterface(InputStream paramInputStream) throws IOException {
    ExifTag[][] arrayOfExifTag = e;
    this.G = (HashMap<String, ExifAttribute>[])new HashMap[arrayOfExifTag.length];
    this.H = new HashSet<Integer>(arrayOfExifTag.length);
    this.I = ByteOrder.BIG_ENDIAN;
    if (paramInputStream != null) {
      this.D = null;
      if (paramInputStream instanceof AssetManager.AssetInputStream) {
        this.E = (AssetManager.AssetInputStream)paramInputStream;
      } else {
        this.E = null;
      } 
      a(paramInputStream);
      return;
    } 
    throw new IllegalArgumentException("inputStream cannot be null");
  }
  
  public ExifInterface(String paramString) throws IOException {
    ExifTag[][] arrayOfExifTag = e;
    this.G = (HashMap<String, ExifAttribute>[])new HashMap[arrayOfExifTag.length];
    this.H = new HashSet<Integer>(arrayOfExifTag.length);
    this.I = ByteOrder.BIG_ENDIAN;
    if (paramString != null) {
      String str = null;
      this.E = null;
      this.D = paramString;
      try {
        FileInputStream fileInputStream = new FileInputStream(paramString);
      } finally {
        arrayOfExifTag = null;
      } 
      a((Closeable)paramString);
      throw arrayOfExifTag;
    } 
    throw new IllegalArgumentException("filename cannot be null");
  }
  
  private static double a(String paramString1, String paramString2) {
    try {
      String[] arrayOfString1 = paramString1.split(",", -1);
      String[] arrayOfString2 = arrayOfString1[0].split("/", -1);
      double d1 = Double.parseDouble(arrayOfString2[0].trim()) / Double.parseDouble(arrayOfString2[1].trim());
      arrayOfString2 = arrayOfString1[1].split("/", -1);
      double d2 = Double.parseDouble(arrayOfString2[0].trim()) / Double.parseDouble(arrayOfString2[1].trim());
      arrayOfString1 = arrayOfString1[2].split("/", -1);
      double d3 = Double.parseDouble(arrayOfString1[0].trim()) / Double.parseDouble(arrayOfString1[1].trim());
      d1 = d1 + d2 / 60.0D + d3 / 3600.0D;
      if (paramString2.equals("S") || paramString2.equals("W"))
        return -d1; 
      if (!paramString2.equals("N")) {
        if (paramString2.equals("E"))
          return d1; 
        throw new IllegalArgumentException();
      } 
      return d1;
    } catch (NumberFormatException|ArrayIndexOutOfBoundsException numberFormatException) {
      throw new IllegalArgumentException();
    } 
  }
  
  private int a(ByteOrderedDataOutputStream paramByteOrderedDataOutputStream, int paramInt) throws IOException {
    char c;
    ExifTag[][] arrayOfExifTag = e;
    int[] arrayOfInt1 = new int[arrayOfExifTag.length];
    int[] arrayOfInt2 = new int[arrayOfExifTag.length];
    ExifTag[] arrayOfExifTag1 = w;
    int j = arrayOfExifTag1.length;
    int i;
    for (i = 0; i < j; i++)
      b((arrayOfExifTag1[i]).name); 
    b(x.name);
    b(y.name);
    for (i = 0; i < e.length; i++) {
      Object[] arrayOfObject = this.G[i].entrySet().toArray();
      int m = arrayOfObject.length;
      for (j = 0; j < m; j++) {
        Map.Entry entry = (Map.Entry)arrayOfObject[j];
        if (entry.getValue() == null)
          this.G[i].remove(entry.getKey()); 
      } 
    } 
    if (!this.G[1].isEmpty())
      this.G[0].put((w[1]).name, ExifAttribute.createULong(0L, this.I)); 
    if (!this.G[2].isEmpty())
      this.G[0].put((w[2]).name, ExifAttribute.createULong(0L, this.I)); 
    if (!this.G[3].isEmpty())
      this.G[1].put((w[3]).name, ExifAttribute.createULong(0L, this.I)); 
    if (this.J) {
      this.G[4].put(x.name, ExifAttribute.createULong(0L, this.I));
      this.G[4].put(y.name, ExifAttribute.createULong(this.L, this.I));
    } 
    for (i = 0; i < e.length; i++) {
      Iterator<Map.Entry> iterator = this.G[i].entrySet().iterator();
      j = 0;
      while (iterator.hasNext()) {
        int m = ((ExifAttribute)((Map.Entry)iterator.next()).getValue()).size();
        if (m > 4)
          j += m; 
      } 
      arrayOfInt2[i] = arrayOfInt2[i] + j;
    } 
    j = 0;
    for (i = 8; j < e.length; i = m) {
      int m = i;
      if (!this.G[j].isEmpty()) {
        arrayOfInt1[j] = i;
        m = i + this.G[j].size() * 12 + 2 + 4 + arrayOfInt2[j];
      } 
      j++;
    } 
    j = i;
    if (this.J) {
      this.G[4].put(x.name, ExifAttribute.createULong(i, this.I));
      this.K = paramInt + i;
      j = i + this.L;
    } 
    int k = j + 8;
    if (!this.G[1].isEmpty())
      this.G[0].put((w[1]).name, ExifAttribute.createULong(arrayOfInt1[1], this.I)); 
    if (!this.G[2].isEmpty())
      this.G[0].put((w[2]).name, ExifAttribute.createULong(arrayOfInt1[2], this.I)); 
    if (!this.G[3].isEmpty())
      this.G[1].put((w[3]).name, ExifAttribute.createULong(arrayOfInt1[3], this.I)); 
    paramByteOrderedDataOutputStream.writeUnsignedShort(k);
    paramByteOrderedDataOutputStream.write(g);
    if (this.I == ByteOrder.BIG_ENDIAN) {
      c = '䵍';
    } else {
      c = '䥉';
    } 
    paramByteOrderedDataOutputStream.writeShort(c);
    paramByteOrderedDataOutputStream.setByteOrder(this.I);
    paramByteOrderedDataOutputStream.writeUnsignedShort(42);
    paramByteOrderedDataOutputStream.writeUnsignedInt(8L);
    for (paramInt = 0; paramInt < e.length; paramInt++) {
      if (!this.G[paramInt].isEmpty()) {
        paramByteOrderedDataOutputStream.writeUnsignedShort(this.G[paramInt].size());
        i = arrayOfInt1[paramInt] + 2 + this.G[paramInt].size() * 12 + 4;
        for (Map.Entry<String, ExifAttribute> entry : this.G[paramInt].entrySet()) {
          int m = ((ExifTag)A[paramInt].get(entry.getKey())).number;
          ExifAttribute exifAttribute = (ExifAttribute)entry.getValue();
          j = exifAttribute.size();
          paramByteOrderedDataOutputStream.writeUnsignedShort(m);
          paramByteOrderedDataOutputStream.writeUnsignedShort(exifAttribute.format);
          paramByteOrderedDataOutputStream.writeInt(exifAttribute.numberOfComponents);
          if (j > 4) {
            paramByteOrderedDataOutputStream.writeUnsignedInt(i);
            i += j;
            continue;
          } 
          paramByteOrderedDataOutputStream.write(exifAttribute.bytes);
          if (j < 4)
            while (j < 4) {
              paramByteOrderedDataOutputStream.writeByte(0);
              j++;
            }  
        } 
        if (paramInt == 0 && !this.G[4].isEmpty()) {
          paramByteOrderedDataOutputStream.writeUnsignedInt(arrayOfInt1[4]);
        } else {
          paramByteOrderedDataOutputStream.writeUnsignedInt(0L);
        } 
        Iterator<Map.Entry> iterator = this.G[paramInt].entrySet().iterator();
        while (iterator.hasNext()) {
          ExifAttribute exifAttribute = (ExifAttribute)((Map.Entry)iterator.next()).getValue();
          if (exifAttribute.bytes.length > 4)
            paramByteOrderedDataOutputStream.write(exifAttribute.bytes, 0, exifAttribute.bytes.length); 
        } 
      } 
    } 
    if (this.J)
      paramByteOrderedDataOutputStream.write(getThumbnailBytes()); 
    paramByteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
    return k;
  }
  
  private int a(BufferedInputStream paramBufferedInputStream) throws IOException {
    paramBufferedInputStream.mark(5000);
    byte[] arrayOfByte = new byte[5000];
    paramBufferedInputStream.read(arrayOfByte);
    paramBufferedInputStream.reset();
    return a(arrayOfByte) ? 4 : (b(arrayOfByte) ? 9 : (c(arrayOfByte) ? 7 : (d(arrayOfByte) ? 10 : 0)));
  }
  
  private ExifAttribute a(String paramString) {
    String str = paramString;
    if ("ISOSpeedRatings".equals(paramString))
      str = "PhotographicSensitivity"; 
    for (int i = 0; i < e.length; i++) {
      ExifAttribute exifAttribute = this.G[i].get(str);
      if (exifAttribute != null)
        return exifAttribute; 
    } 
    return null;
  }
  
  private String a(double paramDouble) {
    long l1 = (long)paramDouble;
    paramDouble -= l1;
    long l2 = (long)(paramDouble * 60.0D);
    long l3 = Math.round((paramDouble - l2 / 60.0D) * 3600.0D * 1.0E7D);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(l1);
    stringBuilder.append("/1,");
    stringBuilder.append(l2);
    stringBuilder.append("/1,");
    stringBuilder.append(l3);
    stringBuilder.append("/10000000");
    return stringBuilder.toString();
  }
  
  private void a() {
    String str = getAttribute("DateTimeOriginal");
    if (str != null && getAttribute("DateTime") == null)
      this.G[0].put("DateTime", ExifAttribute.createString(str)); 
    if (getAttribute("ImageWidth") == null)
      this.G[0].put("ImageWidth", ExifAttribute.createULong(0L, this.I)); 
    if (getAttribute("ImageLength") == null)
      this.G[0].put("ImageLength", ExifAttribute.createULong(0L, this.I)); 
    if (getAttribute("Orientation") == null)
      this.G[0].put("Orientation", ExifAttribute.createULong(0L, this.I)); 
    if (getAttribute("LightSource") == null)
      this.G[1].put("LightSource", ExifAttribute.createULong(0L, this.I)); 
  }
  
  private void a(int paramInt1, int paramInt2) throws IOException {
    if (!this.G[paramInt1].isEmpty()) {
      if (this.G[paramInt2].isEmpty())
        return; 
      ExifAttribute exifAttribute1 = this.G[paramInt1].get("ImageLength");
      ExifAttribute exifAttribute2 = this.G[paramInt1].get("ImageWidth");
      ExifAttribute exifAttribute3 = this.G[paramInt2].get("ImageLength");
      ExifAttribute exifAttribute4 = this.G[paramInt2].get("ImageWidth");
      if (exifAttribute1 != null) {
        if (exifAttribute2 == null)
          return; 
        if (exifAttribute3 != null) {
          if (exifAttribute4 == null)
            return; 
          int i = exifAttribute1.getIntValue(this.I);
          int j = exifAttribute2.getIntValue(this.I);
          int k = exifAttribute3.getIntValue(this.I);
          int m = exifAttribute4.getIntValue(this.I);
          if (i < k && j < m) {
            HashMap<String, ExifAttribute>[] arrayOfHashMap = this.G;
            HashMap<String, ExifAttribute> hashMap = arrayOfHashMap[paramInt1];
            arrayOfHashMap[paramInt1] = arrayOfHashMap[paramInt2];
            arrayOfHashMap[paramInt2] = hashMap;
          } 
        } 
      } 
    } 
  }
  
  private void a(ByteOrderedDataInputStream paramByteOrderedDataInputStream) throws IOException {
    a(paramByteOrderedDataInputStream, paramByteOrderedDataInputStream.available());
    b(paramByteOrderedDataInputStream, 0);
    d(paramByteOrderedDataInputStream, 0);
    d(paramByteOrderedDataInputStream, 5);
    d(paramByteOrderedDataInputStream, 4);
    b(paramByteOrderedDataInputStream);
    if (this.F == 8) {
      ExifAttribute exifAttribute = this.G[1].get("MakerNote");
      if (exifAttribute != null) {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(exifAttribute.bytes);
        byteOrderedDataInputStream.setByteOrder(this.I);
        byteOrderedDataInputStream.seek(6L);
        b(byteOrderedDataInputStream, 9);
        ExifAttribute exifAttribute1 = this.G[9].get("ColorSpace");
        if (exifAttribute1 != null)
          this.G[1].put("ColorSpace", exifAttribute1); 
      } 
    } 
  }
  
  private void a(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt) throws IOException {
    this.I = e(paramByteOrderedDataInputStream);
    paramByteOrderedDataInputStream.setByteOrder(this.I);
    int i = paramByteOrderedDataInputStream.readUnsignedShort();
    int j = this.F;
    if (j == 7 || j == 10 || i == 42) {
      i = paramByteOrderedDataInputStream.readInt();
      if (i >= 8 && i < paramInt) {
        paramInt = i - 8;
        if (paramInt > 0) {
          if (paramByteOrderedDataInputStream.skipBytes(paramInt) == paramInt)
            return; 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Couldn't jump to first Ifd: ");
          stringBuilder2.append(paramInt);
          throw new IOException(stringBuilder2.toString());
        } 
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Invalid first Ifd offset: ");
      stringBuilder1.append(i);
      throw new IOException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid start code: ");
    stringBuilder.append(Integer.toHexString(i));
    throw new IOException(stringBuilder.toString());
  }
  
  private void a(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt1, int paramInt2) throws IOException {
    paramByteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
    paramByteOrderedDataInputStream.seek(paramInt1);
    int i = paramByteOrderedDataInputStream.readByte();
    if (i == -1) {
      if (paramByteOrderedDataInputStream.readByte() == -40) {
        paramInt1 = paramInt1 + 1 + 1;
        while (true) {
          i = paramByteOrderedDataInputStream.readByte();
          if (i == -1) {
            byte b = paramByteOrderedDataInputStream.readByte();
            if (b != -39) {
              if (b == -38)
                continue; 
              i = paramByteOrderedDataInputStream.readUnsignedShort() - 2;
              int j = paramInt1 + 1 + 1 + 2;
              if (i >= 0) {
                if (b != -31) {
                  if (b != -2) {
                    switch (b) {
                      default:
                        switch (b) {
                          default:
                            switch (b) {
                              default:
                                switch (b) {
                                  default:
                                    paramInt1 = i;
                                    i = j;
                                    break;
                                  case -51:
                                  case -50:
                                  case -49:
                                    break;
                                } 
                                break;
                              case -55:
                              case -54:
                              case -53:
                                break;
                            } 
                            break;
                          case -59:
                          case -58:
                          case -57:
                            break;
                        } 
                      case -64:
                      case -63:
                      case -62:
                      case -61:
                        if (paramByteOrderedDataInputStream.skipBytes(1) == 1) {
                          this.G[paramInt2].put("ImageLength", ExifAttribute.createULong(paramByteOrderedDataInputStream.readUnsignedShort(), this.I));
                          this.G[paramInt2].put("ImageWidth", ExifAttribute.createULong(paramByteOrderedDataInputStream.readUnsignedShort(), this.I));
                          paramInt1 = i - 5;
                          i = j;
                          break;
                        } 
                        throw new IOException("Invalid SOFx");
                    } 
                  } else {
                    byte[] arrayOfByte = new byte[i];
                    if (paramByteOrderedDataInputStream.read(arrayOfByte) == i) {
                      i = j;
                      if (getAttribute("UserComment") == null) {
                        this.G[1].put("UserComment", ExifAttribute.createString(new String(arrayOfByte, f)));
                        i = j;
                      } 
                    } else {
                      throw new IOException("Invalid exif");
                    } 
                    paramInt1 = 0;
                  } 
                } else if (i < 6) {
                  paramInt1 = i;
                  i = j;
                } else {
                  byte[] arrayOfByte = new byte[6];
                  if (paramByteOrderedDataInputStream.read(arrayOfByte) == 6) {
                    j += 6;
                    paramInt1 = i - 6;
                    if (!Arrays.equals(arrayOfByte, g)) {
                      i = j;
                    } else {
                      if (paramInt1 > 0) {
                        this.O = j;
                        arrayOfByte = new byte[paramInt1];
                        if (paramByteOrderedDataInputStream.read(arrayOfByte) == paramInt1) {
                          i = j + paramInt1;
                          a(arrayOfByte, paramInt2);
                        } else {
                          throw new IOException("Invalid exif");
                        } 
                      } else {
                        throw new IOException("Invalid exif");
                      } 
                      paramInt1 = 0;
                    } 
                  } else {
                    throw new IOException("Invalid exif");
                  } 
                } 
                if (paramInt1 >= 0) {
                  if (paramByteOrderedDataInputStream.skipBytes(paramInt1) == paramInt1) {
                    paramInt1 = i + paramInt1;
                    continue;
                  } 
                  throw new IOException("Invalid JPEG segment");
                } 
                throw new IOException("Invalid length");
              } 
              throw new IOException("Invalid length");
            } 
            paramByteOrderedDataInputStream.setByteOrder(this.I);
            return;
          } 
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("Invalid marker:");
          stringBuilder2.append(Integer.toHexString(i & 0xFF));
          throw new IOException(stringBuilder2.toString());
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Invalid marker: ");
      stringBuilder1.append(Integer.toHexString(i & 0xFF));
      throw new IOException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid marker: ");
    stringBuilder.append(Integer.toHexString(i & 0xFF));
    throw new IOException(stringBuilder.toString());
  }
  
  private void a(ByteOrderedDataInputStream paramByteOrderedDataInputStream, HashMap paramHashMap) throws IOException {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 'JPEGInterchangeFormat'
    //   4: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast androidx/exifinterface/media/ExifInterface$ExifAttribute
    //   10: astore #7
    //   12: aload_2
    //   13: ldc_w 'JPEGInterchangeFormatLength'
    //   16: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast androidx/exifinterface/media/ExifInterface$ExifAttribute
    //   22: astore_2
    //   23: aload #7
    //   25: ifnull -> 180
    //   28: aload_2
    //   29: ifnull -> 180
    //   32: aload #7
    //   34: aload_0
    //   35: getfield I : Ljava/nio/ByteOrder;
    //   38: invokevirtual getIntValue : (Ljava/nio/ByteOrder;)I
    //   41: istore #4
    //   43: aload_2
    //   44: aload_0
    //   45: getfield I : Ljava/nio/ByteOrder;
    //   48: invokevirtual getIntValue : (Ljava/nio/ByteOrder;)I
    //   51: aload_1
    //   52: invokevirtual available : ()I
    //   55: iload #4
    //   57: isub
    //   58: invokestatic min : (II)I
    //   61: istore #5
    //   63: aload_0
    //   64: getfield F : I
    //   67: istore #6
    //   69: iload #6
    //   71: iconst_4
    //   72: if_icmpeq -> 110
    //   75: iload #6
    //   77: bipush #9
    //   79: if_icmpeq -> 110
    //   82: iload #6
    //   84: bipush #10
    //   86: if_icmpne -> 92
    //   89: goto -> 110
    //   92: iload #4
    //   94: istore_3
    //   95: iload #6
    //   97: bipush #7
    //   99: if_icmpne -> 120
    //   102: aload_0
    //   103: getfield P : I
    //   106: istore_3
    //   107: goto -> 115
    //   110: aload_0
    //   111: getfield O : I
    //   114: istore_3
    //   115: iload #4
    //   117: iload_3
    //   118: iadd
    //   119: istore_3
    //   120: iload_3
    //   121: ifle -> 180
    //   124: iload #5
    //   126: ifle -> 180
    //   129: aload_0
    //   130: iconst_1
    //   131: putfield J : Z
    //   134: aload_0
    //   135: iload_3
    //   136: putfield K : I
    //   139: aload_0
    //   140: iload #5
    //   142: putfield L : I
    //   145: aload_0
    //   146: getfield D : Ljava/lang/String;
    //   149: ifnonnull -> 180
    //   152: aload_0
    //   153: getfield E : Landroid/content/res/AssetManager$AssetInputStream;
    //   156: ifnonnull -> 180
    //   159: iload #5
    //   161: newarray byte
    //   163: astore_2
    //   164: aload_1
    //   165: iload_3
    //   166: i2l
    //   167: invokevirtual seek : (J)V
    //   170: aload_1
    //   171: aload_2
    //   172: invokevirtual readFully : ([B)V
    //   175: aload_0
    //   176: aload_2
    //   177: putfield M : [B
    //   180: return
  }
  
  private static void a(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (RuntimeException runtimeException) {
        throw runtimeException;
      } catch (Exception exception) {
        return;
      }  
  }
  
  private void a(InputStream paramInputStream) throws IOException {
    int i = 0;
    try {
      while (i < e.length) {
        this.G[i] = new HashMap<String, ExifAttribute>();
        i++;
      } 
      paramInputStream = new BufferedInputStream(paramInputStream, 5000);
      this.F = a((BufferedInputStream)paramInputStream);
      paramInputStream = new ByteOrderedDataInputStream(paramInputStream);
      switch (this.F) {
        case 10:
          d((ByteOrderedDataInputStream)paramInputStream);
          break;
        case 9:
          b((ByteOrderedDataInputStream)paramInputStream);
          break;
        case 7:
          c((ByteOrderedDataInputStream)paramInputStream);
          break;
        case 4:
          a((ByteOrderedDataInputStream)paramInputStream, 0, 0);
          break;
        case 0:
        case 1:
        case 2:
        case 3:
        case 5:
        case 6:
        case 8:
        case 11:
          a((ByteOrderedDataInputStream)paramInputStream);
          break;
      } 
      f((ByteOrderedDataInputStream)paramInputStream);
    } catch (IOException iOException) {
    
    } finally {
      a();
    } 
    a();
  }
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    paramInputStream = new DataInputStream(paramInputStream);
    paramOutputStream = new ByteOrderedDataOutputStream(paramOutputStream, ByteOrder.BIG_ENDIAN);
    if (paramInputStream.readByte() == -1) {
      paramOutputStream.writeByte(-1);
      if (paramInputStream.readByte() == -40) {
        paramOutputStream.writeByte(-40);
        paramOutputStream.writeByte(-1);
        paramOutputStream.writeByte(-31);
        a((ByteOrderedDataOutputStream)paramOutputStream, 6);
        byte[] arrayOfByte = new byte[4096];
        while (paramInputStream.readByte() == -1) {
          int i = paramInputStream.readByte();
          if (i != -39 && i != -38) {
            if (i != -31) {
              paramOutputStream.writeByte(-1);
              paramOutputStream.writeByte(i);
              int k = paramInputStream.readUnsignedShort();
              paramOutputStream.writeUnsignedShort(k);
              k -= 2;
              if (k >= 0) {
                while (k > 0) {
                  int m = paramInputStream.read(arrayOfByte, 0, Math.min(k, arrayOfByte.length));
                  if (m >= 0) {
                    paramOutputStream.write(arrayOfByte, 0, m);
                    k -= m;
                  } 
                } 
                continue;
              } 
              throw new IOException("Invalid length");
            } 
            int j = paramInputStream.readUnsignedShort() - 2;
            if (j >= 0) {
              byte[] arrayOfByte1 = new byte[6];
              if (j >= 6)
                if (paramInputStream.read(arrayOfByte1) == 6) {
                  if (Arrays.equals(arrayOfByte1, g)) {
                    i = j - 6;
                    if (paramInputStream.skipBytes(i) == i)
                      continue; 
                    throw new IOException("Invalid length");
                  } 
                } else {
                  throw new IOException("Invalid exif");
                }  
              paramOutputStream.writeByte(-1);
              paramOutputStream.writeByte(i);
              paramOutputStream.writeUnsignedShort(j + 2);
              i = j;
              if (j >= 6) {
                i = j - 6;
                paramOutputStream.write(arrayOfByte1);
              } 
              while (i > 0) {
                j = paramInputStream.read(arrayOfByte, 0, Math.min(i, arrayOfByte.length));
                if (j >= 0) {
                  paramOutputStream.write(arrayOfByte, 0, j);
                  i -= j;
                } 
              } 
              continue;
            } 
            throw new IOException("Invalid length");
          } 
          paramOutputStream.writeByte(-1);
          paramOutputStream.writeByte(i);
          b(paramInputStream, paramOutputStream);
          return;
        } 
        throw new IOException("Invalid marker");
      } 
      throw new IOException("Invalid marker");
    } 
    throw new IOException("Invalid marker");
  }
  
  private void a(byte[] paramArrayOfbyte, int paramInt) throws IOException {
    ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(paramArrayOfbyte);
    a(byteOrderedDataInputStream, paramArrayOfbyte.length);
    b(byteOrderedDataInputStream, paramInt);
  }
  
  private boolean a(HashMap paramHashMap) throws IOException {
    ExifAttribute exifAttribute = (ExifAttribute)paramHashMap.get("BitsPerSample");
    if (exifAttribute != null) {
      int[] arrayOfInt = (int[])exifAttribute.a(this.I);
      if (Arrays.equals(BITS_PER_SAMPLE_RGB, arrayOfInt))
        return true; 
      if (this.F == 3) {
        ExifAttribute exifAttribute1 = (ExifAttribute)paramHashMap.get("PhotometricInterpretation");
        if (exifAttribute1 != null) {
          int i = exifAttribute1.getIntValue(this.I);
          if ((i == 1 && Arrays.equals(arrayOfInt, BITS_PER_SAMPLE_GREYSCALE_2)) || (i == 6 && Arrays.equals(arrayOfInt, BITS_PER_SAMPLE_RGB)))
            return true; 
        } 
      } 
    } 
    return false;
  }
  
  private static boolean a(byte[] paramArrayOfbyte) throws IOException {
    int i = 0;
    while (true) {
      byte[] arrayOfByte = a;
      if (i < arrayOfByte.length) {
        if (paramArrayOfbyte[i] != arrayOfByte[i])
          return false; 
        i++;
        continue;
      } 
      return true;
    } 
  }
  
  private static long[] a(Object paramObject) {
    if (paramObject instanceof int[]) {
      paramObject = paramObject;
      long[] arrayOfLong = new long[paramObject.length];
      for (int i = 0; i < paramObject.length; i++)
        arrayOfLong[i] = paramObject[i]; 
      return arrayOfLong;
    } 
    return (paramObject instanceof long[]) ? (long[])paramObject : null;
  }
  
  private static int b(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    byte[] arrayOfByte = new byte[8192];
    int i = 0;
    while (true) {
      int j = paramInputStream.read(arrayOfByte);
      if (j != -1) {
        i += j;
        paramOutputStream.write(arrayOfByte, 0, j);
        continue;
      } 
      return i;
    } 
  }
  
  private void b(ByteOrderedDataInputStream paramByteOrderedDataInputStream) throws IOException {
    paramByteOrderedDataInputStream.skipBytes(84);
    byte[] arrayOfByte1 = new byte[4];
    byte[] arrayOfByte2 = new byte[4];
    paramByteOrderedDataInputStream.read(arrayOfByte1);
    paramByteOrderedDataInputStream.skipBytes(4);
    paramByteOrderedDataInputStream.read(arrayOfByte2);
    int i = ByteBuffer.wrap(arrayOfByte1).getInt();
    int j = ByteBuffer.wrap(arrayOfByte2).getInt();
    a(paramByteOrderedDataInputStream, i, 5);
    paramByteOrderedDataInputStream.seek(j);
    paramByteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
    j = paramByteOrderedDataInputStream.readInt();
    for (i = 0; i < j; i++) {
      ExifAttribute exifAttribute;
      int k = paramByteOrderedDataInputStream.readUnsignedShort();
      int m = paramByteOrderedDataInputStream.readUnsignedShort();
      if (k == r.number) {
        i = paramByteOrderedDataInputStream.readShort();
        j = paramByteOrderedDataInputStream.readShort();
        exifAttribute = ExifAttribute.createUShort(i, this.I);
        ExifAttribute exifAttribute1 = ExifAttribute.createUShort(j, this.I);
        this.G[0].put("ImageLength", exifAttribute);
        this.G[0].put("ImageWidth", exifAttribute1);
        return;
      } 
      exifAttribute.skipBytes(m);
    } 
  }
  
  private void b(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt) throws IOException {
    this.H.add(Integer.valueOf(paramByteOrderedDataInputStream.b));
    if (paramByteOrderedDataInputStream.b + 2 > paramByteOrderedDataInputStream.a)
      return; 
    short s = paramByteOrderedDataInputStream.readShort();
    if (paramByteOrderedDataInputStream.b + s * 12 <= paramByteOrderedDataInputStream.a) {
      if (s <= 0)
        return; 
      for (short s1 = 0;; s1 = (short)(s1 + 1)) {
        int i = paramInt;
        if (s1 < s) {
          int m = paramByteOrderedDataInputStream.readUnsignedShort();
          int k = paramByteOrderedDataInputStream.readUnsignedShort();
          int n = paramByteOrderedDataInputStream.readInt();
          long l2 = paramByteOrderedDataInputStream.peek() + 4L;
          ExifTag exifTag = z[i].get(Integer.valueOf(m));
          if (exifTag == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Skip the tag entry since tag number is not defined: ");
            stringBuilder.append(m);
            Log.w("ExifInterface", stringBuilder.toString());
          } else if (k <= 0 || k >= c.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Skip the tag entry since data format is invalid: ");
            stringBuilder.append(k);
            Log.w("ExifInterface", stringBuilder.toString());
          } else if (!exifTag.a(k)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Skip the tag entry since data format (");
            stringBuilder.append(b[k]);
            stringBuilder.append(") is unexpected for tag: ");
            stringBuilder.append(exifTag.name);
            Log.w("ExifInterface", stringBuilder.toString());
          } else {
            int i1 = k;
            if (k == 7)
              i1 = exifTag.primaryFormat; 
            long l = n * c[i1];
            if (l < 0L || l > 2147483647L) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Skip the tag entry since the number of components is invalid: ");
              stringBuilder.append(n);
              Log.w("ExifInterface", stringBuilder.toString());
            } else {
              k = 1;
            } 
            k = 0;
          } 
          long l1 = 0L;
          int j = k;
        } else {
          if (paramByteOrderedDataInputStream.peek() + 4 <= paramByteOrderedDataInputStream.a) {
            paramInt = paramByteOrderedDataInputStream.readInt();
            long l = paramInt;
            if (l > 0L && paramInt < paramByteOrderedDataInputStream.a) {
              if (!this.H.contains(Integer.valueOf(paramInt))) {
                paramByteOrderedDataInputStream.seek(l);
                if (this.G[4].isEmpty()) {
                  b(paramByteOrderedDataInputStream, 4);
                  return;
                } 
                if (this.G[5].isEmpty()) {
                  b(paramByteOrderedDataInputStream, 5);
                  return;
                } 
                break;
              } 
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
              stringBuilder1.append(paramInt);
              Log.w("ExifInterface", stringBuilder1.toString());
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Stop reading file since a wrong offset may cause an infinite loop: ");
            stringBuilder.append(paramInt);
            Log.w("ExifInterface", stringBuilder.toString());
          } 
          break;
        } 
        boolean bool = false;
      } 
    } 
  }
  
  private void b(ByteOrderedDataInputStream paramByteOrderedDataInputStream, HashMap paramHashMap) throws IOException {
    ExifAttribute exifAttribute1 = (ExifAttribute)paramHashMap.get("StripOffsets");
    ExifAttribute exifAttribute2 = (ExifAttribute)paramHashMap.get("StripByteCounts");
    if (exifAttribute1 != null && exifAttribute2 != null) {
      long[] arrayOfLong1 = a(exifAttribute1.a(this.I));
      long[] arrayOfLong2 = a(exifAttribute2.a(this.I));
      if (arrayOfLong1 == null) {
        Log.w("ExifInterface", "stripOffsets should not be null.");
        return;
      } 
      if (arrayOfLong2 == null) {
        Log.w("ExifInterface", "stripByteCounts should not be null.");
        return;
      } 
      int j = arrayOfLong2.length;
      long l = 0L;
      int i;
      for (i = 0; i < j; i++)
        l += arrayOfLong2[i]; 
      byte[] arrayOfByte = new byte[(int)l];
      j = 0;
      int k = 0;
      i = 0;
      while (j < arrayOfLong1.length) {
        int n = (int)arrayOfLong1[j];
        int m = (int)arrayOfLong2[j];
        n -= k;
        if (n < 0)
          Log.d("ExifInterface", "Invalid strip offset value"); 
        paramByteOrderedDataInputStream.seek(n);
        byte[] arrayOfByte1 = new byte[m];
        paramByteOrderedDataInputStream.read(arrayOfByte1);
        k = k + n + m;
        System.arraycopy(arrayOfByte1, 0, arrayOfByte, i, arrayOfByte1.length);
        i += arrayOfByte1.length;
        j++;
      } 
      this.J = true;
      this.M = arrayOfByte;
      this.L = arrayOfByte.length;
    } 
  }
  
  private void b(InputStream paramInputStream) throws IOException {
    a(0, 5);
    a(0, 4);
    a(5, 4);
    ExifAttribute exifAttribute1 = this.G[1].get("PixelXDimension");
    ExifAttribute exifAttribute2 = this.G[1].get("PixelYDimension");
    if (exifAttribute1 != null && exifAttribute2 != null) {
      this.G[0].put("ImageWidth", exifAttribute1);
      this.G[0].put("ImageLength", exifAttribute2);
    } 
    if (this.G[4].isEmpty() && b(this.G[5])) {
      HashMap<String, ExifAttribute>[] arrayOfHashMap = this.G;
      arrayOfHashMap[4] = arrayOfHashMap[5];
      arrayOfHashMap[5] = new HashMap<String, ExifAttribute>();
    } 
    if (!b(this.G[4]))
      Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image."); 
  }
  
  private void b(String paramString) {
    for (int i = 0; i < e.length; i++)
      this.G[i].remove(paramString); 
  }
  
  private boolean b(HashMap paramHashMap) throws IOException {
    ExifAttribute exifAttribute2 = (ExifAttribute)paramHashMap.get("ImageLength");
    ExifAttribute exifAttribute1 = (ExifAttribute)paramHashMap.get("ImageWidth");
    if (exifAttribute2 != null && exifAttribute1 != null) {
      int i = exifAttribute2.getIntValue(this.I);
      int j = exifAttribute1.getIntValue(this.I);
      if (i <= 512 && j <= 512)
        return true; 
    } 
    return false;
  }
  
  private boolean b(byte[] paramArrayOfbyte) throws IOException {
    byte[] arrayOfByte = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
    for (int i = 0; i < arrayOfByte.length; i++) {
      if (paramArrayOfbyte[i] != arrayOfByte[i])
        return false; 
    } 
    return true;
  }
  
  private static Pair<Integer, Integer> c(String paramString) {
    Pair<Integer, Integer> pair;
    long l1;
    long l2;
    boolean bool = paramString.contains(",");
    int i = 1;
    Integer integer1 = Integer.valueOf(2);
    Integer integer2 = Integer.valueOf(-1);
    if (bool) {
      String[] arrayOfString = paramString.split(",", -1);
      Pair<Integer, Integer> pair1 = c(arrayOfString[0]);
      pair = pair1;
      if (((Integer)pair1.first).intValue() == 2)
        return pair1; 
      while (i < arrayOfString.length) {
        byte b1;
        byte b2;
        pair1 = c(arrayOfString[i]);
        if (((Integer)pair1.first).equals(pair.first) || ((Integer)pair1.second).equals(pair.first)) {
          b1 = ((Integer)pair.first).intValue();
        } else {
          b1 = -1;
        } 
        if (((Integer)pair.second).intValue() != -1 && (((Integer)pair1.first).equals(pair.second) || ((Integer)pair1.second).equals(pair.second))) {
          b2 = ((Integer)pair.second).intValue();
        } else {
          b2 = -1;
        } 
        if (b1 == -1 && b2 == -1)
          return new Pair(integer1, integer2); 
        if (b1 == -1) {
          pair = new Pair(Integer.valueOf(b2), integer2);
        } else if (b2 == -1) {
          pair = new Pair(Integer.valueOf(b1), integer2);
        } 
        i++;
      } 
      return pair;
    } 
    if (pair.contains("/")) {
      String[] arrayOfString = pair.split("/", -1);
      if (arrayOfString.length == 2) {
        try {
          l1 = (long)Double.parseDouble(arrayOfString[0]);
          l2 = (long)Double.parseDouble(arrayOfString[1]);
          if (l1 < 0L || l2 < 0L)
            return new Pair(Integer.valueOf(10), integer2); 
        } catch (NumberFormatException numberFormatException) {
          return new Pair(integer1, integer2);
        } 
      } else {
        return new Pair(integer1, integer2);
      } 
    } else {
      try {
        Long long_ = Long.valueOf(Long.parseLong((String)numberFormatException));
        return (long_.longValue() >= 0L && long_.longValue() <= 65535L) ? new Pair(Integer.valueOf(3), Integer.valueOf(4)) : ((long_.longValue() < 0L) ? new Pair(Integer.valueOf(9), integer2) : new Pair(Integer.valueOf(4), integer2));
      } catch (NumberFormatException numberFormatException1) {
        try {
          Double.parseDouble((String)numberFormatException);
          return new Pair(Integer.valueOf(12), integer2);
        } catch (NumberFormatException numberFormatException2) {
          return new Pair(integer1, integer2);
        } 
      } 
    } 
    return (l1 > 2147483647L || l2 > 2147483647L) ? new Pair(Integer.valueOf(5), integer2) : new Pair(Integer.valueOf(10), Integer.valueOf(5));
  }
  
  private void c(ByteOrderedDataInputStream paramByteOrderedDataInputStream) throws IOException {
    a(paramByteOrderedDataInputStream);
    ExifAttribute exifAttribute = this.G[1].get("MakerNote");
    if (exifAttribute != null) {
      ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(exifAttribute.bytes);
      byteOrderedDataInputStream.setByteOrder(this.I);
      byte[] arrayOfByte1 = new byte[j.length];
      byteOrderedDataInputStream.readFully(arrayOfByte1);
      byteOrderedDataInputStream.seek(0L);
      byte[] arrayOfByte2 = new byte[k.length];
      byteOrderedDataInputStream.readFully(arrayOfByte2);
      if (Arrays.equals(arrayOfByte1, j)) {
        byteOrderedDataInputStream.seek(8L);
      } else if (Arrays.equals(arrayOfByte2, k)) {
        byteOrderedDataInputStream.seek(12L);
      } 
      b(byteOrderedDataInputStream, 6);
      ExifAttribute exifAttribute1 = this.G[7].get("PreviewImageStart");
      ExifAttribute exifAttribute2 = this.G[7].get("PreviewImageLength");
      if (exifAttribute1 != null && exifAttribute2 != null) {
        this.G[5].put("JPEGInterchangeFormat", exifAttribute1);
        this.G[5].put("JPEGInterchangeFormatLength", exifAttribute2);
      } 
      exifAttribute1 = this.G[8].get("AspectFrame");
      if (exifAttribute1 != null) {
        int[] arrayOfInt = (int[])exifAttribute1.a(this.I);
        if (arrayOfInt == null || arrayOfInt.length != 4) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid aspect frame values. frame=");
          stringBuilder.append(Arrays.toString(arrayOfInt));
          Log.w("ExifInterface", stringBuilder.toString());
          return;
        } 
        if (arrayOfInt[2] > arrayOfInt[0] && arrayOfInt[3] > arrayOfInt[1]) {
          int m = arrayOfInt[2] - arrayOfInt[0] + 1;
          int k = arrayOfInt[3] - arrayOfInt[1] + 1;
          int j = m;
          int i = k;
          if (m < k) {
            j = m + k;
            i = j - k;
            j -= i;
          } 
          ExifAttribute exifAttribute3 = ExifAttribute.createUShort(j, this.I);
          exifAttribute2 = ExifAttribute.createUShort(i, this.I);
          this.G[0].put("ImageWidth", exifAttribute3);
          this.G[0].put("ImageLength", exifAttribute2);
          return;
        } 
      } 
    } 
  }
  
  private void c(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt) throws IOException {
    ExifAttribute exifAttribute1 = this.G[paramInt].get("ImageLength");
    ExifAttribute exifAttribute2 = this.G[paramInt].get("ImageWidth");
    if (exifAttribute1 == null || exifAttribute2 == null) {
      exifAttribute1 = this.G[paramInt].get("JPEGInterchangeFormat");
      if (exifAttribute1 != null)
        a(paramByteOrderedDataInputStream, exifAttribute1.getIntValue(this.I), paramInt); 
    } 
  }
  
  private boolean c(byte[] paramArrayOfbyte) throws IOException {
    ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(paramArrayOfbyte);
    this.I = e(byteOrderedDataInputStream);
    byteOrderedDataInputStream.setByteOrder(this.I);
    short s = byteOrderedDataInputStream.readShort();
    byteOrderedDataInputStream.close();
    return (s == 20306 || s == 21330);
  }
  
  private void d(ByteOrderedDataInputStream paramByteOrderedDataInputStream) throws IOException {
    a(paramByteOrderedDataInputStream);
    if ((ExifAttribute)this.G[0].get("JpgFromRaw") != null)
      a(paramByteOrderedDataInputStream, this.S, 5); 
    ExifAttribute exifAttribute1 = this.G[0].get("ISO");
    ExifAttribute exifAttribute2 = this.G[1].get("PhotographicSensitivity");
    if (exifAttribute1 != null && exifAttribute2 == null)
      this.G[1].put("PhotographicSensitivity", exifAttribute1); 
  }
  
  private void d(ByteOrderedDataInputStream paramByteOrderedDataInputStream, int paramInt) throws IOException {
    ExifAttribute exifAttribute1;
    ExifAttribute exifAttribute2 = this.G[paramInt].get("DefaultCropSize");
    ExifAttribute exifAttribute3 = this.G[paramInt].get("SensorTopBorder");
    ExifAttribute exifAttribute4 = this.G[paramInt].get("SensorLeftBorder");
    ExifAttribute exifAttribute5 = this.G[paramInt].get("SensorBottomBorder");
    ExifAttribute exifAttribute6 = this.G[paramInt].get("SensorRightBorder");
    if (exifAttribute2 != null) {
      ExifAttribute exifAttribute;
      if (exifAttribute2.format == 5) {
        Rational[] arrayOfRational = (Rational[])exifAttribute2.a(this.I);
        if (arrayOfRational == null || arrayOfRational.length != 2) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid crop size values. cropSize=");
          stringBuilder.append(Arrays.toString((Object[])arrayOfRational));
          Log.w("ExifInterface", stringBuilder.toString());
          return;
        } 
        exifAttribute1 = ExifAttribute.createURational(arrayOfRational[0], this.I);
        exifAttribute = ExifAttribute.createURational(arrayOfRational[1], this.I);
      } else {
        int[] arrayOfInt = (int[])exifAttribute.a(this.I);
        if (arrayOfInt == null || arrayOfInt.length != 2) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid crop size values. cropSize=");
          stringBuilder.append(Arrays.toString(arrayOfInt));
          Log.w("ExifInterface", stringBuilder.toString());
          return;
        } 
        exifAttribute1 = ExifAttribute.createUShort(arrayOfInt[0], this.I);
        exifAttribute = ExifAttribute.createUShort(arrayOfInt[1], this.I);
      } 
      this.G[paramInt].put("ImageWidth", exifAttribute1);
      this.G[paramInt].put("ImageLength", exifAttribute);
      return;
    } 
    if (exifAttribute3 != null && exifAttribute4 != null && exifAttribute5 != null && exifAttribute6 != null) {
      int i = exifAttribute3.getIntValue(this.I);
      int j = exifAttribute5.getIntValue(this.I);
      int k = exifAttribute6.getIntValue(this.I);
      int m = exifAttribute4.getIntValue(this.I);
      if (j > i && k > m) {
        exifAttribute1 = ExifAttribute.createUShort(j - i, this.I);
        exifAttribute2 = ExifAttribute.createUShort(k - m, this.I);
        this.G[paramInt].put("ImageLength", exifAttribute1);
        this.G[paramInt].put("ImageWidth", exifAttribute2);
        return;
      } 
    } else {
      c((ByteOrderedDataInputStream)exifAttribute1, paramInt);
    } 
  }
  
  private boolean d(byte[] paramArrayOfbyte) throws IOException {
    ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(paramArrayOfbyte);
    this.I = e(byteOrderedDataInputStream);
    byteOrderedDataInputStream.setByteOrder(this.I);
    short s = byteOrderedDataInputStream.readShort();
    byteOrderedDataInputStream.close();
    return (s == 85);
  }
  
  private ByteOrder e(ByteOrderedDataInputStream paramByteOrderedDataInputStream) throws IOException {
    short s = paramByteOrderedDataInputStream.readShort();
    if (s != 18761) {
      if (s == 19789)
        return ByteOrder.BIG_ENDIAN; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid byte order: ");
      stringBuilder.append(Integer.toHexString(s));
      throw new IOException(stringBuilder.toString());
    } 
    return ByteOrder.LITTLE_ENDIAN;
  }
  
  private void f(ByteOrderedDataInputStream paramByteOrderedDataInputStream) throws IOException {
    HashMap<String, ExifAttribute> hashMap = this.G[4];
    ExifAttribute exifAttribute = hashMap.get("Compression");
    if (exifAttribute != null) {
      this.N = exifAttribute.getIntValue(this.I);
      int i = this.N;
      if (i != 1)
        if (i != 6) {
          if (i != 7)
            return; 
        } else {
          a(paramByteOrderedDataInputStream, hashMap);
          return;
        }  
      if (a(hashMap)) {
        b(paramByteOrderedDataInputStream, hashMap);
        return;
      } 
    } else {
      this.N = 6;
      a(paramByteOrderedDataInputStream, hashMap);
    } 
  }
  
  public void flipHorizontally() {
    byte b = 1;
    switch (getAttributeInt("Orientation", 1)) {
      default:
        b = 0;
        break;
      case 8:
        b = 7;
        break;
      case 7:
        b = 8;
        break;
      case 6:
        b = 5;
        break;
      case 5:
        b = 6;
        break;
      case 4:
        b = 3;
        break;
      case 3:
        b = 4;
        break;
      case 1:
        b = 2;
        break;
      case 2:
        break;
    } 
    setAttribute("Orientation", Integer.toString(b));
  }
  
  public void flipVertically() {
    byte b = 1;
    switch (getAttributeInt("Orientation", 1)) {
      default:
        b = 0;
        break;
      case 8:
        b = 5;
        break;
      case 7:
        b = 6;
        break;
      case 6:
        b = 7;
        break;
      case 5:
        b = 8;
        break;
      case 3:
        b = 2;
        break;
      case 2:
        b = 3;
        break;
      case 1:
        b = 4;
        break;
      case 4:
        break;
    } 
    setAttribute("Orientation", Integer.toString(b));
  }
  
  public double getAltitude(double paramDouble) {
    double d = getAttributeDouble("GPSAltitude", -1.0D);
    int i = getAttributeInt("GPSAltitudeRef", -1);
    if (d >= 0.0D && i >= 0) {
      byte b = 1;
      if (i == 1)
        b = -1; 
      return d * b;
    } 
    return paramDouble;
  }
  
  public String getAttribute(String paramString) {
    ExifAttribute exifAttribute = a(paramString);
    if (exifAttribute != null) {
      StringBuilder stringBuilder;
      if (!B.contains(paramString))
        return exifAttribute.getStringValue(this.I); 
      if (paramString.equals("GPSTimeStamp")) {
        if (exifAttribute.format != 5 && exifAttribute.format != 10) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("GPS Timestamp format is not rational. format=");
          stringBuilder1.append(exifAttribute.format);
          Log.w("ExifInterface", stringBuilder1.toString());
          return null;
        } 
        Rational[] arrayOfRational = (Rational[])exifAttribute.a(this.I);
        if (arrayOfRational == null || arrayOfRational.length != 3) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid GPS Timestamp array. array=");
          stringBuilder.append(Arrays.toString((Object[])arrayOfRational));
          Log.w("ExifInterface", stringBuilder.toString());
          return null;
        } 
        return String.format("%02d:%02d:%02d", new Object[] { Integer.valueOf((int)((float)(arrayOfRational[0]).numerator / (float)(arrayOfRational[0]).denominator)), Integer.valueOf((int)((float)(arrayOfRational[1]).numerator / (float)(arrayOfRational[1]).denominator)), Integer.valueOf((int)((float)(arrayOfRational[2]).numerator / (float)(arrayOfRational[2]).denominator)) });
      } 
      try {
        return Double.toString(stringBuilder.getDoubleValue(this.I));
      } catch (NumberFormatException numberFormatException) {
        return null;
      } 
    } 
    return null;
  }
  
  public double getAttributeDouble(String paramString, double paramDouble) {
    ExifAttribute exifAttribute = a(paramString);
    if (exifAttribute == null)
      return paramDouble; 
    try {
      return exifAttribute.getDoubleValue(this.I);
    } catch (NumberFormatException numberFormatException) {
      return paramDouble;
    } 
  }
  
  public int getAttributeInt(String paramString, int paramInt) {
    ExifAttribute exifAttribute = a(paramString);
    if (exifAttribute == null)
      return paramInt; 
    try {
      return exifAttribute.getIntValue(this.I);
    } catch (NumberFormatException numberFormatException) {
      return paramInt;
    } 
  }
  
  public long getDateTime() {
    String str = getAttribute("DateTime");
    if (str != null) {
      if (!U.matcher(str).matches())
        return -1L; 
      ParsePosition parsePosition = new ParsePosition(0);
      try {
        Date date = l.parse(str, parsePosition);
        if (date == null)
          return -1L; 
        long l2 = date.getTime();
        String str1 = getAttribute("SubSecTime");
        long l1 = l2;
        if (str1 != null)
          try {
            for (l1 = Long.parseLong(str1); l1 > 1000L; l1 /= 10L);
            return l2 + l1;
          } catch (NumberFormatException numberFormatException) {
            return l2;
          }  
        return l1;
      } catch (IllegalArgumentException illegalArgumentException) {
        return -1L;
      } 
    } 
    return -1L;
  }
  
  public long getGpsDateTime() {
    String str1 = getAttribute("GPSDateStamp");
    String str2 = getAttribute("GPSTimeStamp");
    if (str1 != null && str2 != null) {
      if (!U.matcher(str1).matches() && !U.matcher(str2).matches())
        return -1L; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(' ');
      stringBuilder.append(str2);
      str1 = stringBuilder.toString();
      ParsePosition parsePosition = new ParsePosition(0);
      try {
        Date date = l.parse(str1, parsePosition);
        return (date == null) ? -1L : date.getTime();
      } catch (IllegalArgumentException illegalArgumentException) {
        return -1L;
      } 
    } 
    return -1L;
  }
  
  @Deprecated
  public boolean getLatLong(float[] paramArrayOffloat) {
    double[] arrayOfDouble = getLatLong();
    if (arrayOfDouble == null)
      return false; 
    paramArrayOffloat[0] = (float)arrayOfDouble[0];
    paramArrayOffloat[1] = (float)arrayOfDouble[1];
    return true;
  }
  
  public double[] getLatLong() {
    String str1 = getAttribute("GPSLatitude");
    String str2 = getAttribute("GPSLatitudeRef");
    String str3 = getAttribute("GPSLongitude");
    String str4 = getAttribute("GPSLongitudeRef");
    if (str1 != null && str2 != null && str3 != null && str4 != null)
      try {
        double d1 = a(str1, str2);
        double d2 = a(str3, str4);
        return new double[] { d1, d2 };
      } catch (IllegalArgumentException illegalArgumentException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Latitude/longitude values are not parseable. ");
        stringBuilder.append(String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[] { str1, str2, str3, str4 }));
        Log.w("ExifInterface", stringBuilder.toString());
      }  
    return null;
  }
  
  public int getRotationDegrees() {
    switch (getAttributeInt("Orientation", 1)) {
      default:
        return 0;
      case 6:
      case 7:
        return 90;
      case 5:
      case 8:
        return 270;
      case 3:
      case 4:
        break;
    } 
    return 180;
  }
  
  public byte[] getThumbnail() {
    int i = this.N;
    return (i == 6 || i == 7) ? getThumbnailBytes() : null;
  }
  
  public Bitmap getThumbnailBitmap() {
    if (!this.J)
      return null; 
    if (this.M == null)
      this.M = getThumbnailBytes(); 
    int i = this.N;
    if (i == 6 || i == 7)
      return BitmapFactory.decodeByteArray(this.M, 0, this.L); 
    if (i == 1) {
      int[] arrayOfInt = new int[this.M.length / 3];
      for (i = 0; i < arrayOfInt.length; i++) {
        byte[] arrayOfByte = this.M;
        int j = i * 3;
        arrayOfInt[i] = (arrayOfByte[j] << 16) + 0 + (arrayOfByte[j + 1] << 8) + arrayOfByte[j + 2];
      } 
      ExifAttribute exifAttribute1 = this.G[4].get("ImageLength");
      ExifAttribute exifAttribute2 = this.G[4].get("ImageWidth");
      if (exifAttribute1 != null && exifAttribute2 != null) {
        i = exifAttribute1.getIntValue(this.I);
        return Bitmap.createBitmap(arrayOfInt, exifAttribute2.getIntValue(this.I), i, Bitmap.Config.ARGB_8888);
      } 
    } 
    return null;
  }
  
  public byte[] getThumbnailBytes() {
    // Byte code:
    //   0: aload_0
    //   1: getfield J : Z
    //   4: ifne -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield M : [B
    //   13: astore #4
    //   15: aload #4
    //   17: ifnull -> 23
    //   20: aload #4
    //   22: areturn
    //   23: aload_0
    //   24: getfield E : Landroid/content/res/AssetManager$AssetInputStream;
    //   27: ifnull -> 98
    //   30: aload_0
    //   31: getfield E : Landroid/content/res/AssetManager$AssetInputStream;
    //   34: astore #4
    //   36: aload #4
    //   38: astore #6
    //   40: aload #4
    //   42: astore #5
    //   44: aload #4
    //   46: invokevirtual markSupported : ()Z
    //   49: ifeq -> 68
    //   52: aload #4
    //   54: astore #6
    //   56: aload #4
    //   58: astore #5
    //   60: aload #4
    //   62: invokevirtual reset : ()V
    //   65: goto -> 124
    //   68: aload #4
    //   70: astore #6
    //   72: aload #4
    //   74: astore #5
    //   76: ldc_w 'ExifInterface'
    //   79: ldc_w 'Cannot read thumbnail from inputstream without mark/reset support'
    //   82: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   85: pop
    //   86: aload #4
    //   88: invokestatic a : (Ljava/io/Closeable;)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore #4
    //   95: goto -> 295
    //   98: aload_0
    //   99: getfield D : Ljava/lang/String;
    //   102: ifnull -> 121
    //   105: new java/io/FileInputStream
    //   108: dup
    //   109: aload_0
    //   110: getfield D : Ljava/lang/String;
    //   113: invokespecial <init> : (Ljava/lang/String;)V
    //   116: astore #4
    //   118: goto -> 124
    //   121: aconst_null
    //   122: astore #4
    //   124: aload #4
    //   126: ifnull -> 266
    //   129: aload #4
    //   131: astore #6
    //   133: aload #4
    //   135: astore #5
    //   137: aload #4
    //   139: aload_0
    //   140: getfield K : I
    //   143: i2l
    //   144: invokevirtual skip : (J)J
    //   147: lstore_2
    //   148: aload #4
    //   150: astore #6
    //   152: aload #4
    //   154: astore #5
    //   156: aload_0
    //   157: getfield K : I
    //   160: istore_1
    //   161: lload_2
    //   162: iload_1
    //   163: i2l
    //   164: lcmp
    //   165: ifne -> 247
    //   168: aload #4
    //   170: astore #6
    //   172: aload #4
    //   174: astore #5
    //   176: aload_0
    //   177: getfield L : I
    //   180: newarray byte
    //   182: astore #7
    //   184: aload #4
    //   186: astore #6
    //   188: aload #4
    //   190: astore #5
    //   192: aload #4
    //   194: aload #7
    //   196: invokevirtual read : ([B)I
    //   199: aload_0
    //   200: getfield L : I
    //   203: if_icmpne -> 228
    //   206: aload #4
    //   208: astore #6
    //   210: aload #4
    //   212: astore #5
    //   214: aload_0
    //   215: aload #7
    //   217: putfield M : [B
    //   220: aload #4
    //   222: invokestatic a : (Ljava/io/Closeable;)V
    //   225: aload #7
    //   227: areturn
    //   228: aload #4
    //   230: astore #6
    //   232: aload #4
    //   234: astore #5
    //   236: new java/io/IOException
    //   239: dup
    //   240: ldc_w 'Corrupted image'
    //   243: invokespecial <init> : (Ljava/lang/String;)V
    //   246: athrow
    //   247: aload #4
    //   249: astore #6
    //   251: aload #4
    //   253: astore #5
    //   255: new java/io/IOException
    //   258: dup
    //   259: ldc_w 'Corrupted image'
    //   262: invokespecial <init> : (Ljava/lang/String;)V
    //   265: athrow
    //   266: aload #4
    //   268: astore #6
    //   270: aload #4
    //   272: astore #5
    //   274: new java/io/FileNotFoundException
    //   277: dup
    //   278: invokespecial <init> : ()V
    //   281: athrow
    //   282: astore #4
    //   284: aconst_null
    //   285: astore #5
    //   287: goto -> 320
    //   290: astore #4
    //   292: aconst_null
    //   293: astore #6
    //   295: aload #6
    //   297: astore #5
    //   299: ldc_w 'ExifInterface'
    //   302: ldc_w 'Encountered exception while getting thumbnail'
    //   305: aload #4
    //   307: invokestatic d : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   310: pop
    //   311: aload #6
    //   313: invokestatic a : (Ljava/io/Closeable;)V
    //   316: aconst_null
    //   317: areturn
    //   318: astore #4
    //   320: aload #5
    //   322: invokestatic a : (Ljava/io/Closeable;)V
    //   325: aload #4
    //   327: athrow
    // Exception table:
    //   from	to	target	type
    //   23	36	290	java/io/IOException
    //   23	36	282	finally
    //   44	52	93	java/io/IOException
    //   44	52	318	finally
    //   60	65	93	java/io/IOException
    //   60	65	318	finally
    //   76	86	93	java/io/IOException
    //   76	86	318	finally
    //   98	118	290	java/io/IOException
    //   98	118	282	finally
    //   137	148	93	java/io/IOException
    //   137	148	318	finally
    //   156	161	93	java/io/IOException
    //   156	161	318	finally
    //   176	184	93	java/io/IOException
    //   176	184	318	finally
    //   192	206	93	java/io/IOException
    //   192	206	318	finally
    //   214	220	93	java/io/IOException
    //   214	220	318	finally
    //   236	247	93	java/io/IOException
    //   236	247	318	finally
    //   255	266	93	java/io/IOException
    //   255	266	318	finally
    //   274	282	93	java/io/IOException
    //   274	282	318	finally
    //   299	311	318	finally
  }
  
  public long[] getThumbnailRange() {
    return !this.J ? null : new long[] { this.K, this.L };
  }
  
  public boolean hasThumbnail() {
    return this.J;
  }
  
  public boolean isFlipped() {
    boolean bool2 = true;
    int i = getAttributeInt("Orientation", 1);
    boolean bool1 = bool2;
    if (i != 2) {
      bool1 = bool2;
      if (i != 7) {
        bool1 = bool2;
        if (i != 4) {
          bool1 = bool2;
          if (i != 5)
            bool1 = false; 
        } 
      } 
    } 
    return bool1;
  }
  
  public boolean isThumbnailCompressed() {
    int i = this.N;
    return (i == 6 || i == 7);
  }
  
  public void resetOrientation() {
    setAttribute("Orientation", Integer.toString(1));
  }
  
  public void rotate(int paramInt) {
    if (paramInt % 90 == 0) {
      int k = getAttributeInt("Orientation", 1);
      boolean bool1 = h.contains(Integer.valueOf(k));
      int j = 0;
      boolean bool = false;
      int i = 0;
      if (bool1) {
        j = (h.indexOf(Integer.valueOf(k)) + paramInt / 90) % 4;
        paramInt = i;
        if (j < 0)
          paramInt = 4; 
        i = ((Integer)h.get(j + paramInt)).intValue();
      } else {
        i = bool;
        if (i.contains(Integer.valueOf(k))) {
          i = (i.indexOf(Integer.valueOf(k)) + paramInt / 90) % 4;
          paramInt = j;
          if (i < 0)
            paramInt = 4; 
          i = ((Integer)i.get(i + paramInt)).intValue();
        } 
      } 
      setAttribute("Orientation", Integer.toString(i));
      return;
    } 
    throw new IllegalArgumentException("degree should be a multiple of 90");
  }
  
  public void saveAttributes() throws IOException {
    if (this.T && this.F == 4) {
      if (this.D != null) {
        this.M = getThumbnail();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.D);
        stringBuilder.append(".tmp");
        File file = new File(stringBuilder.toString());
        if ((new File(this.D)).renameTo(file)) {
          Closeable closeable;
          FileOutputStream fileOutputStream = null;
          try {
            closeable = new FileInputStream(file);
          } finally {
            stringBuilder = null;
          } 
          a(closeable);
          a(fileOutputStream);
          file.delete();
          throw stringBuilder;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Could not rename to ");
        stringBuilder.append(file.getAbsolutePath());
        throw new IOException(stringBuilder.toString());
      } 
      throw new IOException("ExifInterface does not support saving attributes for the current input.");
    } 
    throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
  }
  
  public void setAltitude(double paramDouble) {
    String str;
    if (paramDouble >= 0.0D) {
      str = "0";
    } else {
      str = "1";
    } 
    setAttribute("GPSAltitude", (new Rational(Math.abs(paramDouble))).toString());
    setAttribute("GPSAltitudeRef", str);
  }
  
  public void setAttribute(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_2
    //   1: astore #7
    //   3: ldc_w 'ISOSpeedRatings'
    //   6: aload_1
    //   7: invokevirtual equals : (Ljava/lang/Object;)Z
    //   10: ifeq -> 21
    //   13: ldc_w 'PhotographicSensitivity'
    //   16: astore #6
    //   18: goto -> 24
    //   21: aload_1
    //   22: astore #6
    //   24: ldc_w 'ExifInterface'
    //   27: astore_1
    //   28: aload #7
    //   30: astore #5
    //   32: aload #7
    //   34: ifnull -> 286
    //   37: aload #7
    //   39: astore #5
    //   41: getstatic androidx/exifinterface/media/ExifInterface.B : Ljava/util/HashSet;
    //   44: aload #6
    //   46: invokevirtual contains : (Ljava/lang/Object;)Z
    //   49: ifeq -> 286
    //   52: aload #6
    //   54: ldc_w 'GPSTimeStamp'
    //   57: invokevirtual equals : (Ljava/lang/Object;)Z
    //   60: ifeq -> 217
    //   63: getstatic androidx/exifinterface/media/ExifInterface.V : Ljava/util/regex/Pattern;
    //   66: aload #7
    //   68: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual find : ()Z
    //   76: ifne -> 129
    //   79: new java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial <init> : ()V
    //   86: astore_1
    //   87: aload_1
    //   88: ldc_w 'Invalid value for '
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: aload #6
    //   98: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: ldc_w ' : '
    //   106: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: aload #7
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: ldc_w 'ExifInterface'
    //   120: aload_1
    //   121: invokevirtual toString : ()Ljava/lang/String;
    //   124: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   127: pop
    //   128: return
    //   129: new java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial <init> : ()V
    //   136: astore #5
    //   138: aload #5
    //   140: aload_2
    //   141: iconst_1
    //   142: invokevirtual group : (I)Ljava/lang/String;
    //   145: invokestatic parseInt : (Ljava/lang/String;)I
    //   148: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload #5
    //   154: ldc_w '/1,'
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #5
    //   163: aload_2
    //   164: iconst_2
    //   165: invokevirtual group : (I)Ljava/lang/String;
    //   168: invokestatic parseInt : (Ljava/lang/String;)I
    //   171: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload #5
    //   177: ldc_w '/1,'
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload #5
    //   186: aload_2
    //   187: iconst_3
    //   188: invokevirtual group : (I)Ljava/lang/String;
    //   191: invokestatic parseInt : (Ljava/lang/String;)I
    //   194: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload #5
    //   200: ldc_w '/1'
    //   203: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload #5
    //   209: invokevirtual toString : ()Ljava/lang/String;
    //   212: astore #5
    //   214: goto -> 286
    //   217: new androidx/exifinterface/media/ExifInterface$Rational
    //   220: dup
    //   221: aload_2
    //   222: invokestatic parseDouble : (Ljava/lang/String;)D
    //   225: invokespecial <init> : (D)V
    //   228: invokevirtual toString : ()Ljava/lang/String;
    //   231: astore #5
    //   233: goto -> 286
    //   236: new java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial <init> : ()V
    //   243: astore_1
    //   244: aload_1
    //   245: ldc_w 'Invalid value for '
    //   248: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_1
    //   253: aload #6
    //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_1
    //   260: ldc_w ' : '
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload_1
    //   268: aload #7
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: ldc_w 'ExifInterface'
    //   277: aload_1
    //   278: invokevirtual toString : ()Ljava/lang/String;
    //   281: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   284: pop
    //   285: return
    //   286: iconst_0
    //   287: istore #4
    //   289: iload #4
    //   291: getstatic androidx/exifinterface/media/ExifInterface.e : [[Landroidx/exifinterface/media/ExifInterface$ExifTag;
    //   294: arraylength
    //   295: if_icmpge -> 1374
    //   298: iload #4
    //   300: iconst_4
    //   301: if_icmpne -> 316
    //   304: aload_0
    //   305: getfield J : Z
    //   308: ifne -> 316
    //   311: aload_1
    //   312: astore_2
    //   313: goto -> 1363
    //   316: getstatic androidx/exifinterface/media/ExifInterface.A : [Ljava/util/HashMap;
    //   319: iload #4
    //   321: aaload
    //   322: aload #6
    //   324: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   327: checkcast androidx/exifinterface/media/ExifInterface$ExifTag
    //   330: astore #10
    //   332: aload_1
    //   333: astore_2
    //   334: aload #10
    //   336: ifnull -> 1363
    //   339: aload #5
    //   341: ifnonnull -> 362
    //   344: aload_0
    //   345: getfield G : [Ljava/util/HashMap;
    //   348: iload #4
    //   350: aaload
    //   351: aload #6
    //   353: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   356: pop
    //   357: aload_1
    //   358: astore_2
    //   359: goto -> 1363
    //   362: aload #5
    //   364: invokestatic c : (Ljava/lang/String;)Landroid/util/Pair;
    //   367: astore #9
    //   369: aload #10
    //   371: getfield primaryFormat : I
    //   374: aload #9
    //   376: getfield first : Ljava/lang/Object;
    //   379: checkcast java/lang/Integer
    //   382: invokevirtual intValue : ()I
    //   385: if_icmpeq -> 753
    //   388: aload #10
    //   390: getfield primaryFormat : I
    //   393: aload #9
    //   395: getfield second : Ljava/lang/Object;
    //   398: checkcast java/lang/Integer
    //   401: invokevirtual intValue : ()I
    //   404: if_icmpne -> 410
    //   407: goto -> 753
    //   410: aload #10
    //   412: getfield secondaryFormat : I
    //   415: iconst_m1
    //   416: if_icmpeq -> 466
    //   419: aload #10
    //   421: getfield secondaryFormat : I
    //   424: aload #9
    //   426: getfield first : Ljava/lang/Object;
    //   429: checkcast java/lang/Integer
    //   432: invokevirtual intValue : ()I
    //   435: if_icmpeq -> 457
    //   438: aload #10
    //   440: getfield secondaryFormat : I
    //   443: aload #9
    //   445: getfield second : Ljava/lang/Object;
    //   448: checkcast java/lang/Integer
    //   451: invokevirtual intValue : ()I
    //   454: if_icmpne -> 466
    //   457: aload #10
    //   459: getfield secondaryFormat : I
    //   462: istore_3
    //   463: goto -> 759
    //   466: aload #10
    //   468: getfield primaryFormat : I
    //   471: iconst_1
    //   472: if_icmpeq -> 744
    //   475: aload #10
    //   477: getfield primaryFormat : I
    //   480: bipush #7
    //   482: if_icmpeq -> 744
    //   485: aload #10
    //   487: getfield primaryFormat : I
    //   490: iconst_2
    //   491: if_icmpne -> 497
    //   494: goto -> 744
    //   497: new java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial <init> : ()V
    //   504: astore #8
    //   506: aload #8
    //   508: ldc_w 'Given tag ('
    //   511: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload #8
    //   517: aload #6
    //   519: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload #8
    //   525: ldc_w ') value didn't match with one of expected '
    //   528: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload #8
    //   534: ldc_w 'formats: '
    //   537: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload #8
    //   543: getstatic androidx/exifinterface/media/ExifInterface.b : [Ljava/lang/String;
    //   546: aload #10
    //   548: getfield primaryFormat : I
    //   551: aaload
    //   552: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload #10
    //   558: getfield secondaryFormat : I
    //   561: istore_3
    //   562: ldc_w ''
    //   565: astore #7
    //   567: iload_3
    //   568: iconst_m1
    //   569: if_icmpne -> 579
    //   572: ldc_w ''
    //   575: astore_2
    //   576: goto -> 614
    //   579: new java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial <init> : ()V
    //   586: astore_2
    //   587: aload_2
    //   588: ldc_w ', '
    //   591: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload_2
    //   596: getstatic androidx/exifinterface/media/ExifInterface.b : [Ljava/lang/String;
    //   599: aload #10
    //   601: getfield secondaryFormat : I
    //   604: aaload
    //   605: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload_2
    //   610: invokevirtual toString : ()Ljava/lang/String;
    //   613: astore_2
    //   614: aload #8
    //   616: aload_2
    //   617: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload #8
    //   623: ldc_w ' (guess: '
    //   626: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload #8
    //   632: getstatic androidx/exifinterface/media/ExifInterface.b : [Ljava/lang/String;
    //   635: aload #9
    //   637: getfield first : Ljava/lang/Object;
    //   640: checkcast java/lang/Integer
    //   643: invokevirtual intValue : ()I
    //   646: aaload
    //   647: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload #9
    //   653: getfield second : Ljava/lang/Object;
    //   656: checkcast java/lang/Integer
    //   659: invokevirtual intValue : ()I
    //   662: iconst_m1
    //   663: if_icmpne -> 672
    //   666: aload #7
    //   668: astore_2
    //   669: goto -> 713
    //   672: new java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial <init> : ()V
    //   679: astore_2
    //   680: aload_2
    //   681: ldc_w ', '
    //   684: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload_2
    //   689: getstatic androidx/exifinterface/media/ExifInterface.b : [Ljava/lang/String;
    //   692: aload #9
    //   694: getfield second : Ljava/lang/Object;
    //   697: checkcast java/lang/Integer
    //   700: invokevirtual intValue : ()I
    //   703: aaload
    //   704: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload_2
    //   709: invokevirtual toString : ()Ljava/lang/String;
    //   712: astore_2
    //   713: aload #8
    //   715: aload_2
    //   716: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload #8
    //   722: ldc_w ')'
    //   725: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload_1
    //   730: aload #8
    //   732: invokevirtual toString : ()Ljava/lang/String;
    //   735: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   738: pop
    //   739: aload_1
    //   740: astore_2
    //   741: goto -> 1363
    //   744: aload #10
    //   746: getfield primaryFormat : I
    //   749: istore_3
    //   750: goto -> 759
    //   753: aload #10
    //   755: getfield primaryFormat : I
    //   758: istore_3
    //   759: iload_3
    //   760: tableswitch default -> 824, 1 -> 1342, 2 -> 1321, 3 -> 1255, 4 -> 1189, 5 -> 1093, 6 -> 824, 7 -> 1321, 8 -> 824, 9 -> 1025, 10 -> 928, 11 -> 824, 12 -> 860
    //   824: new java/lang/StringBuilder
    //   827: dup
    //   828: invokespecial <init> : ()V
    //   831: astore_2
    //   832: aload_2
    //   833: ldc_w 'Data format isn't one of expected formats: '
    //   836: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: pop
    //   840: aload_2
    //   841: iload_3
    //   842: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: aload_2
    //   847: invokevirtual toString : ()Ljava/lang/String;
    //   850: astore_2
    //   851: aload_1
    //   852: aload_2
    //   853: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   856: pop
    //   857: goto -> 1365
    //   860: aload #5
    //   862: ldc_w ','
    //   865: iconst_m1
    //   866: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   869: astore_2
    //   870: aload_2
    //   871: arraylength
    //   872: newarray double
    //   874: astore #7
    //   876: iconst_0
    //   877: istore_3
    //   878: iload_3
    //   879: aload_2
    //   880: arraylength
    //   881: if_icmpge -> 901
    //   884: aload #7
    //   886: iload_3
    //   887: aload_2
    //   888: iload_3
    //   889: aaload
    //   890: invokestatic parseDouble : (Ljava/lang/String;)D
    //   893: dastore
    //   894: iload_3
    //   895: iconst_1
    //   896: iadd
    //   897: istore_3
    //   898: goto -> 878
    //   901: aload_0
    //   902: getfield G : [Ljava/util/HashMap;
    //   905: iload #4
    //   907: aaload
    //   908: aload #6
    //   910: aload #7
    //   912: aload_0
    //   913: getfield I : Ljava/nio/ByteOrder;
    //   916: invokestatic createDouble : ([DLjava/nio/ByteOrder;)Landroidx/exifinterface/media/ExifInterface$ExifAttribute;
    //   919: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   922: pop
    //   923: aload_1
    //   924: astore_2
    //   925: goto -> 1363
    //   928: aload #5
    //   930: ldc_w ','
    //   933: iconst_m1
    //   934: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   937: astore #7
    //   939: aload #7
    //   941: arraylength
    //   942: anewarray androidx/exifinterface/media/ExifInterface$Rational
    //   945: astore_2
    //   946: iconst_0
    //   947: istore_3
    //   948: iload_3
    //   949: aload #7
    //   951: arraylength
    //   952: if_icmpge -> 1001
    //   955: aload #7
    //   957: iload_3
    //   958: aaload
    //   959: ldc_w '/'
    //   962: iconst_m1
    //   963: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   966: astore #8
    //   968: aload_2
    //   969: iload_3
    //   970: new androidx/exifinterface/media/ExifInterface$Rational
    //   973: dup
    //   974: aload #8
    //   976: iconst_0
    //   977: aaload
    //   978: invokestatic parseDouble : (Ljava/lang/String;)D
    //   981: d2l
    //   982: aload #8
    //   984: iconst_1
    //   985: aaload
    //   986: invokestatic parseDouble : (Ljava/lang/String;)D
    //   989: d2l
    //   990: invokespecial <init> : (JJ)V
    //   993: aastore
    //   994: iload_3
    //   995: iconst_1
    //   996: iadd
    //   997: istore_3
    //   998: goto -> 948
    //   1001: aload_0
    //   1002: getfield G : [Ljava/util/HashMap;
    //   1005: iload #4
    //   1007: aaload
    //   1008: aload #6
    //   1010: aload_2
    //   1011: aload_0
    //   1012: getfield I : Ljava/nio/ByteOrder;
    //   1015: invokestatic createSRational : ([Landroidx/exifinterface/media/ExifInterface$Rational;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/ExifInterface$ExifAttribute;
    //   1018: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1021: pop
    //   1022: goto -> 1088
    //   1025: aload #5
    //   1027: ldc_w ','
    //   1030: iconst_m1
    //   1031: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   1034: astore_2
    //   1035: aload_2
    //   1036: arraylength
    //   1037: newarray int
    //   1039: astore #7
    //   1041: iconst_0
    //   1042: istore_3
    //   1043: iload_3
    //   1044: aload_2
    //   1045: arraylength
    //   1046: if_icmpge -> 1066
    //   1049: aload #7
    //   1051: iload_3
    //   1052: aload_2
    //   1053: iload_3
    //   1054: aaload
    //   1055: invokestatic parseInt : (Ljava/lang/String;)I
    //   1058: iastore
    //   1059: iload_3
    //   1060: iconst_1
    //   1061: iadd
    //   1062: istore_3
    //   1063: goto -> 1043
    //   1066: aload_0
    //   1067: getfield G : [Ljava/util/HashMap;
    //   1070: iload #4
    //   1072: aaload
    //   1073: aload #6
    //   1075: aload #7
    //   1077: aload_0
    //   1078: getfield I : Ljava/nio/ByteOrder;
    //   1081: invokestatic createSLong : ([ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/ExifInterface$ExifAttribute;
    //   1084: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1087: pop
    //   1088: aload_1
    //   1089: astore_2
    //   1090: goto -> 1363
    //   1093: aload #5
    //   1095: ldc_w ','
    //   1098: iconst_m1
    //   1099: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   1102: astore_2
    //   1103: aload_2
    //   1104: arraylength
    //   1105: anewarray androidx/exifinterface/media/ExifInterface$Rational
    //   1108: astore #7
    //   1110: iconst_0
    //   1111: istore_3
    //   1112: iload_3
    //   1113: aload_2
    //   1114: arraylength
    //   1115: if_icmpge -> 1164
    //   1118: aload_2
    //   1119: iload_3
    //   1120: aaload
    //   1121: ldc_w '/'
    //   1124: iconst_m1
    //   1125: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   1128: astore #8
    //   1130: aload #7
    //   1132: iload_3
    //   1133: new androidx/exifinterface/media/ExifInterface$Rational
    //   1136: dup
    //   1137: aload #8
    //   1139: iconst_0
    //   1140: aaload
    //   1141: invokestatic parseDouble : (Ljava/lang/String;)D
    //   1144: d2l
    //   1145: aload #8
    //   1147: iconst_1
    //   1148: aaload
    //   1149: invokestatic parseDouble : (Ljava/lang/String;)D
    //   1152: d2l
    //   1153: invokespecial <init> : (JJ)V
    //   1156: aastore
    //   1157: iload_3
    //   1158: iconst_1
    //   1159: iadd
    //   1160: istore_3
    //   1161: goto -> 1112
    //   1164: aload_0
    //   1165: getfield G : [Ljava/util/HashMap;
    //   1168: iload #4
    //   1170: aaload
    //   1171: aload #6
    //   1173: aload #7
    //   1175: aload_0
    //   1176: getfield I : Ljava/nio/ByteOrder;
    //   1179: invokestatic createURational : ([Landroidx/exifinterface/media/ExifInterface$Rational;Ljava/nio/ByteOrder;)Landroidx/exifinterface/media/ExifInterface$ExifAttribute;
    //   1182: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1185: pop
    //   1186: goto -> 1360
    //   1189: aload #5
    //   1191: ldc_w ','
    //   1194: iconst_m1
    //   1195: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   1198: astore_2
    //   1199: aload_2
    //   1200: arraylength
    //   1201: newarray long
    //   1203: astore #7
    //   1205: iconst_0
    //   1206: istore_3
    //   1207: iload_3
    //   1208: aload_2
    //   1209: arraylength
    //   1210: if_icmpge -> 1230
    //   1213: aload #7
    //   1215: iload_3
    //   1216: aload_2
    //   1217: iload_3
    //   1218: aaload
    //   1219: invokestatic parseLong : (Ljava/lang/String;)J
    //   1222: lastore
    //   1223: iload_3
    //   1224: iconst_1
    //   1225: iadd
    //   1226: istore_3
    //   1227: goto -> 1207
    //   1230: aload_0
    //   1231: getfield G : [Ljava/util/HashMap;
    //   1234: iload #4
    //   1236: aaload
    //   1237: aload #6
    //   1239: aload #7
    //   1241: aload_0
    //   1242: getfield I : Ljava/nio/ByteOrder;
    //   1245: invokestatic createULong : ([JLjava/nio/ByteOrder;)Landroidx/exifinterface/media/ExifInterface$ExifAttribute;
    //   1248: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1251: pop
    //   1252: goto -> 1360
    //   1255: aload #5
    //   1257: ldc_w ','
    //   1260: iconst_m1
    //   1261: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   1264: astore_2
    //   1265: aload_2
    //   1266: arraylength
    //   1267: newarray int
    //   1269: astore #7
    //   1271: iconst_0
    //   1272: istore_3
    //   1273: iload_3
    //   1274: aload_2
    //   1275: arraylength
    //   1276: if_icmpge -> 1296
    //   1279: aload #7
    //   1281: iload_3
    //   1282: aload_2
    //   1283: iload_3
    //   1284: aaload
    //   1285: invokestatic parseInt : (Ljava/lang/String;)I
    //   1288: iastore
    //   1289: iload_3
    //   1290: iconst_1
    //   1291: iadd
    //   1292: istore_3
    //   1293: goto -> 1273
    //   1296: aload_0
    //   1297: getfield G : [Ljava/util/HashMap;
    //   1300: iload #4
    //   1302: aaload
    //   1303: aload #6
    //   1305: aload #7
    //   1307: aload_0
    //   1308: getfield I : Ljava/nio/ByteOrder;
    //   1311: invokestatic createUShort : ([ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/ExifInterface$ExifAttribute;
    //   1314: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1317: pop
    //   1318: goto -> 1360
    //   1321: aload_0
    //   1322: getfield G : [Ljava/util/HashMap;
    //   1325: iload #4
    //   1327: aaload
    //   1328: aload #6
    //   1330: aload #5
    //   1332: invokestatic createString : (Ljava/lang/String;)Landroidx/exifinterface/media/ExifInterface$ExifAttribute;
    //   1335: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1338: pop
    //   1339: goto -> 1360
    //   1342: aload_0
    //   1343: getfield G : [Ljava/util/HashMap;
    //   1346: iload #4
    //   1348: aaload
    //   1349: aload #6
    //   1351: aload #5
    //   1353: invokestatic createByte : (Ljava/lang/String;)Landroidx/exifinterface/media/ExifInterface$ExifAttribute;
    //   1356: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1359: pop
    //   1360: goto -> 1365
    //   1363: aload_2
    //   1364: astore_1
    //   1365: iload #4
    //   1367: iconst_1
    //   1368: iadd
    //   1369: istore #4
    //   1371: goto -> 289
    //   1374: return
    //   1375: astore_1
    //   1376: goto -> 236
    // Exception table:
    //   from	to	target	type
    //   217	233	1375	java/lang/NumberFormatException
  }
  
  public void setDateTime(long paramLong) {
    setAttribute("DateTime", l.format(new Date(paramLong)));
    setAttribute("SubSecTime", Long.toString(paramLong % 1000L));
  }
  
  public void setGpsInfo(Location paramLocation) {
    if (paramLocation == null)
      return; 
    setAttribute("GPSProcessingMethod", paramLocation.getProvider());
    setLatLong(paramLocation.getLatitude(), paramLocation.getLongitude());
    setAltitude(paramLocation.getAltitude());
    setAttribute("GPSSpeedRef", "K");
    setAttribute("GPSSpeed", (new Rational((paramLocation.getSpeed() * (float)TimeUnit.HOURS.toSeconds(1L) / 1000.0F))).toString());
    String[] arrayOfString = l.format(new Date(paramLocation.getTime())).split("\\s+", -1);
    setAttribute("GPSDateStamp", arrayOfString[0]);
    setAttribute("GPSTimeStamp", arrayOfString[1]);
  }
  
  public void setLatLong(double paramDouble1, double paramDouble2) {
    if (paramDouble1 >= -90.0D && paramDouble1 <= 90.0D && !Double.isNaN(paramDouble1)) {
      if (paramDouble2 >= -180.0D && paramDouble2 <= 180.0D && !Double.isNaN(paramDouble2)) {
        String str;
        if (paramDouble1 >= 0.0D) {
          str = "N";
        } else {
          str = "S";
        } 
        setAttribute("GPSLatitudeRef", str);
        setAttribute("GPSLatitude", a(Math.abs(paramDouble1)));
        if (paramDouble2 >= 0.0D) {
          str = "E";
        } else {
          str = "W";
        } 
        setAttribute("GPSLongitudeRef", str);
        setAttribute("GPSLongitude", a(Math.abs(paramDouble2)));
        return;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Longitude value ");
      stringBuilder1.append(paramDouble2);
      stringBuilder1.append(" is not valid.");
      throw new IllegalArgumentException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Latitude value ");
    stringBuilder.append(paramDouble1);
    stringBuilder.append(" is not valid.");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static class ByteOrderedDataInputStream extends InputStream implements DataInput {
    private static final ByteOrder c = ByteOrder.LITTLE_ENDIAN;
    
    private static final ByteOrder d = ByteOrder.BIG_ENDIAN;
    
    final int a;
    
    int b;
    
    private DataInputStream e;
    
    private ByteOrder f = ByteOrder.BIG_ENDIAN;
    
    public ByteOrderedDataInputStream(InputStream param1InputStream) throws IOException {
      this.e = new DataInputStream(param1InputStream);
      this.a = this.e.available();
      this.b = 0;
      this.e.mark(this.a);
    }
    
    public ByteOrderedDataInputStream(byte[] param1ArrayOfbyte) throws IOException {
      this(new ByteArrayInputStream(param1ArrayOfbyte));
    }
    
    public int available() throws IOException {
      return this.e.available();
    }
    
    public int peek() {
      return this.b;
    }
    
    public int read() throws IOException {
      this.b++;
      return this.e.read();
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      param1Int1 = this.e.read(param1ArrayOfbyte, param1Int1, param1Int2);
      this.b += param1Int1;
      return param1Int1;
    }
    
    public boolean readBoolean() throws IOException {
      this.b++;
      return this.e.readBoolean();
    }
    
    public byte readByte() throws IOException {
      this.b++;
      if (this.b <= this.a) {
        int i = this.e.read();
        if (i >= 0)
          return (byte)i; 
        throw new EOFException();
      } 
      throw new EOFException();
    }
    
    public char readChar() throws IOException {
      this.b += 2;
      return this.e.readChar();
    }
    
    public double readDouble() throws IOException {
      return Double.longBitsToDouble(readLong());
    }
    
    public float readFloat() throws IOException {
      return Float.intBitsToFloat(readInt());
    }
    
    public void readFully(byte[] param1ArrayOfbyte) throws IOException {
      this.b += param1ArrayOfbyte.length;
      if (this.b <= this.a) {
        if (this.e.read(param1ArrayOfbyte, 0, param1ArrayOfbyte.length) == param1ArrayOfbyte.length)
          return; 
        throw new IOException("Couldn't read up to the length of buffer");
      } 
      throw new EOFException();
    }
    
    public void readFully(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      this.b += param1Int2;
      if (this.b <= this.a) {
        if (this.e.read(param1ArrayOfbyte, param1Int1, param1Int2) == param1Int2)
          return; 
        throw new IOException("Couldn't read up to the length of buffer");
      } 
      throw new EOFException();
    }
    
    public int readInt() throws IOException {
      this.b += 4;
      if (this.b <= this.a) {
        int i = this.e.read();
        int j = this.e.read();
        int k = this.e.read();
        int m = this.e.read();
        if ((i | j | k | m) >= 0) {
          ByteOrder byteOrder = this.f;
          if (byteOrder == c)
            return (m << 24) + (k << 16) + (j << 8) + i; 
          if (byteOrder == d)
            return (i << 24) + (j << 16) + (k << 8) + m; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid byte order: ");
          stringBuilder.append(this.f);
          throw new IOException(stringBuilder.toString());
        } 
        throw new EOFException();
      } 
      throw new EOFException();
    }
    
    public String readLine() throws IOException {
      Log.d("ExifInterface", "Currently unsupported");
      return null;
    }
    
    public long readLong() throws IOException {
      this.b += 8;
      if (this.b <= this.a) {
        int i = this.e.read();
        int j = this.e.read();
        int k = this.e.read();
        int m = this.e.read();
        int n = this.e.read();
        int i1 = this.e.read();
        int i2 = this.e.read();
        int i3 = this.e.read();
        if ((i | j | k | m | n | i1 | i2 | i3) >= 0) {
          ByteOrder byteOrder = this.f;
          if (byteOrder == c)
            return (i3 << 56L) + (i2 << 48L) + (i1 << 40L) + (n << 32L) + (m << 24L) + (k << 16L) + (j << 8L) + i; 
          if (byteOrder == d)
            return (i << 56L) + (j << 48L) + (k << 40L) + (m << 32L) + (n << 24L) + (i1 << 16L) + (i2 << 8L) + i3; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid byte order: ");
          stringBuilder.append(this.f);
          throw new IOException(stringBuilder.toString());
        } 
        throw new EOFException();
      } 
      throw new EOFException();
    }
    
    public short readShort() throws IOException {
      this.b += 2;
      if (this.b <= this.a) {
        int i = this.e.read();
        int j = this.e.read();
        if ((i | j) >= 0) {
          ByteOrder byteOrder = this.f;
          if (byteOrder == c)
            return (short)((j << 8) + i); 
          if (byteOrder == d)
            return (short)((i << 8) + j); 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid byte order: ");
          stringBuilder.append(this.f);
          throw new IOException(stringBuilder.toString());
        } 
        throw new EOFException();
      } 
      throw new EOFException();
    }
    
    public String readUTF() throws IOException {
      this.b += 2;
      return this.e.readUTF();
    }
    
    public int readUnsignedByte() throws IOException {
      this.b++;
      return this.e.readUnsignedByte();
    }
    
    public long readUnsignedInt() throws IOException {
      return readInt() & 0xFFFFFFFFL;
    }
    
    public int readUnsignedShort() throws IOException {
      this.b += 2;
      if (this.b <= this.a) {
        int i = this.e.read();
        int j = this.e.read();
        if ((i | j) >= 0) {
          ByteOrder byteOrder = this.f;
          if (byteOrder == c)
            return (j << 8) + i; 
          if (byteOrder == d)
            return (i << 8) + j; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Invalid byte order: ");
          stringBuilder.append(this.f);
          throw new IOException(stringBuilder.toString());
        } 
        throw new EOFException();
      } 
      throw new EOFException();
    }
    
    public void seek(long param1Long) throws IOException {
      int i = this.b;
      if (i > param1Long) {
        this.b = 0;
        this.e.reset();
        this.e.mark(this.a);
      } else {
        param1Long -= i;
      } 
      i = (int)param1Long;
      if (skipBytes(i) == i)
        return; 
      throw new IOException("Couldn't seek up to the byteCount");
    }
    
    public void setByteOrder(ByteOrder param1ByteOrder) {
      this.f = param1ByteOrder;
    }
    
    public int skipBytes(int param1Int) throws IOException {
      int i = Math.min(param1Int, this.a - this.b);
      for (param1Int = 0; param1Int < i; param1Int += this.e.skipBytes(i - param1Int));
      this.b += param1Int;
      return param1Int;
    }
  }
  
  static class ByteOrderedDataOutputStream extends FilterOutputStream {
    private final OutputStream a;
    
    private ByteOrder b;
    
    public ByteOrderedDataOutputStream(OutputStream param1OutputStream, ByteOrder param1ByteOrder) {
      super(param1OutputStream);
      this.a = param1OutputStream;
      this.b = param1ByteOrder;
    }
    
    public void setByteOrder(ByteOrder param1ByteOrder) {
      this.b = param1ByteOrder;
    }
    
    public void write(byte[] param1ArrayOfbyte) throws IOException {
      this.a.write(param1ArrayOfbyte);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      this.a.write(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public void writeByte(int param1Int) throws IOException {
      this.a.write(param1Int);
    }
    
    public void writeInt(int param1Int) throws IOException {
      if (this.b == ByteOrder.LITTLE_ENDIAN) {
        this.a.write(param1Int >>> 0 & 0xFF);
        this.a.write(param1Int >>> 8 & 0xFF);
        this.a.write(param1Int >>> 16 & 0xFF);
        this.a.write(param1Int >>> 24 & 0xFF);
        return;
      } 
      if (this.b == ByteOrder.BIG_ENDIAN) {
        this.a.write(param1Int >>> 24 & 0xFF);
        this.a.write(param1Int >>> 16 & 0xFF);
        this.a.write(param1Int >>> 8 & 0xFF);
        this.a.write(param1Int >>> 0 & 0xFF);
      } 
    }
    
    public void writeShort(short param1Short) throws IOException {
      if (this.b == ByteOrder.LITTLE_ENDIAN) {
        this.a.write(param1Short >>> 0 & 0xFF);
        this.a.write(param1Short >>> 8 & 0xFF);
        return;
      } 
      if (this.b == ByteOrder.BIG_ENDIAN) {
        this.a.write(param1Short >>> 8 & 0xFF);
        this.a.write(param1Short >>> 0 & 0xFF);
      } 
    }
    
    public void writeUnsignedInt(long param1Long) throws IOException {
      writeInt((int)param1Long);
    }
    
    public void writeUnsignedShort(int param1Int) throws IOException {
      writeShort((short)param1Int);
    }
  }
  
  static class ExifAttribute {
    public final byte[] bytes;
    
    public final int format;
    
    public final int numberOfComponents;
    
    ExifAttribute(int param1Int1, int param1Int2, byte[] param1ArrayOfbyte) {
      this.format = param1Int1;
      this.numberOfComponents = param1Int2;
      this.bytes = param1ArrayOfbyte;
    }
    
    public static ExifAttribute createByte(String param1String) {
      if (param1String.length() == 1 && param1String.charAt(0) >= '0' && param1String.charAt(0) <= '1') {
        byte[] arrayOfByte1 = new byte[1];
        arrayOfByte1[0] = (byte)(param1String.charAt(0) - 48);
        return new ExifAttribute(1, arrayOfByte1.length, arrayOfByte1);
      } 
      byte[] arrayOfByte = param1String.getBytes(ExifInterface.f);
      return new ExifAttribute(1, arrayOfByte.length, arrayOfByte);
    }
    
    public static ExifAttribute createDouble(double param1Double, ByteOrder param1ByteOrder) {
      return createDouble(new double[] { param1Double }, param1ByteOrder);
    }
    
    public static ExifAttribute createDouble(double[] param1ArrayOfdouble, ByteOrder param1ByteOrder) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.c[12] * param1ArrayOfdouble.length]);
      byteBuffer.order(param1ByteOrder);
      int j = param1ArrayOfdouble.length;
      for (int i = 0; i < j; i++)
        byteBuffer.putDouble(param1ArrayOfdouble[i]); 
      return new ExifAttribute(12, param1ArrayOfdouble.length, byteBuffer.array());
    }
    
    public static ExifAttribute createSLong(int param1Int, ByteOrder param1ByteOrder) {
      return createSLong(new int[] { param1Int }, param1ByteOrder);
    }
    
    public static ExifAttribute createSLong(int[] param1ArrayOfint, ByteOrder param1ByteOrder) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.c[9] * param1ArrayOfint.length]);
      byteBuffer.order(param1ByteOrder);
      int j = param1ArrayOfint.length;
      for (int i = 0; i < j; i++)
        byteBuffer.putInt(param1ArrayOfint[i]); 
      return new ExifAttribute(9, param1ArrayOfint.length, byteBuffer.array());
    }
    
    public static ExifAttribute createSRational(ExifInterface.Rational param1Rational, ByteOrder param1ByteOrder) {
      return createSRational(new ExifInterface.Rational[] { param1Rational }, param1ByteOrder);
    }
    
    public static ExifAttribute createSRational(ExifInterface.Rational[] param1ArrayOfRational, ByteOrder param1ByteOrder) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.c[10] * param1ArrayOfRational.length]);
      byteBuffer.order(param1ByteOrder);
      int j = param1ArrayOfRational.length;
      for (int i = 0; i < j; i++) {
        ExifInterface.Rational rational = param1ArrayOfRational[i];
        byteBuffer.putInt((int)rational.numerator);
        byteBuffer.putInt((int)rational.denominator);
      } 
      return new ExifAttribute(10, param1ArrayOfRational.length, byteBuffer.array());
    }
    
    public static ExifAttribute createString(String param1String) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String);
      stringBuilder.append(false);
      byte[] arrayOfByte = stringBuilder.toString().getBytes(ExifInterface.f);
      return new ExifAttribute(2, arrayOfByte.length, arrayOfByte);
    }
    
    public static ExifAttribute createULong(long param1Long, ByteOrder param1ByteOrder) {
      return createULong(new long[] { param1Long }, param1ByteOrder);
    }
    
    public static ExifAttribute createULong(long[] param1ArrayOflong, ByteOrder param1ByteOrder) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.c[4] * param1ArrayOflong.length]);
      byteBuffer.order(param1ByteOrder);
      int j = param1ArrayOflong.length;
      for (int i = 0; i < j; i++)
        byteBuffer.putInt((int)param1ArrayOflong[i]); 
      return new ExifAttribute(4, param1ArrayOflong.length, byteBuffer.array());
    }
    
    public static ExifAttribute createURational(ExifInterface.Rational param1Rational, ByteOrder param1ByteOrder) {
      return createURational(new ExifInterface.Rational[] { param1Rational }, param1ByteOrder);
    }
    
    public static ExifAttribute createURational(ExifInterface.Rational[] param1ArrayOfRational, ByteOrder param1ByteOrder) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.c[5] * param1ArrayOfRational.length]);
      byteBuffer.order(param1ByteOrder);
      int j = param1ArrayOfRational.length;
      for (int i = 0; i < j; i++) {
        ExifInterface.Rational rational = param1ArrayOfRational[i];
        byteBuffer.putInt((int)rational.numerator);
        byteBuffer.putInt((int)rational.denominator);
      } 
      return new ExifAttribute(5, param1ArrayOfRational.length, byteBuffer.array());
    }
    
    public static ExifAttribute createUShort(int param1Int, ByteOrder param1ByteOrder) {
      return createUShort(new int[] { param1Int }, param1ByteOrder);
    }
    
    public static ExifAttribute createUShort(int[] param1ArrayOfint, ByteOrder param1ByteOrder) {
      ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[ExifInterface.c[3] * param1ArrayOfint.length]);
      byteBuffer.order(param1ByteOrder);
      int j = param1ArrayOfint.length;
      for (int i = 0; i < j; i++)
        byteBuffer.putShort((short)param1ArrayOfint[i]); 
      return new ExifAttribute(3, param1ArrayOfint.length, byteBuffer.array());
    }
    
    Object a(ByteOrder param1ByteOrder) {
      // Byte code:
      //   0: new androidx/exifinterface/media/ExifInterface$ByteOrderedDataInputStream
      //   3: dup
      //   4: aload_0
      //   5: getfield bytes : [B
      //   8: invokespecial <init> : ([B)V
      //   11: astore #14
      //   13: aload #14
      //   15: astore #13
      //   17: aload #14
      //   19: aload_1
      //   20: invokevirtual setByteOrder : (Ljava/nio/ByteOrder;)V
      //   23: aload #14
      //   25: astore #13
      //   27: aload_0
      //   28: getfield format : I
      //   31: istore #12
      //   33: iconst_1
      //   34: istore #5
      //   36: iconst_0
      //   37: istore_3
      //   38: iconst_0
      //   39: istore #6
      //   41: iconst_0
      //   42: istore #7
      //   44: iconst_0
      //   45: istore #8
      //   47: iconst_0
      //   48: istore #9
      //   50: iconst_0
      //   51: istore #10
      //   53: iconst_0
      //   54: istore #11
      //   56: iconst_0
      //   57: istore #4
      //   59: iconst_0
      //   60: istore_2
      //   61: iload #12
      //   63: tableswitch default -> 1091, 1 -> 857, 2 -> 677, 3 -> 611, 4 -> 545, 5 -> 466, 6 -> 857, 7 -> 677, 8 -> 400, 9 -> 334, 10 -> 253, 11 -> 187, 12 -> 124
      //   124: aload #14
      //   126: astore #13
      //   128: aload_0
      //   129: getfield numberOfComponents : I
      //   132: newarray double
      //   134: astore_1
      //   135: aload #14
      //   137: astore #13
      //   139: iload_2
      //   140: aload_0
      //   141: getfield numberOfComponents : I
      //   144: if_icmpge -> 166
      //   147: aload #14
      //   149: astore #13
      //   151: aload_1
      //   152: iload_2
      //   153: aload #14
      //   155: invokevirtual readDouble : ()D
      //   158: dastore
      //   159: iload_2
      //   160: iconst_1
      //   161: iadd
      //   162: istore_2
      //   163: goto -> 135
      //   166: aload #14
      //   168: invokevirtual close : ()V
      //   171: aload_1
      //   172: areturn
      //   173: astore #13
      //   175: ldc 'ExifInterface'
      //   177: ldc 'IOException occurred while closing InputStream'
      //   179: aload #13
      //   181: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   184: pop
      //   185: aload_1
      //   186: areturn
      //   187: aload #14
      //   189: astore #13
      //   191: aload_0
      //   192: getfield numberOfComponents : I
      //   195: newarray double
      //   197: astore_1
      //   198: iload_3
      //   199: istore_2
      //   200: aload #14
      //   202: astore #13
      //   204: iload_2
      //   205: aload_0
      //   206: getfield numberOfComponents : I
      //   209: if_icmpge -> 232
      //   212: aload #14
      //   214: astore #13
      //   216: aload_1
      //   217: iload_2
      //   218: aload #14
      //   220: invokevirtual readFloat : ()F
      //   223: f2d
      //   224: dastore
      //   225: iload_2
      //   226: iconst_1
      //   227: iadd
      //   228: istore_2
      //   229: goto -> 200
      //   232: aload #14
      //   234: invokevirtual close : ()V
      //   237: aload_1
      //   238: areturn
      //   239: astore #13
      //   241: ldc 'ExifInterface'
      //   243: ldc 'IOException occurred while closing InputStream'
      //   245: aload #13
      //   247: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   250: pop
      //   251: aload_1
      //   252: areturn
      //   253: aload #14
      //   255: astore #13
      //   257: aload_0
      //   258: getfield numberOfComponents : I
      //   261: anewarray androidx/exifinterface/media/ExifInterface$Rational
      //   264: astore_1
      //   265: iload #6
      //   267: istore_2
      //   268: aload #14
      //   270: astore #13
      //   272: iload_2
      //   273: aload_0
      //   274: getfield numberOfComponents : I
      //   277: if_icmpge -> 313
      //   280: aload #14
      //   282: astore #13
      //   284: aload_1
      //   285: iload_2
      //   286: new androidx/exifinterface/media/ExifInterface$Rational
      //   289: dup
      //   290: aload #14
      //   292: invokevirtual readInt : ()I
      //   295: i2l
      //   296: aload #14
      //   298: invokevirtual readInt : ()I
      //   301: i2l
      //   302: invokespecial <init> : (JJ)V
      //   305: aastore
      //   306: iload_2
      //   307: iconst_1
      //   308: iadd
      //   309: istore_2
      //   310: goto -> 268
      //   313: aload #14
      //   315: invokevirtual close : ()V
      //   318: aload_1
      //   319: areturn
      //   320: astore #13
      //   322: ldc 'ExifInterface'
      //   324: ldc 'IOException occurred while closing InputStream'
      //   326: aload #13
      //   328: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   331: pop
      //   332: aload_1
      //   333: areturn
      //   334: aload #14
      //   336: astore #13
      //   338: aload_0
      //   339: getfield numberOfComponents : I
      //   342: newarray int
      //   344: astore_1
      //   345: iload #7
      //   347: istore_2
      //   348: aload #14
      //   350: astore #13
      //   352: iload_2
      //   353: aload_0
      //   354: getfield numberOfComponents : I
      //   357: if_icmpge -> 379
      //   360: aload #14
      //   362: astore #13
      //   364: aload_1
      //   365: iload_2
      //   366: aload #14
      //   368: invokevirtual readInt : ()I
      //   371: iastore
      //   372: iload_2
      //   373: iconst_1
      //   374: iadd
      //   375: istore_2
      //   376: goto -> 348
      //   379: aload #14
      //   381: invokevirtual close : ()V
      //   384: aload_1
      //   385: areturn
      //   386: astore #13
      //   388: ldc 'ExifInterface'
      //   390: ldc 'IOException occurred while closing InputStream'
      //   392: aload #13
      //   394: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   397: pop
      //   398: aload_1
      //   399: areturn
      //   400: aload #14
      //   402: astore #13
      //   404: aload_0
      //   405: getfield numberOfComponents : I
      //   408: newarray int
      //   410: astore_1
      //   411: iload #8
      //   413: istore_2
      //   414: aload #14
      //   416: astore #13
      //   418: iload_2
      //   419: aload_0
      //   420: getfield numberOfComponents : I
      //   423: if_icmpge -> 445
      //   426: aload #14
      //   428: astore #13
      //   430: aload_1
      //   431: iload_2
      //   432: aload #14
      //   434: invokevirtual readShort : ()S
      //   437: iastore
      //   438: iload_2
      //   439: iconst_1
      //   440: iadd
      //   441: istore_2
      //   442: goto -> 414
      //   445: aload #14
      //   447: invokevirtual close : ()V
      //   450: aload_1
      //   451: areturn
      //   452: astore #13
      //   454: ldc 'ExifInterface'
      //   456: ldc 'IOException occurred while closing InputStream'
      //   458: aload #13
      //   460: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   463: pop
      //   464: aload_1
      //   465: areturn
      //   466: aload #14
      //   468: astore #13
      //   470: aload_0
      //   471: getfield numberOfComponents : I
      //   474: anewarray androidx/exifinterface/media/ExifInterface$Rational
      //   477: astore_1
      //   478: iload #9
      //   480: istore_2
      //   481: aload #14
      //   483: astore #13
      //   485: iload_2
      //   486: aload_0
      //   487: getfield numberOfComponents : I
      //   490: if_icmpge -> 524
      //   493: aload #14
      //   495: astore #13
      //   497: aload_1
      //   498: iload_2
      //   499: new androidx/exifinterface/media/ExifInterface$Rational
      //   502: dup
      //   503: aload #14
      //   505: invokevirtual readUnsignedInt : ()J
      //   508: aload #14
      //   510: invokevirtual readUnsignedInt : ()J
      //   513: invokespecial <init> : (JJ)V
      //   516: aastore
      //   517: iload_2
      //   518: iconst_1
      //   519: iadd
      //   520: istore_2
      //   521: goto -> 481
      //   524: aload #14
      //   526: invokevirtual close : ()V
      //   529: aload_1
      //   530: areturn
      //   531: astore #13
      //   533: ldc 'ExifInterface'
      //   535: ldc 'IOException occurred while closing InputStream'
      //   537: aload #13
      //   539: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   542: pop
      //   543: aload_1
      //   544: areturn
      //   545: aload #14
      //   547: astore #13
      //   549: aload_0
      //   550: getfield numberOfComponents : I
      //   553: newarray long
      //   555: astore_1
      //   556: iload #10
      //   558: istore_2
      //   559: aload #14
      //   561: astore #13
      //   563: iload_2
      //   564: aload_0
      //   565: getfield numberOfComponents : I
      //   568: if_icmpge -> 590
      //   571: aload #14
      //   573: astore #13
      //   575: aload_1
      //   576: iload_2
      //   577: aload #14
      //   579: invokevirtual readUnsignedInt : ()J
      //   582: lastore
      //   583: iload_2
      //   584: iconst_1
      //   585: iadd
      //   586: istore_2
      //   587: goto -> 559
      //   590: aload #14
      //   592: invokevirtual close : ()V
      //   595: aload_1
      //   596: areturn
      //   597: astore #13
      //   599: ldc 'ExifInterface'
      //   601: ldc 'IOException occurred while closing InputStream'
      //   603: aload #13
      //   605: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   608: pop
      //   609: aload_1
      //   610: areturn
      //   611: aload #14
      //   613: astore #13
      //   615: aload_0
      //   616: getfield numberOfComponents : I
      //   619: newarray int
      //   621: astore_1
      //   622: iload #11
      //   624: istore_2
      //   625: aload #14
      //   627: astore #13
      //   629: iload_2
      //   630: aload_0
      //   631: getfield numberOfComponents : I
      //   634: if_icmpge -> 656
      //   637: aload #14
      //   639: astore #13
      //   641: aload_1
      //   642: iload_2
      //   643: aload #14
      //   645: invokevirtual readUnsignedShort : ()I
      //   648: iastore
      //   649: iload_2
      //   650: iconst_1
      //   651: iadd
      //   652: istore_2
      //   653: goto -> 625
      //   656: aload #14
      //   658: invokevirtual close : ()V
      //   661: aload_1
      //   662: areturn
      //   663: astore #13
      //   665: ldc 'ExifInterface'
      //   667: ldc 'IOException occurred while closing InputStream'
      //   669: aload #13
      //   671: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   674: pop
      //   675: aload_1
      //   676: areturn
      //   677: iload #4
      //   679: istore_2
      //   680: aload #14
      //   682: astore #13
      //   684: aload_0
      //   685: getfield numberOfComponents : I
      //   688: getstatic androidx/exifinterface/media/ExifInterface.d : [B
      //   691: arraylength
      //   692: if_icmplt -> 751
      //   695: iconst_0
      //   696: istore_2
      //   697: iload #5
      //   699: istore_3
      //   700: aload #14
      //   702: astore #13
      //   704: iload_2
      //   705: getstatic androidx/exifinterface/media/ExifInterface.d : [B
      //   708: arraylength
      //   709: if_icmpge -> 735
      //   712: aload #14
      //   714: astore #13
      //   716: aload_0
      //   717: getfield bytes : [B
      //   720: iload_2
      //   721: baload
      //   722: getstatic androidx/exifinterface/media/ExifInterface.d : [B
      //   725: iload_2
      //   726: baload
      //   727: if_icmpeq -> 1094
      //   730: iconst_0
      //   731: istore_3
      //   732: goto -> 735
      //   735: iload #4
      //   737: istore_2
      //   738: iload_3
      //   739: ifeq -> 751
      //   742: aload #14
      //   744: astore #13
      //   746: getstatic androidx/exifinterface/media/ExifInterface.d : [B
      //   749: arraylength
      //   750: istore_2
      //   751: aload #14
      //   753: astore #13
      //   755: new java/lang/StringBuilder
      //   758: dup
      //   759: invokespecial <init> : ()V
      //   762: astore_1
      //   763: aload #14
      //   765: astore #13
      //   767: iload_2
      //   768: aload_0
      //   769: getfield numberOfComponents : I
      //   772: if_icmpge -> 827
      //   775: aload #14
      //   777: astore #13
      //   779: aload_0
      //   780: getfield bytes : [B
      //   783: iload_2
      //   784: baload
      //   785: istore_3
      //   786: iload_3
      //   787: ifne -> 793
      //   790: goto -> 827
      //   793: iload_3
      //   794: bipush #32
      //   796: if_icmplt -> 813
      //   799: aload #14
      //   801: astore #13
      //   803: aload_1
      //   804: iload_3
      //   805: i2c
      //   806: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   809: pop
      //   810: goto -> 1101
      //   813: aload #14
      //   815: astore #13
      //   817: aload_1
      //   818: bipush #63
      //   820: invokevirtual append : (C)Ljava/lang/StringBuilder;
      //   823: pop
      //   824: goto -> 1101
      //   827: aload #14
      //   829: astore #13
      //   831: aload_1
      //   832: invokevirtual toString : ()Ljava/lang/String;
      //   835: astore_1
      //   836: aload #14
      //   838: invokevirtual close : ()V
      //   841: aload_1
      //   842: areturn
      //   843: astore #13
      //   845: ldc 'ExifInterface'
      //   847: ldc 'IOException occurred while closing InputStream'
      //   849: aload #13
      //   851: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   854: pop
      //   855: aload_1
      //   856: areturn
      //   857: aload #14
      //   859: astore #13
      //   861: aload_0
      //   862: getfield bytes : [B
      //   865: arraylength
      //   866: iconst_1
      //   867: if_icmpne -> 946
      //   870: aload #14
      //   872: astore #13
      //   874: aload_0
      //   875: getfield bytes : [B
      //   878: iconst_0
      //   879: baload
      //   880: iflt -> 946
      //   883: aload #14
      //   885: astore #13
      //   887: aload_0
      //   888: getfield bytes : [B
      //   891: iconst_0
      //   892: baload
      //   893: iconst_1
      //   894: if_icmpgt -> 946
      //   897: aload #14
      //   899: astore #13
      //   901: new java/lang/String
      //   904: dup
      //   905: iconst_1
      //   906: newarray char
      //   908: dup
      //   909: iconst_0
      //   910: aload_0
      //   911: getfield bytes : [B
      //   914: iconst_0
      //   915: baload
      //   916: bipush #48
      //   918: iadd
      //   919: i2c
      //   920: castore
      //   921: invokespecial <init> : ([C)V
      //   924: astore_1
      //   925: aload #14
      //   927: invokevirtual close : ()V
      //   930: aload_1
      //   931: areturn
      //   932: astore #13
      //   934: ldc 'ExifInterface'
      //   936: ldc 'IOException occurred while closing InputStream'
      //   938: aload #13
      //   940: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   943: pop
      //   944: aload_1
      //   945: areturn
      //   946: aload #14
      //   948: astore #13
      //   950: new java/lang/String
      //   953: dup
      //   954: aload_0
      //   955: getfield bytes : [B
      //   958: getstatic androidx/exifinterface/media/ExifInterface.f : Ljava/nio/charset/Charset;
      //   961: invokespecial <init> : ([BLjava/nio/charset/Charset;)V
      //   964: astore_1
      //   965: aload #14
      //   967: invokevirtual close : ()V
      //   970: aload_1
      //   971: areturn
      //   972: astore #13
      //   974: ldc 'ExifInterface'
      //   976: ldc 'IOException occurred while closing InputStream'
      //   978: aload #13
      //   980: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   983: pop
      //   984: aload_1
      //   985: areturn
      //   986: aload #14
      //   988: invokevirtual close : ()V
      //   991: aconst_null
      //   992: areturn
      //   993: astore_1
      //   994: ldc 'ExifInterface'
      //   996: ldc 'IOException occurred while closing InputStream'
      //   998: aload_1
      //   999: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   1002: pop
      //   1003: aconst_null
      //   1004: areturn
      //   1005: astore #13
      //   1007: aload #14
      //   1009: astore_1
      //   1010: aload #13
      //   1012: astore #14
      //   1014: goto -> 1028
      //   1017: astore_1
      //   1018: aconst_null
      //   1019: astore #13
      //   1021: goto -> 1064
      //   1024: astore #14
      //   1026: aconst_null
      //   1027: astore_1
      //   1028: aload_1
      //   1029: astore #13
      //   1031: ldc 'ExifInterface'
      //   1033: ldc 'IOException occurred during reading a value'
      //   1035: aload #14
      //   1037: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   1040: pop
      //   1041: aload_1
      //   1042: ifnull -> 1061
      //   1045: aload_1
      //   1046: invokevirtual close : ()V
      //   1049: aconst_null
      //   1050: areturn
      //   1051: astore_1
      //   1052: ldc 'ExifInterface'
      //   1054: ldc 'IOException occurred while closing InputStream'
      //   1056: aload_1
      //   1057: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   1060: pop
      //   1061: aconst_null
      //   1062: areturn
      //   1063: astore_1
      //   1064: aload #13
      //   1066: ifnull -> 1089
      //   1069: aload #13
      //   1071: invokevirtual close : ()V
      //   1074: goto -> 1089
      //   1077: astore #13
      //   1079: ldc 'ExifInterface'
      //   1081: ldc 'IOException occurred while closing InputStream'
      //   1083: aload #13
      //   1085: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   1088: pop
      //   1089: aload_1
      //   1090: athrow
      //   1091: goto -> 986
      //   1094: iload_2
      //   1095: iconst_1
      //   1096: iadd
      //   1097: istore_2
      //   1098: goto -> 697
      //   1101: iload_2
      //   1102: iconst_1
      //   1103: iadd
      //   1104: istore_2
      //   1105: goto -> 763
      // Exception table:
      //   from	to	target	type
      //   0	13	1024	java/io/IOException
      //   0	13	1017	finally
      //   17	23	1005	java/io/IOException
      //   17	23	1063	finally
      //   27	33	1005	java/io/IOException
      //   27	33	1063	finally
      //   128	135	1005	java/io/IOException
      //   128	135	1063	finally
      //   139	147	1005	java/io/IOException
      //   139	147	1063	finally
      //   151	159	1005	java/io/IOException
      //   151	159	1063	finally
      //   166	171	173	java/io/IOException
      //   191	198	1005	java/io/IOException
      //   191	198	1063	finally
      //   204	212	1005	java/io/IOException
      //   204	212	1063	finally
      //   216	225	1005	java/io/IOException
      //   216	225	1063	finally
      //   232	237	239	java/io/IOException
      //   257	265	1005	java/io/IOException
      //   257	265	1063	finally
      //   272	280	1005	java/io/IOException
      //   272	280	1063	finally
      //   284	306	1005	java/io/IOException
      //   284	306	1063	finally
      //   313	318	320	java/io/IOException
      //   338	345	1005	java/io/IOException
      //   338	345	1063	finally
      //   352	360	1005	java/io/IOException
      //   352	360	1063	finally
      //   364	372	1005	java/io/IOException
      //   364	372	1063	finally
      //   379	384	386	java/io/IOException
      //   404	411	1005	java/io/IOException
      //   404	411	1063	finally
      //   418	426	1005	java/io/IOException
      //   418	426	1063	finally
      //   430	438	1005	java/io/IOException
      //   430	438	1063	finally
      //   445	450	452	java/io/IOException
      //   470	478	1005	java/io/IOException
      //   470	478	1063	finally
      //   485	493	1005	java/io/IOException
      //   485	493	1063	finally
      //   497	517	1005	java/io/IOException
      //   497	517	1063	finally
      //   524	529	531	java/io/IOException
      //   549	556	1005	java/io/IOException
      //   549	556	1063	finally
      //   563	571	1005	java/io/IOException
      //   563	571	1063	finally
      //   575	583	1005	java/io/IOException
      //   575	583	1063	finally
      //   590	595	597	java/io/IOException
      //   615	622	1005	java/io/IOException
      //   615	622	1063	finally
      //   629	637	1005	java/io/IOException
      //   629	637	1063	finally
      //   641	649	1005	java/io/IOException
      //   641	649	1063	finally
      //   656	661	663	java/io/IOException
      //   684	695	1005	java/io/IOException
      //   684	695	1063	finally
      //   704	712	1005	java/io/IOException
      //   704	712	1063	finally
      //   716	730	1005	java/io/IOException
      //   716	730	1063	finally
      //   746	751	1005	java/io/IOException
      //   746	751	1063	finally
      //   755	763	1005	java/io/IOException
      //   755	763	1063	finally
      //   767	775	1005	java/io/IOException
      //   767	775	1063	finally
      //   779	786	1005	java/io/IOException
      //   779	786	1063	finally
      //   803	810	1005	java/io/IOException
      //   803	810	1063	finally
      //   817	824	1005	java/io/IOException
      //   817	824	1063	finally
      //   831	836	1005	java/io/IOException
      //   831	836	1063	finally
      //   836	841	843	java/io/IOException
      //   861	870	1005	java/io/IOException
      //   861	870	1063	finally
      //   874	883	1005	java/io/IOException
      //   874	883	1063	finally
      //   887	897	1005	java/io/IOException
      //   887	897	1063	finally
      //   901	925	1005	java/io/IOException
      //   901	925	1063	finally
      //   925	930	932	java/io/IOException
      //   950	965	1005	java/io/IOException
      //   950	965	1063	finally
      //   965	970	972	java/io/IOException
      //   986	991	993	java/io/IOException
      //   1031	1041	1063	finally
      //   1045	1049	1051	java/io/IOException
      //   1069	1074	1077	java/io/IOException
    }
    
    public double getDoubleValue(ByteOrder param1ByteOrder) {
      Object object = a(param1ByteOrder);
      if (object != null) {
        if (object instanceof String)
          return Double.parseDouble((String)object); 
        if (object instanceof long[]) {
          object = object;
          if (object.length == 1)
            return object[0]; 
          throw new NumberFormatException("There are more than one component");
        } 
        if (object instanceof int[]) {
          object = object;
          if (object.length == 1)
            return object[0]; 
          throw new NumberFormatException("There are more than one component");
        } 
        if (object instanceof double[]) {
          object = object;
          if (object.length == 1)
            return object[0]; 
          throw new NumberFormatException("There are more than one component");
        } 
        if (object instanceof ExifInterface.Rational[]) {
          object = object;
          if (object.length == 1)
            return object[0].calculate(); 
          throw new NumberFormatException("There are more than one component");
        } 
        throw new NumberFormatException("Couldn't find a double value");
      } 
      throw new NumberFormatException("NULL can't be converted to a double value");
    }
    
    public int getIntValue(ByteOrder param1ByteOrder) {
      Object object = a(param1ByteOrder);
      if (object != null) {
        if (object instanceof String)
          return Integer.parseInt((String)object); 
        if (object instanceof long[]) {
          object = object;
          if (object.length == 1)
            return (int)object[0]; 
          throw new NumberFormatException("There are more than one component");
        } 
        if (object instanceof int[]) {
          object = object;
          if (object.length == 1)
            return object[0]; 
          throw new NumberFormatException("There are more than one component");
        } 
        throw new NumberFormatException("Couldn't find a integer value");
      } 
      throw new NumberFormatException("NULL can't be converted to a integer value");
    }
    
    public String getStringValue(ByteOrder param1ByteOrder) {
      Object object = a(param1ByteOrder);
      if (object == null)
        return null; 
      if (object instanceof String)
        return (String)object; 
      StringBuilder stringBuilder = new StringBuilder();
      boolean bool = object instanceof long[];
      int j = 0;
      boolean bool1 = false;
      boolean bool2 = false;
      int i = 0;
      if (bool) {
        object = object;
        while (i < object.length) {
          stringBuilder.append(object[i]);
          j = i + 1;
          i = j;
          if (j != object.length) {
            stringBuilder.append(",");
            i = j;
          } 
        } 
        return stringBuilder.toString();
      } 
      if (object instanceof int[]) {
        object = object;
        i = j;
        while (i < object.length) {
          stringBuilder.append(object[i]);
          j = i + 1;
          i = j;
          if (j != object.length) {
            stringBuilder.append(",");
            i = j;
          } 
        } 
        return stringBuilder.toString();
      } 
      if (object instanceof double[]) {
        object = object;
        i = bool1;
        while (i < object.length) {
          stringBuilder.append(object[i]);
          j = i + 1;
          i = j;
          if (j != object.length) {
            stringBuilder.append(",");
            i = j;
          } 
        } 
        return stringBuilder.toString();
      } 
      if (object instanceof ExifInterface.Rational[]) {
        object = object;
        i = bool2;
        while (i < object.length) {
          stringBuilder.append(((ExifInterface.Rational)object[i]).numerator);
          stringBuilder.append('/');
          stringBuilder.append(((ExifInterface.Rational)object[i]).denominator);
          j = i + 1;
          i = j;
          if (j != object.length) {
            stringBuilder.append(",");
            i = j;
          } 
        } 
        return stringBuilder.toString();
      } 
      return null;
    }
    
    public int size() {
      return ExifInterface.c[this.format] * this.numberOfComponents;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(ExifInterface.b[this.format]);
      stringBuilder.append(", data length:");
      stringBuilder.append(this.bytes.length);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class ExifTag {
    public final String name;
    
    public final int number;
    
    public final int primaryFormat;
    
    public final int secondaryFormat;
    
    ExifTag(String param1String, int param1Int1, int param1Int2) {
      this.name = param1String;
      this.number = param1Int1;
      this.primaryFormat = param1Int2;
      this.secondaryFormat = -1;
    }
    
    ExifTag(String param1String, int param1Int1, int param1Int2, int param1Int3) {
      this.name = param1String;
      this.number = param1Int1;
      this.primaryFormat = param1Int2;
      this.secondaryFormat = param1Int3;
    }
    
    boolean a(int param1Int) {
      int i = this.primaryFormat;
      if (i != 7) {
        if (param1Int == 7)
          return true; 
        if (i != param1Int) {
          int j = this.secondaryFormat;
          return (j == param1Int) ? true : (((i == 4 || j == 4) && param1Int == 3) ? true : (((this.primaryFormat == 9 || this.secondaryFormat == 9) && param1Int == 8) ? true : (((this.primaryFormat == 12 || this.secondaryFormat == 12) && param1Int == 11))));
        } 
      } 
      return true;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface IfdType {}
  
  static class Rational {
    public final long denominator;
    
    public final long numerator;
    
    Rational(double param1Double) {
      this((long)(param1Double * 10000.0D), 10000L);
    }
    
    Rational(long param1Long1, long param1Long2) {
      if (param1Long2 == 0L) {
        this.numerator = 0L;
        this.denominator = 1L;
        return;
      } 
      this.numerator = param1Long1;
      this.denominator = param1Long2;
    }
    
    public double calculate() {
      return this.numerator / this.denominator;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.numerator);
      stringBuilder.append("/");
      stringBuilder.append(this.denominator);
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\exifinterface\media\ExifInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */