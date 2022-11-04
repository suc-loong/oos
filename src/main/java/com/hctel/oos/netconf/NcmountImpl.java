//package com.hctel.oos.ncmount;
//
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.CacheLoader;
//import com.google.common.cache.LoadingCache;
//import com.hctel.oos.netconf.base.entity.NodeInfo;
//import org.opendaylight.mdsal.binding.api.*;
//import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.netconf.notification._1._0.rev080714.CreateSubscriptionInputBuilder;
//import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.netconf.notification._1._0.rev080714.CreateSubscriptionOutput;
//import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.netconf.notification._1._0.rev080714.NotificationsService;
//import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.netconf.notification._1._0.rev080714.StreamNameType;
//import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.Host;
//import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IpAddress;
//import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.netconf.notifications.rev120206.IetfNetconfNotificationsListener;
//import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.netconf.notifications.rev120206.NetconfSessionStart;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.CreateDeviceInputBuilder;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.NetconfNode;
//import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.network.topology.topology.topology.types.TopologyNetconf;
//import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology;
//import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NodeId;
//import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;
//import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology;
//import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyKey;
//import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Node;
//import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.NodeKey;
//import org.opendaylight.yangtools.concepts.ListenerRegistration;
//import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
//import org.opendaylight.yangtools.yang.binding.KeyedInstanceIdentifier;
//import org.opendaylight.yangtools.yang.common.QName;
//import org.opendaylight.yangtools.yang.common.RpcResult;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//import java.util.concurrent.ExecutionException;
//import java.util.stream.Collectors;
//
//@Component
//public class NcmountImpl implements DataTreeChangeListener<Topology> {
//    final private static Logger LOG = LoggerFactory.getLogger(NcmountImpl.class);
//    @Resource
//    private CreateDeviceInputBuilder createDeviceInputBuilder;
//    @Resource
//    private MountPointService mountPointService;
//
//    protected ListenableFuture<NetconfDeviceCapabilities> setupConnection(final NodeId nodeId, final Node configNode) {
//
//        // 创建连接，主动连接底层device
//        final ListenableFuture<NetconfDeviceCapabilities> future =
//                deviceCommunicator.initializeRemoteConnection(clientDispatcher, clientConfig);
//
//    }
//
//    public void notification(){
//        final Optional<MountPoint> mountPoint = null;
////        try {
////            // Get mount point for specified device
////            mountPoint = NcmountProvider.getMountPointService().getMountPoint(mountIds.get(nodeId.getValue()));
////        } catch (ExecutionException e) {
////            throw new IllegalArgumentException(e);
////        }
//
//        final Optional<RpcConsumerRegistry> service = mountPoint.get().getService(RpcConsumerRegistry.class);
//        final NotificationsService rpcService = service.get().getRpcService(NotificationsService.class);
//        final String streamName = "NETCONF";
//        final CreateSubscriptionInputBuilder createSubscriptionInputBuilder = new CreateSubscriptionInputBuilder();
//        createSubscriptionInputBuilder.setStream(new StreamNameType(streamName));
//        final Future<RpcResult<Void>> subscription = rpcService.createSubscription(createSubscriptionInputBuilder.build());
//        try {
//            System.out.println("1"+subscription.get().getResult());
//            System.out.println("2"+subscription.get().getErrors());
//            System.out.println("是否成功："+subscription.get().isSuccessful());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public ListenableFuture<NetconfDeviceCapabilities> initializeRemoteConnection(
//            final NetconfClientDispatcher dispatcher, final NetconfClientConfiguration config) {
//        // 创建client
//        if (config instanceof NetconfReconnectingClientConfiguration) {
//            initFuture = dispatcher.createReconnectingClient((NetconfReconnectingClientConfiguration) config);
//        } else {
//            initFuture = dispatcher.createClient(config);
//        }
//
//
//        initFuture.addListener(future -> {
//            if (!future.isSuccess() && !future.isCancelled()) {
//                LOG.debug("{}: Connection failed", id, future.cause());
//                NetconfDeviceCommunicator.this.remoteDevice.onRemoteSessionFailed(future.cause());
//                if (firstConnectionFuture.isDone()) {
//                    firstConnectionFuture.setException(future.cause());
//                }
//            }
//        });
//        return firstConnectionFuture;
//    }
//    // 假设第一次连接，会调用NetconfClientDispatcherImpl的createClient方法。
//
//    // Netty创建Client及初始化
//    // 在NetconfClientDispatcherImpl中会根据不同的协议，使用TCP/SSH建立netconf连接：
//
//    @Override
//    public Future<NetconfClientSession> createClient(final NetconfClientConfiguration clientConfiguration) {
//        switch (clientConfiguration.getProtocol()) {
//            case TCP:
//                return createTcpClient(clientConfiguration);
//            case SSH:
//                return createSshClient(clientConfiguration);
//            default:
//                throw new IllegalArgumentException("Unknown client protocol " + clientConfiguration.getProtocol());
//        }
//    }
//
//
//    private Future<NetconfClientSession> createSshClient(final NetconfClientConfiguration currentConfiguration) {
//        LOG.debug("Creating SSH client with configuration: {}", currentConfiguration);
//        return super.createClient(currentConfiguration.getAddress(), currentConfiguration.getReconnectStrategy(),
//                (ch, sessionPromise) -> new SshClientChannelInitializer(currentConfiguration.getAuthHandler(),
//                        getNegotiatorFactory(currentConfiguration), currentConfiguration.getSessionListener())
//                        .initialize(ch, sessionPromise));
//    }
//
//    private void start() {
//        final NetconfHelloMessage helloMessage = this.sessionPreferences.getHelloMessage();
//        LOG.debug("Session negotiation started with hello message {} on channel {}", helloMessage, channel);
//
//        channel.pipeline().addLast(NAME_OF_EXCEPTION_HANDLER, new ExceptionHandlingInboundChannelHandler());
//
//        // 发送NetconfHelloMessage消息
//        sendMessage(helloMessage);
//
//        // 发送helloMessage后，pipeline中NETCONF_MESSAGE_ENCODER将NetconfHelloMessageToXMLEncoder替换为NetconfMessageToXMLEncoder
//        replaceHelloMessageOutboundHandler();
//        changeState(State.OPEN_WAIT);
//
//        // 等待一段时间，检查session状态是否为ESTABLISHED. 状态的修改由另外的异步(hello message交互)实现
//        timeout = this.timer.newTimeout(new TimerTask() {
//            @Override
//            @SuppressWarnings("checkstyle:hiddenField")
//            public void run(final Timeout timeout) {
//                synchronized (this) {
//                    if (state != State.ESTABLISHED) {
//                        // 非ESTABLISHED，做相关逻辑设置状态为FAILED
//                        ...
//                    } else if (channel.isOpen()) {
//                        channel.pipeline().remove(NAME_OF_EXCEPTION_HANDLER);
//                    }
//                }
//            }
//        }, connectionTimeoutMillis, TimeUnit.MILLISECONDS);
//    }
//    public static final InstanceIdentifier<Topology> NETCONF_TOPO_IID =
//            InstanceIdentifier
//                    .create(NetworkTopology.class)
//                    .child(Topology.class,
//                            new TopologyKey(new TopologyId(TopologyNetconf.QNAME.getLocalName())));
//
//    // 从NETCONF_TOPO_IID下，即Topology为TopologyNetconf下的Node当中，根据输入Node名字取得其路径
//    LoadingCache<String, KeyedInstanceIdentifier<Node, NodeKey>> mountIds = CacheBuilder.newBuilder()
//            .maximumSize(20)
//            .build(
//                    new CacheLoader<String, KeyedInstanceIdentifier<Node, NodeKey>>() {
//                        public KeyedInstanceIdentifier<Node, NodeKey> load(final String key) {
//                            return NETCONF_TOPO_IID.child(Node.class, new NodeKey(new NodeId(key)));
//                        }
//                    });
//
//    @Override
//    public void onInitialData() {
//
//    }
//
//    // 监听Topology下Node变化
//    @Override
//    public void onDataTreeChanged(Collection<DataTreeModification<Topology>> changes) {
//        LOG.info("-----Ncmount TopoDTChangeListener:  onDataTreeChanged");
//
//        // 遍历变化的Topology节点
//        for (DataTreeModification<Topology> change : changes) {
//            // Topology层变化节点
//            final DataObjectModification<Topology> rootTopologyNode = change.getRootNode();
//            // 获得Topology层下子变化节点，即Node变化节点
//            Collection<DataObjectModification<?>> modifiedChildren = (Collection<DataObjectModification<?>>) rootTopologyNode.getModifiedChildren();
//            // 遍历Node变化节点
//            for (final DataObjectModification<?> child : modifiedChildren) {
//                // 判断节点类类型
//                if (child.getDataType() != Node.class)
//                    continue;
//
//                // Node下第一层为NetconfNode变化节点
//                Collection<DataObjectModification<?>> childModifiedChildren = (Collection<DataObjectModification<?>>) child.getModifiedChildren();
//                for (final DataObjectModification<?> netconfChild : childModifiedChildren) {
//                    // 判断节点类类型
//                    if (netconfChild.getDataType() != NetconfNode.class)
//                        continue;
//
//                    // 获得变化后的NetconfNode
//                    NetconfNode nnode = (NetconfNode) netconfChild.getDataAfter();
//                    if (nnode != null) {
//                        // 判断NetconfNode变化类型
//                        switch (nnode.getConnectionStatus()) {
//                            case Connected: {
//                                // 注意：此处要使用Node层中的NodeId
//                                Node childNode = (Node) child.getDataAfter();
//                                NodeId nodeId = childNode.getNodeId();
//                                LOG.info("-----Ncmount TopoDTChangeListener:  NETCONF Node: Connected: {}", nodeId.getValue());
//
//                                List<String> capabilities =
//                                        nnode.getAvailableCapabilities()
//                                                .getAvailableCapability()
//                                                .stream()
//                                                .map(cp -> cp.getCapability())
//                                                .collect(Collectors.toList());
//
//                                int i = 1;
//                                for (String capability : capabilities) {
//                                    LOG.info("{}: {}", i++, capability);
//                                }
//                                //判断是否新增了设备挂载点（不包含源挂载点（controller-config））
//                                if (!nodeId.getValue().equals("controller-config")) {
//                                    LOG.info("Ncmount newNodeId:{} != controller-config", nodeId.getValue());
//
//                                    final java.util.Optional<MountPoint> mountPoint;
//                                    try {
//                                        // Get mount point for specified device
//                                        mountPoint = mountPointService.getMountPoint(mountIds.get(nodeId.getValue()));
//                                    } catch (ExecutionException e) {
//                                        throw new IllegalArgumentException(e);
//                                    }
//
//
//                                    java.util.Optional<NotificationService> notificationService = mountPoint.get().getService(NotificationService.class);
//                                    java.util.Optional<NotificationService> service = mountPoint.get().getService(NotificationService.class);
//                                    if (capabilities.contains(QName.create(NetconfSessionStart.QNAME, "ietf-netconf-notifications").toString())) {
//                                        if (true) {
//                                            System.out.println("包含session");
//                                            final IetfNetconfNotificationsListener testNotification = new TestNotification();
//                                            final ListenerRegistration<IetfNetconfNotificationsListener> accessTopologyListenerListenerRegistration =
//                                                    service.get().registerNotificationListener(testNotification);
//                                            notificationService.get().registerNotificationListener(new TestNotification());
//                                            subscription(nodeId, "NETCONF");
//                                        }
//                                    }
//                                    //如果新增了其他挂载点，将其信息保存到数据库中
////                                    AccTransferContainer atc = new AccTransferContainer(nodeId.getValue());
////                                    atc.persistenceMe();
//                                }
//
//                                break;
//                            }
//                            case Connecting: {
//                                LOG.info("-----Ncmount TopoDTChangeListener:  NETCONF Node: Connecting");
//                                break;
//                            }
//                            case UnableToConnect: {
//                                LOG.info("-----Ncmount TopoDTChangeListener:  NETCONF Node: UnableToConnect");
//                                break;
//                            }
//                            default:
//                                LOG.info("-----Ncmount TopoDTChangeListener:  NETCONF Node: default");
//                                break;
//                        }
//
//                    }
//                }
//            }
//
//        }
//
//    }
//
//
//
//
//    //订阅
//    private void subscription(NodeId nodeId, String streamName) {
//        Optional<MountPoint> mountPoint;
//        try {
//            // Get mount point for specified device
//            mountPoint = mountPointService.getMountPoint(mountIds.get(nodeId.getValue()));
//        } catch (ExecutionException e) {
//            throw new IllegalArgumentException(e);
//        }
//        //建立订阅
//        java.util.Optional<RpcConsumerRegistry> service = mountPoint.get().getService(RpcConsumerRegistry.class);
//        NotificationsService rpcService = service.get().getRpcService(NotificationsService.class);
////        String streamName = "NETCONF";
//        CreateSubscriptionInputBuilder createSubscriptionInputBuilder = new CreateSubscriptionInputBuilder();
//        createSubscriptionInputBuilder.setStream(new StreamNameType(streamName));
//        com.google.common.util.concurrent.ListenableFuture<RpcResult<CreateSubscriptionOutput>> subscription = rpcService.createSubscription(createSubscriptionInputBuilder.build());
//        try {
//            System.out.println("错误信息：" + subscription.get().getErrors());
//            System.out.println("结果信息：" + subscription.get().getResult());
//            System.out.println("订阅判定： " + subscription.get().isSuccessful());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//    }
//}
