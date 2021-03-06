package mysql_integration_tests.main;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import org.hyperledger.indy.sdk.LibIndy;

public abstract class MySQLPluggableStorage {

    private String type = "mysql";
    public static API api = null;
    public static String LIBRARY_NAME = "mysqlstorage";


    /**
     * JNA method signatures for calling SDK function.
     */
    public interface API extends Library {
        public int mysql_storage_init ();
    }

    static {

        // init libindy
        LibIndy.init("./lib");

        NativeLibrary.addSearchPath(LIBRARY_NAME, "./lib");
        api = Native.loadLibrary(LIBRARY_NAME, API.class);


    }

    /**
     * Indicates whether or not the API has been initialized.
     *
     * @return true if the API is initialize, otherwise false.
     */
    public static boolean isInitialized() {

        return api != null;
    }
}
