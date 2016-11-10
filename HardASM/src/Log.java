import com.sun.istack.internal.Nullable;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * <h3></h3>
 * Created by root on 2016/11/9.
 */
public class Log {

    private static Logger INSTANCE = getLogger();

    private Log(){

    }

    public static void d(String tag, String message){
        INSTANCE.debug(tag + ": " + message);
    }

    public static void i(String tag, String message){
        INSTANCE.info(tag + ": " + message);
    }

    public static void w(String tag, String message){
        INSTANCE.warn(tag + ": " + message);
    }

    public static void e(String tag, String message){
        INSTANCE.error(tag + ": " + message);
    }

    public static void f(String tag, String message){
        INSTANCE.fatal(tag + ": " + message);
    }

    private static Logger getLogger(){
        PropertyConfigurator.configure("D:\\me\\8892\\Hard\\HardScript\\HardASM\\out\\production\\HardASM\\log4j.properties");//加载.properties文件
        return Logger.getLogger(Log.class);
    }
}