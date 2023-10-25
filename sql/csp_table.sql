drop table if exists `tb_exercises`;
CREATE TABLE `tb_exercises`
(
    id                    bigint auto_increment not null comment '主键',
    exercise_title        text comment '题目描述',
    choice_a              varchar(128) default '' comment '选项A',
    choice_b              varchar(128) default '' comment '选项B',
    choice_c              varchar(128) default '' comment '选项C',
    choice_d              varchar(128) default '' comment '选项D',
    correct_answer        varchar(128) default '' comment '正确答案，对于选择题只能取A、B、C、D这四个值其中之一，对于判断题只能是 正确/错误 二者之一',
    analysis              text comment '答案解析',
    exercise_type         tinyint(3)   default 0  comment '题目类型 0:选择题 1:判断题',
    ques_type             tinyint(3)   default 0  comment '类型 0:基础题 1:阅读程序 2:补全程序',
    is_delete             tinyint(3)   default 0  comment '是否删除 0:否 1:是',
    create_by             varchar(64)  default '' comment '创建者',
    create_time           datetime                comment '创建时间',
    update_by             varchar(64)  default '' comment '更新者',
    update_time           datetime                comment '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '题目表';

drop table if exists `tb_paper`;
CREATE TABLE `tb_paper`
(
    id                    bigint auto_increment not null comment '主键',
    paper_name            varchar(128) default '' comment '试卷名称',
    create_by             varchar(64)  default '' comment '创建者',
    create_time           datetime                comment '创建时间',
    update_by             varchar(64)  default '' comment '更新者',
    update_time           datetime                comment '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '试卷表（存放生成的试卷）';

drop table if exists `tb_paper_exercise`;
CREATE TABLE `tb_paper_exercise`
(
    id                    bigint auto_increment not null comment '主键',
    paper_id              bigint default 0 comment '试卷id',
    exercise_id           bigint default 0 comment '题目id',
    score                 int4   default 0 comment '题目分数',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '试卷-题目映射表';


drop table if exists `tb_exam`;
CREATE TABLE `tb_exam`
(
    id                    bigint auto_increment not null comment '主键',
    exam_name             varchar(128) default '' comment '考试名称',
    paper_id              bigint       default 0  comment '试卷id',
    start_time            datetime                comment '开始时间',
    duration              int4         default 0  comment '持续时间，以分钟为单位',
    is_end                tinyint(3)   default 0  comment '是否结束 0:否 1:是',
    is_delete             tinyint(3)   default 0  comment '是否删除 0:否 1:是',
    create_by             varchar(64)  default '' comment '创建者',
    create_time           datetime                comment '创建时间',
    update_by             varchar(64)  default '' comment '更新者',
    update_time           datetime                comment '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '考试表';

drop table if exists `tb_exam_user`;
CREATE TABLE `tb_exam_user`
(
    id                    bigint auto_increment not null comment '主键',
    exam_id               bigint default 0 comment '考试id',
    user_id               bigint default 0 comment '用户id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '考试-用户映射表（记录参加考试的用户）';

drop table if exists `tb_examination_info`;
CREATE TABLE `tb_examination_info`
(
    id                    bigint auto_increment not null comment '主键',
    exam_id               bigint        default 0  comment '考试id',
    user_id               bigint        default 0  comment '用户id',
    exercise_id           bigint        default 0  comment '题目id',
    is_true               int4          default 1  comment '是否正确 0：否 1：是',
    create_by             varchar(64)   default '' comment '创建者',
    create_time           datetime                 comment '创建时间',
    update_by             varchar(64)   default '' comment '更新者',
    update_time           datetime                 comment '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '考试情况记录表';

drop table if exists `tb_error_exercise`;
CREATE TABLE `tb_error_exercise`
(
    id                    bigint auto_increment not null comment '主键',
    exercise_id           bigint        default 0  comment '题目id',
    user_id               bigint        default 0  comment '用户id',
    error_counts          int4          default 0  comment '错误次数',
    is_delete             tinyint(3)    default 0  comment '是否删除 0:否 1:是',
    create_by             varchar(64)   default '' comment '创建者',
    create_time           datetime                comment '创建时间',
    update_by             varchar(64)   default '' comment '更新者',
    update_time           datetime                comment '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '错题记录表';