package top.mdoufei.asm.util;

/**
 * Relevant to format transform utils
 *
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
        StringBuilder output = new StringBuilder();
        for (String para : paraArr) {
            para = para.trim();
            para = para.replace("/", ".");
            boolean meetArr = false;
            for (int i = 0; i < para.length(); i++) {
                boolean breakLoop = false;
                char type = para.charAt(i);
                switch (type) {
                    case TypeConstants.TYPE_REFERENCE:
                        output.append(para.substring(i + 1));
                        breakLoop = true;
                        break;
                    case TypeConstants.TYPE_ARR:
                        meetArr = true;
                        continue;
                    case TypeConstants.TYPE_BOOL:
                        output.append(TypeConstants.BOOL);
                        break;
                    case TypeConstants.TYPE_BYTE:
                        output.append(TypeConstants.BYTE);
                        break;
                    case TypeConstants.TYPE_CHAR:
                        output.append(TypeConstants.CHAR);
                        break;
                    case TypeConstants.TYPE_DOUBLE:
                        output.append(TypeConstants.DOUBLE);
                        break;
                    case TypeConstants.TYPE_FLOAT:
                        output.append(TypeConstants.FLOAT);
                        break;
                    case TypeConstants.TYPE_INT:
                        output.append(TypeConstants.INT);
                        break;
                    case TypeConstants.TYPE_LONG:
                        output.append(TypeConstants.LONG);
                        break;
                    case TypeConstants.TYPE_SHORT:
                        output.append(TypeConstants.SHORT);
                        break;
                    default:
                        System.out.println("Error type with " + type);
                        break;
                }

                if (meetArr) {
                    output.append("[]");
                    meetArr = false;
                }

                output.append(",");

                if (breakLoop) {
                    break;
                }
            }
        }

        String str = output.toString();
        return str.substring(0, str.length() - 1);
    }
}
