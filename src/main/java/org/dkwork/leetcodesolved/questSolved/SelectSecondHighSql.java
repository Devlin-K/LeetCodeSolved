package org.dkwork.leetcodesolved.questSolved;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author jin
 * @date 2020/12/1
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProject javatemplate
 * @BelongPackage org.dkwork.leetcodesolved.questSolved
 * @Describe:
 */
public interface SelectSecondHighSql {
    @Select("SELECT t.user_id,count(0) as count12 FROM `time_punch_log` t GROUP BY t.user_id  HAVING count(0)>1  ORDER BY count12 desc LIMIT 1,2")
    Map<String,Long> getSecondHigh();
}
