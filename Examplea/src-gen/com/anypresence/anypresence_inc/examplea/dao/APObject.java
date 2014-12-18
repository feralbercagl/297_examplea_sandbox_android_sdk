package com.anypresence.anypresence_inc.examplea.dao;

/**
 * Abstract class for GreenDAO models
 */
public abstract class APObject {
	public abstract Long getId();

	public abstract void setObjectId(String objectId);

	public abstract String getObjectId();

	public abstract java.util.Date get_cacheUpdatedAt();

	public abstract void set_cacheUpdatedAt(java.util.Date _cacheUpdatedAt);
}
