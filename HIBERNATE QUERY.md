

# 하이버네이트 쿼리 샘플
```

package org.hibernate.shards.query;

import org.hibernate.shards.Shard;
import org.hibernate.shards.util.Lists;
import org.hibernate.shards.util.Maps;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Maulik Shah
 */
public class QueryResult {

  private final Map<Shard, List> resultMap = Maps.newHashMap();

  private final List<Object> entityList = Lists.newArrayList();

  public Map<Shard, List> getResultMap() {
    return Collections.unmodifiableMap(resultMap);
  }

  public void add(Shard shard, List<Object> list) {
    resultMap.put(shard, list);
    entityList.addAll(list);
  }

  public void add(QueryResult result) {
    resultMap.putAll(result.getResultMap());
    entityList.addAll(result.getEntityList());
  }

  public List<Object> getEntityList() {
    return entityList;
  }

}

``
