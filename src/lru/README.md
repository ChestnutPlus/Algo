[缓存淘汰算法--LRU算法(java代码实现)](https://blog.csdn.net/wangxilong1991/article/details/70172302)

#### 原理
LRU（Least recently used，最近最少使用）算法根据数据的历史访问记录来进行淘汰数据，其核心思想是“如果数据最近被访问过，那么将来被访问的几率也更高

#### 算法（基于链表）
- 1）初始化一个固定大小的链表
- 2）新数据加入，先查看链表中是否已经缓存有数据
  - 有则把对应的数据插到表头
  - 无则把数据插到表头
- 3）当链表超过固定大小的时候，从链表末尾的数据去掉


