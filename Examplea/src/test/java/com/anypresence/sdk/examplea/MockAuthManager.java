package com.anypresence.sdk.examplea;

import com.anypresence.sdk.acl.*;
import com.anypresence.rails_droid.RemoteObject;
import com.anypresence.rails_droid.RemoteRequest;
import com.anypresence.rails_droid.RemoteRequestException;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;

public class MockAuthManager implements IAuthManager {
	private Boolean authenticated = false;

	public MockAuthManager() {
	}

	@Override
	public IAuthenticatable getUser() {
		return null;
	}

	@Override
	public IAuthenticatable getAuthenticatableObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAuthenticatableObject(IAuthenticatable authenticatableObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean getIsAuthenticated() {
		// TODO Auto-generated method stub
		return authenticated;
	}

	@Override
	public void authenticateUser(String username, String password,
			FutureCallback<String> futureCallback)
			throws RemoteRequestException {
		this.authenticated = true;
		ListenableFuture<String> future = (ListenableFuture<String>) RemoteRequest
				.getService().submit(new Callable<String>() {
					@SuppressWarnings("unchecked")
					public String call() throws Exception {
						return "success";
					}
				});
		Futures.addCallback(future, futureCallback);
	}

	@Override
	public void authenticateUser(final RemoteObject user,
			FutureCallback<String> futureCallback)
			throws RemoteRequestException {
		this.authenticated = true;
		ListenableFuture<String> future = (ListenableFuture<String>) RemoteRequest
				.getService().submit(new Callable<String>() {
					@SuppressWarnings("unchecked")
					public String call() throws Exception {
						return "success";
					}
				});
		Futures.addCallback(future, futureCallback);
	}

	@Override
	public void authenticate(FutureCallback<IAuthenticatable> futureCallback) {
		// TODO Auto-generated method stub
	}

	@Override
	public Boolean authenticateUser(final String username, final String password)
			throws RemoteRequestException {
		return authenticated;
	}

	@Override
	public Boolean authenticate() throws RemoteRequestException {
		return authenticated;
	}

	@Override
	public void deauthenticate() throws RemoteRequestException {
		// TODO Auto-generated method stub
	}

	@Override
	public void deauthenticate(FutureCallback<Void> futureCallback) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deauthenticateUser(FutureCallback<String> futureCallback)
			throws RemoteRequestException {
		// TODO Auto-generated method stub
	}

	@Override
	public Boolean isAuthorized(IAuthorizable objectRequiringAuthorization,
			AllowedAction action) throws UnauthorizedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends RemoteObject> getAuthenticatableObjectClazz() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAuthenticatableObjectClazz(
			Class<? extends RemoteObject> authenticatableObjectClazz) {
		// TODO Auto-generated method stub

	}

}
