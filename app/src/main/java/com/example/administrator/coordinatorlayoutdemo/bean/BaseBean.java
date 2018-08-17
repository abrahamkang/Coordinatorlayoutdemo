/*
 * File Name：BaseBean.java
 * Copyright：Copyright 2008-2015 CiWong.Inc. All Rights Reserved.
 * Description： BaseBean.java
 * Modify By：bin
 * Modify Date：2015年4月23日
 * Modify Type：Add
 */
package com.example.administrator.coordinatorlayoutdemo.bean;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 实体类基类
 *
 */
public class BaseBean implements Serializable
{
    /**
     * TODO field comment
     */
    private static final long serialVersionUID = -635484015267913538L;

    protected long _id;

    public long get_id()
    {
        return _id;
    }

    public void set_id(long _id)
    {
        this._id = _id;
    }

    public ParameterizedType getType(final Class raw, final Type... args)
    {
        return new ParameterizedType()
        {
            public Type getRawType()
            {
                return raw;
            }

            public Type[] getActualTypeArguments()
            {
                return args;
            }

            public Type getOwnerType()
            {
                return null;
            }
        };
    }

}
