#适应设计模式
##iterator【模式迭代器模式】
从包含有多个元素集合中将各个元素逐一取出来的iterator模式

###相关角色定义


_aggregate_:**表示集合的接口**

_iterator_:**遍历集合的接口**

_book_:**表示书的类**

_bookShelf_:**表示书架的类**

_bookShelfIterator_:**遍历书架的类**

main:测试程序

###uml图

![uml](iterator.jpg)
##adapter【适配器模式】
用来填充不同接口之间的缝隙

###相关角色定义

target(对象):目前需要的被适配的东西

client(请求者):使用者,用户

adaptee(被适配):被适配成的东西

adapter(适配):适配转换方式

![adapter](adapter.jpg)