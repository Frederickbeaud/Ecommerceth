package tn.ipsas.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig
{
    @Autowired // pour l'injection de dépendances
//Définir les utilisateurs et leurs rôles
    public void globalConfig(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN","USER");
        auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws
            Exception {

        http
                .csrf().disable() //désactiver la protection contre CSRF
                .authorizeRequests()
                .anyRequest()
                .authenticated() //il faut s'authentifier pour accéder à toutes les URLs
                .and()
                .formLogin()
                .loginPage("/login") //page d'authentification (template)
                .permitAll()

                .defaultSuccessUrl("/",true);//page d’accueil

        return http.build();
    }

}
