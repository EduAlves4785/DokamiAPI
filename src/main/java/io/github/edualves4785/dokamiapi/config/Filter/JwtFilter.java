package io.github.edualves4785.dokamiapi.config.Filter;

import io.github.edualves4785.dokamiapi.jwt.InvalidTokenExcpetion;
import io.github.edualves4785.dokamiapi.jwt.JwtService;
import io.github.edualves4785.dokamiapi.domain.entities.Usuario;
import io.github.edualves4785.dokamiapi.domain.entities.service.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioService usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token=getToken(request);

        if (token!=null){
            try {
                String email= jwtService.getEmailFromToken(token);
                Usuario usuario=usuarioService.getByEmail(email);
                setUsuarioAutenticado(usuario);
            }catch (InvalidTokenExcpetion e){
                log.error("Token inválido: {} ",e.getMessage());
            }catch (Exception e){
                log.error("Erro na validação to token: {}",e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }

    private void setUsuarioAutenticado(Usuario usuario){
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        usuario,
                        null,
                        List.of(new SimpleGrantedAuthority("ROLE_USER"))
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getToken(HttpServletRequest request){
        String authHeader= request.getHeader("Authorization");
        if (authHeader!=null){
           String[] authHeaderParts= authHeader.split(" ");
           if (authHeaderParts.length==2){
               return authHeaderParts[1];
           }
        }
        return null;
    }
}
