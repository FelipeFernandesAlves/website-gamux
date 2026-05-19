package com.gamux.website_api.infra.security;

import java.util.function.Supplier;

import org.jspecify.annotations.Nullable;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

@Component
public class UserAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public @Nullable AuthorizationResult authorize(Supplier<? extends @Nullable Authentication> authentication, RequestAuthorizationContext context) {
        Authentication auth = authentication.get();
        if (auth == null || !auth.isAuthenticated()) {
            return new AuthorizationDecision(false);
        }
        
        boolean isGlobalAdmin = auth.getAuthorities().stream()
            .anyMatch(a -> {
                return a.getAuthority().equals("ROLE_STAFF");
            });

        if (isGlobalAdmin)
            return new AuthorizationDecision(true);

        String username = context.getRequest().getHeader("username");
        String authUsername = auth.getName();

        return new AuthorizationDecision(username.equals(authUsername));
    }
    
}
