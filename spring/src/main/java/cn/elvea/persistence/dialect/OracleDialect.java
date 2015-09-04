package cn.elvea.persistence.dialect;

public class OracleDialect extends Dialect {
    @Override
    public String getTimeSql() {
        return " select sysdate as t from dual";
    }

    @Override
    public String getDateSql() {
        return " select systimestamp as d ";
    }
}
