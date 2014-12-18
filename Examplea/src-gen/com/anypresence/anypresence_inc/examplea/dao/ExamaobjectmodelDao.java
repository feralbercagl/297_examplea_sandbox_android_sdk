package com.anypresence.anypresence_inc.examplea.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import com.anypresence.anypresence_inc.examplea.dao.Examaobjectmodel;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table EXAMAOBJECTMODELS.
 */
public class ExamaobjectmodelDao extends AbstractDao<Examaobjectmodel, Long> {

	public static final String TABLENAME = "EXAMAOBJECTMODELS";

	/**
	 * Properties of entity Examaobjectmodel.<br/>
	 * Can be used for QueryBuilder and for referencing column names.
	 */
	public static class Properties {
		public final static Property Id = new Property(0, Long.class, "id",
				true, "_id");
		public final static Property CreationDate = new Property(1,
				java.util.Date.class, "creationDate", false, "CREATION_DATE");
		public final static Property Name = new Property(2, String.class,
				"name", false, "NAME");
		public final static Property Scope = new Property(3, String.class,
				"scope", false, "SCOPE");
		public final static Property ObjectId = new Property(4, String.class,
				"objectId", false, "OBJECT_ID");
		public final static Property _cacheUpdatedAt = new Property(5,
				java.util.Date.class, "_cacheUpdatedAt", false,
				"_CACHE_UPDATED_AT");
		public final static Property ApCachedRequestId = new Property(6,
				Long.class, "apCachedRequestId", false, "AP_CACHED_REQUEST_ID");
	};

	private DaoSession daoSession;

	public ExamaobjectmodelDao(DaoConfig config) {
		super(config);
	}

	public ExamaobjectmodelDao(DaoConfig config, DaoSession daoSession) {
		super(config, daoSession);
		this.daoSession = daoSession;
	}

	/** Creates the underlying database table. */
	public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
		String constraint = ifNotExists ? "IF NOT EXISTS " : "";
		db.execSQL("CREATE TABLE " + constraint + "'EXAMAOBJECTMODELS' (" + //
				"'_id' INTEGER PRIMARY KEY ," + // 0: id
				"'CREATION_DATE' INTEGER," + // 1: creationDate
				"'NAME' TEXT," + // 2: name
				"'SCOPE' TEXT," + // 3: scope
				"'OBJECT_ID' TEXT," + // 4: objectId
				"'_CACHE_UPDATED_AT' INTEGER," + // 5: _cacheUpdatedAt
				"'AP_CACHED_REQUEST_ID' INTEGER);"); // 6: apCachedRequestId
		// Add Indexes
		db.execSQL("CREATE UNIQUE INDEX " + constraint
				+ "IDX_EXAMAOBJECTMODELS_OBJECT_ID ON EXAMAOBJECTMODELS"
				+ " (OBJECT_ID);");
	}

	/** Drops the underlying database table. */
	public static void dropTable(SQLiteDatabase db, boolean ifExists) {
		String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "")
				+ "'EXAMAOBJECTMODELS'";
		db.execSQL(sql);
	}

	/** @inheritdoc */
	@Override
	protected void bindValues(SQLiteStatement stmt, Examaobjectmodel entity) {
		stmt.clearBindings();

		Long id = entity.getId();
		if (id != null) {
			stmt.bindLong(1, id);
		}

		java.util.Date creationDate = entity.getCreationDate();
		if (creationDate != null) {
			stmt.bindLong(2, creationDate.getTime());
		}

		String name = entity.getName();
		if (name != null) {
			stmt.bindString(3, name);
		}

		String scope = entity.getScope();
		if (scope != null) {
			stmt.bindString(4, scope);
		}

		String objectId = entity.getObjectId();
		if (objectId != null) {
			stmt.bindString(5, objectId);
		}

		java.util.Date _cacheUpdatedAt = entity.get_cacheUpdatedAt();
		if (_cacheUpdatedAt != null) {
			stmt.bindLong(6, _cacheUpdatedAt.getTime());
		}

		Long apCachedRequestId = entity.getApCachedRequestId();
		if (apCachedRequestId != null) {
			stmt.bindLong(7, apCachedRequestId);
		}
	}

	@Override
	protected void attachEntity(Examaobjectmodel entity) {
		super.attachEntity(entity);
		entity.__setDaoSession(daoSession);
	}

	/** @inheritdoc */
	@Override
	public Long readKey(Cursor cursor, int offset) {
		return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
	}

	/** @inheritdoc */
	@Override
	public Examaobjectmodel readEntity(Cursor cursor, int offset) {
		Examaobjectmodel entity = new Examaobjectmodel(
				//
				cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
				cursor.isNull(offset + 1) ? null : new java.util.Date(cursor
						.getLong(offset + 1)), // creationDate
				cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
				cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // scope
				cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // objectId
				cursor.isNull(offset + 5) ? null : new java.util.Date(cursor
						.getLong(offset + 5)), // _cacheUpdatedAt
				cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6) // apCachedRequestId
		);
		return entity;
	}

	/** @inheritdoc */
	@Override
	public void readEntity(Cursor cursor, Examaobjectmodel entity, int offset) {
		entity.setId(cursor.isNull(offset + 0) ? null : cursor
				.getLong(offset + 0));
		entity.setCreationDate(cursor.isNull(offset + 1)
				? null
				: new java.util.Date(cursor.getLong(offset + 1)));
		entity.setName(cursor.isNull(offset + 2) ? null : cursor
				.getString(offset + 2));
		entity.setScope(cursor.isNull(offset + 3) ? null : cursor
				.getString(offset + 3));
		entity.setObjectId(cursor.isNull(offset + 4) ? null : cursor
				.getString(offset + 4));
		entity.set_cacheUpdatedAt(cursor.isNull(offset + 5)
				? null
				: new java.util.Date(cursor.getLong(offset + 5)));
		entity.setApCachedRequestId(cursor.isNull(offset + 6) ? null : cursor
				.getLong(offset + 6));
	}

	/** @inheritdoc */
	@Override
	protected Long updateKeyAfterInsert(Examaobjectmodel entity, long rowId) {
		entity.setId(rowId);
		return rowId;
	}

	/** @inheritdoc */
	@Override
	public Long getKey(Examaobjectmodel entity) {
		if (entity != null) {
			return entity.getId();
		} else {
			return null;
		}
	}

	/** @inheritdoc */
	@Override
	protected boolean isEntityUpdateable() {
		return true;
	}

	private String selectDeep;

	protected String getSelectDeep() {
		if (selectDeep == null) {
			StringBuilder builder = new StringBuilder("SELECT ");
			SqlUtils.appendColumns(builder, "T", getAllColumns());
			builder.append(',');
			SqlUtils.appendColumns(builder, "T0", daoSession
					.getAPCachedRequestDao().getAllColumns());
			builder.append(" FROM EXAMAOBJECTMODELS T");
			builder.append(" LEFT JOIN APCACHED_REQUEST T0 ON T.'AP_CACHED_REQUEST_ID'=T0.'_id'");
			builder.append(' ');
			selectDeep = builder.toString();
		}
		return selectDeep;
	}

	protected Examaobjectmodel loadCurrentDeep(Cursor cursor, boolean lock) {
		Examaobjectmodel entity = loadCurrent(cursor, 0, lock);
		int offset = getAllColumns().length;

		APCachedRequest aPCachedRequest = loadCurrentOther(
				daoSession.getAPCachedRequestDao(), cursor, offset);
		entity.setAPCachedRequest(aPCachedRequest);

		return entity;
	}

	public Examaobjectmodel loadDeep(Long key) {
		assertSinglePk();
		if (key == null) {
			return null;
		}

		StringBuilder builder = new StringBuilder(getSelectDeep());
		builder.append("WHERE ");
		SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
		String sql = builder.toString();

		String[] keyArray = new String[]{key.toString()};
		Cursor cursor = db.rawQuery(sql, keyArray);

		try {
			boolean available = cursor.moveToFirst();
			if (!available) {
				return null;
			} else if (!cursor.isLast()) {
				throw new IllegalStateException(
						"Expected unique result, but count was "
								+ cursor.getCount());
			}
			return loadCurrentDeep(cursor, true);
		} finally {
			cursor.close();
		}
	}

	/** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
	public List<Examaobjectmodel> loadAllDeepFromCursor(Cursor cursor) {
		int count = cursor.getCount();
		List<Examaobjectmodel> list = new ArrayList<Examaobjectmodel>(count);

		if (cursor.moveToFirst()) {
			if (identityScope != null) {
				identityScope.lock();
				identityScope.reserveRoom(count);
			}
			try {
				do {
					list.add(loadCurrentDeep(cursor, false));
				} while (cursor.moveToNext());
			} finally {
				if (identityScope != null) {
					identityScope.unlock();
				}
			}
		}
		return list;
	}

	protected List<Examaobjectmodel> loadDeepAllAndCloseCursor(Cursor cursor) {
		try {
			return loadAllDeepFromCursor(cursor);
		} finally {
			cursor.close();
		}
	}

	/** A raw-style query where you can pass any WHERE clause and arguments. */
	public List<Examaobjectmodel> queryDeep(String where,
			String... selectionArg) {
		Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
		return loadDeepAllAndCloseCursor(cursor);
	}

}
