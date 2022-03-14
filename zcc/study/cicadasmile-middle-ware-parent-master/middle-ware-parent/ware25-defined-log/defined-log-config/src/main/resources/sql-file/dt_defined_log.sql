CREATE TABLE dt_defined_log (
	id INT ( 11 ) NOT NULL AUTO_INCREMENT COMMENT '主键',
	class_name VARCHAR ( 200 ) DEFAULT NULL COMMENT '请求类名',
	method_name VARCHAR ( 100 ) DEFAULT NULL COMMENT '请求方法名',
	method_desc VARCHAR ( 100 ) DEFAULT NULL COMMENT '请求方法描述',
	api_type INT ( 1 ) DEFAULT 0 COMMENT 'API类型',
	biz_nature INT ( 1 ) DEFAULT 0 COMMENT '业务性质类型',
	data_flow_type INT ( 1 ) DEFAULT 0 COMMENT '日志数据流向',
	req_param VARCHAR ( 200 ) DEFAULT NULL COMMENT '请求报文',
	res_param VARCHAR ( 200 ) DEFAULT NULL COMMENT '响应报文',
	PRIMARY KEY ( `id` )
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '日志记录表';