package ar.edu.unju.fi;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAUTH implements AuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        // TODO Auto-generated method stub
        boolean userCandidato = false;
        boolean userEmpleador = false;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("CIUDADANO")) {
                userCandidato = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("EMPLEADOR")) {
                userEmpleador = true;
                break;
            }
        }

        if (userCandidato) {
            redirectStrategy.sendRedirect(request, response, "/candidato/nuevo");

        } else {
            if (userEmpleador) {
                redirectStrategy.sendRedirect(request, response, "/empleador/nuevo");
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
