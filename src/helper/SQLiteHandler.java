//package helper;
//
//import java.util.HashMap;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
// 
//public class SQLiteHandler extends SQLiteOpenHelper {
// 
//    private static final String TAG = SQLiteHandler.class.getSimpleName();
// 
//    // All Static variables
//    // Database Version
//    private static final int DATABASE_VERSION = 1;
// 
//    // Database Name
//    private static final String DATABASE_NAME = "spots";
// 
//    // Login table name
//    private static final String TABLE_DRIVER = "Driver";
// 
//    // Login Table Columns names
//    private static final String KEY_ID = "userId";
//    private static final String KEY_UNAME = "username";
//    private static final String KEY_FIRSTNAME = "fName";
//    private static final String KEY_LASTNAME = "lName";
//    private static final String KEY_EMAIL = "email";
//    private static final String KEY_PASSWORD = "password";
//    private static final String KEY_STREET = "street";
//    private static final String KEY_CITY = "city";
//    private static final String KEY_STATE = "state";
//    private static final String KEY_ZIP = "zip";
//    private static final String KEY_PHONE = "phone";
// 
//    public SQLiteHandler(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
// 
//    // Creating Tables
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String CREATE_DRIVER_TABLE = "CREATE TABLE " + TABLE_DRIVER + "("
//                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_UNAME + " TEXT,"
//                + KEY_FIRSTNAME + " TEXT," + KEY_LASTNAME + " TEXT," +
//                KEY_EMAIL + " TEXT UNIQUE," + KEY_PASSWORD + " TEXT,"
//                + KEY_STREET + " TEXT," + KEY_CITY + " TEXT," + KEY_STATE + " TEXT,"
//                + KEY_ZIP + " TEXT,"+ KEY_PHONE + " TEXT" + ")";
//        db.execSQL(CREATE_DRIVER_TABLE);
// 
//        Log.d(TAG, "Database tables created");
//    }
// 
//    // Upgrading database
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // Drop older table if existed
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DRIVER);
// 
//        // Create tables again
//        onCreate(db);
//    }
// 
//    /**
//     * Storing user details in database
//     * */
//    public void addUser(String uname, String fname, String lname, String email, String uid, String created_at) {
//        SQLiteDatabase db = this.getWritableDatabase();
// 
//        ContentValues values = new ContentValues();
//        values.put(KEY_UNAME, name); // Name
//        values.put(KEY_EMAIL, email); // Email
//        values.put(KEY_EMAIL, uid); // Email
// 
//        // Inserting Row
//        long id = db.insert(TABLE_DRIVER, null, values);
//        db.close(); // Closing database connection
// 
//        Log.d(TAG, "New user inserted into sqlite: " + id);
//    }
// 
//    /**
//     * Getting user data from database
//     * */
//    public HashMap<String, String> getUserDetails() {
//        HashMap<String, String> user = new HashMap<String, String>();
//        String selectQuery = "SELECT  * FROM " + TABLE_DRIVER;
// 
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        // Move to first row
//        cursor.moveToFirst();
//        if (cursor.getCount() > 0) {
//            user.put("name", cursor.getString(1));
//            user.put("email", cursor.getString(2));
//            user.put("uid", cursor.getString(3));
//            user.put("created_at", cursor.getString(4));
//        }
//        cursor.close();
//        db.close();
//        // return user
//        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());
// 
//        return user;
//    }
// 
//    /**
//     * Getting user login status return true if rows are there in table
//     * */
//    public int getRowCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_DRIVER;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        int rowCount = cursor.getCount();
//        db.close();
//        cursor.close();
// 
//        // return row count
//        return rowCount;
//    }
// 
//    /**
//     * Re crate database Delete all tables and create them again
//     * */
//    public void deleteUsers() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        // Delete All Rows
//        db.delete(TABLE_DRIVER, null, null);
//        db.close();
// 
//        Log.d(TAG, "Deleted all user info from sqlite");
//    }
// 
//}