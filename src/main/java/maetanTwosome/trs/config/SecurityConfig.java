package maetanTwosome.trs.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.stream.Stream;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    // 필터 적용 White List
    private static final String[] WHITE_LIST = {"/", "/static/**", "/js/**", "/image/**", "/auth/**"};

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .requestMatchers(
                                Stream
                                    .of(WHITE_LIST)
                                    .map(AntPathRequestMatcher::antMatcher)
                                    .toArray(AntPathRequestMatcher[]::new)
                        ).permitAll()
                        .anyRequest().authenticated()
                );
                // TODO: 로그인 및 권한 관련 설정 추가 필요
        return http.build();
    }
}
