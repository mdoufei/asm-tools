package top.mdoufei.asm.util;

/**
 * @author leon
 * @date 2019-10-10
 */
public class TransformUtils {

    /**
     * bytecode type to src type
     * eg.
     * Ljava/lang/String;[Landroid/graphics/PointF;   ->   java.lang.String,android.graphics.PointF[]
     * IIII -> int,int,int,int
     * [II -> int[],int
     * [Lcom.google.zxing.ResultPoint; -> com.google.zxing.ResultPoint[]
     * Landroid.graphics.Bitmap;I -> android.graphics.Bitmap,int
     * Landroid.content.Context;Ljava.lang.String;ZZZ -> android.content.Context,java.lang.String,boolean,boolean,boolean
     * Landroid.content.Context;Ljava.lang.String; -> android.content.Context,java.lang.String
     * IILandroid.content.Intent; -> int,int,android.content.Intent
     *
     * @param bc bytecode type
     * @return src type
     */
    public static String bc2Src(String bc) {
        if (bc == null || bc.length() == 0) {
            return null;
        }

        String[] paraArr = bc.split(";");
        if (paraArr.length >= 1) {
            StringBuffer sb = new StringBuffer();
            for (String para : paraArr) {
                para = para.replace("/", ".");
                boolean meetArrFlag = false;
                for (int i = 0; i < para.length(); i++) {
                    char type = para.charAt(i);
                    boolean breakLoop = false;
                    switch (type) {
                        case TypeConstants.TYPE_REFERENCE:
                            sb.append(para.substring(i + 1));
                            breakLoop = true;
                            break;
                        case TypeConstants.TYPE_ARR:
                            meetArrFlag = true;
                            continue;
                        case TypeConstants.TYPE_BOOL:
                            sb.append(TypeConstants.BOOL);
                            break;
                        case TypeConstants.TYPE_BYTE:
                            sb.append(TypeConstants.BYTE);
                            break;
                        case TypeConstants.TYPE_CHAR:
                            sb.append(TypeConstants.CHAR);
                            break;
                        case TypeConstants.TYPE_DOUBLE:
                            sb.append(TypeConstants.DOUBLE);
                            break;
                        case TypeConstants.TYPE_FLOAT:
                            sb.append(TypeConstants.FLOAT);
                            break;
                        case TypeConstants.TYPE_INT:
                            sb.append(TypeConstants.INT);
                            break;
                        case TypeConstants.TYPE_LONG:
                            sb.append(TypeConstants.LONG);
                            break;
                        case TypeConstants.TYPE_SHORT:
                            sb.append(TypeConstants.SHORT);
                            break;
                        default:
                            System.out.println("Error type with " + type);
                            break;
                    }

                    if (meetArrFlag) {
                        sb.append("[]");
                        meetArrFlag = false;
                    }

                    sb.append(",");

                    if (breakLoop) {
                        break;
                    }
                }
            }

            String paramStr = sb.toString();
            return paramStr.substring(0, paramStr.length() - 1);
        }
        return null;
    }
}
