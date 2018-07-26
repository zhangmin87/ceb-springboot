-- USER 表
CREATE  TABLE T_SYSTEM_USER (
     id integer primary key auto_increment COMMENT 'ID',
     USERNAME varchar (100) COMMENT '用户名',
     PASSWORD varchar (100) COMMENT '密码'
) COMMENT='用户表' ;
-- 用户名不能为空
ALTER  TABLE  T_SYSTEM_USER modify USERNAME VARCHAR(100)   NOT  NULL;
-- 密码不能为空
ALTER  TABLE  T_SYSTEM_USER MODIFY PASSWORD VARCHAR(100)  NOT  NULL;

-- 创建时间
ALTER TABLE T_SYSTEM_USER  ADD  CREATETIMEd  DATE NOT NULL COMMENT '创建时间';

-- 在严格模式下，不允许日期和月份为零
SET SESSION sql_mode=NO_ZERO_IN_DATE;