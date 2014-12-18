package com.anypresence.sdk.cache.greendao;

//
//  GreenDAOUtility.java
//  
//
//  Generated by AnyPresence, Inc on 2014-12-18
//  Copyright (c) 2014. All rights reserved.
//

import de.greenrobot.dao.query.*;
import de.greenrobot.dao.*;
import com.anypresence.sdk.acl.*;
import com.anypresence.sdk.callbacks.*;
import com.anypresence.sdk.query.*;
import com.anypresence.sdk.APSDKSetup;
import java.lang.reflect.*;
import com.anypresence.sdk.cache.*;
import com.anypresence.sdk.cache.internal.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.anypresence.sdk.cache.internal.*;
import com.anypresence.sdk.cache.internal.APObjectsAPCachedRequests;
import com.anypresence.anypresence_inc.examplea.dao.DaoMaster;
import com.anypresence.anypresence_inc.examplea.dao.DaoSession;
import android.database.sqlite.SQLiteDatabase;
import com.anypresence.sdk.examplea.models.*;
import com.anypresence.rails_droid.*;
import com.anypresence.sdk.config.Config;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.*;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import android.util.Base64;

import static com.anypresence.sdk.APSDKSetup.DEBUG_MODE;

import java.util.*;

class GreenDAOUtility {
	private static Log log = LogFactory.getLog(GreenDAOUtility.class);

	private static WhereCondition getConditional(Property whereCondition,
			String val) {
		WhereCondition eq = null;
		if (whereCondition.type == Integer.class) {
			eq = whereCondition.eq(Integer.parseInt(val));
		} else if (whereCondition.type == Boolean.class) {
			eq = whereCondition.eq(Boolean.parseBoolean(val));
		} else if (whereCondition.type == Long.class) {
			eq = whereCondition.eq(Long.parseLong(val));
		} else if (whereCondition.type == String.class) {
			eq = whereCondition.eq(val);
		} else if (whereCondition.type == Date.class) {
			eq = whereCondition.eq(Long.parseLong(val));
		} else {
			log.info("The type " + whereCondition.type.toString()
					+ " is not supported as a conditional at this time.");
		}
		return eq;
	}

	public static String parsedValue(Class<?> fieldType, String val) {
		String retValue = null;
		if (fieldType == Integer.class) {
			retValue = Integer.toString(Integer.parseInt(val));
		} else if (fieldType == Boolean.class) {
			retValue = (Boolean.parseBoolean(val)) ? "1" : "0";
		} else if (fieldType == Long.class) {
			retValue = Long.toString(Long.parseLong(val));
		} else if (fieldType == String.class) {
			retValue = "'" + val + "'";
		} else if (fieldType == Date.class) {
			try {
				retValue = Long.toString(Long.parseLong(val));
			} catch (NumberFormatException e) {
				try {
					Date parsedDate = CacheManager.DATE_FORMAT.parse(val);
					retValue = Long.toString(parsedDate.getTime());
				} catch (ParseException e1) {
					throw new NumberFormatException(
							"Unable to parse the date. The format is: EEE MMM dd HH:mm:ss zzz yyyy");
				}
			}
		} else {
			log.info("The type " + fieldType.toString()
					+ " is not supported as a conditional at this time.");
		}
		return retValue;
	}

	public static WhereCondition processParams(Field field, String value)
			throws IllegalAccessException {
		Property whereCondition = (Property) field.get(null);
		return getConditional(whereCondition, value);
	}

	public static Boolean processAPCachedRequestParams(
			List<WhereCondition> list, Map<String, String> params) {
		for (Map.Entry<String, String> entry : params.entrySet()) {
			if (entry.getValue() == null) {
				continue;
			}
			try {
				// The properties needs to be in camel-case form
				Field field = com.anypresence.anypresence_inc.examplea.dao.APCachedRequestDao.Properties.class
						.getField(Inflector.camelize(entry.getKey(), true));
				WhereCondition eq = GreenDAOUtility.processParams(field,
						entry.getValue());
				if (eq == null)
					continue;
				list.add(eq);
			} catch (SecurityException e) {
				e.printStackTrace();
				return true;
			} catch (NoSuchFieldException e) {
				log.error("The field " + entry.getKey()
						+ " does not map to any property on the model.", e);
				return true;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return true;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return true;
			}
		}
		return false;
	}

	public static HashMap<String, Object> deserializeToHashMap(String base64) {
		return deserialize(base64, new TypeToken<HashMap<String, Object>>() {
		}.getType());
	}

	public static ArrayList<Object> deserializeToArrayList(String base64) {
		return deserialize(base64, new TypeToken<ArrayList<Object>>() {
		}.getType());
	}

	public static String base64decode(String base64) {
		String decoded = "";
		if (base64 != null) {
			try {
				decoded = new String(Base64.decode(base64, Base64.DEFAULT),
						"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return decoded;
	}

	public static <T> T deserialize(String base64, Type type) {
		Gson gson = RemoteRailsConfig.getInstance().getGsonDeserializer();

		try {
			return gson.fromJson(base64decode(base64), type);
		} catch (JsonSyntaxException e0) {
			e0.printStackTrace();
		}

		return null;
	}

	public static String serialize(Object object) {
		String base64 = "";
		Gson gson = RemoteRailsConfig.getInstance().getGsonSerializer();

		try {
			base64 = Base64.encodeToString(gson.toJson(object)
					.getBytes("UTF-8"), Base64.DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return base64;
	}

}