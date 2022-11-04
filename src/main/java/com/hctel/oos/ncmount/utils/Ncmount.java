package com.hctel.oos.ncmount.utils;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.opendaylight.mdsal.binding.api.DataBroker;
import org.opendaylight.mdsal.binding.api.MountPoint;
import org.opendaylight.mdsal.binding.api.MountPointService;
import org.opendaylight.mdsal.binding.api.ReadTransaction;
import org.opendaylight.mdsal.dom.api.DOMDataBroker;
import org.opendaylight.yang.gen.v1.urn.opendaylight.netconf.node.topology.rev150114.network.topology.topology.topology.types.TopologyNetconf;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NetworkTopologyBuilder;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.NodeId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.TopologyId;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.Topology;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.TopologyKey;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.Node;
import org.opendaylight.yang.gen.v1.urn.tbd.params.xml.ns.yang.network.topology.rev131021.network.topology.topology.NodeKey;
import org.opendaylight.yangtools.yang.binding.InstanceIdentifier;
import org.opendaylight.yangtools.yang.binding.KeyedInstanceIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Ncmount {
    final private static Logger LOG = LoggerFactory.getLogger(Ncmount.class);
    /**
     * 数据库服务 Database Services
     */
    private static DataBroker dataBroker;


    /**
     * 挂载点服务
     */
    private static MountPointService mountPointService;


    private DOMDataBroker globalDomDataBroker;

    public static final InstanceIdentifier<Topology> NETCONF_TOPO_IID =
            InstanceIdentifier
                    .create(NetworkTopology.class)
                    .child(Topology.class,
                            new TopologyKey(new TopologyId(TopologyNetconf.QNAME.getLocalName())));

    // 从NETCONF_TOPO_IID下，即Topology为TopologyNetconf下的Node当中，根据输入Node名字取得其路径
    LoadingCache<String, KeyedInstanceIdentifier<Node, NodeKey>> mountIds = CacheBuilder.newBuilder()
            .maximumSize(20)
            .build(
                    new CacheLoader<String, KeyedInstanceIdentifier<Node, NodeKey>>() {
                        public KeyedInstanceIdentifier<Node, NodeKey> load(final String key) {
                            return NETCONF_TOPO_IID.child(Node.class, new NodeKey(new NodeId(key)));
                        }
                    });
//    static final QName NC_OPER_NODES = QName.create(ListNodesOutput.QNAME, "nc-oper-nodes").intern();


    public Ncmount() {
    }

    public Ncmount(DataBroker dataBroker, MountPointService mountPointService) {
        Ncmount.dataBroker = dataBroker;
        Ncmount.mountPointService = mountPointService;
    }


    public static DataBroker getDataBroker() {
        return dataBroker;
    }

    public static void setDataBroker(DataBroker dataBroker) {
        Ncmount.dataBroker = dataBroker;
    }


    public static MountPointService getMountPointService() {
        return mountPointService;
    }

    public static void setMountPointService(MountPointService mountPointService) {
        Ncmount.mountPointService = mountPointService;
    }

    /**
     * This method reads the operational data-store and return list of nodes
     * from Netconf topology. It also logs the capability of 'connected'
     * netconf nodes.
     *
     * @return list of nodes in Netconf topology from operational data store.
     */
    /*private LeafSetNode<Object> getNCOperationalNodes() {

        // read and create the leaf node to represent "leaf-list nc-oper-nodes"
        ListNodeBuilder<Object, LeafSetEntryNode<Object>> ncOperLeafListBuilder = Builders.leafSetBuilder()
                .withNodeIdentifier(new YangInstanceIdentifier.NodeIdentifier(NC_OPER_NODES));
        NormalizedNode<?, ?> topology = null;
        DOMDataTreeReadTransaction rtx = this.globalDomDataBroker.newReadOnlyTransaction();
        try {
            Optional<NormalizedNode<?, ?>> optTopology = rtx.read(LogicalDatastoreType.OPERATIONAL, NETCONF_TOPO_IID)
                    .checkedGet();

            // if the topology is present the move further,
            // otherwise return with the empty leaf-list of nc node.
            if (optTopology.isPresent()) {
                topology = optTopology.get();
            } else {
                return ncOperLeafListBuilder.build();
            }

        } catch (ReadFailedException e) {
            LOG.warn("Failed to read operational datastore: {}", e);
            return ncOperLeafListBuilder.build();
        } finally {
            // close the transaction resource.
            rtx.close();
        }

        DataContainerChild<? extends InstanceIdentifier.PathArgument, ?> nodeList = ((MapEntryNode) topology).getChild(new YangInstanceIdentifier.NodeIdentifier(Node.QNAME))
                .get();
        for (MapEntryNode operNode : ((MapNode) nodeList).getValue()) {

            // pick the leaf node with local name "node-id"
            String nodeId = ((String) operNode
                    .getChild(TOPO_NODE_ID_PATHARG).get().getValue());

            final Optional<DataContainerChild<? extends YangInstanceIdentifier.PathArgument, ?>> netconfNode = operNode.getChild(
                    // TODO the augmentation identifier could be extracted into a static constant
                    new YangInstanceIdentifier.AugmentationIdentifier(Sets.newHashSet(
                            toQNames(NetconfNode.QNAME, "tcp-only", "available-capabilities", "port",
                                    "reconnect-on-changed-schema", "connected-message",
                                    "default-request-timeout-millis", "host", "max-connection-attempts",
                                    "connection-status", "credentials", "unavailable-capabilities",
                                    "between-attempts-timeout-millis", "keepalive-delay",
                                    "clustered-connection-status", "yang-module-capabilities", "pass-through",
                                    "connection-timeout-millis", "sleep-factor"))));

            if (!netconfNode.isPresent()) {
                // Skipping non netconf nodes, even though this should not happen,
                // since we are querying netconf topology
                continue;
            }

            final AugmentationNode netconfNodeParameters = (AugmentationNode) netconfNode.get();
            final LeafNode<?> connectionStatus = ((LeafNode<?>) netconfNodeParameters
                    .getChild(new NodeIdentifier(toQName(NetconfNode.QNAME, "connection-status"))).get());

            if ("connected".equals(connectionStatus.getValue())) {
                final ContainerNode availableCapabilities = ((ContainerNode) netconfNodeParameters
                        .getChild(new NodeIdentifier(toQName(NetconfNode.QNAME, "available-capabilities"))).get());
                final LeafSetNode<?> availableCapability = (LeafSetNode<?>) availableCapabilities
                        .getChild(new NodeIdentifier(toQName(NetconfNode.QNAME, "available-capability"))).get();

                LOG.warn("Capabilities of {} : {}", nodeId,
                        Collections2.transform(availableCapability.getValue(), new Function<LeafSetEntryNode<?>, Object>() {
                            @Nullable
                            @Override
                            public Object apply(final LeafSetEntryNode<?> input) {
                                return input.getValue();

                            }
                        }));
            }

            // include the node in the nc_oper_leaf_list
            ncOperLeafListBuilder.withChildValue(nodeId);
        }

        return ncOperLeafListBuilder.build();
    }*/


    public void getDevices(String nodeName) {
        LOG.info("-----Ncmount RpcImpl: showNode called, input {}", nodeName);


        NetworkTopologyBuilder networkTopologyBuilder = new NetworkTopologyBuilder();
        List<Topology> topology = networkTopologyBuilder.getTopology();
        System.out.println(topology);

        System.out.println("现在的拓扑详情："+topology);
        // Get the mount point for the specified node
        // Equivalent to '.../restconf/<config | operational>/opendaylight-inventory:nodes/node/<node-name>/yang-ext:mount/'
        // Note that we can read both config and operational data from the same
        // mount point
        java.util.Optional<MountPoint> xrNodeOptional = getMountPointService().getMountPoint(NETCONF_TOPO_IID.child(Node.class, new NodeKey(new NodeId(nodeName))));

        Preconditions.checkArgument(xrNodeOptional.isPresent(),
                "-----Ncmount RpcImpl: Unable to locate mountpoint: %s, not mounted yet or not configured",
                nodeName);
        final MountPoint xrNode = xrNodeOptional.get();

        // Get the DataBroker for the mounted node
        final DataBroker xrNodeBroker = xrNode.getService(DataBroker.class).get();
        // Start a new read only transaction that we will use to read data
        // from the device
        final ReadTransaction xrNodeReadTx = xrNodeBroker.newReadOnlyTransaction();



/*        // EXAMPLE: Browsing through the node's interface configuration data.

        // First, we get an Instance Identifier for the configuration data. Note
        // that the Instance Identifier is relative to the mountpoint (we got
        // the path to the mountpoint above). The Instance Identifier path is
        // equivalent to:
        // '.../yang-ext:mount/Cisco-IOS-XR-ifmgr-cfg:interface-configurations'
        InstanceIdentifier<InterfaceConfigurations> iid =
                InstanceIdentifier.create(InterfaceConfigurations.class);

        Optional<InterfaceConfigurations> ifConfig;
        try {
            // Read from a transaction is asynchronous, but a simple
            // get/checkedGet makes the call synchronous
            ifConfig = xrNodeReadTx.read(LogicalDatastoreType.CONFIGURATION, iid).checkedGet();
        } catch (ReadFailedException e) {
            throw new IllegalStateException("-----Ncmount RpcImpl: Unexpected error reading data from " + input.getNodeName(), e);
        }

        List<Ifc> ifcList = new ArrayList<Ifc>();
        if (ifConfig.isPresent()) {
            List<InterfaceConfiguration> ifConfigs = ifConfig
                    .get()
                    .getInterfaceConfiguration();
            for (InterfaceConfiguration config : ifConfigs) {
                LOG.info("-----Ncmount RpcImpl: Config for '{}': config {}",
                        config.getInterfaceName().getValue(), config);
                String ifcActive = config.getActive().getValue();
                String ifcName = config.getInterfaceName().getValue();
                ifcList.add(new IfcBuilder()
                        .setActive(ifcActive)
                        .setBandwidth(config.getBandwidth())
                        .setDescription(config.getDescription())
                        .setInterfaceName(ifcName)
                        .setLinkStatus(config.isLinkStatus() == Boolean.TRUE ? "Up" : "Down")
                        .setKey(new IfcKey(ifcActive, ifcName))
                        .build());
            }
        } else {
            LOG.info("-----Ncmount RpcImpl:  No data present on path '{}' for mountpoint: {}",
                    iid,
                    nodeName;
        }

        // EXAMPLE: Browsing through the node's interface operational data

        // First, we get an Instance Identifier for the portion of the
        // operational data that we want to browse through. Note that we are
        // getting an identifier to a more specific path - the data-nodes
        // container within the interface-properties container. The Instance
        // Identifier path is equivalent to:
        // '.../yang-ext:mount/Cisco-IOS-XR-ifmgr-oper:interface-properties/data-nodes'
        InstanceIdentifier<DataNodes> idn = InstanceIdentifier.create(InterfaceProperties.class)
                .child(DataNodes.class);
        Optional<DataNodes> ldn;
        try {
            ldn = xrNodeReadTx.read(LogicalDatastoreType.OPERATIONAL, idn).checkedGet();
        } catch (ReadFailedException e) {
            throw new IllegalStateException("Unexpected error reading data from " + input.getNodeName(), e);
        }

        if (ldn.isPresent()) {
            List<DataNode> dataNodes = ldn.get().getDataNode();
            for (DataNode node : dataNodes) {
                LOG.info("-----Ncmount RpcImpl:  DataNode '{}'", node.getDataNodeName().getValue());

                Locationviews lw = node.getLocationviews();
                List<Locationview> locationViews = lw.getLocationview();
                for (Locationview view : locationViews) {
                    LOG.info("-----Ncmount RpcImpl:  LocationView '{}': {}",
                            view.getKey().getLocationviewName().getValue(),
                            view);
                }

                Interfaces ifc = node.getSystemView().getInterfaces();
                List<Interface> ifList = ifc.getInterface();
                for (Interface intf : ifList) {
                    LOG.info("-----Ncmount RpcImpl:  Interface '{}': {}",
                            intf.getInterface().getValue(), intf);
                }

            }
        } else {
            LOG.info("-----Ncmount RpcImpl:  No data present on path '{}' for mountpoint: {}",
                    idn, input.getNodeName());
        }

        // Finally, we build the RPC response with the retrieved data and return
        ShowNodeOutput output = new ShowNodeOutputBuilder()
                .setIfCfgData(new IfCfgDataBuilder().setIfc(ifcList).build())
                .build();
        return RpcResultBuilder.success(output).buildFuture();*/
    }


    public String setDevices(){

        return null;

    }
}

