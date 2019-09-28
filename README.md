# Java MVC模式 #
学生管理系统



### sql分页 ###
		ALTER PROCEDURE P_GetInfoByPage @page INT
		AS
		    BEGIN
		        SELECT  X.sid ,
		                X.sname ,
		                X.gender ,
		                X.phone ,
		                X.birthday ,
		                X.hobby ,
		                X.info
		        FROM    ( SELECT    ROW_NUMBER() OVER ( ORDER BY sid ) id ,
		                            *
		                  FROM      dbo.stu
		                ) AS X
		        WHERE   id >= ( @page - 1 ) * 4 + 1
		                AND id <= 4 * @page;
		    END;
