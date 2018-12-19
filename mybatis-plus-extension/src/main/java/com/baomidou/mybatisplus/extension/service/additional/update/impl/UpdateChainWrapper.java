package com.baomidou.mybatisplus.extension.service.additional.update.impl;

import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ExceptionUtils;
import com.baomidou.mybatisplus.extension.service.additional.AbstractChainWrapper;
import com.baomidou.mybatisplus.extension.service.additional.update.ChainUpdate;

/**
 * @author miemie
 * @since 2018-12-19
 */
@SuppressWarnings("serial")
public class UpdateChainWrapper<T> extends AbstractChainWrapper<T, String, UpdateChainWrapper<T>, UpdateWrapper<T>>
    implements ChainUpdate<T>, Update<UpdateChainWrapper<T>, String> {

    public UpdateChainWrapper(BaseMapper<T> baseMapper) {
        super(baseMapper);
        wrapperChildren = new UpdateWrapper<>();
    }

    @Override
    public UpdateChainWrapper<T> set(boolean condition, String column, Object val) {
        wrapperChildren.set(condition, column, val);
        return typedThis;
    }

    @Override
    public UpdateChainWrapper<T> setSql(boolean condition, String sql) {
        wrapperChildren.setSql(condition, sql);
        return typedThis;
    }

    @Override
    public String getSqlSet() {
        throw ExceptionUtils.mpe("can not use this method for \"%s\"", "getSqlSet");
    }
}
