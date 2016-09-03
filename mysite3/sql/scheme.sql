CREATE TABLE `board` (
  `no` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '번호',
  `title` varchar(200) NOT NULL COMMENT '제목',
  `content` text NOT NULL COMMENT '내용',
  `view_count` int(10) unsigned NOT NULL COMMENT '조회수',
  `reg_date` datetime NOT NULL COMMENT '작성일',
  `user_no` int(10) unsigned NOT NULL COMMENT '회원번호',
  PRIMARY KEY (`no`),
  KEY `FK_user_TO_board` (`user_no`),
  CONSTRAINT `FK_user_TO_board` FOREIGN KEY (`user_no`) REFERENCES `user` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='게시판';

CREATE TABLE `emaillist` (
  `no` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '번호',
  `first_name` varchar(50) NOT NULL COMMENT '성',
  `last_name` varchar(50) NOT NULL COMMENT '이름',
  `email` varchar(200) NOT NULL COMMENT '이메일',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='이메일목록';

CREATE TABLE `guestbook` (
  `no` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '번호',
  `name` varchar(100) NOT NULL COMMENT '이름',
  `reg_date` datetime NOT NULL COMMENT '등록일',
  `message` text NOT NULL COMMENT '메세지',
  `password` varchar(64) NOT NULL COMMENT '비밀번호',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='방명록';

CREATE TABLE `user` (
  `no` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '번호',
  `name` varchar(100) NOT NULL COMMENT '이름',
  `email` varchar(200) NOT NULL COMMENT '이메일',
  `passwd` varchar(80) NOT NULL COMMENT '비밀번호',
  `gender` enum('FEMALE','MALE') NOT NULL COMMENT '성별',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='회원';
