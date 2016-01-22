package cn.elvea.core.persistence.dialect;

public class MsSqlDialect extends Dialect {
    @Override
    public String getTimeSql() {
        return " select getDate() as t ";
    }

    @Override
    public String getDateSql() {
        return " select getDate() as d ";
    }
}
