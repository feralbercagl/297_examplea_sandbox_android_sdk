package com.anypresence;

//
//  APSetup.java
//  
//
//  Generated by AnyPresence, Inc on 2014-12-19
//  Copyright (c) 2014. All rights reserved.
//

import com.anypresence.rails_droid.RemoteRailsConfig;
import com.anypresence.sdk.acl.*;
import com.anypresence.sdk.config.*;
import com.anypresence.sdk.cache.*;
import com.anypresence.sdk.examplea.models.*;

import com.anypresence.sdk.cache.greendao.*;
import com.anypresence.anypresence_inc.examplea.dao.DaoMaster;
import com.anypresence.anypresence_inc.examplea.dao.DaoSession;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

/**
 * This class represents a base class for setting up the SDK.
 *
 * The static {@link #setup()} method must be called before the SDK can be used.
 *
 */
public final class APSetup {

	/**
	 * Setups the SDK by setting the application URL that was specified from the Designer.
	 */
	public static void setup(Context context) {
		setupOrm(context);

		com.anypresence.sdk.APSDKSetup
				.setup(context,
						"https://obscure-harbor-6682.herokuapp.com/api/v3",
						"https://obscure-harbor-6682.herokuapp.com/auth/password/callback",
						"https://obscure-harbor-6682.herokuapp.com/auth/signout",
						null, null, null);

	}

	/**
	 * Setups the SDK by setting the application URL that was specified from the Designer.
	 */
	@Deprecated
	public static void setup() {

		com.anypresence.sdk.APSDKSetup
				.setup("https://obscure-harbor-6682.herokuapp.com/api/v3",
						"https://obscure-harbor-6682.herokuapp.com/auth/password/callback",
						"https://obscure-harbor-6682.herokuapp.com/auth/signout",
						null, null, null);

	}

	/**
	 * Changes the base url. 
	 * 
	 * Please note that calling #setup after this method will just set the application URL to the default values specified from the Designer. Therefore, you should call this method after #setup.
	 */
	public static void setBaseUrl(String baseUrl) {
		Config.getInstance().setBaseUrl(baseUrl);
	}

	/**
	 * Turns on debug logging
	 */
	public static void enableDebugMode() {
		com.anypresence.sdk.APSDKSetup.DEBUG_MODE = true;
	}

	/**
	 * Turns off debug logging
	 */
	public static void disableDebugMode() {
		com.anypresence.sdk.APSDKSetup.DEBUG_MODE = false;
	}

	/**
	 * Shuts down the <tt>Executor</tt> service that runs the <tt>Futures</tt>.
	 *
	 * @see java.util.concurrent.ExecutorService
	 */
	public static void shutdownServices() {
		RemoteRailsConfig.getInstance().shutdownServices();
	}

	/**
	 * Sets the database store type. The default database store is sqlite.
	 *
	 * @see {@link APSDKSetup.DBStoreType}
	 * @param type the database store type
	 */
	public static void setDBStoreType(DBStoreType type) {
		com.anypresence.sdk.APSDKSetup.setDBStoreType(type);
	}

	/**
	 * Gets the database store type.
	 */
	public static DBStoreType getDBStoreType() {
		return com.anypresence.sdk.APSDKSetup.getDBStoreType();
	}

	/**
	 * Sets up the ORM.
	 *
	 * <p>
	 * Example:
	 * </p>
	 * <pre>
	 * <code>
	 * public class MyApplication extends Application {
	 *     {@literal @}Override
	 *     public void onCreate() {
	 *         APSetup.setup();
	 *         APSetup.setupOrm(this);
	 *     }
	 * }
	 * </code>
	 * </pre>
	 */
	public static void setupOrm(Context context) {
		CacheManager cacheManager = CacheManager.getInstance();
		cacheManager.setDatabaseName("examplea_db");
		cacheManager.setAndroidContext(context);
		com.anypresence.sdk.APSDKSetup.setCacheManager(cacheManager);
		com.anypresence.sdk.APObject.setCacheManager(cacheManager);
		com.anypresence.sdk.APSDKSetup.setupOrm(context);
	}

	/**
	 * Disables ORM.
	 */
	public static void disableOrm() {
		com.anypresence.sdk.APSDKSetup.disableOrm();
	}

}
