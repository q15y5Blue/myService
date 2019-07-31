package cn.yqius.entity.custom;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.*;
import java.time.YearMonth;

/**
 * 现金流水账
 */
@RedisHash(value = "cashLedgerTable", timeToLive=86400L)
public class CashLedgerTable {
    @Id
    private String id;
    private Year year;  //- 年
    private Month month;//月
    private LocalDate localDate;  //日期
    private String abstractContent; //摘要
    private Double income;  //收入
    private Double expense; // 支出
    private Double remains;//余额
    private LocalTime localTime;

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


    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public CashLedgerTable() {
        LocalDate.now(Clock.system(ZoneId.of("Asia/Shanghai")));
    }

    public CashLedgerTable(Year year, Month month, LocalDate localDate, String abstractContent, Double income, Double expense, Double remains) {
        LocalDate.now(Clock.system(ZoneId.of("Asia/Shanghai")));
        this.year = year;
        this.month = month;
        this.localDate=localDate;
        this.abstractContent = abstractContent;
        this.income = income;
        this.expense = expense;
        this.remains = remains;
        this.localTime = LocalTime.now();
    }
}
