package cn.yqius.repository.custom;

import cn.yqius.entity.custom.CashLedgerTable;
import org.springframework.data.repository.CrudRepository;

public interface CashLedgerRepository extends CrudRepository<CashLedgerTable,String> {
}
