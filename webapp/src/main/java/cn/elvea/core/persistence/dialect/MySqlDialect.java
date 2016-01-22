package cn.elvea.core.persistence.dialect;

public class MySqlDialect extends Dialect {
    @Override
    public String getTimeSql() {
        return " select now() as t ";
    }

    @Override
    public String getDateSql() {
        return " select now() as t ";
    }
}
