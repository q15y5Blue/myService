package cn.yqius.control.custom;

import cn.yqius.entity.custom.CashLedgerTable;
import cn.yqius.repository.custom.CashLedgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Controller
@RequestMapping(path = "/table")
public class TableCustomController {

    @Autowired
    private CashLedgerRepository cashLedgerRepository;


    @GetMapping(path="/show")
    @ResponseBody
    public void getArticlePage(){
        CashLedgerTable clt = new CashLedgerTable(YearMonth.now(), LocalDate.now(),"asdasdqwedsa",100.00,100.00,100.00);
        cashLedgerRepository.save(clt);
        System.out.println("save su cc id :"+clt.getId());
        Optional<CashLedgerTable> st =cashLedgerRepository.findById(clt.getId());
        System.out.println(cashLedgerRepository.findAll());
        st.ifPresent(ca -> {
            System.out.println(ca.getAbstractContent());
            System.out.println(ca.getId());
        });
        long ss =cashLedgerRepository.count();
        System.out.println(ss);
        cashLedgerRepository.delete(clt);
        System.out.println("delete ss");
    }

}
