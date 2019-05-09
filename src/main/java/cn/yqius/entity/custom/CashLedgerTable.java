package cn.yqius.entity.custom;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.LocalDate;
import java.time.YearMonth;

/**
 * 现金流水账
 */
@RedisHash(value = "cashLedgerTable", timeToLive=86400L)
public class CashLedgerTable {
    @Id
    private String id;
    private YearMonth yearMonth;
    private LocalDate localDate;
    private String abstractContent;
    private Double income;
    private Double expense;
    private Double remains;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getRemains() {
        return remains;
    }

    public void setRemains(Double remains) {
        this.remains = remains;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getExpense() {
        return expense;
    }

    public void setExpense(Double expense) {
        this.expense = expense;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(YearMonth yearMonth) {
        this.yearMonth = yearMonth;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public CashLedgerTable() {

    }

    public CashLedgerTable(YearMonth yearMonth, LocalDate localDate, String abstractContent, Double income, Double expense, Double remains) {
        this.yearMonth = yearMonth;
        this.localDate = localDate;
        this.abstractContent = abstractContent;
        this.income = income;
        this.expense = expense;
        this.remains = remains;
    }
}
