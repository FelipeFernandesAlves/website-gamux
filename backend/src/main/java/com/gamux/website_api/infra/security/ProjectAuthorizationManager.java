package com.gamux.website_api.infra.security;

import java.util.UUID;
import java.util.function.Supplier;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import com.gamux.website_api.domain.gamux_project.enums.MemberRole;
import com.gamux.website_api.repositories.gamux_project.GamuxProjectMemberRepository;

@Component
public class ProjectAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {

    @Autowired
    private GamuxProjectMemberRepository memberRepository;

    @Override
    public @Nullable AuthorizationResult authorize(Supplier<? extends @Nullable Authentication> authentication, RequestAuthorizationContext context) {
        String idStr = context.getRequest().getParameter("id");
        Authentication auth = authentication.get();

        if (auth == null || !auth.isAuthenticated() || idStr == null)
            return new AuthorizationDecision(false);
        
        boolean isGlobalAdmin = auth.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals("ROLE_STAFF"));

        if (isGlobalAdmin)
            return new AuthorizationDecision(true);

        UUID projectId = UUID.fromString(idStr);
        String username = auth.getName();
        MemberRole requiredRole = determineRequiredRole(context.getRequest().getMethod());
        
        boolean hasAccess = memberRepository.findByProjectIdAndUserUsername(projectId, username)
            .map(member -> MemberRole.valueOf(member.getRole()).isAtLeast(requiredRole))
            .orElse(MemberRole.VIEWER.isAtLeast(requiredRole));

        return new AuthorizationDecision(hasAccess);
    }

    MemberRole determineRequiredRole(String method) {
        return switch(method) {
            case "POST", "PUT", "PATCH", "DELETE" -> MemberRole.ADMIN;
            default -> MemberRole.VIEWER;
        };
    }
}
