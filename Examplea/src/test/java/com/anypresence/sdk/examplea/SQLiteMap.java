package com.anypresence.sdk.examplea;

import org.robolectric.util.DatabaseConfig;

import java.io.File;
import java.sql.ResultSet;

public class SQLiteMap implements DatabaseConfig.DatabaseMap {

	private String _dbFile;

	/**
	 * This constructor will use in-memory database.
	 */
	public SQLiteMap() {
	}

	/**
	 * This constructor will use a database file
	 *
	 * @param dbFile: path to the SQLite database file
	 */
	public SQLiteMap(String dbFile) {
		_dbFile = dbFile;
	}

	public String getDriverClassName() {
		return "org.sqlite.JDBC";
	}

	@Override
	public String getMemoryConnectionString() {
		return "jdbc:sqlite::memory:";
	}

	@Override
	public String getConnectionString(File file) {
		if (file == null) {
			return "jdbc:sqlite::memory:";
		} else {
			return String.format("jdbc:sqlite:%s", file.getName());
		}

	}

	public String getScrubSQL(String sql) {
		return sql;
	}

	public String getSelectLastInsertIdentity() {
		return "SELECT last_insert_rowid() AS id";
	}

	public int getResultSetType() {
		return ResultSet.TYPE_FORWARD_ONLY;
	}

}
