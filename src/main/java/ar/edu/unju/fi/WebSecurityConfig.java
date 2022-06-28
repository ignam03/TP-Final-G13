package ar.edu.unju.fi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import ar.edu.unju.fi.service.imp.LoginUsuarioImp;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Autowired
    ManejadorAUTH autenticacion;

    String[] resources = new String[] {
            "/include/**", "/css/**", "/assets/**", "/js/**", "/layer/**", "/webjars/**", "/images/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
                .antMatchers("/", "/empleos/sobreNosotros", "/ciudadano/nuevo", "/ciudadano/guardar", "/ciudadano/cargarCv",
                        "/empleador/nuevo", "/empleador/guardar")
                .permitAll()
                // .antMatchers("/ciudadano/**", "/employee/**").hasAuthority("ADMINISTRADOR")
                // .antMatchers("/producto").hasAuthority("administrador")
                // .antMatchers("/cargarRegistro/","/buscarPersona","/cargarPersona",
                // "/guardarCondicion", "/").hasAuthority("CLIENTE")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/empleos/loginCiu")
                .permitAll()
                .successHandler(autenticacion)
                .failureUrl("/empleos/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/empleos/inicio");
        // http.csrf().disable();
        return http.build();
    }

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
        return bCryptPasswordEncoder;
    }

    @Autowired
    LoginUsuarioImp userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        var provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
