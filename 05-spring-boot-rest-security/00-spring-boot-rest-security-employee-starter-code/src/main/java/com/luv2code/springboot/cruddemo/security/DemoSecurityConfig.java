package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// ***************************************After Database*********************

@Configuration
public class DemoSecurityConfig {
//    add support for JDBC ... no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
//        tell spring security to use JDBC authentication with our data source

    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );
//        use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());
//          disable cross request forgery (CSRF)
//          in general, not required for stateless REST APIs that usePOST, PUT, DELETE and / 0r PATCH
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}



// ********************************************Before Database********************

//// create security configuration
//@Configuration
//public class DemoSecurityConfig {
////    Add user and password roles.
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}test123")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(john, mary, susan);
//
//    }
////    we defined our users here...
////    spring boot will not use the user/password from the application.properties file
//      @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(configure ->
//                configure
//                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
//                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
//                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
//        );
////        use HTTP Basic authentication
//          http.httpBasic(Customizer.withDefaults());
////          disable cross request forgery (CSRF)
////          in general, not required for stateless REST APIs that usePOST, PUT, DELETE and / 0r PATCH
//          http.csrf(csrf -> csrf.disable());
//          return http.build();
//      }
//}
