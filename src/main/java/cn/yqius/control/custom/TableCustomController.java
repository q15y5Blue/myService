package cn.yqius.control.custom;

import cn.yqius.entity.custom.CashLedgerTable;
import cn.yqius.repository.custom.CashLedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Map;
import java.util.Optional;

/**
 *
 */
@Controller
@RequestMapping(path = "/table")
@EnableRedisHttpSession//http session
public class TableCustomController {

    @Autowired
    FindByIndexNameSessionRepository<? extends Session> sessionRepository;


    @Autowired
    private CashLedgerRepository cashLedgerRepository;


    @GetMapping(path="/show")
    @ResponseBody
    public void getArticlePage(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session){
        CashLedgerTable clt = new CashLedgerTable(Year.now(), Month.from(LocalDate.now()), LocalDate.now(),"asdasdqwedsa",100.00,100.00,100.00);
        cashLedgerRepository.save(clt);
        System.out.println("save su cc id :"+clt.getId());
        System.out.println(clt.getYear());
        System.out.println(clt.getMonth());
        System.out.println(clt.getLocalDate());
        System.out.println(clt.getLocalTime());
        Optional<CashLedgerTable> st =cashLedgerRepository.findById(clt.getId());
        System.out.println(cashLedgerRepository.findAll());
        st.ifPresent(ca -> {
            System.out.println(ca.getAbstractContent());
            System.out.println(ca.getId());
        });
        long ss =cashLedgerRepository.count();
        System.out.println(ss);
//        cashLedgerRepository.delete(clt);
        System.out.println("delete ss");


        this.test(browser,request,session);
        String username ="test";
        Map<String, ? extends Session> usersSessions = sessionRepository.findByIndexNameAndIndexValue(FindByIndexNameSessionRepository.PRINCIPAL_NAME_INDEX_NAME, username);

    }

    private void test(String browser, HttpServletRequest request, HttpSession session) {
        //取出session中的browser
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            System.out.println("不存在session，设置browser=" + browser);
            session.setAttribute("browser", browser);
        } else {
            System.out.println("存在session，browser=" + sessionBrowser.toString());
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }

    }

}
