/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;


import entity.users;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author munevver
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;

        String url = request.getRequestURI();
        HttpSession session = request.getSession();

        users user = null;
        if (session != null) { //session nesnesi null değil ise; validUser değişkeninin içerisindeki kullanıcı alınır.
            user = (users) session.getAttribute("validUser");
        }

        if (user == null) {//kullanıcı yok ise 
            if (url.contains("logout")) {
                response.sendRedirect(request.getContextPath() + "/panel/login.xhtml");
            } else {
                fc.doFilter(sr, sr1); // bu yazılmazsa akis kesilmis olur.(bu kod geçişe izin verir)

            }
        } else { //kullanıcı var ise
            if (url.contains("register")) {  // url register kelimesini içeriyorsa public sayfasına geçiş yap.(index.xhtml sayfası)
                response.sendRedirect(request.getContextPath() + "/panel/index.xhtml");
            } else if (url.contains("logout")) {
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/panel/login.xhtml");

            } else {
                fc.doFilter(sr, sr1); // bu yazılmazsa akis kesilmis olur.(bu kod geçişe izin verir)

            }
        }

    }
}