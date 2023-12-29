-- 用户表
DROP TABLE IF EXISTS sast_pancake.`user`;
create table if not exists sast_pancake.`user`
(
    `id` int not null auto_increment comment 'ID' primary key,
    `username` varchar(255) not null comment '用户名',
    `password` varchar(255) not null comment '密码',
    `role` int default 0 not null comment '角色'
) comment '用户表';

-- pancake表
DROP TABLE IF EXISTS sast_pancake.`pancake`;
create table if not exists sast_pancake.`pancake`
(
    `id` int not null auto_increment comment 'ID' primary key,
    `title` varchar(255) not null comment '标题',
    `create_time` date not null comment '创建时间',
    `ddl` date not null comment '截至时间',
    `is_done` tinyint default 0 not null comment '是否完成 (未完成: 0; 完成: 1)'
) comment 'pancake表';

-- 添加基本信息
insert into sast_pancake.`user` (`id`, `username`, `password`, `role`) values (null, '张三', 'admin123', 1);
insert into sast_pancake.`user` (`id`, `username`, `password`, `role`) values (null, '李四', 'user01123', 0);
insert into sast_pancake.`user` (`id`, `username`, `password`, `role`) values (null, '李枫', 'user02123', 0);
insert into sast_pancake.`user` (`id`, `username`, `password`, `role`) values (null, '花枫', 'user03123', 0);
insert into sast_pancake.`user` (`id`, `username`, `password`, `role`) values (null, '秋山澪', 'user04123', 0);
insert into sast_pancake.`pancake` (`id`, `title`, `create_time`, `ddl`, `is_done`) values (null, 'SAST-EVENTO', '2023-07-01', '2023-10-24', 1);
insert into sast_pancake.`pancake` (`id`, `title`, `create_time`, `ddl`, `is_done`) values (null, 'SAST-OS', '2023-10-01', '2025-10-01', 0);