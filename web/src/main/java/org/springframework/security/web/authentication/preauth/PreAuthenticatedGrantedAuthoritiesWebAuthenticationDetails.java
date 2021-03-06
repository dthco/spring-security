package org.springframework.security.web.authentication.preauth;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainerImpl;
import org.springframework.security.core.authority.MutableGrantedAuthoritiesContainer;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * This WebAuthenticationDetails implementation allows for storing a list of
 * pre-authenticated Granted Authorities.
 *
 * @author Ruud Senden
 * @author Luke Taylor
 * @since 2.0
 */
public class PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails extends WebAuthenticationDetails implements
        MutableGrantedAuthoritiesContainer {
    public static final long serialVersionUID = 1L;

    private MutableGrantedAuthoritiesContainer authoritiesContainer = new GrantedAuthoritiesContainerImpl();

    public PreAuthenticatedGrantedAuthoritiesWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        return authoritiesContainer.getGrantedAuthorities();
    }

    public void setGrantedAuthorities(List<GrantedAuthority> authorities) {
        this.authoritiesContainer.setGrantedAuthorities(authorities);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + "; ");
        sb.append(authoritiesContainer);
        return sb.toString();
    }
}
