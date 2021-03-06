package org.springframework.nativex.substitutions.tomcat;

import java.util.Optional;

import javax.security.auth.message.config.AuthConfigProvider;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import org.springframework.nativex.substitutions.OnlyIfPresent;

@TargetClass(className = "org.apache.catalina.authenticator.AuthenticatorBase", onlyWith = { OnlyIfPresent.class })
final class Target_AuthenticatorBase {

	@Alias
	private volatile Optional<AuthConfigProvider> jaspicProvider;

	@Substitute
	private AuthConfigProvider getJaspicProvider() {
		return null;
	}

	@Substitute
	private Optional<AuthConfigProvider> findJaspicProvider() {
		jaspicProvider = Optional.empty();
		return jaspicProvider;
	}
}
