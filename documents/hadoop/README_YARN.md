Hadoop -> HDFS (Storage Subsystem), YARN (Process Scheduling Subsystem)

    Data Locality: processing data locally whenever possible. Core to Hadoop, intentionally attempts to minimize the amount of data transferred across the network.
    Shared Nothing: refers to tasks  that can be executed independently on a distributed processing platform such as Hadoop that do not require synchronization or sharing of state wth one another
    Core Components of Hadoop: HDFS, YARN
    
    HDFS
        '''
        Hadoop applies Master-Slave Cluster Architecture (the master and slave process are predefined, static role for the lifetime)
        
        File, Blocks, and Metadata
        
        NameNode: is a madatory process necessary for HDFS to operate. 
            * HDFS Master Node process which manage the filesystem
            * http://127.0.0.1:50070/dfshealth.html#tab-overview  (local Hadoop UI)
            * Tip: Data Does Not Go Through the NameNode
                 It is a common misconception that data goes into HDFS via the
                 NameNode. This is not the case as it would create a bottleneck.
                 Instead, the client interacts with the NameNode to get directives on
                 which cluster node(s) to communicate with to get or put blocks that
                 pertain to the file the client is trying to read or write.
        
        SecondaryNameNode/Standby NameNode: are optional processes that expedite filesystem recovery or provide a failover process in the event of a NameNode failure.
        
        DataNode: DetaNode process is a HDFS slave node daemon that runs on one or more nodes of the HDFS clusters.
            * The DataNodes are the nodes of the cluster on which HDFS blocks are stored and managed
            * Caution: DataNodes Are Not Aware of HDFS Files and Directories
                DataNodes store and manage physical HDFS blocks only, without
                having any knowledge of how these blocks are related to files and
                directories in the HDFS filesystem. This relationship is held only in
                the NameNode’s metadata.
        '''
        
    YARN
        '''
        YARN governs the processing of data in Hadoop, which typically is data sourced from and written to HDFS. 
        ResourceManager is the master node
            * http://127.0.0.1:8088/cluster
            
        NodeManager is the slave node (can be more than one)
            * ApplicataionMaster is the first container allocated by the ResourceManager to run on a NodeManager for an application
        '''
    
    LocalJobRunner is typically used for map reduce development and unit testing.
    
    HDFS is a virtual filesystem, meaning that it appears to a client as if it is one system, but the underlying data is located in multiple different locations.
    Blocks are actually distributed.
    
    WORM: Write Once, Read Many. Immutability refers to the inabilty to update data after it is committed to the filesystem
    
    HDFS -> Files -> Block (default to 128M)
    
    NameNode Meetadata: it a is perhaps the single most critical component in the HDFS architecture. Without it the filesystem is not accessible, usable, or
                           recoverable. The NameNode’s metadata contains the critical link between blocks stored on each of the DataNodes’ respective filesystems 
                           and their context within files and directories in the Hadoop virtual filesystem.
                           
                           NameNode simply uses its metadata to direct clients where to read and write data —specifically which DataNodes to interact with. 
                           The clients then perform data operations directly with the specified DataNodes in the cluster.
                           
                           Objects in HDFS have associated ACLs, which define the owner of the object and permissions that the owner, groups, and others have to the object.
                           These ACLs are part of the metadata structure as previously shown.
    
    Apache Flume: is a Hadoop ecosystem project originally developed by Cloudera designed to capture, transform, and ingest data into HDFS using one or more agents. 
    In many cases you will need to establish interfaces to capture data produced from source systems in real time, such as web logs, or schedule batch snapshots from a relational database, 
    such as a transaction processing system.
    
    Sqoop: (which is a portmanteau for “sql-to-hadoop”) is a top-level ASF project designed to source data from a relational database and ingest this data into files
    (typically delimited files) in HDFS. Sqoop can also be used to send data from Hadoop to a relational database, useful for sending results processed in Hadoop to an operational transaction processing
    system. Sqoop integrates with Hive, which is a SQLabstraction to MapReduce and other processing technologies on the Hadoop platform. Sqoop can automatically create Hive tables from imported 
    data from a RDBMS (Relational Database Management System) table.
    
    Sqoop includes tools for the following operations:
        * Listing databases and tables on a database system
        * Importing a single table from a database system, including
        * Specifying which columns to import
        * Specifying which rows to import using a WHERE clause
        * Importing data from one or more tables using a SELECT statement
        * Incremental imports from a table on a database system (importing only what has changed since a known previous state)
        * Exporting of data from HDFS to a table on a remote database system
    
    The server-based implementation of Sqoop is called Sqoop2.
    More information on Sqoop including Sqoop2 (Sqoop-as-a-service) is available from any of the following sources:
        * Apache Sqoop (http://sqoop.apache.org/)
        * Cloudera (http://www.cloudera.com/)
        * Hortonworks (http://hortonworks.com/)
        * MapR (https://www.mapr.com/)
    
    