1. HDFS Blocks - 128 MB by default

    Check Example: hdfs fsck / -files -blocks

2. HDFS Federation

    The namenode keeps a reference to every file and block in the filesystem in memory
    
    One namenode might manage all the files rooted under /user, say, and a second name‐ node might handle files under /share.
    
    Namenodes do not communicate with one another, and furthermore the failure of one namenode does not affect the availability of the namespaces managed by other namen‐ odes.
    
3. HDFS High Availability

    • The namenodes must use highly available shared storage to share the edit log. When a standby namenode comes up, 
        it reads up to the end of the shared edit log to synchronize its state with the active namenode, and then continues to read new entries as they are written by the active namenode.
    
    • Datanodes must send block reports to both namenodes because the block mappings are stored in a namenode’s memory, and not on disk.
    
    • Clients must be configured to handle namenode failover, using a mechanism that is transparent to users.
    
    • The secondary namenode’s role is subsumed by the standby, which takes periodic checkpoints of the active namenode’s namespace.










