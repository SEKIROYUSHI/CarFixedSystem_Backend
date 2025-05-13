package com.carSys.TypeHandler;

import com.carSys.Enums.TaskType;
import com.carSys.Enums.TaskType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskTypeHandler extends BaseTypeHandler<TaskType> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, TaskType parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    @Override
    public TaskType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (value == null) {
            return null;
        }
        return TaskType.valueOf(value);
    }

    @Override
    public TaskType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if (value == null) {
            return null;
        }
        return TaskType.valueOf(value);
    }

    @Override
    public TaskType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if (value == null) {
            return null;
        }
        return TaskType.valueOf(value);
    }
}