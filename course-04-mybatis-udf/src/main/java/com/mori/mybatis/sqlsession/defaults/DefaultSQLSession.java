package com.mori.mybatis.sqlsession.defaults;

import com.mori.mybatis.cfg.Configuration;
import com.mori.mybatis.sqlsession.SqlSession;

/**
 * SQLSession 的实现类
 */
public class DefaultSQLSession implements SqlSession {

    private Configuration cfg;

    public DefaultSQLSession(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 创建代理对象
     *
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return null;
    }

    /**
     * 释放资源
     */
    @Override
    public void close() {

    }
}
