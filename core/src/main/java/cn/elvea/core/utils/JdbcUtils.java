package cn.elvea.core.utils;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JdbcUtils {
    public final static Logger logger = LoggerFactory.getLogger(JdbcUtils.class);

    public final static String DB_TYPE_ORACLE = "ORACLE";
    public final static String DB_TYPE_MYSQL = "MYSQL";
    public final static String DB_TYPE_OTHEER = "OTHER";

    public final static String COL_TYPE_STRING = "STRING";
    public final static String COL_TYPE_DATE = "DATE";
    public final static String COL_TYPE_TIMESTAMP = "TIMESTAMP";
    public final static String COL_TYPE_DOUBLE = "DOUBLE";
    public final static String COL_TYPE_FLOAT = "FLOAT ";
    public final static String COL_TYPE_INTEGER = "INTEGER";

    public static DatabaseMetaData getDatabaseMetaData(Connection con) throws SQLException {
        return con.getMetaData();
    }

    public static String getDatabaseType(Connection con) throws SQLException {
        return getDatabaseType(getDatabaseMetaData(con));
    }

    public static String getDatabaseType(DatabaseMetaData metaData) throws SQLException {
        if (metaData != null) {
            String name = metaData.getDatabaseProductName();
            if (!Strings.isNullOrEmpty(name) && name.trim().toUpperCase().contains(DB_TYPE_MYSQL)) {
                return DB_TYPE_MYSQL;
            } else if (!Strings.isNullOrEmpty(name) && name.trim().toUpperCase().contains(DB_TYPE_ORACLE)) {
                return DB_TYPE_ORACLE;
            }
        }
        return DB_TYPE_OTHEER;
    }

    /**
     * 创建简单临时表
     */
    public static String createTemporaryTable(Connection con, List<Long> data) throws SQLException {
        // 生成临时表名
        String temporaryTableName = "tem_" + ((int) (Math.random() * 100000)) + "_" + System.currentTimeMillis();

        Statement createTemporaryStatement = null;
        PreparedStatement insertStatement = null;
        try {
            // 获取数据库类型
            String dbType = getDatabaseType(con);

            // 创建临时表
            createTemporaryStatement = con.createStatement();
            if (dbType.equalsIgnoreCase(DB_TYPE_ORACLE)) {
                createTemporaryStatement.execute("create global temporary table " + temporaryTableName + "(id number(19)) on commit preserve rows");
            } else if (dbType.equalsIgnoreCase(DB_TYPE_MYSQL)) {
                createTemporaryStatement.execute("create table " + temporaryTableName + "(id int)");
            } else {
                temporaryTableName = "#" + temporaryTableName;
                createTemporaryStatement.execute("create table " + temporaryTableName + "(id int)");
            }

            // 初始临时数据
            insertStatement = con.prepareStatement("insert into " + temporaryTableName + "(id) values(?)");
            if (data != null && !data.isEmpty()) {
                for (Long val : data) {
                    insertStatement.setLong(1, val);
                    insertStatement.addBatch();
                }
            }
            insertStatement.executeBatch();

            return temporaryTableName;
        } catch (Exception e) {
            logger.error("Create temporary table " + temporaryTableName + " failure.\n", e);
            throw new SQLException("Create temporary table " + temporaryTableName + " failure.\n");
        } finally {
            close(createTemporaryStatement);
            close(insertStatement);
        }
    }

    /**
     * 创建临时表
     */
    public static String createTemporaryTable(Connection con, final Map<String, String> nameTypeMap, final List<Map<String, Object>> data) throws SQLException {
        // 生成临时表名
        String temporaryTableName = "tmp_" + (((int) (Math.random() * 100000)) + "_" + System.currentTimeMillis());

        Statement createTemporaryStatement = null;
        PreparedStatement insertStatement = null;
        try {
            // 获取数据库类型
            String dbType = getDatabaseType(con);

            // 生成创建临时表的DDL
            StringBuffer createTemprarySql = new StringBuffer(" (");
            Set<String> set = nameTypeMap.keySet();
            for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
                String name = iterator.next();
                String columnType = nameTypeMap.get(name);

                createTemprarySql.append(name);
                /** 如果是Oracle数据库 */
                if (dbType.equalsIgnoreCase(DB_TYPE_ORACLE)) {
                    if (columnType.equalsIgnoreCase(COL_TYPE_STRING)) {
                        columnType = "nvarchar2(255)";
                    } else if (columnType.equalsIgnoreCase(COL_TYPE_TIMESTAMP) || columnType.equalsIgnoreCase(COL_TYPE_DATE)) {
                        columnType = "timestamp";
                    }
                } else {
                    /** 如果是其他数据库 */
                    if (columnType.equalsIgnoreCase(COL_TYPE_STRING)) {
                        columnType = "varchar(255)";
                    } else if (columnType.equalsIgnoreCase(COL_TYPE_TIMESTAMP) || columnType.equalsIgnoreCase(COL_TYPE_DATE)) {
                        columnType = "datetime";
                    }
                }
                if (columnType.equalsIgnoreCase(COL_TYPE_DOUBLE) || columnType.equalsIgnoreCase(COL_TYPE_FLOAT)) {
                    columnType = "float";
                }
                if (columnType.equalsIgnoreCase(COL_TYPE_INTEGER)) {
                    columnType = "int";
                }
                createTemprarySql.append(" ").append(columnType);
                if (iterator.hasNext()) {
                    createTemprarySql.append(", ");
                } else {
                    createTemprarySql.append(") ");
                }
            }

            // 创建临时表
            createTemporaryStatement = con.createStatement();
            if (dbType.equalsIgnoreCase(DB_TYPE_ORACLE)) {
                createTemporaryStatement.execute("create global temporary table " + temporaryTableName + createTemprarySql.toString() + " on commit preserve rows");
            } else if (dbType.equalsIgnoreCase(DB_TYPE_MYSQL)) {
                createTemporaryStatement.execute("create table " + temporaryTableName + createTemprarySql.toString());
            } else {
                temporaryTableName = "#" + temporaryTableName;
                createTemporaryStatement.execute("create table " + temporaryTableName + createTemprarySql.toString());
            }

            // 初始临时数据
            if (data != null && !data.isEmpty()) {
                List<String> nameList = Lists.newLinkedList();
                List<String> nameTypeList = Lists.newLinkedList();

                StringBuffer insertSql = new StringBuffer("insert into ").append(temporaryTableName).append("(");
                StringBuffer insertValuesSql = new StringBuffer(" values ( ");
                for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
                    String name = iterator.next();
                    String columnType = nameTypeMap.get(name);

                    nameList.add(name);
                    nameTypeList.add(columnType);

                    if (iterator.hasNext()) {
                        insertSql.append(name).append(", ");
                        insertValuesSql.append("?, ");
                    } else {
                        insertSql.append(name).append(") ");
                        insertValuesSql.append("?)");
                    }
                }
                insertSql.append(insertValuesSql);

                insertStatement = con.prepareStatement(insertSql.toString());
                for (Map<String, Object> row : data) {
                    for (int i = 0; i < nameList.size(); i++) {
                        String name = nameList.get(i);
                        String columnType = nameTypeList.get(i);

                        if (columnType.equalsIgnoreCase(COL_TYPE_STRING)) {
                            String val = row.get(name) == null ? null : row.get(name).toString();
                            insertStatement.setString(i + 1, val);
                        } else if (columnType.equalsIgnoreCase(COL_TYPE_TIMESTAMP) || columnType.equalsIgnoreCase(COL_TYPE_DATE)) {
                            Timestamp val = row.get(name) == null ? null : (Timestamp) row.get(name);
                            insertStatement.setTimestamp(i + 1, val);
                        } else if (columnType.equalsIgnoreCase(COL_TYPE_DOUBLE) || columnType.equalsIgnoreCase(COL_TYPE_FLOAT)) {
                            float val = row.get(name) == null ? 0f : (Float) row.get(name);
                            insertStatement.setFloat(i + 1, val);
                        } else if (columnType.equalsIgnoreCase(COL_TYPE_INTEGER)) {
                            int val = row.get(name) == null ? 0 : (Integer) row.get(name);
                            insertStatement.setInt(i + 1, val);
                        }
                    }
                    insertStatement.addBatch();
                }
                insertStatement.executeBatch();
            }
            return temporaryTableName;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Create temporary table " + temporaryTableName + " failure.\n", e);
            throw new SQLException("Create temporary table " + temporaryTableName + " failure.\n");
        } finally {
            close(createTemporaryStatement);
            close(insertStatement);
        }
    }

    /**
     * 移除临时表
     *
     * @param temporaryTableName 临时表名
     */
    public static void dropTemporaryTable(Connection con, String temporaryTableName) throws SQLException {
        if (!Strings.isNullOrEmpty(temporaryTableName)) {
            Statement dropTemporaryStatement = null;
            try {
                dropTemporaryStatement = con.createStatement();
                dropTemporaryStatement.execute("truncate table " + temporaryTableName);
                dropTemporaryStatement.execute("drop table " + temporaryTableName);
            } catch (Exception e) {
                logger.error("Drop temporary table " + temporaryTableName + " failure.\n", e);
                throw new SQLException("Drop temporary table " + temporaryTableName + " failure.\n");
            } finally {
                close(dropTemporaryStatement);
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt) {
        close(rs);
        close(stmt);
    }

    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                logger.trace("Could not close JDBC Statement", ex);
            } catch (Throwable ex) {
                logger.trace("Unexpected exception on closing JDBC Statement", ex);
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                logger.trace("Could not close JDBC ResultSet", ex);
            } catch (Throwable ex) {
                logger.trace("Unexpected exception on closing JDBC ResultSet", ex);
            }
        }
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                logger.trace("Could not close JDBC Connection", ex);
            } catch (Throwable ex) {
                logger.trace("Unexpected exception on closing JDBC Connection", ex);
            }
        }
    }
}

