CPU大量的无效循环-写事件：

只要 TCP 连接适合数据写入时就会产生 OP_WRITE 事件，基本上 95% 以上的时间都会产生 OP_WRITE 事件。

由于很多时间都会产生 OP_WRITE 事件，一开始就注册的话会对服务器产生严重的性能损耗，过多的循环会导致 CPU 利用率骤增。
一般来说，如果没有数据写入时不要注册 OP_WRITE，只在有数据要写入时再去注册，写完后就注销 OP_WRITE 事件.
一般只注册 read 事件，在有数据写入的时间再注册 write 事件，写完后再改为 read 事件(取消write事件)。
如果没有数据写入时也注册 write 事件的话，那会产生很差的性能(大量的无效循环)。

有一些 NIO 框架就很少注册 OP_WRITE 事件的，直接写入，如果不适合时就会产生阻塞直到能写为止。
OP_WRITE 比 OP_READ 等事件处理麻烦很多，一不小心就会对性能产生严重的影响。

socket空闲时，即为可写.有数据来时，可读.
对于nio的写事件，只在发送数据时，如果因为通道的阻塞，暂时不能全部发送，才注册写事件key.interestOps(key.interestOps() | SelectionKey.OP_WRITE);
。等通道可写时，再写入。同时判断是否写完，如果写完，就取消写事件即可key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE);。
空闲状态下，所有的通道都是可写的，如果你给每个通道注册了写事件，那么肯定是死循环了

基本上有 99% 的时间都是可写的，在多selector架构的情况下在处理 read事件的时候需要取消 key.interestOps(key.interestOps() | SelectionKey.OP_READ)，
处理完成之后再重新注册read事件。